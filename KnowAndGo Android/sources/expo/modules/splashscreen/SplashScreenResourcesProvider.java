package expo.modules.splashscreen;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0007"}, mo39786d2 = {"Lexpo/modules/splashscreen/SplashScreenResourcesProvider;", "", "getBackgroundColor", "", "context", "Landroid/content/Context;", "getImageResource", "expo-splash-screen_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
/* compiled from: SplashScreenResourcesProvider.kt */
public interface SplashScreenResourcesProvider {
    @ColorInt
    int getBackgroundColor(@NotNull Context context);

    @DrawableRes
    int getImageResource(@NotNull Context context);
}
