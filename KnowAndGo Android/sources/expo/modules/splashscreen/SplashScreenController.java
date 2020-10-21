package expo.modules.splashscreen;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.ReactRootView;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.splashscreen.exceptions.NoContentViewException;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\fH\u0002JP\u0010\u001a\u001a\u00020\u00192#\b\u0002\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00190\u001c2#\b\u0002\u0010 \u001a\u001d\u0012\u0013\u0012\u00110!¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00190\u001cJL\u0010#\u001a\u00020\u00192!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00190\u001c2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110!¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00190\u001cJ\b\u0010$\u001a\u00020\u0019H\u0002J\u0016\u0010%\u001a\u00020\u00192\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190&R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00030\u00030\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, mo39786d2 = {"Lexpo/modules/splashscreen/SplashScreenController;", "", "activity", "Landroid/app/Activity;", "resizeMode", "Lexpo/modules/splashscreen/SplashScreenImageResizeMode;", "splashScreenResourcesProvider", "Lexpo/modules/splashscreen/SplashScreenResourcesProvider;", "(Landroid/app/Activity;Lexpo/modules/splashscreen/SplashScreenImageResizeMode;Lexpo/modules/splashscreen/SplashScreenResourcesProvider;)V", "autoHideEnabled", "", "contentView", "Landroid/view/ViewGroup;", "handler", "Landroid/os/Handler;", "rootView", "splashScreenShown", "splashScreenView", "Landroid/view/View;", "weakActivity", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "findRootView", "view", "handleRootView", "", "hideSplashScreen", "successCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "hasEffect", "failureCallback", "", "reason", "preventAutoHide", "searchForRootView", "showSplashScreen", "Lkotlin/Function0;", "expo-splash-screen_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
/* compiled from: SplashScreenController.kt */
public final class SplashScreenController {
    /* access modifiers changed from: private */
    public boolean autoHideEnabled;
    /* access modifiers changed from: private */
    public final ViewGroup contentView;
    private final Handler handler;
    /* access modifiers changed from: private */
    public ViewGroup rootView;
    /* access modifiers changed from: private */
    public boolean splashScreenShown;
    /* access modifiers changed from: private */
    public View splashScreenView;
    private final WeakReference<Activity> weakActivity;

    public SplashScreenController(@NotNull Activity activity, @NotNull SplashScreenImageResizeMode splashScreenImageResizeMode, @NotNull SplashScreenResourcesProvider splashScreenResourcesProvider) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(splashScreenImageResizeMode, ViewProps.RESIZE_MODE);
        Intrinsics.checkParameterIsNotNull(splashScreenResourcesProvider, "splashScreenResourcesProvider");
        this.weakActivity = new WeakReference<>(activity);
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (viewGroup != null) {
            this.contentView = viewGroup;
            this.splashScreenView = new SplashScreenView(activity, splashScreenImageResizeMode, splashScreenResourcesProvider);
            this.handler = new Handler();
            this.autoHideEnabled = true;
            return;
        }
        throw new NoContentViewException();
    }

    public static /* synthetic */ void showSplashScreen$default(SplashScreenController splashScreenController, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = SplashScreenController$showSplashScreen$1.INSTANCE;
        }
        splashScreenController.showSplashScreen(function0);
    }

    public final void showSplashScreen(@NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "successCallback");
        Activity activity = (Activity) this.weakActivity.get();
        if (activity != null) {
            activity.runOnUiThread(new SplashScreenController$showSplashScreen$2(this, function0));
        }
    }

    public final void preventAutoHide(@NotNull Function1<? super Boolean, Unit> function1, @NotNull Function1<? super String, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(function1, "successCallback");
        Intrinsics.checkParameterIsNotNull(function12, "failureCallback");
        if (!this.autoHideEnabled) {
            function1.invoke(false);
        } else if (!this.splashScreenShown) {
            function12.invoke("Native splash screen is already hidden. Call this method before rendering any view.");
        } else {
            this.autoHideEnabled = false;
            function1.invoke(true);
        }
    }

    public static /* synthetic */ void hideSplashScreen$default(SplashScreenController splashScreenController, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = SplashScreenController$hideSplashScreen$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function12 = SplashScreenController$hideSplashScreen$2.INSTANCE;
        }
        splashScreenController.hideSplashScreen(function1, function12);
    }

    public final void hideSplashScreen(@NotNull Function1<? super Boolean, Unit> function1, @NotNull Function1<? super String, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(function1, "successCallback");
        Intrinsics.checkParameterIsNotNull(function12, "failureCallback");
        if (!this.splashScreenShown) {
            function1.invoke(false);
            return;
        }
        Activity activity = (Activity) this.weakActivity.get();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            function12.invoke("Cannot hide native splash screen on activity that is already destroyed (application is already closed).");
        } else {
            activity.runOnUiThread(new SplashScreenController$hideSplashScreen$3(this, function1));
        }
    }

    /* access modifiers changed from: private */
    public final void searchForRootView() {
        if (this.rootView == null) {
            ViewGroup findRootView = findRootView(this.contentView);
            if (findRootView != null) {
                handleRootView(findRootView);
            } else {
                this.handler.postDelayed(new SplashScreenController$searchForRootView$2(this), 20);
            }
        }
    }

    private final ViewGroup findRootView(View view) {
        if (Reflection.getOrCreateKotlinClass(ReactRootView.class).isInstance(view)) {
            if (view != null) {
                return (ViewGroup) view;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        } else if ((view instanceof SplashScreenView) || !(view instanceof ViewGroup)) {
            return null;
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkExpressionValueIsNotNull(childAt, "view.getChildAt(idx)");
                ViewGroup findRootView = findRootView(childAt);
                if (findRootView != null) {
                    return findRootView;
                }
            }
            return null;
        }
    }

    private final void handleRootView(ViewGroup viewGroup) {
        this.rootView = viewGroup;
        ViewGroup viewGroup2 = this.rootView;
        if ((viewGroup2 != null ? viewGroup2.getChildCount() : 0) > 0 && this.autoHideEnabled) {
            hideSplashScreen$default(this, (Function1) null, (Function1) null, 3, (Object) null);
        }
        viewGroup.setOnHierarchyChangeListener(new SplashScreenController$handleRootView$1(this));
    }
}
