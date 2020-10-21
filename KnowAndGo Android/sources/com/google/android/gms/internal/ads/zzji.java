package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.extractor.p012ts.TsExtractor;
import com.google.firebase.FirebaseError;
import java.io.IOException;

final class zzji implements zzje {
    private final /* synthetic */ zzjg zzaoq;

    private zzji(zzjg zzjg) {
        this.zzaoq = zzjg;
    }

    public final int zzx(int i) {
        switch (i) {
            case 131:
            case 159:
            case 176:
            case 179:
            case 186:
            case JfifUtil.MARKER_RST7:
            case 231:
            case 241:
            case 251:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 20531:
            case 21420:
            case 22186:
            case 22203:
            case 2807729:
                return 2;
            case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO:
            case FirebaseError.ERROR_WEAK_PASSWORD /*17026*/:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case JfifUtil.MARKER_APP1:
            case 18407:
            case 19899:
            case 20533:
            case 25152:
            case 28032:
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
            case 18402:
            case 21419:
            case 25506:
                return 4;
            case 181:
            case 17545:
                return 5;
            default:
                return 0;
        }
    }

    public final void zzb(int i, long j, long j2) throws zzhl {
        this.zzaoq.zzb(i, j, j2);
    }

    public final void zzy(int i) throws zzhl {
        this.zzaoq.zzy(i);
    }

    public final void zzc(int i, long j) throws zzhl {
        this.zzaoq.zzc(i, j);
    }

    public final void zza(int i, double d) {
        this.zzaoq.zza(i, d);
    }

    public final void zza(int i, String str) throws zzhl {
        this.zzaoq.zza(i, str);
    }

    public final void zza(int i, int i2, zzie zzie) throws IOException, InterruptedException {
        this.zzaoq.zza(i, i2, zzie);
    }
}
