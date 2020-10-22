package expo.modules.updates;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.loader.FileDownloader;
import expo.modules.updates.loader.RemoteLoader;
import expo.modules.updates.manifest.Manifest;
import expo.modules.updates.p021db.entity.AssetEntity;
import expo.modules.updates.p021db.entity.UpdateEntity;
import java.util.HashMap;
import java.util.Map;
import org.unimodules.core.ExportedModule;
import org.unimodules.core.ModuleRegistry;
import org.unimodules.core.Promise;
import org.unimodules.core.interfaces.ExpoMethod;

public class UpdatesModule extends ExportedModule {
    private static final String NAME = "ExpoUpdates";
    /* access modifiers changed from: private */
    public static final String TAG = "UpdatesModule";
    private ModuleRegistry mModuleRegistry;

    public String getName() {
        return NAME;
    }

    public UpdatesModule(Context context) {
        super(context);
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        this.mModuleRegistry = moduleRegistry;
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        try {
            UpdatesController instance = UpdatesController.getInstance();
            if (instance != null) {
                hashMap.put("isEmergencyLaunch", Boolean.valueOf(instance.isEmergencyLaunch()));
                UpdateEntity launchedUpdate = instance.getLaunchedUpdate();
                if (launchedUpdate != null) {
                    hashMap.put("updateId", launchedUpdate.f2958id.toString());
                    hashMap.put("manifestString", launchedUpdate.metadata != null ? launchedUpdate.metadata.toString() : "{}");
                }
                Map<AssetEntity, String> localAssetFiles = instance.getLocalAssetFiles();
                if (localAssetFiles != null) {
                    HashMap hashMap2 = new HashMap();
                    for (AssetEntity next : localAssetFiles.keySet()) {
                        hashMap2.put(next.key, localAssetFiles.get(next));
                    }
                    hashMap.put("localAssets", hashMap2);
                }
                hashMap.put("isEnabled", Boolean.valueOf(instance.getUpdatesConfiguration().isEnabled()));
                hashMap.put(UpdatesConfiguration.UPDATES_CONFIGURATION_RELEASE_CHANNEL_KEY, instance.getUpdatesConfiguration().getReleaseChannel());
                hashMap.put("isUsingEmbeddedAssets", Boolean.valueOf(instance.isUsingEmbeddedAssets()));
            }
        } catch (IllegalStateException unused) {
            hashMap.put("isEnabled", false);
        }
        return hashMap;
    }

    @ExpoMethod
    public void reload(final Promise promise) {
        try {
            UpdatesController instance = UpdatesController.getInstance();
            if (!instance.getUpdatesConfiguration().isEnabled()) {
                promise.reject("ERR_UPDATES_DISABLED", "You cannot reload when expo-updates is not enabled.");
            } else {
                instance.relaunchReactApplication(getContext(), new Launcher.LauncherCallback() {
                    public void onFailure(Exception exc) {
                        Log.e(UpdatesModule.TAG, "Failed to relaunch application", exc);
                        promise.reject("ERR_UPDATES_RELOAD", exc.getMessage(), exc);
                    }

                    public void onSuccess() {
                        promise.resolve((Object) null);
                    }
                });
            }
        } catch (IllegalStateException unused) {
            promise.reject("ERR_UPDATES_RELOAD", "The updates module controller has not been properly initialized. If you're using a development client, you cannot use `Updates.reloadAsync`. Otherwise, make sure you have called the native method UpdatesController.initialize().");
        }
    }

    @ExpoMethod
    public void checkForUpdateAsync(final Promise promise) {
        try {
            final UpdatesController instance = UpdatesController.getInstance();
            if (!instance.getUpdatesConfiguration().isEnabled()) {
                promise.reject("ERR_UPDATES_DISABLED", "You cannot check for updates when expo-updates is not enabled.");
            } else {
                FileDownloader.downloadManifest(instance.getUpdateUrl(), getContext(), new FileDownloader.ManifestDownloadCallback() {
                    public void onFailure(String str, Exception exc) {
                        promise.reject("ERR_UPDATES_CHECK", str, exc);
                        Log.e(UpdatesModule.TAG, str, exc);
                    }

                    public void onSuccess(Manifest manifest) {
                        UpdateEntity launchedUpdate = instance.getLaunchedUpdate();
                        Bundle bundle = new Bundle();
                        if (launchedUpdate == null) {
                            bundle.putBoolean("isAvailable", true);
                            bundle.putString("manifestString", manifest.getRawManifestJson().toString());
                            promise.resolve(bundle);
                        } else if (instance.getSelectionPolicy().shouldLoadNewUpdate(manifest.getUpdateEntity(), launchedUpdate)) {
                            bundle.putBoolean("isAvailable", true);
                            bundle.putString("manifestString", manifest.getRawManifestJson().toString());
                            promise.resolve(bundle);
                        } else {
                            bundle.putBoolean("isAvailable", false);
                            promise.resolve(bundle);
                        }
                    }
                });
            }
        } catch (IllegalStateException unused) {
            promise.reject("ERR_UPDATES_CHECK", "The updates module controller has not been properly initialized. If you're using a development client, you cannot check for updates. Otherwise, make sure you have called the native method UpdatesController.initialize().");
        }
    }

    @ExpoMethod
    public void fetchUpdateAsync(Promise promise) {
        try {
            UpdatesController instance = UpdatesController.getInstance();
            if (!instance.getUpdatesConfiguration().isEnabled()) {
                promise.reject("ERR_UPDATES_DISABLED", "You cannot fetch updates when expo-updates is not enabled.");
            } else {
                AsyncTask.execute(new Runnable(instance, promise) {
                    private final /* synthetic */ UpdatesController f$1;
                    private final /* synthetic */ Promise f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        new RemoteLoader(UpdatesModule.this.getContext(), this.f$1.getDatabase(), this.f$1.getUpdatesDirectory()).start(this.f$1.getUpdateUrl(), new RemoteLoader.LoaderCallback(this.f$1, this.f$2) {
                            public void onFailure(Exception exc) {
                                r5.releaseDatabase();
                                r6.reject("ERR_UPDATES_FETCH", "Failed to download new update", exc);
                            }

                            public void onSuccess(@Nullable UpdateEntity updateEntity) {
                                r5.releaseDatabase();
                                Bundle bundle = new Bundle();
                                if (updateEntity == null) {
                                    bundle.putBoolean("isNew", false);
                                } else {
                                    bundle.putBoolean("isNew", true);
                                    bundle.putString("manifestString", updateEntity.metadata.toString());
                                }
                                r6.resolve(bundle);
                            }
                        });
                    }
                });
            }
        } catch (IllegalStateException unused) {
            promise.reject("ERR_UPDATES_FETCH", "The updates module controller has not been properly initialized. If you're using a development client, you cannot fetch updates. Otherwise, make sure you have called the native method UpdatesController.initialize().");
        }
    }
}
