package com.google.android.gms.internal.ads;

public enum zzbw implements zzdoe {
    UNKNOWN_ENCRYPTION_METHOD(0),
    BITSLICER(1),
    TINK_HYBRID(2),
    UNENCRYPTED(3);
    
    private static final zzdof<zzbw> zzeg = null;
    private final int value;

    public final int zzac() {
        return this.value;
    }

    public static zzbw zzi(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_ENCRYPTION_METHOD;
            case 1:
                return BITSLICER;
            case 2:
                return TINK_HYBRID;
            case 3:
                return UNENCRYPTED;
            default:
                return null;
        }
    }

    public static zzdog zzad() {
        return zzby.zzei;
    }

    private zzbw(int i) {
        this.value = i;
    }

    static {
        zzeg = new zzbx();
    }
}
