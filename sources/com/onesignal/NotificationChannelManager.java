package com.onesignal;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.onesignal.OneSignal;
import java.util.HashSet;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class NotificationChannelManager {
    private static final String DEFAULT_CHANNEL_ID = "fcm_fallback_notification_channel";
    private static final String RESTORE_CHANNEL_ID = "restored_OS_notifications";
    private static final Pattern hexPattern = Pattern.compile("^([A-Fa-f0-9]{8})$");

    private static int priorityToImportance(int i) {
        if (i > 9) {
            return 5;
        }
        if (i > 7) {
            return 4;
        }
        if (i > 5) {
            return 3;
        }
        if (i > 3) {
            return 2;
        }
        return i > 1 ? 1 : 0;
    }

    NotificationChannelManager() {
    }

    static String createNotificationChannel(NotificationGenerationJob notificationGenerationJob) {
        if (Build.VERSION.SDK_INT < 26) {
            return DEFAULT_CHANNEL_ID;
        }
        Context context = notificationGenerationJob.context;
        JSONObject jSONObject = notificationGenerationJob.jsonPayload;
        NotificationManager notificationManager = OneSignalNotificationManager.getNotificationManager(context);
        if (notificationGenerationJob.restoring) {
            return createRestoreChannel(notificationManager);
        }
        if (jSONObject.has("oth_chnl")) {
            String optString = jSONObject.optString("oth_chnl");
            if (notificationManager.getNotificationChannel(optString) != null) {
                return optString;
            }
        }
        if (!jSONObject.has("chnl")) {
            return createDefaultChannel(notificationManager);
        }
        try {
            return createChannel(context, notificationManager, jSONObject);
        } catch (JSONException e) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Could not create notification channel due to JSON payload error!", e);
            return DEFAULT_CHANNEL_ID;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x013a  */
    @androidx.annotation.RequiresApi(api = 26)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String createChannel(android.content.Context r6, android.app.NotificationManager r7, org.json.JSONObject r8) throws org.json.JSONException {
        /*
            java.lang.String r0 = "chnl"
            java.lang.Object r0 = r8.opt(r0)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L_0x0012
            org.json.JSONObject r1 = new org.json.JSONObject
            java.lang.String r0 = (java.lang.String) r0
            r1.<init>(r0)
            goto L_0x0015
        L_0x0012:
            r1 = r0
            org.json.JSONObject r1 = (org.json.JSONObject) r1
        L_0x0015:
            java.lang.String r0 = "id"
            java.lang.String r2 = "fcm_fallback_notification_channel"
            java.lang.String r0 = r1.optString(r0, r2)
            java.lang.String r2 = "miscellaneous"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0027
            java.lang.String r0 = "fcm_fallback_notification_channel"
        L_0x0027:
            java.lang.String r2 = "langs"
            boolean r2 = r1.has(r2)
            if (r2 == 0) goto L_0x0044
            java.lang.String r2 = "langs"
            org.json.JSONObject r2 = r1.getJSONObject(r2)
            java.lang.String r3 = com.onesignal.OSUtils.getCorrectedLanguage()
            boolean r4 = r2.has(r3)
            if (r4 == 0) goto L_0x0044
            org.json.JSONObject r2 = r2.optJSONObject(r3)
            goto L_0x0045
        L_0x0044:
            r2 = r1
        L_0x0045:
            java.lang.String r3 = "nm"
            java.lang.String r4 = "Miscellaneous"
            java.lang.String r3 = r2.optString(r3, r4)
            java.lang.String r4 = "pri"
            r5 = 6
            int r4 = r8.optInt(r4, r5)
            int r4 = priorityToImportance(r4)
            android.app.NotificationChannel r5 = new android.app.NotificationChannel
            r5.<init>(r0, r3, r4)
            java.lang.String r3 = "dscr"
            r4 = 0
            java.lang.String r3 = r2.optString(r3, r4)
            r5.setDescription(r3)
            java.lang.String r3 = "grp_id"
            boolean r3 = r1.has(r3)
            if (r3 == 0) goto L_0x0086
            java.lang.String r3 = "grp_id"
            java.lang.String r1 = r1.optString(r3)
            java.lang.String r3 = "grp_nm"
            java.lang.String r2 = r2.optString(r3)
            android.app.NotificationChannelGroup r3 = new android.app.NotificationChannelGroup
            r3.<init>(r1, r2)
            r7.createNotificationChannelGroup(r3)
            r5.setGroup(r1)
        L_0x0086:
            java.lang.String r1 = "ledc"
            boolean r1 = r8.has(r1)
            if (r1 == 0) goto L_0x00c0
            java.lang.String r1 = "ledc"
            java.lang.String r1 = r8.optString(r1)
            java.util.regex.Pattern r2 = hexPattern
            java.util.regex.Matcher r2 = r2.matcher(r1)
            boolean r2 = r2.matches()
            if (r2 != 0) goto L_0x00a9
            com.onesignal.OneSignal$LOG_LEVEL r1 = com.onesignal.OneSignal.LOG_LEVEL.WARN
            java.lang.String r2 = "OneSignal LED Color Settings: ARGB Hex value incorrect format (E.g: FF9900FF)"
            com.onesignal.OneSignal.Log(r1, r2)
            java.lang.String r1 = "FFFFFFFF"
        L_0x00a9:
            java.math.BigInteger r2 = new java.math.BigInteger     // Catch:{ Throwable -> 0x00b8 }
            r3 = 16
            r2.<init>(r1, r3)     // Catch:{ Throwable -> 0x00b8 }
            int r1 = r2.intValue()     // Catch:{ Throwable -> 0x00b8 }
            r5.setLightColor(r1)     // Catch:{ Throwable -> 0x00b8 }
            goto L_0x00c0
        L_0x00b8:
            r1 = move-exception
            com.onesignal.OneSignal$LOG_LEVEL r2 = com.onesignal.OneSignal.LOG_LEVEL.ERROR
            java.lang.String r3 = "Couldn't convert ARGB Hex value to BigInteger:"
            com.onesignal.OneSignal.Log(r2, r3, r1)
        L_0x00c0:
            java.lang.String r1 = "led"
            r2 = 1
            int r1 = r8.optInt(r1, r2)
            r3 = 0
            if (r1 != r2) goto L_0x00cc
            r1 = 1
            goto L_0x00cd
        L_0x00cc:
            r1 = 0
        L_0x00cd:
            r5.enableLights(r1)
            java.lang.String r1 = "vib_pt"
            boolean r1 = r8.has(r1)
            if (r1 == 0) goto L_0x00e1
            long[] r1 = com.onesignal.OSUtils.parseVibrationPattern(r8)
            if (r1 == 0) goto L_0x00e1
            r5.setVibrationPattern(r1)
        L_0x00e1:
            java.lang.String r1 = "vib"
            int r1 = r8.optInt(r1, r2)
            if (r1 != r2) goto L_0x00eb
            r1 = 1
            goto L_0x00ec
        L_0x00eb:
            r1 = 0
        L_0x00ec:
            r5.enableVibration(r1)
            java.lang.String r1 = "sound"
            boolean r1 = r8.has(r1)
            if (r1 == 0) goto L_0x011a
            java.lang.String r1 = "sound"
            java.lang.String r1 = r8.optString(r1, r4)
            android.net.Uri r6 = com.onesignal.OSUtils.getSoundUri(r6, r1)
            if (r6 == 0) goto L_0x0107
            r5.setSound(r6, r4)
            goto L_0x011a
        L_0x0107:
            java.lang.String r6 = "null"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0117
            java.lang.String r6 = "nil"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x011a
        L_0x0117:
            r5.setSound(r4, r4)
        L_0x011a:
            java.lang.String r6 = "vis"
            int r6 = r8.optInt(r6, r3)
            r5.setLockscreenVisibility(r6)
            java.lang.String r6 = "bdg"
            int r6 = r8.optInt(r6, r2)
            if (r6 != r2) goto L_0x012d
            r6 = 1
            goto L_0x012e
        L_0x012d:
            r6 = 0
        L_0x012e:
            r5.setShowBadge(r6)
            java.lang.String r6 = "bdnd"
            int r6 = r8.optInt(r6, r3)
            if (r6 != r2) goto L_0x013a
            goto L_0x013b
        L_0x013a:
            r2 = 0
        L_0x013b:
            r5.setBypassDnd(r2)
            com.onesignal.OneSignal$LOG_LEVEL r6 = com.onesignal.OneSignal.LOG_LEVEL.VERBOSE
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "Creating notification channel with channel:\n"
            r8.append(r1)
            java.lang.String r1 = r5.toString()
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            com.onesignal.OneSignal.onesignalLog(r6, r8)
            r7.createNotificationChannel(r5)     // Catch:{ IllegalArgumentException -> 0x015c }
            goto L_0x0160
        L_0x015c:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0160:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.NotificationChannelManager.createChannel(android.content.Context, android.app.NotificationManager, org.json.JSONObject):java.lang.String");
    }

    @RequiresApi(api = 26)
    private static String createDefaultChannel(NotificationManager notificationManager) {
        NotificationChannel notificationChannel = new NotificationChannel(DEFAULT_CHANNEL_ID, "Miscellaneous", 3);
        notificationChannel.enableLights(true);
        notificationChannel.enableVibration(true);
        notificationManager.createNotificationChannel(notificationChannel);
        return DEFAULT_CHANNEL_ID;
    }

    @RequiresApi(api = 26)
    private static String createRestoreChannel(NotificationManager notificationManager) {
        notificationManager.createNotificationChannel(new NotificationChannel(RESTORE_CHANNEL_ID, "Restored", 2));
        return RESTORE_CHANNEL_ID;
    }

    static void processChannelList(@NonNull Context context, @Nullable JSONArray jSONArray) {
        if (Build.VERSION.SDK_INT >= 26 && jSONArray != null) {
            NotificationManager notificationManager = OneSignalNotificationManager.getNotificationManager(context);
            HashSet hashSet = new HashSet();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    hashSet.add(createChannel(context, notificationManager, jSONArray.getJSONObject(i)));
                } catch (JSONException e) {
                    OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Could not create notification channel due to JSON payload error!", e);
                }
            }
            for (NotificationChannel id : notificationManager.getNotificationChannels()) {
                String id2 = id.getId();
                if (id2.startsWith("OS_") && !hashSet.contains(id2)) {
                    notificationManager.deleteNotificationChannel(id2);
                }
            }
        }
    }
}
