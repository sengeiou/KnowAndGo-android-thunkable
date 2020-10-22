package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzciu implements zzczc<zzciv, zzciw> {
    private final String zzdmi;
    private final zzasm zzfxl;
    private final String zzfxz;
    private final Context zzlj;

    public zzciu(Context context, String str, zzasm zzasm, String str2) {
        this.zzlj = context;
        this.zzfxz = str;
        this.zzfxl = zzasm;
        this.zzdmi = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r11 = new java.io.InputStreamReader(r2.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        com.google.android.gms.ads.internal.zzk.zzlg();
        r6 = com.google.android.gms.internal.ads.zzaxi.zza(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r11);
        r14.zzek(r6);
        r0.zzfya = r13;
        r0.zzdnh = r6;
        r0.zzab = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0179, code lost:
        if (android.text.TextUtils.isEmpty(r6) == false) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x018b, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzyt.zzpe().zzd(com.google.android.gms.internal.ads.zzacu.zzcvk)).booleanValue() == false) goto L_0x018e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0196, code lost:
        throw new com.google.android.gms.internal.ads.zzcif("No Fill", 3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0197, code lost:
        r0.zzfyb = com.google.android.gms.ads.internal.zzk.zzln().elapsedRealtime() - r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r2.disconnect();
        r1.zzfxl.zzub();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01ab, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01ac, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01ad, code lost:
        r18 = r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzciw zza(java.lang.String r20, com.google.android.gms.internal.ads.zzasd r21, org.json.JSONObject r22, java.lang.String r23) throws com.google.android.gms.internal.ads.zzcif {
        /*
            r19 = this;
            r1 = r19
            com.google.android.gms.internal.ads.zzciw r0 = new com.google.android.gms.internal.ads.zzciw     // Catch:{ IOException -> 0x023f }
            r0.<init>()     // Catch:{ IOException -> 0x023f }
            java.lang.String r2 = "SDK version: "
            java.lang.String r3 = r1.zzfxz     // Catch:{ IOException -> 0x023f }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x023f }
            int r4 = r3.length()     // Catch:{ IOException -> 0x023f }
            if (r4 == 0) goto L_0x001a
            java.lang.String r2 = r2.concat(r3)     // Catch:{ IOException -> 0x023f }
            goto L_0x0020
        L_0x001a:
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x023f }
            r3.<init>(r2)     // Catch:{ IOException -> 0x023f }
            r2 = r3
        L_0x0020:
            com.google.android.gms.internal.ads.zzawz.zzeo(r2)     // Catch:{ IOException -> 0x023f }
            java.lang.String r2 = "AdRequestServiceImpl: Sending request: "
            java.lang.String r3 = java.lang.String.valueOf(r20)     // Catch:{ IOException -> 0x023f }
            int r4 = r3.length()     // Catch:{ IOException -> 0x023f }
            if (r4 == 0) goto L_0x0034
            java.lang.String r2 = r2.concat(r3)     // Catch:{ IOException -> 0x023f }
            goto L_0x003a
        L_0x0034:
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x023f }
            r3.<init>(r2)     // Catch:{ IOException -> 0x023f }
            r2 = r3
        L_0x003a:
            com.google.android.gms.internal.ads.zzawz.zzdp(r2)     // Catch:{ IOException -> 0x023f }
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x023f }
            r3 = r20
            r2.<init>(r3)     // Catch:{ IOException -> 0x023f }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ IOException -> 0x023f }
            r3.<init>()     // Catch:{ IOException -> 0x023f }
            com.google.android.gms.common.util.Clock r4 = com.google.android.gms.ads.internal.zzk.zzln()     // Catch:{ IOException -> 0x023f }
            long r4 = r4.elapsedRealtime()     // Catch:{ IOException -> 0x023f }
            r6 = 0
            r7 = 0
        L_0x0053:
            com.google.android.gms.internal.ads.zzasm r8 = r1.zzfxl     // Catch:{ IOException -> 0x023f }
            r8.zzua()     // Catch:{ IOException -> 0x023f }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x023f }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x023f }
            com.google.android.gms.internal.ads.zzaxi r8 = com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x0235 }
            android.content.Context r9 = r1.zzlj     // Catch:{ all -> 0x0235 }
            java.lang.String r10 = r1.zzfxz     // Catch:{ all -> 0x0235 }
            r8.zza((android.content.Context) r9, (java.lang.String) r10, (boolean) r6, (java.net.HttpURLConnection) r2)     // Catch:{ all -> 0x0235 }
            boolean r8 = android.text.TextUtils.isEmpty(r23)     // Catch:{ all -> 0x0235 }
            if (r8 != 0) goto L_0x0077
            java.lang.String r8 = "Cookie"
            r9 = r23
            r2.addRequestProperty(r8, r9)     // Catch:{ all -> 0x0235 }
            goto L_0x0079
        L_0x0077:
            r9 = r23
        L_0x0079:
            boolean r8 = r21.zztw()     // Catch:{ all -> 0x0235 }
            if (r8 == 0) goto L_0x00c6
            java.lang.String r8 = "pii"
            r10 = r22
            org.json.JSONObject r8 = r10.optJSONObject(r8)     // Catch:{ all -> 0x0235 }
            if (r8 == 0) goto L_0x00c0
            java.lang.String r11 = "doritos"
            java.lang.String r12 = ""
            java.lang.String r11 = r8.optString(r11, r12)     // Catch:{ all -> 0x0235 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0235 }
            if (r11 != 0) goto L_0x00a4
            java.lang.String r11 = "x-afma-drt-cookie"
            java.lang.String r12 = "doritos"
            java.lang.String r13 = ""
            java.lang.String r12 = r8.optString(r12, r13)     // Catch:{ all -> 0x0235 }
            r2.addRequestProperty(r11, r12)     // Catch:{ all -> 0x0235 }
        L_0x00a4:
            java.lang.String r11 = "doritos_v2"
            java.lang.String r12 = ""
            java.lang.String r11 = r8.optString(r11, r12)     // Catch:{ all -> 0x0235 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0235 }
            if (r11 != 0) goto L_0x00c8
            java.lang.String r11 = "x-afma-drt-v2-cookie"
            java.lang.String r12 = "doritos_v2"
            java.lang.String r13 = ""
            java.lang.String r8 = r8.optString(r12, r13)     // Catch:{ all -> 0x0235 }
            r2.addRequestProperty(r11, r8)     // Catch:{ all -> 0x0235 }
            goto L_0x00c8
        L_0x00c0:
            java.lang.String r8 = "DSID signal does not exist."
            com.google.android.gms.internal.ads.zzawz.zzds(r8)     // Catch:{ all -> 0x0235 }
            goto L_0x00c8
        L_0x00c6:
            r10 = r22
        L_0x00c8:
            r8 = 1
            if (r21 == 0) goto L_0x00fd
            java.lang.String r13 = r21.zztv()     // Catch:{ all -> 0x0235 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0235 }
            if (r13 != 0) goto L_0x00fd
            r2.setDoOutput(r8)     // Catch:{ all -> 0x0235 }
            java.lang.String r13 = r21.zztv()     // Catch:{ all -> 0x0235 }
            byte[] r13 = r13.getBytes()     // Catch:{ all -> 0x0235 }
            int r14 = r13.length     // Catch:{ all -> 0x0235 }
            r2.setFixedLengthStreamingMode(r14)     // Catch:{ all -> 0x0235 }
            java.io.BufferedOutputStream r14 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00f7 }
            java.io.OutputStream r15 = r2.getOutputStream()     // Catch:{ all -> 0x00f7 }
            r14.<init>(r15)     // Catch:{ all -> 0x00f7 }
            r14.write(r13)     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r14)     // Catch:{ all -> 0x0235 }
            goto L_0x00fe
        L_0x00f4:
            r0 = move-exception
            r11 = r14
            goto L_0x00f9
        L_0x00f7:
            r0 = move-exception
            r11 = 0
        L_0x00f9:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r11)     // Catch:{ all -> 0x0235 }
            throw r0     // Catch:{ all -> 0x0235 }
        L_0x00fd:
            r13 = 0
        L_0x00fe:
            com.google.android.gms.internal.ads.zzazx r14 = new com.google.android.gms.internal.ads.zzazx     // Catch:{ all -> 0x0235 }
            r14.<init>()     // Catch:{ all -> 0x0235 }
            r14.zza((java.net.HttpURLConnection) r2, (byte[]) r13)     // Catch:{ all -> 0x0235 }
            int r13 = r2.getResponseCode()     // Catch:{ all -> 0x0235 }
            java.util.Map r15 = r2.getHeaderFields()     // Catch:{ all -> 0x0235 }
            java.util.Set r15 = r15.entrySet()     // Catch:{ all -> 0x0235 }
            java.util.Iterator r15 = r15.iterator()     // Catch:{ all -> 0x0235 }
        L_0x0116:
            boolean r16 = r15.hasNext()     // Catch:{ all -> 0x0235 }
            if (r16 == 0) goto L_0x014e
            java.lang.Object r16 = r15.next()     // Catch:{ all -> 0x0235 }
            java.util.Map$Entry r16 = (java.util.Map.Entry) r16     // Catch:{ all -> 0x0235 }
            java.lang.Object r17 = r16.getKey()     // Catch:{ all -> 0x0235 }
            r6 = r17
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0235 }
            java.lang.Object r16 = r16.getValue()     // Catch:{ all -> 0x0235 }
            r11 = r16
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x0235 }
            boolean r16 = r3.containsKey(r6)     // Catch:{ all -> 0x0235 }
            if (r16 == 0) goto L_0x0143
            java.lang.Object r6 = r3.get(r6)     // Catch:{ all -> 0x0235 }
            java.util.List r6 = (java.util.List) r6     // Catch:{ all -> 0x0235 }
            r6.addAll(r11)     // Catch:{ all -> 0x0235 }
            r6 = 0
            goto L_0x0116
        L_0x0143:
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x0235 }
            r8.<init>(r11)     // Catch:{ all -> 0x0235 }
            r3.put(r6, r8)     // Catch:{ all -> 0x0235 }
            r6 = 0
            r8 = 1
            goto L_0x0116
        L_0x014e:
            r14.zza((java.net.HttpURLConnection) r2, (int) r13)     // Catch:{ all -> 0x0235 }
            r6 = 200(0xc8, float:2.8E-43)
            r8 = 300(0x12c, float:4.2E-43)
            if (r13 < r6) goto L_0x01b7
            if (r13 >= r8) goto L_0x01b7
            java.io.InputStreamReader r11 = new java.io.InputStreamReader     // Catch:{ all -> 0x01b0 }
            java.io.InputStream r6 = r2.getInputStream()     // Catch:{ all -> 0x01b0 }
            r11.<init>(r6)     // Catch:{ all -> 0x01b0 }
            com.google.android.gms.ads.internal.zzk.zzlg()     // Catch:{ all -> 0x01ac }
            java.lang.String r6 = com.google.android.gms.internal.ads.zzaxi.zza((java.io.InputStreamReader) r11)     // Catch:{ all -> 0x01ac }
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r11)     // Catch:{ all -> 0x0235 }
            r14.zzek(r6)     // Catch:{ all -> 0x0235 }
            r0.zzfya = r13     // Catch:{ all -> 0x0235 }
            r0.zzdnh = r6     // Catch:{ all -> 0x0235 }
            r0.zzab = r3     // Catch:{ all -> 0x0235 }
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0235 }
            if (r3 == 0) goto L_0x0197
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzacu.zzcvk     // Catch:{ all -> 0x0235 }
            com.google.android.gms.internal.ads.zzacr r6 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ all -> 0x0235 }
            java.lang.Object r3 = r6.zzd(r3)     // Catch:{ all -> 0x0235 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0235 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0235 }
            if (r3 == 0) goto L_0x018e
            goto L_0x0197
        L_0x018e:
            com.google.android.gms.internal.ads.zzcif r0 = new com.google.android.gms.internal.ads.zzcif     // Catch:{ all -> 0x0235 }
            java.lang.String r3 = "No Fill"
            r4 = 3
            r0.<init>(r3, r4)     // Catch:{ all -> 0x0235 }
            throw r0     // Catch:{ all -> 0x0235 }
        L_0x0197:
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzk.zzln()     // Catch:{ all -> 0x0235 }
            long r6 = r3.elapsedRealtime()     // Catch:{ all -> 0x0235 }
            r3 = 0
            long r6 = r6 - r4
            r0.zzfyb = r6     // Catch:{ all -> 0x0235 }
            r2.disconnect()     // Catch:{ IOException -> 0x023f }
            com.google.android.gms.internal.ads.zzasm r2 = r1.zzfxl     // Catch:{ IOException -> 0x023f }
            r2.zzub()     // Catch:{ IOException -> 0x023f }
            return r0
        L_0x01ac:
            r0 = move-exception
            r18 = r11
            goto L_0x01b3
        L_0x01b0:
            r0 = move-exception
            r18 = 0
        L_0x01b3:
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r18)     // Catch:{ all -> 0x0235 }
            throw r0     // Catch:{ all -> 0x0235 }
        L_0x01b7:
            if (r13 < r8) goto L_0x0208
            r6 = 400(0x190, float:5.6E-43)
            if (r13 >= r6) goto L_0x0208
            java.lang.String r6 = "Location"
            java.lang.String r6 = r2.getHeaderField(r6)     // Catch:{ all -> 0x0235 }
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0235 }
            if (r8 != 0) goto L_0x01fb
            java.net.URL r8 = new java.net.URL     // Catch:{ all -> 0x0235 }
            r8.<init>(r6)     // Catch:{ all -> 0x0235 }
            r6 = 1
            int r7 = r7 + r6
            com.google.android.gms.internal.ads.zzacj<java.lang.Integer> r6 = com.google.android.gms.internal.ads.zzacu.zzcut     // Catch:{ all -> 0x0235 }
            com.google.android.gms.internal.ads.zzacr r11 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ all -> 0x0235 }
            java.lang.Object r6 = r11.zzd(r6)     // Catch:{ all -> 0x0235 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x0235 }
            int r6 = r6.intValue()     // Catch:{ all -> 0x0235 }
            if (r7 > r6) goto L_0x01ee
            r2.disconnect()     // Catch:{ IOException -> 0x023f }
            com.google.android.gms.internal.ads.zzasm r2 = r1.zzfxl     // Catch:{ IOException -> 0x023f }
            r2.zzub()     // Catch:{ IOException -> 0x023f }
            r2 = r8
            r6 = 0
            goto L_0x0053
        L_0x01ee:
            java.lang.String r0 = "Too many redirects."
            com.google.android.gms.internal.ads.zzawz.zzep(r0)     // Catch:{ all -> 0x0235 }
            com.google.android.gms.internal.ads.zzcif r0 = new com.google.android.gms.internal.ads.zzcif     // Catch:{ all -> 0x0235 }
            java.lang.String r3 = "Too many redirects"
            r0.<init>(r3)     // Catch:{ all -> 0x0235 }
            throw r0     // Catch:{ all -> 0x0235 }
        L_0x01fb:
            java.lang.String r0 = "No location header to follow redirect."
            com.google.android.gms.internal.ads.zzawz.zzep(r0)     // Catch:{ all -> 0x0235 }
            com.google.android.gms.internal.ads.zzcif r0 = new com.google.android.gms.internal.ads.zzcif     // Catch:{ all -> 0x0235 }
            java.lang.String r3 = "No location header to follow redirect"
            r0.<init>(r3)     // Catch:{ all -> 0x0235 }
            throw r0     // Catch:{ all -> 0x0235 }
        L_0x0208:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0235 }
            r3 = 46
            r0.<init>(r3)     // Catch:{ all -> 0x0235 }
            java.lang.String r4 = "Received error HTTP response code: "
            r0.append(r4)     // Catch:{ all -> 0x0235 }
            r0.append(r13)     // Catch:{ all -> 0x0235 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0235 }
            com.google.android.gms.internal.ads.zzawz.zzep(r0)     // Catch:{ all -> 0x0235 }
            com.google.android.gms.internal.ads.zzcif r0 = new com.google.android.gms.internal.ads.zzcif     // Catch:{ all -> 0x0235 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0235 }
            r4.<init>(r3)     // Catch:{ all -> 0x0235 }
            java.lang.String r3 = "Received error HTTP response code: "
            r4.append(r3)     // Catch:{ all -> 0x0235 }
            r4.append(r13)     // Catch:{ all -> 0x0235 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0235 }
            r0.<init>(r3)     // Catch:{ all -> 0x0235 }
            throw r0     // Catch:{ all -> 0x0235 }
        L_0x0235:
            r0 = move-exception
            r2.disconnect()     // Catch:{ IOException -> 0x023f }
            com.google.android.gms.internal.ads.zzasm r2 = r1.zzfxl     // Catch:{ IOException -> 0x023f }
            r2.zzub()     // Catch:{ IOException -> 0x023f }
            throw r0     // Catch:{ IOException -> 0x023f }
        L_0x023f:
            r0 = move-exception
            java.lang.String r2 = "Error while connecting to ad server: "
            java.lang.String r3 = r0.getMessage()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x0255
            java.lang.String r2 = r2.concat(r3)
            goto L_0x025b
        L_0x0255:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r2)
            r2 = r3
        L_0x025b:
            com.google.android.gms.internal.ads.zzawz.zzep(r2)
            com.google.android.gms.internal.ads.zzcif r2 = new com.google.android.gms.internal.ads.zzcif
            java.lang.String r3 = "Error connecting to ad server:"
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r4 = r0.length()
            if (r4 == 0) goto L_0x0275
            java.lang.String r0 = r3.concat(r0)
            goto L_0x027a
        L_0x0275:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
        L_0x027a:
            r3 = 2
            r2.<init>(r0, r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzciu.zza(java.lang.String, com.google.android.gms.internal.ads.zzasd, org.json.JSONObject, java.lang.String):com.google.android.gms.internal.ads.zzciw");
    }

    public final /* synthetic */ Object apply(Object obj) throws Exception {
        zzciv zzciv = (zzciv) obj;
        return zza(zzciv.zzfxu.getUrl(), zzciv.zzfxu, zzciv.zzfxt, this.zzdmi);
    }
}
