package com.onesignal;

import androidx.annotation.NonNull;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalRestClient;
import org.json.JSONException;
import org.json.JSONObject;

class OSReceiveReceiptRepository {
    private static final String APP_ID = "app_id";
    private static final String PLAYER_ID = "player_id";

    OSReceiveReceiptRepository() {
    }

    /* access modifiers changed from: package-private */
    public void sendReceiveReceipt(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull OneSignalRestClient.ResponseHandler responseHandler) {
        try {
            JSONObject put = new JSONObject().put(APP_ID, str).put(PLAYER_ID, str2);
            OneSignalRestClient.put("notifications/" + str3 + "/report_received", put, responseHandler);
        } catch (JSONException e) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Generating direct receive receipt:JSON Failed.", e);
        }
    }
}
