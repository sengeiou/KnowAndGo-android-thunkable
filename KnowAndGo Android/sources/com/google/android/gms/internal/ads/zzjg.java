package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class zzjg implements zzid {
    private long zzack;
    private int zzamq;
    private zzif zzamt;
    private final zzjf zzanh;
    private final zzjd zzano;
    private final zzkm zzanp;
    private final zzkm zzanq;
    private final zzkm zzanr;
    private long zzans;
    private long zzant;
    private long zzanu;
    private zzjj zzanv;
    private zzjj zzanw;
    private zzjj zzanx;
    private boolean zzany;
    private int zzanz;
    private long zzaoa;
    private boolean zzaob;
    private long zzaoc;
    private long zzaod;
    private int zzaoe;
    private long zzaof;
    private zzkk zzaog;
    private zzkk zzaoh;
    private boolean zzaoi;
    private int zzaoj;
    private int zzaok;
    private int zzaol;
    private int zzaom;
    private long zzaon;
    private boolean zzaoo;
    private boolean zzaop;

    public zzjg() {
        this(new zzja());
    }

    private zzjg(zzjd zzjd) {
        this.zzans = -1;
        this.zzant = -1;
        this.zzanu = 1000000;
        this.zzack = -1;
        this.zzaoc = -1;
        this.zzaod = -1;
        this.zzaoe = 0;
        this.zzaof = -1;
        this.zzano = zzjd;
        this.zzano.zza((zzje) new zzji(this));
        this.zzanh = new zzjf();
        this.zzanp = new zzkm(4);
        this.zzanq = new zzkm(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzanr = new zzkm(4);
    }

    public final void zza(zzif zzif) {
        this.zzamt = zzif;
    }

    public final void zzfh() {
        this.zzaof = -1;
        this.zzaok = 0;
        this.zzano.reset();
        this.zzanh.reset();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0005 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzie r8, com.google.android.gms.internal.ads.zzij r9) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r7 = this;
            r0 = 0
            r7.zzaoo = r0
            r1 = 1
            r2 = 1
        L_0x0005:
            if (r2 == 0) goto L_0x003f
            boolean r3 = r7.zzaoo
            if (r3 != 0) goto L_0x003f
            com.google.android.gms.internal.ads.zzjd r2 = r7.zzano
            boolean r2 = r2.zza((com.google.android.gms.internal.ads.zzie) r8)
            if (r2 == 0) goto L_0x0005
            long r3 = r8.getPosition()
            boolean r5 = r7.zzaob
            if (r5 == 0) goto L_0x0027
            r7.zzaod = r3
            long r3 = r7.zzaoc
            r9.zzahv = r3
            r7.zzaoe = r1
            r7.zzaob = r0
        L_0x0025:
            r3 = 1
            goto L_0x003c
        L_0x0027:
            int r3 = r7.zzaoe
            r4 = 2
            if (r3 != r4) goto L_0x003b
            long r3 = r7.zzaod
            r5 = -1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x003b
            long r3 = r7.zzaod
            r9.zzahv = r3
            r7.zzaod = r5
            goto L_0x0025
        L_0x003b:
            r3 = 0
        L_0x003c:
            if (r3 == 0) goto L_0x0005
            return r1
        L_0x003f:
            if (r2 == 0) goto L_0x0042
            return r0
        L_0x0042:
            r8 = -1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjg.zza(com.google.android.gms.internal.ads.zzie, com.google.android.gms.internal.ads.zzij):int");
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i, long j, long j2) throws zzhl {
        if (i == 160) {
            this.zzaop = false;
        } else if (i == 174) {
            this.zzanv = new zzjj();
        } else if (i == 187) {
            this.zzaoi = false;
        } else if (i == 19899) {
            this.zzanz = -1;
            this.zzaoa = -1;
        } else if (i == 20533) {
            this.zzanv.zzaos = true;
        } else if (i == 25152) {
        } else {
            if (i != 408125543) {
                if (i == 475249515) {
                    this.zzaog = new zzkk();
                    this.zzaoh = new zzkk();
                } else if (i == 524531317 && this.zzaoe == 0 && this.zzaoc != -1) {
                    this.zzaob = true;
                }
            } else if (this.zzans == -1) {
                this.zzans = j;
                this.zzant = j2;
            } else {
                throw new zzhl("Multiple Segment elements not supported");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzy(int i) throws zzhl {
        zzhj zzhj;
        zzhj zzhj2;
        if (i != 160) {
            if (i != 174) {
                if (i != 19899) {
                    if (i != 25152) {
                        if (i != 374648427) {
                            if (i == 475249515 && this.zzaoe != 2) {
                                zzif zzif = this.zzamt;
                                if (this.zzans == -1) {
                                    throw new zzhl("Segment start/end offsets unknown");
                                } else if (this.zzack == -1) {
                                    throw new zzhl("Duration unknown");
                                } else if (this.zzaog == null || this.zzaoh == null || this.zzaog.size() == 0 || this.zzaog.size() != this.zzaoh.size()) {
                                    throw new zzhl("Invalid/missing cue points");
                                } else {
                                    int size = this.zzaog.size();
                                    int[] iArr = new int[size];
                                    long[] jArr = new long[size];
                                    long[] jArr2 = new long[size];
                                    long[] jArr3 = new long[size];
                                    int i2 = 0;
                                    for (int i3 = 0; i3 < size; i3++) {
                                        jArr3[i3] = this.zzaog.get(i3);
                                        jArr[i3] = this.zzans + this.zzaoh.get(i3);
                                    }
                                    while (true) {
                                        int i4 = size - 1;
                                        if (i2 < i4) {
                                            int i5 = i2 + 1;
                                            iArr[i2] = (int) (jArr[i5] - jArr[i2]);
                                            jArr2[i2] = jArr3[i5] - jArr3[i2];
                                            i2 = i5;
                                        } else {
                                            iArr[i4] = (int) ((this.zzans + this.zzant) - jArr[i4]);
                                            jArr2[i4] = this.zzack - jArr3[i4];
                                            this.zzaog = null;
                                            this.zzaoh = null;
                                            zzif.zza(new zzia(iArr, jArr, jArr2, jArr3));
                                            this.zzaoe = 2;
                                            return;
                                        }
                                    }
                                }
                            }
                        } else if (this.zzanx == null && this.zzanw == null) {
                            throw new zzhl("No valid tracks were found");
                        } else {
                            this.zzamt.zzfi();
                        }
                    } else if (!this.zzanv.zzaos) {
                        throw new zzhl("Found an unsupported ContentEncoding");
                    } else if (this.zzanv.zzajy == null) {
                        throw new zzhl("Encrypted Track found but ContentEncKeyID was not found");
                    } else if (!this.zzany) {
                        this.zzamt.zzb(new zzhy(MimeTypes.VIDEO_WEBM, this.zzanv.zzajy));
                        this.zzany = true;
                    }
                } else if (this.zzanz == -1 || this.zzaoa == -1) {
                    throw new zzhl("Mandatory element SeekID or SeekPosition not found");
                } else if (this.zzanz == 475249515) {
                    this.zzaoc = this.zzaoa;
                }
            } else if (this.zzanv.number == -1 || this.zzanv.type == -1) {
                throw new zzhl("Mandatory element TrackNumber or TrackType not found");
            } else if ((this.zzanv.type != 2 || this.zzanw == null) && (this.zzanv.type != 1 || this.zzanx == null)) {
                if (this.zzanv.type == 2 && zzat(this.zzanv.zzaor)) {
                    this.zzanw = this.zzanv;
                    this.zzanw.zzamx = this.zzamt.zzs(this.zzanw.number);
                    zzip zzip = this.zzanw.zzamx;
                    if (this.zzanw != null && "A_VORBIS".equals(this.zzanw.zzaor)) {
                        zzhj2 = zzhj.zzb(MimeTypes.AUDIO_VORBIS, 8192, this.zzack, this.zzanw.zzafu, this.zzanw.zzafv, zzfx());
                    } else if (this.zzanw == null || !"A_OPUS".equals(this.zzanw.zzaor)) {
                        throw new zzhl("Unable to build format");
                    } else {
                        ArrayList arrayList = new ArrayList(3);
                        arrayList.add(this.zzanw.zzaov);
                        arrayList.add(ByteBuffer.allocate(64).putLong(this.zzanw.zzaow).array());
                        arrayList.add(ByteBuffer.allocate(64).putLong(this.zzanw.zzaox).array());
                        zzhj2 = zzhj.zzb(MimeTypes.AUDIO_OPUS, 5760, this.zzack, this.zzanw.zzafu, this.zzanw.zzafv, arrayList);
                    }
                    zzip.zza(zzhj2);
                } else if (this.zzanv.type == 1 && zzat(this.zzanv.zzaor)) {
                    this.zzanx = this.zzanv;
                    this.zzanx.zzamx = this.zzamt.zzs(this.zzanx.number);
                    zzip zzip2 = this.zzanx.zzamx;
                    if (this.zzanx != null && "V_VP8".equals(this.zzanx.zzaor)) {
                        zzhj = zzhj.zza(MimeTypes.VIDEO_VP8, -1, this.zzack, this.zzanx.zzaot, this.zzanx.zzaou, (List<byte[]>) null);
                    } else if (this.zzanx == null || !"V_VP9".equals(this.zzanx.zzaor)) {
                        throw new zzhl("Unable to build format");
                    } else {
                        zzhj = zzhj.zza(MimeTypes.VIDEO_VP9, -1, this.zzack, this.zzanx.zzaot, this.zzanx.zzaou, (List<byte[]>) null);
                    }
                    zzip2.zza(zzhj);
                }
                this.zzanv = null;
            } else {
                this.zzanv = null;
            }
        } else if (this.zzaok == 2) {
            if (!this.zzaop) {
                this.zzaom |= 1;
            }
            zza(((this.zzanw == null || this.zzaol != this.zzanw.number) ? this.zzanx : this.zzanw).zzamx);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(int i, long j) throws zzhl {
        switch (i) {
            case 131:
                this.zzanv.type = (int) j;
                return;
            case 159:
                this.zzanv.zzafu = (int) j;
                return;
            case 176:
                this.zzanv.zzaot = (int) j;
                return;
            case 179:
                this.zzaog.add(zzdw(j));
                return;
            case 186:
                this.zzanv.zzaou = (int) j;
                return;
            case JfifUtil.MARKER_RST7:
                this.zzanv.number = (int) j;
                return;
            case 231:
                this.zzaof = zzdw(j);
                return;
            case 241:
                if (!this.zzaoi) {
                    this.zzaoh.add(j);
                    this.zzaoi = true;
                    return;
                }
                return;
            case 251:
                this.zzaop = true;
                return;
            case 17029:
                if (j < 1 || j > 2) {
                    StringBuilder sb = new StringBuilder(53);
                    sb.append("DocTypeReadVersion ");
                    sb.append(j);
                    sb.append(" not supported");
                    throw new zzhl(sb.toString());
                }
                return;
            case 17143:
                if (j != 1) {
                    StringBuilder sb2 = new StringBuilder(50);
                    sb2.append("EBMLReadVersion ");
                    sb2.append(j);
                    sb2.append(" not supported");
                    throw new zzhl(sb2.toString());
                }
                return;
            case 18401:
                if (j != 5) {
                    StringBuilder sb3 = new StringBuilder(49);
                    sb3.append("ContentEncAlgo ");
                    sb3.append(j);
                    sb3.append(" not supported");
                    throw new zzhl(sb3.toString());
                }
                return;
            case 18408:
                if (j != 1) {
                    StringBuilder sb4 = new StringBuilder(56);
                    sb4.append("AESSettingsCipherMode ");
                    sb4.append(j);
                    sb4.append(" not supported");
                    throw new zzhl(sb4.toString());
                }
                return;
            case 20529:
                if (j != 0) {
                    StringBuilder sb5 = new StringBuilder(55);
                    sb5.append("ContentEncodingOrder ");
                    sb5.append(j);
                    sb5.append(" not supported");
                    throw new zzhl(sb5.toString());
                }
                return;
            case 20530:
                if (j != 1) {
                    StringBuilder sb6 = new StringBuilder(55);
                    sb6.append("ContentEncodingScope ");
                    sb6.append(j);
                    sb6.append(" not supported");
                    throw new zzhl(sb6.toString());
                }
                return;
            case 20531:
                if (j != 1) {
                    StringBuilder sb7 = new StringBuilder(54);
                    sb7.append("ContentEncodingType ");
                    sb7.append(j);
                    sb7.append(" not supported");
                    throw new zzhl(sb7.toString());
                }
                return;
            case 21420:
                this.zzaoa = j + this.zzans;
                return;
            case 22186:
                this.zzanv.zzaow = j;
                return;
            case 22203:
                this.zzanv.zzaox = j;
                return;
            case 2807729:
                this.zzanu = j;
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, double d) {
        if (i == 181) {
            this.zzanv.zzafv = (int) d;
        } else if (i == 17545) {
            this.zzack = zzdw((long) d);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, String str) throws zzhl {
        if (i == 134) {
            this.zzanv.zzaor = str;
        } else if (i == 17026 && !"webm".equals(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new zzhl(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0157  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(int r17, int r18, com.google.android.gms.internal.ads.zzie r19) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = 161(0xa1, float:2.26E-43)
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 4
            r7 = 0
            if (r1 == r4) goto L_0x0071
            if (r1 == r5) goto L_0x0071
            r4 = 18402(0x47e2, float:2.5787E-41)
            if (r1 == r4) goto L_0x0063
            r4 = 21419(0x53ab, float:3.0014E-41)
            if (r1 == r4) goto L_0x0045
            r4 = 25506(0x63a2, float:3.5742E-41)
            if (r1 != r4) goto L_0x002c
            com.google.android.gms.internal.ads.zzjj r1 = r0.zzanv
            byte[] r4 = new byte[r2]
            r1.zzaov = r4
            com.google.android.gms.internal.ads.zzjj r1 = r0.zzanv
            byte[] r1 = r1.zzaov
            r3.readFully(r1, r7, r2)
            return
        L_0x002c:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 26
            r3.<init>(r4)
            java.lang.String r4 = "Unexpected id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x0045:
            com.google.android.gms.internal.ads.zzkm r1 = r0.zzanr
            byte[] r1 = r1.data
            java.util.Arrays.fill(r1, r7)
            com.google.android.gms.internal.ads.zzkm r1 = r0.zzanr
            byte[] r1 = r1.data
            int r6 = r6 - r2
            r3.readFully(r1, r6, r2)
            com.google.android.gms.internal.ads.zzkm r1 = r0.zzanr
            r1.setPosition(r7)
            com.google.android.gms.internal.ads.zzkm r1 = r0.zzanr
            long r1 = r1.zzge()
            int r1 = (int) r1
            r0.zzanz = r1
            return
        L_0x0063:
            com.google.android.gms.internal.ads.zzjj r1 = r0.zzanv
            byte[] r4 = new byte[r2]
            r1.zzajy = r4
            com.google.android.gms.internal.ads.zzjj r1 = r0.zzanv
            byte[] r1 = r1.zzajy
            r3.readFully(r1, r7, r2)
            return
        L_0x0071:
            int r4 = r0.zzaok
            r8 = 1
            if (r4 != 0) goto L_0x0089
            com.google.android.gms.internal.ads.zzjf r4 = r0.zzanh
            long r9 = r4.zza(r3, r7, r8)
            int r4 = (int) r9
            r0.zzaol = r4
            com.google.android.gms.internal.ads.zzjf r4 = r0.zzanh
            int r4 = r4.zzfw()
            r0.zzaoj = r4
            r0.zzaok = r8
        L_0x0089:
            com.google.android.gms.internal.ads.zzjj r4 = r0.zzanw
            if (r4 == 0) goto L_0x00a1
            com.google.android.gms.internal.ads.zzjj r4 = r0.zzanx
            if (r4 == 0) goto L_0x00a1
            com.google.android.gms.internal.ads.zzjj r4 = r0.zzanw
            int r4 = r4.number
            int r9 = r0.zzaol
            if (r4 == r9) goto L_0x00a1
            com.google.android.gms.internal.ads.zzjj r4 = r0.zzanx
            int r4 = r4.number
            int r9 = r0.zzaol
            if (r4 != r9) goto L_0x00c1
        L_0x00a1:
            com.google.android.gms.internal.ads.zzjj r4 = r0.zzanw
            if (r4 == 0) goto L_0x00b1
            com.google.android.gms.internal.ads.zzjj r4 = r0.zzanx
            if (r4 != 0) goto L_0x00b1
            com.google.android.gms.internal.ads.zzjj r4 = r0.zzanw
            int r4 = r4.number
            int r9 = r0.zzaol
            if (r4 != r9) goto L_0x00c1
        L_0x00b1:
            com.google.android.gms.internal.ads.zzjj r4 = r0.zzanw
            if (r4 != 0) goto L_0x00cb
            com.google.android.gms.internal.ads.zzjj r4 = r0.zzanx
            if (r4 == 0) goto L_0x00cb
            com.google.android.gms.internal.ads.zzjj r4 = r0.zzanx
            int r4 = r4.number
            int r9 = r0.zzaol
            if (r4 == r9) goto L_0x00cb
        L_0x00c1:
            int r1 = r0.zzaoj
            int r1 = r2 - r1
            r3.zzr(r1)
            r0.zzaok = r7
            return
        L_0x00cb:
            com.google.android.gms.internal.ads.zzjj r4 = r0.zzanw
            if (r4 == 0) goto L_0x00da
            int r4 = r0.zzaol
            com.google.android.gms.internal.ads.zzjj r9 = r0.zzanw
            int r9 = r9.number
            if (r4 != r9) goto L_0x00da
            com.google.android.gms.internal.ads.zzjj r4 = r0.zzanw
            goto L_0x00dc
        L_0x00da:
            com.google.android.gms.internal.ads.zzjj r4 = r0.zzanx
        L_0x00dc:
            com.google.android.gms.internal.ads.zzip r9 = r4.zzamx
            int r10 = r0.zzaok
            if (r10 != r8) goto L_0x0189
            com.google.android.gms.internal.ads.zzkm r10 = r0.zzanp
            byte[] r10 = r10.data
            boolean r11 = r4.zzaos
            r12 = 3
            if (r11 == 0) goto L_0x00ed
            r11 = 4
            goto L_0x00ee
        L_0x00ed:
            r11 = 3
        L_0x00ee:
            r3.readFully(r10, r7, r11)
            int r13 = r0.zzaoj
            int r13 = r13 + r11
            r0.zzaoj = r13
            byte r11 = r10[r7]
            r13 = 8
            int r11 = r11 << r13
            byte r14 = r10[r8]
            r14 = r14 & 255(0xff, float:3.57E-43)
            r11 = r11 | r14
            long r14 = r0.zzaof
            long r6 = (long) r11
            long r6 = r0.zzdw(r6)
            long r14 = r14 + r6
            r0.zzaon = r14
            r7 = 2
            byte r6 = r10[r7]
            r6 = r6 & 6
            int r6 = r6 >> r8
            if (r6 != 0) goto L_0x0170
            byte r6 = r10[r7]
            r6 = r6 & r13
            if (r6 != r13) goto L_0x0119
            r6 = 1
            goto L_0x011a
        L_0x0119:
            r6 = 0
        L_0x011a:
            r11 = 128(0x80, float:1.794E-43)
            if (r1 != r5) goto L_0x0125
            byte r14 = r10[r7]
            r14 = r14 & r11
            if (r14 != r11) goto L_0x0125
            r14 = 1
            goto L_0x0126
        L_0x0125:
            r14 = 0
        L_0x0126:
            boolean r15 = r4.zzaos
            if (r15 == 0) goto L_0x0136
            byte r15 = r10[r12]
            r15 = r15 & r11
            if (r15 == r11) goto L_0x0138
            byte r10 = r10[r12]
            r10 = r10 & r8
            if (r10 != r8) goto L_0x0136
            r10 = 1
            goto L_0x0140
        L_0x0136:
            r10 = 0
            goto L_0x0140
        L_0x0138:
            com.google.android.gms.internal.ads.zzhl r1 = new com.google.android.gms.internal.ads.zzhl
            java.lang.String r2 = "Extension bit is set in signal byte"
            r1.<init>(r2)
            throw r1
        L_0x0140:
            if (r6 == 0) goto L_0x0145
            r6 = 134217728(0x8000000, float:3.85186E-34)
            goto L_0x0146
        L_0x0145:
            r6 = 0
        L_0x0146:
            r6 = r6 | r14
            if (r10 == 0) goto L_0x014b
            r11 = 2
            goto L_0x014c
        L_0x014b:
            r11 = 0
        L_0x014c:
            r6 = r6 | r11
            r0.zzaom = r6
            int r6 = r0.zzaoj
            int r6 = r2 - r6
            r0.zzamq = r6
            if (r10 == 0) goto L_0x016d
            com.google.android.gms.internal.ads.zzkm r6 = r0.zzanp
            byte[] r6 = r6.data
            r10 = 0
            r6[r10] = r13
            com.google.android.gms.internal.ads.zzkm r6 = r0.zzanp
            r6.setPosition(r10)
            com.google.android.gms.internal.ads.zzkm r6 = r0.zzanp
            r9.zza((com.google.android.gms.internal.ads.zzkm) r6, (int) r8)
            int r6 = r0.zzamq
            int r6 = r6 + r8
            r0.zzamq = r6
        L_0x016d:
            r0.zzaok = r7
            goto L_0x0189
        L_0x0170:
            com.google.android.gms.internal.ads.zzhl r1 = new com.google.android.gms.internal.ads.zzhl
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 38
            r2.<init>(r3)
            java.lang.String r3 = "Lacing mode not supported: "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0189:
            int r6 = r0.zzaoj
            if (r6 >= r2) goto L_0x019b
            int r6 = r0.zzaoj
            int r7 = r0.zzaoj
            int r7 = r2 - r7
            int r7 = r9.zza((com.google.android.gms.internal.ads.zzie) r3, (int) r7)
            int r6 = r6 + r7
            r0.zzaoj = r6
            goto L_0x0189
        L_0x019b:
            java.lang.String r2 = "A_VORBIS"
            java.lang.String r3 = r4.zzaor
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x01b6
            com.google.android.gms.internal.ads.zzkm r2 = r0.zzanq
            r3 = 0
            r2.setPosition(r3)
            com.google.android.gms.internal.ads.zzkm r2 = r0.zzanq
            r3 = 4
            r9.zza((com.google.android.gms.internal.ads.zzkm) r2, (int) r3)
            int r2 = r0.zzamq
            int r2 = r2 + r3
            r0.zzamq = r2
        L_0x01b6:
            if (r1 != r5) goto L_0x01bb
            r0.zza((com.google.android.gms.internal.ads.zzip) r9)
        L_0x01bb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjg.zza(int, int, com.google.android.gms.internal.ads.zzie):void");
    }

    private final void zza(zzip zzip) {
        zzip.zza(this.zzaon, this.zzaom, this.zzamq, 0, (byte[]) null);
        this.zzaok = 0;
        this.zzaoo = true;
    }

    private final ArrayList<byte[]> zzfx() throws zzhl {
        try {
            byte[] bArr = this.zzanw.zzaov;
            if (bArr[0] == 2) {
                int i = 1;
                int i2 = 0;
                while (bArr[i] == -1) {
                    i2 += 255;
                    i++;
                }
                int i3 = i + 1;
                int i4 = i2 + bArr[i];
                int i5 = 0;
                while (bArr[i3] == -1) {
                    i5 += 255;
                    i3++;
                }
                int i6 = i3 + 1;
                int i7 = i5 + bArr[i3];
                if (bArr[i6] == 1) {
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, i6, bArr2, 0, i4);
                    int i8 = i6 + i4;
                    if (bArr[i8] == 3) {
                        int i9 = i8 + i7;
                        if (bArr[i9] == 5) {
                            byte[] bArr3 = new byte[(bArr.length - i9)];
                            System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
                            ArrayList<byte[]> arrayList = new ArrayList<>(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw new zzhl("Error parsing vorbis codec private");
                    }
                    throw new zzhl("Error parsing vorbis codec private");
                }
                throw new zzhl("Error parsing vorbis codec private");
            }
            throw new zzhl("Error parsing vorbis codec private");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhl("Error parsing vorbis codec private");
        }
    }

    private final long zzdw(long j) {
        return TimeUnit.NANOSECONDS.toMicros(j * this.zzanu);
    }

    private static boolean zzat(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str);
    }
}
