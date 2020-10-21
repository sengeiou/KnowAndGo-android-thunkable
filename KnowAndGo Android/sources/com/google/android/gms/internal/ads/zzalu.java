package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
@zzard
public final class zzalu<I, O> implements zzalj<I, O> {
    private final zzakh zzddn;
    /* access modifiers changed from: private */
    public final zzall<O> zzddo;
    private final zzalm<I> zzddp;
    private final String zzddq;

    zzalu(zzakh zzakh, String str, zzalm<I> zzalm, zzall<O> zzall) {
        this.zzddn = zzakh;
        this.zzddq = str;
        this.zzddp = zzalm;
        this.zzddo = zzall;
    }

    public final zzbbh<O> zzi(I i) {
        zzbbr zzbbr = new zzbbr();
        zzakw zzb = this.zzddn.zzb((zzdh) null);
        zzb.zza(new zzalv(this, zzb, i, zzbbr), new zzalw(this, zzbbr, zzb));
        return zzbbr;
    }

    /* access modifiers changed from: private */
    public final void zza(zzakw zzakw, zzalf zzalf, I i, zzbbr<O> zzbbr) {
        try {
            zzk.zzlg();
            String zzwb = zzaxi.zzwb();
            zzagz.zzdae.zza(zzwb, (zzahw) new zzalx(this, zzakw, zzbbr));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", zzwb);
            jSONObject.put("args", this.zzddp.zzj(i));
            zzalf.zzb(this.zzddq, jSONObject);
        } catch (Exception e) {
            zzbbr.setException(e);
            zzawz.zzc("Unable to invokeJavascript", e);
            zzakw.release();
        } catch (Throwable th) {
            zzakw.release();
            throw th;
        }
    }

    public final zzbbh<O> zzf(@Nullable I i) throws Exception {
        return zzi(i);
    }
}
