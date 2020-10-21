package com.google.android.gms.internal.ads;

import android.provider.Settings;
import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

public final class zzel extends zzfk {
    public zzel(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 49);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzzm.zzf(zzbz.ENUM_FAILURE);
        try {
            this.zzzm.zzf(((Boolean) this.zzzw.invoke((Object) null, new Object[]{this.zzvd.getContext()})).booleanValue() ? zzbz.ENUM_TRUE : zzbz.ENUM_FALSE);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
