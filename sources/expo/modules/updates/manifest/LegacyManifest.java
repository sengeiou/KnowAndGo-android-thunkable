package expo.modules.updates.manifest;

import android.net.Uri;
import android.util.Log;
import com.amplitude.api.DeviceInfo;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.UpdatesController;
import expo.modules.updates.loader.EmbeddedLoader;
import expo.modules.updates.p021db.entity.AssetEntity;
import expo.modules.updates.p021db.entity.UpdateEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import org.apache.commons.lang3.time.TimeZones;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LegacyManifest implements Manifest {
    private static String EXPO_ASSETS_URL_BASE = "https://d1wp6m56sqw74a.cloudfront.net/~assets/";
    private static String[] EXPO_DOMAINS = {"expo.io", "exp.host", "expo.test"};
    private static String TAG = Manifest.class.getSimpleName();
    private JSONArray mAssets;
    private Uri mAssetsUrlBase = null;
    private Uri mBundleUrl;
    private Date mCommitTime;
    private UUID mId;
    private JSONObject mManifestJson;
    private JSONObject mMetadata;
    private String mRuntimeVersion;

    private LegacyManifest(JSONObject jSONObject, UUID uuid, Date date, String str, JSONObject jSONObject2, Uri uri, JSONArray jSONArray) {
        this.mManifestJson = jSONObject;
        this.mId = uuid;
        this.mCommitTime = date;
        this.mRuntimeVersion = str;
        this.mMetadata = jSONObject2;
        this.mBundleUrl = uri;
        this.mAssets = jSONArray;
    }

    public static LegacyManifest fromLegacyManifestJson(JSONObject jSONObject) throws JSONException {
        String str;
        Date date;
        UUID fromString = UUID.fromString(jSONObject.getString("releaseId"));
        String string = jSONObject.getString("commitTime");
        String string2 = jSONObject.getString(UpdatesConfiguration.UPDATES_CONFIGURATION_SDK_VERSION_KEY);
        Object opt = jSONObject.opt(UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY);
        if (opt != null) {
            if (opt instanceof String) {
                str = (String) opt;
                Uri parse = Uri.parse(jSONObject.getString("bundleUrl"));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
                date = simpleDateFormat.parse(string);
                return new LegacyManifest(jSONObject, fromString, date, str, jSONObject, parse, jSONObject.optJSONArray("bundledAssets"));
            } else if (opt instanceof JSONObject) {
                string2 = ((JSONObject) opt).optString(DeviceInfo.OS_NAME, string2);
            }
        }
        str = string2;
        Uri parse2 = Uri.parse(jSONObject.getString("bundleUrl"));
        try {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            simpleDateFormat2.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
            date = simpleDateFormat2.parse(string);
        } catch (ParseException e) {
            Log.e(TAG, "Could not parse commitTime", e);
            date = new Date();
        }
        return new LegacyManifest(jSONObject, fromString, date, str, jSONObject, parse2, jSONObject.optJSONArray("bundledAssets"));
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
        String str;
        ArrayList<AssetEntity> arrayList = new ArrayList<>();
        AssetEntity assetEntity = new AssetEntity("bundle-" + this.mCommitTime.getTime(), "js");
        assetEntity.url = this.mBundleUrl;
        assetEntity.isLaunchAsset = true;
        assetEntity.embeddedAssetFilename = EmbeddedLoader.BUNDLE_FILENAME;
        arrayList.add(assetEntity);
        if (this.mAssets != null && this.mAssets.length() > 0) {
            for (int i = 0; i < this.mAssets.length(); i++) {
                try {
                    String string = this.mAssets.getString(i);
                    int lastIndexOf = string.lastIndexOf(46);
                    int length = "asset_".length();
                    if (lastIndexOf > 0) {
                        str = string.substring(length, lastIndexOf);
                    } else {
                        str = string.substring(length);
                    }
                    String substring = lastIndexOf > 0 ? string.substring(lastIndexOf + 1) : "";
                    AssetEntity assetEntity2 = new AssetEntity(str + "." + substring, substring);
                    assetEntity2.url = Uri.withAppendedPath(getAssetsUrlBase(), str);
                    assetEntity2.embeddedAssetFilename = string;
                    arrayList.add(assetEntity2);
                } catch (JSONException e) {
                    Log.e(TAG, "Could not read asset from manifest", e);
                }
            }
        }
        return arrayList;
    }

    private Uri getAssetsUrlBase() {
        if (this.mAssetsUrlBase == null) {
            Uri updateUrl = UpdatesController.getInstance().getUpdateUrl();
            String host = updateUrl.getHost();
            if (host == null) {
                this.mAssetsUrlBase = Uri.parse(EXPO_ASSETS_URL_BASE);
            } else {
                String[] strArr = EXPO_DOMAINS;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (host.contains(strArr[i])) {
                        this.mAssetsUrlBase = Uri.parse(EXPO_ASSETS_URL_BASE);
                        break;
                    } else {
                        i++;
                    }
                }
                if (this.mAssetsUrlBase == null) {
                    String optString = getRawManifestJson().optString("assetUrlOverride", "assets");
                    Uri.Builder buildUpon = updateUrl.buildUpon();
                    List<String> pathSegments = updateUrl.getPathSegments();
                    buildUpon.path("");
                    for (int i2 = 0; i2 < pathSegments.size() - 1; i2++) {
                        buildUpon.appendPath(pathSegments.get(i2));
                    }
                    buildUpon.appendPath(optString);
                    this.mAssetsUrlBase = buildUpon.build();
                }
            }
        }
        return this.mAssetsUrlBase;
    }
}
