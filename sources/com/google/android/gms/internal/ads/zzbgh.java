package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import com.google.android.exoplayer2.util.MimeTypes;

@TargetApi(16)
@zzard
public final class zzbgh extends zzbgl {
    private final String mimeType = null;

    public zzbgh(zzbdf zzbdf, String str) {
        super(zzbdf);
    }

    /* access modifiers changed from: protected */
    public final int zzzw() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final zzhn zzfa(String str) {
        zzjp zzjt = new zzjt(this.mContext, this.zzdyb);
        return new zzig(Uri.parse(str), ((Boolean) zzyt.zzpe().zzd(zzacu.zzctr)).booleanValue() ? new zzbeh(this.mContext, zzjt, new zzbgi(this)) : zzjt, MimeTypes.VIDEO_WEBM.equals(this.mimeType) ? new zzjg() : new zziv(), 2, ((Integer) zzyt.zzpe().zzd(zzacu.zzclw)).intValue());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(boolean z, long j) {
        zzbdf zzbdf = (zzbdf) this.zzeht.get();
        if (zzbdf != null) {
            zzbbm.zzeae.execute(new zzbgj(zzbdf, z, j));
        }
    }
}
