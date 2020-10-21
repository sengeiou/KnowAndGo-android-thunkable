package com.google.android.gms.internal.ads;

final /* synthetic */ class zzavm implements zzavv {
    static final zzavv zzdst = new zzavm();

    private zzavm() {
    }

    public final Object zzb(zzbjf zzbjf) {
        String currentScreenName = zzbjf.getCurrentScreenName();
        if (currentScreenName != null) {
            return currentScreenName;
        }
        String currentScreenClass = zzbjf.getCurrentScreenClass();
        return currentScreenClass != null ? currentScreenClass : "";
    }
}
