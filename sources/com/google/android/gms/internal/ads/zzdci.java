package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzdci implements zzdbk<zzdbj> {
    public final zzdbs<zzdbj> zzb(String str, String str2, int i) throws GeneralSecurityException {
        zzdbs<zzdbj> zzdbs;
        String lowerCase = str2.toLowerCase();
        char c = 65535;
        if (((lowerCase.hashCode() == 2989895 && lowerCase.equals("aead")) ? (char) 0 : 65535) == 0) {
            switch (str.hashCode()) {
                case 245054116:
                    if (str.equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
                        c = 6;
                        break;
                    }
                    break;
                case 360753376:
                    if (str.equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1215885937:
                    if (str.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1469984853:
                    if (str.equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1797113348:
                    if (str.equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1855890991:
                    if (str.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
                        c = 2;
                        break;
                    }
                    break;
                case 2079211877:
                    if (str.equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    zzdbs = new zzdcm();
                    break;
                case 1:
                    zzdbs = new zzdco();
                    break;
                case 2:
                    zzdbs = new zzdcp();
                    break;
                case 3:
                    zzdbs = new zzdcq();
                    break;
                case 4:
                    zzdbs = new zzdcr();
                    break;
                case 5:
                    zzdbs = new zzdct();
                    break;
                case 6:
                    zzdbs = new zzdcu();
                    break;
                default:
                    throw new GeneralSecurityException(String.format("No support for primitive 'Aead' with key type '%s'.", new Object[]{str}));
            }
            if (zzdbs.getVersion() >= i) {
                return zzdbs;
            }
            throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
        }
        throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[]{str2}));
    }

    public final zzdcc<zzdbj> zzanp() {
        return new zzdck();
    }
}
