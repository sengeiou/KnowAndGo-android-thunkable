package com.google.android.play.core.appupdate;

import android.content.Context;
import java.io.File;

/* renamed from: com.google.android.play.core.appupdate.r */
final class C1833r {

    /* renamed from: a */
    private final Context f251a;

    C1833r(Context context) {
        this.f251a = context;
    }

    /* renamed from: a */
    private static long m238a(File file) {
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (File a : listFiles) {
                j += m238a(a);
            }
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final long mo33277a() {
        return m238a(new File(this.f251a.getFilesDir(), "assetpacks"));
    }
}
