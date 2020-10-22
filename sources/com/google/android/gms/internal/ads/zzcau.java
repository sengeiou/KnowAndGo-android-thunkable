package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p022fi.iki.elonen.NanoHTTPD;

public final class zzcau {
    private final zzbai zzbtc;
    private final zzady zzdgs;
    private final zzwj zzejd;
    private final zzdh zzeko;
    private final Executor zzffi;
    private final ScheduledExecutorService zzfiw;
    private final zzcan zzfrl;
    private final zza zzfrm;
    private final zzcbi zzfrn;
    private final Context zzlj;

    public zzcau(Context context, zzcan zzcan, zzdh zzdh, zzbai zzbai, zza zza, zzwj zzwj, Executor executor, zzcxv zzcxv, zzcbi zzcbi, ScheduledExecutorService scheduledExecutorService) {
        this.zzlj = context;
        this.zzfrl = zzcan;
        this.zzeko = zzdh;
        this.zzbtc = zzbai;
        this.zzfrm = zza;
        this.zzejd = zzwj;
        this.zzffi = executor;
        this.zzdgs = zzcxv.zzdgs;
        this.zzfrn = zzcbi;
        this.zzfiw = scheduledExecutorService;
    }

    public static List<zzabj> zzi(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return Collections.emptyList();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzabj zzk = zzk(optJSONArray.optJSONObject(i));
            if (zzk != null) {
                arrayList.add(zzk);
            }
        }
        return arrayList;
    }

    @Nullable
    public static zzabj zzj(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mute");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzk(optJSONObject);
    }

    @Nullable
    private static zzabj zzk(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzabj(optString, optString2);
    }

    public final zzbbh<zzadw> zzc(JSONObject jSONObject, String str) {
        return zza(jSONObject.optJSONObject(str), this.zzdgs.zzcym);
    }

    public final zzbbh<List<zzadw>> zzd(JSONObject jSONObject, String str) {
        return zza(jSONObject.optJSONArray(str), this.zzdgs.zzcym, this.zzdgs.zzbqe);
    }

    private final zzbbh<List<zzadw>> zza(@Nullable JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzbar.zzm(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(zza(jSONArray.optJSONObject(i), z));
        }
        return zzbar.zza(zzbar.zze(arrayList), zzcav.zzdrn, this.zzffi);
    }

    private final zzbbh<zzadw> zza(@Nullable JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzbar.zzm(null);
        }
        String optString = jSONObject.optString(ImagesContract.URL);
        if (TextUtils.isEmpty(optString)) {
            return zzbar.zzm(null);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt("width", -1);
        int optInt2 = jSONObject.optInt("height", -1);
        if (z) {
            return zzbar.zzm(new zzadw((Drawable) null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return zza(jSONObject.optBoolean("require"), zzbar.zza(this.zzfrl.zza(optString, optDouble, optBoolean), new zzcaw(optString, optDouble, optInt, optInt2), this.zzffi), (Object) null);
    }

    public final zzbbh<zzadt> zze(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzbar.zzm(null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return zza(optJSONObject.optBoolean("require"), zzbar.zza(zza(optJSONArray, false, true), new zzcax(this, optJSONObject), this.zzffi), (Object) null);
    }

    private static Integer zzf(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final zzbbh<zzbgz> zzl(JSONObject jSONObject) {
        JSONObject zza = zzazc.zza(jSONObject, "html_containers", "instream");
        if (zza == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(MimeTypes.BASE_TYPE_VIDEO);
            if (optJSONObject == null) {
                return zzbar.zzm(null);
            }
            if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
                zzawz.zzep("Required field 'vast_xml' is missing");
                return zzbar.zzm(null);
            }
            return zza(zzbar.zza(this.zzfrn.zzm(optJSONObject), (long) ((Integer) zzyt.zzpe().zzd(zzacu.zzcse)).intValue(), TimeUnit.SECONDS, this.zzfiw), (Object) null);
        }
        return zza(zza.optBoolean("require"), this.zzfrn.zzq(zza.optString("base_url"), zza.optString("html")), (Object) null);
    }

    private static <T> zzbbh<T> zza(zzbbh<T> zzbbh, T t) {
        return zzbar.zza(zzbbh, Exception.class, new zzcaz((Object) null), zzbbm.zzeaf);
    }

    private static <T> zzbbh<T> zza(boolean z, zzbbh<T> zzbbh, T t) {
        if (z) {
            return zzbar.zza(zzbbh, new zzcba(zzbbh), zzbbm.zzeaf);
        }
        return zza(zzbbh, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zzb(String str, Object obj) throws Exception {
        zzk.zzlh();
        zzbgz zza = zzbhf.zza(this.zzlj, zzbin.zzabu(), "native-omid", false, false, this.zzeko, this.zzbtc, (zzadi) null, (zzj) null, this.zzfrm, this.zzejd);
        zzbbq zzn = zzbbq.zzn(zza);
        zza.zzaai().zza((zzbij) new zzcbb(zzn));
        zza.loadData(str, NanoHTTPD.MIME_HTML, "UTF-8");
        return zzn;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzadt zza(JSONObject jSONObject, List list) {
        Integer num = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString("text");
        Integer zzf = zzf(jSONObject, "bg_color");
        Integer zzf2 = zzf(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        int optInt3 = jSONObject.optInt("presentation_ms", 4000);
        if (optInt > 0) {
            num = Integer.valueOf(optInt);
        }
        return new zzadt(optString, list, zzf, zzf2, num, optInt3 + optInt2, this.zzdgs.zzbqf, optBoolean);
    }
}
