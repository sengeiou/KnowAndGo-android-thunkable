package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;
import p022fi.iki.elonen.NanoHTTPD;

@ParametersAreNonnullByDefault
@zzard
public final class zzajj extends zzaju<zzalf> implements zzajq, zzajw {
    private final zzbjb zzdbh;
    /* access modifiers changed from: private */
    public zzajx zzdbi;

    public zzajj(Context context, zzbai zzbai) throws zzbhj {
        try {
            this.zzdbh = new zzbjb(context, new zzajp(this));
            this.zzdbh.setWillNotDraw(true);
            this.zzdbh.addJavascriptInterface(new zzajo(this), "GoogleJsInterface");
            zzk.zzlg().zza(context, zzbai.zzbsx, this.zzdbh.getSettings());
            super.zzg(this);
        } catch (Throwable th) {
            throw new zzbhj("Init failed.", th);
        }
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

    public final void zzcl(String str) {
        zzcm(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", new Object[]{str}));
    }

    public final void zzcm(String str) {
        zzbbm.zzeae.execute(new zzajk(this, str));
    }

    public final void zzcn(String str) {
        zzbbm.zzeae.execute(new zzajl(this, str));
    }

    public final void zza(zzajx zzajx) {
        this.zzdbi = zzajx;
    }

    public final void destroy() {
        this.zzdbh.destroy();
    }

    public final boolean isDestroyed() {
        return this.zzdbh.isDestroyed();
    }

    public final zzalg zzru() {
        return new zzalh(this);
    }

    public final void zzco(String str) {
        zzbbm.zzeae.execute(new zzajm(this, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzcp(String str) {
        this.zzdbh.zzco(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzcq(String str) {
        this.zzdbh.loadUrl(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzcr(String str) {
        this.zzdbh.loadData(str, NanoHTTPD.MIME_HTML, "UTF-8");
    }
}
