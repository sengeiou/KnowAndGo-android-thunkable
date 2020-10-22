package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

public final class zzdlo {
    private static final ThreadLocal<SecureRandom> zzhbl = new zzdlp();

    /* access modifiers changed from: private */
    public static SecureRandom zzavb() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] zzff(int i) {
        byte[] bArr = new byte[i];
        zzhbl.get().nextBytes(bArr);
        return bArr;
    }
}
