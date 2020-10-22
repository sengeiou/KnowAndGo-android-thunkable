package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.google.android.play.core.assetpacks.ds */
final /* synthetic */ class C1941ds implements FilenameFilter {

    /* renamed from: a */
    static final FilenameFilter f654a = new C1941ds();

    private C1941ds() {
    }

    public final boolean accept(File file, String str) {
        return C1942dt.f655a.matcher(str).matches();
    }
}
