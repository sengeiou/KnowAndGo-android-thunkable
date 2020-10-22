package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
final class zzfy implements zzis {
    private int tag;
    private int zzrw;
    private final zzft zzsp;
    private int zzsq = 0;

    public static zzfy zza(zzft zzft) {
        if (zzft.zzsi != null) {
            return zzft.zzsi;
        }
        return new zzfy(zzft);
    }

    private zzfy(zzft zzft) {
        this.zzsp = (zzft) zzgt.zza(zzft, "input");
        this.zzsp.zzsi = this;
    }

    public final int zzdu() throws IOException {
        if (this.zzsq != 0) {
            this.tag = this.zzsq;
            this.zzsq = 0;
        } else {
            this.tag = this.zzsp.zzex();
        }
        if (this.tag == 0 || this.tag == this.zzrw) {
            return Integer.MAX_VALUE;
        }
        return this.tag >>> 3;
    }

    public final int getTag() {
        return this.tag;
    }

    public final boolean zzdv() throws IOException {
        if (this.zzsp.zzdt() || this.tag == this.zzrw) {
            return false;
        }
        return this.zzsp.zzar(this.tag);
    }

    private final void zzaj(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzhc.zzgr();
        }
    }

    public final double readDouble() throws IOException {
        zzaj(1);
        return this.zzsp.readDouble();
    }

    public final float readFloat() throws IOException {
        zzaj(5);
        return this.zzsp.readFloat();
    }

    public final long zzdw() throws IOException {
        zzaj(0);
        return this.zzsp.zzdw();
    }

    public final long zzdx() throws IOException {
        zzaj(0);
        return this.zzsp.zzdx();
    }

    public final int zzdy() throws IOException {
        zzaj(0);
        return this.zzsp.zzdy();
    }

    public final long zzdz() throws IOException {
        zzaj(1);
        return this.zzsp.zzdz();
    }

    public final int zzea() throws IOException {
        zzaj(5);
        return this.zzsp.zzea();
    }

    public final boolean zzeb() throws IOException {
        zzaj(0);
        return this.zzsp.zzeb();
    }

    public final String readString() throws IOException {
        zzaj(2);
        return this.zzsp.readString();
    }

    public final String zzec() throws IOException {
        zzaj(2);
        return this.zzsp.zzec();
    }

    public final <T> T zza(Class<T> cls, zzgd zzgd) throws IOException {
        zzaj(2);
        return zzb(zzin.zzho().zzf(cls), zzgd);
    }

    public final <T> T zza(zzir<T> zzir, zzgd zzgd) throws IOException {
        zzaj(2);
        return zzb(zzir, zzgd);
    }

    public final <T> T zzb(Class<T> cls, zzgd zzgd) throws IOException {
        zzaj(3);
        return zzd(zzin.zzho().zzf(cls), zzgd);
    }

    public final <T> T zzc(zzir<T> zzir, zzgd zzgd) throws IOException {
        zzaj(3);
        return zzd(zzir, zzgd);
    }

    private final <T> T zzb(zzir<T> zzir, zzgd zzgd) throws IOException {
        int zzee = this.zzsp.zzee();
        if (this.zzsp.zzsf < this.zzsp.zzsg) {
            int zzas = this.zzsp.zzas(zzee);
            T newInstance = zzir.newInstance();
            this.zzsp.zzsf++;
            zzir.zza(newInstance, this, zzgd);
            zzir.zzg(newInstance);
            this.zzsp.zzaq(0);
            zzft zzft = this.zzsp;
            zzft.zzsf--;
            this.zzsp.zzat(zzas);
            return newInstance;
        }
        throw new zzhc("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzd(zzir<T> zzir, zzgd zzgd) throws IOException {
        int i = this.zzrw;
        this.zzrw = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzir.newInstance();
            zzir.zza(newInstance, this, zzgd);
            zzir.zzg(newInstance);
            if (this.tag == this.zzrw) {
                return newInstance;
            }
            throw zzhc.zzgs();
        } finally {
            this.zzrw = i;
        }
    }

    public final zzfh zzed() throws IOException {
        zzaj(2);
        return this.zzsp.zzed();
    }

    public final int zzee() throws IOException {
        zzaj(0);
        return this.zzsp.zzee();
    }

    public final int zzef() throws IOException {
        zzaj(0);
        return this.zzsp.zzef();
    }

    public final int zzeg() throws IOException {
        zzaj(5);
        return this.zzsp.zzeg();
    }

    public final long zzeh() throws IOException {
        zzaj(1);
        return this.zzsp.zzeh();
    }

    public final int zzei() throws IOException {
        zzaj(0);
        return this.zzsp.zzei();
    }

    public final long zzej() throws IOException {
        zzaj(0);
        return this.zzsp.zzej();
    }

    public final void zza(List<Double> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzgb) {
            zzgb zzgb = (zzgb) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzee = this.zzsp.zzee();
                    zzak(zzee);
                    int zzez = this.zzsp.zzez() + zzee;
                    do {
                        zzgb.zzc(this.zzsp.readDouble());
                    } while (this.zzsp.zzez() < zzez);
                    return;
                default:
                    throw zzhc.zzgr();
            }
            do {
                zzgb.zzc(this.zzsp.readDouble());
                if (!this.zzsp.zzdt()) {
                    zzex2 = this.zzsp.zzex();
                } else {
                    return;
                }
            } while (zzex2 == this.tag);
            this.zzsq = zzex2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzee2 = this.zzsp.zzee();
                zzak(zzee2);
                int zzez2 = this.zzsp.zzez() + zzee2;
                do {
                    list.add(Double.valueOf(this.zzsp.readDouble()));
                } while (this.zzsp.zzez() < zzez2);
                return;
            default:
                throw zzhc.zzgr();
        }
        do {
            list.add(Double.valueOf(this.zzsp.readDouble()));
            if (!this.zzsp.zzdt()) {
                zzex = this.zzsp.zzex();
            } else {
                return;
            }
        } while (zzex == this.tag);
        this.zzsq = zzex;
    }

    public final void zzb(List<Float> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzgo) {
            zzgo zzgo = (zzgo) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzee = this.zzsp.zzee();
                zzal(zzee);
                int zzez = this.zzsp.zzez() + zzee;
                do {
                    zzgo.zzu(this.zzsp.readFloat());
                } while (this.zzsp.zzez() < zzez);
            } else if (i == 5) {
                do {
                    zzgo.zzu(this.zzsp.readFloat());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzee2 = this.zzsp.zzee();
                zzal(zzee2);
                int zzez2 = this.zzsp.zzez() + zzee2;
                do {
                    list.add(Float.valueOf(this.zzsp.readFloat()));
                } while (this.zzsp.zzez() < zzez2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zzsp.readFloat()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzc(List<Long> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzhq.zzac(this.zzsp.zzdw());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else if (i == 2) {
                int zzez = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    zzhq.zzac(this.zzsp.zzdw());
                } while (this.zzsp.zzez() < zzez);
                zzam(zzez);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzsp.zzdw()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else if (i2 == 2) {
                int zzez2 = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    list.add(Long.valueOf(this.zzsp.zzdw()));
                } while (this.zzsp.zzez() < zzez2);
                zzam(zzez2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzd(List<Long> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzhq.zzac(this.zzsp.zzdx());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else if (i == 2) {
                int zzez = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    zzhq.zzac(this.zzsp.zzdx());
                } while (this.zzsp.zzez() < zzez);
                zzam(zzez);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzsp.zzdx()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else if (i2 == 2) {
                int zzez2 = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    list.add(Long.valueOf(this.zzsp.zzdx()));
                } while (this.zzsp.zzez() < zzez2);
                zzam(zzez2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zze(List<Integer> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgu.zzbl(this.zzsp.zzdy());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else if (i == 2) {
                int zzez = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    zzgu.zzbl(this.zzsp.zzdy());
                } while (this.zzsp.zzez() < zzez);
                zzam(zzez);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzsp.zzdy()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else if (i2 == 2) {
                int zzez2 = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    list.add(Integer.valueOf(this.zzsp.zzdy()));
                } while (this.zzsp.zzez() < zzez2);
                zzam(zzez2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzf(List<Long> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzee = this.zzsp.zzee();
                    zzak(zzee);
                    int zzez = this.zzsp.zzez() + zzee;
                    do {
                        zzhq.zzac(this.zzsp.zzdz());
                    } while (this.zzsp.zzez() < zzez);
                    return;
                default:
                    throw zzhc.zzgr();
            }
            do {
                zzhq.zzac(this.zzsp.zzdz());
                if (!this.zzsp.zzdt()) {
                    zzex2 = this.zzsp.zzex();
                } else {
                    return;
                }
            } while (zzex2 == this.tag);
            this.zzsq = zzex2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzee2 = this.zzsp.zzee();
                zzak(zzee2);
                int zzez2 = this.zzsp.zzez() + zzee2;
                do {
                    list.add(Long.valueOf(this.zzsp.zzdz()));
                } while (this.zzsp.zzez() < zzez2);
                return;
            default:
                throw zzhc.zzgr();
        }
        do {
            list.add(Long.valueOf(this.zzsp.zzdz()));
            if (!this.zzsp.zzdt()) {
                zzex = this.zzsp.zzex();
            } else {
                return;
            }
        } while (zzex == this.tag);
        this.zzsq = zzex;
    }

    public final void zzg(List<Integer> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzee = this.zzsp.zzee();
                zzal(zzee);
                int zzez = this.zzsp.zzez() + zzee;
                do {
                    zzgu.zzbl(this.zzsp.zzea());
                } while (this.zzsp.zzez() < zzez);
            } else if (i == 5) {
                do {
                    zzgu.zzbl(this.zzsp.zzea());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzee2 = this.zzsp.zzee();
                zzal(zzee2);
                int zzez2 = this.zzsp.zzez() + zzee2;
                do {
                    list.add(Integer.valueOf(this.zzsp.zzea()));
                } while (this.zzsp.zzez() < zzez2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzsp.zzea()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzh(List<Boolean> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzff) {
            zzff zzff = (zzff) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzff.addBoolean(this.zzsp.zzeb());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else if (i == 2) {
                int zzez = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    zzff.addBoolean(this.zzsp.zzeb());
                } while (this.zzsp.zzez() < zzez);
                zzam(zzez);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zzsp.zzeb()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else if (i2 == 2) {
                int zzez2 = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    list.add(Boolean.valueOf(this.zzsp.zzeb()));
                } while (this.zzsp.zzez() < zzez2);
                zzam(zzez2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    public final void zzi(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzex;
        int zzex2;
        if ((this.tag & 7) != 2) {
            throw zzhc.zzgr();
        } else if (!(list instanceof zzhj) || z) {
            do {
                list.add(z ? zzec() : readString());
                if (!this.zzsp.zzdt()) {
                    zzex = this.zzsp.zzex();
                } else {
                    return;
                }
            } while (zzex == this.tag);
            this.zzsq = zzex;
        } else {
            zzhj zzhj = (zzhj) list;
            do {
                zzhj.zzc(zzed());
                if (!this.zzsp.zzdt()) {
                    zzex2 = this.zzsp.zzex();
                } else {
                    return;
                }
            } while (zzex2 == this.tag);
            this.zzsq = zzex2;
        }
    }

    public final <T> void zza(List<T> list, zzir<T> zzir, zzgd zzgd) throws IOException {
        int zzex;
        if ((this.tag & 7) == 2) {
            int i = this.tag;
            do {
                list.add(zzb(zzir, zzgd));
                if (!this.zzsp.zzdt() && this.zzsq == 0) {
                    zzex = this.zzsp.zzex();
                } else {
                    return;
                }
            } while (zzex == i);
            this.zzsq = zzex;
            return;
        }
        throw zzhc.zzgr();
    }

    public final <T> void zzb(List<T> list, zzir<T> zzir, zzgd zzgd) throws IOException {
        int zzex;
        if ((this.tag & 7) == 3) {
            int i = this.tag;
            do {
                list.add(zzd(zzir, zzgd));
                if (!this.zzsp.zzdt() && this.zzsq == 0) {
                    zzex = this.zzsp.zzex();
                } else {
                    return;
                }
            } while (zzex == i);
            this.zzsq = zzex;
            return;
        }
        throw zzhc.zzgr();
    }

    public final void zzj(List<zzfh> list) throws IOException {
        int zzex;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzed());
                if (!this.zzsp.zzdt()) {
                    zzex = this.zzsp.zzex();
                } else {
                    return;
                }
            } while (zzex == this.tag);
            this.zzsq = zzex;
            return;
        }
        throw zzhc.zzgr();
    }

    public final void zzk(List<Integer> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgu.zzbl(this.zzsp.zzee());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else if (i == 2) {
                int zzez = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    zzgu.zzbl(this.zzsp.zzee());
                } while (this.zzsp.zzez() < zzez);
                zzam(zzez);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzsp.zzee()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else if (i2 == 2) {
                int zzez2 = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    list.add(Integer.valueOf(this.zzsp.zzee()));
                } while (this.zzsp.zzez() < zzez2);
                zzam(zzez2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzl(List<Integer> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgu.zzbl(this.zzsp.zzef());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else if (i == 2) {
                int zzez = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    zzgu.zzbl(this.zzsp.zzef());
                } while (this.zzsp.zzez() < zzez);
                zzam(zzez);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzsp.zzef()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else if (i2 == 2) {
                int zzez2 = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    list.add(Integer.valueOf(this.zzsp.zzef()));
                } while (this.zzsp.zzez() < zzez2);
                zzam(zzez2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzm(List<Integer> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzee = this.zzsp.zzee();
                zzal(zzee);
                int zzez = this.zzsp.zzez() + zzee;
                do {
                    zzgu.zzbl(this.zzsp.zzeg());
                } while (this.zzsp.zzez() < zzez);
            } else if (i == 5) {
                do {
                    zzgu.zzbl(this.zzsp.zzeg());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzee2 = this.zzsp.zzee();
                zzal(zzee2);
                int zzez2 = this.zzsp.zzez() + zzee2;
                do {
                    list.add(Integer.valueOf(this.zzsp.zzeg()));
                } while (this.zzsp.zzez() < zzez2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzsp.zzeg()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzn(List<Long> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzee = this.zzsp.zzee();
                    zzak(zzee);
                    int zzez = this.zzsp.zzez() + zzee;
                    do {
                        zzhq.zzac(this.zzsp.zzeh());
                    } while (this.zzsp.zzez() < zzez);
                    return;
                default:
                    throw zzhc.zzgr();
            }
            do {
                zzhq.zzac(this.zzsp.zzeh());
                if (!this.zzsp.zzdt()) {
                    zzex2 = this.zzsp.zzex();
                } else {
                    return;
                }
            } while (zzex2 == this.tag);
            this.zzsq = zzex2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzee2 = this.zzsp.zzee();
                zzak(zzee2);
                int zzez2 = this.zzsp.zzez() + zzee2;
                do {
                    list.add(Long.valueOf(this.zzsp.zzeh()));
                } while (this.zzsp.zzez() < zzez2);
                return;
            default:
                throw zzhc.zzgr();
        }
        do {
            list.add(Long.valueOf(this.zzsp.zzeh()));
            if (!this.zzsp.zzdt()) {
                zzex = this.zzsp.zzex();
            } else {
                return;
            }
        } while (zzex == this.tag);
        this.zzsq = zzex;
    }

    public final void zzo(List<Integer> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgu.zzbl(this.zzsp.zzei());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else if (i == 2) {
                int zzez = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    zzgu.zzbl(this.zzsp.zzei());
                } while (this.zzsp.zzez() < zzez);
                zzam(zzez);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzsp.zzei()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else if (i2 == 2) {
                int zzez2 = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    list.add(Integer.valueOf(this.zzsp.zzei()));
                } while (this.zzsp.zzez() < zzez2);
                zzam(zzez2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzp(List<Long> list) throws IOException {
        int zzex;
        int zzex2;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzhq.zzac(this.zzsp.zzej());
                    if (!this.zzsp.zzdt()) {
                        zzex2 = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex2 == this.tag);
                this.zzsq = zzex2;
            } else if (i == 2) {
                int zzez = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    zzhq.zzac(this.zzsp.zzej());
                } while (this.zzsp.zzez() < zzez);
                zzam(zzez);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzsp.zzej()));
                    if (!this.zzsp.zzdt()) {
                        zzex = this.zzsp.zzex();
                    } else {
                        return;
                    }
                } while (zzex == this.tag);
                this.zzsq = zzex;
            } else if (i2 == 2) {
                int zzez2 = this.zzsp.zzez() + this.zzsp.zzee();
                do {
                    list.add(Long.valueOf(this.zzsp.zzej()));
                } while (this.zzsp.zzez() < zzez2);
                zzam(zzez2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    private static void zzak(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzhc.zzgs();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        if (zzdv() != false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        throw new com.google.android.gms.internal.vision.zzhc("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r6, com.google.android.gms.internal.vision.zzht<K, V> r7, com.google.android.gms.internal.vision.zzgd r8) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 2
            r5.zzaj(r0)
            com.google.android.gms.internal.vision.zzft r0 = r5.zzsp
            int r0 = r0.zzee()
            com.google.android.gms.internal.vision.zzft r1 = r5.zzsp
            int r0 = r1.zzas(r0)
            K r1 = r7.zzyn
            V r2 = r7.zzgc
        L_0x0014:
            int r3 = r5.zzdu()     // Catch:{ all -> 0x0067 }
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r3 == r4) goto L_0x005e
            com.google.android.gms.internal.vision.zzft r4 = r5.zzsp     // Catch:{ all -> 0x0067 }
            boolean r4 = r4.zzdt()     // Catch:{ all -> 0x0067 }
            if (r4 != 0) goto L_0x005e
            switch(r3) {
                case 1: goto L_0x003b;
                case 2: goto L_0x002d;
                default: goto L_0x0028;
            }
        L_0x0028:
            boolean r3 = r5.zzdv()     // Catch:{ zzhb -> 0x004f }
            goto L_0x0044
        L_0x002d:
            com.google.android.gms.internal.vision.zzka r3 = r7.zzyo     // Catch:{ zzhb -> 0x004f }
            V r4 = r7.zzgc     // Catch:{ zzhb -> 0x004f }
            java.lang.Class r4 = r4.getClass()     // Catch:{ zzhb -> 0x004f }
            java.lang.Object r3 = r5.zza((com.google.android.gms.internal.vision.zzka) r3, (java.lang.Class<?>) r4, (com.google.android.gms.internal.vision.zzgd) r8)     // Catch:{ zzhb -> 0x004f }
            r2 = r3
            goto L_0x0014
        L_0x003b:
            com.google.android.gms.internal.vision.zzka r3 = r7.zzym     // Catch:{ zzhb -> 0x004f }
            r4 = 0
            java.lang.Object r3 = r5.zza((com.google.android.gms.internal.vision.zzka) r3, (java.lang.Class<?>) r4, (com.google.android.gms.internal.vision.zzgd) r4)     // Catch:{ zzhb -> 0x004f }
            r1 = r3
            goto L_0x0014
        L_0x0044:
            if (r3 == 0) goto L_0x0047
            goto L_0x0014
        L_0x0047:
            com.google.android.gms.internal.vision.zzhc r3 = new com.google.android.gms.internal.vision.zzhc     // Catch:{ zzhb -> 0x004f }
            java.lang.String r4 = "Unable to parse map entry."
            r3.<init>(r4)     // Catch:{ zzhb -> 0x004f }
            throw r3     // Catch:{ zzhb -> 0x004f }
        L_0x004f:
            boolean r3 = r5.zzdv()     // Catch:{ all -> 0x0067 }
            if (r3 == 0) goto L_0x0056
            goto L_0x0014
        L_0x0056:
            com.google.android.gms.internal.vision.zzhc r6 = new com.google.android.gms.internal.vision.zzhc     // Catch:{ all -> 0x0067 }
            java.lang.String r7 = "Unable to parse map entry."
            r6.<init>(r7)     // Catch:{ all -> 0x0067 }
            throw r6     // Catch:{ all -> 0x0067 }
        L_0x005e:
            r6.put(r1, r2)     // Catch:{ all -> 0x0067 }
            com.google.android.gms.internal.vision.zzft r6 = r5.zzsp
            r6.zzat(r0)
            return
        L_0x0067:
            r6 = move-exception
            com.google.android.gms.internal.vision.zzft r7 = r5.zzsp
            r7.zzat(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfy.zza(java.util.Map, com.google.android.gms.internal.vision.zzht, com.google.android.gms.internal.vision.zzgd):void");
    }

    private final Object zza(zzka zzka, Class<?> cls, zzgd zzgd) throws IOException {
        switch (zzfx.zzrr[zzka.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzeb());
            case 2:
                return zzed();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzef());
            case 5:
                return Integer.valueOf(zzea());
            case 6:
                return Long.valueOf(zzdz());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzdy());
            case 9:
                return Long.valueOf(zzdx());
            case 10:
                return zza(cls, zzgd);
            case 11:
                return Integer.valueOf(zzeg());
            case 12:
                return Long.valueOf(zzeh());
            case 13:
                return Integer.valueOf(zzei());
            case 14:
                return Long.valueOf(zzej());
            case 15:
                return zzec();
            case 16:
                return Integer.valueOf(zzee());
            case 17:
                return Long.valueOf(zzdw());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzal(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzhc.zzgs();
        }
    }

    private final void zzam(int i) throws IOException {
        if (this.zzsp.zzez() != i) {
            throw zzhc.zzgm();
        }
    }
}
