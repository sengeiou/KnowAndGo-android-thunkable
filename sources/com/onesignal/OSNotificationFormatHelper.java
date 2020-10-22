package com.onesignal;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.onesignal.OneSignal;
import org.json.JSONException;
import org.json.JSONObject;

class OSNotificationFormatHelper {
    public static final String PAYLOAD_OS_NOTIFICATION_ID = "i";
    public static final String PAYLOAD_OS_ROOT_CUSTOM = "custom";

    OSNotificationFormatHelper() {
    }

    static boolean isOneSignalIntent(@Nullable Intent intent) {
        if (intent == null) {
            return false;
        }
        return isOneSignalBundle(intent.getExtras());
    }

    static boolean isOneSignalBundle(@Nullable Bundle bundle) {
        return getOSNotificationIdFromBundle(bundle) != null;
    }

    @Nullable
    private static String getOSNotificationIdFromBundle(@Nullable Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return null;
        }
        String string = bundle.getString(PAYLOAD_OS_ROOT_CUSTOM, (String) null);
        if (string != null) {
            return getOSNotificationIdFromJsonString(string);
        }
        OneSignal.Log(OneSignal.LOG_LEVEL.DEBUG, "Not a OneSignal formatted Bundle. No 'custom' field in the bundle.");
        return null;
    }

    @Nullable
    static String getOSNotificationIdFromJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return getOSNotificationIdFromJsonString(jSONObject.optString(PAYLOAD_OS_ROOT_CUSTOM, (String) null));
    }

    @Nullable
    private static String getOSNotificationIdFromJsonString(@Nullable String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("i")) {
                return jSONObject.optString("i", (String) null);
            }
            OneSignal.Log(OneSignal.LOG_LEVEL.DEBUG, "Not a OneSignal formatted JSON string. No 'i' field in custom.");
            return null;
        } catch (JSONException unused) {
            OneSignal.Log(OneSignal.LOG_LEVEL.DEBUG, "Not a OneSignal formatted JSON String, error parsing string as JSON.");
        }
    }
}
