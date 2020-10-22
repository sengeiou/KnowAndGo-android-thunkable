package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzbmg {
    private final String zzbsw;
    private final zzaly zzffh;
    /* access modifiers changed from: private */
    public final Executor zzffi;
    /* access modifiers changed from: private */
    public zzbmn zzffj;
    private final zzaho<Object> zzffk = new zzbmh(this);
    private final zzaho<Object> zzffl = new zzbmj(this);

    public zzbmg(String str, zzaly zzaly, Executor executor) {
        this.zzbsw = str;
        this.zzffh = zzaly;
        this.zzffi = executor;
    }

    public final void zza(zzbmn zzbmn) {
        this.zzffh.zzc("/updateActiveView", this.zzffk);
        this.zzffh.zzc("/untrackActiveViewUnit", this.zzffl);
        this.zzffj = zzbmn;
    }

    public final void zzd(zzbgz zzbgz) {
        zzbgz.zza("/updateActiveView", (zzaho<? super zzbgz>) this.zzffk);
        zzbgz.zza("/untrackActiveViewUnit", (zzaho<? super zzbgz>) this.zzffl);
    }

    public final void zze(zzbgz zzbgz) {
        zzbgz.zzb("/updateActiveView", (zzaho<? super zzbgz>) this.zzffk);
        zzbgz.zzb("/untrackActiveViewUnit", (zzaho<? super zzbgz>) this.zzffl);
    }

    public final void zzafc() {
        this.zzffh.zzd("/updateActiveView", this.zzffk);
        this.zzffh.zzd("/untrackActiveViewUnit", this.zzffl);
    }

    /* access modifiers changed from: private */
    public final boolean zzl(@Nullable Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        if (TextUtils.isEmpty(str) || !str.equals(this.zzbsw)) {
            return false;
        }
        return true;
    }
}
