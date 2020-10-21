package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public final class zzcre implements zzcva<zzcrd> {
    private final zzcxv zzfjp;
    private final zzbbl zzgfz;
    private final View zzgga;
    private final Context zzlj;

    public zzcre(zzbbl zzbbl, Context context, zzcxv zzcxv, @Nullable ViewGroup viewGroup) {
        this.zzgfz = zzbbl;
        this.zzlj = context;
        this.zzfjp = zzcxv;
        this.zzgga = viewGroup;
    }

    public final zzbbh<zzcrd> zzalm() {
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcnr)).booleanValue()) {
            return zzbar.zzd(new Exception("Ad Key signal disabled."));
        }
        return this.zzgfz.zza(new zzcrf(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcrd zzaln() throws Exception {
        Context context = this.zzlj;
        zzyd zzyd = this.zzfjp.zzdll;
        ArrayList arrayList = new ArrayList();
        View view = this.zzgga;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            int i = -1;
            if (parent instanceof ViewGroup) {
                i = ((ViewGroup) parent).indexOfChild(view);
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", i);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzcrd(context, zzyd, arrayList);
    }
}
