package com.google.android.gms.internal.ads;

public enum zzbz implements zzdoe {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_FAILURE(2),
    ENUM_UNKNOWN(1000);
    
    private static final zzdof<zzbz> zzeg = null;
    private final int value;

    public final int zzac() {
        return this.value;
    }

    public static zzbz zzj(int i) {
        if (i == 1000) {
            return ENUM_UNKNOWN;
        }
        switch (i) {
            case 0:
                return ENUM_FALSE;
            case 1:
                return ENUM_TRUE;
            case 2:
                return ENUM_FAILURE;
            default:
                return null;
        }
    }

    public static zzdog zzad() {
        return zzcb.zzei;
    }

    private zzbz(int i) {
        this.value = i;
    }

    static {
        zzeg = new zzca();
    }
}
