package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class zzfi {
    private static final String TAG = "zzfi";
    private final String className;
    private final zzdy zzvd;
    private final String zzzu;
    private final int zzzv = 2;
    private volatile Method zzzw = null;
    private final Class<?>[] zzzx;
    private CountDownLatch zzzy = new CountDownLatch(1);

    public zzfi(zzdy zzdy, String str, String str2, Class<?>... clsArr) {
        this.zzvd = zzdy;
        this.className = str;
        this.zzzu = str2;
        this.zzzx = clsArr;
        this.zzvd.zzch().submit(new zzfj(this));
    }

    /* access modifiers changed from: private */
    public final void zzdb() {
        try {
            Class loadClass = this.zzvd.zzci().loadClass(zzb(this.zzvd.zzck(), this.className));
            if (loadClass != null) {
                this.zzzw = loadClass.getMethod(zzb(this.zzvd.zzck(), this.zzzu), this.zzzx);
                if (this.zzzw == null) {
                    this.zzzy.countDown();
                } else {
                    this.zzzy.countDown();
                }
            }
        } catch (zzdk unused) {
        } catch (UnsupportedEncodingException unused2) {
        } catch (ClassNotFoundException unused3) {
        } catch (NoSuchMethodException unused4) {
        } catch (NullPointerException unused5) {
        } finally {
            this.zzzy.countDown();
        }
    }

    private final String zzb(byte[] bArr, String str) throws zzdk, UnsupportedEncodingException {
        return new String(this.zzvd.zzcj().zza(bArr, str), "UTF-8");
    }

    public final Method zzdc() {
        if (this.zzzw != null) {
            return this.zzzw;
        }
        try {
            if (!this.zzzy.await(2, TimeUnit.SECONDS)) {
                return null;
            }
            return this.zzzw;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
