package expo.modules.splashscreen;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.unimodules.core.Promise;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39786d2 = {"<anonymous>", "", "hasEffect", "", "invoke"}, mo39787k = 3, mo39788mv = {1, 1, 16})
/* compiled from: SplashScreenModule.kt */
final class SplashScreenModule$preventAutoHideAsync$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Promise $promise;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SplashScreenModule$preventAutoHideAsync$1(Promise promise) {
        super(1);
        this.$promise = promise;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        this.$promise.resolve(Boolean.valueOf(z));
    }
}
