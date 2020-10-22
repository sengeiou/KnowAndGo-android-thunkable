package com.google.android.play.core.review;

import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.internal.C1978ab;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.internal.C1983ag;
import com.google.android.play.core.internal.C1992ap;
import com.google.android.play.core.tasks.C2170i;
import com.google.android.play.core.tasks.Task;

/* renamed from: com.google.android.play.core.review.h */
public final class C2079h {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final C1982af f816b = new C1982af("ReviewService");

    /* renamed from: a */
    final C1992ap<C1978ab> f817a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f818c;

    public C2079h(Context context) {
        this.f818c = context.getPackageName();
        Context context2 = context;
        this.f817a = new C1992ap(context2, f816b, "com.google.android.finsky.inappreviewservice.InAppReviewService", new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE").setPackage("com.android.vending"), C2075d.f810a);
    }

    /* renamed from: a */
    public final Task<ReviewInfo> mo33678a() {
        f816b.mo33553c("requestInAppReview (%s)", this.f818c);
        C2170i iVar = new C2170i();
        this.f817a.mo33562a((C1983ag) new C2076e(this, iVar, iVar));
        return iVar.mo33805a();
    }
}
