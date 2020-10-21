package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzbkw;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public abstract class zzbjm implements zzblp {
    @GuardedBy("AppComponent.class")
    private static zzbjm zzeod;

    /* access modifiers changed from: protected */
    public abstract zzcvs zza(zzcwx zzcwx);

    public abstract Executor zzace();

    public abstract zzbbl zzacf();

    public abstract zzbtb zzacg();

    public abstract zzclc zzach();

    public abstract zzbkz zzaci();

    public abstract zzbod zzacj();

    public abstract zzbwt zzack();

    public abstract zzbxp zzacl();

    public abstract zzcdg zzacm();

    public abstract zzcqp zzacn();

    public static zzbjm zza(Context context, zzamp zzamp, int i) {
        zzbjm zzd = zzd(context, i);
        zzd.zzach().zzb(zzamp);
        return zzd;
    }

    @Deprecated
    public static zzbjm zzd(Context context, int i) {
        synchronized (zzbjm.class) {
            if (zzeod == null) {
                return zza(new zzbai(15000000, i, true, false), context, (zzbkw.zza) new zzbkb());
            }
            zzbjm zzbjm = zzeod;
            return zzbjm;
        }
    }

    @Deprecated
    private static zzbjm zza(zzbai zzbai, Context context, zzbkw.zza zza) {
        zzbjm zzbjm;
        synchronized (zzbjm.class) {
            if (zzeod == null) {
                zzeod = new zzbkn().zzc(new zzbjn(new zzbjn.zza().zza(zzbai).zzbo(context))).zza(new zzbkw(zza)).zzaec();
                zzacu.initialize(context);
                zzk.zzlk().zzd(context, zzbai);
                zzk.zzlm().initialize(context);
                zzk.zzlg().zzak(context);
                zzk.zzlg().zzal(context);
                zzawx.zzaj(context);
                zzk.zzlj().initialize(context);
                zzk.zzmb().initialize(context);
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwt)).booleanValue()) {
                    new zzcjr(context, zzbai, new zzwj(new zzwo(context)), new zzcjc(new zzcja(context), zzeod.zzacf())).zzakp();
                }
            }
            zzbjm = zzeod;
        }
        return zzbjm;
    }

    public final zzcvs zza(zzarx zzarx) {
        return zza(new zzcwx(zzarx));
    }
}
