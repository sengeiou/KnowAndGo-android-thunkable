package com.google.android.p011a;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.a.c */
/* compiled from: Codecs */
public final class C1447c {
    static {
        C1447c.class.getClassLoader();
    }

    private C1447c() {
    }

    /* renamed from: a */
    public static <T extends Parcelable> T m147a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() != 0) {
            return (Parcelable) creator.createFromParcel(parcel);
        }
        return null;
    }

    /* renamed from: a */
    public static void m148a(Parcel parcel, Parcelable parcelable) {
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }
}
