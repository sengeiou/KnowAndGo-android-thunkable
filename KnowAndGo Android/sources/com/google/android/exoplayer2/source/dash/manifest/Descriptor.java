package com.google.android.exoplayer2.source.dash.manifest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Util;

public final class Descriptor {
    @Nullable

    /* renamed from: id */
    public final String f156id;
    @NonNull
    public final String schemeIdUri;
    @Nullable
    public final String value;

    public Descriptor(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        this.schemeIdUri = str;
        this.value = str2;
        this.f156id = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Descriptor descriptor = (Descriptor) obj;
        if (!Util.areEqual(this.schemeIdUri, descriptor.schemeIdUri) || !Util.areEqual(this.value, descriptor.value) || !Util.areEqual(this.f156id, descriptor.f156id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((this.schemeIdUri != null ? this.schemeIdUri.hashCode() : 0) * 31) + (this.value != null ? this.value.hashCode() : 0)) * 31;
        if (this.f156id != null) {
            i = this.f156id.hashCode();
        }
        return hashCode + i;
    }
}
