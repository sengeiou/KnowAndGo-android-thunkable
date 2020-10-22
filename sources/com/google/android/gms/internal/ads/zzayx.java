package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzayx extends zzax {
    private final /* synthetic */ byte[] zzdxl;
    private final /* synthetic */ Map zzdxm;
    private final /* synthetic */ zzazx zzdxn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzayx(zzayu zzayu, int i, String str, zzaa zzaa, zzz zzz, byte[] bArr, Map map, zzazx zzazx) {
        super(i, str, zzaa, zzz);
        this.zzdxl = bArr;
        this.zzdxm = map;
        this.zzdxn = zzazx;
    }

    public final byte[] zzg() throws zza {
        return this.zzdxl == null ? super.zzg() : this.zzdxl;
    }

    public final Map<String, String> getHeaders() throws zza {
        return this.zzdxm == null ? super.getHeaders() : this.zzdxm;
    }

    /* access modifiers changed from: protected */
    public final void zzh(String str) {
        this.zzdxn.zzek(str);
        super.zza(str);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zza(Object obj) {
        zza((String) obj);
    }
}
