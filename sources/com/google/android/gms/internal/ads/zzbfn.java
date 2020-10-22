package com.google.android.gms.internal.ads;

@zzard
final class zzbfn extends zzay {
    static final zzbfn zzeho = new zzbfn();

    zzbfn() {
    }

    public final zzbd zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzbf();
        }
        if ("mvhd".equals(str)) {
            return new zzbg();
        }
        return new zzbh(str);
    }
}
