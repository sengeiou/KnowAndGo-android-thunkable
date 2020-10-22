package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class zzcxx {
    /* access modifiers changed from: private */
    public boolean zzbqn;
    /* access modifiers changed from: private */
    public zzady zzdgs;
    /* access modifiers changed from: private */
    public zzyd zzdll;
    /* access modifiers changed from: private */
    public zzaiy zzdne;
    /* access modifiers changed from: private */
    public zzxz zzghg;
    /* access modifiers changed from: private */
    public zzzy zzgkz;
    /* access modifiers changed from: private */
    public zzacd zzgla;
    /* access modifiers changed from: private */
    public String zzglb;
    /* access modifiers changed from: private */
    public ArrayList<String> zzglc;
    /* access modifiers changed from: private */
    public ArrayList<String> zzgld;
    /* access modifiers changed from: private */
    public String zzgle;
    /* access modifiers changed from: private */
    public String zzglf;
    /* access modifiers changed from: private */
    public int zzglg = 1;
    /* access modifiers changed from: private */
    public PublisherAdViewOptions zzglh;
    /* access modifiers changed from: private */
    @Nullable
    public zzzs zzgli;
    public final Set<String> zzglj = new HashSet();

    public final zzcxx zzg(zzxz zzxz) {
        this.zzghg = zzxz;
        return this;
    }

    public final zzxz zzamo() {
        return this.zzghg;
    }

    public final zzcxx zzd(zzyd zzyd) {
        this.zzdll = zzyd;
        return this;
    }

    public final zzyd zzpn() {
        return this.zzdll;
    }

    public final zzcxx zzd(zzzy zzzy) {
        this.zzgkz = zzzy;
        return this;
    }

    public final zzcxx zzft(String str) {
        this.zzglb = str;
        return this;
    }

    public final String zzamp() {
        return this.zzglb;
    }

    public final zzcxx zzc(zzacd zzacd) {
        this.zzgla = zzacd;
        return this;
    }

    public final zzcxx zzbc(boolean z) {
        this.zzbqn = z;
        return this;
    }

    public final zzcxx zzdp(int i) {
        this.zzglg = i;
        return this;
    }

    public final zzcxx zzb(ArrayList<String> arrayList) {
        this.zzglc = arrayList;
        return this;
    }

    public final zzcxx zzc(ArrayList<String> arrayList) {
        this.zzgld = arrayList;
        return this;
    }

    public final zzcxx zzb(zzady zzady) {
        this.zzdgs = zzady;
        return this;
    }

    public final zzcxx zzb(zzaiy zzaiy) {
        this.zzdne = zzaiy;
        this.zzgla = new zzacd(false, true, false);
        return this;
    }

    public final zzcxx zzfu(String str) {
        this.zzgle = str;
        return this;
    }

    public final zzcxx zzfv(String str) {
        this.zzglf = str;
        return this;
    }

    public final zzcxx zzb(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzglh = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zzbqn = publisherAdViewOptions.getManualImpressionsEnabled();
            this.zzgli = publisherAdViewOptions.zzkt();
        }
        return this;
    }

    public final zzcxv zzamq() {
        Preconditions.checkNotNull(this.zzglb, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzdll, "ad size must not be null");
        Preconditions.checkNotNull(this.zzghg, "ad request must not be null");
        return new zzcxv(this);
    }
}
