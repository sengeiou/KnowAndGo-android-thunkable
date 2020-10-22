package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.impl.C1603R;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

@zzard
public final class zzbhk extends FrameLayout implements zzbgz {
    /* access modifiers changed from: private */
    public final zzbgz zzekj;
    private final zzbcw zzekk;
    private final AtomicBoolean zzekl = new AtomicBoolean();

    public zzbhk(zzbgz zzbgz) {
        super(zzbgz.getContext());
        this.zzekj = zzbgz;
        this.zzekk = new zzbcw(zzbgz.zzaad(), this, this);
        addView(this.zzekj.getView());
    }

    public final View getView() {
        return this;
    }

    public final zzbcw zzya() {
        return this.zzekk;
    }

    public final void onPause() {
        this.zzekk.onPause();
        this.zzekj.onPause();
    }

    public final void zzaao() {
        this.zzekk.onDestroy();
        this.zzekj.zzaao();
    }

    public final void zzaau() {
        setBackgroundColor(0);
        this.zzekj.setBackgroundColor(0);
    }

    public final int zzyi() {
        return getMeasuredHeight();
    }

    public final int zzyj() {
        return getMeasuredWidth();
    }

    public final void zzyk() {
        this.zzekj.zzyk();
    }

    public final WebView getWebView() {
        return this.zzekj.getWebView();
    }

    public final void zza(String str, Map<String, ?> map) {
        this.zzekj.zza(str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        this.zzekj.zza(str, jSONObject);
    }

    public final void zza(String str, zzaho<? super zzbgz> zzaho) {
        this.zzekj.zza(str, zzaho);
    }

    public final void zzb(String str, zzaho<? super zzbgz> zzaho) {
        this.zzekj.zzb(str, zzaho);
    }

    public final void zza(String str, Predicate<zzaho<? super zzbgz>> predicate) {
        this.zzekj.zza(str, predicate);
    }

    public final void zzaab() {
        this.zzekj.zzaab();
    }

    public final void zzdi(int i) {
        this.zzekj.zzdi(i);
    }

    public final void zztl() {
        this.zzekj.zztl();
    }

    public final void zzaac() {
        this.zzekj.zzaac();
    }

    public final void zza(boolean z, long j) {
        this.zzekj.zza(z, j);
    }

    public final void zzco(String str) {
        this.zzekj.zzco(str);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        this.zzekj.zzb(str, jSONObject);
    }

    public final Activity zzyd() {
        return this.zzekj.zzyd();
    }

    public final Context zzaad() {
        return this.zzekj.zzaad();
    }

    public final zza zzye() {
        return this.zzekj.zzye();
    }

    public final zzd zzaae() {
        return this.zzekj.zzaae();
    }

    public final IObjectWrapper zzaam() {
        return this.zzekj.zzaam();
    }

    public final zzd zzaaf() {
        return this.zzekj.zzaaf();
    }

    public final zzbin zzaag() {
        return this.zzekj.zzaag();
    }

    public final String zzaah() {
        return this.zzekj.zzaah();
    }

    public final zzbii zzaai() {
        return this.zzekj.zzaai();
    }

    public final WebViewClient zzaaj() {
        return this.zzekj.zzaaj();
    }

    public final boolean zzaak() {
        return this.zzekj.zzaak();
    }

    public final zzdh zzaal() {
        return this.zzekj.zzaal();
    }

    public final zzbai zzyh() {
        return this.zzekj.zzyh();
    }

    public final boolean zzaan() {
        return this.zzekj.zzaan();
    }

    public final boolean isDestroyed() {
        return this.zzekj.isDestroyed();
    }

    public final boolean zzaap() {
        return this.zzekj.zzaap();
    }

    public final void zzld() {
        this.zzekj.zzld();
    }

    public final void zzlc() {
        this.zzekj.zzlc();
    }

    public final String zzyf() {
        return this.zzekj.zzyf();
    }

    public final zzadg zzyc() {
        return this.zzekj.zzyc();
    }

    public final zzadh zzyg() {
        return this.zzekj.zzyg();
    }

    public final zzbhq zzyb() {
        return this.zzekj.zzyb();
    }

    public final void zza(zzd zzd) {
        this.zzekj.zza(zzd);
    }

    public final void zzam(IObjectWrapper iObjectWrapper) {
        this.zzekj.zzam(iObjectWrapper);
    }

    public final void zza(zzbin zzbin) {
        this.zzekj.zza(zzbin);
    }

    public final void zzaq(boolean z) {
        this.zzekj.zzaq(z);
    }

    public final void zzaar() {
        this.zzekj.zzaar();
    }

    public final void zzbn(Context context) {
        this.zzekj.zzbn(context);
    }

    public final void zzaf(boolean z) {
        this.zzekj.zzaf(z);
    }

    public final void setRequestedOrientation(int i) {
        this.zzekj.setRequestedOrientation(i);
    }

    public final void zzb(zzd zzd) {
        this.zzekj.zzb(zzd);
    }

    public final void zzar(boolean z) {
        this.zzekj.zzar(z);
    }

    public final void zza(String str, zzbft zzbft) {
        this.zzekj.zza(str, zzbft);
    }

    public final zzbft zzet(String str) {
        return this.zzekj.zzet(str);
    }

    public final void zzaas() {
        this.zzekj.zzaas();
    }

    public final void destroy() {
        IObjectWrapper zzaam = zzaam();
        if (zzaam != null) {
            zzk.zzlv().zzab(zzaam);
            zzaxi.zzdvv.postDelayed(new zzbhl(this), (long) ((Integer) zzyt.zzpe().zzd(zzacu.zzcuv)).intValue());
            return;
        }
        this.zzekj.destroy();
    }

    public final void loadData(String str, String str2, String str3) {
        this.zzekj.loadData(str, str2, str3);
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zzekj.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final void loadUrl(String str) {
        this.zzekj.loadUrl(str);
    }

    public final void zzb(String str, String str2, @Nullable String str3) {
        this.zzekj.zzb(str, str2, str3);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzekj.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zzekj.setOnTouchListener(onTouchListener);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zzekj.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zzekj.setWebViewClient(webViewClient);
    }

    public final void onResume() {
        this.zzekj.onResume();
    }

    public final void zzaav() {
        TextView textView = new TextView(getContext());
        Resources resources = zzk.zzlk().getResources();
        textView.setText(resources != null ? resources.getString(C1603R.string.f173s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        if (Build.VERSION.SDK_INT >= 16) {
            textView.setBackground(gradientDrawable);
        } else {
            textView.setBackgroundDrawable(gradientDrawable);
        }
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    public final void zzat(boolean z) {
        this.zzekj.zzat(z);
    }

    public final void zza(zzadv zzadv) {
        this.zzekj.zza(zzadv);
    }

    public final void zza(zzud zzud) {
        this.zzekj.zza(zzud);
    }

    public final void zza(@Nullable zzadx zzadx) {
        this.zzekj.zza(zzadx);
    }

    @Nullable
    public final zzadx zzaat() {
        return this.zzekj.zzaat();
    }

    public final void zza(zzbhq zzbhq) {
        this.zzekj.zza(zzbhq);
    }

    public final boolean zzaaq() {
        return this.zzekj.zzaaq();
    }

    public final void zzas(boolean z) {
        this.zzekj.zzas(z);
    }

    public final void zzao(boolean z) {
        this.zzekj.zzao(z);
    }

    public final void zztm() {
        this.zzekj.zztm();
    }

    public final void zza(zzc zzc) {
        this.zzekj.zza(zzc);
    }

    public final void zzc(boolean z, int i) {
        this.zzekj.zzc(z, i);
    }

    public final void zza(boolean z, int i, String str) {
        this.zzekj.zza(z, i, str);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        this.zzekj.zza(z, i, str, str2);
    }

    public final boolean zzb(boolean z, int i) {
        if (!this.zzekl.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcoo)).booleanValue()) {
            return false;
        }
        removeView(this.zzekj.getView());
        return this.zzekj.zzb(z, i);
    }

    public final boolean zzaaw() {
        return this.zzekl.get();
    }
}
