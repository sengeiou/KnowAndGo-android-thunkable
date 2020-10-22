package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbk;
import com.google.android.gms.internal.ads.zzbp;
import java.util.concurrent.ExecutionException;

public final class zzen extends zzfk {
    private static final zzfl<zzch> zzzh = new zzfl<>();
    private final Context zzzg;
    private zzbk.zza zzzi = null;

    public zzen(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2, Context context, zzbk.zza zza2) {
        super(zzdy, str, str2, zza, i, 27);
        this.zzzg = context;
        this.zzzi = zza2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzcx() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzfl<com.google.android.gms.internal.ads.zzch> r0 = zzzh
            android.content.Context r1 = r8.zzzg
            java.lang.String r1 = r1.getPackageName()
            java.util.concurrent.atomic.AtomicReference r0 = r0.zzar(r1)
            monitor-enter(r0)
            java.lang.Object r1 = r0.get()     // Catch:{ all -> 0x011f }
            com.google.android.gms.internal.ads.zzch r1 = (com.google.android.gms.internal.ads.zzch) r1     // Catch:{ all -> 0x011f }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0036
            java.lang.String r4 = r1.zzne     // Catch:{ all -> 0x011f }
            boolean r4 = com.google.android.gms.internal.ads.zzef.zzaq(r4)     // Catch:{ all -> 0x011f }
            if (r4 != 0) goto L_0x0036
            java.lang.String r4 = r1.zzne     // Catch:{ all -> 0x011f }
            java.lang.String r5 = "E"
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x011f }
            if (r4 != 0) goto L_0x0036
            java.lang.String r1 = r1.zzne     // Catch:{ all -> 0x011f }
            java.lang.String r4 = "0000000000000000000000000000000000000000000000000000000000000000"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x011f }
            if (r1 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r1 = 0
            goto L_0x0037
        L_0x0036:
            r1 = 1
        L_0x0037:
            if (r1 == 0) goto L_0x00e9
            com.google.android.gms.internal.ads.zzbk$zza r1 = r8.zzzi     // Catch:{ all -> 0x011f }
            java.lang.String r1 = zza(r1)     // Catch:{ all -> 0x011f }
            boolean r1 = com.google.android.gms.internal.ads.zzef.zzaq(r1)     // Catch:{ all -> 0x011f }
            if (r1 != 0) goto L_0x0048
            com.google.android.gms.internal.ads.zzbm r1 = com.google.android.gms.internal.ads.zzbm.ENUM_SIGNAL_SOURCE_CALLER_PROVIDED     // Catch:{ all -> 0x011f }
            goto L_0x0082
        L_0x0048:
            com.google.android.gms.internal.ads.zzbk$zza r1 = r8.zzzi     // Catch:{ all -> 0x011f }
            java.lang.String r4 = zza(r1)     // Catch:{ all -> 0x011f }
            boolean r4 = com.google.android.gms.internal.ads.zzef.zzaq(r4)     // Catch:{ all -> 0x011f }
            if (r4 == 0) goto L_0x006a
            if (r1 == 0) goto L_0x006a
            boolean r4 = r1.zzu()     // Catch:{ all -> 0x011f }
            if (r4 == 0) goto L_0x006a
            com.google.android.gms.internal.ads.zzbk$zzb r1 = r1.zzv()     // Catch:{ all -> 0x011f }
            com.google.android.gms.internal.ads.zzbm r1 = r1.zzz()     // Catch:{ all -> 0x011f }
            com.google.android.gms.internal.ads.zzbm r4 = com.google.android.gms.internal.ads.zzbm.ENUM_SIGNAL_SOURCE_GASS     // Catch:{ all -> 0x011f }
            if (r1 != r4) goto L_0x006a
            r1 = 1
            goto L_0x006b
        L_0x006a:
            r1 = 0
        L_0x006b:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x011f }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x011f }
            if (r1 == 0) goto L_0x0080
            com.google.android.gms.internal.ads.zzdy r1 = r8.zzvd     // Catch:{ all -> 0x011f }
            boolean r1 = r1.zzcn()     // Catch:{ all -> 0x011f }
            if (r1 == 0) goto L_0x0080
            com.google.android.gms.internal.ads.zzbm r1 = com.google.android.gms.internal.ads.zzbm.ENUM_SIGNAL_SOURCE_GASS     // Catch:{ all -> 0x011f }
            goto L_0x0082
        L_0x0080:
            com.google.android.gms.internal.ads.zzbm r1 = com.google.android.gms.internal.ads.zzbm.ENUM_SIGNAL_SOURCE_ADSHIELD     // Catch:{ all -> 0x011f }
        L_0x0082:
            java.lang.reflect.Method r4 = r8.zzzw     // Catch:{ all -> 0x011f }
            r5 = 0
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x011f }
            android.content.Context r7 = r8.zzzg     // Catch:{ all -> 0x011f }
            r6[r2] = r7     // Catch:{ all -> 0x011f }
            com.google.android.gms.internal.ads.zzbm r7 = com.google.android.gms.internal.ads.zzbm.ENUM_SIGNAL_SOURCE_ADSHIELD     // Catch:{ all -> 0x011f }
            if (r1 != r7) goto L_0x0091
            r2 = 1
        L_0x0091:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x011f }
            r6[r3] = r2     // Catch:{ all -> 0x011f }
            r2 = 2
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzacu.zzcrj     // Catch:{ all -> 0x011f }
            com.google.android.gms.internal.ads.zzacr r7 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ all -> 0x011f }
            java.lang.Object r3 = r7.zzd(r3)     // Catch:{ all -> 0x011f }
            r6[r2] = r3     // Catch:{ all -> 0x011f }
            java.lang.Object r2 = r4.invoke(r5, r6)     // Catch:{ all -> 0x011f }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x011f }
            com.google.android.gms.internal.ads.zzch r3 = new com.google.android.gms.internal.ads.zzch     // Catch:{ all -> 0x011f }
            r3.<init>(r2)     // Catch:{ all -> 0x011f }
            java.lang.String r2 = r3.zzne     // Catch:{ all -> 0x011f }
            boolean r2 = com.google.android.gms.internal.ads.zzef.zzaq(r2)     // Catch:{ all -> 0x011f }
            if (r2 != 0) goto L_0x00c1
            java.lang.String r2 = r3.zzne     // Catch:{ all -> 0x011f }
            java.lang.String r4 = "E"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x011f }
            if (r2 == 0) goto L_0x00e6
        L_0x00c1:
            int[] r2 = com.google.android.gms.internal.ads.zzeo.zzzj     // Catch:{ all -> 0x011f }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x011f }
            r1 = r2[r1]     // Catch:{ all -> 0x011f }
            switch(r1) {
                case 1: goto L_0x00da;
                case 2: goto L_0x00cd;
                default: goto L_0x00cc;
            }     // Catch:{ all -> 0x011f }
        L_0x00cc:
            goto L_0x00e6
        L_0x00cd:
            java.lang.String r1 = r8.zzcy()     // Catch:{ all -> 0x011f }
            boolean r2 = com.google.android.gms.internal.ads.zzef.zzaq(r1)     // Catch:{ all -> 0x011f }
            if (r2 != 0) goto L_0x00e6
            r3.zzne = r1     // Catch:{ all -> 0x011f }
            goto L_0x00e6
        L_0x00da:
            com.google.android.gms.internal.ads.zzbk$zza r1 = r8.zzzi     // Catch:{ all -> 0x011f }
            com.google.android.gms.internal.ads.zzbk$zzc r1 = r1.zzx()     // Catch:{ all -> 0x011f }
            java.lang.String r1 = r1.zzae()     // Catch:{ all -> 0x011f }
            r3.zzne = r1     // Catch:{ all -> 0x011f }
        L_0x00e6:
            r0.set(r3)     // Catch:{ all -> 0x011f }
        L_0x00e9:
            java.lang.Object r1 = r0.get()     // Catch:{ all -> 0x011f }
            com.google.android.gms.internal.ads.zzch r1 = (com.google.android.gms.internal.ads.zzch) r1     // Catch:{ all -> 0x011f }
            monitor-exit(r0)     // Catch:{ all -> 0x011f }
            com.google.android.gms.internal.ads.zzbp$zza$zza r2 = r8.zzzm
            monitor-enter(r2)
            if (r1 == 0) goto L_0x011b
            com.google.android.gms.internal.ads.zzbp$zza$zza r0 = r8.zzzm     // Catch:{ all -> 0x0119 }
            java.lang.String r3 = r1.zzne     // Catch:{ all -> 0x0119 }
            r0.zzz(r3)     // Catch:{ all -> 0x0119 }
            com.google.android.gms.internal.ads.zzbp$zza$zza r0 = r8.zzzm     // Catch:{ all -> 0x0119 }
            long r3 = r1.zznf     // Catch:{ all -> 0x0119 }
            r0.zzba(r3)     // Catch:{ all -> 0x0119 }
            com.google.android.gms.internal.ads.zzbp$zza$zza r0 = r8.zzzm     // Catch:{ all -> 0x0119 }
            java.lang.String r3 = r1.zzng     // Catch:{ all -> 0x0119 }
            r0.zzab(r3)     // Catch:{ all -> 0x0119 }
            com.google.android.gms.internal.ads.zzbp$zza$zza r0 = r8.zzzm     // Catch:{ all -> 0x0119 }
            java.lang.String r3 = r1.zznh     // Catch:{ all -> 0x0119 }
            r0.zzac(r3)     // Catch:{ all -> 0x0119 }
            com.google.android.gms.internal.ads.zzbp$zza$zza r0 = r8.zzzm     // Catch:{ all -> 0x0119 }
            java.lang.String r1 = r1.zzni     // Catch:{ all -> 0x0119 }
            r0.zzad(r1)     // Catch:{ all -> 0x0119 }
            goto L_0x011b
        L_0x0119:
            r0 = move-exception
            goto L_0x011d
        L_0x011b:
            monitor-exit(r2)     // Catch:{ all -> 0x0119 }
            return
        L_0x011d:
            monitor-exit(r2)     // Catch:{ all -> 0x0119 }
            throw r0
        L_0x011f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x011f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzen.zzcx():void");
    }

    private static String zza(zzbk.zza zza) {
        if (zza == null || !zza.zzw() || zzef.zzaq(zza.zzx().zzae())) {
            return null;
        }
        return zza.zzx().zzae();
    }

    private final String zzcy() {
        try {
            if (this.zzvd.zzcq() != null) {
                this.zzvd.zzcq().get();
            }
            zzbp.zza zzcp = this.zzvd.zzcp();
            if (zzcp == null || !zzcp.zzai()) {
                return null;
            }
            return zzcp.zzae();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }
}
