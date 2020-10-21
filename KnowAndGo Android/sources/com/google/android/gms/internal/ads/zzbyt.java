package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

public final class zzbyt {
    private Bundle extras;
    private zzaea zzcyo;
    private List<zzabj> zzczc = Collections.emptyList();
    private List<zzadw> zzend;
    private double zzeng;
    @Nullable
    private IObjectWrapper zzfih;
    private int zzfog;
    private zzaar zzfoh;
    private View zzfoi;
    private zzabj zzfoj;
    private zzbgz zzfok;
    @Nullable
    private zzbgz zzfol;
    private View zzfom;
    private IObjectWrapper zzfon;
    private zzaei zzfoo;
    private zzaei zzfop;
    private String zzfoq;
    private SimpleArrayMap<String, zzadw> zzfor = new SimpleArrayMap<>();
    private SimpleArrayMap<String, String> zzfos = new SimpleArrayMap<>();
    private float zzfot;

    public final synchronized void zzdn(int i) {
        this.zzfog = i;
    }

    public final synchronized void zzb(zzaar zzaar) {
        this.zzfoh = zzaar;
    }

    public final synchronized void zza(zzaea zzaea) {
        this.zzcyo = zzaea;
    }

    public final synchronized void setImages(List<zzadw> list) {
        this.zzend = list;
    }

    public final synchronized void zze(List<zzabj> list) {
        this.zzczc = list;
    }

    public final synchronized void zza(@Nullable zzabj zzabj) {
        this.zzfoj = zzabj;
    }

    public final synchronized void zzz(View view) {
        this.zzfom = view;
    }

    public final synchronized void setStarRating(double d) {
        this.zzeng = d;
    }

    public final synchronized void zza(zzaei zzaei) {
        this.zzfoo = zzaei;
    }

    public final synchronized void zzb(zzaei zzaei) {
        this.zzfop = zzaei;
    }

    public final synchronized void zzfl(String str) {
        this.zzfoq = str;
    }

    public final synchronized void zzh(zzbgz zzbgz) {
        this.zzfok = zzbgz;
    }

    public final synchronized void zzi(zzbgz zzbgz) {
        this.zzfol = zzbgz;
    }

    public final synchronized void zzan(IObjectWrapper iObjectWrapper) {
        this.zzfih = iObjectWrapper;
    }

    public final synchronized void zzp(String str, String str2) {
        if (str2 == null) {
            this.zzfos.remove(str);
        } else {
            this.zzfos.put(str, str2);
        }
    }

    public final synchronized void zza(String str, zzadw zzadw) {
        if (zzadw == null) {
            this.zzfor.remove(str);
        } else {
            this.zzfor.put(str, zzadw);
        }
    }

    private final synchronized void zzf(float f) {
        this.zzfot = f;
    }

    private final synchronized String zzfm(String str) {
        return this.zzfos.get(str);
    }

    public final synchronized int zzahv() {
        return this.zzfog;
    }

    public final synchronized zzaar getVideoController() {
        return this.zzfoh;
    }

    public final synchronized zzaea zzrj() {
        return this.zzcyo;
    }

    public final synchronized View zzahw() {
        return this.zzfoi;
    }

    public final synchronized String getHeadline() {
        return zzfm("headline");
    }

    public final synchronized List<zzadw> getImages() {
        return this.zzend;
    }

    public final synchronized List<zzabj> getMuteThisAdReasons() {
        return this.zzczc;
    }

    @Nullable
    public final synchronized zzabj zzahx() {
        return this.zzfoj;
    }

    public final synchronized String getBody() {
        return zzfm(TtmlNode.TAG_BODY);
    }

    public final synchronized Bundle getExtras() {
        if (this.extras == null) {
            this.extras = new Bundle();
        }
        return this.extras;
    }

    public final synchronized String getCallToAction() {
        return zzfm("call_to_action");
    }

    public final synchronized View zzahy() {
        return this.zzfom;
    }

    public final synchronized IObjectWrapper zzrk() {
        return this.zzfon;
    }

    public final synchronized String getStore() {
        return zzfm("store");
    }

    public final synchronized String getPrice() {
        return zzfm("price");
    }

    public final synchronized double getStarRating() {
        return this.zzeng;
    }

    public final synchronized zzaei zzri() {
        return this.zzfoo;
    }

    public final synchronized String getAdvertiser() {
        return zzfm("advertiser");
    }

    public final synchronized zzaei zzrl() {
        return this.zzfop;
    }

    public final synchronized String getCustomTemplateId() {
        return this.zzfoq;
    }

    public final synchronized zzbgz zzahz() {
        return this.zzfok;
    }

    @Nullable
    public final synchronized zzbgz zzaia() {
        return this.zzfol;
    }

    @Nullable
    public final synchronized IObjectWrapper zzaib() {
        return this.zzfih;
    }

    public final synchronized SimpleArrayMap<String, zzadw> zzaic() {
        return this.zzfor;
    }

    public final synchronized float zzsq() {
        return this.zzfot;
    }

    public final synchronized SimpleArrayMap<String, String> zzaid() {
        return this.zzfos;
    }

    public final synchronized void destroy() {
        if (this.zzfok != null) {
            this.zzfok.destroy();
            this.zzfok = null;
        }
        if (this.zzfol != null) {
            this.zzfol.destroy();
            this.zzfol = null;
        }
        this.zzfih = null;
        this.zzfor.clear();
        this.zzfos.clear();
        this.zzfoh = null;
        this.zzcyo = null;
        this.zzfoi = null;
        this.zzend = null;
        this.extras = null;
        this.zzfom = null;
        this.zzfon = null;
        this.zzfoo = null;
        this.zzfop = null;
        this.zzfoq = null;
    }

    public static zzbyt zza(zzand zzand) {
        try {
            zzaar videoController = zzand.getVideoController();
            zzaea zzrj = zzand.zzrj();
            String headline = zzand.getHeadline();
            List<zzadw> images = zzand.getImages();
            String body = zzand.getBody();
            Bundle extras2 = zzand.getExtras();
            String callToAction = zzand.getCallToAction();
            IObjectWrapper zzrk = zzand.zzrk();
            String advertiser = zzand.getAdvertiser();
            zzaei zzrl = zzand.zzrl();
            zzbyt zzbyt = new zzbyt();
            zzbyt.zzfog = 1;
            zzbyt.zzfoh = videoController;
            zzbyt.zzcyo = zzrj;
            zzbyt.zzfoi = (View) zzao(zzand.zzso());
            zzbyt.zzp("headline", headline);
            zzbyt.zzend = images;
            zzbyt.zzp(TtmlNode.TAG_BODY, body);
            zzbyt.extras = extras2;
            zzbyt.zzp("call_to_action", callToAction);
            zzbyt.zzfom = (View) zzao(zzand.zzsp());
            zzbyt.zzfon = zzrk;
            zzbyt.zzp("advertiser", advertiser);
            zzbyt.zzfop = zzrl;
            return zzbyt;
        } catch (RemoteException e) {
            zzawz.zzd("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzbyt zza(zzana zzana) {
        try {
            zzaar videoController = zzana.getVideoController();
            zzaea zzrj = zzana.zzrj();
            String headline = zzana.getHeadline();
            List<zzadw> images = zzana.getImages();
            String body = zzana.getBody();
            Bundle extras2 = zzana.getExtras();
            String callToAction = zzana.getCallToAction();
            IObjectWrapper zzrk = zzana.zzrk();
            String store = zzana.getStore();
            String price = zzana.getPrice();
            double starRating = zzana.getStarRating();
            zzaei zzri = zzana.zzri();
            zzbyt zzbyt = new zzbyt();
            zzbyt.zzfog = 2;
            zzbyt.zzfoh = videoController;
            zzbyt.zzcyo = zzrj;
            zzbyt.zzfoi = (View) zzao(zzana.zzso());
            zzbyt.zzp("headline", headline);
            zzbyt.zzend = images;
            zzbyt.zzp(TtmlNode.TAG_BODY, body);
            zzbyt.extras = extras2;
            zzbyt.zzp("call_to_action", callToAction);
            zzbyt.zzfom = (View) zzao(zzana.zzsp());
            zzbyt.zzfon = zzrk;
            zzbyt.zzp("store", store);
            zzbyt.zzp("price", price);
            zzbyt.zzeng = starRating;
            zzbyt.zzfoo = zzri;
            return zzbyt;
        } catch (RemoteException e) {
            zzawz.zzd("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzbyt zzb(zzang zzang) {
        try {
            return zza(zzang.getVideoController(), zzang.zzrj(), (View) zzao(zzang.zzso()), zzang.getHeadline(), zzang.getImages(), zzang.getBody(), zzang.getExtras(), zzang.getCallToAction(), (View) zzao(zzang.zzsp()), zzang.zzrk(), zzang.getStore(), zzang.getPrice(), zzang.getStarRating(), zzang.zzri(), zzang.getAdvertiser(), zzang.zzsq());
        } catch (RemoteException e) {
            zzawz.zzd("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public static zzbyt zzb(zzana zzana) {
        try {
            return zza(zzana.getVideoController(), zzana.zzrj(), (View) zzao(zzana.zzso()), zzana.getHeadline(), zzana.getImages(), zzana.getBody(), zzana.getExtras(), zzana.getCallToAction(), (View) zzao(zzana.zzsp()), zzana.zzrk(), zzana.getStore(), zzana.getPrice(), zzana.getStarRating(), zzana.zzri(), (String) null, 0.0f);
        } catch (RemoteException e) {
            zzawz.zzd("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzbyt zzb(zzand zzand) {
        try {
            return zza(zzand.getVideoController(), zzand.zzrj(), (View) zzao(zzand.zzso()), zzand.getHeadline(), zzand.getImages(), zzand.getBody(), zzand.getExtras(), zzand.getCallToAction(), (View) zzao(zzand.zzsp()), zzand.zzrk(), (String) null, (String) null, -1.0d, zzand.zzrl(), zzand.getAdvertiser(), 0.0f);
        } catch (RemoteException e) {
            zzawz.zzd("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzbyt zza(zzaar zzaar, zzaea zzaea, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzaei zzaei, String str6, float f) {
        zzbyt zzbyt = new zzbyt();
        zzbyt.zzfog = 6;
        zzbyt.zzfoh = zzaar;
        zzbyt.zzcyo = zzaea;
        zzbyt.zzfoi = view;
        String str7 = str;
        zzbyt.zzp("headline", str);
        zzbyt.zzend = list;
        String str8 = str2;
        zzbyt.zzp(TtmlNode.TAG_BODY, str2);
        zzbyt.extras = bundle;
        String str9 = str3;
        zzbyt.zzp("call_to_action", str3);
        zzbyt.zzfom = view2;
        zzbyt.zzfon = iObjectWrapper;
        String str10 = str4;
        zzbyt.zzp("store", str4);
        String str11 = str5;
        zzbyt.zzp("price", str5);
        zzbyt.zzeng = d;
        zzbyt.zzfoo = zzaei;
        zzbyt.zzp("advertiser", str6);
        zzbyt.zzf(f);
        return zzbyt;
    }

    private static <T> T zzao(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }
}
