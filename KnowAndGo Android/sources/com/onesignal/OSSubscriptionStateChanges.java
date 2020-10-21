package com.onesignal;

import org.json.JSONObject;

public class OSSubscriptionStateChanges {
    OSSubscriptionState from;

    /* renamed from: to */
    OSSubscriptionState f1086to;

    public OSSubscriptionState getTo() {
        return this.f1086to;
    }

    public OSSubscriptionState getFrom() {
        return this.from;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.from.toJSONObject());
            jSONObject.put("to", this.f1086to.toJSONObject());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return toJSONObject().toString();
    }
}
