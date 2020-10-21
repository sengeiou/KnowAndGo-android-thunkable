package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.ads.internal.zzk;

public final class zzcsd implements zzcva<zzcsc> {
    private final zzbbl zzfqw;
    private final Context zzlj;

    public zzcsd(zzbbl zzbbl, Context context) {
        this.zzfqw = zzbbl;
        this.zzlj = context;
    }

    public final zzbbh<zzcsc> zzalm() {
        return this.zzfqw.zza(new zzcse(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcsc zzalo() throws Exception {
        AudioManager audioManager = (AudioManager) this.zzlj.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        return new zzcsc(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzk.zzll().zzpq(), zzk.zzll().zzpr());
    }
}
