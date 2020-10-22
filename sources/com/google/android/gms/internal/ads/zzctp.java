package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.ArrayList;
import javax.annotation.Nullable;

public final class zzctp implements zzcva<zzcto> {
    private final PackageInfo zzdlm;
    private final zzaxb zzduk;
    private final zzcxv zzfjp;
    private final zzbbl zzfqw;

    public zzctp(zzbbl zzbbl, zzcxv zzcxv, @Nullable PackageInfo packageInfo, zzaxb zzaxb) {
        this.zzfqw = zzbbl;
        this.zzfjp = zzcxv;
        this.zzdlm = packageInfo;
        this.zzduk = zzaxb;
    }

    public final zzbbh<zzcto> zzalm() {
        return this.zzfqw.zza(new zzctq(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b1, code lost:
        r5 = r5.optJSONArray(r4.zzfjp.zzglb);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(java.util.ArrayList r5, android.os.Bundle r6) {
        /*
            r4 = this;
            java.lang.String r0 = "native_version"
            r1 = 3
            r6.putInt(r0, r1)
            java.lang.String r0 = "native_templates"
            r6.putStringArrayList(r0, r5)
            java.lang.String r5 = "native_custom_templates"
            com.google.android.gms.internal.ads.zzcxv r0 = r4.zzfjp
            java.util.ArrayList<java.lang.String> r0 = r0.zzgld
            r6.putStringArrayList(r5, r0)
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r5 = com.google.android.gms.internal.ads.zzacu.zzcsg
            com.google.android.gms.internal.ads.zzacr r0 = com.google.android.gms.internal.ads.zzyt.zzpe()
            java.lang.Object r5 = r0.zzd(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r0 = 1
            if (r5 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzcxv r5 = r4.zzfjp
            com.google.android.gms.internal.ads.zzady r5 = r5.zzdgs
            int r5 = r5.versionCode
            if (r5 <= r1) goto L_0x0058
            java.lang.String r5 = "enable_native_media_orientation"
            r6.putBoolean(r5, r0)
            com.google.android.gms.internal.ads.zzcxv r5 = r4.zzfjp
            com.google.android.gms.internal.ads.zzady r5 = r5.zzdgs
            int r5 = r5.zzbqd
            switch(r5) {
                case 1: goto L_0x0049;
                case 2: goto L_0x0046;
                case 3: goto L_0x0043;
                case 4: goto L_0x0040;
                default: goto L_0x003d;
            }
        L_0x003d:
            java.lang.String r5 = "unknown"
            goto L_0x004b
        L_0x0040:
            java.lang.String r5 = "square"
            goto L_0x004b
        L_0x0043:
            java.lang.String r5 = "portrait"
            goto L_0x004b
        L_0x0046:
            java.lang.String r5 = "landscape"
            goto L_0x004b
        L_0x0049:
            java.lang.String r5 = "any"
        L_0x004b:
            java.lang.String r1 = "unknown"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x0058
            java.lang.String r1 = "native_media_orientation"
            r6.putString(r1, r5)
        L_0x0058:
            com.google.android.gms.internal.ads.zzcxv r5 = r4.zzfjp
            com.google.android.gms.internal.ads.zzady r5 = r5.zzdgs
            int r5 = r5.zzbqc
            switch(r5) {
                case 0: goto L_0x006a;
                case 1: goto L_0x0067;
                case 2: goto L_0x0064;
                default: goto L_0x0061;
            }
        L_0x0061:
            java.lang.String r5 = "unknown"
            goto L_0x006c
        L_0x0064:
            java.lang.String r5 = "landscape"
            goto L_0x006c
        L_0x0067:
            java.lang.String r5 = "portrait"
            goto L_0x006c
        L_0x006a:
            java.lang.String r5 = "any"
        L_0x006c:
            java.lang.String r1 = "unknown"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x0079
            java.lang.String r1 = "native_image_orientation"
            r6.putString(r1, r5)
        L_0x0079:
            java.lang.String r5 = "native_multiple_images"
            com.google.android.gms.internal.ads.zzcxv r1 = r4.zzfjp
            com.google.android.gms.internal.ads.zzady r1 = r1.zzdgs
            boolean r1 = r1.zzbqe
            r6.putBoolean(r5, r1)
            java.lang.String r5 = "use_custom_mute"
            com.google.android.gms.internal.ads.zzcxv r1 = r4.zzfjp
            com.google.android.gms.internal.ads.zzady r1 = r1.zzdgs
            boolean r1 = r1.zzbqh
            r6.putBoolean(r5, r1)
            android.content.pm.PackageInfo r5 = r4.zzdlm
            if (r5 != 0) goto L_0x0095
            r5 = 0
            goto L_0x0097
        L_0x0095:
            int r5 = r5.versionCode
        L_0x0097:
            com.google.android.gms.internal.ads.zzaxb r1 = r4.zzduk
            int r1 = r1.zzvq()
            if (r5 <= r1) goto L_0x00a9
            com.google.android.gms.internal.ads.zzaxb r1 = r4.zzduk
            r1.zzvw()
            com.google.android.gms.internal.ads.zzaxb r1 = r4.zzduk
            r1.zzct(r5)
        L_0x00a9:
            com.google.android.gms.internal.ads.zzaxb r5 = r4.zzduk
            org.json.JSONObject r5 = r5.zzvv()
            if (r5 == 0) goto L_0x00c0
            com.google.android.gms.internal.ads.zzcxv r1 = r4.zzfjp
            java.lang.String r1 = r1.zzglb
            org.json.JSONArray r5 = r5.optJSONArray(r1)
            if (r5 == 0) goto L_0x00c0
            java.lang.String r5 = r5.toString()
            goto L_0x00c1
        L_0x00c0:
            r5 = 0
        L_0x00c1:
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L_0x00cc
            java.lang.String r1 = "native_advanced_settings"
            r6.putString(r1, r5)
        L_0x00cc:
            com.google.android.gms.internal.ads.zzcxv r5 = r4.zzfjp
            int r5 = r5.zzglg
            if (r5 <= r0) goto L_0x00db
            java.lang.String r5 = "max_num_ads"
            com.google.android.gms.internal.ads.zzcxv r1 = r4.zzfjp
            int r1 = r1.zzglg
            r6.putInt(r5, r1)
        L_0x00db:
            com.google.android.gms.internal.ads.zzcxv r5 = r4.zzfjp
            com.google.android.gms.internal.ads.zzaiy r5 = r5.zzdne
            if (r5 == 0) goto L_0x0119
            java.lang.String r5 = "ia_var"
            com.google.android.gms.internal.ads.zzcxv r1 = r4.zzfjp
            com.google.android.gms.internal.ads.zzaiy r1 = r1.zzdne
            int r2 = r1.zzdbe
            switch(r2) {
                case 1: goto L_0x010f;
                case 2: goto L_0x010c;
                default: goto L_0x00ec;
            }
        L_0x00ec:
            int r1 = r1.zzdbe
            r2 = 52
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Instream ad video aspect ratio "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = " is wrong."
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzbad.zzen(r1)
            java.lang.String r1 = "l"
            goto L_0x0111
        L_0x010c:
            java.lang.String r1 = "p"
            goto L_0x0111
        L_0x010f:
            java.lang.String r1 = "l"
        L_0x0111:
            r6.putString(r5, r1)
            java.lang.String r5 = "instr"
            r6.putBoolean(r5, r0)
        L_0x0119:
            com.google.android.gms.internal.ads.zzcxv r5 = r4.zzfjp
            com.google.android.gms.internal.ads.zzaga r5 = r5.zzamn()
            if (r5 == 0) goto L_0x0126
            java.lang.String r5 = "has_delayed_banner_listener"
            r6.putBoolean(r5, r0)
        L_0x0126:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzctp.zza(java.util.ArrayList, android.os.Bundle):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcto zzalt() throws Exception {
        ArrayList<String> arrayList = this.zzfjp.zzglc;
        if (arrayList == null) {
            return zzctr.zzghl;
        }
        if (arrayList.isEmpty()) {
            return zzcts.zzghl;
        }
        return new zzctt(this, arrayList);
    }
}
