package expo.modules.updates;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.JSBundleLoader;
import expo.modules.updates.launcher.DatabaseLauncher;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.launcher.SelectionPolicy;
import expo.modules.updates.launcher.SelectionPolicyNewest;
import expo.modules.updates.p021db.Reaper;
import expo.modules.updates.p021db.UpdatesDatabase;
import expo.modules.updates.p021db.entity.AssetEntity;
import expo.modules.updates.p021db.entity.UpdateEntity;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Map;

public class UpdatesController {
    /* access modifiers changed from: private */
    public static final String TAG = "UpdatesController";
    private static final String UPDATE_AVAILABLE_EVENT = "updateAvailable";
    private static final String UPDATE_ERROR_EVENT = "error";
    private static final String UPDATE_NO_UPDATE_AVAILABLE_EVENT = "noUpdateAvailable";
    private static UpdatesController sInstance;
    private DatabaseHolder mDatabaseHolder;
    private HandlerThread mHandlerThread;
    /* access modifiers changed from: private */
    public boolean mHasLaunched = false;
    /* access modifiers changed from: private */
    public boolean mIsEmergencyLaunch = false;
    /* access modifiers changed from: private */
    public boolean mIsReadyToLaunch = false;
    /* access modifiers changed from: private */
    public Launcher mLauncher;
    /* access modifiers changed from: private */
    public WeakReference<ReactNativeHost> mReactNativeHost;
    /* access modifiers changed from: private */
    public SelectionPolicy mSelectionPolicy;
    private boolean mTimeoutFinished = false;
    private UpdatesConfiguration mUpdatesConfiguration;
    /* access modifiers changed from: private */
    public File mUpdatesDirectory;
    private Exception mUpdatesDirectoryException;

    private UpdatesController(Context context, UpdatesConfiguration updatesConfiguration) {
        this.mUpdatesConfiguration = updatesConfiguration;
        this.mDatabaseHolder = new DatabaseHolder(UpdatesDatabase.getInstance(context));
        this.mSelectionPolicy = new SelectionPolicyNewest(UpdatesUtils.getRuntimeVersion(updatesConfiguration));
        if (context instanceof ReactApplication) {
            this.mReactNativeHost = new WeakReference<>(((ReactApplication) context).getReactNativeHost());
        }
        try {
            this.mUpdatesDirectory = UpdatesUtils.getOrCreateUpdatesDirectory(context);
        } catch (Exception e) {
            this.mUpdatesDirectoryException = e;
            this.mUpdatesDirectory = null;
        }
        this.mHandlerThread = new HandlerThread("expo-updates-timer");
    }

    public static UpdatesController getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        throw new IllegalStateException("UpdatesController.getInstance() was called before the module was initialized");
    }

    public static void initialize(Context context) {
        if (sInstance == null) {
            sInstance = new UpdatesController(context, new UpdatesConfiguration().loadValuesFromMetadata(context));
            sInstance.start(context);
        }
    }

    public static void initialize(Context context, Map<String, Object> map) {
        if (sInstance == null) {
            sInstance = new UpdatesController(context, new UpdatesConfiguration().loadValuesFromMetadata(context).loadValuesFromMap(map));
            sInstance.start(context);
        }
    }

    public void setReactNativeHost(ReactNativeHost reactNativeHost) {
        this.mReactNativeHost = new WeakReference<>(reactNativeHost);
    }

    private class DatabaseHolder {
        private boolean isInUse = false;
        private UpdatesDatabase mDatabase;

        public DatabaseHolder(UpdatesDatabase updatesDatabase) {
            this.mDatabase = updatesDatabase;
        }

        public synchronized UpdatesDatabase getDatabase() {
            while (this.isInUse) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Log.e(UpdatesController.TAG, "Interrupted while waiting for database", e);
                }
            }
            this.isInUse = true;
            return this.mDatabase;
        }

        public synchronized void releaseDatabase() {
            this.isInUse = false;
            notify();
        }
    }

    public UpdatesDatabase getDatabase() {
        return this.mDatabaseHolder.getDatabase();
    }

    public void releaseDatabase() {
        this.mDatabaseHolder.releaseDatabase();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001b, code lost:
        return r3.mLauncher.getLaunchAssetFile();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000a, code lost:
        r3.mHasLaunched = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000f, code lost:
        if (r3.mLauncher != null) goto L_0x0014;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String getLaunchAssetFile() {
        /*
            r3 = this;
            monitor-enter(r3)
        L_0x0001:
            boolean r0 = r3.mIsReadyToLaunch     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x001c
            boolean r0 = r3.mTimeoutFinished     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x000a
            goto L_0x001c
        L_0x000a:
            r0 = 1
            r3.mHasLaunched = r0     // Catch:{ all -> 0x0029 }
            expo.modules.updates.launcher.Launcher r0 = r3.mLauncher     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x0014
            r0 = 0
            monitor-exit(r3)
            return r0
        L_0x0014:
            expo.modules.updates.launcher.Launcher r0 = r3.mLauncher     // Catch:{ all -> 0x0029 }
            java.lang.String r0 = r0.getLaunchAssetFile()     // Catch:{ all -> 0x0029 }
            monitor-exit(r3)
            return r0
        L_0x001c:
            r3.wait()     // Catch:{ InterruptedException -> 0x0020 }
            goto L_0x0001
        L_0x0020:
            r0 = move-exception
            java.lang.String r1 = TAG     // Catch:{ all -> 0x0029 }
            java.lang.String r2 = "Interrupted while waiting for launch asset file"
            android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0029 }
            goto L_0x0001
        L_0x0029:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.UpdatesController.getLaunchAssetFile():java.lang.String");
    }

    @Nullable
    public String getBundleAssetName() {
        if (this.mLauncher == null) {
            return null;
        }
        return this.mLauncher.getBundleAssetName();
    }

    @Nullable
    public Map<AssetEntity, String> getLocalAssetFiles() {
        if (this.mLauncher == null) {
            return null;
        }
        return this.mLauncher.getLocalAssetFiles();
    }

    public boolean isUsingEmbeddedAssets() {
        if (this.mLauncher == null) {
            return true;
        }
        return this.mLauncher.isUsingEmbeddedAssets();
    }

    public Uri getUpdateUrl() {
        return this.mUpdatesConfiguration.getUpdateUrl();
    }

    public UpdatesConfiguration getUpdatesConfiguration() {
        return this.mUpdatesConfiguration;
    }

    public File getUpdatesDirectory() {
        return this.mUpdatesDirectory;
    }

    public UpdateEntity getLaunchedUpdate() {
        return this.mLauncher.getLaunchedUpdate();
    }

    public SelectionPolicy getSelectionPolicy() {
        return this.mSelectionPolicy;
    }

    public boolean isEmergencyLaunch() {
        return this.mIsEmergencyLaunch;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void start(final android.content.Context r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            expo.modules.updates.UpdatesConfiguration r0 = r6.mUpdatesConfiguration     // Catch:{ all -> 0x00ad }
            boolean r0 = r0.isEnabled()     // Catch:{ all -> 0x00ad }
            if (r0 != 0) goto L_0x0010
            expo.modules.updates.launcher.NoDatabaseLauncher r0 = new expo.modules.updates.launcher.NoDatabaseLauncher     // Catch:{ all -> 0x00ad }
            r0.<init>(r7)     // Catch:{ all -> 0x00ad }
            r6.mLauncher = r0     // Catch:{ all -> 0x00ad }
        L_0x0010:
            java.io.File r0 = r6.mUpdatesDirectory     // Catch:{ all -> 0x00ad }
            r1 = 1
            if (r0 != 0) goto L_0x0020
            expo.modules.updates.launcher.NoDatabaseLauncher r0 = new expo.modules.updates.launcher.NoDatabaseLauncher     // Catch:{ all -> 0x00ad }
            java.lang.Exception r2 = r6.mUpdatesDirectoryException     // Catch:{ all -> 0x00ad }
            r0.<init>(r7, r2)     // Catch:{ all -> 0x00ad }
            r6.mLauncher = r0     // Catch:{ all -> 0x00ad }
            r6.mIsEmergencyLaunch = r1     // Catch:{ all -> 0x00ad }
        L_0x0020:
            expo.modules.updates.launcher.Launcher r0 = r6.mLauncher     // Catch:{ all -> 0x00ad }
            if (r0 == 0) goto L_0x002a
            r6.mIsReadyToLaunch = r1     // Catch:{ all -> 0x00ad }
            r6.mTimeoutFinished = r1     // Catch:{ all -> 0x00ad }
            monitor-exit(r6)
            return
        L_0x002a:
            expo.modules.updates.UpdatesConfiguration r0 = r6.mUpdatesConfiguration     // Catch:{ all -> 0x00ad }
            android.net.Uri r0 = r0.getUpdateUrl()     // Catch:{ all -> 0x00ad }
            if (r0 == 0) goto L_0x00a5
            expo.modules.updates.UpdatesConfiguration r0 = r6.mUpdatesConfiguration     // Catch:{ all -> 0x00ad }
            boolean r0 = expo.modules.updates.UpdatesUtils.shouldCheckForUpdateOnLaunch(r0, r7)     // Catch:{ all -> 0x00ad }
            expo.modules.updates.UpdatesConfiguration r2 = r6.getUpdatesConfiguration()     // Catch:{ all -> 0x00ad }
            int r2 = r2.getLaunchWaitMs()     // Catch:{ all -> 0x00ad }
            if (r2 <= 0) goto L_0x005e
            if (r0 == 0) goto L_0x005e
            android.os.HandlerThread r1 = r6.mHandlerThread     // Catch:{ all -> 0x00ad }
            r1.start()     // Catch:{ all -> 0x00ad }
            android.os.Handler r1 = new android.os.Handler     // Catch:{ all -> 0x00ad }
            android.os.HandlerThread r3 = r6.mHandlerThread     // Catch:{ all -> 0x00ad }
            android.os.Looper r3 = r3.getLooper()     // Catch:{ all -> 0x00ad }
            r1.<init>(r3)     // Catch:{ all -> 0x00ad }
            expo.modules.updates.-$$Lambda$UpdatesController$jZYCnGfQv0VGf3Ud1iuPlhAGzqw r3 = new expo.modules.updates.-$$Lambda$UpdatesController$jZYCnGfQv0VGf3Ud1iuPlhAGzqw     // Catch:{ all -> 0x00ad }
            r3.<init>()     // Catch:{ all -> 0x00ad }
            long r4 = (long) r2     // Catch:{ all -> 0x00ad }
            r1.postDelayed(r3, r4)     // Catch:{ all -> 0x00ad }
            goto L_0x0060
        L_0x005e:
            r6.mTimeoutFinished = r1     // Catch:{ all -> 0x00ad }
        L_0x0060:
            expo.modules.updates.db.UpdatesDatabase r1 = r6.getDatabase()     // Catch:{ all -> 0x00ad }
            expo.modules.updates.launcher.DatabaseLauncher r2 = new expo.modules.updates.launcher.DatabaseLauncher     // Catch:{ all -> 0x00ad }
            java.io.File r3 = r6.mUpdatesDirectory     // Catch:{ all -> 0x00ad }
            expo.modules.updates.launcher.SelectionPolicy r4 = r6.mSelectionPolicy     // Catch:{ all -> 0x00ad }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00ad }
            r6.mLauncher = r2     // Catch:{ all -> 0x00ad }
            expo.modules.updates.launcher.SelectionPolicy r3 = r6.mSelectionPolicy     // Catch:{ all -> 0x00ad }
            expo.modules.updates.manifest.Manifest r4 = expo.modules.updates.loader.EmbeddedLoader.readEmbeddedManifest(r7)     // Catch:{ all -> 0x00ad }
            expo.modules.updates.db.entity.UpdateEntity r4 = r4.getUpdateEntity()     // Catch:{ all -> 0x00ad }
            expo.modules.updates.db.entity.UpdateEntity r5 = r2.getLaunchableUpdate(r1, r7)     // Catch:{ all -> 0x00ad }
            boolean r3 = r3.shouldLoadNewUpdate(r4, r5)     // Catch:{ all -> 0x00ad }
            if (r3 == 0) goto L_0x008d
            expo.modules.updates.loader.EmbeddedLoader r3 = new expo.modules.updates.loader.EmbeddedLoader     // Catch:{ all -> 0x00ad }
            java.io.File r4 = r6.mUpdatesDirectory     // Catch:{ all -> 0x00ad }
            r3.<init>(r7, r1, r4)     // Catch:{ all -> 0x00ad }
            r3.loadEmbeddedUpdate()     // Catch:{ all -> 0x00ad }
        L_0x008d:
            expo.modules.updates.UpdatesController$1 r3 = new expo.modules.updates.UpdatesController$1     // Catch:{ all -> 0x00ad }
            r3.<init>(r7)     // Catch:{ all -> 0x00ad }
            r2.launch(r1, r7, r3)     // Catch:{ all -> 0x00ad }
            if (r0 == 0) goto L_0x00a0
            expo.modules.updates.-$$Lambda$UpdatesController$cVwvsx9XXcX6YuWbf7IvrVkJAiA r0 = new expo.modules.updates.-$$Lambda$UpdatesController$cVwvsx9XXcX6YuWbf7IvrVkJAiA     // Catch:{ all -> 0x00ad }
            r0.<init>(r7, r1)     // Catch:{ all -> 0x00ad }
            android.os.AsyncTask.execute(r0)     // Catch:{ all -> 0x00ad }
            goto L_0x00a3
        L_0x00a0:
            r6.runReaper()     // Catch:{ all -> 0x00ad }
        L_0x00a3:
            monitor-exit(r6)
            return
        L_0x00a5:
            java.lang.AssertionError r7 = new java.lang.AssertionError     // Catch:{ all -> 0x00ad }
            java.lang.String r0 = "expo-updates is enabled, but no valid updateUrl is configured in AndroidManifest.xml. If you are making a release build for the first time, make sure you have run `expo publish` at least once."
            r7.<init>(r0)     // Catch:{ all -> 0x00ad }
            throw r7     // Catch:{ all -> 0x00ad }
        L_0x00ad:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.UpdatesController.start(android.content.Context):void");
    }

    /* access modifiers changed from: private */
    public synchronized void finishTimeout() {
        if (!this.mTimeoutFinished) {
            this.mTimeoutFinished = true;
            notify();
        }
        this.mHandlerThread.quitSafely();
    }

    /* access modifiers changed from: private */
    public void runReaper() {
        AsyncTask.execute(new Runnable() {
            public final void run() {
                UpdatesController.lambda$runReaper$1(UpdatesController.this);
            }
        });
    }

    public static /* synthetic */ void lambda$runReaper$1(UpdatesController updatesController) {
        Reaper.reapUnusedUpdates(updatesController.getDatabase(), updatesController.mUpdatesDirectory, updatesController.getLaunchedUpdate(), updatesController.mSelectionPolicy);
        updatesController.releaseDatabase();
    }

    public void relaunchReactApplication(Context context, Launcher.LauncherCallback launcherCallback) {
        if (this.mReactNativeHost == null || this.mReactNativeHost.get() == null) {
            launcherCallback.onFailure(new Exception("Could not reload application. Ensure you have passed the correct instance of ReactApplication into UpdatesController.initialize()."));
            return;
        }
        final ReactNativeHost reactNativeHost = (ReactNativeHost) this.mReactNativeHost.get();
        final String launchAssetFile = this.mLauncher.getLaunchAssetFile();
        UpdatesDatabase database = getDatabase();
        DatabaseLauncher databaseLauncher = new DatabaseLauncher(this.mUpdatesDirectory, this.mSelectionPolicy);
        final Launcher.LauncherCallback launcherCallback2 = launcherCallback;
        final DatabaseLauncher databaseLauncher2 = databaseLauncher;
        databaseLauncher.launch(database, context, new Launcher.LauncherCallback() {
            public void onFailure(Exception exc) {
                launcherCallback2.onFailure(exc);
            }

            public void onSuccess() {
                Launcher unused = UpdatesController.this.mLauncher = databaseLauncher2;
                UpdatesController.this.releaseDatabase();
                ReactInstanceManager reactInstanceManager = reactNativeHost.getReactInstanceManager();
                String launchAssetFile = UpdatesController.this.mLauncher.getLaunchAssetFile();
                if (launchAssetFile != null && !launchAssetFile.equals(launchAssetFile)) {
                    try {
                        JSBundleLoader createFileLoader = JSBundleLoader.createFileLoader(launchAssetFile);
                        Field declaredField = reactInstanceManager.getClass().getDeclaredField("mBundleLoader");
                        declaredField.setAccessible(true);
                        declaredField.set(reactInstanceManager, createFileLoader);
                    } catch (Exception e) {
                        Log.e(UpdatesController.TAG, "Could not reset JSBundleLoader in ReactInstanceManager", e);
                    }
                }
                launcherCallback2.onSuccess();
                Handler handler = new Handler(Looper.getMainLooper());
                reactInstanceManager.getClass();
                handler.post(new Runnable() {
                    public final void run() {
                        ReactInstanceManager.this.recreateReactContextInBackground();
                    }
                });
                UpdatesController.this.runReaper();
            }
        });
    }
}
