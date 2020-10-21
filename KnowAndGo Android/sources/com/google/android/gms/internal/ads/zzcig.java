package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzcig extends zzarn {
    private final Executor zzffv;
    private final zzasm zzfxl;
    private final zzasl zzfxm;
    private final zzblp zzfxn;
    private final Context zzlj;

    public zzcig(Context context, Executor executor, zzasm zzasm, zzblp zzblp, zzasl zzasl) {
        zzacu.initialize(context);
        this.zzlj = context;
        this.zzffv = executor;
        this.zzfxl = zzasm;
        this.zzfxm = zzasl;
        this.zzfxn = zzblp;
    }

    public final zzari zza(zzarg zzarg) throws RemoteException {
        return null;
    }

    public final void zza(zzarg zzarg, zzarp zzarp) throws RemoteException {
    }

    public final zzbbh<InputStream> zzh(zzarx zzarx) {
        zzalr zza = zzk.zzlt().zza(this.zzlj, zzbai.zzxc());
        zzcvs zza2 = this.zzfxn.zza(zzarx);
        zzcih zzcih = new zzcih(zza2);
        zzczc zzczc = zzcii.zzfvz;
        zzalj<I, O> zza3 = zza.zza("AFMA_getAdDictionary", zzalo.zzddi, zzcij.zzddk);
        zzalj<I, O> zza4 = zza.zza("google.afma.response.normalize", zzcir.zzfxv, zzalo.zzddj);
        zzciu zzciu = new zzciu(this.zzlj, zzarx.zzdld.zzbsx, this.zzfxl, zzarx.zzdmi);
        zzczt zzadr = zza2.zzadr();
        zzcze zzane = zzadr.zza(zzczs.GMS_SIGNALS, zzbar.zzm(zzarx.zzdot)).zza(zzcih).zzb(zzczc).zzane();
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvp)).booleanValue()) {
            return zzadr.zza(zzczs.AD_REQUEST, zzane).zza(zza.zza("google.afma.request.getAdResponse", zzalo.zzddi, zzalo.zzddi)).zzb(zzcik.zzfvz).zzane();
        }
        zzcze<E, O2> zzane2 = zzadr.zza(zzczs.BUILD_URL, zzane).zza(zza3).zzane();
        zzcze zzane3 = zzadr.zza(zzczs.HTTP, (zzbbh<?>[]) new zzbbh[]{zzane2, zzane}).zzc(new zzcil(zzane, zzane2)).zzb(zzciu).zzane();
        return zzadr.zza(zzczs.PRE_PROCESS, (zzbbh<?>[]) new zzbbh[]{zzane, zzane2, zzane3}).zzc(new zzcim(zzane3, zzane, zzane2)).zza(zza4).zzane();
    }

    public final void zza(zzarx zzarx, zzarr zzarr) {
        zzbbh<InputStream> zzh = zzh(zzarx);
        zza(zzh, zzarr);
        zzh.zza(new zzcin(this), this.zzffv);
    }

    public final void zzb(zzarx zzarx, zzarr zzarr) {
        zzbbh zzbbh;
        zzalr zza = zzk.zzlt().zza(this.zzlj, zzbai.zzxc());
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcwd)).booleanValue()) {
            zzbbh = zzbar.zzd(new Exception("Signal collection disabled."));
        } else {
            zzcvs zza2 = this.zzfxn.zza(zzarx);
            zzcvb<JSONObject> zzadq = this.zzfxn.zza(zzarx).zzadq();
            zzbbh = zza2.zzadr().zza(zzczs.GET_SIGNALS, zzbar.zzm(zzarx.zzdot)).zza(new zzcio(zzadq)).zzx(zzczs.JS_SIGNALS).zza(zza.zza("google.afma.request.getSignals", zzalo.zzddi, zzalo.zzddj)).zzane();
        }
        zza((zzbbh<InputStream>) zzbbh, zzarr);
    }

    private final void zza(zzbbh<InputStream> zzbbh, zzarr zzarr) {
        zzbar.zza(zzbar.zza(zzbbh, new zzcip(this), (Executor) zzaxg.zzdvp), new zzciq(this, zzarr), zzbbm.zzeaf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaki() {
        zzbao.zza(this.zzfxm.zztz(), "persistFlags");
    }
}
