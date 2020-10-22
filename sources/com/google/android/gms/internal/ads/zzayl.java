package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;
import java.util.regex.Pattern;

@zzard
public final class zzayl extends zzak {
    private final Context zzlj;

    public static zzv zzbc(Context context) {
        zzv zzv = new zzv(new zzan(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzayl(context, new zzat()));
        zzv.start();
        return zzv;
    }

    private zzayl(Context context, zzas zzas) {
        super(zzas);
        this.zzlj = context;
    }

    public final zzp zzc(zzr<?> zzr) throws zzaf {
        if (zzr.zzh() && zzr.getMethod() == 0) {
            if (Pattern.matches((String) zzyt.zzpe().zzd(zzacu.zzctw), zzr.getUrl())) {
                zzyt.zzpa();
                if (zzazt.zzc(this.zzlj, 13400000)) {
                    zzp zzc = new zzaii(this.zzlj).zzc(zzr);
                    if (zzc != null) {
                        String valueOf = String.valueOf(zzr.getUrl());
                        zzawz.zzds(valueOf.length() != 0 ? "Got gmscore asset response: ".concat(valueOf) : new String("Got gmscore asset response: "));
                        return zzc;
                    }
                    String valueOf2 = String.valueOf(zzr.getUrl());
                    zzawz.zzds(valueOf2.length() != 0 ? "Failed to get gmscore asset response: ".concat(valueOf2) : new String("Failed to get gmscore asset response: "));
                }
            }
        }
        return super.zzc(zzr);
    }
}
