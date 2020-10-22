package com.google.android.play.core.internal;

import com.RNFetchBlob.RNFetchBlobConst;
import java.io.File;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.bk */
final class C2014bk implements C1997au {
    C2014bk() {
    }

    /* renamed from: b */
    static void m662b(ClassLoader classLoader, Set<File> set) {
        C2009bf.m651a(classLoader, set, new C2012bi());
    }

    /* renamed from: b */
    static boolean m663b(ClassLoader classLoader, File file, File file2, boolean z) {
        return C2004ba.m640a(classLoader, file, file2, z, C2009bf.m650a(), RNFetchBlobConst.RNFB_RESPONSE_PATH, new C2013bj());
    }

    /* renamed from: a */
    public final void mo33569a(ClassLoader classLoader, Set<File> set) {
        m662b(classLoader, set);
    }

    /* renamed from: a */
    public final boolean mo33570a(ClassLoader classLoader, File file, File file2, boolean z) {
        return m663b(classLoader, file, file2, z);
    }
}
