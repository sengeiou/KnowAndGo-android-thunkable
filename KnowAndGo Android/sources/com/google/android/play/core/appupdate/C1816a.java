package com.google.android.play.core.appupdate;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.listener.C2069b;

/* renamed from: com.google.android.play.core.appupdate.a */
public final class C1816a extends C2069b<InstallState> {
    public C1816a(Context context) {
        super(new C1982af("AppUpdateListenerRegistry"), new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"), context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo33265a(Context context, Intent intent) {
        if (!context.getPackageName().equals(intent.getStringExtra("package.name"))) {
            this.f791a.mo33550a("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", intent.getStringExtra("package.name"));
            return;
        }
        this.f791a.mo33550a("List of extras in received intent:", new Object[0]);
        for (String str : intent.getExtras().keySet()) {
            this.f791a.mo33550a("Key: %s; value: %s", str, intent.getExtras().get(str));
        }
        C1982af afVar = this.f791a;
        afVar.mo33550a("List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
        afVar.mo33550a("Key: %s; value: %s", "install.status", Integer.valueOf(intent.getIntExtra("install.status", 0)));
        afVar.mo33550a("Key: %s; value: %s", "error.code", Integer.valueOf(intent.getIntExtra("error.code", 0)));
        InstallState a = InstallState.m574a(intent.getIntExtra("install.status", 0), intent.getLongExtra("bytes.downloaded", 0), intent.getLongExtra("total.bytes.to.download", 0), intent.getIntExtra("error.code", 0), intent.getStringExtra("package.name"));
        this.f791a.mo33550a("ListenerRegistryBroadcastReceiver.onReceive: %s", a);
        mo33656a(a);
    }
}
