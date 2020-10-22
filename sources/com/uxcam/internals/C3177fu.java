package com.uxcam.internals;

import android.content.Context;
import com.uxcam.service.HttpPostService;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/* renamed from: com.uxcam.internals.fu */
public class C3177fu {

    /* renamed from: a */
    private static final String f2295a = "fu";

    /* renamed from: b */
    private Context f2296b;

    public C3177fu(Context context) {
        this.f2296b = context;
    }

    /* renamed from: a */
    private void m2023a(File file) {
        File[] listFiles = file.listFiles(new FilenameFilter() {
            public final boolean accept(File file, String str) {
                return C2958as.m1198a(str) || str.startsWith("data") || str.startsWith("icon");
            }
        });
        m2024a(listFiles);
        if (listFiles != null && listFiles.length <= 0) {
            return;
        }
        if (HttpPostService.m2431a(file)) {
            C2964ay ayVar = new C2964ay();
            ayVar.f1383d = true;
            ayVar.mo38063b(this.f2296b, file);
            return;
        }
        C2970bc.m1233a(f2295a);
        new StringBuilder("Sending offline data File is already being posted :: ").append(file);
    }

    /* renamed from: a */
    private static void m2024a(File[] fileArr) {
        int length = fileArr.length;
        int i = 0;
        while (i < length) {
            File file = fileArr[i];
            if (file.length() != 0 || file.getName().startsWith("icon")) {
                i++;
            } else {
                C3183fy.m2035a(file.getParentFile());
                HashMap hashMap = new HashMap();
                hashMap.put("sessionDir", file.getParentFile().getName());
                C3171fo.m1998a(C3183fy.m2030a(), "unexpectedCloseOfSession", hashMap);
                new C2956ar("").mo38053a(3, C2958as.m1199b() + "/" + file.getParentFile().getName() + "/");
                return;
            }
        }
    }

    /* renamed from: a */
    public final void mo38476a(boolean z) {
        File[] listFiles;
        try {
            File[] listFiles2 = new File(C2958as.m1199b()).listFiles();
            Arrays.sort(listFiles2, new Comparator() {
                public final int compare(Object obj, Object obj2) {
                    File file = (File) obj;
                    File file2 = (File) obj2;
                    if (file.lastModified() > file2.lastModified()) {
                        return -1;
                    }
                    return file.lastModified() < file2.lastModified() ? 1 : 0;
                }
            });
            HashMap hashMap = new HashMap();
            hashMap.put("sessionCount", Integer.valueOf(listFiles2.length - 1));
            C3171fo.m1998a(C3183fy.m2030a(), "sendPreviousSession", hashMap);
            if (listFiles2 != null) {
                for (File file : listFiles2) {
                    boolean equals = file.getName().equals(C2952an.f1318b);
                    if (!(file == null || equals || (listFiles = file.listFiles()) == null)) {
                        if (listFiles.length == 0) {
                            file.delete();
                        } else if (z) {
                            if (!C3183fy.m2040b(file)) {
                                C3183fy.m2035a(file);
                            } else {
                                C3183fy.m2043c(file);
                                new C2956ar("").mo38053a(1, C2958as.m1199b() + "/" + file.getName() + "/");
                            }
                        } else if (C3169fm.m1993a(this.f2296b)) {
                            m2023a(file);
                        }
                    }
                }
            }
        } catch (Exception unused) {
            C2970bc.m1238c();
        }
    }
}
