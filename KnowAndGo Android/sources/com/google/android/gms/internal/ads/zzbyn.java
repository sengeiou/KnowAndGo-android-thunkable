package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzbyn extends zzbpc {
    private final zzbai zzbtc;
    private final zzdh zzeko;
    private final Executor zzffv;
    private final zzbzc zzfgz;
    private final zzavf zzfio;
    private final zzbyt zzfmq;
    private final zzbzb zzfno;
    private final zzbzl zzfnp;
    private final zzbyx zzfnq;
    private final zzdte<zzccb> zzfnr;
    private final zzdte<zzcbz> zzfns;
    private final zzdte<zzccg> zzfnt;
    private final zzdte<zzcbw> zzfnu;
    private final zzdte<zzccd> zzfnv;
    private zzcab zzfnw;
    private boolean zzfnx;
    private final Context zzlj;

    public zzbyn(Executor executor, zzbyt zzbyt, zzbzb zzbzb, zzbzl zzbzl, zzbyx zzbyx, zzbzc zzbzc, zzdte<zzccb> zzdte, zzdte<zzcbz> zzdte2, zzdte<zzccg> zzdte3, zzdte<zzcbw> zzdte4, zzdte<zzccd> zzdte5, zzavf zzavf, zzdh zzdh, zzbai zzbai, Context context) {
        this.zzffv = executor;
        this.zzfmq = zzbyt;
        this.zzfno = zzbzb;
        this.zzfnp = zzbzl;
        this.zzfnq = zzbyx;
        this.zzfgz = zzbzc;
        this.zzfnr = zzdte;
        this.zzfns = zzdte2;
        this.zzfnt = zzdte3;
        this.zzfnu = zzdte4;
        this.zzfnv = zzdte5;
        this.zzfio = zzavf;
        this.zzeko = zzdh;
        this.zzbtc = zzbai;
        this.zzlj = context;
    }

    @AnyThread
    public final void zzafl() {
        this.zzffv.execute(new zzbyo(this));
        if (this.zzfmq.zzahv() != 7) {
            Executor executor = this.zzffv;
            zzbzb zzbzb = this.zzfno;
            zzbzb.getClass();
            executor.execute(zzbyp.zza(zzbzb));
        }
        super.zzafl();
    }

    public final synchronized void zzfi(String str) {
        this.zzfno.zzfi(str);
    }

    public final synchronized void zzahk() {
        if (!this.zzfnx) {
            this.zzfno.zzahk();
        }
    }

    public final synchronized void zzf(Bundle bundle) {
        this.zzfno.zzf(bundle);
    }

    public final synchronized boolean zzh(Bundle bundle) {
        if (this.zzfnx) {
            return true;
        }
        boolean zzh = this.zzfno.zzh(bundle);
        this.zzfnx = zzh;
        return zzh;
    }

    public final synchronized void zzg(Bundle bundle) {
        this.zzfno.zzg(bundle);
    }

    public final synchronized void destroy() {
        this.zzffv.execute(new zzbyq(this));
        super.destroy();
    }

    public final synchronized void zza(zzcab zzcab) {
        zzdc zzcg;
        this.zzfnw = zzcab;
        this.zzfnp.zzc(zzcab);
        this.zzfno.zza(zzcab.zzafi(), zzcab.zzaiu(), zzcab.zzaiv(), (View.OnTouchListener) zzcab, (View.OnClickListener) zzcab);
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcrg)).booleanValue() && (zzcg = this.zzeko.zzcg()) != null) {
            zzcg.zzb(zzcab.zzafi());
        }
        if (zzcab.zzais() != null) {
            zzcab.zzais().zza((zzue) this.zzfio);
        }
    }

    public final synchronized void zzb(zzcab zzcab) {
        this.zzfno.zza(zzcab.zzafi(), zzcab.zzait());
        if (zzcab.zzair() != null) {
            zzcab.zzair().setClickable(false);
            zzcab.zzair().removeAllViews();
        }
        if (zzcab.zzais() != null) {
            zzcab.zzais().zzb(this.zzfio);
        }
        this.zzfnw = null;
    }

    public final synchronized void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwq)).booleanValue()) {
            this.zzfnp.zzd(this.zzfnw);
        }
        this.zzfno.zza(view, view2, map, map2, z);
    }

    public final synchronized void zza(View view, MotionEvent motionEvent, View view2) {
        this.zzfno.zza(view, motionEvent, view2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb(android.view.View r3, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r5, boolean r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzfnx     // Catch:{ all -> 0x005c }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            r0 = 1
            if (r6 == 0) goto L_0x0013
            com.google.android.gms.internal.ads.zzbzb r6 = r2.zzfno     // Catch:{ all -> 0x005c }
            r6.zza((android.view.View) r3, (java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>>) r4, (java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>>) r5)     // Catch:{ all -> 0x005c }
            r2.zzfnx = r0     // Catch:{ all -> 0x005c }
            monitor-exit(r2)
            return
        L_0x0013:
            if (r6 != 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzacu.zzcsl     // Catch:{ all -> 0x005c }
            com.google.android.gms.internal.ads.zzacr r1 = com.google.android.gms.internal.ads.zzyt.zzpe()     // Catch:{ all -> 0x005c }
            java.lang.Object r6 = r1.zzd(r6)     // Catch:{ all -> 0x005c }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x005c }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x005c }
            if (r6 == 0) goto L_0x005a
            if (r4 == 0) goto L_0x005a
            java.util.Set r6 = r4.entrySet()     // Catch:{ all -> 0x005c }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x005c }
        L_0x0031:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x005a
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x005c }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x005c }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x005c }
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch:{ all -> 0x005c }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x005c }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x0031
            boolean r1 = zzx(r1)     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzbzb r6 = r2.zzfno     // Catch:{ all -> 0x005c }
            r6.zza((android.view.View) r3, (java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>>) r4, (java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>>) r5)     // Catch:{ all -> 0x005c }
            r2.zzfnx = r0     // Catch:{ all -> 0x005c }
            monitor-exit(r2)
            return
        L_0x005a:
            monitor-exit(r2)
            return
        L_0x005c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbyn.zzb(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void setClickConfirmingView(View view) {
        this.zzfno.setClickConfirmingView(view);
    }

    public final synchronized void zza(zzagd zzagd) {
        this.zzfno.zza(zzagd);
    }

    public final synchronized void cancelUnconfirmedClick() {
        this.zzfno.cancelUnconfirmedClick();
    }

    public final synchronized void zza(@Nullable zzaak zzaak) {
        this.zzfno.zza(zzaak);
    }

    public final synchronized void zza(zzaag zzaag) {
        this.zzfno.zza(zzaag);
    }

    public final synchronized void zzro() {
        this.zzfno.zzro();
    }

    public final synchronized void recordCustomClickGesture() {
        if (this.zzfnw == null) {
            zzawz.zzdp("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            this.zzffv.execute(new zzbyr(this, this.zzfnw instanceof zzbzi));
        }
    }

    public static boolean zzx(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), (Point) null);
    }

    public final boolean zzahs() {
        return this.zzfnq.zzaif();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzfk(java.lang.String r11) {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzbyx r0 = r10.zzfnq
            boolean r0 = r0.zzaih()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            com.google.android.gms.internal.ads.zzbyt r0 = r10.zzfmq
            com.google.android.gms.internal.ads.zzbgz r0 = r0.zzaia()
            com.google.android.gms.internal.ads.zzbyt r1 = r10.zzfmq
            com.google.android.gms.internal.ads.zzbgz r1 = r1.zzahz()
            if (r0 != 0) goto L_0x001a
            if (r1 != 0) goto L_0x001a
            return
        L_0x001a:
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0020
            r4 = 1
            goto L_0x0021
        L_0x0020:
            r4 = 0
        L_0x0021:
            if (r1 == 0) goto L_0x0024
            r2 = 1
        L_0x0024:
            r3 = 0
            if (r4 == 0) goto L_0x0029
        L_0x0027:
            r8 = r3
            goto L_0x0031
        L_0x0029:
            if (r2 == 0) goto L_0x002f
            java.lang.String r3 = "javascript"
            r0 = r1
            goto L_0x0027
        L_0x002f:
            r0 = r3
            r8 = r0
        L_0x0031:
            android.webkit.WebView r3 = r0.getWebView()
            if (r3 != 0) goto L_0x0038
            return
        L_0x0038:
            com.google.android.gms.internal.ads.zzaqd r3 = com.google.android.gms.ads.internal.zzk.zzlv()
            android.content.Context r4 = r10.zzlj
            boolean r3 = r3.zzl(r4)
            if (r3 == 0) goto L_0x0094
            com.google.android.gms.internal.ads.zzbai r3 = r10.zzbtc
            int r3 = r3.zzdzc
            com.google.android.gms.internal.ads.zzbai r4 = r10.zzbtc
            int r4 = r4.zzdzd
            r5 = 23
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            r6.append(r3)
            java.lang.String r3 = "."
            r6.append(r3)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            com.google.android.gms.internal.ads.zzaqd r3 = com.google.android.gms.ads.internal.zzk.zzlv()
            android.webkit.WebView r5 = r0.getWebView()
            java.lang.String r6 = ""
            java.lang.String r7 = "javascript"
            r9 = r11
            com.google.android.gms.dynamic.IObjectWrapper r11 = r3.zza(r4, r5, r6, r7, r8, r9)
            if (r11 != 0) goto L_0x0076
            return
        L_0x0076:
            com.google.android.gms.internal.ads.zzbyt r3 = r10.zzfmq
            r3.zzan(r11)
            r0.zzam(r11)
            if (r2 == 0) goto L_0x008d
            android.view.View r0 = r1.getView()
            if (r0 == 0) goto L_0x008d
            com.google.android.gms.internal.ads.zzaqd r1 = com.google.android.gms.ads.internal.zzk.zzlv()
            r1.zza(r11, r0)
        L_0x008d:
            com.google.android.gms.internal.ads.zzaqd r0 = com.google.android.gms.ads.internal.zzk.zzlv()
            r0.zzaa(r11)
        L_0x0094:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbyn.zzfk(java.lang.String):void");
    }

    public final void zzy(View view) {
        IObjectWrapper zzaib = this.zzfmq.zzaib();
        boolean z = this.zzfmq.zzaia() != null;
        if (this.zzfnq.zzaih() && zzaib != null && z && view != null) {
            zzk.zzlv().zza(zzaib, view);
        }
    }

    public final zzaee zzrp() {
        return new zzbym(this.zzfmq);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzay(boolean z) {
        this.zzfno.zza(this.zzfnw.zzafi(), this.zzfnw.zzait(), this.zzfnw.zzaiu(), z);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaht() {
        this.zzfno.destroy();
        this.zzfmq.destroy();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzahu() {
        try {
            switch (this.zzfmq.zzahv()) {
                case 1:
                    if (this.zzfgz.zzaii() != null) {
                        zzfk("Google");
                        this.zzfgz.zzaii().zza(this.zzfnr.get());
                        return;
                    }
                    return;
                case 2:
                    if (this.zzfgz.zzaij() != null) {
                        zzfk("Google");
                        this.zzfgz.zzaij().zza(this.zzfns.get());
                        return;
                    }
                    return;
                case 3:
                    if (this.zzfgz.zzfn(this.zzfmq.getCustomTemplateId()) != null) {
                        this.zzfgz.zzfn(this.zzfmq.getCustomTemplateId()).zzb(this.zzfnv.get());
                        return;
                    }
                    return;
                case 6:
                    if (this.zzfgz.zzaik() != null) {
                        zzfk("Google");
                        this.zzfgz.zzaik().zza(this.zzfnt.get());
                        return;
                    }
                    return;
                case 7:
                    if (this.zzfgz.zzaim() != null) {
                        this.zzfgz.zzaim().zza(this.zzfnu.get());
                        return;
                    }
                    return;
                default:
                    zzawz.zzen("Wrong native template id!");
                    return;
            }
        } catch (RemoteException e) {
            zzawz.zzc("RemoteException when notifyAdLoad is called", e);
        }
    }
}
