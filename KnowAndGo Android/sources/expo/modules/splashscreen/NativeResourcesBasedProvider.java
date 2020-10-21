package expo.modules.splashscreen;

import android.content.Context;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, mo39786d2 = {"Lexpo/modules/splashscreen/NativeResourcesBasedProvider;", "Lexpo/modules/splashscreen/SplashScreenResourcesProvider;", "()V", "getBackgroundColor", "", "context", "Landroid/content/Context;", "getImageResource", "expo-splash-screen_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
/* compiled from: NativeResourcesBasedProvider.kt */
public final class NativeResourcesBasedProvider implements SplashScreenResourcesProvider {
    public int getBackgroundColor(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return ContextCompat.getColor(context, C3525R.C3526color.splashscreen_background);
    }

    public int getImageResource(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return C3525R.C3527drawable.splashscreen_image;
    }
}
