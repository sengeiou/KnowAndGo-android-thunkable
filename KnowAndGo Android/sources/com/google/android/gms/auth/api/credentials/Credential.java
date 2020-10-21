package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

@SafeParcelable.Class(creator = "CredentialCreator")
@SafeParcelable.Reserved({1000})
public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new zzc();
    public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getId", mo22648id = 1)
    @Nonnull
    public final String mId;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getName", mo22648id = 2)
    @Nullable
    public final String mName;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getProfilePictureUri", mo22648id = 3)
    @Nullable
    public final Uri zzo;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getIdTokens", mo22648id = 4)
    @Nonnull
    public final List<IdToken> zzp;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getPassword", mo22648id = 5)
    @Nullable
    public final String zzq;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getAccountType", mo22648id = 6)
    @Nullable
    public final String zzr;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getGivenName", mo22648id = 9)
    @Nullable
    public final String zzs;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getFamilyName", mo22648id = 10)
    @Nullable
    public final String zzt;

    @SafeParcelable.Constructor
    Credential(@SafeParcelable.Param(mo22651id = 1) String str, @SafeParcelable.Param(mo22651id = 2) String str2, @SafeParcelable.Param(mo22651id = 3) Uri uri, @SafeParcelable.Param(mo22651id = 4) List<IdToken> list, @SafeParcelable.Param(mo22651id = 5) String str3, @SafeParcelable.Param(mo22651id = 6) String str4, @SafeParcelable.Param(mo22651id = 9) String str5, @SafeParcelable.Param(mo22651id = 10) String str6) {
        List<IdToken> list2;
        String trim = ((String) Preconditions.checkNotNull(str, "credential identifier cannot be null")).trim();
        Preconditions.checkNotEmpty(trim, "credential identifier cannot be empty");
        if (str3 == null || !TextUtils.isEmpty(str3)) {
            if (str4 != null) {
                boolean z = false;
                if (!TextUtils.isEmpty(str4)) {
                    Uri parse = Uri.parse(str4);
                    if (parse.isAbsolute() && parse.isHierarchical() && !TextUtils.isEmpty(parse.getScheme()) && !TextUtils.isEmpty(parse.getAuthority()) && (UriUtil.HTTP_SCHEME.equalsIgnoreCase(parse.getScheme()) || UriUtil.HTTPS_SCHEME.equalsIgnoreCase(parse.getScheme()))) {
                        z = true;
                    }
                }
                if (!Boolean.valueOf(z).booleanValue()) {
                    throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
                }
            }
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                if (str2 != null && TextUtils.isEmpty(str2.trim())) {
                    str2 = null;
                }
                this.mName = str2;
                this.zzo = uri;
                if (list == null) {
                    list2 = Collections.emptyList();
                } else {
                    list2 = Collections.unmodifiableList(list);
                }
                this.zzp = list2;
                this.mId = trim;
                this.zzq = str3;
                this.zzr = str4;
                this.zzs = str5;
                this.zzt = str6;
                return;
            }
            throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
        }
        throw new IllegalArgumentException("Password must not be empty if set");
    }

    public static class Builder {
        private final String mId;
        private String mName;
        private Uri zzo;
        private List<IdToken> zzp;
        private String zzq;
        private String zzr;
        private String zzs;
        private String zzt;

        public Builder(String str) {
            this.mId = str;
        }

        public Builder(Credential credential) {
            this.mId = credential.mId;
            this.mName = credential.mName;
            this.zzo = credential.zzo;
            this.zzp = credential.zzp;
            this.zzq = credential.zzq;
            this.zzr = credential.zzr;
            this.zzs = credential.zzs;
            this.zzt = credential.zzt;
        }

        public Builder setName(String str) {
            this.mName = str;
            return this;
        }

        public Builder setProfilePictureUri(Uri uri) {
            this.zzo = uri;
            return this;
        }

        public Builder setPassword(String str) {
            this.zzq = str;
            return this;
        }

        public Builder setAccountType(String str) {
            this.zzr = str;
            return this;
        }

        public Credential build() {
            return new Credential(this.mId, this.mName, this.zzo, this.zzp, this.zzq, this.zzr, this.zzs, this.zzt);
        }
    }

    @Nonnull
    public String getId() {
        return this.mId;
    }

    @Nullable
    public String getName() {
        return this.mName;
    }

    @Nullable
    public Uri getProfilePictureUri() {
        return this.zzo;
    }

    @Nonnull
    public List<IdToken> getIdTokens() {
        return this.zzp;
    }

    @Nullable
    public String getPassword() {
        return this.zzq;
    }

    @Nullable
    public String getAccountType() {
        return this.zzr;
    }

    @Nullable
    public String getGivenName() {
        return this.zzs;
    }

    @Nullable
    public String getFamilyName() {
        return this.zzt;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getProfilePictureUri(), i, false);
        SafeParcelWriter.writeTypedList(parcel, 4, getIdTokens(), false);
        SafeParcelWriter.writeString(parcel, 5, getPassword(), false);
        SafeParcelWriter.writeString(parcel, 6, getAccountType(), false);
        SafeParcelWriter.writeString(parcel, 9, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 10, getFamilyName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.mId, credential.mId) && TextUtils.equals(this.mName, credential.mName) && Objects.equal(this.zzo, credential.zzo) && TextUtils.equals(this.zzq, credential.zzq) && TextUtils.equals(this.zzr, credential.zzr);
    }

    public int hashCode() {
        return Objects.hashCode(this.mId, this.mName, this.zzo, this.zzq, this.zzr);
    }
}
