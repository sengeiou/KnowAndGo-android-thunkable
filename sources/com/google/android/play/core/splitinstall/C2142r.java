package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;

/* renamed from: com.google.android.play.core.splitinstall.r */
final class C2142r implements C2127d {

    /* renamed from: a */
    final /* synthetic */ SplitInstallSessionState f937a;

    /* renamed from: b */
    final /* synthetic */ Intent f938b;

    /* renamed from: c */
    final /* synthetic */ Context f939c;

    /* renamed from: d */
    final /* synthetic */ C2144t f940d;

    C2142r(C2144t tVar, SplitInstallSessionState splitInstallSessionState, Intent intent, Context context) {
        this.f940d = tVar;
        this.f937a = splitInstallSessionState;
        this.f938b = intent;
        this.f939c = context;
    }

    /* renamed from: a */
    public final void mo33759a() {
        this.f940d.f946d.post(new C2143s(this.f940d, this.f937a, 5, 0));
    }

    /* renamed from: a */
    public final void mo33760a(@SplitInstallErrorCode int i) {
        this.f940d.f946d.post(new C2143s(this.f940d, this.f937a, 6, i));
    }

    /* renamed from: b */
    public final void mo33761b() {
        if (!this.f938b.getBooleanExtra("triggered_from_app_after_verification", false)) {
            this.f938b.putExtra("triggered_from_app_after_verification", true);
            this.f939c.sendBroadcast(this.f938b);
            return;
        }
        this.f940d.f791a.mo33552b("Splits copied and verified more than once.", new Object[0]);
    }
}
