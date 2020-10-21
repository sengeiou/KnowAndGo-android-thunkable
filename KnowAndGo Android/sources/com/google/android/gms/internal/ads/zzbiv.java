package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzwl;
import com.google.android.gms.internal.ads.zzwt;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;
import p022fi.iki.elonen.NanoHTTPD;

@ParametersAreNonnullByDefault
@VisibleForTesting
@zzard
final class zzbiv extends zzbjb implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzajq, zzbgz {
    private int maxHeight = -1;
    private int maxWidth = -1;
    @GuardedBy("this")
    private String zzaap;
    private final zzbai zzbtc;
    private final WindowManager zzbtf;
    @GuardedBy("this")
    private boolean zzdko;
    private int zzdlt = -1;
    private int zzdlu = -1;
    @GuardedBy("this")
    private String zzdlx = "";
    private zzadg zzeem;
    private final zzwj zzejd;
    private final zzbim zzekn;
    @Nullable
    private final zzdh zzeko;
    private final zzj zzekp;
    private final zza zzekq;
    @GuardedBy("this")
    private zzd zzekv;
    @GuardedBy("this")
    private zzbin zzekx;
    @GuardedBy("this")
    private boolean zzekz;
    @GuardedBy("this")
    private boolean zzela;
    @GuardedBy("this")
    private int zzelb;
    @GuardedBy("this")
    private boolean zzelc = true;
    @GuardedBy("this")
    private boolean zzeld = false;
    @GuardedBy("this")
    private zzbhq zzele;
    @GuardedBy("this")
    private boolean zzelf;
    @GuardedBy("this")
    private boolean zzelg;
    @GuardedBy("this")
    private zzadx zzelh;
    @GuardedBy("this")
    private zzadv zzeli;
    @GuardedBy("this")
    private int zzelj;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public int zzelk;
    private zzadg zzell;
    private zzadg zzelm;
    private zzadh zzeln;
    private WeakReference<View.OnClickListener> zzelo;
    @GuardedBy("this")
    private zzd zzelp;
    private zzazs zzelr;
    private Map<String, zzbft> zzels;
    private final zzbio zzemn;
    private final AtomicReference<IObjectWrapper> zzemo = new AtomicReference<>();
    private final DisplayMetrics zzwb;

    @VisibleForTesting
    protected zzbiv(zzbim zzbim, zzbio zzbio, zzbin zzbin, String str, boolean z, boolean z2, @Nullable zzdh zzdh, zzbai zzbai, zzadi zzadi, zzj zzj, zza zza, zzwj zzwj) {
        super(zzbim, zzbio);
        this.zzekn = zzbim;
        this.zzemn = zzbio;
        this.zzekx = zzbin;
        this.zzaap = str;
        this.zzekz = z;
        this.zzelb = -1;
        this.zzeko = zzdh;
        this.zzbtc = zzbai;
        this.zzekp = zzj;
        this.zzekq = zza;
        this.zzbtf = (WindowManager) getContext().getSystemService("window");
        zzk.zzlg();
        this.zzwb = zzaxi.zza(this.zzbtf);
        this.zzejd = zzwj;
        this.zzelr = new zzazs(this.zzekn.zzyd(), this, this, (ViewTreeObserver.OnScrollChangedListener) null);
        zzk.zzlg().zza((Context) zzbim, zzbai.zzbsx, getSettings());
        setDownloadListener(this);
        zzabn();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(zzbht.zzc(this), "googleAdsJsInterface");
        }
        zzabr();
        this.zzeln = new zzadh(new zzadi(true, "make_wv", this.zzaap));
        this.zzeln.zzqw().zzc(zzadi);
        this.zzeem = zzadb.zzb(this.zzeln.zzqw());
        this.zzeln.zza("native:view_create", this.zzeem);
        this.zzelm = null;
        this.zzell = null;
        zzk.zzli().zzay(zzbim);
    }

    public final View getView() {
        return this;
    }

    public final WebView getWebView() {
        return this;
    }

    public final void zza(String str, Map map) {
        zzajr.zza((zzajq) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        zzajr.zzb(this, str, jSONObject);
    }

    public final void zzaao() {
    }

    public final boolean zzaaw() {
        return false;
    }

    public final void zzb(String str, JSONObject jSONObject) {
        zzajr.zza((zzajq) this, str, jSONObject);
    }

    public final void zzi(String str, String str2) {
        zzajr.zza((zzajq) this, str, str2);
    }

    public final zzbcw zzya() {
        return null;
    }

    public final zza zzye() {
        return this.zzekq;
    }

    private final boolean zzabk() {
        int i;
        int i2;
        boolean z = false;
        if (!this.zzemn.zzaay() && !this.zzemn.zzaaz()) {
            return false;
        }
        zzyt.zzpa();
        int zzb = zzazt.zzb(this.zzwb, this.zzwb.widthPixels);
        zzyt.zzpa();
        int zzb2 = zzazt.zzb(this.zzwb, this.zzwb.heightPixels);
        Activity zzyd = this.zzekn.zzyd();
        if (zzyd == null || zzyd.getWindow() == null) {
            i2 = zzb;
            i = zzb2;
        } else {
            zzk.zzlg();
            int[] zzd = zzaxi.zzd(zzyd);
            zzyt.zzpa();
            int zzb3 = zzazt.zzb(this.zzwb, zzd[0]);
            zzyt.zzpa();
            i = zzazt.zzb(this.zzwb, zzd[1]);
            i2 = zzb3;
        }
        if (this.zzdlt == zzb && this.zzdlu == zzb2 && this.maxWidth == i2 && this.maxHeight == i) {
            return false;
        }
        if (!(this.zzdlt == zzb && this.zzdlu == zzb2)) {
            z = true;
        }
        this.zzdlt = zzb;
        this.zzdlu = zzb2;
        this.maxWidth = i2;
        this.maxHeight = i;
        new zzaqb(this).zza(zzb, zzb2, i2, i, this.zzwb.density, this.zzbtf.getDefaultDisplay().getRotation());
        return z;
    }

    public final synchronized void zzb(String str, String str2, @Nullable String str3) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcok)).booleanValue()) {
            str2 = zzbid.zzf(str2, zzbid.zzabt());
        }
        super.loadDataWithBaseURL(str, str2, NanoHTTPD.MIME_HTML, "UTF-8", str3);
    }

    public final synchronized void zzco(String str) {
        if (!isDestroyed()) {
            super.zzco(str);
        } else {
            zzawz.zzep("The webview is destroyed. Ignoring action.");
        }
    }

    public final void zzaab() {
        zzabm();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzbtc.zzbsx);
        zzajr.zza((zzajq) this, "onhide", (Map) hashMap);
    }

    public final void zzdi(int i) {
        if (i == 0) {
            zzadb.zza(this.zzeln.zzqw(), this.zzeem, "aebb2");
        }
        zzabm();
        if (this.zzeln.zzqw() != null) {
            this.zzeln.zzqw().zzh("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zzbtc.zzbsx);
        zzajr.zza((zzajq) this, "onhide", (Map) hashMap);
    }

    private final void zzabm() {
        zzadb.zza(this.zzeln.zzqw(), this.zzeem, "aeh2");
    }

    public final void zztl() {
        if (this.zzell == null) {
            zzadb.zza(this.zzeln.zzqw(), this.zzeem, "aes2");
            this.zzell = zzadb.zzb(this.zzeln.zzqw());
            this.zzeln.zza("native:view_show", this.zzell);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzbtc.zzbsx);
        zzajr.zza((zzajq) this, "onshow", (Map) hashMap);
    }

    public final void zzaac() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzk.zzll().zzpr()));
        hashMap.put("app_volume", String.valueOf(zzk.zzll().zzpq()));
        hashMap.put("device_volume", String.valueOf(zzaya.zzba(getContext())));
        zzajr.zza((zzajq) this, "volume", (Map) hashMap);
    }

    public final void zza(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("success", z ? "1" : "0");
        hashMap.put("duration", Long.toString(j));
        zzajr.zza((zzajq) this, "onCacheAccessComplete", (Map) hashMap);
    }

    public final synchronized zzd zzaae() {
        return this.zzekv;
    }

    public final IObjectWrapper zzaam() {
        return this.zzemo.get();
    }

    public final synchronized zzd zzaaf() {
        return this.zzelp;
    }

    public final synchronized zzbin zzaag() {
        return this.zzekx;
    }

    public final synchronized String zzaah() {
        return this.zzaap;
    }

    public final WebViewClient zzaaj() {
        return this.zzemn;
    }

    public final synchronized boolean zzaak() {
        return this.zzdko;
    }

    public final zzdh zzaal() {
        return this.zzeko;
    }

    public final zzbai zzyh() {
        return this.zzbtc;
    }

    public final synchronized boolean zzaan() {
        return this.zzekz;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzk.zzlg();
            zzaxi.zza(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            zzawz.zzdp(sb.toString());
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zzemn.zzaaz()) {
            synchronized (this) {
                if (this.zzelh != null) {
                    this.zzelh.zzc(motionEvent);
                }
            }
        } else if (this.zzeko != null) {
            this.zzeko.zza(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01d8 A[SYNTHETIC, Splitter:B:109:0x01d8] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0141  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:64:0x00de=Splitter:B:64:0x00de, B:116:0x01ee=Splitter:B:116:0x01ee} */
    @android.annotation.SuppressLint({"DrawAllocation"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.isDestroyed()     // Catch:{ all -> 0x01f3 }
            r1 = 0
            if (r0 == 0) goto L_0x000d
            r7.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x000d:
            boolean r0 = r7.isInEditMode()     // Catch:{ all -> 0x01f3 }
            if (r0 != 0) goto L_0x01ee
            boolean r0 = r7.zzekz     // Catch:{ all -> 0x01f3 }
            if (r0 != 0) goto L_0x01ee
            com.google.android.gms.internal.ads.zzbin r0 = r7.zzekx     // Catch:{ all -> 0x01f3 }
            boolean r0 = r0.zzaby()     // Catch:{ all -> 0x01f3 }
            if (r0 == 0) goto L_0x0021
            goto L_0x01ee
        L_0x0021:
            com.google.android.gms.internal.ads.zzbin r0 = r7.zzekx     // Catch:{ all -> 0x01f3 }
            boolean r0 = r0.zzaca()     // Catch:{ all -> 0x01f3 }
            if (r0 == 0) goto L_0x002e
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x002e:
            com.google.android.gms.internal.ads.zzbin r0 = r7.zzekx     // Catch:{ all -> 0x01f3 }
            boolean r0 = r0.zzabz()     // Catch:{ all -> 0x01f3 }
            if (r0 == 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzacu.zzcsk     // Catch:{ all -> 0x01f3 }
            com.google.android.gms.internal.ads.zzacr r1 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ all -> 0x01f3 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x01f3 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01f3 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01f3 }
            if (r0 == 0) goto L_0x004d
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x004d:
            com.google.android.gms.internal.ads.zzbhq r0 = r7.zzyb()     // Catch:{ all -> 0x01f3 }
            r1 = 0
            if (r0 == 0) goto L_0x0059
            float r0 = r0.getAspectRatio()     // Catch:{ all -> 0x01f3 }
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0063
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x0063:
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x01f3 }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01f3 }
            float r1 = (float) r9     // Catch:{ all -> 0x01f3 }
            float r1 = r1 * r0
            int r1 = (int) r1     // Catch:{ all -> 0x01f3 }
            float r2 = (float) r8     // Catch:{ all -> 0x01f3 }
            float r2 = r2 / r0
            int r2 = (int) r2     // Catch:{ all -> 0x01f3 }
            if (r9 != 0) goto L_0x007c
            if (r2 == 0) goto L_0x007c
            float r9 = (float) r2     // Catch:{ all -> 0x01f3 }
            float r9 = r9 * r0
            int r1 = (int) r9     // Catch:{ all -> 0x01f3 }
            r9 = r2
            goto L_0x0084
        L_0x007c:
            if (r8 != 0) goto L_0x0084
            if (r1 == 0) goto L_0x0084
            float r8 = (float) r1     // Catch:{ all -> 0x01f3 }
            float r8 = r8 / r0
            int r2 = (int) r8     // Catch:{ all -> 0x01f3 }
            r8 = r1
        L_0x0084:
            int r8 = java.lang.Math.min(r1, r8)     // Catch:{ all -> 0x01f3 }
            int r9 = java.lang.Math.min(r2, r9)     // Catch:{ all -> 0x01f3 }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x0091:
            com.google.android.gms.internal.ads.zzbin r0 = r7.zzekx     // Catch:{ all -> 0x01f3 }
            boolean r0 = r0.isFluid()     // Catch:{ all -> 0x01f3 }
            if (r0 == 0) goto L_0x00e3
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzacu.zzcsn     // Catch:{ all -> 0x01f3 }
            com.google.android.gms.internal.ads.zzacr r1 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ all -> 0x01f3 }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x01f3 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01f3 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01f3 }
            if (r0 != 0) goto L_0x00de
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR1()     // Catch:{ all -> 0x01f3 }
            if (r0 != 0) goto L_0x00b2
            goto L_0x00de
        L_0x00b2:
            java.lang.String r0 = "/contentHeight"
            com.google.android.gms.internal.ads.zzbix r1 = new com.google.android.gms.internal.ads.zzbix     // Catch:{ all -> 0x01f3 }
            r1.<init>(r7)     // Catch:{ all -> 0x01f3 }
            r7.zza((java.lang.String) r0, (com.google.android.gms.internal.ads.zzaho<? super com.google.android.gms.internal.ads.zzbgz>) r1)     // Catch:{ all -> 0x01f3 }
            java.lang.String r0 = "(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();"
            r7.zzco(r0)     // Catch:{ all -> 0x01f3 }
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x01f3 }
            int r0 = r7.zzelk     // Catch:{ all -> 0x01f3 }
            r1 = -1
            if (r0 == r1) goto L_0x00d5
            int r9 = r7.zzelk     // Catch:{ all -> 0x01f3 }
            float r9 = (float) r9     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r0 = r7.zzwb     // Catch:{ all -> 0x01f3 }
            float r0 = r0.density     // Catch:{ all -> 0x01f3 }
            float r9 = r9 * r0
            int r9 = (int) r9     // Catch:{ all -> 0x01f3 }
            goto L_0x00d9
        L_0x00d5:
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01f3 }
        L_0x00d9:
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x00de:
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x00e3:
            com.google.android.gms.internal.ads.zzbin r0 = r7.zzekx     // Catch:{ all -> 0x01f3 }
            boolean r0 = r0.zzabx()     // Catch:{ all -> 0x01f3 }
            if (r0 == 0) goto L_0x00f8
            android.util.DisplayMetrics r8 = r7.zzwb     // Catch:{ all -> 0x01f3 }
            int r8 = r8.widthPixels     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r9 = r7.zzwb     // Catch:{ all -> 0x01f3 }
            int r9 = r9.heightPixels     // Catch:{ all -> 0x01f3 }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x00f8:
            int r0 = android.view.View.MeasureSpec.getMode(r8)     // Catch:{ all -> 0x01f3 }
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x01f3 }
            int r2 = android.view.View.MeasureSpec.getMode(r9)     // Catch:{ all -> 0x01f3 }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01f3 }
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r4) goto L_0x0118
            if (r0 != r3) goto L_0x0114
            goto L_0x0118
        L_0x0114:
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0119
        L_0x0118:
            r0 = r8
        L_0x0119:
            if (r2 == r4) goto L_0x011d
            if (r2 != r3) goto L_0x011e
        L_0x011d:
            r5 = r9
        L_0x011e:
            com.google.android.gms.internal.ads.zzbin r2 = r7.zzekx     // Catch:{ all -> 0x01f3 }
            int r2 = r2.widthPixels     // Catch:{ all -> 0x01f3 }
            r3 = 1
            if (r2 > r0) goto L_0x012e
            com.google.android.gms.internal.ads.zzbin r2 = r7.zzekx     // Catch:{ all -> 0x01f3 }
            int r2 = r2.heightPixels     // Catch:{ all -> 0x01f3 }
            if (r2 <= r5) goto L_0x012c
            goto L_0x012e
        L_0x012c:
            r2 = 0
            goto L_0x012f
        L_0x012e:
            r2 = 1
        L_0x012f:
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zzacu.zzcvg     // Catch:{ all -> 0x01f3 }
            com.google.android.gms.internal.ads.zzacr r6 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ all -> 0x01f3 }
            java.lang.Object r4 = r6.zzd(r4)     // Catch:{ all -> 0x01f3 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x01f3 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x01f3 }
            if (r4 == 0) goto L_0x016e
            com.google.android.gms.internal.ads.zzbin r4 = r7.zzekx     // Catch:{ all -> 0x01f3 }
            int r4 = r4.widthPixels     // Catch:{ all -> 0x01f3 }
            float r4 = (float) r4     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r6 = r7.zzwb     // Catch:{ all -> 0x01f3 }
            float r6 = r6.density     // Catch:{ all -> 0x01f3 }
            float r4 = r4 / r6
            float r0 = (float) r0     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r6 = r7.zzwb     // Catch:{ all -> 0x01f3 }
            float r6 = r6.density     // Catch:{ all -> 0x01f3 }
            float r0 = r0 / r6
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x016a
            com.google.android.gms.internal.ads.zzbin r0 = r7.zzekx     // Catch:{ all -> 0x01f3 }
            int r0 = r0.heightPixels     // Catch:{ all -> 0x01f3 }
            float r0 = (float) r0     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r4 = r7.zzwb     // Catch:{ all -> 0x01f3 }
            float r4 = r4.density     // Catch:{ all -> 0x01f3 }
            float r0 = r0 / r4
            float r4 = (float) r5     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r5 = r7.zzwb     // Catch:{ all -> 0x01f3 }
            float r5 = r5.density     // Catch:{ all -> 0x01f3 }
            float r4 = r4 / r5
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x016a
            goto L_0x016b
        L_0x016a:
            r3 = 0
        L_0x016b:
            if (r2 == 0) goto L_0x016e
            r2 = r3
        L_0x016e:
            r0 = 8
            if (r2 == 0) goto L_0x01d8
            com.google.android.gms.internal.ads.zzbin r2 = r7.zzekx     // Catch:{ all -> 0x01f3 }
            int r2 = r2.widthPixels     // Catch:{ all -> 0x01f3 }
            float r2 = (float) r2     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r3 = r7.zzwb     // Catch:{ all -> 0x01f3 }
            float r3 = r3.density     // Catch:{ all -> 0x01f3 }
            float r2 = r2 / r3
            int r2 = (int) r2     // Catch:{ all -> 0x01f3 }
            com.google.android.gms.internal.ads.zzbin r3 = r7.zzekx     // Catch:{ all -> 0x01f3 }
            int r3 = r3.heightPixels     // Catch:{ all -> 0x01f3 }
            float r3 = (float) r3     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r4 = r7.zzwb     // Catch:{ all -> 0x01f3 }
            float r4 = r4.density     // Catch:{ all -> 0x01f3 }
            float r3 = r3 / r4
            int r3 = (int) r3     // Catch:{ all -> 0x01f3 }
            float r8 = (float) r8     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r4 = r7.zzwb     // Catch:{ all -> 0x01f3 }
            float r4 = r4.density     // Catch:{ all -> 0x01f3 }
            float r8 = r8 / r4
            int r8 = (int) r8     // Catch:{ all -> 0x01f3 }
            float r9 = (float) r9     // Catch:{ all -> 0x01f3 }
            android.util.DisplayMetrics r4 = r7.zzwb     // Catch:{ all -> 0x01f3 }
            float r4 = r4.density     // Catch:{ all -> 0x01f3 }
            float r9 = r9 / r4
            int r9 = (int) r9     // Catch:{ all -> 0x01f3 }
            r4 = 103(0x67, float:1.44E-43)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01f3 }
            r5.<init>(r4)     // Catch:{ all -> 0x01f3 }
            java.lang.String r4 = "Not enough space to show ad. Needs "
            r5.append(r4)     // Catch:{ all -> 0x01f3 }
            r5.append(r2)     // Catch:{ all -> 0x01f3 }
            java.lang.String r2 = "x"
            r5.append(r2)     // Catch:{ all -> 0x01f3 }
            r5.append(r3)     // Catch:{ all -> 0x01f3 }
            java.lang.String r2 = " dp, but only has "
            r5.append(r2)     // Catch:{ all -> 0x01f3 }
            r5.append(r8)     // Catch:{ all -> 0x01f3 }
            java.lang.String r8 = "x"
            r5.append(r8)     // Catch:{ all -> 0x01f3 }
            r5.append(r9)     // Catch:{ all -> 0x01f3 }
            java.lang.String r8 = " dp."
            r5.append(r8)     // Catch:{ all -> 0x01f3 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x01f3 }
            com.google.android.gms.internal.ads.zzawz.zzep(r8)     // Catch:{ all -> 0x01f3 }
            int r8 = r7.getVisibility()     // Catch:{ all -> 0x01f3 }
            if (r8 == r0) goto L_0x01d3
            r8 = 4
            r7.setVisibility(r8)     // Catch:{ all -> 0x01f3 }
        L_0x01d3:
            r7.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x01d8:
            int r8 = r7.getVisibility()     // Catch:{ all -> 0x01f3 }
            if (r8 == r0) goto L_0x01e1
            r7.setVisibility(r1)     // Catch:{ all -> 0x01f3 }
        L_0x01e1:
            com.google.android.gms.internal.ads.zzbin r8 = r7.zzekx     // Catch:{ all -> 0x01f3 }
            int r8 = r8.widthPixels     // Catch:{ all -> 0x01f3 }
            com.google.android.gms.internal.ads.zzbin r9 = r7.zzekx     // Catch:{ all -> 0x01f3 }
            int r9 = r9.heightPixels     // Catch:{ all -> 0x01f3 }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x01ee:
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01f3 }
            monitor-exit(r7)
            return
        L_0x01f3:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbiv.onMeasure(int, int):void");
    }

    public final void onGlobalLayout() {
        boolean zzabk = zzabk();
        zzd zzaae = zzaae();
        if (zzaae != null && zzabk) {
            zzaae.zztk();
        }
    }

    public final synchronized void zza(zzd zzd) {
        this.zzekv = zzd;
    }

    public final void zzam(IObjectWrapper iObjectWrapper) {
        this.zzemo.set(iObjectWrapper);
    }

    public final synchronized void zzb(zzd zzd) {
        this.zzelp = zzd;
    }

    public final synchronized void zza(zzbin zzbin) {
        this.zzekx = zzbin;
        requestLayout();
    }

    public final synchronized void zzaq(boolean z) {
        boolean z2 = z != this.zzekz;
        this.zzekz = z;
        zzabn();
        if (z2) {
            new zzaqb(this).zzdj(z ? "expanded" : "default");
        }
    }

    public final void zzaar() {
        this.zzelr.zzwt();
    }

    /* access modifiers changed from: protected */
    public final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.zzelr.onAttachedToWindow();
        }
        boolean z = this.zzelf;
        if (this.zzemn != null && this.zzemn.zzaaz()) {
            if (!this.zzelg) {
                this.zzemn.zzaba();
                this.zzemn.zzabb();
                this.zzelg = true;
            }
            zzabk();
            z = true;
        }
        zzav(z);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        synchronized (this) {
            if (!isDestroyed()) {
                this.zzelr.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.zzelg && this.zzemn != null && this.zzemn.zzaaz() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzemn.zzaba();
                this.zzemn.zzabb();
                this.zzelg = false;
            }
        }
        zzav(false);
    }

    public final void zzbn(Context context) {
        this.zzekn.setBaseContext(context);
        this.zzelr.zzh(this.zzekn.zzyd());
    }

    public final synchronized void zzaf(boolean z) {
        if (this.zzekv != null) {
            this.zzekv.zza(this.zzemn.zzaay(), z);
        } else {
            this.zzdko = z;
        }
    }

    public final synchronized void setRequestedOrientation(int i) {
        this.zzelb = i;
        if (this.zzekv != null) {
            this.zzekv.setRequestedOrientation(this.zzelb);
        }
    }

    public final Activity zzyd() {
        return this.zzekn.zzyd();
    }

    public final Context zzaad() {
        return this.zzekn.zzaad();
    }

    private final synchronized void zzabn() {
        if (!this.zzekz) {
            if (!this.zzekx.zzabx()) {
                if (Build.VERSION.SDK_INT < 18) {
                    zzawz.zzdp("Disabling hardware acceleration on an AdView.");
                    zzabo();
                    return;
                }
                zzawz.zzdp("Enabling hardware acceleration on an AdView.");
                zzabp();
                return;
            }
        }
        zzawz.zzdp("Enabling hardware acceleration on an overlay.");
        zzabp();
    }

    private final synchronized void zzabo() {
        if (!this.zzela) {
            zzk.zzli();
            setLayerType(1, (Paint) null);
        }
        this.zzela = true;
    }

    private final synchronized void zzabp() {
        if (this.zzela) {
            zzk.zzli();
            setLayerType(0, (Paint) null);
        }
        this.zzela = false;
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzaw(boolean z) {
        if (!z) {
            try {
                zzabr();
                this.zzelr.zzwu();
                if (this.zzekv != null) {
                    this.zzekv.close();
                    this.zzekv.onDestroy();
                    this.zzekv = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.zzemo.set((Object) null);
        this.zzemn.destroy();
        zzk.zzmc();
        zzbfs.zzc(this);
        zzabq();
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public final void onDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
            super.onDraw(canvas);
        }
    }

    public final void zzaas() {
        if (this.zzelm == null) {
            this.zzelm = zzadb.zzb(this.zzeln.zzqw());
            this.zzeln.zza("native:view_load", this.zzelm);
        }
    }

    public final void onPause() {
        try {
            super.onPause();
        } catch (Exception e) {
            zzawz.zzc("Could not pause webview.", e);
        }
    }

    public final void onResume() {
        try {
            super.onResume();
        } catch (Exception e) {
            zzawz.zzc("Could not resume webview.", e);
        }
    }

    public final void zzaav() {
        zzawz.zzds("Cannot add text view to inner AdWebView");
    }

    public final void zzat(boolean z) {
        this.zzemn.zzat(z);
    }

    public final void stopLoading() {
        try {
            super.stopLoading();
        } catch (Exception e) {
            zzawz.zzc("Could not stop loading webview.", e);
        }
    }

    public final synchronized void zzar(boolean z) {
        this.zzelc = z;
    }

    public final synchronized boolean zzaap() {
        return this.zzelc;
    }

    public final synchronized void zzlc() {
        this.zzeld = true;
        if (this.zzekp != null) {
            this.zzekp.zzlc();
        }
    }

    public final synchronized void zzld() {
        this.zzeld = false;
        if (this.zzekp != null) {
            this.zzekp.zzld();
        }
    }

    private final synchronized void zzabq() {
        if (this.zzels != null) {
            for (zzbft release : this.zzels.values()) {
                release.release();
            }
        }
        this.zzels = null;
    }

    public final synchronized void zza(String str, zzbft zzbft) {
        if (this.zzels == null) {
            this.zzels = new HashMap();
        }
        this.zzels.put(str, zzbft);
    }

    public final synchronized zzbft zzet(String str) {
        if (this.zzels == null) {
            return null;
        }
        return this.zzels.get(str);
    }

    public final synchronized String zzyf() {
        return this.zzdlx;
    }

    public final zzadg zzyc() {
        return this.zzeem;
    }

    public final zzadh zzyg() {
        return this.zzeln;
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzelo = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public final synchronized void zza(zzadx zzadx) {
        this.zzelh = zzadx;
    }

    public final synchronized zzadx zzaat() {
        return this.zzelh;
    }

    public final synchronized void zzyk() {
        if (this.zzeli != null) {
            this.zzeli.zzre();
        }
    }

    public final synchronized void zza(zzadv zzadv) {
        this.zzeli = zzadv;
    }

    public final synchronized zzbhq zzyb() {
        return this.zzele;
    }

    public final synchronized void zza(zzbhq zzbhq) {
        if (this.zzele != null) {
            zzawz.zzen("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzele = zzbhq;
        }
    }

    public final synchronized boolean zzaaq() {
        return this.zzelj > 0;
    }

    public final synchronized void zzas(boolean z) {
        this.zzelj += z ? 1 : -1;
        if (this.zzelj <= 0 && this.zzekv != null) {
            this.zzekv.zztn();
        }
    }

    private final void zzabr() {
        zzadi zzqw;
        if (this.zzeln != null && (zzqw = this.zzeln.zzqw()) != null && zzk.zzlk().zzuw() != null) {
            zzk.zzlk().zzuw().zza(zzqw);
        }
    }

    public final void zzaau() {
        setBackgroundColor(0);
    }

    public final void zzao(boolean z) {
        this.zzemn.zzao(z);
    }

    public final void zztm() {
        zzd zzaae = zzaae();
        if (zzaae != null) {
            zzaae.zztm();
        }
    }

    public final int zzyi() {
        return getMeasuredHeight();
    }

    public final int zzyj() {
        return getMeasuredWidth();
    }

    public final void zza(zzc zzc) {
        this.zzemn.zza(zzc);
    }

    public final void zzc(boolean z, int i) {
        this.zzemn.zzc(z, i);
    }

    public final void zza(boolean z, int i, String str) {
        this.zzemn.zza(z, i, str);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        this.zzemn.zza(z, i, str, str2);
    }

    public final void zza(zzud zzud) {
        synchronized (this) {
            this.zzelf = zzud.zzbtk;
        }
        zzav(zzud.zzbtk);
    }

    private final void zzav(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zzajr.zza((zzajq) this, "onAdVisibilityChanged", (Map) hashMap);
    }

    public final void zza(String str, zzaho<? super zzbgz> zzaho) {
        if (this.zzemn != null) {
            this.zzemn.zza(str, zzaho);
        }
    }

    public final void zzb(String str, zzaho<? super zzbgz> zzaho) {
        if (this.zzemn != null) {
            this.zzemn.zzb(str, zzaho);
        }
    }

    public final void zza(String str, Predicate<zzaho<? super zzbgz>> predicate) {
        if (this.zzemn != null) {
            this.zzemn.zza(str, predicate);
        }
    }

    public final boolean zzb(boolean z, int i) {
        destroy();
        this.zzejd.zza((zzwk) new zzbiw(z, i));
        this.zzejd.zza(zzwl.zza.zzb.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    public final /* synthetic */ zzbii zzaai() {
        return this.zzemn;
    }

    static final /* synthetic */ void zza(boolean z, int i, zzxn zzxn) {
        zzwt.zzv.zza zzop = zzwt.zzv.zzop();
        if (zzop.zzoo() != z) {
            zzop.zzr(z);
        }
        zzop.zzcm(i);
        zzxn.zzcfn = (zzwt.zzv) ((zzdob) zzop.zzaya());
    }
}
