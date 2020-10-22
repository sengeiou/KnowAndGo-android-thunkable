package com.RNFetchBlob;

import android.content.res.AssetFileDescriptor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.RNFetchBlob.Utils.PathResolver;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

class RNFetchBlobFS {
    private static HashMap<String, RNFetchBlobFS> fileStreams = new HashMap<>();
    private DeviceEventManagerModule.RCTDeviceEventEmitter emitter;
    private String encoding = RNFetchBlobConst.RNFB_RESPONSE_BASE64;
    private ReactApplicationContext mCtx;
    private OutputStream writeStreamInstance = null;

    RNFetchBlobFS(ReactApplicationContext reactApplicationContext) {
        this.mCtx = reactApplicationContext;
        this.emitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c3 A[Catch:{ all -> 0x00e4, FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c8 A[Catch:{ all -> 0x00e4, FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void writeFile(java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6, com.facebook.react.bridge.Promise r7) {
        /*
            java.io.File r0 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            java.io.File r1 = r0.getParentFile()     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            boolean r2 = r0.exists()     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            if (r2 != 0) goto L_0x005b
            if (r1 == 0) goto L_0x0039
            boolean r2 = r1.exists()     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            if (r2 != 0) goto L_0x0039
            boolean r1 = r1.mkdirs()     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            if (r1 != 0) goto L_0x0039
            java.lang.String r4 = "EUNSPECIFIED"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            java.lang.String r6 = "Failed to create parent directory of '"
            r5.append(r6)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            r5.append(r3)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            java.lang.String r6 = "'"
            r5.append(r6)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            java.lang.String r5 = r5.toString()     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            r7.reject((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            return
        L_0x0039:
            boolean r1 = r0.createNewFile()     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            if (r1 != 0) goto L_0x005b
            java.lang.String r4 = "ENOENT"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            java.lang.String r6 = "File '"
            r5.append(r6)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            r5.append(r3)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            java.lang.String r6 = "' does not exist and could not be created"
            r5.append(r6)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            java.lang.String r5 = r5.toString()     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            r7.reject((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            return
        L_0x005b:
            java.lang.String r1 = "uri"
            boolean r1 = r4.equalsIgnoreCase(r1)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            if (r1 == 0) goto L_0x00cc
            java.lang.String r4 = normalizePath(r5)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            java.io.File r5 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            boolean r1 = r5.exists()     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            if (r1 != 0) goto L_0x0097
            java.lang.String r5 = "ENOENT"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            r6.<init>()     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            java.lang.String r0 = "No such file '"
            r6.append(r0)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            r6.append(r3)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            java.lang.String r0 = "' ('"
            r6.append(r0)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            r6.append(r4)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            java.lang.String r4 = "')"
            r6.append(r4)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            java.lang.String r4 = r6.toString()     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            r7.reject((java.lang.String) r5, (java.lang.String) r4)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            return
        L_0x0097:
            r4 = 10240(0x2800, float:1.4349E-41)
            byte[] r4 = new byte[r4]     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x00bf }
            r2.<init>(r5)     // Catch:{ all -> 0x00bf }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x00bd }
            r5.<init>(r0, r6)     // Catch:{ all -> 0x00bd }
            r6 = 0
            r0 = 0
        L_0x00a8:
            int r1 = r2.read(r4)     // Catch:{ all -> 0x00ba }
            if (r1 <= 0) goto L_0x00b3
            r5.write(r4, r6, r1)     // Catch:{ all -> 0x00ba }
            int r0 = r0 + r1
            goto L_0x00a8
        L_0x00b3:
            r2.close()     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            r5.close()     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            goto L_0x00dc
        L_0x00ba:
            r4 = move-exception
            r1 = r5
            goto L_0x00c1
        L_0x00bd:
            r4 = move-exception
            goto L_0x00c1
        L_0x00bf:
            r4 = move-exception
            r2 = r1
        L_0x00c1:
            if (r2 == 0) goto L_0x00c6
            r2.close()     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
        L_0x00c6:
            if (r1 == 0) goto L_0x00cb
            r1.close()     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
        L_0x00cb:
            throw r4     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
        L_0x00cc:
            byte[] r4 = stringToBytes(r5, r4)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            r5.<init>(r0, r6)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            r5.write(r4)     // Catch:{ all -> 0x00e4 }
            int r0 = r4.length     // Catch:{ all -> 0x00e4 }
            r5.close()     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
        L_0x00dc:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            r7.resolve(r4)     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            goto L_0x010f
        L_0x00e4:
            r4 = move-exception
            r5.close()     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
            throw r4     // Catch:{ FileNotFoundException -> 0x00f4, Exception -> 0x00e9 }
        L_0x00e9:
            r3 = move-exception
            java.lang.String r4 = "EUNSPECIFIED"
            java.lang.String r3 = r3.getLocalizedMessage()
            r7.reject((java.lang.String) r4, (java.lang.String) r3)
            goto L_0x010f
        L_0x00f4:
            java.lang.String r4 = "ENOENT"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "File '"
            r5.append(r6)
            r5.append(r3)
            java.lang.String r3 = "' does not exist and could not be created, or it is a directory"
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r7.reject((java.lang.String) r4, (java.lang.String) r3)
        L_0x010f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobFS.writeFile(java.lang.String, java.lang.String, java.lang.String, boolean, com.facebook.react.bridge.Promise):void");
    }

    static void writeFile(String str, ReadableArray readableArray, boolean z, Promise promise) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!file.exists()) {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    promise.reject("ENOTDIR", "Failed to create parent directory of '" + str + "'");
                    return;
                } else if (!file.createNewFile()) {
                    promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            }
            fileOutputStream = new FileOutputStream(file, z);
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            promise.resolve(Integer.valueOf(readableArray.size()));
        } catch (FileNotFoundException unused) {
            promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x007c A[Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009b A[Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d8 A[Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00db A[Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e5 A[Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f8 A[Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void readFile(java.lang.String r6, java.lang.String r7, com.facebook.react.bridge.Promise r8) {
        /*
            java.lang.String r0 = normalizePath(r6)
            if (r0 == 0) goto L_0x0007
            r6 = r0
        L_0x0007:
            r1 = 0
            if (r0 == 0) goto L_0x0043
            java.lang.String r2 = "bundle-assets://"
            boolean r2 = r0.startsWith(r2)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            if (r2 == 0) goto L_0x0043
            java.lang.String r0 = "bundle-assets://"
            java.lang.String r2 = ""
            java.lang.String r0 = r6.replace(r0, r2)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            com.facebook.react.bridge.ReactApplicationContext r2 = com.RNFetchBlob.C0623RNFetchBlob.RCTContext     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            android.content.res.AssetFileDescriptor r2 = r2.openFd(r0)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            long r2 = r2.getLength()     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            int r2 = (int) r2     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            byte[] r3 = new byte[r2]     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            com.facebook.react.bridge.ReactApplicationContext r4 = com.RNFetchBlob.C0623RNFetchBlob.RCTContext     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            java.io.InputStream r0 = r4.open(r0)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            int r4 = r0.read(r3, r1, r2)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            r0.close()     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            goto L_0x007a
        L_0x003d:
            r6 = move-exception
            goto L_0x0107
        L_0x0040:
            r7 = move-exception
            goto L_0x0111
        L_0x0043:
            if (r0 != 0) goto L_0x0061
            com.facebook.react.bridge.ReactApplicationContext r0 = com.RNFetchBlob.C0623RNFetchBlob.RCTContext     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            android.net.Uri r2 = android.net.Uri.parse(r6)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            java.io.InputStream r0 = r0.openInputStream(r2)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            int r2 = r0.available()     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            byte[] r3 = new byte[r2]     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            int r4 = r0.read(r3)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            r0.close()     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            goto L_0x007a
        L_0x0061:
            java.io.File r0 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            r0.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            long r2 = r0.length()     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            int r2 = (int) r2     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            byte[] r3 = new byte[r2]     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            r4.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            int r0 = r4.read(r3)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            r4.close()     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            r4 = r0
        L_0x007a:
            if (r4 >= r2) goto L_0x009b
            java.lang.String r7 = "EUNSPECIFIED"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            r0.<init>()     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            java.lang.String r1 = "Read only "
            r0.append(r1)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            r0.append(r4)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            java.lang.String r1 = " bytes of "
            r0.append(r1)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            r0.append(r2)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            java.lang.String r0 = r0.toString()     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            r8.reject((java.lang.String) r7, (java.lang.String) r0)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            return
        L_0x009b:
            java.lang.String r7 = r7.toLowerCase()     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            r0 = -1
            int r2 = r7.hashCode()     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            r4 = -1396204209(0xffffffffacc79d4f, float:-5.673385E-12)
            r5 = 2
            if (r2 == r4) goto L_0x00ca
            r4 = 3600241(0x36ef71, float:5.045012E-39)
            if (r2 == r4) goto L_0x00bf
            r4 = 93106001(0x58caf51, float:1.3229938E-35)
            if (r2 == r4) goto L_0x00b5
            goto L_0x00d4
        L_0x00b5:
            java.lang.String r2 = "ascii"
            boolean r7 = r7.equals(r2)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            if (r7 == 0) goto L_0x00d4
            r7 = 1
            goto L_0x00d5
        L_0x00bf:
            java.lang.String r2 = "utf8"
            boolean r7 = r7.equals(r2)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            if (r7 == 0) goto L_0x00d4
            r7 = 2
            goto L_0x00d5
        L_0x00ca:
            java.lang.String r2 = "base64"
            boolean r7 = r7.equals(r2)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            if (r7 == 0) goto L_0x00d4
            r7 = 0
            goto L_0x00d5
        L_0x00d4:
            r7 = -1
        L_0x00d5:
            switch(r7) {
                case 0: goto L_0x00f8;
                case 1: goto L_0x00e5;
                case 2: goto L_0x00db;
                default: goto L_0x00d8;
            }     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
        L_0x00d8:
            java.lang.String r7 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            goto L_0x0100
        L_0x00db:
            java.lang.String r7 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            r7.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            r8.resolve(r7)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            goto L_0x015a
        L_0x00e5:
            com.facebook.react.bridge.WritableArray r7 = com.facebook.react.bridge.Arguments.createArray()     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            int r0 = r3.length     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
        L_0x00ea:
            if (r1 >= r0) goto L_0x00f4
            byte r2 = r3[r1]     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            r7.pushInt(r2)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            int r1 = r1 + 1
            goto L_0x00ea
        L_0x00f4:
            r8.resolve(r7)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            goto L_0x015a
        L_0x00f8:
            java.lang.String r7 = android.util.Base64.encodeToString(r3, r5)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            r8.resolve(r7)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            goto L_0x015a
        L_0x0100:
            r7.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            r8.resolve(r7)     // Catch:{ FileNotFoundException -> 0x0040, Exception -> 0x003d }
            goto L_0x015a
        L_0x0107:
            java.lang.String r7 = "EUNSPECIFIED"
            java.lang.String r6 = r6.getLocalizedMessage()
            r8.reject((java.lang.String) r7, (java.lang.String) r6)
            goto L_0x015a
        L_0x0111:
            java.lang.String r7 = r7.getLocalizedMessage()
            java.lang.String r0 = "EISDIR"
            boolean r0 = r7.contains(r0)
            if (r0 == 0) goto L_0x013c
            java.lang.String r0 = "EISDIR"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expecting a file but '"
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = "' is a directory; "
            r1.append(r6)
            r1.append(r7)
            java.lang.String r6 = r1.toString()
            r8.reject((java.lang.String) r0, (java.lang.String) r6)
            goto L_0x015a
        L_0x013c:
            java.lang.String r0 = "ENOENT"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "No such file '"
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = "'; "
            r1.append(r6)
            r1.append(r7)
            java.lang.String r6 = r1.toString()
            r8.reject((java.lang.String) r0, (java.lang.String) r6)
        L_0x015a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobFS.readFile(java.lang.String, java.lang.String, com.facebook.react.bridge.Promise):void");
    }

    static Map<String, Object> getSystemfolders(ReactApplicationContext reactApplicationContext) {
        HashMap hashMap = new HashMap();
        hashMap.put("DocumentDir", reactApplicationContext.getFilesDir().getAbsolutePath());
        hashMap.put("CacheDir", reactApplicationContext.getCacheDir().getAbsolutePath());
        hashMap.put("DCIMDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath());
        hashMap.put("PictureDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
        hashMap.put("MusicDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath());
        hashMap.put("DownloadDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
        hashMap.put("MovieDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath());
        hashMap.put("RingtoneDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES).getAbsolutePath());
        if (Environment.getExternalStorageState().equals("mounted")) {
            hashMap.put("SDCardDir", Environment.getExternalStorageDirectory().getAbsolutePath());
            File externalFilesDir = reactApplicationContext.getExternalFilesDir((String) null);
            if (externalFilesDir != null) {
                hashMap.put("SDCardApplicationDir", externalFilesDir.getParentFile().getAbsolutePath());
            } else {
                hashMap.put("SDCardApplicationDir", "");
            }
        }
        hashMap.put("MainBundleDir", reactApplicationContext.getApplicationInfo().dataDir);
        return hashMap;
    }

    public static void getSDCardDir(Promise promise) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            promise.resolve(Environment.getExternalStorageDirectory().getAbsolutePath());
        } else {
            promise.reject("RNFetchBlob.getSDCardDir", "External storage not mounted");
        }
    }

    public static void getSDCardApplicationDir(ReactApplicationContext reactApplicationContext, Promise promise) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                promise.resolve(reactApplicationContext.getExternalFilesDir((String) null).getParentFile().getAbsolutePath());
            } catch (Exception e) {
                promise.reject("RNFetchBlob.getSDCardApplicationDir", e.getLocalizedMessage());
            }
        } else {
            promise.reject("RNFetchBlob.getSDCardApplicationDir", "External storage not mounted");
        }
    }

    static String getTmpPath(String str) {
        return C0623RNFetchBlob.RCTContext.getFilesDir() + "/RNFetchBlobTmp_" + str;
    }

    /* access modifiers changed from: package-private */
    public void readStream(String str, String str2, int i, int i2, String str3) {
        InputStream inputStream;
        String normalizePath = normalizePath(str);
        if (normalizePath != null) {
            str = normalizePath;
        }
        try {
            int i3 = str2.equalsIgnoreCase(RNFetchBlobConst.RNFB_RESPONSE_BASE64) ? 4095 : 4096;
            if (i <= 0) {
                i = i3;
            }
            if (normalizePath != null && str.startsWith(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET)) {
                inputStream = C0623RNFetchBlob.RCTContext.getAssets().open(str.replace(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET, ""));
            } else if (normalizePath == null) {
                inputStream = C0623RNFetchBlob.RCTContext.getContentResolver().openInputStream(Uri.parse(str));
            } else {
                inputStream = new FileInputStream(new File(str));
            }
            byte[] bArr = new byte[i];
            boolean z = false;
            if (str2.equalsIgnoreCase(RNFetchBlobConst.RNFB_RESPONSE_UTF8)) {
                CharsetEncoder newEncoder = Charset.forName("UTF-8").newEncoder();
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    newEncoder.encode(ByteBuffer.wrap(bArr).asCharBuffer());
                    emitStreamEvent(str3, "data", new String(bArr, 0, read));
                    if (i2 > 0) {
                        SystemClock.sleep((long) i2);
                    }
                }
            } else if (str2.equalsIgnoreCase("ascii")) {
                while (true) {
                    int read2 = inputStream.read(bArr);
                    if (read2 == -1) {
                        break;
                    }
                    WritableArray createArray = Arguments.createArray();
                    for (int i4 = 0; i4 < read2; i4++) {
                        createArray.pushInt(bArr[i4]);
                    }
                    emitStreamEvent(str3, "data", createArray);
                    if (i2 > 0) {
                        SystemClock.sleep((long) i2);
                    }
                }
            } else if (str2.equalsIgnoreCase(RNFetchBlobConst.RNFB_RESPONSE_BASE64)) {
                while (true) {
                    int read3 = inputStream.read(bArr);
                    if (read3 == -1) {
                        break;
                    }
                    if (read3 < i) {
                        byte[] bArr2 = new byte[read3];
                        System.arraycopy(bArr, 0, bArr2, 0, read3);
                        emitStreamEvent(str3, "data", Base64.encodeToString(bArr2, 2));
                    } else {
                        emitStreamEvent(str3, "data", Base64.encodeToString(bArr, 2));
                    }
                    if (i2 > 0) {
                        SystemClock.sleep((long) i2);
                    }
                }
            } else {
                emitStreamEvent(str3, "error", "EINVAL", "Unrecognized encoding `" + str2 + "`, should be one of `base64`, `utf8`, `ascii`");
                z = true;
            }
            if (!z) {
                emitStreamEvent(str3, "end", "");
            }
            inputStream.close();
        } catch (FileNotFoundException unused) {
            emitStreamEvent(str3, "error", "ENOENT", "No such file '" + str + "'");
        } catch (Exception e) {
            emitStreamEvent(str3, "error", "EUNSPECIFIED", "Failed to convert data to " + str2 + " encoded string. This might be because this encoding cannot be used for this data.");
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void writeStream(String str, String str2, boolean z, Callback callback) {
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!file.exists()) {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                    callback.invoke("ENOTDIR", "Failed to create parent directory of '" + str + "'");
                    return;
                } else if (!file.createNewFile()) {
                    callback.invoke("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            } else if (file.isDirectory()) {
                callback.invoke("EISDIR", "Expecting a file but '" + str + "' is a directory");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str, z);
            this.encoding = str2;
            String uuid = UUID.randomUUID().toString();
            fileStreams.put(uuid, this);
            this.writeStreamInstance = fileOutputStream;
            callback.invoke(null, null, uuid);
        } catch (Exception e) {
            callback.invoke("EUNSPECIFIED", "Failed to create write stream at path `" + str + "`; " + e.getLocalizedMessage());
        }
    }

    static void writeChunk(String str, String str2, Callback callback) {
        RNFetchBlobFS rNFetchBlobFS = fileStreams.get(str);
        try {
            rNFetchBlobFS.writeStreamInstance.write(stringToBytes(str2, rNFetchBlobFS.encoding));
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static void writeArrayChunk(String str, ReadableArray readableArray, Callback callback) {
        try {
            OutputStream outputStream = fileStreams.get(str).writeStreamInstance;
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            outputStream.write(bArr);
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static void closeStream(String str, Callback callback) {
        try {
            OutputStream outputStream = fileStreams.get(str).writeStreamInstance;
            fileStreams.remove(str);
            outputStream.close();
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static void unlink(String str, Callback callback) {
        try {
            deleteRecursive(new File(normalizePath(str)));
            callback.invoke(null, true);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage(), false);
        }
    }

    private static void deleteRecursive(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File deleteRecursive : listFiles) {
                    deleteRecursive(deleteRecursive);
                }
            } else {
                throw new NullPointerException("Received null trying to list files of directory '" + file + "'");
            }
        }
        if (!file.delete()) {
            throw new IOException("Failed to delete '" + file + "'");
        }
    }

    static void mkdir(String str, Promise promise) {
        File file = new File(str);
        if (file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append(file.isDirectory() ? "Folder" : "File");
            sb.append(" '");
            sb.append(str);
            sb.append("' already exists");
            promise.reject("EEXIST", sb.toString());
            return;
        }
        try {
            if (!file.mkdirs()) {
                promise.reject("EUNSPECIFIED", "mkdir failed to create some or all directories in '" + str + "'");
                return;
            }
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c1 A[SYNTHETIC, Splitter:B:43:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c9 A[Catch:{ Exception -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f7 A[SYNTHETIC, Splitter:B:57:0x00f7] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ff A[Catch:{ Exception -> 0x00fb }] */
    /* renamed from: cp */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m14cp(java.lang.String r6, java.lang.String r7, com.facebook.react.bridge.Callback r8) {
        /*
            java.lang.String r6 = normalizePath(r6)
            java.lang.String r0 = ""
            r1 = 0
            r2 = 1
            r3 = 0
            boolean r4 = isPathExists(r6)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            if (r4 != 0) goto L_0x002d
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            r4.<init>()     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.lang.String r5 = "Source file at path`"
            r4.append(r5)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            r4.append(r6)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.lang.String r6 = "` does not exist"
            r4.append(r6)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.lang.String r6 = r4.toString()     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            r7[r3] = r6     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            r8.invoke(r7)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            return
        L_0x002d:
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            r4.<init>(r7)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            boolean r4 = r4.exists()     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            if (r4 != 0) goto L_0x0061
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            r4.<init>(r7)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            boolean r4 = r4.createNewFile()     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            if (r4 != 0) goto L_0x0061
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            r4.<init>()     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.lang.String r5 = "Destination file at '"
            r4.append(r5)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            r4.append(r7)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.lang.String r7 = "' already exists"
            r4.append(r7)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.lang.String r7 = r4.toString()     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            r6[r3] = r7     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            r8.invoke(r6)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            return
        L_0x0061:
            java.io.InputStream r6 = inputStreamFromPath(r6)     // Catch:{ Exception -> 0x00aa, all -> 0x00a7 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00a2, all -> 0x009d }
            r4.<init>(r7)     // Catch:{ Exception -> 0x00a2, all -> 0x009d }
            r7 = 10240(0x2800, float:1.4349E-41)
            byte[] r7 = new byte[r7]     // Catch:{ Exception -> 0x009b, all -> 0x0099 }
        L_0x006e:
            int r1 = r6.read(r7)     // Catch:{ Exception -> 0x009b, all -> 0x0099 }
            if (r1 <= 0) goto L_0x0078
            r4.write(r7, r3, r1)     // Catch:{ Exception -> 0x009b, all -> 0x0099 }
            goto L_0x006e
        L_0x0078:
            if (r6 == 0) goto L_0x0080
            r6.close()     // Catch:{ Exception -> 0x007e }
            goto L_0x0080
        L_0x007e:
            r6 = move-exception
            goto L_0x0085
        L_0x0080:
            r4.close()     // Catch:{ Exception -> 0x007e }
            goto L_0x00e2
        L_0x0085:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            java.lang.String r6 = r6.getLocalizedMessage()
            r7.append(r6)
            java.lang.String r0 = r7.toString()
            goto L_0x00e2
        L_0x0099:
            r7 = move-exception
            goto L_0x009f
        L_0x009b:
            r7 = move-exception
            goto L_0x00a4
        L_0x009d:
            r7 = move-exception
            r4 = r1
        L_0x009f:
            r1 = r6
            r6 = r7
            goto L_0x00f5
        L_0x00a2:
            r7 = move-exception
            r4 = r1
        L_0x00a4:
            r1 = r6
            r6 = r7
            goto L_0x00ac
        L_0x00a7:
            r6 = move-exception
            r4 = r1
            goto L_0x00f5
        L_0x00aa:
            r6 = move-exception
            r4 = r1
        L_0x00ac:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f4 }
            r7.<init>()     // Catch:{ all -> 0x00f4 }
            r7.append(r0)     // Catch:{ all -> 0x00f4 }
            java.lang.String r6 = r6.getLocalizedMessage()     // Catch:{ all -> 0x00f4 }
            r7.append(r6)     // Catch:{ all -> 0x00f4 }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x00f4 }
            if (r1 == 0) goto L_0x00c7
            r1.close()     // Catch:{ Exception -> 0x00c5 }
            goto L_0x00c7
        L_0x00c5:
            r7 = move-exception
            goto L_0x00cd
        L_0x00c7:
            if (r4 == 0) goto L_0x00e1
            r4.close()     // Catch:{ Exception -> 0x00c5 }
            goto L_0x00e1
        L_0x00cd:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            java.lang.String r6 = r7.getLocalizedMessage()
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            goto L_0x00e2
        L_0x00e1:
            r0 = r6
        L_0x00e2:
            java.lang.String r6 = ""
            if (r0 == r6) goto L_0x00ee
            java.lang.Object[] r6 = new java.lang.Object[r2]
            r6[r3] = r0
            r8.invoke(r6)
            goto L_0x00f3
        L_0x00ee:
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r8.invoke(r6)
        L_0x00f3:
            return
        L_0x00f4:
            r6 = move-exception
        L_0x00f5:
            if (r1 == 0) goto L_0x00fd
            r1.close()     // Catch:{ Exception -> 0x00fb }
            goto L_0x00fd
        L_0x00fb:
            r7 = move-exception
            goto L_0x0103
        L_0x00fd:
            if (r4 == 0) goto L_0x0115
            r4.close()     // Catch:{ Exception -> 0x00fb }
            goto L_0x0115
        L_0x0103:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            java.lang.String r7 = r7.getLocalizedMessage()
            r8.append(r7)
            r8.toString()
        L_0x0115:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobFS.m14cp(java.lang.String, java.lang.String, com.facebook.react.bridge.Callback):void");
    }

    /* renamed from: mv */
    static void m17mv(String str, String str2, Callback callback) {
        File file = new File(str);
        if (!file.exists()) {
            callback.invoke("Source file at path `" + str + "` does not exist");
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    fileOutputStream.flush();
                    file.delete();
                    callback.invoke(new Object[0]);
                    return;
                }
            }
        } catch (FileNotFoundException unused) {
            callback.invoke("Source file not found.");
        } catch (Exception e) {
            callback.invoke(e.toString());
        }
    }

    static void exists(String str, Callback callback) {
        if (isAsset(str)) {
            try {
                C0623RNFetchBlob.RCTContext.getAssets().openFd(str.replace(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET, ""));
                callback.invoke(true, false);
            } catch (IOException unused) {
                callback.invoke(false, false);
            }
        } else {
            String normalizePath = normalizePath(str);
            if (normalizePath != null) {
                callback.invoke(Boolean.valueOf(new File(normalizePath).exists()), Boolean.valueOf(new File(normalizePath).isDirectory()));
                return;
            }
            callback.invoke(false, false);
        }
    }

    /* renamed from: ls */
    static void m16ls(String str, Promise promise) {
        try {
            String normalizePath = normalizePath(str);
            File file = new File(normalizePath);
            if (!file.exists()) {
                promise.reject("ENOENT", "No such file '" + normalizePath + "'");
            } else if (!file.isDirectory()) {
                promise.reject("ENOTDIR", "Not a directory '" + normalizePath + "'");
            } else {
                String[] list = new File(normalizePath).list();
                WritableArray createArray = Arguments.createArray();
                for (String pushString : list) {
                    createArray.pushString(pushString);
                }
                promise.resolve(createArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void slice(String str, String str2, int i, int i2, String str3, Promise promise) {
        try {
            String normalizePath = normalizePath(str);
            File file = new File(normalizePath);
            if (file.isDirectory()) {
                promise.reject("EISDIR", "Expecting a file but '" + normalizePath + "' is a directory");
            } else if (!file.exists()) {
                promise.reject("ENOENT", "No such file '" + normalizePath + "'");
            } else {
                int length = (int) file.length();
                int min = Math.min(length, i2) - i;
                FileInputStream fileInputStream = new FileInputStream(new File(normalizePath));
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
                int skip = (int) fileInputStream.skip((long) i);
                if (skip != i) {
                    promise.reject("EUNSPECIFIED", "Skipped " + skip + " instead of the specified " + i + " bytes, size is " + length);
                    return;
                }
                byte[] bArr = new byte[10240];
                int i3 = 0;
                while (true) {
                    if (i3 >= min) {
                        break;
                    }
                    int read = fileInputStream.read(bArr, 0, 10240);
                    int i4 = min - i3;
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, Math.min(i4, read));
                    i3 += read;
                }
                fileInputStream.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                promise.resolve(str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void lstat(String str, final Callback callback) {
        String normalizePath = normalizePath(str);
        new AsyncTask<String, Integer, Integer>() {
            /* access modifiers changed from: protected */
            public Integer doInBackground(String... strArr) {
                WritableArray createArray = Arguments.createArray();
                if (strArr[0] == null) {
                    callback.invoke("the path specified for lstat is either `null` or `undefined`.");
                    return 0;
                }
                File file = new File(strArr[0]);
                if (!file.exists()) {
                    callback.invoke("failed to lstat path `" + strArr[0] + "` because it does not exist or it is not a folder");
                    return 0;
                }
                if (file.isDirectory()) {
                    for (String str : file.list()) {
                        createArray.pushMap(RNFetchBlobFS.statFile(file.getPath() + "/" + str));
                    }
                } else {
                    createArray.pushMap(RNFetchBlobFS.statFile(file.getAbsolutePath()));
                }
                callback.invoke(null, createArray);
                return 0;
            }
        }.execute(new String[]{normalizePath});
    }

    static void stat(String str, Callback callback) {
        try {
            String normalizePath = normalizePath(str);
            WritableMap statFile = statFile(normalizePath);
            if (statFile == null) {
                callback.invoke("failed to stat path `" + normalizePath + "` because it does not exist or it is not a folder", null);
                return;
            }
            callback.invoke(null, statFile);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static WritableMap statFile(String str) {
        try {
            String normalizePath = normalizePath(str);
            WritableMap createMap = Arguments.createMap();
            if (isAsset(normalizePath)) {
                String replace = normalizePath.replace(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET, "");
                AssetFileDescriptor openFd = C0623RNFetchBlob.RCTContext.getAssets().openFd(replace);
                createMap.putString("filename", replace);
                createMap.putString(RNFetchBlobConst.RNFB_RESPONSE_PATH, normalizePath);
                createMap.putString("type", UriUtil.LOCAL_ASSET_SCHEME);
                createMap.putString("size", String.valueOf(openFd.getLength()));
                createMap.putInt("lastModified", 0);
            } else {
                File file = new File(normalizePath);
                if (!file.exists()) {
                    return null;
                }
                createMap.putString("filename", file.getName());
                createMap.putString(RNFetchBlobConst.RNFB_RESPONSE_PATH, file.getPath());
                createMap.putString("type", file.isDirectory() ? "directory" : UriUtil.LOCAL_FILE_SCHEME);
                createMap.putString("size", String.valueOf(file.length()));
                createMap.putString("lastModified", String.valueOf(file.lastModified()));
            }
            return createMap;
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void scanFile(String[] strArr, String[] strArr2, final Callback callback) {
        try {
            MediaScannerConnection.scanFile(this.mCtx, strArr, strArr2, new MediaScannerConnection.OnScanCompletedListener() {
                public void onScanCompleted(String str, Uri uri) {
                    callback.invoke(null, true);
                }
            });
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage(), null);
        }
    }

    static void hash(String str, String str2, Promise promise) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("md5", MessageDigestAlgorithms.MD5);
            hashMap.put("sha1", MessageDigestAlgorithms.SHA_1);
            hashMap.put("sha224", "SHA-224");
            hashMap.put("sha256", MessageDigestAlgorithms.SHA_256);
            hashMap.put("sha384", MessageDigestAlgorithms.SHA_384);
            hashMap.put("sha512", MessageDigestAlgorithms.SHA_512);
            if (!hashMap.containsKey(str2)) {
                promise.reject("EINVAL", "Invalid algorithm '" + str2 + "', must be one of md5, sha1, sha224, sha256, sha384, sha512");
                return;
            }
            File file = new File(str);
            if (file.isDirectory()) {
                promise.reject("EISDIR", "Expecting a file but '" + str + "' is a directory");
            } else if (!file.exists()) {
                promise.reject("ENOENT", "No such file '" + str + "'");
            } else {
                MessageDigest instance = MessageDigest.getInstance((String) hashMap.get(str2));
                FileInputStream fileInputStream = new FileInputStream(str);
                byte[] bArr = new byte[1048576];
                if (file.length() != 0) {
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    }
                }
                StringBuilder sb = new StringBuilder();
                byte[] digest = instance.digest();
                int length = digest.length;
                for (int i = 0; i < length; i++) {
                    sb.append(String.format("%02x", new Object[]{Byte.valueOf(digest[i])}));
                }
                promise.resolve(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void createFile(String str, String str2, String str3, Promise promise) {
        try {
            File file = new File(str);
            boolean createNewFile = file.createNewFile();
            if (str3.equals("uri")) {
                File file2 = new File(str2.replace(RNFetchBlobConst.FILE_PREFIX, ""));
                if (!file2.exists()) {
                    promise.reject("ENOENT", "Source file : " + str2 + " does not exist");
                    return;
                }
                FileInputStream fileInputStream = new FileInputStream(file2);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[10240];
                for (int read = fileInputStream.read(bArr); read > 0; read = fileInputStream.read(bArr)) {
                    fileOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                fileOutputStream.close();
            } else if (!createNewFile) {
                promise.reject("EEXIST", "File `" + str + "` already exists");
                return;
            } else {
                new FileOutputStream(file).write(stringToBytes(str2, str3));
            }
            promise.resolve(str);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void createFileASCII(String str, ReadableArray readableArray, Promise promise) {
        try {
            File file = new File(str);
            if (!file.createNewFile()) {
                promise.reject("EEXIST", "File at path `" + str + "` already exists");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            fileOutputStream.write(bArr);
            promise.resolve(str);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* renamed from: df */
    static void m15df(Callback callback) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        WritableMap createMap = Arguments.createMap();
        if (Build.VERSION.SDK_INT >= 18) {
            createMap.putString("internal_free", String.valueOf(statFs.getFreeBytes()));
            createMap.putString("internal_total", String.valueOf(statFs.getTotalBytes()));
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
            createMap.putString("external_free", String.valueOf(statFs2.getFreeBytes()));
            createMap.putString("external_total", String.valueOf(statFs2.getTotalBytes()));
        }
        callback.invoke(null, createMap);
    }

    static void removeSession(ReadableArray readableArray, final Callback callback) {
        new AsyncTask<ReadableArray, Integer, Integer>() {
            /* access modifiers changed from: protected */
            public Integer doInBackground(ReadableArray... readableArrayArr) {
                try {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < readableArrayArr[0].size(); i++) {
                        String string = readableArrayArr[0].getString(i);
                        File file = new File(string);
                        if (file.exists() && !file.delete()) {
                            arrayList.add(string);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        callback.invoke(null, true);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to delete: ");
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            sb.append((String) it.next());
                            sb.append(", ");
                        }
                        callback.invoke(sb.toString());
                    }
                } catch (Exception e) {
                    callback.invoke(e.getLocalizedMessage());
                }
                return Integer.valueOf(readableArrayArr[0].size());
            }
        }.execute(new ReadableArray[]{readableArray});
    }

    private static byte[] stringToBytes(String str, String str2) {
        if (str2.equalsIgnoreCase("ascii")) {
            return str.getBytes(Charset.forName("US-ASCII"));
        }
        if (str2.toLowerCase().contains(RNFetchBlobConst.RNFB_RESPONSE_BASE64)) {
            return Base64.decode(str, 2);
        }
        if (str2.equalsIgnoreCase(RNFetchBlobConst.RNFB_RESPONSE_UTF8)) {
            return str.getBytes(Charset.forName("UTF-8"));
        }
        return str.getBytes(Charset.forName("US-ASCII"));
    }

    private void emitStreamEvent(String str, String str2, String str3) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        createMap.putString("detail", str3);
        this.emitter.emit(str, createMap);
    }

    private void emitStreamEvent(String str, String str2, WritableArray writableArray) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        createMap.putArray("detail", writableArray);
        this.emitter.emit(str, createMap);
    }

    private void emitStreamEvent(String str, String str2, String str3, String str4) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        createMap.putString("code", str3);
        createMap.putString("detail", str4);
        this.emitter.emit(str, createMap);
    }

    private static InputStream inputStreamFromPath(String str) throws IOException {
        if (str.startsWith(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET)) {
            return C0623RNFetchBlob.RCTContext.getAssets().open(str.replace(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET, ""));
        }
        return new FileInputStream(new File(str));
    }

    private static boolean isPathExists(String str) {
        if (!str.startsWith(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET)) {
            return new File(str).exists();
        }
        try {
            C0623RNFetchBlob.RCTContext.getAssets().open(str.replace(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET, ""));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    static boolean isAsset(String str) {
        return str != null && str.startsWith(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET);
    }

    static String normalizePath(String str) {
        if (str == null) {
            return null;
        }
        if (!str.matches("\\w+\\:.*")) {
            return str;
        }
        if (str.startsWith("file://")) {
            return str.replace("file://", "");
        }
        Uri parse = Uri.parse(str);
        if (str.startsWith(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET)) {
            return str;
        }
        return PathResolver.getRealPathFromURI(C0623RNFetchBlob.RCTContext, parse);
    }
}
