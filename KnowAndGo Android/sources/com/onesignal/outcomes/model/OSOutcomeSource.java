package com.onesignal.outcomes.model;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class OSOutcomeSource {
    private static final String DIRECT = "direct";
    private static final String INDIRECT = "indirect";
    @Nullable
    private OSOutcomeSourceBody directBody;
    @Nullable
    private OSOutcomeSourceBody indirectBody;

    public OSOutcomeSource(@Nullable OSOutcomeSourceBody oSOutcomeSourceBody, @Nullable OSOutcomeSourceBody oSOutcomeSourceBody2) {
        this.directBody = oSOutcomeSourceBody;
        this.indirectBody = oSOutcomeSourceBody2;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (this.directBody != null) {
            jSONObject.put(DIRECT, this.directBody.toJSONObject());
        }
        if (this.indirectBody != null) {
            jSONObject.put(INDIRECT, this.indirectBody.toJSONObject());
        }
        return jSONObject;
    }

    public OSOutcomeSourceBody getDirectBody() {
        return this.directBody;
    }

    public OSOutcomeSource setDirectBody(@Nullable OSOutcomeSourceBody oSOutcomeSourceBody) {
        this.directBody = oSOutcomeSourceBody;
        return this;
    }

    public OSOutcomeSourceBody getIndirectBody() {
        return this.indirectBody;
    }

    public OSOutcomeSource setIndirectBody(@Nullable OSOutcomeSourceBody oSOutcomeSourceBody) {
        this.indirectBody = oSOutcomeSourceBody;
        return this;
    }

    public String toString() {
        return "OSOutcomeSource{directBody=" + this.directBody + ", indirectBody=" + this.indirectBody + '}';
    }
}
