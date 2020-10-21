package com.onesignal;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.onesignal.OneSignalSyncServiceUtils;

public class SyncService extends Service {
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        OneSignalSyncServiceUtils.doBackgroundSync(this, new OneSignalSyncServiceUtils.LegacySyncRunnable(this));
        return 1;
    }
}
