package expo.modules.splashscreen;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo39786d2 = {"<anonymous>", "", "run", "expo/modules/splashscreen/SplashScreenStatusBar$configureTranslucent$1$1"}, mo39787k = 3, mo39788mv = {1, 1, 16})
/* compiled from: SplashScreenStatusBar.kt */
final class SplashScreenStatusBar$configureTranslucent$$inlined$let$lambda$1 implements Runnable {
    final /* synthetic */ Activity $activity$inlined;
    final /* synthetic */ boolean $it;

    SplashScreenStatusBar$configureTranslucent$$inlined$let$lambda$1(boolean z, Activity activity) {
        this.$it = z;
        this.$activity$inlined = activity;
    }

    public final void run() {
        Window window = this.$activity$inlined.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window, "activity.window");
        View decorView = window.getDecorView();
        Intrinsics.checkExpressionValueIsNotNull(decorView, "activity.window.decorView");
        if (this.$it) {
            decorView.setOnApplyWindowInsetsListener(SplashScreenStatusBar$configureTranslucent$1$1$1.INSTANCE);
        } else {
            decorView.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
        }
        ViewCompat.requestApplyInsets(decorView);
    }
}
