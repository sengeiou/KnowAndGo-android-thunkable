package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.C1470C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.internal.ads.zzpo;
import java.util.ArrayList;
import java.util.List;

final class zzom {
    private static final int zzbdl = zzsy.zzay("meta");
    private static final int zzbeb = zzsy.zzay("vide");
    private static final int zzbec = zzsy.zzay("soun");
    private static final int zzbed = zzsy.zzay("text");
    private static final int zzbee = zzsy.zzay("sbtl");
    private static final int zzbef = zzsy.zzay("subt");
    private static final int zzbeg = zzsy.zzay("clcp");
    private static final int zzbeh = zzsy.zzay(C1470C.CENC_TYPE_cenc);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v72, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v24, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:356:0x0629  */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x0676  */
    /* JADX WARNING: Removed duplicated region for block: B:378:0x06c8  */
    /* JADX WARNING: Removed duplicated region for block: B:381:0x06d1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x06d2  */
    /* JADX WARNING: Removed duplicated region for block: B:390:0x0641 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzpa zza(com.google.android.gms.internal.ads.zzok r49, com.google.android.gms.internal.ads.zzol r50, long r51, com.google.android.gms.internal.ads.zzne r53, boolean r54) throws com.google.android.gms.internal.ads.zzlm {
        /*
            r0 = r49
            int r2 = com.google.android.gms.internal.ads.zzoj.zzakr
            com.google.android.gms.internal.ads.zzok r2 = r0.zzaz(r2)
            int r3 = com.google.android.gms.internal.ads.zzoj.zzala
            com.google.android.gms.internal.ads.zzol r3 = r2.zzay(r3)
            com.google.android.gms.internal.ads.zzst r3 = r3.zzbea
            r4 = 16
            r3.setPosition(r4)
            int r3 = r3.readInt()
            int r5 = zzbec
            r6 = 3
            r7 = 4
            r9 = -1
            if (r3 != r5) goto L_0x0022
            r13 = 1
            goto L_0x0042
        L_0x0022:
            int r5 = zzbeb
            if (r3 != r5) goto L_0x0028
            r13 = 2
            goto L_0x0042
        L_0x0028:
            int r5 = zzbed
            if (r3 == r5) goto L_0x0041
            int r5 = zzbee
            if (r3 == r5) goto L_0x0041
            int r5 = zzbef
            if (r3 == r5) goto L_0x0041
            int r5 = zzbeg
            if (r3 != r5) goto L_0x0039
            goto L_0x0041
        L_0x0039:
            int r5 = zzbdl
            if (r3 != r5) goto L_0x003f
            r13 = 4
            goto L_0x0042
        L_0x003f:
            r13 = -1
            goto L_0x0042
        L_0x0041:
            r13 = 3
        L_0x0042:
            r3 = 0
            if (r13 != r9) goto L_0x0046
            return r3
        L_0x0046:
            int r5 = com.google.android.gms.internal.ads.zzoj.zzaky
            com.google.android.gms.internal.ads.zzol r5 = r0.zzay(r5)
            com.google.android.gms.internal.ads.zzst r5 = r5.zzbea
            r11 = 8
            r5.setPosition(r11)
            int r12 = r5.readInt()
            int r12 = com.google.android.gms.internal.ads.zzoj.zzt(r12)
            if (r12 != 0) goto L_0x0060
            r14 = 8
            goto L_0x0062
        L_0x0060:
            r14 = 16
        L_0x0062:
            r5.zzac(r14)
            int r14 = r5.readInt()
            r5.zzac(r7)
            int r15 = r5.getPosition()
            if (r12 != 0) goto L_0x0074
            r8 = 4
            goto L_0x0076
        L_0x0074:
            r8 = 8
        L_0x0076:
            r10 = 0
        L_0x0077:
            if (r10 >= r8) goto L_0x0087
            byte[] r3 = r5.data
            int r16 = r15 + r10
            byte r3 = r3[r16]
            if (r3 == r9) goto L_0x0083
            r3 = 0
            goto L_0x0088
        L_0x0083:
            int r10 = r10 + 1
            r3 = 0
            goto L_0x0077
        L_0x0087:
            r3 = 1
        L_0x0088:
            r15 = 0
            r17 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r3 == 0) goto L_0x0097
            r5.zzac(r8)
        L_0x0094:
            r9 = r17
            goto L_0x00a9
        L_0x0097:
            if (r12 != 0) goto L_0x009e
            long r19 = r5.zzge()
            goto L_0x00a2
        L_0x009e:
            long r19 = r5.zzgh()
        L_0x00a2:
            int r3 = (r19 > r15 ? 1 : (r19 == r15 ? 0 : -1))
            if (r3 != 0) goto L_0x00a7
            goto L_0x0094
        L_0x00a7:
            r9 = r19
        L_0x00a9:
            r5.zzac(r4)
            int r3 = r5.readInt()
            int r8 = r5.readInt()
            r5.zzac(r7)
            int r12 = r5.readInt()
            int r5 = r5.readInt()
            r7 = 65536(0x10000, float:9.18355E-41)
            r15 = -65536(0xffffffffffff0000, float:NaN)
            if (r3 != 0) goto L_0x00ce
            if (r8 != r7) goto L_0x00ce
            if (r12 != r15) goto L_0x00ce
            if (r5 != 0) goto L_0x00ce
            r3 = 90
            goto L_0x00e5
        L_0x00ce:
            if (r3 != 0) goto L_0x00d9
            if (r8 != r15) goto L_0x00d9
            if (r12 != r7) goto L_0x00d9
            if (r5 != 0) goto L_0x00d9
            r3 = 270(0x10e, float:3.78E-43)
            goto L_0x00e5
        L_0x00d9:
            if (r3 != r15) goto L_0x00e4
            if (r8 != 0) goto L_0x00e4
            if (r12 != 0) goto L_0x00e4
            if (r5 != r15) goto L_0x00e4
            r3 = 180(0xb4, float:2.52E-43)
            goto L_0x00e5
        L_0x00e4:
            r3 = 0
        L_0x00e5:
            com.google.android.gms.internal.ads.zzos r5 = new com.google.android.gms.internal.ads.zzos
            r5.<init>(r14, r9, r3)
            long r19 = r5.zzct
            r3 = r50
            com.google.android.gms.internal.ads.zzst r3 = r3.zzbea
            r3.setPosition(r11)
            int r7 = r3.readInt()
            int r7 = com.google.android.gms.internal.ads.zzoj.zzt(r7)
            if (r7 != 0) goto L_0x0102
            r7 = 8
            goto L_0x0104
        L_0x0102:
            r7 = 16
        L_0x0104:
            r3.zzac(r7)
            long r7 = r3.zzge()
            int r3 = (r19 > r17 ? 1 : (r19 == r17 ? 0 : -1))
            if (r3 != 0) goto L_0x0112
            r18 = r17
            goto L_0x011d
        L_0x0112:
            r21 = 1000000(0xf4240, double:4.940656E-318)
            r23 = r7
            long r9 = com.google.android.gms.internal.ads.zzsy.zza((long) r19, (long) r21, (long) r23)
            r18 = r9
        L_0x011d:
            int r3 = com.google.android.gms.internal.ads.zzoj.zzaks
            com.google.android.gms.internal.ads.zzok r3 = r2.zzaz(r3)
            int r9 = com.google.android.gms.internal.ads.zzoj.zzakt
            com.google.android.gms.internal.ads.zzok r3 = r3.zzaz(r9)
            int r9 = com.google.android.gms.internal.ads.zzoj.zzakz
            com.google.android.gms.internal.ads.zzol r2 = r2.zzay(r9)
            com.google.android.gms.internal.ads.zzst r2 = r2.zzbea
            r2.setPosition(r11)
            int r9 = r2.readInt()
            int r9 = com.google.android.gms.internal.ads.zzoj.zzt(r9)
            if (r9 != 0) goto L_0x0141
            r10 = 8
            goto L_0x0143
        L_0x0141:
            r10 = 16
        L_0x0143:
            r2.zzac(r10)
            long r14 = r2.zzge()
            if (r9 != 0) goto L_0x014e
            r9 = 4
            goto L_0x0150
        L_0x014e:
            r9 = 8
        L_0x0150:
            r2.zzac(r9)
            int r2 = r2.readUnsignedShort()
            int r9 = r2 >> 10
            r9 = r9 & 31
            int r9 = r9 + 96
            char r9 = (char) r9
            int r10 = r2 >> 5
            r10 = r10 & 31
            int r10 = r10 + 96
            char r10 = (char) r10
            r2 = r2 & 31
            int r2 = r2 + 96
            char r2 = (char) r2
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r6)
            r12.append(r9)
            r12.append(r10)
            r12.append(r2)
            java.lang.String r2 = r12.toString()
            java.lang.Long r9 = java.lang.Long.valueOf(r14)
            android.util.Pair r2 = android.util.Pair.create(r9, r2)
            int r9 = com.google.android.gms.internal.ads.zzoj.zzalb
            com.google.android.gms.internal.ads.zzol r3 = r3.zzay(r9)
            com.google.android.gms.internal.ads.zzst r3 = r3.zzbea
            int r9 = r5.f184id
            int r10 = r5.zzatt
            java.lang.Object r12 = r2.second
            java.lang.String r12 = (java.lang.String) r12
            r14 = 12
            r3.setPosition(r14)
            int r14 = r3.readInt()
            com.google.android.gms.internal.ads.zzop r15 = new com.google.android.gms.internal.ads.zzop
            r15.<init>(r14)
            r6 = 0
        L_0x01a7:
            if (r6 >= r14) goto L_0x065b
            int r4 = r3.getPosition()
            int r11 = r3.readInt()
            if (r11 <= 0) goto L_0x01b9
            r42 = r7
            r41 = r14
            r14 = 1
            goto L_0x01be
        L_0x01b9:
            r42 = r7
            r41 = r14
            r14 = 0
        L_0x01be:
            java.lang.String r7 = "childAtomSize should be positive"
            com.google.android.gms.internal.ads.zzsk.checkArgument(r14, r7)
            int r7 = r3.readInt()
            int r8 = com.google.android.gms.internal.ads.zzoj.zzaka
            if (r7 == r8) goto L_0x04c5
            int r8 = com.google.android.gms.internal.ads.zzoj.zzakb
            if (r7 == r8) goto L_0x04c5
            int r8 = com.google.android.gms.internal.ads.zzoj.zzalh
            if (r7 == r8) goto L_0x04c5
            int r8 = com.google.android.gms.internal.ads.zzoj.zzalr
            if (r7 == r8) goto L_0x04c5
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbcj
            if (r7 == r8) goto L_0x04c5
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbck
            if (r7 == r8) goto L_0x04c5
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbcl
            if (r7 == r8) goto L_0x04c5
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbdu
            if (r7 == r8) goto L_0x04c5
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbdv
            if (r7 != r8) goto L_0x01ed
            goto L_0x04c5
        L_0x01ed:
            int r8 = com.google.android.gms.internal.ads.zzoj.zzake
            if (r7 == r8) goto L_0x02c9
            int r8 = com.google.android.gms.internal.ads.zzoj.zzali
            if (r7 == r8) goto L_0x02c9
            int r8 = com.google.android.gms.internal.ads.zzoj.zzakf
            if (r7 == r8) goto L_0x02c9
            int r8 = com.google.android.gms.internal.ads.zzoj.zzakh
            if (r7 == r8) goto L_0x02c9
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbcr
            if (r7 == r8) goto L_0x02c9
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbcu
            if (r7 == r8) goto L_0x02c9
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbcs
            if (r7 == r8) goto L_0x02c9
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbct
            if (r7 == r8) goto L_0x02c9
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbdi
            if (r7 == r8) goto L_0x02c9
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbdj
            if (r7 == r8) goto L_0x02c9
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbcp
            if (r7 == r8) goto L_0x02c9
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbcq
            if (r7 == r8) goto L_0x02c9
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbcn
            if (r7 == r8) goto L_0x02c9
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbdy
            if (r7 != r8) goto L_0x0227
            goto L_0x02c9
        L_0x0227:
            int r8 = com.google.android.gms.internal.ads.zzoj.zzalo
            if (r7 == r8) goto L_0x0256
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbde
            if (r7 == r8) goto L_0x0256
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbdf
            if (r7 == r8) goto L_0x0256
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbdg
            if (r7 == r8) goto L_0x0256
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbdh
            if (r7 != r8) goto L_0x023c
            goto L_0x0256
        L_0x023c:
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbdx
            if (r7 != r8) goto L_0x0252
            java.lang.String r7 = java.lang.Integer.toString(r9)
            java.lang.String r8 = "application/x-camera-motion"
            r44 = r13
            r13 = -1
            r14 = 0
            com.google.android.gms.internal.ads.zzlh r7 = com.google.android.gms.internal.ads.zzlh.zza(r7, r8, r14, r13, r14)
            r15.zzaue = r7
            goto L_0x030a
        L_0x0252:
            r44 = r13
            goto L_0x030a
        L_0x0256:
            r44 = r13
            int r8 = r4 + 8
            r13 = 8
            int r8 = r8 + r13
            r3.setPosition(r8)
            int r8 = com.google.android.gms.internal.ads.zzoj.zzalo
            if (r7 != r8) goto L_0x0270
            java.lang.String r7 = "application/ttml+xml"
        L_0x0266:
            r27 = r7
            r34 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x026d:
            r36 = 0
            goto L_0x02ac
        L_0x0270:
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbde
            if (r7 != r8) goto L_0x0290
            java.lang.String r7 = "application/x-quicktime-tx3g"
            int r8 = r11 + -8
            r16 = 8
            int r8 = r8 + -8
            byte[] r13 = new byte[r8]
            r14 = 0
            r3.zzb(r13, r14, r8)
            java.util.List r8 = java.util.Collections.singletonList(r13)
            r27 = r7
            r36 = r8
            r34 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L_0x02ac
        L_0x0290:
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbdf
            if (r7 != r8) goto L_0x0297
            java.lang.String r7 = "application/x-mp4-vtt"
            goto L_0x0266
        L_0x0297:
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbdg
            if (r7 != r8) goto L_0x02a2
            java.lang.String r7 = "application/ttml+xml"
            r27 = r7
            r34 = 0
            goto L_0x026d
        L_0x02a2:
            int r8 = com.google.android.gms.internal.ads.zzoj.zzbdh
            if (r7 != r8) goto L_0x02c3
            java.lang.String r7 = "application/x-mp4-cea-608"
            r8 = 1
            r15.zzbep = r8
            goto L_0x0266
        L_0x02ac:
            java.lang.String r26 = java.lang.Integer.toString(r9)
            r28 = 0
            r29 = -1
            r30 = 0
            r32 = -1
            r33 = 0
            r31 = r12
            com.google.android.gms.internal.ads.zzlh r7 = com.google.android.gms.internal.ads.zzlh.zza(r26, r27, r28, r29, r30, r31, r32, r33, r34, r36)
            r15.zzaue = r7
            goto L_0x030a
        L_0x02c3:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x02c9:
            r44 = r13
            int r8 = r4 + 8
            r13 = 8
            int r8 = r8 + r13
            r3.setPosition(r8)
            if (r54 == 0) goto L_0x02de
            int r8 = r3.readUnsignedShort()
            r14 = 6
            r3.zzac(r14)
            goto L_0x02e2
        L_0x02de:
            r3.zzac(r13)
            r8 = 0
        L_0x02e2:
            if (r8 == 0) goto L_0x0313
            r13 = 1
            if (r8 != r13) goto L_0x02e8
            goto L_0x0313
        L_0x02e8:
            r13 = 2
            if (r8 != r13) goto L_0x030a
            r8 = 16
            r3.zzac(r8)
            long r13 = r3.readLong()
            double r13 = java.lang.Double.longBitsToDouble(r13)
            long r13 = java.lang.Math.round(r13)
            int r8 = (int) r13
            int r13 = r3.zzgg()
            r14 = 20
            r3.zzac(r14)
            r14 = r8
            r45 = r13
            goto L_0x0329
        L_0x030a:
            r46 = r2
            r47 = r5
            r48 = r10
        L_0x0310:
            r14 = 3
            goto L_0x0641
        L_0x0313:
            int r13 = r3.readUnsignedShort()
            r14 = 6
            r3.zzac(r14)
            int r14 = r3.zzgf()
            r45 = r13
            r13 = 1
            if (r8 != r13) goto L_0x0329
            r8 = 16
            r3.zzac(r8)
        L_0x0329:
            int r8 = r3.getPosition()
            int r13 = com.google.android.gms.internal.ads.zzoj.zzali
            if (r7 != r13) goto L_0x0338
            int r7 = zza((com.google.android.gms.internal.ads.zzst) r3, (int) r4, (int) r11, (com.google.android.gms.internal.ads.zzop) r15, (int) r6)
            r3.setPosition(r8)
        L_0x0338:
            int r13 = com.google.android.gms.internal.ads.zzoj.zzakf
            if (r7 != r13) goto L_0x033f
            java.lang.String r7 = "audio/ac3"
            goto L_0x0389
        L_0x033f:
            int r13 = com.google.android.gms.internal.ads.zzoj.zzakh
            if (r7 != r13) goto L_0x0346
            java.lang.String r7 = "audio/eac3"
            goto L_0x0389
        L_0x0346:
            int r13 = com.google.android.gms.internal.ads.zzoj.zzbcr
            if (r7 != r13) goto L_0x034d
            java.lang.String r7 = "audio/vnd.dts"
            goto L_0x0389
        L_0x034d:
            int r13 = com.google.android.gms.internal.ads.zzoj.zzbcs
            if (r7 == r13) goto L_0x0387
            int r13 = com.google.android.gms.internal.ads.zzoj.zzbct
            if (r7 != r13) goto L_0x0356
            goto L_0x0387
        L_0x0356:
            int r13 = com.google.android.gms.internal.ads.zzoj.zzbcu
            if (r7 != r13) goto L_0x035d
            java.lang.String r7 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x0389
        L_0x035d:
            int r13 = com.google.android.gms.internal.ads.zzoj.zzbdi
            if (r7 != r13) goto L_0x0364
            java.lang.String r7 = "audio/3gpp"
            goto L_0x0389
        L_0x0364:
            int r13 = com.google.android.gms.internal.ads.zzoj.zzbdj
            if (r7 != r13) goto L_0x036b
            java.lang.String r7 = "audio/amr-wb"
            goto L_0x0389
        L_0x036b:
            int r13 = com.google.android.gms.internal.ads.zzoj.zzbcp
            if (r7 == r13) goto L_0x0384
            int r13 = com.google.android.gms.internal.ads.zzoj.zzbcq
            if (r7 != r13) goto L_0x0374
            goto L_0x0384
        L_0x0374:
            int r13 = com.google.android.gms.internal.ads.zzoj.zzbcn
            if (r7 != r13) goto L_0x037b
            java.lang.String r7 = "audio/mpeg"
            goto L_0x0389
        L_0x037b:
            int r13 = com.google.android.gms.internal.ads.zzoj.zzbdy
            if (r7 != r13) goto L_0x0382
            java.lang.String r7 = "audio/alac"
            goto L_0x0389
        L_0x0382:
            r7 = 0
            goto L_0x0389
        L_0x0384:
            java.lang.String r7 = "audio/raw"
            goto L_0x0389
        L_0x0387:
            java.lang.String r7 = "audio/vnd.dts.hd"
        L_0x0389:
            r46 = r2
            r13 = 0
        L_0x038c:
            int r2 = r8 - r4
            if (r2 >= r11) goto L_0x0484
            r3.setPosition(r8)
            int r2 = r3.readInt()
            if (r2 <= 0) goto L_0x039d
            r47 = r5
            r5 = 1
            goto L_0x03a0
        L_0x039d:
            r47 = r5
            r5 = 0
        L_0x03a0:
            java.lang.String r0 = "childAtomSize should be positive"
            com.google.android.gms.internal.ads.zzsk.checkArgument(r5, r0)
            int r0 = r3.readInt()
            int r5 = com.google.android.gms.internal.ads.zzoj.zzakc
            if (r0 == r5) goto L_0x0415
            if (r54 == 0) goto L_0x03b4
            int r5 = com.google.android.gms.internal.ads.zzoj.zzbco
            if (r0 != r5) goto L_0x03b4
            goto L_0x0415
        L_0x03b4:
            int r5 = com.google.android.gms.internal.ads.zzoj.zzakg
            if (r0 != r5) goto L_0x03ca
            int r0 = r8 + 8
            r3.setPosition(r0)
            java.lang.String r0 = java.lang.Integer.toString(r9)
            r5 = 0
            com.google.android.gms.internal.ads.zzlh r0 = com.google.android.gms.internal.ads.zzlv.zza(r3, r0, r12, r5)
            r15.zzaue = r0
        L_0x03c8:
            r5 = 0
            goto L_0x0410
        L_0x03ca:
            int r5 = com.google.android.gms.internal.ads.zzoj.zzaki
            if (r0 != r5) goto L_0x03df
            int r0 = r8 + 8
            r3.setPosition(r0)
            java.lang.String r0 = java.lang.Integer.toString(r9)
            r5 = 0
            com.google.android.gms.internal.ads.zzlh r0 = com.google.android.gms.internal.ads.zzlv.zzb(r3, r0, r12, r5)
            r15.zzaue = r0
            goto L_0x03c8
        L_0x03df:
            int r5 = com.google.android.gms.internal.ads.zzoj.zzbcv
            if (r0 != r5) goto L_0x0402
            java.lang.String r26 = java.lang.Integer.toString(r9)
            r28 = 0
            r29 = -1
            r30 = -1
            r33 = 0
            r34 = 0
            r35 = 0
            r27 = r7
            r31 = r45
            r32 = r14
            r36 = r12
            com.google.android.gms.internal.ads.zzlh r0 = com.google.android.gms.internal.ads.zzlh.zza(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            r15.zzaue = r0
            goto L_0x03c8
        L_0x0402:
            int r5 = com.google.android.gms.internal.ads.zzoj.zzbdy
            if (r0 != r5) goto L_0x03c8
            byte[] r0 = new byte[r2]
            r3.setPosition(r8)
            r5 = 0
            r3.zzb(r0, r5, r2)
            r13 = r0
        L_0x0410:
            r48 = r10
            r1 = -1
            goto L_0x047b
        L_0x0415:
            int r5 = com.google.android.gms.internal.ads.zzoj.zzakc
            if (r0 != r5) goto L_0x041e
            r0 = r8
            r48 = r10
        L_0x041c:
            r1 = -1
            goto L_0x044c
        L_0x041e:
            int r0 = r3.getPosition()
        L_0x0422:
            int r5 = r0 - r8
            if (r5 >= r2) goto L_0x0448
            r3.setPosition(r0)
            int r5 = r3.readInt()
            if (r5 <= 0) goto L_0x0433
            r48 = r10
            r1 = 1
            goto L_0x0436
        L_0x0433:
            r48 = r10
            r1 = 0
        L_0x0436:
            java.lang.String r10 = "childAtomSize should be positive"
            com.google.android.gms.internal.ads.zzsk.checkArgument(r1, r10)
            int r1 = r3.readInt()
            int r10 = com.google.android.gms.internal.ads.zzoj.zzakc
            if (r1 != r10) goto L_0x0444
            goto L_0x041c
        L_0x0444:
            int r0 = r0 + r5
            r10 = r48
            goto L_0x0422
        L_0x0448:
            r48 = r10
            r0 = -1
            goto L_0x041c
        L_0x044c:
            if (r0 == r1) goto L_0x047b
            android.util.Pair r0 = zzb(r3, r0)
            java.lang.Object r5 = r0.first
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r0 = r0.second
            r13 = r0
            byte[] r13 = (byte[]) r13
            java.lang.String r0 = "audio/mp4a-latm"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x047a
            android.util.Pair r0 = com.google.android.gms.internal.ads.zzsl.zzf(r13)
            java.lang.Object r7 = r0.first
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r0 = r0.second
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r45 = r0
            r14 = r7
        L_0x047a:
            r7 = r5
        L_0x047b:
            int r8 = r8 + r2
            r5 = r47
            r10 = r48
            r0 = r49
            goto L_0x038c
        L_0x0484:
            r47 = r5
            r48 = r10
            r1 = -1
            com.google.android.gms.internal.ads.zzlh r0 = r15.zzaue
            if (r0 != 0) goto L_0x0310
            if (r7 == 0) goto L_0x0310
            java.lang.String r0 = "audio/raw"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x049a
            r33 = 2
            goto L_0x049c
        L_0x049a:
            r33 = -1
        L_0x049c:
            java.lang.String r26 = java.lang.Integer.toString(r9)
            r28 = 0
            r29 = -1
            r30 = -1
            if (r13 != 0) goto L_0x04ab
            r34 = 0
            goto L_0x04b1
        L_0x04ab:
            java.util.List r0 = java.util.Collections.singletonList(r13)
            r34 = r0
        L_0x04b1:
            r35 = 0
            r36 = 0
            r27 = r7
            r31 = r45
            r32 = r14
            r37 = r12
            com.google.android.gms.internal.ads.zzlh r0 = com.google.android.gms.internal.ads.zzlh.zza(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)
            r15.zzaue = r0
            goto L_0x0310
        L_0x04c5:
            r46 = r2
            r47 = r5
            r48 = r10
            r44 = r13
            r1 = -1
            int r0 = r4 + 8
            r2 = 8
            int r0 = r0 + r2
            r3.setPosition(r0)
            r0 = 16
            r3.zzac(r0)
            int r31 = r3.readUnsignedShort()
            int r32 = r3.readUnsignedShort()
            r2 = 1065353216(0x3f800000, float:1.0)
            r5 = 50
            r3.zzac(r5)
            int r5 = r3.getPosition()
            int r8 = com.google.android.gms.internal.ads.zzoj.zzalh
            if (r7 != r8) goto L_0x04f9
            int r7 = zza((com.google.android.gms.internal.ads.zzst) r3, (int) r4, (int) r11, (com.google.android.gms.internal.ads.zzop) r15, (int) r6)
            r3.setPosition(r5)
        L_0x04f9:
            r10 = 0
            r27 = 0
            r34 = 0
            r36 = 1065353216(0x3f800000, float:1.0)
            r37 = 0
            r38 = -1
        L_0x0504:
            int r2 = r5 - r4
            if (r2 >= r11) goto L_0x0626
            r3.setPosition(r5)
            int r2 = r3.getPosition()
            int r8 = r3.readInt()
            if (r8 != 0) goto L_0x051c
            int r13 = r3.getPosition()
            int r13 = r13 - r4
            if (r13 == r11) goto L_0x0626
        L_0x051c:
            if (r8 <= 0) goto L_0x0520
            r13 = 1
            goto L_0x0521
        L_0x0520:
            r13 = 0
        L_0x0521:
            java.lang.String r14 = "childAtomSize should be positive"
            com.google.android.gms.internal.ads.zzsk.checkArgument(r13, r14)
            int r13 = r3.readInt()
            int r14 = com.google.android.gms.internal.ads.zzoj.zzaku
            if (r13 != r14) goto L_0x0554
            if (r27 != 0) goto L_0x0532
            r13 = 1
            goto L_0x0533
        L_0x0532:
            r13 = 0
        L_0x0533:
            com.google.android.gms.internal.ads.zzsk.checkState(r13)
            java.lang.String r13 = "video/avc"
            int r2 = r2 + 8
            r3.setPosition(r2)
            com.google.android.gms.internal.ads.zzta r2 = com.google.android.gms.internal.ads.zzta.zzf(r3)
            java.util.List<byte[]> r14 = r2.zzafw
            int r0 = r2.zzamf
            r15.zzamf = r0
            if (r10 != 0) goto L_0x054d
            float r0 = r2.zzbne
            r36 = r0
        L_0x054d:
            r27 = r13
            r34 = r14
        L_0x0551:
            r14 = 3
            goto L_0x0620
        L_0x0554:
            int r0 = com.google.android.gms.internal.ads.zzoj.zzbcw
            if (r13 != r0) goto L_0x0576
            if (r27 != 0) goto L_0x055c
            r0 = 1
            goto L_0x055d
        L_0x055c:
            r0 = 0
        L_0x055d:
            com.google.android.gms.internal.ads.zzsk.checkState(r0)
            java.lang.String r0 = "video/hevc"
            int r2 = r2 + 8
            r3.setPosition(r2)
            com.google.android.gms.internal.ads.zztg r2 = com.google.android.gms.internal.ads.zztg.zzh(r3)
            java.util.List<byte[]> r13 = r2.zzafw
            int r2 = r2.zzamf
            r15.zzamf = r2
            r27 = r0
            r34 = r13
            goto L_0x0551
        L_0x0576:
            int r0 = com.google.android.gms.internal.ads.zzoj.zzbdw
            if (r13 != r0) goto L_0x058c
            if (r27 != 0) goto L_0x057e
            r0 = 1
            goto L_0x057f
        L_0x057e:
            r0 = 0
        L_0x057f:
            com.google.android.gms.internal.ads.zzsk.checkState(r0)
            int r0 = com.google.android.gms.internal.ads.zzoj.zzbdu
            if (r7 != r0) goto L_0x0589
            java.lang.String r0 = "video/x-vnd.on2.vp8"
            goto L_0x059a
        L_0x0589:
            java.lang.String r0 = "video/x-vnd.on2.vp9"
            goto L_0x059a
        L_0x058c:
            int r0 = com.google.android.gms.internal.ads.zzoj.zzbcm
            if (r13 != r0) goto L_0x059d
            if (r27 != 0) goto L_0x0594
            r0 = 1
            goto L_0x0595
        L_0x0594:
            r0 = 0
        L_0x0595:
            com.google.android.gms.internal.ads.zzsk.checkState(r0)
            java.lang.String r0 = "video/3gpp"
        L_0x059a:
            r27 = r0
            goto L_0x0551
        L_0x059d:
            int r0 = com.google.android.gms.internal.ads.zzoj.zzakc
            if (r13 != r0) goto L_0x05be
            if (r27 != 0) goto L_0x05a5
            r0 = 1
            goto L_0x05a6
        L_0x05a5:
            r0 = 0
        L_0x05a6:
            com.google.android.gms.internal.ads.zzsk.checkState(r0)
            android.util.Pair r0 = zzb(r3, r2)
            java.lang.Object r2 = r0.first
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r0 = r0.second
            byte[] r0 = (byte[]) r0
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r34 = r0
            r27 = r2
            goto L_0x0551
        L_0x05be:
            int r0 = com.google.android.gms.internal.ads.zzoj.zzaln
            if (r13 != r0) goto L_0x05d6
            int r2 = r2 + 8
            r3.setPosition(r2)
            int r0 = r3.zzgg()
            int r2 = r3.zzgg()
            float r0 = (float) r0
            float r2 = (float) r2
            float r36 = r0 / r2
            r10 = 1
            goto L_0x0551
        L_0x05d6:
            int r0 = com.google.android.gms.internal.ads.zzoj.zzbds
            if (r13 != r0) goto L_0x05ff
            int r0 = r2 + 8
        L_0x05dc:
            int r13 = r0 - r2
            if (r13 >= r8) goto L_0x05fa
            r3.setPosition(r0)
            int r13 = r3.readInt()
            int r14 = r3.readInt()
            int r1 = com.google.android.gms.internal.ads.zzoj.zzbdt
            if (r14 != r1) goto L_0x05f7
            byte[] r1 = r3.data
            int r13 = r13 + r0
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r0, r13)
            goto L_0x05fb
        L_0x05f7:
            int r0 = r0 + r13
            r1 = -1
            goto L_0x05dc
        L_0x05fa:
            r0 = 0
        L_0x05fb:
            r37 = r0
            goto L_0x0551
        L_0x05ff:
            int r0 = com.google.android.gms.internal.ads.zzoj.zzbdr
            if (r13 != r0) goto L_0x0551
            int r0 = r3.readUnsignedByte()
            r14 = 3
            r3.zzac(r14)
            if (r0 != 0) goto L_0x0620
            int r0 = r3.readUnsignedByte()
            switch(r0) {
                case 0: goto L_0x061e;
                case 1: goto L_0x061b;
                case 2: goto L_0x0618;
                case 3: goto L_0x0615;
                default: goto L_0x0614;
            }
        L_0x0614:
            goto L_0x0620
        L_0x0615:
            r38 = 3
            goto L_0x0620
        L_0x0618:
            r38 = 2
            goto L_0x0620
        L_0x061b:
            r38 = 1
            goto L_0x0620
        L_0x061e:
            r38 = 0
        L_0x0620:
            int r5 = r5 + r8
            r0 = 16
            r1 = -1
            goto L_0x0504
        L_0x0626:
            r14 = 3
            if (r27 == 0) goto L_0x0641
            java.lang.String r26 = java.lang.Integer.toString(r9)
            r28 = 0
            r29 = -1
            r30 = -1
            r33 = -1082130432(0xffffffffbf800000, float:-1.0)
            r39 = 0
            r40 = 0
            r35 = r48
            com.google.android.gms.internal.ads.zzlh r0 = com.google.android.gms.internal.ads.zzlh.zza(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            r15.zzaue = r0
        L_0x0641:
            int r4 = r4 + r11
            r3.setPosition(r4)
            int r6 = r6 + 1
            r14 = r41
            r7 = r42
            r13 = r44
            r2 = r46
            r5 = r47
            r10 = r48
            r0 = r49
            r4 = 16
            r11 = 8
            goto L_0x01a7
        L_0x065b:
            r46 = r2
            r47 = r5
            r42 = r7
            r44 = r13
            int r0 = com.google.android.gms.internal.ads.zzoj.zzbcy
            r1 = r49
            com.google.android.gms.internal.ads.zzok r0 = r1.zzaz(r0)
            if (r0 == 0) goto L_0x06c8
            int r1 = com.google.android.gms.internal.ads.zzoj.zzbcz
            com.google.android.gms.internal.ads.zzol r0 = r0.zzay(r1)
            if (r0 != 0) goto L_0x0676
            goto L_0x06c8
        L_0x0676:
            com.google.android.gms.internal.ads.zzst r0 = r0.zzbea
            r1 = 8
            r0.setPosition(r1)
            int r1 = r0.readInt()
            int r1 = com.google.android.gms.internal.ads.zzoj.zzt(r1)
            int r2 = r0.zzgg()
            long[] r3 = new long[r2]
            long[] r4 = new long[r2]
            r5 = 0
        L_0x068e:
            if (r5 >= r2) goto L_0x06c1
            r6 = 1
            if (r1 != r6) goto L_0x0698
            long r7 = r0.zzgh()
            goto L_0x069c
        L_0x0698:
            long r7 = r0.zzge()
        L_0x069c:
            r3[r5] = r7
            if (r1 != r6) goto L_0x06a5
            long r7 = r0.readLong()
            goto L_0x06aa
        L_0x06a5:
            int r7 = r0.readInt()
            long r7 = (long) r7
        L_0x06aa:
            r4[r5] = r7
            short r7 = r0.readShort()
            if (r7 != r6) goto L_0x06b9
            r7 = 2
            r0.zzac(r7)
            int r5 = r5 + 1
            goto L_0x068e
        L_0x06b9:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported media rate."
            r0.<init>(r1)
            throw r0
        L_0x06c1:
            android.util.Pair r0 = android.util.Pair.create(r3, r4)
            r1 = r0
            r0 = 0
            goto L_0x06cd
        L_0x06c8:
            r0 = 0
            android.util.Pair r1 = android.util.Pair.create(r0, r0)
        L_0x06cd:
            com.google.android.gms.internal.ads.zzlh r2 = r15.zzaue
            if (r2 != 0) goto L_0x06d2
            return r0
        L_0x06d2:
            com.google.android.gms.internal.ads.zzpa r0 = new com.google.android.gms.internal.ads.zzpa
            int r12 = r47.f184id
            r2 = r46
            java.lang.Object r2 = r2.first
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            com.google.android.gms.internal.ads.zzlh r4 = r15.zzaue
            int r5 = r15.zzbep
            com.google.android.gms.internal.ads.zzpb[] r6 = r15.zzbeo
            int r7 = r15.zzamf
            java.lang.Object r8 = r1.first
            r24 = r8
            long[] r24 = (long[]) r24
            java.lang.Object r1 = r1.second
            r25 = r1
            long[] r25 = (long[]) r25
            r11 = r0
            r13 = r44
            r14 = r2
            r16 = r42
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r11.<init>(r12, r13, r14, r16, r18, r20, r21, r22, r23, r24, r25)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzom.zza(com.google.android.gms.internal.ads.zzok, com.google.android.gms.internal.ads.zzol, long, com.google.android.gms.internal.ads.zzne, boolean):com.google.android.gms.internal.ads.zzpa");
    }

    public static zzpc zza(zzpa zzpa, zzok zzok, zznr zznr) throws zzlm {
        zzoo zzoo;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        long[] jArr;
        int[] iArr2;
        long[] jArr2;
        long j;
        int[] iArr3;
        long[] jArr3;
        boolean z2;
        long[] jArr4;
        int i5;
        long[] jArr5;
        int[] iArr4;
        int[] iArr5;
        int[] iArr6;
        int i6;
        zzoo zzoo2;
        zzpa zzpa2 = zzpa;
        zzok zzok2 = zzok;
        zznr zznr2 = zznr;
        zzol zzay = zzok2.zzay(zzoj.zzalw);
        if (zzay != null) {
            zzoo = new zzoq(zzay);
        } else {
            zzol zzay2 = zzok2.zzay(zzoj.zzbdd);
            if (zzay2 != null) {
                zzoo = new zzor(zzay2);
            } else {
                throw new zzlm("Track has no sample table size information");
            }
        }
        int zzim = zzoo.zzim();
        if (zzim == 0) {
            return new zzpc(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        zzol zzay3 = zzok2.zzay(zzoj.zzalx);
        if (zzay3 == null) {
            zzay3 = zzok2.zzay(zzoj.zzaly);
            z = true;
        } else {
            z = false;
        }
        zzst zzst = zzay3.zzbea;
        zzst zzst2 = zzok2.zzay(zzoj.zzalv).zzbea;
        zzst zzst3 = zzok2.zzay(zzoj.zzals).zzbea;
        zzol zzay4 = zzok2.zzay(zzoj.zzalt);
        zzst zzst4 = zzay4 != null ? zzay4.zzbea : null;
        zzol zzay5 = zzok2.zzay(zzoj.zzalu);
        zzst zzst5 = zzay5 != null ? zzay5.zzbea : null;
        zzon zzon = new zzon(zzst2, zzst, z);
        zzst3.setPosition(12);
        int zzgg = zzst3.zzgg() - 1;
        int zzgg2 = zzst3.zzgg();
        int zzgg3 = zzst3.zzgg();
        if (zzst5 != null) {
            zzst5.setPosition(12);
            i = zzst5.zzgg();
        } else {
            i = 0;
        }
        int i7 = -1;
        if (zzst4 != null) {
            zzst4.setPosition(12);
            i2 = zzst4.zzgg();
            if (i2 > 0) {
                i7 = zzst4.zzgg() - 1;
            } else {
                zzst4 = null;
            }
        } else {
            i2 = 0;
        }
        long j2 = 0;
        if (!(zzoo.zzio() && MimeTypes.AUDIO_RAW.equals(zzpa2.zzaue.zzatq) && zzgg == 0 && i == 0 && i2 == 0)) {
            jArr2 = new long[zzim];
            iArr = new int[zzim];
            jArr = new long[zzim];
            int i8 = i2;
            iArr2 = new int[zzim];
            zzst zzst6 = zzst3;
            int i9 = i;
            int i10 = i7;
            long j3 = 0;
            int i11 = i8;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = zzgg;
            long j4 = 0;
            int i17 = 0;
            int i18 = zzgg3;
            int i19 = zzgg2;
            int i20 = i18;
            while (i17 < zzim) {
                while (i14 == 0) {
                    zzsk.checkState(zzon.zzil());
                    long j5 = zzon.zzajx;
                    i14 = zzon.zzbei;
                    i20 = i20;
                    i16 = i16;
                    j4 = j5;
                }
                int i21 = i20;
                int i22 = i16;
                if (zzst5 != null) {
                    while (i15 == 0 && i9 > 0) {
                        i15 = zzst5.zzgg();
                        i13 = zzst5.readInt();
                        i9--;
                    }
                    i15--;
                }
                int i23 = i13;
                jArr2[i17] = j4;
                iArr[i17] = zzoo.zzin();
                if (iArr[i17] > i12) {
                    i6 = zzim;
                    zzoo2 = zzoo;
                    i12 = iArr[i17];
                } else {
                    i6 = zzim;
                    zzoo2 = zzoo;
                }
                jArr[i17] = j3 + ((long) i23);
                iArr2[i17] = zzst4 == null ? 1 : 0;
                if (i17 == i10) {
                    iArr2[i17] = 1;
                    i11--;
                    if (i11 > 0) {
                        i10 = zzst4.zzgg() - 1;
                    }
                }
                int i24 = i11;
                int i25 = i10;
                int i26 = i21;
                j3 += (long) i26;
                i19--;
                if (i19 != 0 || i22 <= 0) {
                    i16 = i22;
                } else {
                    i16 = i22 - 1;
                    i19 = zzst6.zzgg();
                    i26 = zzst6.zzgg();
                }
                j4 += (long) iArr[i17];
                i14--;
                i17++;
                i13 = i23;
                zzoo = zzoo2;
                zzim = i6;
                i10 = i25;
                i20 = i26;
                i11 = i24;
            }
            i3 = zzim;
            int i27 = i16;
            zzsk.checkArgument(i15 == 0);
            while (i9 > 0) {
                zzsk.checkArgument(zzst5.zzgg() == 0);
                zzst5.readInt();
                i9--;
            }
            if (i11 == 0 && i19 == 0 && i14 == 0 && i27 == 0) {
                zzpa2 = zzpa;
            } else {
                int i28 = i11;
                zzpa2 = zzpa;
                int i29 = zzpa2.f185id;
                StringBuilder sb = new StringBuilder(JfifUtil.MARKER_RST7);
                sb.append("Inconsistent stbl box for track ");
                sb.append(i29);
                sb.append(": remainingSynchronizationSamples ");
                sb.append(i28);
                sb.append(", remainingSamplesAtTimestampDelta ");
                sb.append(i19);
                sb.append(", remainingSamplesInChunk ");
                sb.append(i14);
                sb.append(", remainingTimestampDeltaChanges ");
                sb.append(i27);
                Log.w("AtomParsers", sb.toString());
            }
            j = j3;
            i4 = i12;
        } else {
            i3 = zzim;
            zzoo zzoo3 = zzoo;
            long[] jArr6 = new long[zzon.length];
            int[] iArr7 = new int[zzon.length];
            while (zzon.zzil()) {
                jArr6[zzon.index] = zzon.zzajx;
                iArr7[zzon.index] = zzon.zzbei;
            }
            int zzin = zzoo3.zzin();
            long j6 = (long) zzgg3;
            int i30 = 8192 / zzin;
            int i31 = 0;
            for (int zzb : iArr7) {
                i31 += zzsy.zzb(zzb, i30);
            }
            long[] jArr7 = new long[i31];
            int[] iArr8 = new int[i31];
            long[] jArr8 = new long[i31];
            int[] iArr9 = new int[i31];
            int i32 = 0;
            int i33 = 0;
            int i34 = 0;
            for (int i35 = 0; i35 < iArr7.length; i35++) {
                int i36 = iArr7[i35];
                long j7 = jArr6[i35];
                while (i36 > 0) {
                    int min = Math.min(i30, i36);
                    jArr7[i33] = j7;
                    iArr8[i33] = zzin * min;
                    i34 = Math.max(i34, iArr8[i33]);
                    jArr8[i33] = ((long) i32) * j6;
                    iArr9[i33] = 1;
                    j7 += (long) iArr8[i33];
                    i32 += min;
                    i36 -= min;
                    i33++;
                    jArr6 = jArr6;
                    iArr7 = iArr7;
                }
                long[] jArr9 = jArr6;
                int[] iArr10 = iArr7;
            }
            zzou zzou = new zzou(jArr7, iArr8, i34, jArr8, iArr9);
            jArr2 = zzou.zzahq;
            iArr = zzou.zzahp;
            int i37 = zzou.zzbet;
            jArr = zzou.zzbeu;
            iArr2 = zzou.zzajr;
            i4 = i37;
            j = 0;
        }
        if (zzpa2.zzbgm == null || zznr.zzii()) {
            zzsy.zza(jArr, 1000000, zzpa2.zzcs);
            return new zzpc(jArr2, iArr, i4, jArr, iArr2);
        }
        if (zzpa2.zzbgm.length == 1 && zzpa2.type == 1 && jArr.length >= 2) {
            long j8 = zzpa2.zzbgn[0];
            long zza = zzsy.zza(zzpa2.zzbgm[0], zzpa2.zzcs, zzpa2.zzbgj) + j8;
            if (jArr[0] <= j8 && j8 < jArr[1] && jArr[jArr.length - 1] < zza && zza <= j) {
                long j9 = j - zza;
                long zza2 = zzsy.zza(j8 - jArr[0], (long) zzpa2.zzaue.zzafv, zzpa2.zzcs);
                long zza3 = zzsy.zza(j9, (long) zzpa2.zzaue.zzafv, zzpa2.zzcs);
                if (!(zza2 == 0 && zza3 == 0) && zza2 <= 2147483647L && zza3 <= 2147483647L) {
                    zznr zznr3 = zznr;
                    zznr3.zzaty = (int) zza2;
                    zznr3.zzatz = (int) zza3;
                    zzsy.zza(jArr, 1000000, zzpa2.zzcs);
                    return new zzpc(jArr2, iArr, i4, jArr, iArr2);
                }
            }
        }
        if (zzpa2.zzbgm.length == 1) {
            char c = 0;
            if (zzpa2.zzbgm[0] == 0) {
                int i38 = 0;
                while (i38 < jArr.length) {
                    jArr[i38] = zzsy.zza(jArr[i38] - zzpa2.zzbgn[c], 1000000, zzpa2.zzcs);
                    i38++;
                    c = 0;
                }
                return new zzpc(jArr2, iArr, i4, jArr, iArr2);
            }
        }
        boolean z3 = zzpa2.type == 1;
        int i39 = 0;
        boolean z4 = false;
        int i40 = 0;
        int i41 = 0;
        while (i39 < zzpa2.zzbgm.length) {
            long j10 = zzpa2.zzbgn[i39];
            if (j10 != -1) {
                iArr6 = iArr;
                long zza4 = zzsy.zza(zzpa2.zzbgm[i39], zzpa2.zzcs, zzpa2.zzbgj);
                int zzb2 = zzsy.zzb(jArr, j10, true, true);
                int zzb3 = zzsy.zzb(jArr, j10 + zza4, z3, false);
                i40 += zzb3 - zzb2;
                z4 |= i41 != zzb2;
                i41 = zzb3;
            } else {
                iArr6 = iArr;
            }
            i39++;
            iArr = iArr6;
        }
        int[] iArr11 = iArr;
        boolean z5 = (i40 != i3) | z4;
        long[] jArr10 = z5 ? new long[i40] : jArr2;
        int[] iArr12 = z5 ? new int[i40] : iArr11;
        if (z5) {
            i4 = 0;
        }
        int[] iArr13 = z5 ? new int[i40] : iArr2;
        long[] jArr11 = new long[i40];
        int i42 = i4;
        int i43 = 0;
        int i44 = 0;
        while (i43 < zzpa2.zzbgm.length) {
            long j11 = zzpa2.zzbgn[i43];
            long j12 = zzpa2.zzbgm[i43];
            if (j11 != -1) {
                int[] iArr14 = iArr13;
                i5 = i43;
                long j13 = zzpa2.zzcs;
                long[] jArr12 = jArr10;
                jArr4 = jArr11;
                int zzb4 = zzsy.zzb(jArr, j11, true, true);
                int zzb5 = zzsy.zzb(jArr, zzsy.zza(j12, j13, zzpa2.zzbgj) + j11, z3, false);
                if (z5) {
                    int i45 = zzb5 - zzb4;
                    jArr5 = jArr12;
                    System.arraycopy(jArr2, zzb4, jArr5, i44, i45);
                    iArr4 = iArr11;
                    System.arraycopy(iArr4, zzb4, iArr12, i44, i45);
                    z2 = z3;
                    iArr5 = iArr14;
                    System.arraycopy(iArr2, zzb4, iArr5, i44, i45);
                } else {
                    z2 = z3;
                    iArr4 = iArr11;
                    iArr5 = iArr14;
                    jArr5 = jArr12;
                }
                int i46 = i42;
                while (zzb4 < zzb5) {
                    long[] jArr13 = jArr2;
                    int[] iArr15 = iArr2;
                    long j14 = j11;
                    jArr4[i44] = zzsy.zza(j2, 1000000, zzpa2.zzbgj) + zzsy.zza(jArr[zzb4] - j11, 1000000, zzpa2.zzcs);
                    if (z5 && iArr12[i44] > i46) {
                        i46 = iArr4[zzb4];
                    }
                    i44++;
                    zzb4++;
                    jArr2 = jArr13;
                    iArr2 = iArr15;
                    j11 = j14;
                }
                jArr3 = jArr2;
                iArr3 = iArr2;
                i42 = i46;
            } else {
                z2 = z3;
                jArr5 = jArr10;
                jArr4 = jArr11;
                jArr3 = jArr2;
                iArr3 = iArr2;
                iArr5 = iArr13;
                i5 = i43;
                iArr4 = iArr11;
            }
            j2 += j12;
            i43 = i5 + 1;
            iArr11 = iArr4;
            jArr10 = jArr5;
            jArr11 = jArr4;
            jArr2 = jArr3;
            iArr2 = iArr3;
            iArr13 = iArr5;
            z3 = z2;
        }
        long[] jArr14 = jArr10;
        long[] jArr15 = jArr11;
        int[] iArr16 = iArr13;
        boolean z6 = false;
        for (int i47 = 0; i47 < iArr16.length && !z6; i47++) {
            z6 |= (iArr16[i47] & 1) != 0;
        }
        if (z6) {
            return new zzpc(jArr14, iArr12, i42, jArr15, iArr16);
        }
        throw new zzlm("The edited sample sequence does not contain a sync sample.");
    }

    public static zzpo zza(zzol zzol, boolean z) {
        if (z) {
            return null;
        }
        zzst zzst = zzol.zzbea;
        zzst.setPosition(8);
        while (zzst.zzjz() >= 8) {
            int position = zzst.getPosition();
            int readInt = zzst.readInt();
            if (zzst.readInt() == zzoj.zzbdl) {
                zzst.setPosition(position);
                int i = position + readInt;
                zzst.zzac(12);
                while (true) {
                    if (zzst.getPosition() >= i) {
                        break;
                    }
                    int position2 = zzst.getPosition();
                    int readInt2 = zzst.readInt();
                    if (zzst.readInt() == zzoj.zzbdm) {
                        zzst.setPosition(position2);
                        int i2 = position2 + readInt2;
                        zzst.zzac(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzst.getPosition() < i2) {
                            zzpo.zza zzd = zzov.zzd(zzst);
                            if (zzd != null) {
                                arrayList.add(zzd);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new zzpo((List<? extends zzpo.zza>) arrayList);
                        }
                    } else {
                        zzst.zzac(readInt2 - 8);
                    }
                }
                return null;
            }
            zzst.zzac(readInt - 8);
        }
        return null;
    }

    private static Pair<String, byte[]> zzb(zzst zzst, int i) {
        zzst.setPosition(i + 8 + 4);
        zzst.zzac(1);
        zzc(zzst);
        zzst.zzac(2);
        int readUnsignedByte = zzst.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            zzst.zzac(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            zzst.zzac(zzst.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            zzst.zzac(2);
        }
        zzst.zzac(1);
        zzc(zzst);
        String str = null;
        switch (zzst.readUnsignedByte()) {
            case 32:
                str = MimeTypes.VIDEO_MP4V;
                break;
            case 33:
                str = MimeTypes.VIDEO_H264;
                break;
            case 35:
                str = MimeTypes.VIDEO_H265;
                break;
            case 64:
            case 102:
            case 103:
            case 104:
                str = MimeTypes.AUDIO_AAC;
                break;
            case 107:
                return Pair.create(MimeTypes.AUDIO_MPEG, (Object) null);
            case 165:
                str = MimeTypes.AUDIO_AC3;
                break;
            case 166:
                str = MimeTypes.AUDIO_E_AC3;
                break;
            case 169:
            case 172:
                return Pair.create(MimeTypes.AUDIO_DTS, (Object) null);
            case 170:
            case 171:
                return Pair.create(MimeTypes.AUDIO_DTS_HD, (Object) null);
        }
        zzst.zzac(12);
        zzst.zzac(1);
        int zzc = zzc(zzst);
        byte[] bArr = new byte[zzc];
        zzst.zzb(bArr, 0, zzc);
        return Pair.create(str, bArr);
    }

    private static int zza(zzst zzst, int i, int i2, zzop zzop, int i3) {
        zzpb zzpb;
        zzst zzst2 = zzst;
        int position = zzst.getPosition();
        while (true) {
            boolean z = false;
            if (position - i >= i2) {
                return 0;
            }
            zzst2.setPosition(position);
            int readInt = zzst.readInt();
            zzsk.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (zzst.readInt() == zzoj.zzald) {
                int i4 = position + 8;
                Pair pair = null;
                Integer num = null;
                zzpb zzpb2 = null;
                boolean z2 = false;
                while (i4 - position < readInt) {
                    zzst2.setPosition(i4);
                    int readInt2 = zzst.readInt();
                    int readInt3 = zzst.readInt();
                    if (readInt3 == zzoj.zzalj) {
                        num = Integer.valueOf(zzst.readInt());
                    } else if (readInt3 == zzoj.zzale) {
                        zzst2.zzac(4);
                        z2 = zzst.readInt() == zzbeh;
                    } else if (readInt3 == zzoj.zzalf) {
                        int i5 = i4 + 8;
                        while (true) {
                            if (i5 - i4 >= readInt2) {
                                zzpb = null;
                                break;
                            }
                            zzst2.setPosition(i5);
                            int readInt4 = zzst.readInt();
                            if (zzst.readInt() == zzoj.zzalg) {
                                zzst2.zzac(6);
                                boolean z3 = zzst.readUnsignedByte() == 1;
                                int readUnsignedByte = zzst.readUnsignedByte();
                                byte[] bArr = new byte[16];
                                zzst2.zzb(bArr, 0, 16);
                                zzpb = new zzpb(z3, readUnsignedByte, bArr);
                            } else {
                                i5 += readInt4;
                            }
                        }
                        zzpb2 = zzpb;
                    }
                    i4 += readInt2;
                }
                if (z2) {
                    zzsk.checkArgument(num != null, "frma atom is mandatory");
                    if (zzpb2 != null) {
                        z = true;
                    }
                    zzsk.checkArgument(z, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, zzpb2);
                }
                if (pair != null) {
                    zzop.zzbeo[i3] = (zzpb) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            zzop zzop2 = zzop;
            position += readInt;
        }
    }

    private static int zzc(zzst zzst) {
        int readUnsignedByte = zzst.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = zzst.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }
}
