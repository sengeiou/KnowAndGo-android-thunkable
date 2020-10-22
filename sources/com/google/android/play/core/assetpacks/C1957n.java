package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;

/* renamed from: com.google.android.play.core.assetpacks.n */
final class C1957n {

    /* renamed from: a */
    private final Context f698a;

    public C1957n(Context context) {
        this.f698a = context;
    }

    @Nullable
    /* renamed from: a */
    static String m539a(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            return bundle.getString("local_testing_dir");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Context mo33526a() {
        return this.f698a;
    }
}
