package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@zzard
public final class zzuo {
    private final Object lock = new Object();
    private int score;
    private final int zzbtz;
    private final int zzbua;
    private final int zzbub;
    private final boolean zzbuc;
    private final zzvb zzbud;
    private final zzvk zzbue;
    private ArrayList<String> zzbuf = new ArrayList<>();
    private ArrayList<String> zzbug = new ArrayList<>();
    private ArrayList<zzuz> zzbuh = new ArrayList<>();
    private int zzbui = 0;
    private int zzbuj = 0;
    private int zzbuk = 0;
    private String zzbul = "";
    private String zzbum = "";
    private String zzbun = "";

    public zzuo(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.zzbtz = i;
        this.zzbua = i2;
        this.zzbub = i3;
        this.zzbuc = z;
        this.zzbud = new zzvb(i4);
        this.zzbue = new zzvk(i5, i6, i7);
    }

    public final boolean zzml() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzbuk == 0;
        }
        return z;
    }

    public final String zzmm() {
        return this.zzbul;
    }

    public final String zzmn() {
        return this.zzbum;
    }

    public final String zzmo() {
        return this.zzbun;
    }

    public final void zzmp() {
        synchronized (this.lock) {
            this.score -= 100;
        }
    }

    public final void zzmq() {
        synchronized (this.lock) {
            this.zzbuk--;
        }
    }

    public final void zzmr() {
        synchronized (this.lock) {
            this.zzbuk++;
        }
    }

    public final void zza(String str, boolean z, float f, float f2, float f3, float f4) {
        zzc(str, z, f, f2, f3, f4);
        synchronized (this.lock) {
            if (this.zzbuk < 0) {
                zzawz.zzdp("ActivityContent: negative number of WebViews.");
            }
            zzmt();
        }
    }

    public final void zzb(String str, boolean z, float f, float f2, float f3, float f4) {
        zzc(str, z, f, f2, f3, f4);
    }

    private final void zzc(@Nullable String str, boolean z, float f, float f2, float f3, float f4) {
        if (str != null && str.length() >= this.zzbub) {
            synchronized (this.lock) {
                this.zzbuf.add(str);
                this.zzbui += str.length();
                if (z) {
                    this.zzbug.add(str);
                    this.zzbuh.add(new zzuz(f, f2, f3, f4, this.zzbug.size() - 1));
                }
            }
        }
    }

    public final void zzms() {
        synchronized (this.lock) {
            int zzh = zzh(this.zzbui, this.zzbuj);
            if (zzh > this.score) {
                this.score = zzh;
            }
        }
    }

    public final void zzmt() {
        synchronized (this.lock) {
            int zzh = zzh(this.zzbui, this.zzbuj);
            if (zzh > this.score) {
                this.score = zzh;
                if (!zzk.zzlk().zzvc().zzvl()) {
                    this.zzbul = this.zzbud.zza(this.zzbuf);
                    this.zzbum = this.zzbud.zza(this.zzbug);
                }
                if (!zzk.zzlk().zzvc().zzvn()) {
                    this.zzbun = this.zzbue.zza(this.zzbug, this.zzbuh);
                }
            }
        }
    }

    @VisibleForTesting
    private final int zzh(int i, int i2) {
        if (this.zzbuc) {
            return this.zzbua;
        }
        return (i * this.zzbtz) + (i2 * this.zzbua);
    }

    public final int getScore() {
        return this.score;
    }

    public final void zzbw(int i) {
        this.zzbuj = i;
    }

    private static String zza(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            sb.append((String) obj);
            sb.append(' ');
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String sb2 = sb.toString();
        if (sb2.length() < 100) {
            return sb2;
        }
        return sb2.substring(0, 100);
    }

    public final String toString() {
        int i = this.zzbuj;
        int i2 = this.score;
        int i3 = this.zzbui;
        String zza = zza(this.zzbuf, 100);
        String zza2 = zza(this.zzbug, 100);
        String str = this.zzbul;
        String str2 = this.zzbum;
        String str3 = this.zzbun;
        StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + 165 + String.valueOf(zza2).length() + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("ActivityContent fetchId: ");
        sb.append(i);
        sb.append(" score:");
        sb.append(i2);
        sb.append(" total_length:");
        sb.append(i3);
        sb.append("\n text: ");
        sb.append(zza);
        sb.append("\n viewableText");
        sb.append(zza2);
        sb.append("\n signture: ");
        sb.append(str);
        sb.append("\n viewableSignture: ");
        sb.append(str2);
        sb.append("\n viewableSignatureForVertical: ");
        sb.append(str3);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final int zzmu() {
        return this.zzbui;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzuo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzuo zzuo = (zzuo) obj;
        return zzuo.zzbul != null && zzuo.zzbul.equals(this.zzbul);
    }

    public final int hashCode() {
        return this.zzbul.hashCode();
    }
}
