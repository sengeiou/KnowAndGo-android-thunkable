package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.Nullable;
import org.json.JSONObject;

public final class zzcvy implements zzcva<zzcvx> {
    private final String packageName;
    private final zzbbl zzfqw;
    private final zzasc zzgiy;
    private final Context zzlj;

    public zzcvy(@Nullable zzasc zzasc, Context context, String str, zzbbl zzbbl) {
        this.zzgiy = zzasc;
        this.zzlj = context;
        this.packageName = str;
        this.zzfqw = zzbbl;
    }

    public final zzbbh<zzcvx> zzalm() {
        return this.zzfqw.zza(new zzcvz(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcvx zzamb() throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (this.zzgiy != null) {
            this.zzgiy.zza(this.zzlj, this.packageName, jSONObject);
        }
        return new zzcvx(jSONObject);
    }
}
