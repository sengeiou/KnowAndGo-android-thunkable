package com.onesignal.outcomes;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.onesignal.OSLogger;
import com.onesignal.OSSharedPreferences;
import com.onesignal.OneSignalDb;
import com.onesignal.influence.model.OSInfluenceChannel;
import com.onesignal.influence.model.OSInfluenceType;
import com.onesignal.outcomes.model.OSCachedUniqueOutcome;
import com.onesignal.outcomes.model.OSOutcomeEventParams;
import com.onesignal.outcomes.model.OSOutcomeSource;
import com.onesignal.outcomes.model.OSOutcomeSourceBody;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

class OSOutcomeEventsCache {
    private static final String PREFS_OS_UNATTRIBUTED_UNIQUE_OUTCOME_EVENTS_SENT = "PREFS_OS_UNATTRIBUTED_UNIQUE_OUTCOME_EVENTS_SENT";
    private OneSignalDb dbHelper;
    private OSLogger logger;
    private OSSharedPreferences preferences;

    OSOutcomeEventsCache(OSLogger oSLogger, OneSignalDb oneSignalDb, OSSharedPreferences oSSharedPreferences) {
        this.logger = oSLogger;
        this.dbHelper = oneSignalDb;
        this.preferences = oSSharedPreferences;
    }

    /* access modifiers changed from: package-private */
    public boolean isOutcomesV2ServiceEnabled() {
        return this.preferences.getBool(this.preferences.getPreferencesName(), this.preferences.getOutcomesV2KeyName(), false);
    }

    /* access modifiers changed from: package-private */
    public Set<String> getUnattributedUniqueOutcomeEventsSentByChannel() {
        return this.preferences.getStringSet(this.preferences.getPreferencesName(), PREFS_OS_UNATTRIBUTED_UNIQUE_OUTCOME_EVENTS_SENT, (Set<String>) null);
    }

    /* access modifiers changed from: package-private */
    public void saveUnattributedUniqueOutcomeEventsSentByChannel(Set<String> set) {
        this.preferences.saveStringSet(this.preferences.getPreferencesName(), PREFS_OS_UNATTRIBUTED_UNIQUE_OUTCOME_EVENTS_SENT, set);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r0 = r7.logger;
        r1 = "Error closing transaction! ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0049, code lost:
        if (r0 != null) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r7.logger.error("Error closing transaction! ", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0057, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
        r8 = e;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x0024, B:14:0x0034] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void deleteOldOutcomeEvent(com.onesignal.outcomes.model.OSOutcomeEventParams r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            com.onesignal.OneSignalDb r0 = r7.dbHelper     // Catch:{ all -> 0x0058 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getSQLiteDatabaseWithRetries()     // Catch:{ all -> 0x0058 }
            r0.beginTransaction()     // Catch:{ SQLiteException -> 0x0033 }
            java.lang.String r1 = "outcome"
            java.lang.String r2 = "timestamp = ?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0033 }
            r4 = 0
            long r5 = r8.getTimestamp()     // Catch:{ SQLiteException -> 0x0033 }
            java.lang.String r8 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0033 }
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x0033 }
            r0.delete(r1, r2, r3)     // Catch:{ SQLiteException -> 0x0033 }
            r0.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x0033 }
            if (r0 == 0) goto L_0x0047
            r0.endTransaction()     // Catch:{ SQLiteException -> 0x0028 }
            goto L_0x0047
        L_0x0028:
            r8 = move-exception
            com.onesignal.OSLogger r0 = r7.logger     // Catch:{ all -> 0x0058 }
            java.lang.String r1 = "Error closing transaction! "
        L_0x002d:
            r0.error(r1, r8)     // Catch:{ all -> 0x0058 }
            goto L_0x0047
        L_0x0031:
            r8 = move-exception
            goto L_0x0049
        L_0x0033:
            r8 = move-exception
            com.onesignal.OSLogger r1 = r7.logger     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = "Error deleting old outcome event records! "
            r1.error(r2, r8)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0047
            r0.endTransaction()     // Catch:{ SQLiteException -> 0x0041 }
            goto L_0x0047
        L_0x0041:
            r8 = move-exception
            com.onesignal.OSLogger r0 = r7.logger     // Catch:{ all -> 0x0058 }
            java.lang.String r1 = "Error closing transaction! "
            goto L_0x002d
        L_0x0047:
            monitor-exit(r7)
            return
        L_0x0049:
            if (r0 == 0) goto L_0x0057
            r0.endTransaction()     // Catch:{ SQLiteException -> 0x004f }
            goto L_0x0057
        L_0x004f:
            r0 = move-exception
            com.onesignal.OSLogger r1 = r7.logger     // Catch:{ all -> 0x0058 }
            java.lang.String r2 = "Error closing transaction! "
            r1.error(r2, r0)     // Catch:{ all -> 0x0058 }
        L_0x0057:
            throw r8     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.outcomes.OSOutcomeEventsCache.deleteOldOutcomeEvent(com.onesignal.outcomes.model.OSOutcomeEventParams):void");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public synchronized void saveOutcomeEvent(OSOutcomeEventParams oSOutcomeEventParams) {
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        OSInfluenceType oSInfluenceType = OSInfluenceType.UNATTRIBUTED;
        OSInfluenceType oSInfluenceType2 = OSInfluenceType.UNATTRIBUTED;
        if (oSOutcomeEventParams.getOutcomeSource() != null) {
            OSOutcomeSource outcomeSource = oSOutcomeEventParams.getOutcomeSource();
            if (outcomeSource.getDirectBody() != null) {
                OSOutcomeSourceBody directBody = outcomeSource.getDirectBody();
                if (directBody.getNotificationIds() != null && directBody.getNotificationIds().length() > 0) {
                    oSInfluenceType = OSInfluenceType.DIRECT;
                    jSONArray = outcomeSource.getDirectBody().getNotificationIds();
                }
                if (directBody.getInAppMessagesIds() != null && directBody.getInAppMessagesIds().length() > 0) {
                    OSInfluenceType oSInfluenceType3 = OSInfluenceType.DIRECT;
                    oSInfluenceType2 = oSInfluenceType3;
                    jSONArray2 = outcomeSource.getDirectBody().getInAppMessagesIds();
                }
            }
            if (outcomeSource.getIndirectBody() != null) {
                OSOutcomeSourceBody indirectBody = outcomeSource.getIndirectBody();
                if (indirectBody.getNotificationIds() != null && indirectBody.getNotificationIds().length() > 0) {
                    OSInfluenceType oSInfluenceType4 = OSInfluenceType.INDIRECT;
                    oSInfluenceType = oSInfluenceType4;
                    jSONArray = outcomeSource.getIndirectBody().getNotificationIds();
                }
                if (indirectBody.getInAppMessagesIds() != null && indirectBody.getInAppMessagesIds().length() > 0) {
                    oSInfluenceType2 = OSInfluenceType.INDIRECT;
                    jSONArray2 = outcomeSource.getIndirectBody().getInAppMessagesIds();
                }
            }
        }
        SQLiteDatabase sQLiteDatabaseWithRetries = this.dbHelper.getSQLiteDatabaseWithRetries();
        sQLiteDatabaseWithRetries.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("notification_ids", jSONArray.toString());
            contentValues.put("iam_ids", jSONArray2.toString());
            contentValues.put("notification_influence_type", oSInfluenceType.toString().toLowerCase());
            contentValues.put("iam_influence_type", oSInfluenceType2.toString().toLowerCase());
            contentValues.put("name", oSOutcomeEventParams.getOutcomeId());
            contentValues.put("weight", oSOutcomeEventParams.getWeight());
            contentValues.put("timestamp", Long.valueOf(oSOutcomeEventParams.getTimestamp()));
            sQLiteDatabaseWithRetries.insert(OSOutcomeTableProvider.OUTCOME_EVENT_TABLE, (String) null, contentValues);
            sQLiteDatabaseWithRetries.setTransactionSuccessful();
            sQLiteDatabaseWithRetries.endTransaction();
        } catch (SQLException e) {
            this.logger.error("Error closing transaction! ", e);
        } catch (Throwable th) {
            try {
                sQLiteDatabaseWithRetries.endTransaction();
            } catch (SQLException e2) {
                this.logger.error("Error closing transaction! ", e2);
            }
            throw th;
        }
        return;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a9, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b2, code lost:
        switch(r4) {
            case com.onesignal.influence.model.OSInfluenceType.DIRECT :com.onesignal.influence.model.OSInfluenceType: goto L_0x00cb;
            case com.onesignal.influence.model.OSInfluenceType.INDIRECT :com.onesignal.influence.model.OSInfluenceType: goto L_0x00b6;
            case com.onesignal.influence.model.OSInfluenceType.UNATTRIBUTED :com.onesignal.influence.model.OSInfluenceType: goto L_0x00df;
            default: goto L_0x00b5;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b6, code lost:
        r8.setInAppMessagesIds(new org.json.JSONArray(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00be, code lost:
        if (r3 != null) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c0, code lost:
        r3 = new com.onesignal.outcomes.model.OSOutcomeSource((com.onesignal.outcomes.model.OSOutcomeSourceBody) null, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c6, code lost:
        r3 = r3.setIndirectBody(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00cb, code lost:
        r7.setInAppMessagesIds(new org.json.JSONArray(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d3, code lost:
        if (r3 != null) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d5, code lost:
        r3 = new com.onesignal.outcomes.model.OSOutcomeSource(r7, (com.onesignal.outcomes.model.OSOutcomeSourceBody) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00db, code lost:
        r3 = r3.setDirectBody(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00df, code lost:
        r0.add(new com.onesignal.outcomes.model.OSOutcomeEventParams(r9, r3, r11, r12));
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fa A[SYNTHETIC, Splitter:B:43:0x00fa] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x010b A[SYNTHETIC, Splitter:B:53:0x010b] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.onesignal.outcomes.model.OSOutcomeEventParams> getAllEventsToSend() {
        /*
            r14 = this;
            monitor-enter(r14)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0115 }
            r0.<init>()     // Catch:{ all -> 0x0115 }
            r1 = 0
            com.onesignal.OneSignalDb r2 = r14.dbHelper     // Catch:{ all -> 0x0107 }
            android.database.sqlite.SQLiteDatabase r3 = r2.getSQLiteDatabaseWithRetries()     // Catch:{ all -> 0x0107 }
            java.lang.String r4 = "outcome"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0107 }
            boolean r3 = r2.moveToFirst()     // Catch:{ all -> 0x0105 }
            if (r3 == 0) goto L_0x00f8
        L_0x001f:
            java.lang.String r3 = "notification_influence_type"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ all -> 0x0105 }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x0105 }
            com.onesignal.influence.model.OSInfluenceType r3 = com.onesignal.influence.model.OSInfluenceType.fromString(r3)     // Catch:{ all -> 0x0105 }
            java.lang.String r4 = "iam_influence_type"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ all -> 0x0105 }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ all -> 0x0105 }
            com.onesignal.influence.model.OSInfluenceType r4 = com.onesignal.influence.model.OSInfluenceType.fromString(r4)     // Catch:{ all -> 0x0105 }
            java.lang.String r5 = "notification_ids"
            int r5 = r2.getColumnIndex(r5)     // Catch:{ all -> 0x0105 }
            java.lang.String r5 = r2.getString(r5)     // Catch:{ all -> 0x0105 }
            if (r5 == 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            java.lang.String r5 = "[]"
        L_0x004a:
            java.lang.String r6 = "iam_ids"
            int r6 = r2.getColumnIndex(r6)     // Catch:{ all -> 0x0105 }
            java.lang.String r6 = r2.getString(r6)     // Catch:{ all -> 0x0105 }
            if (r6 == 0) goto L_0x0057
            goto L_0x0059
        L_0x0057:
            java.lang.String r6 = "[]"
        L_0x0059:
            java.lang.String r7 = "name"
            int r7 = r2.getColumnIndex(r7)     // Catch:{ all -> 0x0105 }
            java.lang.String r9 = r2.getString(r7)     // Catch:{ all -> 0x0105 }
            java.lang.String r7 = "weight"
            int r7 = r2.getColumnIndex(r7)     // Catch:{ all -> 0x0105 }
            float r11 = r2.getFloat(r7)     // Catch:{ all -> 0x0105 }
            java.lang.String r7 = "timestamp"
            int r7 = r2.getColumnIndex(r7)     // Catch:{ all -> 0x0105 }
            long r12 = r2.getLong(r7)     // Catch:{ all -> 0x0105 }
            com.onesignal.outcomes.model.OSOutcomeSourceBody r7 = new com.onesignal.outcomes.model.OSOutcomeSourceBody     // Catch:{ JSONException -> 0x00ea }
            r7.<init>()     // Catch:{ JSONException -> 0x00ea }
            com.onesignal.outcomes.model.OSOutcomeSourceBody r8 = new com.onesignal.outcomes.model.OSOutcomeSourceBody     // Catch:{ JSONException -> 0x00ea }
            r8.<init>()     // Catch:{ JSONException -> 0x00ea }
            int[] r10 = com.onesignal.outcomes.OSOutcomeEventsCache.C24891.$SwitchMap$com$onesignal$influence$model$OSInfluenceType     // Catch:{ JSONException -> 0x00ea }
            int r3 = r3.ordinal()     // Catch:{ JSONException -> 0x00ea }
            r3 = r10[r3]     // Catch:{ JSONException -> 0x00ea }
            switch(r3) {
                case 1: goto L_0x009b;
                case 2: goto L_0x008d;
                case 3: goto L_0x00a9;
                default: goto L_0x008c;
            }     // Catch:{ JSONException -> 0x00ea }
        L_0x008c:
            goto L_0x00a9
        L_0x008d:
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00ea }
            r3.<init>(r5)     // Catch:{ JSONException -> 0x00ea }
            r8.setNotificationIds(r3)     // Catch:{ JSONException -> 0x00ea }
            com.onesignal.outcomes.model.OSOutcomeSource r3 = new com.onesignal.outcomes.model.OSOutcomeSource     // Catch:{ JSONException -> 0x00ea }
            r3.<init>(r1, r8)     // Catch:{ JSONException -> 0x00ea }
            goto L_0x00aa
        L_0x009b:
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00ea }
            r3.<init>(r5)     // Catch:{ JSONException -> 0x00ea }
            r7.setNotificationIds(r3)     // Catch:{ JSONException -> 0x00ea }
            com.onesignal.outcomes.model.OSOutcomeSource r3 = new com.onesignal.outcomes.model.OSOutcomeSource     // Catch:{ JSONException -> 0x00ea }
            r3.<init>(r7, r1)     // Catch:{ JSONException -> 0x00ea }
            goto L_0x00aa
        L_0x00a9:
            r3 = r1
        L_0x00aa:
            int[] r5 = com.onesignal.outcomes.OSOutcomeEventsCache.C24891.$SwitchMap$com$onesignal$influence$model$OSInfluenceType     // Catch:{ JSONException -> 0x00ea }
            int r4 = r4.ordinal()     // Catch:{ JSONException -> 0x00ea }
            r4 = r5[r4]     // Catch:{ JSONException -> 0x00ea }
            switch(r4) {
                case 1: goto L_0x00cb;
                case 2: goto L_0x00b6;
                case 3: goto L_0x00df;
                default: goto L_0x00b5;
            }     // Catch:{ JSONException -> 0x00ea }
        L_0x00b5:
            goto L_0x00df
        L_0x00b6:
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00ea }
            r4.<init>(r6)     // Catch:{ JSONException -> 0x00ea }
            r8.setInAppMessagesIds(r4)     // Catch:{ JSONException -> 0x00ea }
            if (r3 != 0) goto L_0x00c6
            com.onesignal.outcomes.model.OSOutcomeSource r3 = new com.onesignal.outcomes.model.OSOutcomeSource     // Catch:{ JSONException -> 0x00ea }
            r3.<init>(r1, r8)     // Catch:{ JSONException -> 0x00ea }
            goto L_0x00df
        L_0x00c6:
            com.onesignal.outcomes.model.OSOutcomeSource r3 = r3.setIndirectBody(r8)     // Catch:{ JSONException -> 0x00ea }
            goto L_0x00df
        L_0x00cb:
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00ea }
            r4.<init>(r6)     // Catch:{ JSONException -> 0x00ea }
            r7.setInAppMessagesIds(r4)     // Catch:{ JSONException -> 0x00ea }
            if (r3 != 0) goto L_0x00db
            com.onesignal.outcomes.model.OSOutcomeSource r3 = new com.onesignal.outcomes.model.OSOutcomeSource     // Catch:{ JSONException -> 0x00ea }
            r3.<init>(r7, r1)     // Catch:{ JSONException -> 0x00ea }
            goto L_0x00df
        L_0x00db:
            com.onesignal.outcomes.model.OSOutcomeSource r3 = r3.setDirectBody(r7)     // Catch:{ JSONException -> 0x00ea }
        L_0x00df:
            r10 = r3
            com.onesignal.outcomes.model.OSOutcomeEventParams r3 = new com.onesignal.outcomes.model.OSOutcomeEventParams     // Catch:{ JSONException -> 0x00ea }
            r8 = r3
            r8.<init>(r9, r10, r11, r12)     // Catch:{ JSONException -> 0x00ea }
            r0.add(r3)     // Catch:{ JSONException -> 0x00ea }
            goto L_0x00f2
        L_0x00ea:
            r3 = move-exception
            com.onesignal.OSLogger r4 = r14.logger     // Catch:{ all -> 0x0105 }
            java.lang.String r5 = "Generating JSONArray from notifications ids outcome:JSON Failed."
            r4.error(r5, r3)     // Catch:{ all -> 0x0105 }
        L_0x00f2:
            boolean r3 = r2.moveToNext()     // Catch:{ all -> 0x0105 }
            if (r3 != 0) goto L_0x001f
        L_0x00f8:
            if (r2 == 0) goto L_0x0103
            boolean r1 = r2.isClosed()     // Catch:{ all -> 0x0115 }
            if (r1 != 0) goto L_0x0103
            r2.close()     // Catch:{ all -> 0x0115 }
        L_0x0103:
            monitor-exit(r14)
            return r0
        L_0x0105:
            r0 = move-exception
            goto L_0x0109
        L_0x0107:
            r0 = move-exception
            r2 = r1
        L_0x0109:
            if (r2 == 0) goto L_0x0114
            boolean r1 = r2.isClosed()     // Catch:{ all -> 0x0115 }
            if (r1 != 0) goto L_0x0114
            r2.close()     // Catch:{ all -> 0x0115 }
        L_0x0114:
            throw r0     // Catch:{ all -> 0x0115 }
        L_0x0115:
            r0 = move-exception
            monitor-exit(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.outcomes.OSOutcomeEventsCache.getAllEventsToSend():java.util.List");
    }

    private void addIdToListFromChannel(List<OSCachedUniqueOutcome> list, JSONArray jSONArray, OSInfluenceChannel oSInfluenceChannel) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    list.add(new OSCachedUniqueOutcome(jSONArray.getString(i), oSInfluenceChannel));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void addIdsToListFromSource(List<OSCachedUniqueOutcome> list, OSOutcomeSourceBody oSOutcomeSourceBody) {
        if (oSOutcomeSourceBody != null) {
            JSONArray inAppMessagesIds = oSOutcomeSourceBody.getInAppMessagesIds();
            JSONArray notificationIds = oSOutcomeSourceBody.getNotificationIds();
            addIdToListFromChannel(list, inAppMessagesIds, OSInfluenceChannel.IAM);
            addIdToListFromChannel(list, notificationIds, OSInfluenceChannel.NOTIFICATION);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public synchronized void saveUniqueOutcomeEventParams(@NonNull OSOutcomeEventParams oSOutcomeEventParams) {
        OSLogger oSLogger = this.logger;
        oSLogger.debug("OneSignal saveUniqueOutcomeEventParams: " + oSOutcomeEventParams.toString());
        if (oSOutcomeEventParams.getOutcomeSource() != null) {
            String outcomeId = oSOutcomeEventParams.getOutcomeId();
            ArrayList<OSCachedUniqueOutcome> arrayList = new ArrayList<>();
            OSOutcomeSourceBody directBody = oSOutcomeEventParams.getOutcomeSource().getDirectBody();
            OSOutcomeSourceBody indirectBody = oSOutcomeEventParams.getOutcomeSource().getIndirectBody();
            addIdsToListFromSource(arrayList, directBody);
            addIdsToListFromSource(arrayList, indirectBody);
            SQLiteDatabase sQLiteDatabaseWithRetries = this.dbHelper.getSQLiteDatabaseWithRetries();
            sQLiteDatabaseWithRetries.beginTransaction();
            try {
                for (OSCachedUniqueOutcome oSCachedUniqueOutcome : arrayList) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(OSOutcomeTableProvider.CACHE_UNIQUE_OUTCOME_COLUMN_CHANNEL_INFLUENCE_ID, oSCachedUniqueOutcome.getInfluenceId());
                    contentValues.put(OSOutcomeTableProvider.CACHE_UNIQUE_OUTCOME_COLUMN_CHANNEL_TYPE, String.valueOf(oSCachedUniqueOutcome.getChannel()));
                    contentValues.put("name", outcomeId);
                    sQLiteDatabaseWithRetries.insert(OSOutcomeTableProvider.CACHE_UNIQUE_OUTCOME_TABLE, (String) null, contentValues);
                }
                sQLiteDatabaseWithRetries.setTransactionSuccessful();
                sQLiteDatabaseWithRetries.endTransaction();
            } catch (SQLException e) {
                this.logger.error("Error closing transaction! ", e);
            } catch (Throwable th) {
                try {
                    sQLiteDatabaseWithRetries.endTransaction();
                } catch (SQLException e2) {
                    this.logger.error("Error closing transaction! ", e2);
                }
                throw th;
            }
        } else {
            return;
        }
        return;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009b, code lost:
        if (r3.isClosed() == false) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009d, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00af, code lost:
        if (r3.isClosed() == false) goto L_0x009d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ab A[SYNTHETIC, Splitter:B:40:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b6 A[SYNTHETIC, Splitter:B:46:0x00b6] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.onesignal.influence.model.OSInfluence> getNotCachedUniqueInfluencesForOutcome(java.lang.String r22, java.util.List<com.onesignal.influence.model.OSInfluence> r23) {
        /*
            r21 = this;
            r1 = r21
            monitor-enter(r21)
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00c0 }
            r2.<init>()     // Catch:{ all -> 0x00c0 }
            com.onesignal.OneSignalDb r0 = r1.dbHelper     // Catch:{ all -> 0x00c0 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getSQLiteDatabaseWithRetries()     // Catch:{ all -> 0x00c0 }
            r3 = 0
            java.util.Iterator r12 = r23.iterator()     // Catch:{ JSONException -> 0x00a5 }
        L_0x0013:
            boolean r4 = r12.hasNext()     // Catch:{ JSONException -> 0x00a5 }
            if (r4 == 0) goto L_0x0095
            java.lang.Object r4 = r12.next()     // Catch:{ JSONException -> 0x00a5 }
            r13 = r4
            com.onesignal.influence.model.OSInfluence r13 = (com.onesignal.influence.model.OSInfluence) r13     // Catch:{ JSONException -> 0x00a5 }
            org.json.JSONArray r14 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00a5 }
            r14.<init>()     // Catch:{ JSONException -> 0x00a5 }
            org.json.JSONArray r15 = r13.getIds()     // Catch:{ JSONException -> 0x00a5 }
            if (r15 != 0) goto L_0x002c
            goto L_0x0013
        L_0x002c:
            r11 = 0
            r16 = r3
            r10 = 0
        L_0x0030:
            int r3 = r15.length()     // Catch:{ JSONException -> 0x0091, all -> 0x008f }
            if (r10 >= r3) goto L_0x007c
            java.lang.String r9 = r15.getString(r10)     // Catch:{ JSONException -> 0x0091, all -> 0x008f }
            com.onesignal.influence.model.OSInfluenceChannel r3 = r13.getInfluenceChannel()     // Catch:{ JSONException -> 0x0091, all -> 0x008f }
            java.lang.String[] r5 = new java.lang.String[r11]     // Catch:{ JSONException -> 0x0091, all -> 0x008f }
            java.lang.String r6 = "channel_influence_id = ? AND channel_type = ? AND name = ?"
            r4 = 3
            java.lang.String[] r7 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x0091, all -> 0x008f }
            r7[r11] = r9     // Catch:{ JSONException -> 0x0091, all -> 0x008f }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ JSONException -> 0x0091, all -> 0x008f }
            r4 = 1
            r7[r4] = r3     // Catch:{ JSONException -> 0x0091, all -> 0x008f }
            r3 = 2
            r7[r3] = r22     // Catch:{ JSONException -> 0x0091, all -> 0x008f }
            java.lang.String r4 = "cached_unique_outcome"
            r8 = 0
            r17 = 0
            r18 = 0
            java.lang.String r19 = "1"
            r3 = r0
            r20 = r9
            r9 = r17
            r17 = r10
            r10 = r18
            r18 = 0
            r11 = r19
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ JSONException -> 0x0091, all -> 0x008f }
            int r4 = r3.getCount()     // Catch:{ JSONException -> 0x00a5 }
            if (r4 != 0) goto L_0x0076
            r4 = r20
            r14.put(r4)     // Catch:{ JSONException -> 0x00a5 }
        L_0x0076:
            int r10 = r17 + 1
            r16 = r3
            r11 = 0
            goto L_0x0030
        L_0x007c:
            int r3 = r14.length()     // Catch:{ JSONException -> 0x0091, all -> 0x008f }
            if (r3 <= 0) goto L_0x008c
            com.onesignal.influence.model.OSInfluence r3 = r13.copy()     // Catch:{ JSONException -> 0x0091, all -> 0x008f }
            r3.setIds(r14)     // Catch:{ JSONException -> 0x0091, all -> 0x008f }
            r2.add(r3)     // Catch:{ JSONException -> 0x0091, all -> 0x008f }
        L_0x008c:
            r3 = r16
            goto L_0x0013
        L_0x008f:
            r0 = move-exception
            goto L_0x00b4
        L_0x0091:
            r0 = move-exception
            r3 = r16
            goto L_0x00a6
        L_0x0095:
            if (r3 == 0) goto L_0x00b2
            boolean r0 = r3.isClosed()     // Catch:{ all -> 0x00c0 }
            if (r0 != 0) goto L_0x00b2
        L_0x009d:
            r3.close()     // Catch:{ all -> 0x00c0 }
            goto L_0x00b2
        L_0x00a1:
            r0 = move-exception
            r16 = r3
            goto L_0x00b4
        L_0x00a5:
            r0 = move-exception
        L_0x00a6:
            r0.printStackTrace()     // Catch:{ all -> 0x00a1 }
            if (r3 == 0) goto L_0x00b2
            boolean r0 = r3.isClosed()     // Catch:{ all -> 0x00c0 }
            if (r0 != 0) goto L_0x00b2
            goto L_0x009d
        L_0x00b2:
            monitor-exit(r21)
            return r2
        L_0x00b4:
            if (r16 == 0) goto L_0x00bf
            boolean r2 = r16.isClosed()     // Catch:{ all -> 0x00c0 }
            if (r2 != 0) goto L_0x00bf
            r16.close()     // Catch:{ all -> 0x00c0 }
        L_0x00bf:
            throw r0     // Catch:{ all -> 0x00c0 }
        L_0x00c0:
            r0 = move-exception
            monitor-exit(r21)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.outcomes.OSOutcomeEventsCache.getNotCachedUniqueInfluencesForOutcome(java.lang.String, java.util.List):java.util.List");
    }
}
