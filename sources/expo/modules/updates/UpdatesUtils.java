package expo.modules.updates;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import expo.modules.updates.p021db.entity.AssetEntity;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class UpdatesUtils {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    private static final String TAG = "UpdatesUtils";
    private static final String UPDATES_DIRECTORY_NAME = ".expo-internal";
    private static final String UPDATES_EVENT_NAME = "Expo.nativeUpdatesEvent";

    public static File getOrCreateUpdatesDirectory(Context context) throws Exception {
        File file = new File(context.getFilesDir(), UPDATES_DIRECTORY_NAME);
        if (file.exists()) {
            if (file.isFile()) {
                throw new Exception("File already exists at the location of the Updates Directory: " + file.toString() + " ; aborting");
            }
        } else if (!file.mkdir()) {
            throw new Exception("Failed to create Updates Directory: mkdir() returned false");
        }
        return file;
    }

    public static String sha256(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            byte[] bytes = str.getBytes("UTF-8");
            instance.update(bytes, 0, bytes.length);
            return bytesToHex(instance.digest());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            Log.e(TAG, "Failed to checksum string via SHA-256", e);
            throw e;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0026, code lost:
        r5 = r4;
        r4 = r3;
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0038, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x003c, code lost:
        if (r1 != null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0047, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x004a, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x004b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x004c, code lost:
        android.util.Log.e(TAG, "Failed to checksum file via SHA-256: " + r6.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0066, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x004b A[ExcHandler: IOException | NoSuchAlgorithmException (r0v0 'e' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] sha256(java.io.File r6) throws java.security.NoSuchAlgorithmException, java.io.IOException {
        /*
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException | NoSuchAlgorithmException -> 0x004b }
            r0.<init>(r6)     // Catch:{ IOException | NoSuchAlgorithmException -> 0x004b }
            r1 = 0
            java.security.DigestInputStream r2 = new java.security.DigestInputStream     // Catch:{ Throwable -> 0x003a }
            java.lang.String r3 = "SHA-256"
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)     // Catch:{ Throwable -> 0x003a }
            r2.<init>(r0, r3)     // Catch:{ Throwable -> 0x003a }
            java.security.MessageDigest r3 = r2.getMessageDigest()     // Catch:{ Throwable -> 0x0023, all -> 0x0020 }
            byte[] r3 = r3.digest()     // Catch:{ Throwable -> 0x0023, all -> 0x0020 }
            r2.close()     // Catch:{ Throwable -> 0x003a }
            r0.close()     // Catch:{ IOException | NoSuchAlgorithmException -> 0x004b }
            return r3
        L_0x0020:
            r3 = move-exception
            r4 = r1
            goto L_0x0029
        L_0x0023:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r4 = move-exception
            r5 = r4
            r4 = r3
            r3 = r5
        L_0x0029:
            if (r4 == 0) goto L_0x0034
            r2.close()     // Catch:{ Throwable -> 0x002f }
            goto L_0x0037
        L_0x002f:
            r2 = move-exception
            r4.addSuppressed(r2)     // Catch:{ Throwable -> 0x003a }
            goto L_0x0037
        L_0x0034:
            r2.close()     // Catch:{ Throwable -> 0x003a }
        L_0x0037:
            throw r3     // Catch:{ Throwable -> 0x003a }
        L_0x0038:
            r2 = move-exception
            goto L_0x003c
        L_0x003a:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0038 }
        L_0x003c:
            if (r1 == 0) goto L_0x0047
            r0.close()     // Catch:{ Throwable -> 0x0042, IOException | NoSuchAlgorithmException -> 0x004b }
            goto L_0x004a
        L_0x0042:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch:{ IOException | NoSuchAlgorithmException -> 0x004b }
            goto L_0x004a
        L_0x0047:
            r0.close()     // Catch:{ IOException | NoSuchAlgorithmException -> 0x004b }
        L_0x004a:
            throw r2     // Catch:{ IOException | NoSuchAlgorithmException -> 0x004b }
        L_0x004b:
            r0 = move-exception
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to checksum file via SHA-256: "
            r2.append(r3)
            java.lang.String r6 = r6.toString()
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            android.util.Log.e(r1, r6, r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.UpdatesUtils.sha256(java.io.File):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0056, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005a, code lost:
        if (r4 != null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0060, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0061, code lost:
        r4.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0065, code lost:
        r0.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] sha256AndWriteToFile(java.io.InputStream r4, java.io.File r5) throws java.security.NoSuchAlgorithmException, java.io.IOException {
        /*
            java.security.DigestInputStream r0 = new java.security.DigestInputStream
            java.lang.String r1 = "SHA-256"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)
            r0.<init>(r4, r1)
            r4 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x0058 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0058 }
            r2.<init>()     // Catch:{ Throwable -> 0x0058 }
            java.lang.String r3 = r5.getAbsolutePath()     // Catch:{ Throwable -> 0x0058 }
            r2.append(r3)     // Catch:{ Throwable -> 0x0058 }
            java.lang.String r3 = ".tmp"
            r2.append(r3)     // Catch:{ Throwable -> 0x0058 }
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x0058 }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x0058 }
            org.apache.commons.p032io.FileUtils.copyInputStreamToFile(r0, r1)     // Catch:{ Throwable -> 0x0058 }
            boolean r1 = r1.renameTo(r5)     // Catch:{ Throwable -> 0x0058 }
            if (r1 == 0) goto L_0x003b
            java.security.MessageDigest r5 = r0.getMessageDigest()     // Catch:{ Throwable -> 0x0058 }
            byte[] r5 = r5.digest()     // Catch:{ Throwable -> 0x0058 }
            r0.close()
            return r5
        L_0x003b:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ Throwable -> 0x0058 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0058 }
            r2.<init>()     // Catch:{ Throwable -> 0x0058 }
            java.lang.String r3 = "File download was successful, but failed to move from temporary to permanent location "
            r2.append(r3)     // Catch:{ Throwable -> 0x0058 }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ Throwable -> 0x0058 }
            r2.append(r5)     // Catch:{ Throwable -> 0x0058 }
            java.lang.String r5 = r2.toString()     // Catch:{ Throwable -> 0x0058 }
            r1.<init>(r5)     // Catch:{ Throwable -> 0x0058 }
            throw r1     // Catch:{ Throwable -> 0x0058 }
        L_0x0056:
            r5 = move-exception
            goto L_0x005a
        L_0x0058:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0056 }
        L_0x005a:
            if (r4 == 0) goto L_0x0065
            r0.close()     // Catch:{ Throwable -> 0x0060 }
            goto L_0x0068
        L_0x0060:
            r0 = move-exception
            r4.addSuppressed(r0)
            goto L_0x0068
        L_0x0065:
            r0.close()
        L_0x0068:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.UpdatesUtils.sha256AndWriteToFile(java.io.InputStream, java.io.File):byte[]");
    }

    public static String createFilenameForAsset(AssetEntity assetEntity) {
        String str;
        if (assetEntity.url == null) {
            return assetEntity.key;
        }
        try {
            str = sha256(assetEntity.url.toString());
        } catch (Exception unused) {
            str = Uri.encode(assetEntity.url.toString());
        }
        return str + "." + assetEntity.type;
    }

    public static void sendEventToReactNative(@Nullable WeakReference<ReactNativeHost> weakReference, String str, WritableMap writableMap) {
        if (weakReference == null || weakReference.get() == null) {
            String str2 = TAG;
            Log.e(str2, "Could not emit " + str + " event; UpdatesController was not initialized with an instance of ReactApplication.");
            return;
        }
        AsyncTask.execute(new Runnable(writableMap, str) {
            private final /* synthetic */ WritableMap f$1;
            private final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                UpdatesUtils.lambda$sendEventToReactNative$0(ReactInstanceManager.this, this.f$1, this.f$2);
            }
        });
    }

    static /* synthetic */ void lambda$sendEventToReactNative$0(ReactInstanceManager reactInstanceManager, WritableMap writableMap, String str) {
        DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter;
        ReactContext reactContext = null;
        int i = 0;
        while (true) {
            if (i >= 5) {
                break;
            }
            try {
                reactContext = reactInstanceManager.getCurrentReactContext();
                if (reactContext != null) {
                    break;
                }
                Thread.sleep(1000);
                i++;
            } catch (Exception unused) {
                String str2 = TAG;
                Log.e(str2, "Could not emit " + str + " event; no react context was found.");
                return;
            }
        }
        if (reactContext == null || (rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)) == null) {
            String str3 = TAG;
            Log.e(str3, "Could not emit " + str + " event; no event emitter was found.");
            return;
        }
        if (writableMap == null) {
            writableMap = Arguments.createMap();
        }
        writableMap.putString("type", str);
        rCTDeviceEventEmitter.emit(UPDATES_EVENT_NAME, writableMap);
    }

    public static boolean shouldCheckForUpdateOnLaunch(UpdatesConfiguration updatesConfiguration, Context context) {
        if (updatesConfiguration.getUpdateUrl() == null) {
            return false;
        }
        switch (updatesConfiguration.getCheckOnLaunch()) {
            case NEVER:
                return false;
            case WIFI_ONLY:
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    return !connectivityManager.isActiveNetworkMetered();
                }
                Log.e(TAG, "Could not determine active network connection is metered; not checking for updates");
                return false;
            default:
                return true;
        }
    }

    public static String getRuntimeVersion(UpdatesConfiguration updatesConfiguration) {
        String runtimeVersion = updatesConfiguration.getRuntimeVersion();
        String sdkVersion = updatesConfiguration.getSdkVersion();
        if (runtimeVersion != null && runtimeVersion.length() > 0) {
            return runtimeVersion;
        }
        if (sdkVersion != null && sdkVersion.length() > 0) {
            return sdkVersion;
        }
        throw new AssertionError("One of expo_runtime_version or expo_sdk_version must be defined in the Android app manifest");
    }

    public static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & UByte.MAX_VALUE;
            int i2 = i * 2;
            cArr[i2] = HEX_ARRAY[b >>> 4];
            cArr[i2 + 1] = HEX_ARRAY[b & 15];
        }
        return new String(cArr);
    }
}
