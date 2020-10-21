package com.bugsnag.android.ndk;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bugsnag.android.Breadcrumb;
import com.bugsnag.android.Configuration;
import com.bugsnag.android.NativeInterface;
import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NativeBridge implements Observer {
    private static final String LOG_TAG = "BugsnagNDK:NativeBridge";
    private static final int METADATA_KEY = 1;
    private static final int METADATA_SECTION = 0;
    private static final int METADATA_VALUE = 2;
    private static final AtomicBoolean installed = new AtomicBoolean(false);
    private static final Lock lock = new ReentrantLock();
    private boolean loggingEnabled;
    private final String reportDirectory;

    public static native void addBreadcrumb(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull Object obj);

    public static native void addHandledEvent();

    public static native void addMetadataBoolean(@NonNull String str, @NonNull String str2, boolean z);

    public static native void addMetadataDouble(@NonNull String str, @NonNull String str2, double d);

    public static native void addMetadataString(@NonNull String str, @NonNull String str2, @NonNull String str3);

    public static native void addUnhandledEvent();

    public static native void clearBreadcrumbs();

    public static native void clearMetadataTab(@NonNull String str);

    public static native void deliverReportAtPath(@NonNull String str);

    public static native void disableCrashReporting();

    public static native void enableCrashReporting();

    public static native void install(@NonNull String str, boolean z, int i, boolean z2);

    public static native void removeMetadata(@NonNull String str, @NonNull String str2);

    public static native void startedSession(@NonNull String str, @NonNull String str2, int i, int i2);

    public static native void stoppedSession();

    public static native void updateAppVersion(@NonNull String str);

    public static native void updateBuildUUID(@NonNull String str);

    public static native void updateContext(@NonNull String str);

    public static native void updateInForeground(boolean z, @NonNull String str);

    public static native void updateLowMemory(boolean z);

    public static native void updateMetadata(@NonNull Object obj);

    public static native void updateOrientation(int i);

    public static native void updateReleaseStage(@NonNull String str);

    public static native void updateUserEmail(@NonNull String str);

    public static native void updateUserId(@NonNull String str);

    public static native void updateUserName(@NonNull String str);

    public NativeBridge() {
        this.loggingEnabled = true;
        this.loggingEnabled = NativeInterface.getLoggingEnabled();
        this.reportDirectory = NativeInterface.getNativeReportPath();
        File file = new File(this.reportDirectory);
        if (!file.exists() && !file.mkdirs()) {
            warn("The native reporting directory cannot be created.");
        }
    }

    public void update(@NonNull Observable observable, @Nullable Object obj) {
        NativeInterface.Message parseMessage = parseMessage(obj);
        if (parseMessage != null) {
            Object obj2 = parseMessage.value;
            switch (parseMessage.type) {
                case INSTALL:
                    handleInstallMessage(obj2);
                    return;
                case ENABLE_NATIVE_CRASH_REPORTING:
                    enableCrashReporting();
                    return;
                case DISABLE_NATIVE_CRASH_REPORTING:
                    disableCrashReporting();
                    return;
                case DELIVER_PENDING:
                    deliverPendingReports();
                    return;
                case ADD_BREADCRUMB:
                    handleAddBreadcrumb(obj2);
                    return;
                case ADD_METADATA:
                    handleAddMetadata(obj2);
                    return;
                case CLEAR_BREADCRUMBS:
                    clearBreadcrumbs();
                    return;
                case CLEAR_METADATA_TAB:
                    handleClearMetadataTab(obj2);
                    return;
                case NOTIFY_HANDLED:
                    addHandledEvent();
                    return;
                case NOTIFY_UNHANDLED:
                    addUnhandledEvent();
                    return;
                case REMOVE_METADATA:
                    handleRemoveMetadata(obj2);
                    return;
                case START_SESSION:
                    handleStartSession(obj2);
                    return;
                case STOP_SESSION:
                    stoppedSession();
                    return;
                case UPDATE_APP_VERSION:
                    handleAppVersionChange(obj2);
                    return;
                case UPDATE_BUILD_UUID:
                    handleBuildUUIDChange(obj2);
                    return;
                case UPDATE_CONTEXT:
                    handleContextChange(obj2);
                    return;
                case UPDATE_IN_FOREGROUND:
                    handleForegroundActivityChange(obj2);
                    return;
                case UPDATE_LOW_MEMORY:
                    handleLowMemoryChange(obj2);
                    return;
                case UPDATE_METADATA:
                    handleUpdateMetadata(obj2);
                    return;
                case UPDATE_ORIENTATION:
                    handleOrientationChange(obj2);
                    return;
                case UPDATE_RELEASE_STAGE:
                    handleReleaseStageChange(obj2);
                    return;
                case UPDATE_NOTIFY_RELEASE_STAGES:
                    handleNotifyReleaseStagesChange(obj2);
                    return;
                case UPDATE_USER_ID:
                    handleUserIdChange(obj2);
                    return;
                case UPDATE_USER_NAME:
                    handleUserNameChange(obj2);
                    return;
                case UPDATE_USER_EMAIL:
                    handleUserEmailChange(obj2);
                    return;
                default:
                    return;
            }
        }
    }

    @Nullable
    private NativeInterface.Message parseMessage(@Nullable Object obj) {
        if (obj instanceof NativeInterface.Message) {
            NativeInterface.Message message = (NativeInterface.Message) obj;
            if (message.type == NativeInterface.MessageType.INSTALL || installed.get()) {
                return message;
            }
            warn("Received message before INSTALL: " + message.type);
            return null;
        }
        if (obj == null) {
            warn("Received observable update with null Message");
        } else {
            warn("Received observable update object which is not instance of Message: " + obj.getClass());
        }
        return null;
    }

    private void deliverPendingReports() {
        lock.lock();
        try {
            File file = new File(this.reportDirectory);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File absolutePath : listFiles) {
                        deliverReportAtPath(absolutePath.getAbsolutePath());
                    }
                }
            } else {
                warn("Report directory does not exist, cannot read pending reports");
            }
        } catch (Exception e) {
            warn("Failed to parse/write pending reports: " + e);
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
        lock.unlock();
    }

    private void handleInstallMessage(@NonNull Object obj) {
        lock.lock();
        try {
            if (installed.get()) {
                warn("Received duplicate setup message with arg: " + obj);
            } else if (obj instanceof List) {
                List list = (List) obj;
                if (list.size() > 0 && (list.get(0) instanceof Configuration)) {
                    install(this.reportDirectory + UUID.randomUUID().toString() + ".crash", ((Configuration) list.get(0)).getDetectNdkCrashes(), Build.VERSION.SDK_INT, is32bit());
                    installed.set(true);
                }
            } else {
                warn("Received install message with incorrect arg: " + obj);
            }
        } finally {
            lock.unlock();
        }
    }

    private boolean is32bit() {
        for (String contains : NativeInterface.getCpuAbi()) {
            if (contains.contains("64")) {
                return false;
            }
        }
        return true;
    }

    private void handleAddBreadcrumb(Object obj) {
        if (obj instanceof Breadcrumb) {
            Breadcrumb breadcrumb = (Breadcrumb) obj;
            HashMap hashMap = new HashMap();
            if (breadcrumb.getMetadata() != null) {
                for (Map.Entry next : breadcrumb.getMetadata().entrySet()) {
                    if (next.getValue() != null) {
                        hashMap.put(makeSafe((String) next.getKey()), makeSafe((String) next.getValue()));
                    }
                }
            }
            addBreadcrumb(breadcrumb.getName(), breadcrumb.getType().toString(), breadcrumb.getTimestamp(), hashMap);
            return;
        }
        warn("Attempted to add non-breadcrumb: " + obj);
    }

    private void handleAddMetadata(Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() == 3 && (list.get(0) instanceof String) && (list.get(1) instanceof String)) {
                String makeSafe = makeSafe((String) list.get(0));
                String makeSafe2 = makeSafe((String) list.get(1));
                if (list.get(2) instanceof String) {
                    addMetadataString(makeSafe, makeSafe2, makeSafe((String) list.get(2)));
                    return;
                } else if (list.get(2) instanceof Boolean) {
                    addMetadataBoolean(makeSafe, makeSafe2, ((Boolean) list.get(2)).booleanValue());
                    return;
                } else if (list.get(2) instanceof Number) {
                    addMetadataDouble(makeSafe, makeSafe2, ((Number) list.get(2)).doubleValue());
                    return;
                }
            } else if (list.size() == 2 && (list.get(0) instanceof String) && (list.get(1) instanceof String)) {
                removeMetadata(makeSafe((String) list.get(0)), makeSafe((String) list.get(1)));
                return;
            }
        }
        warn("ADD_METADATA object is invalid: " + obj);
    }

    private void handleClearMetadataTab(Object obj) {
        if (obj instanceof String) {
            clearMetadataTab(makeSafe((String) obj));
            return;
        }
        warn("CLEAR_METADATA_TAB object is invalid: " + obj);
    }

    private void handleAppVersionChange(Object obj) {
        if (obj instanceof String) {
            updateAppVersion(makeSafe((String) obj));
            return;
        }
        warn("UPDATE_APP_VERSION object is invalid: " + obj);
    }

    private void handleRemoveMetadata(Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() == 2) {
                removeMetadata(makeSafe((String) list.get(0)), makeSafe((String) list.get(1)));
                return;
            }
        }
        warn("REMOVE_METADATA object is invalid: " + obj);
    }

    private void handleStartSession(Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() == 4) {
                Object obj2 = list.get(0);
                Object obj3 = list.get(1);
                Object obj4 = list.get(2);
                Object obj5 = list.get(3);
                if ((obj2 instanceof String) && (obj3 instanceof String) && (obj4 instanceof Integer) && (obj5 instanceof Integer)) {
                    startedSession((String) obj2, (String) obj3, ((Integer) obj4).intValue(), ((Integer) obj5).intValue());
                    return;
                }
            }
        }
        warn("START_SESSION object is invalid: " + obj);
    }

    private void handleStopSession() {
        stoppedSession();
    }

    private void handleReleaseStageChange(Object obj) {
        if (obj instanceof Configuration) {
            Configuration configuration = (Configuration) obj;
            updateReleaseStage(makeSafe(configuration.getReleaseStage()));
            enableOrDisableReportingIfNeeded(configuration);
            return;
        }
        warn("UPDATE_RELEASE_STAGE object is invalid: " + obj);
    }

    private void handleNotifyReleaseStagesChange(Object obj) {
        if (obj instanceof Configuration) {
            enableOrDisableReportingIfNeeded((Configuration) obj);
            return;
        }
        warn("UPDATE_NOTIFY_RELEASE_STAGES object is invalid: " + obj);
    }

    private void enableOrDisableReportingIfNeeded(Configuration configuration) {
        if (!configuration.shouldNotifyForReleaseStage(configuration.getReleaseStage())) {
            disableCrashReporting();
        } else if (configuration.getDetectNdkCrashes()) {
            enableCrashReporting();
        }
    }

    private void handleOrientationChange(Object obj) {
        if (obj instanceof Integer) {
            updateOrientation(((Integer) obj).intValue());
        } else if (obj == null) {
            warn("UPDATE_ORIENTATION object is null");
        } else {
            warn("UPDATE_ORIENTATION object is invalid: " + obj);
        }
    }

    private void handleForegroundActivityChange(Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() == 2) {
                updateInForeground(((Boolean) list.get(0)).booleanValue(), makeSafe((String) list.get(1)));
                return;
            }
        }
        warn("UPDATE_IN_FOREGROUND object is invalid: " + obj);
    }

    private void handleUserIdChange(Object obj) {
        if (obj == null) {
            updateUserId("");
        } else if (obj instanceof String) {
            updateUserId(makeSafe((String) obj));
        } else {
            warn("UPDATE_USER_ID object is invalid: " + obj);
        }
    }

    private void handleUserNameChange(Object obj) {
        if (obj == null) {
            updateUserName("");
        } else if (obj instanceof String) {
            updateUserName(makeSafe((String) obj));
        } else {
            warn("UPDATE_USER_NAME object is invalid: " + obj);
        }
    }

    private void handleUserEmailChange(Object obj) {
        if (obj == null) {
            updateUserEmail("");
        } else if (obj instanceof String) {
            updateUserEmail(makeSafe((String) obj));
        } else {
            warn("UPDATE_USER_EMAIL object is invalid: " + obj);
        }
    }

    private void handleBuildUUIDChange(Object obj) {
        if (obj == null) {
            updateBuildUUID("");
        } else if (obj instanceof String) {
            updateBuildUUID(makeSafe((String) obj));
        } else {
            warn("UPDATE_BUILD_UUID object is invalid: " + obj);
        }
    }

    private void handleContextChange(Object obj) {
        if (obj == null) {
            updateContext("");
        } else if (obj instanceof String) {
            updateContext(makeSafe((String) obj));
        } else {
            warn("UPDATE_CONTEXT object is invalid: " + obj);
        }
    }

    private void handleLowMemoryChange(Object obj) {
        if (obj instanceof Boolean) {
            updateLowMemory(((Boolean) obj).booleanValue());
            return;
        }
        warn("UPDATE_LOW_MEMORY object is invalid: " + obj);
    }

    private void handleUpdateMetadata(Object obj) {
        if (obj instanceof Map) {
            updateMetadata(obj);
            return;
        }
        warn("UPDATE_METADATA object is invalid: " + obj);
    }

    private String makeSafe(String str) {
        if (str == null) {
            return null;
        }
        return new String(str.getBytes(Charset.defaultCharset()));
    }

    private void warn(String str) {
        if (this.loggingEnabled) {
            Log.w(LOG_TAG, str);
        }
    }
}
