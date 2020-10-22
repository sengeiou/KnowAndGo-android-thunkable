package expo.modules.updates.loader;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.Nullable;
import expo.modules.updates.UpdatesController;
import expo.modules.updates.loader.FileDownloader;
import expo.modules.updates.manifest.Manifest;
import expo.modules.updates.p021db.UpdatesDatabase;
import expo.modules.updates.p021db.entity.AssetEntity;
import expo.modules.updates.p021db.entity.UpdateEntity;
import expo.modules.updates.p021db.enums.UpdateStatus;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class RemoteLoader {
    /* access modifiers changed from: private */
    public static String TAG = "RemoteLoader";
    private int mAssetTotal = 0;
    /* access modifiers changed from: private */
    public LoaderCallback mCallback;
    private Context mContext;
    private UpdatesDatabase mDatabase;
    private ArrayList<AssetEntity> mErroredAssetList = new ArrayList<>();
    private ArrayList<AssetEntity> mExistingAssetList = new ArrayList<>();
    private ArrayList<AssetEntity> mFinishedAssetList = new ArrayList<>();
    private UpdateEntity mUpdateEntity;
    private File mUpdatesDirectory;

    public interface LoaderCallback {
        void onFailure(Exception exc);

        void onSuccess(@Nullable UpdateEntity updateEntity);
    }

    public RemoteLoader(Context context, UpdatesDatabase updatesDatabase, File file) {
        this.mContext = context;
        this.mDatabase = updatesDatabase;
        this.mUpdatesDirectory = file;
    }

    public void start(Uri uri, LoaderCallback loaderCallback) {
        if (this.mCallback != null) {
            loaderCallback.onFailure(new Exception("RemoteLoader has already started. Create a new instance in order to load multiple URLs in parallel."));
            return;
        }
        this.mCallback = loaderCallback;
        FileDownloader.downloadManifest(uri, this.mContext, new FileDownloader.ManifestDownloadCallback() {
            public void onFailure(String str, Exception exc) {
                RemoteLoader.this.finishWithError(str, exc);
            }

            public void onSuccess(Manifest manifest) {
                if (UpdatesController.getInstance().getSelectionPolicy().shouldLoadNewUpdate(manifest.getUpdateEntity(), UpdatesController.getInstance().getLaunchedUpdate())) {
                    RemoteLoader.this.processManifest(manifest);
                } else {
                    RemoteLoader.this.mCallback.onSuccess((UpdateEntity) null);
                }
            }
        });
    }

    private void reset() {
        this.mUpdateEntity = null;
        this.mCallback = null;
        this.mAssetTotal = 0;
        this.mErroredAssetList = new ArrayList<>();
        this.mExistingAssetList = new ArrayList<>();
        this.mFinishedAssetList = new ArrayList<>();
    }

    private void finishWithSuccess() {
        if (this.mCallback == null) {
            Log.e(TAG, "RemoteLoader tried to finish but it already finished or was never initialized.");
            return;
        }
        this.mCallback.onSuccess(this.mUpdateEntity);
        reset();
    }

    /* access modifiers changed from: private */
    public void finishWithError(String str, Exception exc) {
        Log.e(TAG, str, exc);
        if (this.mCallback == null) {
            Log.e(TAG, "RemoteLoader tried to finish but it already finished or was never initialized.");
            return;
        }
        this.mCallback.onFailure(exc);
        reset();
    }

    /* access modifiers changed from: private */
    public void processManifest(Manifest manifest) {
        UpdateEntity updateEntity = manifest.getUpdateEntity();
        UpdateEntity loadUpdateWithId = this.mDatabase.updateDao().loadUpdateWithId(updateEntity.f2958id);
        if (loadUpdateWithId == null || loadUpdateWithId.status != UpdateStatus.READY) {
            if (loadUpdateWithId == null) {
                this.mUpdateEntity = updateEntity;
                this.mDatabase.updateDao().insertUpdate(this.mUpdateEntity);
            } else {
                this.mUpdateEntity = loadUpdateWithId;
            }
            downloadAllAssets(manifest.getAssetEntityList());
            return;
        }
        this.mUpdateEntity = loadUpdateWithId;
        finishWithSuccess();
    }

    private void downloadAllAssets(ArrayList<AssetEntity> arrayList) {
        this.mAssetTotal = arrayList.size();
        Iterator<AssetEntity> it = arrayList.iterator();
        while (it.hasNext()) {
            AssetEntity next = it.next();
            AssetEntity loadAssetWithKey = this.mDatabase.assetDao().loadAssetWithKey(next.key);
            if (loadAssetWithKey != null) {
                this.mDatabase.assetDao().mergeAndUpdateAsset(loadAssetWithKey, next);
                next = loadAssetWithKey;
            }
            if (next.relativePath != null && new File(this.mUpdatesDirectory, next.relativePath).exists()) {
                handleAssetDownloadCompleted(next, true, false);
            } else if (next.url == null) {
                Log.e(TAG, "Failed to download asset with no URL provided");
                handleAssetDownloadCompleted(next, false, false);
            } else {
                FileDownloader.downloadAsset(next, this.mUpdatesDirectory, this.mContext, new FileDownloader.AssetDownloadCallback() {
                    public void onFailure(Exception exc, AssetEntity assetEntity) {
                        String access$300 = RemoteLoader.TAG;
                        Log.e(access$300, "Failed to download asset from " + assetEntity.url, exc);
                        RemoteLoader.this.handleAssetDownloadCompleted(assetEntity, false, false);
                    }

                    public void onSuccess(AssetEntity assetEntity, boolean z) {
                        RemoteLoader.this.handleAssetDownloadCompleted(assetEntity, true, z);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:15|16|17|18|19|20|41) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void handleAssetDownloadCompleted(expo.modules.updates.p021db.entity.AssetEntity r4, boolean r5, boolean r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r5 == 0) goto L_0x0011
            if (r6 == 0) goto L_0x000b
            java.util.ArrayList<expo.modules.updates.db.entity.AssetEntity> r5 = r3.mFinishedAssetList     // Catch:{ all -> 0x00b1 }
            r5.add(r4)     // Catch:{ all -> 0x00b1 }
            goto L_0x0016
        L_0x000b:
            java.util.ArrayList<expo.modules.updates.db.entity.AssetEntity> r5 = r3.mExistingAssetList     // Catch:{ all -> 0x00b1 }
            r5.add(r4)     // Catch:{ all -> 0x00b1 }
            goto L_0x0016
        L_0x0011:
            java.util.ArrayList<expo.modules.updates.db.entity.AssetEntity> r5 = r3.mErroredAssetList     // Catch:{ all -> 0x00b1 }
            r5.add(r4)     // Catch:{ all -> 0x00b1 }
        L_0x0016:
            java.util.ArrayList<expo.modules.updates.db.entity.AssetEntity> r4 = r3.mFinishedAssetList     // Catch:{ all -> 0x00b1 }
            int r4 = r4.size()     // Catch:{ all -> 0x00b1 }
            java.util.ArrayList<expo.modules.updates.db.entity.AssetEntity> r5 = r3.mErroredAssetList     // Catch:{ all -> 0x00b1 }
            int r5 = r5.size()     // Catch:{ all -> 0x00b1 }
            int r4 = r4 + r5
            java.util.ArrayList<expo.modules.updates.db.entity.AssetEntity> r5 = r3.mExistingAssetList     // Catch:{ all -> 0x00b1 }
            int r5 = r5.size()     // Catch:{ all -> 0x00b1 }
            int r4 = r4 + r5
            int r5 = r3.mAssetTotal     // Catch:{ all -> 0x00b1 }
            if (r4 != r5) goto L_0x00af
            java.util.ArrayList<expo.modules.updates.db.entity.AssetEntity> r4 = r3.mExistingAssetList     // Catch:{ Exception -> 0x00a7 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x00a7 }
        L_0x0034:
            boolean r5 = r4.hasNext()     // Catch:{ Exception -> 0x00a7 }
            if (r5 == 0) goto L_0x006e
            java.lang.Object r5 = r4.next()     // Catch:{ Exception -> 0x00a7 }
            expo.modules.updates.db.entity.AssetEntity r5 = (expo.modules.updates.p021db.entity.AssetEntity) r5     // Catch:{ Exception -> 0x00a7 }
            expo.modules.updates.db.UpdatesDatabase r6 = r3.mDatabase     // Catch:{ Exception -> 0x00a7 }
            expo.modules.updates.db.dao.AssetDao r6 = r6.assetDao()     // Catch:{ Exception -> 0x00a7 }
            expo.modules.updates.db.entity.UpdateEntity r0 = r3.mUpdateEntity     // Catch:{ Exception -> 0x00a7 }
            boolean r1 = r5.isLaunchAsset     // Catch:{ Exception -> 0x00a7 }
            boolean r6 = r6.addExistingAssetToUpdate(r0, r5, r1)     // Catch:{ Exception -> 0x00a7 }
            if (r6 != 0) goto L_0x0034
            r6 = 0
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x005f }
            java.io.File r1 = r3.mUpdatesDirectory     // Catch:{ Exception -> 0x005f }
            java.lang.String r2 = r5.relativePath     // Catch:{ Exception -> 0x005f }
            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x005f }
            byte[] r0 = expo.modules.updates.UpdatesUtils.sha256((java.io.File) r0)     // Catch:{ Exception -> 0x005f }
            r6 = r0
        L_0x005f:
            java.util.Date r0 = new java.util.Date     // Catch:{ Exception -> 0x00a7 }
            r0.<init>()     // Catch:{ Exception -> 0x00a7 }
            r5.downloadTime = r0     // Catch:{ Exception -> 0x00a7 }
            r5.hash = r6     // Catch:{ Exception -> 0x00a7 }
            java.util.ArrayList<expo.modules.updates.db.entity.AssetEntity> r6 = r3.mFinishedAssetList     // Catch:{ Exception -> 0x00a7 }
            r6.add(r5)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x0034
        L_0x006e:
            expo.modules.updates.db.UpdatesDatabase r4 = r3.mDatabase     // Catch:{ Exception -> 0x00a7 }
            expo.modules.updates.db.dao.AssetDao r4 = r4.assetDao()     // Catch:{ Exception -> 0x00a7 }
            java.util.ArrayList<expo.modules.updates.db.entity.AssetEntity> r5 = r3.mFinishedAssetList     // Catch:{ Exception -> 0x00a7 }
            expo.modules.updates.db.entity.UpdateEntity r6 = r3.mUpdateEntity     // Catch:{ Exception -> 0x00a7 }
            r4.insertAssets(r5, r6)     // Catch:{ Exception -> 0x00a7 }
            java.util.ArrayList<expo.modules.updates.db.entity.AssetEntity> r4 = r3.mErroredAssetList     // Catch:{ Exception -> 0x00a7 }
            int r4 = r4.size()     // Catch:{ Exception -> 0x00a7 }
            if (r4 != 0) goto L_0x008e
            expo.modules.updates.db.UpdatesDatabase r4 = r3.mDatabase     // Catch:{ Exception -> 0x00a7 }
            expo.modules.updates.db.dao.UpdateDao r4 = r4.updateDao()     // Catch:{ Exception -> 0x00a7 }
            expo.modules.updates.db.entity.UpdateEntity r5 = r3.mUpdateEntity     // Catch:{ Exception -> 0x00a7 }
            r4.markUpdateFinished(r5)     // Catch:{ Exception -> 0x00a7 }
        L_0x008e:
            java.util.ArrayList<expo.modules.updates.db.entity.AssetEntity> r4 = r3.mErroredAssetList     // Catch:{ all -> 0x00b1 }
            int r4 = r4.size()     // Catch:{ all -> 0x00b1 }
            if (r4 <= 0) goto L_0x00a3
            java.lang.String r4 = "Failed to load all assets"
            java.lang.Exception r5 = new java.lang.Exception     // Catch:{ all -> 0x00b1 }
            java.lang.String r6 = "Failed to load all assets"
            r5.<init>(r6)     // Catch:{ all -> 0x00b1 }
            r3.finishWithError(r4, r5)     // Catch:{ all -> 0x00b1 }
            goto L_0x00af
        L_0x00a3:
            r3.finishWithSuccess()     // Catch:{ all -> 0x00b1 }
            goto L_0x00af
        L_0x00a7:
            r4 = move-exception
            java.lang.String r5 = "Error while adding new update to database"
            r3.finishWithError(r5, r4)     // Catch:{ all -> 0x00b1 }
            monitor-exit(r3)
            return
        L_0x00af:
            monitor-exit(r3)
            return
        L_0x00b1:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.loader.RemoteLoader.handleAssetDownloadCompleted(expo.modules.updates.db.entity.AssetEntity, boolean, boolean):void");
    }
}
