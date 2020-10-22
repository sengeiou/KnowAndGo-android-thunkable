package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbmy implements zzue {
    private final Clock zzbsa;
    private boolean zzbxm = false;
    private zzbgz zzdbs;
    private final zzbml zzffs;
    private final Executor zzffv;
    private zzbmp zzffx = new zzbmp();
    private boolean zzfgs = false;

    public zzbmy(Executor executor, zzbml zzbml, Clock clock) {
        this.zzffv = executor;
        this.zzffs = zzbml;
        this.zzbsa = clock;
    }

    private final void zzafg() {
        try {
            JSONObject zza = this.zzffs.zzj(this.zzffx);
            if (this.zzdbs != null) {
                this.zzffv.execute(new zzbmz(this, zza));
            }
        } catch (JSONException e) {
            zzawz.zza("Failed to call video active view js", e);
        }
    }

    public final void zza(zzud zzud) {
        this.zzffx.zzbtk = this.zzfgs ? false : zzud.zzbtk;
        this.zzffx.timestamp = this.zzbsa.elapsedRealtime();
        this.zzffx.zzfge = zzud;
        if (this.zzbxm) {
            zzafg();
        }
    }

    public final void zzg(zzbgz zzbgz) {
        this.zzdbs = zzbgz;
    }

    public final void disable() {
        this.zzbxm = false;
    }

    public final void enable() {
        this.zzbxm = true;
        zzafg();
    }

    public final void zzax(boolean z) {
        this.zzfgs = z;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(JSONObject jSONObject) {
        this.zzdbs.zzb("AFMA_updateActiveView", jSONObject);
    }
}
