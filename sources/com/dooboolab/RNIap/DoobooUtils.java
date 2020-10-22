package com.dooboolab.RNIap;

import android.util.Log;
import com.facebook.react.bridge.ObjectAlreadyConsumedException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DoobooUtils {
    public static final String E_ALREADY_OWNED = "E_ALREADY_OWNED";
    public static final String E_BILLING_RESPONSE_JSON_PARSE_ERROR = "E_BILLING_RESPONSE_JSON_PARSE_ERROR";
    public static final String E_DEVELOPER_ERROR = "E_DEVELOPER_ERROR";
    public static final String E_ITEM_UNAVAILABLE = "E_ITEM_UNAVAILABLE";
    public static final String E_NETWORK_ERROR = "E_NETWORK_ERROR";
    public static final String E_NOT_ENDED = "E_NOT_ENDED";
    public static final String E_NOT_PREPARED = "E_NOT_PREPARED";
    public static final String E_REMOTE_ERROR = "E_REMOTE_ERROR";
    public static final String E_SERVICE_ERROR = "E_SERVICE_ERROR";
    public static final String E_UNKNOWN = "E_UNKNOWN";
    public static final String E_USER_CANCELLED = "E_USER_CANCELLED";
    public static final String E_USER_ERROR = "E_USER_ERROR";
    private static final String TAG = "DoobooUtils";
    private static DoobooUtils instance = new DoobooUtils();
    private HashMap<String, ArrayList<Promise>> promises = new HashMap<>();

    public static DoobooUtils getInstance() {
        return instance;
    }

    public void rejectPromiseWithBillingError(Promise promise, int i) {
        String[] billingResponseData = getBillingResponseData(i);
        promise.reject(billingResponseData[0], billingResponseData[1]);
    }

    public String[] getBillingResponseData(int i) {
        String[] strArr = new String[2];
        switch (i) {
            case -2:
                strArr[0] = E_SERVICE_ERROR;
                strArr[1] = "This feature is not available on your device.";
                break;
            case -1:
                strArr[0] = E_NETWORK_ERROR;
                strArr[1] = "The service is disconnected (check your internet connection.)";
                break;
            case 0:
                strArr[0] = "OK";
                strArr[1] = "";
                break;
            case 1:
                strArr[0] = E_USER_CANCELLED;
                strArr[1] = "Payment is Cancelled.";
                break;
            case 2:
                strArr[0] = E_SERVICE_ERROR;
                strArr[1] = "The service is unreachable. This may be your internet connection, or the Play Store may be down.";
                break;
            case 3:
                strArr[0] = E_SERVICE_ERROR;
                strArr[1] = "Billing is unavailable. This may be a problem with your device, or the Play Store may be down.";
                break;
            case 4:
                strArr[0] = E_ITEM_UNAVAILABLE;
                strArr[1] = "That item is unavailable.";
                break;
            case 5:
                strArr[0] = E_DEVELOPER_ERROR;
                strArr[1] = "Google is indicating that we have some issue connecting to payment.";
                break;
            case 6:
                strArr[0] = E_UNKNOWN;
                strArr[1] = "An unknown or unexpected error has occured. Please try again later.";
                break;
            case 7:
                strArr[0] = E_ALREADY_OWNED;
                strArr[1] = "You already own this item.";
                break;
            default:
                strArr[0] = E_UNKNOWN;
                strArr[1] = "Purchase failed with code: " + i;
                break;
        }
        Log.e(TAG, "Error Code : " + i);
        return strArr;
    }

    public void addPromiseForKey(String str, Promise promise) {
        ArrayList arrayList;
        try {
            if (this.promises.containsKey(str)) {
                arrayList = this.promises.get(str);
            } else {
                ArrayList arrayList2 = new ArrayList();
                this.promises.put(str, arrayList2);
                arrayList = arrayList2;
            }
            arrayList.add(promise);
        } catch (ObjectAlreadyConsumedException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void resolvePromisesForKey(String str, Object obj) {
        try {
            if (this.promises.containsKey(str)) {
                Iterator it = this.promises.get(str).iterator();
                while (it.hasNext()) {
                    ((Promise) it.next()).resolve(obj);
                }
                this.promises.remove(str);
            }
        } catch (ObjectAlreadyConsumedException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void rejectPromisesForKey(String str, String str2, String str3, Exception exc) {
        try {
            if (this.promises.containsKey(str)) {
                Iterator it = this.promises.get(str).iterator();
                while (it.hasNext()) {
                    ((Promise) it.next()).reject(str2, str3, (Throwable) exc);
                }
                this.promises.remove(str);
            }
        } catch (ObjectAlreadyConsumedException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void rejectPromisesWithBillingError(String str, int i) {
        try {
            if (this.promises.containsKey(str)) {
                Iterator it = this.promises.get(str).iterator();
                while (it.hasNext()) {
                    rejectPromiseWithBillingError((Promise) it.next(), i);
                }
                this.promises.remove(str);
            }
        } catch (ObjectAlreadyConsumedException e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public WritableMap convertJsonToMap(JSONObject jSONObject) throws JSONException {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONObject) {
                writableNativeMap.putMap(next, convertJsonToMap((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                writableNativeMap.putArray(next, convertJsonToArray((JSONArray) obj));
            } else if (obj instanceof Boolean) {
                writableNativeMap.putBoolean(next, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                writableNativeMap.putInt(next, ((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                writableNativeMap.putDouble(next, ((Double) obj).doubleValue());
            } else if (obj instanceof String) {
                writableNativeMap.putString(next, (String) obj);
            } else {
                writableNativeMap.putString(next, obj.toString());
            }
        }
        return writableNativeMap;
    }

    public WritableArray convertJsonToArray(JSONArray jSONArray) throws JSONException {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONObject) {
                writableNativeArray.pushMap(convertJsonToMap((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                writableNativeArray.pushArray(convertJsonToArray((JSONArray) obj));
            } else if (obj instanceof Boolean) {
                writableNativeArray.pushBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                writableNativeArray.pushInt(((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                writableNativeArray.pushDouble(((Double) obj).doubleValue());
            } else if (obj instanceof String) {
                writableNativeArray.pushString((String) obj);
            } else {
                writableNativeArray.pushString(obj.toString());
            }
        }
        return writableNativeArray;
    }

    public JSONObject convertMapToJson(ReadableMap readableMap) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (readableMap.getType(nextKey)) {
                case Null:
                    jSONObject.put(nextKey, JSONObject.NULL);
                    break;
                case Boolean:
                    jSONObject.put(nextKey, readableMap.getBoolean(nextKey));
                    break;
                case Number:
                    jSONObject.put(nextKey, readableMap.getDouble(nextKey));
                    break;
                case String:
                    jSONObject.put(nextKey, readableMap.getString(nextKey));
                    break;
                case Map:
                    jSONObject.put(nextKey, convertMapToJson(readableMap.getMap(nextKey)));
                    break;
                case Array:
                    jSONObject.put(nextKey, convertArrayToJson(readableMap.getArray(nextKey)));
                    break;
            }
        }
        return jSONObject;
    }

    public JSONArray convertArrayToJson(ReadableArray readableArray) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < readableArray.size(); i++) {
            switch (readableArray.getType(i)) {
                case Boolean:
                    jSONArray.put(readableArray.getBoolean(i));
                    break;
                case Number:
                    jSONArray.put(readableArray.getDouble(i));
                    break;
                case String:
                    jSONArray.put(readableArray.getString(i));
                    break;
                case Map:
                    jSONArray.put(convertMapToJson(readableArray.getMap(i)));
                    break;
                case Array:
                    jSONArray.put(convertArrayToJson(readableArray.getArray(i)));
                    break;
            }
        }
        return jSONArray;
    }
}
