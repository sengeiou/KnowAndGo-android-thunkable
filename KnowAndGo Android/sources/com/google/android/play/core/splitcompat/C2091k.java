package com.google.android.play.core.splitcompat;

import android.util.Log;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

/* renamed from: com.google.android.play.core.splitcompat.k */
public final class C2091k {

    /* renamed from: a */
    public static final /* synthetic */ int f842a = 0;

    /* renamed from: b */
    private static final Pattern f843b = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    /* renamed from: c */
    private final C2083c f844c;

    C2091k(C2083c cVar) throws IOException {
        this.f844c = cVar;
    }

    /* renamed from: a */
    static /* synthetic */ Set m900a(C2091k kVar, Set set, C2097q qVar, ZipFile zipFile) throws IOException {
        HashSet hashSet = new HashSet();
        kVar.m903a(qVar, set, new C2087g(hashSet, qVar, zipFile));
        return hashSet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00fc A[SYNTHETIC, Splitter:B:32:0x00fc] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m902a(com.google.android.play.core.splitcompat.C2097q r13, com.google.android.play.core.splitcompat.C2088h r14) throws java.io.IOException {
        /*
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x00f8 }
            java.io.File r1 = r13.mo33704a()     // Catch:{ IOException -> 0x00f8 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x00f8 }
            java.lang.String r13 = r13.mo33705b()     // Catch:{ IOException -> 0x00f6 }
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ IOException -> 0x00f6 }
            r1.<init>()     // Catch:{ IOException -> 0x00f6 }
            java.util.Enumeration r2 = r0.entries()     // Catch:{ IOException -> 0x00f6 }
        L_0x0016:
            boolean r3 = r2.hasMoreElements()     // Catch:{ IOException -> 0x00f6 }
            r4 = 2
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L_0x006a
            java.lang.Object r3 = r2.nextElement()     // Catch:{ IOException -> 0x00f6 }
            java.util.zip.ZipEntry r3 = (java.util.zip.ZipEntry) r3     // Catch:{ IOException -> 0x00f6 }
            java.lang.String r7 = r3.getName()     // Catch:{ IOException -> 0x00f6 }
            java.util.regex.Pattern r8 = f843b     // Catch:{ IOException -> 0x00f6 }
            java.util.regex.Matcher r7 = r8.matcher(r7)     // Catch:{ IOException -> 0x00f6 }
            boolean r8 = r7.matches()     // Catch:{ IOException -> 0x00f6 }
            if (r8 == 0) goto L_0x0016
            java.lang.String r8 = r7.group(r6)     // Catch:{ IOException -> 0x00f6 }
            java.lang.String r7 = r7.group(r4)     // Catch:{ IOException -> 0x00f6 }
            r9 = 3
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ IOException -> 0x00f6 }
            r9[r5] = r13     // Catch:{ IOException -> 0x00f6 }
            r9[r6] = r7     // Catch:{ IOException -> 0x00f6 }
            r9[r4] = r8     // Catch:{ IOException -> 0x00f6 }
            java.lang.String r4 = "SplitCompat"
            java.lang.String r5 = "NativeLibraryExtractor: split '%s' has native library '%s' for ABI '%s'"
            java.lang.String r5 = java.lang.String.format(r5, r9)     // Catch:{ IOException -> 0x00f6 }
            android.util.Log.d(r4, r5)     // Catch:{ IOException -> 0x00f6 }
            java.lang.Object r4 = r1.get(r8)     // Catch:{ IOException -> 0x00f6 }
            java.util.Set r4 = (java.util.Set) r4     // Catch:{ IOException -> 0x00f6 }
            if (r4 != 0) goto L_0x0061
            java.util.HashSet r4 = new java.util.HashSet     // Catch:{ IOException -> 0x00f6 }
            r4.<init>()     // Catch:{ IOException -> 0x00f6 }
            r1.put(r8, r4)     // Catch:{ IOException -> 0x00f6 }
        L_0x0061:
            com.google.android.play.core.splitcompat.j r5 = new com.google.android.play.core.splitcompat.j     // Catch:{ IOException -> 0x00f6 }
            r5.<init>(r3, r7)     // Catch:{ IOException -> 0x00f6 }
            r4.add(r5)     // Catch:{ IOException -> 0x00f6 }
            goto L_0x0016
        L_0x006a:
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ IOException -> 0x00f6 }
            r13.<init>()     // Catch:{ IOException -> 0x00f6 }
            java.lang.String[] r2 = android.os.Build.SUPPORTED_ABIS     // Catch:{ IOException -> 0x00f6 }
            int r3 = r2.length     // Catch:{ IOException -> 0x00f6 }
            r7 = 0
        L_0x0073:
            if (r7 >= r3) goto L_0x00e6
            r8 = r2[r7]     // Catch:{ IOException -> 0x00f6 }
            boolean r9 = r1.containsKey(r8)     // Catch:{ IOException -> 0x00f6 }
            if (r9 == 0) goto L_0x00d4
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ IOException -> 0x00f6 }
            r9[r5] = r8     // Catch:{ IOException -> 0x00f6 }
            java.lang.String r10 = "SplitCompat"
            java.lang.String r11 = "NativeLibraryExtractor: there are native libraries for supported ABI %s; will use this ABI"
            java.lang.String r9 = java.lang.String.format(r11, r9)     // Catch:{ IOException -> 0x00f6 }
            android.util.Log.d(r10, r9)     // Catch:{ IOException -> 0x00f6 }
            java.lang.Object r9 = r1.get(r8)     // Catch:{ IOException -> 0x00f6 }
            java.util.Set r9 = (java.util.Set) r9     // Catch:{ IOException -> 0x00f6 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ IOException -> 0x00f6 }
        L_0x0096:
            boolean r10 = r9.hasNext()     // Catch:{ IOException -> 0x00f6 }
            if (r10 == 0) goto L_0x00e3
            java.lang.Object r10 = r9.next()     // Catch:{ IOException -> 0x00f6 }
            com.google.android.play.core.splitcompat.j r10 = (com.google.android.play.core.splitcompat.C2090j) r10     // Catch:{ IOException -> 0x00f6 }
            java.lang.String r11 = r10.f840a     // Catch:{ IOException -> 0x00f6 }
            boolean r11 = r13.containsKey(r11)     // Catch:{ IOException -> 0x00f6 }
            if (r11 == 0) goto L_0x00be
            java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x00f6 }
            java.lang.String r10 = r10.f840a     // Catch:{ IOException -> 0x00f6 }
            r11[r5] = r10     // Catch:{ IOException -> 0x00f6 }
            r11[r6] = r8     // Catch:{ IOException -> 0x00f6 }
            java.lang.String r10 = "SplitCompat"
            java.lang.String r12 = "NativeLibraryExtractor: skipping library %s for ABI %s; already present for a better ABI"
            java.lang.String r11 = java.lang.String.format(r12, r11)     // Catch:{ IOException -> 0x00f6 }
        L_0x00ba:
            android.util.Log.d(r10, r11)     // Catch:{ IOException -> 0x00f6 }
            goto L_0x0096
        L_0x00be:
            java.lang.String r11 = r10.f840a     // Catch:{ IOException -> 0x00f6 }
            r13.put(r11, r10)     // Catch:{ IOException -> 0x00f6 }
            java.lang.Object[] r11 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x00f6 }
            java.lang.String r10 = r10.f840a     // Catch:{ IOException -> 0x00f6 }
            r11[r5] = r10     // Catch:{ IOException -> 0x00f6 }
            r11[r6] = r8     // Catch:{ IOException -> 0x00f6 }
            java.lang.String r10 = "SplitCompat"
            java.lang.String r12 = "NativeLibraryExtractor: using library %s for ABI %s"
            java.lang.String r11 = java.lang.String.format(r12, r11)     // Catch:{ IOException -> 0x00f6 }
            goto L_0x00ba
        L_0x00d4:
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ IOException -> 0x00f6 }
            r9[r5] = r8     // Catch:{ IOException -> 0x00f6 }
            java.lang.String r8 = "SplitCompat"
            java.lang.String r10 = "NativeLibraryExtractor: there are no native libraries for supported ABI %s"
            java.lang.String r9 = java.lang.String.format(r10, r9)     // Catch:{ IOException -> 0x00f6 }
            android.util.Log.d(r8, r9)     // Catch:{ IOException -> 0x00f6 }
        L_0x00e3:
            int r7 = r7 + 1
            goto L_0x0073
        L_0x00e6:
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ IOException -> 0x00f6 }
            java.util.Collection r13 = r13.values()     // Catch:{ IOException -> 0x00f6 }
            r1.<init>(r13)     // Catch:{ IOException -> 0x00f6 }
            r14.mo33697a(r0, r1)     // Catch:{ IOException -> 0x00f6 }
            r0.close()     // Catch:{ IOException -> 0x00f6 }
            return
        L_0x00f6:
            r13 = move-exception
            goto L_0x00fa
        L_0x00f8:
            r13 = move-exception
            r0 = 0
        L_0x00fa:
            if (r0 == 0) goto L_0x0104
            r0.close()     // Catch:{ IOException -> 0x0100 }
            goto L_0x0104
        L_0x0100:
            r14 = move-exception
            com.google.android.play.core.internal.C2039ci.m739a(r13, r14)
        L_0x0104:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitcompat.C2091k.m902a(com.google.android.play.core.splitcompat.q, com.google.android.play.core.splitcompat.h):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m903a(C2097q qVar, Set<C2090j> set, C2089i iVar) throws IOException {
        for (C2090j next : set) {
            File a = this.f844c.mo33684a(qVar.mo33705b(), next.f840a);
            boolean z = false;
            if (a.exists() && a.length() == next.f841b.getSize()) {
                z = true;
            }
            iVar.mo33696a(next, a, z);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Set<File> mo33698a() throws IOException {
        Log.d("SplitCompat", "NativeLibraryExtractor: synchronizing native libraries");
        Set<C2097q> d = this.f844c.mo33691d();
        for (String next : this.f844c.mo33693e()) {
            Iterator<C2097q> it = d.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().mo33705b().equals(next)) {
                        break;
                    }
                } else {
                    Log.i("SplitCompat", String.format("NativeLibraryExtractor: extracted split '%s' has no corresponding split; deleting", new Object[]{next}));
                    this.f844c.mo33692d(next);
                    break;
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (C2097q next2 : d) {
            HashSet hashSet2 = new HashSet();
            m902a(next2, new C2086f(this, hashSet2, next2));
            for (File next3 : this.f844c.mo33694e(next2.mo33705b())) {
                if (!hashSet2.contains(next3)) {
                    Log.i("SplitCompat", String.format("NativeLibraryExtractor: file '%s' found in split '%s' that is not in the split file '%s'; removing", new Object[]{next3.getAbsolutePath(), next2.mo33705b(), next2.mo33704a().getAbsolutePath()}));
                    this.f844c.mo33688b(next3);
                }
            }
            hashSet.addAll(hashSet2);
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public final Set<File> mo33699a(C2097q qVar) throws IOException {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        HashSet hashSet = new HashSet();
        m902a(qVar, new C2085e(this, qVar, hashSet, atomicBoolean));
        if (atomicBoolean.get()) {
            return hashSet;
        }
        return null;
    }
}
