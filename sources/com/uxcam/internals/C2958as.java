package com.uxcam.internals;

import android.os.Environment;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.uxcam.internals.as */
public final class C2958as {
    /* renamed from: a */
    public static String m1196a() {
        return m1199b() + "/" + C2952an.f1318b + "/";
    }

    /* renamed from: a */
    public static String m1197a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = null;
        } else {
            int d = m1203d(str);
            if (d != 1) {
                str = str.substring(0, d);
            }
        }
        sb.append(str);
        sb.append(".");
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: a */
    public static boolean m1198a(String str) {
        return str.startsWith(MimeTypes.BASE_TYPE_VIDEO) || str.startsWith("screen");
    }

    /* renamed from: b */
    public static String m1199b() {
        if (!C2952an.f1332p) {
            return m1201c("UXBrowser").getAbsolutePath();
        }
        return m1205e() + "/UXCam";
    }

    /* renamed from: b */
    public static String m1200b(String str) {
        if (str == null) {
            return null;
        }
        int d = m1203d(str);
        return d == 1 ? "" : str.substring(d + 1);
    }

    /* renamed from: c */
    private static File m1201c(String str) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES), str);
        if (!file.mkdirs()) {
            new Object[1][0] = "Directory not created";
            C2970bc.m1237b();
        }
        return file;
    }

    /* renamed from: c */
    public static String m1202c() {
        if (C2952an.f1332p) {
            return "video.mp4";
        }
        String format = new SimpleDateFormat("yyyy-MM-dd_HH-mm", Locale.ENGLISH).format(new Date());
        return format + ".mp4";
    }

    /* renamed from: d */
    private static int m1203d(String str) {
        int lastIndexOf;
        if (str != null && str.lastIndexOf("/") <= (lastIndexOf = str.lastIndexOf("."))) {
            return lastIndexOf;
        }
        return 1;
    }

    /* renamed from: d */
    public static String m1204d() {
        return C2952an.f1307J ? "data.zip" : "data.txt";
    }

    /* renamed from: e */
    private static String m1205e() {
        try {
            return C3183fy.m2030a().getFilesDir().getPath();
        } catch (Exception unused) {
            C2970bc.m1233a("tag");
            return null;
        }
    }
}
