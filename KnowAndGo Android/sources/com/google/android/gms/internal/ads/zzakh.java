package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzk;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@zzard
public final class zzakh {
    /* access modifiers changed from: private */
    public final Object lock;
    /* access modifiers changed from: private */
    public int status;
    private final zzbai zzbtc;
    private final String zzdca;
    /* access modifiers changed from: private */
    public zzayp<zzajw> zzdcb;
    private zzayp<zzajw> zzdcc;
    /* access modifiers changed from: private */
    @Nullable
    public zzala zzdcd;
    private final Context zzlj;

    public zzakh(Context context, zzbai zzbai, String str) {
        this.lock = new Object();
        this.status = 1;
        this.zzdca = str;
        this.zzlj = context.getApplicationContext();
        this.zzbtc = zzbai;
        this.zzdcb = new zzakv();
        this.zzdcc = new zzakv();
    }

    public zzakh(Context context, zzbai zzbai, String str, zzayp<zzajw> zzayp, zzayp<zzajw> zzayp2) {
        this(context, zzbai, str);
        this.zzdcb = zzayp;
        this.zzdcc = zzayp2;
    }

    /* access modifiers changed from: protected */
    public final zzala zza(@Nullable zzdh zzdh) {
        zzala zzala = new zzala(this.zzdcc);
        zzbbm.zzeae.execute(new zzaki(this, zzdh, zzala));
        zzala.zza(new zzaks(this, zzala), new zzakt(this, zzala));
        return zzala;
    }

    public final zzakw zzb(@Nullable zzdh zzdh) {
        synchronized (this.lock) {
            synchronized (this.lock) {
                if (this.zzdcd != null && this.status == 0) {
                    if (((Boolean) zzyt.zzpe().zzd(zzacu.zzclb)).booleanValue()) {
                        this.zzdcd.zza(new zzakj(this), zzakk.zzdch);
                    }
                }
            }
            if (this.zzdcd != null) {
                if (this.zzdcd.getStatus() != -1) {
                    if (this.status == 0) {
                        zzakw zzrx = this.zzdcd.zzrx();
                        return zzrx;
                    } else if (this.status == 1) {
                        this.status = 2;
                        zza((zzdh) null);
                        zzakw zzrx2 = this.zzdcd.zzrx();
                        return zzrx2;
                    } else if (this.status == 2) {
                        zzakw zzrx3 = this.zzdcd.zzrx();
                        return zzrx3;
                    } else {
                        zzakw zzrx4 = this.zzdcd.zzrx();
                        return zzrx4;
                    }
                }
            }
            this.status = 2;
            this.zzdcd = zza((zzdh) null);
            zzakw zzrx5 = this.zzdcd.zzrx();
            return zzrx5;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzajw zzajw) {
        if (zzajw.isDestroyed()) {
            this.status = 1;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzdh zzdh, zzala zzala) {
        zzajw zzajw;
        try {
            Context context = this.zzlj;
            zzbai zzbai = this.zzbtc;
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcoj)).booleanValue()) {
                zzajw = new zzajj(context, zzbai);
            } else {
                zzajw = new zzajy(context, zzbai, zzdh, (zza) null);
            }
            zzajw.zza(new zzakl(this, zzala, zzajw));
            zzajw.zza("/jsLoaded", new zzako(this, zzala, zzajw));
            zzazk zzazk = new zzazk();
            zzakp zzakp = new zzakp(this, zzdh, zzajw, zzazk);
            zzazk.set(zzakp);
            zzajw.zza("/requestReload", zzakp);
            if (this.zzdca.endsWith(".js")) {
                zzajw.zzcl(this.zzdca);
            } else if (this.zzdca.startsWith("<html>")) {
                zzajw.zzcm(this.zzdca);
            } else {
                zzajw.zzcn(this.zzdca);
            }
            zzaxi.zzdvv.postDelayed(new zzakq(this, zzala, zzajw), (long) zzaku.zzdcr);
        } catch (Throwable th) {
            zzawz.zzc("Error creating webview.", th);
            zzk.zzlk().zza(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzala.reject();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(com.google.android.gms.internal.ads.zzala r4, com.google.android.gms.internal.ads.zzajw r5) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            int r1 = r4.getStatus()     // Catch:{ all -> 0x002a }
            r2 = -1
            if (r1 == r2) goto L_0x0028
            int r1 = r4.getStatus()     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 != r2) goto L_0x0012
            goto L_0x0028
        L_0x0012:
            r4.reject()     // Catch:{ all -> 0x002a }
            java.util.concurrent.Executor r4 = com.google.android.gms.internal.ads.zzbbm.zzeae     // Catch:{ all -> 0x002a }
            r5.getClass()     // Catch:{ all -> 0x002a }
            java.lang.Runnable r5 = com.google.android.gms.internal.ads.zzakn.zzb(r5)     // Catch:{ all -> 0x002a }
            r4.execute(r5)     // Catch:{ all -> 0x002a }
            java.lang.String r4 = "Could not receive loaded message in a timely manner. Rejecting."
            com.google.android.gms.internal.ads.zzawz.zzds(r4)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x002a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakh.zza(com.google.android.gms.internal.ads.zzala, com.google.android.gms.internal.ads.zzajw):void");
    }
}
