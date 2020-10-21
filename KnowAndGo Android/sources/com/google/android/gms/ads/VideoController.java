package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaar;
import com.google.android.gms.internal.ads.zzacc;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzbad;
import javax.annotation.concurrent.GuardedBy;

@zzard
public final class VideoController {
    @KeepForSdk
    public static final int PLAYBACK_STATE_ENDED = 3;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PAUSED = 2;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PLAYING = 1;
    @KeepForSdk
    public static final int PLAYBACK_STATE_READY = 5;
    @KeepForSdk
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object lock = new Object();
    @GuardedBy("lock")
    @Nullable
    private zzaar zzaav;
    @GuardedBy("lock")
    @Nullable
    private VideoLifecycleCallbacks zzaaw;

    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    public final void zza(zzaar zzaar) {
        synchronized (this.lock) {
            this.zzaav = zzaar;
            if (this.zzaaw != null) {
                setVideoLifecycleCallbacks(this.zzaaw);
            }
        }
    }

    public final zzaar zzdh() {
        zzaar zzaar;
        synchronized (this.lock) {
            zzaar = this.zzaav;
        }
        return zzaar;
    }

    public final void play() {
        synchronized (this.lock) {
            if (this.zzaav != null) {
                try {
                    this.zzaav.play();
                } catch (RemoteException e) {
                    zzbad.zzc("Unable to call play on video controller.", e);
                }
            }
        }
    }

    public final void pause() {
        synchronized (this.lock) {
            if (this.zzaav != null) {
                try {
                    this.zzaav.pause();
                } catch (RemoteException e) {
                    zzbad.zzc("Unable to call pause on video controller.", e);
                }
            }
        }
    }

    public final void mute(boolean z) {
        synchronized (this.lock) {
            if (this.zzaav != null) {
                try {
                    this.zzaav.mute(z);
                } catch (RemoteException e) {
                    zzbad.zzc("Unable to call mute on video controller.", e);
                }
            }
        }
    }

    public final boolean isMuted() {
        synchronized (this.lock) {
            if (this.zzaav == null) {
                return true;
            }
            try {
                boolean isMuted = this.zzaav.isMuted();
                return isMuted;
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call isMuted on video controller.", e);
                return true;
            }
        }
    }

    @KeepForSdk
    public final int getPlaybackState() {
        synchronized (this.lock) {
            if (this.zzaav == null) {
                return 0;
            }
            try {
                int playbackState = this.zzaav.getPlaybackState();
                return playbackState;
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call getPlaybackState on video controller.", e);
                return 0;
            }
        }
    }

    public final boolean isCustomControlsEnabled() {
        synchronized (this.lock) {
            if (this.zzaav == null) {
                return false;
            }
            try {
                boolean isCustomControlsEnabled = this.zzaav.isCustomControlsEnabled();
                return isCustomControlsEnabled;
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call isUsingCustomPlayerControls.", e);
                return false;
            }
        }
    }

    public final boolean isClickToExpandEnabled() {
        synchronized (this.lock) {
            if (this.zzaav == null) {
                return false;
            }
            try {
                boolean isClickToExpandEnabled = this.zzaav.isClickToExpandEnabled();
                return isClickToExpandEnabled;
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call isClickToExpandEnabled.", e);
                return false;
            }
        }
    }

    public final void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        Preconditions.checkNotNull(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.lock) {
            this.zzaaw = videoLifecycleCallbacks;
            if (this.zzaav != null) {
                try {
                    this.zzaav.zza(new zzacc(videoLifecycleCallbacks));
                } catch (RemoteException e) {
                    zzbad.zzc("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                }
            }
        }
    }

    @Nullable
    public final VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.lock) {
            videoLifecycleCallbacks = this.zzaaw;
        }
        return videoLifecycleCallbacks;
    }

    public final boolean hasVideoContent() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzaav != null;
        }
        return z;
    }

    public final float getAspectRatio() {
        synchronized (this.lock) {
            if (this.zzaav == null) {
                return 0.0f;
            }
            try {
                float aspectRatio = this.zzaav.getAspectRatio();
                return aspectRatio;
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call getAspectRatio on video controller.", e);
                return 0.0f;
            }
        }
    }
}
