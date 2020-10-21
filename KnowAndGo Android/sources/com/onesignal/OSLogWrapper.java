package com.onesignal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.onesignal.OneSignal;

class OSLogWrapper implements OSLogger {
    OSLogWrapper() {
    }

    public void verbose(@NonNull String str) {
        OneSignal.Log(OneSignal.LOG_LEVEL.VERBOSE, str);
    }

    public void debug(@NonNull String str) {
        OneSignal.Log(OneSignal.LOG_LEVEL.DEBUG, str);
    }

    public void warning(@NonNull String str) {
        OneSignal.Log(OneSignal.LOG_LEVEL.WARN, str);
    }

    public void error(@NonNull String str, @Nullable Throwable th) {
        OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, str, th);
    }
}
