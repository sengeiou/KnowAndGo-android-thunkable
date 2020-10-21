package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaaz;
import com.google.android.gms.internal.ads.zzaba;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.List;
import java.util.Set;

@VisibleForTesting
public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final String MAX_AD_CONTENT_RATING_G = "G";
    public static final String MAX_AD_CONTENT_RATING_MA = "MA";
    public static final String MAX_AD_CONTENT_RATING_PG = "PG";
    public static final String MAX_AD_CONTENT_RATING_T = "T";
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_FALSE = 0;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_TRUE = 1;
    public static final int TAG_FOR_UNDER_AGE_OF_CONSENT_UNSPECIFIED = -1;
    private final zzaaz zzaam;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MaxAdContentRating {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForUnderAgeOfConsent {
    }

    private PublisherAdRequest(Builder builder) {
        this.zzaam = new zzaaz(builder.zzaan);
    }

    public static void updateCorrelator() {
    }

    @VisibleForTesting
    public static final class Builder {
        /* access modifiers changed from: private */
        public final zzaba zzaan = new zzaba();

        public final Builder addKeyword(String str) {
            this.zzaan.zzbw(str);
            return this;
        }

        public final Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zzaan.zza(networkExtras);
            return this;
        }

        public final Builder addNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
            this.zzaan.zza(cls, bundle);
            return this;
        }

        public final Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zzaan.zzb(cls, bundle);
            return this;
        }

        public final Builder addTestDevice(String str) {
            this.zzaan.zzbx(str);
            return this;
        }

        public final PublisherAdRequest build() {
            return new PublisherAdRequest(this);
        }

        @Deprecated
        public final Builder setBirthday(Date date) {
            this.zzaan.zza(date);
            return this;
        }

        public final Builder setContentUrl(String str) {
            Preconditions.checkNotNull(str, "Content URL must be non-null.");
            Preconditions.checkNotEmpty(str, "Content URL must be non-empty.");
            Preconditions.checkArgument(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
            this.zzaan.zzbz(str);
            return this;
        }

        @Deprecated
        public final Builder setGender(int i) {
            this.zzaan.zzcn(i);
            return this;
        }

        public final Builder setLocation(Location location) {
            this.zzaan.zza(location);
            return this;
        }

        @Deprecated
        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzaan.setManualImpressionsEnabled(z);
            return this;
        }

        public final Builder setPublisherProvidedId(String str) {
            this.zzaan.zzca(str);
            return this;
        }

        public final Builder setRequestAgent(String str) {
            this.zzaan.zzcb(str);
            return this;
        }

        public final Builder tagForChildDirectedTreatment(boolean z) {
            this.zzaan.zzt(z);
            return this;
        }

        public final Builder addCustomTargeting(String str, String str2) {
            this.zzaan.zze(str, str2);
            return this;
        }

        public final Builder addCustomTargeting(String str, List<String> list) {
            if (list != null) {
                this.zzaan.zze(str, TextUtils.join(",", list));
            }
            return this;
        }

        public final Builder addCategoryExclusion(String str) {
            this.zzaan.zzcc(str);
            return this;
        }

        @Deprecated
        public final Builder setIsDesignedForFamilies(boolean z) {
            this.zzaan.zzu(z);
            return this;
        }

        public final Builder setTagForUnderAgeOfConsent(int i) {
            this.zzaan.zzco(i);
            return this;
        }

        public final Builder setMaxAdContentRating(String str) {
            this.zzaan.zzcd(str);
            return this;
        }
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zzaam.getBirthday();
    }

    public final String getContentUrl() {
        return this.zzaam.getContentUrl();
    }

    @Deprecated
    public final int getGender() {
        return this.zzaam.getGender();
    }

    public final Set<String> getKeywords() {
        return this.zzaam.getKeywords();
    }

    public final Location getLocation() {
        return this.zzaam.getLocation();
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzaam.getManualImpressionsEnabled();
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.zzaam.getNetworkExtras(cls);
    }

    public final <T extends MediationExtrasReceiver> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zzaam.getNetworkExtrasBundle(cls);
    }

    public final <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zzaam.getCustomEventExtrasBundle(cls);
    }

    public final String getPublisherProvidedId() {
        return this.zzaam.getPublisherProvidedId();
    }

    public final boolean isTestDevice(Context context) {
        return this.zzaam.isTestDevice(context);
    }

    public final Bundle getCustomTargeting() {
        return this.zzaam.getCustomTargeting();
    }

    public final zzaaz zzde() {
        return this.zzaam;
    }
}
