package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

@zzard
public final class zzazi extends zzawv {
    private final String url;
    private final zzbah zzdxw;

    public zzazi(Context context, String str, String str2) {
        this(str2, zzk.zzlg().zzq(context, str));
    }

    private zzazi(String str, String str2) {
        this.zzdxw = new zzbah(str2);
        this.url = str;
    }

    public final void zzto() {
        this.zzdxw.zzed(this.url);
    }
}
