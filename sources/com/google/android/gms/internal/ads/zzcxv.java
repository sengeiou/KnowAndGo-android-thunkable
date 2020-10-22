package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.Set;

public final class zzcxv {
    public final zzady zzdgs;
    public final zzyd zzdll;
    @Nullable
    public final zzaiy zzdne;
    public final zzxz zzghg;
    @Nullable
    public final zzzy zzgkz;
    @Nullable
    public final zzacd zzgla;
    public final String zzglb;
    public final ArrayList<String> zzglc;
    public final ArrayList<String> zzgld;
    public final String zzgle;
    public final String zzglf;
    public final int zzglg;
    public final PublisherAdViewOptions zzglh;
    public final zzzs zzgli;
    public final Set<String> zzglj;

    private zzcxv(zzcxx zzcxx) {
        zzacd zzacd;
        this.zzdll = zzcxx.zzdll;
        this.zzglb = zzcxx.zzglb;
        this.zzgkz = zzcxx.zzgkz;
        this.zzghg = new zzxz(zzcxx.zzghg.versionCode, zzcxx.zzghg.zzcgn, zzcxx.zzghg.extras, zzcxx.zzghg.zzcgo, zzcxx.zzghg.zzcgp, zzcxx.zzghg.zzcgq, zzcxx.zzghg.zzcgr, zzcxx.zzghg.zzbqn || zzcxx.zzbqn, zzcxx.zzghg.zzcgs, zzcxx.zzghg.zzcgt, zzcxx.zzghg.zzmw, zzcxx.zzghg.zzcgu, zzcxx.zzghg.zzcgv, zzcxx.zzghg.zzcgw, zzcxx.zzghg.zzcgx, zzcxx.zzghg.zzcgy, zzcxx.zzghg.zzcgz, zzcxx.zzghg.zzcha, zzcxx.zzghg.zzchb, zzcxx.zzghg.zzchc, zzcxx.zzghg.zzchd);
        zzady zzady = null;
        if (zzcxx.zzgla != null) {
            zzacd = zzcxx.zzgla;
        } else {
            zzacd = zzcxx.zzdgs != null ? zzcxx.zzdgs.zzcyn : null;
        }
        this.zzgla = zzacd;
        this.zzglc = zzcxx.zzglc;
        this.zzgld = zzcxx.zzgld;
        if (zzcxx.zzglc != null) {
            if (zzcxx.zzdgs == null) {
                zzady = new zzady(new NativeAdOptions.Builder().build());
            } else {
                zzady = zzcxx.zzdgs;
            }
        }
        this.zzdgs = zzady;
        this.zzgle = zzcxx.zzgle;
        this.zzglf = zzcxx.zzglf;
        this.zzglg = zzcxx.zzglg;
        this.zzglh = zzcxx.zzglh;
        this.zzgli = zzcxx.zzgli;
        this.zzdne = zzcxx.zzdne;
        this.zzglj = zzcxx.zzglj;
    }

    public final zzaga zzamn() {
        if (this.zzglh == null) {
            return null;
        }
        return this.zzglh.zzku();
    }
}
