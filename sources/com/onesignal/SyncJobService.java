package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;
import androidx.annotation.RequiresApi;
import com.onesignal.OneSignalSyncServiceUtils;

@RequiresApi(api = 21)
public class SyncJobService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        OneSignalSyncServiceUtils.doBackgroundSync(this, new OneSignalSyncServiceUtils.LollipopSyncRunnable(this, jobParameters));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return OneSignalSyncServiceUtils.stopSyncBgThread();
    }
}
