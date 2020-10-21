package com.google.android.play.core.review.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

public class FakeReviewManager implements ReviewManager {

    /* renamed from: a */
    private final Context f819a;

    /* renamed from: b */
    private ReviewInfo f820b;

    public FakeReviewManager(Context context) {
        this.f819a = context;
    }

    @NonNull
    public Task<Void> launchReviewFlow(@NonNull Activity activity, @NonNull ReviewInfo reviewInfo) {
        return reviewInfo != this.f820b ? Tasks.m1052a((Exception) new C2080a()) : Tasks.m1053a(null);
    }

    @NonNull
    public Task<ReviewInfo> requestReviewFlow() {
        this.f820b = ReviewInfo.m851a(PendingIntent.getBroadcast(this.f819a, 0, new Intent(), 0));
        return Tasks.m1053a(this.f820b);
    }
}
