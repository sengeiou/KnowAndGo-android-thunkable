package expo.modules.updates.manifest;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.UpdatesController;
import expo.modules.updates.loader.EmbeddedLoader;
import expo.modules.updates.p021db.entity.AssetEntity;
import expo.modules.updates.p021db.entity.UpdateEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NewManifest implements Manifest {
    private static String TAG = Manifest.class.getSimpleName();
    private JSONArray mAssets;
    private Uri mBundleUrl;
    private Date mCommitTime;
    private UUID mId;
    private JSONObject mManifestJson;
    private JSONObject mMetadata;
    private String mRuntimeVersion;

    private NewManifest(JSONObject jSONObject, UUID uuid, Date date, String str, JSONObject jSONObject2, Uri uri, JSONArray jSONArray) {
        this.mManifestJson = jSONObject;
        this.mId = uuid;
        this.mCommitTime = date;
        this.mRuntimeVersion = str;
        this.mMetadata = jSONObject2;
        this.mBundleUrl = uri;
        this.mAssets = jSONArray;
    }

    public static NewManifest fromManifestJson(JSONObject jSONObject) throws JSONException {
        return new NewManifest(jSONObject, UUID.fromString(jSONObject.getString("id")), new Date(jSONObject.getLong("commitTime")), jSONObject.getString(UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY), jSONObject.optJSONObject(TtmlNode.TAG_METADATA), Uri.parse(jSONObject.getString("bundleUrl")), jSONObject.optJSONArray("assets"));
    }

    public JSONObject getRawManifestJson() {
        return this.mManifestJson;
    }

    public UpdateEntity getUpdateEntity() {
        UpdateEntity updateEntity = new UpdateEntity(this.mId, this.mCommitTime, this.mRuntimeVersion, UpdatesController.getInstance().getUpdateUrl().toString());
        if (this.mMetadata != null) {
            updateEntity.metadata = this.mMetadata;
        }
        return updateEntity;
    }

    public ArrayList<AssetEntity> getAssetEntityList() {
        ArrayList<AssetEntity> arrayList = new ArrayList<>();
        AssetEntity assetEntity = new AssetEntity("bundle-" + this.mCommitTime.getTime(), "js");
        assetEntity.url = this.mBundleUrl;
        assetEntity.isLaunchAsset = true;
        assetEntity.embeddedAssetFilename = EmbeddedLoader.BUNDLE_FILENAME;
        arrayList.add(assetEntity);
        if (this.mAssets != null && this.mAssets.length() > 0) {
            for (int i = 0; i < this.mAssets.length(); i++) {
                try {
                    JSONObject jSONObject = this.mAssets.getJSONObject(i);
                    AssetEntity assetEntity2 = new AssetEntity(jSONObject.getString("key"), jSONObject.getString("type"));
                    assetEntity2.url = Uri.parse(jSONObject.getString(ImagesContract.URL));
                    assetEntity2.embeddedAssetFilename = jSONObject.optString("embeddedAssetFilename");
                    arrayList.add(assetEntity2);
                } catch (JSONException e) {
                    Log.e(TAG, "Could not read asset from manifest", e);
                }
            }
        }
        return arrayList;
    }
}
