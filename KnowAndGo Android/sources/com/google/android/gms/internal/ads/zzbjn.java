package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.lang.ref.WeakReference;

public class zzbjn {
    private final zzbai zzbrc;
    private final WeakReference<Context> zzeoe;
    private final Context zzlj;

    public static class zza {
        /* access modifiers changed from: private */
        public zzbai zzbrc;
        /* access modifiers changed from: private */
        public WeakReference<Context> zzeoe;
        /* access modifiers changed from: private */
        public Context zzlj;

        public final zza zza(zzbai zzbai) {
            this.zzbrc = zzbai;
            return this;
        }

        public final zza zzbo(Context context) {
            this.zzeoe = new WeakReference<>(context);
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzlj = context;
            return this;
        }
    }

    private zzbjn(zza zza2) {
        this.zzbrc = zza2.zzbrc;
        this.zzlj = zza2.zzlj;
        this.zzeoe = zza2.zzeoe;
    }

    /* access modifiers changed from: package-private */
    public final Context zzaco() {
        return this.zzlj;
    }

    /* access modifiers changed from: package-private */
    public final Context zzacp() {
        if (this.zzeoe.get() != null) {
            return (Context) this.zzeoe.get();
        }
        return this.zzlj;
    }

    /* access modifiers changed from: package-private */
    public final zzbai zzacq() {
        return this.zzbrc;
    }

    /* access modifiers changed from: package-private */
    public final String zzacr() {
        return zzk.zzlg().zzq(this.zzlj, this.zzbrc.zzbsx);
    }
}
