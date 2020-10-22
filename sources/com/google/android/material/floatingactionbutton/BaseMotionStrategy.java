package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import java.util.ArrayList;
import java.util.List;

abstract class BaseMotionStrategy implements MotionStrategy {
    private final Context context;
    @Nullable
    private MotionSpec defaultMotionSpec;
    @NonNull
    private final ExtendedFloatingActionButton fab;
    private final ArrayList<Animator.AnimatorListener> listeners = new ArrayList<>();
    @Nullable
    private MotionSpec motionSpec;
    private final AnimatorTracker tracker;

    BaseMotionStrategy(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton, AnimatorTracker animatorTracker) {
        this.fab = extendedFloatingActionButton;
        this.context = extendedFloatingActionButton.getContext();
        this.tracker = animatorTracker;
    }

    public final void setMotionSpec(@Nullable MotionSpec motionSpec2) {
        this.motionSpec = motionSpec2;
    }

    public final MotionSpec getCurrentMotionSpec() {
        if (this.motionSpec != null) {
            return this.motionSpec;
        }
        if (this.defaultMotionSpec == null) {
            this.defaultMotionSpec = MotionSpec.createFromResource(this.context, getDefaultMotionSpecResource());
        }
        return (MotionSpec) Preconditions.checkNotNull(this.defaultMotionSpec);
    }

    public final void addAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.listeners.add(animatorListener);
    }

    public final void removeAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        this.listeners.remove(animatorListener);
    }

    @NonNull
    public final List<Animator.AnimatorListener> getListeners() {
        return this.listeners;
    }

    @Nullable
    public MotionSpec getMotionSpec() {
        return this.motionSpec;
    }

    @CallSuper
    public void onAnimationStart(Animator animator) {
        this.tracker.onNextAnimationStart(animator);
    }

    @CallSuper
    public void onAnimationEnd() {
        this.tracker.clear();
    }

    @CallSuper
    public void onAnimationCancel() {
        this.tracker.clear();
    }

    public AnimatorSet createAnimator() {
        return createAnimator(getCurrentMotionSpec());
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public AnimatorSet createAnimator(@NonNull MotionSpec motionSpec2) {
        ArrayList arrayList = new ArrayList();
        if (motionSpec2.hasPropertyValues(ViewProps.OPACITY)) {
            arrayList.add(motionSpec2.getAnimator(ViewProps.OPACITY, this.fab, View.ALPHA));
        }
        if (motionSpec2.hasPropertyValues("scale")) {
            arrayList.add(motionSpec2.getAnimator("scale", this.fab, View.SCALE_Y));
            arrayList.add(motionSpec2.getAnimator("scale", this.fab, View.SCALE_X));
        }
        if (motionSpec2.hasPropertyValues("width")) {
            arrayList.add(motionSpec2.getAnimator("width", this.fab, ExtendedFloatingActionButton.WIDTH));
        }
        if (motionSpec2.hasPropertyValues("height")) {
            arrayList.add(motionSpec2.getAnimator("height", this.fab, ExtendedFloatingActionButton.HEIGHT));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }
}
