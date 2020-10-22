package com.RNFetchBlob;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.RNFetchBlob.RNFetchBlobReq;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import org.apache.commons.p032io.IOUtils;
import p022fi.iki.elonen.NanoHTTPD;

class RNFetchBlobBody extends RequestBody {
    private File bodyCache;
    private Boolean chunkedEncoding = false;
    private long contentLength = 0;
    private ReadableArray form;
    private String mTaskId;
    private MediaType mime;
    private String rawBody;
    int reported = 0;
    private InputStream requestStream;
    private RNFetchBlobReq.RequestType requestType;

    RNFetchBlobBody(String str) {
        this.mTaskId = str;
    }

    /* access modifiers changed from: package-private */
    public RNFetchBlobBody chunkedEncoding(boolean z) {
        this.chunkedEncoding = Boolean.valueOf(z);
        return this;
    }

    /* access modifiers changed from: package-private */
    public RNFetchBlobBody setMIME(MediaType mediaType) {
        this.mime = mediaType;
        return this;
    }

    /* access modifiers changed from: package-private */
    public RNFetchBlobBody setRequestType(RNFetchBlobReq.RequestType requestType2) {
        this.requestType = requestType2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public RNFetchBlobBody setBody(String str) {
        this.rawBody = str;
        if (this.rawBody == null) {
            this.rawBody = "";
            this.requestType = RNFetchBlobReq.RequestType.AsIs;
        }
        try {
            switch (this.requestType) {
                case SingleFile:
                    this.requestStream = getRequestStream();
                    this.contentLength = (long) this.requestStream.available();
                    break;
                case AsIs:
                    this.contentLength = (long) this.rawBody.getBytes().length;
                    this.requestStream = new ByteArrayInputStream(this.rawBody.getBytes());
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            RNFetchBlobUtils.emitWarningEvent("RNFetchBlob failed to create single content request body :" + e.getLocalizedMessage() + IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public RNFetchBlobBody setBody(ReadableArray readableArray) {
        this.form = readableArray;
        try {
            this.bodyCache = createMultipartBodyCache();
            this.requestStream = new FileInputStream(this.bodyCache);
            this.contentLength = this.bodyCache.length();
        } catch (Exception e) {
            e.printStackTrace();
            RNFetchBlobUtils.emitWarningEvent("RNFetchBlob failed to create request multipart body :" + e.getLocalizedMessage());
        }
        return this;
    }

    public long contentLength() {
        if (this.chunkedEncoding.booleanValue()) {
            return -1;
        }
        return this.contentLength;
    }

    public MediaType contentType() {
        return this.mime;
    }

    public void writeTo(@NonNull BufferedSink bufferedSink) {
        try {
            pipeStreamToSink(this.requestStream, bufferedSink);
        } catch (Exception e) {
            RNFetchBlobUtils.emitWarningEvent(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean clearRequestBody() {
        try {
            if (this.bodyCache == null || !this.bodyCache.exists()) {
                return true;
            }
            this.bodyCache.delete();
            return true;
        } catch (Exception e) {
            RNFetchBlobUtils.emitWarningEvent(e.getLocalizedMessage());
            return false;
        }
    }

    private InputStream getRequestStream() throws Exception {
        if (this.rawBody.startsWith(RNFetchBlobConst.FILE_PREFIX)) {
            String normalizePath = RNFetchBlobFS.normalizePath(this.rawBody.substring(RNFetchBlobConst.FILE_PREFIX.length()));
            if (RNFetchBlobFS.isAsset(normalizePath)) {
                try {
                    return C0623RNFetchBlob.RCTContext.getAssets().open(normalizePath.replace(RNFetchBlobConst.FILE_PREFIX_BUNDLE_ASSET, ""));
                } catch (Exception e) {
                    throw new Exception("error when getting request stream from asset : " + e.getLocalizedMessage());
                }
            } else {
                File file = new File(RNFetchBlobFS.normalizePath(normalizePath));
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    return new FileInputStream(file);
                } catch (Exception e2) {
                    throw new Exception("error when getting request stream: " + e2.getLocalizedMessage());
                }
            }
        } else if (this.rawBody.startsWith(RNFetchBlobConst.CONTENT_PREFIX)) {
            String substring = this.rawBody.substring(RNFetchBlobConst.CONTENT_PREFIX.length());
            try {
                return C0623RNFetchBlob.RCTContext.getContentResolver().openInputStream(Uri.parse(substring));
            } catch (Exception e3) {
                throw new Exception("error when getting request stream for content URI: " + substring, e3);
            }
        } else {
            try {
                return new ByteArrayInputStream(Base64.decode(this.rawBody, 0));
            } catch (Exception e4) {
                throw new Exception("error when getting request stream: " + e4.getLocalizedMessage());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0188  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File createMultipartBodyCache() throws java.io.IOException {
        /*
            r11 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "RNFetchBlob-"
            r0.append(r1)
            java.lang.String r1 = r11.mTaskId
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.facebook.react.bridge.ReactApplicationContext r1 = com.RNFetchBlob.C0623RNFetchBlob.RCTContext
            java.io.File r1 = r1.getCacheDir()
            java.lang.String r2 = "rnfb-form-tmp"
            java.lang.String r3 = ""
            java.io.File r1 = java.io.File.createTempFile(r2, r3, r1)
            java.io.FileOutputStream r2 = new java.io.FileOutputStream
            r2.<init>(r1)
            java.util.ArrayList r3 = r11.countFormDataLength()
            com.facebook.react.bridge.ReactApplicationContext r4 = com.RNFetchBlob.C0623RNFetchBlob.RCTContext
            java.util.Iterator r3 = r3.iterator()
        L_0x0030:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x01e4
            java.lang.Object r5 = r3.next()
            com.RNFetchBlob.RNFetchBlobBody$FormField r5 = (com.RNFetchBlob.RNFetchBlobBody.FormField) r5
            java.lang.String r6 = r5.data
            java.lang.String r7 = r5.name
            if (r7 == 0) goto L_0x0030
            if (r6 != 0) goto L_0x0045
            goto L_0x0030
        L_0x0045:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "--"
            r8.append(r9)
            r8.append(r0)
            java.lang.String r9 = "\r\n"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = r5.filename
            if (r9 == 0) goto L_0x0195
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r8)
            java.lang.String r8 = "Content-Disposition: form-data; name=\""
            r9.append(r8)
            r9.append(r7)
            java.lang.String r7 = "\"; filename=\""
            r9.append(r7)
            java.lang.String r7 = r5.filename
            r9.append(r7)
            java.lang.String r7 = "\"\r\n"
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            java.lang.String r7 = "Content-Type: "
            r8.append(r7)
            java.lang.String r5 = r5.mime
            r8.append(r5)
            java.lang.String r5 = "\r\n\r\n"
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            byte[] r5 = r5.getBytes()
            r2.write(r5)
            java.lang.String r5 = "RNFetchBlob-file://"
            boolean r5 = r6.startsWith(r5)
            if (r5 == 0) goto L_0x012c
            java.lang.String r5 = "RNFetchBlob-file://"
            int r5 = r5.length()
            java.lang.String r5 = r6.substring(r5)
            java.lang.String r5 = com.RNFetchBlob.RNFetchBlobFS.normalizePath(r5)
            boolean r6 = com.RNFetchBlob.RNFetchBlobFS.isAsset(r5)
            if (r6 == 0) goto L_0x00f8
            java.lang.String r6 = "bundle-assets://"
            java.lang.String r7 = ""
            java.lang.String r6 = r5.replace(r6, r7)     // Catch:{ IOException -> 0x00d5 }
            android.content.res.AssetManager r7 = r4.getAssets()     // Catch:{ IOException -> 0x00d5 }
            java.io.InputStream r6 = r7.open(r6)     // Catch:{ IOException -> 0x00d5 }
            r11.pipeStreamToFileStream(r6, r2)     // Catch:{ IOException -> 0x00d5 }
            goto L_0x01d9
        L_0x00d5:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Failed to create form data asset :"
            r7.append(r8)
            r7.append(r5)
            java.lang.String r5 = ", "
            r7.append(r5)
            java.lang.String r5 = r6.getLocalizedMessage()
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            com.RNFetchBlob.RNFetchBlobUtils.emitWarningEvent(r5)
            goto L_0x01d9
        L_0x00f8:
            java.io.File r6 = new java.io.File
            java.lang.String r7 = com.RNFetchBlob.RNFetchBlobFS.normalizePath(r5)
            r6.<init>(r7)
            boolean r7 = r6.exists()
            if (r7 == 0) goto L_0x0111
            java.io.FileInputStream r5 = new java.io.FileInputStream
            r5.<init>(r6)
            r11.pipeStreamToFileStream(r5, r2)
            goto L_0x01d9
        L_0x0111:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Failed to create form data from path :"
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = ", file not exists."
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            com.RNFetchBlob.RNFetchBlobUtils.emitWarningEvent(r5)
            goto L_0x01d9
        L_0x012c:
            java.lang.String r5 = "RNFetchBlob-content://"
            boolean r5 = r6.startsWith(r5)
            if (r5 == 0) goto L_0x018c
            java.lang.String r5 = "RNFetchBlob-content://"
            int r5 = r5.length()
            java.lang.String r5 = r6.substring(r5)
            r6 = 0
            android.content.ContentResolver r7 = r4.getContentResolver()     // Catch:{ Exception -> 0x015f }
            android.net.Uri r8 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x015f }
            java.io.InputStream r7 = r7.openInputStream(r8)     // Catch:{ Exception -> 0x015f }
            r11.pipeStreamToFileStream(r7, r2)     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            if (r7 == 0) goto L_0x01d9
            r7.close()
            goto L_0x01d9
        L_0x0155:
            r0 = move-exception
            r6 = r7
            goto L_0x0186
        L_0x0158:
            r6 = move-exception
            r10 = r7
            r7 = r6
            r6 = r10
            goto L_0x0160
        L_0x015d:
            r0 = move-exception
            goto L_0x0186
        L_0x015f:
            r7 = move-exception
        L_0x0160:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x015d }
            r8.<init>()     // Catch:{ all -> 0x015d }
            java.lang.String r9 = "Failed to create form data from content URI:"
            r8.append(r9)     // Catch:{ all -> 0x015d }
            r8.append(r5)     // Catch:{ all -> 0x015d }
            java.lang.String r5 = ", "
            r8.append(r5)     // Catch:{ all -> 0x015d }
            java.lang.String r5 = r7.getLocalizedMessage()     // Catch:{ all -> 0x015d }
            r8.append(r5)     // Catch:{ all -> 0x015d }
            java.lang.String r5 = r8.toString()     // Catch:{ all -> 0x015d }
            com.RNFetchBlob.RNFetchBlobUtils.emitWarningEvent(r5)     // Catch:{ all -> 0x015d }
            if (r6 == 0) goto L_0x01d9
            r6.close()
            goto L_0x01d9
        L_0x0186:
            if (r6 == 0) goto L_0x018b
            r6.close()
        L_0x018b:
            throw r0
        L_0x018c:
            r5 = 0
            byte[] r5 = android.util.Base64.decode(r6, r5)
            r2.write(r5)
            goto L_0x01d9
        L_0x0195:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r8)
            java.lang.String r8 = "Content-Disposition: form-data; name=\""
            r6.append(r8)
            r6.append(r7)
            java.lang.String r7 = "\"\r\n"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            java.lang.String r6 = "Content-Type: "
            r7.append(r6)
            java.lang.String r6 = r5.mime
            r7.append(r6)
            java.lang.String r6 = "\r\n\r\n"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            byte[] r6 = r6.getBytes()
            r2.write(r6)
            java.lang.String r5 = r5.data
            byte[] r5 = r5.getBytes()
            r2.write(r5)
        L_0x01d9:
            java.lang.String r5 = "\r\n"
            byte[] r5 = r5.getBytes()
            r2.write(r5)
            goto L_0x0030
        L_0x01e4:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "--"
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = "--\r\n"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            byte[] r0 = r0.getBytes()
            r2.write(r0)
            r2.flush()
            r2.close()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobBody.createMultipartBodyCache():java.io.File");
    }

    private void pipeStreamToSink(InputStream inputStream, BufferedSink bufferedSink) throws IOException {
        byte[] bArr = new byte[10240];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, 10240);
            if (read > 0) {
                bufferedSink.write(bArr, 0, read);
                j += (long) read;
                emitUploadProgress(j);
            } else {
                inputStream.close();
                return;
            }
        }
    }

    private void pipeStreamToFileStream(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[10240];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x010a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.ArrayList<com.RNFetchBlob.RNFetchBlobBody.FormField> countFormDataLength() throws java.io.IOException {
        /*
            r12 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.facebook.react.bridge.ReactApplicationContext r1 = com.RNFetchBlob.C0623RNFetchBlob.RCTContext
            r2 = 0
            r3 = 0
            r4 = r3
            r3 = 0
        L_0x000c:
            com.facebook.react.bridge.ReadableArray r6 = r12.form
            int r6 = r6.size()
            if (r3 >= r6) goto L_0x010e
            com.RNFetchBlob.RNFetchBlobBody$FormField r6 = new com.RNFetchBlob.RNFetchBlobBody$FormField
            com.facebook.react.bridge.ReadableArray r7 = r12.form
            com.facebook.react.bridge.ReadableMap r7 = r7.getMap(r3)
            r6.<init>(r7)
            r0.add(r6)
            java.lang.String r7 = r6.data
            if (r7 != 0) goto L_0x0043
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "RNFetchBlob multipart request builder has found a field without `data` property, the field `"
            r7.append(r8)
            java.lang.String r6 = r6.name
            r7.append(r6)
            java.lang.String r6 = "` will be removed implicitly."
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.RNFetchBlob.RNFetchBlobUtils.emitWarningEvent(r6)
            goto L_0x010a
        L_0x0043:
            java.lang.String r7 = r6.filename
            if (r7 == 0) goto L_0x0101
            java.lang.String r6 = r6.data
            java.lang.String r7 = "RNFetchBlob-file://"
            boolean r7 = r6.startsWith(r7)
            if (r7 == 0) goto L_0x0097
            java.lang.String r7 = "RNFetchBlob-file://"
            int r7 = r7.length()
            java.lang.String r6 = r6.substring(r7)
            java.lang.String r6 = com.RNFetchBlob.RNFetchBlobFS.normalizePath(r6)
            boolean r7 = com.RNFetchBlob.RNFetchBlobFS.isAsset(r6)
            if (r7 == 0) goto L_0x0087
            java.lang.String r7 = "bundle-assets://"
            java.lang.String r8 = ""
            java.lang.String r6 = r6.replace(r7, r8)     // Catch:{ IOException -> 0x007d }
            android.content.res.AssetManager r7 = r1.getAssets()     // Catch:{ IOException -> 0x007d }
            java.io.InputStream r6 = r7.open(r6)     // Catch:{ IOException -> 0x007d }
            int r6 = r6.available()     // Catch:{ IOException -> 0x007d }
            long r6 = (long) r6
            long r4 = r4 + r6
            goto L_0x010a
        L_0x007d:
            r6 = move-exception
            java.lang.String r6 = r6.getLocalizedMessage()
            com.RNFetchBlob.RNFetchBlobUtils.emitWarningEvent(r6)
            goto L_0x010a
        L_0x0087:
            java.io.File r7 = new java.io.File
            java.lang.String r6 = com.RNFetchBlob.RNFetchBlobFS.normalizePath(r6)
            r7.<init>(r6)
            long r6 = r7.length()
            long r4 = r4 + r6
            goto L_0x010a
        L_0x0097:
            java.lang.String r7 = "RNFetchBlob-content://"
            boolean r7 = r6.startsWith(r7)
            if (r7 == 0) goto L_0x00f9
            java.lang.String r7 = "RNFetchBlob-content://"
            int r7 = r7.length()
            java.lang.String r6 = r6.substring(r7)
            r7 = 0
            android.content.ContentResolver r8 = r1.getContentResolver()     // Catch:{ Exception -> 0x00cc }
            android.net.Uri r9 = android.net.Uri.parse(r6)     // Catch:{ Exception -> 0x00cc }
            java.io.InputStream r8 = r8.openInputStream(r9)     // Catch:{ Exception -> 0x00cc }
            int r7 = r8.available()     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
            long r6 = (long) r7
            long r4 = r4 + r6
            if (r8 == 0) goto L_0x010a
            r8.close()
            goto L_0x010a
        L_0x00c2:
            r0 = move-exception
            r7 = r8
            goto L_0x00f3
        L_0x00c5:
            r7 = move-exception
            r11 = r8
            r8 = r7
            r7 = r11
            goto L_0x00cd
        L_0x00ca:
            r0 = move-exception
            goto L_0x00f3
        L_0x00cc:
            r8 = move-exception
        L_0x00cd:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ca }
            r9.<init>()     // Catch:{ all -> 0x00ca }
            java.lang.String r10 = "Failed to estimate form data length from content URI:"
            r9.append(r10)     // Catch:{ all -> 0x00ca }
            r9.append(r6)     // Catch:{ all -> 0x00ca }
            java.lang.String r6 = ", "
            r9.append(r6)     // Catch:{ all -> 0x00ca }
            java.lang.String r6 = r8.getLocalizedMessage()     // Catch:{ all -> 0x00ca }
            r9.append(r6)     // Catch:{ all -> 0x00ca }
            java.lang.String r6 = r9.toString()     // Catch:{ all -> 0x00ca }
            com.RNFetchBlob.RNFetchBlobUtils.emitWarningEvent(r6)     // Catch:{ all -> 0x00ca }
            if (r7 == 0) goto L_0x010a
            r7.close()
            goto L_0x010a
        L_0x00f3:
            if (r7 == 0) goto L_0x00f8
            r7.close()
        L_0x00f8:
            throw r0
        L_0x00f9:
            byte[] r6 = android.util.Base64.decode(r6, r2)
            int r6 = r6.length
            long r6 = (long) r6
            long r4 = r4 + r6
            goto L_0x010a
        L_0x0101:
            java.lang.String r6 = r6.data
            byte[] r6 = r6.getBytes()
            int r6 = r6.length
            long r6 = (long) r6
            long r4 = r4 + r6
        L_0x010a:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x010e:
            r12.contentLength = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.RNFetchBlobBody.countFormDataLength():java.util.ArrayList");
    }

    private class FormField {
        public String data;
        String filename;
        String mime;
        public String name;

        FormField(ReadableMap readableMap) {
            if (readableMap.hasKey("name")) {
                this.name = readableMap.getString("name");
            }
            if (readableMap.hasKey("filename")) {
                this.filename = readableMap.getString("filename");
            }
            if (readableMap.hasKey("type")) {
                this.mime = readableMap.getString("type");
            } else {
                this.mime = this.filename == null ? NanoHTTPD.MIME_PLAINTEXT : "application/octet-stream";
            }
            if (readableMap.hasKey("data")) {
                this.data = readableMap.getString("data");
            }
        }
    }

    private void emitUploadProgress(long j) {
        RNFetchBlobProgressConfig reportUploadProgress = RNFetchBlobReq.getReportUploadProgress(this.mTaskId);
        if (reportUploadProgress != null && this.contentLength != 0 && reportUploadProgress.shouldReport(((float) j) / ((float) this.contentLength))) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("taskId", this.mTaskId);
            createMap.putString("written", String.valueOf(j));
            createMap.putString("total", String.valueOf(this.contentLength));
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) C0623RNFetchBlob.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(RNFetchBlobConst.EVENT_UPLOAD_PROGRESS, createMap);
        }
    }
}
