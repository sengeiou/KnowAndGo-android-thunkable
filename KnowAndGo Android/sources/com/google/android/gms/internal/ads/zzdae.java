package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public final class zzdae {
    private final Clock zzbsa;
    private final String zzbsx;
    private final String zzcig;
    private final String zzdlo;
    private final Executor zzffi;
    private final zzcmu zzfkx;
    private final zzbah zzgnr;
    private final Context zzlj;

    public zzdae(Executor executor, zzbah zzbah, zzcmu zzcmu, zzbai zzbai, String str, String str2, Context context, Clock clock) {
        this.zzffi = executor;
        this.zzgnr = zzbah;
        this.zzfkx = zzcmu;
        this.zzbsx = zzbai.zzbsx;
        this.zzdlo = str;
        this.zzcig = str2;
        this.zzlj = context;
        this.zzbsa = clock;
    }

    public final void zza(zzcxu zzcxu, zzcxm zzcxm, List<String> list) {
        zza(zzcxu, zzcxm, false, list);
    }

    public final void zza(zzcxu zzcxu, @Nullable zzcxm zzcxm, boolean z, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String str = z ? "1" : "0";
        for (String zzc : list) {
            String zzc2 = zzc(zzc(zzc(zzc, "@gw_adlocid@", zzcxu.zzgkx.zzfjp.zzglb), "@gw_adnetrefresh@", str), "@gw_sdkver@", this.zzbsx);
            if (zzcxm != null) {
                zzc2 = zzavx.zzd(zzc(zzc(zzc(zzc2, "@gw_qdata@", zzcxm.zzdfk), "@gw_adnetid@", zzcxm.zzatl), "@gw_allocid@", zzcxm.zzdej), this.zzlj, zzcxm.zzdok);
            }
            arrayList.add(zzc(zzc(zzc(zzc2, "@gw_adnetstatus@", this.zzfkx.zzaku()), "@gw_seqnum@", this.zzdlo), "@gw_sessid@", this.zzcig));
        }
        zzh(arrayList);
    }

    public final void zza(zzcxu zzcxu, zzcxm zzcxm, List<String> list, zzasr zzasr) {
        long currentTimeMillis = this.zzbsa.currentTimeMillis();
        try {
            String type = zzasr.getType();
            String num = Integer.toString(zzasr.getAmount());
            ArrayList arrayList = new ArrayList();
            String zzfz = zzfz(zzcxu.zzgkx.zzfjp.zzgle);
            String zzfz2 = zzfz(zzcxu.zzgkx.zzfjp.zzglf);
            for (String zzc : list) {
                arrayList.add(zzavx.zzd(zzc(zzc(zzc(zzc(zzc(zzc(zzc, "@gw_rwd_userid@", Uri.encode(zzfz)), "@gw_rwd_custom_data@", Uri.encode(zzfz2)), "@gw_tmstmp@", Long.toString(currentTimeMillis)), "@gw_rwd_itm@", Uri.encode(type)), "@gw_rwd_amt@", num), "@gw_sdkver@", this.zzbsx), this.zzlj, zzcxm.zzdok));
            }
            zzh(arrayList);
        } catch (RemoteException unused) {
        }
    }

    public final void zzh(List<String> list) {
        for (String zzed : list) {
            zzed(zzed);
        }
    }

    public final void zzed(String str) {
        this.zzffi.execute(new zzdaf(this, str));
    }

    private static String zzc(String str, String str2, @Nullable String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    @Nullable
    private static String zzfz(@Nullable String str) {
        return (TextUtils.isEmpty(str) || !zzazx.isEnabled()) ? str : "fakeForAdDebugLog";
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzga(String str) {
        this.zzgnr.zzed(str);
    }
}
