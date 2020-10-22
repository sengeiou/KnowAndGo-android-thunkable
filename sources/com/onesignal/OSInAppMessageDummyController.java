package com.onesignal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class OSInAppMessageDummyController extends OSInAppMessageController {
    /* access modifiers changed from: package-private */
    public void addTriggers(Map<String, Object> map) {
    }

    /* access modifiers changed from: package-private */
    public void displayPreviewMessage(@NonNull String str) {
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public OSInAppMessage getCurrentDisplayedInAppMessage() {
        return null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Object getTriggerValue(String str) {
        return null;
    }

    public void initRedisplayData(OneSignalDbHelper oneSignalDbHelper) {
    }

    /* access modifiers changed from: package-private */
    public void initWithCachedInAppMessages() {
    }

    /* access modifiers changed from: package-private */
    public boolean isInAppMessageShowing() {
        return false;
    }

    public void messageTriggerConditionChanged() {
    }

    public void messageWasDismissed(@NonNull OSInAppMessage oSInAppMessage) {
    }

    /* access modifiers changed from: package-private */
    public void onMessageActionOccurredOnMessage(@NonNull OSInAppMessage oSInAppMessage, @NonNull JSONObject jSONObject) {
    }

    /* access modifiers changed from: package-private */
    public void onMessageActionOccurredOnPreview(@NonNull OSInAppMessage oSInAppMessage, @NonNull JSONObject jSONObject) {
    }

    /* access modifiers changed from: package-private */
    public void receivedInAppMessageJson(@NonNull JSONArray jSONArray) throws JSONException {
    }

    /* access modifiers changed from: package-private */
    public void removeTriggersForKeys(Collection<String> collection) {
    }

    /* access modifiers changed from: package-private */
    public void setInAppMessagingEnabled(boolean z) {
    }

    OSInAppMessageDummyController(OneSignalDbHelper oneSignalDbHelper) {
        super(oneSignalDbHelper);
    }
}
