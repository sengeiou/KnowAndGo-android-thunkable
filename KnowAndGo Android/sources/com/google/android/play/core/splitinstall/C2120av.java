package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.internal.C1992ap;
import com.google.android.play.core.internal.C2024bu;
import com.google.android.play.core.internal.C2028by;
import com.google.android.play.core.splitcompat.C2096p;
import com.google.android.play.core.tasks.C2170i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.av */
final class C2120av {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final C1982af f899b = new C1982af("SplitInstallService");

    /* renamed from: c */
    private static final Intent f900c = new Intent("com.google.android.play.core.splitinstall.BIND_SPLIT_INSTALL_SERVICE").setPackage("com.android.vending");
    @Nullable

    /* renamed from: a */
    C1992ap<C2024bu> f901a;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final String f902d;

    public C2120av(Context context) {
        this.f902d = context.getPackageName();
        if (C2028by.m725a(context)) {
            this.f901a = new C1992ap(C2096p.m907a(context), f899b, "SplitInstallService", f900c, C2102ad.f872a);
        }
    }

    /* renamed from: a */
    static /* synthetic */ ArrayList m954a(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* renamed from: b */
    static /* synthetic */ Bundle m955b() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10800);
        return bundle;
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.util.List, java.util.Collection] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.util.ArrayList m956b(java.util.Collection r6) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r6.size()
            r0.<init>(r1)
            int r1 = r6.size()
            r2 = 0
        L_0x000e:
            if (r2 >= r1) goto L_0x0026
            java.lang.Object r3 = r6.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            java.lang.String r5 = "language"
            r4.putString(r5, r3)
            r0.add(r4)
            int r2 = r2 + 1
            goto L_0x000e
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.C2120av.m956b(java.util.Collection):java.util.ArrayList");
    }

    /* renamed from: d */
    private static <T> Task<T> m958d() {
        f899b.mo33552b("onError(%d)", -14);
        return Tasks.m1052a((Exception) new SplitInstallException(-14));
    }

    /* renamed from: a */
    public final Task<List<SplitInstallSessionState>> mo33744a() {
        if (this.f901a == null) {
            return m958d();
        }
        f899b.mo33553c("getSessionStates", new Object[0]);
        C2170i iVar = new C2170i();
        this.f901a.mo33562a((C1983ag) new C2109ak(this, iVar, iVar));
        return iVar.mo33805a();
    }

    /* renamed from: a */
    public final Task<SplitInstallSessionState> mo33745a(int i) {
        if (this.f901a == null) {
            return m958d();
        }
        f899b.mo33553c("getSessionState(%d)", Integer.valueOf(i));
        C2170i iVar = new C2170i();
        this.f901a.mo33562a((C1983ag) new C2108aj(this, iVar, i, iVar));
        return iVar.mo33805a();
    }

    /* renamed from: a */
    public final Task<Integer> mo33746a(Collection<String> collection, Collection<String> collection2) {
        if (this.f901a == null) {
            return m958d();
        }
        f899b.mo33553c("startInstall(%s,%s)", collection, collection2);
        C2170i iVar = new C2170i();
        this.f901a.mo33562a((C1983ag) new C2103ae(this, iVar, collection, collection2, iVar));
        return iVar.mo33805a();
    }

    /* renamed from: a */
    public final Task<Void> mo33747a(List<String> list) {
        if (this.f901a == null) {
            return m958d();
        }
        f899b.mo33553c("deferredUninstall(%s)", list);
        C2170i iVar = new C2170i();
        this.f901a.mo33562a((C1983ag) new C2104af(this, iVar, list, iVar));
        return iVar.mo33805a();
    }

    /* renamed from: b */
    public final Task<Void> mo33748b(int i) {
        if (this.f901a == null) {
            return m958d();
        }
        f899b.mo33553c("cancelInstall(%d)", Integer.valueOf(i));
        C2170i iVar = new C2170i();
        this.f901a.mo33562a((C1983ag) new C2110al(this, iVar, i, iVar));
        return iVar.mo33805a();
    }

    /* renamed from: b */
    public final Task<Void> mo33749b(List<String> list) {
        if (this.f901a == null) {
            return m958d();
        }
        f899b.mo33553c("deferredInstall(%s)", list);
        C2170i iVar = new C2170i();
        this.f901a.mo33562a((C1983ag) new C2105ag(this, iVar, list, iVar));
        return iVar.mo33805a();
    }

    /* renamed from: c */
    public final Task<Void> mo33750c(List<String> list) {
        if (this.f901a == null) {
            return m958d();
        }
        f899b.mo33553c("deferredLanguageInstall(%s)", list);
        C2170i iVar = new C2170i();
        this.f901a.mo33562a((C1983ag) new C2106ah(this, iVar, list, iVar));
        return iVar.mo33805a();
    }

    /* renamed from: d */
    public final Task<Void> mo33751d(List<String> list) {
        if (this.f901a == null) {
            return m958d();
        }
        f899b.mo33553c("deferredLanguageUninstall(%s)", list);
        C2170i iVar = new C2170i();
        this.f901a.mo33562a((C1983ag) new C2107ai(this, iVar, list, iVar));
        return iVar.mo33805a();
    }
}
