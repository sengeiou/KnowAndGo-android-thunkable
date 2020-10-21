package com.onesignal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.onesignal.AndroidSupportV4Compat;
import com.onesignal.LocationController;
import com.onesignal.OneSignal;
import java.util.concurrent.ArrayBlockingQueue;

class OneSignalSyncServiceUtils {
    private static final long SYNC_AFTER_BG_DELAY_MS = 30000;
    private static final int SYNC_TASK_ID = 2071862118;
    /* access modifiers changed from: private */
    public static Long nextScheduledSyncTimeMs = 0L;
    private static Thread syncBgThread;

    OneSignalSyncServiceUtils() {
    }

    static void scheduleLocationUpdateTask(Context context, long j) {
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.VERBOSE;
        OneSignal.Log(log_level, "scheduleLocationUpdateTask:delayMs: " + j);
        scheduleSyncTask(context, j);
    }

    static void scheduleSyncTask(Context context) {
        OneSignal.Log(OneSignal.LOG_LEVEL.VERBOSE, "scheduleSyncTask:SYNC_AFTER_BG_DELAY_MS: 30000");
        scheduleSyncTask(context, 30000);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized void cancelSyncTask(android.content.Context r3) {
        /*
            java.lang.Class<com.onesignal.OneSignalSyncServiceUtils> r0 = com.onesignal.OneSignalSyncServiceUtils.class
            monitor-enter(r0)
            r1 = 0
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0039 }
            nextScheduledSyncTimeMs = r1     // Catch:{ all -> 0x0039 }
            boolean r1 = com.onesignal.LocationController.scheduleUpdate(r3)     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0013
            monitor-exit(r0)
            return
        L_0x0013:
            boolean r1 = useJob()     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0028
            java.lang.String r1 = "jobscheduler"
            java.lang.Object r3 = r3.getSystemService(r1)     // Catch:{ all -> 0x0039 }
            android.app.job.JobScheduler r3 = (android.app.job.JobScheduler) r3     // Catch:{ all -> 0x0039 }
            r1 = 2071862118(0x7b7e1b66, float:1.3193991E36)
            r3.cancel(r1)     // Catch:{ all -> 0x0039 }
            goto L_0x0037
        L_0x0028:
            java.lang.String r1 = "alarm"
            java.lang.Object r1 = r3.getSystemService(r1)     // Catch:{ all -> 0x0039 }
            android.app.AlarmManager r1 = (android.app.AlarmManager) r1     // Catch:{ all -> 0x0039 }
            android.app.PendingIntent r3 = syncServicePendingIntent(r3)     // Catch:{ all -> 0x0039 }
            r1.cancel(r3)     // Catch:{ all -> 0x0039 }
        L_0x0037:
            monitor-exit(r0)
            return
        L_0x0039:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OneSignalSyncServiceUtils.cancelSyncTask(android.content.Context):void");
    }

    private static PendingIntent syncServicePendingIntent(Context context) {
        return PendingIntent.getService(context, SYNC_TASK_ID, new Intent(context, SyncService.class), 134217728);
    }

    private static boolean useJob() {
        return Build.VERSION.SDK_INT >= 21;
    }

    private static synchronized void scheduleSyncTask(Context context, long j) {
        synchronized (OneSignalSyncServiceUtils.class) {
            if (nextScheduledSyncTimeMs.longValue() == 0 || System.currentTimeMillis() + j <= nextScheduledSyncTimeMs.longValue()) {
                if (j < DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS) {
                    j = 5000;
                }
                if (useJob()) {
                    scheduleSyncServiceAsJob(context, j);
                } else {
                    scheduleSyncServiceAsAlarm(context, j);
                }
                nextScheduledSyncTimeMs = Long.valueOf(System.currentTimeMillis() + j);
            }
        }
    }

    private static boolean hasBootPermission(Context context) {
        return AndroidSupportV4Compat.ContextCompat.checkSelfPermission(context, "android.permission.RECEIVE_BOOT_COMPLETED") == 0;
    }

    @RequiresApi(21)
    private static void scheduleSyncServiceAsJob(Context context, long j) {
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.VERBOSE;
        OneSignal.Log(log_level, "scheduleSyncServiceAsJob:atTime: " + j);
        JobInfo.Builder builder = new JobInfo.Builder(SYNC_TASK_ID, new ComponentName(context, SyncJobService.class));
        builder.setMinimumLatency(j).setRequiredNetworkType(1);
        if (hasBootPermission(context)) {
            builder.setPersisted(true);
        }
        try {
            int schedule = ((JobScheduler) context.getSystemService("jobscheduler")).schedule(builder.build());
            OneSignal.LOG_LEVEL log_level2 = OneSignal.LOG_LEVEL.INFO;
            OneSignal.Log(log_level2, "scheduleSyncServiceAsJob:result: " + schedule);
        } catch (NullPointerException e) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "scheduleSyncServiceAsJob called JobScheduler.jobScheduler which triggered an internal null Android error. Skipping job.", e);
        }
    }

    private static void scheduleSyncServiceAsAlarm(Context context, long j) {
        OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.VERBOSE;
        OneSignal.Log(log_level, "scheduleServiceSyncTask:atTime: " + j);
        ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(0, System.currentTimeMillis() + j + j, syncServicePendingIntent(context));
    }

    static void doBackgroundSync(Context context, SyncRunnable syncRunnable) {
        OneSignal.setAppContext(context);
        syncBgThread = new Thread(syncRunnable, "OS_SYNCSRV_BG_SYNC");
        syncBgThread.start();
    }

    static boolean stopSyncBgThread() {
        if (syncBgThread == null || !syncBgThread.isAlive()) {
            return false;
        }
        syncBgThread.interrupt();
        return true;
    }

    static abstract class SyncRunnable implements Runnable {
        /* access modifiers changed from: protected */
        public abstract void stopSync();

        SyncRunnable() {
        }

        public final void run() {
            synchronized (OneSignalSyncServiceUtils.class) {
                Long unused = OneSignalSyncServiceUtils.nextScheduledSyncTimeMs = 0L;
            }
            if (OneSignal.getUserId() == null) {
                stopSync();
                return;
            }
            OneSignal.appId = OneSignal.getSavedAppId();
            OneSignalStateSynchronizer.initUserState();
            try {
                final ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
                LocationController.getLocation(OneSignal.appContext, false, false, new LocationController.LocationHandler() {
                    public LocationController.PermissionType getType() {
                        return LocationController.PermissionType.SYNC_SERVICE;
                    }

                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.onesignal.LocationController$LocationPoint} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object} */
                    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.onesignal.LocationController$LocationPoint} */
                    /* JADX WARNING: Failed to insert additional move for type inference */
                    /* JADX WARNING: Multi-variable type inference failed */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void onComplete(com.onesignal.LocationController.LocationPoint r2) {
                        /*
                            r1 = this;
                            if (r2 == 0) goto L_0x0003
                            goto L_0x0008
                        L_0x0003:
                            java.lang.Object r2 = new java.lang.Object
                            r2.<init>()
                        L_0x0008:
                            java.util.concurrent.BlockingQueue r0 = r1
                            r0.offer(r2)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.OneSignalSyncServiceUtils.SyncRunnable.C24551.onComplete(com.onesignal.LocationController$LocationPoint):void");
                    }
                });
                Object take = arrayBlockingQueue.take();
                if (take instanceof LocationController.LocationPoint) {
                    OneSignalStateSynchronizer.updateLocation((LocationController.LocationPoint) take);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            OneSignalStateSynchronizer.syncUserState(true);
            FocusTimeController.getInstance().doBlockingBackgroundSyncOfUnsentTime();
            stopSync();
        }
    }

    @RequiresApi(api = 21)
    static class LollipopSyncRunnable extends SyncRunnable {
        private JobParameters jobParameters;
        private JobService jobService;

        LollipopSyncRunnable(JobService jobService2, JobParameters jobParameters2) {
            this.jobService = jobService2;
            this.jobParameters = jobParameters2;
        }

        /* access modifiers changed from: protected */
        public void stopSync() {
            OneSignal.Log(OneSignal.LOG_LEVEL.DEBUG, "LollipopSyncRunnable:JobFinished");
            this.jobService.jobFinished(this.jobParameters, false);
        }
    }

    static class LegacySyncRunnable extends SyncRunnable {
        Service callerService;

        LegacySyncRunnable(Service service) {
            this.callerService = service;
        }

        /* access modifiers changed from: protected */
        public void stopSync() {
            OneSignal.Log(OneSignal.LOG_LEVEL.DEBUG, "LegacySyncRunnable:Stopped");
            this.callerService.stopSelf();
        }
    }
}
