package com.google.android.gms.internal.ads;

final class zzbkj implements zzbod {
    private zzcyo zzepw;
    private zzbqy zzepx;
    private zzcfp zzepy;
    private zzbpx zzepz;
    private zzbqt zzeqa;
    private zzbtv zzeqb;
    private zzbxk zzeqc;
    private zzcyg zzeqd;
    private final /* synthetic */ zzbkc zzeqe;
    private zzbnc zzezs;
    private zzbox zzezt;
    private zzcow zzezu;

    private zzbkj(zzbkc zzbkc) {
        this.zzeqe = zzbkc;
    }

    public final zzboc zzads() {
        zzdto.zza(this.zzeqb, zzbtv.class);
        if (this.zzeqd == null) {
            this.zzeqd = new zzcyg();
        }
        if (this.zzepw == null) {
            this.zzepw = new zzcyo();
        }
        zzdto.zza(this.zzepx, zzbqy.class);
        if (this.zzepy == null) {
            this.zzepy = new zzcfp();
        }
        zzdto.zza(this.zzezs, zzbnc.class);
        if (this.zzepz == null) {
            this.zzepz = new zzbpx();
        }
        if (this.zzeqa == null) {
            this.zzeqa = new zzbqt();
        }
        zzdto.zza(this.zzezt, zzbox.class);
        zzdto.zza(this.zzezu, zzcow.class);
        zzdto.zza(this.zzeqc, zzbxk.class);
        return new zzbkk(this.zzeqe, this.zzeqb, this.zzeqd, this.zzepw, this.zzepx, this.zzepy, this.zzezs, this.zzepz, this.zzeqa, this.zzezt, this.zzezu, this.zzeqc);
    }

    public final /* synthetic */ zzbod zzb(zzbxk zzbxk) {
        this.zzeqc = (zzbxk) zzdto.checkNotNull(zzbxk);
        return this;
    }

    public final /* synthetic */ zzbod zza(zzbnc zzbnc) {
        this.zzezs = (zzbnc) zzdto.checkNotNull(zzbnc);
        return this;
    }

    public final /* synthetic */ zzbod zza(zzbox zzbox) {
        this.zzezt = (zzbox) zzdto.checkNotNull(zzbox);
        return this;
    }

    public final /* synthetic */ zzbod zza(zzcow zzcow) {
        this.zzezu = (zzcow) zzdto.checkNotNull(zzcow);
        return this;
    }

    public final /* synthetic */ zzbod zzb(zzbqy zzbqy) {
        this.zzepx = (zzbqy) zzdto.checkNotNull(zzbqy);
        return this;
    }

    public final /* synthetic */ zzbod zzb(zzbtv zzbtv) {
        this.zzeqb = (zzbtv) zzdto.checkNotNull(zzbtv);
        return this;
    }
}
