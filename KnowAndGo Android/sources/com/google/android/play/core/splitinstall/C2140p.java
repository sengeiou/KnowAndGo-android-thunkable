package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.play.core.internal.C1982af;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitinstall.p */
public final class C2140p {

    /* renamed from: a */
    private static final C1982af f933a = new C1982af("SplitInstallInfoProvider");

    /* renamed from: b */
    private final Context f934b;

    /* renamed from: c */
    private final String f935c;

    public C2140p(Context context) {
        this.f934b = context;
        this.f935c = context.getPackageName();
    }

    public C2140p(Context context, String str) {
        this.f934b = context;
        this.f935c = str;
    }

    /* renamed from: a */
    public static boolean m998a(String str) {
        return str.startsWith("config.");
    }

    /* renamed from: b */
    public static boolean m999b(String str) {
        return m998a(str) || str.contains(".config.");
    }

    /* renamed from: d */
    private final Set<String> m1000d() {
        HashSet hashSet = new HashSet();
        Bundle e = m1001e();
        if (e != null) {
            String string = e.getString("com.android.dynamic.apk.fused.modules");
            if (string == null || string.isEmpty()) {
                f933a.mo33550a("App has no fused modules.", new Object[0]);
            } else {
                Collections.addAll(hashSet, string.split(",", -1));
                hashSet.remove("");
                hashSet.remove("base");
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = null;
            try {
                PackageInfo packageInfo = this.f934b.getPackageManager().getPackageInfo(this.f935c, 0);
                if (packageInfo != null) {
                    strArr = packageInfo.splitNames;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                f933a.mo33554d("App is not found in PackageManager", new Object[0]);
            }
            if (strArr != null) {
                f933a.mo33550a("Adding splits from package manager: %s", Arrays.toString(strArr));
                Collections.addAll(hashSet, strArr);
            } else {
                f933a.mo33550a("No splits are found or app cannot be found in package manager.", new Object[0]);
            }
            C2138n a = C2139o.m996a();
            if (a != null) {
                hashSet.addAll(a.mo33700a());
            }
        }
        return hashSet;
    }

    @Nullable
    /* renamed from: e */
    private final Bundle m1001e() {
        try {
            ApplicationInfo applicationInfo = this.f934b.getPackageManager().getApplicationInfo(this.f935c, 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                return applicationInfo.metaData;
            }
            f933a.mo33550a("App has no applicationInfo or metaData", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            f933a.mo33554d("App is not found in PackageManager", new Object[0]);
            return null;
        }
    }

    /* renamed from: a */
    public final Set<String> mo33767a() {
        HashSet hashSet = new HashSet();
        for (String next : m1000d()) {
            if (!m999b(next)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: b */
    public final Set<String> mo33768b() {
        C2131h c = mo33769c();
        if (c == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Set<String> d = m1000d();
        d.add("");
        Set<String> a = mo33767a();
        a.add("");
        for (Map.Entry next : c.mo33765a(a).entrySet()) {
            if (d.containsAll((Collection) next.getValue())) {
                hashSet.add((String) next.getKey());
            }
        }
        return hashSet;
    }

    @Nullable
    /* renamed from: c */
    public final C2131h mo33769c() {
        C1982af afVar;
        String str;
        Bundle e = m1001e();
        if (e == null) {
            afVar = f933a;
            str = "No metadata found in Context.";
        } else {
            int i = e.getInt("com.android.vending.splits");
            if (i == 0) {
                afVar = f933a;
                str = "No metadata found in AndroidManifest.";
            } else {
                try {
                    C2131h a = new C2124az(this.f934b.getResources().getXml(i)).mo33754a();
                    if (a == null) {
                        f933a.mo33554d("Can't parse languages metadata.", new Object[0]);
                    }
                    return a;
                } catch (Resources.NotFoundException unused) {
                    afVar = f933a;
                    str = "Resource with languages metadata doesn't exist.";
                }
            }
        }
        afVar.mo33554d(str, new Object[0]);
        return null;
    }
}
