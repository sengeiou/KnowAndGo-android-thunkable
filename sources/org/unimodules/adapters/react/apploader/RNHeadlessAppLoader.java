package org.unimodules.adapters.react.apploader;

import android.content.Context;
import android.os.Handler;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.unimodules.apploader.HeadlessAppLoader;
import org.unimodules.core.interfaces.Consumer;
import org.unimodules.core.interfaces.DoNotStrip;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J4\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo39786d2 = {"Lorg/unimodules/adapters/react/apploader/RNHeadlessAppLoader;", "Lorg/unimodules/apploader/HeadlessAppLoader;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "invalidateApp", "", "appId", "", "isRunning", "loadApp", "", "params", "Lorg/unimodules/apploader/HeadlessAppLoader$Params;", "alreadyRunning", "Ljava/lang/Runnable;", "callback", "Lorg/unimodules/core/interfaces/Consumer;", "unimodules-react-native-adapter_release"}, mo39787k = 1, mo39788mv = {1, 1, 15})
/* compiled from: RNHeadlessAppLoader.kt */
public final class RNHeadlessAppLoader implements HeadlessAppLoader {
    private final Context context;

    @DoNotStrip
    public RNHeadlessAppLoader(@NotNull Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
    }

    public void loadApp(@NotNull Context context2, @Nullable HeadlessAppLoader.Params params, @Nullable Runnable runnable, @Nullable Consumer<Boolean> consumer) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        if (params == null || params.getAppId() == null) {
            throw new IllegalArgumentException("Params must be set with appId!");
        } else if (context2.getApplicationContext() instanceof ReactApplication) {
            Context applicationContext = context2.getApplicationContext();
            if (applicationContext != null) {
                ReactNativeHost reactNativeHost = ((ReactApplication) applicationContext).getReactNativeHost();
                Intrinsics.checkExpressionValueIsNotNull(reactNativeHost, "(context.applicationCont…lication).reactNativeHost");
                ReactInstanceManager reactInstanceManager = reactNativeHost.getReactInstanceManager();
                if (!RNHeadlessAppLoaderKt.appRecords.containsKey(params.getAppId())) {
                    reactInstanceManager.addReactInstanceEventListener(new RNHeadlessAppLoader$loadApp$1(params, consumer));
                    Map access$getAppRecords$p = RNHeadlessAppLoaderKt.appRecords;
                    String appId = params.getAppId();
                    Intrinsics.checkExpressionValueIsNotNull(appId, "params.appId");
                    Intrinsics.checkExpressionValueIsNotNull(reactInstanceManager, "reactInstanceManager");
                    access$getAppRecords$p.put(appId, reactInstanceManager);
                    if (reactInstanceManager.hasStartedCreatingInitialContext()) {
                        reactInstanceManager.recreateReactContextInBackground();
                    } else {
                        reactInstanceManager.createReactContextInBackground();
                    }
                } else if (runnable != null) {
                    runnable.run();
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.facebook.react.ReactApplication");
            }
        } else {
            throw new IllegalStateException("Your application must implement ReactApplication");
        }
    }

    public boolean invalidateApp(@Nullable String str) {
        Map access$getAppRecords$p = RNHeadlessAppLoaderKt.appRecords;
        if (access$getAppRecords$p == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        } else if (!access$getAppRecords$p.containsKey(str) || RNHeadlessAppLoaderKt.appRecords.get(str) == null) {
            return false;
        } else {
            Object obj = RNHeadlessAppLoaderKt.appRecords.get(str);
            if (obj == null) {
                Intrinsics.throwNpe();
            }
            new Handler(this.context.getMainLooper()).post(new RNHeadlessAppLoader$invalidateApp$1((ReactInstanceManager) obj, str));
            return true;
        }
    }

    public boolean isRunning(@Nullable String str) {
        if (RNHeadlessAppLoaderKt.appRecords.containsKey(str)) {
            Object obj = RNHeadlessAppLoaderKt.appRecords.get(str);
            if (obj == null) {
                Intrinsics.throwNpe();
            }
            if (((ReactInstanceManager) obj).hasStartedCreatingInitialContext()) {
                return true;
            }
        }
        return false;
    }
}
