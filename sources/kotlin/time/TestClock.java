package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, mo39786d2 = {"Lkotlin/time/TestClock;", "Lkotlin/time/AbstractLongClock;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(D)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, mo39787k = 1, mo39788mv = {1, 1, 15})
@SinceKotlin(version = "1.3")
@ExperimentalTime
/* compiled from: Clocks.kt */
public final class TestClock extends AbstractLongClock {
    private long reading;

    public TestClock() {
        super(TimeUnit.NANOSECONDS);
    }

    /* access modifiers changed from: protected */
    public long read() {
        return this.reading;
    }

    /* renamed from: plusAssign-LRDsOJo */
    public final void m3490plusAssignLRDsOJo(double d) {
        long j;
        double r0 = Duration.m3475toDoubleimpl(d, getUnit());
        long j2 = (long) r0;
        if (j2 == Long.MIN_VALUE || j2 == Long.MAX_VALUE) {
            double d2 = ((double) this.reading) + r0;
            if (d2 > ((double) Long.MAX_VALUE) || d2 < ((double) Long.MIN_VALUE)) {
                m3489overflowLRDsOJo(d);
            }
            j = (long) d2;
        } else {
            j = this.reading + j2;
            if ((j2 ^ this.reading) >= 0 && (this.reading ^ j) < 0) {
                m3489overflowLRDsOJo(d);
            }
        }
        this.reading = j;
    }

    /* renamed from: overflow-LRDsOJo */
    private final void m3489overflowLRDsOJo(double d) {
        throw new IllegalStateException("TestClock will overflow if its reading " + this.reading + "ns is advanced by " + Duration.m3481toStringimpl(d) + '.');
    }
}
