package com.onesignal;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class OSSubscriptionState implements Cloneable {
    private boolean accepted;
    OSObservable<Object, OSSubscriptionState> observable = new OSObservable<>("changed", false);
    private String pushToken;
    private String userId;
    private boolean userSubscriptionSetting;

    OSSubscriptionState(boolean z, boolean z2) {
        if (z) {
            this.userSubscriptionSetting = OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_ONESIGNAL_SUBSCRIPTION_LAST, false);
            this.userId = OneSignalPrefs.getString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_ONESIGNAL_PLAYER_ID_LAST, (String) null);
            this.pushToken = OneSignalPrefs.getString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_ONESIGNAL_PUSH_TOKEN_LAST, (String) null);
            this.accepted = OneSignalPrefs.getBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_ONESIGNAL_PERMISSION_ACCEPTED_LAST, false);
            return;
        }
        this.userSubscriptionSetting = OneSignalStateSynchronizer.getUserSubscribePreference();
        this.userId = OneSignal.getUserId();
        this.pushToken = OneSignalStateSynchronizer.getRegistrationId();
        this.accepted = z2;
    }

    /* access modifiers changed from: package-private */
    public void changed(OSPermissionState oSPermissionState) {
        setAccepted(oSPermissionState.getEnabled());
    }

    /* access modifiers changed from: package-private */
    public void setUserId(@Nullable String str) {
        boolean z = true;
        if (str != null ? str.equals(this.userId) : this.userId == null) {
            z = false;
        }
        this.userId = str;
        if (z) {
            this.observable.notifyChange(this);
        }
    }

    public String getUserId() {
        return this.userId;
    }

    /* access modifiers changed from: package-private */
    public void setPushToken(String str) {
        if (str != null) {
            boolean z = !str.equals(this.pushToken);
            this.pushToken = str;
            if (z) {
                this.observable.notifyChange(this);
            }
        }
    }

    public String getPushToken() {
        return this.pushToken;
    }

    /* access modifiers changed from: package-private */
    public void setUserSubscriptionSetting(boolean z) {
        boolean z2 = this.userSubscriptionSetting != z;
        this.userSubscriptionSetting = z;
        if (z2) {
            this.observable.notifyChange(this);
        }
    }

    public boolean getUserSubscriptionSetting() {
        return this.userSubscriptionSetting;
    }

    private void setAccepted(boolean z) {
        boolean subscribed = getSubscribed();
        this.accepted = z;
        if (subscribed != getSubscribed()) {
            this.observable.notifyChange(this);
        }
    }

    public boolean getSubscribed() {
        return this.userId != null && this.pushToken != null && this.userSubscriptionSetting && this.accepted;
    }

    /* access modifiers changed from: package-private */
    public void persistAsFrom() {
        OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_ONESIGNAL_SUBSCRIPTION_LAST, this.userSubscriptionSetting);
        OneSignalPrefs.saveString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_ONESIGNAL_PLAYER_ID_LAST, this.userId);
        OneSignalPrefs.saveString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_ONESIGNAL_PUSH_TOKEN_LAST, this.pushToken);
        OneSignalPrefs.saveBool(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_ONESIGNAL_PERMISSION_ACCEPTED_LAST, this.accepted);
    }

    /* access modifiers changed from: package-private */
    public boolean compare(OSSubscriptionState oSSubscriptionState) {
        if (this.userSubscriptionSetting == oSSubscriptionState.userSubscriptionSetting) {
            if ((this.userId != null ? this.userId : "").equals(oSSubscriptionState.userId != null ? oSSubscriptionState.userId : "")) {
                return !(this.pushToken != null ? this.pushToken : "").equals(oSSubscriptionState.pushToken != null ? oSSubscriptionState.pushToken : "") || this.accepted != oSSubscriptionState.accepted;
            }
        }
    }

    /* access modifiers changed from: protected */
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.userId != null) {
                jSONObject.put("userId", this.userId);
            } else {
                jSONObject.put("userId", JSONObject.NULL);
            }
            if (this.pushToken != null) {
                jSONObject.put("pushToken", this.pushToken);
            } else {
                jSONObject.put("pushToken", JSONObject.NULL);
            }
            jSONObject.put("userSubscriptionSetting", this.userSubscriptionSetting);
            jSONObject.put("subscribed", getSubscribed());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return toJSONObject().toString();
    }
}
