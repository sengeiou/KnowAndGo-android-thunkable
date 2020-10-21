package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
@zzard
public final class zzajy implements zzajq, zzajw {
    /* access modifiers changed from: private */
    public final zzbgz zzdbs;
    private final Context zzlj;

    public zzajy(Context context, zzbai zzbai, @Nullable zzdh zzdh, zza zza) throws zzbhj {
        this.zzlj = context;
        zzk.zzlh();
        this.zzdbs = zzbhf.zza(context, zzbin.zzabu(), "", false, false, zzdh, zzbai, (zzadi) null, (zzj) null, (zza) null, zzwj.zznl());
        this.zzdbs.getView().setWillNotDraw(true);
    }

    public final void zza(String str, Map map) {
        zzajr.zza((zzajq) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        zzajr.zzb(this, str, jSONObject);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        zzajr.zza((zzajq) this, str, jSONObject);
    }

    public final void zzi(String str, String str2) {
        zzajr.zza((zzajq) this, str, str2);
    }

    private static void runOnUiThread(Runnable runnable) {
        zzyt.zzpa();
        if (zzazt.zzwy()) {
            runnable.run();
        } else {
            zzaxi.zzdvv.post(runnable);
        }
    }

    public final void zzco(String str) {
        runOnUiThread(new zzajz(this, str));
    }

    public final void zzcl(String str) {
        runOnUiThread(new zzakc(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public final void zzcm(String str) {
        runOnUiThread(new zzakd(this, str));
    }

    public final void zzcn(String str) {
        runOnUiThread(new zzake(this, str));
    }

    public final void zza(String str, zzaho<? super zzalf> zzaho) {
        this.zzdbs.zza(str, (zzaho<? super zzbgz>) new zzakf(this, zzaho));
    }

    public final void zzb(String str, zzaho<? super zzalf> zzaho) {
        this.zzdbs.zza(str, (Predicate<zzaho<? super zzbgz>>) new zzaka(zzaho));
    }

    public final void zza(zzajx zzajx) {
        zzbii zzaai = this.zzdbs.zzaai();
        zzajx.getClass();
        zzaai.zza(zzakb.zzb(zzajx));
    }

    public final zzalg zzru() {
        return new zzalh(this);
    }

    public final void destroy() {
        this.zzdbs.destroy();
    }

    public final boolean isDestroyed() {
        return this.zzdbs.isDestroyed();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzct(String str) {
        this.zzdbs.zzco(str);
    }
}
