package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

final class zzdng implements zzdqa {
    private int tag;
    private final zzdnd zzhdj;
    private int zzhdk;
    private int zzhdl = 0;

    public static zzdng zza(zzdnd zzdnd) {
        if (zzdnd.zzhdc != null) {
            return zzdnd.zzhdc;
        }
        return new zzdng(zzdnd);
    }

    private zzdng(zzdnd zzdnd) {
        this.zzhdj = (zzdnd) zzdod.zza(zzdnd, "input");
        this.zzhdj.zzhdc = this;
    }

    public final int zzaws() throws IOException {
        if (this.zzhdl != 0) {
            this.tag = this.zzhdl;
            this.zzhdl = 0;
        } else {
            this.tag = this.zzhdj.zzavu();
        }
        if (this.tag == 0 || this.tag == this.zzhdk) {
            return Integer.MAX_VALUE;
        }
        return this.tag >>> 3;
    }

    public final int getTag() {
        return this.tag;
    }

    public final boolean zzawt() throws IOException {
        if (this.zzhdj.zzawk() || this.tag == this.zzhdk) {
            return false;
        }
        return this.zzhdj.zzfq(this.tag);
    }

    private final void zzfv(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzdok.zzayi();
        }
    }

    public final double readDouble() throws IOException {
        zzfv(1);
        return this.zzhdj.readDouble();
    }

    public final float readFloat() throws IOException {
        zzfv(5);
        return this.zzhdj.readFloat();
    }

    public final long zzavv() throws IOException {
        zzfv(0);
        return this.zzhdj.zzavv();
    }

    public final long zzavw() throws IOException {
        zzfv(0);
        return this.zzhdj.zzavw();
    }

    public final int zzavx() throws IOException {
        zzfv(0);
        return this.zzhdj.zzavx();
    }

    public final long zzavy() throws IOException {
        zzfv(1);
        return this.zzhdj.zzavy();
    }

    public final int zzavz() throws IOException {
        zzfv(5);
        return this.zzhdj.zzavz();
    }

    public final boolean zzawa() throws IOException {
        zzfv(0);
        return this.zzhdj.zzawa();
    }

    public final String readString() throws IOException {
        zzfv(2);
        return this.zzhdj.readString();
    }

    public final String zzawb() throws IOException {
        zzfv(2);
        return this.zzhdj.zzawb();
    }

    public final <T> T zza(zzdqb<T> zzdqb, zzdno zzdno) throws IOException {
        zzfv(2);
        return zzc(zzdqb, zzdno);
    }

    public final <T> T zzb(zzdqb<T> zzdqb, zzdno zzdno) throws IOException {
        zzfv(3);
        return zzd(zzdqb, zzdno);
    }

    private final <T> T zzc(zzdqb<T> zzdqb, zzdno zzdno) throws IOException {
        int zzawd = this.zzhdj.zzawd();
        if (this.zzhdj.zzhcz < this.zzhdj.zzhda) {
            int zzfr = this.zzhdj.zzfr(zzawd);
            T newInstance = zzdqb.newInstance();
            this.zzhdj.zzhcz++;
            zzdqb.zza(newInstance, this, zzdno);
            zzdqb.zzaa(newInstance);
            this.zzhdj.zzfp(0);
            zzdnd zzdnd = this.zzhdj;
            zzdnd.zzhcz--;
            this.zzhdj.zzfs(zzfr);
            return newInstance;
        }
        throw new zzdok("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzd(zzdqb<T> zzdqb, zzdno zzdno) throws IOException {
        int i = this.zzhdk;
        this.zzhdk = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzdqb.newInstance();
            zzdqb.zza(newInstance, this, zzdno);
            zzdqb.zzaa(newInstance);
            if (this.tag == this.zzhdk) {
                return newInstance;
            }
            throw zzdok.zzayj();
        } finally {
            this.zzhdk = i;
        }
    }

    public final zzdmr zzawc() throws IOException {
        zzfv(2);
        return this.zzhdj.zzawc();
    }

    public final int zzawd() throws IOException {
        zzfv(0);
        return this.zzhdj.zzawd();
    }

    public final int zzawe() throws IOException {
        zzfv(0);
        return this.zzhdj.zzawe();
    }

    public final int zzawf() throws IOException {
        zzfv(5);
        return this.zzhdj.zzawf();
    }

    public final long zzawg() throws IOException {
        zzfv(1);
        return this.zzhdj.zzawg();
    }

    public final int zzawh() throws IOException {
        zzfv(0);
        return this.zzhdj.zzawh();
    }

    public final long zzawi() throws IOException {
        zzfv(0);
        return this.zzhdj.zzawi();
    }

    public final void zzi(List<Double> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof zzdnl) {
            zzdnl zzdnl = (zzdnl) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzawd = this.zzhdj.zzawd();
                    zzfw(zzawd);
                    int zzawl = this.zzhdj.zzawl() + zzawd;
                    do {
                        zzdnl.zzd(this.zzhdj.readDouble());
                    } while (this.zzhdj.zzawl() < zzawl);
                    return;
                default:
                    throw zzdok.zzayi();
            }
            do {
                zzdnl.zzd(this.zzhdj.readDouble());
                if (!this.zzhdj.zzawk()) {
                    zzavu2 = this.zzhdj.zzavu();
                } else {
                    return;
                }
            } while (zzavu2 == this.tag);
            this.zzhdl = zzavu2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzawd2 = this.zzhdj.zzawd();
                zzfw(zzawd2);
                int zzawl2 = this.zzhdj.zzawl() + zzawd2;
                do {
                    list.add(Double.valueOf(this.zzhdj.readDouble()));
                } while (this.zzhdj.zzawl() < zzawl2);
                return;
            default:
                throw zzdok.zzayi();
        }
        do {
            list.add(Double.valueOf(this.zzhdj.readDouble()));
            if (!this.zzhdj.zzawk()) {
                zzavu = this.zzhdj.zzavu();
            } else {
                return;
            }
        } while (zzavu == this.tag);
        this.zzhdl = zzavu;
    }

    public final void zzj(List<Float> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof zzdny) {
            zzdny zzdny = (zzdny) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzawd = this.zzhdj.zzawd();
                zzfx(zzawd);
                int zzawl = this.zzhdj.zzawl() + zzawd;
                do {
                    zzdny.zzi(this.zzhdj.readFloat());
                } while (this.zzhdj.zzawl() < zzawl);
            } else if (i == 5) {
                do {
                    zzdny.zzi(this.zzhdj.readFloat());
                    if (!this.zzhdj.zzawk()) {
                        zzavu2 = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu2 == this.tag);
                this.zzhdl = zzavu2;
            } else {
                throw zzdok.zzayi();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzawd2 = this.zzhdj.zzawd();
                zzfx(zzawd2);
                int zzawl2 = this.zzhdj.zzawl() + zzawd2;
                do {
                    list.add(Float.valueOf(this.zzhdj.readFloat()));
                } while (this.zzhdj.zzawl() < zzawl2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zzhdj.readFloat()));
                    if (!this.zzhdj.zzawk()) {
                        zzavu = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu == this.tag);
                this.zzhdl = zzavu;
            } else {
                throw zzdok.zzayi();
            }
        }
    }

    public final void zzk(List<Long> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof zzdoy) {
            zzdoy zzdoy = (zzdoy) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzdoy.zzfu(this.zzhdj.zzavv());
                    if (!this.zzhdj.zzawk()) {
                        zzavu2 = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu2 == this.tag);
                this.zzhdl = zzavu2;
            } else if (i == 2) {
                int zzawl = this.zzhdj.zzawl() + this.zzhdj.zzawd();
                do {
                    zzdoy.zzfu(this.zzhdj.zzavv());
                } while (this.zzhdj.zzawl() < zzawl);
                zzfy(zzawl);
            } else {
                throw zzdok.zzayi();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzhdj.zzavv()));
                    if (!this.zzhdj.zzawk()) {
                        zzavu = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu == this.tag);
                this.zzhdl = zzavu;
            } else if (i2 == 2) {
                int zzawl2 = this.zzhdj.zzawl() + this.zzhdj.zzawd();
                do {
                    list.add(Long.valueOf(this.zzhdj.zzavv()));
                } while (this.zzhdj.zzawl() < zzawl2);
                zzfy(zzawl2);
            } else {
                throw zzdok.zzayi();
            }
        }
    }

    public final void zzl(List<Long> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof zzdoy) {
            zzdoy zzdoy = (zzdoy) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzdoy.zzfu(this.zzhdj.zzavw());
                    if (!this.zzhdj.zzawk()) {
                        zzavu2 = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu2 == this.tag);
                this.zzhdl = zzavu2;
            } else if (i == 2) {
                int zzawl = this.zzhdj.zzawl() + this.zzhdj.zzawd();
                do {
                    zzdoy.zzfu(this.zzhdj.zzavw());
                } while (this.zzhdj.zzawl() < zzawl);
                zzfy(zzawl);
            } else {
                throw zzdok.zzayi();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzhdj.zzavw()));
                    if (!this.zzhdj.zzawk()) {
                        zzavu = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu == this.tag);
                this.zzhdl = zzavu;
            } else if (i2 == 2) {
                int zzawl2 = this.zzhdj.zzawl() + this.zzhdj.zzawd();
                do {
                    list.add(Long.valueOf(this.zzhdj.zzavw()));
                } while (this.zzhdj.zzawl() < zzawl2);
                zzfy(zzawl2);
            } else {
                throw zzdok.zzayi();
            }
        }
    }

    public final void zzm(List<Integer> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof zzdoc) {
            zzdoc zzdoc = (zzdoc) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzdoc.zzgp(this.zzhdj.zzavx());
                    if (!this.zzhdj.zzawk()) {
                        zzavu2 = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu2 == this.tag);
                this.zzhdl = zzavu2;
            } else if (i == 2) {
                int zzawl = this.zzhdj.zzawl() + this.zzhdj.zzawd();
                do {
                    zzdoc.zzgp(this.zzhdj.zzavx());
                } while (this.zzhdj.zzawl() < zzawl);
                zzfy(zzawl);
            } else {
                throw zzdok.zzayi();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzhdj.zzavx()));
                    if (!this.zzhdj.zzawk()) {
                        zzavu = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu == this.tag);
                this.zzhdl = zzavu;
            } else if (i2 == 2) {
                int zzawl2 = this.zzhdj.zzawl() + this.zzhdj.zzawd();
                do {
                    list.add(Integer.valueOf(this.zzhdj.zzavx()));
                } while (this.zzhdj.zzawl() < zzawl2);
                zzfy(zzawl2);
            } else {
                throw zzdok.zzayi();
            }
        }
    }

    public final void zzn(List<Long> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof zzdoy) {
            zzdoy zzdoy = (zzdoy) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzawd = this.zzhdj.zzawd();
                    zzfw(zzawd);
                    int zzawl = this.zzhdj.zzawl() + zzawd;
                    do {
                        zzdoy.zzfu(this.zzhdj.zzavy());
                    } while (this.zzhdj.zzawl() < zzawl);
                    return;
                default:
                    throw zzdok.zzayi();
            }
            do {
                zzdoy.zzfu(this.zzhdj.zzavy());
                if (!this.zzhdj.zzawk()) {
                    zzavu2 = this.zzhdj.zzavu();
                } else {
                    return;
                }
            } while (zzavu2 == this.tag);
            this.zzhdl = zzavu2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzawd2 = this.zzhdj.zzawd();
                zzfw(zzawd2);
                int zzawl2 = this.zzhdj.zzawl() + zzawd2;
                do {
                    list.add(Long.valueOf(this.zzhdj.zzavy()));
                } while (this.zzhdj.zzawl() < zzawl2);
                return;
            default:
                throw zzdok.zzayi();
        }
        do {
            list.add(Long.valueOf(this.zzhdj.zzavy()));
            if (!this.zzhdj.zzawk()) {
                zzavu = this.zzhdj.zzavu();
            } else {
                return;
            }
        } while (zzavu == this.tag);
        this.zzhdl = zzavu;
    }

    public final void zzo(List<Integer> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof zzdoc) {
            zzdoc zzdoc = (zzdoc) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzawd = this.zzhdj.zzawd();
                zzfx(zzawd);
                int zzawl = this.zzhdj.zzawl() + zzawd;
                do {
                    zzdoc.zzgp(this.zzhdj.zzavz());
                } while (this.zzhdj.zzawl() < zzawl);
            } else if (i == 5) {
                do {
                    zzdoc.zzgp(this.zzhdj.zzavz());
                    if (!this.zzhdj.zzawk()) {
                        zzavu2 = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu2 == this.tag);
                this.zzhdl = zzavu2;
            } else {
                throw zzdok.zzayi();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzawd2 = this.zzhdj.zzawd();
                zzfx(zzawd2);
                int zzawl2 = this.zzhdj.zzawl() + zzawd2;
                do {
                    list.add(Integer.valueOf(this.zzhdj.zzavz()));
                } while (this.zzhdj.zzawl() < zzawl2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzhdj.zzavz()));
                    if (!this.zzhdj.zzawk()) {
                        zzavu = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu == this.tag);
                this.zzhdl = zzavu;
            } else {
                throw zzdok.zzayi();
            }
        }
    }

    public final void zzp(List<Boolean> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof zzdmp) {
            zzdmp zzdmp = (zzdmp) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzdmp.addBoolean(this.zzhdj.zzawa());
                    if (!this.zzhdj.zzawk()) {
                        zzavu2 = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu2 == this.tag);
                this.zzhdl = zzavu2;
            } else if (i == 2) {
                int zzawl = this.zzhdj.zzawl() + this.zzhdj.zzawd();
                do {
                    zzdmp.addBoolean(this.zzhdj.zzawa());
                } while (this.zzhdj.zzawl() < zzawl);
                zzfy(zzawl);
            } else {
                throw zzdok.zzayi();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zzhdj.zzawa()));
                    if (!this.zzhdj.zzawk()) {
                        zzavu = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu == this.tag);
                this.zzhdl = zzavu;
            } else if (i2 == 2) {
                int zzawl2 = this.zzhdj.zzawl() + this.zzhdj.zzawd();
                do {
                    list.add(Boolean.valueOf(this.zzhdj.zzawa()));
                } while (this.zzhdj.zzawl() < zzawl2);
                zzfy(zzawl2);
            } else {
                throw zzdok.zzayi();
            }
        }
    }

    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    public final void zzq(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzavu;
        int zzavu2;
        if ((this.tag & 7) != 2) {
            throw zzdok.zzayi();
        } else if (!(list instanceof zzdot) || z) {
            do {
                list.add(z ? zzawb() : readString());
                if (!this.zzhdj.zzawk()) {
                    zzavu = this.zzhdj.zzavu();
                } else {
                    return;
                }
            } while (zzavu == this.tag);
            this.zzhdl = zzavu;
        } else {
            zzdot zzdot = (zzdot) list;
            do {
                zzdot.zzdb(zzawc());
                if (!this.zzhdj.zzawk()) {
                    zzavu2 = this.zzhdj.zzavu();
                } else {
                    return;
                }
            } while (zzavu2 == this.tag);
            this.zzhdl = zzavu2;
        }
    }

    public final <T> void zza(List<T> list, zzdqb<T> zzdqb, zzdno zzdno) throws IOException {
        int zzavu;
        if ((this.tag & 7) == 2) {
            int i = this.tag;
            do {
                list.add(zzc(zzdqb, zzdno));
                if (!this.zzhdj.zzawk() && this.zzhdl == 0) {
                    zzavu = this.zzhdj.zzavu();
                } else {
                    return;
                }
            } while (zzavu == i);
            this.zzhdl = zzavu;
            return;
        }
        throw zzdok.zzayi();
    }

    public final <T> void zzb(List<T> list, zzdqb<T> zzdqb, zzdno zzdno) throws IOException {
        int zzavu;
        if ((this.tag & 7) == 3) {
            int i = this.tag;
            do {
                list.add(zzd(zzdqb, zzdno));
                if (!this.zzhdj.zzawk() && this.zzhdl == 0) {
                    zzavu = this.zzhdj.zzavu();
                } else {
                    return;
                }
            } while (zzavu == i);
            this.zzhdl = zzavu;
            return;
        }
        throw zzdok.zzayi();
    }

    public final void zzr(List<zzdmr> list) throws IOException {
        int zzavu;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzawc());
                if (!this.zzhdj.zzawk()) {
                    zzavu = this.zzhdj.zzavu();
                } else {
                    return;
                }
            } while (zzavu == this.tag);
            this.zzhdl = zzavu;
            return;
        }
        throw zzdok.zzayi();
    }

    public final void zzs(List<Integer> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof zzdoc) {
            zzdoc zzdoc = (zzdoc) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzdoc.zzgp(this.zzhdj.zzawd());
                    if (!this.zzhdj.zzawk()) {
                        zzavu2 = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu2 == this.tag);
                this.zzhdl = zzavu2;
            } else if (i == 2) {
                int zzawl = this.zzhdj.zzawl() + this.zzhdj.zzawd();
                do {
                    zzdoc.zzgp(this.zzhdj.zzawd());
                } while (this.zzhdj.zzawl() < zzawl);
                zzfy(zzawl);
            } else {
                throw zzdok.zzayi();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzhdj.zzawd()));
                    if (!this.zzhdj.zzawk()) {
                        zzavu = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu == this.tag);
                this.zzhdl = zzavu;
            } else if (i2 == 2) {
                int zzawl2 = this.zzhdj.zzawl() + this.zzhdj.zzawd();
                do {
                    list.add(Integer.valueOf(this.zzhdj.zzawd()));
                } while (this.zzhdj.zzawl() < zzawl2);
                zzfy(zzawl2);
            } else {
                throw zzdok.zzayi();
            }
        }
    }

    public final void zzt(List<Integer> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof zzdoc) {
            zzdoc zzdoc = (zzdoc) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzdoc.zzgp(this.zzhdj.zzawe());
                    if (!this.zzhdj.zzawk()) {
                        zzavu2 = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu2 == this.tag);
                this.zzhdl = zzavu2;
            } else if (i == 2) {
                int zzawl = this.zzhdj.zzawl() + this.zzhdj.zzawd();
                do {
                    zzdoc.zzgp(this.zzhdj.zzawe());
                } while (this.zzhdj.zzawl() < zzawl);
                zzfy(zzawl);
            } else {
                throw zzdok.zzayi();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzhdj.zzawe()));
                    if (!this.zzhdj.zzawk()) {
                        zzavu = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu == this.tag);
                this.zzhdl = zzavu;
            } else if (i2 == 2) {
                int zzawl2 = this.zzhdj.zzawl() + this.zzhdj.zzawd();
                do {
                    list.add(Integer.valueOf(this.zzhdj.zzawe()));
                } while (this.zzhdj.zzawl() < zzawl2);
                zzfy(zzawl2);
            } else {
                throw zzdok.zzayi();
            }
        }
    }

    public final void zzu(List<Integer> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof zzdoc) {
            zzdoc zzdoc = (zzdoc) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzawd = this.zzhdj.zzawd();
                zzfx(zzawd);
                int zzawl = this.zzhdj.zzawl() + zzawd;
                do {
                    zzdoc.zzgp(this.zzhdj.zzawf());
                } while (this.zzhdj.zzawl() < zzawl);
            } else if (i == 5) {
                do {
                    zzdoc.zzgp(this.zzhdj.zzawf());
                    if (!this.zzhdj.zzawk()) {
                        zzavu2 = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu2 == this.tag);
                this.zzhdl = zzavu2;
            } else {
                throw zzdok.zzayi();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzawd2 = this.zzhdj.zzawd();
                zzfx(zzawd2);
                int zzawl2 = this.zzhdj.zzawl() + zzawd2;
                do {
                    list.add(Integer.valueOf(this.zzhdj.zzawf()));
                } while (this.zzhdj.zzawl() < zzawl2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzhdj.zzawf()));
                    if (!this.zzhdj.zzawk()) {
                        zzavu = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu == this.tag);
                this.zzhdl = zzavu;
            } else {
                throw zzdok.zzayi();
            }
        }
    }

    public final void zzv(List<Long> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof zzdoy) {
            zzdoy zzdoy = (zzdoy) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzawd = this.zzhdj.zzawd();
                    zzfw(zzawd);
                    int zzawl = this.zzhdj.zzawl() + zzawd;
                    do {
                        zzdoy.zzfu(this.zzhdj.zzawg());
                    } while (this.zzhdj.zzawl() < zzawl);
                    return;
                default:
                    throw zzdok.zzayi();
            }
            do {
                zzdoy.zzfu(this.zzhdj.zzawg());
                if (!this.zzhdj.zzawk()) {
                    zzavu2 = this.zzhdj.zzavu();
                } else {
                    return;
                }
            } while (zzavu2 == this.tag);
            this.zzhdl = zzavu2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzawd2 = this.zzhdj.zzawd();
                zzfw(zzawd2);
                int zzawl2 = this.zzhdj.zzawl() + zzawd2;
                do {
                    list.add(Long.valueOf(this.zzhdj.zzawg()));
                } while (this.zzhdj.zzawl() < zzawl2);
                return;
            default:
                throw zzdok.zzayi();
        }
        do {
            list.add(Long.valueOf(this.zzhdj.zzawg()));
            if (!this.zzhdj.zzawk()) {
                zzavu = this.zzhdj.zzavu();
            } else {
                return;
            }
        } while (zzavu == this.tag);
        this.zzhdl = zzavu;
    }

    public final void zzw(List<Integer> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof zzdoc) {
            zzdoc zzdoc = (zzdoc) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzdoc.zzgp(this.zzhdj.zzawh());
                    if (!this.zzhdj.zzawk()) {
                        zzavu2 = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu2 == this.tag);
                this.zzhdl = zzavu2;
            } else if (i == 2) {
                int zzawl = this.zzhdj.zzawl() + this.zzhdj.zzawd();
                do {
                    zzdoc.zzgp(this.zzhdj.zzawh());
                } while (this.zzhdj.zzawl() < zzawl);
                zzfy(zzawl);
            } else {
                throw zzdok.zzayi();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzhdj.zzawh()));
                    if (!this.zzhdj.zzawk()) {
                        zzavu = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu == this.tag);
                this.zzhdl = zzavu;
            } else if (i2 == 2) {
                int zzawl2 = this.zzhdj.zzawl() + this.zzhdj.zzawd();
                do {
                    list.add(Integer.valueOf(this.zzhdj.zzawh()));
                } while (this.zzhdj.zzawl() < zzawl2);
                zzfy(zzawl2);
            } else {
                throw zzdok.zzayi();
            }
        }
    }

    public final void zzx(List<Long> list) throws IOException {
        int zzavu;
        int zzavu2;
        if (list instanceof zzdoy) {
            zzdoy zzdoy = (zzdoy) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzdoy.zzfu(this.zzhdj.zzawi());
                    if (!this.zzhdj.zzawk()) {
                        zzavu2 = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu2 == this.tag);
                this.zzhdl = zzavu2;
            } else if (i == 2) {
                int zzawl = this.zzhdj.zzawl() + this.zzhdj.zzawd();
                do {
                    zzdoy.zzfu(this.zzhdj.zzawi());
                } while (this.zzhdj.zzawl() < zzawl);
                zzfy(zzawl);
            } else {
                throw zzdok.zzayi();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzhdj.zzawi()));
                    if (!this.zzhdj.zzawk()) {
                        zzavu = this.zzhdj.zzavu();
                    } else {
                        return;
                    }
                } while (zzavu == this.tag);
                this.zzhdl = zzavu;
            } else if (i2 == 2) {
                int zzawl2 = this.zzhdj.zzawl() + this.zzhdj.zzawd();
                do {
                    list.add(Long.valueOf(this.zzhdj.zzawi()));
                } while (this.zzhdj.zzawl() < zzawl2);
                zzfy(zzawl2);
            } else {
                throw zzdok.zzayi();
            }
        }
    }

    private static void zzfw(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzdok.zzayj();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        if (zzawt() != false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        throw new com.google.android.gms.internal.ads.zzdok("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x004f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r6, com.google.android.gms.internal.ads.zzdpd<K, V> r7, com.google.android.gms.internal.ads.zzdno r8) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 2
            r5.zzfv(r0)
            com.google.android.gms.internal.ads.zzdnd r0 = r5.zzhdj
            int r0 = r0.zzawd()
            com.google.android.gms.internal.ads.zzdnd r1 = r5.zzhdj
            int r0 = r1.zzfr(r0)
            K r1 = r7.zzhjj
            V r2 = r7.zzckh
        L_0x0014:
            int r3 = r5.zzaws()     // Catch:{ all -> 0x0067 }
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r3 == r4) goto L_0x005e
            com.google.android.gms.internal.ads.zzdnd r4 = r5.zzhdj     // Catch:{ all -> 0x0067 }
            boolean r4 = r4.zzawk()     // Catch:{ all -> 0x0067 }
            if (r4 != 0) goto L_0x005e
            switch(r3) {
                case 1: goto L_0x003b;
                case 2: goto L_0x002d;
                default: goto L_0x0028;
            }
        L_0x0028:
            boolean r3 = r5.zzawt()     // Catch:{ zzdol -> 0x004f }
            goto L_0x0044
        L_0x002d:
            com.google.android.gms.internal.ads.zzdri r3 = r7.zzhjk     // Catch:{ zzdol -> 0x004f }
            V r4 = r7.zzckh     // Catch:{ zzdol -> 0x004f }
            java.lang.Class r4 = r4.getClass()     // Catch:{ zzdol -> 0x004f }
            java.lang.Object r3 = r5.zza((com.google.android.gms.internal.ads.zzdri) r3, (java.lang.Class<?>) r4, (com.google.android.gms.internal.ads.zzdno) r8)     // Catch:{ zzdol -> 0x004f }
            r2 = r3
            goto L_0x0014
        L_0x003b:
            com.google.android.gms.internal.ads.zzdri r3 = r7.zzhji     // Catch:{ zzdol -> 0x004f }
            r4 = 0
            java.lang.Object r3 = r5.zza((com.google.android.gms.internal.ads.zzdri) r3, (java.lang.Class<?>) r4, (com.google.android.gms.internal.ads.zzdno) r4)     // Catch:{ zzdol -> 0x004f }
            r1 = r3
            goto L_0x0014
        L_0x0044:
            if (r3 == 0) goto L_0x0047
            goto L_0x0014
        L_0x0047:
            com.google.android.gms.internal.ads.zzdok r3 = new com.google.android.gms.internal.ads.zzdok     // Catch:{ zzdol -> 0x004f }
            java.lang.String r4 = "Unable to parse map entry."
            r3.<init>(r4)     // Catch:{ zzdol -> 0x004f }
            throw r3     // Catch:{ zzdol -> 0x004f }
        L_0x004f:
            boolean r3 = r5.zzawt()     // Catch:{ all -> 0x0067 }
            if (r3 == 0) goto L_0x0056
            goto L_0x0014
        L_0x0056:
            com.google.android.gms.internal.ads.zzdok r6 = new com.google.android.gms.internal.ads.zzdok     // Catch:{ all -> 0x0067 }
            java.lang.String r7 = "Unable to parse map entry."
            r6.<init>(r7)     // Catch:{ all -> 0x0067 }
            throw r6     // Catch:{ all -> 0x0067 }
        L_0x005e:
            r6.put(r1, r2)     // Catch:{ all -> 0x0067 }
            com.google.android.gms.internal.ads.zzdnd r6 = r5.zzhdj
            r6.zzfs(r0)
            return
        L_0x0067:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzdnd r7 = r5.zzhdj
            r7.zzfs(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdng.zza(java.util.Map, com.google.android.gms.internal.ads.zzdpd, com.google.android.gms.internal.ads.zzdno):void");
    }

    private final Object zza(zzdri zzdri, Class<?> cls, zzdno zzdno) throws IOException {
        switch (zzdnh.zzhdm[zzdri.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzawa());
            case 2:
                return zzawc();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzawe());
            case 5:
                return Integer.valueOf(zzavz());
            case 6:
                return Long.valueOf(zzavy());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzavx());
            case 9:
                return Long.valueOf(zzavw());
            case 10:
                zzfv(2);
                return zzc(zzdpx.zzazg().zzg(cls), zzdno);
            case 11:
                return Integer.valueOf(zzawf());
            case 12:
                return Long.valueOf(zzawg());
            case 13:
                return Integer.valueOf(zzawh());
            case 14:
                return Long.valueOf(zzawi());
            case 15:
                return zzawb();
            case 16:
                return Integer.valueOf(zzawd());
            case 17:
                return Long.valueOf(zzavv());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzfx(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzdok.zzayj();
        }
    }

    private final void zzfy(int i) throws IOException {
        if (this.zzhdj.zzawl() != i) {
            throw zzdok.zzayd();
        }
    }
}
