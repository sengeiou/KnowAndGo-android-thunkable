package com.onesignal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.RNFetchBlob.RNFetchBlobConst;
import com.onesignal.ActivityLifecycleHandler;
import com.onesignal.InAppMessageView;
import com.onesignal.OneSignal;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(19)
class WebViewManager extends ActivityLifecycleHandler.ActivityAvailableListener {
    private static final int IN_APP_MESSAGE_INIT_DELAY = 200;
    private static final int MARGIN_PX_SIZE = OSViewUtils.dpToPx(24);
    /* access modifiers changed from: private */
    public static final String TAG = WebViewManager.class.getCanonicalName();
    @Nullable
    protected static WebViewManager lastInstance = null;
    /* access modifiers changed from: private */
    @NonNull
    public Activity activity;
    /* access modifiers changed from: private */
    public boolean firstShow = true;
    /* access modifiers changed from: private */
    @NonNull
    public OSInAppMessage message;
    /* access modifiers changed from: private */
    @Nullable
    public InAppMessageView messageView;
    /* access modifiers changed from: private */
    @Nullable
    public OSWebView webView;

    interface OneSignalGenericCallback {
        void onComplete();
    }

    enum Position {
        TOP_BANNER,
        BOTTOM_BANNER,
        CENTER_MODAL,
        FULL_SCREEN;

        /* access modifiers changed from: package-private */
        public boolean isBanner() {
            switch (this) {
                case TOP_BANNER:
                case BOTTOM_BANNER:
                    return true;
                default:
                    return false;
            }
        }
    }

    protected WebViewManager(@NonNull OSInAppMessage oSInAppMessage, @NonNull Activity activity2) {
        this.message = oSInAppMessage;
        this.activity = activity2;
    }

    static void showHTMLString(@NonNull final OSInAppMessage oSInAppMessage, @NonNull final String str) {
        final Activity activity2 = ActivityLifecycleHandler.curActivity;
        if (activity2 == null) {
            Looper.prepare();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    WebViewManager.showHTMLString(oSInAppMessage, str);
                }
            }, 200);
        } else if (lastInstance == null || !oSInAppMessage.isPreview) {
            initInAppMessage(activity2, oSInAppMessage, str);
        } else {
            lastInstance.dismissAndAwaitNextMessage(new OneSignalGenericCallback() {
                public void onComplete() {
                    WebViewManager.lastInstance = null;
                    WebViewManager.initInAppMessage(activity2, oSInAppMessage, str);
                }
            });
        }
    }

    static void dismissCurrentInAppMessage() {
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
        OneSignal.onesignalLog(log_level, "WebViewManager IAM dismissAndAwaitNextMessage lastInstance: " + lastInstance);
        if (lastInstance != null) {
            lastInstance.dismissAndAwaitNextMessage((OneSignalGenericCallback) null);
        }
    }

    /* access modifiers changed from: private */
    public static void initInAppMessage(@NonNull final Activity activity2, @NonNull OSInAppMessage oSInAppMessage, @NonNull String str) {
        try {
            final String encodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 2);
            WebViewManager webViewManager = new WebViewManager(oSInAppMessage, activity2);
            lastInstance = webViewManager;
            OSUtils.runOnMainUIThread(new Runnable(webViewManager) {
                final /* synthetic */ WebViewManager val$webViewManager;

                {
                    this.val$webViewManager = r1;
                }

                public void run() {
                    this.val$webViewManager.setupWebView(activity2, encodeToString);
                }
            });
        } catch (UnsupportedEncodingException e) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Catch on initInAppMessage: ", e);
            e.printStackTrace();
        }
    }

    class OSJavaScriptInterface {
        static final String EVENT_TYPE_ACTION_TAKEN = "action_taken";
        static final String EVENT_TYPE_KEY = "type";
        static final String EVENT_TYPE_RENDERING_COMPLETE = "rendering_complete";
        static final String GET_PAGE_META_DATA_JS_FUNCTION = "getPageMetaData()";
        static final String IAM_DISPLAY_LOCATION_KEY = "displayLocation";
        static final String IAM_PAGE_META_DATA_KEY = "pageMetaData";
        static final String JS_OBJ_NAME = "OSAndroid";

        OSJavaScriptInterface() {
        }

        @JavascriptInterface
        public void postMessage(String str) {
            try {
                OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
                OneSignal.onesignalLog(log_level, "OSJavaScriptInterface:postMessage: " + str);
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString(EVENT_TYPE_KEY);
                if (string.equals(EVENT_TYPE_RENDERING_COMPLETE)) {
                    handleRenderComplete(jSONObject);
                } else if (string.equals(EVENT_TYPE_ACTION_TAKEN) && !WebViewManager.this.messageView.isDragging()) {
                    handleActionTaken(jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private void handleRenderComplete(JSONObject jSONObject) {
            Position displayLocation = getDisplayLocation(jSONObject);
            WebViewManager.this.createNewInAppMessageView(displayLocation, displayLocation == Position.FULL_SCREEN ? -1 : getPageHeightData(jSONObject));
        }

        private int getPageHeightData(JSONObject jSONObject) {
            try {
                return WebViewManager.pageRectToViewHeight(WebViewManager.this.activity, jSONObject.getJSONObject(IAM_PAGE_META_DATA_KEY));
            } catch (JSONException unused) {
                return -1;
            }
        }

        @NonNull
        private Position getDisplayLocation(JSONObject jSONObject) {
            Position position = Position.FULL_SCREEN;
            try {
                if (!jSONObject.has(IAM_DISPLAY_LOCATION_KEY) || jSONObject.get(IAM_DISPLAY_LOCATION_KEY).equals("")) {
                    return position;
                }
                return Position.valueOf(jSONObject.optString(IAM_DISPLAY_LOCATION_KEY, "FULL_SCREEN").toUpperCase());
            } catch (JSONException e) {
                e.printStackTrace();
                return position;
            }
        }

        private void handleActionTaken(JSONObject jSONObject) throws JSONException {
            JSONObject jSONObject2 = jSONObject.getJSONObject(TtmlNode.TAG_BODY);
            String optString = jSONObject2.optString("id", (String) null);
            if (WebViewManager.this.message.isPreview) {
                OSInAppMessageController.getController().onMessageActionOccurredOnPreview(WebViewManager.this.message, jSONObject2);
            } else if (optString != null) {
                OSInAppMessageController.getController().onMessageActionOccurredOnMessage(WebViewManager.this.message, jSONObject2);
            }
            if (jSONObject2.getBoolean("close")) {
                WebViewManager.this.dismissAndAwaitNextMessage((OneSignalGenericCallback) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public static int pageRectToViewHeight(@NonNull Activity activity2, @NonNull JSONObject jSONObject) {
        try {
            int dpToPx = OSViewUtils.dpToPx(jSONObject.getJSONObject("rect").getInt("height"));
            OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
            OneSignal.onesignalLog(log_level, "getPageHeightData:pxHeight: " + dpToPx);
            int webViewMaxSizeY = getWebViewMaxSizeY(activity2);
            if (dpToPx <= webViewMaxSizeY) {
                return dpToPx;
            }
            OneSignal.LOG_LEVEL log_level2 = OneSignal.LOG_LEVEL.DEBUG;
            OneSignal.Log(log_level2, "getPageHeightData:pxHeight is over screen max: " + webViewMaxSizeY);
            return webViewMaxSizeY;
        } catch (JSONException e) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "pageRectToViewHeight could not get page height", e);
            return -1;
        }
    }

    private void calculateHeightAndShowWebViewAfterNewActivity() {
        if (this.messageView.getDisplayPosition() == Position.FULL_SCREEN) {
            showMessageView((Integer) null);
        } else {
            OSViewUtils.decorViewReady(this.activity, new Runnable() {
                public void run() {
                    WebViewManager.this.setWebViewToMaxSize(WebViewManager.this.activity);
                    WebViewManager.this.webView.evaluateJavascript("getPageMetaData()", new ValueCallback<String>() {
                        public void onReceiveValue(String str) {
                            try {
                                WebViewManager.this.showMessageView(Integer.valueOf(WebViewManager.pageRectToViewHeight(WebViewManager.this.activity, new JSONObject(str))));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void available(@NonNull Activity activity2) {
        this.activity = activity2;
        if (this.firstShow) {
            showMessageView((Integer) null);
        } else {
            calculateHeightAndShowWebViewAfterNewActivity();
        }
    }

    /* access modifiers changed from: package-private */
    public void stopped(WeakReference<Activity> weakReference) {
        if (this.messageView != null) {
            this.messageView.removeAllViews();
        }
    }

    /* access modifiers changed from: private */
    public void showMessageView(@Nullable Integer num) {
        if (this.messageView == null) {
            OneSignal.Log(OneSignal.LOG_LEVEL.WARN, "No messageView found to update a with a new height.");
            return;
        }
        this.messageView.setWebView(this.webView);
        if (num != null) {
            this.messageView.updateHeight(num.intValue());
        }
        this.messageView.showView(this.activity);
        this.messageView.checkIfShouldDismiss();
    }

    /* access modifiers changed from: private */
    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    public void setupWebView(@NonNull final Activity activity2, @NonNull final String str) {
        enableWebViewRemoteDebugging();
        this.webView = new OSWebView(activity2);
        this.webView.setOverScrollMode(2);
        this.webView.setVerticalScrollBarEnabled(false);
        this.webView.setHorizontalScrollBarEnabled(false);
        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.addJavascriptInterface(new OSJavaScriptInterface(), "OSAndroid");
        blurryRenderingWebViewForKitKatWorkAround(this.webView);
        OSViewUtils.decorViewReady(activity2, new Runnable() {
            public void run() {
                WebViewManager.this.setWebViewToMaxSize(activity2);
                WebViewManager.this.webView.loadData(str, "text/html; charset=utf-8", RNFetchBlobConst.RNFB_RESPONSE_BASE64);
            }
        });
    }

    private void blurryRenderingWebViewForKitKatWorkAround(@NonNull WebView webView2) {
        if (Build.VERSION.SDK_INT == 19) {
            webView2.setLayerType(1, (Paint) null);
        }
    }

    /* access modifiers changed from: private */
    public void setWebViewToMaxSize(Activity activity2) {
        this.webView.layout(0, 0, getWebViewMaxSizeX(activity2), getWebViewMaxSizeY(activity2));
    }

    /* access modifiers changed from: private */
    public void createNewInAppMessageView(@NonNull Position position, int i) {
        this.messageView = new InAppMessageView(this.webView, position, i, this.message.getDisplayDuration());
        this.messageView.setMessageController(new InAppMessageView.InAppMessageViewListener() {
            public void onMessageWasShown() {
                boolean unused = WebViewManager.this.firstShow = false;
                OSInAppMessageController.getController().onMessageWasShown(WebViewManager.this.message);
            }

            public void onMessageWasDismissed() {
                OSInAppMessageController.getController().messageWasDismissed(WebViewManager.this.message);
                ActivityLifecycleHandler.removeActivityAvailableListener(WebViewManager.TAG + WebViewManager.this.message.messageId);
            }
        });
        ActivityLifecycleHandler.setActivityAvailableListener(TAG + this.message.messageId, this);
    }

    private static void enableWebViewRemoteDebugging() {
        if (Build.VERSION.SDK_INT >= 19 && OneSignal.atLogLevel(OneSignal.LOG_LEVEL.DEBUG)) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
    }

    private static int getWebViewMaxSizeX(Activity activity2) {
        return OSViewUtils.getWindowWidth(activity2) - (MARGIN_PX_SIZE * 2);
    }

    private static int getWebViewMaxSizeY(Activity activity2) {
        return OSViewUtils.getWindowHeight(activity2) - (MARGIN_PX_SIZE * 2);
    }

    /* access modifiers changed from: protected */
    public void dismissAndAwaitNextMessage(@Nullable final OneSignalGenericCallback oneSignalGenericCallback) {
        if (this.messageView != null) {
            this.messageView.dismissAndAwaitNextMessage(new OneSignalGenericCallback() {
                public void onComplete() {
                    InAppMessageView unused = WebViewManager.this.messageView = null;
                    if (oneSignalGenericCallback != null) {
                        oneSignalGenericCallback.onComplete();
                    }
                }
            });
        } else if (oneSignalGenericCallback != null) {
            oneSignalGenericCallback.onComplete();
        }
    }
}
