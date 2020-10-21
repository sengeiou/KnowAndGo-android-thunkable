package com.geektime.rnonesignalandroid;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RNUtils {
    @Nullable
    public static JSONObject readableMapToJson(ReadableMap readableMap) {
        JSONObject jSONObject = new JSONObject();
        if (readableMap == null) {
            return null;
        }
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        if (!keySetIterator.hasNextKey()) {
            return null;
        }
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            try {
                switch (readableMap.getType(nextKey)) {
                    case Null:
                        jSONObject.put(nextKey, (Object) null);
                        break;
                    case Boolean:
                        jSONObject.put(nextKey, readableMap.getBoolean(nextKey));
                        break;
                    case Number:
                        jSONObject.put(nextKey, readableMap.getInt(nextKey));
                        break;
                    case String:
                        jSONObject.put(nextKey, readableMap.getString(nextKey));
                        break;
                    case Map:
                        jSONObject.put(nextKey, readableMapToJson(readableMap.getMap(nextKey)));
                        break;
                    case Array:
                        jSONObject.put(nextKey, readableMap.getArray(nextKey));
                        break;
                }
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    @Nullable
    public static WritableMap jsonToWritableMap(JSONObject jSONObject) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        if (!keys.hasNext()) {
            return null;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj == null) {
                    writableNativeMap.putNull(next);
                } else if (obj instanceof Boolean) {
                    writableNativeMap.putBoolean(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Integer) {
                    writableNativeMap.putInt(next, ((Integer) obj).intValue());
                } else {
                    if (!(obj instanceof Double) && !(obj instanceof Long)) {
                        if (!(obj instanceof Float)) {
                            if (obj instanceof String) {
                                writableNativeMap.putString(next, obj.toString());
                            } else if (obj instanceof JSONObject) {
                                writableNativeMap.putMap(next, jsonToWritableMap((JSONObject) obj));
                            } else if (obj instanceof JSONArray) {
                                writableNativeMap.putArray(next, jsonArrayToWritableArray((JSONArray) obj));
                            } else if (obj.getClass().isEnum()) {
                                writableNativeMap.putString(next, obj.toString());
                            }
                        }
                    }
                    writableNativeMap.putDouble(next, Double.parseDouble(String.valueOf(obj)));
                }
            } catch (JSONException unused) {
            }
        }
        return writableNativeMap;
    }

    @Nullable
    public static WritableArray jsonArrayToWritableArray(JSONArray jSONArray) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Object obj = jSONArray.get(i);
                if (obj == null) {
                    writableNativeArray.pushNull();
                } else if (obj instanceof Boolean) {
                    writableNativeArray.pushBoolean(((Boolean) obj).booleanValue());
                } else if (obj instanceof Integer) {
                    writableNativeArray.pushInt(((Integer) obj).intValue());
                } else {
                    if (!(obj instanceof Double) && !(obj instanceof Long)) {
                        if (!(obj instanceof Float)) {
                            if (obj instanceof String) {
                                writableNativeArray.pushString(obj.toString());
                            } else if (obj instanceof JSONObject) {
                                writableNativeArray.pushMap(jsonToWritableMap((JSONObject) obj));
                            } else if (obj instanceof JSONArray) {
                                writableNativeArray.pushArray(jsonArrayToWritableArray((JSONArray) obj));
                            } else if (obj.getClass().isEnum()) {
                                writableNativeArray.pushString(obj.toString());
                            }
                        }
                    }
                    writableNativeArray.pushDouble(Double.parseDouble(String.valueOf(obj)));
                }
            } catch (JSONException unused) {
            }
        }
        return writableNativeArray;
    }

    public static Collection<String> convertReableArrayIntoStringCollection(ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = readableArray.toArrayList().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof String) {
                arrayList.add((String) next);
            }
        }
        return arrayList;
    }
}
