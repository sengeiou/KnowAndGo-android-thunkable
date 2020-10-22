package com.google.android.gms.internal.ads;

final class zzbke implements zzbxp {
    private zzcyo zzepw;
    private zzbqy zzepx;
    private zzcfp zzepy;
    private zzbpx zzepz;
    private zzbqt zzeqa;
    private zzbtv zzeqb;
    private zzbxk zzeqc;
    private zzcyg zzeqd;
    private final /* synthetic */ zzbkc zzeqe;

    private zzbke(zzbkc zzbkc) {
        this.zzeqe = zzbkc;
    }

    public final zzbxo zzacy() {
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
        zzdto.zza(this.zzeqb, zzbtv.class);
        zzdto.zza(this.zzeqc, zzbxk.class);
        if (this.zzeqd == null) {
            this.zzeqd = new zzcyg();
        }
        return new zzbkf(this.zzeqe, this.zzepw, this.zzepx, this.zzepy, this.zzepz, this.zzeqa, this.zzeqb, this.zzeqc, this.zzeqd);
    }

    public final /* synthetic */ zzbxp zza(zzbxk zzbxk) {
        this.zzeqc = (zzbxk) zzdto.checkNotNull(zzbxk);
        return this;
    }

    public final /* synthetic */ zzbxp zza(zzbqy zzbqy) {
        this.zzepx = (zzbqy) zzdto.checkNotNull(zzbqy);
        return this;
    }

    public final /* synthetic */ zzbxp zza(zzbtv zzbtv) {
        this.zzeqb = (zzbtv) zzdto.checkNotNull(zzbtv);
        return this;
    }
}
