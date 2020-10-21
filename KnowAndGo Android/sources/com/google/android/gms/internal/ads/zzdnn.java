package com.google.android.gms.internal.ads;

final class zzdnn {
    private static final Class<?> zzhdy = zzawz();

    private static Class<?> zzawz() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzdno zzaxa() {
        if (zzhdy != null) {
            try {
                return zzgz("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return zzdno.zzhec;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.ads.zzdno zzaxb() {
        /*
            java.lang.Class<?> r0 = zzhdy
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = "loadGeneratedRegistry"
            com.google.android.gms.internal.ads.zzdno r0 = zzgz(r0)     // Catch:{ Exception -> 0x000b }
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            if (r0 != 0) goto L_0x0012
            com.google.android.gms.internal.ads.zzdno r0 = com.google.android.gms.internal.ads.zzdno.zzaxb()
        L_0x0012:
            if (r0 != 0) goto L_0x0018
            com.google.android.gms.internal.ads.zzdno r0 = zzaxa()
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdnn.zzaxb():com.google.android.gms.internal.ads.zzdno");
    }

    private static final zzdno zzgz(String str) throws Exception {
        return (zzdno) zzhdy.getDeclaredMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
    }
}
