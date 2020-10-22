package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

@zzard
public final class zzbfa implements zzkw, zzqi, zzsj<zzrv>, zztn {
    @VisibleForTesting
    private static int zzefc;
    @VisibleForTesting
    private static int zzefd;
    private int bytesTransferred;
    private final zzbde zzefp;
    private final zzbez zzegy;
    private final zzlo zzegz;
    private final zzlo zzeha;
    private final zzrj zzehb;
    private zzkv zzehc;
    private ByteBuffer zzehd;
    private boolean zzehe;
    private zzbfi zzehf;
    private Set<WeakReference<zzbev>> zzehg = new HashSet();
    private final Context zzlj;

    public zzbfa(Context context, zzbde zzbde) {
        this.zzlj = context;
        this.zzefp = zzbde;
        this.zzegy = new zzbez();
        this.zzegz = new zzth(this.zzlj, zzpg.zzbhn, 0, zzaxi.zzdvv, this, -1);
        this.zzeha = new zzms(zzpg.zzbhn);
        this.zzehb = new zzrg();
        if (zzawz.zzvj()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
            sb.append("ExoPlayerAdapter initialize ");
            sb.append(valueOf);
            zzawz.zzds(sb.toString());
        }
        zzefc++;
        this.zzehc = zzkz.zza(new zzlo[]{this.zzeha, this.zzegz}, this.zzehb, this.zzegy);
        this.zzehc.zza((zzkw) this);
    }

    public final void zza(zzln zzln) {
    }

    public final void zza(zzlr zzlr, Object obj) {
    }

    public final void zza(zzrb zzrb, zzro zzro) {
    }

    public final void zzb(int i, long j) {
    }

    public final void zzb(Surface surface) {
    }

    public final void zze(zznc zznc) {
    }

    public final /* bridge */ /* synthetic */ void zze(Object obj) {
    }

    public final void zze(String str, long j, long j2) {
    }

    public final void zzf(zznc zznc) {
    }

    public final void zzgt() {
    }

    public final void zzh(boolean z) {
    }

    public final void zzk(zzlh zzlh) {
    }

    public final zzkv zzzt() {
        return this.zzehc;
    }

    public static int zzyp() {
        return zzefc;
    }

    public static int zzyq() {
        return zzefd;
    }

    public final void zza(zzbfi zzbfi) {
        this.zzehf = zzbfi;
    }

    public final zzbez zzzu() {
        return this.zzegy;
    }

    public final void zza(Uri[] uriArr, String str) {
        zza(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zza(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzql zzql;
        this.zzehd = byteBuffer;
        this.zzehe = z;
        if (uriArr.length == 1) {
            zzql = zza(uriArr[0], str);
        } else {
            zzql[] zzqlArr = new zzql[uriArr.length];
            for (int i = 0; i < uriArr.length; i++) {
                zzqlArr[i] = zza(uriArr[i], str);
            }
            zzql = new zzqo(zzqlArr);
        }
        this.zzehc.zza(zzql);
        zzefd++;
    }

    public final void release() {
        if (this.zzehc != null) {
            this.zzehc.zzb((zzkw) this);
            this.zzehc.release();
            this.zzehc = null;
            zzefd--;
        }
    }

    public final long getBytesTransferred() {
        return (long) this.bytesTransferred;
    }

    public final void zzb(IOException iOException) {
        if (this.zzehf != null) {
            this.zzehf.zza("onLoadError", iOException);
        }
    }

    public final void zza(int i, int i2, int i3, float f) {
        if (this.zzehf != null) {
            this.zzehf.zzo(i, i2);
        }
    }

    public final void zza(boolean z, int i) {
        if (this.zzehf != null) {
            this.zzehf.zzde(i);
        }
    }

    public final void zza(zzku zzku) {
        if (this.zzehf != null) {
            this.zzehf.zza("onPlayerError", zzku);
        }
    }

    public final void zzdc(int i) {
        for (WeakReference<zzbev> weakReference : this.zzehg) {
            zzbev zzbev = (zzbev) weakReference.get();
            if (zzbev != null) {
                zzbev.setReceiveBufferSize(i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Surface surface, boolean z) {
        zzky zzky = new zzky(this.zzegz, 1, surface);
        if (z) {
            this.zzehc.zzb(zzky);
            return;
        }
        this.zzehc.zza(zzky);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(float f, boolean z) {
        zzky zzky = new zzky(this.zzeha, 2, Float.valueOf(f));
        if (z) {
            this.zzehc.zzb(zzky);
            return;
        }
        this.zzehc.zza(zzky);
    }

    /* access modifiers changed from: package-private */
    public final void zzap(boolean z) {
        for (int i = 0; i < this.zzehc.zzgs(); i++) {
            this.zzehb.zzg(i, !z);
        }
    }

    @VisibleForTesting
    private final zzql zza(Uri uri, String str) {
        zzbfb zzbfb;
        zzrw zzrw;
        if (!this.zzehe || this.zzehd.limit() <= 0) {
            if (this.zzefp.zzeek > 0) {
                zzrw = new zzbfc(this, str);
            } else {
                zzrw = new zzbfd(this, str);
            }
            zzbff zzbfe = this.zzefp.zzeel ? new zzbfe(this, zzrw) : zzrw;
            if (this.zzehd.limit() > 0) {
                byte[] bArr = new byte[this.zzehd.limit()];
                this.zzehd.get(bArr);
                zzbfe = new zzbff(zzbfe, bArr);
            }
            zzbfb = zzbfe;
        } else {
            byte[] bArr2 = new byte[this.zzehd.limit()];
            this.zzehd.get(bArr2);
            zzbfb = new zzbfb(bArr2);
        }
        return new zzqh(uri, zzbfb, zzbfg.zzehl, -1, zzaxi.zzdvv, this, (String) null, this.zzefp.zzeei);
    }

    public final void finalize() throws Throwable {
        zzefc--;
        if (zzawz.zzvj()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
            sb.append("ExoPlayerAdapter finalize ");
            sb.append(valueOf);
            zzawz.zzds(sb.toString());
        }
    }

    public final /* synthetic */ void zzc(Object obj, int i) {
        this.bytesTransferred += i;
    }

    public final /* synthetic */ void zza(Object obj, zzry zzry) {
        this.bytesTransferred = 0;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzrv zza(zzrw zzrw) {
        return new zzbex(this.zzlj, zzrw.zzju(), this, new zzbfh(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(boolean z, long j) {
        if (this.zzehf != null) {
            this.zzehf.zzd(z, j);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzrv zzev(String str) {
        return new zzsa(str, (zzsv<String>) null, this.zzefp.zzeel ? null : this, this.zzefp.zzeef, this.zzefp.zzeeh, true, (zzsd) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzrv zzew(String str) {
        zzbev zzbev = new zzbev(str, this.zzefp.zzeel ? null : this, this.zzefp.zzeef, this.zzefp.zzeeh, this.zzefp.zzeek);
        this.zzehg.add(new WeakReference(zzbev));
        return zzbev;
    }
}
