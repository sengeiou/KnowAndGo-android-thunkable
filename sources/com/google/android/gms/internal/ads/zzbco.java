package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;

@TargetApi(14)
@zzard
public abstract class zzbco extends TextureView implements zzbdj {
    protected final zzbcy zzebr = new zzbcy();
    protected final zzbdi zzebs;

    public zzbco(Context context) {
        super(context);
        this.zzebs = new zzbdi(context, this);
    }

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void pause();

    public abstract void play();

    public abstract void seekTo(int i);

    public abstract void setVideoPath(String str);

    public abstract void stop();

    public abstract void zza(float f, float f2);

    public abstract void zza(zzbcn zzbcn);

    public void zzcy(int i) {
    }

    public void zzcz(int i) {
    }

    public void zzda(int i) {
    }

    public void zzdb(int i) {
    }

    public void zzdc(int i) {
    }

    public abstract String zzxg();

    public abstract void zzxk();

    public void zzb(String str, String[] strArr) {
        setVideoPath(str);
    }
}
