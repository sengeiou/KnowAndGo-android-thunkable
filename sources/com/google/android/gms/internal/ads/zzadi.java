package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@zzard
public final class zzadi {
    private final Object lock = new Object();
    @VisibleForTesting
    boolean zzcxq = true;
    private final List<zzadg> zzcxr = new LinkedList();
    private final Map<String, String> zzcxs = new LinkedHashMap();
    @Nullable
    private zzadi zzcxt;

    public zzadi(boolean z, String str, String str2) {
        this.zzcxs.put("action", str);
        this.zzcxs.put("ad_format", str2);
    }

    public final void zzc(@Nullable zzadi zzadi) {
        synchronized (this.lock) {
            this.zzcxt = zzadi;
        }
    }

    @Nullable
    public final zzadg zzfa(long j) {
        if (!this.zzcxq) {
            return null;
        }
        return new zzadg(j, (String) null, (zzadg) null);
    }

    public final boolean zza(zzadg zzadg, long j, String... strArr) {
        synchronized (this.lock) {
            for (String zzadg2 : strArr) {
                this.zzcxr.add(new zzadg(j, zzadg2, zzadg));
            }
        }
        return true;
    }

    public final String zzqx() {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        synchronized (this.lock) {
            for (zzadg next : this.zzcxr) {
                long time = next.getTime();
                String zzqu = next.zzqu();
                zzadg zzqv = next.zzqv();
                if (zzqv != null && time > 0) {
                    sb2.append(zzqu);
                    sb2.append('.');
                    sb2.append(time - zzqv.getTime());
                    sb2.append(',');
                }
            }
            this.zzcxr.clear();
            if (!TextUtils.isEmpty((CharSequence) null)) {
                sb2.append((String) null);
            } else if (sb2.length() > 0) {
                sb2.setLength(sb2.length() - 1);
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public final void zzh(String str, String str2) {
        zzacy zzuw;
        if (this.zzcxq && !TextUtils.isEmpty(str2) && (zzuw = zzk.zzlk().zzuw()) != null) {
            synchronized (this.lock) {
                zzadc zzch = zzuw.zzch(str);
                Map<String, String> map = this.zzcxs;
                map.put(str, zzch.zzg(map.get(str), str2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final Map<String, String> zzqy() {
        synchronized (this.lock) {
            zzacy zzuw = zzk.zzlk().zzuw();
            if (zzuw != null) {
                if (this.zzcxt != null) {
                    Map<String, String> zza = zzuw.zza(this.zzcxs, this.zzcxt.zzqy());
                    return zza;
                }
            }
            Map<String, String> map = this.zzcxs;
            return map;
        }
    }
}
