package com.uxcam.internals;

import java.io.File;
import java.io.IOException;

/* renamed from: com.uxcam.internals.ea */
public interface C3108ea {

    /* renamed from: a */
    public static final C3108ea f2105a = new C3108ea() {
        /* renamed from: a */
        public final void mo38312a(File file) {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete ".concat(String.valueOf(file)));
            }
        }
    };

    /* renamed from: a */
    void mo38312a(File file);
}
