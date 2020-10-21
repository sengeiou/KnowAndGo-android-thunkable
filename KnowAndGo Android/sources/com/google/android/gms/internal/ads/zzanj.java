package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzanj extends zzaas {
    private final Object lock = new Object();
    private volatile zzaau zzdfz;

    public final void play() throws RemoteException {
        throw new RemoteException();
    }

    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    public final void mute(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    public final boolean isMuted() throws RemoteException {
        throw new RemoteException();
    }

    public final int getPlaybackState() throws RemoteException {
        throw new RemoteException();
    }

    public final float zzpv() throws RemoteException {
        throw new RemoteException();
    }

    public final float zzpw() throws RemoteException {
        throw new RemoteException();
    }

    public final void zza(zzaau zzaau) throws RemoteException {
        synchronized (this.lock) {
            this.zzdfz = zzaau;
        }
    }

    public final zzaau zzpx() throws RemoteException {
        zzaau zzaau;
        synchronized (this.lock) {
            zzaau = this.zzdfz;
        }
        return zzaau;
    }

    public final float getAspectRatio() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean isCustomControlsEnabled() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean isClickToExpandEnabled() throws RemoteException {
        throw new RemoteException();
    }
}
