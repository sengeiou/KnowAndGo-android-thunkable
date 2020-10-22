package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@zzard
public final class zzami extends zzbjg {
    private static final AtomicBoolean zzded = new AtomicBoolean(false);
    private final AppMeasurementSdk zzdee;

    private zzami(AppMeasurementSdk appMeasurementSdk) {
        this.zzdee = appMeasurementSdk;
    }

    public static void initialize(Context context, String str) {
        if (zzded.compareAndSet(false, true)) {
            new Thread(new zzamj(context, str)).start();
        }
    }

    public final void performAction(Bundle bundle) throws RemoteException {
        this.zzdee.performAction(bundle);
    }

    public final Bundle performActionWithResponse(Bundle bundle) throws RemoteException {
        return this.zzdee.performActionWithResponse(bundle);
    }

    public final void logEvent(String str, String str2, Bundle bundle) throws RemoteException {
        this.zzdee.logEvent(str, str2, bundle);
    }

    public final void zza(String str, String str2, IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzdee.setUserProperty(str, str2, iObjectWrapper != null ? ObjectWrapper.unwrap(iObjectWrapper) : null);
    }

    public final Map getUserProperties(String str, String str2, boolean z) throws RemoteException {
        return this.zzdee.getUserProperties(str, str2, z);
    }

    public final int getMaxUserProperties(String str) throws RemoteException {
        return this.zzdee.getMaxUserProperties(str);
    }

    public final void setConditionalUserProperty(Bundle bundle) throws RemoteException {
        this.zzdee.setConditionalUserProperty(bundle);
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        this.zzdee.clearConditionalUserProperty(str, str2, bundle);
    }

    public final List getConditionalUserProperties(String str, String str2) throws RemoteException {
        return this.zzdee.getConditionalUserProperties(str, str2);
    }

    public final String getAppInstanceId() throws RemoteException {
        return this.zzdee.getAppInstanceId();
    }

    public final String getGmpAppId() throws RemoteException {
        return this.zzdee.getGmpAppId();
    }

    public final long generateEventId() throws RemoteException {
        return this.zzdee.generateEventId();
    }

    public final void beginAdUnitExposure(String str) throws RemoteException {
        this.zzdee.beginAdUnitExposure(str);
    }

    public final void endAdUnitExposure(String str) throws RemoteException {
        this.zzdee.endAdUnitExposure(str);
    }

    public final void zzb(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        this.zzdee.setCurrentScreen(iObjectWrapper != null ? (Activity) ObjectWrapper.unwrap(iObjectWrapper) : null, str, str2);
    }

    public final String getCurrentScreenName() throws RemoteException {
        return this.zzdee.getCurrentScreenName();
    }

    public final String getCurrentScreenClass() throws RemoteException {
        return this.zzdee.getCurrentScreenClass();
    }

    public final String getAppIdOrigin() throws RemoteException {
        return this.zzdee.getAppIdOrigin();
    }

    static final /* synthetic */ void zzc(Context context, String str) {
        boolean z;
        zzacu.initialize(context);
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcoa)).booleanValue()) {
            if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcnz)).booleanValue()) {
                z = false;
                Bundle bundle = new Bundle();
                bundle.putBoolean("measurementEnabled", z);
                ((zzbjh) zzbae.zza(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", zzamk.zzbzd)).zzc(new zzami(AppMeasurementSdk.getInstance(context, AdRequest.LOGTAG, "am", str, bundle)));
            }
        }
        z = true;
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("measurementEnabled", z);
        try {
            ((zzbjh) zzbae.zza(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", zzamk.zzbzd)).zzc(new zzami(AppMeasurementSdk.getInstance(context, AdRequest.LOGTAG, "am", str, bundle2)));
        } catch (RemoteException | zzbag | NullPointerException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }
}
