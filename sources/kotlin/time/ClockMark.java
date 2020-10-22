package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u0004H&ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u001b\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, mo39786d2 = {"Lkotlin/time/ClockMark;", "", "()V", "elapsedNow", "Lkotlin/time/Duration;", "()D", "hasNotPassedNow", "", "hasPassedNow", "minus", "duration", "minus-LRDsOJo", "(D)Lkotlin/time/ClockMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib"}, mo39787k = 1, mo39788mv = {1, 1, 15})
@SinceKotlin(version = "1.3")
@ExperimentalTime
/* compiled from: Clock.kt */
public abstract class ClockMark {
    public abstract double elapsedNow();

    @NotNull
    /* renamed from: plus-LRDsOJo */
    public ClockMark m3438plusLRDsOJo(double d) {
        return new AdjustedClockMark(this, d, (DefaultConstructorMarker) null);
    }

    @NotNull
    /* renamed from: minus-LRDsOJo */
    public ClockMark m3439minusLRDsOJo(double d) {
        return m3438plusLRDsOJo(Duration.m3484unaryMinusimpl(d));
    }

    public final boolean hasPassedNow() {
        return !Duration.m3464isNegativeimpl(elapsedNow());
    }

    public final boolean hasNotPassedNow() {
        return Duration.m3464isNegativeimpl(elapsedNow());
    }
}
