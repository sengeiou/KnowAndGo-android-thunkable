package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzagv;
import com.google.android.gms.internal.ads.zzagx;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzxr;

@SafeParcelable.Class(creator = "AdOverlayInfoCreator")
@SafeParcelable.Reserved({1})
@zzard
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzn();
    @SafeParcelable.Field(mo22648id = 11)
    public final int orientation;
    @SafeParcelable.Field(mo22648id = 13)
    public final String url;
    @SafeParcelable.Field(mo22648id = 14)
    public final zzbai zzbtc;
    @SafeParcelable.Field(getter = "getAdClickListenerAsBinder", mo22648id = 3, type = "android.os.IBinder")
    public final zzxr zzcgi;
    @SafeParcelable.Field(getter = "getAdMetadataGmsgListenerAsBinder", mo22648id = 18, type = "android.os.IBinder")
    public final zzagv zzczo;
    @SafeParcelable.Field(getter = "getAppEventGmsgListenerAsBinder", mo22648id = 6, type = "android.os.IBinder")
    public final zzagx zzczp;
    @SafeParcelable.Field(getter = "getAdWebViewAsBinder", mo22648id = 5, type = "android.os.IBinder")
    public final zzbgz zzdbs;
    @SafeParcelable.Field(mo22648id = 2)
    public final zzc zzdkl;
    @SafeParcelable.Field(getter = "getAdOverlayListenerAsBinder", mo22648id = 4, type = "android.os.IBinder")
    public final zzo zzdkm;
    @SafeParcelable.Field(mo22648id = 7)
    public final String zzdkn;
    @SafeParcelable.Field(mo22648id = 8)
    public final boolean zzdko;
    @SafeParcelable.Field(mo22648id = 9)
    public final String zzdkp;
    @SafeParcelable.Field(getter = "getLeaveApplicationListenerAsBinder", mo22648id = 10, type = "android.os.IBinder")
    public final zzu zzdkq;
    @SafeParcelable.Field(mo22648id = 12)
    public final int zzdkr;
    @SafeParcelable.Field(mo22648id = 16)
    public final String zzdks;
    @SafeParcelable.Field(mo22648id = 17)
    public final zzh zzdkt;

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzc(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    public AdOverlayInfoParcel(zzxr zzxr, zzo zzo, zzu zzu, zzbgz zzbgz, int i, zzbai zzbai, String str, zzh zzh) {
        this.zzdkl = null;
        this.zzcgi = null;
        this.zzdkm = zzo;
        this.zzdbs = zzbgz;
        this.zzczo = null;
        this.zzczp = null;
        this.zzdkn = null;
        this.zzdko = false;
        this.zzdkp = null;
        this.zzdkq = null;
        this.orientation = i;
        this.zzdkr = 1;
        this.url = null;
        this.zzbtc = zzbai;
        this.zzdks = str;
        this.zzdkt = zzh;
    }

    public AdOverlayInfoParcel(zzxr zzxr, zzo zzo, zzu zzu, zzbgz zzbgz, boolean z, int i, zzbai zzbai) {
        this.zzdkl = null;
        this.zzcgi = zzxr;
        this.zzdkm = zzo;
        this.zzdbs = zzbgz;
        this.zzczo = null;
        this.zzczp = null;
        this.zzdkn = null;
        this.zzdko = z;
        this.zzdkp = null;
        this.zzdkq = zzu;
        this.orientation = i;
        this.zzdkr = 2;
        this.url = null;
        this.zzbtc = zzbai;
        this.zzdks = null;
        this.zzdkt = null;
    }

    public AdOverlayInfoParcel(zzxr zzxr, zzo zzo, zzagv zzagv, zzagx zzagx, zzu zzu, zzbgz zzbgz, boolean z, int i, String str, zzbai zzbai) {
        this.zzdkl = null;
        this.zzcgi = zzxr;
        this.zzdkm = zzo;
        this.zzdbs = zzbgz;
        this.zzczo = zzagv;
        this.zzczp = zzagx;
        this.zzdkn = null;
        this.zzdko = z;
        this.zzdkp = null;
        this.zzdkq = zzu;
        this.orientation = i;
        this.zzdkr = 3;
        this.url = str;
        this.zzbtc = zzbai;
        this.zzdks = null;
        this.zzdkt = null;
    }

    public AdOverlayInfoParcel(zzxr zzxr, zzo zzo, zzagv zzagv, zzagx zzagx, zzu zzu, zzbgz zzbgz, boolean z, int i, String str, String str2, zzbai zzbai) {
        this.zzdkl = null;
        this.zzcgi = zzxr;
        this.zzdkm = zzo;
        this.zzdbs = zzbgz;
        this.zzczo = zzagv;
        this.zzczp = zzagx;
        this.zzdkn = str2;
        this.zzdko = z;
        this.zzdkp = str;
        this.zzdkq = zzu;
        this.orientation = i;
        this.zzdkr = 3;
        this.url = null;
        this.zzbtc = zzbai;
        this.zzdks = null;
        this.zzdkt = null;
    }

    public AdOverlayInfoParcel(zzc zzc, zzxr zzxr, zzo zzo, zzu zzu, zzbai zzbai) {
        this.zzdkl = zzc;
        this.zzcgi = zzxr;
        this.zzdkm = zzo;
        this.zzdbs = null;
        this.zzczo = null;
        this.zzczp = null;
        this.zzdkn = null;
        this.zzdko = false;
        this.zzdkp = null;
        this.zzdkq = zzu;
        this.orientation = -1;
        this.zzdkr = 4;
        this.url = null;
        this.zzbtc = zzbai;
        this.zzdks = null;
        this.zzdkt = null;
    }

    @SafeParcelable.Constructor
    AdOverlayInfoParcel(@SafeParcelable.Param(mo22651id = 2) zzc zzc, @SafeParcelable.Param(mo22651id = 3) IBinder iBinder, @SafeParcelable.Param(mo22651id = 4) IBinder iBinder2, @SafeParcelable.Param(mo22651id = 5) IBinder iBinder3, @SafeParcelable.Param(mo22651id = 6) IBinder iBinder4, @SafeParcelable.Param(mo22651id = 7) String str, @SafeParcelable.Param(mo22651id = 8) boolean z, @SafeParcelable.Param(mo22651id = 9) String str2, @SafeParcelable.Param(mo22651id = 10) IBinder iBinder5, @SafeParcelable.Param(mo22651id = 11) int i, @SafeParcelable.Param(mo22651id = 12) int i2, @SafeParcelable.Param(mo22651id = 13) String str3, @SafeParcelable.Param(mo22651id = 14) zzbai zzbai, @SafeParcelable.Param(mo22651id = 16) String str4, @SafeParcelable.Param(mo22651id = 17) zzh zzh, @SafeParcelable.Param(mo22651id = 18) IBinder iBinder6) {
        this.zzdkl = zzc;
        this.zzcgi = (zzxr) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzdkm = (zzo) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
        this.zzdbs = (zzbgz) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder3));
        this.zzczo = (zzagv) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder6));
        this.zzczp = (zzagx) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder4));
        this.zzdkn = str;
        this.zzdko = z;
        this.zzdkp = str2;
        this.zzdkq = (zzu) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder5));
        this.orientation = i;
        this.zzdkr = i2;
        this.url = str3;
        this.zzbtc = zzbai;
        this.zzdks = str4;
        this.zzdkt = zzh;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdkl, i, false);
        SafeParcelWriter.writeIBinder(parcel, 3, ObjectWrapper.wrap(this.zzcgi).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzdkm).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 5, ObjectWrapper.wrap(this.zzdbs).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 6, ObjectWrapper.wrap(this.zzczp).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdkn, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdko);
        SafeParcelWriter.writeString(parcel, 9, this.zzdkp, false);
        SafeParcelWriter.writeIBinder(parcel, 10, ObjectWrapper.wrap(this.zzdkq).asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 11, this.orientation);
        SafeParcelWriter.writeInt(parcel, 12, this.zzdkr);
        SafeParcelWriter.writeString(parcel, 13, this.url, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzbtc, i, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzdks, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzdkt, i, false);
        SafeParcelWriter.writeIBinder(parcel, 18, ObjectWrapper.wrap(this.zzczo).asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
