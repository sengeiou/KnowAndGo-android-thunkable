package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.q */
public final class C2058q extends C2050i implements C2060s {
    C2058q(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
    }

    /* renamed from: a */
    public final void mo33640a(String str, Bundle bundle, Bundle bundle2, C2062u uVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m778a(a, (Parcelable) bundle2);
        C2052k.m777a(a, (IInterface) uVar);
        mo33634a(6, a);
    }

    /* renamed from: a */
    public final void mo33641a(String str, Bundle bundle, C2062u uVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m777a(a, (IInterface) uVar);
        mo33634a(5, a);
    }

    /* renamed from: a */
    public final void mo33642a(String str, List<Bundle> list, Bundle bundle, C2062u uVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        a.writeTypedList(list);
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m777a(a, (IInterface) uVar);
        mo33634a(2, a);
    }

    /* renamed from: b */
    public final void mo33643b(String str, Bundle bundle, Bundle bundle2, C2062u uVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m778a(a, (Parcelable) bundle2);
        C2052k.m777a(a, (IInterface) uVar);
        mo33634a(7, a);
    }

    /* renamed from: b */
    public final void mo33644b(String str, Bundle bundle, C2062u uVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m777a(a, (IInterface) uVar);
        mo33634a(10, a);
    }

    /* renamed from: b */
    public final void mo33645b(String str, List<Bundle> list, Bundle bundle, C2062u uVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        a.writeTypedList(list);
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m777a(a, (IInterface) uVar);
        mo33634a(14, a);
    }

    /* renamed from: c */
    public final void mo33646c(String str, Bundle bundle, Bundle bundle2, C2062u uVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m778a(a, (Parcelable) bundle2);
        C2052k.m777a(a, (IInterface) uVar);
        mo33634a(9, a);
    }

    /* renamed from: c */
    public final void mo33647c(String str, List<Bundle> list, Bundle bundle, C2062u uVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        a.writeTypedList(list);
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m777a(a, (IInterface) uVar);
        mo33634a(12, a);
    }

    /* renamed from: d */
    public final void mo33648d(String str, Bundle bundle, Bundle bundle2, C2062u uVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m778a(a, (Parcelable) bundle2);
        C2052k.m777a(a, (IInterface) uVar);
        mo33634a(11, a);
    }

    /* renamed from: e */
    public final void mo33649e(String str, Bundle bundle, Bundle bundle2, C2062u uVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m778a(a, (Parcelable) bundle2);
        C2052k.m777a(a, (IInterface) uVar);
        mo33634a(13, a);
    }
}
