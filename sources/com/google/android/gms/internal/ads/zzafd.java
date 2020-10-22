package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

@zzard
public final class zzafd extends NativeContentAd {
    private final VideoController zzcje = new VideoController();
    private final List<NativeAd.Image> zzcyt = new ArrayList();
    private final NativeAd.AdChoicesInfo zzcyv;
    private final zzafa zzcyw;
    private final zzael zzcyx;

    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007a A[Catch:{ RemoteException -> 0x0087 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzafd(com.google.android.gms.internal.ads.zzafa r5) {
        /*
            r4 = this;
            r4.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r4.zzcyt = r0
            com.google.android.gms.ads.VideoController r0 = new com.google.android.gms.ads.VideoController
            r0.<init>()
            r4.zzcje = r0
            r4.zzcyw = r5
            r5 = 0
            com.google.android.gms.internal.ads.zzafa r0 = r4.zzcyw     // Catch:{ RemoteException -> 0x0055 }
            java.util.List r0 = r0.getImages()     // Catch:{ RemoteException -> 0x0055 }
            if (r0 == 0) goto L_0x005b
            java.util.Iterator r0 = r0.iterator()     // Catch:{ RemoteException -> 0x0055 }
        L_0x0020:
            boolean r1 = r0.hasNext()     // Catch:{ RemoteException -> 0x0055 }
            if (r1 == 0) goto L_0x005b
            java.lang.Object r1 = r0.next()     // Catch:{ RemoteException -> 0x0055 }
            boolean r2 = r1 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0055 }
            if (r2 == 0) goto L_0x0047
            android.os.IBinder r1 = (android.os.IBinder) r1     // Catch:{ RemoteException -> 0x0055 }
            if (r1 == 0) goto L_0x0047
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)     // Catch:{ RemoteException -> 0x0055 }
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaei     // Catch:{ RemoteException -> 0x0055 }
            if (r3 == 0) goto L_0x0040
            r1 = r2
            com.google.android.gms.internal.ads.zzaei r1 = (com.google.android.gms.internal.ads.zzaei) r1     // Catch:{ RemoteException -> 0x0055 }
            goto L_0x0048
        L_0x0040:
            com.google.android.gms.internal.ads.zzaek r2 = new com.google.android.gms.internal.ads.zzaek     // Catch:{ RemoteException -> 0x0055 }
            r2.<init>(r1)     // Catch:{ RemoteException -> 0x0055 }
            r1 = r2
            goto L_0x0048
        L_0x0047:
            r1 = r5
        L_0x0048:
            if (r1 == 0) goto L_0x0020
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r2 = r4.zzcyt     // Catch:{ RemoteException -> 0x0055 }
            com.google.android.gms.internal.ads.zzael r3 = new com.google.android.gms.internal.ads.zzael     // Catch:{ RemoteException -> 0x0055 }
            r3.<init>(r1)     // Catch:{ RemoteException -> 0x0055 }
            r2.add(r3)     // Catch:{ RemoteException -> 0x0055 }
            goto L_0x0020
        L_0x0055:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzbad.zzc(r1, r0)
        L_0x005b:
            com.google.android.gms.internal.ads.zzafa r0 = r4.zzcyw     // Catch:{ RemoteException -> 0x0069 }
            com.google.android.gms.internal.ads.zzaei r0 = r0.zzrl()     // Catch:{ RemoteException -> 0x0069 }
            if (r0 == 0) goto L_0x006f
            com.google.android.gms.internal.ads.zzael r1 = new com.google.android.gms.internal.ads.zzael     // Catch:{ RemoteException -> 0x0069 }
            r1.<init>(r0)     // Catch:{ RemoteException -> 0x0069 }
            goto L_0x0070
        L_0x0069:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzbad.zzc(r1, r0)
        L_0x006f:
            r1 = r5
        L_0x0070:
            r4.zzcyx = r1
            com.google.android.gms.internal.ads.zzafa r0 = r4.zzcyw     // Catch:{ RemoteException -> 0x0087 }
            com.google.android.gms.internal.ads.zzaea r0 = r0.zzrj()     // Catch:{ RemoteException -> 0x0087 }
            if (r0 == 0) goto L_0x008d
            com.google.android.gms.internal.ads.zzaed r0 = new com.google.android.gms.internal.ads.zzaed     // Catch:{ RemoteException -> 0x0087 }
            com.google.android.gms.internal.ads.zzafa r1 = r4.zzcyw     // Catch:{ RemoteException -> 0x0087 }
            com.google.android.gms.internal.ads.zzaea r1 = r1.zzrj()     // Catch:{ RemoteException -> 0x0087 }
            r0.<init>(r1)     // Catch:{ RemoteException -> 0x0087 }
            r5 = r0
            goto L_0x008d
        L_0x0087:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzbad.zzc(r1, r0)
        L_0x008d:
            r4.zzcyv = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafd.<init>(com.google.android.gms.internal.ads.zzafa):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: zzrh */
    public final IObjectWrapper zzkq() {
        try {
            return this.zzcyw.zzrh();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zzcyw.performClick(bundle);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzcyw.recordImpression(bundle);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzcyw.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    public final CharSequence getHeadline() {
        try {
            return this.zzcyw.getHeadline();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzcyt;
    }

    public final CharSequence getBody() {
        try {
            return this.zzcyw.getBody();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final NativeAd.Image getLogo() {
        return this.zzcyx;
    }

    public final CharSequence getCallToAction() {
        try {
            return this.zzcyw.getCallToAction();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final CharSequence getAdvertiser() {
        try {
            return this.zzcyw.getAdvertiser();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zzcyw.getVideoController() != null) {
                this.zzcje.zza(this.zzcyw.getVideoController());
            }
        } catch (RemoteException e) {
            zzbad.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcje;
    }

    public final Bundle getExtras() {
        try {
            return this.zzcyw.getExtras();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzcyv;
    }

    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.zzcyw.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final void destroy() {
        try {
            this.zzcyw.destroy();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
