package expo.modules.updates.loader;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.Nullable;
import com.amplitude.api.DeviceInfo;
import expo.modules.updates.UpdatesController;
import expo.modules.updates.UpdatesUtils;
import expo.modules.updates.launcher.NoDatabaseLauncher;
import expo.modules.updates.loader.Crypto;
import expo.modules.updates.manifest.Manifest;
import expo.modules.updates.manifest.ManifestFactory;
import expo.modules.updates.p021db.entity.AssetEntity;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import okhttp3.C3873Response;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONException;
import org.json.JSONObject;

public class FileDownloader {
    /* access modifiers changed from: private */
    public static final String TAG = "FileDownloader";
    private static OkHttpClient sClient = new OkHttpClient.Builder().build();

    public interface AssetDownloadCallback {
        void onFailure(Exception exc, AssetEntity assetEntity);

        void onSuccess(AssetEntity assetEntity, boolean z);
    }

    public interface FileDownloadCallback {
        void onFailure(Exception exc);

        void onSuccess(File file, @Nullable byte[] bArr);
    }

    public interface ManifestDownloadCallback {
        void onFailure(String str, Exception exc);

        void onSuccess(Manifest manifest);
    }

    public static void downloadFileToPath(Request request, final File file, final FileDownloadCallback fileDownloadCallback) {
        downloadData(request, new Callback() {
            public void onFailure(Call call, IOException iOException) {
                fileDownloadCallback.onFailure(iOException);
            }

            public void onResponse(Call call, C3873Response response) throws IOException {
                InputStream byteStream;
                if (!response.isSuccessful()) {
                    FileDownloadCallback fileDownloadCallback = fileDownloadCallback;
                    fileDownloadCallback.onFailure(new Exception("Network request failed: " + response.body().string()));
                    return;
                }
                try {
                    byteStream = response.body().byteStream();
                    fileDownloadCallback.onSuccess(file, UpdatesUtils.sha256AndWriteToFile(byteStream, file));
                    if (byteStream != null) {
                        byteStream.close();
                        return;
                    }
                    return;
                } catch (Exception e) {
                    String access$000 = FileDownloader.TAG;
                    Log.e(access$000, "Failed to download file to destination " + file.toString(), e);
                    fileDownloadCallback.onFailure(e);
                    return;
                } catch (Throwable th) {
                    r5.addSuppressed(th);
                }
                throw th;
            }
        });
    }

    public static void downloadManifest(final Uri uri, final Context context, final ManifestDownloadCallback manifestDownloadCallback) {
        try {
            downloadData(addHeadersToManifestUrl(uri, context), new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    ManifestDownloadCallback manifestDownloadCallback = manifestDownloadCallback;
                    manifestDownloadCallback.onFailure("Failed to download manifest from URL: " + uri, iOException);
                }

                public void onResponse(Call call, C3873Response response) throws IOException {
                    if (!response.isSuccessful()) {
                        ManifestDownloadCallback manifestDownloadCallback = manifestDownloadCallback;
                        manifestDownloadCallback.onFailure("Failed to download manifest from URL: " + uri, new Exception(response.body().string()));
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(response.body().string());
                        if (!jSONObject.has("manifestString") || !jSONObject.has("signature")) {
                            manifestDownloadCallback.onSuccess(ManifestFactory.getManifest(context, jSONObject));
                            return;
                        }
                        final String string = jSONObject.getString("manifestString");
                        Crypto.verifyPublicRSASignature(string, jSONObject.getString("signature"), (Crypto.RSASignatureListener) new Crypto.RSASignatureListener() {
                            public void onError(Exception exc, boolean z) {
                                manifestDownloadCallback.onFailure("Could not validate signed manifest", exc);
                            }

                            public void onCompleted(boolean z) {
                                if (z) {
                                    try {
                                        manifestDownloadCallback.onSuccess(ManifestFactory.getManifest(context, new JSONObject(string)));
                                    } catch (JSONException e) {
                                        manifestDownloadCallback.onFailure("Failed to parse manifest data", e);
                                    }
                                } else {
                                    manifestDownloadCallback.onFailure("Manifest signature is invalid; aborting", new Exception("Manifest signature is invalid"));
                                }
                            }
                        });
                    } catch (Exception e) {
                        manifestDownloadCallback.onFailure("Failed to parse manifest data", e);
                    }
                }
            });
        } catch (Exception e) {
            manifestDownloadCallback.onFailure("Failed to download manifest from URL " + uri.toString(), e);
        }
    }

    public static void downloadAsset(final AssetEntity assetEntity, File file, Context context, final AssetDownloadCallback assetDownloadCallback) {
        if (assetEntity.url == null) {
            assetDownloadCallback.onFailure(new Exception("Could not download asset " + assetEntity.key + " with no URL"), assetEntity);
            return;
        }
        final String createFilenameForAsset = UpdatesUtils.createFilenameForAsset(assetEntity);
        File file2 = new File(file, createFilenameForAsset);
        if (file2.exists()) {
            assetEntity.relativePath = createFilenameForAsset;
            assetDownloadCallback.onSuccess(assetEntity, false);
            return;
        }
        try {
            downloadFileToPath(addHeadersToUrl(assetEntity.url, context), file2, new FileDownloadCallback() {
                public void onFailure(Exception exc) {
                    assetDownloadCallback.onFailure(exc, assetEntity);
                }

                public void onSuccess(File file, @Nullable byte[] bArr) {
                    assetEntity.downloadTime = new Date();
                    assetEntity.relativePath = createFilenameForAsset;
                    assetEntity.hash = bArr;
                    assetDownloadCallback.onSuccess(assetEntity, true);
                }
            });
        } catch (Exception e) {
            assetDownloadCallback.onFailure(e, assetEntity);
        }
    }

    public static void downloadData(Request request, Callback callback) {
        downloadData(request, callback, false);
    }

    /* access modifiers changed from: private */
    public static void downloadData(final Request request, final Callback callback, final boolean z) {
        sClient.newCall(request).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                if (z) {
                    callback.onFailure(call, iOException);
                } else {
                    FileDownloader.downloadData(request, callback, true);
                }
            }

            public void onResponse(Call call, C3873Response response) throws IOException {
                callback.onResponse(call, response);
            }
        });
    }

    private static Request addHeadersToUrl(Uri uri, Context context) {
        return new Request.Builder().url(uri.toString()).header("Expo-Platform", DeviceInfo.OS_NAME).header("Expo-Api-Version", "1").header("Expo-Updates-Environment", "BARE").build();
    }

    private static Request addHeadersToManifestUrl(Uri uri, Context context) {
        Request.Builder builder;
        Request.Builder cacheControl = new Request.Builder().url(uri.toString()).header("Accept", "application/expo+json,application/json").header("Expo-Platform", DeviceInfo.OS_NAME).header("Expo-Api-Version", "1").header("Expo-Updates-Environment", "BARE").header("Expo-JSON-Error", "true").header("Expo-Accept-Signature", "true").cacheControl(CacheControl.FORCE_NETWORK);
        String runtimeVersion = UpdatesController.getInstance().getUpdatesConfiguration().getRuntimeVersion();
        String sdkVersion = UpdatesController.getInstance().getUpdatesConfiguration().getSdkVersion();
        if (runtimeVersion == null || runtimeVersion.length() <= 0) {
            builder = cacheControl.header("Expo-SDK-Version", sdkVersion);
        } else {
            builder = cacheControl.header("Expo-Runtime-Version", runtimeVersion);
        }
        Request.Builder header = builder.header("Expo-Release-Channel", UpdatesController.getInstance().getUpdatesConfiguration().getReleaseChannel());
        String consumeErrorLog = NoDatabaseLauncher.consumeErrorLog(context);
        if (consumeErrorLog != null) {
            header = header.header("Expo-Fatal-Error", consumeErrorLog.substring(0, Math.min(1024, consumeErrorLog.length())));
        }
        return header.build();
    }
}
