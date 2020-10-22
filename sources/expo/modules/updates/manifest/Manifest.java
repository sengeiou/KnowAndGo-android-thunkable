package expo.modules.updates.manifest;

import expo.modules.updates.p021db.entity.AssetEntity;
import expo.modules.updates.p021db.entity.UpdateEntity;
import java.util.ArrayList;
import org.json.JSONObject;

public interface Manifest {
    ArrayList<AssetEntity> getAssetEntityList();

    JSONObject getRawManifestJson();

    UpdateEntity getUpdateEntity();
}
