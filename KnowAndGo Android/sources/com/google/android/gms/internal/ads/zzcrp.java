package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public final class zzcrp implements zzcva<zzcro> {
    private final zzawm zzbrw;
    private final zzcxv zzfjp;
    private final zzcva<zzcvf> zzggh;
    private final Context zzlj;

    public zzcrp(zzcsk<zzcvf> zzcsk, zzcxv zzcxv, Context context, zzawm zzawm) {
        this.zzggh = zzcsk;
        this.zzfjp = zzcxv;
        this.zzlj = context;
        this.zzbrw = zzawm;
    }

    public final zzbbh<zzcro> zzalm() {
        return zzbar.zza(this.zzggh.zzalm(), new zzcrq(this), zzbbm.zzeaf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcro zza(zzcvf zzcvf) {
        boolean z;
        String str;
        int i;
        int i2;
        float f;
        String str2;
        int i3;
        int i4;
        int i5;
        DisplayMetrics displayMetrics;
        zzyd zzyd = this.zzfjp.zzdll;
        if (zzyd.zzchg != null) {
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (zzyd zzyd2 : zzyd.zzchg) {
                if (!zzyd2.zzchh && !z2) {
                    str = zzyd2.zzaap;
                    z2 = true;
                }
                if (zzyd2.zzchh && !z3) {
                    z3 = true;
                    z = true;
                }
                if (z2 && z3) {
                    break;
                }
            }
        } else {
            str = zzyd.zzaap;
            z = zzyd.zzchh;
        }
        Resources resources = this.zzlj.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            str2 = null;
            f = 0.0f;
            i2 = 0;
            i = 0;
        } else {
            float f2 = displayMetrics.density;
            int i6 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
            str2 = this.zzbrw.zzvc().zzvx();
            i2 = i6;
            f = f2;
        }
        StringBuilder sb = new StringBuilder();
        if (zzyd.zzchg != null) {
            zzyd[] zzydArr = zzyd.zzchg;
            int length = zzydArr.length;
            int i7 = 0;
            boolean z4 = false;
            while (i7 < length) {
                zzyd zzyd3 = zzydArr[i7];
                if (zzyd3.zzchh) {
                    z4 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    if (zzyd3.width != -1 || f == 0.0f) {
                        i4 = zzyd3.width;
                    } else {
                        i4 = (int) (((float) zzyd3.widthPixels) / f);
                    }
                    sb.append(i4);
                    sb.append("x");
                    if (zzyd3.height != -2 || f == 0.0f) {
                        i5 = zzyd3.height;
                    } else {
                        i5 = (int) (((float) zzyd3.heightPixels) / f);
                    }
                    sb.append(i5);
                }
                i7++;
            }
            if (z4) {
                if (sb.length() != 0) {
                    i3 = 0;
                    sb.insert(0, "|");
                } else {
                    i3 = 0;
                }
                sb.insert(i3, "320x50");
            }
        }
        return new zzcro(zzyd, str, z, sb.toString(), f, i2, i, str2);
    }
}
