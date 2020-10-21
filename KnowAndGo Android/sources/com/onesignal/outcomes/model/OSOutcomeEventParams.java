package com.onesignal.outcomes.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class OSOutcomeEventParams {
    private static final String OUTCOME_ID = "id";
    private static final String OUTCOME_SOURCES = "sources";
    private static final String TIMESTAMP = "timestamp";
    private static final String WEIGHT = "weight";
    @NonNull
    private String outcomeId;
    @Nullable
    private OSOutcomeSource outcomeSource;
    private long timestamp;
    private Float weight;

    public OSOutcomeEventParams(@NonNull String str, @Nullable OSOutcomeSource oSOutcomeSource, float f) {
        this(str, oSOutcomeSource, f, 0);
    }

    public OSOutcomeEventParams(@NonNull String str, @Nullable OSOutcomeSource oSOutcomeSource, float f, long j) {
        this.outcomeId = str;
        this.outcomeSource = oSOutcomeSource;
        this.weight = Float.valueOf(f);
        this.timestamp = j;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.outcomeId);
        if (this.outcomeSource != null) {
            jSONObject.put(OUTCOME_SOURCES, this.outcomeSource.toJSONObject());
        }
        if (this.weight.floatValue() > 0.0f) {
            jSONObject.put(WEIGHT, this.weight);
        }
        if (this.timestamp > 0) {
            jSONObject.put(TIMESTAMP, this.timestamp);
        }
        return jSONObject;
    }

    public String getOutcomeId() {
        return this.outcomeId;
    }

    public OSOutcomeSource getOutcomeSource() {
        return this.outcomeSource;
    }

    public Float getWeight() {
        return this.weight;
    }

    public void setWeight(float f) {
        this.weight = Float.valueOf(f);
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public boolean isUnattributed() {
        return this.outcomeSource == null || (this.outcomeSource.getDirectBody() == null && this.outcomeSource.getIndirectBody() == null);
    }

    public String toString() {
        return "OSOutcomeEventParams{outcomeId='" + this.outcomeId + '\'' + ", outcomeSource=" + this.outcomeSource + ", weight=" + this.weight + ", timestamp=" + this.timestamp + '}';
    }
}
