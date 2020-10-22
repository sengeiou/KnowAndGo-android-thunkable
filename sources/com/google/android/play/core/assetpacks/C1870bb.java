package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.internal.C2039ci;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.play.core.assetpacks.bb */
final class C1870bb {

    /* renamed from: a */
    private static final C1982af f394a = new C1982af("AssetPackStorage");

    /* renamed from: b */
    private static final long f395b = TimeUnit.DAYS.toMillis(14);

    /* renamed from: c */
    private static final long f396c = TimeUnit.DAYS.toMillis(28);

    /* renamed from: d */
    private final Context f397d;

    /* renamed from: e */
    private final C1934dl f398e;

    C1870bb(Context context, C1934dl dlVar) {
        this.f397d = context;
        this.f398e = dlVar;
    }

    /* renamed from: a */
    private final File m338a(String str, int i) {
        return new File(m343g(str), String.valueOf(i));
    }

    /* renamed from: a */
    private static List<String> m339a(PackageInfo packageInfo, String str) {
        ArrayList arrayList = new ArrayList();
        if (packageInfo.splitNames == null) {
            return arrayList;
        }
        int i = (-Arrays.binarySearch(packageInfo.splitNames, str)) - 1;
        while (i < packageInfo.splitNames.length && packageInfo.splitNames[i].startsWith(str)) {
            arrayList.add(packageInfo.applicationInfo.splitSourceDirs[i]);
            i++;
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m340a(File file) {
        if (file.listFiles() != null && file.listFiles().length > 1) {
            long b = m341b(file);
            for (File file2 : file.listFiles()) {
                if (!file2.getName().equals(String.valueOf(b)) && !file2.getName().equals("stale.tmp")) {
                    m342c(file2);
                }
            }
        }
    }

    /* renamed from: b */
    private static long m341b(File file) {
        if (!file.exists()) {
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (File file2 : file.listFiles()) {
                if (!file2.getName().equals("stale.tmp")) {
                    arrayList.add(Long.valueOf(file2.getName()));
                }
            }
        } catch (NumberFormatException e) {
            f394a.mo33551a((Throwable) e, "Corrupt asset pack directories.", new Object[0]);
        }
        if (arrayList.isEmpty()) {
            return -1;
        }
        Collections.sort(arrayList);
        return ((Long) arrayList.get(arrayList.size() - 1)).longValue();
    }

    /* renamed from: c */
    private static boolean m342c(File file) {
        boolean z;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            z = true;
            for (File c : listFiles) {
                z &= m342c(c);
            }
        } else {
            z = true;
        }
        return file.delete() && true == z;
    }

    /* renamed from: g */
    private final File m343g(String str) {
        return new File(m348i(), str);
    }

    /* renamed from: g */
    private final File m344g(String str, int i, long j) {
        return new File(mo33384c(str, i, j), "merge.tmp");
    }

    /* renamed from: g */
    private final List<File> m345g() {
        ArrayList arrayList = new ArrayList();
        try {
            if (m348i().exists()) {
                if (m348i().listFiles() != null) {
                    for (File file : m348i().listFiles()) {
                        if (!file.getCanonicalPath().equals(m346h().getCanonicalPath())) {
                            arrayList.add(file);
                        }
                    }
                    return arrayList;
                }
            }
            return arrayList;
        } catch (IOException e) {
            f394a.mo33552b("Could not process directory while scanning installed packs. %s", e);
        }
    }

    /* renamed from: h */
    private final File m346h() {
        return new File(m348i(), "_tmp");
    }

    /* renamed from: h */
    private final File m347h(String str, int i, long j) {
        return new File(new File(new File(m346h(), str), String.valueOf(i)), String.valueOf(j));
    }

    /* renamed from: i */
    private final File m348i() {
        return new File(this.f397d.getFilesDir(), "assetpacks");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0077  */
    @androidx.annotation.Nullable
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.play.core.assetpacks.AssetLocation mo33372a(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            android.content.Context r2 = r10.f397d     // Catch:{ NameNotFoundException -> 0x0013 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0013 }
            android.content.Context r3 = r10.f397d     // Catch:{ NameNotFoundException -> 0x0013 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ NameNotFoundException -> 0x0013 }
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r3, r1)     // Catch:{ NameNotFoundException -> 0x0013 }
            goto L_0x001d
        L_0x0013:
            com.google.android.play.core.internal.af r2 = f394a
            java.lang.String r3 = "Could not find PackageInfo."
            java.lang.Object[] r4 = new java.lang.Object[r1]
            r2.mo33552b(r3, r4)
            r2 = r0
        L_0x001d:
            r3 = 1
            if (r2 != 0) goto L_0x0022
            r4 = r0
            goto L_0x0085
        L_0x0022:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 21
            if (r5 >= r6) goto L_0x0035
            android.content.pm.ApplicationInfo r2 = r2.applicationInfo
            java.lang.String r2 = r2.sourceDir
            r4.add(r2)
            goto L_0x0085
        L_0x0035:
            java.lang.String[] r5 = r2.splitNames
            if (r5 == 0) goto L_0x0058
            android.content.pm.ApplicationInfo r5 = r2.applicationInfo
            java.lang.String[] r5 = r5.splitSourceDirs
            if (r5 != 0) goto L_0x0040
            goto L_0x0058
        L_0x0040:
            java.lang.String[] r5 = r2.splitNames
            int r5 = java.util.Arrays.binarySearch(r5, r11)
            if (r5 >= 0) goto L_0x0051
            com.google.android.play.core.internal.af r5 = f394a
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r6[r1] = r11
            java.lang.String r7 = "Asset Pack '%s' is not installed."
            goto L_0x0060
        L_0x0051:
            android.content.pm.ApplicationInfo r6 = r2.applicationInfo
            java.lang.String[] r6 = r6.splitSourceDirs
            r5 = r6[r5]
            goto L_0x0064
        L_0x0058:
            com.google.android.play.core.internal.af r5 = f394a
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r6[r1] = r11
            java.lang.String r7 = "No splits present for package %s."
        L_0x0060:
            r5.mo33550a(r7, r6)
            r5 = r0
        L_0x0064:
            if (r5 != 0) goto L_0x0077
            android.content.pm.ApplicationInfo r5 = r2.applicationInfo
            java.lang.String r5 = r5.sourceDir
            r4.add(r5)
            java.lang.String r5 = "config."
        L_0x006f:
            java.util.List r2 = m339a((android.content.pm.PackageInfo) r2, (java.lang.String) r5)
            r4.addAll(r2)
            goto L_0x0085
        L_0x0077:
            r4.add(r5)
            java.lang.String r5 = java.lang.String.valueOf(r11)
            java.lang.String r6 = ".config."
            java.lang.String r5 = r5.concat(r6)
            goto L_0x006f
        L_0x0085:
            if (r4 != 0) goto L_0x0088
            goto L_0x00ca
        L_0x0088:
            java.io.File r2 = new java.io.File
            java.lang.String r5 = "assets"
            r2.<init>(r5, r12)
            java.lang.String r2 = r2.getPath()
            int r5 = r4.size()
            r6 = 0
        L_0x0098:
            r7 = 2
            if (r6 >= r5) goto L_0x00ba
            java.lang.Object r8 = r4.get(r6)
            java.lang.String r8 = (java.lang.String) r8
            com.google.android.play.core.assetpacks.AssetLocation r9 = com.google.android.play.core.assetpacks.C1924db.m467a((java.lang.String) r8, (java.lang.String) r2)     // Catch:{ IOException -> 0x00ab }
            int r6 = r6 + 1
            if (r9 == 0) goto L_0x0098
            r0 = r9
            goto L_0x00ca
        L_0x00ab:
            r11 = move-exception
            com.google.android.play.core.internal.af r2 = f394a
            java.lang.Object[] r4 = new java.lang.Object[r7]
            r4[r1] = r8
            r4[r3] = r12
            java.lang.String r12 = "Failed to parse APK file '%s' looking for asset '%s'."
            r2.mo33551a((java.lang.Throwable) r11, (java.lang.String) r12, (java.lang.Object[]) r4)
            goto L_0x00ca
        L_0x00ba:
            com.google.android.play.core.internal.af r2 = f394a
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r1] = r12
            r5[r3] = r11
            r5[r7] = r4
            java.lang.String r11 = "The asset %s is not present in Asset Pack %s. Searched in APKs: %s"
            r2.mo33550a(r11, r5)
        L_0x00ca:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C1870bb.mo33372a(java.lang.String, java.lang.String):com.google.android.play.core.assetpacks.AssetLocation");
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public final AssetLocation mo33373a(String str, String str2, AssetPackLocation assetPackLocation) {
        File file = new File(assetPackLocation.assetsPath(), str2);
        if (file.exists()) {
            return AssetLocation.m254a(file.getPath(), 0, file.length());
        }
        f394a.mo33550a("The asset %s is not present in Asset Pack %s. Searched in folder: %s", str2, str, assetPackLocation.assetsPath());
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final File mo33374a(String str, int i, long j) {
        return new File(m338a(str, i), String.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final File mo33375a(String str, int i, long j, String str2) {
        return new File(new File(new File(m347h(str, i, j), "_slices"), "_unverified"), str2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Map<String, AssetPackLocation> mo33376a() {
        HashMap hashMap = new HashMap();
        try {
            for (File next : m345g()) {
                AssetPackLocation b = mo33380b(next.getName());
                if (b != null) {
                    hashMap.put(next.getName(), b);
                }
            }
        } catch (IOException e) {
            f394a.mo33552b("Could not process directory while scanning installed packs: %s", e);
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo33377a(String str, int i, long j, int i2) throws IOException {
        File g = m344g(str, i, j);
        Properties properties = new Properties();
        properties.put("numberOfMerges", String.valueOf(i2));
        g.getParentFile().mkdirs();
        g.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(g);
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo33378a(List<String> list) {
        int a = this.f398e.mo33478a();
        List<File> g = m345g();
        int size = g.size();
        for (int i = 0; i < size; i++) {
            File file = g.get(i);
            if (!list.contains(file.getName()) && m341b(file) != ((long) a)) {
                m342c(file);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo33379a(String str) {
        try {
            return mo33386c(str) != null;
        } catch (IOException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: b */
    public final AssetPackLocation mo33380b(String str) throws IOException {
        String c = mo33386c(str);
        if (c == null) {
            return null;
        }
        File file = new File(c, "assets");
        if (file.isDirectory()) {
            return AssetPackLocation.m259a(c, file.getCanonicalPath());
        }
        f394a.mo33552b("Failed to find assets directory: %s", file);
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final File mo33381b(String str, int i, long j) {
        return new File(mo33374a(str, i, j), "_metadata");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final File mo33382b(String str, int i, long j, String str2) {
        return new File(new File(new File(m347h(str, i, j), "_slices"), "_verified"), str2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final Map<String, Long> mo33383b() {
        HashMap hashMap = new HashMap();
        for (String next : mo33376a().keySet()) {
            hashMap.put(next, Long.valueOf(mo33396f(next)));
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final File mo33384c(String str, int i, long j) {
        return new File(m347h(str, i, j), "_packs");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final File mo33385c(String str, int i, long j, String str2) {
        return new File(mo33397f(str, i, j, str2), "checkpoint.dat");
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: c */
    public final String mo33386c(String str) throws IOException {
        int length;
        File file = new File(m348i(), str);
        if (!file.exists()) {
            f394a.mo33550a("Pack not found with pack name: %s", str);
            return null;
        }
        File file2 = new File(file, String.valueOf(this.f398e.mo33478a()));
        if (!file2.exists()) {
            f394a.mo33550a("Pack not found with pack name: %s app version: %s", str, Integer.valueOf(this.f398e.mo33478a()));
            return null;
        }
        File[] listFiles = file2.listFiles();
        if (listFiles == null || (length = listFiles.length) == 0) {
            f394a.mo33550a("No pack version found for pack name: %s app version: %s", str, Integer.valueOf(this.f398e.mo33478a()));
            return null;
        } else if (length <= 1) {
            return listFiles[0].getCanonicalPath();
        } else {
            f394a.mo33552b("Multiple pack versions found for pack name: %s app version: %s", str, Integer.valueOf(this.f398e.mo33478a()));
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo33387c() {
        List<File> g = m345g();
        int size = g.size();
        for (int i = 0; i < size; i++) {
            File file = g.get(i);
            if (file.listFiles() != null) {
                m340a(file);
                long b = m341b(file);
                if (((long) this.f398e.mo33478a()) != b) {
                    try {
                        new File(new File(file, String.valueOf(b)), "stale.tmp").createNewFile();
                    } catch (IOException unused) {
                        f394a.mo33552b("Could not write staleness marker.", new Object[0]);
                    }
                }
                for (File a : file.listFiles()) {
                    m340a(a);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final int mo33388d(String str, int i, long j) throws IOException {
        File g = m344g(str, i, j);
        if (!g.exists()) {
            return 0;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(g);
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("numberOfMerges") != null) {
                try {
                    return Integer.parseInt(properties.getProperty("numberOfMerges"));
                } catch (NumberFormatException e) {
                    throw new C1890bv("Merge checkpoint file corrupt.", (Exception) e);
                }
            } else {
                throw new C1890bv("Merge checkpoint file corrupt.");
            }
        } catch (Throwable th) {
            C2039ci.m739a(th, th);
        }
        throw th;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final File mo33389d(String str, int i, long j, String str2) {
        return new File(mo33397f(str, i, j, str2), "checkpoint_ext.dat");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo33390d() {
        List<File> g = m345g();
        int size = g.size();
        for (int i = 0; i < size; i++) {
            File file = g.get(i);
            if (file.listFiles() != null) {
                for (File file2 : file.listFiles()) {
                    File file3 = new File(file2, "stale.tmp");
                    if (file3.exists() && System.currentTimeMillis() - file3.lastModified() > f396c) {
                        m342c(file2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final boolean mo33391d(String str) {
        if (!m343g(str).exists()) {
            return true;
        }
        return m342c(m343g(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final int mo33392e(String str) {
        return (int) m341b(m343g(str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final File mo33393e(String str, int i, long j) {
        return new File(new File(m347h(str, i, j), "_slices"), "_metadata");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final File mo33394e(String str, int i, long j, String str2) {
        return new File(mo33397f(str, i, j, str2), "slice.zip");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final void mo33395e() {
        if (m346h().exists()) {
            for (File file : m346h().listFiles()) {
                if (System.currentTimeMillis() - file.lastModified() > f395b) {
                    m342c(file);
                } else {
                    m340a(file);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final long mo33396f(String str) {
        return m341b(m338a(str, mo33392e(str)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final File mo33397f(String str, int i, long j, String str2) {
        return new File(mo33393e(str, i, j), str2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo33398f() {
        m342c(m348i());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final void mo33399f(String str, int i, long j) {
        if (m347h(str, i, j).exists()) {
            m342c(m347h(str, i, j));
        }
    }
}
