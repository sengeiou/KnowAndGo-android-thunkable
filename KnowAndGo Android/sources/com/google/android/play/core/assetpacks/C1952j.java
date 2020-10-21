package com.google.android.play.core.assetpacks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.play.core.assetpacks.model.AssetPackStatus;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.internal.C2040cj;
import com.google.android.play.core.internal.C2049h;
import com.google.android.play.core.splitinstall.C2140p;
import com.google.android.play.core.tasks.C2170i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.j */
final class C1952j implements AssetPackManager {

    /* renamed from: a */
    private static final C1982af f675a = new C1982af("AssetPackManager");

    /* renamed from: b */
    private final C1870bb f676b;

    /* renamed from: c */
    private final C2040cj<C1966w> f677c;

    /* renamed from: d */
    private final C1864aw f678d;

    /* renamed from: e */
    private final C2140p f679e;

    /* renamed from: f */
    private final C1911cp f680f;

    /* renamed from: g */
    private final C1894bz f681g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C1882bn f682h;

    /* renamed from: i */
    private final C2040cj<Executor> f683i;

    /* renamed from: j */
    private final Handler f684j = new Handler(Looper.getMainLooper());

    /* renamed from: k */
    private boolean f685k;

    C1952j(C1870bb bbVar, C2040cj<C1966w> cjVar, C1864aw awVar, C2140p pVar, C1911cp cpVar, C1894bz bzVar, C1882bn bnVar, C2040cj<Executor> cjVar2) {
        this.f676b = bbVar;
        this.f677c = cjVar;
        this.f678d = awVar;
        this.f679e = pVar;
        this.f680f = cpVar;
        this.f681g = bzVar;
        this.f682h = bnVar;
        this.f683i = cjVar2;
    }

    /* renamed from: c */
    private final void m530c() {
        this.f683i.mo33606a().execute(new C1947e(this));
    }

    /* renamed from: d */
    private final void m531d() {
        this.f683i.mo33606a().execute(new C1948f(this));
        this.f685k = true;
    }

    /* access modifiers changed from: package-private */
    @AssetPackStatus
    /* renamed from: a */
    public final int mo33519a(@AssetPackStatus int i, String str) {
        if (!this.f676b.mo33379a(str) && i == 4) {
            return 8;
        }
        if (!this.f676b.mo33379a(str) || i == 4) {
            return i;
        }
        return 4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo33520a() {
        this.f676b.mo33390d();
        this.f676b.mo33387c();
        this.f676b.mo33395e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo33521a(String str, C2170i iVar) {
        if (this.f676b.mo33391d(str)) {
            iVar.mo33807a(null);
            this.f677c.mo33606a().mo33360a(str);
            return;
        }
        iVar.mo33806a((Exception) new IOException(String.format("Failed to remove pack %s.", new Object[]{str})));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo33522a(boolean z) {
        boolean b = this.f678d.mo33659b();
        this.f678d.mo33657a(z);
        if (z && !b) {
            m530c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo33523b() {
        C1870bb bbVar = this.f676b;
        bbVar.getClass();
        this.f677c.mo33606a().mo33355a(this.f676b.mo33383b()).addOnSuccessListener(this.f683i.mo33606a(), C1949g.m527a(bbVar)).addOnFailureListener(this.f683i.mo33606a(), C1950h.f672a);
    }

    public final AssetPackStates cancel(List<String> list) {
        Map<String, Integer> a = this.f680f.mo33440a(list);
        HashMap hashMap = new HashMap();
        for (String next : list) {
            Integer num = a.get(next);
            hashMap.put(next, AssetPackState.m261a(next, num == null ? 0 : num.intValue(), 0, 0, 0, 0.0d));
        }
        this.f677c.mo33606a().mo33361a(list);
        return AssetPackStates.m262a(0, (Map<String, AssetPackState>) hashMap);
    }

    public final void clearListeners() {
        this.f678d.mo33654a();
    }

    public final Task<AssetPackStates> fetch(List<String> list) {
        Map<String, Long> b = this.f676b.mo33383b();
        ArrayList arrayList = new ArrayList(list);
        arrayList.removeAll(b.keySet());
        ArrayList arrayList2 = new ArrayList(list);
        arrayList2.removeAll(arrayList);
        if (!arrayList.isEmpty()) {
            return this.f677c.mo33606a().mo33354a((List<String>) arrayList2, (List<String>) arrayList, b);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt("error_code", 0);
        for (String next : list) {
            bundle.putInt(C2049h.m757a("status", next), 4);
            bundle.putInt(C2049h.m757a("error_code", next), 0);
            bundle.putLong(C2049h.m757a("total_bytes_to_download", next), 0);
            bundle.putLong(C2049h.m757a("bytes_downloaded", next), 0);
        }
        bundle.putStringArrayList("pack_names", new ArrayList(list));
        bundle.putLong("total_bytes_to_download", 0);
        bundle.putLong("bytes_downloaded", 0);
        return Tasks.m1053a(AssetPackStates.m263a(bundle, this.f681g));
    }

    @Nullable
    public final AssetLocation getAssetLocation(String str, String str2) {
        AssetPackLocation assetPackLocation;
        if (!this.f685k) {
            this.f683i.mo33606a().execute(new C1948f(this));
            this.f685k = true;
        }
        if (this.f676b.mo33379a(str)) {
            try {
                assetPackLocation = this.f676b.mo33380b(str);
            } catch (IOException unused) {
            }
        } else {
            if (this.f679e.mo33767a().contains(str)) {
                assetPackLocation = AssetPackLocation.m258a();
            }
            assetPackLocation = null;
        }
        if (assetPackLocation == null) {
            return null;
        }
        if (assetPackLocation.packStorageMethod() == 1) {
            return this.f676b.mo33372a(str, str2);
        }
        if (assetPackLocation.packStorageMethod() == 0) {
            return this.f676b.mo33373a(str, str2, assetPackLocation);
        }
        f675a.mo33550a("The asset %s is not present in Asset Pack %s", str2, str);
        return null;
    }

    @Nullable
    public final AssetPackLocation getPackLocation(String str) {
        if (!this.f685k) {
            m531d();
        }
        if (this.f676b.mo33379a(str)) {
            try {
                return this.f676b.mo33380b(str);
            } catch (IOException unused) {
                return null;
            }
        } else if (this.f679e.mo33767a().contains(str)) {
            return AssetPackLocation.m258a();
        } else {
            return null;
        }
    }

    public final Map<String, AssetPackLocation> getPackLocations() {
        Map<String, AssetPackLocation> a = this.f676b.mo33376a();
        HashMap hashMap = new HashMap();
        for (String put : this.f679e.mo33767a()) {
            hashMap.put(put, AssetPackLocation.m258a());
        }
        a.putAll(hashMap);
        return a;
    }

    public final Task<AssetPackStates> getPackStates(List<String> list) {
        return this.f677c.mo33606a().mo33353a(list, (C1867az) new C1895c(this), this.f676b.mo33383b());
    }

    public final synchronized void registerListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
        boolean b = this.f678d.mo33659b();
        this.f678d.mo33655a(assetPackStateUpdateListener);
        if (!b) {
            m530c();
        }
    }

    public final Task<Void> removePack(String str) {
        C2170i iVar = new C2170i();
        this.f683i.mo33606a().execute(new C1922d(this, str, iVar));
        return iVar.mo33805a();
    }

    public final Task<Integer> showCellularDataConfirmation(Activity activity) {
        if (this.f682h.mo33425a() == null) {
            return Tasks.m1052a((Exception) new AssetPackException(-12));
        }
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", this.f682h.mo33425a());
        C2170i iVar = new C2170i();
        intent.putExtra("result_receiver", new C1951i(this, this.f684j, iVar));
        activity.startActivity(intent);
        return iVar.mo33805a();
    }

    public final void unregisterListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
        this.f678d.mo33658b(assetPackStateUpdateListener);
    }
}
