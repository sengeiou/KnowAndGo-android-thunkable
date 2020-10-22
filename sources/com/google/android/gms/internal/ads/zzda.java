package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ConditionVariable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbi;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class zzda {
    /* access modifiers changed from: private */
    public static final ConditionVariable zzve = new ConditionVariable();
    @VisibleForTesting
    protected static volatile zzwo zzvf = null;
    private static volatile Random zzvh = null;
    /* access modifiers changed from: private */
    public zzdy zzvd;
    @VisibleForTesting
    protected volatile Boolean zzvg;

    public zzda(zzdy zzdy) {
        this.zzvd = zzdy;
        zzdy.zzch().execute(new zzdb(this));
    }

    public final void zza(int i, int i2, long j) {
        zza(i, i2, j, (Exception) null);
    }

    public final void zza(int i, int i2, long j, Exception exc) {
        try {
            zzve.block();
            if (this.zzvg.booleanValue() && zzvf != null) {
                zzbi.zza.C4376zza zzd = zzbi.zza.zzs().zzl(this.zzvd.zzlj.getPackageName()).zzd(j);
                if (exc != null) {
                    StringWriter stringWriter = new StringWriter();
                    zzdmb.zza((Throwable) exc, new PrintWriter(stringWriter));
                    zzd.zzm(stringWriter.toString()).zzn(exc.getClass().getName());
                }
                zzws zzg = zzvf.zzg(((zzbi.zza) ((zzdob) zzd.zzaya())).toByteArray());
                zzg.zzby(i);
                if (i2 != -1) {
                    zzg.zzbx(i2);
                }
                zzg.zzdj();
            }
        } catch (Exception unused) {
        }
    }

    public static int zzcd() {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ThreadLocalRandom.current().nextInt();
            }
            return zzce().nextInt();
        } catch (RuntimeException unused) {
            return zzce().nextInt();
        }
    }

    private static Random zzce() {
        if (zzvh == null) {
            synchronized (zzda.class) {
                if (zzvh == null) {
                    zzvh = new Random();
                }
            }
        }
        return zzvh;
    }
}
