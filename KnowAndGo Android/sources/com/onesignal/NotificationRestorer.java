package com.onesignal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalDbContract;
import java.util.ArrayList;

class NotificationRestorer {
    static final String[] COLUMNS_FOR_RESTORE = {OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID, OneSignalDbContract.NotificationTable.COLUMN_NAME_FULL_DATA, OneSignalDbContract.NotificationTable.COLUMN_NAME_CREATED_TIME};
    static final int DEFAULT_TTL_IF_NOT_IN_PAYLOAD = 259200;
    private static final int DELAY_BETWEEN_NOTIFICATION_RESTORES_MS = 200;
    private static final int RESTORE_KICKOFF_REQUEST_CODE = 2071862120;
    private static final int RESTORE_NOTIFICATIONS_DELAY_MS = 15000;
    public static boolean restored;

    NotificationRestorer() {
    }

    static void asyncRestore(final Context context) {
        new Thread(new Runnable() {
            public void run() {
                Thread.currentThread().setPriority(10);
                NotificationRestorer.restore(context);
            }
        }, "OS_RESTORE_NOTIFS").start();
    }

    @WorkerThread
    public static void restore(Context context) {
        if (OSUtils.areNotificationsEnabled(context) && !restored) {
            restored = true;
            OneSignal.Log(OneSignal.LOG_LEVEL.INFO, "Restoring notifications");
            OneSignalDbHelper instance = OneSignalDbHelper.getInstance(context);
            StringBuilder recentUninteractedWithNotificationsWhere = OneSignalDbHelper.recentUninteractedWithNotificationsWhere();
            skipVisibleNotifications(context, recentUninteractedWithNotificationsWhere);
            queryAndRestoreNotificationsAndBadgeCount(context, instance, recentUninteractedWithNotificationsWhere);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void queryAndRestoreNotificationsAndBadgeCount(android.content.Context r10, com.onesignal.OneSignalDbHelper r11, java.lang.StringBuilder r12) {
        /*
            com.onesignal.OneSignal$LOG_LEVEL r0 = com.onesignal.OneSignal.LOG_LEVEL.INFO
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Querying DB for notifs to restore: "
            r1.append(r2)
            java.lang.String r2 = r12.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.onesignal.OneSignal.Log(r0, r1)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r11 = r11.getSQLiteDatabaseWithRetries()     // Catch:{ Throwable -> 0x004f }
            java.lang.String r2 = "notification"
            java.lang.String[] r3 = COLUMNS_FOR_RESTORE     // Catch:{ Throwable -> 0x004f }
            java.lang.String r4 = r12.toString()     // Catch:{ Throwable -> 0x004f }
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = "_id DESC"
            java.lang.String r9 = com.onesignal.NotificationLimitManager.MAX_NUMBER_OF_NOTIFICATIONS_STR     // Catch:{ Throwable -> 0x004f }
            r1 = r11
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Throwable -> 0x004f }
            r0 = 200(0xc8, float:2.8E-43)
            showNotificationsFromCursor(r10, r12, r0)     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            com.onesignal.BadgeCountUpdater.update(r11, r10)     // Catch:{ Throwable -> 0x004a, all -> 0x0047 }
            if (r12 == 0) goto L_0x0062
            boolean r10 = r12.isClosed()
            if (r10 != 0) goto L_0x0062
            r12.close()
            goto L_0x0062
        L_0x0047:
            r10 = move-exception
            r0 = r12
            goto L_0x0063
        L_0x004a:
            r10 = move-exception
            r0 = r12
            goto L_0x0050
        L_0x004d:
            r10 = move-exception
            goto L_0x0063
        L_0x004f:
            r10 = move-exception
        L_0x0050:
            com.onesignal.OneSignal$LOG_LEVEL r11 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ all -> 0x004d }
            java.lang.String r12 = "Error restoring notification records! "
            com.onesignal.OneSignal.Log(r11, r12, r10)     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x0062
            boolean r10 = r0.isClosed()
            if (r10 != 0) goto L_0x0062
            r0.close()
        L_0x0062:
            return
        L_0x0063:
            if (r0 == 0) goto L_0x006e
            boolean r11 = r0.isClosed()
            if (r11 != 0) goto L_0x006e
            r0.close()
        L_0x006e:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.NotificationRestorer.queryAndRestoreNotificationsAndBadgeCount(android.content.Context, com.onesignal.OneSignalDbHelper, java.lang.StringBuilder):void");
    }

    private static void skipVisibleNotifications(Context context, StringBuilder sb) {
        if (Build.VERSION.SDK_INT >= 23) {
            StatusBarNotification[] activeNotifications = OneSignalNotificationManager.getActiveNotifications(context);
            if (activeNotifications.length != 0) {
                ArrayList arrayList = new ArrayList();
                for (StatusBarNotification id : activeNotifications) {
                    arrayList.add(Integer.valueOf(id.getId()));
                }
                sb.append(" AND android_notification_id NOT IN (");
                sb.append(TextUtils.join(",", arrayList));
                sb.append(")");
            }
        }
    }

    static void showNotificationsFromCursor(Context context, Cursor cursor, int i) {
        if (cursor.moveToFirst()) {
            boolean z = NotificationExtenderService.getIntent(context) != null;
            do {
                if (z) {
                    Intent intent = NotificationExtenderService.getIntent(context);
                    addRestoreExtras(intent, cursor);
                    NotificationExtenderService.enqueueWork(context, intent.getComponent(), 2071862121, intent, false);
                } else {
                    RestoreJobService.enqueueWork(context, new ComponentName(context, RestoreJobService.class), 2071862122, addRestoreExtras(new Intent(), cursor), false);
                }
                if (i > 0) {
                    OSUtils.sleep(i);
                }
            } while (cursor.moveToNext());
        }
    }

    private static Intent addRestoreExtras(Intent intent, Cursor cursor) {
        int i = cursor.getInt(cursor.getColumnIndex(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID));
        String string = cursor.getString(cursor.getColumnIndex(OneSignalDbContract.NotificationTable.COLUMN_NAME_FULL_DATA));
        intent.putExtra("json_payload", string).putExtra("android_notif_id", i).putExtra("restoring", true).putExtra("timestamp", Long.valueOf(cursor.getLong(cursor.getColumnIndex(OneSignalDbContract.NotificationTable.COLUMN_NAME_CREATED_TIME))));
        return intent;
    }

    static void startDelayedRestoreTaskFromReceiver(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            OneSignal.Log(OneSignal.LOG_LEVEL.INFO, "scheduleRestoreKickoffJob");
            ((JobScheduler) context.getSystemService("jobscheduler")).schedule(new JobInfo.Builder(RESTORE_KICKOFF_REQUEST_CODE, new ComponentName(context, RestoreKickoffJobService.class)).setOverrideDeadline(15000).setMinimumLatency(15000).build());
            return;
        }
        OneSignal.Log(OneSignal.LOG_LEVEL.INFO, "scheduleRestoreKickoffAlarmTask");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context.getPackageName(), NotificationRestoreService.class.getName()));
        PendingIntent service = PendingIntent.getService(context, RESTORE_KICKOFF_REQUEST_CODE, intent, 134217728);
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 15000, service);
    }
}
