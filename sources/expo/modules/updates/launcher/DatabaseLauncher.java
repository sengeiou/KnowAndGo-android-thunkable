package expo.modules.updates.launcher;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.loader.EmbeddedLoader;
import expo.modules.updates.loader.FileDownloader;
import expo.modules.updates.manifest.Manifest;
import expo.modules.updates.p021db.UpdatesDatabase;
import expo.modules.updates.p021db.entity.AssetEntity;
import expo.modules.updates.p021db.entity.UpdateEntity;
import expo.modules.updates.p021db.enums.UpdateStatus;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DatabaseLauncher implements Launcher {
    /* access modifiers changed from: private */
    public static final String TAG = "DatabaseLauncher";
    private int mAssetsToDownload = 0;
    private int mAssetsToDownloadFinished = 0;
    private String mBundleAssetName = null;
    private Launcher.LauncherCallback mCallback = null;
    /* access modifiers changed from: private */
    public Exception mLaunchAssetException = null;
    private String mLaunchAssetFile = null;
    private UpdateEntity mLaunchedUpdate = null;
    private Map<AssetEntity, String> mLocalAssetFiles = null;
    private SelectionPolicy mSelectionPolicy;
    /* access modifiers changed from: private */
    public File mUpdatesDirectory;

    public DatabaseLauncher(File file, SelectionPolicy selectionPolicy) {
        this.mUpdatesDirectory = file;
        this.mSelectionPolicy = selectionPolicy;
    }

    @Nullable
    public UpdateEntity getLaunchedUpdate() {
        return this.mLaunchedUpdate;
    }

    @Nullable
    public String getLaunchAssetFile() {
        return this.mLaunchAssetFile;
    }

    @Nullable
    public String getBundleAssetName() {
        return this.mBundleAssetName;
    }

    @Nullable
    public Map<AssetEntity, String> getLocalAssetFiles() {
        return this.mLocalAssetFiles;
    }

    public boolean isUsingEmbeddedAssets() {
        return this.mLocalAssetFiles == null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b0, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void launch(expo.modules.updates.p021db.UpdatesDatabase r4, android.content.Context r5, expo.modules.updates.launcher.Launcher.LauncherCallback r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            expo.modules.updates.launcher.Launcher$LauncherCallback r0 = r3.mCallback     // Catch:{ all -> 0x00c1 }
            if (r0 != 0) goto L_0x00b9
            r3.mCallback = r6     // Catch:{ all -> 0x00c1 }
            expo.modules.updates.db.entity.UpdateEntity r6 = r3.getLaunchableUpdate(r4, r5)     // Catch:{ all -> 0x00c1 }
            r3.mLaunchedUpdate = r6     // Catch:{ all -> 0x00c1 }
            expo.modules.updates.db.entity.UpdateEntity r6 = r3.mLaunchedUpdate     // Catch:{ all -> 0x00c1 }
            if (r6 != 0) goto L_0x001f
            expo.modules.updates.launcher.Launcher$LauncherCallback r4 = r3.mCallback     // Catch:{ all -> 0x00c1 }
            java.lang.Exception r5 = new java.lang.Exception     // Catch:{ all -> 0x00c1 }
            java.lang.String r6 = "No launchable update was found"
            r5.<init>(r6)     // Catch:{ all -> 0x00c1 }
            r4.onFailure(r5)     // Catch:{ all -> 0x00c1 }
            monitor-exit(r3)
            return
        L_0x001f:
            expo.modules.updates.db.entity.UpdateEntity r6 = r3.mLaunchedUpdate     // Catch:{ all -> 0x00c1 }
            expo.modules.updates.db.enums.UpdateStatus r6 = r6.status     // Catch:{ all -> 0x00c1 }
            expo.modules.updates.db.enums.UpdateStatus r0 = expo.modules.updates.p021db.enums.UpdateStatus.EMBEDDED     // Catch:{ all -> 0x00c1 }
            if (r6 != r0) goto L_0x003e
            java.lang.String r4 = "index.android.bundle"
            r3.mBundleAssetName = r4     // Catch:{ all -> 0x00c1 }
            java.util.Map<expo.modules.updates.db.entity.AssetEntity, java.lang.String> r4 = r3.mLocalAssetFiles     // Catch:{ all -> 0x00c1 }
            if (r4 != 0) goto L_0x0036
            expo.modules.updates.launcher.Launcher$LauncherCallback r4 = r3.mCallback     // Catch:{ all -> 0x00c1 }
            r4.onSuccess()     // Catch:{ all -> 0x00c1 }
            monitor-exit(r3)
            return
        L_0x0036:
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ all -> 0x00c1 }
            java.lang.String r5 = "mLocalAssetFiles should be null for embedded updates"
            r4.<init>(r5)     // Catch:{ all -> 0x00c1 }
            throw r4     // Catch:{ all -> 0x00c1 }
        L_0x003e:
            expo.modules.updates.db.dao.UpdateDao r6 = r4.updateDao()     // Catch:{ all -> 0x00c1 }
            expo.modules.updates.db.entity.UpdateEntity r0 = r3.mLaunchedUpdate     // Catch:{ all -> 0x00c1 }
            java.util.UUID r0 = r0.f2958id     // Catch:{ all -> 0x00c1 }
            expo.modules.updates.db.entity.AssetEntity r6 = r6.loadLaunchAsset(r0)     // Catch:{ all -> 0x00c1 }
            java.lang.String r0 = r6.relativePath     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x00b1
            java.io.File r6 = r3.ensureAssetExists(r6, r4, r5)     // Catch:{ all -> 0x00c1 }
            if (r6 == 0) goto L_0x005a
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00c1 }
            r3.mLaunchAssetFile = r6     // Catch:{ all -> 0x00c1 }
        L_0x005a:
            expo.modules.updates.db.dao.AssetDao r6 = r4.assetDao()     // Catch:{ all -> 0x00c1 }
            expo.modules.updates.db.entity.UpdateEntity r0 = r3.mLaunchedUpdate     // Catch:{ all -> 0x00c1 }
            java.util.UUID r0 = r0.f2958id     // Catch:{ all -> 0x00c1 }
            java.util.List r6 = r6.loadAssetsForUpdate(r0)     // Catch:{ all -> 0x00c1 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x00c1 }
            r0.<init>()     // Catch:{ all -> 0x00c1 }
            r3.mLocalAssetFiles = r0     // Catch:{ all -> 0x00c1 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x00c1 }
        L_0x0071:
            boolean r0 = r6.hasNext()     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x0095
            java.lang.Object r0 = r6.next()     // Catch:{ all -> 0x00c1 }
            expo.modules.updates.db.entity.AssetEntity r0 = (expo.modules.updates.p021db.entity.AssetEntity) r0     // Catch:{ all -> 0x00c1 }
            java.lang.String r1 = r0.relativePath     // Catch:{ all -> 0x00c1 }
            if (r1 == 0) goto L_0x0071
            java.io.File r1 = r3.ensureAssetExists(r0, r4, r5)     // Catch:{ all -> 0x00c1 }
            if (r1 == 0) goto L_0x0071
            java.util.Map<expo.modules.updates.db.entity.AssetEntity, java.lang.String> r2 = r3.mLocalAssetFiles     // Catch:{ all -> 0x00c1 }
            java.net.URI r1 = r1.toURI()     // Catch:{ all -> 0x00c1 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00c1 }
            r2.put(r0, r1)     // Catch:{ all -> 0x00c1 }
            goto L_0x0071
        L_0x0095:
            int r4 = r3.mAssetsToDownload     // Catch:{ all -> 0x00c1 }
            if (r4 != 0) goto L_0x00af
            java.lang.String r4 = r3.mLaunchAssetFile     // Catch:{ all -> 0x00c1 }
            if (r4 != 0) goto L_0x00aa
            expo.modules.updates.launcher.Launcher$LauncherCallback r4 = r3.mCallback     // Catch:{ all -> 0x00c1 }
            java.lang.Exception r5 = new java.lang.Exception     // Catch:{ all -> 0x00c1 }
            java.lang.String r6 = "mLaunchAssetFile was immediately null; this should never happen"
            r5.<init>(r6)     // Catch:{ all -> 0x00c1 }
            r4.onFailure(r5)     // Catch:{ all -> 0x00c1 }
            goto L_0x00af
        L_0x00aa:
            expo.modules.updates.launcher.Launcher$LauncherCallback r4 = r3.mCallback     // Catch:{ all -> 0x00c1 }
            r4.onSuccess()     // Catch:{ all -> 0x00c1 }
        L_0x00af:
            monitor-exit(r3)
            return
        L_0x00b1:
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ all -> 0x00c1 }
            java.lang.String r5 = "Launch Asset relativePath should not be null"
            r4.<init>(r5)     // Catch:{ all -> 0x00c1 }
            throw r4     // Catch:{ all -> 0x00c1 }
        L_0x00b9:
            java.lang.AssertionError r4 = new java.lang.AssertionError     // Catch:{ all -> 0x00c1 }
            java.lang.String r5 = "DatabaseLauncher has already started. Create a new instance in order to launch a new version."
            r4.<init>(r5)     // Catch:{ all -> 0x00c1 }
            throw r4     // Catch:{ all -> 0x00c1 }
        L_0x00c1:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.launcher.DatabaseLauncher.launch(expo.modules.updates.db.UpdatesDatabase, android.content.Context, expo.modules.updates.launcher.Launcher$LauncherCallback):void");
    }

    public UpdateEntity getLaunchableUpdate(UpdatesDatabase updatesDatabase, Context context) {
        List<UpdateEntity> loadLaunchableUpdates = updatesDatabase.updateDao().loadLaunchableUpdates();
        Manifest readEmbeddedManifest = EmbeddedLoader.readEmbeddedManifest(context);
        ArrayList arrayList = new ArrayList();
        for (UpdateEntity next : loadLaunchableUpdates) {
            if (next.status != UpdateStatus.EMBEDDED || readEmbeddedManifest.getUpdateEntity().f2958id.equals(next.f2958id)) {
                arrayList.add(next);
            }
        }
        return this.mSelectionPolicy.selectUpdateToLaunch(arrayList);
    }

    private File ensureAssetExists(AssetEntity assetEntity, final UpdatesDatabase updatesDatabase, Context context) {
        Manifest readEmbeddedManifest;
        AssetEntity assetEntity2;
        File file = new File(this.mUpdatesDirectory, assetEntity.relativePath);
        boolean exists = file.exists();
        if (!exists && (readEmbeddedManifest = EmbeddedLoader.readEmbeddedManifest(context)) != null) {
            Iterator<AssetEntity> it = readEmbeddedManifest.getAssetEntityList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    assetEntity2 = null;
                    break;
                }
                assetEntity2 = it.next();
                if (assetEntity2.key.equals(assetEntity.key)) {
                    break;
                }
            }
            if (assetEntity2 != null) {
                try {
                    byte[] copyAssetAndGetHash = EmbeddedLoader.copyAssetAndGetHash(assetEntity2, file, context);
                    if (copyAssetAndGetHash != null && Arrays.equals(copyAssetAndGetHash, assetEntity.hash)) {
                        exists = true;
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Failed to copy matching embedded asset", e);
                }
            }
        }
        if (exists) {
            return file;
        }
        this.mAssetsToDownload++;
        FileDownloader.downloadAsset(assetEntity, this.mUpdatesDirectory, context, new FileDownloader.AssetDownloadCallback() {
            public void onFailure(Exception exc, AssetEntity assetEntity) {
                Log.e(DatabaseLauncher.TAG, "Failed to load asset from disk or network", exc);
                if (assetEntity.isLaunchAsset) {
                    Exception unused = DatabaseLauncher.this.mLaunchAssetException = exc;
                }
                DatabaseLauncher.this.maybeFinish(assetEntity, (File) null);
            }

            public void onSuccess(AssetEntity assetEntity, boolean z) {
                updatesDatabase.assetDao().updateAsset(assetEntity);
                File file = new File(DatabaseLauncher.this.mUpdatesDirectory, assetEntity.relativePath);
                DatabaseLauncher databaseLauncher = DatabaseLauncher.this;
                if (!file.exists()) {
                    file = null;
                }
                databaseLauncher.maybeFinish(assetEntity, file);
            }
        });
        return null;
    }

    /* access modifiers changed from: private */
    public synchronized void maybeFinish(AssetEntity assetEntity, File file) {
        this.mAssetsToDownloadFinished++;
        if (assetEntity.isLaunchAsset) {
            if (file == null) {
                Log.e(TAG, "Could not launch; failed to load update from disk or network");
                this.mLaunchAssetFile = null;
            } else {
                this.mLaunchAssetFile = file.toString();
            }
        } else if (file != null) {
            this.mLocalAssetFiles.put(assetEntity, file.toString());
        }
        if (this.mAssetsToDownloadFinished == this.mAssetsToDownload) {
            if (this.mLaunchAssetFile == null) {
                if (this.mLaunchAssetException == null) {
                    this.mLaunchAssetException = new Exception("Launcher mLaunchAssetFile is unexpectedly null");
                }
                this.mCallback.onFailure(this.mLaunchAssetException);
            } else {
                this.mCallback.onSuccess();
            }
        }
    }
}
