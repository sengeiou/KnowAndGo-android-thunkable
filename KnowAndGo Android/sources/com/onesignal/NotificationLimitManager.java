package com.onesignal;

import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import androidx.annotation.RequiresApi;
import java.util.Map;
import java.util.TreeMap;

class NotificationLimitManager {
    private static final int MAX_NUMBER_OF_NOTIFICATIONS_INT = 49;
    static final String MAX_NUMBER_OF_NOTIFICATIONS_STR = Integer.toString(49);

    private static int getMaxNumberOfNotificationsInt() {
        return 49;
    }

    NotificationLimitManager() {
    }

    private static String getMaxNumberOfNotificationsString() {
        return MAX_NUMBER_OF_NOTIFICATIONS_STR;
    }

    static void clearOldestOverLimit(Context context, int i) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                clearOldestOverLimitStandard(context, i);
            } else {
                clearOldestOverLimitFallback(context, i);
            }
        } catch (Throwable unused) {
            clearOldestOverLimitFallback(context, i);
        }
    }

    @RequiresApi(api = 23)
    static void clearOldestOverLimitStandard(Context context, int i) throws Throwable {
        StatusBarNotification[] activeNotifications = OneSignalNotificationManager.getActiveNotifications(context);
        int length = (activeNotifications.length - getMaxNumberOfNotificationsInt()) + i;
        if (length >= 1) {
            TreeMap treeMap = new TreeMap();
            for (StatusBarNotification statusBarNotification : activeNotifications) {
                if (!isGroupSummary(statusBarNotification)) {
                    treeMap.put(Long.valueOf(statusBarNotification.getNotification().when), Integer.valueOf(statusBarNotification.getId()));
                }
            }
            for (Map.Entry value : treeMap.entrySet()) {
                OneSignal.cancelNotification(((Integer) value.getValue()).intValue());
                length--;
                if (length <= 0) {
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void clearOldestOverLimitFallback(android.content.Context r10, int r11) {
        /*
            com.onesignal.OneSignalDbHelper r10 = com.onesignal.OneSignalDbHelper.getInstance(r10)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.getSQLiteDatabaseWithRetries()     // Catch:{ Throwable -> 0x0079 }
            java.lang.String r2 = "notification"
            java.lang.String r10 = "android_notification_id"
            java.lang.String[] r3 = new java.lang.String[]{r10}     // Catch:{ Throwable -> 0x0079 }
            java.lang.StringBuilder r10 = com.onesignal.OneSignalDbHelper.recentUninteractedWithNotificationsWhere()     // Catch:{ Throwable -> 0x0079 }
            java.lang.String r4 = r10.toString()     // Catch:{ Throwable -> 0x0079 }
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = "_id"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0079 }
            r10.<init>()     // Catch:{ Throwable -> 0x0079 }
            java.lang.String r9 = getMaxNumberOfNotificationsString()     // Catch:{ Throwable -> 0x0079 }
            r10.append(r9)     // Catch:{ Throwable -> 0x0079 }
            r10.append(r11)     // Catch:{ Throwable -> 0x0079 }
            java.lang.String r9 = r10.toString()     // Catch:{ Throwable -> 0x0079 }
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Throwable -> 0x0079 }
            int r0 = r10.getCount()     // Catch:{ Throwable -> 0x0074, all -> 0x0071 }
            int r1 = getMaxNumberOfNotificationsInt()     // Catch:{ Throwable -> 0x0074, all -> 0x0071 }
            int r0 = r0 - r1
            int r0 = r0 + r11
            r11 = 1
            if (r0 >= r11) goto L_0x004e
            if (r10 == 0) goto L_0x004d
            boolean r11 = r10.isClosed()
            if (r11 != 0) goto L_0x004d
            r10.close()
        L_0x004d:
            return
        L_0x004e:
            boolean r11 = r10.moveToNext()     // Catch:{ Throwable -> 0x0074, all -> 0x0071 }
            if (r11 == 0) goto L_0x0065
            java.lang.String r11 = "android_notification_id"
            int r11 = r10.getColumnIndex(r11)     // Catch:{ Throwable -> 0x0074, all -> 0x0071 }
            int r11 = r10.getInt(r11)     // Catch:{ Throwable -> 0x0074, all -> 0x0071 }
            com.onesignal.OneSignal.cancelNotification(r11)     // Catch:{ Throwable -> 0x0074, all -> 0x0071 }
            int r0 = r0 + -1
            if (r0 > 0) goto L_0x004e
        L_0x0065:
            if (r10 == 0) goto L_0x008c
            boolean r11 = r10.isClosed()
            if (r11 != 0) goto L_0x008c
            r10.close()
            goto L_0x008c
        L_0x0071:
            r11 = move-exception
            r0 = r10
            goto L_0x008d
        L_0x0074:
            r11 = move-exception
            r0 = r10
            goto L_0x007a
        L_0x0077:
            r11 = move-exception
            goto L_0x008d
        L_0x0079:
            r11 = move-exception
        L_0x007a:
            com.onesignal.OneSignal$LOG_LEVEL r10 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ all -> 0x0077 }
            java.lang.String r1 = "Error clearing oldest notifications over limit! "
            com.onesignal.OneSignal.Log(r10, r1, r11)     // Catch:{ all -> 0x0077 }
            if (r0 == 0) goto L_0x008c
            boolean r10 = r0.isClosed()
            if (r10 != 0) goto L_0x008c
            r0.close()
        L_0x008c:
            return
        L_0x008d:
            if (r0 == 0) goto L_0x0098
            boolean r10 = r0.isClosed()
            if (r10 != 0) goto L_0x0098
            r0.close()
        L_0x0098:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.NotificationLimitManager.clearOldestOverLimitFallback(android.content.Context, int):void");
    }

    @RequiresApi(api = 21)
    static boolean isGroupSummary(StatusBarNotification statusBarNotification) {
        return (statusBarNotification.getNotification().flags & 512) != 0;
    }
}
