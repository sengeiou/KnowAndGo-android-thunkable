package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.AppUpdateOptions;

/* renamed from: com.google.android.play.core.appupdate.u */
final class C1836u extends AppUpdateOptions.Builder {

    /* renamed from: a */
    private Integer f281a;

    /* renamed from: b */
    private Boolean f282b;

    C1836u() {
    }

    public final AppUpdateOptions build() {
        String str = "";
        if (this.f281a == null) {
            str = str.concat(" appUpdateType");
        }
        if (this.f282b == null) {
            str = String.valueOf(str).concat(" allowAssetPackDeletion");
        }
        if (str.isEmpty()) {
            return new C1837v(this.f281a.intValue(), this.f282b.booleanValue());
        }
        String valueOf = String.valueOf(str);
        throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
    }

    public final AppUpdateOptions.Builder setAllowAssetPackDeletion(boolean z) {
        this.f282b = Boolean.valueOf(z);
        return this;
    }

    public final AppUpdateOptions.Builder setAppUpdateType(int i) {
        this.f281a = Integer.valueOf(i);
        return this;
    }
}
