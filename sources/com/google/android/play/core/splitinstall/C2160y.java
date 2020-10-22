package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.io.File;

/* renamed from: com.google.android.play.core.splitinstall.y */
public final class C2160y {

    /* renamed from: a */
    private final Context f1010a;

    C2160y(Context context) {
        this.f1010a = context;
    }

    @Nullable
    /* renamed from: a */
    static File m1047a(Context context) {
        String string;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null || (string = bundle.getString("local_testing_dir")) == null) {
                return null;
            }
            return new File(context.getExternalFilesDir((String) null), string);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C2144t mo33783a() {
        return C2144t.m1011a(this.f1010a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Context mo33784b() {
        return this.f1010a;
    }
}
