package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.facebook.common.util.UriUtil;
import java.util.Map;

public final class zzcci implements zzaho<Object> {
    private final zzdte<zzccd> zzfnv;
    private final zzccj zzfpz;
    @Nullable
    private final zzafo zzfsg;

    public zzcci(zzbzc zzbzc, zzbyt zzbyt, zzccj zzccj, zzdte<zzccd> zzdte) {
        this.zzfsg = zzbzc.zzfo(zzbyt.getCustomTemplateId());
        this.zzfpz = zzccj;
        this.zzfnv = zzdte;
    }

    public final void zzaji() {
        if (this.zzfsg != null) {
            this.zzfpz.zza("/nativeAdCustomClick", (zzaho<Object>) this);
        }
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get(UriUtil.LOCAL_ASSET_SCHEME);
        try {
            this.zzfsg.zza(this.zzfnv.get(), str);
        } catch (RemoteException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            zzawz.zzd(sb.toString(), e);
        }
    }
}
