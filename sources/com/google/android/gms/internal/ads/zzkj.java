package com.google.android.gms.internal.ads;

public final class zzkj {
    public static final byte[] zzaqt = {0, 0, 0, 1};

    public static byte[] zzc(zzkm zzkm) {
        int readUnsignedShort = zzkm.readUnsignedShort();
        int position = zzkm.getPosition();
        zzkm.zzac(readUnsignedShort);
        return zzki.zza(zzkm.data, position, readUnsignedShort);
    }
}
