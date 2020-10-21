package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

@zzard
public final class zzagj extends UnifiedNativeAd {
    private final VideoController zzcje = new VideoController();
    private final List<NativeAd.Image> zzcyt = new ArrayList();
    private final zzael zzcyu;
    private final NativeAd.AdChoicesInfo zzcyv;
    private final zzagg zzczb;
    private final List<MuteThisAdReason> zzczc = new ArrayList();
    private final UnifiedNativeAd.zza zzczd;

    /* JADX WARNING: type inference failed for: r2v5, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b6 A[Catch:{ RemoteException -> 0x00c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d3 A[Catch:{ RemoteException -> 0x00e0 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzagj(com.google.android.gms.internal.ads.zzagg r5) {
        /*
            r4 = this;
            r4.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r4.zzcyt = r0
            com.google.android.gms.ads.VideoController r0 = new com.google.android.gms.ads.VideoController
            r0.<init>()
            r4.zzcje = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r4.zzczc = r0
            r4.zzczb = r5
            r5 = 0
            com.google.android.gms.internal.ads.zzagg r0 = r4.zzczb     // Catch:{ RemoteException -> 0x005c }
            java.util.List r0 = r0.getImages()     // Catch:{ RemoteException -> 0x005c }
            if (r0 == 0) goto L_0x0062
            java.util.Iterator r0 = r0.iterator()     // Catch:{ RemoteException -> 0x005c }
        L_0x0027:
            boolean r1 = r0.hasNext()     // Catch:{ RemoteException -> 0x005c }
            if (r1 == 0) goto L_0x0062
            java.lang.Object r1 = r0.next()     // Catch:{ RemoteException -> 0x005c }
            boolean r2 = r1 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x005c }
            if (r2 == 0) goto L_0x004e
            android.os.IBinder r1 = (android.os.IBinder) r1     // Catch:{ RemoteException -> 0x005c }
            if (r1 == 0) goto L_0x004e
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)     // Catch:{ RemoteException -> 0x005c }
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaei     // Catch:{ RemoteException -> 0x005c }
            if (r3 == 0) goto L_0x0047
            r1 = r2
            com.google.android.gms.internal.ads.zzaei r1 = (com.google.android.gms.internal.ads.zzaei) r1     // Catch:{ RemoteException -> 0x005c }
            goto L_0x004f
        L_0x0047:
            com.google.android.gms.internal.ads.zzaek r2 = new com.google.android.gms.internal.ads.zzaek     // Catch:{ RemoteException -> 0x005c }
            r2.<init>(r1)     // Catch:{ RemoteException -> 0x005c }
            r1 = r2
            goto L_0x004f
        L_0x004e:
            r1 = r5
        L_0x004f:
            if (r1 == 0) goto L_0x0027
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r2 = r4.zzcyt     // Catch:{ RemoteException -> 0x005c }
            com.google.android.gms.internal.ads.zzael r3 = new com.google.android.gms.internal.ads.zzael     // Catch:{ RemoteException -> 0x005c }
            r3.<init>(r1)     // Catch:{ RemoteException -> 0x005c }
            r2.add(r3)     // Catch:{ RemoteException -> 0x005c }
            goto L_0x0027
        L_0x005c:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzbad.zzc(r1, r0)
        L_0x0062:
            com.google.android.gms.internal.ads.zzagg r0 = r4.zzczb     // Catch:{ RemoteException -> 0x0091 }
            java.util.List r0 = r0.getMuteThisAdReasons()     // Catch:{ RemoteException -> 0x0091 }
            if (r0 == 0) goto L_0x0097
            java.util.Iterator r0 = r0.iterator()     // Catch:{ RemoteException -> 0x0091 }
        L_0x006e:
            boolean r1 = r0.hasNext()     // Catch:{ RemoteException -> 0x0091 }
            if (r1 == 0) goto L_0x0097
            java.lang.Object r1 = r0.next()     // Catch:{ RemoteException -> 0x0091 }
            boolean r2 = r1 instanceof android.os.IBinder     // Catch:{ RemoteException -> 0x0091 }
            if (r2 == 0) goto L_0x0083
            android.os.IBinder r1 = (android.os.IBinder) r1     // Catch:{ RemoteException -> 0x0091 }
            com.google.android.gms.internal.ads.zzaak r1 = com.google.android.gms.internal.ads.zzaal.zzf(r1)     // Catch:{ RemoteException -> 0x0091 }
            goto L_0x0084
        L_0x0083:
            r1 = r5
        L_0x0084:
            if (r1 == 0) goto L_0x006e
            java.util.List<com.google.android.gms.ads.MuteThisAdReason> r2 = r4.zzczc     // Catch:{ RemoteException -> 0x0091 }
            com.google.android.gms.internal.ads.zzaan r3 = new com.google.android.gms.internal.ads.zzaan     // Catch:{ RemoteException -> 0x0091 }
            r3.<init>(r1)     // Catch:{ RemoteException -> 0x0091 }
            r2.add(r3)     // Catch:{ RemoteException -> 0x0091 }
            goto L_0x006e
        L_0x0091:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzbad.zzc(r1, r0)
        L_0x0097:
            com.google.android.gms.internal.ads.zzagg r0 = r4.zzczb     // Catch:{ RemoteException -> 0x00a5 }
            com.google.android.gms.internal.ads.zzaei r0 = r0.zzri()     // Catch:{ RemoteException -> 0x00a5 }
            if (r0 == 0) goto L_0x00ab
            com.google.android.gms.internal.ads.zzael r1 = new com.google.android.gms.internal.ads.zzael     // Catch:{ RemoteException -> 0x00a5 }
            r1.<init>(r0)     // Catch:{ RemoteException -> 0x00a5 }
            goto L_0x00ac
        L_0x00a5:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzbad.zzc(r1, r0)
        L_0x00ab:
            r1 = r5
        L_0x00ac:
            r4.zzcyu = r1
            com.google.android.gms.internal.ads.zzagg r0 = r4.zzczb     // Catch:{ RemoteException -> 0x00c2 }
            com.google.android.gms.internal.ads.zzaea r0 = r0.zzrj()     // Catch:{ RemoteException -> 0x00c2 }
            if (r0 == 0) goto L_0x00c8
            com.google.android.gms.internal.ads.zzaed r0 = new com.google.android.gms.internal.ads.zzaed     // Catch:{ RemoteException -> 0x00c2 }
            com.google.android.gms.internal.ads.zzagg r1 = r4.zzczb     // Catch:{ RemoteException -> 0x00c2 }
            com.google.android.gms.internal.ads.zzaea r1 = r1.zzrj()     // Catch:{ RemoteException -> 0x00c2 }
            r0.<init>(r1)     // Catch:{ RemoteException -> 0x00c2 }
            goto L_0x00c9
        L_0x00c2:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzbad.zzc(r1, r0)
        L_0x00c8:
            r0 = r5
        L_0x00c9:
            r4.zzcyv = r0
            com.google.android.gms.internal.ads.zzagg r0 = r4.zzczb     // Catch:{ RemoteException -> 0x00e0 }
            com.google.android.gms.internal.ads.zzaee r0 = r0.zzrp()     // Catch:{ RemoteException -> 0x00e0 }
            if (r0 == 0) goto L_0x00e6
            com.google.android.gms.internal.ads.zzaeh r0 = new com.google.android.gms.internal.ads.zzaeh     // Catch:{ RemoteException -> 0x00e0 }
            com.google.android.gms.internal.ads.zzagg r1 = r4.zzczb     // Catch:{ RemoteException -> 0x00e0 }
            com.google.android.gms.internal.ads.zzaee r1 = r1.zzrp()     // Catch:{ RemoteException -> 0x00e0 }
            r0.<init>(r1)     // Catch:{ RemoteException -> 0x00e0 }
            r5 = r0
            goto L_0x00e6
        L_0x00e0:
            r0 = move-exception
            java.lang.String r1 = ""
            com.google.android.gms.internal.ads.zzbad.zzc(r1, r0)
        L_0x00e6:
            r4.zzczd = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagj.<init>(com.google.android.gms.internal.ads.zzagg):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: zzrh */
    public final IObjectWrapper zzkq() {
        try {
            return this.zzczb.zzrh();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final Object zzkv() {
        try {
            IObjectWrapper zzrk = this.zzczb.zzrk();
            if (zzrk != null) {
                return ObjectWrapper.unwrap(zzrk);
            }
            return null;
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zzczb.performClick(bundle);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzczb.recordImpression(bundle);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzczb.reportTouchEvent(bundle);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    public final String getHeadline() {
        try {
            return this.zzczb.getHeadline();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzcyt;
    }

    public final String getBody() {
        try {
            return this.zzczb.getBody();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final NativeAd.Image getIcon() {
        return this.zzcyu;
    }

    public final String getCallToAction() {
        try {
            return this.zzczb.getCallToAction();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final Double getStarRating() {
        try {
            double starRating = this.zzczb.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final String getStore() {
        try {
            return this.zzczb.getStore();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final String getPrice() {
        try {
            return this.zzczb.getPrice();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zzczb.getVideoController() != null) {
                this.zzcje.zza(this.zzczb.getVideoController());
            }
        } catch (RemoteException e) {
            zzbad.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcje;
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzcyv;
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.zzczb.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            Bundle extras = this.zzczb.getExtras();
            if (extras != null) {
                return extras;
            }
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
        return new Bundle();
    }

    public final void enableCustomClickGesture() {
        try {
            this.zzczb.zzro();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    public final void recordCustomClickGesture() {
        try {
            this.zzczb.recordCustomClickGesture();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zzczc;
    }

    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zzczb.isCustomMuteThisAdEnabled();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return false;
        }
    }

    public final void destroy() {
        try {
            this.zzczb.destroy();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zzczb.zza((zzagd) new zzagt(unconfirmedClickListener));
        } catch (RemoteException e) {
            zzbad.zzc("Failed to setUnconfirmedClickListener", e);
        }
    }

    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (!isCustomMuteThisAdEnabled()) {
                zzbad.zzen("Ad is not custom mute enabled");
            } else if (muteThisAdReason == null) {
                this.zzczb.zza((zzaak) null);
            } else if (muteThisAdReason instanceof zzaan) {
                this.zzczb.zza(((zzaan) muteThisAdReason).zzpu());
            } else {
                zzbad.zzen("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
            }
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zzczb.zza((zzaag) new zzaaj(muteThisAdListener));
        } catch (RemoteException e) {
            zzbad.zzc("", e);
        }
    }

    public final void cancelUnconfirmedClick() {
        try {
            this.zzczb.cancelUnconfirmedClick();
        } catch (RemoteException e) {
            zzbad.zzc("Failed to cancelUnconfirmedClick", e);
        }
    }

    public final String getAdvertiser() {
        try {
            return this.zzczb.getAdvertiser();
        } catch (RemoteException e) {
            zzbad.zzc("", e);
            return null;
        }
    }
}
