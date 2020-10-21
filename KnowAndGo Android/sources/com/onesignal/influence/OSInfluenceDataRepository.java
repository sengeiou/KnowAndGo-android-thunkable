package com.onesignal.influence;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.onesignal.OSSharedPreferences;
import com.onesignal.OneSignalRemoteParams;
import com.onesignal.influence.model.OSInfluenceType;
import org.json.JSONArray;
import org.json.JSONException;

class OSInfluenceDataRepository {
    protected static final String PREFS_OS_DIRECT_ENABLED = "PREFS_OS_DIRECT_ENABLED";
    protected static final String PREFS_OS_IAM_INDIRECT_ATTRIBUTION_WINDOW = "PREFS_OS_IAM_INDIRECT_ATTRIBUTION_WINDOW";
    protected static final String PREFS_OS_IAM_LIMIT = "PREFS_OS_IAM_LIMIT";
    protected static final String PREFS_OS_INDIRECT_ENABLED = "PREFS_OS_INDIRECT_ENABLED";
    protected static final String PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN = "PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN";
    protected static final String PREFS_OS_LAST_IAMS_RECEIVED = "PREFS_OS_LAST_IAMS_RECEIVED";
    protected static final String PREFS_OS_LAST_NOTIFICATIONS_RECEIVED = "PREFS_OS_LAST_NOTIFICATIONS_RECEIVED";
    protected static final String PREFS_OS_NOTIFICATION_INDIRECT_ATTRIBUTION_WINDOW = "PREFS_OS_INDIRECT_ATTRIBUTION_WINDOW";
    protected static final String PREFS_OS_NOTIFICATION_LIMIT = "PREFS_OS_NOTIFICATION_LIMIT";
    protected static final String PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE = "PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE";
    protected static final String PREFS_OS_OUTCOMES_CURRENT_NOTIFICATION_INFLUENCE = "PREFS_OS_OUTCOMES_CURRENT_SESSION";
    protected static final String PREFS_OS_UNATTRIBUTED_ENABLED = "PREFS_OS_UNATTRIBUTED_ENABLED";
    private OSSharedPreferences preferences;

    public OSInfluenceDataRepository(OSSharedPreferences oSSharedPreferences) {
        this.preferences = oSSharedPreferences;
    }

    /* access modifiers changed from: package-private */
    public void cacheNotificationInfluenceType(@NonNull OSInfluenceType oSInfluenceType) {
        this.preferences.saveString(this.preferences.getPreferencesName(), PREFS_OS_OUTCOMES_CURRENT_NOTIFICATION_INFLUENCE, oSInfluenceType.toString());
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public OSInfluenceType getNotificationCachedInfluenceType() {
        return OSInfluenceType.fromString(this.preferences.getString(this.preferences.getPreferencesName(), PREFS_OS_OUTCOMES_CURRENT_NOTIFICATION_INFLUENCE, OSInfluenceType.UNATTRIBUTED.toString()));
    }

    /* access modifiers changed from: package-private */
    public void cacheIAMInfluenceType(@NonNull OSInfluenceType oSInfluenceType) {
        this.preferences.saveString(this.preferences.getPreferencesName(), PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE, oSInfluenceType.toString());
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public OSInfluenceType getIAMCachedInfluenceType() {
        return OSInfluenceType.fromString(this.preferences.getString(this.preferences.getPreferencesName(), PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE, OSInfluenceType.UNATTRIBUTED.toString()));
    }

    /* access modifiers changed from: package-private */
    public void cacheNotificationOpenId(@Nullable String str) {
        this.preferences.saveString(this.preferences.getPreferencesName(), PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN, str);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public String getCachedNotificationOpenId() {
        return this.preferences.getString(this.preferences.getPreferencesName(), PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN, (String) null);
    }

    /* access modifiers changed from: package-private */
    public void saveNotifications(@NonNull JSONArray jSONArray) {
        this.preferences.saveString(this.preferences.getPreferencesName(), PREFS_OS_LAST_NOTIFICATIONS_RECEIVED, jSONArray.toString());
    }

    /* access modifiers changed from: package-private */
    public void saveIAMs(@NonNull JSONArray jSONArray) {
        this.preferences.saveString(this.preferences.getPreferencesName(), PREFS_OS_LAST_IAMS_RECEIVED, jSONArray.toString());
    }

    /* access modifiers changed from: package-private */
    public JSONArray getLastNotificationsReceivedData() throws JSONException {
        String string = this.preferences.getString(this.preferences.getPreferencesName(), PREFS_OS_LAST_NOTIFICATIONS_RECEIVED, "[]");
        return string != null ? new JSONArray(string) : new JSONArray();
    }

    /* access modifiers changed from: package-private */
    public JSONArray getLastIAMsReceivedData() throws JSONException {
        String string = this.preferences.getString(this.preferences.getPreferencesName(), PREFS_OS_LAST_IAMS_RECEIVED, "[]");
        return string != null ? new JSONArray(string) : new JSONArray();
    }

    /* access modifiers changed from: package-private */
    public int getNotificationLimit() {
        return this.preferences.getInt(this.preferences.getPreferencesName(), PREFS_OS_NOTIFICATION_LIMIT, 10);
    }

    /* access modifiers changed from: package-private */
    public int getIAMLimit() {
        return this.preferences.getInt(this.preferences.getPreferencesName(), PREFS_OS_IAM_LIMIT, 10);
    }

    /* access modifiers changed from: package-private */
    public int getNotificationIndirectAttributionWindow() {
        return this.preferences.getInt(this.preferences.getPreferencesName(), PREFS_OS_NOTIFICATION_INDIRECT_ATTRIBUTION_WINDOW, OneSignalRemoteParams.DEFAULT_INDIRECT_ATTRIBUTION_WINDOW);
    }

    /* access modifiers changed from: package-private */
    public int getIAMIndirectAttributionWindow() {
        return this.preferences.getInt(this.preferences.getPreferencesName(), PREFS_OS_IAM_INDIRECT_ATTRIBUTION_WINDOW, OneSignalRemoteParams.DEFAULT_INDIRECT_ATTRIBUTION_WINDOW);
    }

    /* access modifiers changed from: package-private */
    public boolean isDirectInfluenceEnabled() {
        return this.preferences.getBool(this.preferences.getPreferencesName(), PREFS_OS_DIRECT_ENABLED, false);
    }

    /* access modifiers changed from: package-private */
    public boolean isIndirectInfluenceEnabled() {
        return this.preferences.getBool(this.preferences.getPreferencesName(), PREFS_OS_INDIRECT_ENABLED, false);
    }

    /* access modifiers changed from: package-private */
    public boolean isUnattributedInfluenceEnabled() {
        return this.preferences.getBool(this.preferences.getPreferencesName(), PREFS_OS_UNATTRIBUTED_ENABLED, false);
    }

    /* access modifiers changed from: package-private */
    public void saveInfluenceParams(OneSignalRemoteParams.InfluenceParams influenceParams) {
        this.preferences.saveBool(this.preferences.getPreferencesName(), PREFS_OS_DIRECT_ENABLED, influenceParams.isDirectEnabled());
        this.preferences.saveBool(this.preferences.getPreferencesName(), PREFS_OS_INDIRECT_ENABLED, influenceParams.isIndirectEnabled());
        this.preferences.saveBool(this.preferences.getPreferencesName(), PREFS_OS_UNATTRIBUTED_ENABLED, influenceParams.isUnattributedEnabled());
        this.preferences.saveInt(this.preferences.getPreferencesName(), PREFS_OS_NOTIFICATION_LIMIT, influenceParams.getNotificationLimit());
        this.preferences.saveInt(this.preferences.getPreferencesName(), PREFS_OS_NOTIFICATION_INDIRECT_ATTRIBUTION_WINDOW, influenceParams.getIndirectNotificationAttributionWindow());
        this.preferences.saveInt(this.preferences.getPreferencesName(), PREFS_OS_IAM_LIMIT, influenceParams.getIamLimit());
        this.preferences.saveInt(this.preferences.getPreferencesName(), PREFS_OS_IAM_INDIRECT_ATTRIBUTION_WINDOW, influenceParams.getIndirectIAMAttributionWindow());
    }
}
