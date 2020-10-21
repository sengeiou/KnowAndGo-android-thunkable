package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdky;
import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

public final class zzdkx<T_WRAPPER extends zzdky<T_ENGINE>, T_ENGINE> {
    private static final Logger logger = Logger.getLogger(zzdkx.class.getName());
    private static final List<Provider> zzhao;
    public static final zzdkx<zzdkz, Cipher> zzhap = new zzdkx<>(new zzdkz());
    public static final zzdkx<zzdld, Mac> zzhaq = new zzdkx<>(new zzdld());
    public static final zzdkx<zzdlf, Signature> zzhar = new zzdkx<>(new zzdlf());
    public static final zzdkx<zzdle, MessageDigest> zzhas = new zzdkx<>(new zzdle());
    public static final zzdkx<zzdla, KeyAgreement> zzhat = new zzdkx<>(new zzdla());
    public static final zzdkx<zzdlc, KeyPairGenerator> zzhau = new zzdkx<>(new zzdlc());
    public static final zzdkx<zzdlb, KeyFactory> zzhav = new zzdkx<>(new zzdlb());
    private T_WRAPPER zzhaw;
    private List<Provider> zzhax = zzhao;
    private boolean zzhay = true;

    private zzdkx(T_WRAPPER t_wrapper) {
        this.zzhaw = t_wrapper;
    }

    public final T_ENGINE zzgt(String str) throws GeneralSecurityException {
        for (Provider next : this.zzhax) {
            if (zza(str, next)) {
                return this.zzhaw.zzb(str, next);
            }
        }
        if (this.zzhay) {
            return this.zzhaw.zzb(str, (Provider) null);
        }
        throw new GeneralSecurityException("No good Provider found.");
    }

    private final boolean zza(String str, Provider provider) {
        try {
            this.zzhaw.zzb(str, provider);
            return true;
        } catch (Exception e) {
            zzdmb.zzg(e);
            return false;
        }
    }

    static {
        if (zzdlv.zzavd()) {
            String[] strArr = {ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    logger.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", new Object[]{str}));
                }
            }
            zzhao = arrayList;
        } else {
            zzhao = new ArrayList();
        }
    }
}
