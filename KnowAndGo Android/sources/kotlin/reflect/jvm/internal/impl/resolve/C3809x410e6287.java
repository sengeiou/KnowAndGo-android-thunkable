package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* renamed from: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1 */
/* compiled from: overridingUtils.kt */
final class C3809x410e6287 extends Lambda implements Function1<H, Unit> {
    final /* synthetic */ SmartSet $conflictedHandles;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C3809x410e6287(SmartSet smartSet) {
        super(1);
        this.$conflictedHandles = smartSet;
    }

    public final void invoke(H h) {
        SmartSet smartSet = this.$conflictedHandles;
        Intrinsics.checkExpressionValueIsNotNull(h, "it");
        smartSet.add(h);
    }
}
