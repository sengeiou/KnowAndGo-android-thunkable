package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

public class zzcoj extends zzamw {
    private final zzbso zzfir;
    private final zzbse zzfjg;
    private final zzbsv zzflp;
    private final zzbrt zzfmr;
    private final zzbri zzfms;
    private final zzbtp zzfsr;
    private final zzbvq zzgcm;

    public zzcoj(zzbri zzbri, zzbrt zzbrt, zzbse zzbse, zzbso zzbso, zzbtp zzbtp, zzbsv zzbsv, zzbvq zzbvq) {
        this.zzfms = zzbri;
        this.zzfmr = zzbrt;
        this.zzfjg = zzbse;
        this.zzfir = zzbso;
        this.zzfsr = zzbtp;
        this.zzflp = zzbsv;
        this.zzgcm = zzbvq;
    }

    public final void onAdFailedToLoad(int i) {
    }

    public final void zza(zzafe zzafe, String str) {
    }

    public final void zza(zzamy zzamy) {
    }

    public void zza(zzatq zzatq) throws RemoteException {
    }

    public void zzb(Bundle bundle) throws RemoteException {
    }

    public void zzb(zzato zzato) {
    }

    public void zzcs(int i) throws RemoteException {
    }

    public final void zzcz(String str) {
    }

    public void zzsn() throws RemoteException {
    }

    public final void onAdClicked() {
        this.zzfms.onAdClicked();
    }

    public final void onAdClosed() {
        this.zzflp.zzsz();
    }

    public final void onAdLeftApplication() {
        this.zzfjg.onAdLeftApplication();
    }

    public final void onAdOpened() {
        this.zzflp.zzta();
    }

    public final void onAppEvent(String str, String str2) {
        this.zzfsr.onAppEvent(str, str2);
    }

    public final void onAdLoaded() {
        this.zzfir.onAdLoaded();
    }

    public final void onAdImpression() {
        this.zzfmr.onAdImpression();
    }

    public final void onVideoPause() {
        this.zzgcm.onVideoPause();
    }

    public void zzsm() {
        this.zzgcm.onVideoStart();
    }

    public void onVideoEnd() {
        this.zzgcm.onVideoEnd();
    }

    public final void onVideoPlay() throws RemoteException {
        this.zzgcm.onVideoPlay();
    }
}
