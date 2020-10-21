package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

final class zzcho implements zzban<zzcxu> {
    private final /* synthetic */ zzchl zzfwz;

    zzcho(zzchl zzchl) {
        this.zzfwz = zzchl;
    }

    public final void zzb(Throwable th) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwt)).booleanValue()) {
            Matcher matcher = zzchl.zzfwx.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zzfwz.zzfww.zzdo(Integer.parseInt(matcher.group(1)));
            }
        }
    }

    public final /* synthetic */ void zzk(Object obj) {
        zzcxu zzcxu = (zzcxu) obj;
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwt)).booleanValue()) {
            this.zzfwz.zzfww.zzdo(zzcxu.zzgky.zzgku.responseCode);
            this.zzfwz.zzfww.zzeu(zzcxu.zzgky.zzgku.zzfyb);
        }
    }
}
