package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

final class zzbki extends zzcvs {
    private final /* synthetic */ zzbkc zzeqe;
    private zzdtu<String> zzeqj;
    private zzdtu<zzcez> zzeql;
    private zzdtu<Map<zzczs, zzcez>> zzeqn;
    private zzdtu<Set<zzbuz<zzczz>>> zzeqp;
    private zzdtu<Set<zzbuz<zzczz>>> zzeqz;
    private zzdtu zzera;
    private zzdtu<zzczt> zzerb;
    private zzdtu<ApplicationInfo> zzesc;
    private zzcwx zzezf;
    private zzdtu<zzcvo> zzezg;
    private zzdtu<String> zzezh;
    private zzdtu<zzcvy> zzezi;
    private zzdtu<zzcwc> zzezj;
    private zzdtu<zzcwj> zzezk;
    private zzdtu<Boolean> zzezl;
    private zzdtu<zzcwq> zzezm;
    private zzdtu<zzcwu> zzezn;
    private zzdtu<zzcxh> zzezo;
    private zzdtu<zzcez> zzezp;
    private zzdtu<zzcez> zzezq;
    private zzdtu<zzcez> zzezr;

    private zzbki(zzbkc zzbkc, zzcwx zzcwx) {
        this.zzeqe = zzbkc;
        this.zzezf = zzcwx;
        this.zzezg = new zzcvr(zzbln.zzafa(), this.zzeqe.zzeos, this.zzeqe.zzeoo, zzcyx.zzamw());
        this.zzezh = new zzcwy(zzcwx);
        this.zzezi = new zzcwa(zzbjy.zzacs(), this.zzeqe.zzeos, this.zzezh, zzcyx.zzamw());
        this.zzezj = new zzcwe(zzblj.zzaes(), zzcyx.zzamw(), this.zzeqe.zzeos);
        this.zzezk = new zzcwl(zzblk.zzaeu(), zzcyx.zzamw(), this.zzezh);
        this.zzezl = new zzcxa(zzcwx);
        this.zzesc = new zzcwz(zzcwx);
        this.zzezm = new zzcws(zzbll.zzaew(), this.zzeqe.zzeoo, this.zzezl, this.zzesc);
        this.zzezn = new zzcww(zzblm.zzaey(), this.zzeqe.zzeoo, this.zzeqe.zzeos);
        this.zzezo = new zzcxj(zzcyx.zzamw());
        this.zzeqj = new zzcxb(zzcwx);
        this.zzeql = zzdth.zzao(zzcet.zzajt());
        this.zzezp = zzdth.zzao(zzces.zzajs());
        this.zzezq = zzdth.zzao(zzceu.zzaju());
        this.zzezr = zzdth.zzao(zzcev.zzajv());
        this.zzeqn = zzdtk.zzho(4).zza(zzczs.GMS_SIGNALS, this.zzeql).zza(zzczs.BUILD_URL, this.zzezp).zza(zzczs.HTTP, this.zzezq).zza(zzczs.PRE_PROCESS, this.zzezr).zzbbf();
        this.zzeqp = zzdth.zzao(new zzcew(this.zzeqj, this.zzeqe.zzeos, zzcyx.zzamw(), this.zzeqn));
        this.zzeqz = zzdtq.zzao(0, 1).zzar(this.zzeqp).zzbbh();
        this.zzera = zzdab.zzan(this.zzeqz);
        this.zzerb = zzdth.zzao(zzdaa.zzq(zzcyx.zzamw(), this.zzeqe.zzeoo, this.zzera));
    }

    private final zzcwn zzadn() {
        return new zzcwn(zzbli.zzaer(), zzcyx.zzamx(), (List) zzdto.zza(this.zzezf.zzamg(), "Cannot return null from a non-@Nullable @Provides method"));
    }

    private final zzcvu zzado() {
        return new zzcvu(zzbln.zzafb(), zzcyx.zzamx(), (String) zzdto.zza(this.zzezf.zzamd(), "Cannot return null from a non-@Nullable @Provides method"), this.zzezf.zzame());
    }

    public final zzcvb<JSONObject> zzadp() {
        return new zzcvb<>(zzcyx.zzamx(), zzdtp.zzhp(11).zzas((zzcva) zzdto.zza(new zzctz(new zzcwj(zzblk.zzaev(), zzcyx.zzamx(), zzcwy.zzb(this.zzezf)), 0, (ScheduledExecutorService) this.zzeqe.zzeoo.get()), "Cannot return null from a non-@Nullable @Provides method")).zzas((zzcva) zzdto.zza(new zzctz(new zzcwq(zzbll.zzaex(), (ScheduledExecutorService) this.zzeqe.zzeoo.get(), this.zzezf.zzamf(), zzcwz.zzc(this.zzezf)), ((Long) zzyt.zzpe().zzd(zzacu.zzcsq)).longValue(), (ScheduledExecutorService) this.zzeqe.zzeoo.get()), "Cannot return null from a non-@Nullable @Provides method")).zzas((zzcva) zzdto.zza(new zzctz(new zzcwu(zzblm.zzaez(), (ScheduledExecutorService) this.zzeqe.zzeoo.get(), zzbjq.zza(this.zzeqe.zzeol)), ((Long) zzyt.zzpe().zzd(zzacu.zzctg)).longValue(), (ScheduledExecutorService) this.zzeqe.zzeoo.get()), "Cannot return null from a non-@Nullable @Provides method")).zzas((zzcva) zzdto.zza(new zzctz(new zzcvo(zzbln.zzafb(), zzbjq.zza(this.zzeqe.zzeol), (ScheduledExecutorService) this.zzeqe.zzeoo.get(), zzcyx.zzamx()), 0, (ScheduledExecutorService) this.zzeqe.zzeoo.get()), "Cannot return null from a non-@Nullable @Provides method")).zzas((zzcva) zzdto.zza(new zzctz(new zzcxh(zzcyx.zzamx()), 0, (ScheduledExecutorService) this.zzeqe.zzeoo.get()), "Cannot return null from a non-@Nullable @Provides method")).zzas(zzcxe.zzamj()).zzas(new zzcvy((zzasc) null, zzbjq.zza(this.zzeqe.zzeol), zzcwy.zzb(this.zzezf), zzcyx.zzamx())).zzas(new zzcwc(zzblj.zzaet(), zzcyx.zzamx(), zzbjq.zza(this.zzeqe.zzeol))).zzas(zzadn()).zzas(zzado()).zzas((zzcva) this.zzeqe.zzepa.get()).zzbbg());
    }

    public final zzcvb<JSONObject> zzadq() {
        return zzcxf.zza(this.zzeqe.zzepa.get(), zzado(), zzadn(), zzdth.zzap(this.zzezg), zzdth.zzap(this.zzezi), zzdth.zzap(this.zzezj), zzdth.zzap(this.zzezk), zzdth.zzap(this.zzezm), zzdth.zzap(this.zzezn), zzdth.zzap(this.zzezo), zzcyx.zzamx());
    }

    public final zzczt zzadr() {
        return this.zzerb.get();
    }
}
