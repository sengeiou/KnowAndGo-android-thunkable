package com.google.android.play.core.appupdate;

import com.google.android.play.core.install.model.AppUpdateType;

/* renamed from: com.google.android.play.core.appupdate.v */
final class C1837v extends AppUpdateOptions {

    /* renamed from: a */
    private final int f283a;

    /* renamed from: b */
    private final boolean f284b;

    /* synthetic */ C1837v(int i, boolean z) {
        this.f283a = i;
        this.f284b = z;
    }

    public final boolean allowAssetPackDeletion() {
        return this.f284b;
    }

    @AppUpdateType
    public final int appUpdateType() {
        return this.f283a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AppUpdateOptions) {
            AppUpdateOptions appUpdateOptions = (AppUpdateOptions) obj;
            return this.f283a == appUpdateOptions.appUpdateType() && this.f284b == appUpdateOptions.allowAssetPackDeletion();
        }
    }

    public final int hashCode() {
        return ((this.f283a ^ 1000003) * 1000003) ^ (true != this.f284b ? 1237 : 1231);
    }

    public final String toString() {
        int i = this.f283a;
        boolean z = this.f284b;
        StringBuilder sb = new StringBuilder(73);
        sb.append("AppUpdateOptions{appUpdateType=");
        sb.append(i);
        sb.append(", allowAssetPackDeletion=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
