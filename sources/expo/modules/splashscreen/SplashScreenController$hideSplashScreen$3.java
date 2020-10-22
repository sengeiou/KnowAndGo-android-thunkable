package expo.modules.splashscreen;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo39786d2 = {"<anonymous>", "", "run"}, mo39787k = 3, mo39788mv = {1, 1, 16})
/* compiled from: SplashScreenController.kt */
final class SplashScreenController$hideSplashScreen$3 implements Runnable {
    final /* synthetic */ Function1 $successCallback;
    final /* synthetic */ SplashScreenController this$0;

    SplashScreenController$hideSplashScreen$3(SplashScreenController splashScreenController, Function1 function1) {
        this.this$0 = splashScreenController;
        this.$successCallback = function1;
    }

    public final void run() {
        this.this$0.contentView.removeView(this.this$0.splashScreenView);
        this.this$0.autoHideEnabled = true;
        this.this$0.splashScreenShown = false;
        this.$successCallback.invoke(true);
    }
}
