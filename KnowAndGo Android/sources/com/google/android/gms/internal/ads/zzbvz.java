package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Set;

public class zzbvz {
    @Nullable
    private final zzbgz zzdbs;
    private final zzbwz zzflm;

    public zzbvz(zzbwz zzbwz) {
        this(zzbwz, (zzbgz) null);
    }

    public zzbvz(zzbwz zzbwz, @Nullable zzbgz zzbgz) {
        this.zzflm = zzbwz;
        this.zzdbs = zzbgz;
    }

    public final zzbwz zzaha() {
        return this.zzflm;
    }

    @Nullable
    public final zzbgz zzafn() {
        return this.zzdbs;
    }

    @Nullable
    public final View zzahb() {
        if (this.zzdbs == null) {
            return null;
        }
        return this.zzdbs.getWebView();
    }

    public Set<zzbuz<zzbrl>> zza(zzbxc zzbxc) {
        return Collections.singleton(zzbuz.zzb(zzbxc, zzbbm.zzeaf));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzahc() {
        if (this.zzdbs.zzaae() != null) {
            this.zzdbs.zzaae().close();
        }
    }
}
