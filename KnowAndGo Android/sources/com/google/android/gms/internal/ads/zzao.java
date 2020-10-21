package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@VisibleForTesting
final class zzao {
    final String zza;
    final long zzb;
    final long zzc;
    long zzcb;
    final String zzcc;
    final long zzd;
    final long zze;
    final List<zzl> zzg;

    private zzao(String str, String str2, long j, long j2, long j3, long j4, List<zzl> list) {
        this.zzcc = str;
        this.zza = "".equals(str2) ? null : str2;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = j3;
        this.zze = j4;
        this.zzg = list;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzao(java.lang.String r14, com.google.android.gms.internal.ads.zzc r15) {
        /*
            r13 = this;
            java.lang.String r2 = r15.zza
            long r3 = r15.zzb
            long r5 = r15.zzc
            long r7 = r15.zzd
            long r9 = r15.zze
            java.util.List<com.google.android.gms.internal.ads.zzl> r0 = r15.zzg
            if (r0 == 0) goto L_0x0012
            java.util.List<com.google.android.gms.internal.ads.zzl> r15 = r15.zzg
            r11 = r15
            goto L_0x0047
        L_0x0012:
            java.util.Map<java.lang.String, java.lang.String> r15 = r15.zzf
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r15.size()
            r0.<init>(r1)
            java.util.Set r15 = r15.entrySet()
            java.util.Iterator r15 = r15.iterator()
        L_0x0025:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L_0x0046
            java.lang.Object r1 = r15.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            com.google.android.gms.internal.ads.zzl r11 = new com.google.android.gms.internal.ads.zzl
            java.lang.Object r12 = r1.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r11.<init>(r12, r1)
            r0.add(r11)
            goto L_0x0025
        L_0x0046:
            r11 = r0
        L_0x0047:
            r0 = r13
            r1 = r14
            r0.<init>(r1, r2, r3, r5, r7, r9, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzao.<init>(java.lang.String, com.google.android.gms.internal.ads.zzc):void");
    }

    static zzao zzc(zzap zzap) throws IOException {
        if (zzan.zzb((InputStream) zzap) == 538247942) {
            return new zzao(zzan.zza(zzap), zzan.zza(zzap), zzan.zzc(zzap), zzan.zzc(zzap), zzan.zzc(zzap), zzan.zzc(zzap), zzan.zzb(zzap));
        }
        throw new IOException();
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(OutputStream outputStream) {
        try {
            zzan.zza(outputStream, 538247942);
            zzan.zza(outputStream, this.zzcc);
            zzan.zza(outputStream, this.zza == null ? "" : this.zza);
            zzan.zza(outputStream, this.zzb);
            zzan.zza(outputStream, this.zzc);
            zzan.zza(outputStream, this.zzd);
            zzan.zza(outputStream, this.zze);
            List<zzl> list = this.zzg;
            if (list != null) {
                zzan.zza(outputStream, list.size());
                for (zzl next : list) {
                    zzan.zza(outputStream, next.getName());
                    zzan.zza(outputStream, next.getValue());
                }
            } else {
                zzan.zza(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e) {
            zzag.m183d("%s", e.toString());
            return false;
        }
    }
}
