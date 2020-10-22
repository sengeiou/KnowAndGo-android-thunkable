package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import com.google.android.exoplayer2.C1470C;

@zzard
public final class zzbim extends MutableContextWrapper {
    private Activity zzdyk;
    private Context zzemj;
    private Context zzys;

    public zzbim(Context context) {
        super(context);
        setBaseContext(context);
    }

    public final void setBaseContext(Context context) {
        this.zzys = context.getApplicationContext();
        this.zzdyk = context instanceof Activity ? (Activity) context : null;
        this.zzemj = context;
        super.setBaseContext(this.zzys);
    }

    public final void startActivity(Intent intent) {
        if (this.zzdyk != null) {
            this.zzdyk.startActivity(intent);
            return;
        }
        intent.setFlags(C1470C.ENCODING_PCM_MU_LAW);
        this.zzys.startActivity(intent);
    }

    public final Activity zzyd() {
        return this.zzdyk;
    }

    public final Object getSystemService(String str) {
        return this.zzemj.getSystemService(str);
    }

    public final Context zzaad() {
        return this.zzemj;
    }
}
