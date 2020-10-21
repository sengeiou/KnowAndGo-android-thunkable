package com.google.android.play.core.review;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.splitcompat.C2096p;

public class ReviewManagerFactory {
    private ReviewManagerFactory() {
    }

    @NonNull
    public static ReviewManager create(@NonNull Context context) {
        PlayCoreDialogWrapperActivity.m565a(context);
        return new C2074c(new C2079h(C2096p.m907a(context)));
    }
}
