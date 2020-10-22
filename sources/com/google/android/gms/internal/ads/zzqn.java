package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C1470C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;

final class zzqn implements zzqj, zzqk {
    private zzrb zzasa;
    private zzqk zzbik;
    public final zzqj[] zzbjd;
    private final IdentityHashMap<zzqw, Integer> zzbje = new IdentityHashMap<>();
    private int zzbjf;
    private zzqj[] zzbjg;
    private zzqx zzbjh;

    public zzqn(zzqj... zzqjArr) {
        this.zzbjd = zzqjArr;
    }

    public final void zza(zzqk zzqk, long j) {
        this.zzbik = zzqk;
        this.zzbjf = this.zzbjd.length;
        for (zzqj zza : this.zzbjd) {
            zza.zza(this, j);
        }
    }

    public final void zziy() throws IOException {
        for (zzqj zziy : this.zzbjd) {
            zziy.zziy();
        }
    }

    public final zzrb zziz() {
        return this.zzasa;
    }

    public final long zza(zzrm[] zzrmArr, boolean[] zArr, zzqw[] zzqwArr, boolean[] zArr2, long j) {
        int i;
        zzrm[] zzrmArr2 = zzrmArr;
        zzqw[] zzqwArr2 = zzqwArr;
        int[] iArr = new int[zzrmArr2.length];
        int[] iArr2 = new int[zzrmArr2.length];
        for (int i2 = 0; i2 < zzrmArr2.length; i2++) {
            if (zzqwArr2[i2] == null) {
                i = -1;
            } else {
                i = this.zzbje.get(zzqwArr2[i2]).intValue();
            }
            iArr[i2] = i;
            iArr2[i2] = -1;
            if (zzrmArr2[i2] != null) {
                zzra zzjr = zzrmArr2[i2].zzjr();
                int i3 = 0;
                while (true) {
                    if (i3 >= this.zzbjd.length) {
                        break;
                    } else if (this.zzbjd[i3].zziz().zza(zzjr) != -1) {
                        iArr2[i2] = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        this.zzbje.clear();
        zzqw[] zzqwArr3 = new zzqw[zzrmArr2.length];
        zzqw[] zzqwArr4 = new zzqw[zzrmArr2.length];
        zzrm[] zzrmArr3 = new zzrm[zzrmArr2.length];
        ArrayList arrayList = new ArrayList(this.zzbjd.length);
        long j2 = j;
        int i4 = 0;
        while (i4 < this.zzbjd.length) {
            for (int i5 = 0; i5 < zzrmArr2.length; i5++) {
                zzrm zzrm = null;
                zzqwArr4[i5] = iArr[i5] == i4 ? zzqwArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    zzrm = zzrmArr2[i5];
                }
                zzrmArr3[i5] = zzrm;
            }
            ArrayList arrayList2 = arrayList;
            zzrm[] zzrmArr4 = zzrmArr3;
            int i6 = i4;
            long zza = this.zzbjd[i4].zza(zzrmArr3, zArr, zzqwArr4, zArr2, j2);
            if (i6 == 0) {
                j2 = zza;
            } else if (zza != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i7 = 0; i7 < zzrmArr2.length; i7++) {
                boolean z2 = true;
                if (iArr2[i7] == i6) {
                    zzsk.checkState(zzqwArr4[i7] != null);
                    zzqwArr3[i7] = zzqwArr4[i7];
                    this.zzbje.put(zzqwArr4[i7], Integer.valueOf(i6));
                    z = true;
                } else if (iArr[i7] == i6) {
                    if (zzqwArr4[i7] != null) {
                        z2 = false;
                    }
                    zzsk.checkState(z2);
                }
            }
            if (z) {
                arrayList2.add(this.zzbjd[i6]);
            }
            i4 = i6 + 1;
            arrayList = arrayList2;
            zzrmArr3 = zzrmArr4;
        }
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zzqwArr3, 0, zzqwArr2, 0, zzqwArr3.length);
        this.zzbjg = new zzqj[arrayList3.size()];
        arrayList3.toArray(this.zzbjg);
        this.zzbjh = new zzpy(this.zzbjg);
        return j2;
    }

    public final void zzem(long j) {
        for (zzqj zzem : this.zzbjg) {
            zzem.zzem(j);
        }
    }

    public final boolean zzel(long j) {
        return this.zzbjh.zzel(j);
    }

    public final long zzix() {
        return this.zzbjh.zzix();
    }

    public final long zzja() {
        long zzja = this.zzbjd[0].zzja();
        int i = 1;
        while (i < this.zzbjd.length) {
            if (this.zzbjd[i].zzja() == C1470C.TIME_UNSET) {
                i++;
            } else {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
        if (zzja != C1470C.TIME_UNSET) {
            zzqj[] zzqjArr = this.zzbjg;
            int length = zzqjArr.length;
            int i2 = 0;
            while (i2 < length) {
                zzqj zzqj = zzqjArr[i2];
                if (zzqj == this.zzbjd[0] || zzqj.zzen(zzja) == zzja) {
                    i2++;
                } else {
                    throw new IllegalStateException("Children seeked to different positions");
                }
            }
        }
        return zzja;
    }

    public final long zzdu() {
        long j = Long.MAX_VALUE;
        for (zzqj zzdu : this.zzbjg) {
            long zzdu2 = zzdu.zzdu();
            if (zzdu2 != Long.MIN_VALUE) {
                j = Math.min(j, zzdu2);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final long zzen(long j) {
        long zzen = this.zzbjg[0].zzen(j);
        int i = 1;
        while (i < this.zzbjg.length) {
            if (this.zzbjg[i].zzen(zzen) == zzen) {
                i++;
            } else {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
        return zzen;
    }

    public final void zza(zzqj zzqj) {
        int i = this.zzbjf - 1;
        this.zzbjf = i;
        if (i <= 0) {
            int i2 = 0;
            for (zzqj zziz : this.zzbjd) {
                i2 += zziz.zziz().length;
            }
            zzra[] zzraArr = new zzra[i2];
            zzqj[] zzqjArr = this.zzbjd;
            int length = zzqjArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                zzrb zziz2 = zzqjArr[i3].zziz();
                int i5 = zziz2.length;
                int i6 = i4;
                int i7 = 0;
                while (i7 < i5) {
                    zzraArr[i6] = zziz2.zzbg(i7);
                    i7++;
                    i6++;
                }
                i3++;
                i4 = i6;
            }
            this.zzasa = new zzrb(zzraArr);
            this.zzbik.zza(this);
        }
    }

    public final /* synthetic */ void zza(zzqx zzqx) {
        if (this.zzasa != null) {
            this.zzbik.zza(this);
        }
    }
}
