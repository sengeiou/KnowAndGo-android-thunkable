package com.google.android.gms.internal.ads;

public enum zzwx implements zzdoe {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_UNKNOWN(1000);
    
    private static final zzdof<zzwx> zzeg = null;
    private final int value;

    public final int zzac() {
        return this.value;
    }

    public static zzwx zzca(int i) {
        if (i == 1000) {
            return ENUM_UNKNOWN;
        }
        switch (i) {
            case 0:
                return ENUM_FALSE;
            case 1:
                return ENUM_TRUE;
            default:
                return null;
        }
    }

    public static zzdog zzad() {
        return zzwz.zzei;
    }

    private zzwx(int i) {
        this.value = i;
    }

    static {
        zzeg = new zzwy();
    }
}
