package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.util.Clock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

public class zzbtv {
    private final Set<zzbuz<zzxr>> zzfko;
    private final Set<zzbuz<zzbrl>> zzfkp;
    private final Set<zzbuz<zzbrw>> zzfkq;
    private final Set<zzbuz<zzbsr>> zzfkr;
    private final Set<zzbuz<zzbro>> zzfks;
    private final Set<zzbuz<zzbrs>> zzfkt;
    private final Set<zzbuz<AdMetadataListener>> zzfku;
    private final Set<zzbuz<AppEventListener>> zzfkv;
    private zzbrm zzfkw;
    private zzcmu zzfkx;

    private zzbtv(zza zza2) {
        this.zzfko = zza2.zzfko;
        this.zzfkq = zza2.zzfkq;
        this.zzfkp = zza2.zzfkp;
        this.zzfkr = zza2.zzfkr;
        this.zzfks = zza2.zzfks;
        this.zzfkt = zza2.zzfkt;
        this.zzfku = zza2.zzfku;
        this.zzfkv = zza2.zzfkv;
    }

    public static class zza {
        /* access modifiers changed from: private */
        public Set<zzbuz<zzxr>> zzfko = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbuz<zzbrl>> zzfkp = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbuz<zzbrw>> zzfkq = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbuz<zzbsr>> zzfkr = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbuz<zzbro>> zzfks = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbuz<zzbrs>> zzfkt = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbuz<AdMetadataListener>> zzfku = new HashSet();
        /* access modifiers changed from: private */
        public Set<zzbuz<AppEventListener>> zzfkv = new HashSet();

        public final zza zza(zzbrl zzbrl, Executor executor) {
            this.zzfkp.add(new zzbuz(zzbrl, executor));
            return this;
        }

        public final zza zza(zzbsr zzbsr, Executor executor) {
            this.zzfkr.add(new zzbuz(zzbsr, executor));
            return this;
        }

        public final zza zza(zzbro zzbro, Executor executor) {
            this.zzfks.add(new zzbuz(zzbro, executor));
            return this;
        }

        public final zza zza(zzbrs zzbrs, Executor executor) {
            this.zzfkt.add(new zzbuz(zzbrs, executor));
            return this;
        }

        public final zza zza(AdMetadataListener adMetadataListener, Executor executor) {
            this.zzfku.add(new zzbuz(adMetadataListener, executor));
            return this;
        }

        public final zza zza(AppEventListener appEventListener, Executor executor) {
            this.zzfkv.add(new zzbuz(appEventListener, executor));
            return this;
        }

        public final zza zza(@Nullable zzzs zzzs, Executor executor) {
            if (this.zzfkv != null) {
                zzcpy zzcpy = new zzcpy();
                zzcpy.zzb(zzzs);
                this.zzfkv.add(new zzbuz(zzcpy, executor));
            }
            return this;
        }

        public final zza zza(zzxr zzxr, Executor executor) {
            this.zzfko.add(new zzbuz(zzxr, executor));
            return this;
        }

        public final zza zza(zzbrw zzbrw, Executor executor) {
            this.zzfkq.add(new zzbuz(zzbrw, executor));
            return this;
        }

        public final zzbtv zzagt() {
            return new zzbtv(this);
        }
    }

    public final Set<zzbuz<zzbrl>> zzagl() {
        return this.zzfkp;
    }

    public final Set<zzbuz<zzbsr>> zzagm() {
        return this.zzfkr;
    }

    public final Set<zzbuz<zzbro>> zzagn() {
        return this.zzfks;
    }

    public final Set<zzbuz<zzbrs>> zzago() {
        return this.zzfkt;
    }

    public final Set<zzbuz<AdMetadataListener>> zzagp() {
        return this.zzfku;
    }

    public final Set<zzbuz<AppEventListener>> zzagq() {
        return this.zzfkv;
    }

    public final Set<zzbuz<zzxr>> zzagr() {
        return this.zzfko;
    }

    public final Set<zzbuz<zzbrw>> zzags() {
        return this.zzfkq;
    }

    public final zzbrm zzc(Set<zzbuz<zzbro>> set) {
        if (this.zzfkw == null) {
            this.zzfkw = new zzbrm(set);
        }
        return this.zzfkw;
    }

    public final zzcmu zza(Clock clock) {
        if (this.zzfkx == null) {
            this.zzfkx = new zzcmu(clock);
        }
        return this.zzfkx;
    }
}
