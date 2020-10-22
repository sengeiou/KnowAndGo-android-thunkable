package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzavb;
import com.google.android.gms.internal.ads.zzaxi;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@zzard
public final class zzb {
    private boolean zzbqv;
    private zzavb zzbqw;
    private zzark zzbqx = null;
    private final Context zzlj;

    public zzb(Context context, zzavb zzavb, zzark zzark) {
        this.zzlj = context;
        this.zzbqw = zzavb;
        if (this.zzbqx == null) {
            this.zzbqx = new zzark();
        }
    }

    private final boolean zzkw() {
        return (this.zzbqw != null && this.zzbqw.zzuc().zzdrw) || this.zzbqx.zzdom;
    }

    public final void recordClick() {
        this.zzbqv = true;
    }

    public final boolean zzkx() {
        return !zzkw() || this.zzbqv;
    }

    public final void zzbk(@Nullable String str) {
        if (zzkw()) {
            if (str == null) {
                str = "";
            }
            if (this.zzbqw != null) {
                this.zzbqw.zza(str, (Map<String, String>) null, 3);
            } else if (this.zzbqx.zzdom && this.zzbqx.zzdon != null) {
                for (String next : this.zzbqx.zzdon) {
                    if (!TextUtils.isEmpty(next)) {
                        String replace = next.replace("{NAVIGATION_URL}", Uri.encode(str));
                        zzk.zzlg();
                        zzaxi.zzb(this.zzlj, "", replace);
                    }
                }
            }
        }
    }
}
