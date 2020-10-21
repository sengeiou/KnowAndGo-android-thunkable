package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzacu;
import com.google.android.gms.internal.ads.zzadi;
import com.google.android.gms.internal.ads.zzagv;
import com.google.android.gms.internal.ads.zzagx;
import com.google.android.gms.internal.ads.zzahp;
import com.google.android.gms.internal.ads.zzaqb;
import com.google.android.gms.internal.ads.zzaqc;
import com.google.android.gms.internal.ads.zzaqh;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzavb;
import com.google.android.gms.internal.ads.zzawz;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbhf;
import com.google.android.gms.internal.ads.zzbii;
import com.google.android.gms.internal.ads.zzbij;
import com.google.android.gms.internal.ads.zzdh;
import com.google.android.gms.internal.ads.zzwj;
import com.google.android.gms.internal.ads.zzxr;
import com.google.android.gms.internal.ads.zzyt;
import java.util.Collections;
import java.util.Map;
import p022fi.iki.elonen.NanoHTTPD;

@zzard
public class zzd extends zzaqh implements zzx {
    @VisibleForTesting
    private static final int zzdjk = Color.argb(0, 0, 0, 0);
    protected final Activity mActivity;
    @VisibleForTesting
    AdOverlayInfoParcel zzdjl;
    @VisibleForTesting
    zzbgz zzdjm;
    @VisibleForTesting
    private zzj zzdjn;
    @VisibleForTesting
    private zzp zzdjo;
    @VisibleForTesting
    private boolean zzdjp = false;
    @VisibleForTesting
    private FrameLayout zzdjq;
    @VisibleForTesting
    private WebChromeClient.CustomViewCallback zzdjr;
    @VisibleForTesting
    private boolean zzdjs = false;
    @VisibleForTesting
    private boolean zzdjt = false;
    @VisibleForTesting
    private zzi zzdju;
    @VisibleForTesting
    private boolean zzdjv = false;
    @VisibleForTesting
    int zzdjw = 0;
    private final Object zzdjx = new Object();
    private Runnable zzdjy;
    private boolean zzdjz;
    private boolean zzdka;
    private boolean zzdkb = false;
    private boolean zzdkc = false;
    private boolean zzdkd = true;

    public zzd(Activity activity) {
        this.mActivity = activity;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void onRestart() {
    }

    public final void close() {
        this.zzdjw = 2;
        this.mActivity.finish();
    }

    public final void zzte() {
        if (this.zzdjl != null && this.zzdjp) {
            setRequestedOrientation(this.zzdjl.orientation);
        }
        if (this.zzdjq != null) {
            this.mActivity.setContentView(this.zzdju);
            this.zzdka = true;
            this.zzdjq.removeAllViews();
            this.zzdjq = null;
        }
        if (this.zzdjr != null) {
            this.zzdjr.onCustomViewHidden();
            this.zzdjr = null;
        }
        this.zzdjp = false;
    }

    public final void zztf() {
        this.zzdjw = 1;
        this.mActivity.finish();
    }

    public final void onBackPressed() {
        this.zzdjw = 0;
    }

    public final boolean zztg() {
        this.zzdjw = 0;
        if (this.zzdjm == null) {
            return true;
        }
        boolean zzaap = this.zzdjm.zzaap();
        if (!zzaap) {
            this.zzdjm.zza("onbackblocked", (Map<String, ?>) Collections.emptyMap());
        }
        return zzaap;
    }

    public void onCreate(Bundle bundle) {
        this.mActivity.requestWindowFeature(1);
        this.zzdjs = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            this.zzdjl = AdOverlayInfoParcel.zzc(this.mActivity.getIntent());
            if (this.zzdjl != null) {
                if (this.zzdjl.zzbtc.zzdzd > 7500000) {
                    this.zzdjw = 3;
                }
                if (this.mActivity.getIntent() != null) {
                    this.zzdkd = this.mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
                }
                if (this.zzdjl.zzdkt != null) {
                    this.zzdjt = this.zzdjl.zzdkt.zzbre;
                } else {
                    this.zzdjt = false;
                }
                if (this.zzdjt && this.zzdjl.zzdkt.zzbrj != -1) {
                    new zzk(this).zzvi();
                }
                if (bundle == null) {
                    if (this.zzdjl.zzdkm != null && this.zzdkd) {
                        this.zzdjl.zzdkm.zzta();
                    }
                    if (!(this.zzdjl.zzdkr == 1 || this.zzdjl.zzcgi == null)) {
                        this.zzdjl.zzcgi.onAdClicked();
                    }
                }
                this.zzdju = new zzi(this.mActivity, this.zzdjl.zzdks, this.zzdjl.zzbtc.zzbsx);
                this.zzdju.setId(1000);
                zzk.zzli().zzg(this.mActivity);
                switch (this.zzdjl.zzdkr) {
                    case 1:
                        zzad(false);
                        return;
                    case 2:
                        this.zzdjn = new zzj(this.zzdjl.zzdbs);
                        zzad(false);
                        return;
                    case 3:
                        zzad(true);
                        return;
                    default:
                        throw new zzh("Could not determine ad overlay type.");
                }
            } else {
                throw new zzh("Could not get info for ad overlay.");
            }
        } catch (zzh e) {
            zzawz.zzep(e.getMessage());
            this.zzdjw = 3;
            this.mActivity.finish();
        }
    }

    public final void onStart() {
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcui)).booleanValue()) {
            return;
        }
        if (this.zzdjm == null || this.zzdjm.isDestroyed()) {
            zzawz.zzep("The webview does not exist. Ignoring action.");
            return;
        }
        zzk.zzli();
        zzaxo.zzb(this.zzdjm);
    }

    public final void onResume() {
        if (this.zzdjl.zzdkm != null) {
            this.zzdjl.zzdkm.onResume();
        }
        zza(this.mActivity.getResources().getConfiguration());
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcui)).booleanValue()) {
            return;
        }
        if (this.zzdjm == null || this.zzdjm.isDestroyed()) {
            zzawz.zzep("The webview does not exist. Ignoring action.");
            return;
        }
        zzk.zzli();
        zzaxo.zzb(this.zzdjm);
    }

    public final void onPause() {
        zzte();
        if (this.zzdjl.zzdkm != null) {
            this.zzdjl.zzdkm.onPause();
        }
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcui)).booleanValue() && this.zzdjm != null && (!this.mActivity.isFinishing() || this.zzdjn == null)) {
            zzk.zzli();
            zzaxo.zza(this.zzdjm);
        }
        zzti();
    }

    public final void zzac(IObjectWrapper iObjectWrapper) {
        zza((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdjs);
    }

    public final void onStop() {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcui)).booleanValue() && this.zzdjm != null && (!this.mActivity.isFinishing() || this.zzdjn == null)) {
            zzk.zzli();
            zzaxo.zza(this.zzdjm);
        }
        zzti();
    }

    public final void onDestroy() {
        if (this.zzdjm != null) {
            this.zzdju.removeView(this.zzdjm.getView());
        }
        zzti();
    }

    private final void zzac(boolean z) {
        int intValue = ((Integer) zzyt.zzpe().zzd(zzacu.zzcuk)).intValue();
        zzq zzq = new zzq();
        zzq.size = 50;
        zzq.paddingLeft = z ? intValue : 0;
        zzq.paddingRight = z ? 0 : intValue;
        zzq.paddingTop = 0;
        zzq.paddingBottom = intValue;
        this.zzdjo = new zzp(this.mActivity, zzq, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        zza(z, this.zzdjl.zzdko);
        this.zzdju.addView(this.zzdjo, layoutParams);
    }

    public final void zzdd() {
        this.zzdka = true;
    }

    public final void zza(boolean z, boolean z2) {
        boolean z3 = true;
        boolean z4 = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcpe)).booleanValue() && this.zzdjl != null && this.zzdjl.zzdkt != null && this.zzdjl.zzdkt.zzbrl;
        boolean z5 = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcpf)).booleanValue() && this.zzdjl != null && this.zzdjl.zzdkt != null && this.zzdjl.zzdkt.zzbrm;
        if (z && z2 && z4 && !z5) {
            new zzaqb(this.zzdjm, "useCustomClose").zzdh("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        if (this.zzdjo != null) {
            zzp zzp = this.zzdjo;
            if (!z5 && (!z2 || z4)) {
                z3 = false;
            }
            zzp.zzaf(z3);
        }
    }

    public final void zzth() {
        this.zzdju.removeView(this.zzdjo);
        zzac(true);
    }

    public final void setRequestedOrientation(int i) {
        if (this.mActivity.getApplicationInfo().targetSdkVersion >= ((Integer) zzyt.zzpe().zzd(zzacu.zzcwg)).intValue()) {
            if (this.mActivity.getApplicationInfo().targetSdkVersion <= ((Integer) zzyt.zzpe().zzd(zzacu.zzcwh)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzyt.zzpe().zzd(zzacu.zzcwi)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzyt.zzpe().zzd(zzacu.zzcwj)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.mActivity.setRequestedOrientation(i);
        } catch (Throwable th) {
            zzk.zzlk().zzb(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.zzdjq = new FrameLayout(this.mActivity);
        this.zzdjq.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzdjq.addView(view, -1, -1);
        this.mActivity.setContentView(this.zzdjq);
        this.zzdka = true;
        this.zzdjr = customViewCallback;
        this.zzdjp = true;
    }

    private final void zzad(boolean z) throws zzh {
        if (!this.zzdka) {
            this.mActivity.requestWindowFeature(1);
        }
        Window window = this.mActivity.getWindow();
        if (window != null) {
            zzb zzb = null;
            zzbii zzaai = this.zzdjl.zzdbs != null ? this.zzdjl.zzdbs.zzaai() : null;
            boolean z2 = false;
            boolean z3 = zzaai != null && zzaai.zzaay();
            this.zzdjv = false;
            if (z3) {
                int i = this.zzdjl.orientation;
                zzk.zzli();
                if (i == 6) {
                    if (this.mActivity.getResources().getConfiguration().orientation == 1) {
                        z2 = true;
                    }
                    this.zzdjv = z2;
                } else {
                    int i2 = this.zzdjl.orientation;
                    zzk.zzli();
                    if (i2 == 7) {
                        if (this.mActivity.getResources().getConfiguration().orientation == 2) {
                            z2 = true;
                        }
                        this.zzdjv = z2;
                    }
                }
            }
            boolean z4 = this.zzdjv;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Delay onShow to next orientation change: ");
            sb.append(z4);
            zzawz.zzdp(sb.toString());
            setRequestedOrientation(this.zzdjl.orientation);
            zzk.zzli();
            window.setFlags(16777216, 16777216);
            zzawz.zzdp("Hardware acceleration on the AdActivity window enabled.");
            if (!this.zzdjt) {
                this.zzdju.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            } else {
                this.zzdju.setBackgroundColor(zzdjk);
            }
            this.mActivity.setContentView(this.zzdju);
            this.zzdka = true;
            if (z) {
                try {
                    zzk.zzlh();
                    this.zzdjm = zzbhf.zza(this.mActivity, this.zzdjl.zzdbs != null ? this.zzdjl.zzdbs.zzaag() : null, this.zzdjl.zzdbs != null ? this.zzdjl.zzdbs.zzaah() : null, true, z3, (zzdh) null, this.zzdjl.zzbtc, (zzadi) null, (zzj) null, this.zzdjl.zzdbs != null ? this.zzdjl.zzdbs.zzye() : null, zzwj.zznl());
                    zzbii zzaai2 = this.zzdjm.zzaai();
                    zzagv zzagv = this.zzdjl.zzczo;
                    zzagx zzagx = this.zzdjl.zzczp;
                    zzu zzu = this.zzdjl.zzdkq;
                    if (this.zzdjl.zzdbs != null) {
                        zzb = this.zzdjl.zzdbs.zzaai().zzaax();
                    }
                    zzaai2.zza((zzxr) null, zzagv, (zzo) null, zzagx, zzu, true, (zzahp) null, zzb, (zzaqc) null, (zzavb) null);
                    this.zzdjm.zzaai().zza((zzbij) new zze(this));
                    if (this.zzdjl.url != null) {
                        this.zzdjm.loadUrl(this.zzdjl.url);
                    } else if (this.zzdjl.zzdkp != null) {
                        this.zzdjm.loadDataWithBaseURL(this.zzdjl.zzdkn, this.zzdjl.zzdkp, NanoHTTPD.MIME_HTML, "UTF-8", (String) null);
                    } else {
                        throw new zzh("No URL or HTML to display in ad overlay.");
                    }
                    if (this.zzdjl.zzdbs != null) {
                        this.zzdjl.zzdbs.zzb(this);
                    }
                } catch (Exception e) {
                    zzawz.zzc("Error obtaining webview.", e);
                    throw new zzh("Could not obtain webview for the overlay.");
                }
            } else {
                this.zzdjm = this.zzdjl.zzdbs;
                this.zzdjm.zzbn(this.mActivity);
            }
            this.zzdjm.zza(this);
            if (this.zzdjl.zzdbs != null) {
                zzb(this.zzdjl.zzdbs.zzaam(), this.zzdju);
            }
            ViewParent parent = this.zzdjm.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.zzdjm.getView());
            }
            if (this.zzdjt) {
                this.zzdjm.zzaau();
            }
            this.zzdju.addView(this.zzdjm.getView(), -1, -1);
            if (!z && !this.zzdjv) {
                zztl();
            }
            zzac(z3);
            if (this.zzdjm.zzaak()) {
                zza(z3, true);
                return;
            }
            return;
        }
        throw new zzh("Invalid activity, no window available.");
    }

    private final void zzti() {
        if (this.mActivity.isFinishing() && !this.zzdkb) {
            this.zzdkb = true;
            if (this.zzdjm != null) {
                this.zzdjm.zzdi(this.zzdjw);
                synchronized (this.zzdjx) {
                    if (!this.zzdjz && this.zzdjm.zzaaq()) {
                        this.zzdjy = new zzf(this);
                        zzaxi.zzdvv.postDelayed(this.zzdjy, ((Long) zzyt.zzpe().zzd(zzacu.zzcpd)).longValue());
                        return;
                    }
                }
            }
            zztj();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zztj() {
        if (!this.zzdkc) {
            this.zzdkc = true;
            if (this.zzdjm != null) {
                this.zzdju.removeView(this.zzdjm.getView());
                if (this.zzdjn != null) {
                    this.zzdjm.zzbn(this.zzdjn.zzlj);
                    this.zzdjm.zzaq(false);
                    this.zzdjn.parent.addView(this.zzdjm.getView(), this.zzdjn.index, this.zzdjn.zzdkh);
                    this.zzdjn = null;
                } else if (this.mActivity.getApplicationContext() != null) {
                    this.zzdjm.zzbn(this.mActivity.getApplicationContext());
                }
                this.zzdjm = null;
            }
            if (!(this.zzdjl == null || this.zzdjl.zzdkm == null)) {
                this.zzdjl.zzdkm.zzsz();
            }
            if (this.zzdjl != null && this.zzdjl.zzdbs != null) {
                zzb(this.zzdjl.zzdbs.zzaam(), this.zzdjl.zzdbs.getView());
            }
        }
    }

    private static void zzb(@Nullable IObjectWrapper iObjectWrapper, @Nullable View view) {
        if (iObjectWrapper != null && view != null) {
            zzk.zzlv().zza(iObjectWrapper, view);
        }
    }

    public final void zztk() {
        if (this.zzdjv) {
            this.zzdjv = false;
            zztl();
        }
    }

    private final void zztl() {
        this.zzdjm.zztl();
    }

    public final void zztm() {
        this.zzdju.zzdkg = true;
    }

    public final void zztn() {
        synchronized (this.zzdjx) {
            this.zzdjz = true;
            if (this.zzdjy != null) {
                zzaxi.zzdvv.removeCallbacks(this.zzdjy);
                zzaxi.zzdvv.post(this.zzdjy);
            }
        }
    }

    private final void zza(Configuration configuration) {
        boolean z = true;
        boolean z2 = false;
        boolean z3 = this.zzdjl.zzdkt != null && this.zzdjl.zzdkt.zzbrf;
        boolean zza = zzk.zzli().zza(this.mActivity, configuration);
        if ((this.zzdjt && !z3) || zza) {
            z = false;
        } else if (Build.VERSION.SDK_INT >= 19 && this.zzdjl.zzdkt != null && this.zzdjl.zzdkt.zzbrk) {
            z2 = true;
        }
        Window window = this.mActivity.getWindow();
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcpg)).booleanValue() && Build.VERSION.SDK_INT >= 19) {
            View decorView = window.getDecorView();
            int i = 256;
            if (z) {
                i = 5380;
                if (z2) {
                    i = 5894;
                }
            }
            decorView.setSystemUiVisibility(i);
        } else if (z) {
            window.addFlags(1024);
            window.clearFlags(2048);
            if (Build.VERSION.SDK_INT >= 19 && z2) {
                window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
            }
        } else {
            window.addFlags(2048);
            window.clearFlags(1024);
        }
    }
}
