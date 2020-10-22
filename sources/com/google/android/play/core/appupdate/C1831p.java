package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.internal.C1992ap;
import com.google.android.play.core.internal.C2028by;
import com.google.android.play.core.internal.C2055n;
import com.google.android.play.core.splitcompat.C2096p;
import com.google.android.play.core.tasks.C2170i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

/* renamed from: com.google.android.play.core.appupdate.p */
final class C1831p {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final C1982af f243b = new C1982af("AppUpdateService");

    /* renamed from: c */
    private static final Intent f244c = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");
    @Nullable

    /* renamed from: a */
    C1992ap<C2055n> f245a;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final String f246d;

    /* renamed from: e */
    private final Context f247e;

    /* renamed from: f */
    private final C1833r f248f;

    public C1831p(Context context, C1833r rVar) {
        this.f246d = context.getPackageName();
        this.f247e = context;
        this.f248f = rVar;
        if (C2028by.m725a(context)) {
            this.f245a = new C1992ap(C2096p.m907a(context), f243b, "AppUpdateService", f244c, C1825j.f231a);
        }
    }

    /* renamed from: a */
    static /* synthetic */ Bundle m228a(C1831p pVar, String str) {
        Integer num;
        Bundle bundle = new Bundle();
        bundle.putAll(m234d());
        bundle.putString("package.name", str);
        try {
            num = Integer.valueOf(pVar.f247e.getPackageManager().getPackageInfo(pVar.f247e.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            f243b.mo33552b("The current version of the app could not be retrieved", new Object[0]);
            num = null;
        }
        if (num != null) {
            bundle.putInt("app.version.code", num.intValue());
        }
        return bundle;
    }

    /* renamed from: a */
    static /* synthetic */ AppUpdateInfo m229a(C1831p pVar, Bundle bundle, String str) {
        Bundle bundle2 = bundle;
        return AppUpdateInfo.m204a(str, bundle2.getInt("version.code", -1), bundle2.getInt("update.availability"), bundle2.getInt("install.status", 0), bundle2.getInt("client.version.staleness", -1) == -1 ? null : Integer.valueOf(bundle2.getInt("client.version.staleness")), bundle2.getInt("in.app.update.priority", 0), bundle2.getLong("bytes.downloaded"), bundle2.getLong("total.bytes.to.download"), bundle2.getLong("additional.size.required"), pVar.f248f.mo33277a(), (PendingIntent) bundle2.getParcelable("blocking.intent"), (PendingIntent) bundle2.getParcelable("nonblocking.intent"), (PendingIntent) bundle2.getParcelable("blocking.destructive.intent"), (PendingIntent) bundle2.getParcelable("nonblocking.destructive.intent"));
    }

    /* renamed from: c */
    private static <T> Task<T> m233c() {
        f243b.mo33552b("onError(%d)", -9);
        return Tasks.m1052a((Exception) new InstallException(-9));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static Bundle m234d() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore.version.code", 10800);
        return bundle;
    }

    /* renamed from: a */
    public final Task<AppUpdateInfo> mo33275a(String str) {
        if (this.f245a == null) {
            return m233c();
        }
        f243b.mo33553c("requestUpdateInfo(%s)", str);
        C2170i iVar = new C2170i();
        this.f245a.mo33562a((C1983ag) new C1826k(this, iVar, str, iVar));
        return iVar.mo33805a();
    }

    /* renamed from: b */
    public final Task<Void> mo33276b(String str) {
        if (this.f245a == null) {
            return m233c();
        }
        f243b.mo33553c("completeUpdate(%s)", str);
        C2170i iVar = new C2170i();
        this.f245a.mo33562a((C1983ag) new C1827l(this, iVar, iVar, str));
        return iVar.mo33805a();
    }
}
