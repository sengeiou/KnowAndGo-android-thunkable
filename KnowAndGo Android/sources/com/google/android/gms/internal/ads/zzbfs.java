package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzard
public final class zzbfs implements Iterable<zzbfq> {
    private final List<zzbfq> zzehs = new ArrayList();

    public static boolean zzc(zzbdf zzbdf) {
        zzbfq zzd = zzd(zzbdf);
        if (zzd == null) {
            return false;
        }
        zzd.zzehq.abort();
        return true;
    }

    static zzbfq zzd(zzbdf zzbdf) {
        Iterator<zzbfq> it = zzk.zzmc().iterator();
        while (it.hasNext()) {
            zzbfq next = it.next();
            if (next.zzebt == zzbdf) {
                return next;
            }
        }
        return null;
    }

    public final void zza(zzbfq zzbfq) {
        this.zzehs.add(zzbfq);
    }

    public final void zzb(zzbfq zzbfq) {
        this.zzehs.remove(zzbfq);
    }

    public final Iterator<zzbfq> iterator() {
        return this.zzehs.iterator();
    }
}
