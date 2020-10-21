package com.onesignal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class NotificationPayloadProcessorHMS {
    NotificationPayloadProcessorHMS() {
    }

    static void handleHMSNotificationOpenIntent(@NonNull Activity activity, @Nullable Intent intent) {
        JSONObject covertHMSOpenIntentToJson;
        OneSignal.setAppContext(activity);
        if (intent != null && (covertHMSOpenIntentToJson = covertHMSOpenIntentToJson(intent)) != null) {
            handleProcessJsonOpenData(activity, covertHMSOpenIntentToJson);
        }
    }

    @Nullable
    private static JSONObject covertHMSOpenIntentToJson(@Nullable Intent intent) {
        if (!OSNotificationFormatHelper.isOneSignalIntent(intent)) {
            return null;
        }
        JSONObject bundleAsJSONObject = NotificationBundleProcessor.bundleAsJSONObject(intent.getExtras());
        reformatButtonClickAction(bundleAsJSONObject);
        return bundleAsJSONObject;
    }

    private static void reformatButtonClickAction(@NonNull JSONObject jSONObject) {
        try {
            String str = (String) NotificationBundleProcessor.getCustomJSONObject(jSONObject).remove(GenerateNotification.BUNDLE_KEY_ACTION_ID);
            if (str != null) {
                jSONObject.put(GenerateNotification.BUNDLE_KEY_ACTION_ID, str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void handleProcessJsonOpenData(@NonNull Activity activity, @NonNull JSONObject jSONObject) {
        if (!NotificationOpenedProcessor.handleIAMPreviewOpen(activity, jSONObject)) {
            OneSignal.handleNotificationOpen(activity, new JSONArray().put(jSONObject), false, OSNotificationFormatHelper.getOSNotificationIdFromJson(jSONObject));
        }
    }

    public static void processDataMessageReceived(@NonNull Context context, @Nullable String str) {
        Bundle jsonStringToBundle;
        OneSignal.setAppContext(context);
        if (str != null && (jsonStringToBundle = OSUtils.jsonStringToBundle(str)) != null && !NotificationBundleProcessor.processBundleFromReceiver(context, jsonStringToBundle).processed()) {
            GcmBroadcastReceiver.startGCMService(context, jsonStringToBundle);
        }
    }
}
