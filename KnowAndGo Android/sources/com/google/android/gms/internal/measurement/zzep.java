package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzea;

final class zzep extends zzea.zzb {
    private final /* synthetic */ zzea zzadv;
    private final /* synthetic */ int zzaeh = 5;
    private final /* synthetic */ String zzaei;
    private final /* synthetic */ Object zzaej;
    private final /* synthetic */ Object zzaek;
    private final /* synthetic */ Object zzael;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzep(zzea zzea, boolean z, int i, String str, Object obj, Object obj2, Object obj3) {
        super(false);
        this.zzadv = zzea;
        this.zzaei = str;
        this.zzaej = obj;
        this.zzaek = obj2;
        this.zzael = obj3;
    }

    /* access modifiers changed from: package-private */
    public final void zzgd() throws RemoteException {
        this.zzadv.zzadr.logHealthData(this.zzaeh, this.zzaei, ObjectWrapper.wrap(this.zzaej), ObjectWrapper.wrap(this.zzaek), ObjectWrapper.wrap(this.zzael));
    }
}
