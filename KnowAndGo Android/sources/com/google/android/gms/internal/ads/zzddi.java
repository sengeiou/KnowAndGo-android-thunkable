package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

final class zzddi {
    public static void zza(zzdft zzdft) throws GeneralSecurityException {
        zzdkr.zza(zza(zzdft.zzaqp().zzara()));
        zza(zzdft.zzaqp().zzaoo());
        if (zzdft.zzaqr() != zzdfd.UNKNOWN_FORMAT) {
            zzdcf.zza(zzdft.zzaqq().zzaqk());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static String zza(zzdgj zzdgj) throws NoSuchAlgorithmException {
        switch (zzddj.zzgqb[zzdgj.ordinal()]) {
            case 1:
                return "HmacSha1";
            case 2:
                return "HmacSha256";
            case 3:
                return "HmacSha512";
            default:
                String valueOf = String.valueOf(zzdgj);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
                sb.append("hash unsupported for HMAC: ");
                sb.append(valueOf);
                throw new NoSuchAlgorithmException(sb.toString());
        }
    }

    public static zzdkt zza(zzdgf zzdgf) throws GeneralSecurityException {
        switch (zzddj.zzgqc[zzdgf.ordinal()]) {
            case 1:
                return zzdkt.NIST_P256;
            case 2:
                return zzdkt.NIST_P384;
            case 3:
                return zzdkt.NIST_P521;
            default:
                String valueOf = String.valueOf(zzdgf);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb.append("unknown curve type: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
        }
    }

    public static zzdkv zza(zzdfd zzdfd) throws GeneralSecurityException {
        switch (zzddj.zzgqd[zzdfd.ordinal()]) {
            case 1:
                return zzdkv.UNCOMPRESSED;
            case 2:
                return zzdkv.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
            case 3:
                return zzdkv.COMPRESSED;
            default:
                String valueOf = String.valueOf(zzdfd);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("unknown point format: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
        }
    }
}
