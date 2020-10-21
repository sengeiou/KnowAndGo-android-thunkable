package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Deprecated
public final class zzdbz {
    @Deprecated
    public static final zzdbu zzl(byte[] bArr) throws GeneralSecurityException {
        try {
            zzdha zzn = zzdha.zzn(bArr);
            zzb(zzn);
            return zzdbu.zza(zzn);
        } catch (zzdok unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    public static final zzdbu zza(zzdbv zzdbv) throws GeneralSecurityException, IOException {
        zzdha zzanq = zzdbv.zzanq();
        zzb(zzanq);
        return zzdbu.zza(zzanq);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzb(com.google.android.gms.internal.ads.zzdha r3) throws java.security.GeneralSecurityException {
        /*
            java.util.List r3 = r3.zzasi()
            java.util.Iterator r3 = r3.iterator()
        L_0x0008:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0041
            java.lang.Object r0 = r3.next()
            com.google.android.gms.internal.ads.zzdha$zzb r0 = (com.google.android.gms.internal.ads.zzdha.zzb) r0
            com.google.android.gms.internal.ads.zzdgr r1 = r0.zzasn()
            com.google.android.gms.internal.ads.zzdgr$zzb r1 = r1.zzarv()
            com.google.android.gms.internal.ads.zzdgr$zzb r2 = com.google.android.gms.internal.ads.zzdgr.zzb.UNKNOWN_KEYMATERIAL
            if (r1 == r2) goto L_0x0039
            com.google.android.gms.internal.ads.zzdgr r1 = r0.zzasn()
            com.google.android.gms.internal.ads.zzdgr$zzb r1 = r1.zzarv()
            com.google.android.gms.internal.ads.zzdgr$zzb r2 = com.google.android.gms.internal.ads.zzdgr.zzb.SYMMETRIC
            if (r1 == r2) goto L_0x0039
            com.google.android.gms.internal.ads.zzdgr r0 = r0.zzasn()
            com.google.android.gms.internal.ads.zzdgr$zzb r0 = r0.zzarv()
            com.google.android.gms.internal.ads.zzdgr$zzb r1 = com.google.android.gms.internal.ads.zzdgr.zzb.ASYMMETRIC_PRIVATE
            if (r0 == r1) goto L_0x0039
            goto L_0x0008
        L_0x0039:
            java.security.GeneralSecurityException r3 = new java.security.GeneralSecurityException
            java.lang.String r0 = "keyset contains secret key material"
            r3.<init>(r0)
            throw r3
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdbz.zzb(com.google.android.gms.internal.ads.zzdha):void");
    }
}
