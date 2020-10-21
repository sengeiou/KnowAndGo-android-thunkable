package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import java.util.Map;

@TargetApi(16)
@zzard
public final class zzbgk extends zzbgl {
    public zzbgk(zzbdf zzbdf) {
        super(zzbdf);
    }

    /* access modifiers changed from: protected */
    public final int zzzw() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final zzhn zzfa(String str) {
        return new zzgl(this.mContext, Uri.parse(str), (Map<String, String>) null, 2);
    }
}
