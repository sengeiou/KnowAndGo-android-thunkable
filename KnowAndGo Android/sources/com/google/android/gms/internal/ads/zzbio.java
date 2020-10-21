package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
@VisibleForTesting
@zzard
public final class zzbio extends zzbiz implements zzbii {
    private final Object lock = new Object();
    private volatile boolean zzbsy;
    private zzxr zzcgi;
    private zzagv zzczo;
    private zzagx zzczp;
    private zzb zzdaj;
    private zzapr zzdak;
    protected zzbgz zzdjm;
    private zzo zzdkm;
    private zzu zzdkq;
    private boolean zzdok;
    private zzbij zzejf;
    private zzbik zzejg;
    private zzbil zzejh;
    private boolean zzeji = false;
    @GuardedBy("lock")
    private boolean zzejj;
    @GuardedBy("lock")
    private boolean zzejk;
    private zzaqa zzejl;
    @Nullable
    private zzavb zzejm;
    private boolean zzejn;
    private boolean zzejo;
    private int zzejp;
    private View.OnAttachStateChangeListener zzejq;
    private final zzaju<zzbgz> zzemk = new zzaju<>();

    /* access modifiers changed from: package-private */
    public final void zza(zzbgz zzbgz, boolean z) {
        zzaqa zzaqa = new zzaqa(zzbgz, zzbgz.zzaad(), new zzacf(zzbgz.getContext()));
        this.zzdjm = zzbgz;
        this.zzbsy = z;
        this.zzejl = zzaqa;
        this.zzdak = null;
        this.zzemk.zzg(zzbgz);
    }

    public final void zza(int i, int i2, boolean z) {
        this.zzejl.zzj(i, i2);
        if (this.zzdak != null) {
            this.zzdak.zza(i, i2, false);
        }
    }

    public final void zza(String str, zzaho<? super zzbgz> zzaho) {
        this.zzemk.zza(str, zzaho);
    }

    public final void zzb(String str, zzaho<? super zzbgz> zzaho) {
        this.zzemk.zzb(str, zzaho);
    }

    public final void zza(String str, Predicate<zzaho<? super zzbgz>> predicate) {
        this.zzemk.zza(str, predicate);
    }

    public final void zza(zzxr zzxr, zzagv zzagv, zzo zzo, zzagx zzagx, zzu zzu, boolean z, @Nullable zzahp zzahp, zzb zzb, zzaqc zzaqc, @Nullable zzavb zzavb) {
        if (zzb == null) {
            zzb = new zzb(this.zzdjm.getContext(), zzavb, (zzark) null);
        }
        this.zzdak = new zzapr(this.zzdjm, zzaqc);
        this.zzejm = zzavb;
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcov)).booleanValue()) {
            zza("/adMetadata", (zzaho<? super zzbgz>) new zzagu(zzagv));
        }
        zza("/appEvent", (zzaho<? super zzbgz>) new zzagw(zzagx));
        zza("/backButton", (zzaho<? super zzbgz>) zzagz.zzczz);
        zza("/refresh", (zzaho<? super zzbgz>) zzagz.zzdaa);
        zza("/canOpenURLs", (zzaho<? super zzbgz>) zzagz.zzczq);
        zza("/canOpenIntents", (zzaho<? super zzbgz>) zzagz.zzczr);
        zza("/click", (zzaho<? super zzbgz>) zzagz.zzczs);
        zza("/close", (zzaho<? super zzbgz>) zzagz.zzczt);
        zza("/customClose", (zzaho<? super zzbgz>) zzagz.zzczu);
        zza("/instrument", (zzaho<? super zzbgz>) zzagz.zzdad);
        zza("/delayPageLoaded", (zzaho<? super zzbgz>) zzagz.zzdaf);
        zza("/delayPageClosed", (zzaho<? super zzbgz>) zzagz.zzdag);
        zza("/getLocationInfo", (zzaho<? super zzbgz>) zzagz.zzdah);
        zza("/httpTrack", (zzaho<? super zzbgz>) zzagz.zzczv);
        zza("/log", (zzaho<? super zzbgz>) zzagz.zzczw);
        zza("/mraid", (zzaho<? super zzbgz>) new zzahr(zzb, this.zzdak, zzaqc));
        zza("/mraidLoaded", (zzaho<? super zzbgz>) this.zzejl);
        zza("/open", (zzaho<? super zzbgz>) new zzahs(zzb, this.zzdak));
        zza("/precache", (zzaho<? super zzbgz>) new zzbgc());
        zza("/touch", (zzaho<? super zzbgz>) zzagz.zzczy);
        zza("/video", (zzaho<? super zzbgz>) zzagz.zzdab);
        zza("/videoMeta", (zzaho<? super zzbgz>) zzagz.zzdac);
        if (zzk.zzme().zzx(this.zzdjm.getContext())) {
            zza("/logScionEvent", (zzaho<? super zzbgz>) new zzahq(this.zzdjm.getContext()));
        }
        this.zzcgi = zzxr;
        this.zzdkm = zzo;
        this.zzczo = zzagv;
        this.zzczp = zzagx;
        this.zzdkq = zzu;
        this.zzdaj = zzb;
        this.zzeji = z;
    }

    public final zzb zzaax() {
        return this.zzdaj;
    }

    public final boolean zzaay() {
        return this.zzbsy;
    }

    public final boolean zzaaz() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzejj;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzaba() {
        synchronized (this.lock) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzabb() {
        synchronized (this.lock) {
        }
        return null;
    }

    public final void zza(zzbja zzbja) {
        this.zzejn = true;
        if (this.zzejg != null) {
            this.zzejg.zzrw();
            this.zzejg = null;
        }
        zzabh();
    }

    /* access modifiers changed from: private */
    public final void zza(View view, zzavb zzavb, int i) {
        if (zzavb.zzud() && i > 0) {
            zzavb.zzj(view);
            if (zzavb.zzud()) {
                zzaxi.zzdvv.postDelayed(new zzbiq(this, view, zzavb, i), 100);
            }
        }
    }

    private final void zzabc() {
        if (this.zzejq != null) {
            this.zzdjm.getView().removeOnAttachStateChangeListener(this.zzejq);
        }
    }

    public final void zzabd() {
        zzavb zzavb = this.zzejm;
        if (zzavb != null) {
            WebView webView = this.zzdjm.getWebView();
            if (ViewCompat.isAttachedToWindow(webView)) {
                zza((View) webView, zzavb, 10);
                return;
            }
            zzabc();
            this.zzejq = new zzbir(this, zzavb);
            this.zzdjm.getView().addOnAttachStateChangeListener(this.zzejq);
        }
    }

    public final void zzabe() {
        synchronized (this.lock) {
            this.zzejk = true;
        }
        this.zzejp++;
        zzabh();
    }

    public final void zzabf() {
        this.zzejp--;
        zzabh();
    }

    public final void zzabg() {
        this.zzejo = true;
        zzabh();
    }

    private final void zzabh() {
        if (this.zzejf != null && ((this.zzejn && this.zzejp <= 0) || this.zzejo)) {
            this.zzejf.zzae(!this.zzejo);
            this.zzejf = null;
        }
        this.zzdjm.zzaas();
    }

    public final void zza(zzc zzc) {
        zzo zzo;
        boolean zzaan = this.zzdjm.zzaan();
        zzxr zzxr = (!zzaan || this.zzdjm.zzaag().zzabx()) ? this.zzcgi : null;
        if (zzaan) {
            zzo = null;
        } else {
            zzo = this.zzdkm;
        }
        zza(new AdOverlayInfoParcel(zzc, zzxr, zzo, this.zzdkq, this.zzdjm.zzyh()));
    }

    public final void zzc(boolean z, int i) {
        zza(new AdOverlayInfoParcel((!this.zzdjm.zzaan() || this.zzdjm.zzaag().zzabx()) ? this.zzcgi : null, this.zzdkm, this.zzdkq, this.zzdjm, z, i, this.zzdjm.zzyh()));
    }

    public final void zza(boolean z, int i, String str) {
        zzbis zzbis;
        boolean zzaan = this.zzdjm.zzaan();
        zzxr zzxr = (!zzaan || this.zzdjm.zzaag().zzabx()) ? this.zzcgi : null;
        if (zzaan) {
            zzbis = null;
        } else {
            zzbis = new zzbis(this.zzdjm, this.zzdkm);
        }
        zza(new AdOverlayInfoParcel(zzxr, zzbis, this.zzczo, this.zzczp, this.zzdkq, this.zzdjm, z, i, str, this.zzdjm.zzyh()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        zzbis zzbis;
        boolean zzaan = this.zzdjm.zzaan();
        zzxr zzxr = (!zzaan || this.zzdjm.zzaag().zzabx()) ? this.zzcgi : null;
        if (zzaan) {
            zzbis = null;
        } else {
            zzbis = new zzbis(this.zzdjm, this.zzdkm);
        }
        zza(new AdOverlayInfoParcel(zzxr, zzbis, this.zzczo, this.zzczp, this.zzdkq, this.zzdjm, z, i, str, str2, this.zzdjm.zzyh()));
    }

    private final void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean zztb = this.zzdak != null ? this.zzdak.zztb() : false;
        zzk.zzlf();
        Context context = this.zzdjm.getContext();
        if (!zztb) {
            z = true;
        }
        zzm.zza(context, adOverlayInfoParcel, z);
        if (this.zzejm != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && adOverlayInfoParcel.zzdkl != null) {
                str = adOverlayInfoParcel.zzdkl.url;
            }
            this.zzejm.zzdk(str);
        }
    }

    public final void destroy() {
        if (this.zzejm != null) {
            this.zzejm.zzuf();
            this.zzejm = null;
        }
        zzabc();
        this.zzemk.reset();
        this.zzemk.zzg(null);
        synchronized (this.lock) {
            this.zzcgi = null;
            this.zzdkm = null;
            this.zzejf = null;
            this.zzejg = null;
            this.zzczo = null;
            this.zzczp = null;
            this.zzdkq = null;
            this.zzejh = null;
            if (this.zzdak != null) {
                this.zzdak.zzw(true);
                this.zzdak = null;
            }
        }
    }

    public final void zza(zzbij zzbij) {
        this.zzejf = zzbij;
    }

    public final void zza(zzbik zzbik) {
        this.zzejg = zzbik;
    }

    public final void zzb(zzbja zzbja) {
        this.zzemk.zzg(zzbja.uri);
    }

    public final boolean zzc(zzbja zzbja) {
        String valueOf = String.valueOf(zzbja.url);
        zzawz.zzds(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri uri = zzbja.uri;
        if (this.zzemk.zzg(uri)) {
            return true;
        }
        if (this.zzeji) {
            String scheme = uri.getScheme();
            if (UriUtil.HTTP_SCHEME.equalsIgnoreCase(scheme) || UriUtil.HTTPS_SCHEME.equalsIgnoreCase(scheme)) {
                if (this.zzcgi != null) {
                    this.zzcgi.onAdClicked();
                    if (this.zzejm != null) {
                        this.zzejm.zzdk(zzbja.url);
                    }
                    this.zzcgi = null;
                }
                return false;
            }
        }
        if (!this.zzdjm.getWebView().willNotDraw()) {
            try {
                zzdh zzaal = this.zzdjm.zzaal();
                if (zzaal != null && zzaal.zzc(uri)) {
                    uri = zzaal.zza(uri, this.zzdjm.getContext(), this.zzdjm.getView(), this.zzdjm.zzyd());
                }
            } catch (zzdi unused) {
                String valueOf2 = String.valueOf(zzbja.url);
                zzawz.zzep(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
            }
            if (this.zzdaj == null || this.zzdaj.zzkx()) {
                zza(new zzc("android.intent.action.VIEW", uri.toString(), (String) null, (String) null, (String) null, (String) null, (String) null));
            } else {
                this.zzdaj.zzbk(zzbja.url);
            }
        } else {
            String valueOf3 = String.valueOf(zzbja.url);
            zzawz.zzep(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
        }
        return true;
    }

    @Nullable
    public final WebResourceResponse zzd(zzbja zzbja) {
        WebResourceResponse webResourceResponse;
        zzvs zza;
        String str;
        if (this.zzejm != null) {
            this.zzejm.zza(zzbja.url, zzbja.zzab, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(zzbja.url).getName())) {
            webResourceResponse = null;
        } else {
            zzth();
            if (this.zzdjm.zzaag().zzabx()) {
                str = (String) zzyt.zzpe().zzd(zzacu.zzcmu);
            } else if (this.zzdjm.zzaan()) {
                str = (String) zzyt.zzpe().zzd(zzacu.zzcmt);
            } else {
                str = (String) zzyt.zzpe().zzd(zzacu.zzcms);
            }
            zzk.zzlg();
            webResourceResponse = zzaxi.zzd(this.zzdjm.getContext(), this.zzdjm.zzyh().zzbsx, str);
        }
        if (webResourceResponse != null) {
            return webResourceResponse;
        }
        try {
            if (!zzavx.zzd(zzbja.url, this.zzdjm.getContext(), this.zzdok).equals(zzbja.url)) {
                return zze(zzbja);
            }
            zzvv zzbo = zzvv.zzbo(zzbja.url);
            if (zzbo != null && (zza = zzk.zzlm().zza(zzbo)) != null && zza.zznh()) {
                return new WebResourceResponse("", "", zza.zzni());
            }
            if (zzazx.isEnabled()) {
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcqc)).booleanValue()) {
                    return zze(zzbja);
                }
            }
            return null;
        } catch (Exception | NoClassDefFoundError e) {
            zzk.zzlk().zza(e, "AdWebViewClient.interceptRequest");
            return zzabi();
        }
    }

    private static WebResourceResponse zzabi() {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcom)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zze(zzbja zzbja) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(zzbja.url);
        int i = 0;
        while (true) {
            i++;
            if (i <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Map.Entry next : zzbja.zzab.entrySet()) {
                    openConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
                }
                if (openConnection instanceof HttpURLConnection) {
                    httpURLConnection = (HttpURLConnection) openConnection;
                    zzk.zzlg().zza(this.zzdjm.getContext(), this.zzdjm.zzyh().zzbsx, false, httpURLConnection);
                    zzazx zzazx = new zzazx();
                    zzazx.zza(httpURLConnection, (byte[]) null);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzazx.zza(httpURLConnection, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        zzk.zzlg();
                    } else {
                        String headerField = httpURLConnection.getHeaderField("Location");
                        if (headerField != null) {
                            URL url2 = new URL(url, headerField);
                            String protocol = url2.getProtocol();
                            if (protocol == null) {
                                zzawz.zzep("Protocol is null");
                                return zzabi();
                            } else if (protocol.equals(UriUtil.HTTP_SCHEME) || protocol.equals(UriUtil.HTTPS_SCHEME)) {
                                String valueOf = String.valueOf(headerField);
                                zzawz.zzdp(valueOf.length() != 0 ? "Redirecting to ".concat(valueOf) : new String("Redirecting to "));
                                httpURLConnection.disconnect();
                                url = url2;
                            } else {
                                String valueOf2 = String.valueOf(protocol);
                                zzawz.zzep(valueOf2.length() != 0 ? "Unsupported scheme: ".concat(valueOf2) : new String("Unsupported scheme: "));
                                return zzabi();
                            }
                        } else {
                            throw new IOException("Missing Location header in redirect");
                        }
                    }
                } else {
                    throw new IOException("Invalid protocol.");
                }
            } else {
                StringBuilder sb = new StringBuilder(32);
                sb.append("Too many redirects (20)");
                throw new IOException(sb.toString());
            }
        }
        zzk.zzlg();
        return zzaxi.zzd(httpURLConnection);
    }

    public final void zzao(boolean z) {
        this.zzeji = z;
    }

    public final zzavb zzabj() {
        return this.zzejm;
    }

    public final void zzth() {
        synchronized (this.lock) {
            this.zzeji = false;
            this.zzbsy = true;
            zzbbm.zzeae.execute(new zzbip(this));
        }
    }

    public final void zzat(boolean z) {
        this.zzdok = z;
    }

    public final void zzi(int i, int i2) {
        if (this.zzdak != null) {
            this.zzdak.zzi(i, i2);
        }
    }

    public final void zzau(boolean z) {
        synchronized (this.lock) {
            this.zzejj = true;
        }
    }

    public final void zzh(Uri uri) {
        this.zzemk.zzh(uri);
    }

    @TargetApi(26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzdjm.zzb(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }
}
