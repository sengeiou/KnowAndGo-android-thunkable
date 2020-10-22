package com.google.android.play.core.review;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.tasks.C2170i;
import com.google.android.play.core.tasks.Task;

/* renamed from: com.google.android.play.core.review.c */
public final class C2074c implements ReviewManager {

    /* renamed from: a */
    private final C2079h f808a;

    /* renamed from: b */
    private final Handler f809b = new Handler(Looper.getMainLooper());

    C2074c(C2079h hVar) {
        this.f808a = hVar;
    }

    @NonNull
    public final Task<Void> launchReviewFlow(@NonNull Activity activity, @NonNull ReviewInfo reviewInfo) {
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", reviewInfo.mo33669a());
        C2170i iVar = new C2170i();
        intent.putExtra("result_receiver", new C2073b(this.f809b, iVar));
        activity.startActivity(intent);
        return iVar.mo33805a();
    }

    @NonNull
    public final Task<ReviewInfo> requestReviewFlow() {
        return this.f808a.mo33678a();
    }
}
