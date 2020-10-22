package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.play.core.splitcompat.C2083c;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.at */
public final class C1996at {

    /* renamed from: a */
    private final C2083c f758a;

    /* renamed from: b */
    private final Context f759b;

    /* renamed from: c */
    private final C1998av f760c;

    public C1996at(Context context, C2083c cVar, C1998av avVar, byte[] bArr) {
        this.f758a = cVar;
        this.f760c = avVar;
        this.f759b = context;
    }

    @Nullable
    /* renamed from: a */
    private static X509Certificate m623a(Signature signature) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
        } catch (CertificateException e) {
            Log.e("SplitCompat", "Cannot decode certificate.", e);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ae, code lost:
        r1 = "SplitCompat";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r3 = new java.lang.StringBuilder(java.lang.String.valueOf(r5).length() + 32);
        r3.append("Downloaded split ");
        r3.append(r5);
        r3.append(" is not signed.");
        r2 = r3.toString();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo33567a() {
        /*
            r11 = this;
            r0 = 0
            com.google.android.play.core.splitcompat.c r1 = r11.f758a     // Catch:{ IOException -> 0x0112 }
            java.io.File r1 = r1.mo33689c()     // Catch:{ IOException -> 0x0112 }
            r2 = 0
            android.content.Context r3 = r11.f759b     // Catch:{ NameNotFoundException -> 0x001d }
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ NameNotFoundException -> 0x001d }
            android.content.Context r4 = r11.f759b     // Catch:{ NameNotFoundException -> 0x001d }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ NameNotFoundException -> 0x001d }
            r5 = 64
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r4, r5)     // Catch:{ NameNotFoundException -> 0x001d }
            android.content.pm.Signature[] r3 = r3.signatures     // Catch:{ NameNotFoundException -> 0x001d }
            goto L_0x001e
        L_0x001d:
            r3 = r2
        L_0x001e:
            if (r3 != 0) goto L_0x0021
            goto L_0x0038
        L_0x0021:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            int r4 = r3.length
            r5 = 0
        L_0x0028:
            if (r5 >= r4) goto L_0x0038
            r6 = r3[r5]
            java.security.cert.X509Certificate r6 = m623a((android.content.pm.Signature) r6)
            if (r6 == 0) goto L_0x0035
            r2.add(r6)
        L_0x0035:
            int r5 = r5 + 1
            goto L_0x0028
        L_0x0038:
            if (r2 == 0) goto L_0x010a
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L_0x0042
            goto L_0x010a
        L_0x0042:
            java.io.File[] r1 = r1.listFiles()
            java.util.Arrays.sort(r1)
            int r3 = r1.length
        L_0x004a:
            int r3 = r3 + -1
            if (r3 < 0) goto L_0x0108
            r4 = r1[r3]
            java.lang.String r5 = r4.getAbsolutePath()     // Catch:{ Exception -> 0x00ff }
            java.security.cert.X509Certificate[][] r6 = com.google.android.play.core.internal.C2049h.m764a((java.lang.String) r5)     // Catch:{ Exception -> 0x00d1 }
            if (r6 == 0) goto L_0x00ae
            int r7 = r6.length     // Catch:{ Exception -> 0x00ff }
            if (r7 == 0) goto L_0x00ae
            r7 = r6[r0]     // Catch:{ Exception -> 0x00ff }
            int r7 = r7.length     // Catch:{ Exception -> 0x00ff }
            if (r7 != 0) goto L_0x0063
            goto L_0x00ae
        L_0x0063:
            boolean r5 = r2.isEmpty()     // Catch:{ Exception -> 0x00ff }
            if (r5 == 0) goto L_0x0072
            java.lang.String r1 = "SplitCompat"
            java.lang.String r2 = "No certificates found for app."
        L_0x006d:
            android.util.Log.e(r1, r2)     // Catch:{ Exception -> 0x00ff }
            goto L_0x00f7
        L_0x0072:
            java.util.Iterator r5 = r2.iterator()     // Catch:{ Exception -> 0x00ff }
        L_0x0076:
            boolean r7 = r5.hasNext()     // Catch:{ Exception -> 0x00ff }
            if (r7 == 0) goto L_0x009b
            java.lang.Object r7 = r5.next()     // Catch:{ Exception -> 0x00ff }
            java.security.cert.X509Certificate r7 = (java.security.cert.X509Certificate) r7     // Catch:{ Exception -> 0x00ff }
            int r8 = r6.length     // Catch:{ Exception -> 0x00ff }
            r9 = 0
        L_0x0084:
            if (r9 >= r8) goto L_0x0093
            r10 = r6[r9]     // Catch:{ Exception -> 0x00ff }
            r10 = r10[r0]     // Catch:{ Exception -> 0x00ff }
            boolean r10 = r10.equals(r7)     // Catch:{ Exception -> 0x00ff }
            if (r10 != 0) goto L_0x0076
            int r9 = r9 + 1
            goto L_0x0084
        L_0x0093:
            java.lang.String r1 = "SplitCompat"
            java.lang.String r2 = "There's an app certificate that doesn't sign the split."
            android.util.Log.i(r1, r2)     // Catch:{ Exception -> 0x00ff }
            goto L_0x00f7
        L_0x009b:
            com.google.android.play.core.splitcompat.c r5 = r11.f758a     // Catch:{ IOException -> 0x00a5 }
            java.io.File r5 = r5.mo33682a((java.io.File) r4)     // Catch:{ IOException -> 0x00a5 }
            r4.renameTo(r5)     // Catch:{ IOException -> 0x00a5 }
            goto L_0x004a
        L_0x00a5:
            r1 = move-exception
            java.lang.String r2 = "SplitCompat"
            java.lang.String r3 = "Cannot write verified split."
            android.util.Log.e(r2, r3, r1)
            return r0
        L_0x00ae:
            java.lang.String r1 = "SplitCompat"
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x00ff }
            int r2 = r2.length()     // Catch:{ Exception -> 0x00ff }
            int r2 = r2 + 32
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ff }
            r3.<init>(r2)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r2 = "Downloaded split "
            r3.append(r2)     // Catch:{ Exception -> 0x00ff }
            r3.append(r5)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r2 = " is not signed."
            r3.append(r2)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x00ff }
            goto L_0x006d
        L_0x00d1:
            r1 = move-exception
            java.lang.String r2 = "SplitCompat"
            java.lang.String r3 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x00ff }
            int r3 = r3.length()     // Catch:{ Exception -> 0x00ff }
            int r3 = r3 + 32
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ff }
            r4.<init>(r3)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r3 = "Downloaded split "
            r4.append(r3)     // Catch:{ Exception -> 0x00ff }
            r4.append(r5)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r3 = " is not signed."
            r4.append(r3)     // Catch:{ Exception -> 0x00ff }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x00ff }
            android.util.Log.e(r2, r3, r1)     // Catch:{ Exception -> 0x00ff }
        L_0x00f7:
            java.lang.String r1 = "SplitCompat"
            java.lang.String r2 = "Split verification failure."
            android.util.Log.e(r1, r2)     // Catch:{ Exception -> 0x00ff }
            return r0
        L_0x00ff:
            r1 = move-exception
            java.lang.String r2 = "SplitCompat"
            java.lang.String r3 = "Split verification error."
            android.util.Log.e(r2, r3, r1)
            return r0
        L_0x0108:
            r0 = 1
            return r0
        L_0x010a:
            java.lang.String r1 = "SplitCompat"
            java.lang.String r2 = "No app certificates found."
            android.util.Log.e(r1, r2)
            return r0
        L_0x0112:
            r1 = move-exception
            java.lang.String r2 = "SplitCompat"
            java.lang.String r3 = "Cannot access directory for unverified splits."
            android.util.Log.e(r2, r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.internal.C1996at.mo33567a():boolean");
    }

    /* renamed from: a */
    public final boolean mo33568a(List<Intent> list) throws IOException {
        for (Intent stringExtra : list) {
            if (!this.f758a.mo33687b(stringExtra.getStringExtra("split_id")).exists()) {
                return false;
            }
        }
        return true;
    }
}
