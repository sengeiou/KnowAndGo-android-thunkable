package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdha;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class zzdca<P> {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final Class<P> zzgpd;
    private ConcurrentMap<String, List<zzdcb<P>>> zzgpj = new ConcurrentHashMap();
    private zzdcb<P> zzgpk;

    public final zzdcb<P> zzanu() {
        return this.zzgpk;
    }

    private zzdca(Class<P> cls) {
        this.zzgpd = cls;
    }

    public static <P> zzdca<P> zza(Class<P> cls) {
        return new zzdca<>(cls);
    }

    public final void zza(zzdcb<P> zzdcb) {
        this.zzgpk = zzdcb;
    }

    public final zzdcb<P> zza(P p, zzdha.zzb zzb) throws GeneralSecurityException {
        byte[] bArr;
        switch (zzdbn.zzgpa[zzb.zzanw().ordinal()]) {
            case 1:
            case 2:
                bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zzb.zzasp()).array();
                break;
            case 3:
                bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zzb.zzasp()).array();
                break;
            case 4:
                bArr = zzdbm.zzgoz;
                break;
            default:
                throw new GeneralSecurityException("unknown output prefix type");
        }
        zzdcb<P> zzdcb = new zzdcb<>(p, bArr, zzb.zzaso(), zzb.zzanw());
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzdcb);
        String str = new String(zzdcb.zzanx(), UTF_8);
        List list = (List) this.zzgpj.put(str, Collections.unmodifiableList(arrayList));
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            arrayList2.add(zzdcb);
            this.zzgpj.put(str, Collections.unmodifiableList(arrayList2));
        }
        return zzdcb;
    }

    public final Class<P> zzanr() {
        return this.zzgpd;
    }
}
