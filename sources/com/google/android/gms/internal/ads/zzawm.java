package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import androidx.annotation.GuardedBy;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@zzard
public final class zzawm {
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    public zzbai zzbtc;
    private final zzawu zzdsw = new zzawu(zzyt.zzpf(), this.zzdtp);
    private zztz zzdto;
    private final zzaxc zzdtp = new zzaxc();
    /* access modifiers changed from: private */
    @Nullable
    public zzacy zzdtq = null;
    @Nullable
    private Boolean zzdtr = null;
    private final AtomicInteger zzdts = new AtomicInteger(0);
    private final zzawp zzdtt = new zzawp((zzawo) null);
    private final Object zzdtu = new Object();
    @GuardedBy("grantedPermissionLock")
    private zzbbh<ArrayList<String>> zzdtv;
    /* access modifiers changed from: private */
    public Context zzlj;
    private boolean zzxs = false;

    @Nullable
    public final zzacy zzuw() {
        zzacy zzacy;
        synchronized (this.lock) {
            zzacy = this.zzdtq;
        }
        return zzacy;
    }

    public final void zza(Boolean bool) {
        synchronized (this.lock) {
            this.zzdtr = bool;
        }
    }

    public final Boolean zzux() {
        Boolean bool;
        synchronized (this.lock) {
            bool = this.zzdtr;
        }
        return bool;
    }

    public final void zzuy() {
        this.zzdtt.zzuy();
    }

    @TargetApi(23)
    public final void zzd(Context context, zzbai zzbai) {
        synchronized (this.lock) {
            if (!this.zzxs) {
                this.zzlj = context.getApplicationContext();
                this.zzbtc = zzbai;
                zzk.zzlj().zza(this.zzdsw);
                zzacy zzacy = null;
                this.zzdtp.zza(this.zzlj, (String) null, true);
                zzaqx.zzc(this.zzlj, this.zzbtc);
                this.zzdto = new zztz(context.getApplicationContext(), this.zzbtc);
                zzk.zzlp();
                if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcmx)).booleanValue()) {
                    zzawz.zzds("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                } else {
                    zzacy = new zzacy();
                }
                this.zzdtq = zzacy;
                if (this.zzdtq != null) {
                    zzbao.zza(new zzawo(this).zzvi(), "AppState.registerCsiReporter");
                }
                this.zzxs = true;
                zzvd();
            }
        }
        zzk.zzlg().zzq(context, zzbai.zzbsx);
    }

    @Nullable
    public final Resources getResources() {
        if (this.zzbtc.zzdze) {
            return this.zzlj.getResources();
        }
        try {
            zzbae.zzbl(this.zzlj).getResources();
            return null;
        } catch (zzbag e) {
            zzawz.zzd("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final void zza(Throwable th, String str) {
        zzaqx.zzc(this.zzlj, this.zzbtc).zza(th, str);
    }

    public final void zzb(Throwable th, String str) {
        zzaqx.zzc(this.zzlj, this.zzbtc).zza(th, str, ((Float) zzyt.zzpe().zzd(zzacu.zzcli)).floatValue());
    }

    public final void zzuz() {
        this.zzdts.incrementAndGet();
    }

    public final void zzva() {
        this.zzdts.decrementAndGet();
    }

    public final int zzvb() {
        return this.zzdts.get();
    }

    public final zzaxb zzvc() {
        zzaxc zzaxc;
        synchronized (this.lock) {
            zzaxc = this.zzdtp;
        }
        return zzaxc;
    }

    @Nullable
    public final Context getApplicationContext() {
        return this.zzlj;
    }

    public final zzbbh<ArrayList<String>> zzvd() {
        if (PlatformVersion.isAtLeastJellyBean() && this.zzlj != null) {
            if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcri)).booleanValue()) {
                synchronized (this.zzdtu) {
                    if (this.zzdtv != null) {
                        zzbbh<ArrayList<String>> zzbbh = this.zzdtv;
                        return zzbbh;
                    }
                    zzbbh<ArrayList<String>> zza = zzaxg.zza(new zzawn(this));
                    this.zzdtv = zza;
                    return zza;
                }
            }
        }
        return zzbar.zzm(new ArrayList());
    }

    @TargetApi(16)
    private static ArrayList<String> zzah(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(context.getApplicationInfo().packageName, 4096);
            if (packageInfo.requestedPermissions == null || packageInfo.requestedPermissionsFlags == null) {
                return arrayList;
            }
            for (int i = 0; i < packageInfo.requestedPermissions.length; i++) {
                if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                    arrayList.add(packageInfo.requestedPermissions[i]);
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException unused) {
            return arrayList;
        }
    }

    public final zzawu zzve() {
        return this.zzdsw;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzvf() throws Exception {
        return zzah(zzasq.zzw(this.zzlj));
    }
}
