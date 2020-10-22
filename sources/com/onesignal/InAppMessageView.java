package com.onesignal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.view.PointerIconCompat;
import androidx.core.widget.PopupWindowCompat;
import com.onesignal.DraggableRelativeLayout;
import com.onesignal.OneSignal;
import com.onesignal.WebViewManager;

class InAppMessageView {
    private static final int ACTIVITY_BACKGROUND_COLOR_EMPTY = Color.parseColor("#00000000");
    private static final int ACTIVITY_BACKGROUND_COLOR_FULL = Color.parseColor("#BB000000");
    private static final int ACTIVITY_FINISH_AFTER_DISMISS_DELAY_MS = 600;
    private static final int ACTIVITY_INIT_DELAY = 200;
    private static final int DRAG_THRESHOLD_PX_SIZE = OSViewUtils.dpToPx(4);
    private static final int IN_APP_BACKGROUND_ANIMATION_DURATION_MS = 400;
    private static final int IN_APP_BANNER_ANIMATION_DURATION_MS = 1000;
    private static final int IN_APP_CENTER_ANIMATION_DURATION_MS = 1000;
    private static final int MARGIN_PX_SIZE = OSViewUtils.dpToPx(24);
    /* access modifiers changed from: private */
    public Activity currentActivity;
    private double dismissDuration;
    /* access modifiers changed from: private */
    @NonNull
    public WebViewManager.Position displayLocation;
    /* access modifiers changed from: private */
    public DraggableRelativeLayout draggableRelativeLayout;
    private final Handler handler = new Handler();
    /* access modifiers changed from: private */
    public boolean hasBackground;
    /* access modifiers changed from: private */
    public boolean isDragging = false;
    /* access modifiers changed from: private */
    public InAppMessageViewListener messageController;
    private int pageHeight;
    private int pageWidth;
    /* access modifiers changed from: private */
    public RelativeLayout parentRelativeLayout;
    private PopupWindow popupWindow;
    /* access modifiers changed from: private */
    public Runnable scheduleDismissRunnable;
    /* access modifiers changed from: private */
    public boolean shouldDismissWhenActive = false;
    /* access modifiers changed from: private */
    public WebView webView;

    interface InAppMessageViewListener {
        void onMessageWasDismissed();

        void onMessageWasShown();
    }

    InAppMessageView(@NonNull WebView webView2, @NonNull WebViewManager.Position position, int i, double d) {
        this.webView = webView2;
        this.displayLocation = position;
        this.pageHeight = i;
        this.pageWidth = -1;
        this.dismissDuration = Double.isNaN(d) ? 0.0d : d;
        this.hasBackground = !position.isBanner();
    }

    /* access modifiers changed from: package-private */
    public void setWebView(WebView webView2) {
        this.webView = webView2;
    }

    /* access modifiers changed from: package-private */
    public void setMessageController(InAppMessageViewListener inAppMessageViewListener) {
        this.messageController = inAppMessageViewListener;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public WebViewManager.Position getDisplayPosition() {
        return this.displayLocation;
    }

    /* access modifiers changed from: package-private */
    public void showView(Activity activity) {
        delayShowUntilAvailable(activity);
    }

    /* access modifiers changed from: package-private */
    public void checkIfShouldDismiss() {
        if (this.shouldDismissWhenActive) {
            this.shouldDismissWhenActive = false;
            finishAfterDelay((WebViewManager.OneSignalGenericCallback) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateHeight(final int i) {
        this.pageHeight = i;
        OSUtils.runOnMainUIThread(new Runnable() {
            public void run() {
                if (InAppMessageView.this.webView == null) {
                    OneSignal.onesignalLog(OneSignal.LOG_LEVEL.WARN, "WebView height update skipped, new height will be used once it is displayed.");
                    return;
                }
                ViewGroup.LayoutParams layoutParams = InAppMessageView.this.webView.getLayoutParams();
                layoutParams.height = i;
                InAppMessageView.this.webView.setLayoutParams(layoutParams);
                if (InAppMessageView.this.draggableRelativeLayout != null) {
                    InAppMessageView.this.draggableRelativeLayout.setParams(InAppMessageView.this.createDraggableLayoutParams(i, InAppMessageView.this.displayLocation));
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void showInAppMessageView(Activity activity) {
        this.currentActivity = activity;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.pageHeight);
        layoutParams.addRule(13);
        showDraggableView(this.displayLocation, layoutParams, this.hasBackground ? createParentLinearLayoutParams() : null, createDraggableLayoutParams(this.pageHeight, this.displayLocation));
    }

    private int getDisplayYSize() {
        return OSViewUtils.getWindowHeight(this.currentActivity);
    }

    private LinearLayout.LayoutParams createParentLinearLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.pageWidth, -1);
        switch (this.displayLocation) {
            case TOP_BANNER:
                layoutParams.gravity = 49;
                break;
            case BOTTOM_BANNER:
                layoutParams.gravity = 81;
                break;
            case CENTER_MODAL:
            case FULL_SCREEN:
                layoutParams.gravity = 17;
                break;
        }
        return layoutParams;
    }

    /* access modifiers changed from: private */
    public DraggableRelativeLayout.Params createDraggableLayoutParams(int i, WebViewManager.Position position) {
        DraggableRelativeLayout.Params params = new DraggableRelativeLayout.Params();
        params.maxXPos = MARGIN_PX_SIZE;
        params.maxYPos = MARGIN_PX_SIZE;
        params.messageHeight = i;
        params.height = getDisplayYSize();
        switch (position) {
            case TOP_BANNER:
                params.dragThresholdY = MARGIN_PX_SIZE - DRAG_THRESHOLD_PX_SIZE;
                break;
            case BOTTOM_BANNER:
                params.posY = getDisplayYSize() - i;
                params.dragThresholdY = MARGIN_PX_SIZE + DRAG_THRESHOLD_PX_SIZE;
                break;
            case CENTER_MODAL:
                break;
            case FULL_SCREEN:
                i = getDisplayYSize() - (MARGIN_PX_SIZE * 2);
                params.messageHeight = i;
                break;
        }
        int displayYSize = (getDisplayYSize() / 2) - (i / 2);
        params.dragThresholdY = DRAG_THRESHOLD_PX_SIZE + displayYSize;
        params.maxYPos = displayYSize;
        params.posY = displayYSize;
        params.dragDirection = position == WebViewManager.Position.TOP_BANNER ? 0 : 1;
        return params;
    }

    private void showDraggableView(WebViewManager.Position position, RelativeLayout.LayoutParams layoutParams, LinearLayout.LayoutParams layoutParams2, DraggableRelativeLayout.Params params) {
        final RelativeLayout.LayoutParams layoutParams3 = layoutParams;
        final LinearLayout.LayoutParams layoutParams4 = layoutParams2;
        final DraggableRelativeLayout.Params params2 = params;
        final WebViewManager.Position position2 = position;
        OSUtils.runOnMainUIThread(new Runnable() {
            public void run() {
                if (InAppMessageView.this.webView != null) {
                    InAppMessageView.this.webView.setLayoutParams(layoutParams3);
                    Context applicationContext = InAppMessageView.this.currentActivity.getApplicationContext();
                    InAppMessageView.this.setUpDraggableLayout(applicationContext, layoutParams4, params2);
                    InAppMessageView.this.setUpParentLinearLayout(applicationContext);
                    InAppMessageView.this.createPopupWindow(InAppMessageView.this.parentRelativeLayout);
                    if (InAppMessageView.this.messageController != null) {
                        InAppMessageView.this.animateInAppMessage(position2, InAppMessageView.this.draggableRelativeLayout, InAppMessageView.this.parentRelativeLayout);
                        InAppMessageView.this.messageController.onMessageWasShown();
                    }
                    InAppMessageView.this.startDismissTimerIfNeeded();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void createPopupWindow(@NonNull RelativeLayout relativeLayout) {
        int i;
        int i2 = -1;
        int i3 = this.hasBackground ? -1 : this.pageWidth;
        if (!this.hasBackground) {
            i2 = -2;
        }
        this.popupWindow = new PopupWindow(relativeLayout, i3, i2);
        this.popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        this.popupWindow.setTouchable(true);
        if (!this.hasBackground) {
            switch (this.displayLocation) {
                case TOP_BANNER:
                    i = 49;
                    break;
                case BOTTOM_BANNER:
                    i = 81;
                    break;
            }
        }
        i = 0;
        PopupWindowCompat.setWindowLayoutType(this.popupWindow, PointerIconCompat.TYPE_HELP);
        this.popupWindow.showAtLocation(this.currentActivity.getWindow().getDecorView().getRootView(), i, 0, 0);
    }

    /* access modifiers changed from: private */
    public void setUpParentLinearLayout(Context context) {
        this.parentRelativeLayout = new RelativeLayout(context);
        this.parentRelativeLayout.setBackgroundDrawable(new ColorDrawable(0));
        this.parentRelativeLayout.setClipChildren(false);
        this.parentRelativeLayout.setClipToPadding(false);
        this.parentRelativeLayout.addView(this.draggableRelativeLayout);
    }

    /* access modifiers changed from: private */
    public void setUpDraggableLayout(Context context, LinearLayout.LayoutParams layoutParams, DraggableRelativeLayout.Params params) {
        this.draggableRelativeLayout = new DraggableRelativeLayout(context);
        if (layoutParams != null) {
            this.draggableRelativeLayout.setLayoutParams(layoutParams);
        }
        this.draggableRelativeLayout.setParams(params);
        this.draggableRelativeLayout.setListener(new DraggableRelativeLayout.DraggableListener() {
            public void onDismiss() {
                InAppMessageView.this.finishAfterDelay((WebViewManager.OneSignalGenericCallback) null);
            }

            public void onDragStart() {
                boolean unused = InAppMessageView.this.isDragging = true;
            }

            public void onDragEnd() {
                boolean unused = InAppMessageView.this.isDragging = false;
            }
        });
        if (this.webView.getParent() != null) {
            ((ViewGroup) this.webView.getParent()).removeAllViews();
        }
        CardView createCardView = createCardView(context);
        createCardView.addView(this.webView);
        this.draggableRelativeLayout.setPadding(MARGIN_PX_SIZE, MARGIN_PX_SIZE, MARGIN_PX_SIZE, MARGIN_PX_SIZE);
        this.draggableRelativeLayout.setClipChildren(false);
        this.draggableRelativeLayout.setClipToPadding(false);
        this.draggableRelativeLayout.addView(createCardView);
    }

    /* access modifiers changed from: package-private */
    public boolean isDragging() {
        return this.isDragging;
    }

    private CardView createCardView(Context context) {
        CardView cardView = new CardView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.displayLocation == WebViewManager.Position.FULL_SCREEN ? -1 : -2);
        layoutParams.addRule(13);
        cardView.setLayoutParams(layoutParams);
        cardView.setRadius((float) OSViewUtils.dpToPx(8));
        cardView.setCardElevation((float) OSViewUtils.dpToPx(5));
        cardView.setClipChildren(false);
        cardView.setClipToPadding(false);
        cardView.setPreventCornerOverlap(false);
        return cardView;
    }

    /* access modifiers changed from: private */
    public void startDismissTimerIfNeeded() {
        if (this.dismissDuration > 0.0d && this.scheduleDismissRunnable == null) {
            this.scheduleDismissRunnable = new Runnable() {
                public void run() {
                    if (InAppMessageView.this.currentActivity != null) {
                        InAppMessageView.this.dismissAndAwaitNextMessage((WebViewManager.OneSignalGenericCallback) null);
                        Runnable unused = InAppMessageView.this.scheduleDismissRunnable = null;
                        return;
                    }
                    boolean unused2 = InAppMessageView.this.shouldDismissWhenActive = true;
                }
            };
            this.handler.postDelayed(this.scheduleDismissRunnable, ((long) this.dismissDuration) * 1000);
        }
    }

    /* access modifiers changed from: private */
    public void delayShowUntilAvailable(final Activity activity) {
        if (!OSViewUtils.isActivityFullyReady(activity) || this.parentRelativeLayout != null) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    InAppMessageView.this.delayShowUntilAvailable(activity);
                }
            }, 200);
        } else {
            showInAppMessageView(activity);
        }
    }

    /* access modifiers changed from: package-private */
    public void dismissAndAwaitNextMessage(@Nullable WebViewManager.OneSignalGenericCallback oneSignalGenericCallback) {
        if (this.draggableRelativeLayout == null) {
            OneSignal.Log(OneSignal.LOG_LEVEL.ERROR, "No host presenter to trigger dismiss animation, counting as dismissed already", new Throwable());
            dereferenceViews();
            if (oneSignalGenericCallback != null) {
                oneSignalGenericCallback.onComplete();
                return;
            }
            return;
        }
        this.draggableRelativeLayout.dismiss();
        finishAfterDelay(oneSignalGenericCallback);
    }

    /* access modifiers changed from: private */
    public void finishAfterDelay(final WebViewManager.OneSignalGenericCallback oneSignalGenericCallback) {
        OSUtils.runOnMainThreadDelayed(new Runnable() {
            public void run() {
                if (!InAppMessageView.this.hasBackground || InAppMessageView.this.parentRelativeLayout == null) {
                    InAppMessageView.this.cleanupViewsAfterDismiss();
                    if (oneSignalGenericCallback != null) {
                        oneSignalGenericCallback.onComplete();
                        return;
                    }
                    return;
                }
                InAppMessageView.this.animateAndDismissLayout(InAppMessageView.this.parentRelativeLayout, oneSignalGenericCallback);
            }
        }, ACTIVITY_FINISH_AFTER_DISMISS_DELAY_MS);
    }

    /* access modifiers changed from: private */
    public void cleanupViewsAfterDismiss() {
        OneSignal.onesignalLog(OneSignal.LOG_LEVEL.DEBUG, "InAppMessageView cleanupViewsAfterDismiss");
        removeAllViews();
        if (this.messageController != null) {
            this.messageController.onMessageWasDismissed();
        }
    }

    /* access modifiers changed from: package-private */
    public void removeAllViews() {
        if (this.scheduleDismissRunnable != null) {
            this.handler.removeCallbacks(this.scheduleDismissRunnable);
            this.scheduleDismissRunnable = null;
        }
        if (this.draggableRelativeLayout != null) {
            this.draggableRelativeLayout.removeAllViews();
        }
        if (this.popupWindow != null) {
            this.popupWindow.dismiss();
        }
        dereferenceViews();
    }

    private void dereferenceViews() {
        this.parentRelativeLayout = null;
        this.draggableRelativeLayout = null;
        this.webView = null;
    }

    /* access modifiers changed from: private */
    public void animateInAppMessage(WebViewManager.Position position, View view, View view2) {
        switch (position) {
            case TOP_BANNER:
                animateTop(((ViewGroup) view).getChildAt(0), this.webView.getHeight());
                return;
            case BOTTOM_BANNER:
                animateBottom(((ViewGroup) view).getChildAt(0), this.webView.getHeight());
                return;
            case CENTER_MODAL:
            case FULL_SCREEN:
                animateCenter(view, view2);
                return;
            default:
                return;
        }
    }

    private void animateTop(View view, int i) {
        OneSignalAnimate.animateViewByTranslation(view, (float) ((-i) - MARGIN_PX_SIZE), 0.0f, 1000, new OneSignalBounceInterpolator(0.1d, 8.0d), (Animation.AnimationListener) null).start();
    }

    private void animateBottom(View view, int i) {
        OneSignalAnimate.animateViewByTranslation(view, (float) (i + MARGIN_PX_SIZE), 0.0f, 1000, new OneSignalBounceInterpolator(0.1d, 8.0d), (Animation.AnimationListener) null).start();
    }

    private void animateCenter(View view, View view2) {
        Animation animateViewSmallToLarge = OneSignalAnimate.animateViewSmallToLarge(view, 1000, new OneSignalBounceInterpolator(0.1d, 8.0d), (Animation.AnimationListener) null);
        ValueAnimator animateBackgroundColor = animateBackgroundColor(view2, 400, ACTIVITY_BACKGROUND_COLOR_EMPTY, ACTIVITY_BACKGROUND_COLOR_FULL, (Animator.AnimatorListener) null);
        animateViewSmallToLarge.start();
        animateBackgroundColor.start();
    }

    /* access modifiers changed from: private */
    public void animateAndDismissLayout(View view, final WebViewManager.OneSignalGenericCallback oneSignalGenericCallback) {
        View view2 = view;
        animateBackgroundColor(view2, 400, ACTIVITY_BACKGROUND_COLOR_FULL, ACTIVITY_BACKGROUND_COLOR_EMPTY, new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                InAppMessageView.this.cleanupViewsAfterDismiss();
                if (oneSignalGenericCallback != null) {
                    oneSignalGenericCallback.onComplete();
                }
            }
        }).start();
    }

    private ValueAnimator animateBackgroundColor(View view, int i, int i2, int i3, Animator.AnimatorListener animatorListener) {
        return OneSignalAnimate.animateViewColor(view, i, i2, i3, animatorListener);
    }
}
