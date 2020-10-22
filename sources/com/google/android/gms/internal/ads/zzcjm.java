package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzwt;
import java.util.ArrayList;

public final class zzcjm {
    private static final SparseArray<zzwt.zzi.zzc> zzfyz;
    private final zzcji zzfww;
    private final zzbbh<Bundle> zzfyv;
    private final TelephonyManager zzfyw;
    /* access modifiers changed from: private */
    public final zzcjc zzfyx;
    private zzwx zzfyy;
    private final Context zzlj;

    zzcjm(Context context, zzbbh<Bundle> zzbbh, zzcji zzcji, zzcjc zzcjc) {
        this.zzlj = context;
        this.zzfyv = zzbbh;
        this.zzfww = zzcji;
        this.zzfyx = zzcjc;
        this.zzfyw = (TelephonyManager) context.getSystemService("phone");
    }

    private static zzwx zzaz(boolean z) {
        return z ? zzwx.ENUM_TRUE : zzwx.ENUM_FALSE;
    }

    /* access modifiers changed from: private */
    public final zzwt.zzg zzj(Bundle bundle) {
        zzwt.zzg.zzb zzb;
        zzwt.zzg.zza zznv = zzwt.zzg.zznv();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            this.zzfyy = zzwx.ENUM_TRUE;
        } else {
            this.zzfyy = zzwx.ENUM_FALSE;
            switch (i) {
                case 0:
                    zznv.zzb(zzwt.zzg.zzc.CELL);
                    break;
                case 1:
                    zznv.zzb(zzwt.zzg.zzc.WIFI);
                    break;
                default:
                    zznv.zzb(zzwt.zzg.zzc.NETWORKTYPE_UNSPECIFIED);
                    break;
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzb = zzwt.zzg.zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzb = zzwt.zzg.zzb.THREE_G;
                    break;
                case 13:
                    zzb = zzwt.zzg.zzb.LTE;
                    break;
                default:
                    zzb = zzwt.zzg.zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zznv.zzb(zzb);
        }
        return (zzwt.zzg) ((zzdob) zznv.zzaya());
    }

    /* access modifiers changed from: private */
    public static zzwt.zzi.zzc zzk(Bundle bundle) {
        return zzfyz.get(zzcxz.zza(zzcxz.zza(bundle, "device"), "network").getInt("active_network_state", -1), zzwt.zzi.zzc.UNSPECIFIED);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.google.android.gms.internal.ads.zzwt.zza.C4389zza> zzl(android.os.Bundle r5) {
        /*
            java.lang.String r0 = "ad_types"
            java.lang.Object r5 = r5.get(r0)
            boolean r0 = r5 instanceof java.util.List
            if (r0 == 0) goto L_0x000d
            java.util.List r5 = (java.util.List) r5
            goto L_0x0017
        L_0x000d:
            boolean r0 = r5 instanceof java.lang.String[]
            if (r0 == 0) goto L_0x003d
            java.lang.String[] r5 = (java.lang.String[]) r5
            java.util.List r5 = java.util.Arrays.asList(r5)
        L_0x0017:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r5.size()
            r0.<init>(r1)
            java.util.Iterator r5 = r5.iterator()
        L_0x0024:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0038
            java.lang.Object r1 = r5.next()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x0024
            java.lang.String r1 = (java.lang.String) r1
            r0.add(r1)
            goto L_0x0024
        L_0x0038:
            java.util.List r5 = java.util.Collections.unmodifiableList(r0)
            goto L_0x0041
        L_0x003d:
            java.util.List r5 = java.util.Collections.emptyList()
        L_0x0041:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x004a:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x00ac
            java.lang.Object r1 = r5.next()
            java.lang.String r1 = (java.lang.String) r1
            r2 = -1
            int r3 = r1.hashCode()
            r4 = -1396342996(0xffffffffacc57f2c, float:-5.6131957E-12)
            if (r3 == r4) goto L_0x008e
            r4 = -1052618729(0xffffffffc1425017, float:-12.144553)
            if (r3 == r4) goto L_0x0084
            r4 = -239580146(0xfffffffff1b84c0e, float:-1.82519E30)
            if (r3 == r4) goto L_0x007a
            r4 = 604727084(0x240b672c, float:3.022821E-17)
            if (r3 == r4) goto L_0x0070
            goto L_0x0097
        L_0x0070:
            java.lang.String r3 = "interstitial"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0097
            r2 = 1
            goto L_0x0097
        L_0x007a:
            java.lang.String r3 = "rewarded"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0097
            r2 = 3
            goto L_0x0097
        L_0x0084:
            java.lang.String r3 = "native"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0097
            r2 = 2
            goto L_0x0097
        L_0x008e:
            java.lang.String r3 = "banner"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0097
            r2 = 0
        L_0x0097:
            switch(r2) {
                case 0: goto L_0x00a6;
                case 1: goto L_0x00a3;
                case 2: goto L_0x00a0;
                case 3: goto L_0x009d;
                default: goto L_0x009a;
            }
        L_0x009a:
            com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.C4389zza.AD_FORMAT_TYPE_UNSPECIFIED
            goto L_0x00a8
        L_0x009d:
            com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.C4389zza.REWARD_BASED_VIDEO_AD
            goto L_0x00a8
        L_0x00a0:
            com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.C4389zza.NATIVE_APP_INSTALL
            goto L_0x00a8
        L_0x00a3:
            com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.C4389zza.INTERSTITIAL
            goto L_0x00a8
        L_0x00a6:
            com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.C4389zza.BANNER
        L_0x00a8:
            r0.add(r1)
            goto L_0x004a
        L_0x00ac:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcjm.zzl(android.os.Bundle):java.util.ArrayList");
    }

    /* access modifiers changed from: private */
    public final byte[] zza(boolean z, ArrayList<zzwt.zza.C4389zza> arrayList, zzwt.zzg zzg, zzwt.zzi.zzc zzc) {
        boolean z2 = false;
        zzwt.zzi.zza.C4390zza zzew = zzwt.zzi.zza.zzoa().zzc(arrayList).zzh(zzaz(zzk.zzli().zzb(this.zzlj.getContentResolver()) != 0)).zzi(zzk.zzli().zza(this.zzlj, this.zzfyw)).zzex(this.zzfww.zzakl()).zzey(this.zzfww.zzakn()).zzcg(this.zzfww.getResponseCode()).zzb(zzc).zzb(zzg).zzj(this.zzfyy).zzf(zzaz(z)).zzew(zzk.zzln().currentTimeMillis());
        if (zzk.zzli().zza(this.zzlj.getContentResolver()) != 0) {
            z2 = true;
        }
        return ((zzwt.zzi.zza) ((zzdob) zzew.zzg(zzaz(z2)).zzaya())).toByteArray();
    }

    public final void zzba(boolean z) {
        zzbar.zza(this.zzfyv, new zzcjn(this, z), zzbbm.zzeaf);
    }

    static {
        SparseArray<zzwt.zzi.zzc> sparseArray = new SparseArray<>();
        zzfyz = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzwt.zzi.zzc.CONNECTED);
        zzfyz.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzwt.zzi.zzc.CONNECTING);
        zzfyz.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzwt.zzi.zzc.CONNECTING);
        zzfyz.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzwt.zzi.zzc.CONNECTING);
        zzfyz.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzwt.zzi.zzc.DISCONNECTING);
        zzfyz.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzwt.zzi.zzc.DISCONNECTED);
        zzfyz.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzwt.zzi.zzc.DISCONNECTED);
        zzfyz.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzwt.zzi.zzc.DISCONNECTED);
        zzfyz.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzwt.zzi.zzc.DISCONNECTED);
        zzfyz.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzwt.zzi.zzc.DISCONNECTED);
        zzfyz.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzwt.zzi.zzc.SUSPENDED);
        if (Build.VERSION.SDK_INT >= 17) {
            zzfyz.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzwt.zzi.zzc.CONNECTING);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            zzfyz.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzwt.zzi.zzc.CONNECTING);
        }
    }
}
