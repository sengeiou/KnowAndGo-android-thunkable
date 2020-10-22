package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.internal.C1992ap;
import com.google.android.play.core.internal.C2028by;
import com.google.android.play.core.internal.C2060s;
import com.google.android.play.core.splitcompat.C2096p;
import com.google.android.play.core.tasks.C2170i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.play.core.assetpacks.ar */
final class C1859ar implements C1966w {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final C1982af f354a = new C1982af("AssetPackServiceImpl");

    /* renamed from: b */
    private static final Intent f355b = new Intent("com.google.android.play.core.assetmoduleservice.BIND_ASSET_MODULE_SERVICE").setPackage("com.android.vending");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f356c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C1894bz f357d;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: e */
    public C1992ap<C2060s> f358e;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: f */
    public C1992ap<C2060s> f359f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final AtomicBoolean f360g = new AtomicBoolean();

    C1859ar(Context context, C1894bz bzVar) {
        this.f356c = context.getPackageName();
        this.f357d = bzVar;
        if (C2028by.m725a(context)) {
            this.f358e = new C1992ap(C2096p.m907a(context), f354a, "AssetPackService", f355b, C1967x.f708a);
            this.f359f = new C1992ap(C2096p.m907a(context), f354a, "AssetPackService-keepAlive", f355b, C1968y.f709a);
        }
        f354a.mo33550a("AssetPackService initiated.", new Object[0]);
    }

    /* renamed from: a */
    static /* synthetic */ ArrayList m299a(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* renamed from: a */
    static /* synthetic */ List m300a(C1859ar arVar, List list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AssetPackState next = AssetPackStates.m263a((Bundle) list.get(i), arVar.f357d).packStates().values().iterator().next();
            if (next == null) {
                f354a.mo33552b("onGetSessionStates: Bundle contained no pack.", new Object[0]);
            }
            if (C1924db.m471a(next.status())) {
                arrayList.add(next.name());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m301a(int i, String str, int i2) {
        if (this.f358e != null) {
            f354a.mo33553c("notifyModuleCompleted", new Object[0]);
            C2170i iVar = new C2170i();
            this.f358e.mo33562a((C1983ag) new C1848ag(this, iVar, i, str, iVar, i2));
            return;
        }
        throw new C1890bv("The Play Store app is not installed or is an unofficial version.", i);
    }

    /* renamed from: b */
    static /* synthetic */ Bundle m305b(Map map) {
        Bundle e = m315e();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            Bundle bundle = new Bundle();
            bundle.putString("installed_asset_module_name", (String) entry.getKey());
            bundle.putLong("installed_asset_module_version", ((Long) entry.getValue()).longValue());
            arrayList.add(bundle);
        }
        e.putParcelableArrayList("installed_asset_module", arrayList);
        return e;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static Bundle m309c(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", i);
        return bundle;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static Bundle m310c(int i, String str) {
        Bundle c = m309c(i);
        c.putString("module_name", str);
        return c;
    }

    /* renamed from: c */
    static /* synthetic */ Bundle m311c(int i, String str, String str2, int i2) {
        Bundle c = m310c(i, str);
        c.putString("slice_id", str2);
        c.putInt("chunk_number", i2);
        return c;
    }

    /* renamed from: d */
    private static <T> Task<T> m314d() {
        f354a.mo33552b("onError(%d)", -11);
        return Tasks.m1052a((Exception) new AssetPackException(-11));
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static Bundle m315e() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10800);
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        bundle.putIntegerArrayList("supported_compression_formats", arrayList);
        bundle.putIntegerArrayList("supported_patch_formats", new ArrayList());
        return bundle;
    }

    /* renamed from: a */
    public final Task<AssetPackStates> mo33353a(List<String> list, C1867az azVar, Map<String, Long> map) {
        if (this.f358e == null) {
            return m314d();
        }
        f354a.mo33553c("getPackStates(%s)", list);
        C2170i iVar = new C2170i();
        this.f358e.mo33562a((C1983ag) new C1846ae(this, iVar, list, map, iVar, azVar));
        return iVar.mo33805a();
    }

    /* renamed from: a */
    public final Task<AssetPackStates> mo33354a(List<String> list, List<String> list2, Map<String, Long> map) {
        if (this.f358e == null) {
            return m314d();
        }
        f354a.mo33553c("startDownload(%s)", list2);
        C2170i iVar = new C2170i();
        this.f358e.mo33562a((C1983ag) new C1843ab(this, iVar, list2, map, iVar, list));
        iVar.mo33805a().addOnSuccessListener(new C1969z(this));
        return iVar.mo33805a();
    }

    /* renamed from: a */
    public final Task<List<String>> mo33355a(Map<String, Long> map) {
        if (this.f358e == null) {
            return m314d();
        }
        f354a.mo33553c("syncPacks", new Object[0]);
        C2170i iVar = new C2170i();
        this.f358e.mo33562a((C1983ag) new C1845ad(this, iVar, map, iVar));
        return iVar.mo33805a();
    }

    /* renamed from: a */
    public final synchronized void mo33356a() {
        if (this.f359f == null) {
            f354a.mo33554d("Keep alive connection manager is not initialized.", new Object[0]);
            return;
        }
        f354a.mo33553c("keepAlive", new Object[0]);
        if (!this.f360g.compareAndSet(false, true)) {
            f354a.mo33553c("Service is already kept alive.", new Object[0]);
            return;
        }
        C2170i iVar = new C2170i();
        this.f359f.mo33562a((C1983ag) new C1851aj(this, iVar, iVar));
    }

    /* renamed from: a */
    public final void mo33357a(int i) {
        if (this.f358e != null) {
            f354a.mo33553c("notifySessionFailed", new Object[0]);
            C2170i iVar = new C2170i();
            this.f358e.mo33562a((C1983ag) new C1849ah(this, iVar, i, iVar));
            return;
        }
        throw new C1890bv("The Play Store app is not installed or is an unofficial version.", i);
    }

    /* renamed from: a */
    public final void mo33358a(int i, String str) {
        m301a(i, str, 10);
    }

    /* renamed from: a */
    public final void mo33359a(int i, String str, String str2, int i2) {
        if (this.f358e != null) {
            f354a.mo33553c("notifyChunkTransferred", new Object[0]);
            C2170i iVar = new C2170i();
            this.f358e.mo33562a((C1983ag) new C1847af(this, iVar, i, str, str2, i2, iVar));
            return;
        }
        throw new C1890bv("The Play Store app is not installed or is an unofficial version.", i);
    }

    /* renamed from: a */
    public final void mo33360a(String str) {
        if (this.f358e != null) {
            f354a.mo33553c("removePack(%s)", str);
            C2170i iVar = new C2170i();
            this.f358e.mo33562a((C1983ag) new C1842aa(this, iVar, str, iVar));
        }
    }

    /* renamed from: a */
    public final void mo33361a(List<String> list) {
        if (this.f358e != null) {
            f354a.mo33553c("cancelDownloads(%s)", list);
            C2170i iVar = new C2170i();
            this.f358e.mo33562a((C1983ag) new C1844ac(this, iVar, list, iVar));
        }
    }

    /* renamed from: b */
    public final Task<ParcelFileDescriptor> mo33362b(int i, String str, String str2, int i2) {
        if (this.f358e == null) {
            return m314d();
        }
        f354a.mo33553c("getChunkFileDescriptor(%s, %s, %d, session=%d)", str, str2, Integer.valueOf(i2), Integer.valueOf(i));
        C2170i iVar = new C2170i();
        this.f358e.mo33562a((C1983ag) new C1850ai(this, iVar, i, str, str2, i2, iVar));
        return iVar.mo33805a();
    }
}
