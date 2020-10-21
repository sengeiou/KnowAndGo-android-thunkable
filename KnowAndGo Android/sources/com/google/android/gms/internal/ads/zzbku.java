package com.google.android.gms.internal.ads;

final class zzbku implements zzcqp {
    private zzcyo zzepw;
    private zzbqy zzepx;
    private zzcfp zzepy;
    private final /* synthetic */ zzbkc zzeqe;
    private zzcqt zzfdv;

    private zzbku(zzbkc zzbkc) {
        this.zzeqe = zzbkc;
    }

    public final zzcqo zzaem() {
        if (this.zzepw == null) {
            this.zzepw = new zzcyo();
        }
        zzdto.zza(this.zzepx, zzbqy.class);
        zzdto.zza(this.zzfdv, zzcqt.class);
        if (this.zzepy == null) {
            this.zzepy = new zzcfp();
        }
        return new zzbkv(this.zzeqe, this.zzepw, this.zzepx, this.zzfdv, this.zzepy);
    }

    public final /* synthetic */ zzcqp zza(zzcqt zzcqt) {
        this.zzfdv = (zzcqt) zzdto.checkNotNull(zzcqt);
        return this;
    }

    public final /* synthetic */ zzcqp zze(zzbqy zzbqy) {
        this.zzepx = (zzbqy) zzdto.checkNotNull(zzbqy);
        return this;
    }
}
