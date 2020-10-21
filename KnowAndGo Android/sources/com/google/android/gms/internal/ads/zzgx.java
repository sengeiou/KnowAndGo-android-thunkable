package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.text.TextUtils;
import android.util.Pair;
import java.util.HashMap;

@TargetApi(16)
public final class zzgx {
    private static final HashMap<zza, Pair<String, MediaCodecInfo.CodecCapabilities>> zzaeq = new HashMap<>();

    public static zzgc zzc(String str, boolean z) throws zzgz {
        Pair<String, MediaCodecInfo.CodecCapabilities> zzd = zzd(str, z);
        if (zzd == null) {
            return null;
        }
        return new zzgc((String) zzd.first, zzkq.SDK_INT >= 19 ? ((MediaCodecInfo.CodecCapabilities) zzd.second).isFeatureSupported("adaptive-playback") : false);
    }

    static final class zza {
        public final String mimeType;
        public final boolean zzaer;

        public zza(String str, boolean z) {
            this.mimeType = str;
            this.zzaer = z;
        }

        public final int hashCode() {
            return (((this.mimeType == null ? 0 : this.mimeType.hashCode()) + 31) * 31) + (this.zzaer ? 1231 : 1237);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != zza.class) {
                return false;
            }
            zza zza = (zza) obj;
            return TextUtils.equals(this.mimeType, zza.mimeType) && this.zzaer == zza.zzaer;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized android.util.Pair<java.lang.String, android.media.MediaCodecInfo.CodecCapabilities> zzd(java.lang.String r6, boolean r7) throws com.google.android.gms.internal.ads.zzgz {
        /*
            java.lang.Class<com.google.android.gms.internal.ads.zzgx> r0 = com.google.android.gms.internal.ads.zzgx.class
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzgx$zza r1 = new com.google.android.gms.internal.ads.zzgx$zza     // Catch:{ all -> 0x007a }
            r1.<init>(r6, r7)     // Catch:{ all -> 0x007a }
            java.util.HashMap<com.google.android.gms.internal.ads.zzgx$zza, android.util.Pair<java.lang.String, android.media.MediaCodecInfo$CodecCapabilities>> r2 = zzaeq     // Catch:{ all -> 0x007a }
            boolean r2 = r2.containsKey(r1)     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x001a
            java.util.HashMap<com.google.android.gms.internal.ads.zzgx$zza, android.util.Pair<java.lang.String, android.media.MediaCodecInfo$CodecCapabilities>> r6 = zzaeq     // Catch:{ all -> 0x007a }
            java.lang.Object r6 = r6.get(r1)     // Catch:{ all -> 0x007a }
            android.util.Pair r6 = (android.util.Pair) r6     // Catch:{ all -> 0x007a }
            monitor-exit(r0)
            return r6
        L_0x001a:
            int r2 = com.google.android.gms.internal.ads.zzkq.SDK_INT     // Catch:{ all -> 0x007a }
            r3 = 0
            r4 = 21
            if (r2 < r4) goto L_0x0027
            com.google.android.gms.internal.ads.zzhc r2 = new com.google.android.gms.internal.ads.zzhc     // Catch:{ all -> 0x007a }
            r2.<init>(r7)     // Catch:{ all -> 0x007a }
            goto L_0x002c
        L_0x0027:
            com.google.android.gms.internal.ads.zzhb r2 = new com.google.android.gms.internal.ads.zzhb     // Catch:{ all -> 0x007a }
            r2.<init>()     // Catch:{ all -> 0x007a }
        L_0x002c:
            android.util.Pair r2 = zza(r1, r2)     // Catch:{ all -> 0x007a }
            if (r7 == 0) goto L_0x0078
            if (r2 != 0) goto L_0x0078
            int r7 = com.google.android.gms.internal.ads.zzkq.SDK_INT     // Catch:{ all -> 0x007a }
            if (r7 < r4) goto L_0x0078
            com.google.android.gms.internal.ads.zzhb r7 = new com.google.android.gms.internal.ads.zzhb     // Catch:{ all -> 0x007a }
            r7.<init>()     // Catch:{ all -> 0x007a }
            android.util.Pair r2 = zza(r1, r7)     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x0078
            java.lang.String r7 = "MediaCodecUtil"
            java.lang.Object r1 = r2.first     // Catch:{ all -> 0x007a }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x007a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x007a }
            java.lang.String r4 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x007a }
            int r4 = r4.length()     // Catch:{ all -> 0x007a }
            int r4 = r4 + 63
            java.lang.String r5 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x007a }
            int r5 = r5.length()     // Catch:{ all -> 0x007a }
            int r4 = r4 + r5
            r3.<init>(r4)     // Catch:{ all -> 0x007a }
            java.lang.String r4 = "MediaCodecList API didn't list secure decoder for: "
            r3.append(r4)     // Catch:{ all -> 0x007a }
            r3.append(r6)     // Catch:{ all -> 0x007a }
            java.lang.String r6 = ". Assuming: "
            r3.append(r6)     // Catch:{ all -> 0x007a }
            r3.append(r1)     // Catch:{ all -> 0x007a }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x007a }
            android.util.Log.w(r7, r6)     // Catch:{ all -> 0x007a }
        L_0x0078:
            monitor-exit(r0)
            return r2
        L_0x007a:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgx.zzd(java.lang.String, boolean):android.util.Pair");
    }

    private static Pair<String, MediaCodecInfo.CodecCapabilities> zza(zza zza2, zzha zzha) throws zzgz {
        zza zza3 = zza2;
        zzha zzha2 = zzha;
        try {
            String str = zza3.mimeType;
            int codecCount = zzha.getCodecCount();
            boolean zzeh = zzha.zzeh();
            boolean z = false;
            int i = 0;
            while (i < codecCount) {
                MediaCodecInfo codecInfoAt = zzha2.getCodecInfoAt(i);
                String name = codecInfoAt.getName();
                if (!codecInfoAt.isEncoder() && name.startsWith("OMX.") && (zzeh || !name.endsWith(".secure"))) {
                    String[] supportedTypes = codecInfoAt.getSupportedTypes();
                    int i2 = 0;
                    while (i2 < supportedTypes.length) {
                        String str2 = supportedTypes[i2];
                        if (str2.equalsIgnoreCase(str)) {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str2);
                            boolean zza4 = zzha2.zza(zza3.mimeType, capabilitiesForType);
                            if (!zzeh) {
                                zzaeq.put(zza3.zzaer ? new zza(str, z) : zza3, Pair.create(name, capabilitiesForType));
                                if (zza4) {
                                    zzaeq.put(zza3.zzaer ? zza3 : new zza(str, true), Pair.create(String.valueOf(name).concat(".secure"), capabilitiesForType));
                                }
                            } else {
                                zzaeq.put(zza3.zzaer == zza4 ? zza3 : new zza(str, zza4), Pair.create(name, capabilitiesForType));
                            }
                            if (zzaeq.containsKey(zza3)) {
                                return zzaeq.get(zza3);
                            }
                        }
                        i2++;
                        z = false;
                    }
                    continue;
                }
                i++;
                z = false;
            }
            return null;
        } catch (Exception e) {
            throw new zzgz(e);
        }
    }
}
