package com.onesignal;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.onesignal.AndroidSupportV4Compat;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalDbContract;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class GenerateNotification {
    public static final String BUNDLE_KEY_ACTION_ID = "actionId";
    public static final String BUNDLE_KEY_ANDROID_NOTIFICATION_ID = "androidNotificationId";
    public static final String BUNDLE_KEY_ONESIGNAL_DATA = "onesignalData";
    private static Resources contextResources;
    private static Context currentContext;
    private static Class<?> notificationOpenedClass;
    private static boolean openerIsBroadcast;
    private static String packageName;

    private static int convertOSToAndroidPriority(int i) {
        if (i > 9) {
            return 2;
        }
        if (i > 7) {
            return 1;
        }
        if (i > 4) {
            return 0;
        }
        return i > 2 ? -1 : -2;
    }

    GenerateNotification() {
    }

    private static class OneSignalNotificationBuilder {
        NotificationCompat.Builder compatBuilder;
        boolean hasLargeIcon;

        private OneSignalNotificationBuilder() {
        }
    }

    private static void setStatics(Context context) {
        currentContext = context;
        packageName = currentContext.getPackageName();
        contextResources = currentContext.getResources();
        PackageManager packageManager = currentContext.getPackageManager();
        Intent intent = new Intent(currentContext, NotificationOpenedReceiver.class);
        intent.setPackage(currentContext.getPackageName());
        if (packageManager.queryBroadcastReceivers(intent, 0).size() > 0) {
            openerIsBroadcast = true;
            notificationOpenedClass = NotificationOpenedReceiver.class;
            return;
        }
        notificationOpenedClass = NotificationOpenedActivity.class;
    }

    static void fromJsonPayload(NotificationGenerationJob notificationGenerationJob) {
        setStatics(notificationGenerationJob.context);
        if (notificationGenerationJob.restoring || !notificationGenerationJob.showAsAlert || ActivityLifecycleHandler.curActivity == null) {
            showNotification(notificationGenerationJob);
        } else {
            showNotificationAsAlert(notificationGenerationJob.jsonPayload, ActivityLifecycleHandler.curActivity, notificationGenerationJob.getAndroidId().intValue());
        }
    }

    private static void showNotificationAsAlert(final JSONObject jSONObject, final Activity activity, final int i) {
        activity.runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle(GenerateNotification.getTitle(jSONObject));
                builder.setMessage(jSONObject.optString("alert"));
                ArrayList arrayList = new ArrayList();
                final ArrayList arrayList2 = new ArrayList();
                GenerateNotification.addAlertButtons(activity, jSONObject, arrayList, arrayList2);
                final Intent access$200 = GenerateNotification.getNewBaseIntent(i);
                access$200.putExtra("action_button", true);
                access$200.putExtra("from_alert", true);
                access$200.putExtra(GenerateNotification.BUNDLE_KEY_ONESIGNAL_DATA, jSONObject.toString());
                if (jSONObject.has("grp")) {
                    access$200.putExtra("grp", jSONObject.optString("grp"));
                }
                C23621 r4 = new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int i2 = i + 3;
                        if (arrayList2.size() > 1) {
                            try {
                                JSONObject jSONObject = new JSONObject(jSONObject.toString());
                                jSONObject.put(GenerateNotification.BUNDLE_KEY_ACTION_ID, arrayList2.get(i2));
                                access$200.putExtra(GenerateNotification.BUNDLE_KEY_ONESIGNAL_DATA, jSONObject.toString());
                                NotificationOpenedProcessor.processIntent(activity, access$200);
                            } catch (Throwable unused) {
                            }
                        } else {
                            NotificationOpenedProcessor.processIntent(activity, access$200);
                        }
                    }
                };
                builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        NotificationOpenedProcessor.processIntent(activity, access$200);
                    }
                });
                for (int i = 0; i < arrayList.size(); i++) {
                    if (i == 0) {
                        builder.setNeutralButton((CharSequence) arrayList.get(i), r4);
                    } else if (i == 1) {
                        builder.setNegativeButton((CharSequence) arrayList.get(i), r4);
                    } else if (i == 2) {
                        builder.setPositiveButton((CharSequence) arrayList.get(i), r4);
                    }
                }
                AlertDialog create = builder.create();
                create.setCanceledOnTouchOutside(false);
                create.show();
            }
        });
    }

    /* access modifiers changed from: private */
    public static CharSequence getTitle(JSONObject jSONObject) {
        String optString = jSONObject.optString(OneSignalDbContract.NotificationTable.COLUMN_NAME_TITLE, (String) null);
        if (optString != null) {
            return optString;
        }
        return currentContext.getPackageManager().getApplicationLabel(currentContext.getApplicationInfo());
    }

    private static PendingIntent getNewActionPendingIntent(int i, Intent intent) {
        if (openerIsBroadcast) {
            return PendingIntent.getBroadcast(currentContext, i, intent, 134217728);
        }
        return PendingIntent.getActivity(currentContext, i, intent, 134217728);
    }

    /* access modifiers changed from: private */
    public static Intent getNewBaseIntent(int i) {
        Intent putExtra = new Intent(currentContext, notificationOpenedClass).putExtra(BUNDLE_KEY_ANDROID_NOTIFICATION_ID, i);
        if (openerIsBroadcast) {
            return putExtra;
        }
        return putExtra.addFlags(603979776);
    }

    private static Intent getNewBaseDeleteIntent(int i) {
        Intent putExtra = new Intent(currentContext, notificationOpenedClass).putExtra(BUNDLE_KEY_ANDROID_NOTIFICATION_ID, i).putExtra("dismissed", true);
        if (openerIsBroadcast) {
            return putExtra;
        }
        return putExtra.addFlags(402718720);
    }

    private static OneSignalNotificationBuilder getBaseOneSignalNotificationBuilder(NotificationGenerationJob notificationGenerationJob) {
        NotificationCompat.Builder builder;
        JSONObject jSONObject = notificationGenerationJob.jsonPayload;
        OneSignalNotificationBuilder oneSignalNotificationBuilder = new OneSignalNotificationBuilder();
        try {
            builder = new NotificationCompat.Builder(currentContext, NotificationChannelManager.createNotificationChannel(notificationGenerationJob));
        } catch (Throwable unused) {
            builder = new NotificationCompat.Builder(currentContext);
        }
        String optString = jSONObject.optString("alert", (String) null);
        builder.setAutoCancel(true).setSmallIcon(getSmallIconId(jSONObject)).setStyle(new NotificationCompat.BigTextStyle().bigText(optString)).setContentText(optString).setTicker(optString);
        if (Build.VERSION.SDK_INT < 24 || !jSONObject.optString(OneSignalDbContract.NotificationTable.COLUMN_NAME_TITLE).equals("")) {
            builder.setContentTitle(getTitle(jSONObject));
        }
        try {
            BigInteger accentColor = getAccentColor(jSONObject);
            if (accentColor != null) {
                builder.setColor(accentColor.intValue());
            }
        } catch (Throwable unused2) {
        }
        try {
            builder.setVisibility(jSONObject.has("vis") ? Integer.parseInt(jSONObject.optString("vis")) : 1);
        } catch (Throwable unused3) {
        }
        Bitmap largeIcon = getLargeIcon(jSONObject);
        if (largeIcon != null) {
            oneSignalNotificationBuilder.hasLargeIcon = true;
            builder.setLargeIcon(largeIcon);
        }
        Bitmap bitmap = getBitmap(jSONObject.optString("bicon", (String) null));
        if (bitmap != null) {
            builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).setSummaryText(optString));
        }
        if (notificationGenerationJob.shownTimeStamp != null) {
            try {
                builder.setWhen(notificationGenerationJob.shownTimeStamp.longValue() * 1000);
            } catch (Throwable unused4) {
            }
        }
        setAlertnessOptions(jSONObject, builder);
        oneSignalNotificationBuilder.compatBuilder = builder;
        return oneSignalNotificationBuilder;
    }

    private static void setAlertnessOptions(JSONObject jSONObject, NotificationCompat.Builder builder) {
        int convertOSToAndroidPriority = convertOSToAndroidPriority(jSONObject.optInt("pri", 6));
        builder.setPriority(convertOSToAndroidPriority);
        if (!(convertOSToAndroidPriority < 0)) {
            int i = 4;
            if (jSONObject.has("ledc") && jSONObject.optInt("led", 1) == 1) {
                try {
                    builder.setLights(new BigInteger(jSONObject.optString("ledc"), 16).intValue(), 2000, 5000);
                    i = 0;
                } catch (Throwable unused) {
                }
            }
            if (OneSignal.getVibrate() && jSONObject.optInt("vib", 1) == 1) {
                if (jSONObject.has("vib_pt")) {
                    long[] parseVibrationPattern = OSUtils.parseVibrationPattern(jSONObject);
                    if (parseVibrationPattern != null) {
                        builder.setVibrate(parseVibrationPattern);
                    }
                } else {
                    i |= 2;
                }
            }
            if (isSoundEnabled(jSONObject)) {
                Uri soundUri = OSUtils.getSoundUri(currentContext, jSONObject.optString("sound", (String) null));
                if (soundUri != null) {
                    builder.setSound(soundUri);
                } else {
                    i |= 1;
                }
            }
            builder.setDefaults(i);
        }
    }

    private static void removeNotifyOptions(NotificationCompat.Builder builder) {
        builder.setOnlyAlertOnce(true).setDefaults(0).setSound((Uri) null).setVibrate((long[]) null).setTicker((CharSequence) null);
    }

    private static void showNotification(NotificationGenerationJob notificationGenerationJob) {
        Notification notification;
        int intValue = notificationGenerationJob.getAndroidId().intValue();
        JSONObject jSONObject = notificationGenerationJob.jsonPayload;
        String optString = jSONObject.optString("grp", (String) null);
        ArrayList<StatusBarNotification> arrayList = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= 24) {
            arrayList = OneSignalNotificationManager.getActiveGrouplessNotifications(currentContext);
            if (optString == null && arrayList.size() >= 3) {
                optString = OneSignalNotificationManager.getGrouplessSummaryKey();
                OneSignalNotificationManager.assignGrouplessNotifications(currentContext, arrayList);
            }
        }
        OneSignalNotificationBuilder baseOneSignalNotificationBuilder = getBaseOneSignalNotificationBuilder(notificationGenerationJob);
        NotificationCompat.Builder builder = baseOneSignalNotificationBuilder.compatBuilder;
        addNotificationActionButtons(jSONObject, builder, intValue, (String) null);
        try {
            addBackgroundImage(jSONObject, builder);
        } catch (Throwable th) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Could not set background notification image!", th);
        }
        applyNotificationExtender(notificationGenerationJob, builder);
        if (notificationGenerationJob.restoring) {
            removeNotifyOptions(builder);
        }
        NotificationLimitManager.clearOldestOverLimit(currentContext, optString != null ? 2 : 1);
        if (optString != null) {
            createGenericPendingIntentsForGroup(builder, jSONObject, optString, intValue);
            notification = createSingleNotificationBeforeSummaryBuilder(notificationGenerationJob, builder);
            if (Build.VERSION.SDK_INT < 24 || !optString.equals(OneSignalNotificationManager.getGrouplessSummaryKey())) {
                createSummaryNotification(notificationGenerationJob, baseOneSignalNotificationBuilder);
            } else {
                createGrouplessSummaryNotification(notificationGenerationJob, arrayList.size() + 1);
            }
        } else {
            notification = createGenericPendingIntentsForNotif(builder, jSONObject, intValue);
        }
        if (optString == null || Build.VERSION.SDK_INT > 17) {
            addXiaomiSettings(baseOneSignalNotificationBuilder, notification);
            NotificationManagerCompat.from(currentContext).notify(intValue, notification);
        }
    }

    private static Notification createGenericPendingIntentsForNotif(NotificationCompat.Builder builder, JSONObject jSONObject, int i) {
        SecureRandom secureRandom = new SecureRandom();
        builder.setContentIntent(getNewActionPendingIntent(secureRandom.nextInt(), getNewBaseIntent(i).putExtra(BUNDLE_KEY_ONESIGNAL_DATA, jSONObject.toString())));
        builder.setDeleteIntent(getNewActionPendingIntent(secureRandom.nextInt(), getNewBaseDeleteIntent(i)));
        return builder.build();
    }

    private static void createGenericPendingIntentsForGroup(NotificationCompat.Builder builder, JSONObject jSONObject, String str, int i) {
        SecureRandom secureRandom = new SecureRandom();
        builder.setContentIntent(getNewActionPendingIntent(secureRandom.nextInt(), getNewBaseIntent(i).putExtra(BUNDLE_KEY_ONESIGNAL_DATA, jSONObject.toString()).putExtra("grp", str)));
        builder.setDeleteIntent(getNewActionPendingIntent(secureRandom.nextInt(), getNewBaseDeleteIntent(i).putExtra("grp", str)));
        builder.setGroup(str);
        try {
            builder.setGroupAlertBehavior(1);
        } catch (Throwable unused) {
        }
    }

    private static void applyNotificationExtender(NotificationGenerationJob notificationGenerationJob, NotificationCompat.Builder builder) {
        if (notificationGenerationJob.overrideSettings != null && notificationGenerationJob.overrideSettings.extender != null) {
            try {
                Field declaredField = NotificationCompat.Builder.class.getDeclaredField("mNotification");
                declaredField.setAccessible(true);
                Notification notification = (Notification) declaredField.get(builder);
                notificationGenerationJob.orgFlags = Integer.valueOf(notification.flags);
                notificationGenerationJob.orgSound = notification.sound;
                builder.extend(notificationGenerationJob.overrideSettings.extender);
                Notification notification2 = (Notification) declaredField.get(builder);
                Field declaredField2 = NotificationCompat.Builder.class.getDeclaredField("mContentText");
                declaredField2.setAccessible(true);
                Field declaredField3 = NotificationCompat.Builder.class.getDeclaredField("mContentTitle");
                declaredField3.setAccessible(true);
                notificationGenerationJob.overriddenBodyFromExtender = (CharSequence) declaredField2.get(builder);
                notificationGenerationJob.overriddenTitleFromExtender = (CharSequence) declaredField3.get(builder);
                if (!notificationGenerationJob.restoring) {
                    notificationGenerationJob.overriddenFlags = Integer.valueOf(notification2.flags);
                    notificationGenerationJob.overriddenSound = notification2.sound;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static Notification createSingleNotificationBeforeSummaryBuilder(NotificationGenerationJob notificationGenerationJob, NotificationCompat.Builder builder) {
        boolean z = Build.VERSION.SDK_INT > 17 && Build.VERSION.SDK_INT < 24 && !notificationGenerationJob.restoring;
        if (z && notificationGenerationJob.overriddenSound != null && !notificationGenerationJob.overriddenSound.equals(notificationGenerationJob.orgSound)) {
            builder.setSound((Uri) null);
        }
        Notification build = builder.build();
        if (z) {
            builder.setSound(notificationGenerationJob.overriddenSound);
        }
        return build;
    }

    private static void addXiaomiSettings(OneSignalNotificationBuilder oneSignalNotificationBuilder, Notification notification) {
        if (oneSignalNotificationBuilder.hasLargeIcon) {
            try {
                Object newInstance = Class.forName("android.app.MiuiNotification").newInstance();
                Field declaredField = newInstance.getClass().getDeclaredField("customizedIcon");
                declaredField.setAccessible(true);
                declaredField.set(newInstance, true);
                Field field = notification.getClass().getField("extraNotification");
                field.setAccessible(true);
                field.set(notification, newInstance);
            } catch (Throwable unused) {
            }
        }
    }

    static void updateSummaryNotification(NotificationGenerationJob notificationGenerationJob) {
        setStatics(notificationGenerationJob.context);
        createSummaryNotification(notificationGenerationJob, (OneSignalNotificationBuilder) null);
    }

    private static void createSummaryNotification(NotificationGenerationJob notificationGenerationJob, OneSignalNotificationBuilder oneSignalNotificationBuilder) {
        Cursor cursor;
        Integer num;
        ArrayList<SpannableString> arrayList;
        Notification notification;
        String str;
        String str2;
        String str3;
        NotificationGenerationJob notificationGenerationJob2 = notificationGenerationJob;
        OneSignalNotificationBuilder oneSignalNotificationBuilder2 = oneSignalNotificationBuilder;
        boolean z = notificationGenerationJob2.restoring;
        JSONObject jSONObject = notificationGenerationJob2.jsonPayload;
        String optString = jSONObject.optString("grp", (String) null);
        SecureRandom secureRandom = new SecureRandom();
        PendingIntent newActionPendingIntent = getNewActionPendingIntent(secureRandom.nextInt(), getNewBaseDeleteIntent(0).putExtra("summary", optString));
        OneSignalDbHelper instance = OneSignalDbHelper.getInstance(currentContext);
        try {
            SQLiteDatabase sQLiteDatabaseWithRetries = instance.getSQLiteDatabaseWithRetries();
            String[] strArr = {OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID, OneSignalDbContract.NotificationTable.COLUMN_NAME_FULL_DATA, OneSignalDbContract.NotificationTable.COLUMN_NAME_IS_SUMMARY, OneSignalDbContract.NotificationTable.COLUMN_NAME_TITLE, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE};
            String str4 = "group_id = ? AND dismissed = 0 AND opened = 0";
            String[] strArr2 = {optString};
            if (!z && notificationGenerationJob.getAndroidId().intValue() != -1) {
                str4 = str4 + " AND android_notification_id <> " + notificationGenerationJob.getAndroidId();
            }
            int i = 1;
            try {
                cursor = sQLiteDatabaseWithRetries.query(OneSignalDbContract.NotificationTable.TABLE_NAME, strArr, str4, strArr2, (String) null, (String) null, "_id DESC");
                try {
                    if (cursor.moveToFirst()) {
                        arrayList = new ArrayList<>();
                        String str5 = null;
                        num = null;
                        while (true) {
                            if (cursor.getInt(cursor.getColumnIndex(OneSignalDbContract.NotificationTable.COLUMN_NAME_IS_SUMMARY)) == i) {
                                num = Integer.valueOf(cursor.getInt(cursor.getColumnIndex(OneSignalDbContract.NotificationTable.COLUMN_NAME_ANDROID_NOTIFICATION_ID)));
                            } else {
                                String string = cursor.getString(cursor.getColumnIndex(OneSignalDbContract.NotificationTable.COLUMN_NAME_TITLE));
                                if (string == null) {
                                    str3 = "";
                                } else {
                                    str3 = string + StringUtils.SPACE;
                                }
                                SpannableString spannableString = new SpannableString(str3 + cursor.getString(cursor.getColumnIndex(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE)));
                                if (str3.length() > 0) {
                                    spannableString.setSpan(new StyleSpan(1), 0, str3.length(), 0);
                                }
                                arrayList.add(spannableString);
                                if (str5 == null) {
                                    str5 = cursor.getString(cursor.getColumnIndex(OneSignalDbContract.NotificationTable.COLUMN_NAME_FULL_DATA));
                                }
                            }
                            if (!cursor.moveToNext()) {
                                break;
                            }
                            i = 1;
                        }
                        if (z && str5 != null) {
                            jSONObject = new JSONObject(str5);
                        }
                    } else {
                        arrayList = null;
                        num = null;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    th = th;
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                if (num == null) {
                    num = Integer.valueOf(secureRandom.nextInt());
                    createSummaryIdDatabaseEntry(instance, optString, num.intValue());
                }
                PendingIntent newActionPendingIntent2 = getNewActionPendingIntent(secureRandom.nextInt(), createBaseSummaryIntent(num.intValue(), jSONObject, optString));
                if (arrayList == null || ((!z || arrayList.size() <= 1) && (z || arrayList.size() <= 0))) {
                    NotificationCompat.Builder builder = oneSignalNotificationBuilder2.compatBuilder;
                    builder.mActions.clear();
                    addNotificationActionButtons(jSONObject, builder, num.intValue(), optString);
                    builder.setContentIntent(newActionPendingIntent2).setDeleteIntent(newActionPendingIntent).setOnlyAlertOnce(z).setAutoCancel(false).setGroup(optString).setGroupSummary(true);
                    try {
                        builder.setGroupAlertBehavior(1);
                    } catch (Throwable unused) {
                    }
                    notification = builder.build();
                    addXiaomiSettings(oneSignalNotificationBuilder2, notification);
                } else {
                    int size = arrayList.size() + (z ^ true ? 1 : 0);
                    String optString2 = jSONObject.optString("grp_msg", (String) null);
                    if (optString2 == null) {
                        str = size + " new messages";
                    } else {
                        str = optString2.replace("$[notif_count]", "" + size);
                    }
                    NotificationCompat.Builder builder2 = getBaseOneSignalNotificationBuilder(notificationGenerationJob).compatBuilder;
                    if (z) {
                        removeNotifyOptions(builder2);
                    } else {
                        if (notificationGenerationJob2.overriddenSound != null) {
                            builder2.setSound(notificationGenerationJob2.overriddenSound);
                        }
                        if (notificationGenerationJob2.overriddenFlags != null) {
                            builder2.setDefaults(notificationGenerationJob2.overriddenFlags.intValue());
                        }
                    }
                    builder2.setContentIntent(newActionPendingIntent2).setDeleteIntent(newActionPendingIntent).setContentTitle(currentContext.getPackageManager().getApplicationLabel(currentContext.getApplicationInfo())).setContentText(str).setNumber(size).setSmallIcon(getDefaultSmallIconId()).setLargeIcon(getDefaultLargeIcon()).setOnlyAlertOnce(z).setAutoCancel(false).setGroup(optString).setGroupSummary(true);
                    try {
                        builder2.setGroupAlertBehavior(1);
                    } catch (Throwable unused2) {
                    }
                    if (!z) {
                        builder2.setTicker(str);
                    }
                    NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                    if (!z) {
                        String charSequence = notificationGenerationJob.getTitle() != null ? notificationGenerationJob.getTitle().toString() : null;
                        if (charSequence == null) {
                            str2 = "";
                        } else {
                            str2 = charSequence + StringUtils.SPACE;
                        }
                        SpannableString spannableString2 = new SpannableString(str2 + notificationGenerationJob.getBody().toString());
                        if (str2.length() > 0) {
                            spannableString2.setSpan(new StyleSpan(1), 0, str2.length(), 0);
                        }
                        inboxStyle.addLine(spannableString2);
                    }
                    for (SpannableString addLine : arrayList) {
                        inboxStyle.addLine(addLine);
                    }
                    inboxStyle.setBigContentTitle(str);
                    builder2.setStyle(inboxStyle);
                    notification = builder2.build();
                }
                NotificationManagerCompat.from(currentContext).notify(num.intValue(), notification);
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            cursor.close();
            throw th;
        }
    }

    @RequiresApi(api = 23)
    private static void createGrouplessSummaryNotification(NotificationGenerationJob notificationGenerationJob, int i) {
        JSONObject jSONObject = notificationGenerationJob.jsonPayload;
        SecureRandom secureRandom = new SecureRandom();
        String grouplessSummaryKey = OneSignalNotificationManager.getGrouplessSummaryKey();
        String str = i + " new messages";
        int grouplessSummaryId = OneSignalNotificationManager.getGrouplessSummaryId();
        PendingIntent newActionPendingIntent = getNewActionPendingIntent(secureRandom.nextInt(), createBaseSummaryIntent(grouplessSummaryId, jSONObject, grouplessSummaryKey));
        PendingIntent newActionPendingIntent2 = getNewActionPendingIntent(secureRandom.nextInt(), getNewBaseDeleteIntent(0).putExtra("summary", grouplessSummaryKey));
        NotificationCompat.Builder builder = getBaseOneSignalNotificationBuilder(notificationGenerationJob).compatBuilder;
        if (notificationGenerationJob.overriddenSound != null) {
            builder.setSound(notificationGenerationJob.overriddenSound);
        }
        if (notificationGenerationJob.overriddenFlags != null) {
            builder.setDefaults(notificationGenerationJob.overriddenFlags.intValue());
        }
        builder.setContentIntent(newActionPendingIntent).setDeleteIntent(newActionPendingIntent2).setContentTitle(currentContext.getPackageManager().getApplicationLabel(currentContext.getApplicationInfo())).setContentText(str).setNumber(i).setSmallIcon(getDefaultSmallIconId()).setLargeIcon(getDefaultLargeIcon()).setOnlyAlertOnce(true).setAutoCancel(false).setGroup(grouplessSummaryKey).setGroupSummary(true);
        try {
            builder.setGroupAlertBehavior(1);
        } catch (Throwable unused) {
        }
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle(str);
        builder.setStyle(inboxStyle);
        NotificationManagerCompat.from(currentContext).notify(grouplessSummaryId, builder.build());
    }

    private static Intent createBaseSummaryIntent(int i, JSONObject jSONObject, String str) {
        return getNewBaseIntent(i).putExtra(BUNDLE_KEY_ONESIGNAL_DATA, jSONObject.toString()).putExtra("summary", str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045 A[SYNTHETIC, Splitter:B:17:0x0045] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054 A[SYNTHETIC, Splitter:B:22:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void createSummaryIdDatabaseEntry(com.onesignal.OneSignalDbHelper r3, java.lang.String r4, int r5) {
        /*
            r0 = 0
            android.database.sqlite.SQLiteDatabase r3 = r3.getSQLiteDatabaseWithRetries()     // Catch:{ Throwable -> 0x003b }
            r3.beginTransaction()     // Catch:{ Throwable -> 0x0035, all -> 0x0033 }
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ Throwable -> 0x0035, all -> 0x0033 }
            r1.<init>()     // Catch:{ Throwable -> 0x0035, all -> 0x0033 }
            java.lang.String r2 = "android_notification_id"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Throwable -> 0x0035, all -> 0x0033 }
            r1.put(r2, r5)     // Catch:{ Throwable -> 0x0035, all -> 0x0033 }
            java.lang.String r5 = "group_id"
            r1.put(r5, r4)     // Catch:{ Throwable -> 0x0035, all -> 0x0033 }
            java.lang.String r4 = "is_summary"
            r5 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Throwable -> 0x0035, all -> 0x0033 }
            r1.put(r4, r5)     // Catch:{ Throwable -> 0x0035, all -> 0x0033 }
            java.lang.String r4 = "notification"
            r3.insertOrThrow(r4, r0, r1)     // Catch:{ Throwable -> 0x0035, all -> 0x0033 }
            r3.setTransactionSuccessful()     // Catch:{ Throwable -> 0x0035, all -> 0x0033 }
            if (r3 == 0) goto L_0x0051
            r3.endTransaction()     // Catch:{ Throwable -> 0x0049 }
            goto L_0x0051
        L_0x0033:
            r4 = move-exception
            goto L_0x0052
        L_0x0035:
            r4 = move-exception
            r0 = r3
            goto L_0x003c
        L_0x0038:
            r4 = move-exception
            r3 = r0
            goto L_0x0052
        L_0x003b:
            r4 = move-exception
        L_0x003c:
            com.onesignal.OneSignal$LOG_LEVEL r3 = com.onesignal.OneSignal.LOG_LEVEL.ERROR     // Catch:{ all -> 0x0038 }
            java.lang.String r5 = "Error adding summary notification record! "
            com.onesignal.OneSignal.Log(r3, r5, r4)     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x0051
            r0.endTransaction()     // Catch:{ Throwable -> 0x0049 }
            goto L_0x0051
        L_0x0049:
            r3 = move-exception
            com.onesignal.OneSignal$LOG_LEVEL r4 = com.onesignal.OneSignal.LOG_LEVEL.ERROR
            java.lang.String r5 = "Error closing transaction! "
            com.onesignal.OneSignal.Log(r4, r5, r3)
        L_0x0051:
            return
        L_0x0052:
            if (r3 == 0) goto L_0x0060
            r3.endTransaction()     // Catch:{ Throwable -> 0x0058 }
            goto L_0x0060
        L_0x0058:
            r3 = move-exception
            com.onesignal.OneSignal$LOG_LEVEL r5 = com.onesignal.OneSignal.LOG_LEVEL.ERROR
            java.lang.String r0 = "Error closing transaction! "
            com.onesignal.OneSignal.Log(r5, r0, r3)
        L_0x0060:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.GenerateNotification.createSummaryIdDatabaseEntry(com.onesignal.OneSignalDbHelper, java.lang.String, int):void");
    }

    private static void addBackgroundImage(JSONObject jSONObject, NotificationCompat.Builder builder) throws Throwable {
        JSONObject jSONObject2;
        Bitmap bitmap;
        String str;
        if (Build.VERSION.SDK_INT >= 16) {
            String optString = jSONObject.optString("bg_img", (String) null);
            if (optString != null) {
                jSONObject2 = new JSONObject(optString);
                bitmap = getBitmap(jSONObject2.optString("img", (String) null));
            } else {
                bitmap = null;
                jSONObject2 = null;
            }
            if (bitmap == null) {
                bitmap = getBitmapFromAssetsOrResourceName("onesignal_bgimage_default_image");
            }
            if (bitmap != null) {
                RemoteViews remoteViews = new RemoteViews(currentContext.getPackageName(), C2463R.layout.onesignal_bgimage_notif_layout);
                remoteViews.setTextViewText(C2463R.C2466id.os_bgimage_notif_title, getTitle(jSONObject));
                remoteViews.setTextViewText(C2463R.C2466id.os_bgimage_notif_body, jSONObject.optString("alert"));
                setTextColor(remoteViews, jSONObject2, C2463R.C2466id.os_bgimage_notif_title, "tc", "onesignal_bgimage_notif_title_color");
                setTextColor(remoteViews, jSONObject2, C2463R.C2466id.os_bgimage_notif_body, "bc", "onesignal_bgimage_notif_body_color");
                if (jSONObject2 == null || !jSONObject2.has("img_align")) {
                    int identifier = contextResources.getIdentifier("onesignal_bgimage_notif_image_align", "string", packageName);
                    str = identifier != 0 ? contextResources.getString(identifier) : null;
                } else {
                    str = jSONObject2.getString("img_align");
                }
                if ("right".equals(str)) {
                    remoteViews.setViewPadding(C2463R.C2466id.os_bgimage_notif_bgimage_align_layout, -5000, 0, 0, 0);
                    remoteViews.setImageViewBitmap(C2463R.C2466id.os_bgimage_notif_bgimage_right_aligned, bitmap);
                    remoteViews.setViewVisibility(C2463R.C2466id.os_bgimage_notif_bgimage_right_aligned, 0);
                    remoteViews.setViewVisibility(C2463R.C2466id.os_bgimage_notif_bgimage, 2);
                } else {
                    remoteViews.setImageViewBitmap(C2463R.C2466id.os_bgimage_notif_bgimage, bitmap);
                }
                builder.setContent(remoteViews);
                builder.setStyle((NotificationCompat.Style) null);
            }
        }
    }

    private static void setTextColor(RemoteViews remoteViews, JSONObject jSONObject, int i, String str, String str2) {
        Integer safeGetColorFromHex = safeGetColorFromHex(jSONObject, str);
        if (safeGetColorFromHex != null) {
            remoteViews.setTextColor(i, safeGetColorFromHex.intValue());
            return;
        }
        int identifier = contextResources.getIdentifier(str2, "color", packageName);
        if (identifier != 0) {
            remoteViews.setTextColor(i, AndroidSupportV4Compat.ContextCompat.getColor(currentContext, identifier));
        }
    }

    private static Integer safeGetColorFromHex(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (jSONObject.has(str)) {
                return Integer.valueOf(new BigInteger(jSONObject.optString(str), 16).intValue());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Bitmap getLargeIcon(JSONObject jSONObject) {
        Bitmap bitmap = getBitmap(jSONObject.optString("licon"));
        if (bitmap == null) {
            bitmap = getBitmapFromAssetsOrResourceName("ic_onesignal_large_icon_default");
        }
        if (bitmap == null) {
            return null;
        }
        return resizeBitmapForLargeIconArea(bitmap);
    }

    private static Bitmap getDefaultLargeIcon() {
        return resizeBitmapForLargeIconArea(getBitmapFromAssetsOrResourceName("ic_onesignal_large_icon_default"));
    }

    private static Bitmap resizeBitmapForLargeIconArea(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int dimension = (int) contextResources.getDimension(17104902);
            int dimension2 = (int) contextResources.getDimension(17104901);
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            if (width > dimension2 || height > dimension) {
                if (height > width) {
                    dimension2 = (int) (((float) dimension) * (((float) width) / ((float) height)));
                } else if (width > height) {
                    dimension = (int) (((float) dimension2) * (((float) height) / ((float) width)));
                }
                return Bitmap.createScaledBitmap(bitmap, dimension2, dimension, true);
            }
        } catch (Throwable unused) {
        }
        return bitmap;
    }

    private static Bitmap getBitmapFromAssetsOrResourceName(String str) {
        Bitmap bitmap;
        try {
            bitmap = BitmapFactory.decodeStream(currentContext.getAssets().open(str));
        } catch (Throwable unused) {
            bitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        try {
            for (String str2 : Arrays.asList(new String[]{".png", ".webp", ".jpg", ".gif", ".bmp"})) {
                try {
                    bitmap = BitmapFactory.decodeStream(currentContext.getAssets().open(str + str2));
                    continue;
                } catch (Throwable unused2) {
                }
                if (bitmap != null) {
                    return bitmap;
                }
            }
            int resourceIcon = getResourceIcon(str);
            if (resourceIcon != 0) {
                return BitmapFactory.decodeResource(contextResources, resourceIcon);
            }
        } catch (Throwable unused3) {
        }
        return null;
    }

    private static Bitmap getBitmapFromURL(String str) {
        try {
            return BitmapFactory.decodeStream(new URL(str).openConnection().getInputStream());
        } catch (Throwable th) {
            OneSignal.Log(OneSignal.LOG_LEVEL.WARN, "Could not download image!", th);
            return null;
        }
    }

    private static Bitmap getBitmap(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("http://") || trim.startsWith("https://")) {
            return getBitmapFromURL(trim);
        }
        return getBitmapFromAssetsOrResourceName(str);
    }

    private static int getResourceIcon(String str) {
        if (str == null) {
            return 0;
        }
        String trim = str.trim();
        if (!OSUtils.isValidResourceName(trim)) {
            return 0;
        }
        int drawableId = getDrawableId(trim);
        if (drawableId != 0) {
            return drawableId;
        }
        try {
            return R.drawable.class.getField(str).getInt((Object) null);
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static int getSmallIconId(JSONObject jSONObject) {
        int resourceIcon = getResourceIcon(jSONObject.optString("sicon", (String) null));
        if (resourceIcon != 0) {
            return resourceIcon;
        }
        return getDefaultSmallIconId();
    }

    private static int getDefaultSmallIconId() {
        int drawableId = getDrawableId("ic_stat_onesignal_default");
        if (drawableId != 0) {
            return drawableId;
        }
        int drawableId2 = getDrawableId("corona_statusbar_icon_default");
        if (drawableId2 != 0) {
            return drawableId2;
        }
        int drawableId3 = getDrawableId("ic_os_notification_fallback_white_24dp");
        if (drawableId3 != 0) {
            return drawableId3;
        }
        return 17301598;
    }

    private static int getDrawableId(String str) {
        return contextResources.getIdentifier(str, "drawable", packageName);
    }

    private static boolean isSoundEnabled(JSONObject jSONObject) {
        String optString = jSONObject.optString("sound", (String) null);
        if ("null".equals(optString) || "nil".equals(optString)) {
            return false;
        }
        return OneSignal.getSoundEnabled();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0017 */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0021 A[Catch:{ Throwable -> 0x0027 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.math.BigInteger getAccentColor(org.json.JSONObject r4) {
        /*
            r0 = 16
            r1 = 0
            java.lang.String r2 = "bgac"
            boolean r2 = r4.has(r2)     // Catch:{ Throwable -> 0x0017 }
            if (r2 == 0) goto L_0x0017
            java.math.BigInteger r2 = new java.math.BigInteger     // Catch:{ Throwable -> 0x0017 }
            java.lang.String r3 = "bgac"
            java.lang.String r4 = r4.optString(r3, r1)     // Catch:{ Throwable -> 0x0017 }
            r2.<init>(r4, r0)     // Catch:{ Throwable -> 0x0017 }
            return r2
        L_0x0017:
            android.content.Context r4 = currentContext     // Catch:{ Throwable -> 0x0027 }
            java.lang.String r2 = "com.onesignal.NotificationAccentColor.DEFAULT"
            java.lang.String r4 = com.onesignal.OSUtils.getManifestMeta(r4, r2)     // Catch:{ Throwable -> 0x0027 }
            if (r4 == 0) goto L_0x0027
            java.math.BigInteger r2 = new java.math.BigInteger     // Catch:{ Throwable -> 0x0027 }
            r2.<init>(r4, r0)     // Catch:{ Throwable -> 0x0027 }
            return r2
        L_0x0027:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.GenerateNotification.getAccentColor(org.json.JSONObject):java.math.BigInteger");
    }

    private static void addNotificationActionButtons(JSONObject jSONObject, NotificationCompat.Builder builder, int i, String str) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString(OSNotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM));
            if (jSONObject2.has(NotificationBundleProcessor.PUSH_ADDITIONAL_DATA_KEY)) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(NotificationBundleProcessor.PUSH_ADDITIONAL_DATA_KEY);
                if (jSONObject3.has("actionButtons")) {
                    JSONArray jSONArray = jSONObject3.getJSONArray("actionButtons");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        JSONObject jSONObject4 = new JSONObject(jSONObject.toString());
                        Intent newBaseIntent = getNewBaseIntent(i);
                        newBaseIntent.setAction("" + i2);
                        newBaseIntent.putExtra("action_button", true);
                        jSONObject4.put(BUNDLE_KEY_ACTION_ID, optJSONObject.optString("id"));
                        newBaseIntent.putExtra(BUNDLE_KEY_ONESIGNAL_DATA, jSONObject4.toString());
                        if (str != null) {
                            newBaseIntent.putExtra("summary", str);
                        } else if (jSONObject.has("grp")) {
                            newBaseIntent.putExtra("grp", jSONObject.optString("grp"));
                        }
                        builder.addAction(optJSONObject.has("icon") ? getResourceIcon(optJSONObject.optString("icon")) : 0, optJSONObject.optString("text"), getNewActionPendingIntent(i, newBaseIntent));
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static void addAlertButtons(Context context, JSONObject jSONObject, List<String> list, List<String> list2) {
        try {
            addCustomAlertButtons(context, jSONObject, list, list2);
        } catch (Throwable th) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "Failed to parse JSON for custom buttons for alert dialog.", th);
        }
        if (list.size() == 0 || list.size() < 3) {
            list.add(OSUtils.getResourceString(context, "onesignal_in_app_alert_ok_button_text", "Ok"));
            list2.add("__DEFAULT__");
        }
    }

    private static void addCustomAlertButtons(Context context, JSONObject jSONObject, List<String> list, List<String> list2) throws JSONException {
        JSONObject jSONObject2 = new JSONObject(jSONObject.optString(OSNotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM));
        if (jSONObject2.has(NotificationBundleProcessor.PUSH_ADDITIONAL_DATA_KEY)) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject(NotificationBundleProcessor.PUSH_ADDITIONAL_DATA_KEY);
            if (jSONObject3.has("actionButtons")) {
                JSONArray optJSONArray = jSONObject3.optJSONArray("actionButtons");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject4 = optJSONArray.getJSONObject(i);
                    list.add(jSONObject4.optString("text"));
                    list2.add(jSONObject4.optString("id"));
                }
            }
        }
    }
}
