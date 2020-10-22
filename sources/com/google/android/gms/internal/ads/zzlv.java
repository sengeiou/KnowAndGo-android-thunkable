package com.google.android.gms.internal.ads;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.List;
import p000ai.api.util.VoiceActivityDetector;

public final class zzlv {
    private static final int[] zzauy = {1, 2, 3, 6};
    private static final int[] zzauz = {48000, 44100, 32000};
    private static final int[] zzava = {24000, 22050, 16000};
    private static final int[] zzavb = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzavc = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, VoiceActivityDetector.FRAME_SIZE_IN_BYTES, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 448, 512, 576, 640};
    private static final int[] zzavd = {69, 87, 104, 121, 139, 174, JfifUtil.MARKER_RST0, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzlh zza(zzst zzst, String str, String str2, zzne zzne) {
        int i = zzauz[(zzst.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzst.readUnsignedByte();
        int i2 = zzavb[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return zzlh.zza(str, MimeTypes.AUDIO_AC3, (String) null, -1, -1, i2, i, (List<byte[]>) null, (zzne) null, 0, str2);
    }

    public static int zzhi() {
        return 1536;
    }

    public static zzlh zzb(zzst zzst, String str, String str2, zzne zzne) {
        zzst.zzac(2);
        int i = zzauz[(zzst.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzst.readUnsignedByte();
        int i2 = zzavb[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        return zzlh.zza(str, MimeTypes.AUDIO_E_AC3, (String) null, -1, -1, i2, i, (List<byte[]>) null, (zzne) null, 0, str2);
    }

    public static int zzh(ByteBuffer byteBuffer) {
        int i = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = zzauy[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i * 256;
    }
}
