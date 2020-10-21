package com.google.android.play.core.internal;

import android.util.Log;
import com.google.android.play.core.splitinstall.C2134k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.ba */
final class C2004ba implements C1997au {
    C2004ba() {
    }

    /* renamed from: a */
    static C2002az m638a() {
        return new C1999aw();
    }

    /* renamed from: a */
    static Object m639a(ClassLoader classLoader) {
        return C2020bq.m677a((Object) classLoader, "pathList", Object.class).mo33574a();
    }

    /* renamed from: a */
    static boolean m640a(ClassLoader classLoader, File file, File file2, boolean z, C2002az azVar, String str, C2001ay ayVar) {
        ArrayList arrayList = new ArrayList();
        Object a = m639a(classLoader);
        C2019bp b = C2020bq.m691b(a, "dexElements", Object.class);
        List<Object> asList = Arrays.asList((Object[]) b.mo33574a());
        ArrayList arrayList2 = new ArrayList();
        for (Object a2 : asList) {
            arrayList2.add(C2020bq.m677a(a2, str, File.class).mo33574a());
        }
        if (arrayList2.contains(file2)) {
            return true;
        }
        if (z || ayVar.mo33572a(a, file2, file)) {
            b.mo33576a((Collection) Arrays.asList(azVar.mo33571a(a, new ArrayList(Collections.singleton(file2)), file, arrayList)));
            if (arrayList.isEmpty()) {
                return true;
            }
            C2018bo boVar = new C2018bo("DexPathList.makeDexElement failed");
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                IOException iOException = (IOException) arrayList.get(i);
                Log.e("SplitCompat", "DexPathList.makeDexElement failed", iOException);
                C2039ci.m739a(boVar, iOException);
            }
            C2020bq.m691b(a, "dexElementsSuppressedExceptions", IOException.class).mo33576a((Collection) arrayList);
            throw boVar;
        }
        String valueOf = String.valueOf(file2.getPath());
        Log.w("SplitCompat", valueOf.length() != 0 ? "Should be optimized ".concat(valueOf) : new String("Should be optimized "));
        return false;
    }

    /* renamed from: b */
    static C2001ay m641b() {
        return new C2000ax();
    }

    /* renamed from: b */
    static void m642b(ClassLoader classLoader, Set<File> set) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File next : set) {
                String valueOf = String.valueOf(next.getParentFile().getAbsolutePath());
                Log.d("Splitcompat", valueOf.length() != 0 ? "Adding native library parent directory: ".concat(valueOf) : new String("Adding native library parent directory: "));
                hashSet.add(next.getParentFile());
            }
            C2019bp b = C2020bq.m691b(m639a(classLoader), "nativeLibraryDirectories", File.class);
            hashSet.removeAll(Arrays.asList((File[]) b.mo33574a()));
            synchronized (C2134k.class) {
                int size = hashSet.size();
                StringBuilder sb = new StringBuilder(30);
                sb.append("Adding directories ");
                sb.append(size);
                Log.d("Splitcompat", sb.toString());
                b.mo33578b(hashSet);
            }
        }
    }

    /* renamed from: a */
    public final void mo33569a(ClassLoader classLoader, Set<File> set) {
        m642b(classLoader, set);
    }

    /* renamed from: a */
    public final boolean mo33570a(ClassLoader classLoader, File file, File file2, boolean z) {
        return m640a(classLoader, file, file2, z, m638a(), "zip", m641b());
    }
}
