package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzacu;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzawz;
import com.google.android.gms.internal.ads.zzaxg;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzdc;
import com.google.android.gms.internal.ads.zzdg;
import com.google.android.gms.internal.ads.zzyt;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@zzard
public final class zzg implements zzdc, Runnable {
    private final List<Object[]> zzbra = new Vector();
    private final AtomicReference<zzdc> zzbrb = new AtomicReference<>();
    private zzbai zzbrc;
    private CountDownLatch zzbrd = new CountDownLatch(1);
    private Context zzlj;

    public zzg(Context context, zzbai zzbai) {
        this.zzlj = context;
        this.zzbrc = zzbai;
        zzyt.zzpa();
        if (zzazt.zzwy()) {
            zzaxg.zzc(this);
        } else {
            run();
        }
    }

    private final boolean zzla() {
        try {
            this.zzbrd.await();
            return true;
        } catch (InterruptedException e) {
            zzawz.zzd("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    private final void zzlb() {
        if (!this.zzbra.isEmpty()) {
            for (Object[] next : this.zzbra) {
                if (next.length == 1) {
                    this.zzbrb.get().zza((MotionEvent) next[0]);
                } else if (next.length == 3) {
                    this.zzbrb.get().zza(((Integer) next[0]).intValue(), ((Integer) next[1]).intValue(), ((Integer) next[2]).intValue());
                }
            }
            this.zzbra.clear();
        }
    }

    private static Context zze(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final String zza(Context context) {
        zzdc zzdc;
        if (!zzla() || (zzdc = this.zzbrb.get()) == null) {
            return "";
        }
        zzlb();
        return zzdc.zza(zze(context));
    }

    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, (Activity) null);
    }

    public final String zza(Context context, String str, View view, Activity activity) {
        zzdc zzdc;
        if (!zzla() || (zzdc = this.zzbrb.get()) == null) {
            return "";
        }
        zzlb();
        return zzdc.zza(zze(context), str, view, activity);
    }

    public final void zzb(View view) {
        zzdc zzdc = this.zzbrb.get();
        if (zzdc != null) {
            zzdc.zzb(view);
        }
    }

    public final void zza(MotionEvent motionEvent) {
        zzdc zzdc = this.zzbrb.get();
        if (zzdc != null) {
            zzlb();
            zzdc.zza(motionEvent);
            return;
        }
        this.zzbra.add(new Object[]{motionEvent});
    }

    public final void zza(int i, int i2, int i3) {
        zzdc zzdc = this.zzbrb.get();
        if (zzdc != null) {
            zzlb();
            zzdc.zza(i, i2, i3);
            return;
        }
        this.zzbra.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final void run() {
        boolean z = false;
        try {
            boolean z2 = this.zzbrc.zzdze;
            if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcpb)).booleanValue() && z2) {
                z = true;
            }
            this.zzbrb.set(zzdg.zza(this.zzbrc.zzbsx, zze(this.zzlj), z));
        } finally {
            this.zzbrd.countDown();
            this.zzlj = null;
            this.zzbrc = null;
        }
    }
}
