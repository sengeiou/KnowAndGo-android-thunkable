package com.google.android.gms.internal.ads;

public enum zzdri {
    DOUBLE(zzdrn.DOUBLE, 1),
    FLOAT(zzdrn.FLOAT, 5),
    INT64(zzdrn.LONG, 0),
    UINT64(zzdrn.LONG, 0),
    INT32(zzdrn.INT, 0),
    FIXED64(zzdrn.LONG, 1),
    FIXED32(zzdrn.INT, 5),
    BOOL(zzdrn.BOOLEAN, 0),
    STRING(zzdrn.STRING, 2),
    GROUP(zzdrn.MESSAGE, 3),
    MESSAGE(zzdrn.MESSAGE, 2),
    BYTES(zzdrn.BYTE_STRING, 2),
    UINT32(zzdrn.INT, 0),
    ENUM(zzdrn.ENUM, 0),
    SFIXED32(zzdrn.INT, 5),
    SFIXED64(zzdrn.LONG, 1),
    SINT32(zzdrn.INT, 0),
    SINT64(zzdrn.LONG, 0);
    
    private final zzdrn zzhmz;
    private final int zzhna;

    private zzdri(zzdrn zzdrn, int i) {
        this.zzhmz = zzdrn;
        this.zzhna = i;
    }

    public final zzdrn zzbaj() {
        return this.zzhmz;
    }

    public final int zzbak() {
        return this.zzhna;
    }
}
