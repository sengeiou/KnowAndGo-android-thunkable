package kotlin.ranges;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u0004"}, mo39786d2 = {"rangeTo", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "that", "kotlin-stdlib"}, mo39787k = 5, mo39788mv = {1, 1, 15}, mo39790xi = 1, mo39791xs = "kotlin/ranges/RangesKt")
/* compiled from: RangesJVM.kt */
class RangesKt__RangesJVMKt {
    @NotNull
    @SinceKotlin(version = "1.1")
    public static final ClosedFloatingPointRange<Float> rangeTo(float f, float f2) {
        return new ClosedFloatRange(f, f2);
    }
}
