package expo.modules.updates.manifest;

import android.content.Context;
import android.util.Log;
import expo.modules.updates.UpdatesConfiguration;
import org.json.JSONException;
import org.json.JSONObject;

public class ManifestFactory {
    private static final String TAG = "ManifestFactory";
    private static Boolean sIsLegacy;

    private static boolean isLegacy(Context context) {
        if (sIsLegacy == null) {
            try {
                sIsLegacy = Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("expo.modules.updates.EXPO_LEGACY_MANIFEST", true));
            } catch (Exception e) {
                Log.e(TAG, "Failed to read expo.modules.updates.EXPO_LEGACY_MANIFEST meta-data from AndroidManifest", e);
            }
        }
        return sIsLegacy.booleanValue();
    }

    public static Manifest getManifest(Context context, JSONObject jSONObject) throws JSONException {
        if (isLegacy(context)) {
            return LegacyManifest.fromLegacyManifestJson(jSONObject);
        }
        return NewManifest.fromManifestJson(jSONObject);
    }

    public static Manifest getEmbeddedManifest(Context context, JSONObject jSONObject) throws JSONException {
        if (isLegacy(context)) {
            if (jSONObject.has("releaseId")) {
                return LegacyManifest.fromLegacyManifestJson(jSONObject);
            }
            return BareManifest.fromManifestJson(jSONObject);
        } else if (jSONObject.has(UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY)) {
            return NewManifest.fromManifestJson(jSONObject);
        } else {
            return BareManifest.fromManifestJson(jSONObject);
        }
    }
}
