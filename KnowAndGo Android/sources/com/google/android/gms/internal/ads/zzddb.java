package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

final class zzddb extends zzdbt<zzdbq, zzdfx, zzdgh> {
    public zzddb() {
        super(zzdbq.class, zzdfx.class, zzdgh.class, "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
    }

    public final int getVersion() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzd(zzdpk zzdpk) throws GeneralSecurityException {
    }

    /* access modifiers changed from: protected */
    public final zzdgr.zzb zzans() {
        return zzdgr.zzb.ASYMMETRIC_PUBLIC;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzt(zzdmr zzdmr) throws zzdok {
        return zzdgh.zzbj(zzdmr);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdpk zzs(zzdmr zzdmr) throws zzdok {
        return zzdfx.zzbc(zzdmr);
    }

    public final /* synthetic */ zzdpk zzg(zzdpk zzdpk) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zze(zzdpk zzdpk) throws GeneralSecurityException {
        zzdfx zzdfx = (zzdfx) zzdpk;
        zzdft zzaqn = zzdfx.zzaqn();
        zzdfz zzaqp = zzaqn.zzaqp();
        return new zzdkc(zzdkr.zza(zzddi.zza(zzaqp.zzara()), zzdfx.zzaqf().toByteArray(), zzdfx.zzaqg().toByteArray()), zzaqp.zzarb().toByteArray(), zzddi.zza(zzaqp.zzaoo()), zzddi.zza(zzaqn.zzaqr()), new zzddk(zzaqn.zzaqq().zzaqk()));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zzc(zzdpk zzdpk) throws GeneralSecurityException {
        zzdfx zzdfx = (zzdfx) zzdpk;
        zzdlx.zzu(zzdfx.getVersion(), 0);
        zzddi.zza(zzdfx.zzaqn());
    }
}
