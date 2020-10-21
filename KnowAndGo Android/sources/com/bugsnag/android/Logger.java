package com.bugsnag.android;

import android.util.Log;

final class Logger {
    private static final String LOG_TAG = "Bugsnag";
    private static volatile boolean enabled = true;

    private Logger() {
    }

    static void info(String str) {
        if (enabled) {
            Log.i(LOG_TAG, str);
        }
    }

    static void warn(String str) {
        if (enabled) {
            Log.w(LOG_TAG, str);
        }
    }

    static void warn(String str, Throwable th) {
        if (enabled) {
            Log.w(LOG_TAG, str, th);
        }
    }

    static void setEnabled(boolean z) {
        enabled = z;
    }

    static boolean getEnabled() {
        return enabled;
    }
}
