package com.dooboolab.RNIap;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.Nullable;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.android.billingclient.api.PurchaseHistoryResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.android.billingclient.util.BillingHelper;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ObjectAlreadyConsumedException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.onesignal.OneSignalDbContract;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class RNIapModule extends ReactContextBaseJavaModule implements PurchasesUpdatedListener {
    private static final String PROMISE_BUY_ITEM = "PROMISE_BUY_ITEM";
    final String TAG = "RNIapModule";
    /* access modifiers changed from: private */
    public BillingClient billingClient;
    private LifecycleEventListener lifecycleEventListener = new LifecycleEventListener() {
        public void onHostPause() {
        }

        public void onHostResume() {
        }

        public void onHostDestroy() {
            if (RNIapModule.this.billingClient != null) {
                RNIapModule.this.billingClient.endConnection();
                BillingClient unused = RNIapModule.this.billingClient = null;
            }
        }
    };
    private HashMap<String, ArrayList<Promise>> promises = new HashMap<>();
    /* access modifiers changed from: private */
    public ReactContext reactContext;
    /* access modifiers changed from: private */
    public List<SkuDetails> skus;

    public String getName() {
        return "RNIapModule";
    }

    public RNIapModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
        this.skus = new ArrayList();
        reactApplicationContext.addLifecycleEventListener(this.lifecycleEventListener);
    }

    private void ensureConnection(final Promise promise, final Runnable runnable) {
        if (this.billingClient == null || !this.billingClient.isReady()) {
            C09232 r0 = new BillingClientStateListener() {
                private boolean bSetupCallbackConsumed = false;

                public void onBillingSetupFinished(BillingResult billingResult) {
                    if (!this.bSetupCallbackConsumed) {
                        this.bSetupCallbackConsumed = true;
                        if (billingResult.getResponseCode() != 0) {
                            WritableMap createMap = Arguments.createMap();
                            createMap.putInt("responseCode", billingResult.getResponseCode());
                            createMap.putString("debugMessage", billingResult.getDebugMessage());
                            String[] billingResponseData = DoobooUtils.getInstance().getBillingResponseData(billingResult.getResponseCode());
                            createMap.putString("code", billingResponseData[0]);
                            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, billingResponseData[1]);
                            RNIapModule.this.sendEvent(RNIapModule.this.reactContext, "purchase-error", createMap);
                            DoobooUtils.getInstance().rejectPromiseWithBillingError(promise, billingResult.getResponseCode());
                        } else if (RNIapModule.this.billingClient != null && RNIapModule.this.billingClient.isReady()) {
                            runnable.run();
                        }
                    }
                }

                public void onBillingServiceDisconnected() {
                    Log.d("RNIapModule", "billing client disconnected");
                }
            };
            try {
                this.billingClient = BillingClient.newBuilder(this.reactContext).enablePendingPurchases().setListener(this).build();
                this.billingClient.startConnection(r0);
            } catch (Exception e) {
                promise.reject(DoobooUtils.E_NOT_PREPARED, e.getMessage(), (Throwable) e);
            }
        } else {
            runnable.run();
        }
    }

    @ReactMethod
    public void initConnection(final Promise promise) {
        this.billingClient = BillingClient.newBuilder(this.reactContext).enablePendingPurchases().setListener(this).build();
        this.billingClient.startConnection(new BillingClientStateListener() {
            public void onBillingSetupFinished(BillingResult billingResult) {
                int responseCode = billingResult.getResponseCode();
                if (responseCode == 0) {
                    try {
                        promise.resolve(true);
                    } catch (ObjectAlreadyConsumedException e) {
                        Log.e("RNIapModule", e.getMessage());
                    }
                } else {
                    DoobooUtils.getInstance().rejectPromiseWithBillingError(promise, responseCode);
                }
            }

            public void onBillingServiceDisconnected() {
                try {
                    promise.reject("initConnection", "Billing service disconnected");
                } catch (ObjectAlreadyConsumedException e) {
                    Log.e("RNIapModule", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void endConnection(Promise promise) {
        if (this.billingClient != null) {
            try {
                this.billingClient.endConnection();
            } catch (Exception e) {
                promise.reject("endConnection", e.getMessage());
                return;
            }
        }
        try {
            promise.resolve(true);
        } catch (ObjectAlreadyConsumedException e2) {
            Log.e("RNIapModule", e2.getMessage());
        }
    }

    @ReactMethod
    public void refreshItems(final Promise promise) {
        ensureConnection(promise, new Runnable() {
            public void run() {
                final WritableNativeArray writableNativeArray = new WritableNativeArray();
                Purchase.PurchasesResult queryPurchases = RNIapModule.this.billingClient.queryPurchases(BillingClient.SkuType.INAPP);
                if (queryPurchases == null) {
                    promise.reject("refreshItem", "No results for query");
                    return;
                }
                List<Purchase> purchasesList = queryPurchases.getPurchasesList();
                if (purchasesList == null || purchasesList.size() == 0) {
                    promise.reject("refreshItem", "No purchases found");
                    return;
                }
                for (Purchase next : purchasesList) {
                    RNIapModule.this.billingClient.consumeAsync(ConsumeParams.newBuilder().setPurchaseToken(next.getPurchaseToken()).setDeveloperPayload(next.getDeveloperPayload()).build(), new ConsumeResponseListener() {
                        public void onConsumeResponse(BillingResult billingResult, String str) {
                            if (billingResult.getResponseCode() != 0) {
                                DoobooUtils.getInstance().rejectPromiseWithBillingError(promise, billingResult.getResponseCode());
                                return;
                            }
                            writableNativeArray.pushString(str);
                            try {
                                promise.resolve(true);
                            } catch (ObjectAlreadyConsumedException e) {
                                promise.reject(e.getMessage());
                            }
                        }
                    });
                }
            }
        });
    }

    @ReactMethod
    public void getItemsByType(final String str, final ReadableArray readableArray, final Promise promise) {
        ensureConnection(promise, new Runnable() {
            public void run() {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < readableArray.size(); i++) {
                    arrayList.add(readableArray.getString(i));
                }
                SkuDetailsParams.Builder newBuilder = SkuDetailsParams.newBuilder();
                newBuilder.setSkusList(arrayList).setType(str);
                RNIapModule.this.billingClient.querySkuDetailsAsync(newBuilder.build(), new SkuDetailsResponseListener() {
                    public void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> list) {
                        Log.d("RNIapModule", "responseCode: " + billingResult.getResponseCode());
                        if (billingResult.getResponseCode() != 0) {
                            DoobooUtils.getInstance().rejectPromiseWithBillingError(promise, billingResult.getResponseCode());
                            return;
                        }
                        for (SkuDetails next : list) {
                            if (!RNIapModule.this.skus.contains(next)) {
                                RNIapModule.this.skus.add(next);
                            }
                        }
                        WritableNativeArray writableNativeArray = new WritableNativeArray();
                        for (SkuDetails next2 : list) {
                            WritableMap createMap = Arguments.createMap();
                            createMap.putString("productId", next2.getSku());
                            createMap.putDouble("price", (double) (((float) next2.getPriceAmountMicros()) / 1000000.0f));
                            createMap.putString("currency", next2.getPriceCurrencyCode());
                            createMap.putString("type", next2.getType());
                            createMap.putString("localizedPrice", next2.getPrice());
                            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_TITLE, next2.getTitle());
                            createMap.putString("description", next2.getDescription());
                            createMap.putString("introductoryPrice", next2.getIntroductoryPrice());
                            createMap.putString("subscriptionPeriodAndroid", next2.getSubscriptionPeriod());
                            createMap.putString("freeTrialPeriodAndroid", next2.getFreeTrialPeriod());
                            createMap.putString("introductoryPriceCyclesAndroid", next2.getIntroductoryPriceCycles());
                            createMap.putString("introductoryPricePeriodAndroid", next2.getIntroductoryPricePeriod());
                            createMap.putString("iconUrl", next2.getIconUrl());
                            createMap.putString("originalJson", next2.getOriginalJson());
                            createMap.putDouble("originalPrice", (double) (((float) next2.getOriginalPriceAmountMicros()) / 1000000.0f));
                            writableNativeArray.pushMap(createMap);
                        }
                        try {
                            promise.resolve(writableNativeArray);
                        } catch (ObjectAlreadyConsumedException e) {
                            Log.e("RNIapModule", e.getMessage());
                        }
                    }
                });
            }
        });
    }

    @ReactMethod
    public void getAvailableItemsByType(final String str, final Promise promise) {
        ensureConnection(promise, new Runnable() {
            public void run() {
                WritableNativeArray writableNativeArray = new WritableNativeArray();
                List<Purchase> purchasesList = RNIapModule.this.billingClient.queryPurchases(str.equals(BillingClient.SkuType.SUBS) ? BillingClient.SkuType.SUBS : BillingClient.SkuType.INAPP).getPurchasesList();
                if (purchasesList != null) {
                    for (Purchase next : purchasesList) {
                        WritableNativeMap writableNativeMap = new WritableNativeMap();
                        writableNativeMap.putString("productId", next.getSku());
                        writableNativeMap.putString("transactionId", next.getOrderId());
                        writableNativeMap.putDouble("transactionDate", (double) next.getPurchaseTime());
                        writableNativeMap.putString("transactionReceipt", next.getOriginalJson());
                        writableNativeMap.putString("orderId", next.getOrderId());
                        writableNativeMap.putString("purchaseToken", next.getPurchaseToken());
                        writableNativeMap.putString("developerPayloadAndroid", next.getDeveloperPayload());
                        writableNativeMap.putString("signatureAndroid", next.getSignature());
                        writableNativeMap.putInt("purchaseStateAndroid", next.getPurchaseState());
                        writableNativeMap.putBoolean("isAcknowledgedAndroid", next.isAcknowledged());
                        if (str.equals(BillingClient.SkuType.SUBS)) {
                            writableNativeMap.putBoolean("autoRenewingAndroid", next.isAutoRenewing());
                        }
                        writableNativeArray.pushMap(writableNativeMap);
                    }
                }
                try {
                    promise.resolve(writableNativeArray);
                } catch (ObjectAlreadyConsumedException e) {
                    Log.e("RNIapModule", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void getPurchaseHistoryByType(final String str, final Promise promise) {
        ensureConnection(promise, new Runnable() {
            public void run() {
                RNIapModule.this.billingClient.queryPurchaseHistoryAsync(str.equals(BillingClient.SkuType.SUBS) ? BillingClient.SkuType.SUBS : BillingClient.SkuType.INAPP, new PurchaseHistoryResponseListener() {
                    public void onPurchaseHistoryResponse(BillingResult billingResult, List<PurchaseHistoryRecord> list) {
                        if (billingResult.getResponseCode() != 0) {
                            DoobooUtils.getInstance().rejectPromiseWithBillingError(promise, billingResult.getResponseCode());
                            return;
                        }
                        Log.d("RNIapModule", list.toString());
                        WritableArray createArray = Arguments.createArray();
                        for (PurchaseHistoryRecord next : list) {
                            WritableMap createMap = Arguments.createMap();
                            createMap.putString("productId", next.getSku());
                            createMap.putDouble("transactionDate", (double) next.getPurchaseTime());
                            createMap.putString("transactionReceipt", next.getOriginalJson());
                            createMap.putString("purchaseToken", next.getPurchaseToken());
                            createMap.putString("dataAndroid", next.getOriginalJson());
                            createMap.putString("signatureAndroid", next.getSignature());
                            createMap.putString(BillingHelper.EXTRA_PARAMS_DEVELOPER_PAYLOAD, next.getDeveloperPayload());
                            createArray.pushMap(createMap);
                        }
                        try {
                            promise.resolve(createArray);
                        } catch (ObjectAlreadyConsumedException e) {
                            Log.e("RNIapModule", e.getMessage());
                        }
                    }
                });
            }
        });
    }

    @ReactMethod
    public void buyItemByType(String str, String str2, String str3, Integer num, Promise promise) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.reject(DoobooUtils.E_UNKNOWN, "getCurrentActivity returned null");
            return;
        }
        final Promise promise2 = promise;
        final String str4 = str;
        final String str5 = str3;
        final Integer num2 = num;
        final String str6 = str2;
        ensureConnection(promise, new Runnable() {
            public void run() {
                DoobooUtils.getInstance().addPromiseForKey(RNIapModule.PROMISE_BUY_ITEM, promise2);
                BillingFlowParams.Builder newBuilder = BillingFlowParams.newBuilder();
                if (str4.equals(BillingClient.SkuType.SUBS) && str5 != null && !str5.isEmpty()) {
                    if (num2 == null || num2.intValue() == -1) {
                        newBuilder.setOldSku(str5);
                    } else {
                        newBuilder.setOldSku(str5);
                        if (num2.intValue() == 2) {
                            newBuilder.setReplaceSkusProrationMode(2);
                        } else if (num2.intValue() == 3) {
                            newBuilder.setReplaceSkusProrationMode(3);
                        } else {
                            newBuilder.setOldSku(str5);
                        }
                    }
                }
                if (!(num2.intValue() == 0 || num2.intValue() == -1)) {
                    newBuilder.setReplaceSkusProrationMode(num2.intValue());
                }
                SkuDetails skuDetails = null;
                Iterator it = RNIapModule.this.skus.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SkuDetails skuDetails2 = (SkuDetails) it.next();
                    if (skuDetails2.getSku().equals(str6)) {
                        skuDetails = skuDetails2;
                        break;
                    }
                }
                if (skuDetails == null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("debugMessage", "The sku was not found. Please fetch products first by calling getItems");
                    createMap.putString("code", RNIapModule.PROMISE_BUY_ITEM);
                    createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "The sku was not found. Please fetch products first by calling getItems");
                    RNIapModule.this.sendEvent(RNIapModule.this.reactContext, "purchase-error", createMap);
                    promise2.reject(RNIapModule.PROMISE_BUY_ITEM, "The sku was not found. Please fetch products first by calling getItems");
                    return;
                }
                BillingResult launchBillingFlow = RNIapModule.this.billingClient.launchBillingFlow(currentActivity, newBuilder.setSkuDetails(skuDetails).build());
                String[] billingResponseData = DoobooUtils.getInstance().getBillingResponseData(launchBillingFlow.getResponseCode());
                Log.d("RNIapModule", "buyItemByType (type: " + str4 + ", sku: " + str6 + ", oldSku: " + str5 + ", prorationMode: " + num2 + ") responseCode: " + launchBillingFlow.getResponseCode() + "(" + billingResponseData[0] + ")");
            }
        });
    }

    @ReactMethod
    public void acknowledgePurchase(String str, String str2, final Promise promise) {
        this.billingClient.acknowledgePurchase(AcknowledgePurchaseParams.newBuilder().setPurchaseToken(str).setDeveloperPayload(str2).build(), new AcknowledgePurchaseResponseListener() {
            public void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                if (billingResult.getResponseCode() != 0) {
                    DoobooUtils.getInstance().rejectPromiseWithBillingError(promise, billingResult.getResponseCode());
                }
                try {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putInt("responseCode", billingResult.getResponseCode());
                    createMap.putString("debugMessage", billingResult.getDebugMessage());
                    String[] billingResponseData = DoobooUtils.getInstance().getBillingResponseData(billingResult.getResponseCode());
                    createMap.putString("code", billingResponseData[0]);
                    createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, billingResponseData[1]);
                    promise.resolve(createMap);
                } catch (ObjectAlreadyConsumedException e) {
                    Log.e("RNIapModule", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void consumeProduct(String str, String str2, final Promise promise) {
        this.billingClient.consumeAsync(ConsumeParams.newBuilder().setPurchaseToken(str).setDeveloperPayload(str2).build(), new ConsumeResponseListener() {
            public void onConsumeResponse(BillingResult billingResult, String str) {
                if (billingResult.getResponseCode() != 0) {
                    DoobooUtils.getInstance().rejectPromiseWithBillingError(promise, billingResult.getResponseCode());
                }
                try {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putInt("responseCode", billingResult.getResponseCode());
                    createMap.putString("debugMessage", billingResult.getDebugMessage());
                    String[] billingResponseData = DoobooUtils.getInstance().getBillingResponseData(billingResult.getResponseCode());
                    createMap.putString("code", billingResponseData[0]);
                    createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, billingResponseData[1]);
                    promise.resolve(createMap);
                } catch (ObjectAlreadyConsumedException e) {
                    promise.reject(e.getMessage());
                }
            }
        });
    }

    public void onPurchasesUpdated(BillingResult billingResult, @Nullable List<Purchase> list) {
        if (billingResult.getResponseCode() != 0) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("responseCode", billingResult.getResponseCode());
            createMap.putString("debugMessage", billingResult.getDebugMessage());
            String[] billingResponseData = DoobooUtils.getInstance().getBillingResponseData(billingResult.getResponseCode());
            createMap.putString("code", billingResponseData[0]);
            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, billingResponseData[1]);
            sendEvent(this.reactContext, "purchase-error", createMap);
            DoobooUtils.getInstance().rejectPromisesWithBillingError(PROMISE_BUY_ITEM, billingResult.getResponseCode());
        } else if (list != null) {
            for (Purchase next : list) {
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putString("productId", next.getSku());
                createMap2.putString("transactionId", next.getOrderId());
                createMap2.putDouble("transactionDate", (double) next.getPurchaseTime());
                createMap2.putString("transactionReceipt", next.getOriginalJson());
                createMap2.putString("purchaseToken", next.getPurchaseToken());
                createMap2.putString("dataAndroid", next.getOriginalJson());
                createMap2.putString("signatureAndroid", next.getSignature());
                createMap2.putBoolean("autoRenewingAndroid", next.isAutoRenewing());
                createMap2.putBoolean("isAcknowledgedAndroid", next.isAcknowledged());
                createMap2.putInt("purchaseStateAndroid", next.getPurchaseState());
                sendEvent(this.reactContext, "purchase-updated", createMap2);
            }
            DoobooUtils.getInstance().resolvePromisesForKey(PROMISE_BUY_ITEM, list.get(0));
        } else {
            WritableMap createMap3 = Arguments.createMap();
            createMap3.putInt("responseCode", billingResult.getResponseCode());
            createMap3.putString("debugMessage", billingResult.getDebugMessage());
            createMap3.putString("code", DoobooUtils.getInstance().getBillingResponseData(billingResult.getResponseCode())[0]);
            createMap3.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "purchases are null.");
            sendEvent(this.reactContext, "purchase-error", createMap3);
            DoobooUtils.getInstance().rejectPromisesWithBillingError(PROMISE_BUY_ITEM, billingResult.getResponseCode());
        }
    }

    private void sendUnconsumedPurchases(Promise promise) {
        ensureConnection(promise, new Runnable() {
            public void run() {
                Purchase.PurchasesResult queryPurchases = RNIapModule.this.billingClient.queryPurchases(BillingClient.SkuType.INAPP);
                ArrayList arrayList = new ArrayList();
                if (queryPurchases != null && queryPurchases.getPurchasesList() != null) {
                    for (Purchase next : queryPurchases.getPurchasesList()) {
                        if (!next.isAcknowledged()) {
                            arrayList.add(next);
                        }
                    }
                    RNIapModule.this.onPurchasesUpdated(queryPurchases.getBillingResult(), arrayList);
                }
            }
        });
    }

    @ReactMethod
    public void startListening(Promise promise) {
        sendUnconsumedPurchases(promise);
    }

    /* access modifiers changed from: private */
    public void sendEvent(ReactContext reactContext2, String str, @Nullable WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext2.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }
}
