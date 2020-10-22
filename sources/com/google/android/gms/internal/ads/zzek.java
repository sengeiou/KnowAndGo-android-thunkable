package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

public final class zzek extends zzfk {
    private final Activity zzzd;
    private final View zzze;

    public zzek(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2, View view, Activity activity) {
        super(zzdy, str, str2, zza, i, 62);
        this.zzze = view;
        this.zzzd = activity;
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (this.zzze != null) {
            boolean booleanValue = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcrf)).booleanValue();
            Object[] objArr = (Object[]) this.zzzw.invoke((Object) null, new Object[]{this.zzze, this.zzzd, Boolean.valueOf(booleanValue)});
            synchronized (this.zzzm) {
                this.zzzm.zzbp(((Long) objArr[0]).longValue());
                this.zzzm.zzbq(((Long) objArr[1]).longValue());
                if (booleanValue) {
                    this.zzzm.zzae((String) objArr[2]);
                }
            }
        }
    }
}
