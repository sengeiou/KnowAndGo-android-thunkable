package com.google.android.gms.internal.ads;

final class zzdph {
    private static final zzdpf zzhjm = zzayy();
    private static final zzdpf zzhjn = new zzdpg();

    static zzdpf zzayw() {
        return zzhjm;
    }

    static zzdpf zzayx() {
        return zzhjn;
    }

    private static zzdpf zzayy() {
        try {
            return (zzdpf) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
