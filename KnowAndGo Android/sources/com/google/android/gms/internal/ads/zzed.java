package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;

final class zzed {
    static zzdbq zzya;

    static boolean zzb(zzdy zzdy) throws IllegalAccessException, InvocationTargetException {
        Method zzc;
        if (zzya != null) {
            return true;
        }
        String str = (String) zzyt.zzpe().zzd(zzacu.zzcrl);
        if (str == null || str.length() == 0) {
            if (zzdy == null || (zzc = zzdy.zzc("zu6uZ8u7nNJHsIXbotuBCEBd9hieUh9UBKC94dMPsF422AtJb3FisPSqZI3W+06A", "tm6XtP5M5qvCs+TffoCZhF/AF3Fx7Ow8iqgApPbgXSw=")) == null) {
                str = null;
            } else {
                str = (String) zzc.invoke((Object) null, new Object[0]);
            }
            if (str == null) {
                return false;
            }
        }
        try {
            try {
                zzdbu zzl = zzdbz.zzl(zzcg.zza(str, true));
                zzdbl.zza(zzddc.zzgpt);
                zzdcf.zza(new zzddg());
                zzya = (zzdbq) zzdcf.zza(zzdcf.zza(zzl, (zzdbs) null, zzdbq.class));
                if (zzya != null) {
                    return true;
                }
                return false;
            } catch (GeneralSecurityException unused) {
                return false;
            }
        } catch (IllegalArgumentException unused2) {
            return false;
        }
    }
}
