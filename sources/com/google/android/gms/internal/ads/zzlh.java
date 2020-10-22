package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import com.amplitude.api.Constants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class zzlh implements Parcelable {
    public static final Parcelable.Creator<zzlh> CREATOR = new zzli();
    public final int height;
    public final int width;
    public final int zzafs;
    public final float zzaft;
    public final int zzafu;
    public final int zzafv;
    public final List<byte[]> zzafw;
    private int zzafx;
    private final String zzatl;
    public final int zzatm;
    public final String zzatn;
    private final zzpo zzato;
    private final String zzatp;
    public final String zzatq;
    public final zzne zzatr;
    public final float zzats;
    public final int zzatt;
    private final int zzatu;
    private final byte[] zzatv;
    private final zztb zzatw;
    public final int zzatx;
    private final int zzaty;
    private final int zzatz;
    public final long zzaua;
    public final int zzaub;
    public final String zzauc;
    private final int zzaud;

    public static zzlh zza(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, zztb zztb, zzne zzne) {
        return new zzlh(str, (String) null, str2, (String) null, -1, i2, i3, i4, -1.0f, i5, f2, bArr, i6, zztb, -1, -1, -1, -1, -1, 0, (String) null, -1, Long.MAX_VALUE, list, zzne, (zzpo) null);
    }

    public final int describeContents() {
        return 0;
    }

    public static zzlh zza(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, zzne zzne, int i5, String str4) {
        return zza(str, str2, (String) null, -1, -1, i3, i4, -1, (List<byte[]>) null, zzne, 0, str4);
    }

    public static zzlh zza(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, zzne zzne, int i6, String str4) {
        return new zzlh(str, (String) null, str2, (String) null, -1, i2, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zztb) null, i3, i4, i5, -1, -1, i6, str4, -1, Long.MAX_VALUE, list, zzne, (zzpo) null);
    }

    public static zzlh zza(String str, String str2, String str3, int i, int i2, String str4, zzne zzne) {
        return zza(str, str2, (String) null, -1, i2, str4, -1, zzne, Long.MAX_VALUE, Collections.emptyList());
    }

    public static zzlh zza(String str, String str2, String str3, int i, int i2, String str4, int i3, zzne zzne, long j, List<byte[]> list) {
        return new zzlh(str, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zztb) null, -1, -1, -1, -1, -1, i2, str4, -1, j, list, zzne, (zzpo) null);
    }

    public static zzlh zza(String str, String str2, String str3, int i, List<byte[]> list, String str4, zzne zzne) {
        return new zzlh(str, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zztb) null, -1, -1, -1, -1, -1, 0, str4, -1, Long.MAX_VALUE, list, zzne, (zzpo) null);
    }

    public static zzlh zza(String str, String str2, String str3, int i, zzne zzne) {
        return new zzlh(str, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zztb) null, -1, -1, -1, -1, -1, 0, (String) null, -1, Long.MAX_VALUE, (List<byte[]>) null, (zzne) null, (zzpo) null);
    }

    private zzlh(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, zztb zztb, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, zzne zzne, zzpo zzpo) {
        this.zzatl = str;
        this.zzatp = str2;
        this.zzatq = str3;
        this.zzatn = str4;
        this.zzatm = i;
        this.zzafs = i2;
        this.width = i3;
        this.height = i4;
        this.zzats = f;
        this.zzatt = i5;
        this.zzaft = f2;
        this.zzatv = bArr;
        this.zzatu = i6;
        this.zzatw = zztb;
        this.zzafu = i7;
        this.zzafv = i8;
        this.zzatx = i9;
        this.zzaty = i10;
        this.zzatz = i11;
        this.zzaub = i12;
        this.zzauc = str5;
        this.zzaud = i13;
        this.zzaua = j;
        this.zzafw = list == null ? Collections.emptyList() : list;
        this.zzatr = zzne;
        this.zzato = zzpo;
    }

    zzlh(Parcel parcel) {
        this.zzatl = parcel.readString();
        this.zzatp = parcel.readString();
        this.zzatq = parcel.readString();
        this.zzatn = parcel.readString();
        this.zzatm = parcel.readInt();
        this.zzafs = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.zzats = parcel.readFloat();
        this.zzatt = parcel.readInt();
        this.zzaft = parcel.readFloat();
        this.zzatv = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.zzatu = parcel.readInt();
        this.zzatw = (zztb) parcel.readParcelable(zztb.class.getClassLoader());
        this.zzafu = parcel.readInt();
        this.zzafv = parcel.readInt();
        this.zzatx = parcel.readInt();
        this.zzaty = parcel.readInt();
        this.zzatz = parcel.readInt();
        this.zzaub = parcel.readInt();
        this.zzauc = parcel.readString();
        this.zzaud = parcel.readInt();
        this.zzaua = parcel.readLong();
        int readInt = parcel.readInt();
        this.zzafw = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.zzafw.add(parcel.createByteArray());
        }
        this.zzatr = (zzne) parcel.readParcelable(zzne.class.getClassLoader());
        this.zzato = (zzpo) parcel.readParcelable(zzpo.class.getClassLoader());
    }

    public final zzlh zzae(int i) {
        String str = this.zzatl;
        return new zzlh(str, this.zzatp, this.zzatq, this.zzatn, this.zzatm, i, this.width, this.height, this.zzats, this.zzatt, this.zzaft, this.zzatv, this.zzatu, this.zzatw, this.zzafu, this.zzafv, this.zzatx, this.zzaty, this.zzatz, this.zzaub, this.zzauc, this.zzaud, this.zzaua, this.zzafw, this.zzatr, this.zzato);
    }

    public final zzlh zzed(long j) {
        return new zzlh(this.zzatl, this.zzatp, this.zzatq, this.zzatn, this.zzatm, this.zzafs, this.width, this.height, this.zzats, this.zzatt, this.zzaft, this.zzatv, this.zzatu, this.zzatw, this.zzafu, this.zzafv, this.zzatx, this.zzaty, this.zzatz, this.zzaub, this.zzauc, this.zzaud, j, this.zzafw, this.zzatr, this.zzato);
    }

    public final zzlh zzc(int i, int i2) {
        String str = this.zzatl;
        return new zzlh(str, this.zzatp, this.zzatq, this.zzatn, this.zzatm, this.zzafs, this.width, this.height, this.zzats, this.zzatt, this.zzaft, this.zzatv, this.zzatu, this.zzatw, this.zzafu, this.zzafv, this.zzatx, i, i2, this.zzaub, this.zzauc, this.zzaud, this.zzaua, this.zzafw, this.zzatr, this.zzato);
    }

    public final zzlh zza(zzpo zzpo) {
        String str = this.zzatl;
        return new zzlh(str, this.zzatp, this.zzatq, this.zzatn, this.zzatm, this.zzafs, this.width, this.height, this.zzats, this.zzatt, this.zzaft, this.zzatv, this.zzatu, this.zzatw, this.zzafu, this.zzafv, this.zzatx, this.zzaty, this.zzatz, this.zzaub, this.zzauc, this.zzaud, this.zzaua, this.zzafw, this.zzatr, zzpo);
    }

    public final int zzhc() {
        if (this.width == -1 || this.height == -1) {
            return -1;
        }
        return this.width * this.height;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat zzen() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.zzatq);
        String str = this.zzauc;
        if (str != null) {
            mediaFormat.setString(Constants.AMP_TRACKING_OPTION_LANGUAGE, str);
        }
        zza(mediaFormat, "max-input-size", this.zzafs);
        zza(mediaFormat, "width", this.width);
        zza(mediaFormat, "height", this.height);
        float f = this.zzats;
        if (f != -1.0f) {
            mediaFormat.setFloat("frame-rate", f);
        }
        zza(mediaFormat, "rotation-degrees", this.zzatt);
        zza(mediaFormat, "channel-count", this.zzafu);
        zza(mediaFormat, "sample-rate", this.zzafv);
        zza(mediaFormat, "encoder-delay", this.zzaty);
        zza(mediaFormat, "encoder-padding", this.zzatz);
        for (int i = 0; i < this.zzafw.size(); i++) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i);
            mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap(this.zzafw.get(i)));
        }
        zztb zztb = this.zzatw;
        if (zztb != null) {
            zza(mediaFormat, "color-transfer", zztb.zzbbp);
            zza(mediaFormat, "color-standard", zztb.zzbbo);
            zza(mediaFormat, "color-range", zztb.zzbbq);
            byte[] bArr = zztb.zzbnt;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public final String toString() {
        String str = this.zzatl;
        String str2 = this.zzatp;
        String str3 = this.zzatq;
        int i = this.zzatm;
        String str4 = this.zzauc;
        int i2 = this.width;
        int i3 = this.height;
        float f = this.zzats;
        int i4 = this.zzafu;
        int i5 = this.zzafv;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 100 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("Format(");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(str4);
        sb.append(", [");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(f);
        sb.append("], [");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append("])");
        return sb.toString();
    }

    public final int hashCode() {
        if (this.zzafx == 0) {
            int i = 0;
            int hashCode = ((((((((((((((((((((((((this.zzatl == null ? 0 : this.zzatl.hashCode()) + 527) * 31) + (this.zzatp == null ? 0 : this.zzatp.hashCode())) * 31) + (this.zzatq == null ? 0 : this.zzatq.hashCode())) * 31) + (this.zzatn == null ? 0 : this.zzatn.hashCode())) * 31) + this.zzatm) * 31) + this.width) * 31) + this.height) * 31) + this.zzafu) * 31) + this.zzafv) * 31) + (this.zzauc == null ? 0 : this.zzauc.hashCode())) * 31) + this.zzaud) * 31) + (this.zzatr == null ? 0 : this.zzatr.hashCode())) * 31;
            if (this.zzato != null) {
                i = this.zzato.hashCode();
            }
            this.zzafx = hashCode + i;
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
        zzlh zzlh = (zzlh) obj;
        if (this.zzatm != zzlh.zzatm || this.zzafs != zzlh.zzafs || this.width != zzlh.width || this.height != zzlh.height || this.zzats != zzlh.zzats || this.zzatt != zzlh.zzatt || this.zzaft != zzlh.zzaft || this.zzatu != zzlh.zzatu || this.zzafu != zzlh.zzafu || this.zzafv != zzlh.zzafv || this.zzatx != zzlh.zzatx || this.zzaty != zzlh.zzaty || this.zzatz != zzlh.zzatz || this.zzaua != zzlh.zzaua || this.zzaub != zzlh.zzaub || !zzsy.zza(this.zzatl, zzlh.zzatl) || !zzsy.zza(this.zzauc, zzlh.zzauc) || this.zzaud != zzlh.zzaud || !zzsy.zza(this.zzatp, zzlh.zzatp) || !zzsy.zza(this.zzatq, zzlh.zzatq) || !zzsy.zza(this.zzatn, zzlh.zzatn) || !zzsy.zza(this.zzatr, zzlh.zzatr) || !zzsy.zza(this.zzato, zzlh.zzato) || !zzsy.zza(this.zzatw, zzlh.zzatw) || !Arrays.equals(this.zzatv, zzlh.zzatv) || this.zzafw.size() != zzlh.zzafw.size()) {
            return false;
        }
        for (int i = 0; i < this.zzafw.size(); i++) {
            if (!Arrays.equals(this.zzafw.get(i), zzlh.zzafw.get(i))) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(16)
    private static void zza(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzatl);
        parcel.writeString(this.zzatp);
        parcel.writeString(this.zzatq);
        parcel.writeString(this.zzatn);
        parcel.writeInt(this.zzatm);
        parcel.writeInt(this.zzafs);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.zzats);
        parcel.writeInt(this.zzatt);
        parcel.writeFloat(this.zzaft);
        parcel.writeInt(this.zzatv != null ? 1 : 0);
        if (this.zzatv != null) {
            parcel.writeByteArray(this.zzatv);
        }
        parcel.writeInt(this.zzatu);
        parcel.writeParcelable(this.zzatw, i);
        parcel.writeInt(this.zzafu);
        parcel.writeInt(this.zzafv);
        parcel.writeInt(this.zzatx);
        parcel.writeInt(this.zzaty);
        parcel.writeInt(this.zzatz);
        parcel.writeInt(this.zzaub);
        parcel.writeString(this.zzauc);
        parcel.writeInt(this.zzaud);
        parcel.writeLong(this.zzaua);
        int size = this.zzafw.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.zzafw.get(i2));
        }
        parcel.writeParcelable(this.zzatr, 0);
        parcel.writeParcelable(this.zzato, 0);
    }
}
