package androidx.core.p005os;

import android.os.Parcel;
import androidx.annotation.NonNull;

/* renamed from: androidx.core.os.ParcelCompat */
public final class ParcelCompat {
    public static boolean readBoolean(@NonNull Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static void writeBoolean(@NonNull Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    private ParcelCompat() {
    }
}
