package com.google.android.gms.internal.ads;

import android.content.Context;
import com.facebook.common.util.UriUtil;
import java.io.IOException;

public final class zzjt implements zzkf {
    private final zzkf zzapz;
    private final zzkf zzaqa;
    private final zzkf zzaqb;
    private zzkf zzaqc;

    public zzjt(Context context, String str) {
        this(context, (zzke) null, str, false);
    }

    private zzjt(Context context, zzke zzke, String str, boolean z) {
        this(context, (zzke) null, new zzjs(str, (zzkn<String>) null, (zzke) null, 8000, 8000, false));
    }

    private zzjt(Context context, zzke zzke, zzkf zzkf) {
        this.zzapz = (zzkf) zzkh.checkNotNull(zzkf);
        this.zzaqa = new zzjv((zzke) null);
        this.zzaqb = new zzjm(context, (zzke) null);
    }

    public final long zza(zzjq zzjq) throws IOException {
        zzkh.checkState(this.zzaqc == null);
        String scheme = zzjq.uri.getScheme();
        if (UriUtil.HTTP_SCHEME.equals(scheme) || UriUtil.HTTPS_SCHEME.equals(scheme)) {
            this.zzaqc = this.zzapz;
        } else if (UriUtil.LOCAL_FILE_SCHEME.equals(scheme)) {
            if (zzjq.uri.getPath().startsWith("/android_asset/")) {
                this.zzaqc = this.zzaqb;
            } else {
                this.zzaqc = this.zzaqa;
            }
        } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(scheme)) {
            this.zzaqc = this.zzaqb;
        } else {
            throw new zzju(scheme);
        }
        return this.zzaqc.zza(zzjq);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return this.zzaqc.read(bArr, i, i2);
    }

    public final void close() throws IOException {
        if (this.zzaqc != null) {
            try {
                this.zzaqc.close();
            } finally {
                this.zzaqc = null;
            }
        }
    }
}
