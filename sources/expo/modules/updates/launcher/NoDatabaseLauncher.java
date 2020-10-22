package expo.modules.updates.launcher;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.Nullable;
import expo.modules.updates.loader.EmbeddedLoader;
import expo.modules.updates.manifest.BareManifest;
import expo.modules.updates.manifest.Manifest;
import expo.modules.updates.p021db.entity.AssetEntity;
import expo.modules.updates.p021db.entity.UpdateEntity;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.p032io.FileUtils;

public class NoDatabaseLauncher implements Launcher {
    private static final String ERROR_LOG_FILENAME = "expo-error.log";
    private static final String TAG = "NoDatabaseLauncher";
    private String mBundleAssetName;
    private Map<AssetEntity, String> mLocalAssetFiles;

    @Nullable
    public String getLaunchAssetFile() {
        return null;
    }

    @Nullable
    public UpdateEntity getLaunchedUpdate() {
        return null;
    }

    public NoDatabaseLauncher(Context context) {
        this(context, (Exception) null);
    }

    public NoDatabaseLauncher(Context context, @Nullable Exception exc) {
        Manifest readEmbeddedManifest = EmbeddedLoader.readEmbeddedManifest(context);
        if (readEmbeddedManifest instanceof BareManifest) {
            this.mBundleAssetName = EmbeddedLoader.BARE_BUNDLE_FILENAME;
            this.mLocalAssetFiles = null;
        } else {
            this.mBundleAssetName = EmbeddedLoader.BUNDLE_FILENAME;
            this.mLocalAssetFiles = new HashMap();
            Iterator<AssetEntity> it = readEmbeddedManifest.getAssetEntityList().iterator();
            while (it.hasNext()) {
                AssetEntity next = it.next();
                Map<AssetEntity, String> map = this.mLocalAssetFiles;
                map.put(next, "asset:///" + next.embeddedAssetFilename);
            }
        }
        if (exc != null) {
            AsyncTask.execute(new Runnable(context, exc) {
                private final /* synthetic */ Context f$1;
                private final /* synthetic */ Exception f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    NoDatabaseLauncher.this.writeErrorToLog(this.f$1, this.f$2);
                }
            });
        }
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

    /* access modifiers changed from: private */
    public void writeErrorToLog(Context context, Exception exc) {
        try {
            FileUtils.writeStringToFile(new File(context.getFilesDir(), ERROR_LOG_FILENAME), exc.toString(), "UTF-8", true);
        } catch (Exception e) {
            Log.e(TAG, "Failed to write fatal error to log", e);
        }
    }

    @Nullable
    public static String consumeErrorLog(Context context) {
        try {
            File file = new File(context.getFilesDir(), ERROR_LOG_FILENAME);
            if (!file.exists()) {
                return null;
            }
            String readFileToString = FileUtils.readFileToString(file, "UTF-8");
            file.delete();
            return readFileToString;
        } catch (Exception e) {
            Log.e(TAG, "Failed to read error log", e);
            return null;
        }
    }
}
