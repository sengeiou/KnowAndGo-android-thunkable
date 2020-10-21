package com.google.android.play.core.missingsplits;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.play.core.internal.C1982af;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.play.core.missingsplits.a */
final class C2070a {

    /* renamed from: a */
    private static final C1982af f798a = new C1982af("MissingSplitsAppComponentsHelper");

    /* renamed from: b */
    private final Context f799b;

    /* renamed from: c */
    private final PackageManager f800c;

    C2070a(Context context, PackageManager packageManager) {
        this.f799b = context;
        this.f800c = packageManager;
    }

    /* renamed from: a */
    private final void m842a(List<ComponentInfo> list, int i) {
        for (ComponentInfo next : list) {
            this.f800c.setComponentEnabledSetting(new ComponentName(next.packageName, next.name), i, 1);
        }
    }

    /* renamed from: d */
    private final List<ComponentInfo> m843d() {
        try {
            ArrayList arrayList = new ArrayList();
            PackageInfo packageInfo = this.f800c.getPackageInfo(this.f799b.getPackageName(), 526);
            if (packageInfo.providers != null) {
                Collections.addAll(arrayList, packageInfo.providers);
            }
            if (packageInfo.receivers != null) {
                Collections.addAll(arrayList, packageInfo.receivers);
            }
            if (packageInfo.services != null) {
                Collections.addAll(arrayList, packageInfo.services);
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            f798a.mo33554d("Failed to resolve own package : %s", e);
            return Collections.emptyList();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo33666a() {
        for (ComponentInfo next : m843d()) {
            if (this.f800c.getComponentEnabledSetting(new ComponentName(next.packageName, next.name)) != 2) {
                f798a.mo33550a("Not all non-activity components are disabled", new Object[0]);
                return false;
            }
        }
        f798a.mo33550a("All non-activity components are disabled", new Object[0]);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo33667b() {
        f798a.mo33553c("Disabling all non-activity components", new Object[0]);
        m842a(m843d(), 2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo33668c() {
        f798a.mo33553c("Resetting enabled state of all non-activity components", new Object[0]);
        m842a(m843d(), 0);
    }
}
