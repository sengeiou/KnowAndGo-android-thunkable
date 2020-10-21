package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import com.google.android.gms.ads.internal.zzk;

final class zzapv implements DialogInterface.OnClickListener {
    private final /* synthetic */ String zzdin;
    private final /* synthetic */ String zzdio;
    private final /* synthetic */ zzapu zzdip;

    zzapv(zzapu zzapu, String str, String str2) {
        this.zzdip = zzapu;
        this.zzdin = str;
        this.zzdio = str2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DownloadManager downloadManager = (DownloadManager) this.zzdip.zzlj.getSystemService("download");
        try {
            String str = this.zzdin;
            String str2 = this.zzdio;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            zzk.zzli();
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.zzdip.zzdh("Could not store picture.");
        }
    }
}
