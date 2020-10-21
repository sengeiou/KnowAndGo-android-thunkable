package com.onesignal;

import androidx.annotation.NonNull;
import org.json.JSONObject;

public class OSEmailSubscriptionState implements Cloneable {
    private String emailAddress;
    private String emailUserId;
    OSObservable<Object, OSEmailSubscriptionState> observable = new OSObservable<>("changed", false);

    OSEmailSubscriptionState(boolean z) {
        if (z) {
            this.emailUserId = OneSignalPrefs.getString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_ONESIGNAL_EMAIL_ID_LAST, (String) null);
            this.emailAddress = OneSignalPrefs.getString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_ONESIGNAL_EMAIL_ADDRESS_LAST, (String) null);
            return;
        }
        this.emailUserId = OneSignal.getEmailId();
        this.emailAddress = OneSignalStateSynchronizer.getEmailStateSynchronizer().getRegistrationId();
    }

    /* access modifiers changed from: package-private */
    public void clearEmailAndId() {
        boolean z = (this.emailUserId == null && this.emailAddress == null) ? false : true;
        this.emailUserId = null;
        this.emailAddress = null;
        if (z) {
            this.observable.notifyChange(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void setEmailUserId(@NonNull String str) {
        boolean z = true;
        if (str != null ? str.equals(this.emailUserId) : this.emailUserId == null) {
            z = false;
        }
        this.emailUserId = str;
        if (z) {
            this.observable.notifyChange(this);
        }
    }

    public String getEmailUserId() {
        return this.emailUserId;
    }

    /* access modifiers changed from: package-private */
    public void setEmailAddress(@NonNull String str) {
        boolean z = !str.equals(this.emailAddress);
        this.emailAddress = str;
        if (z) {
            this.observable.notifyChange(this);
        }
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public boolean getSubscribed() {
        return (this.emailUserId == null || this.emailAddress == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public void persistAsFrom() {
        OneSignalPrefs.saveString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_ONESIGNAL_EMAIL_ID_LAST, this.emailUserId);
        OneSignalPrefs.saveString(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_ONESIGNAL_EMAIL_ADDRESS_LAST, this.emailAddress);
    }

    /* access modifiers changed from: package-private */
    public boolean compare(OSEmailSubscriptionState oSEmailSubscriptionState) {
        if ((this.emailUserId != null ? this.emailUserId : "").equals(oSEmailSubscriptionState.emailUserId != null ? oSEmailSubscriptionState.emailUserId : "")) {
            return !(this.emailAddress != null ? this.emailAddress : "").equals(oSEmailSubscriptionState.emailAddress != null ? oSEmailSubscriptionState.emailAddress : "");
        }
    }

    /* access modifiers changed from: protected */
    public Object clone() {
        try {
            return super.clone();
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.emailUserId != null) {
                jSONObject.put("emailUserId", this.emailUserId);
            } else {
                jSONObject.put("emailUserId", JSONObject.NULL);
            }
            if (this.emailAddress != null) {
                jSONObject.put("emailAddress", this.emailAddress);
            } else {
                jSONObject.put("emailAddress", JSONObject.NULL);
            }
            jSONObject.put("subscribed", getSubscribed());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return toJSONObject().toString();
    }
}
