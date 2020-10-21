package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

public final class zzne implements Parcelable, Comparator<zza> {
    public static final Parcelable.Creator<zzne> CREATOR = new zznf();
    private int zzafx;
    private final zza[] zzazf;
    public final int zzazg;

    public zzne(zza... zzaArr) {
        this(true, zzaArr);
    }

    public final int describeContents() {
        return 0;
    }

    public static final class zza implements Parcelable {
        public static final Parcelable.Creator<zza> CREATOR = new zzng();
        private final byte[] data;
        private final String mimeType;
        /* access modifiers changed from: private */
        public final UUID uuid;
        private int zzafx;
        public final boolean zzazh;

        public zza(UUID uuid2, String str, byte[] bArr) {
            this(uuid2, str, bArr, false);
        }

        public final int describeContents() {
            return 0;
        }

        private zza(UUID uuid2, String str, byte[] bArr, boolean z) {
            this.uuid = (UUID) zzsk.checkNotNull(uuid2);
            this.mimeType = (String) zzsk.checkNotNull(str);
            this.data = (byte[]) zzsk.checkNotNull(bArr);
            this.zzazh = false;
        }

        zza(Parcel parcel) {
            this.uuid = new UUID(parcel.readLong(), parcel.readLong());
            this.mimeType = parcel.readString();
            this.data = parcel.createByteArray();
            this.zzazh = parcel.readByte() != 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            zza zza = (zza) obj;
            return this.mimeType.equals(zza.mimeType) && zzsy.zza(this.uuid, zza.uuid) && Arrays.equals(this.data, zza.data);
        }

        public final int hashCode() {
            if (this.zzafx == 0) {
                this.zzafx = (((this.uuid.hashCode() * 31) + this.mimeType.hashCode()) * 31) + Arrays.hashCode(this.data);
            }
            return this.zzafx;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
            parcel.writeByte(this.zzazh ? (byte) 1 : 0);
        }
    }

    private zzne(boolean z, zza... zzaArr) {
        zza[] zzaArr2 = (zza[]) zzaArr.clone();
        Arrays.sort(zzaArr2, this);
        int i = 1;
        while (i < zzaArr2.length) {
            if (!zzaArr2[i - 1].uuid.equals(zzaArr2[i].uuid)) {
                i++;
            } else {
                String valueOf = String.valueOf(zzaArr2[i].uuid);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
                sb.append("Duplicate data for uuid: ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this.zzazf = zzaArr2;
        this.zzazg = zzaArr2.length;
    }

    zzne(Parcel parcel) {
        this.zzazf = (zza[]) parcel.createTypedArray(zza.CREATOR);
        this.zzazg = this.zzazf.length;
    }

    public final zza zzap(int i) {
        return this.zzazf[i];
    }

    public final int hashCode() {
        if (this.zzafx == 0) {
            this.zzafx = Arrays.hashCode(this.zzazf);
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
        return Arrays.equals(this.zzazf, ((zzne) obj).zzazf);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.zzazf, 0);
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zza zza2 = (zza) obj;
        zza zza3 = (zza) obj2;
        if (zzkt.zzarg.equals(zza2.uuid)) {
            return zzkt.zzarg.equals(zza3.uuid) ? 0 : 1;
        }
        return zza2.uuid.compareTo(zza3.uuid);
    }
}
