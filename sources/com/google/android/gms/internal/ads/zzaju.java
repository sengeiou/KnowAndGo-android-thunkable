package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@zzard
public class zzaju<ReferenceT> implements zzajt {
    @GuardedBy("this")
    private final Map<String, CopyOnWriteArrayList<zzaho<? super ReferenceT>>> zzdbn = new HashMap();
    private ReferenceT zzdbo;

    public final void zzg(ReferenceT referencet) {
        this.zzdbo = referencet;
    }

    public final boolean zzcs(@Nullable String str) {
        return str != null && zzg(Uri.parse(str));
    }

    public final boolean zzg(Uri uri) {
        if (!"gmsg".equalsIgnoreCase(uri.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            return false;
        }
        zzh(uri);
        return true;
    }

    public final void zzh(Uri uri) {
        String path = uri.getPath();
        zzk.zzlg();
        zzb(path, zzaxi.zzi(uri));
    }

    private final synchronized void zzb(String str, Map<String, String> map) {
        if (zzawz.isLoggable(2)) {
            String valueOf = String.valueOf(str);
            zzawz.zzds(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
            for (String next : map.keySet()) {
                String str2 = map.get(next);
                StringBuilder sb = new StringBuilder(String.valueOf(next).length() + 4 + String.valueOf(str2).length());
                sb.append("  ");
                sb.append(next);
                sb.append(": ");
                sb.append(str2);
                zzawz.zzds(sb.toString());
            }
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.zzdbn.get(str);
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                zzbbm.zzeae.execute(new zzajv(this, (zzaho) it.next(), map));
            }
        }
    }

    public final synchronized void zza(String str, zzaho<? super ReferenceT> zzaho) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.zzdbn.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.zzdbn.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(zzaho);
    }

    public final synchronized void zzb(String str, zzaho<? super ReferenceT> zzaho) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.zzdbn.get(str);
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(zzaho);
        }
    }

    public final synchronized void zza(String str, Predicate<zzaho<? super ReferenceT>> predicate) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.zzdbn.get(str);
        if (copyOnWriteArrayList != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                zzaho zzaho = (zzaho) it.next();
                if (predicate.apply(zzaho)) {
                    arrayList.add(zzaho);
                }
            }
            copyOnWriteArrayList.removeAll(arrayList);
        }
    }

    public final synchronized void reset() {
        this.zzdbn.clear();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzaho zzaho, Map map) {
        zzaho.zza(this.zzdbo, map);
    }
}
