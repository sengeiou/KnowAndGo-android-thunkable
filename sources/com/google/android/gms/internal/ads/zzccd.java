package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;

public final class zzccd extends zzaff {
    private final zzbyt zzfmq;
    /* access modifiers changed from: private */
    public final zzbyn zzfpj;
    private final zzbzl zzfse;
    private final Context zzys;

    public zzccd(Context context, zzbyt zzbyt, zzbzl zzbzl, zzbyn zzbyn) {
        this.zzys = context;
        this.zzfmq = zzbyt;
        this.zzfse = zzbzl;
        this.zzfpj = zzbyn;
    }

    public final IObjectWrapper zzrh() {
        return null;
    }

    public final String zzcj(String str) {
        return this.zzfmq.zzaid().get(str);
    }

    public final zzaei zzck(String str) {
        return this.zzfmq.zzaic().get(str);
    }

    public final List<String> getAvailableAssetNames() {
        SimpleArrayMap<String, zzadw> zzaic = this.zzfmq.zzaic();
        SimpleArrayMap<String, String> zzaid = this.zzfmq.zzaid();
        String[] strArr = new String[(zzaic.size() + zzaid.size())];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < zzaic.size()) {
            strArr[i3] = zzaic.keyAt(i2);
            i2++;
            i3++;
        }
        while (i < zzaid.size()) {
            strArr[i3] = zzaid.keyAt(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    public final String getCustomTemplateId() {
        return this.zzfmq.getCustomTemplateId();
    }

    public final void performClick(String str) {
        this.zzfpj.zzfi(str);
    }

    public final void recordImpression() {
        this.zzfpj.zzahk();
    }

    public final zzaar getVideoController() {
        return this.zzfmq.getVideoController();
    }

    public final void destroy() {
        this.zzfpj.destroy();
    }

    public final IObjectWrapper zzrm() {
        return ObjectWrapper.wrap(this.zzys);
    }

    public final boolean zzp(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || !this.zzfse.zza((ViewGroup) unwrap)) {
            return false;
        }
        this.zzfmq.zzahz().zza((zzadx) new zzcce(this));
        return true;
    }
}
