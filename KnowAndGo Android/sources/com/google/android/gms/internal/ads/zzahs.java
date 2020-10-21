package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbhx;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.internal.ads.zzbic;
import com.google.android.gms.internal.ads.zzbif;
import com.google.android.gms.internal.ads.zzbih;
import java.net.URISyntaxException;
import java.util.Map;

@zzard
public final class zzahs<T extends zzbhx & zzbhy & zzbic & zzbif & zzbih> implements zzaho<T> {
    private final zzb zzdan;
    private final zzapr zzdao;

    public zzahs(zzb zzb, zzapr zzapr) {
        this.zzdan = zzb;
        this.zzdao = zzapr;
    }

    private static boolean zzc(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzd(Map<String, String> map) {
        String str = map.get(NotificationBundleProcessor.PUSH_MINIFIED_BUTTONS_LIST);
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            zzk.zzli();
            return 7;
        } else if ("l".equalsIgnoreCase(str)) {
            zzk.zzli();
            return 6;
        } else if ("c".equalsIgnoreCase(str)) {
            return zzk.zzli().zzwf();
        } else {
            return -1;
        }
    }

    private final void zzv(boolean z) {
        if (this.zzdao != null) {
            this.zzdao.zzw(z);
        }
    }

    @VisibleForTesting
    static String zza(Context context, zzdh zzdh, String str, View view, @Nullable Activity activity) {
        if (zzdh == null) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (zzdh.zzd(parse)) {
                parse = zzdh.zza(parse, context, view, activity);
            }
            return parse.toString();
        } catch (zzdi unused) {
            return str;
        } catch (Exception e) {
            zzk.zzlk().zza(e, "OpenGmsgHandler.maybeAddClickSignalsToUrl");
            return str;
        }
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbhx zzbhx = (zzbhx) obj;
        String zzd = zzavx.zzd((String) map.get("u"), zzbhx.getContext(), true);
        String str = (String) map.get(NotificationBundleProcessor.PUSH_ADDITIONAL_DATA_KEY);
        if (str == null) {
            zzawz.zzep("Action missing from an open GMSG.");
        } else if (this.zzdan != null && !this.zzdan.zzkx()) {
            this.zzdan.zzbk(zzd);
        } else if ("expand".equalsIgnoreCase(str)) {
            if (((zzbhy) zzbhx).zzaan()) {
                zzawz.zzep("Cannot expand WebView that is already expanded.");
                return;
            }
            zzv(false);
            ((zzbic) zzbhx).zzc(zzc(map), zzd(map));
        } else if ("webapp".equalsIgnoreCase(str)) {
            zzv(false);
            if (zzd != null) {
                ((zzbic) zzbhx).zza(zzc(map), zzd(map), zzd);
            } else {
                ((zzbic) zzbhx).zza(zzc(map), zzd(map), (String) map.get("html"), (String) map.get("baseurl"));
            }
        } else if (!"app".equalsIgnoreCase(str) || !"true".equalsIgnoreCase((String) map.get("system_browser"))) {
            zzv(true);
            String str2 = (String) map.get("intent_url");
            Intent intent = null;
            if (!TextUtils.isEmpty(str2)) {
                try {
                    intent = Intent.parseUri(str2, 0);
                } catch (URISyntaxException e) {
                    String valueOf = String.valueOf(str2);
                    zzawz.zzc(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e);
                }
            }
            if (!(intent == null || intent.getData() == null)) {
                Uri data = intent.getData();
                String uri = data.toString();
                if (!TextUtils.isEmpty(uri)) {
                    try {
                        uri = zza(zzbhx.getContext(), ((zzbif) zzbhx).zzaal(), uri, ((zzbih) zzbhx).getView(), zzbhx.zzyd());
                    } catch (Exception e2) {
                        zzawz.zzc("Error occurred while adding signals.", e2);
                        zzk.zzlk().zza(e2, "OpenGmsgHandler.onGmsg");
                    }
                    try {
                        data = Uri.parse(uri);
                    } catch (Exception e3) {
                        String valueOf2 = String.valueOf(uri);
                        zzawz.zzc(valueOf2.length() != 0 ? "Error parsing the uri: ".concat(valueOf2) : new String("Error parsing the uri: "), e3);
                        zzk.zzlk().zza(e3, "OpenGmsgHandler.onGmsg");
                    }
                }
                intent.setData(data);
            }
            if (intent != null) {
                ((zzbic) zzbhx).zza(new zzc(intent));
                return;
            }
            if (!TextUtils.isEmpty(zzd)) {
                zzd = zza(zzbhx.getContext(), ((zzbif) zzbhx).zzaal(), zzd, ((zzbih) zzbhx).getView(), zzbhx.zzyd());
            }
            ((zzbic) zzbhx).zza(new zzc((String) map.get("i"), zzd, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
        } else {
            zzv(true);
            if (TextUtils.isEmpty(zzd)) {
                zzawz.zzep("Destination url cannot be empty.");
                return;
            }
            try {
                ((zzbic) zzbhx).zza(new zzc(new zzaht(zzbhx.getContext(), ((zzbif) zzbhx).zzaal(), ((zzbih) zzbhx).getView()).zze(map)));
            } catch (ActivityNotFoundException e4) {
                zzawz.zzep(e4.getMessage());
            }
        }
    }
}
