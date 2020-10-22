package com.google.android.exoplayer2.p013ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;

/* renamed from: com.google.android.exoplayer2.ui.DownloadNotificationUtil */
public final class DownloadNotificationUtil {
    @StringRes
    private static final int NULL_STRING_ID = 0;

    private DownloadNotificationUtil() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.app.Notification buildProgressNotification(android.content.Context r17, @androidx.annotation.DrawableRes int r18, java.lang.String r19, @androidx.annotation.Nullable android.app.PendingIntent r20, @androidx.annotation.Nullable java.lang.String r21, com.google.android.exoplayer2.offline.DownloadManager.TaskState[] r22) {
        /*
            r0 = r22
            int r1 = r0.length
            r2 = 1
            r3 = 0
            r4 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 1
        L_0x000d:
            if (r4 >= r1) goto L_0x0042
            r11 = r0[r4]
            int r12 = r11.state
            if (r12 == r2) goto L_0x001b
            int r12 = r11.state
            r13 = 2
            if (r12 == r13) goto L_0x001b
            goto L_0x003f
        L_0x001b:
            com.google.android.exoplayer2.offline.DownloadAction r12 = r11.action
            boolean r12 = r12.isRemoveAction
            if (r12 == 0) goto L_0x0023
            r6 = 1
            goto L_0x003f
        L_0x0023:
            float r5 = r11.downloadPercentage
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r5 == 0) goto L_0x002f
            float r5 = r11.downloadPercentage
            float r7 = r7 + r5
            r10 = 0
        L_0x002f:
            long r11 = r11.downloadedBytes
            r13 = 0
            int r5 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r5 <= 0) goto L_0x0039
            r5 = 1
            goto L_0x003a
        L_0x0039:
            r5 = 0
        L_0x003a:
            r5 = r5 | r8
            int r9 = r9 + 1
            r8 = r5
            r5 = 1
        L_0x003f:
            int r4 = r4 + 1
            goto L_0x000d
        L_0x0042:
            if (r5 == 0) goto L_0x0049
            int r0 = com.google.android.exoplayer2.p013ui.C1581R.string.exo_download_downloading
        L_0x0046:
            r16 = r0
            goto L_0x0050
        L_0x0049:
            if (r6 == 0) goto L_0x004e
            int r0 = com.google.android.exoplayer2.p013ui.C1581R.string.exo_download_removing
            goto L_0x0046
        L_0x004e:
            r16 = 0
        L_0x0050:
            r11 = r17
            r12 = r18
            r13 = r19
            r14 = r20
            r15 = r21
            androidx.core.app.NotificationCompat$Builder r0 = newNotificationBuilder(r11, r12, r13, r14, r15, r16)
            if (r5 == 0) goto L_0x006a
            float r1 = (float) r9
            float r7 = r7 / r1
            int r1 = (int) r7
            if (r10 == 0) goto L_0x0068
            if (r8 == 0) goto L_0x0068
            goto L_0x006b
        L_0x0068:
            r4 = 0
            goto L_0x006c
        L_0x006a:
            r1 = 0
        L_0x006b:
            r4 = 1
        L_0x006c:
            r5 = 100
            r0.setProgress(r5, r1, r4)
            r0.setOngoing(r2)
            r0.setShowWhen(r3)
            android.app.Notification r0 = r0.build()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p013ui.DownloadNotificationUtil.buildProgressNotification(android.content.Context, int, java.lang.String, android.app.PendingIntent, java.lang.String, com.google.android.exoplayer2.offline.DownloadManager$TaskState[]):android.app.Notification");
    }

    public static Notification buildDownloadCompletedNotification(Context context, @DrawableRes int i, String str, @Nullable PendingIntent pendingIntent, @Nullable String str2) {
        return newNotificationBuilder(context, i, str, pendingIntent, str2, C1581R.string.exo_download_completed).build();
    }

    public static Notification buildDownloadFailedNotification(Context context, @DrawableRes int i, String str, @Nullable PendingIntent pendingIntent, @Nullable String str2) {
        return newNotificationBuilder(context, i, str, pendingIntent, str2, C1581R.string.exo_download_failed).build();
    }

    private static NotificationCompat.Builder newNotificationBuilder(Context context, @DrawableRes int i, String str, @Nullable PendingIntent pendingIntent, @Nullable String str2, @StringRes int i2) {
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(context, str).setSmallIcon(i);
        if (i2 != 0) {
            smallIcon.setContentTitle(context.getResources().getString(i2));
        }
        if (pendingIntent != null) {
            smallIcon.setContentIntent(pendingIntent);
        }
        if (str2 != null) {
            smallIcon.setStyle(new NotificationCompat.BigTextStyle().bigText(str2));
        }
        return smallIcon;
    }
}
