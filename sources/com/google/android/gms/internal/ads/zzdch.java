package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import com.google.android.gms.internal.ads.zzdha;
import com.google.android.gms.internal.ads.zzdhc;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

final class zzdch {
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    public static zzdhc zzc(zzdha zzdha) {
        zzdhc.zza zzev = zzdhc.zzass().zzev(zzdha.zzash());
        for (zzdha.zzb next : zzdha.zzasi()) {
            zzev.zzb((zzdhc.zzb) ((zzdob) zzdhc.zzb.zzasu().zzgq(next.zzasn().zzart()).zzc(next.zzaso()).zzc(next.zzanw()).zzew(next.zzasp()).zzaya()));
        }
        return (zzdhc) ((zzdob) zzev.zzaya());
    }

    public static void zzd(zzdha zzdha) throws GeneralSecurityException {
        int zzash = zzdha.zzash();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzdha.zzb next : zzdha.zzasi()) {
            if (next.zzaso() != zzdgu.DESTROYED) {
                i++;
                if (!next.zzasm()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(next.zzasp())}));
                } else if (next.zzanw() == zzdhm.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(next.zzasp())}));
                } else if (next.zzaso() != zzdgu.UNKNOWN_STATUS) {
                    if (next.zzaso() == zzdgu.ENABLED && next.zzasp() == zzash) {
                        if (!z) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    if (next.zzasn().zzarv() != zzdgr.zzb.ASYMMETRIC_PUBLIC) {
                        z2 = false;
                    }
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(next.zzasp())}));
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("empty keyset");
        } else if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }

    public static byte[] zzg(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
