package com.google.android.gms.internal.ads;

public enum zzcc implements zzdoe {
    UNKNOWN_PROTO(0),
    AFMA_SIGNALS(1),
    UNITY_SIGNALS(2),
    PARTNER_SIGNALS(3);
    
    private static final zzdof<zzcc> zzeg = null;
    private final int value;

    public final int zzac() {
        return this.value;
    }

    public static zzcc zzk(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_PROTO;
            case 1:
                return AFMA_SIGNALS;
            case 2:
                return UNITY_SIGNALS;
            case 3:
                return PARTNER_SIGNALS;
            default:
                return null;
        }
    }

    public static zzdog zzad() {
        return zzce.zzei;
    }

    private zzcc(int i) {
        this.value = i;
    }

    static {
        zzeg = new zzcd();
    }
}
