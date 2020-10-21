package expo.modules.splashscreen;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39786d2 = {"<anonymous>", "", "it", "", "invoke"}, mo39787k = 3, mo39788mv = {1, 1, 16})
/* compiled from: SplashScreenController.kt */
final class SplashScreenController$hideSplashScreen$2 extends Lambda implements Function1<String, Unit> {
    public static final SplashScreenController$hideSplashScreen$2 INSTANCE = new SplashScreenController$hideSplashScreen$2();

    SplashScreenController$hideSplashScreen$2() {
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }
}
