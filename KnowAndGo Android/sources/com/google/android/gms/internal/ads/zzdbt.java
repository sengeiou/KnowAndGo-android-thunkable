package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import com.google.android.gms.internal.ads.zzdpk;
import java.security.GeneralSecurityException;

public abstract class zzdbt<P, KeyProto extends zzdpk, KeyFormatProto extends zzdpk> implements zzdbs<P> {
    private final Class<P> zzgpd;
    private final Class<KeyProto> zzgpe;
    private final Class<KeyFormatProto> zzgpf;
    private final String zzgpg;

    protected zzdbt(Class<P> cls, Class<KeyProto> cls2, Class<KeyFormatProto> cls3, String str) {
        this.zzgpd = cls;
        this.zzgpe = cls2;
        this.zzgpf = cls3;
        this.zzgpg = str;
    }

    /* access modifiers changed from: protected */
    public abstract zzdgr.zzb zzans();

    /* access modifiers changed from: protected */
    public abstract void zzc(KeyProto keyproto) throws GeneralSecurityException;

    /* access modifiers changed from: protected */
    public abstract void zzd(KeyFormatProto keyformatproto) throws GeneralSecurityException;

    /* access modifiers changed from: protected */
    public abstract P zze(KeyProto keyproto) throws GeneralSecurityException;

    /* access modifiers changed from: protected */
    public abstract KeyProto zzg(KeyFormatProto keyformatproto) throws GeneralSecurityException;

    /* access modifiers changed from: protected */
    public abstract KeyProto zzs(zzdmr zzdmr) throws zzdok;

    /* access modifiers changed from: protected */
    public abstract KeyFormatProto zzt(zzdmr zzdmr) throws zzdok;

    private static <Casted> Casted zza(Object obj, String str, Class<Casted> cls) throws GeneralSecurityException {
        if (cls.isInstance(obj)) {
            return obj;
        }
        throw new GeneralSecurityException(str);
    }

    public final P zzp(zzdmr zzdmr) throws GeneralSecurityException {
        try {
            return zzf(zzs(zzdmr));
        } catch (zzdok e) {
            String valueOf = String.valueOf(this.zzgpe.getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    public final P zza(zzdpk zzdpk) throws GeneralSecurityException {
        String valueOf = String.valueOf(this.zzgpe.getName());
        return zzf((zzdpk) zza(zzdpk, valueOf.length() != 0 ? "Expected proto of type ".concat(valueOf) : new String("Expected proto of type "), this.zzgpe));
    }

    public final zzdpk zzq(zzdmr zzdmr) throws GeneralSecurityException {
        try {
            return zzh(zzt(zzdmr));
        } catch (zzdok e) {
            String valueOf = String.valueOf(this.zzgpf.getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    public final zzdpk zzb(zzdpk zzdpk) throws GeneralSecurityException {
        String valueOf = String.valueOf(this.zzgpf.getName());
        return zzh((zzdpk) zza(zzdpk, valueOf.length() != 0 ? "Expected proto of type ".concat(valueOf) : new String("Expected proto of type "), this.zzgpf));
    }

    public final String getKeyType() {
        return this.zzgpg;
    }

    public final zzdgr zzr(zzdmr zzdmr) throws GeneralSecurityException {
        try {
            return (zzdgr) ((zzdob) zzdgr.zzarw().zzgk(this.zzgpg).zzbo(zzh(zzt(zzdmr)).zzavf()).zzb(zzans()).zzaya());
        } catch (zzdok e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    public final Class<P> zzanr() {
        return this.zzgpd;
    }

    private final P zzf(KeyProto keyproto) throws GeneralSecurityException {
        zzc(keyproto);
        return zze(keyproto);
    }

    private final KeyProto zzh(KeyFormatProto keyformatproto) throws GeneralSecurityException {
        zzd(keyformatproto);
        KeyProto zzg = zzg(keyformatproto);
        zzc(zzg);
        return zzg;
    }
}
