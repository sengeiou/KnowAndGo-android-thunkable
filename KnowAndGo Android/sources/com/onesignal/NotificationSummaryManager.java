package com.onesignal;

import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalDbContract;
import org.json.JSONException;
import org.json.JSONObject;

class NotificationSummaryManager {
    NotificationSummaryManager() {
    }

    static void updatePossibleDependentSummaryOnDismiss(Context context, SQLiteDatabase sQLiteDatabase, int i) {
        String[] strArr = {OneSignalDbContract.NotificationTable.COLUMN_NAME_GROUP_ID};
        Cursor query = sQLiteDatabase.query(OneSignalDbContract.NotificationTable.TABLE_NAME, strArr, "android_notification_id = " + i, (String[]) null, (String) null, (String) null, (String) null);
        if (query.moveToFirst()) {
            String string = query.getString(query.getColumnIndex(OneSignalDbContract.NotificationTable.COLUMN_NAME_GROUP_ID));
            query.close();
            if (string != null) {
                updateSummaryNotificationAfterChildRemoved(context, sQLiteDatabase, string, true);
                return;
            }
            return;
        }
        query.close();
    }

    static void updateSummaryNotificationAfterChildRemoved(Context context, SQLiteDatabase sQLiteDatabase, String str, boolean z) {
        try {
            Cursor internalUpdateSummaryNotificationAfterChildRemoved = internalUpdateSummaryNotificationAfterChildRemoved(context, sQLiteDatabase, str, z);
            if (internalUpdateSummaryNotificationAfterChildRemoved != null && !internalUpdateSummaryNotificationAfterChildRemoved.isClosed()) {
                internalUpdateSummaryNotificationAfterChildRemoved.close();
            }
        } catch (Throwable th) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error running updateSummaryNotificationAfterChildRemoved!", th);
        }
    }

    private static Cursor internalUpdateSummaryNotificationAfterChildRemoved(Context context, SQLiteDatabase sQLiteDatabase, String str, boolean z) {
        Cursor query = sQLiteDatabase.query(OneSignalDbContract.NotificationTable.TABLE_NAME, new String[]{OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID, OneSignalDbContract.NotificationTable.COLUMN_NAME_CREATED_TIME}, "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0", new String[]{str}, (String) null, (String) null, "_id DESC");
        int count = query.getCount();
        if (count == 0) {
            query.close();
            Integer summaryNotificationId = getSummaryNotificationId(sQLiteDatabase, str);
            if (summaryNotificationId == null) {
                return query;
            }
            OneSignalNotificationManager.getNotificationManager(context).cancel(summaryNotificationId.intValue());
            ContentValues contentValues = new ContentValues();
            contentValues.put(z ? "dismissed" : OneSignalDbContract.NotificationTable.COLUMN_NAME_OPENED, 1);
            sQLiteDatabase.update(OneSignalDbContract.NotificationTable.TABLE_NAME, contentValues, "android_notification_id = " + summaryNotificationId, (String[]) null);
            return query;
        } else if (count == 1) {
            query.close();
            if (getSummaryNotificationId(sQLiteDatabase, str) == null) {
                return query;
            }
            restoreSummary(context, str);
            return query;
        } else {
            try {
                query.moveToFirst();
                Long valueOf = Long.valueOf(query.getLong(query.getColumnIndex(OneSignalDbContract.NotificationTable.COLUMN_NAME_CREATED_TIME)));
                query.close();
                if (getSummaryNotificationId(sQLiteDatabase, str) == null) {
                    return query;
                }
                NotificationGenerationJob notificationGenerationJob = new NotificationGenerationJob(context);
                notificationGenerationJob.restoring = true;
                notificationGenerationJob.shownTimeStamp = valueOf;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("grp", str);
                notificationGenerationJob.jsonPayload = jSONObject;
                GenerateNotification.updateSummaryNotification(notificationGenerationJob);
                return query;
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void restoreSummary(android.content.Context r10, java.lang.String r11) {
        /*
            com.onesignal.OneSignalDbHelper r0 = com.onesignal.OneSignalDbHelper.getInstance(r10)
            r1 = 1
            java.lang.String[] r6 = new java.lang.String[r1]
            r1 = 0
            r6[r1] = r11
            r11 = 0
            android.database.sqlite.SQLiteDatabase r2 = r0.getSQLiteDatabaseWithRetries()     // Catch:{ Throwable -> 0x0033 }
            java.lang.String r3 = "notification"
            java.lang.String[] r4 = com.onesignal.NotificationRestorer.COLUMNS_FOR_RESTORE     // Catch:{ Throwable -> 0x0033 }
            java.lang.String r5 = "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0"
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r0 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Throwable -> 0x0033 }
            com.onesignal.NotificationRestorer.showNotificationsFromCursor(r10, r0, r1)     // Catch:{ Throwable -> 0x002e, all -> 0x002b }
            if (r0 == 0) goto L_0x0046
            boolean r10 = r0.isClosed()
            if (r10 != 0) goto L_0x0046
            r0.close()
            goto L_0x0046
        L_0x002b:
            r10 = move-exception
            r11 = r0
            goto L_0x0047
        L_0x002e:
            r10 = move-exception
            r11 = r0
            goto L_0x0034
        L_0x0031:
            r10 = move-exception
            goto L_0x0047
        L_0x0033:
            r10 = move-exception
        L_0x0034:
            com.onesignal.OneSignal$LOG_LEVEL r0 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ all -> 0x0031 }
            java.lang.String r1 = "Error restoring notification records! "
            com.onesignal.OneSignal.Log(r0, r1, r10)     // Catch:{ all -> 0x0031 }
            if (r11 == 0) goto L_0x0046
            boolean r10 = r11.isClosed()
            if (r10 != 0) goto L_0x0046
            r11.close()
        L_0x0046:
            return
        L_0x0047:
            if (r11 == 0) goto L_0x0052
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto L_0x0052
            r11.close()
        L_0x0052:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.NotificationSummaryManager.restoreSummary(android.content.Context, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        r11 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0052, code lost:
        r8 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0054, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0055, code lost:
        r8 = r10;
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007b, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return r10;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x0019] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.Integer getSummaryNotificationId(android.database.sqlite.SQLiteDatabase r10, java.lang.String r11) {
        /*
            java.lang.String r3 = "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 1"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]
            r0 = 0
            r4[r0] = r11
            r8 = 0
            java.lang.String r1 = "notification"
            java.lang.String r0 = "android_notification_id"
            java.lang.String[] r2 = new java.lang.String[]{r0}     // Catch:{ Throwable -> 0x005b }
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r10
            android.database.Cursor r10 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Throwable -> 0x005b }
            boolean r0 = r10.moveToFirst()     // Catch:{ Throwable -> 0x0054, all -> 0x0051 }
            if (r0 != 0) goto L_0x002e
            r10.close()     // Catch:{ Throwable -> 0x0054, all -> 0x0051 }
            if (r10 == 0) goto L_0x002d
            boolean r11 = r10.isClosed()
            if (r11 != 0) goto L_0x002d
            r10.close()
        L_0x002d:
            return r8
        L_0x002e:
            java.lang.String r0 = "android_notification_id"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Throwable -> 0x0054, all -> 0x0051 }
            int r0 = r10.getInt(r0)     // Catch:{ Throwable -> 0x0054, all -> 0x0051 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Throwable -> 0x0054, all -> 0x0051 }
            r10.close()     // Catch:{ Throwable -> 0x004c, all -> 0x0051 }
            if (r10 == 0) goto L_0x004a
            boolean r11 = r10.isClosed()
            if (r11 != 0) goto L_0x004a
            r10.close()
        L_0x004a:
            r10 = r0
            goto L_0x007e
        L_0x004c:
            r1 = move-exception
            r8 = r10
            r10 = r0
            r0 = r1
            goto L_0x005d
        L_0x0051:
            r11 = move-exception
            r8 = r10
            goto L_0x007f
        L_0x0054:
            r0 = move-exception
            r9 = r8
            r8 = r10
            r10 = r9
            goto L_0x005d
        L_0x0059:
            r11 = move-exception
            goto L_0x007f
        L_0x005b:
            r0 = move-exception
            r10 = r8
        L_0x005d:
            com.onesignal.OneSignal$LOG_LEVEL r1 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ all -> 0x0059 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0059 }
            r2.<init>()     // Catch:{ all -> 0x0059 }
            java.lang.String r3 = "Error getting android notification id for summary notification group: "
            r2.append(r3)     // Catch:{ all -> 0x0059 }
            r2.append(r11)     // Catch:{ all -> 0x0059 }
            java.lang.String r11 = r2.toString()     // Catch:{ all -> 0x0059 }
            com.onesignal.OneSignal.Log(r1, r11, r0)     // Catch:{ all -> 0x0059 }
            if (r8 == 0) goto L_0x007e
            boolean r11 = r8.isClosed()
            if (r11 != 0) goto L_0x007e
            r8.close()
        L_0x007e:
            return r10
        L_0x007f:
            if (r8 == 0) goto L_0x008a
            boolean r10 = r8.isClosed()
            if (r10 != 0) goto L_0x008a
            r8.close()
        L_0x008a:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.NotificationSummaryManager.getSummaryNotificationId(android.database.sqlite.SQLiteDatabase, java.lang.String):java.lang.Integer");
    }

    static void clearNotificationOnSummaryClick(Context context, SQLiteDatabase sQLiteDatabase, String str) {
        Integer summaryNotificationId = getSummaryNotificationId(sQLiteDatabase, str);
        boolean equals = str.equals(OneSignalNotificationManager.getGrouplessSummaryKey());
        NotificationManager notificationManager = OneSignalNotificationManager.getNotificationManager(context);
        Integer mostRecentNotifIdFromGroup = OneSignalNotificationManager.getMostRecentNotifIdFromGroup(sQLiteDatabase, str, equals);
        if (mostRecentNotifIdFromGroup == null) {
            return;
        }
        if (OneSignal.getClearGroupSummaryClick()) {
            if (equals) {
                summaryNotificationId = Integer.valueOf(OneSignalNotificationManager.getGrouplessSummaryId());
            }
            if (summaryNotificationId != null) {
                notificationManager.cancel(summaryNotificationId.intValue());
                return;
            }
            return;
        }
        OneSignal.cancelNotification(mostRecentNotifIdFromGroup.intValue());
    }
}
