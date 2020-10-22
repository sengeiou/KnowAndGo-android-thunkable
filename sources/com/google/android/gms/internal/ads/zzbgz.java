package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@VisibleForTesting
@zzard
public interface zzbgz extends zzj, zzaji, zzakg, zzbdf, zzbhx, zzbhy, zzbic, zzbif, zzbig, zzbih, zzue {
    void destroy();

    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    ViewParent getParent();

    View getView();

    WebView getWebView();

    int getWidth();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, @Nullable String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void zza(zzd zzd);

    void zza(zzadv zzadv);

    void zza(zzadx zzadx);

    void zza(zzbhq zzbhq);

    void zza(zzbin zzbin);

    void zza(String str, Predicate<zzaho<? super zzbgz>> predicate);

    void zza(String str, zzaho<? super zzbgz> zzaho);

    void zza(String str, zzbft zzbft);

    void zzaab();

    void zzaac();

    Context zzaad();

    zzd zzaae();

    zzd zzaaf();

    zzbin zzaag();

    String zzaah();

    @Nullable
    zzbii zzaai();

    WebViewClient zzaaj();

    boolean zzaak();

    zzdh zzaal();

    @Nullable
    IObjectWrapper zzaam();

    boolean zzaan();

    void zzaao();

    boolean zzaap();

    boolean zzaaq();

    void zzaar();

    void zzaas();

    zzadx zzaat();

    void zzaau();

    void zzaav();

    boolean zzaaw();

    void zzaf(boolean z);

    void zzam(IObjectWrapper iObjectWrapper);

    void zzaq(boolean z);

    void zzar(boolean z);

    void zzas(boolean z);

    void zzat(boolean z);

    void zzb(zzd zzd);

    void zzb(String str, zzaho<? super zzbgz> zzaho);

    void zzb(String str, String str2, @Nullable String str3);

    boolean zzb(boolean z, int i);

    void zzbn(Context context);

    void zzdi(int i);

    void zztl();

    @Nullable
    zzbhq zzyb();

    Activity zzyd();

    zza zzye();

    zzadh zzyg();

    zzbai zzyh();
}
