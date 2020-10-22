package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class zzbzl {
    private final zzady zzdgs;
    private final zzaxb zzduk;
    private final Executor zzffi;
    private final Executor zzffv;
    private final zzcxv zzfjp;
    private final zzbyt zzfmq;
    private final zzbyx zzfnq;
    @Nullable
    private final zzbzt zzfps;
    private final Context zzlj;

    public zzbzl(Context context, zzaxb zzaxb, zzcxv zzcxv, zzbyx zzbyx, zzbyt zzbyt, @Nullable zzbzt zzbzt, Executor executor, Executor executor2) {
        this.zzlj = context;
        this.zzduk = zzaxb;
        this.zzfjp = zzcxv;
        this.zzdgs = zzcxv.zzdgs;
        this.zzfnq = zzbyx;
        this.zzfmq = zzbyt;
        this.zzfps = zzbzt;
        this.zzffv = executor;
        this.zzffi = executor2;
    }

    public final void zzc(zzcab zzcab) {
        this.zzffv.execute(new zzbzm(this, zzcab));
    }

    private static void zza(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i != 0) {
            switch (i) {
                case 2:
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    return;
                case 3:
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                    return;
                default:
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    return;
            }
        } else {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        }
    }

    public final void zzd(@Nullable zzcab zzcab) {
        if (zzcab != null && this.zzfps != null && zzcab.zzair() != null) {
            try {
                zzcab.zzair().addView(this.zzfps.zzajb());
            } catch (zzbhj e) {
                zzawz.zza("web view can not be obtained", e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean zza(zzcab zzcab, String[] strArr) {
        Map<String, WeakReference<View>> zzaiu = zzcab.zzaiu();
        if (zzaiu == null) {
            return false;
        }
        for (String str : strArr) {
            if (zzaiu.get(str) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean zza(@Nonnull ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        View zzahy = this.zzfmq.zzahy();
        if (zzahy == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzahy.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzahy.getParent()).removeView(zzahy);
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcsk)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(zzahy, layoutParams);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        if (this.zzfmq.zzahy() == null) {
            return;
        }
        if (2 == this.zzfmq.zzahv() || 1 == this.zzfmq.zzahv()) {
            this.zzduk.zzc(this.zzfjp.zzglb, String.valueOf(this.zzfmq.zzahv()), z);
        } else if (6 == this.zzfmq.zzahv()) {
            this.zzduk.zzc(this.zzfjp.zzglb, ExifInterface.GPS_MEASUREMENT_2D, z);
            this.zzduk.zzc(this.zzfjp.zzglb, "1", z);
        }
    }

    /* JADX WARNING: type inference failed for: r6v5, types: [android.view.View] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0108 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zze(com.google.android.gms.internal.ads.zzcab r10) {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzbyx r0 = r9.zzfnq
            boolean r0 = r0.zzaig()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzbyx r0 = r9.zzfnq
            boolean r0 = r0.zzaif()
            if (r0 == 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r0 = 0
            goto L_0x0016
        L_0x0015:
            r0 = 1
        L_0x0016:
            r3 = 0
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = "1098"
            java.lang.String r4 = "3011"
            java.lang.String[] r0 = new java.lang.String[]{r0, r4}
            r4 = 0
        L_0x0022:
            r5 = 2
            if (r4 >= r5) goto L_0x0037
            r5 = r0[r4]
            android.view.View r5 = r10.zzfp(r5)
            if (r5 == 0) goto L_0x0034
            boolean r6 = r5 instanceof android.view.ViewGroup
            if (r6 == 0) goto L_0x0034
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            goto L_0x0038
        L_0x0034:
            int r4 = r4 + 1
            goto L_0x0022
        L_0x0037:
            r5 = r3
        L_0x0038:
            if (r5 == 0) goto L_0x003c
            r0 = 1
            goto L_0x003d
        L_0x003c:
            r0 = 0
        L_0x003d:
            android.widget.RelativeLayout$LayoutParams r4 = new android.widget.RelativeLayout$LayoutParams
            r6 = -2
            r4.<init>(r6, r6)
            com.google.android.gms.internal.ads.zzbyt r6 = r9.zzfmq
            android.view.View r6 = r6.zzahw()
            if (r6 == 0) goto L_0x0063
            com.google.android.gms.internal.ads.zzbyt r6 = r9.zzfmq
            android.view.View r6 = r6.zzahw()
            com.google.android.gms.internal.ads.zzady r7 = r9.zzdgs
            if (r7 != 0) goto L_0x0056
            goto L_0x0097
        L_0x0056:
            if (r0 != 0) goto L_0x0097
            com.google.android.gms.internal.ads.zzady r7 = r9.zzdgs
            int r7 = r7.zzbqf
            zza((android.widget.RelativeLayout.LayoutParams) r4, (int) r7)
            r6.setLayoutParams(r4)
            goto L_0x0097
        L_0x0063:
            com.google.android.gms.internal.ads.zzbyt r6 = r9.zzfmq
            com.google.android.gms.internal.ads.zzaea r6 = r6.zzrj()
            boolean r6 = r6 instanceof com.google.android.gms.internal.ads.zzadt
            if (r6 != 0) goto L_0x006f
            r6 = r3
            goto L_0x0097
        L_0x006f:
            com.google.android.gms.internal.ads.zzbyt r6 = r9.zzfmq
            com.google.android.gms.internal.ads.zzaea r6 = r6.zzrj()
            com.google.android.gms.internal.ads.zzadt r6 = (com.google.android.gms.internal.ads.zzadt) r6
            if (r0 != 0) goto L_0x0080
            int r7 = r6.zzrd()
            zza((android.widget.RelativeLayout.LayoutParams) r4, (int) r7)
        L_0x0080:
            com.google.android.gms.internal.ads.zzadu r7 = new com.google.android.gms.internal.ads.zzadu
            android.content.Context r8 = r9.zzlj
            r7.<init>(r8, r6, r4)
            com.google.android.gms.internal.ads.zzacj<java.lang.String> r4 = com.google.android.gms.internal.ads.zzacu.zzcsh
            com.google.android.gms.internal.ads.zzacr r6 = com.google.android.gms.internal.ads.zzyt.zzpe()
            java.lang.Object r4 = r6.zzd(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r7.setContentDescription(r4)
            r6 = r7
        L_0x0097:
            r4 = -1
            if (r6 == 0) goto L_0x00dc
            android.view.ViewParent r7 = r6.getParent()
            boolean r7 = r7 instanceof android.view.ViewGroup
            if (r7 == 0) goto L_0x00ab
            android.view.ViewParent r7 = r6.getParent()
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            r7.removeView(r6)
        L_0x00ab:
            if (r0 == 0) goto L_0x00b4
            r5.removeAllViews()
            r5.addView(r6)
            goto L_0x00d5
        L_0x00b4:
            com.google.android.gms.ads.formats.AdChoicesView r0 = new com.google.android.gms.ads.formats.AdChoicesView
            android.view.View r5 = r10.zzafi()
            android.content.Context r5 = r5.getContext()
            r0.<init>(r5)
            android.widget.FrameLayout$LayoutParams r5 = new android.widget.FrameLayout$LayoutParams
            r5.<init>(r4, r4)
            r0.setLayoutParams(r5)
            r0.addView(r6)
            android.widget.FrameLayout r5 = r10.zzair()
            if (r5 == 0) goto L_0x00d5
            r5.addView(r0)
        L_0x00d5:
            java.lang.String r0 = r10.zzaiw()
            r10.zza(r0, r6, r2)
        L_0x00dc:
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzacu.zzcwq
            com.google.android.gms.internal.ads.zzacr r2 = com.google.android.gms.internal.ads.zzyt.zzpe()
            java.lang.Object r0 = r2.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x00f1
            r9.zzd(r10)
        L_0x00f1:
            java.lang.String[] r0 = com.google.android.gms.internal.ads.zzbzj.zzfpm
            int r2 = r0.length
            r5 = 0
        L_0x00f5:
            if (r5 >= r2) goto L_0x0108
            r6 = r0[r5]
            android.view.View r6 = r10.zzfp(r6)
            boolean r7 = r6 instanceof android.view.ViewGroup
            if (r7 == 0) goto L_0x0105
            r0 = r6
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x0109
        L_0x0105:
            int r5 = r5 + 1
            goto L_0x00f5
        L_0x0108:
            r0 = r3
        L_0x0109:
            java.util.concurrent.Executor r2 = r9.zzffi
            com.google.android.gms.internal.ads.zzbzn r5 = new com.google.android.gms.internal.ads.zzbzn
            r5.<init>(r9, r0)
            r2.execute(r5)
            if (r0 == 0) goto L_0x019c
            boolean r2 = r9.zza(r0)
            if (r2 == 0) goto L_0x0132
            com.google.android.gms.internal.ads.zzbyt r1 = r9.zzfmq
            com.google.android.gms.internal.ads.zzbgz r1 = r1.zzahz()
            if (r1 == 0) goto L_0x019c
            com.google.android.gms.internal.ads.zzbyt r1 = r9.zzfmq
            com.google.android.gms.internal.ads.zzbgz r1 = r1.zzahz()
            com.google.android.gms.internal.ads.zzbzo r2 = new com.google.android.gms.internal.ads.zzbzo
            r2.<init>(r9, r10, r0)
            r1.zza((com.google.android.gms.internal.ads.zzadx) r2)
            return
        L_0x0132:
            r0.removeAllViews()
            android.view.View r10 = r10.zzafi()
            if (r10 == 0) goto L_0x0140
            android.content.Context r10 = r10.getContext()
            goto L_0x0141
        L_0x0140:
            r10 = r3
        L_0x0141:
            if (r10 == 0) goto L_0x019c
            com.google.android.gms.internal.ads.zzbyt r2 = r9.zzfmq
            java.util.List r2 = r2.getImages()
            if (r2 == 0) goto L_0x019b
            com.google.android.gms.internal.ads.zzbyt r2 = r9.zzfmq
            java.util.List r2 = r2.getImages()
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0158
            goto L_0x019b
        L_0x0158:
            com.google.android.gms.internal.ads.zzbyt r2 = r9.zzfmq
            java.util.List r2 = r2.getImages()
            java.lang.Object r1 = r2.get(r1)
            boolean r2 = r1 instanceof android.os.IBinder
            if (r2 == 0) goto L_0x016c
            android.os.IBinder r1 = (android.os.IBinder) r1
            com.google.android.gms.internal.ads.zzaei r3 = com.google.android.gms.internal.ads.zzaej.zzk(r1)
        L_0x016c:
            if (r3 == 0) goto L_0x019c
            com.google.android.gms.dynamic.IObjectWrapper r1 = r3.zzrf()     // Catch:{ RemoteException -> 0x0195 }
            if (r1 == 0) goto L_0x019c
            java.lang.Object r1 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r1)
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1
            if (r1 == 0) goto L_0x019c
            android.widget.ImageView r2 = new android.widget.ImageView
            r2.<init>(r10)
            r2.setImageDrawable(r1)
            android.widget.ImageView$ScaleType r10 = android.widget.ImageView.ScaleType.CENTER_INSIDE
            r2.setScaleType(r10)
            android.widget.FrameLayout$LayoutParams r10 = new android.widget.FrameLayout$LayoutParams
            r10.<init>(r4, r4)
            r2.setLayoutParams(r10)
            r0.addView(r2)
            goto L_0x019c
        L_0x0195:
            java.lang.String r10 = "Could not get drawable from image"
            com.google.android.gms.internal.ads.zzawz.zzep(r10)
            return
        L_0x019b:
            return
        L_0x019c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzl.zze(com.google.android.gms.internal.ads.zzcab):void");
    }
}
