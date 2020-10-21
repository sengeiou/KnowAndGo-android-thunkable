package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
public final class zzatj implements RewardedVideoAd {
    private final Object lock = new Object();
    @NonNull
    private final zzasw zzdqq;
    private final zzatg zzdqr = new zzatg((RewardedVideoAdListener) null);
    private String zzdqs;
    private String zzdqt;
    private final Context zzlj;

    public zzatj(Context context, @Nullable zzasw zzasw) {
        this.zzdqq = zzasw == null ? new zzabx() : zzasw;
        this.zzlj = context.getApplicationContext();
    }

    private final void zza(String str, zzaaz zzaaz) {
        synchronized (this.lock) {
            if (this.zzdqq != null) {
                try {
                    this.zzdqq.zza(new zzath(zzyc.zza(this.zzlj, zzaaz), str));
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void loadAd(String str, AdRequest adRequest) {
        zza(str, adRequest.zzde());
    }

    public final void loadAd(String str, PublisherAdRequest publisherAdRequest) {
        zza(str, publisherAdRequest.zzde());
    }

    public final void show() {
        synchronized (this.lock) {
            if (this.zzdqq != null) {
                try {
                    this.zzdqq.show();
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.lock) {
            this.zzdqr.setRewardedVideoAdListener(rewardedVideoAdListener);
            if (this.zzdqq != null) {
                try {
                    this.zzdqq.zza((zzatb) this.zzdqr);
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        synchronized (this.lock) {
            if (this.zzdqq != null) {
                try {
                    this.zzdqq.zza((zzzp) new zzxy(adMetadataListener));
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final Bundle getAdMetadata() {
        synchronized (this.lock) {
            if (this.zzdqq != null) {
                try {
                    Bundle adMetadata = this.zzdqq.getAdMetadata();
                    return adMetadata;
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
            Bundle bundle = new Bundle();
            return bundle;
        }
    }

    public final void setUserId(String str) {
        synchronized (this.lock) {
            this.zzdqs = str;
            if (this.zzdqq != null) {
                try {
                    this.zzdqq.setUserId(str);
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final boolean isLoaded() {
        synchronized (this.lock) {
            if (this.zzdqq == null) {
                return false;
            }
            try {
                boolean isLoaded = this.zzdqq.isLoaded();
                return isLoaded;
            } catch (RemoteException e) {
                zzbad.zze("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    public final void pause() {
        pause((Context) null);
    }

    public final void pause(Context context) {
        synchronized (this.lock) {
            if (this.zzdqq != null) {
                try {
                    this.zzdqq.zzl(ObjectWrapper.wrap(context));
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void resume() {
        resume((Context) null);
    }

    public final void resume(Context context) {
        synchronized (this.lock) {
            if (this.zzdqq != null) {
                try {
                    this.zzdqq.zzm(ObjectWrapper.wrap(context));
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void destroy() {
        destroy((Context) null);
    }

    public final void destroy(Context context) {
        synchronized (this.lock) {
            this.zzdqr.setRewardedVideoAdListener((RewardedVideoAdListener) null);
            if (this.zzdqq != null) {
                try {
                    this.zzdqq.zzn(ObjectWrapper.wrap(context));
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.lock) {
            rewardedVideoAdListener = this.zzdqr.getRewardedVideoAdListener();
        }
        return rewardedVideoAdListener;
    }

    public final String getUserId() {
        String str;
        synchronized (this.lock) {
            str = this.zzdqs;
        }
        return str;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzdqq != null) {
                return this.zzdqq.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final void setImmersiveMode(boolean z) {
        synchronized (this.lock) {
            if (this.zzdqq != null) {
                try {
                    this.zzdqq.setImmersiveMode(z);
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setCustomData(String str) {
        synchronized (this.lock) {
            if (this.zzdqq != null) {
                try {
                    this.zzdqq.setCustomData(str);
                    this.zzdqt = str;
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final String getCustomData() {
        String str;
        synchronized (this.lock) {
            str = this.zzdqt;
        }
        return str;
    }
}
