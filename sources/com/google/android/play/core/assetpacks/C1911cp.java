package com.google.android.play.core.assetpacks;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.internal.C2040cj;
import com.google.android.play.core.internal.C2049h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.play.core.assetpacks.cp */
final class C1911cp {

    /* renamed from: a */
    private static final C1982af f539a = new C1982af("ExtractorSessionStoreView");

    /* renamed from: b */
    private final C1870bb f540b;

    /* renamed from: c */
    private final C2040cj<C1966w> f541c;

    /* renamed from: d */
    private final C1894bz f542d;

    /* renamed from: e */
    private final C2040cj<Executor> f543e;

    /* renamed from: f */
    private final Map<Integer, C1908cm> f544f = new HashMap();

    /* renamed from: g */
    private final ReentrantLock f545g = new ReentrantLock();

    C1911cp(C1870bb bbVar, C2040cj<C1966w> cjVar, C1894bz bzVar, C2040cj<Executor> cjVar2) {
        this.f540b = bbVar;
        this.f541c = cjVar;
        this.f542d = bzVar;
        this.f543e = cjVar2;
    }

    /* renamed from: a */
    private final <T> T m420a(C1910co<T> coVar) {
        try {
            mo33441a();
            return coVar.mo33438a();
        } finally {
            mo33446b();
        }
    }

    /* renamed from: d */
    private final Map<String, C1908cm> m421d(List<String> list) {
        return (Map) m420a(new C1901cf(this, list));
    }

    /* renamed from: e */
    private final C1908cm m422e(int i) {
        Map<Integer, C1908cm> map = this.f544f;
        Integer valueOf = Integer.valueOf(i);
        C1908cm cmVar = map.get(valueOf);
        if (cmVar != null) {
            return cmVar;
        }
        throw new C1890bv(String.format("Could not find session %d while trying to get it", new Object[]{valueOf}), i);
    }

    /* renamed from: e */
    private static String m423e(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        if (stringArrayList != null && !stringArrayList.isEmpty()) {
            return stringArrayList.get(0);
        }
        throw new C1890bv("Session without pack received.");
    }

    /* renamed from: e */
    private static <T> List<T> m424e(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Map<String, Integer> mo33440a(List<String> list) {
        return (Map) m420a(new C1904ci(this, list));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo33441a() {
        this.f545g.lock();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo33442a(int i) {
        m420a(new C1903ch(this, i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo33443a(String str, int i, long j) {
        m420a(new C1900ce(this, str, i, j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo33444a(Bundle bundle) {
        return ((Boolean) m420a(new C1898cc(this, bundle))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ Map mo33445b(List list) {
        int i;
        Map<String, C1908cm> d = m421d((List<String>) list);
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            C1908cm cmVar = d.get(str);
            if (cmVar == null) {
                i = 8;
            } else {
                if (C1924db.m471a(cmVar.f532c.f527c)) {
                    try {
                        cmVar.f532c.f527c = 6;
                        this.f543e.mo33606a().execute(new C1905cj(this, cmVar));
                        this.f542d.mo33436a(str);
                    } catch (C1890bv unused) {
                        f539a.mo33553c("Session %d with pack %s does not exist, no need to cancel.", Integer.valueOf(cmVar.f530a), str);
                    }
                }
                i = cmVar.f532c.f527c;
            }
            hashMap.put(str, Integer.valueOf(i));
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo33446b() {
        this.f545g.unlock();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo33447b(int i) {
        m422e(i).f532c.f527c = 5;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo33448b(String str, int i, long j) {
        C1908cm cmVar = m421d((List<String>) Arrays.asList(new String[]{str})).get(str);
        if (cmVar == null || C1924db.m474b(cmVar.f532c.f527c)) {
            f539a.mo33552b(String.format("Could not find pack %s while trying to complete it", new Object[]{str}), new Object[0]);
        }
        this.f540b.mo33399f(str, i, j);
        cmVar.f532c.f527c = 4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo33449b(Bundle bundle) {
        return ((Boolean) m420a(new C1899cd(this, bundle))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ Boolean mo33450c(Bundle bundle) {
        boolean z;
        int i = bundle.getInt("session_id");
        if (i == 0) {
            return true;
        }
        Map<Integer, C1908cm> map = this.f544f;
        Integer valueOf = Integer.valueOf(i);
        if (!map.containsKey(valueOf)) {
            return true;
        }
        C1908cm cmVar = this.f544f.get(valueOf);
        if (cmVar.f532c.f527c == 6) {
            z = false;
        } else {
            z = !C1924db.m472a(cmVar.f532c.f527c, bundle.getInt(C2049h.m757a("status", m423e(bundle))));
        }
        return Boolean.valueOf(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final Map<Integer, C1908cm> mo33451c() {
        return this.f544f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ Map mo33452c(List list) {
        HashMap hashMap = new HashMap();
        for (C1908cm next : this.f544f.values()) {
            String str = next.f532c.f525a;
            if (list.contains(str)) {
                C1908cm cmVar = (C1908cm) hashMap.get(str);
                if ((cmVar == null ? -1 : cmVar.f530a) < next.f530a) {
                    hashMap.put(str, next);
                }
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo33453c(int i) {
        C1908cm e = m422e(i);
        if (C1924db.m474b(e.f532c.f527c)) {
            C1870bb bbVar = this.f540b;
            C1907cl clVar = e.f532c;
            bbVar.mo33399f(clVar.f525a, e.f531b, clVar.f526b);
            C1907cl clVar2 = e.f532c;
            int i2 = clVar2.f527c;
            if (i2 == 5 || i2 == 6) {
                this.f540b.mo33391d(clVar2.f525a);
                return;
            }
            return;
        }
        throw new C1890bv(String.format("Could not safely delete session %d because it is not in a terminal state.", new Object[]{Integer.valueOf(i)}), i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ Boolean mo33454d(Bundle bundle) {
        C1909cn cnVar;
        Bundle bundle2 = bundle;
        int i = bundle2.getInt("session_id");
        if (i == 0) {
            return false;
        }
        Map<Integer, C1908cm> map = this.f544f;
        Integer valueOf = Integer.valueOf(i);
        boolean z = true;
        if (map.containsKey(valueOf)) {
            C1908cm e = m422e(i);
            int i2 = bundle2.getInt(C2049h.m757a("status", e.f532c.f525a));
            if (C1924db.m472a(e.f532c.f527c, i2)) {
                f539a.mo33550a("Found stale update for session %s with status %d.", valueOf, Integer.valueOf(e.f532c.f527c));
                C1907cl clVar = e.f532c;
                String str = clVar.f525a;
                int i3 = clVar.f527c;
                if (i3 == 4) {
                    this.f541c.mo33606a().mo33358a(i, str);
                } else if (i3 == 5) {
                    this.f541c.mo33606a().mo33357a(i);
                } else if (i3 == 6) {
                    this.f541c.mo33606a().mo33361a((List<String>) Arrays.asList(new String[]{str}));
                }
            } else {
                e.f532c.f527c = i2;
                if (C1924db.m474b(i2)) {
                    mo33442a(i);
                    this.f542d.mo33436a(e.f532c.f525a);
                } else {
                    List<C1909cn> list = e.f532c.f529e;
                    int size = list.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        C1909cn cnVar2 = list.get(i4);
                        ArrayList parcelableArrayList = bundle2.getParcelableArrayList(C2049h.m758a("chunk_intents", e.f532c.f525a, cnVar2.f533a));
                        if (parcelableArrayList != null) {
                            for (int i5 = 0; i5 < parcelableArrayList.size(); i5++) {
                                if (!(parcelableArrayList.get(i5) == null || ((Intent) parcelableArrayList.get(i5)).getData() == null)) {
                                    cnVar2.f536d.get(i5).f524a = true;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            String e2 = m423e(bundle);
            long j = bundle2.getLong(C2049h.m757a("pack_version", e2));
            int i6 = bundle2.getInt(C2049h.m757a("status", e2));
            long j2 = bundle2.getLong(C2049h.m757a("total_bytes_to_download", e2));
            ArrayList<String> stringArrayList = bundle2.getStringArrayList(C2049h.m757a("slice_ids", e2));
            ArrayList arrayList = new ArrayList();
            for (T t : m424e(stringArrayList)) {
                ArrayList parcelableArrayList2 = bundle2.getParcelableArrayList(C2049h.m758a("chunk_intents", e2, (String) t));
                ArrayList arrayList2 = new ArrayList();
                for (Intent intent : m424e(parcelableArrayList2)) {
                    if (intent == null) {
                        z = false;
                    }
                    arrayList2.add(new C1906ck(z));
                    z = true;
                }
                String string = bundle2.getString(C2049h.m758a("uncompressed_hash_sha256", e2, (String) t));
                long j3 = bundle2.getLong(C2049h.m758a("uncompressed_size", e2, (String) t));
                int i7 = bundle2.getInt(C2049h.m758a("patch_format", e2, (String) t), 0);
                if (i7 != 0) {
                    cnVar = new C1909cn(t, string, j3, arrayList2, 0, i7);
                } else {
                    cnVar = new C1909cn(t, string, j3, arrayList2, bundle2.getInt(C2049h.m758a("compression_format", e2, (String) t), 0), 0);
                }
                arrayList.add(cnVar);
                z = true;
            }
            this.f544f.put(Integer.valueOf(i), new C1908cm(i, bundle2.getInt("app_version_code"), new C1907cl(e2, j, i6, j2, arrayList)));
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo33455d(int i) {
        m420a(new C1902cg(this, i));
    }
}
