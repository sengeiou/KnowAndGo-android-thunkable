package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.C1470C;
import com.google.android.exoplayer2.extractor.p012ts.TsExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.internal.ads.zzne;
import com.google.firebase.FirebaseError;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

public final class zzod implements zznn {
    private static final zznq zzazt = new zzoe();
    private static final byte[] zzazu = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzazv = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    /* access modifiers changed from: private */
    public static final UUID zzazw = new UUID(72057594037932032L, -9223371306706625679L);
    private long zzack;
    private int zzamr;
    private int zzams;
    private long zzans;
    private long zzant;
    private long zzanu;
    private int zzanz;
    private long zzaoa;
    private boolean zzaob;
    private long zzaoc;
    private long zzaod;
    private long zzaof;
    private boolean zzaoi;
    private boolean zzaoo;
    private boolean zzaop;
    private final zzoi zzazr;
    private final zzob zzazx;
    private final SparseArray<zzog> zzazy;
    private final boolean zzazz;
    private final zzst zzbaa;
    private final zzst zzbab;
    private final zzst zzbac;
    private final zzst zzbad;
    private final zzst zzbae;
    private final zzst zzbaf;
    private final zzst zzbag;
    private final zzst zzbah;
    private final zzst zzbai;
    private ByteBuffer zzbaj;
    private long zzbak;
    private zzog zzbal;
    private boolean zzbam;
    private zzsn zzban;
    private zzsn zzbao;
    private int zzbap;
    private long zzbaq;
    private long zzbar;
    private int zzbas;
    private int zzbat;
    private int[] zzbau;
    private int zzbav;
    private int zzbaw;
    private int zzbax;
    private int zzbay;
    private boolean zzbaz;
    private boolean zzbba;
    private boolean zzbbb;
    private boolean zzbbc;
    private byte zzbbd;
    private int zzbbe;
    private zznp zzbbf;

    public zzod() {
        this(0);
    }

    static boolean zzav(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    static int zzx(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case JfifUtil.MARKER_RST7:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO:
            case FirebaseError.ERROR_WEAK_PASSWORD /*17026*/:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case JfifUtil.MARKER_APP1:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    public final void release() {
    }

    private zzod(int i) {
        this(new zzny(), 0);
    }

    private zzod(zzob zzob, int i) {
        this.zzans = -1;
        this.zzanu = C1470C.TIME_UNSET;
        this.zzbak = C1470C.TIME_UNSET;
        this.zzack = C1470C.TIME_UNSET;
        this.zzaoc = -1;
        this.zzaod = -1;
        this.zzaof = C1470C.TIME_UNSET;
        this.zzazx = zzob;
        this.zzazx.zza(new zzof(this, (zzoe) null));
        this.zzazz = true;
        this.zzazr = new zzoi();
        this.zzazy = new SparseArray<>();
        this.zzbac = new zzst(4);
        this.zzbad = new zzst(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzbae = new zzst(4);
        this.zzbaa = new zzst(zzsq.zzaqt);
        this.zzbab = new zzst(4);
        this.zzbaf = new zzst();
        this.zzbag = new zzst();
        this.zzbah = new zzst(8);
        this.zzbai = new zzst();
    }

    public final boolean zza(zzno zzno) throws IOException, InterruptedException {
        return new zzoh().zza(zzno);
    }

    public final void zza(zznp zznp) {
        this.zzbbf = zznp;
    }

    public final void zzd(long j, long j2) {
        this.zzaof = C1470C.TIME_UNSET;
        this.zzbap = 0;
        this.zzazx.reset();
        this.zzazr.reset();
        zzij();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0005 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzno r8, com.google.android.gms.internal.ads.zznt r9) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r7 = this;
            r0 = 0
            r7.zzaoo = r0
            r1 = 1
            r2 = 1
        L_0x0005:
            if (r2 == 0) goto L_0x003c
            boolean r3 = r7.zzaoo
            if (r3 != 0) goto L_0x003c
            com.google.android.gms.internal.ads.zzob r2 = r7.zzazx
            boolean r2 = r2.zzb(r8)
            if (r2 == 0) goto L_0x0005
            long r3 = r8.getPosition()
            boolean r5 = r7.zzaob
            if (r5 == 0) goto L_0x0025
            r7.zzaod = r3
            long r3 = r7.zzaoc
            r9.zzahv = r3
            r7.zzaob = r0
        L_0x0023:
            r3 = 1
            goto L_0x0039
        L_0x0025:
            boolean r3 = r7.zzbam
            if (r3 == 0) goto L_0x0038
            long r3 = r7.zzaod
            r5 = -1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0038
            long r3 = r7.zzaod
            r9.zzahv = r3
            r7.zzaod = r5
            goto L_0x0023
        L_0x0038:
            r3 = 0
        L_0x0039:
            if (r3 == 0) goto L_0x0005
            return r1
        L_0x003c:
            if (r2 == 0) goto L_0x003f
            return r0
        L_0x003f:
            r8 = -1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzod.zza(com.google.android.gms.internal.ads.zzno, com.google.android.gms.internal.ads.zznt):int");
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i, long j, long j2) throws zzlm {
        if (i == 160) {
            this.zzaop = false;
        } else if (i == 174) {
            this.zzbal = new zzog((zzoe) null);
        } else if (i == 187) {
            this.zzaoi = false;
        } else if (i == 19899) {
            this.zzanz = -1;
            this.zzaoa = -1;
        } else if (i == 20533) {
            this.zzbal.zzaos = true;
        } else if (i == 21968) {
            this.zzbal.zzbbn = true;
        } else if (i == 25152) {
        } else {
            if (i != 408125543) {
                if (i == 475249515) {
                    this.zzban = new zzsn();
                    this.zzbao = new zzsn();
                } else if (i != 524531317 || this.zzbam) {
                } else {
                    if (!this.zzazz || this.zzaoc == -1) {
                        this.zzbbf.zza(new zznv(this.zzack));
                        this.zzbam = true;
                        return;
                    }
                    this.zzaob = true;
                }
            } else if (this.zzans == -1 || this.zzans == j) {
                this.zzans = j;
                this.zzant = j2;
            } else {
                throw new zzlm("Multiple Segment elements not supported");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzy(int i) throws zzlm {
        zznu zznu;
        int i2;
        int i3 = 0;
        if (i != 160) {
            if (i == 174) {
                String str = this.zzbal.zzaor;
                if ("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) {
                    i3 = 1;
                }
                if (i3 != 0) {
                    this.zzbal.zza(this.zzbbf, this.zzbal.number);
                    this.zzazy.put(this.zzbal.number, this.zzbal);
                }
                this.zzbal = null;
            } else if (i != 19899) {
                if (i != 25152) {
                    if (i != 28032) {
                        if (i == 357149030) {
                            if (this.zzanu == C1470C.TIME_UNSET) {
                                this.zzanu = 1000000;
                            }
                            if (this.zzbak != C1470C.TIME_UNSET) {
                                this.zzack = zzdw(this.zzbak);
                            }
                        } else if (i != 374648427) {
                            if (i == 475249515 && !this.zzbam) {
                                zznp zznp = this.zzbbf;
                                if (this.zzans == -1 || this.zzack == C1470C.TIME_UNSET || this.zzban == null || this.zzban.size() == 0 || this.zzbao == null || this.zzbao.size() != this.zzban.size()) {
                                    this.zzban = null;
                                    this.zzbao = null;
                                    zznu = new zznv(this.zzack);
                                } else {
                                    int size = this.zzban.size();
                                    int[] iArr = new int[size];
                                    long[] jArr = new long[size];
                                    long[] jArr2 = new long[size];
                                    long[] jArr3 = new long[size];
                                    for (int i4 = 0; i4 < size; i4++) {
                                        jArr3[i4] = this.zzban.get(i4);
                                        jArr[i4] = this.zzans + this.zzbao.get(i4);
                                    }
                                    while (true) {
                                        i2 = size - 1;
                                        if (i3 >= i2) {
                                            break;
                                        }
                                        int i5 = i3 + 1;
                                        iArr[i3] = (int) (jArr[i5] - jArr[i3]);
                                        jArr2[i3] = jArr3[i5] - jArr3[i3];
                                        i3 = i5;
                                    }
                                    iArr[i2] = (int) ((this.zzans + this.zzant) - jArr[i2]);
                                    jArr2[i2] = this.zzack - jArr3[i2];
                                    this.zzban = null;
                                    this.zzbao = null;
                                    zznu = new zznl(iArr, jArr, jArr2, jArr3);
                                }
                                zznp.zza(zznu);
                                this.zzbam = true;
                            }
                        } else if (this.zzazy.size() != 0) {
                            this.zzbbf.zzfi();
                        } else {
                            throw new zzlm("No valid tracks were found");
                        }
                    } else if (this.zzbal.zzaos && this.zzbal.zzbbi != null) {
                        throw new zzlm("Combining encryption and compression is not supported");
                    }
                } else if (!this.zzbal.zzaos) {
                } else {
                    if (this.zzbal.zzbbj != null) {
                        this.zzbal.zzatr = new zzne(new zzne.zza(zzkt.zzarg, MimeTypes.VIDEO_WEBM, this.zzbal.zzbbj.zzazq));
                        return;
                    }
                    throw new zzlm("Encrypted Track found but ContentEncKeyID was not found");
                }
            } else if (this.zzanz == -1 || this.zzaoa == -1) {
                throw new zzlm("Mandatory element SeekID or SeekPosition not found");
            } else if (this.zzanz == 475249515) {
                this.zzaoc = this.zzaoa;
            }
        } else if (this.zzbap == 2) {
            if (!this.zzaop) {
                this.zzbax |= 1;
            }
            zza(this.zzazy.get(this.zzbav), this.zzbaq);
            this.zzbap = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(int i, long j) throws zzlm {
        boolean z = false;
        switch (i) {
            case 131:
                this.zzbal.type = (int) j;
                return;
            case 136:
                zzog zzog = this.zzbal;
                if (j == 1) {
                    z = true;
                }
                zzog.zzbce = z;
                return;
            case 155:
                this.zzbar = zzdw(j);
                return;
            case 159:
                this.zzbal.zzafu = (int) j;
                return;
            case 176:
                this.zzbal.width = (int) j;
                return;
            case 179:
                this.zzban.add(zzdw(j));
                return;
            case 186:
                this.zzbal.height = (int) j;
                return;
            case JfifUtil.MARKER_RST7:
                this.zzbal.number = (int) j;
                return;
            case 231:
                this.zzaof = zzdw(j);
                return;
            case 241:
                if (!this.zzaoi) {
                    this.zzbao.add(j);
                    this.zzaoi = true;
                    return;
                }
                return;
            case 251:
                this.zzaop = true;
                return;
            case 16980:
                if (j != 3) {
                    StringBuilder sb = new StringBuilder(50);
                    sb.append("ContentCompAlgo ");
                    sb.append(j);
                    sb.append(" not supported");
                    throw new zzlm(sb.toString());
                }
                return;
            case 17029:
                if (j < 1 || j > 2) {
                    StringBuilder sb2 = new StringBuilder(53);
                    sb2.append("DocTypeReadVersion ");
                    sb2.append(j);
                    sb2.append(" not supported");
                    throw new zzlm(sb2.toString());
                }
                return;
            case 17143:
                if (j != 1) {
                    StringBuilder sb3 = new StringBuilder(50);
                    sb3.append("EBMLReadVersion ");
                    sb3.append(j);
                    sb3.append(" not supported");
                    throw new zzlm(sb3.toString());
                }
                return;
            case 18401:
                if (j != 5) {
                    StringBuilder sb4 = new StringBuilder(49);
                    sb4.append("ContentEncAlgo ");
                    sb4.append(j);
                    sb4.append(" not supported");
                    throw new zzlm(sb4.toString());
                }
                return;
            case 18408:
                if (j != 1) {
                    StringBuilder sb5 = new StringBuilder(56);
                    sb5.append("AESSettingsCipherMode ");
                    sb5.append(j);
                    sb5.append(" not supported");
                    throw new zzlm(sb5.toString());
                }
                return;
            case 20529:
                if (j != 0) {
                    StringBuilder sb6 = new StringBuilder(55);
                    sb6.append("ContentEncodingOrder ");
                    sb6.append(j);
                    sb6.append(" not supported");
                    throw new zzlm(sb6.toString());
                }
                return;
            case 20530:
                if (j != 1) {
                    StringBuilder sb7 = new StringBuilder(55);
                    sb7.append("ContentEncodingScope ");
                    sb7.append(j);
                    sb7.append(" not supported");
                    throw new zzlm(sb7.toString());
                }
                return;
            case 21420:
                this.zzaoa = j + this.zzans;
                return;
            case 21432:
                int i2 = (int) j;
                if (i2 == 3) {
                    this.zzbal.zzatu = 1;
                    return;
                } else if (i2 != 15) {
                    switch (i2) {
                        case 0:
                            this.zzbal.zzatu = 0;
                            return;
                        case 1:
                            this.zzbal.zzatu = 2;
                            return;
                        default:
                            return;
                    }
                } else {
                    this.zzbal.zzatu = 3;
                    return;
                }
            case 21680:
                this.zzbal.zzbbk = (int) j;
                return;
            case 21682:
                this.zzbal.zzbbm = (int) j;
                return;
            case 21690:
                this.zzbal.zzbbl = (int) j;
                return;
            case 21930:
                zzog zzog2 = this.zzbal;
                if (j == 1) {
                    z = true;
                }
                zzog2.zzbcf = z;
                return;
            case 21945:
                switch ((int) j) {
                    case 1:
                        this.zzbal.zzbbq = 2;
                        return;
                    case 2:
                        this.zzbal.zzbbq = 1;
                        return;
                    default:
                        return;
                }
            case 21946:
                int i3 = (int) j;
                if (i3 != 1) {
                    if (i3 == 16) {
                        this.zzbal.zzbbp = 6;
                        return;
                    } else if (i3 != 18) {
                        switch (i3) {
                            case 6:
                            case 7:
                                break;
                            default:
                                return;
                        }
                    } else {
                        this.zzbal.zzbbp = 7;
                        return;
                    }
                }
                this.zzbal.zzbbp = 3;
                return;
            case 21947:
                this.zzbal.zzbbn = true;
                int i4 = (int) j;
                if (i4 == 1) {
                    this.zzbal.zzbbo = 1;
                    return;
                } else if (i4 != 9) {
                    switch (i4) {
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            this.zzbal.zzbbo = 2;
                            return;
                        default:
                            return;
                    }
                } else {
                    this.zzbal.zzbbo = 6;
                    return;
                }
            case 21948:
                this.zzbal.zzbbr = (int) j;
                return;
            case 21949:
                this.zzbal.zzbbs = (int) j;
                return;
            case 22186:
                this.zzbal.zzaow = j;
                return;
            case 22203:
                this.zzbal.zzaox = j;
                return;
            case 25188:
                this.zzbal.zzbcd = (int) j;
                return;
            case 2352003:
                this.zzbal.zzbbh = (int) j;
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
            this.zzbal.zzafv = (int) d;
        } else if (i != 17545) {
            switch (i) {
                case 21969:
                    this.zzbal.zzbbt = (float) d;
                    return;
                case 21970:
                    this.zzbal.zzbbu = (float) d;
                    return;
                case 21971:
                    this.zzbal.zzbbv = (float) d;
                    return;
                case 21972:
                    this.zzbal.zzbbw = (float) d;
                    return;
                case 21973:
                    this.zzbal.zzbbx = (float) d;
                    return;
                case 21974:
                    this.zzbal.zzbby = (float) d;
                    return;
                case 21975:
                    this.zzbal.zzbbz = (float) d;
                    return;
                case 21976:
                    this.zzbal.zzbca = (float) d;
                    return;
                case 21977:
                    this.zzbal.zzbcb = (float) d;
                    return;
                case 21978:
                    this.zzbal.zzbcc = (float) d;
                    return;
                default:
                    return;
            }
        } else {
            this.zzbak = (long) d;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, String str) throws zzlm {
        if (i == 134) {
            this.zzbal.zzaor = str;
        } else if (i != 17026) {
            if (i == 2274716) {
                String unused = this.zzbal.zzauc = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new zzlm(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, int i2, zzno zzno) throws IOException, InterruptedException {
        long j;
        byte b;
        int i3 = i;
        int i4 = i2;
        zzno zzno2 = zzno;
        int i5 = 0;
        int i6 = 1;
        if (i3 == 161 || i3 == 163) {
            int i7 = 8;
            if (this.zzbap == 0) {
                this.zzbav = (int) this.zzazr.zza(zzno2, false, true, 8);
                this.zzbaw = this.zzazr.zzfw();
                this.zzbar = C1470C.TIME_UNSET;
                this.zzbap = 1;
                this.zzbac.reset();
            }
            zzog zzog = this.zzazy.get(this.zzbav);
            if (zzog == null) {
                zzno2.zzr(i4 - this.zzbaw);
                this.zzbap = 0;
                return;
            }
            if (this.zzbap == 1) {
                zzb(zzno2, 3);
                int i8 = (this.zzbac.data[2] & 6) >> 1;
                if (i8 == 0) {
                    this.zzbat = 1;
                    this.zzbau = zza(this.zzbau, 1);
                    this.zzbau[0] = (i4 - this.zzbaw) - 3;
                } else if (i3 == 163) {
                    zzb(zzno2, 4);
                    this.zzbat = (this.zzbac.data[3] & UByte.MAX_VALUE) + 1;
                    this.zzbau = zza(this.zzbau, this.zzbat);
                    if (i8 == 2) {
                        Arrays.fill(this.zzbau, 0, this.zzbat, ((i4 - this.zzbaw) - 4) / this.zzbat);
                    } else if (i8 == 1) {
                        int i9 = 4;
                        int i10 = 0;
                        for (int i11 = 0; i11 < this.zzbat - 1; i11++) {
                            this.zzbau[i11] = 0;
                            do {
                                i9++;
                                zzb(zzno2, i9);
                                b = this.zzbac.data[i9 - 1] & UByte.MAX_VALUE;
                                int[] iArr = this.zzbau;
                                iArr[i11] = iArr[i11] + b;
                            } while (b == 255);
                            i10 += this.zzbau[i11];
                        }
                        this.zzbau[this.zzbat - 1] = ((i4 - this.zzbaw) - i9) - i10;
                    } else if (i8 == 3) {
                        int i12 = 0;
                        int i13 = 4;
                        int i14 = 0;
                        while (i12 < this.zzbat - i6) {
                            this.zzbau[i12] = i5;
                            i13++;
                            zzb(zzno2, i13);
                            int i15 = i13 - 1;
                            if (this.zzbac.data[i15] != 0) {
                                int i16 = 0;
                                while (true) {
                                    if (i16 >= i7) {
                                        j = 0;
                                        break;
                                    }
                                    int i17 = i6 << (7 - i16);
                                    if ((this.zzbac.data[i15] & i17) != 0) {
                                        int i18 = i13 + i16;
                                        zzb(zzno2, i18);
                                        long j2 = (long) ((~i17) & this.zzbac.data[i15] & UByte.MAX_VALUE);
                                        int i19 = i15 + 1;
                                        long j3 = j2;
                                        while (i19 < i18) {
                                            j3 = (j3 << i7) | ((long) (this.zzbac.data[i19] & UByte.MAX_VALUE));
                                            i19++;
                                            i18 = i18;
                                            i7 = 8;
                                        }
                                        int i20 = i18;
                                        if (i12 > 0) {
                                            j3 -= (1 << ((i16 * 7) + 6)) - 1;
                                        }
                                        j = j3;
                                        i13 = i20;
                                    } else {
                                        i16++;
                                        i6 = 1;
                                        i7 = 8;
                                    }
                                }
                                if (j < -2147483648L || j > 2147483647L) {
                                    throw new zzlm("EBML lacing sample size out of range.");
                                }
                                int i21 = (int) j;
                                int[] iArr2 = this.zzbau;
                                if (i12 != 0) {
                                    i21 += this.zzbau[i12 - 1];
                                }
                                iArr2[i12] = i21;
                                i14 += this.zzbau[i12];
                                i12++;
                                i5 = 0;
                                i6 = 1;
                                i7 = 8;
                            } else {
                                throw new zzlm("No valid varint length mask found");
                            }
                        }
                        this.zzbau[this.zzbat - 1] = ((i4 - this.zzbaw) - i13) - i14;
                    } else {
                        StringBuilder sb = new StringBuilder(36);
                        sb.append("Unexpected lacing value: ");
                        sb.append(i8);
                        throw new zzlm(sb.toString());
                    }
                } else {
                    throw new zzlm("Lacing only supported in SimpleBlocks.");
                }
                this.zzbaq = this.zzaof + zzdw((long) ((this.zzbac.data[0] << 8) | (this.zzbac.data[1] & UByte.MAX_VALUE)));
                this.zzbax = ((zzog.type == 2 || (i3 == 163 && (this.zzbac.data[2] & ByteCompanionObject.MIN_VALUE) == 128)) ? 1 : 0) | ((this.zzbac.data[2] & 8) == 8 ? Integer.MIN_VALUE : 0);
                this.zzbap = 2;
                this.zzbas = 0;
            }
            if (i3 == 163) {
                while (this.zzbas < this.zzbat) {
                    zza(zzno2, zzog, this.zzbau[this.zzbas]);
                    zza(zzog, this.zzbaq + ((long) ((this.zzbas * zzog.zzbbh) / 1000)));
                    this.zzbas++;
                }
                this.zzbap = 0;
                return;
            }
            zza(zzno2, zzog, this.zzbau[0]);
        } else if (i3 == 16981) {
            this.zzbal.zzbbi = new byte[i4];
            zzno2.readFully(this.zzbal.zzbbi, 0, i4);
        } else if (i3 == 18402) {
            byte[] bArr = new byte[i4];
            zzno2.readFully(bArr, 0, i4);
            this.zzbal.zzbbj = new zznx(1, bArr);
        } else if (i3 == 21419) {
            Arrays.fill(this.zzbae.data, (byte) 0);
            zzno2.readFully(this.zzbae.data, 4 - i4, i4);
            this.zzbae.setPosition(0);
            this.zzanz = (int) this.zzbae.zzge();
        } else if (i3 == 25506) {
            this.zzbal.zzaov = new byte[i4];
            zzno2.readFully(this.zzbal.zzaov, 0, i4);
        } else if (i3 == 30322) {
            this.zzbal.zzatv = new byte[i4];
            zzno2.readFully(this.zzbal.zzatv, 0, i4);
        } else {
            StringBuilder sb2 = new StringBuilder(26);
            sb2.append("Unexpected id: ");
            sb2.append(i3);
            throw new zzlm(sb2.toString());
        }
    }

    private final void zza(zzog zzog, long j) {
        byte[] bArr;
        if ("S_TEXT/UTF8".equals(zzog.zzaor)) {
            byte[] bArr2 = this.zzbag.data;
            long j2 = this.zzbar;
            if (j2 == C1470C.TIME_UNSET) {
                bArr = zzazv;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (((long) i) * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - ((long) (60000000 * i2));
                int i3 = (int) (j4 / 1000000);
                bArr = zzsy.zzbh(String.format(Locale.US, "%02d:%02d:%02d,%03d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - ((long) (1000000 * i3))) / 1000))}));
            }
            System.arraycopy(bArr, 0, bArr2, 19, 12);
            zzog.zzbcg.zza(this.zzbag, this.zzbag.limit());
            this.zzamr += this.zzbag.limit();
        }
        zzog.zzbcg.zza(j, this.zzbax, this.zzamr, 0, zzog.zzbbj);
        this.zzaoo = true;
        zzij();
    }

    private final void zzij() {
        this.zzbay = 0;
        this.zzamr = 0;
        this.zzams = 0;
        this.zzbaz = false;
        this.zzbba = false;
        this.zzbbc = false;
        this.zzbbe = 0;
        this.zzbbd = 0;
        this.zzbbb = false;
        this.zzbaf.reset();
    }

    private final void zzb(zzno zzno, int i) throws IOException, InterruptedException {
        if (this.zzbac.limit() < i) {
            if (this.zzbac.capacity() < i) {
                this.zzbac.zzb(Arrays.copyOf(this.zzbac.data, Math.max(this.zzbac.data.length << 1, i)), this.zzbac.limit());
            }
            zzno.readFully(this.zzbac.data, this.zzbac.limit(), i - this.zzbac.limit());
            this.zzbac.zzbo(i);
        }
    }

    private final void zza(zzno zzno, zzog zzog, int i) throws IOException, InterruptedException {
        if ("S_TEXT/UTF8".equals(zzog.zzaor)) {
            int length = zzazu.length + i;
            if (this.zzbag.capacity() < length) {
                this.zzbag.data = Arrays.copyOf(zzazu, length + i);
            }
            zzno.readFully(this.zzbag.data, zzazu.length, i);
            this.zzbag.setPosition(0);
            this.zzbag.zzbo(length);
            return;
        }
        zznw zznw = zzog.zzbcg;
        if (!this.zzbaz) {
            if (zzog.zzaos) {
                this.zzbax &= -1073741825;
                int i2 = 128;
                if (!this.zzbba) {
                    zzno.readFully(this.zzbac.data, 0, 1);
                    this.zzbay++;
                    if ((this.zzbac.data[0] & ByteCompanionObject.MIN_VALUE) != 128) {
                        this.zzbbd = this.zzbac.data[0];
                        this.zzbba = true;
                    } else {
                        throw new zzlm("Extension bit is set in signal byte");
                    }
                }
                if ((this.zzbbd & 1) == 1) {
                    boolean z = (this.zzbbd & 2) == 2;
                    this.zzbax |= 1073741824;
                    if (!this.zzbbb) {
                        zzno.readFully(this.zzbah.data, 0, 8);
                        this.zzbay += 8;
                        this.zzbbb = true;
                        byte[] bArr = this.zzbac.data;
                        if (!z) {
                            i2 = 0;
                        }
                        bArr[0] = (byte) (i2 | 8);
                        this.zzbac.setPosition(0);
                        zznw.zza(this.zzbac, 1);
                        this.zzamr++;
                        this.zzbah.setPosition(0);
                        zznw.zza(this.zzbah, 8);
                        this.zzamr += 8;
                    }
                    if (z) {
                        if (!this.zzbbc) {
                            zzno.readFully(this.zzbac.data, 0, 1);
                            this.zzbay++;
                            this.zzbac.setPosition(0);
                            this.zzbbe = this.zzbac.readUnsignedByte();
                            this.zzbbc = true;
                        }
                        int i3 = this.zzbbe << 2;
                        this.zzbac.reset(i3);
                        zzno.readFully(this.zzbac.data, 0, i3);
                        this.zzbay += i3;
                        short s = (short) ((this.zzbbe / 2) + 1);
                        int i4 = (s * 6) + 2;
                        if (this.zzbaj == null || this.zzbaj.capacity() < i4) {
                            this.zzbaj = ByteBuffer.allocate(i4);
                        }
                        this.zzbaj.position(0);
                        this.zzbaj.putShort(s);
                        int i5 = 0;
                        int i6 = 0;
                        while (i5 < this.zzbbe) {
                            int zzgg = this.zzbac.zzgg();
                            if (i5 % 2 == 0) {
                                this.zzbaj.putShort((short) (zzgg - i6));
                            } else {
                                this.zzbaj.putInt(zzgg - i6);
                            }
                            i5++;
                            i6 = zzgg;
                        }
                        int i7 = (i - this.zzbay) - i6;
                        if (this.zzbbe % 2 == 1) {
                            this.zzbaj.putInt(i7);
                        } else {
                            this.zzbaj.putShort((short) i7);
                            this.zzbaj.putInt(0);
                        }
                        this.zzbai.zzb(this.zzbaj.array(), i4);
                        zznw.zza(this.zzbai, i4);
                        this.zzamr += i4;
                    }
                }
            } else if (zzog.zzbbi != null) {
                this.zzbaf.zzb(zzog.zzbbi, zzog.zzbbi.length);
            }
            this.zzbaz = true;
        }
        int limit = i + this.zzbaf.limit();
        if ("V_MPEG4/ISO/AVC".equals(zzog.zzaor) || "V_MPEGH/ISO/HEVC".equals(zzog.zzaor)) {
            byte[] bArr2 = this.zzbab.data;
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[2] = 0;
            int i8 = zzog.zzamf;
            int i9 = 4 - zzog.zzamf;
            while (this.zzbay < limit) {
                if (this.zzams == 0) {
                    int min = Math.min(i8, this.zzbaf.zzjz());
                    zzno.readFully(bArr2, i9 + min, i8 - min);
                    if (min > 0) {
                        this.zzbaf.zzb(bArr2, i9, min);
                    }
                    this.zzbay += i8;
                    this.zzbab.setPosition(0);
                    this.zzams = this.zzbab.zzgg();
                    this.zzbaa.setPosition(0);
                    zznw.zza(this.zzbaa, 4);
                    this.zzamr += 4;
                } else {
                    this.zzams -= zza(zzno, zznw, this.zzams);
                }
            }
        } else {
            while (this.zzbay < limit) {
                zza(zzno, zznw, limit - this.zzbay);
            }
        }
        if ("A_VORBIS".equals(zzog.zzaor)) {
            this.zzbad.setPosition(0);
            zznw.zza(this.zzbad, 4);
            this.zzamr += 4;
        }
    }

    private final int zza(zzno zzno, zznw zznw, int i) throws IOException, InterruptedException {
        int i2;
        int zzjz = this.zzbaf.zzjz();
        if (zzjz > 0) {
            i2 = Math.min(i, zzjz);
            zznw.zza(this.zzbaf, i2);
        } else {
            i2 = zznw.zza(zzno, i, false);
        }
        this.zzbay += i2;
        this.zzamr += i2;
        return i2;
    }

    private final long zzdw(long j) throws zzlm {
        if (this.zzanu != C1470C.TIME_UNSET) {
            return zzsy.zza(j, this.zzanu, 1000);
        }
        throw new zzlm("Can't scale timecode prior to timecodeScale being set.");
    }

    private static int[] zza(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        if (iArr.length >= i) {
            return iArr;
        }
        return new int[Math.max(iArr.length << 1, i)];
    }
}
