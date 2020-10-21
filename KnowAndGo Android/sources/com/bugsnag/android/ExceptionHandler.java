package com.bugsnag.android;

import android.os.StrictMode;
import androidx.annotation.NonNull;
import java.lang.Thread;
import java.util.Map;
import java.util.WeakHashMap;

class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final String STRICT_MODE_KEY = "Violation";
    private static final String STRICT_MODE_TAB = "StrictMode";
    final Map<Client, Boolean> clientMap = new WeakHashMap();
    private final Thread.UncaughtExceptionHandler originalHandler;
    private final StrictModeHandler strictModeHandler = new StrictModeHandler();

    static void enable(@NonNull Client client) {
        ExceptionHandler exceptionHandler;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof ExceptionHandler) {
            exceptionHandler = (ExceptionHandler) defaultUncaughtExceptionHandler;
        } else {
            ExceptionHandler exceptionHandler2 = new ExceptionHandler(defaultUncaughtExceptionHandler);
            Thread.setDefaultUncaughtExceptionHandler(exceptionHandler2);
            exceptionHandler = exceptionHandler2;
        }
        exceptionHandler.clientMap.put(client, true);
    }

    static void disable(@NonNull Client client) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof ExceptionHandler) {
            ExceptionHandler exceptionHandler = (ExceptionHandler) defaultUncaughtExceptionHandler;
            exceptionHandler.clientMap.remove(client);
            if (exceptionHandler.clientMap.isEmpty()) {
                Thread.setDefaultUncaughtExceptionHandler(exceptionHandler.originalHandler);
            }
        }
    }

    ExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.originalHandler = uncaughtExceptionHandler;
    }

    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
        String str;
        MetaData metaData;
        boolean isStrictModeThrowable = this.strictModeHandler.isStrictModeThrowable(th);
        for (Client next : this.clientMap.keySet()) {
            MetaData metaData2 = new MetaData();
            if (isStrictModeThrowable) {
                String violationDescription = this.strictModeHandler.getViolationDescription(th.getMessage());
                MetaData metaData3 = new MetaData();
                metaData3.addToTab(STRICT_MODE_TAB, STRICT_MODE_KEY, violationDescription);
                str = violationDescription;
                metaData = metaData3;
            } else {
                metaData = metaData2;
                str = null;
            }
            String str2 = isStrictModeThrowable ? "strictMode" : "unhandledException";
            if (isStrictModeThrowable) {
                StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
                next.cacheAndNotify(th, Severity.ERROR, metaData, str2, str, thread);
                StrictMode.setThreadPolicy(threadPolicy);
            } else {
                next.cacheAndNotify(th, Severity.ERROR, metaData, str2, str, thread);
            }
        }
        if (this.originalHandler != null) {
            this.originalHandler.uncaughtException(thread, th);
            return;
        }
        System.err.printf("Exception in thread \"%s\" ", new Object[]{thread.getName()});
        Logger.warn("Exception", th);
    }
}
