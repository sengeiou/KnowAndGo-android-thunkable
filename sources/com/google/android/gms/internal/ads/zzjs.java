package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public final class zzjs implements zzkf {
    private static final Pattern zzapl = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzapm = new AtomicReference<>();
    private final zzke zzaoz;
    private boolean zzapd;
    private final boolean zzapn;
    private final int zzapo;
    private final int zzapp;
    private final String zzapq;
    private final zzkn<String> zzapr;
    private final HashMap<String, String> zzaps;
    private zzjq zzapt;
    private HttpURLConnection zzapu;
    private InputStream zzapv;
    private long zzapw;
    private long zzapx;
    private long zzapy;
    private long zzce;

    public zzjs(String str, zzkn<String> zzkn, zzke zzke, int i, int i2, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.zzapq = str;
            this.zzapr = null;
            this.zzaoz = null;
            this.zzaps = new HashMap<>();
            this.zzapo = i;
            this.zzapp = i2;
            this.zzapn = z;
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(com.google.android.gms.internal.ads.zzjq r19) throws com.google.android.gms.internal.ads.zzjx {
        /*
            r18 = this;
            r8 = r18
            r9 = r19
            r8.zzapt = r9
            r10 = 0
            r8.zzce = r10
            r8.zzapy = r10
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x0187 }
            android.net.Uri r0 = r9.uri     // Catch:{ IOException -> 0x0187 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0187 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0187 }
            long r12 = r9.zzahv     // Catch:{ IOException -> 0x0187 }
            long r14 = r9.zzcd     // Catch:{ IOException -> 0x0187 }
            int r0 = r9.flags     // Catch:{ IOException -> 0x0187 }
            r7 = 1
            r0 = r0 & r7
            r5 = 0
            if (r0 == 0) goto L_0x0024
            r0 = 1
            goto L_0x0025
        L_0x0024:
            r0 = 0
        L_0x0025:
            boolean r1 = r8.zzapn     // Catch:{ IOException -> 0x0187 }
            if (r1 != 0) goto L_0x0038
            r1 = r18
            r3 = r12
            r5 = r14
            r12 = 1
            r7 = r0
            java.net.HttpURLConnection r0 = r1.zza(r2, r3, r5, r7)     // Catch:{ IOException -> 0x0187 }
            r0.connect()     // Catch:{ IOException -> 0x0187 }
            r11 = 1
            goto L_0x0075
        L_0x0038:
            r6 = r2
            r1 = 0
        L_0x003a:
            int r3 = r1 + 1
            r2 = 20
            if (r1 > r2) goto L_0x016a
            r1 = r18
            r2 = r6
            r16 = r3
            r3 = r12
            r17 = r6
            r10 = 0
            r5 = r14
            r11 = 1
            r7 = r0
            java.net.HttpURLConnection r1 = r1.zza(r2, r3, r5, r7)     // Catch:{ IOException -> 0x0187 }
            r1.setInstanceFollowRedirects(r10)     // Catch:{ IOException -> 0x0187 }
            r1.connect()     // Catch:{ IOException -> 0x0187 }
            int r2 = r1.getResponseCode()     // Catch:{ IOException -> 0x0187 }
            r3 = 300(0x12c, float:4.2E-43)
            if (r2 == r3) goto L_0x0117
            r3 = 301(0x12d, float:4.22E-43)
            if (r2 == r3) goto L_0x0117
            r3 = 302(0x12e, float:4.23E-43)
            if (r2 == r3) goto L_0x0117
            r3 = 303(0x12f, float:4.25E-43)
            if (r2 == r3) goto L_0x0117
            r3 = 307(0x133, float:4.3E-43)
            if (r2 == r3) goto L_0x0117
            r3 = 308(0x134, float:4.32E-43)
            if (r2 != r3) goto L_0x0074
            goto L_0x0117
        L_0x0074:
            r0 = r1
        L_0x0075:
            r8.zzapu = r0     // Catch:{ IOException -> 0x0187 }
            java.net.HttpURLConnection r0 = r8.zzapu     // Catch:{ IOException -> 0x00f0 }
            int r0 = r0.getResponseCode()     // Catch:{ IOException -> 0x00f0 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 < r1) goto L_0x00e1
            r2 = 299(0x12b, float:4.19E-43)
            if (r0 > r2) goto L_0x00e1
            java.net.HttpURLConnection r2 = r8.zzapu
            r2.getContentType()
            if (r0 != r1) goto L_0x0097
            long r0 = r9.zzahv
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0099
            long r0 = r9.zzahv
            goto L_0x009a
        L_0x0097:
            r2 = 0
        L_0x0099:
            r0 = r2
        L_0x009a:
            r8.zzapw = r0
            int r0 = r9.flags
            r0 = r0 & r11
            if (r0 != 0) goto L_0x00bd
            java.net.HttpURLConnection r0 = r8.zzapu
            long r0 = zzc(r0)
            long r2 = r9.zzcd
            r4 = -1
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x00b2
            long r4 = r9.zzcd
            goto L_0x00ba
        L_0x00b2:
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x00ba
            long r2 = r8.zzapw
            long r4 = r0 - r2
        L_0x00ba:
            r8.zzapx = r4
            goto L_0x00c1
        L_0x00bd:
            long r0 = r9.zzcd
            r8.zzapx = r0
        L_0x00c1:
            java.net.HttpURLConnection r0 = r8.zzapu     // Catch:{ IOException -> 0x00d7 }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x00d7 }
            r8.zzapv = r0     // Catch:{ IOException -> 0x00d7 }
            r8.zzapd = r11
            com.google.android.gms.internal.ads.zzke r0 = r8.zzaoz
            if (r0 == 0) goto L_0x00d4
            com.google.android.gms.internal.ads.zzke r0 = r8.zzaoz
            r0.zzgc()
        L_0x00d4:
            long r0 = r8.zzapx
            return r0
        L_0x00d7:
            r0 = move-exception
            r18.closeConnection()
            com.google.android.gms.internal.ads.zzjx r1 = new com.google.android.gms.internal.ads.zzjx
            r1.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzjq) r9)
            throw r1
        L_0x00e1:
            java.net.HttpURLConnection r1 = r8.zzapu
            java.util.Map r1 = r1.getHeaderFields()
            r18.closeConnection()
            com.google.android.gms.internal.ads.zzjy r2 = new com.google.android.gms.internal.ads.zzjy
            r2.<init>(r0, r1, r9)
            throw r2
        L_0x00f0:
            r0 = move-exception
            r18.closeConnection()
            com.google.android.gms.internal.ads.zzjx r1 = new com.google.android.gms.internal.ads.zzjx
            java.lang.String r2 = "Unable to connect to "
            android.net.Uri r3 = r9.uri
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x010d
            java.lang.String r2 = r2.concat(r3)
            goto L_0x0113
        L_0x010d:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r2)
            r2 = r3
        L_0x0113:
            r1.<init>(r2, r0, r9)
            throw r1
        L_0x0117:
            r2 = 0
            java.lang.String r4 = "Location"
            java.lang.String r4 = r1.getHeaderField(r4)     // Catch:{ IOException -> 0x0187 }
            r1.disconnect()     // Catch:{ IOException -> 0x0187 }
            if (r4 == 0) goto L_0x0162
            java.net.URL r6 = new java.net.URL     // Catch:{ IOException -> 0x0187 }
            r1 = r17
            r6.<init>(r1, r4)     // Catch:{ IOException -> 0x0187 }
            java.lang.String r1 = r6.getProtocol()     // Catch:{ IOException -> 0x0187 }
            java.lang.String r4 = "https"
            boolean r4 = r4.equals(r1)     // Catch:{ IOException -> 0x0187 }
            if (r4 != 0) goto L_0x015b
            java.lang.String r4 = "http"
            boolean r4 = r4.equals(r1)     // Catch:{ IOException -> 0x0187 }
            if (r4 != 0) goto L_0x015b
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x0187 }
            java.lang.String r2 = "Unsupported protocol redirect: "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x0187 }
            int r3 = r1.length()     // Catch:{ IOException -> 0x0187 }
            if (r3 == 0) goto L_0x0152
            java.lang.String r1 = r2.concat(r1)     // Catch:{ IOException -> 0x0187 }
            goto L_0x0157
        L_0x0152:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x0187 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0187 }
        L_0x0157:
            r0.<init>(r1)     // Catch:{ IOException -> 0x0187 }
            throw r0     // Catch:{ IOException -> 0x0187 }
        L_0x015b:
            r10 = r2
            r1 = r16
            r5 = 0
            r7 = 1
            goto L_0x003a
        L_0x0162:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x0187 }
            java.lang.String r1 = "Null location redirect"
            r0.<init>(r1)     // Catch:{ IOException -> 0x0187 }
            throw r0     // Catch:{ IOException -> 0x0187 }
        L_0x016a:
            r16 = r3
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x0187 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0187 }
            r2 = 31
            r1.<init>(r2)     // Catch:{ IOException -> 0x0187 }
            java.lang.String r2 = "Too many redirects: "
            r1.append(r2)     // Catch:{ IOException -> 0x0187 }
            r2 = r16
            r1.append(r2)     // Catch:{ IOException -> 0x0187 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0187 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0187 }
            throw r0     // Catch:{ IOException -> 0x0187 }
        L_0x0187:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzjx r1 = new com.google.android.gms.internal.ads.zzjx
            java.lang.String r2 = "Unable to connect to "
            android.net.Uri r3 = r9.uri
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x01a1
            java.lang.String r2 = r2.concat(r3)
            goto L_0x01a7
        L_0x01a1:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r2)
            r2 = r3
        L_0x01a7:
            r1.<init>(r2, r0, r9)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjs.zza(com.google.android.gms.internal.ads.zzjq):long");
    }

    public final int read(byte[] bArr, int i, int i2) throws zzjx {
        try {
            if (this.zzapy != this.zzapw) {
                byte[] andSet = zzapm.getAndSet((Object) null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (this.zzapy != this.zzapw) {
                    int read = this.zzapv.read(andSet, 0, (int) Math.min(this.zzapw - this.zzapy, (long) andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.zzapy += (long) read;
                        if (this.zzaoz != null) {
                            this.zzaoz.zzab(read);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
                zzapm.set(andSet);
            }
            if (this.zzapx != -1) {
                i2 = (int) Math.min((long) i2, this.zzapx - this.zzce);
            }
            if (i2 == 0) {
                return -1;
            }
            int read2 = this.zzapv.read(bArr, i, i2);
            if (read2 == -1) {
                if (this.zzapx != -1) {
                    if (this.zzapx != this.zzce) {
                        throw new EOFException();
                    }
                }
                return -1;
            }
            this.zzce += (long) read2;
            if (this.zzaoz != null) {
                this.zzaoz.zzab(read2);
            }
            return read2;
        } catch (IOException e) {
            throw new zzjx(e, this.zzapt);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:4|(1:6)(1:7)|8|(5:13|14|(2:16|(1:18))(1:19)|21|(1:25))|26|27|28|29|30) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r2 > android.support.p002v4.media.session.PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) goto L_0x003a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x006b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() throws com.google.android.gms.internal.ads.zzjx {
        /*
            r9 = this;
            r0 = 0
            java.io.InputStream r1 = r9.zzapv     // Catch:{ all -> 0x0091 }
            if (r1 == 0) goto L_0x007d
            java.net.HttpURLConnection r1 = r9.zzapu     // Catch:{ all -> 0x0091 }
            long r2 = r9.zzapx     // Catch:{ all -> 0x0091 }
            r4 = -1
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0012
            long r2 = r9.zzapx     // Catch:{ all -> 0x0091 }
            goto L_0x0018
        L_0x0012:
            long r2 = r9.zzapx     // Catch:{ all -> 0x0091 }
            long r6 = r9.zzce     // Catch:{ all -> 0x0091 }
            r8 = 0
            long r2 = r2 - r6
        L_0x0018:
            int r6 = com.google.android.gms.internal.ads.zzkq.SDK_INT     // Catch:{ all -> 0x0091 }
            r7 = 19
            if (r6 == r7) goto L_0x0024
            int r6 = com.google.android.gms.internal.ads.zzkq.SDK_INT     // Catch:{ all -> 0x0091 }
            r7 = 20
            if (r6 != r7) goto L_0x006b
        L_0x0024:
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException | Exception -> 0x006b }
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x0034
            int r2 = r1.read()     // Catch:{ IOException | Exception -> 0x006b }
            r3 = -1
            if (r2 != r3) goto L_0x003a
            goto L_0x006b
        L_0x0034:
            r4 = 2048(0x800, double:1.0118E-320)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x006b
        L_0x003a:
            java.lang.Class r2 = r1.getClass()     // Catch:{ IOException | Exception -> 0x006b }
            java.lang.String r2 = r2.getName()     // Catch:{ IOException | Exception -> 0x006b }
            java.lang.String r3 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r3 = r2.equals(r3)     // Catch:{ IOException | Exception -> 0x006b }
            if (r3 != 0) goto L_0x0052
            java.lang.String r3 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r2 = r2.equals(r3)     // Catch:{ IOException | Exception -> 0x006b }
            if (r2 == 0) goto L_0x006b
        L_0x0052:
            java.lang.Class r2 = r1.getClass()     // Catch:{ IOException | Exception -> 0x006b }
            java.lang.Class r2 = r2.getSuperclass()     // Catch:{ IOException | Exception -> 0x006b }
            java.lang.String r3 = "unexpectedEndOfInput"
            java.lang.Class[] r4 = new java.lang.Class[r0]     // Catch:{ IOException | Exception -> 0x006b }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r4)     // Catch:{ IOException | Exception -> 0x006b }
            r3 = 1
            r2.setAccessible(r3)     // Catch:{ IOException | Exception -> 0x006b }
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ IOException | Exception -> 0x006b }
            r2.invoke(r1, r3)     // Catch:{ IOException | Exception -> 0x006b }
        L_0x006b:
            java.io.InputStream r1 = r9.zzapv     // Catch:{ IOException -> 0x0074 }
            r1.close()     // Catch:{ IOException -> 0x0074 }
            r1 = 0
            r9.zzapv = r1     // Catch:{ all -> 0x0091 }
            goto L_0x007d
        L_0x0074:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzjx r2 = new com.google.android.gms.internal.ads.zzjx     // Catch:{ all -> 0x0091 }
            com.google.android.gms.internal.ads.zzjq r3 = r9.zzapt     // Catch:{ all -> 0x0091 }
            r2.<init>((java.io.IOException) r1, (com.google.android.gms.internal.ads.zzjq) r3)     // Catch:{ all -> 0x0091 }
            throw r2     // Catch:{ all -> 0x0091 }
        L_0x007d:
            boolean r1 = r9.zzapd
            if (r1 == 0) goto L_0x0090
            r9.zzapd = r0
            com.google.android.gms.internal.ads.zzke r0 = r9.zzaoz
            if (r0 == 0) goto L_0x008c
            com.google.android.gms.internal.ads.zzke r0 = r9.zzaoz
            r0.zzgd()
        L_0x008c:
            r9.closeConnection()
            return
        L_0x0090:
            return
        L_0x0091:
            r1 = move-exception
            boolean r2 = r9.zzapd
            if (r2 == 0) goto L_0x00a4
            r9.zzapd = r0
            com.google.android.gms.internal.ads.zzke r0 = r9.zzaoz
            if (r0 == 0) goto L_0x00a1
            com.google.android.gms.internal.ads.zzke r0 = r9.zzaoz
            r0.zzgd()
        L_0x00a1:
            r9.closeConnection()
        L_0x00a4:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjs.close():void");
    }

    private final HttpURLConnection zza(URL url, long j, long j2, boolean z) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.zzapo);
        httpURLConnection.setReadTimeout(this.zzapp);
        httpURLConnection.setDoOutput(false);
        synchronized (this.zzaps) {
            for (Map.Entry next : this.zzaps.entrySet()) {
                httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
        }
        if (!(j == 0 && j2 == -1)) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            String sb2 = sb.toString();
            if (j2 != -1) {
                String valueOf = String.valueOf(sb2);
                StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb3.append(valueOf);
                sb3.append((j + j2) - 1);
                sb2 = sb3.toString();
            }
            httpURLConnection.setRequestProperty("Range", sb2);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.zzapq);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
        }
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long zzc(java.net.HttpURLConnection r9) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r9.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0036
            long r1 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0011 }
            goto L_0x0038
        L_0x0011:
            java.lang.String r1 = "HttpDataSource"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r3 = r3 + 28
            r2.<init>(r3)
            java.lang.String r3 = "Unexpected Content-Length ["
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = "]"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
        L_0x0036:
            r1 = -1
        L_0x0038:
            java.lang.String r3 = "Content-Range"
            java.lang.String r9 = r9.getHeaderField(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r9)
            if (r3 != 0) goto L_0x00d4
            java.util.regex.Pattern r3 = zzapl
            java.util.regex.Matcher r3 = r3.matcher(r9)
            boolean r4 = r3.find()
            if (r4 == 0) goto L_0x00d4
            r4 = 2
            java.lang.String r4 = r3.group(r4)     // Catch:{ NumberFormatException -> 0x00af }
            long r4 = java.lang.Long.parseLong(r4)     // Catch:{ NumberFormatException -> 0x00af }
            r6 = 1
            java.lang.String r3 = r3.group(r6)     // Catch:{ NumberFormatException -> 0x00af }
            long r6 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x00af }
            r3 = 0
            long r4 = r4 - r6
            r6 = 1
            long r3 = r4 + r6
            r5 = 0
            int r5 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x0070
        L_0x006e:
            r1 = r3
            goto L_0x00d4
        L_0x0070:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00d4
            java.lang.String r5 = "HttpDataSource"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00af }
            java.lang.String r7 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00af }
            int r7 = r7.length()     // Catch:{ NumberFormatException -> 0x00af }
            int r7 = r7 + 26
            java.lang.String r8 = java.lang.String.valueOf(r9)     // Catch:{ NumberFormatException -> 0x00af }
            int r8 = r8.length()     // Catch:{ NumberFormatException -> 0x00af }
            int r7 = r7 + r8
            r6.<init>(r7)     // Catch:{ NumberFormatException -> 0x00af }
            java.lang.String r7 = "Inconsistent headers ["
            r6.append(r7)     // Catch:{ NumberFormatException -> 0x00af }
            r6.append(r0)     // Catch:{ NumberFormatException -> 0x00af }
            java.lang.String r0 = "] ["
            r6.append(r0)     // Catch:{ NumberFormatException -> 0x00af }
            r6.append(r9)     // Catch:{ NumberFormatException -> 0x00af }
            java.lang.String r0 = "]"
            r6.append(r0)     // Catch:{ NumberFormatException -> 0x00af }
            java.lang.String r0 = r6.toString()     // Catch:{ NumberFormatException -> 0x00af }
            android.util.Log.w(r5, r0)     // Catch:{ NumberFormatException -> 0x00af }
            long r3 = java.lang.Math.max(r1, r3)     // Catch:{ NumberFormatException -> 0x00af }
            goto L_0x006e
        L_0x00af:
            java.lang.String r0 = "HttpDataSource"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r9)
            int r4 = r4.length()
            int r4 = r4 + 27
            r3.<init>(r4)
            java.lang.String r4 = "Unexpected Content-Range ["
            r3.append(r4)
            r3.append(r9)
            java.lang.String r9 = "]"
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            android.util.Log.e(r0, r9)
        L_0x00d4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjs.zzc(java.net.HttpURLConnection):long");
    }

    private final void closeConnection() {
        if (this.zzapu != null) {
            this.zzapu.disconnect();
            this.zzapu = null;
        }
    }
}
