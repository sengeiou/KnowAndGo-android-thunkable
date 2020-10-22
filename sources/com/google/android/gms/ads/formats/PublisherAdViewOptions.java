package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzaga;
import com.google.android.gms.internal.ads.zzagb;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzyf;
import com.google.android.gms.internal.ads.zzzs;
import com.google.android.gms.internal.ads.zzzt;

@SafeParcelable.Class(creator = "PublisherAdViewOptionsCreator")
@zzard
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getManualImpressionsEnabled", mo22648id = 1)
    private final boolean zzbqn;
    @SafeParcelable.Field(getter = "getAppEventListenerBinder", mo22648id = 2, type = "android.os.IBinder")
    @Nullable
    private final zzzs zzbqo;
    @Nullable
    private AppEventListener zzbqp;
    @SafeParcelable.Field(getter = "getDelayedBannerAdListenerBinder", mo22648id = 3)
    @Nullable
    private final IBinder zzbqq;

    private PublisherAdViewOptions(Builder builder) {
        this.zzbqn = builder.zzbqn;
        this.zzbqp = builder.zzbqp;
        this.zzbqo = this.zzbqp != null ? new zzyf(this.zzbqp) : null;
        this.zzbqq = null;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzbqn = false;
        /* access modifiers changed from: private */
        @Nullable
        public AppEventListener zzbqp;

        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzbqn = z;
            return this;
        }

        public final Builder setAppEventListener(AppEventListener appEventListener) {
            this.zzbqp = appEventListener;
            return this;
        }

        public final PublisherAdViewOptions build() {
            return new PublisherAdViewOptions(this);
        }
    }

    @SafeParcelable.Constructor
    PublisherAdViewOptions(@SafeParcelable.Param(mo22651id = 1) boolean z, @SafeParcelable.Param(mo22651id = 2) @Nullable IBinder iBinder, @SafeParcelable.Param(mo22651id = 3) @Nullable IBinder iBinder2) {
        this.zzbqn = z;
        this.zzbqo = iBinder != null ? zzzt.zzd(iBinder) : null;
        this.zzbqq = iBinder2;
    }

    @Nullable
    public final AppEventListener getAppEventListener() {
        return this.zzbqp;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbqn;
    }

    @Nullable
    public final zzzs zzkt() {
        return this.zzbqo;
    }

    @Nullable
    public final zzaga zzku() {
        return zzagb.zzu(this.zzbqq);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getManualImpressionsEnabled());
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzbqo == null ? null : this.zzbqo.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzbqq, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
