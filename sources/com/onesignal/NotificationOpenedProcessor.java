package com.onesignal;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalDbContract;
import org.json.JSONArray;
import org.json.JSONObject;

class NotificationOpenedProcessor {
    private static final String TAG = NotificationOpenedProcessor.class.getCanonicalName();

    NotificationOpenedProcessor() {
    }

    static void processFromContext(Context context, Intent intent) {
        if (isOneSignalIntent(intent)) {
            OneSignal.setAppContext(context);
            handleDismissFromActionButtonPress(context, intent);
            processIntent(context, intent);
        }
    }

    private static boolean isOneSignalIntent(Intent intent) {
        return intent.hasExtra(GenerateNotification.BUNDLE_KEY_ONESIGNAL_DATA) || intent.hasExtra("summary") || intent.hasExtra(GenerateNotification.BUNDLE_KEY_ANDROID_NOTIFICATION_ID);
    }

    private static void handleDismissFromActionButtonPress(Context context, Intent intent) {
        if (intent.getBooleanExtra("action_button", false)) {
            NotificationManagerCompat.from(context).cancel(intent.getIntExtra(GenerateNotification.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, 0));
            context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0078 A[SYNTHETIC, Splitter:B:29:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008e A[SYNTHETIC, Splitter:B:40:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ac A[SYNTHETIC, Splitter:B:47:0x00ac] */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void processIntent(android.content.Context r8, android.content.Intent r9) {
        /*
            java.lang.String r0 = "summary"
            java.lang.String r0 = r9.getStringExtra(r0)
            java.lang.String r1 = "dismissed"
            r2 = 0
            boolean r1 = r9.getBooleanExtra(r1, r2)
            r3 = 0
            if (r1 != 0) goto L_0x004f
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0048 }
            java.lang.String r5 = "onesignalData"
            java.lang.String r5 = r9.getStringExtra(r5)     // Catch:{ Throwable -> 0x0048 }
            r4.<init>(r5)     // Catch:{ Throwable -> 0x0048 }
            boolean r5 = handleIAMPreviewOpen(r8, r4)     // Catch:{ Throwable -> 0x0046 }
            if (r5 == 0) goto L_0x0022
            return
        L_0x0022:
            java.lang.String r5 = "androidNotificationId"
            java.lang.String r6 = "androidNotificationId"
            int r6 = r9.getIntExtra(r6, r2)     // Catch:{ Throwable -> 0x0046 }
            r4.put(r5, r6)     // Catch:{ Throwable -> 0x0046 }
            java.lang.String r5 = "onesignalData"
            java.lang.String r6 = r4.toString()     // Catch:{ Throwable -> 0x0046 }
            r9.putExtra(r5, r6)     // Catch:{ Throwable -> 0x0046 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0046 }
            java.lang.String r6 = "onesignalData"
            java.lang.String r6 = r9.getStringExtra(r6)     // Catch:{ Throwable -> 0x0046 }
            r5.<init>(r6)     // Catch:{ Throwable -> 0x0046 }
            org.json.JSONArray r5 = com.onesignal.NotificationBundleProcessor.newJsonArray(r5)     // Catch:{ Throwable -> 0x0046 }
            goto L_0x0051
        L_0x0046:
            r5 = move-exception
            goto L_0x004a
        L_0x0048:
            r5 = move-exception
            r4 = r3
        L_0x004a:
            r5.printStackTrace()
            r5 = r3
            goto L_0x0051
        L_0x004f:
            r4 = r3
            r5 = r4
        L_0x0051:
            com.onesignal.OneSignalDbHelper r6 = com.onesignal.OneSignalDbHelper.getInstance(r8)
            android.database.sqlite.SQLiteDatabase r6 = r6.getSQLiteDatabaseWithRetries()     // Catch:{ Exception -> 0x0084 }
            r6.beginTransaction()     // Catch:{ Exception -> 0x007e, all -> 0x007c }
            if (r1 != 0) goto L_0x0063
            if (r0 == 0) goto L_0x0063
            addChildNotifications(r5, r0, r6)     // Catch:{ Exception -> 0x007e, all -> 0x007c }
        L_0x0063:
            markNotificationsConsumed(r8, r9, r6, r1)     // Catch:{ Exception -> 0x007e, all -> 0x007c }
            if (r0 != 0) goto L_0x0073
            java.lang.String r0 = "grp"
            java.lang.String r0 = r9.getStringExtra(r0)     // Catch:{ Exception -> 0x007e, all -> 0x007c }
            if (r0 == 0) goto L_0x0073
            com.onesignal.NotificationSummaryManager.updateSummaryNotificationAfterChildRemoved(r8, r6, r0, r1)     // Catch:{ Exception -> 0x007e, all -> 0x007c }
        L_0x0073:
            r6.setTransactionSuccessful()     // Catch:{ Exception -> 0x007e, all -> 0x007c }
            if (r6 == 0) goto L_0x009a
            r6.endTransaction()     // Catch:{ Throwable -> 0x0092 }
            goto L_0x009a
        L_0x007c:
            r8 = move-exception
            goto L_0x00aa
        L_0x007e:
            r0 = move-exception
            r3 = r6
            goto L_0x0085
        L_0x0081:
            r8 = move-exception
            r6 = r3
            goto L_0x00aa
        L_0x0084:
            r0 = move-exception
        L_0x0085:
            com.onesignal.OneSignal$LOG_LEVEL r6 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ all -> 0x0081 }
            java.lang.String r7 = "Error processing notification open or dismiss record! "
            com.onesignal.OneSignal.Log(r6, r7, r0)     // Catch:{ all -> 0x0081 }
            if (r3 == 0) goto L_0x009a
            r3.endTransaction()     // Catch:{ Throwable -> 0x0092 }
            goto L_0x009a
        L_0x0092:
            r0 = move-exception
            com.onesignal.OneSignal$LOG_LEVEL r3 = com.onesignal.OneSignal.LOG_LEVEL.ERROR
            java.lang.String r6 = "Error closing transaction! "
            com.onesignal.OneSignal.Log(r3, r6, r0)
        L_0x009a:
            if (r1 != 0) goto L_0x00a9
            java.lang.String r0 = "from_alert"
            boolean r9 = r9.getBooleanExtra(r0, r2)
            java.lang.String r0 = com.onesignal.OSNotificationFormatHelper.getOSNotificationIdFromJson(r4)
            com.onesignal.OneSignal.handleNotificationOpen(r8, r5, r9, r0)
        L_0x00a9:
            return
        L_0x00aa:
            if (r6 == 0) goto L_0x00b8
            r6.endTransaction()     // Catch:{ Throwable -> 0x00b0 }
            goto L_0x00b8
        L_0x00b0:
            r9 = move-exception
            com.onesignal.OneSignal$LOG_LEVEL r0 = com.onesignal.OneSignal.LOG_LEVEL.ERROR
            java.lang.String r1 = "Error closing transaction! "
            com.onesignal.OneSignal.Log(r0, r1, r9)
        L_0x00b8:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.NotificationOpenedProcessor.processIntent(android.content.Context, android.content.Intent):void");
    }

    static boolean handleIAMPreviewOpen(@NonNull Context context, @NonNull JSONObject jSONObject) {
        String inAppPreviewPushUUID = NotificationBundleProcessor.inAppPreviewPushUUID(jSONObject);
        if (inAppPreviewPushUUID == null) {
            return false;
        }
        OneSignal.startOrResumeApp(context);
        OSInAppMessageController.getController().displayPreviewMessage(inAppPreviewPushUUID);
        return true;
    }

    private static void addChildNotifications(JSONArray jSONArray, String str, SQLiteDatabase sQLiteDatabase) {
        Cursor query = sQLiteDatabase.query(OneSignalDbContract.NotificationTable.TABLE_NAME, new String[]{OneSignalDbContract.NotificationTable.COLUMN_NAME_FULL_DATA}, "group_id = ? AND dismissed = 0 AND opened = 0 AND is_summary = 0", new String[]{str}, (String) null, (String) null, (String) null);
        if (query.getCount() > 1) {
            query.moveToFirst();
            do {
                try {
                    jSONArray.put(new JSONObject(query.getString(query.getColumnIndex(OneSignalDbContract.NotificationTable.COLUMN_NAME_FULL_DATA))));
                } catch (Throwable unused) {
                    OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.ERROR;
                    OneSignal.Log(log_level, "Could not parse JSON of sub notification in group: " + str);
                }
            } while (query.moveToNext());
        }
        query.close();
    }

    private static void markNotificationsConsumed(Context context, Intent intent, SQLiteDatabase sQLiteDatabase, boolean z) {
        String str;
        String stringExtra = intent.getStringExtra("summary");
        String[] strArr = null;
        if (stringExtra != null) {
            boolean equals = stringExtra.equals(OneSignalNotificationManager.getGrouplessSummaryKey());
            if (equals) {
                str = "group_id IS NULL";
            } else {
                str = "group_id = ?";
                strArr = new String[]{stringExtra};
            }
            if (!z && !OneSignal.getClearGroupSummaryClick()) {
                String valueOf = String.valueOf(OneSignalNotificationManager.getMostRecentNotifIdFromGroup(sQLiteDatabase, stringExtra, equals));
                str = str + " AND android_notification_id = ?";
                strArr = equals ? new String[]{valueOf} : new String[]{stringExtra, valueOf};
            }
        } else {
            str = "android_notification_id = " + intent.getIntExtra(GenerateNotification.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, 0);
        }
        clearStatusBarNotifications(context, sQLiteDatabase, stringExtra);
        sQLiteDatabase.update(OneSignalDbContract.NotificationTable.TABLE_NAME, newContentValuesWithConsumed(intent), str, strArr);
        BadgeCountUpdater.update(sQLiteDatabase, context);
    }

    private static void clearStatusBarNotifications(Context context, SQLiteDatabase sQLiteDatabase, String str) {
        if (str != null) {
            NotificationSummaryManager.clearNotificationOnSummaryClick(context, sQLiteDatabase, str);
        } else if (Build.VERSION.SDK_INT >= 23 && OneSignalNotificationManager.getGrouplessNotifsCount(context).intValue() < 1) {
            OneSignalNotificationManager.getNotificationManager(context).cancel(OneSignalNotificationManager.getGrouplessSummaryId());
        }
    }

    private static ContentValues newContentValuesWithConsumed(Intent intent) {
        ContentValues contentValues = new ContentValues();
        if (intent.getBooleanExtra("dismissed", false)) {
            contentValues.put("dismissed", 1);
        } else {
            contentValues.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_OPENED, 1);
        }
        return contentValues;
    }
}
