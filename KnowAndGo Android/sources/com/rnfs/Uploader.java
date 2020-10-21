package com.rnfs;

import android.os.AsyncTask;
import android.webkit.MimeTypeMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class Uploader extends AsyncTask<UploadParams, int[], UploadResult> {
    private AtomicBoolean mAbort = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public UploadParams mParams;
    /* access modifiers changed from: private */
    public UploadResult res;

    /* access modifiers changed from: protected */
    public UploadResult doInBackground(UploadParams... uploadParamsArr) {
        this.mParams = uploadParamsArr[0];
        this.res = new UploadResult();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Uploader.this.upload(Uploader.this.mParams, Uploader.this.res);
                    Uploader.this.mParams.onUploadComplete.onUploadComplete(Uploader.this.res);
                } catch (Exception e) {
                    Uploader.this.res.exception = e;
                    Uploader.this.mParams.onUploadComplete.onUploadComplete(Uploader.this.res);
                }
            }
        }).start();
        return this.res;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0381  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0386  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x038b  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0390  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void upload(com.rnfs.UploadParams r34, com.rnfs.UploadResult r35) throws java.lang.Exception {
        /*
            r33 = this;
            r1 = r33
            r0 = r34
            java.lang.String r2 = "\r\n"
            java.lang.String r3 = "--"
            java.lang.String r4 = "*****"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r2)
            r5.append(r3)
            r5.append(r4)
            r5.append(r3)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = ""
            java.lang.String r7 = ""
            java.util.ArrayList<com.facebook.react.bridge.ReadableMap> r9 = r0.files     // Catch:{ all -> 0x0379 }
            java.lang.Object[] r9 = r9.toArray()     // Catch:{ all -> 0x0379 }
            boolean r10 = r0.binaryStreamOnly     // Catch:{ all -> 0x0379 }
            java.net.URL r11 = r0.src     // Catch:{ all -> 0x0379 }
            java.net.URLConnection r11 = r11.openConnection()     // Catch:{ all -> 0x0379 }
            java.net.HttpURLConnection r11 = (java.net.HttpURLConnection) r11     // Catch:{ all -> 0x0379 }
            r12 = 1
            r11.setDoOutput(r12)     // Catch:{ all -> 0x0375 }
            com.facebook.react.bridge.ReadableMap r13 = r0.headers     // Catch:{ all -> 0x0375 }
            com.facebook.react.bridge.ReadableMapKeySetIterator r13 = r13.keySetIterator()     // Catch:{ all -> 0x0375 }
            java.lang.String r14 = r0.method     // Catch:{ all -> 0x0375 }
            r11.setRequestMethod(r14)     // Catch:{ all -> 0x0375 }
            if (r10 != 0) goto L_0x005d
            java.lang.String r14 = "Content-Type"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0375 }
            r15.<init>()     // Catch:{ all -> 0x0375 }
            java.lang.String r8 = "multipart/form-data;boundary="
            r15.append(r8)     // Catch:{ all -> 0x0375 }
            r15.append(r4)     // Catch:{ all -> 0x0375 }
            java.lang.String r8 = r15.toString()     // Catch:{ all -> 0x0375 }
            r11.setRequestProperty(r14, r8)     // Catch:{ all -> 0x0375 }
        L_0x005d:
            boolean r8 = r13.hasNextKey()     // Catch:{ all -> 0x0375 }
            if (r8 == 0) goto L_0x0071
            java.lang.String r8 = r13.nextKey()     // Catch:{ all -> 0x0375 }
            com.facebook.react.bridge.ReadableMap r14 = r0.headers     // Catch:{ all -> 0x0375 }
            java.lang.String r14 = r14.getString(r8)     // Catch:{ all -> 0x0375 }
            r11.setRequestProperty(r8, r14)     // Catch:{ all -> 0x0375 }
            goto L_0x005d
        L_0x0071:
            com.facebook.react.bridge.ReadableMap r8 = r0.fields     // Catch:{ all -> 0x0375 }
            com.facebook.react.bridge.ReadableMapKeySetIterator r8 = r8.keySetIterator()     // Catch:{ all -> 0x0375 }
        L_0x0077:
            boolean r13 = r8.hasNextKey()     // Catch:{ all -> 0x0375 }
            if (r13 == 0) goto L_0x00b6
            java.lang.String r13 = r8.nextKey()     // Catch:{ all -> 0x0375 }
            com.facebook.react.bridge.ReadableMap r14 = r0.fields     // Catch:{ all -> 0x0375 }
            java.lang.String r14 = r14.getString(r13)     // Catch:{ all -> 0x0375 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0375 }
            r15.<init>()     // Catch:{ all -> 0x0375 }
            r15.append(r6)     // Catch:{ all -> 0x0375 }
            r15.append(r3)     // Catch:{ all -> 0x0375 }
            r15.append(r4)     // Catch:{ all -> 0x0375 }
            r15.append(r2)     // Catch:{ all -> 0x0375 }
            java.lang.String r6 = "Content-Disposition: form-data; name=\""
            r15.append(r6)     // Catch:{ all -> 0x0375 }
            r15.append(r13)     // Catch:{ all -> 0x0375 }
            java.lang.String r6 = "\""
            r15.append(r6)     // Catch:{ all -> 0x0375 }
            r15.append(r2)     // Catch:{ all -> 0x0375 }
            r15.append(r2)     // Catch:{ all -> 0x0375 }
            r15.append(r14)     // Catch:{ all -> 0x0375 }
            r15.append(r2)     // Catch:{ all -> 0x0375 }
            java.lang.String r6 = r15.toString()     // Catch:{ all -> 0x0375 }
            goto L_0x0077
        L_0x00b6:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0375 }
            r8.<init>()     // Catch:{ all -> 0x0375 }
            r8.append(r7)     // Catch:{ all -> 0x0375 }
            r8.append(r6)     // Catch:{ all -> 0x0375 }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x0375 }
            int r8 = r9.length     // Catch:{ all -> 0x0375 }
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ all -> 0x0375 }
            java.util.ArrayList<com.facebook.react.bridge.ReadableMap> r13 = r0.files     // Catch:{ all -> 0x0375 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ all -> 0x0375 }
            r17 = 0
            r14 = r17
            r19 = 0
        L_0x00d4:
            boolean r17 = r13.hasNext()     // Catch:{ all -> 0x0375 }
            if (r17 == 0) goto L_0x01e6
            java.lang.Object r17 = r13.next()     // Catch:{ all -> 0x01df }
            r12 = r17
            com.facebook.react.bridge.ReadableMap r12 = (com.facebook.react.bridge.ReadableMap) r12     // Catch:{ all -> 0x01df }
            r20 = r13
            java.lang.String r13 = "name"
            java.lang.String r13 = r12.getString(r13)     // Catch:{ NoSuchKeyException -> 0x0104 }
            r21 = r13
            java.lang.String r13 = "filename"
            java.lang.String r13 = r12.getString(r13)     // Catch:{ NoSuchKeyException -> 0x0104 }
            r22 = r13
            java.lang.String r13 = "filetype"
            java.lang.String r13 = r12.getString(r13)     // Catch:{ NoSuchKeyException -> 0x0104 }
            r25 = r6
            r26 = r11
            r6 = r13
            r13 = r21
            r0 = r22
            goto L_0x0127
        L_0x0104:
            java.lang.String r13 = "name"
            java.lang.String r13 = r12.getString(r13)     // Catch:{ all -> 0x01df }
            r23 = r13
            java.lang.String r13 = "filename"
            java.lang.String r13 = r12.getString(r13)     // Catch:{ all -> 0x01df }
            r24 = r13
            java.lang.String r13 = "filepath"
            java.lang.String r13 = r12.getString(r13)     // Catch:{ all -> 0x01df }
            java.lang.String r13 = r1.getMimeType(r13)     // Catch:{ all -> 0x01df }
            r25 = r6
            r26 = r11
            r6 = r13
            r13 = r23
            r0 = r24
        L_0x0127:
            java.io.File r11 = new java.io.File     // Catch:{ all -> 0x01db }
            java.lang.String r1 = "filepath"
            java.lang.String r1 = r12.getString(r1)     // Catch:{ all -> 0x01db }
            r11.<init>(r1)     // Catch:{ all -> 0x01db }
            long r11 = r11.length()     // Catch:{ all -> 0x01db }
            r1 = 0
            long r14 = r14 + r11
            if (r10 != 0) goto L_0x01c2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r1.<init>()     // Catch:{ all -> 0x01db }
            r1.append(r3)     // Catch:{ all -> 0x01db }
            r1.append(r4)     // Catch:{ all -> 0x01db }
            r1.append(r2)     // Catch:{ all -> 0x01db }
            r27 = r3
            java.lang.String r3 = "Content-Disposition: form-data; name=\""
            r1.append(r3)     // Catch:{ all -> 0x01db }
            r1.append(r13)     // Catch:{ all -> 0x01db }
            java.lang.String r3 = "\"; filename=\""
            r1.append(r3)     // Catch:{ all -> 0x01db }
            r1.append(r0)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = "\""
            r1.append(r0)     // Catch:{ all -> 0x01db }
            r1.append(r2)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = "Content-Type: "
            r1.append(r0)     // Catch:{ all -> 0x01db }
            r1.append(r6)     // Catch:{ all -> 0x01db }
            r1.append(r2)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x01db }
            int r1 = r9.length     // Catch:{ all -> 0x01db }
            r3 = 1
            int r1 = r1 - r3
            r6 = r19
            if (r1 != r6) goto L_0x0181
            int r1 = r5.length()     // Catch:{ all -> 0x01db }
            r28 = r4
            long r3 = (long) r1     // Catch:{ all -> 0x01db }
            long r14 = r14 + r3
            goto L_0x0183
        L_0x0181:
            r28 = r4
        L_0x0183:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r1.<init>()     // Catch:{ all -> 0x01db }
            java.lang.String r3 = "Content-length: "
            r1.append(r3)     // Catch:{ all -> 0x01db }
            r1.append(r11)     // Catch:{ all -> 0x01db }
            r1.append(r2)     // Catch:{ all -> 0x01db }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01db }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r3.<init>()     // Catch:{ all -> 0x01db }
            r3.append(r0)     // Catch:{ all -> 0x01db }
            r3.append(r1)     // Catch:{ all -> 0x01db }
            r3.append(r2)     // Catch:{ all -> 0x01db }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01db }
            r8[r6] = r3     // Catch:{ all -> 0x01db }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01db }
            r3.<init>()     // Catch:{ all -> 0x01db }
            r3.append(r7)     // Catch:{ all -> 0x01db }
            r3.append(r0)     // Catch:{ all -> 0x01db }
            r3.append(r1)     // Catch:{ all -> 0x01db }
            r3.append(r2)     // Catch:{ all -> 0x01db }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x01db }
            r7 = r0
            goto L_0x01c8
        L_0x01c2:
            r27 = r3
            r28 = r4
            r6 = r19
        L_0x01c8:
            int r19 = r6 + 1
            r13 = r20
            r6 = r25
            r11 = r26
            r3 = r27
            r4 = r28
            r0 = r34
            r1 = r33
            r12 = 1
            goto L_0x00d4
        L_0x01db:
            r0 = move-exception
            r11 = r26
            goto L_0x01e2
        L_0x01df:
            r0 = move-exception
            r26 = r11
        L_0x01e2:
            r1 = r33
            goto L_0x0376
        L_0x01e6:
            r25 = r6
            r26 = r11
            com.rnfs.UploadParams r0 = r1.mParams     // Catch:{ all -> 0x0371 }
            com.rnfs.UploadParams$onUploadBegin r0 = r0.onUploadBegin     // Catch:{ all -> 0x0371 }
            if (r0 == 0) goto L_0x01f7
            com.rnfs.UploadParams r0 = r1.mParams     // Catch:{ all -> 0x0371 }
            com.rnfs.UploadParams$onUploadBegin r0 = r0.onUploadBegin     // Catch:{ all -> 0x0371 }
            r0.onUploadBegin()     // Catch:{ all -> 0x0371 }
        L_0x01f7:
            if (r10 != 0) goto L_0x0224
            int r0 = r7.length()     // Catch:{ all -> 0x0371 }
            int r3 = r9.length     // Catch:{ all -> 0x0371 }
            int r4 = r2.length()     // Catch:{ all -> 0x0371 }
            int r3 = r3 * r4
            int r0 = r0 + r3
            long r3 = (long) r0     // Catch:{ all -> 0x0371 }
            long r3 = r3 + r14
            java.lang.String r0 = "Content-length"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0371 }
            r6.<init>()     // Catch:{ all -> 0x0371 }
            java.lang.String r7 = ""
            r6.append(r7)     // Catch:{ all -> 0x0371 }
            int r3 = (int) r3     // Catch:{ all -> 0x0371 }
            r6.append(r3)     // Catch:{ all -> 0x0371 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x0371 }
            r11 = r26
            r11.setRequestProperty(r0, r4)     // Catch:{ all -> 0x0375 }
            r11.setFixedLengthStreamingMode(r3)     // Catch:{ all -> 0x0375 }
            goto L_0x0226
        L_0x0224:
            r11 = r26
        L_0x0226:
            r11.connect()     // Catch:{ all -> 0x0375 }
            java.io.DataOutputStream r3 = new java.io.DataOutputStream     // Catch:{ all -> 0x0375 }
            java.io.OutputStream r0 = r11.getOutputStream()     // Catch:{ all -> 0x0375 }
            r3.<init>(r0)     // Catch:{ all -> 0x0375 }
            if (r10 != 0) goto L_0x0241
            r6 = r25
            r3.writeBytes(r6)     // Catch:{ all -> 0x023a }
            goto L_0x0241
        L_0x023a:
            r0 = move-exception
            r16 = r3
            r2 = 0
            r8 = 0
            goto L_0x037f
        L_0x0241:
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x023a }
            r4 = r34
            java.util.ArrayList<com.facebook.react.bridge.ReadableMap> r4 = r4.files     // Catch:{ all -> 0x023a }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x023a }
            r6 = 0
            r7 = 0
        L_0x024f:
            boolean r9 = r4.hasNext()     // Catch:{ all -> 0x023a }
            if (r9 == 0) goto L_0x02e0
            java.lang.Object r9 = r4.next()     // Catch:{ all -> 0x023a }
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9     // Catch:{ all -> 0x023a }
            if (r10 != 0) goto L_0x0262
            r12 = r8[r6]     // Catch:{ all -> 0x023a }
            r3.writeBytes(r12)     // Catch:{ all -> 0x023a }
        L_0x0262:
            java.io.File r12 = new java.io.File     // Catch:{ all -> 0x023a }
            java.lang.String r13 = "filepath"
            java.lang.String r9 = r9.getString(r13)     // Catch:{ all -> 0x023a }
            r12.<init>(r9)     // Catch:{ all -> 0x023a }
            r30 = r7
            r29 = r8
            long r7 = r12.length()     // Catch:{ all -> 0x023a }
            int r7 = (int) r7     // Catch:{ all -> 0x023a }
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ all -> 0x023a }
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ all -> 0x023a }
            r9.<init>(r12)     // Catch:{ all -> 0x023a }
            r8.<init>(r9)     // Catch:{ all -> 0x023a }
            float r7 = (float) r7     // Catch:{ all -> 0x023a }
            r9 = 1120403456(0x42c80000, float:100.0)
            float r7 = r7 / r9
            double r12 = (double) r7     // Catch:{ all -> 0x023a }
            double r12 = java.lang.Math.ceil(r12)     // Catch:{ all -> 0x023a }
            int r7 = (int) r12     // Catch:{ all -> 0x023a }
            float r9 = (float) r7     // Catch:{ all -> 0x023a }
            long r12 = r0.freeMemory()     // Catch:{ all -> 0x023a }
            float r12 = (float) r12     // Catch:{ all -> 0x023a }
            r13 = 1092616192(0x41200000, float:10.0)
            float r12 = r12 / r13
            int r9 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r9 <= 0) goto L_0x02a8
            r31 = r14
            long r13 = r0.freeMemory()     // Catch:{ all -> 0x023a }
            float r7 = (float) r13     // Catch:{ all -> 0x023a }
            r9 = 1092616192(0x41200000, float:10.0)
            float r7 = r7 / r9
            double r12 = (double) r7     // Catch:{ all -> 0x023a }
            double r12 = java.lang.Math.ceil(r12)     // Catch:{ all -> 0x023a }
            int r7 = (int) r12     // Catch:{ all -> 0x023a }
            goto L_0x02aa
        L_0x02a8:
            r31 = r14
        L_0x02aa:
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x023a }
        L_0x02ac:
            int r9 = r8.read(r7)     // Catch:{ all -> 0x023a }
            r12 = -1
            if (r9 == r12) goto L_0x02ce
            r12 = 0
            r3.write(r7, r12, r9)     // Catch:{ all -> 0x023a }
            com.rnfs.UploadParams r12 = r1.mParams     // Catch:{ all -> 0x023a }
            com.rnfs.UploadParams$onUploadProgress r12 = r12.onUploadProgress     // Catch:{ all -> 0x023a }
            if (r12 == 0) goto L_0x02ac
            int r9 = r30 + r9
            com.rnfs.UploadParams r12 = r1.mParams     // Catch:{ all -> 0x023a }
            com.rnfs.UploadParams$onUploadProgress r12 = r12.onUploadProgress     // Catch:{ all -> 0x023a }
            r14 = r31
            int r13 = (int) r14     // Catch:{ all -> 0x023a }
            r12.onUploadProgress(r13, r9)     // Catch:{ all -> 0x023a }
            r30 = r9
            r31 = r14
            goto L_0x02ac
        L_0x02ce:
            r14 = r31
            if (r10 != 0) goto L_0x02d5
            r3.writeBytes(r2)     // Catch:{ all -> 0x023a }
        L_0x02d5:
            int r6 = r6 + 1
            r8.close()     // Catch:{ all -> 0x023a }
            r8 = r29
            r7 = r30
            goto L_0x024f
        L_0x02e0:
            if (r10 != 0) goto L_0x02e5
            r3.writeBytes(r5)     // Catch:{ all -> 0x023a }
        L_0x02e5:
            r3.flush()     // Catch:{ all -> 0x023a }
            r3.close()     // Catch:{ all -> 0x023a }
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ all -> 0x023a }
            java.io.InputStream r0 = r11.getInputStream()     // Catch:{ all -> 0x023a }
            r8.<init>(r0)     // Catch:{ all -> 0x023a }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x036c }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ all -> 0x036c }
            r0.<init>(r8)     // Catch:{ all -> 0x036c }
            r2.<init>(r0)     // Catch:{ all -> 0x036c }
            com.facebook.react.bridge.WritableMap r0 = com.facebook.react.bridge.Arguments.createMap()     // Catch:{ all -> 0x0368 }
            java.util.Map r4 = r11.getHeaderFields()     // Catch:{ all -> 0x0368 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ all -> 0x0368 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0368 }
        L_0x030e:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0368 }
            if (r5 == 0) goto L_0x0331
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0368 }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x0368 }
            java.lang.Object r6 = r5.getKey()     // Catch:{ all -> 0x0368 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0368 }
            java.lang.Object r5 = r5.getValue()     // Catch:{ all -> 0x0368 }
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x0368 }
            r7 = 0
            java.lang.Object r5 = r5.get(r7)     // Catch:{ all -> 0x0368 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0368 }
            r0.putString(r6, r5)     // Catch:{ all -> 0x0368 }
            goto L_0x030e
        L_0x0331:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0368 }
            r4.<init>()     // Catch:{ all -> 0x0368 }
        L_0x0336:
            java.lang.String r5 = r2.readLine()     // Catch:{ all -> 0x0368 }
            if (r5 == 0) goto L_0x0345
            r4.append(r5)     // Catch:{ all -> 0x0368 }
            java.lang.String r5 = "\n"
            r4.append(r5)     // Catch:{ all -> 0x0368 }
            goto L_0x0336
        L_0x0345:
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0368 }
            int r5 = r11.getResponseCode()     // Catch:{ all -> 0x0368 }
            com.rnfs.UploadResult r6 = r1.res     // Catch:{ all -> 0x0368 }
            r6.headers = r0     // Catch:{ all -> 0x0368 }
            com.rnfs.UploadResult r0 = r1.res     // Catch:{ all -> 0x0368 }
            r0.body = r4     // Catch:{ all -> 0x0368 }
            com.rnfs.UploadResult r0 = r1.res     // Catch:{ all -> 0x0368 }
            r0.statusCode = r5     // Catch:{ all -> 0x0368 }
            if (r11 == 0) goto L_0x035e
            r11.disconnect()
        L_0x035e:
            r3.close()
            r8.close()
            r2.close()
            return
        L_0x0368:
            r0 = move-exception
            r16 = r3
            goto L_0x037f
        L_0x036c:
            r0 = move-exception
            r16 = r3
            r2 = 0
            goto L_0x037f
        L_0x0371:
            r0 = move-exception
            r11 = r26
            goto L_0x0376
        L_0x0375:
            r0 = move-exception
        L_0x0376:
            r2 = 0
            r8 = 0
            goto L_0x037d
        L_0x0379:
            r0 = move-exception
            r2 = 0
            r8 = 0
            r11 = 0
        L_0x037d:
            r16 = 0
        L_0x037f:
            if (r11 == 0) goto L_0x0384
            r11.disconnect()
        L_0x0384:
            if (r16 == 0) goto L_0x0389
            r16.close()
        L_0x0389:
            if (r8 == 0) goto L_0x038e
            r8.close()
        L_0x038e:
            if (r2 == 0) goto L_0x0393
            r2.close()
        L_0x0393:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnfs.Uploader.upload(com.rnfs.UploadParams, com.rnfs.UploadResult):void");
    }

    /* access modifiers changed from: protected */
    public String getMimeType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        String mimeTypeFromExtension = fileExtensionFromUrl != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase()) : null;
        return mimeTypeFromExtension == null ? "*/*" : mimeTypeFromExtension;
    }

    /* access modifiers changed from: protected */
    public void stop() {
        this.mAbort.set(true);
    }
}
