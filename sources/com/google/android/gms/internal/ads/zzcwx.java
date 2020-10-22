package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import java.util.List;
import javax.annotation.Nullable;

public final class zzcwx {
    private final zzarx zzfxh;

    public zzcwx(zzarx zzarx) {
        this.zzfxh = zzarx;
    }

    public final String zzamc() {
        return this.zzfxh.packageName;
    }

    public final String zzamd() {
        return this.zzfxh.zzdot.getString("ms");
    }

    @Nullable
    public final PackageInfo zzame() {
        return this.zzfxh.zzdlm;
    }

    public final boolean zzamf() {
        return this.zzfxh.zzdou;
    }

    public final List<String> zzamg() {
        return this.zzfxh.zzdly;
    }

    public final ApplicationInfo zzamh() {
        return this.zzfxh.applicationInfo;
    }

    public final String zzami() {
        return this.zzfxh.zzdov;
    }
}
