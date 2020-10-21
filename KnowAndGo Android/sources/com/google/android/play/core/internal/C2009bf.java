package com.google.android.play.core.internal;

import com.google.android.play.core.splitinstall.C2134k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.bf */
final class C2009bf implements C1997au {
    C2009bf() {
    }

    /* renamed from: a */
    static C2002az m650a() {
        return new C2006bc();
    }

    /* renamed from: a */
    public static void m651a(ClassLoader classLoader, Set<File> set, C2008be beVar) {
        if (!set.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (File parentFile : set) {
                hashSet.add(parentFile.getParentFile());
            }
            Object a = C2004ba.m639a(classLoader);
            C2019bp<List> a2 = C2020bq.m677a(a, "nativeLibraryDirectories", List.class);
            synchronized (C2134k.class) {
                ArrayList arrayList = new ArrayList(a2.mo33574a());
                hashSet.removeAll(arrayList);
                arrayList.addAll(hashSet);
                a2.mo33575a(arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            Object[] a3 = beVar.mo33573a(a, new ArrayList(hashSet), arrayList2);
            if (!arrayList2.isEmpty()) {
                C2018bo boVar = new C2018bo("Error in makePathElements");
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    C2039ci.m739a(boVar, (IOException) arrayList2.get(i));
                }
                throw boVar;
            }
            synchronized (C2134k.class) {
                C2020bq.m691b(a, "nativeLibraryPathElements", Object.class).mo33578b(Arrays.asList(a3));
            }
        }
    }

    /* renamed from: b */
    static C2008be m652b() {
        return new C2007bd();
    }

    /* renamed from: b */
    public static boolean m653b(ClassLoader classLoader, File file, File file2, boolean z) {
        return C2004ba.m640a(classLoader, file, file2, z, m650a(), "zip", C2004ba.m641b());
    }

    /* renamed from: a */
    public final void mo33569a(ClassLoader classLoader, Set<File> set) {
        m651a(classLoader, set, m652b());
    }

    /* renamed from: a */
    public final boolean mo33570a(ClassLoader classLoader, File file, File file2, boolean z) {
        return m653b(classLoader, file, file2, z);
    }
}
