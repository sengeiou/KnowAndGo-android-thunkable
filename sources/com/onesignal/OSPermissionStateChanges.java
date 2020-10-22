package com.onesignal;

import org.json.JSONObject;

public class OSPermissionStateChanges {
    OSPermissionState from;

    /* renamed from: to */
    OSPermissionState f1085to;

    public OSPermissionState getTo() {
        return this.f1085to;
    }

    public OSPermissionState getFrom() {
        return this.from;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.from.toJSONObject());
            jSONObject.put("to", this.f1085to.toJSONObject());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return toJSONObject().toString();
    }
}
