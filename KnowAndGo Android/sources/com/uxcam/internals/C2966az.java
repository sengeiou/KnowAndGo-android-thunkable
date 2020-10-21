package com.uxcam.internals;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.uxcam.internals.az */
public class C2966az {

    /* renamed from: b */
    private static String f1388b = "az";

    /* renamed from: a */
    protected Context f1389a;

    public C2966az(Context context) {
        this.f1389a = context;
    }

    /* renamed from: a */
    public final void mo38066a() {
        try {
            File[] listFiles = new File(C2958as.m1196a()).listFiles(new FilenameFilter() {
                public final boolean accept(File file, String str) {
                    return C2958as.m1198a(str);
                }
            });
            File file = (listFiles == null || listFiles.length <= 0) ? null : listFiles[0];
            if (file != null && C2952an.f1332p) {
                new C2964ay().mo38061a(this.f1389a, file);
            }
        } catch (Exception unused) {
            C2970bc.m1233a(f1388b);
        }
    }
}
