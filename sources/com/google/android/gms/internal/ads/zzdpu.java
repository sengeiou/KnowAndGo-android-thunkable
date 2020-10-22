package com.google.android.gms.internal.ads;

final class zzdpu {
    private static final zzdps zzhkh = zzazf();
    private static final zzdps zzhki = new zzdpt();

    static zzdps zzazd() {
        return zzhkh;
    }

    static zzdps zzaze() {
        return zzhki;
    }

    private static zzdps zzazf() {
        try {
            return (zzdps) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
