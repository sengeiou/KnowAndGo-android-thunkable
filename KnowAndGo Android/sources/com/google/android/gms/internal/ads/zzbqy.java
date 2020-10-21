package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import javax.annotation.Nullable;

public class zzbqy {
    private final zzcxv zzfjp;
    @Nullable
    private final String zzfju;
    private Bundle zzfjv;
    private final Context zzlj;

    public static class zza {
        /* access modifiers changed from: private */
        public zzcxv zzfjp;
        /* access modifiers changed from: private */
        @Nullable
        public String zzfju;
        /* access modifiers changed from: private */
        public Bundle zzfjv;
        /* access modifiers changed from: private */
        public Context zzlj;

        public final zza zzbt(Context context) {
            this.zzlj = context;
            return this;
        }

        public final zza zza(zzcxv zzcxv) {
            this.zzfjp = zzcxv;
            return this;
        }

        public final zza zze(Bundle bundle) {
            this.zzfjv = bundle;
            return this;
        }

        public final zza zzfg(String str) {
            this.zzfju = str;
            return this;
        }

        public final zzbqy zzagh() {
            return new zzbqy(this);
        }
    }

    private zzbqy(zza zza2) {
        this.zzlj = zza2.zzlj;
        this.zzfjp = zza2.zzfjp;
        this.zzfjv = zza2.zzfjv;
        this.zzfju = zza2.zzfju;
    }

    /* access modifiers changed from: package-private */
    public final zza zzagd() {
        return new zza().zzbt(this.zzlj).zza(this.zzfjp).zzfg(this.zzfju).zze(this.zzfjv);
    }

    /* access modifiers changed from: package-private */
    public final zzcxv zzage() {
        return this.zzfjp;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final Bundle zzagf() {
        return this.zzfjv;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final String zzagg() {
        return this.zzfju;
    }

    /* access modifiers changed from: package-private */
    public final Context zzbs(Context context) {
        if (this.zzfju != null) {
            return context;
        }
        return this.zzlj;
    }
}
