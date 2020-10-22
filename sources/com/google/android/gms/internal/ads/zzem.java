package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

public final class zzem extends zzfk {
    private static zzfl<String> zzzf = new zzfl<>();
    private final Context zzzg;

    public zzem(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2, Context context) {
        super(zzdy, str, str2, zza, i, 29);
        this.zzzg = context;
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzzm.zzaa(ExifInterface.LONGITUDE_EAST);
        AtomicReference<String> zzar = zzzf.zzar(this.zzzg.getPackageName());
        if (zzar.get() == null) {
            synchronized (zzar) {
                if (zzar.get() == null) {
                    zzar.set((String) this.zzzw.invoke((Object) null, new Object[]{this.zzzg}));
                }
            }
        }
        String str = zzar.get();
        synchronized (this.zzzm) {
            this.zzzm.zzaa(zzcg.zza(str.getBytes(), true));
        }
    }
}
