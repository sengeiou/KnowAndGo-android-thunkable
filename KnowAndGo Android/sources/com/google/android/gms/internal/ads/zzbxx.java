package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzbxx implements zzbzb {
    private final Clock zzbsa;
    private final zzbai zzbtc;
    private final zzdh zzeko;
    private final zzdae zzffb;
    private final zzbzc zzfgz;
    private final zzcxm zzfig;
    private final zzcxv zzfjp;
    private final JSONObject zzfmo;
    private final zzccj zzfmp;
    private final zzbyt zzfmq;
    /* access modifiers changed from: private */
    public final zzbrt zzfmr;
    /* access modifiers changed from: private */
    public final zzbri zzfms;
    private final zzbmn zzfmt;
    private final zzbzq zzfmu;
    private final zzbva zzfmv;
    private boolean zzfmw = false;
    private boolean zzfmx;
    private boolean zzfmy = false;
    private boolean zzfmz = false;
    private Point zzfna = new Point();
    private Point zzfnb = new Point();
    private long zzfnc = 0;
    private long zzfnd = 0;
    private zzaag zzfne;
    private final Context zzlj;

    public zzbxx(Context context, zzbzc zzbzc, JSONObject jSONObject, zzccj zzccj, zzbyt zzbyt, zzdh zzdh, zzbrt zzbrt, zzbri zzbri, zzcxm zzcxm, zzbai zzbai, zzcxv zzcxv, zzbmn zzbmn, zzbzq zzbzq, Clock clock, zzbva zzbva, zzdae zzdae) {
        this.zzlj = context;
        this.zzfgz = zzbzc;
        this.zzfmo = jSONObject;
        this.zzfmp = zzccj;
        this.zzfmq = zzbyt;
        this.zzeko = zzdh;
        this.zzfmr = zzbrt;
        this.zzfms = zzbri;
        this.zzfig = zzcxm;
        this.zzbtc = zzbai;
        this.zzfjp = zzcxv;
        this.zzfmt = zzbmn;
        this.zzfmu = zzbzq;
        this.zzbsa = clock;
        this.zzfmv = zzbva;
        this.zzffb = zzdae;
    }

    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.zzfna = new Point();
        this.zzfnb = new Point();
        if (!this.zzfmx) {
            this.zzfmv.zzq(view);
            this.zzfmx = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.zzfmt.zzq(this);
        if (map != null) {
            for (Map.Entry<String, WeakReference<View>> value : map.entrySet()) {
                View view2 = (View) ((WeakReference) value.getValue()).get();
                if (view2 != null) {
                    view2.setOnTouchListener(onTouchListener);
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            for (Map.Entry<String, WeakReference<View>> value2 : map2.entrySet()) {
                View view3 = (View) ((WeakReference) value2.getValue()).get();
                if (view3 != null) {
                    view3.setOnTouchListener(onTouchListener);
                    view3.setClickable(false);
                }
            }
        }
    }

    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map) {
        this.zzfna = new Point();
        this.zzfnb = new Point();
        this.zzfmv.zzr(view);
        this.zzfmx = false;
    }

    private final boolean zzfh(String str) {
        JSONObject optJSONObject = this.zzfmo.optJSONObject("allow_pub_event_reporting");
        if (optJSONObject == null || !optJSONObject.optBoolean(str, false)) {
            return false;
        }
        return true;
    }

    public final void zza(View view, @Nullable View view2, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        View view3 = view2;
        Map<String, WeakReference<View>> map3 = map;
        JSONObject zza = zza(map, map2, view2);
        JSONObject zzs = zzs(view2);
        JSONObject zzt = zzt(view2);
        JSONObject zzu = zzu(view2);
        View view4 = view;
        String zzb = zzb(view, map);
        zza(view, zzs, zza, zzt, zzu, zzb, zzfj(zzb), (JSONObject) null, z, false);
    }

    @Nullable
    private final String zzb(@Nullable View view, @Nullable Map<String, WeakReference<View>> map) {
        if (!(map == null || view == null)) {
            for (Map.Entry next : map.entrySet()) {
                if (view.equals((View) ((WeakReference) next.getValue()).get())) {
                    return (String) next.getKey();
                }
            }
        }
        int zzahv = this.zzfmq.zzahv();
        if (zzahv == 6) {
            return "3099";
        }
        switch (zzahv) {
            case 1:
                return "1099";
            case 2:
                return "2099";
            case 3:
                return null;
            default:
                return null;
        }
    }

    public final void zzfi(String str) {
        zza((View) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, str, (JSONObject) null, (JSONObject) null, false, false);
    }

    public final void zzf(@Nullable Bundle bundle) {
        if (bundle == null) {
            zzawz.zzdp("Click data is null. No click is reported.");
        } else if (!zzfh("click_reporting")) {
            zzawz.zzen("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            zza((View) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, bundle2 != null ? bundle2.getString("asset_id") : null, (JSONObject) null, zzk.zzlg().zza(bundle, (JSONObject) null), false, false);
        }
    }

    public final void zza(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzfmz) {
            zzawz.zzdp("Custom click reporting failed. enableCustomClickGesture is not set.");
        } else if (!zzahj()) {
            zzawz.zzdp("Custom click reporting failed. Ad unit id not whitelisted.");
        } else {
            JSONObject zza = zza(map, map2, view);
            JSONObject zzs = zzs(view);
            JSONObject zzt = zzt(view);
            JSONObject zzu = zzu(view);
            String zzb = zzb((View) null, map);
            zza(view, zzs, zza, zzt, zzu, zzb, zzfj(zzb), (JSONObject) null, z, true);
        }
    }

    private final boolean zzahj() {
        return this.zzfmo.optBoolean("allow_custom_click_gesture", false);
    }

    public final void zzro() {
        this.zzfmz = true;
    }

    private final void zza(@Nullable View view, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3, @Nullable JSONObject jSONObject4, @Nullable String str, @Nullable JSONObject jSONObject5, @Nullable JSONObject jSONObject6, boolean z, boolean z2) {
        Preconditions.checkMainThread("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.zzfmo);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            boolean z3 = false;
            jSONObject7.put("has_custom_click_handler", this.zzfgz.zzfo(this.zzfmq.getCustomTemplateId()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put("template", this.zzfmq.zzahv());
            jSONObject8.put("view_aware_api_used", z);
            jSONObject8.put("custom_mute_requested", this.zzfjp.zzdgs != null && this.zzfjp.zzdgs.zzbqh);
            jSONObject8.put("custom_mute_enabled", !this.zzfmq.getMuteThisAdReasons().isEmpty() && this.zzfmq.zzahx() != null);
            if (this.zzfmu.zzaiz() != null && this.zzfmo.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", this.zzbsa.currentTimeMillis());
            if (this.zzfmz && zzahj()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            if (this.zzfgz.zzfo(this.zzfmq.getCustomTemplateId()) != null) {
                z3 = true;
            }
            jSONObject8.put("has_custom_click_handler", z3);
            jSONObject8.put("click_signals", zzv(view));
            jSONObject7.put("click", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long currentTimeMillis = this.zzbsa.currentTimeMillis();
            jSONObject9.put("time_from_last_touch_down", currentTimeMillis - this.zzfnc);
            jSONObject9.put("time_from_last_touch", currentTimeMillis - this.zzfnd);
            jSONObject7.put("touch_signal", jSONObject9);
            zzbao.zza(this.zzfmp.zzc("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e) {
            zzawz.zzc("Unable to create click JSON.", e);
        }
    }

    public final void zza(View view, MotionEvent motionEvent, @Nullable View view2) {
        int[] zzw = zzw(view2);
        this.zzfna = new Point(((int) motionEvent.getRawX()) - zzw[0], ((int) motionEvent.getRawY()) - zzw[1]);
        long currentTimeMillis = this.zzbsa.currentTimeMillis();
        this.zzfnd = currentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.zzfnc = currentTimeMillis;
            this.zzfnb = this.zzfna;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setLocation((float) this.zzfna.x, (float) this.zzfna.y);
        this.zzeko.zza(obtain);
        obtain.recycle();
    }

    public final void zzg(@Nullable Bundle bundle) {
        if (bundle == null) {
            zzawz.zzdp("Touch event data is null. No touch event is reported.");
        } else if (!zzfh("touch_reporting")) {
            zzawz.zzen("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
        } else {
            int i = bundle.getInt("duration_ms");
            this.zzeko.zzcg().zza((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), i);
        }
    }

    public final void zzahk() {
        zza((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null);
    }

    public final void setClickConfirmingView(View view) {
        if (!this.zzfmo.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzawz.zzep("setClickConfirmingView: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzbzq zzbzq = this.zzfmu;
        if (view != null) {
            view.setOnClickListener(zzbzq);
            view.setClickable(true);
            zzbzq.zzfqe = new WeakReference<>(view);
        }
    }

    public final void zza(zzagd zzagd) {
        if (!this.zzfmo.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzawz.zzep("setUnconfirmedClickListener: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
        } else {
            this.zzfmu.zza(zzagd);
        }
    }

    public final void cancelUnconfirmedClick() {
        if (this.zzfmo.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzfmu.cancelUnconfirmedClick();
        }
    }

    public final void zza(@Nullable zzaak zzaak) {
        try {
            if (!this.zzfmy) {
                if (zzaak != null || this.zzfmq.zzahx() == null) {
                    this.zzfmy = true;
                    this.zzffb.zzed(zzaak.zzpt());
                    zzahl();
                    return;
                }
                this.zzfmy = true;
                this.zzffb.zzed(this.zzfmq.zzahx().zzpt());
                zzahl();
            }
        } catch (RemoteException e) {
            zzawz.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzaag zzaag) {
        this.zzfne = zzaag;
    }

    public final void zzahl() {
        try {
            if (this.zzfne != null) {
                this.zzfne.onAdMuted();
            }
        } catch (RemoteException e) {
            zzawz.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        zza(zzs(view), zza(map, map2, view), zzt(view), zzu(view), (JSONObject) null);
    }

    public final void zzahm() {
        Preconditions.checkMainThread("recordDownloadedImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzfmo);
            zzbao.zza(this.zzfmp.zzc("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e) {
            zzbad.zzc("", e);
        }
    }

    public final boolean zzh(Bundle bundle) {
        if (!zzfh("impression_reporting")) {
            zzawz.zzen("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
            return false;
        }
        return zza((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, zzk.zzlg().zza(bundle, (JSONObject) null));
    }

    private final boolean zza(@Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3, @Nullable JSONObject jSONObject4, @Nullable JSONObject jSONObject5) {
        Preconditions.checkMainThread("recordImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.zzfmo);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            this.zzfmp.zza("/logScionEvent", (zzaho<Object>) new zzbxz(this));
            this.zzfmp.zza("/nativeImpression", (zzaho<Object>) new zzbya(this));
            zzbao.zza(this.zzfmp.zzc("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            if (this.zzfmw || this.zzfig.zzgkj == null) {
                return true;
            }
            this.zzfmw |= zzk.zzlq().zzb(this.zzlj, this.zzbtc.zzbsx, this.zzfig.zzgkj.toString(), this.zzfjp.zzglb);
            return true;
        } catch (JSONException e) {
            zzawz.zzc("Unable to create impression JSON.", e);
            return false;
        }
    }

    private final JSONObject zzb(Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", zzdm(rect.right - rect.left));
        jSONObject.put("height", zzdm(rect.bottom - rect.top));
        jSONObject.put("x", zzdm(rect.left));
        jSONObject.put("y", zzdm(rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e5 A[Catch:{ JSONException -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f5 A[Catch:{ JSONException -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0101 A[Catch:{ JSONException -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0104 A[Catch:{ JSONException -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x010b A[Catch:{ JSONException -> 0x0115 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final org.json.JSONObject zzs(@androidx.annotation.Nullable android.view.View r8) {
        /*
            r7 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            if (r8 != 0) goto L_0x0008
            return r0
        L_0x0008:
            r1 = 1
            r2 = 0
            int[] r3 = zzw(r8)     // Catch:{ Exception -> 0x0092 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0092 }
            r4.<init>()     // Catch:{ Exception -> 0x0092 }
            java.lang.String r5 = "width"
            int r6 = r8.getMeasuredWidth()     // Catch:{ Exception -> 0x0092 }
            int r6 = r7.zzdm(r6)     // Catch:{ Exception -> 0x0092 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r5 = "height"
            int r6 = r8.getMeasuredHeight()     // Catch:{ Exception -> 0x0092 }
            int r6 = r7.zzdm(r6)     // Catch:{ Exception -> 0x0092 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r5 = "x"
            r6 = r3[r2]     // Catch:{ Exception -> 0x0092 }
            int r6 = r7.zzdm(r6)     // Catch:{ Exception -> 0x0092 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r5 = "y"
            r6 = r3[r1]     // Catch:{ Exception -> 0x0092 }
            int r6 = r7.zzdm(r6)     // Catch:{ Exception -> 0x0092 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r5 = "relative_to"
            java.lang.String r6 = "window"
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r5 = "frame"
            r0.put(r5, r4)     // Catch:{ Exception -> 0x0092 }
            android.graphics.Rect r4 = new android.graphics.Rect     // Catch:{ Exception -> 0x0092 }
            r4.<init>()     // Catch:{ Exception -> 0x0092 }
            boolean r5 = r8.getGlobalVisibleRect(r4)     // Catch:{ Exception -> 0x0092 }
            if (r5 == 0) goto L_0x005f
            org.json.JSONObject r3 = r7.zzb((android.graphics.Rect) r4)     // Catch:{ Exception -> 0x0092 }
            goto L_0x008c
        L_0x005f:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0092 }
            r4.<init>()     // Catch:{ Exception -> 0x0092 }
            java.lang.String r5 = "width"
            r4.put(r5, r2)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r5 = "height"
            r4.put(r5, r2)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r5 = "x"
            r6 = r3[r2]     // Catch:{ Exception -> 0x0092 }
            int r6 = r7.zzdm(r6)     // Catch:{ Exception -> 0x0092 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r5 = "y"
            r3 = r3[r1]     // Catch:{ Exception -> 0x0092 }
            int r3 = r7.zzdm(r3)     // Catch:{ Exception -> 0x0092 }
            r4.put(r5, r3)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r3 = "relative_to"
            java.lang.String r5 = "window"
            r4.put(r3, r5)     // Catch:{ Exception -> 0x0092 }
            r3 = r4
        L_0x008c:
            java.lang.String r4 = "visible_bounds"
            r0.put(r4, r3)     // Catch:{ Exception -> 0x0092 }
            goto L_0x0097
        L_0x0092:
            java.lang.String r3 = "Unable to get native ad view bounding box"
            com.google.android.gms.internal.ads.zzawz.zzep(r3)
        L_0x0097:
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzacu.zzcww
            com.google.android.gms.internal.ads.zzacr r4 = com.google.android.gms.internal.ads.zzyt.zzpe()
            java.lang.Object r3 = r4.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x011b
            java.lang.String r3 = ""
            android.view.ViewParent r8 = r8.getParent()
            if (r8 == 0) goto L_0x00da
            java.lang.Class r4 = r8.getClass()     // Catch:{ NoSuchMethodException -> 0x00da, SecurityException -> 0x00d4, IllegalAccessException -> 0x00cd, InvocationTargetException -> 0x00c6 }
            java.lang.String r5 = "getTemplateTypeName"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x00da, SecurityException -> 0x00d4, IllegalAccessException -> 0x00cd, InvocationTargetException -> 0x00c6 }
            java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch:{ NoSuchMethodException -> 0x00da, SecurityException -> 0x00d4, IllegalAccessException -> 0x00cd, InvocationTargetException -> 0x00c6 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ NoSuchMethodException -> 0x00da, SecurityException -> 0x00d4, IllegalAccessException -> 0x00cd, InvocationTargetException -> 0x00c6 }
            java.lang.Object r8 = r4.invoke(r8, r5)     // Catch:{ NoSuchMethodException -> 0x00da, SecurityException -> 0x00d4, IllegalAccessException -> 0x00cd, InvocationTargetException -> 0x00c6 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ NoSuchMethodException -> 0x00da, SecurityException -> 0x00d4, IllegalAccessException -> 0x00cd, InvocationTargetException -> 0x00c6 }
            goto L_0x00db
        L_0x00c6:
            r8 = move-exception
            java.lang.String r4 = "Cannot access method getTemplateTypeName: "
            com.google.android.gms.internal.ads.zzawz.zzc(r4, r8)
            goto L_0x00da
        L_0x00cd:
            r8 = move-exception
            java.lang.String r4 = "Cannot access method getTemplateTypeName: "
            com.google.android.gms.internal.ads.zzawz.zzc(r4, r8)
            goto L_0x00da
        L_0x00d4:
            r8 = move-exception
            java.lang.String r4 = "Cannot access method getTemplateTypeName: "
            com.google.android.gms.internal.ads.zzawz.zzc(r4, r8)
        L_0x00da:
            r8 = r3
        L_0x00db:
            r3 = -1
            int r4 = r8.hashCode()     // Catch:{ JSONException -> 0x0115 }
            r5 = -2066603854(0xffffffff84d220b2, float:-4.940079E-36)
            if (r4 == r5) goto L_0x00f5
            r5 = 2019754500(0x78630204, float:1.8417067E34)
            if (r4 == r5) goto L_0x00eb
            goto L_0x00fe
        L_0x00eb:
            java.lang.String r4 = "medium_template"
            boolean r8 = r8.equals(r4)     // Catch:{ JSONException -> 0x0115 }
            if (r8 == 0) goto L_0x00fe
            r3 = 1
            goto L_0x00fe
        L_0x00f5:
            java.lang.String r4 = "small_template"
            boolean r8 = r8.equals(r4)     // Catch:{ JSONException -> 0x0115 }
            if (r8 == 0) goto L_0x00fe
            r3 = 0
        L_0x00fe:
            switch(r3) {
                case 0: goto L_0x010b;
                case 1: goto L_0x0104;
                default: goto L_0x0101;
            }     // Catch:{ JSONException -> 0x0115 }
        L_0x0101:
            java.lang.String r8 = "native_template_type"
            goto L_0x0111
        L_0x0104:
            java.lang.String r8 = "native_template_type"
            r1 = 2
            r0.put(r8, r1)     // Catch:{ JSONException -> 0x0115 }
            goto L_0x011b
        L_0x010b:
            java.lang.String r8 = "native_template_type"
            r0.put(r8, r1)     // Catch:{ JSONException -> 0x0115 }
            goto L_0x011b
        L_0x0111:
            r0.put(r8, r2)     // Catch:{ JSONException -> 0x0115 }
            goto L_0x011b
        L_0x0115:
            r8 = move-exception
            java.lang.String r1 = "Could not log native template signal to JSON"
            com.google.android.gms.internal.ads.zzawz.zzc(r1, r8)
        L_0x011b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbxx.zzs(android.view.View):org.json.JSONObject");
    }

    private static JSONObject zzt(@Nullable View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            zzk.zzlg();
            jSONObject.put("contained_in_scroll_view", zzaxi.zzp(view) != -1);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private final JSONObject zzu(@Nullable View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            zzk.zzlg();
            jSONObject.put("can_show_on_lock_screen", zzaxi.zzo(view));
            zzk.zzlg();
            jSONObject.put("is_keyguard_locked", zzaxi.zzat(this.zzlj));
        } catch (JSONException unused) {
            zzawz.zzep("Unable to get lock screen information");
        }
        return jSONObject;
    }

    private final JSONObject zza(@Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, @Nullable View view) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (map == null || view == null) {
            return jSONObject2;
        }
        int[] zzw = zzw(view);
        for (Map.Entry next : map.entrySet()) {
            View view2 = (View) ((WeakReference) next.getValue()).get();
            if (view2 != null) {
                int[] zzw2 = zzw(view2);
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put("width", zzdm(view2.getMeasuredWidth()));
                    jSONObject4.put("height", zzdm(view2.getMeasuredHeight()));
                    boolean z = false;
                    jSONObject4.put("x", zzdm(zzw2[0] - zzw[0]));
                    jSONObject4.put("y", zzdm(zzw2[1] - zzw[1]));
                    jSONObject4.put("relative_to", "ad_view");
                    jSONObject3.put("frame", jSONObject4);
                    Rect rect = new Rect();
                    if (view2.getLocalVisibleRect(rect)) {
                        jSONObject = zzb(rect);
                    } else {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("width", 0);
                        jSONObject5.put("height", 0);
                        jSONObject5.put("x", zzdm(zzw2[0] - zzw[0]));
                        jSONObject5.put("y", zzdm(zzw2[1] - zzw[1]));
                        jSONObject5.put("relative_to", "ad_view");
                        jSONObject = jSONObject5;
                    }
                    jSONObject3.put("visible_bounds", jSONObject);
                    if (view2 instanceof TextView) {
                        TextView textView = (TextView) view2;
                        jSONObject3.put("text_color", textView.getCurrentTextColor());
                        jSONObject3.put("font_size", (double) textView.getTextSize());
                        jSONObject3.put("text", textView.getText());
                    }
                    if (map2 != null && map2.containsKey(next.getKey()) && view2.isClickable()) {
                        z = true;
                    }
                    jSONObject3.put("is_clickable", z);
                    jSONObject2.put((String) next.getKey(), jSONObject3);
                } catch (JSONException unused) {
                    zzawz.zzep("Unable to get asset views information");
                }
            }
        }
        return jSONObject2;
    }

    private final String zzv(View view) {
        try {
            JSONObject optJSONObject = this.zzfmo.optJSONObject("tracking_urls_and_actions");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            return this.zzeko.zzcg().zza(this.zzlj, optJSONObject.optString("click_string"), view);
        } catch (Exception e) {
            zzawz.zzc("Exception obtaining click signals", e);
            return null;
        }
    }

    private final JSONObject zzfj(@Nullable String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("click_point", zzahn());
                jSONObject.put("asset_id", str);
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            jSONObject = null;
            zzawz.zzc("Error occurred while grabbing click signals.", e);
            return jSONObject;
        }
        return jSONObject;
    }

    @Nullable
    private final JSONObject zzahn() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", zzdm(this.zzfna.x));
            jSONObject.put("y", zzdm(this.zzfna.y));
            jSONObject.put("start_x", zzdm(this.zzfnb.x));
            jSONObject.put("start_y", zzdm(this.zzfnb.y));
            return jSONObject;
        } catch (JSONException e) {
            zzawz.zzc("Error occurred while putting signals into JSON object.", e);
            return null;
        }
    }

    private static int[] zzw(@Nullable View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    private final int zzdm(int i) {
        return zzyt.zzpa().zzb(this.zzlj, i);
    }

    public final void destroy() {
        this.zzfmp.destroy();
    }
}
