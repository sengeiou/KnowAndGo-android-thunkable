package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzdno {
    private static volatile boolean zzhdz = false;
    private static final Class<?> zzhea = zzaxc();
    private static volatile zzdno zzheb;
    static final zzdno zzhec = new zzdno(true);
    private final Map<zza, zzdob.zzd<?, ?>> zzhed;

    private static Class<?> zzaxc() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.object == zza.object && this.number == zza.number) {
                return true;
            }
            return false;
        }
    }

    public static zzdno zzaxd() {
        return zzdnn.zzaxa();
    }

    public static zzdno zzaxe() {
        zzdno zzdno = zzheb;
        if (zzdno == null) {
            synchronized (zzdno.class) {
                zzdno = zzheb;
                if (zzdno == null) {
                    zzdno = zzdnn.zzaxb();
                    zzheb = zzdno;
                }
            }
        }
        return zzdno;
    }

    static zzdno zzaxb() {
        return zzdnz.zzb(zzdno.class);
    }

    public final <ContainingType extends zzdpk> zzdob.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zzhed.get(new zza(containingtype, i));
    }

    zzdno() {
        this.zzhed = new HashMap();
    }

    private zzdno(boolean z) {
        this.zzhed = Collections.emptyMap();
    }
}
