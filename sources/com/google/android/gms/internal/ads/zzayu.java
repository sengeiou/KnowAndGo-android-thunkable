package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@zzard
public final class zzayu {
    private static zzv zzdxh;
    private static final Object zzdxi = new Object();
    @Deprecated
    private static final zzayy<Void> zzdxj = new zzayv();

    public zzayu(Context context) {
        zzbd(context.getApplicationContext() != null ? context.getApplicationContext() : context);
    }

    public static zzbbh<zzp> zzeg(String str) {
        zzbbr zzbbr = new zzbbr();
        zzdxh.zze(new zzaza(str, zzbbr));
        return zzbbr;
    }

    public final zzbbh<String> zza(int i, String str, @Nullable Map<String, String> map, @Nullable byte[] bArr) {
        String str2 = str;
        zzayz zzayz = new zzayz((zzayv) null);
        zzayw zzayw = new zzayw(this, str2, zzayz);
        zzazx zzazx = new zzazx((String) null);
        zzayx zzayx = new zzayx(this, i, str, zzayz, zzayw, bArr, map, zzazx);
        if (zzazx.isEnabled()) {
            try {
                zzazx.zza(str2, "GET", zzayx.getHeaders(), zzayx.zzg());
            } catch (zza e) {
                zzawz.zzep(e.getMessage());
            }
        }
        zzdxh.zze(zzayx);
        return zzayz;
    }

    public final zzbbh<String> zzc(String str, Map<String, String> map) {
        return zza(0, str, map, (byte[]) null);
    }

    @VisibleForTesting
    private static zzv zzbd(Context context) {
        zzv zzv;
        zzv zzv2;
        synchronized (zzdxi) {
            if (zzdxh == null) {
                zzacu.initialize(context);
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzctv)).booleanValue()) {
                    zzv2 = zzayl.zzbc(context);
                } else {
                    zzv2 = new zzv(new zzan(new File(context.getCacheDir(), "volley")), new zzak((zzaj) new zzat()));
                    zzv2.start();
                }
                zzdxh = zzv2;
            }
            zzv = zzdxh;
        }
        return zzv;
    }
}
