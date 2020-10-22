package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

@zzard
public final class zzbhq extends zzaas {
    private final Object lock = new Object();
    @GuardedBy("lock")
    private boolean zzaay;
    @GuardedBy("lock")
    private boolean zzaaz;
    @GuardedBy("lock")
    private int zzabv;
    @GuardedBy("lock")
    private zzaau zzdfz;
    private final zzbdf zzebt;
    private final boolean zzelv;
    private final boolean zzelw;
    @GuardedBy("lock")
    private boolean zzelx;
    @GuardedBy("lock")
    private boolean zzely = true;
    @GuardedBy("lock")
    private float zzelz;
    @GuardedBy("lock")
    private float zzema;
    @GuardedBy("lock")
    private float zzemb;

    public zzbhq(zzbdf zzbdf, float f, boolean z, boolean z2) {
        this.zzebt = zzbdf;
        this.zzelz = f;
        this.zzelv = z;
        this.zzelw = z2;
    }

    public final void play() {
        zzf("play", (Map<String, String>) null);
    }

    public final void pause() {
        zzf("pause", (Map<String, String>) null);
    }

    public final void mute(boolean z) {
        zzf(z ? "mute" : "unmute", (Map<String, String>) null);
    }

    public final void zzb(zzacd zzacd) {
        boolean z = zzacd.zzaax;
        boolean z2 = zzacd.zzaay;
        boolean z3 = zzacd.zzaaz;
        synchronized (this.lock) {
            this.zzaay = z2;
            this.zzaaz = z3;
        }
        zzf("initialState", CollectionUtils.mapOf("muteStart", z ? "1" : "0", "customControlsRequested", z2 ? "1" : "0", "clickToExpandRequested", z3 ? "1" : "0"));
    }

    private final void zzf(String str, @Nullable Map<String, String> map) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzbbm.zzeae.execute(new zzbhr(this, hashMap));
    }

    public final boolean isMuted() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzely;
        }
        return z;
    }

    public final int getPlaybackState() {
        int i;
        synchronized (this.lock) {
            i = this.zzabv;
        }
        return i;
    }

    public final float getAspectRatio() {
        float f;
        synchronized (this.lock) {
            f = this.zzemb;
        }
        return f;
    }

    public final float zzpv() {
        float f;
        synchronized (this.lock) {
            f = this.zzelz;
        }
        return f;
    }

    public final float zzpw() {
        float f;
        synchronized (this.lock) {
            f = this.zzema;
        }
        return f;
    }

    public final void zza(zzaau zzaau) {
        synchronized (this.lock) {
            this.zzdfz = zzaau;
        }
    }

    public final zzaau zzpx() throws RemoteException {
        zzaau zzaau;
        synchronized (this.lock) {
            zzaau = this.zzdfz;
        }
        return zzaau;
    }

    public final boolean isCustomControlsEnabled() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzelv && this.zzaay;
        }
        return z;
    }

    public final boolean isClickToExpandEnabled() {
        boolean z;
        boolean isCustomControlsEnabled = isCustomControlsEnabled();
        synchronized (this.lock) {
            if (!isCustomControlsEnabled) {
                try {
                    if (this.zzaaz && this.zzelw) {
                        z = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            z = false;
        }
        return z;
    }

    public final void zze(float f) {
        synchronized (this.lock) {
            this.zzema = f;
        }
    }

    public final void zzabs() {
        boolean z;
        int i;
        synchronized (this.lock) {
            z = this.zzely;
            i = this.zzabv;
            this.zzabv = 3;
        }
        zza(i, 3, z, z);
    }

    public final void zza(float f, float f2, int i, boolean z, float f3) {
        boolean z2;
        int i2;
        synchronized (this.lock) {
            this.zzelz = f2;
            this.zzema = f;
            z2 = this.zzely;
            this.zzely = z;
            i2 = this.zzabv;
            this.zzabv = i;
            float f4 = this.zzemb;
            this.zzemb = f3;
            if (Math.abs(this.zzemb - f4) > 1.0E-4f) {
                this.zzebt.getView().invalidate();
            }
        }
        zza(i2, i, z2, z);
    }

    private final void zza(int i, int i2, boolean z, boolean z2) {
        zzbbm.zzeae.execute(new zzbhs(this, i, i2, z, z2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(int i, int i2, boolean z, boolean z2) {
        synchronized (this.lock) {
            boolean z3 = false;
            boolean z4 = i != i2;
            boolean z5 = !this.zzelx && i2 == 1;
            boolean z6 = z4 && i2 == 1;
            boolean z7 = z4 && i2 == 2;
            boolean z8 = z4 && i2 == 3;
            boolean z9 = z != z2;
            if (this.zzelx || z5) {
                z3 = true;
            }
            this.zzelx = z3;
            if (z5) {
                try {
                    if (this.zzdfz != null) {
                        this.zzdfz.onVideoStart();
                    }
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
            if (z6 && this.zzdfz != null) {
                this.zzdfz.onVideoPlay();
            }
            if (z7 && this.zzdfz != null) {
                this.zzdfz.onVideoPause();
            }
            if (z8) {
                if (this.zzdfz != null) {
                    this.zzdfz.onVideoEnd();
                }
                this.zzebt.zzyk();
            }
            if (z9 && this.zzdfz != null) {
                this.zzdfz.onVideoMute(z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(Map map) {
        this.zzebt.zza("pubVideoCmd", (Map<String, ?>) map);
    }
}
