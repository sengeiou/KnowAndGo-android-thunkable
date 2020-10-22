package com.google.android.play.core.internal;

import android.util.Log;
import java.io.File;

/* renamed from: com.google.android.play.core.internal.bj */
final class C2013bj implements C2001ay {
    C2013bj() {
    }

    /* renamed from: a */
    public final boolean mo33572a(Object obj, File file, File file2) {
        try {
            return !((Boolean) C2020bq.m678a((Class) Class.forName("dalvik.system.DexFile"), Boolean.class, String.class, file.getPath())).booleanValue();
        } catch (ClassNotFoundException unused) {
            Log.e("SplitCompat", "Unexpected missing dalvik.system.DexFile.");
            return false;
        }
    }
}
