package com.onesignal;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.onesignal.OneSignalDbContract;
import java.util.ArrayList;
import java.util.Iterator;

public class OneSignalNotificationManager {
    private static final int GROUPLESS_SUMMARY_ID = -718463522;
    private static final String GROUPLESS_SUMMARY_KEY = "os_group_undefined";

    static int getGrouplessSummaryId() {
        return GROUPLESS_SUMMARY_ID;
    }

    static String getGrouplessSummaryKey() {
        return GROUPLESS_SUMMARY_KEY;
    }

    static NotificationManager getNotificationManager(Context context) {
        return (NotificationManager) context.getSystemService(OneSignalDbContract.NotificationTable.TABLE_NAME);
    }

    @RequiresApi(api = 23)
    static Integer getGrouplessNotifsCount(Context context) {
        int i = 0;
        for (StatusBarNotification statusBarNotification : getActiveNotifications(context)) {
            if (!NotificationCompat.isGroupSummary(statusBarNotification.getNotification()) && GROUPLESS_SUMMARY_KEY.equals(statusBarNotification.getNotification().getGroup())) {
                i++;
            }
        }
        return Integer.valueOf(i);
    }

    @RequiresApi(api = 23)
    static StatusBarNotification[] getActiveNotifications(Context context) {
        try {
            return getNotificationManager(context).getActiveNotifications();
        } catch (Throwable unused) {
            return new StatusBarNotification[0];
        }
    }

    @RequiresApi(api = 23)
    static ArrayList<StatusBarNotification> getActiveGrouplessNotifications(Context context) {
        ArrayList<StatusBarNotification> arrayList = new ArrayList<>();
        for (StatusBarNotification statusBarNotification : getActiveNotifications(context)) {
            Notification notification = statusBarNotification.getNotification();
            boolean isGroupSummary = NotificationLimitManager.isGroupSummary(statusBarNotification);
            boolean z = notification.getGroup() == null || notification.getGroup().equals(getGrouplessSummaryKey());
            if (!isGroupSummary && z) {
                arrayList.add(statusBarNotification);
            }
        }
        return arrayList;
    }

    @RequiresApi(api = 23)
    static void assignGrouplessNotifications(Context context, ArrayList<StatusBarNotification> arrayList) {
        Notification.Builder builder;
        Iterator<StatusBarNotification> it = arrayList.iterator();
        while (it.hasNext()) {
            StatusBarNotification next = it.next();
            if (Build.VERSION.SDK_INT >= 24) {
                builder = Notification.Builder.recoverBuilder(context, next.getNotification());
            } else {
                builder = new Notification.Builder(context);
            }
            NotificationManagerCompat.from(context).notify(next.getId(), builder.setGroup(GROUPLESS_SUMMARY_KEY).build());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006b, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006c, code lost:
        r0 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006e, code lost:
        r14 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006f, code lost:
        r0 = r12;
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0095, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return r12;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b A[ExcHandler: all (th java.lang.Throwable), Splitter:B:10:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.Integer getMostRecentNotifIdFromGroup(android.database.sqlite.SQLiteDatabase r12, java.lang.String r13, boolean r14) {
        /*
            if (r14 == 0) goto L_0x0005
            java.lang.String r0 = "group_id IS NULL"
            goto L_0x0007
        L_0x0005:
            java.lang.String r0 = "group_id = ?"
        L_0x0007:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " AND dismissed = 0 AND opened = 0 AND is_summary = 0"
            r1.append(r0)
            java.lang.String r5 = r1.toString()
            r0 = 0
            if (r14 == 0) goto L_0x001d
            r6 = r0
            goto L_0x0024
        L_0x001d:
            r14 = 1
            java.lang.String[] r14 = new java.lang.String[r14]
            r1 = 0
            r14[r1] = r13
            r6 = r14
        L_0x0024:
            java.lang.String r3 = "notification"
            r4 = 0
            r7 = 0
            r8 = 0
            java.lang.String r9 = "created_time DESC"
            java.lang.String r10 = "1"
            r2 = r12
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x0075 }
            boolean r14 = r12.moveToFirst()     // Catch:{ Throwable -> 0x006e, all -> 0x006b }
            if (r14 != 0) goto L_0x0047
            r12.close()     // Catch:{ Throwable -> 0x006e, all -> 0x006b }
            if (r12 == 0) goto L_0x0046
            boolean r13 = r12.isClosed()
            if (r13 != 0) goto L_0x0046
            r12.close()
        L_0x0046:
            return r0
        L_0x0047:
            java.lang.String r14 = "android_notification_id"
            int r14 = r12.getColumnIndex(r14)     // Catch:{ Throwable -> 0x006e, all -> 0x006b }
            int r14 = r12.getInt(r14)     // Catch:{ Throwable -> 0x006e, all -> 0x006b }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ Throwable -> 0x006e, all -> 0x006b }
            r12.close()     // Catch:{ Throwable -> 0x0065, all -> 0x006b }
            if (r12 == 0) goto L_0x0063
            boolean r13 = r12.isClosed()
            if (r13 != 0) goto L_0x0063
            r12.close()
        L_0x0063:
            r12 = r14
            goto L_0x0098
        L_0x0065:
            r0 = move-exception
            r11 = r0
            r0 = r12
            r12 = r14
            r14 = r11
            goto L_0x0077
        L_0x006b:
            r13 = move-exception
            r0 = r12
            goto L_0x0099
        L_0x006e:
            r14 = move-exception
            r11 = r0
            r0 = r12
            r12 = r11
            goto L_0x0077
        L_0x0073:
            r13 = move-exception
            goto L_0x0099
        L_0x0075:
            r14 = move-exception
            r12 = r0
        L_0x0077:
            com.onesignal.OneSignal$LOG_LEVEL r1 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ all -> 0x0073 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
            r2.<init>()     // Catch:{ all -> 0x0073 }
            java.lang.String r3 = "Error getting android notification id for summary notification group: "
            r2.append(r3)     // Catch:{ all -> 0x0073 }
            r2.append(r13)     // Catch:{ all -> 0x0073 }
            java.lang.String r13 = r2.toString()     // Catch:{ all -> 0x0073 }
            com.onesignal.OneSignal.Log(r1, r13, r14)     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x0098
            boolean r13 = r0.isClosed()
            if (r13 != 0) goto L_0x0098
            r0.close()
        L_0x0098:
            return r12
        L_0x0099:
            if (r0 == 0) goto L_0x00a4
            boolean r12 = r0.isClosed()
            if (r12 != 0) goto L_0x00a4
            r0.close()
        L_0x00a4:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OneSignalNotificationManager.getMostRecentNotifIdFromGroup(android.database.sqlite.SQLiteDatabase, java.lang.String, boolean):java.lang.Integer");
    }
}
