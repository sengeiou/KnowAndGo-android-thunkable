package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import javax.annotation.Nonnull;

abstract class zzys<T> {
    @Nullable
    private static final zzzv zzcic = zzox();

    zzys() {
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract T zza(zzzv zzzv) throws RemoteException;

    /* access modifiers changed from: protected */
    @Nonnull
    public abstract T zzov();

    /* access modifiers changed from: protected */
    @Nullable
    public abstract T zzow() throws RemoteException;

    private static zzzv zzox() {
        try {
            Object newInstance = zzyh.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi2").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzbad.zzep("ClientApi class is not an instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            if (queryLocalInterface instanceof zzzv) {
                return (zzzv) queryLocalInterface;
            }
            return new zzzx(iBinder);
        } catch (Exception unused) {
            zzbad.zzep("Failed to instantiate ClientApi class.");
            return null;
        }
    }

    @Nullable
    private final T zzoy() {
        if (zzcic == null) {
            zzbad.zzep("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return zza(zzcic);
        } catch (RemoteException e) {
            zzbad.zzd("Cannot invoke local loader using ClientApi class.", e);
            return null;
        }
    }

    @Nullable
    private final T zzoz() {
        try {
            return zzow();
        } catch (RemoteException e) {
            zzbad.zzd("Cannot invoke remote loader.", e);
            return null;
        }
    }

    public final T zzd(Context context, boolean z) {
        T t;
        boolean z2 = true;
        if (!z) {
            zzyt.zzpa();
            if (!zzazt.zzc(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                zzbad.zzdp("Google Play Services is not available.");
                z = true;
            }
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) > DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID)) {
            z = true;
        }
        zzacu.initialize(context);
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcur)).booleanValue()) {
            z = false;
        }
        if (z) {
            t = zzoy();
            if (t == null) {
                t = zzoz();
            }
        } else {
            T zzoz = zzoz();
            int i = zzoz == null ? 1 : 0;
            if (i != 0) {
                if (zzyt.zzph().nextInt(((Integer) zzyt.zzpe().zzd(zzacu.zzcwr)).intValue()) != 0) {
                    z2 = false;
                }
                if (z2) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", i);
                    zzyt.zzpa().zza(context, zzyt.zzpg().zzbsx, "gmob-apps", bundle, true);
                }
            }
            t = zzoz == null ? zzoy() : zzoz;
        }
        return t == null ? zzov() : t;
    }
}
