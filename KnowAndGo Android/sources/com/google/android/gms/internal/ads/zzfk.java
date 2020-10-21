package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class zzfk implements Callable {
    private final String TAG = getClass().getSimpleName();
    private final String className;
    private final int zzaaa;
    private final int zzaab;
    protected final zzdy zzvd;
    protected final zzbp.zza.C4378zza zzzm;
    private final String zzzu;
    protected Method zzzw;

    public zzfk(zzdy zzdy, String str, String str2, zzbp.zza.C4378zza zza, int i, int i2) {
        this.zzvd = zzdy;
        this.className = str;
        this.zzzu = str2;
        this.zzzm = zza;
        this.zzaaa = i;
        this.zzaab = i2;
    }

    /* access modifiers changed from: protected */
    public abstract void zzcx() throws IllegalAccessException, InvocationTargetException;

    /* renamed from: zzcz */
    public Void call() throws Exception {
        try {
            long nanoTime = System.nanoTime();
            this.zzzw = this.zzvd.zzc(this.className, this.zzzu);
            if (this.zzzw == null) {
                return null;
            }
            zzcx();
            zzda zzcm = this.zzvd.zzcm();
            if (!(zzcm == null || this.zzaaa == Integer.MIN_VALUE)) {
                zzcm.zza(this.zzaab, this.zzaaa, (System.nanoTime() - nanoTime) / 1000);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }
}
