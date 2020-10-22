package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.bs */
public final class C2022bs extends C2050i implements C2024bu {
    C2022bs(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
    }

    /* renamed from: a */
    public final void mo33579a(String str, int i, Bundle bundle, C2026bw bwVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        a.writeInt(i);
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m777a(a, (IInterface) bwVar);
        mo33634a(4, a);
    }

    /* renamed from: a */
    public final void mo33580a(String str, int i, C2026bw bwVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        a.writeInt(i);
        C2052k.m777a(a, (IInterface) bwVar);
        mo33634a(5, a);
    }

    /* renamed from: a */
    public final void mo33581a(String str, C2026bw bwVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        C2052k.m777a(a, (IInterface) bwVar);
        mo33634a(6, a);
    }

    /* renamed from: a */
    public final void mo33582a(String str, List<Bundle> list, Bundle bundle, C2026bw bwVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        a.writeTypedList(list);
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m777a(a, (IInterface) bwVar);
        mo33634a(2, a);
    }

    /* renamed from: b */
    public final void mo33583b(String str, List<Bundle> list, Bundle bundle, C2026bw bwVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        a.writeTypedList(list);
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m777a(a, (IInterface) bwVar);
        mo33634a(7, a);
    }

    /* renamed from: c */
    public final void mo33584c(String str, List<Bundle> list, Bundle bundle, C2026bw bwVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        a.writeTypedList(list);
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m777a(a, (IInterface) bwVar);
        mo33634a(8, a);
    }

    /* renamed from: d */
    public final void mo33585d(String str, List<Bundle> list, Bundle bundle, C2026bw bwVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        a.writeTypedList(list);
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m777a(a, (IInterface) bwVar);
        mo33634a(13, a);
    }

    /* renamed from: e */
    public final void mo33586e(String str, List<Bundle> list, Bundle bundle, C2026bw bwVar) throws RemoteException {
        Parcel a = mo33633a();
        a.writeString(str);
        a.writeTypedList(list);
        C2052k.m778a(a, (Parcelable) bundle);
        C2052k.m777a(a, (IInterface) bwVar);
        mo33634a(14, a);
    }
}
