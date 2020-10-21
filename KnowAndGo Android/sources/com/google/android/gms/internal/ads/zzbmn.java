package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

public final class zzbmn implements zzo, zzbrw, zzbrx, zzue {
    private final Clock zzbsa;
    private final zzbmg zzffr;
    private final zzbml zzffs;
    private final Set<zzbgz> zzfft = new HashSet();
    private final zzamd<JSONObject, JSONObject> zzffu;
    private final Executor zzffv;
    private final AtomicBoolean zzffw = new AtomicBoolean(false);
    @GuardedBy("this")
    private final zzbmp zzffx = new zzbmp();
    private boolean zzffy = false;
    private WeakReference<Object> zzffz = new WeakReference<>(this);

    public zzbmn(zzaly zzaly, zzbml zzbml, Executor executor, zzbmg zzbmg, Clock clock) {
        this.zzffr = zzbmg;
        this.zzffu = zzaly.zzb("google.afma.activeView.handleUpdate", zzalo.zzddi, zzalo.zzddi);
        this.zzffs = zzbml;
        this.zzffv = executor;
        this.zzbsa = clock;
    }

    public final void zzsz() {
    }

    public final void zzta() {
    }

    public final synchronized void zzafd() {
        if (!(this.zzffz.get() != null)) {
            zzaff();
        } else if (!this.zzffy && this.zzffw.get()) {
            try {
                this.zzffx.timestamp = this.zzbsa.elapsedRealtime();
                JSONObject zza = this.zzffs.zzj(this.zzffx);
                for (zzbgz zzbmo : this.zzfft) {
                    this.zzffv.execute(new zzbmo(zzbmo, zza));
                }
                zzbao.zzb(this.zzffu.zzf(zza), "ActiveViewListener.callActiveViewJs");
            } catch (Exception e) {
                zzawz.zza("Failed to call ActiveViewJS", e);
            }
        }
    }

    private final void zzafe() {
        for (zzbgz zze : this.zzfft) {
            this.zzffr.zze(zze);
        }
        this.zzffr.zzafc();
    }

    public final synchronized void zzaff() {
        zzafe();
        this.zzffy = true;
    }

    public final synchronized void zzf(zzbgz zzbgz) {
        this.zzfft.add(zzbgz);
        this.zzffr.zzd(zzbgz);
    }

    public final void zzq(Object obj) {
        this.zzffz = new WeakReference<>(obj);
    }

    public final synchronized void zza(zzud zzud) {
        this.zzffx.zzbtk = zzud.zzbtk;
        this.zzffx.zzfge = zzud;
        zzafd();
    }

    public final synchronized void zzbp(@Nullable Context context) {
        this.zzffx.zzfgb = true;
        zzafd();
    }

    public final synchronized void zzbq(@Nullable Context context) {
        this.zzffx.zzfgb = false;
        zzafd();
    }

    public final synchronized void zzbr(@Nullable Context context) {
        this.zzffx.zzfgd = "u";
        zzafd();
        zzafe();
        this.zzffy = true;
    }

    public final synchronized void onPause() {
        this.zzffx.zzfgb = true;
        zzafd();
    }

    public final synchronized void onResume() {
        this.zzffx.zzfgb = false;
        zzafd();
    }

    public final synchronized void onAdImpression() {
        if (this.zzffw.compareAndSet(false, true)) {
            this.zzffr.zza(this);
            zzafd();
        }
    }
}
