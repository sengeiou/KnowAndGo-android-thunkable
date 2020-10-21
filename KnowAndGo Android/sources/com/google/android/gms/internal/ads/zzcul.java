package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

public final class zzcul implements zzcva<zzcuk> {
    private final List<zzcpk> zzdei;
    private final ScheduledExecutorService zzfiw;
    private final zzcxv zzfjp;
    private final zzbbl zzfqw;
    private String zzgft;
    private final Context zzlj;

    public zzcul(zzbbl zzbbl, ScheduledExecutorService scheduledExecutorService, String str, zzcpf zzcpf, Context context, zzcxv zzcxv) {
        this.zzfqw = zzbbl;
        this.zzfiw = scheduledExecutorService;
        this.zzgft = str;
        this.zzlj = context;
        this.zzfjp = zzcxv;
        if (zzcpf.zzakx().containsKey(zzcxv.zzglb)) {
            this.zzdei = zzcpf.zzakx().get(zzcxv.zzglb);
        } else {
            this.zzdei = Collections.emptyList();
        }
    }

    public final zzbbh<zzcuk> zzalm() {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcqt)).booleanValue()) {
            return zzbar.zza(this.zzfqw.zza(new zzcum(this)), new zzcun(this), (Executor) this.zzfqw);
        }
        return zzbar.zzm(null);
    }

    static final /* synthetic */ zzcuk zzf(List list) throws Exception {
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(((zzbbh) it.next()).get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return new zzcuk(jSONArray.toString());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzcpk zzcpk, Bundle bundle, zzcpl zzcpl, zzbbr zzbbr) {
        try {
            zzcpk.zzgdj.zza(ObjectWrapper.wrap(this.zzlj), this.zzgft, bundle, zzcpk.zzemv, this.zzfjp.zzdll, (zzaoy) zzcpl);
        } catch (Exception e) {
            zzbbr.setException(new Exception("Error calling adapter"));
            zzbad.zzc("", e);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh zzg(List list) throws Exception {
        return zzbar.zzf(list).zza(new zzcup(list), this.zzfqw);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ List zzalw() throws Exception {
        ArrayList arrayList = new ArrayList();
        for (zzcpk next : this.zzdei) {
            zzbbr zzbbr = new zzbbr();
            zzcpl zzcpl = new zzcpl(next, zzbbr);
            Bundle bundle = this.zzfjp.zzghg.zzcgv != null ? this.zzfjp.zzghg.zzcgv.getBundle(next.zzfis) : null;
            arrayList.add(zzbar.zza(zzbbr, ((Long) zzyt.zzpe().zzd(zzacu.zzcqs)).longValue(), TimeUnit.MILLISECONDS, this.zzfiw));
            this.zzfqw.execute(new zzcuo(this, next, bundle, zzcpl, zzbbr));
        }
        return arrayList;
    }
}
