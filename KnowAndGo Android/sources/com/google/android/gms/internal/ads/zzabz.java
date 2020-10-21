package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

@zzard
public final class zzabz extends zzaap {
    private final OnAdMetadataChangedListener zzcke;

    public zzabz(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzcke = onAdMetadataChangedListener;
    }

    public final void onAdMetadataChanged() throws RemoteException {
        if (this.zzcke != null) {
            this.zzcke.onAdMetadataChanged();
        }
    }
}
