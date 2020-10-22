package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzg;
import java.util.HashMap;
import java.util.Map;

public final class zzcyk {
    private final zzbai zzbrc;
    private final zzawm zzbrw;
    private final Map<String, zzcym> zzglr = new HashMap();
    private final zzdh zzgls;
    private final Context zzys;

    public zzcyk(Context context, zzbai zzbai, zzawm zzawm) {
        this.zzys = context;
        this.zzbrc = zzbai;
        this.zzbrw = zzawm;
        this.zzgls = new zzdh(new zzg(context, zzbai));
    }

    public final zzcym zzfw(@Nullable String str) {
        if (str == null) {
            return zzamt();
        }
        if (this.zzglr.containsKey(str)) {
            return this.zzglr.get(str);
        }
        zzcym zzfx = zzfx(str);
        this.zzglr.put(str, zzfx);
        return zzfx;
    }

    private final zzcym zzamt() {
        return new zzcym(this.zzys, this.zzbrw.zzvc(), this.zzbrw.zzve(), this.zzgls);
    }

    private final zzcym zzfx(String str) {
        zzasq zzv = zzasq.zzv(this.zzys);
        try {
            zzv.setAppPackageName(str);
            zzaxc zzaxc = new zzaxc();
            zzaxc.zza(this.zzys, str, false);
            zzaxf zzaxf = new zzaxf(this.zzbrw.zzvc(), zzaxc);
            return new zzcym(zzv, zzaxf, new zzawu(zzazt.zzwz(), zzaxf), new zzdh(new zzg(this.zzys, this.zzbrc)));
        } catch (PackageManager.NameNotFoundException unused) {
            return zzamt();
        }
    }
}
