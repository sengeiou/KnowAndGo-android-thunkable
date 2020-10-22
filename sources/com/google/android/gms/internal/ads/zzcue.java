package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

public final class zzcue implements zzcva<zzcud> {
    private final Bundle zzfjv;
    private final zzbbl zzfqw;

    public zzcue(zzbbl zzbbl, @Nullable Bundle bundle) {
        this.zzfqw = zzbbl;
        this.zzfjv = bundle;
    }

    public final zzbbh<zzcud> zzalm() {
        return this.zzfqw.zza(new zzcuf(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcud zzalv() throws Exception {
        return new zzcud(this.zzfjv);
    }
}
