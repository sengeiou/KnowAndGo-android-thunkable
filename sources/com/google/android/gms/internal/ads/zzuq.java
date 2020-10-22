package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
@zzard
public final class zzuq {
    private final Object zzbuq = new Object();
    @GuardedBy("activityTrackerLock")
    private zzur zzbur = null;
    @GuardedBy("activityTrackerLock")
    private boolean zzbus = false;

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zzbuq
            monitor-enter(r0)
            boolean r1 = r4.zzbus     // Catch:{ all -> 0x003c }
            if (r1 != 0) goto L_0x003a
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastIceCreamSandwich()     // Catch:{ all -> 0x003c }
            if (r1 != 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return
        L_0x000f:
            r1 = 0
            android.content.Context r2 = r5.getApplicationContext()     // Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x0017
            r2 = r5
        L_0x0017:
            boolean r3 = r2 instanceof android.app.Application     // Catch:{ all -> 0x003c }
            if (r3 == 0) goto L_0x001e
            r1 = r2
            android.app.Application r1 = (android.app.Application) r1     // Catch:{ all -> 0x003c }
        L_0x001e:
            if (r1 != 0) goto L_0x0027
            java.lang.String r5 = "Can not cast Context to Application"
            com.google.android.gms.internal.ads.zzawz.zzep(r5)     // Catch:{ all -> 0x003c }
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return
        L_0x0027:
            com.google.android.gms.internal.ads.zzur r2 = r4.zzbur     // Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzur r2 = new com.google.android.gms.internal.ads.zzur     // Catch:{ all -> 0x003c }
            r2.<init>()     // Catch:{ all -> 0x003c }
            r4.zzbur = r2     // Catch:{ all -> 0x003c }
        L_0x0032:
            com.google.android.gms.internal.ads.zzur r2 = r4.zzbur     // Catch:{ all -> 0x003c }
            r2.zza((android.app.Application) r1, (android.content.Context) r5)     // Catch:{ all -> 0x003c }
            r5 = 1
            r4.zzbus = r5     // Catch:{ all -> 0x003c }
        L_0x003a:
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return
        L_0x003c:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuq.initialize(android.content.Context):void");
    }

    public final void zza(zzut zzut) {
        synchronized (this.zzbuq) {
            if (PlatformVersion.isAtLeastIceCreamSandwich()) {
                if (this.zzbur == null) {
                    this.zzbur = new zzur();
                }
                this.zzbur.zza(zzut);
            }
        }
    }

    @Nullable
    public final Activity getActivity() {
        synchronized (this.zzbuq) {
            if (!PlatformVersion.isAtLeastIceCreamSandwich()) {
                return null;
            }
            if (this.zzbur == null) {
                return null;
            }
            Activity activity = this.zzbur.getActivity();
            return activity;
        }
    }

    @Nullable
    public final Context getContext() {
        synchronized (this.zzbuq) {
            if (!PlatformVersion.isAtLeastIceCreamSandwich()) {
                return null;
            }
            if (this.zzbur == null) {
                return null;
            }
            Context context = this.zzbur.getContext();
            return context;
        }
    }
}
