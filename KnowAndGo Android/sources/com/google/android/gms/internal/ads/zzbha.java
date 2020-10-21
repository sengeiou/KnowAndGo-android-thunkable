package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.extractor.p012ts.TsExtractor;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.iid.InstanceID;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
@VisibleForTesting
@zzard
public class zzbha extends WebViewClient implements zzbii {
    private static final String[] zzejb = {"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", InstanceID.ERROR_TIMEOUT, "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] zzejc = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private final Object lock;
    @GuardedBy("lock")
    private boolean zzbsy;
    private zzxr zzcgi;
    private zzagv zzczo;
    private zzagx zzczp;
    private zzb zzdaj;
    private zzapr zzdak;
    protected zzbgz zzdjm;
    private zzo zzdkm;
    private zzu zzdkq;
    private boolean zzdok;
    @Nullable
    private final zzwj zzejd;
    private final HashMap<String, List<zzaho<? super zzbgz>>> zzeje;
    private zzbij zzejf;
    private zzbik zzejg;
    private zzbil zzejh;
    private boolean zzeji;
    @GuardedBy("lock")
    private boolean zzejj;
    @GuardedBy("lock")
    private boolean zzejk;
    private final zzaqa zzejl;
    @Nullable
    protected zzavb zzejm;
    private boolean zzejn;
    private boolean zzejo;
    private int zzejp;
    private View.OnAttachStateChangeListener zzejq;

    public zzbha(zzbgz zzbgz, zzwj zzwj, boolean z) {
        this(zzbgz, zzwj, z, new zzaqa(zzbgz, zzbgz.zzaad(), new zzacf(zzbgz.getContext())), (zzapr) null);
    }

    @VisibleForTesting
    private zzbha(zzbgz zzbgz, zzwj zzwj, boolean z, zzaqa zzaqa, zzapr zzapr) {
        this.zzeje = new HashMap<>();
        this.lock = new Object();
        this.zzeji = false;
        this.zzejd = zzwj;
        this.zzdjm = zzbgz;
        this.zzbsy = z;
        this.zzejl = zzaqa;
        this.zzdak = null;
    }

    public final void zza(int i, int i2, boolean z) {
        this.zzejl.zzj(i, i2);
        if (this.zzdak != null) {
            this.zzdak.zza(i, i2, false);
        }
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
        boolean z;
        synchronized (this.lock) {
            z = this.zzbsy;
        }
        return z;
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

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r0.zzejg == null) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r0.zzejg.zzrw();
        r0.zzejg = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        zzabh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r0.zzejn = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r1, java.lang.String r2) {
        /*
            r0 = this;
            java.lang.Object r1 = r0.lock
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzbgz r2 = r0.zzdjm     // Catch:{ all -> 0x002b }
            boolean r2 = r2.isDestroyed()     // Catch:{ all -> 0x002b }
            if (r2 == 0) goto L_0x0017
            java.lang.String r2 = "Blank page loaded, 1..."
            com.google.android.gms.internal.ads.zzawz.zzds(r2)     // Catch:{ all -> 0x002b }
            com.google.android.gms.internal.ads.zzbgz r2 = r0.zzdjm     // Catch:{ all -> 0x002b }
            r2.zzaao()     // Catch:{ all -> 0x002b }
            monitor-exit(r1)     // Catch:{ all -> 0x002b }
            return
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x002b }
            r1 = 1
            r0.zzejn = r1
            com.google.android.gms.internal.ads.zzbik r1 = r0.zzejg
            if (r1 == 0) goto L_0x0027
            com.google.android.gms.internal.ads.zzbik r1 = r0.zzejg
            r1.zzrw()
            r1 = 0
            r0.zzejg = r1
        L_0x0027:
            r0.zzabh()
            return
        L_0x002b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x002b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbha.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public final void zza(View view, zzavb zzavb, int i) {
        if (zzavb.zzud() && i > 0) {
            zzavb.zzj(view);
            if (zzavb.zzud()) {
                zzaxi.zzdvv.postDelayed(new zzbhc(this, view, zzavb, i), 100);
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
            this.zzejq = new zzbhd(this, zzavb);
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
        zzbhe zzbhe;
        boolean zzaan = this.zzdjm.zzaan();
        zzxr zzxr = (!zzaan || this.zzdjm.zzaag().zzabx()) ? this.zzcgi : null;
        if (zzaan) {
            zzbhe = null;
        } else {
            zzbhe = new zzbhe(this.zzdjm, this.zzdkm);
        }
        zza(new AdOverlayInfoParcel(zzxr, zzbhe, this.zzczo, this.zzczp, this.zzdkq, this.zzdjm, z, i, str, this.zzdjm.zzyh()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        zzbhe zzbhe;
        boolean zzaan = this.zzdjm.zzaan();
        zzxr zzxr = (!zzaan || this.zzdjm.zzaag().zzabx()) ? this.zzcgi : null;
        if (zzaan) {
            zzbhe = null;
        } else {
            zzbhe = new zzbhe(this.zzdjm, this.zzdkm);
        }
        zza(new AdOverlayInfoParcel(zzxr, zzbhe, this.zzczo, this.zzczp, this.zzdkq, this.zzdjm, z, i, str, str2, this.zzdjm.zzyh()));
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

    public final void zza(String str, zzaho<? super zzbgz> zzaho) {
        synchronized (this.lock) {
            List list = this.zzeje.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zzeje.put(str, list);
            }
            list.add(zzaho);
        }
    }

    public final void zzb(String str, zzaho<? super zzbgz> zzaho) {
        synchronized (this.lock) {
            List list = this.zzeje.get(str);
            if (list != null) {
                list.remove(zzaho);
            }
        }
    }

    public final void zza(String str, Predicate<zzaho<? super zzbgz>> predicate) {
        synchronized (this.lock) {
            List<zzaho> list = this.zzeje.get(str);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (zzaho zzaho : list) {
                    if (predicate.apply(zzaho)) {
                        arrayList.add(zzaho);
                    }
                }
                list.removeAll(arrayList);
            }
        }
    }

    public final void reset() {
        if (this.zzejm != null) {
            this.zzejm.zzuf();
            this.zzejm = null;
        }
        zzabc();
        synchronized (this.lock) {
            this.zzeje.clear();
            this.zzcgi = null;
            this.zzdkm = null;
            this.zzejf = null;
            this.zzejg = null;
            this.zzczo = null;
            this.zzczp = null;
            this.zzeji = false;
            this.zzbsy = false;
            this.zzejj = false;
            this.zzejk = false;
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

    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzawz.zzds(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String str3;
        int i2;
        if (i >= 0 || (-i) - 1 >= zzejb.length) {
            str3 = String.valueOf(i);
        } else {
            str3 = zzejb[i2];
        }
        zze(this.zzdjm.getContext(), "http_err", str3, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String str;
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            if (primaryError < 0 || primaryError >= zzejc.length) {
                str = String.valueOf(primaryError);
            } else {
                str = zzejc[primaryError];
            }
            Context context = this.zzdjm.getContext();
            zzk.zzli();
            zze(context, "ssl_err", str, sslError.getUrl());
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    private final void zze(Context context, String str, String str2, String str3) {
        String str4;
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcqo)).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString(NotificationCompat.CATEGORY_ERROR, str);
            bundle.putString("code", str2);
            if (!TextUtils.isEmpty(str3)) {
                Uri parse = Uri.parse(str3);
                if (parse.getHost() != null) {
                    str4 = parse.getHost();
                    bundle.putString("host", str4);
                    zzk.zzlg().zza(context, this.zzdjm.zzyh().zzbsx, "gmob-apps", bundle, true);
                }
            }
            str4 = "";
            bundle.putString("host", str4);
            zzk.zzlg().zza(context, this.zzdjm.zzyh().zzbsx, "gmob-apps", bundle, true);
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzawz.zzds(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri parse = Uri.parse(str);
        if (!"gmsg".equalsIgnoreCase(parse.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            if (this.zzeji && webView == this.zzdjm.getWebView()) {
                String scheme = parse.getScheme();
                if (UriUtil.HTTP_SCHEME.equalsIgnoreCase(scheme) || UriUtil.HTTPS_SCHEME.equalsIgnoreCase(scheme)) {
                    if (this.zzcgi != null) {
                        this.zzcgi.onAdClicked();
                        if (this.zzejm != null) {
                            this.zzejm.zzdk(str);
                        }
                        this.zzcgi = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.zzdjm.getWebView().willNotDraw()) {
                try {
                    zzdh zzaal = this.zzdjm.zzaal();
                    if (zzaal != null && zzaal.zzc(parse)) {
                        parse = zzaal.zza(parse, this.zzdjm.getContext(), this.zzdjm.getView(), this.zzdjm.zzyd());
                    }
                } catch (zzdi unused) {
                    String valueOf2 = String.valueOf(str);
                    zzawz.zzep(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
                }
                if (this.zzdaj == null || this.zzdaj.zzkx()) {
                    zza(new zzc("android.intent.action.VIEW", parse.toString(), (String) null, (String) null, (String) null, (String) null, (String) null));
                } else {
                    this.zzdaj.zzbk(str);
                }
            } else {
                String valueOf3 = String.valueOf(str);
                zzawz.zzep(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
            }
        } else {
            zzh(parse);
        }
        return true;
    }

    @TargetApi(11)
    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzd(str, Collections.emptyMap());
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final WebResourceResponse zzd(String str, Map<String, String> map) {
        zzvs zza;
        try {
            String zzd = zzavx.zzd(str, this.zzdjm.getContext(), this.zzdok);
            if (!zzd.equals(str)) {
                return zze(zzd, map);
            }
            zzvv zzbo = zzvv.zzbo(str);
            if (zzbo != null && (zza = zzk.zzlm().zza(zzbo)) != null && zza.zznh()) {
                return new WebResourceResponse("", "", zza.zzni());
            }
            if (!zzazx.isEnabled()) {
                return null;
            }
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcqc)).booleanValue()) {
                return zze(str, map);
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

    private final WebResourceResponse zze(String str, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        int i = 0;
        while (true) {
            i++;
            if (i <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Map.Entry next : map.entrySet()) {
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
            zzbbm.zzeae.execute(new zzbhb(this));
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

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case TsExtractor.TS_STREAM_TYPE_AC3:
                    case TsExtractor.TS_STREAM_TYPE_HDMV_DTS:
                        return true;
                    default:
                        return false;
                }
        }
    }

    public final void zzh(Uri uri) {
        String path = uri.getPath();
        List<zzaho> list = this.zzeje.get(path);
        if (list != null) {
            zzk.zzlg();
            Map<String, String> zzi = zzaxi.zzi(uri);
            if (zzawz.isLoggable(2)) {
                String valueOf = String.valueOf(path);
                zzawz.zzds(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
                for (String next : zzi.keySet()) {
                    String str = zzi.get(next);
                    StringBuilder sb = new StringBuilder(String.valueOf(next).length() + 4 + String.valueOf(str).length());
                    sb.append("  ");
                    sb.append(next);
                    sb.append(": ");
                    sb.append(str);
                    zzawz.zzds(sb.toString());
                }
            }
            for (zzaho zza : list) {
                zza.zza(this.zzdjm, zzi);
            }
            return;
        }
        String valueOf2 = String.valueOf(uri);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 32);
        sb2.append("No GMSG handler found for GMSG: ");
        sb2.append(valueOf2);
        zzawz.zzds(sb2.toString());
    }

    public final void zzau(boolean z) {
        synchronized (this.lock) {
            this.zzejj = true;
        }
    }

    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzdjm.zzb(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }
}
