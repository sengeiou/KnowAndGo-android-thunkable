package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import com.google.android.exoplayer2.util.MimeTypes;

@TargetApi(14)
@zzard
public final class zzbdi implements AudioManager.OnAudioFocusChangeListener {
    private float zzcv = 1.0f;
    private boolean zzebz;
    private final AudioManager zzeey;
    private final zzbdj zzeez;
    private boolean zzefa;
    private boolean zzefb;

    public zzbdi(Context context, zzbdj zzbdj) {
        this.zzeey = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.zzeez = zzbdj;
    }

    public final void setMuted(boolean z) {
        this.zzefb = z;
        zzyo();
    }

    public final void setVolume(float f) {
        this.zzcv = f;
        zzyo();
    }

    public final float getVolume() {
        float f = this.zzefb ? 0.0f : this.zzcv;
        if (this.zzefa) {
            return f;
        }
        return 0.0f;
    }

    public final void zzyl() {
        this.zzebz = true;
        zzyo();
    }

    public final void zzym() {
        this.zzebz = false;
        zzyo();
    }

    public final void onAudioFocusChange(int i) {
        this.zzefa = i > 0;
        this.zzeez.zzxk();
    }

    private final void zzyo() {
        boolean z = false;
        boolean z2 = this.zzebz && !this.zzefb && this.zzcv > 0.0f;
        if (z2 && !this.zzefa) {
            if (this.zzeey != null && !this.zzefa) {
                if (this.zzeey.requestAudioFocus(this, 3, 2) == 1) {
                    z = true;
                }
                this.zzefa = z;
            }
            this.zzeez.zzxk();
        } else if (!z2 && this.zzefa) {
            if (this.zzeey != null && this.zzefa) {
                if (this.zzeey.abandonAudioFocus(this) == 0) {
                    z = true;
                }
                this.zzefa = z;
            }
            this.zzeez.zzxk();
        }
    }
}
