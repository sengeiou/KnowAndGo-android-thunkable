package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

@zzard
public final class zzaez extends NativeAppInstallAd {
    private final VideoController zzcje = new VideoController();
    private final zzaew zzcys;
    private final List<NativeAd.Image> zzcyt = new ArrayList();
    private final zzael zzcyu;
    private final NativeAd.AdChoicesInfo zzcyv;

    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007a A[Catch:{ RemoteException -> 0x0087 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzaez(com.google.android.gms.internal.ads.zzaew r5) {
        /*
            r4 = this;
            r4.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r4.zzcyt = r0
            com.google.android.gms.ads.VideoController r0 = new com.google.android.gms.ads.VideoController
            r0.<init>()
            r4.zzcje = r0
            r4.zzcys = r5
            r5 = 0
            com.google.android.gms.internal.ads.zzaew r0 = r4.zzcys     // Catch:{ RemoteException -> 0x0055 }
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
            com.google.android.gms.internal.ads.zzaew r0 = r4.zzcys     // Catch:{ RemoteException -> 0x0069 }
            com.google.android.gms.internal.ads.zzaei r0 = r0.zzri()     // Catch:{ RemoteException -> 0x0069 }
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
            r4.zzcyu = r1
            com.google.android.gms.internal.ads.zzaew r0 = r4.zzcys     // Catch:{ RemoteException -> 0x0087 }
            com.google.android.gms.internal.ads.zzaea r0 = r0.zzrj()     // Catch:{ RemoteException -> 0x0087 }
            if (r0 == 0) goto L_0x008d
            com.google.android.gms.internal.ads.zzaed r0 = new com.google.android.gms.internal.ads.zzaed     // Catch:{ RemoteException -> 0x0087 }
            com.google.android.gms.internal.ads.zzaew r1 = r4.zzcys     // Catch:{ RemoteException -> 0x0087 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaez.<init>(com.google.android.gms.internal.ads.zzaew):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: zzrh */
    public final IObjectWrapper zzkq() {
        try {
            return this.zzcys.zzrh();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zzcys.performClick(bundle);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzcys.recordImpression(bundle);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzcys.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    public final CharSequence getHeadline() {
        try {
            return this.zzcys.getHeadline();
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
            return this.zzcys.getBody();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final NativeAd.Image getIcon() {
        return this.zzcyu;
    }

    public final CharSequence getCallToAction() {
        try {
            return this.zzcys.getCallToAction();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final Double getStarRating() {
        try {
            double starRating = this.zzcys.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final CharSequence getStore() {
        try {
            return this.zzcys.getStore();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final CharSequence getPrice() {
        try {
            return this.zzcys.getPrice();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zzcys.getVideoController() != null) {
                this.zzcje.zza(this.zzcys.getVideoController());
            }
        } catch (RemoteException e) {
            zzbad.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcje;
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzcyv;
    }

    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.zzcys.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            return this.zzcys.getExtras();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final void destroy() {
        try {
            this.zzcys.destroy();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }
}
