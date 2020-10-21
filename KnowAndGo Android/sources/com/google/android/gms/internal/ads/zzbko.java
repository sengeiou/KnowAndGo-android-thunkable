package com.google.android.gms.internal.ads;

final class zzbko implements zzbwt {
    private zzcyo zzepw;
    private zzbqy zzepx;
    private zzcfp zzepy;
    private zzbpx zzepz;
    private zzbqt zzeqa;
    private zzbtv zzeqb;
    private zzcyg zzeqd;
    private final /* synthetic */ zzbkc zzeqe;
    private zzcow zzezu;

    private zzbko(zzbkc zzbkc) {
        this.zzeqe = zzbkc;
    }

    public final zzbws zzaed() {
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
        if (this.zzepz == null) {
            this.zzepz = new zzbpx();
        }
        if (this.zzeqa == null) {
            this.zzeqa = new zzbqt();
        }
        zzdto.zza(this.zzezu, zzcow.class);
        return new zzbkp(this.zzeqe, this.zzeqb, this.zzeqd, this.zzepw, this.zzepx, this.zzepy, this.zzepz, this.zzeqa, this.zzezu);
    }

    public final /* synthetic */ zzbwt zzb(zzcow zzcow) {
        this.zzezu = (zzcow) zzdto.checkNotNull(zzcow);
        return this;
    }

    public final /* synthetic */ zzbwt zzc(zzbqy zzbqy) {
        this.zzepx = (zzbqy) zzdto.checkNotNull(zzbqy);
        return this;
    }

    public final /* synthetic */ zzbwt zzc(zzbtv zzbtv) {
        this.zzeqb = (zzbtv) zzdto.checkNotNull(zzbtv);
        return this;
    }
}
