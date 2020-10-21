package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "VisibleRegionCreator")
@SafeParcelable.Reserved({1})
public final class VisibleRegion extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VisibleRegion> CREATOR = new zzv();
    @SafeParcelable.Field(mo22648id = 4)
    public final LatLng farLeft;
    @SafeParcelable.Field(mo22648id = 5)
    public final LatLng farRight;
    @SafeParcelable.Field(mo22648id = 6)
    public final LatLngBounds latLngBounds;
    @SafeParcelable.Field(mo22648id = 2)
    public final LatLng nearLeft;
    @SafeParcelable.Field(mo22648id = 3)
    public final LatLng nearRight;

    @SafeParcelable.Constructor
    public VisibleRegion(@SafeParcelable.Param(mo22651id = 2) LatLng latLng, @SafeParcelable.Param(mo22651id = 3) LatLng latLng2, @SafeParcelable.Param(mo22651id = 4) LatLng latLng3, @SafeParcelable.Param(mo22651id = 5) LatLng latLng4, @SafeParcelable.Param(mo22651id = 6) LatLngBounds latLngBounds2) {
        this.nearLeft = latLng;
        this.nearRight = latLng2;
        this.farLeft = latLng3;
        this.farRight = latLng4;
        this.latLngBounds = latLngBounds2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.nearLeft, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.nearRight, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.farLeft, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.farRight, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.latLngBounds, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int hashCode() {
        return Objects.hashCode(this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        return this.nearLeft.equals(visibleRegion.nearLeft) && this.nearRight.equals(visibleRegion.nearRight) && this.farLeft.equals(visibleRegion.farLeft) && this.farRight.equals(visibleRegion.farRight) && this.latLngBounds.equals(visibleRegion.latLngBounds);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("nearLeft", this.nearLeft).add("nearRight", this.nearRight).add("farLeft", this.farLeft).add("farRight", this.farRight).add("latLngBounds", this.latLngBounds).toString();
    }
}
