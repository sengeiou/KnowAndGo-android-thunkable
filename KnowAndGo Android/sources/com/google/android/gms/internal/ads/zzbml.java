package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.ads.internal.zzk;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbml implements zzalm<zzbmp> {
    private final zzty zzffp;
    private final Context zzlj;
    private final PowerManager zzyt;

    public zzbml(Context context, zzty zzty) {
        this.zzlj = context;
        this.zzffp = zzty;
        this.zzyt = (PowerManager) context.getSystemService("power");
    }

    /* renamed from: zza */
    public final JSONObject zzj(zzbmp zzbmp) throws JSONException {
        JSONObject jSONObject;
        boolean z;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        if (zzbmp.zzfge == null) {
            jSONObject = new JSONObject();
        } else {
            zzud zzud = zzbmp.zzfge;
            if (this.zzffp.zzmh() != null) {
                boolean z2 = zzud.zzbtp;
                JSONObject jSONObject3 = new JSONObject();
                JSONObject put = jSONObject3.put("afmaVersion", this.zzffp.zzmg()).put("activeViewJSON", this.zzffp.zzmh()).put("timestamp", zzbmp.timestamp).put("adFormat", this.zzffp.zzmf()).put("hashCode", this.zzffp.zzmi());
                zzty zzty = this.zzffp;
                JSONObject put2 = put.put("isMraid", false).put("isStopped", false).put("isPaused", zzbmp.zzfgb).put("isNative", this.zzffp.zzmj());
                if (Build.VERSION.SDK_INT >= 20) {
                    z = this.zzyt.isInteractive();
                } else {
                    z = this.zzyt.isScreenOn();
                }
                put2.put("isScreenOn", z).put("appMuted", zzk.zzll().zzpr()).put("appVolume", (double) zzk.zzll().zzpq()).put("deviceVolume", (double) zzaya.zzba(this.zzlj.getApplicationContext()));
                Rect rect = new Rect();
                Display defaultDisplay = ((WindowManager) this.zzlj.getSystemService("window")).getDefaultDisplay();
                rect.right = defaultDisplay.getWidth();
                rect.bottom = defaultDisplay.getHeight();
                jSONObject3.put("windowVisibility", zzud.zzza).put("isAttachedToWindow", z2).put("viewBox", new JSONObject().put(ViewProps.TOP, zzud.zzbtq.top).put(ViewProps.BOTTOM, zzud.zzbtq.bottom).put("left", zzud.zzbtq.left).put("right", zzud.zzbtq.right)).put("adBox", new JSONObject().put(ViewProps.TOP, zzud.zzbtr.top).put(ViewProps.BOTTOM, zzud.zzbtr.bottom).put("left", zzud.zzbtr.left).put("right", zzud.zzbtr.right)).put("globalVisibleBox", new JSONObject().put(ViewProps.TOP, zzud.zzbts.top).put(ViewProps.BOTTOM, zzud.zzbts.bottom).put("left", zzud.zzbts.left).put("right", zzud.zzbts.right)).put("globalVisibleBoxVisible", zzud.zzbtt).put("localVisibleBox", new JSONObject().put(ViewProps.TOP, zzud.zzbtu.top).put(ViewProps.BOTTOM, zzud.zzbtu.bottom).put("left", zzud.zzbtu.left).put("right", zzud.zzbtu.right)).put("localVisibleBoxVisible", zzud.zzbtv).put("hitBox", new JSONObject().put(ViewProps.TOP, zzud.zzbtw.top).put(ViewProps.BOTTOM, zzud.zzbtw.bottom).put("left", zzud.zzbtw.left).put("right", zzud.zzbtw.right)).put("screenDensity", (double) this.zzlj.getResources().getDisplayMetrics().density);
                jSONObject3.put("isVisible", zzbmp.zzbtk);
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcql)).booleanValue()) {
                    JSONArray jSONArray2 = new JSONArray();
                    if (zzud.zzbty != null) {
                        for (Rect next : zzud.zzbty) {
                            jSONArray2.put(new JSONObject().put(ViewProps.TOP, next.top).put(ViewProps.BOTTOM, next.bottom).put("left", next.left).put("right", next.right));
                        }
                    }
                    jSONObject3.put("scrollableContainerBoxes", jSONArray2);
                }
                if (!TextUtils.isEmpty(zzbmp.zzfgd)) {
                    jSONObject3.put("doneReasonCode", "u");
                }
                jSONObject = jSONObject3;
            } else {
                throw new JSONException("Active view Info cannot be null.");
            }
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
