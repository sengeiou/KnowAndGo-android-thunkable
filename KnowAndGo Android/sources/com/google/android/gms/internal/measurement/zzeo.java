package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzea;

final class zzeo extends zzea.zzb {
    private final /* synthetic */ String zzads;
    private final /* synthetic */ zzea zzadv;
    private final /* synthetic */ String zzadz;
    private final /* synthetic */ zzea.zza zzaea;
    private final /* synthetic */ boolean zzaeg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeo(zzea zzea, String str, String str2, boolean z, zzea.zza zza) {
        super(zzea);
        this.zzadv = zzea;
        this.zzads = str;
        this.zzadz = str2;
        this.zzaeg = z;
        this.zzaea = zza;
    }

    /* access modifiers changed from: package-private */
    public final void zzgd() throws RemoteException {
        this.zzadv.zzadr.getUserProperties(this.zzads, this.zzadz, this.zzaeg, this.zzaea);
    }

    /* access modifiers changed from: protected */
    public final void zzge() {
        this.zzaea.zzb((Bundle) null);
    }
}
