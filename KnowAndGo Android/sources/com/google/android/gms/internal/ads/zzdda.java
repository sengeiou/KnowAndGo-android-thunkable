package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

final class zzdda extends zzdbt<zzdbp, zzdfv, zzdfr> implements zzdbs<zzdbp> {
    public zzdda() {
        super(zzdbp.class, zzdfv.class, zzdfr.class, "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
    }

    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final zzdgr.zzb zzans() {
        return zzdgr.zzb.ASYMMETRIC_PRIVATE;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzt(zzdmr zzdmr) throws zzdok {
        return zzdfr.zzaz(zzdmr);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzs(zzdmr zzdmr) throws zzdok {
        return zzdfv.zzba(zzdmr);
    }

    public final /* synthetic */ zzdpk zzg(zzdpk zzdpk) throws GeneralSecurityException {
        zzdfr zzdfr = (zzdfr) zzdpk;
        KeyPair zza = zzdkr.zza(zzdkr.zza(zzddi.zza(zzdfr.zzaqn().zzaqp().zzara())));
        ECPoint w = ((ECPublicKey) zza.getPublic()).getW();
        return (zzdfv) ((zzdob) zzdfv.zzaqv().zzeg(0).zzb((zzdfx) ((zzdob) zzdfx.zzaqx().zzeh(0).zzc(zzdfr.zzaqn()).zzbd(zzdmr.zzz(w.getAffineX().toByteArray())).zzbe(zzdmr.zzz(w.getAffineY().toByteArray())).zzaya())).zzbb(zzdmr.zzz(((ECPrivateKey) zza.getPrivate()).getS().toByteArray())).zzaya());
    }

    public final /* synthetic */ Object zze(zzdpk zzdpk) throws GeneralSecurityException {
        zzdfv zzdfv = (zzdfv) zzdpk;
        zzdft zzaqn = zzdfv.zzaqu().zzaqn();
        zzdfz zzaqp = zzaqn.zzaqp();
        return new zzdkb(zzdkr.zza(zzddi.zza(zzaqp.zzara()), zzdfv.zzaoi().toByteArray()), zzaqp.zzarb().toByteArray(), zzddi.zza(zzaqp.zzaoo()), zzddi.zza(zzaqn.zzaqr()), new zzddk(zzaqn.zzaqq().zzaqk()));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzd(zzdpk zzdpk) throws GeneralSecurityException {
        zzddi.zza(((zzdfr) zzdpk).zzaqn());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdpk zzdpk) throws GeneralSecurityException {
        zzdfv zzdfv = (zzdfv) zzdpk;
        zzdlx.zzu(zzdfv.getVersion(), 0);
        zzddi.zza(zzdfv.zzaqu().zzaqn());
    }
}
