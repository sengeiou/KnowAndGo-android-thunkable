package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzea;
import java.util.HashMap;
import java.util.Map;

final class zzeb extends zzea.zzb {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzads;
    private final /* synthetic */ String zzadt;
    private final /* synthetic */ Bundle zzadu;
    private final /* synthetic */ zzea zzadv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeb(zzea zzea, Context context, String str, String str2, Bundle bundle) {
        super(zzea);
        this.zzadv = zzea;
        this.val$context = context;
        this.zzads = str;
        this.zzadt = str2;
        this.zzadu = bundle;
    }

    public final void zzgd() {
        String str;
        String str2;
        String str3;
        try {
            Map unused = this.zzadv.zzadn = new HashMap();
            zzdn unused2 = this.zzadv.zzadr = this.zzadv.zzg(this.val$context);
            if (this.zzadv.zzadr == null) {
                Log.w(this.zzadv.zzadh, "Failed to connect to measurement client.");
                return;
            }
            if (zzea.zze(this.zzads, this.zzadt)) {
                String str4 = this.zzadt;
                str2 = this.zzads;
                str = str4;
                str3 = this.zzadv.zzadh;
            } else {
                str3 = null;
                str2 = null;
                str = null;
            }
            int zzj = zzea.zzi(this.val$context);
            int zzk = zzea.zzh(this.val$context);
            this.zzadv.zzadr.initialize(ObjectWrapper.wrap(this.val$context), new zzdy(13001, (long) Math.max(zzj, zzk), zzk < zzj, str3, str2, str, this.zzadu), this.timestamp);
        } catch (RemoteException e) {
            this.zzadv.zza((Exception) e, true, false);
        }
    }
}
