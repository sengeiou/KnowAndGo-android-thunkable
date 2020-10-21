package com.onesignal;

import androidx.annotation.Nullable;
import com.onesignal.OneSignalStateSynchronizer;
import com.onesignal.UserStateSynchronizer;
import org.json.JSONException;
import org.json.JSONObject;

class UserStateEmailSynchronizer extends UserStateSynchronizer {
    /* access modifiers changed from: package-private */
    @Nullable
    public String getExternalId(boolean z) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean getSubscribed() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public UserStateSynchronizer.GetTagsResult getTags(boolean z) {
        return null;
    }

    public boolean getUserSubscribePreference() {
        return false;
    }

    public void setPermission(boolean z) {
    }

    /* access modifiers changed from: package-private */
    public void setSubscription(boolean z) {
    }

    /* access modifiers changed from: package-private */
    public void updateState(JSONObject jSONObject) {
    }

    UserStateEmailSynchronizer() {
        super(OneSignalStateSynchronizer.UserStateSynchronizerType.EMAIL);
    }

    /* access modifiers changed from: protected */
    public UserState newUserState(String str, boolean z) {
        return new UserStateEmail(str, z);
    }

    /* access modifiers changed from: package-private */
    public void refresh() {
        scheduleSyncToServer();
    }

    /* access modifiers changed from: protected */
    public void scheduleSyncToServer() {
        if (!(getId() == null && getRegistrationId() == null) && OneSignal.getUserId() != null) {
            getNetworkHandlerThread(0).runNewJobDelayed();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setEmail(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            com.onesignal.UserState r0 = r5.getUserStateForModification()
            org.json.JSONObject r0 = r0.syncValues
            java.lang.String r1 = "identifier"
            java.lang.String r1 = r0.optString(r1)
            boolean r1 = r6.equals(r1)
            if (r1 == 0) goto L_0x0026
            java.lang.String r1 = "email_auth_hash"
            java.lang.String r1 = r0.optString(r1)
            if (r7 != 0) goto L_0x001d
            java.lang.String r2 = ""
            goto L_0x001e
        L_0x001d:
            r2 = r7
        L_0x001e:
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0026
            r1 = 1
            goto L_0x0027
        L_0x0026:
            r1 = 0
        L_0x0027:
            if (r1 == 0) goto L_0x002d
            com.onesignal.OneSignal.fireEmailUpdateSuccess()
            return
        L_0x002d:
            java.lang.String r1 = "identifier"
            r2 = 0
            java.lang.String r1 = r0.optString(r1, r2)
            if (r1 != 0) goto L_0x0039
            r5.setNewSession()
        L_0x0039:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0066 }
            r3.<init>()     // Catch:{ JSONException -> 0x0066 }
            java.lang.String r4 = "identifier"
            r3.put(r4, r6)     // Catch:{ JSONException -> 0x0066 }
            if (r7 == 0) goto L_0x004a
            java.lang.String r4 = "email_auth_hash"
            r3.put(r4, r7)     // Catch:{ JSONException -> 0x0066 }
        L_0x004a:
            if (r7 != 0) goto L_0x005f
            if (r1 == 0) goto L_0x005f
            boolean r6 = r1.equals(r6)     // Catch:{ JSONException -> 0x0066 }
            if (r6 != 0) goto L_0x005f
            java.lang.String r6 = ""
            com.onesignal.OneSignal.saveEmailId(r6)     // Catch:{ JSONException -> 0x0066 }
            r5.resetCurrentState()     // Catch:{ JSONException -> 0x0066 }
            r5.setNewSession()     // Catch:{ JSONException -> 0x0066 }
        L_0x005f:
            r5.generateJsonDiff(r0, r3, r0, r2)     // Catch:{ JSONException -> 0x0066 }
            r5.scheduleSyncToServer()     // Catch:{ JSONException -> 0x0066 }
            goto L_0x006a
        L_0x0066:
            r6 = move-exception
            r6.printStackTrace()
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.UserStateEmailSynchronizer.setEmail(java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public String getId() {
        return OneSignal.getEmailId();
    }

    /* access modifiers changed from: package-private */
    public void updateIdDependents(String str) {
        OneSignal.updateEmailIdDependents(str);
    }

    /* access modifiers changed from: protected */
    public void addOnSessionOrCreateExtras(JSONObject jSONObject) {
        try {
            jSONObject.put("device_type", 11);
            jSONObject.putOpt("device_player_id", OneSignal.getUserId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void logoutEmail() {
        OneSignal.saveEmailId("");
        resetCurrentState();
        getToSyncUserState().syncValues.remove("identifier");
        this.toSyncUserState.syncValues.remove("email_auth_hash");
        this.toSyncUserState.syncValues.remove("device_player_id");
        this.toSyncUserState.syncValues.remove("external_user_id");
        this.toSyncUserState.persistState();
        OneSignal.getPermissionSubscriptionState().emailSubscriptionStatus.clearEmailAndId();
    }

    /* access modifiers changed from: protected */
    public void fireEventsForUpdateFailure(JSONObject jSONObject) {
        if (jSONObject.has("identifier")) {
            OneSignal.fireEmailUpdateFailure();
        }
    }

    /* access modifiers changed from: protected */
    public void onSuccessfulSync(JSONObject jSONObject) {
        if (jSONObject.has("identifier")) {
            OneSignal.fireEmailUpdateSuccess();
        }
    }
}
