package com.onesignal;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.WorkerThread;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalDbContract;
import java.util.Set;

class OSInAppMessageRepository {
    static final long IAM_CACHE_DATA_LIFETIME = 15552000;
    private final OneSignalDbHelper dbHelper;

    OSInAppMessageRepository(OneSignalDbHelper oneSignalDbHelper) {
        this.dbHelper = oneSignalDbHelper;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public synchronized void saveInAppMessage(OSInAppMessage oSInAppMessage) {
        SQLiteDatabase sQLiteDatabaseWithRetries = this.dbHelper.getSQLiteDatabaseWithRetries();
        sQLiteDatabaseWithRetries.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(OneSignalDbContract.InAppMessageTable.COLUMN_NAME_MESSAGE_ID, oSInAppMessage.messageId);
            contentValues.put(OneSignalDbContract.InAppMessageTable.COLUMN_NAME_DISPLAY_QUANTITY, Integer.valueOf(oSInAppMessage.getRedisplayStats().getDisplayQuantity()));
            contentValues.put(OneSignalDbContract.InAppMessageTable.COLUMN_NAME_LAST_DISPLAY, Long.valueOf(oSInAppMessage.getRedisplayStats().getLastDisplayTime()));
            contentValues.put(OneSignalDbContract.InAppMessageTable.COLUMN_CLICK_IDS, oSInAppMessage.getClickedClickIds().toString());
            contentValues.put(OneSignalDbContract.InAppMessageTable.COLUMN_DISPLAYED_IN_SESSION, Boolean.valueOf(oSInAppMessage.isDisplayedInSession()));
            if (sQLiteDatabaseWithRetries.update(OneSignalDbContract.InAppMessageTable.TABLE_NAME, contentValues, "message_id = ?", new String[]{oSInAppMessage.messageId}) == 0) {
                sQLiteDatabaseWithRetries.insert(OneSignalDbContract.InAppMessageTable.TABLE_NAME, (String) null, contentValues);
            }
            sQLiteDatabaseWithRetries.setTransactionSuccessful();
            sQLiteDatabaseWithRetries.endTransaction();
        } catch (SQLException e) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error closing transaction! ", e);
        } catch (Throwable th) {
            try {
                sQLiteDatabaseWithRetries.endTransaction();
            } catch (SQLException e2) {
                OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error closing transaction! ", e2);
            }
            throw th;
        }
        return;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0078, code lost:
        if (r2.isClosed() == false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007a, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0094, code lost:
        if (r2.isClosed() == false) goto L_0x007a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0090 A[SYNTHETIC, Splitter:B:28:0x0090] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009c A[SYNTHETIC, Splitter:B:35:0x009c] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.onesignal.OSInAppMessage> getCachedInAppMessages() {
        /*
            r12 = this;
            monitor-enter(r12)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00a6 }
            r0.<init>()     // Catch:{ all -> 0x00a6 }
            r1 = 0
            com.onesignal.OneSignalDbHelper r2 = r12.dbHelper     // Catch:{ JSONException -> 0x0083, all -> 0x0080 }
            android.database.sqlite.SQLiteDatabase r3 = r2.getSQLiteDatabaseWithRetries()     // Catch:{ JSONException -> 0x0083, all -> 0x0080 }
            java.lang.String r4 = "in_app_message"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ JSONException -> 0x0083, all -> 0x0080 }
            boolean r1 = r2.moveToFirst()     // Catch:{ JSONException -> 0x007e }
            if (r1 == 0) goto L_0x0072
        L_0x001f:
            java.lang.String r1 = "message_id"
            int r1 = r2.getColumnIndex(r1)     // Catch:{ JSONException -> 0x007e }
            java.lang.String r1 = r2.getString(r1)     // Catch:{ JSONException -> 0x007e }
            java.lang.String r3 = "click_ids"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ JSONException -> 0x007e }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ JSONException -> 0x007e }
            java.lang.String r4 = "display_quantity"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ JSONException -> 0x007e }
            int r4 = r2.getInt(r4)     // Catch:{ JSONException -> 0x007e }
            java.lang.String r5 = "last_display"
            int r5 = r2.getColumnIndex(r5)     // Catch:{ JSONException -> 0x007e }
            long r5 = r2.getLong(r5)     // Catch:{ JSONException -> 0x007e }
            java.lang.String r7 = "displayed_in_session"
            int r7 = r2.getColumnIndex(r7)     // Catch:{ JSONException -> 0x007e }
            int r7 = r2.getInt(r7)     // Catch:{ JSONException -> 0x007e }
            r8 = 1
            if (r7 != r8) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r8 = 0
        L_0x0056:
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch:{ JSONException -> 0x007e }
            r7.<init>(r3)     // Catch:{ JSONException -> 0x007e }
            java.util.Set r3 = com.onesignal.OSUtils.newStringSetFromJSONArray(r7)     // Catch:{ JSONException -> 0x007e }
            com.onesignal.OSInAppMessage r7 = new com.onesignal.OSInAppMessage     // Catch:{ JSONException -> 0x007e }
            com.onesignal.OSInAppMessageRedisplayStats r9 = new com.onesignal.OSInAppMessageRedisplayStats     // Catch:{ JSONException -> 0x007e }
            r9.<init>(r4, r5)     // Catch:{ JSONException -> 0x007e }
            r7.<init>(r1, r3, r8, r9)     // Catch:{ JSONException -> 0x007e }
            r0.add(r7)     // Catch:{ JSONException -> 0x007e }
            boolean r1 = r2.moveToNext()     // Catch:{ JSONException -> 0x007e }
            if (r1 != 0) goto L_0x001f
        L_0x0072:
            if (r2 == 0) goto L_0x0097
            boolean r1 = r2.isClosed()     // Catch:{ all -> 0x00a6 }
            if (r1 != 0) goto L_0x0097
        L_0x007a:
            r2.close()     // Catch:{ all -> 0x00a6 }
            goto L_0x0097
        L_0x007e:
            r1 = move-exception
            goto L_0x0087
        L_0x0080:
            r0 = move-exception
            r2 = r1
            goto L_0x009a
        L_0x0083:
            r2 = move-exception
            r11 = r2
            r2 = r1
            r1 = r11
        L_0x0087:
            com.onesignal.OneSignal$LOG_LEVEL r3 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ all -> 0x0099 }
            java.lang.String r4 = "Generating JSONArray from iam click ids:JSON Failed."
            com.onesignal.OneSignal.Log(r3, r4, r1)     // Catch:{ all -> 0x0099 }
            if (r2 == 0) goto L_0x0097
            boolean r1 = r2.isClosed()     // Catch:{ all -> 0x00a6 }
            if (r1 != 0) goto L_0x0097
            goto L_0x007a
        L_0x0097:
            monitor-exit(r12)
            return r0
        L_0x0099:
            r0 = move-exception
        L_0x009a:
            if (r2 == 0) goto L_0x00a5
            boolean r1 = r2.isClosed()     // Catch:{ all -> 0x00a6 }
            if (r1 != 0) goto L_0x00a5
            r2.close()     // Catch:{ all -> 0x00a6 }
        L_0x00a5:
            throw r0     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OSInAppMessageRepository.getCachedInAppMessages():java.util.List");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0097, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a1 A[SYNTHETIC, Splitter:B:38:0x00a1] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void cleanCachedInAppMessages() {
        /*
            r14 = this;
            monitor-enter(r14)
            com.onesignal.OneSignalDbHelper r0 = r14.dbHelper     // Catch:{ all -> 0x00e3 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getSQLiteDatabaseWithRetries()     // Catch:{ all -> 0x00e3 }
            java.lang.String r1 = "message_id"
            java.lang.String r2 = "click_ids"
            java.lang.String[] r3 = new java.lang.String[]{r1, r2}     // Catch:{ all -> 0x00e3 }
            java.lang.String r9 = "last_display < ?"
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00e3 }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r4
            r4 = 15552000(0xed4e00, double:7.683709E-317)
            long r1 = r1 - r4
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x00e3 }
            r2 = 1
            java.lang.String[] r10 = new java.lang.String[r2]     // Catch:{ all -> 0x00e3 }
            r2 = 0
            r10[r2] = r1     // Catch:{ all -> 0x00e3 }
            java.util.Set r11 = com.onesignal.OSUtils.newConcurrentSet()     // Catch:{ all -> 0x00e3 }
            java.util.Set r12 = com.onesignal.OSUtils.newConcurrentSet()     // Catch:{ all -> 0x00e3 }
            r13 = 0
            java.lang.String r2 = "in_app_message"
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r0
            r4 = r9
            r5 = r10
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ JSONException -> 0x009b }
            if (r1 == 0) goto L_0x0084
            int r2 = r1.getCount()     // Catch:{ JSONException -> 0x0081, all -> 0x007f }
            if (r2 != 0) goto L_0x0044
            goto L_0x0084
        L_0x0044:
            boolean r2 = r1.moveToFirst()     // Catch:{ JSONException -> 0x0081, all -> 0x007f }
            if (r2 == 0) goto L_0x0073
        L_0x004a:
            java.lang.String r2 = "message_id"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ JSONException -> 0x0081, all -> 0x007f }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ JSONException -> 0x0081, all -> 0x007f }
            java.lang.String r3 = "click_ids"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ JSONException -> 0x0081, all -> 0x007f }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ JSONException -> 0x0081, all -> 0x007f }
            r11.add(r2)     // Catch:{ JSONException -> 0x0081, all -> 0x007f }
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0081, all -> 0x007f }
            r2.<init>(r3)     // Catch:{ JSONException -> 0x0081, all -> 0x007f }
            java.util.Set r2 = com.onesignal.OSUtils.newStringSetFromJSONArray(r2)     // Catch:{ JSONException -> 0x0081, all -> 0x007f }
            r12.addAll(r2)     // Catch:{ JSONException -> 0x0081, all -> 0x007f }
            boolean r2 = r1.moveToNext()     // Catch:{ JSONException -> 0x0081, all -> 0x007f }
            if (r2 != 0) goto L_0x004a
        L_0x0073:
            if (r1 == 0) goto L_0x00aa
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x00e3 }
            if (r2 != 0) goto L_0x00aa
            r1.close()     // Catch:{ all -> 0x00e3 }
            goto L_0x00aa
        L_0x007f:
            r0 = move-exception
            goto L_0x00d7
        L_0x0081:
            r2 = move-exception
            r13 = r1
            goto L_0x009c
        L_0x0084:
            com.onesignal.OneSignal$LOG_LEVEL r2 = com.onesignal.OneSignal.LOG_LEVEL.DEBUG     // Catch:{ JSONException -> 0x0081, all -> 0x007f }
            java.lang.String r3 = "Attempted to clean 6 month old IAM data, but none exists!"
            com.onesignal.OneSignal.onesignalLog(r2, r3)     // Catch:{ JSONException -> 0x0081, all -> 0x007f }
            if (r1 == 0) goto L_0x0096
            boolean r0 = r1.isClosed()     // Catch:{ all -> 0x00e3 }
            if (r0 != 0) goto L_0x0096
            r1.close()     // Catch:{ all -> 0x00e3 }
        L_0x0096:
            monitor-exit(r14)
            return
        L_0x0098:
            r0 = move-exception
            r1 = r13
            goto L_0x00d7
        L_0x009b:
            r2 = move-exception
        L_0x009c:
            r2.printStackTrace()     // Catch:{ all -> 0x0098 }
            if (r13 == 0) goto L_0x00aa
            boolean r1 = r13.isClosed()     // Catch:{ all -> 0x00e3 }
            if (r1 != 0) goto L_0x00aa
            r13.close()     // Catch:{ all -> 0x00e3 }
        L_0x00aa:
            r0.beginTransaction()     // Catch:{ all -> 0x00e3 }
            java.lang.String r1 = "in_app_message"
            r0.delete(r1, r9, r10)     // Catch:{ all -> 0x00c9 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x00c9 }
            r0.endTransaction()     // Catch:{ SQLException -> 0x00b9 }
            goto L_0x00c1
        L_0x00b9:
            r0 = move-exception
            com.onesignal.OneSignal$LOG_LEVEL r1 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ all -> 0x00e3 }
            java.lang.String r2 = "Error closing transaction! "
            com.onesignal.OneSignal.Log(r1, r2, r0)     // Catch:{ all -> 0x00e3 }
        L_0x00c1:
            r14.cleanInAppMessageIds(r11)     // Catch:{ all -> 0x00e3 }
            r14.cleanInAppMessageClickedClickIds(r12)     // Catch:{ all -> 0x00e3 }
            monitor-exit(r14)
            return
        L_0x00c9:
            r1 = move-exception
            r0.endTransaction()     // Catch:{ SQLException -> 0x00ce }
            goto L_0x00d6
        L_0x00ce:
            r0 = move-exception
            com.onesignal.OneSignal$LOG_LEVEL r2 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ all -> 0x00e3 }
            java.lang.String r3 = "Error closing transaction! "
            com.onesignal.OneSignal.Log(r2, r3, r0)     // Catch:{ all -> 0x00e3 }
        L_0x00d6:
            throw r1     // Catch:{ all -> 0x00e3 }
        L_0x00d7:
            if (r1 == 0) goto L_0x00e2
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x00e3 }
            if (r2 != 0) goto L_0x00e2
            r1.close()     // Catch:{ all -> 0x00e3 }
        L_0x00e2:
            throw r0     // Catch:{ all -> 0x00e3 }
        L_0x00e3:
            r0 = move-exception
            monitor-exit(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OSInAppMessageRepository.cleanCachedInAppMessages():void");
    }

    private void cleanInAppMessageIds(Set<String> set) {
        if (set != null && set.size() > 0) {
            Set<String> stringSet = OneSignalPrefs.getStringSet(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_DISMISSED_IAMS, (Set<String>) null);
            Set<String> stringSet2 = OneSignalPrefs.getStringSet(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_IMPRESSIONED_IAMS, (Set<String>) null);
            if (stringSet != null && stringSet.size() > 0) {
                stringSet.removeAll(set);
                OneSignalPrefs.saveStringSet(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_DISMISSED_IAMS, stringSet);
            }
            if (stringSet2 != null && stringSet2.size() > 0) {
                stringSet2.removeAll(set);
                OneSignalPrefs.saveStringSet(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_IMPRESSIONED_IAMS, stringSet2);
            }
        }
    }

    private void cleanInAppMessageClickedClickIds(Set<String> set) {
        Set<String> stringSet;
        if (set != null && set.size() > 0 && (stringSet = OneSignalPrefs.getStringSet(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_CLICKED_CLICK_IDS_IAMS, (Set<String>) null)) != null && stringSet.size() > 0) {
            stringSet.removeAll(set);
            OneSignalPrefs.saveStringSet(OneSignalPrefs.PREFS_ONESIGNAL, OneSignalPrefs.PREFS_OS_CLICKED_CLICK_IDS_IAMS, stringSet);
        }
    }
}
