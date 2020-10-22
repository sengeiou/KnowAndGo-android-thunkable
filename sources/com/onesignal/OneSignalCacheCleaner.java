package com.onesignal;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.WorkerThread;
import com.onesignal.OneSignal;
import com.onesignal.OneSignalDbContract;
import com.onesignal.influence.model.OSInfluenceChannel;
import com.onesignal.outcomes.OSOutcomeTableProvider;

class OneSignalCacheCleaner {
    private static final long NOTIFICATION_CACHE_DATA_LIFETIME = 604800;
    private static final String OS_DELETE_CACHED_NOTIFICATIONS_THREAD = "OS_DELETE_CACHED_NOTIFICATIONS_THREAD";
    private static final String OS_DELETE_CACHED_REDISPLAYED_IAMS_THREAD = "OS_DELETE_CACHED_REDISPLAYED_IAMS_THREAD";

    OneSignalCacheCleaner() {
    }

    static void cleanOldCachedData(Context context) {
        OneSignalDbHelper instance = OneSignalDbHelper.getInstance(context);
        cleanNotificationCache(instance.getSQLiteDatabaseWithRetries());
        cleanCachedInAppMessages(instance);
    }

    static synchronized void cleanNotificationCache(final SQLiteDatabase sQLiteDatabase) {
        synchronized (OneSignalCacheCleaner.class) {
            new Thread(new Runnable() {
                public void run() {
                    String str;
                    Thread.currentThread().setPriority(10);
                    sQLiteDatabase.beginTransaction();
                    try {
                        OneSignalCacheCleaner.cleanCachedNotifications(sQLiteDatabase);
                        OneSignalCacheCleaner.cleanCachedUniqueOutcomeEventNotifications(sQLiteDatabase);
                        sQLiteDatabase.setTransactionSuccessful();
                    } finally {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (SQLException e) {
                            str = "Error closing transaction! ";
                            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, str, e);
                        }
                    }
                }
            }, OS_DELETE_CACHED_NOTIFICATIONS_THREAD).start();
        }
    }

    @WorkerThread
    static synchronized void cleanCachedInAppMessages(final OneSignalDbHelper oneSignalDbHelper) {
        synchronized (OneSignalCacheCleaner.class) {
            new Thread(new Runnable() {
                public void run() {
                    Thread.currentThread().setPriority(10);
                    OSInAppMessageController.getController().getInAppMessageRepository(oneSignalDbHelper).cleanCachedInAppMessages();
                }
            }, OS_DELETE_CACHED_REDISPLAYED_IAMS_THREAD).start();
        }
    }

    /* access modifiers changed from: private */
    public static void cleanCachedNotifications(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.delete(OneSignalDbContract.NotificationTable.TABLE_NAME, "created_time < ?", new String[]{String.valueOf((System.currentTimeMillis() / 1000) - NOTIFICATION_CACHE_DATA_LIFETIME)});
    }

    /* access modifiers changed from: private */
    public static void cleanCachedUniqueOutcomeEventNotifications(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.delete(OSOutcomeTableProvider.CACHE_UNIQUE_OUTCOME_TABLE, "NOT EXISTS(SELECT NULL FROM notification n WHERE n.notification_id = channel_influence_id AND channel_type = \"" + OSInfluenceChannel.NOTIFICATION.toString().toLowerCase() + "\")", (String[]) null);
    }
}
