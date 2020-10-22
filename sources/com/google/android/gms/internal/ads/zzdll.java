package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

public final class zzdll implements zzdby {
    private Mac zzhbh;
    private final int zzhbi;
    private final String zzhbj;
    private final Key zzhbk;

    public zzdll(String str, Key key, int i) throws GeneralSecurityException {
        String str2;
        if (i >= 10) {
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1823053428) {
                if (hashCode != 392315118) {
                    if (hashCode == 392317873 && str.equals("HMACSHA512")) {
                        c = 2;
                    }
                } else if (str.equals("HMACSHA256")) {
                    c = 1;
                }
            } else if (str.equals("HMACSHA1")) {
                c = 0;
            }
            switch (c) {
                case 0:
                    if (i > 20) {
                        throw new InvalidAlgorithmParameterException("tag size too big");
                    }
                    break;
                case 1:
                    if (i > 32) {
                        throw new InvalidAlgorithmParameterException("tag size too big");
                    }
                    break;
                case 2:
                    if (i > 64) {
                        throw new InvalidAlgorithmParameterException("tag size too big");
                    }
                    break;
                default:
                    String valueOf = String.valueOf(str);
                    if (valueOf.length() != 0) {
                        str2 = "unknown Hmac algorithm: ".concat(valueOf);
                    } else {
                        str2 = new String("unknown Hmac algorithm: ");
                    }
                    throw new NoSuchAlgorithmException(str2);
            }
            this.zzhbj = str;
            this.zzhbi = i;
            this.zzhbk = key;
            this.zzhbh = zzdkx.zzhaq.zzgt(str);
            this.zzhbh.init(key);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    public final byte[] zzk(byte[] bArr) throws GeneralSecurityException {
        Mac mac;
        try {
            mac = (Mac) this.zzhbh.clone();
        } catch (CloneNotSupportedException unused) {
            mac = zzdkx.zzhaq.zzgt(this.zzhbj);
            mac.init(this.zzhbk);
        }
        mac.update(bArr);
        byte[] bArr2 = new byte[this.zzhbi];
        System.arraycopy(mac.doFinal(), 0, bArr2, 0, this.zzhbi);
        return bArr2;
    }
}
