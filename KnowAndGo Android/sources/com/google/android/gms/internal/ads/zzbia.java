package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import java.io.File;
import java.util.Collections;
import java.util.Map;

@TargetApi(11)
@zzard
public class zzbia extends zzbha {
    public zzbia(zzbgz zzbgz, zzwj zzwj, boolean z) {
        super(zzbgz, zzwj, z);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final WebResourceResponse zza(WebView webView, String str, @Nullable Map<String, String> map) {
        String str2;
        if (!(webView instanceof zzbgz)) {
            zzawz.zzep("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzbgz zzbgz = (zzbgz) webView;
        if (this.zzejm != null) {
            this.zzejm.zza(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzd(str, map);
        }
        if (zzbgz.zzaai() != null) {
            zzbgz.zzaai().zzth();
        }
        if (zzbgz.zzaag().zzabx()) {
            str2 = (String) zzyt.zzpe().zzd(zzacu.zzcmu);
        } else if (zzbgz.zzaan()) {
            str2 = (String) zzyt.zzpe().zzd(zzacu.zzcmt);
        } else {
            str2 = (String) zzyt.zzpe().zzd(zzacu.zzcms);
        }
        zzk.zzlg();
        return zzaxi.zzd(zzbgz.getContext(), zzbgz.zzyh().zzbsx, str2);
    }
}
