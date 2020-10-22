package com.bugsnag.android;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.annotation.Nullable;
import java.util.List;

class ForegroundDetector {
    private final ActivityManager activityManager;

    ForegroundDetector(Context context) {
        this.activityManager = (ActivityManager) context.getSystemService("activity");
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Boolean isInForeground() {
        try {
            ActivityManager.RunningAppProcessInfo processInfo = getProcessInfo();
            if (processInfo == null) {
                return null;
            }
            return Boolean.valueOf(processInfo.importance <= 100);
        } catch (RuntimeException unused) {
            return null;
        }
    }

    private ActivityManager.RunningAppProcessInfo getProcessInfo() {
        if (Build.VERSION.SDK_INT < 16) {
            return getProcessInfoPreApi16();
        }
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo;
    }

    @Nullable
    private ActivityManager.RunningAppProcessInfo getProcessInfoPreApi16() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (myPid == next.pid) {
                return next;
            }
        }
        return null;
    }
}
