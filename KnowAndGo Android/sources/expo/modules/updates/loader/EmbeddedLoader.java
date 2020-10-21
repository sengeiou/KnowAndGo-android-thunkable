package expo.modules.updates.loader;

import android.content.Context;
import android.util.Log;
import expo.modules.updates.UpdatesUtils;
import expo.modules.updates.manifest.Manifest;
import expo.modules.updates.manifest.ManifestFactory;
import expo.modules.updates.p021db.UpdatesDatabase;
import expo.modules.updates.p021db.entity.AssetEntity;
import expo.modules.updates.p021db.entity.UpdateEntity;
import expo.modules.updates.p021db.enums.UpdateStatus;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.apache.commons.p032io.IOUtils;
import org.json.JSONObject;

public class EmbeddedLoader {
    public static final String BARE_BUNDLE_FILENAME = "index.android.bundle";
    public static final String BUNDLE_FILENAME = "app.bundle";
    public static final String MANIFEST_FILENAME = "app.manifest";
    private static final String TAG = "EmbeddedLoader";
    private static Manifest sEmbeddedManifest;
    private Context mContext;
    private UpdatesDatabase mDatabase;
    private ArrayList<AssetEntity> mErroredAssetList = new ArrayList<>();
    private ArrayList<AssetEntity> mExistingAssetList = new ArrayList<>();
    private ArrayList<AssetEntity> mFinishedAssetList = new ArrayList<>();
    private float mPixelDensity;
    private ArrayList<AssetEntity> mSkippedAssetList = new ArrayList<>();
    private UpdateEntity mUpdateEntity;
    private File mUpdatesDirectory;

    public EmbeddedLoader(Context context, UpdatesDatabase updatesDatabase, File file) {
        this.mContext = context;
        this.mDatabase = updatesDatabase;
        this.mUpdatesDirectory = file;
        this.mPixelDensity = context.getResources().getDisplayMetrics().density;
    }

    public boolean loadEmbeddedUpdate() {
        Manifest readEmbeddedManifest = readEmbeddedManifest(this.mContext);
        if (readEmbeddedManifest == null) {
            return false;
        }
        boolean processManifest = processManifest(readEmbeddedManifest);
        reset();
        return processManifest;
    }

    public void reset() {
        this.mUpdateEntity = null;
        this.mErroredAssetList = new ArrayList<>();
        this.mSkippedAssetList = new ArrayList<>();
        this.mExistingAssetList = new ArrayList<>();
        this.mFinishedAssetList = new ArrayList<>();
    }

    public static Manifest readEmbeddedManifest(Context context) {
        InputStream open;
        Throwable th;
        if (sEmbeddedManifest == null) {
            try {
                open = context.getAssets().open(MANIFEST_FILENAME);
                sEmbeddedManifest = ManifestFactory.getEmbeddedManifest(context, new JSONObject(IOUtils.toString(open, "UTF-8")));
                if (open != null) {
                    open.close();
                }
            } catch (Exception e) {
                Log.e(TAG, "Could not read embedded manifest", e);
                throw new AssertionError("The embedded manifest is invalid or could not be read. Make sure you have configured expo-updates correctly in android/app/build.gradle. " + e.getMessage());
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        return sEmbeddedManifest;
        throw th;
    }

    public static byte[] copyAssetAndGetHash(AssetEntity assetEntity, File file, Context context) throws NoSuchAlgorithmException, IOException {
        if (assetEntity.embeddedAssetFilename != null) {
            return copyContextAssetAndGetHash(assetEntity, file, context);
        }
        if (assetEntity.resourcesFilename != null && assetEntity.resourcesFolder != null) {
            return copyResourceAndGetHash(assetEntity, file, context);
        }
        throw new AssertionError("Failed to copy asset " + assetEntity.key + " from APK assets or resources because not enough information was provided.");
    }

    public static byte[] copyContextAssetAndGetHash(AssetEntity assetEntity, File file, Context context) throws NoSuchAlgorithmException, IOException {
        InputStream open;
        try {
            open = context.getAssets().open(assetEntity.embeddedAssetFilename);
            byte[] sha256AndWriteToFile = UpdatesUtils.sha256AndWriteToFile(open, file);
            if (open != null) {
                open.close();
            }
            return sha256AndWriteToFile;
        } catch (Exception e) {
            String str = TAG;
            Log.e(str, "Failed to copy asset " + assetEntity.embeddedAssetFilename, e);
            throw e;
        } catch (Throwable th) {
            r0.addSuppressed(th);
        }
        throw th;
    }

    public static byte[] copyResourceAndGetHash(AssetEntity assetEntity, File file, Context context) throws NoSuchAlgorithmException, IOException {
        InputStream openRawResource;
        try {
            openRawResource = context.getResources().openRawResource(context.getResources().getIdentifier(assetEntity.resourcesFilename, assetEntity.resourcesFolder, context.getPackageName()));
            byte[] sha256AndWriteToFile = UpdatesUtils.sha256AndWriteToFile(openRawResource, file);
            if (openRawResource != null) {
                openRawResource.close();
            }
            return sha256AndWriteToFile;
        } catch (Exception e) {
            String str = TAG;
            Log.e(str, "Failed to copy asset " + assetEntity.embeddedAssetFilename, e);
            throw e;
        } catch (Throwable th) {
            r0.addSuppressed(th);
        }
        throw th;
    }

    private boolean processManifest(Manifest manifest) {
        UpdateEntity updateEntity = manifest.getUpdateEntity();
        UpdateEntity loadUpdateWithId = this.mDatabase.updateDao().loadUpdateWithId(updateEntity.f2958id);
        if (loadUpdateWithId == null || loadUpdateWithId.status != UpdateStatus.READY) {
            if (loadUpdateWithId == null) {
                this.mUpdateEntity = updateEntity;
                this.mDatabase.updateDao().insertUpdate(this.mUpdateEntity);
            } else {
                this.mUpdateEntity = loadUpdateWithId;
            }
            copyAllAssets(manifest.getAssetEntityList());
            return true;
        }
        this.mUpdateEntity = loadUpdateWithId;
        return true;
    }

    private void copyAllAssets(ArrayList<AssetEntity> arrayList) {
        Iterator<AssetEntity> it = arrayList.iterator();
        while (it.hasNext()) {
            AssetEntity next = it.next();
            if (shouldSkipAsset(next)) {
                this.mSkippedAssetList.add(next);
            } else {
                AssetEntity loadAssetWithKey = this.mDatabase.assetDao().loadAssetWithKey(next.key);
                if (loadAssetWithKey != null) {
                    this.mDatabase.assetDao().mergeAndUpdateAsset(loadAssetWithKey, next);
                    next = loadAssetWithKey;
                }
                if (next.relativePath == null || !new File(this.mUpdatesDirectory, next.relativePath).exists()) {
                    String createFilenameForAsset = UpdatesUtils.createFilenameForAsset(next);
                    File file = new File(this.mUpdatesDirectory, createFilenameForAsset);
                    if (file.exists()) {
                        next.relativePath = createFilenameForAsset;
                        this.mExistingAssetList.add(next);
                    } else {
                        try {
                            next.hash = copyAssetAndGetHash(next, file, this.mContext);
                            next.downloadTime = new Date();
                            next.relativePath = createFilenameForAsset;
                            this.mFinishedAssetList.add(next);
                        } catch (FileNotFoundException unused) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("APK bundle must contain the expected embedded asset ");
                            sb.append(next.embeddedAssetFilename != null ? next.embeddedAssetFilename : next.resourcesFilename);
                            throw new AssertionError(sb.toString());
                        } catch (Exception unused2) {
                            this.mErroredAssetList.add(next);
                        }
                    }
                } else {
                    this.mExistingAssetList.add(next);
                }
            }
        }
        Iterator<AssetEntity> it2 = this.mExistingAssetList.iterator();
        while (it2.hasNext()) {
            AssetEntity next2 = it2.next();
            if (!this.mDatabase.assetDao().addExistingAssetToUpdate(this.mUpdateEntity, next2, next2.isLaunchAsset)) {
                byte[] bArr = null;
                try {
                    bArr = UpdatesUtils.sha256(new File(this.mUpdatesDirectory, next2.relativePath));
                } catch (Exception unused3) {
                }
                next2.downloadTime = new Date();
                next2.hash = bArr;
                this.mFinishedAssetList.add(next2);
            }
        }
        this.mDatabase.assetDao().insertAssets(this.mFinishedAssetList, this.mUpdateEntity);
        if (this.mErroredAssetList.size() == 0) {
            this.mDatabase.updateDao().markUpdateFinished(this.mUpdateEntity, this.mSkippedAssetList.size() != 0);
        }
    }

    private boolean shouldSkipAsset(AssetEntity assetEntity) {
        if (assetEntity.scales == null || assetEntity.scale == null || pickClosestScale(assetEntity.scales) == assetEntity.scale.floatValue()) {
            return false;
        }
        return true;
    }

    private float pickClosestScale(Float[] fArr) {
        float f = Float.MAX_VALUE;
        float f2 = 0.0f;
        for (Float floatValue : fArr) {
            float floatValue2 = floatValue.floatValue();
            if (floatValue2 >= this.mPixelDensity && floatValue2 < f) {
                f = floatValue2;
            }
            if (floatValue2 > f2) {
                f2 = floatValue2;
            }
        }
        return f < Float.MAX_VALUE ? f : f2;
    }
}
