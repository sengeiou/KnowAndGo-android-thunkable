package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C2031ca;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* renamed from: com.google.android.play.core.assetpacks.be */
final class C1873be extends C2031ca {

    /* renamed from: a */
    private final File f403a;

    /* renamed from: b */
    private final File f404b;

    /* renamed from: c */
    private final NavigableMap<Long, File> f405c = new TreeMap();

    C1873be(File file, File file2) throws IOException {
        this.f403a = file;
        this.f404b = file2;
        List<File> a = C1942dt.m513a(this.f403a, this.f404b);
        if (!a.isEmpty()) {
            int size = a.size();
            long j = 0;
            for (int i = 0; i < size; i++) {
                File file3 = a.get(i);
                this.f405c.put(Long.valueOf(j), file3);
                j += file3.length();
            }
            return;
        }
        throw new C1890bv(String.format("Virtualized slice archive empty for %s, %s", new Object[]{this.f403a, this.f404b}));
    }

    /* renamed from: a */
    private final InputStream m378a(long j, Long l) throws IOException {
        FileInputStream fileInputStream = new FileInputStream((File) this.f405c.get(l));
        if (fileInputStream.skip(j - l.longValue()) == j - l.longValue()) {
            return fileInputStream;
        }
        throw new C1890bv(String.format("Virtualized slice archive corrupt, could not skip in file with key %s", new Object[]{l}));
    }

    /* renamed from: a */
    public final long mo33403a() {
        Map.Entry<Long, File> lastEntry = this.f405c.lastEntry();
        return lastEntry.getKey().longValue() + lastEntry.getValue().length();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final InputStream mo33404a(long j, long j2) throws IOException {
        if (j < 0 || j2 < 0) {
            throw new C1890bv(String.format("Invalid input parameters %s, %s", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        }
        long j3 = j + j2;
        if (j3 <= mo33403a()) {
            Long floorKey = this.f405c.floorKey(Long.valueOf(j));
            Long floorKey2 = this.f405c.floorKey(Long.valueOf(j3));
            if (floorKey.equals(floorKey2)) {
                return new C1872bd(m378a(j, floorKey), j2);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(m378a(j, floorKey));
            Collection values = this.f405c.subMap(floorKey, false, floorKey2, false).values();
            if (!values.isEmpty()) {
                arrayList.add(new C1925dc(Collections.enumeration(values)));
            }
            arrayList.add(new C1872bd(new FileInputStream((File) this.f405c.get(floorKey2)), j2 - (floorKey2.longValue() - j)));
            return new SequenceInputStream(Collections.enumeration(arrayList));
        }
        throw new C1890bv(String.format("Trying to access archive out of bounds. Archive ends at: %s. Tried accessing: %s", new Object[]{Long.valueOf(mo33403a()), Long.valueOf(j3)}));
    }

    public final void close() {
    }
}
