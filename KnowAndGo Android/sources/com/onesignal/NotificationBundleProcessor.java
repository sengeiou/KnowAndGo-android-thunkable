package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.onesignal.NotificationExtenderService;
import com.onesignal.OSNotificationPayload;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalDbContract;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class NotificationBundleProcessor {
    static final String DEFAULT_ACTION = "__DEFAULT__";
    private static final String IAM_PREVIEW_KEY = "os_in_app_message_preview_id";
    public static final String PUSH_ADDITIONAL_DATA_KEY = "a";
    public static final String PUSH_MINIFIED_BUTTONS_LIST = "o";
    public static final String PUSH_MINIFIED_BUTTON_ICON = "p";
    public static final String PUSH_MINIFIED_BUTTON_ID = "i";
    public static final String PUSH_MINIFIED_BUTTON_TEXT = "n";

    NotificationBundleProcessor() {
    }

    static void ProcessFromGCMIntentService(Context context, BundleCompat bundleCompat, NotificationExtenderService.OverrideSettings overrideSettings) {
        OneSignal.setAppContext(context);
        try {
            String string = bundleCompat.getString("json_payload");
            if (string == null) {
                OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.ERROR;
                OneSignal.Log(log_level, "json_payload key is nonexistent from mBundle passed to ProcessFromGCMIntentService: " + bundleCompat);
                return;
            }
            NotificationGenerationJob notificationGenerationJob = new NotificationGenerationJob(context);
            boolean z = false;
            notificationGenerationJob.restoring = bundleCompat.getBoolean("restoring", false);
            notificationGenerationJob.shownTimeStamp = bundleCompat.getLong("timestamp");
            notificationGenerationJob.jsonPayload = new JSONObject(string);
            if (inAppPreviewPushUUID(notificationGenerationJob.jsonPayload) != null) {
                z = true;
            }
            notificationGenerationJob.isInAppPreviewPush = z;
            if (notificationGenerationJob.restoring || notificationGenerationJob.isInAppPreviewPush || !OneSignal.notValidOrDuplicated(context, notificationGenerationJob.jsonPayload)) {
                if (bundleCompat.containsKey("android_notif_id")) {
                    if (overrideSettings == null) {
                        overrideSettings = new NotificationExtenderService.OverrideSettings();
                    }
                    overrideSettings.androidNotificationId = bundleCompat.getInt("android_notif_id");
                }
                notificationGenerationJob.overrideSettings = overrideSettings;
                ProcessJobForDisplay(notificationGenerationJob);
                if (notificationGenerationJob.restoring) {
                    OSUtils.sleep(100);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    static int ProcessJobForDisplay(NotificationGenerationJob notificationGenerationJob) {
        notificationGenerationJob.showAsAlert = OneSignal.getInAppAlertNotificationEnabled() && OneSignal.isAppActive();
        processCollapseKey(notificationGenerationJob);
        if (shouldDisplayNotif(notificationGenerationJob)) {
            GenerateNotification.fromJsonPayload(notificationGenerationJob);
        }
        if (!notificationGenerationJob.restoring && !notificationGenerationJob.isInAppPreviewPush) {
            processNotification(notificationGenerationJob, false);
            try {
                JSONObject jSONObject = new JSONObject(notificationGenerationJob.jsonPayload.toString());
                jSONObject.put(GenerateNotification.BUNDLE_KEY_ANDROID_NOTIFICATION_ID, notificationGenerationJob.getAndroidId());
                OneSignal.handleNotificationReceived(newJsonArray(jSONObject), true, notificationGenerationJob.showAsAlert);
            } catch (Throwable unused) {
            }
        }
        return notificationGenerationJob.getAndroidId().intValue();
    }

    private static boolean shouldDisplayNotif(NotificationGenerationJob notificationGenerationJob) {
        if (notificationGenerationJob.isInAppPreviewPush && Build.VERSION.SDK_INT <= 18) {
            return false;
        }
        if (notificationGenerationJob.hasExtender() || shouldDisplay(notificationGenerationJob.jsonPayload.optString("alert"))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static JSONArray bundleAsJsonArray(Bundle bundle) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(bundleAsJSONObject(bundle));
        return jSONArray;
    }

    private static void saveAndProcessNotification(Context context, Bundle bundle, boolean z, int i) {
        NotificationGenerationJob notificationGenerationJob = new NotificationGenerationJob(context);
        notificationGenerationJob.jsonPayload = bundleAsJSONObject(bundle);
        notificationGenerationJob.overrideSettings = new NotificationExtenderService.OverrideSettings();
        notificationGenerationJob.overrideSettings.androidNotificationId = Integer.valueOf(i);
        processNotification(notificationGenerationJob, z);
    }

    static void processNotification(NotificationGenerationJob notificationGenerationJob, boolean z) {
        saveNotification(notificationGenerationJob, z);
        if (notificationGenerationJob.isNotificationToDisplay()) {
            String apiNotificationId = notificationGenerationJob.getApiNotificationId();
            OneSignal.getSessionManager().onNotificationReceived(apiNotificationId);
            OSReceiveReceiptController.getInstance().sendReceiveReceipt(apiNotificationId);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0124 A[SYNTHETIC, Splitter:B:47:0x0124] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0130 A[SYNTHETIC, Splitter:B:53:0x0130] */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void saveNotification(com.onesignal.NotificationGenerationJob r10, boolean r11) {
        /*
            android.content.Context r0 = r10.context
            org.json.JSONObject r1 = r10.jsonPayload
            org.json.JSONObject r2 = r10.jsonPayload     // Catch:{ JSONException -> 0x013d }
            org.json.JSONObject r2 = getCustomJSONObject(r2)     // Catch:{ JSONException -> 0x013d }
            android.content.Context r3 = r10.context     // Catch:{ JSONException -> 0x013d }
            com.onesignal.OneSignalDbHelper r3 = com.onesignal.OneSignalDbHelper.getInstance(r3)     // Catch:{ JSONException -> 0x013d }
            r4 = 0
            android.database.sqlite.SQLiteDatabase r3 = r3.getSQLiteDatabaseWithRetries()     // Catch:{ Exception -> 0x011a }
            r3.beginTransaction()     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            boolean r5 = r10.isNotificationToDisplay()     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            if (r5 == 0) goto L_0x004a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            r5.<init>()     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            java.lang.String r6 = "android_notification_id = "
            r5.append(r6)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            int r6 = r10.getAndroidIdWithoutCreate()     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            r5.append(r6)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            r6.<init>()     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            java.lang.String r7 = "dismissed"
            r8 = 1
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            java.lang.String r7 = "notification"
            r3.update(r7, r6, r5, r4)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            com.onesignal.BadgeCountUpdater.update(r3, r0)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
        L_0x004a:
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            r5.<init>()     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            java.lang.String r6 = "notification_id"
            java.lang.String r7 = "i"
            java.lang.String r2 = r2.optString(r7)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            r5.put(r6, r2)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            java.lang.String r2 = "grp"
            boolean r2 = r1.has(r2)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            if (r2 == 0) goto L_0x006d
            java.lang.String r2 = "group_id"
            java.lang.String r6 = "grp"
            java.lang.String r6 = r1.optString(r6)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            r5.put(r2, r6)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
        L_0x006d:
            java.lang.String r2 = "collapse_key"
            boolean r2 = r1.has(r2)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            if (r2 == 0) goto L_0x008e
            java.lang.String r2 = "do_not_collapse"
            java.lang.String r6 = "collapse_key"
            java.lang.String r6 = r1.optString(r6)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            if (r2 != 0) goto L_0x008e
            java.lang.String r2 = "collapse_id"
            java.lang.String r6 = "collapse_key"
            java.lang.String r6 = r1.optString(r6)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            r5.put(r2, r6)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
        L_0x008e:
            java.lang.String r2 = "opened"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            r5.put(r2, r6)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            if (r11 != 0) goto L_0x00a6
            java.lang.String r2 = "android_notification_id"
            int r6 = r10.getAndroidIdWithoutCreate()     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            r5.put(r2, r6)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
        L_0x00a6:
            java.lang.CharSequence r2 = r10.getTitle()     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            if (r2 == 0) goto L_0x00b9
            java.lang.String r2 = "title"
            java.lang.CharSequence r6 = r10.getTitle()     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            r5.put(r2, r6)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
        L_0x00b9:
            java.lang.CharSequence r2 = r10.getBody()     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            if (r2 == 0) goto L_0x00cc
            java.lang.String r2 = "message"
            java.lang.CharSequence r10 = r10.getBody()     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            r5.put(r2, r10)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
        L_0x00cc:
            java.lang.String r10 = "google.sent_time"
            long r6 = android.os.SystemClock.currentThreadTimeMillis()     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            long r6 = r1.optLong(r10, r6)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r8
            java.lang.String r10 = "google.ttl"
            r2 = 259200(0x3f480, float:3.63217E-40)
            int r10 = r1.optInt(r10, r2)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            long r8 = (long) r10     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            long r6 = r6 + r8
            java.lang.String r10 = "expire_time"
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            r5.put(r10, r2)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            java.lang.String r10 = "full_data"
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            r5.put(r10, r1)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            java.lang.String r10 = "notification"
            r3.insertOrThrow(r10, r4, r5)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            if (r11 != 0) goto L_0x0100
            com.onesignal.BadgeCountUpdater.update(r3, r0)     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
        L_0x0100:
            r3.setTransactionSuccessful()     // Catch:{ Exception -> 0x0114, all -> 0x0112 }
            if (r3 == 0) goto L_0x0141
            r3.endTransaction()     // Catch:{ Throwable -> 0x0109 }
            goto L_0x0141
        L_0x0109:
            r10 = move-exception
            com.onesignal.OneSignal$LOG_LEVEL r11 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ JSONException -> 0x013d }
            java.lang.String r0 = "Error closing transaction! "
        L_0x010e:
            com.onesignal.OneSignal.Log(r11, r0, r10)     // Catch:{ JSONException -> 0x013d }
            goto L_0x0141
        L_0x0112:
            r10 = move-exception
            goto L_0x012e
        L_0x0114:
            r10 = move-exception
            r4 = r3
            goto L_0x011b
        L_0x0117:
            r10 = move-exception
            r3 = r4
            goto L_0x012e
        L_0x011a:
            r10 = move-exception
        L_0x011b:
            com.onesignal.OneSignal$LOG_LEVEL r11 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ all -> 0x0117 }
            java.lang.String r0 = "Error saving notification record! "
            com.onesignal.OneSignal.Log(r11, r0, r10)     // Catch:{ all -> 0x0117 }
            if (r4 == 0) goto L_0x0141
            r4.endTransaction()     // Catch:{ Throwable -> 0x0128 }
            goto L_0x0141
        L_0x0128:
            r10 = move-exception
            com.onesignal.OneSignal$LOG_LEVEL r11 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ JSONException -> 0x013d }
            java.lang.String r0 = "Error closing transaction! "
            goto L_0x010e
        L_0x012e:
            if (r3 == 0) goto L_0x013c
            r3.endTransaction()     // Catch:{ Throwable -> 0x0134 }
            goto L_0x013c
        L_0x0134:
            r11 = move-exception
            com.onesignal.OneSignal$LOG_LEVEL r0 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ JSONException -> 0x013d }
            java.lang.String r1 = "Error closing transaction! "
            com.onesignal.OneSignal.Log(r0, r1, r11)     // Catch:{ JSONException -> 0x013d }
        L_0x013c:
            throw r10     // Catch:{ JSONException -> 0x013d }
        L_0x013d:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0141:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.NotificationBundleProcessor.saveNotification(com.onesignal.NotificationGenerationJob, boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f A[SYNTHETIC, Splitter:B:20:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006e A[SYNTHETIC, Splitter:B:25:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void markRestoredNotificationAsDismissed(com.onesignal.NotificationGenerationJob r6) {
        /*
            int r0 = r6.getAndroidIdWithoutCreate()
            r1 = -1
            if (r0 != r1) goto L_0x0008
            return
        L_0x0008:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "android_notification_id = "
            r0.append(r1)
            int r1 = r6.getAndroidIdWithoutCreate()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.content.Context r1 = r6.context
            com.onesignal.OneSignalDbHelper r1 = com.onesignal.OneSignalDbHelper.getInstance(r1)
            r2 = 0
            android.database.sqlite.SQLiteDatabase r1 = r1.getSQLiteDatabaseWithRetries()     // Catch:{ Exception -> 0x0055 }
            r1.beginTransaction()     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            r3.<init>()     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            java.lang.String r4 = "dismissed"
            r5 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            java.lang.String r4 = "notification"
            r1.update(r4, r3, r0, r2)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            android.content.Context r6 = r6.context     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            com.onesignal.BadgeCountUpdater.update(r1, r6)     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            r1.setTransactionSuccessful()     // Catch:{ Exception -> 0x004f, all -> 0x004d }
            if (r1 == 0) goto L_0x006b
            r1.endTransaction()     // Catch:{ Throwable -> 0x0063 }
            goto L_0x006b
        L_0x004d:
            r6 = move-exception
            goto L_0x006c
        L_0x004f:
            r6 = move-exception
            r2 = r1
            goto L_0x0056
        L_0x0052:
            r6 = move-exception
            r1 = r2
            goto L_0x006c
        L_0x0055:
            r6 = move-exception
        L_0x0056:
            com.onesignal.OneSignal$LOG_LEVEL r0 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ all -> 0x0052 }
            java.lang.String r1 = "Error saving notification record! "
            com.onesignal.OneSignal.Log(r0, r1, r6)     // Catch:{ all -> 0x0052 }
            if (r2 == 0) goto L_0x006b
            r2.endTransaction()     // Catch:{ Throwable -> 0x0063 }
            goto L_0x006b
        L_0x0063:
            r6 = move-exception
            com.onesignal.OneSignal$LOG_LEVEL r0 = com.onesignal.OneSignal.LOG_LEVEL.ERROR
            java.lang.String r1 = "Error closing transaction! "
            com.onesignal.OneSignal.Log(r0, r1, r6)
        L_0x006b:
            return
        L_0x006c:
            if (r1 == 0) goto L_0x007a
            r1.endTransaction()     // Catch:{ Throwable -> 0x0072 }
            goto L_0x007a
        L_0x0072:
            r0 = move-exception
            com.onesignal.OneSignal$LOG_LEVEL r1 = com.onesignal.OneSignal.LOG_LEVEL.ERROR
            java.lang.String r2 = "Error closing transaction! "
            com.onesignal.OneSignal.Log(r1, r2, r0)
        L_0x007a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.NotificationBundleProcessor.markRestoredNotificationAsDismissed(com.onesignal.NotificationGenerationJob):void");
    }

    @NonNull
    static JSONObject bundleAsJSONObject(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                jSONObject.put(str, bundle.get(str));
            } catch (JSONException e) {
                OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.ERROR;
                OneSignal.Log(log_level, "bundleAsJSONObject error for key: " + str, e);
            }
        }
        return jSONObject;
    }

    private static void unMinifyButtonsFromBundle(Bundle bundle) {
        JSONObject jSONObject;
        String str;
        if (bundle.containsKey(PUSH_MINIFIED_BUTTONS_LIST)) {
            try {
                JSONObject jSONObject2 = new JSONObject(bundle.getString(OSNotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM));
                if (jSONObject2.has(PUSH_ADDITIONAL_DATA_KEY)) {
                    jSONObject = jSONObject2.getJSONObject(PUSH_ADDITIONAL_DATA_KEY);
                } else {
                    jSONObject = new JSONObject();
                }
                JSONArray jSONArray = new JSONArray(bundle.getString(PUSH_MINIFIED_BUTTONS_LIST));
                bundle.remove(PUSH_MINIFIED_BUTTONS_LIST);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    String string = jSONObject3.getString(PUSH_MINIFIED_BUTTON_TEXT);
                    jSONObject3.remove(PUSH_MINIFIED_BUTTON_TEXT);
                    if (jSONObject3.has("i")) {
                        str = jSONObject3.getString("i");
                        jSONObject3.remove("i");
                    } else {
                        str = string;
                    }
                    jSONObject3.put("id", str);
                    jSONObject3.put("text", string);
                    if (jSONObject3.has("p")) {
                        jSONObject3.put("icon", jSONObject3.getString("p"));
                        jSONObject3.remove("p");
                    }
                }
                jSONObject.put("actionButtons", jSONArray);
                jSONObject.put(GenerateNotification.BUNDLE_KEY_ACTION_ID, DEFAULT_ACTION);
                if (!jSONObject2.has(PUSH_ADDITIONAL_DATA_KEY)) {
                    jSONObject2.put(PUSH_ADDITIONAL_DATA_KEY, jSONObject);
                }
                bundle.putString(OSNotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM, jSONObject2.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    static OSNotificationPayload OSNotificationPayloadFrom(JSONObject jSONObject) {
        OSNotificationPayload oSNotificationPayload = new OSNotificationPayload();
        try {
            JSONObject customJSONObject = getCustomJSONObject(jSONObject);
            oSNotificationPayload.notificationID = customJSONObject.optString("i");
            oSNotificationPayload.templateId = customJSONObject.optString("ti");
            oSNotificationPayload.templateName = customJSONObject.optString("tn");
            oSNotificationPayload.rawPayload = jSONObject.toString();
            oSNotificationPayload.additionalData = customJSONObject.optJSONObject(PUSH_ADDITIONAL_DATA_KEY);
            oSNotificationPayload.launchURL = customJSONObject.optString("u", (String) null);
            oSNotificationPayload.body = jSONObject.optString("alert", (String) null);
            oSNotificationPayload.title = jSONObject.optString(OneSignalDbContract.NotificationTable.COLUMN_NAME_TITLE, (String) null);
            oSNotificationPayload.smallIcon = jSONObject.optString("sicon", (String) null);
            oSNotificationPayload.bigPicture = jSONObject.optString("bicon", (String) null);
            oSNotificationPayload.largeIcon = jSONObject.optString("licon", (String) null);
            oSNotificationPayload.sound = jSONObject.optString("sound", (String) null);
            oSNotificationPayload.groupKey = jSONObject.optString("grp", (String) null);
            oSNotificationPayload.groupMessage = jSONObject.optString("grp_msg", (String) null);
            oSNotificationPayload.smallIconAccentColor = jSONObject.optString("bgac", (String) null);
            oSNotificationPayload.ledColor = jSONObject.optString("ledc", (String) null);
            String optString = jSONObject.optString("vis", (String) null);
            if (optString != null) {
                oSNotificationPayload.lockScreenVisibility = Integer.parseInt(optString);
            }
            oSNotificationPayload.fromProjectNumber = jSONObject.optString("from", (String) null);
            oSNotificationPayload.priority = jSONObject.optInt("pri", 0);
            String optString2 = jSONObject.optString("collapse_key", (String) null);
            if (!"do_not_collapse".equals(optString2)) {
                oSNotificationPayload.collapseId = optString2;
            }
            setActionButtons(oSNotificationPayload);
        } catch (Throwable th) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error assigning OSNotificationPayload values!", th);
        }
        try {
            setBackgroundImageLayout(oSNotificationPayload, jSONObject);
        } catch (Throwable th2) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Error assigning OSNotificationPayload.backgroundImageLayout values!", th2);
        }
        return oSNotificationPayload;
    }

    private static void setActionButtons(OSNotificationPayload oSNotificationPayload) throws Throwable {
        if (oSNotificationPayload.additionalData != null && oSNotificationPayload.additionalData.has("actionButtons")) {
            JSONArray jSONArray = oSNotificationPayload.additionalData.getJSONArray("actionButtons");
            oSNotificationPayload.actionButtons = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                OSNotificationPayload.ActionButton actionButton = new OSNotificationPayload.ActionButton();
                actionButton.f1084id = jSONObject.optString("id", (String) null);
                actionButton.text = jSONObject.optString("text", (String) null);
                actionButton.icon = jSONObject.optString("icon", (String) null);
                oSNotificationPayload.actionButtons.add(actionButton);
            }
            oSNotificationPayload.additionalData.remove(GenerateNotification.BUNDLE_KEY_ACTION_ID);
            oSNotificationPayload.additionalData.remove("actionButtons");
        }
    }

    private static void setBackgroundImageLayout(OSNotificationPayload oSNotificationPayload, JSONObject jSONObject) throws Throwable {
        String optString = jSONObject.optString("bg_img", (String) null);
        if (optString != null) {
            JSONObject jSONObject2 = new JSONObject(optString);
            oSNotificationPayload.backgroundImageLayout = new OSNotificationPayload.BackgroundImageLayout();
            oSNotificationPayload.backgroundImageLayout.image = jSONObject2.optString("img");
            oSNotificationPayload.backgroundImageLayout.titleTextColor = jSONObject2.optString("tc");
            oSNotificationPayload.backgroundImageLayout.bodyTextColor = jSONObject2.optString("bc");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void processCollapseKey(com.onesignal.NotificationGenerationJob r11) {
        /*
            boolean r0 = r11.restoring
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            org.json.JSONObject r0 = r11.jsonPayload
            java.lang.String r1 = "collapse_key"
            boolean r0 = r0.has(r1)
            if (r0 == 0) goto L_0x0096
            java.lang.String r0 = "do_not_collapse"
            org.json.JSONObject r1 = r11.jsonPayload
            java.lang.String r2 = "collapse_key"
            java.lang.String r1 = r1.optString(r2)
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0021
            goto L_0x0096
        L_0x0021:
            org.json.JSONObject r0 = r11.jsonPayload
            java.lang.String r1 = "collapse_key"
            java.lang.String r0 = r0.optString(r1)
            android.content.Context r1 = r11.context
            com.onesignal.OneSignalDbHelper r1 = com.onesignal.OneSignalDbHelper.getInstance(r1)
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r1.getSQLiteDatabaseWithRetries()     // Catch:{ Throwable -> 0x0076 }
            java.lang.String r4 = "notification"
            java.lang.String r1 = "android_notification_id"
            java.lang.String[] r5 = new java.lang.String[]{r1}     // Catch:{ Throwable -> 0x0076 }
            java.lang.String r6 = "collapse_id = ? AND dismissed = 0 AND opened = 0 "
            r1 = 1
            java.lang.String[] r7 = new java.lang.String[r1]     // Catch:{ Throwable -> 0x0076 }
            r1 = 0
            r7[r1] = r0     // Catch:{ Throwable -> 0x0076 }
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x0076 }
            boolean r1 = r0.moveToFirst()     // Catch:{ Throwable -> 0x0071, all -> 0x006e }
            if (r1 == 0) goto L_0x0062
            java.lang.String r1 = "android_notification_id"
            int r1 = r0.getColumnIndex(r1)     // Catch:{ Throwable -> 0x0071, all -> 0x006e }
            int r1 = r0.getInt(r1)     // Catch:{ Throwable -> 0x0071, all -> 0x006e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Throwable -> 0x0071, all -> 0x006e }
            r11.setAndroidIdWithOutOverriding(r1)     // Catch:{ Throwable -> 0x0071, all -> 0x006e }
        L_0x0062:
            if (r0 == 0) goto L_0x0089
            boolean r11 = r0.isClosed()
            if (r11 != 0) goto L_0x0089
            r0.close()
            goto L_0x0089
        L_0x006e:
            r11 = move-exception
            r2 = r0
            goto L_0x008a
        L_0x0071:
            r11 = move-exception
            r2 = r0
            goto L_0x0077
        L_0x0074:
            r11 = move-exception
            goto L_0x008a
        L_0x0076:
            r11 = move-exception
        L_0x0077:
            com.onesignal.OneSignal$LOG_LEVEL r0 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ all -> 0x0074 }
            java.lang.String r1 = "Could not read DB to find existing collapse_key!"
            com.onesignal.OneSignal.Log(r0, r1, r11)     // Catch:{ all -> 0x0074 }
            if (r2 == 0) goto L_0x0089
            boolean r11 = r2.isClosed()
            if (r11 != 0) goto L_0x0089
            r2.close()
        L_0x0089:
            return
        L_0x008a:
            if (r2 == 0) goto L_0x0095
            boolean r0 = r2.isClosed()
            if (r0 != 0) goto L_0x0095
            r2.close()
        L_0x0095:
            throw r11
        L_0x0096:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.NotificationBundleProcessor.processCollapseKey(com.onesignal.NotificationGenerationJob):void");
    }

    @NonNull
    static ProcessedBundleResult processBundleFromReceiver(Context context, final Bundle bundle) {
        ProcessedBundleResult processedBundleResult = new ProcessedBundleResult();
        if (!OSNotificationFormatHelper.isOneSignalBundle(bundle)) {
            return processedBundleResult;
        }
        processedBundleResult.isOneSignalPayload = true;
        unMinifyButtonsFromBundle(bundle);
        JSONObject bundleAsJSONObject = bundleAsJSONObject(bundle);
        String inAppPreviewPushUUID = inAppPreviewPushUUID(bundleAsJSONObject);
        if (inAppPreviewPushUUID != null) {
            if (OneSignal.isAppActive()) {
                processedBundleResult.inAppPreviewShown = true;
                OSInAppMessageController.getController().displayPreviewMessage(inAppPreviewPushUUID);
            }
            return processedBundleResult;
        } else if (startExtenderService(context, bundle, processedBundleResult)) {
            return processedBundleResult;
        } else {
            processedBundleResult.isDup = OneSignal.notValidOrDuplicated(context, bundleAsJSONObject);
            if (!processedBundleResult.isDup && !shouldDisplay(bundle.getString("alert"))) {
                saveAndProcessNotification(context, bundle, true, -1);
                new Thread(new Runnable() {
                    public void run() {
                        OneSignal.handleNotificationReceived(NotificationBundleProcessor.bundleAsJsonArray(bundle), false, false);
                    }
                }, "OS_PROC_BUNDLE").start();
            }
            return processedBundleResult;
        }
    }

    @Nullable
    static String inAppPreviewPushUUID(JSONObject jSONObject) {
        try {
            JSONObject customJSONObject = getCustomJSONObject(jSONObject);
            if (!customJSONObject.has(PUSH_ADDITIONAL_DATA_KEY)) {
                return null;
            }
            JSONObject optJSONObject = customJSONObject.optJSONObject(PUSH_ADDITIONAL_DATA_KEY);
            if (optJSONObject.has(IAM_PREVIEW_KEY)) {
                return optJSONObject.optString(IAM_PREVIEW_KEY);
            }
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }

    private static boolean startExtenderService(Context context, Bundle bundle, ProcessedBundleResult processedBundleResult) {
        Intent intent = NotificationExtenderService.getIntent(context);
        boolean z = false;
        if (intent == null) {
            return false;
        }
        intent.putExtra("json_payload", bundleAsJSONObject(bundle).toString());
        intent.putExtra("timestamp", System.currentTimeMillis() / 1000);
        if (Integer.parseInt(bundle.getString("pri", "0")) > 9) {
            z = true;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            NotificationExtenderService.enqueueWork(context, intent.getComponent(), 2071862121, intent, z);
        } else {
            context.startService(intent);
        }
        processedBundleResult.hasExtenderService = true;
        return true;
    }

    static boolean shouldDisplay(String str) {
        boolean z = str != null && !"".equals(str);
        boolean inAppAlertNotificationEnabled = OneSignal.getInAppAlertNotificationEnabled();
        boolean isAppActive = OneSignal.isAppActive();
        if (!z || (!OneSignal.getNotificationsWhenActiveEnabled() && !inAppAlertNotificationEnabled && isAppActive)) {
            return false;
        }
        return true;
    }

    @NonNull
    static JSONArray newJsonArray(JSONObject jSONObject) {
        return new JSONArray().put(jSONObject);
    }

    static JSONObject getCustomJSONObject(JSONObject jSONObject) throws JSONException {
        return new JSONObject(jSONObject.optString(OSNotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM));
    }

    static boolean hasRemoteResource(Bundle bundle) {
        return isBuildKeyRemote(bundle, "licon") || isBuildKeyRemote(bundle, "bicon") || bundle.getString("bg_img", (String) null) != null;
    }

    private static boolean isBuildKeyRemote(Bundle bundle, String str) {
        String trim = bundle.getString(str, "").trim();
        return trim.startsWith("http://") || trim.startsWith("https://");
    }

    static class ProcessedBundleResult {
        boolean hasExtenderService;
        boolean inAppPreviewShown;
        boolean isDup;
        boolean isOneSignalPayload;

        ProcessedBundleResult() {
        }

        /* access modifiers changed from: package-private */
        public boolean processed() {
            return !this.isOneSignalPayload || this.hasExtenderService || this.isDup || this.inAppPreviewShown;
        }
    }
}
