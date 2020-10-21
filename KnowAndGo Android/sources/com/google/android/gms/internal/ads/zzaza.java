package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzaza extends zzr<zzp> {
    private final Map<String, String> zzab;
    private final zzbbr<zzp> zzdxo;
    private final zzazx zzdxp;

    public zzaza(String str, zzbbr<zzp> zzbbr) {
        this(str, (Map<String, String>) null, zzbbr);
    }

    private zzaza(String str, Map<String, String> map, zzbbr<zzp> zzbbr) {
        super(0, str, new zzazb(zzbbr));
        this.zzab = null;
        this.zzdxo = zzbbr;
        this.zzdxp = new zzazx();
        this.zzdxp.zza(str, "GET", (Map<String, ?>) null, (byte[]) null);
    }

    /* access modifiers changed from: protected */
    public final zzy<zzp> zza(zzp zzp) {
        return zzy.zza(zzp, zzaq.zzb(zzp));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zza(Object obj) {
        zzp zzp = (zzp) obj;
        this.zzdxp.zza((Map<String, ?>) zzp.zzab, zzp.statusCode);
        zzazx zzazx = this.zzdxp;
        byte[] bArr = zzp.data;
        if (zzazx.isEnabled() && bArr != null) {
            zzazx.zzj(bArr);
        }
        this.zzdxo.set(zzp);
    }
}
