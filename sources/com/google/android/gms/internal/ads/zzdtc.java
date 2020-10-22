package com.google.android.gms.internal.ads;

public abstract class zzdtc {
    public abstract void zzhc(String str);

    public static zzdtc zzm(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new zzdsx(cls.getSimpleName());
        }
        return new zzdsz(cls.getSimpleName());
    }
}
