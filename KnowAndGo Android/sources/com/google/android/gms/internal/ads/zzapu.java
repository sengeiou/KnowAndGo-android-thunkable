package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.C1603R;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

@zzard
public final class zzapu extends zzaqb {
    private final Map<String, String> zzcxs;
    /* access modifiers changed from: private */
    public final Context zzlj;

    public zzapu(zzbgz zzbgz, Map<String, String> map) {
        super(zzbgz, "storePicture");
        this.zzcxs = map;
        this.zzlj = zzbgz.zzyd();
    }

    public final void execute() {
        if (this.zzlj == null) {
            zzdh("Activity context is not available");
            return;
        }
        zzk.zzlg();
        if (!zzaxi.zzao(this.zzlj).zzqk()) {
            zzdh("Feature is not supported by the device.");
            return;
        }
        String str = this.zzcxs.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzdh("Image url cannot be empty.");
        } else if (!URLUtil.isValidUrl(str)) {
            String valueOf = String.valueOf(str);
            zzdh(valueOf.length() != 0 ? "Invalid image url: ".concat(valueOf) : new String("Invalid image url: "));
        } else {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            zzk.zzlg();
            if (!zzaxi.zzdz(lastPathSegment)) {
                String valueOf2 = String.valueOf(lastPathSegment);
                zzdh(valueOf2.length() != 0 ? "Image type not recognized: ".concat(valueOf2) : new String("Image type not recognized: "));
                return;
            }
            Resources resources = zzk.zzlk().getResources();
            zzk.zzlg();
            AlertDialog.Builder zzan = zzaxi.zzan(this.zzlj);
            zzan.setTitle(resources != null ? resources.getString(C1603R.string.f167s1) : "Save image");
            zzan.setMessage(resources != null ? resources.getString(C1603R.string.f168s2) : "Allow Ad to store image in Picture gallery?");
            zzan.setPositiveButton(resources != null ? resources.getString(C1603R.string.f169s3) : "Accept", new zzapv(this, str, lastPathSegment));
            zzan.setNegativeButton(resources != null ? resources.getString(C1603R.string.f170s4) : "Decline", new zzapw(this));
            zzan.create().show();
        }
    }
}
