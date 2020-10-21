package expo.modules.splashscreen;

import android.app.Activity;
import com.facebook.react.uimanager.ViewProps;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.unimodules.core.interfaces.SingletonModule;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016JT\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b0\u000e2!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b0\u000eJT\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b0\u000e2!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b0\u000eJ_\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c2#\b\u0002\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b0\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo39786d2 = {"Lexpo/modules/splashscreen/SplashScreen;", "Lorg/unimodules/core/interfaces/SingletonModule;", "()V", "TAG", "", "controllers", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "Lexpo/modules/splashscreen/SplashScreenController;", "getName", "hide", "", "activity", "successCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "hasEffect", "failureCallback", "reason", "preventAutoHide", "show", "resizeMode", "Lexpo/modules/splashscreen/SplashScreenImageResizeMode;", "statusBarTranslucent", "splashScreenResourcesProvider", "Lexpo/modules/splashscreen/SplashScreenResourcesProvider;", "Lkotlin/Function0;", "expo-splash-screen_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
/* compiled from: SplashScreen.kt */
public final class SplashScreen implements SingletonModule {
    public static final SplashScreen INSTANCE = new SplashScreen();
    private static final String TAG = "SplashScreen";
    private static final WeakHashMap<Activity, SplashScreenController> controllers = new WeakHashMap<>();

    @JvmStatic
    @JvmOverloads
    public static final void show(@NotNull Activity activity, @NotNull SplashScreenImageResizeMode splashScreenImageResizeMode, boolean z) {
        show$default(activity, splashScreenImageResizeMode, z, (SplashScreenResourcesProvider) null, (Function0) null, (Function1) null, 56, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void show(@NotNull Activity activity, @NotNull SplashScreenImageResizeMode splashScreenImageResizeMode, boolean z, @NotNull SplashScreenResourcesProvider splashScreenResourcesProvider) {
        show$default(activity, splashScreenImageResizeMode, z, splashScreenResourcesProvider, (Function0) null, (Function1) null, 48, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void show(@NotNull Activity activity, @NotNull SplashScreenImageResizeMode splashScreenImageResizeMode, boolean z, @NotNull SplashScreenResourcesProvider splashScreenResourcesProvider, @NotNull Function0<Unit> function0) {
        show$default(activity, splashScreenImageResizeMode, z, splashScreenResourcesProvider, function0, (Function1) null, 32, (Object) null);
    }

    @NotNull
    public String getName() {
        return TAG;
    }

    private SplashScreen() {
    }

    public static /* synthetic */ void show$default(Activity activity, SplashScreenImageResizeMode splashScreenImageResizeMode, boolean z, SplashScreenResourcesProvider splashScreenResourcesProvider, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            splashScreenResourcesProvider = new NativeResourcesBasedProvider();
        }
        SplashScreenResourcesProvider splashScreenResourcesProvider2 = splashScreenResourcesProvider;
        if ((i & 16) != 0) {
            function0 = SplashScreen$show$1.INSTANCE;
        }
        Function0 function02 = function0;
        if ((i & 32) != 0) {
            function1 = SplashScreen$show$2.INSTANCE;
        }
        show(activity, splashScreenImageResizeMode, z, splashScreenResourcesProvider2, function02, function1);
    }

    @JvmStatic
    @JvmOverloads
    public static final void show(@NotNull Activity activity, @NotNull SplashScreenImageResizeMode splashScreenImageResizeMode, boolean z, @NotNull SplashScreenResourcesProvider splashScreenResourcesProvider, @NotNull Function0<Unit> function0, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(splashScreenImageResizeMode, ViewProps.RESIZE_MODE);
        Intrinsics.checkParameterIsNotNull(splashScreenResourcesProvider, "splashScreenResourcesProvider");
        Intrinsics.checkParameterIsNotNull(function0, "successCallback");
        Intrinsics.checkParameterIsNotNull(function1, "failureCallback");
        if (controllers.containsKey(activity)) {
            function1.invoke("'SplashScreen.show' has already been called for this activity.");
            return;
        }
        SplashScreenStatusBar.INSTANCE.configureTranslucent(activity, Boolean.valueOf(z));
        SplashScreenController splashScreenController = new SplashScreenController(activity, splashScreenImageResizeMode, splashScreenResourcesProvider);
        controllers.put(activity, splashScreenController);
        splashScreenController.showSplashScreen(function0);
    }

    public final void preventAutoHide(@NotNull Activity activity, @NotNull Function1<? super Boolean, Unit> function1, @NotNull Function1<? super String, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(function1, "successCallback");
        Intrinsics.checkParameterIsNotNull(function12, "failureCallback");
        if (!controllers.containsKey(activity)) {
            function12.invoke("No native splash screen registered for provided activity. Please configure your application's main Activity to call 'SplashScreen.show' (https://github.com/expo/expo/tree/master/packages/expo-splash-screen#-configure-android).");
            return;
        }
        SplashScreenController splashScreenController = controllers.get(activity);
        if (splashScreenController != null) {
            splashScreenController.preventAutoHide(function1, function12);
        }
    }

    public final void hide(@NotNull Activity activity, @NotNull Function1<? super Boolean, Unit> function1, @NotNull Function1<? super String, Unit> function12) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(function1, "successCallback");
        Intrinsics.checkParameterIsNotNull(function12, "failureCallback");
        if (!controllers.containsKey(activity)) {
            function12.invoke("No native splash screen registered for provided activity. Please configure your application's main Activity to call 'SplashScreen.show' (https://github.com/expo/expo/tree/master/packages/expo-splash-screen#-configure-android).");
            return;
        }
        SplashScreenController splashScreenController = controllers.get(activity);
        if (splashScreenController != null) {
            splashScreenController.hideSplashScreen(function1, function12);
        }
    }
}
