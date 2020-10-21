package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

public final class zzex extends zzfk {
    private static final Object zzzl = new Object();
    private static volatile String zzzp;

    public zzex(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2) {
        super(zzdy, str, str2, zza, i, 1);
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        this.zzzm.zzx(ExifInterface.LONGITUDE_EAST);
        if (zzzp == null) {
            synchronized (zzzl) {
                if (zzzp == null) {
                    zzzp = (String) this.zzzw.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzzm) {
            this.zzzm.zzx(zzzp);
        }
    }
}
