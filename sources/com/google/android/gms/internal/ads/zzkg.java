package com.google.android.gms.internal.ads;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;
import p000ai.api.util.VoiceActivityDetector;

public final class zzkg {
    private static final int[] zzaqp = {48000, 44100, 32000};
    private static final int[] zzaqq = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzaqr = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, VoiceActivityDetector.FRAME_SIZE_IN_BYTES, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 448, 512, 576, 640};
    private static final int[] zzaqs = {69, 87, 104, 121, 139, 174, JfifUtil.MARKER_RST0, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzhj zza(zzkm zzkm) {
        int i = zzaqp[(zzkm.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzkm.readUnsignedByte();
        int i2 = zzaqq[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return zzhj.zzb(MimeTypes.AUDIO_AC3, -1, -1, i2, i, Collections.emptyList());
    }

    public static zzhj zzb(zzkm zzkm) {
        zzkm.zzac(2);
        int i = zzaqp[(zzkm.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzkm.readUnsignedByte();
        int i2 = zzaqq[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        return zzhj.zza(MimeTypes.AUDIO_E_AC3, -1, i2, i, Collections.emptyList());
    }

    public static int zza(int i, int i2) {
        return (((i << 3) * i2) + 768000) / 1536000;
    }
}
