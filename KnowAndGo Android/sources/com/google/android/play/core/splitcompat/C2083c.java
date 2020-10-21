package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.play.core.internal.C1998av;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitcompat.c */
public final class C2083c {

    /* renamed from: a */
    private final long f826a;

    /* renamed from: b */
    private final Context f827b;

    /* renamed from: c */
    private File f828c;

    public C2083c(Context context) throws PackageManager.NameNotFoundException {
        this.f827b = context;
        this.f826a = (long) context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
    }

    /* renamed from: a */
    private static File m871a(File file, String str) throws IOException {
        File file2 = new File(file, str);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            return file2;
        }
        throw new IllegalArgumentException("split ID cannot be placed in target directory");
    }

    /* renamed from: c */
    public static void m872c(File file) throws IOException {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File c : listFiles) {
                m872c(c);
            }
        }
        if (file.exists() && !file.delete()) {
            throw new IOException(String.format("Failed to delete '%s'", new Object[]{file.getAbsolutePath()}));
        }
    }

    /* renamed from: d */
    private static void m873d(File file) throws IOException {
        if (!file.exists()) {
            file.mkdirs();
            if (!file.isDirectory()) {
                String valueOf = String.valueOf(file.getAbsolutePath());
                throw new IOException(valueOf.length() != 0 ? "Unable to create directory: ".concat(valueOf) : new String("Unable to create directory: "));
            }
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException("File input must be directory when it exists.");
        }
    }

    /* renamed from: f */
    private final File m874f() throws IOException {
        File file = new File(m875g(), "verified-splits");
        m873d(file);
        return file;
    }

    /* renamed from: g */
    private final File m875g() throws IOException {
        File file = new File(m877h(), Long.toString(this.f826a));
        m873d(file);
        return file;
    }

    /* renamed from: g */
    private final File m876g(String str) throws IOException {
        File a = m871a(m879i(), str);
        m873d(a);
        return a;
    }

    /* renamed from: h */
    private final File m877h() throws IOException {
        if (this.f828c == null) {
            Context context = this.f827b;
            if (context != null) {
                this.f828c = context.getFilesDir();
            } else {
                throw new IllegalStateException("context must be non-null to populate null filesDir");
            }
        }
        File file = new File(this.f828c, "splitcompat");
        m873d(file);
        return file;
    }

    /* renamed from: h */
    private static String m878h(String str) {
        String valueOf = String.valueOf(str);
        return ".apk".length() != 0 ? valueOf.concat(".apk") : new String(valueOf);
    }

    /* renamed from: i */
    private final File m879i() throws IOException {
        File file = new File(m875g(), "native-libraries");
        m873d(file);
        return file;
    }

    /* renamed from: a */
    public final File mo33682a(File file) throws IOException {
        return m871a(m874f(), file.getName());
    }

    /* renamed from: a */
    public final File mo33683a(String str) throws IOException {
        return m871a(mo33689c(), m878h(str));
    }

    /* renamed from: a */
    public final File mo33684a(String str, String str2) throws IOException {
        return m871a(m876g(str), str2);
    }

    /* renamed from: a */
    public final void mo33685a() throws IOException {
        File h = m877h();
        String[] list = h.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(Long.toString(this.f826a))) {
                    File file = new File(h, str);
                    String valueOf = String.valueOf(file);
                    long j = this.f826a;
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118);
                    sb.append("FileStorage: removing directory for different version code (directory = ");
                    sb.append(valueOf);
                    sb.append(", current version code = ");
                    sb.append(j);
                    sb.append(")");
                    Log.d("SplitCompat", sb.toString());
                    m872c(file);
                }
            }
        }
    }

    /* renamed from: b */
    public final File mo33686b() throws IOException {
        return new File(m875g(), "lock.tmp");
    }

    /* renamed from: b */
    public final File mo33687b(String str) throws IOException {
        return m871a(m874f(), m878h(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo33688b(File file) throws IOException {
        C1998av.m631a(file.getParentFile().getParentFile().equals(m879i()), (Object) "File to remove is not a native library");
        m872c(file);
    }

    /* renamed from: c */
    public final File mo33689c() throws IOException {
        File file = new File(m875g(), "unverified-splits");
        m873d(file);
        return file;
    }

    /* renamed from: c */
    public final File mo33690c(String str) throws IOException {
        File file = new File(m875g(), "dex");
        m873d(file);
        File a = m871a(file, str);
        m873d(a);
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final Set<C2097q> mo33691d() throws IOException {
        File f = m874f();
        HashSet hashSet = new HashSet();
        File[] listFiles = f.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && file.getName().endsWith(".apk")) {
                    String name = file.getName();
                    hashSet.add(new C2097q(file, name.substring(0, name.length() - 4)));
                }
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo33692d(String str) throws IOException {
        m872c(m876g(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final List<String> mo33693e() throws IOException {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = m879i().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    arrayList.add(file.getName());
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final Set<File> mo33694e(String str) throws IOException {
        HashSet hashSet = new HashSet();
        File[] listFiles = m876g(str).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    hashSet.add(file);
                }
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo33695f(String str) throws IOException {
        m872c(mo33687b(str));
    }
}
