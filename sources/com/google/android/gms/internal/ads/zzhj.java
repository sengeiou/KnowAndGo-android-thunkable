package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class zzhj {
    public final int height;
    private int maxHeight;
    private int maxWidth;
    public final String mimeType;
    public final int width;
    public final long zzack;
    private final int zzafs;
    public final float zzaft;
    private final int zzafu;
    private final int zzafv;
    public final List<byte[]> zzafw;
    private int zzafx;
    private MediaFormat zzafy;

    @TargetApi(16)
    public static zzhj zza(MediaFormat mediaFormat) {
        return new zzhj(mediaFormat);
    }

    public static zzhj zza(String str, int i, long j, int i2, int i3, List<byte[]> list) {
        return zza(str, -1, j, i2, i3, 1.0f, list);
    }

    public static zzhj zza(String str, int i, long j, int i2, int i3, float f, List<byte[]> list) {
        return new zzhj(str, -1, j, i2, i3, f, -1, -1, list);
    }

    public static zzhj zza(String str, int i, int i2, int i3, List<byte[]> list) {
        return zzb(str, -1, -1, i2, i3, list);
    }

    public static zzhj zzb(String str, int i, long j, int i2, int i3, List<byte[]> list) {
        return new zzhj(str, i, j, -1, -1, -1.0f, i2, i3, list);
    }

    public static zzhj zzem() {
        return new zzhj(MimeTypes.APPLICATION_TTML, -1, -1, -1, -1, -1.0f, -1, -1, (List<byte[]>) null);
    }

    @TargetApi(16)
    private zzhj(MediaFormat mediaFormat) {
        this.zzafy = mediaFormat;
        this.mimeType = mediaFormat.getString("mime");
        this.zzafs = zza(mediaFormat, "max-input-size");
        this.width = zza(mediaFormat, "width");
        this.height = zza(mediaFormat, "height");
        this.zzafu = zza(mediaFormat, "channel-count");
        this.zzafv = zza(mediaFormat, "sample-rate");
        this.zzaft = mediaFormat.containsKey("com.google.android.videos.pixelWidthHeightRatio") ? mediaFormat.getFloat("com.google.android.videos.pixelWidthHeightRatio") : -1.0f;
        this.zzafw = new ArrayList();
        int i = 0;
        while (true) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i);
            if (!mediaFormat.containsKey(sb.toString())) {
                break;
            }
            StringBuilder sb2 = new StringBuilder(15);
            sb2.append("csd-");
            sb2.append(i);
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer(sb2.toString());
            byte[] bArr = new byte[byteBuffer.limit()];
            byteBuffer.get(bArr);
            this.zzafw.add(bArr);
            byteBuffer.flip();
            i++;
        }
        this.zzack = mediaFormat.containsKey("durationUs") ? mediaFormat.getLong("durationUs") : -1;
        this.maxWidth = -1;
        this.maxHeight = -1;
    }

    private zzhj(String str, int i, long j, int i2, int i3, float f, int i4, int i5, List<byte[]> list) {
        this.mimeType = str;
        this.zzafs = i;
        this.zzack = j;
        this.width = i2;
        this.height = i3;
        this.zzaft = f;
        this.zzafu = i4;
        this.zzafv = i5;
        this.zzafw = list == null ? Collections.emptyList() : list;
        this.maxWidth = -1;
        this.maxHeight = -1;
    }

    public final int hashCode() {
        if (this.zzafx == 0) {
            int hashCode = (((((((((((((((((((this.mimeType == null ? 0 : this.mimeType.hashCode()) + 527) * 31) + this.zzafs) * 31) + this.width) * 31) + this.height) * 31) + Float.floatToRawIntBits(this.zzaft)) * 31) + ((int) this.zzack)) * 31) + this.maxWidth) * 31) + this.maxHeight) * 31) + this.zzafu) * 31) + this.zzafv;
            for (int i = 0; i < this.zzafw.size(); i++) {
                hashCode = (hashCode * 31) + Arrays.hashCode(this.zzafw.get(i));
            }
            this.zzafx = hashCode;
        }
        return this.zzafx;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzhj zzhj = (zzhj) obj;
        if (this.zzafs != zzhj.zzafs || this.width != zzhj.width || this.height != zzhj.height || this.zzaft != zzhj.zzaft || this.maxWidth != zzhj.maxWidth || this.maxHeight != zzhj.maxHeight || this.zzafu != zzhj.zzafu || this.zzafv != zzhj.zzafv || !zzkq.zza(this.mimeType, zzhj.mimeType) || this.zzafw.size() != zzhj.zzafw.size()) {
            return false;
        }
        for (int i = 0; i < this.zzafw.size(); i++) {
            if (!Arrays.equals(this.zzafw.get(i), zzhj.zzafw.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        String str = this.mimeType;
        int i = this.zzafs;
        int i2 = this.width;
        int i3 = this.height;
        float f = this.zzaft;
        int i4 = this.zzafu;
        int i5 = this.zzafv;
        long j = this.zzack;
        int i6 = this.maxWidth;
        int i7 = this.maxHeight;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 143);
        sb.append("MediaFormat(");
        sb.append(str);
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(f);
        sb.append(", ");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append(", ");
        sb.append(j);
        sb.append(", ");
        sb.append(i6);
        sb.append(", ");
        sb.append(i7);
        sb.append(")");
        return sb.toString();
    }

    @TargetApi(16)
    public final MediaFormat zzen() {
        if (this.zzafy == null) {
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", this.mimeType);
            zza(mediaFormat, "max-input-size", this.zzafs);
            zza(mediaFormat, "width", this.width);
            zza(mediaFormat, "height", this.height);
            zza(mediaFormat, "channel-count", this.zzafu);
            zza(mediaFormat, "sample-rate", this.zzafv);
            float f = this.zzaft;
            if (f != -1.0f) {
                mediaFormat.setFloat("com.google.android.videos.pixelWidthHeightRatio", f);
            }
            for (int i = 0; i < this.zzafw.size(); i++) {
                StringBuilder sb = new StringBuilder(15);
                sb.append("csd-");
                sb.append(i);
                mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap(this.zzafw.get(i)));
            }
            if (this.zzack != -1) {
                mediaFormat.setLong("durationUs", this.zzack);
            }
            zza(mediaFormat, "max-width", this.maxWidth);
            zza(mediaFormat, "max-height", this.maxHeight);
            this.zzafy = mediaFormat;
        }
        return this.zzafy;
    }

    @TargetApi(16)
    private static final void zza(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    @TargetApi(16)
    private static final int zza(MediaFormat mediaFormat, String str) {
        if (mediaFormat.containsKey(str)) {
            return mediaFormat.getInteger(str);
        }
        return -1;
    }
}
