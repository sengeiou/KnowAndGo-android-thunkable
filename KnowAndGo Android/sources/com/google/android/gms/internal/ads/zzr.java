package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzag;
import java.util.Collections;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public abstract class zzr<T> implements Comparable<zzr<T>> {
    private final Object mLock;
    /* access modifiers changed from: private */
    public final zzag.zza zzae;
    private final int zzaf;
    private final String zzag;
    private final int zzah;
    @GuardedBy("mLock")
    @Nullable
    private zzz zzai;
    private Integer zzaj;
    private zzv zzak;
    private boolean zzal;
    @GuardedBy("mLock")
    private boolean zzam;
    @GuardedBy("mLock")
    private boolean zzan;
    private boolean zzao;
    private zzac zzap;
    private zzc zzaq;
    @GuardedBy("mLock")
    private zzt zzar;

    public zzr(int i, String str, @Nullable zzz zzz) {
        Uri parse;
        String host;
        this.zzae = zzag.zza.zzbl ? new zzag.zza() : null;
        this.mLock = new Object();
        this.zzal = true;
        int i2 = 0;
        this.zzam = false;
        this.zzan = false;
        this.zzao = false;
        this.zzaq = null;
        this.zzaf = i;
        this.zzag = str;
        this.zzai = zzz;
        this.zzap = new zzh();
        if (!(TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null)) {
            i2 = host.hashCode();
        }
        this.zzah = i2;
    }

    /* access modifiers changed from: protected */
    public abstract zzy<T> zza(zzp zzp);

    /* access modifiers changed from: protected */
    public abstract void zza(T t);

    public byte[] zzg() throws zza {
        return null;
    }

    public final int getMethod() {
        return this.zzaf;
    }

    public final int zzd() {
        return this.zzah;
    }

    public final void zzb(String str) {
        if (zzag.zza.zzbl) {
            this.zzae.zza(str, Thread.currentThread().getId());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(String str) {
        if (this.zzak != null) {
            this.zzak.zzf(this);
        }
        if (zzag.zza.zzbl) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzs(this, str, id));
                return;
            }
            this.zzae.zza(str, id);
            this.zzae.zzc(toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i) {
        if (this.zzak != null) {
            this.zzak.zza(this, i);
        }
    }

    public final zzr<?> zza(zzv zzv) {
        this.zzak = zzv;
        return this;
    }

    public final zzr<?> zzb(int i) {
        this.zzaj = Integer.valueOf(i);
        return this;
    }

    public final String getUrl() {
        return this.zzag;
    }

    public final String zze() {
        String str = this.zzag;
        int i = this.zzaf;
        if (i == 0 || i == -1) {
            return str;
        }
        String num = Integer.toString(i);
        StringBuilder sb = new StringBuilder(String.valueOf(num).length() + 1 + String.valueOf(str).length());
        sb.append(num);
        sb.append('-');
        sb.append(str);
        return sb.toString();
    }

    public final zzr<?> zza(zzc zzc) {
        this.zzaq = zzc;
        return this;
    }

    public final zzc zzf() {
        return this.zzaq;
    }

    public final boolean isCanceled() {
        synchronized (this.mLock) {
        }
        return false;
    }

    public Map<String, String> getHeaders() throws zza {
        return Collections.emptyMap();
    }

    public final boolean zzh() {
        return this.zzal;
    }

    public final int zzi() {
        return this.zzap.zzb();
    }

    public final zzac zzj() {
        return this.zzap;
    }

    public final void zzk() {
        synchronized (this.mLock) {
            this.zzan = true;
        }
    }

    public final boolean zzl() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzan;
        }
        return z;
    }

    public final void zzb(zzaf zzaf2) {
        zzz zzz;
        synchronized (this.mLock) {
            zzz = this.zzai;
        }
        if (zzz != null) {
            zzz.zzd(zzaf2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzt zzt) {
        synchronized (this.mLock) {
            this.zzar = zzt;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzy<?> zzy) {
        zzt zzt;
        synchronized (this.mLock) {
            zzt = this.zzar;
        }
        if (zzt != null) {
            zzt.zza(this, zzy);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzm() {
        zzt zzt;
        synchronized (this.mLock) {
            zzt = this.zzar;
        }
        if (zzt != null) {
            zzt.zza(this);
        }
    }

    public String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.zzah));
        String concat = valueOf.length() != 0 ? "0x".concat(valueOf) : new String("0x");
        isCanceled();
        String str = this.zzag;
        String valueOf2 = String.valueOf(zzu.NORMAL);
        String valueOf3 = String.valueOf(this.zzaj);
        StringBuilder sb = new StringBuilder(String.valueOf("[ ] ").length() + 3 + String.valueOf(str).length() + String.valueOf(concat).length() + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append("[ ] ");
        sb.append(str);
        sb.append(StringUtils.SPACE);
        sb.append(concat);
        sb.append(StringUtils.SPACE);
        sb.append(valueOf2);
        sb.append(StringUtils.SPACE);
        sb.append(valueOf3);
        return sb.toString();
    }

    public /* synthetic */ int compareTo(Object obj) {
        zzr zzr = (zzr) obj;
        zzu zzu = zzu.NORMAL;
        zzu zzu2 = zzu.NORMAL;
        return zzu == zzu2 ? this.zzaj.intValue() - zzr.zzaj.intValue() : zzu2.ordinal() - zzu.ordinal();
    }
}
