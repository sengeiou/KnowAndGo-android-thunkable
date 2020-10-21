package expo.modules.updates.launcher;

import androidx.annotation.Nullable;
import expo.modules.updates.p021db.entity.AssetEntity;
import expo.modules.updates.p021db.entity.UpdateEntity;
import java.util.Map;

public interface Launcher {

    public interface LauncherCallback {
        void onFailure(Exception exc);

        void onSuccess();
    }

    @Nullable
    String getBundleAssetName();

    @Nullable
    String getLaunchAssetFile();

    @Nullable
    UpdateEntity getLaunchedUpdate();

    @Nullable
    Map<AssetEntity, String> getLocalAssetFiles();

    boolean isUsingEmbeddedAssets();
}
