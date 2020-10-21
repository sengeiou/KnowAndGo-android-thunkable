package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzang extends IInterface {
    String getAdvertiser() throws RemoteException;

    String getBody() throws RemoteException;

    String getCallToAction() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    String getHeadline() throws RemoteException;

    List getImages() throws RemoteException;

    boolean getOverrideClickHandling() throws RemoteException;

    boolean getOverrideImpressionRecording() throws RemoteException;

    String getPrice() throws RemoteException;

    double getStarRating() throws RemoteException;

    String getStore() throws RemoteException;

    zzaar getVideoController() throws RemoteException;

    void recordImpression() throws RemoteException;

    void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    zzaei zzri() throws RemoteException;

    zzaea zzrj() throws RemoteException;

    IObjectWrapper zzrk() throws RemoteException;

    IObjectWrapper zzso() throws RemoteException;

    IObjectWrapper zzsp() throws RemoteException;

    float zzsq() throws RemoteException;

    void zzt(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzv(IObjectWrapper iObjectWrapper) throws RemoteException;
}
