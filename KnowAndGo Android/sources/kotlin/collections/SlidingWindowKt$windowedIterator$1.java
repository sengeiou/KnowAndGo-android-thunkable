package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H@¢\u0006\u0004\b\u0005\u0010\u0006"}, mo39786d2 = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo39787k = 3, mo39788mv = {1, 1, 15})
@DebugMetadata(mo40397c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", mo40398f = "SlidingWindow.kt", mo40399i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, mo40400l = {34, 40, 49, 55, 58}, mo40401m = "invokeSuspend", mo40402n = {"$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "$this$iterator", "bufferInitialCapacity", "gap", "buffer"}, mo40403s = {"L$0", "I$0", "I$1", "L$1", "I$2", "L$2", "L$0", "I$0", "I$1", "L$1", "I$2", "L$0", "I$0", "I$1", "L$1", "L$2", "L$0", "I$0", "I$1", "L$1", "L$0", "I$0", "I$1", "L$1"})
/* compiled from: SlidingWindow.kt */
final class SlidingWindowKt$windowedIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Iterator $iterator;
    final /* synthetic */ boolean $partialWindows;
    final /* synthetic */ boolean $reuseBuffer;
    final /* synthetic */ int $size;
    final /* synthetic */ int $step;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* renamed from: p$ */
    private SequenceScope f2966p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SlidingWindowKt$windowedIterator$1(int i, int i2, Iterator it, boolean z, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.$size = i;
        this.$step = i2;
        this.$iterator = it;
        this.$reuseBuffer = z;
        this.$partialWindows = z2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
        slidingWindowKt$windowedIterator$1.f2966p$ = (SequenceScope) obj;
        return slidingWindowKt$windowedIterator$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SlidingWindowKt$windowedIterator$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0097, code lost:
        if (r1.hasNext() == false) goto L_0x00d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0099, code lost:
        r8 = r1.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x009d, code lost:
        if (r5 <= 0) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009f, code lost:
        r5 = r5 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a2, code lost:
        r3.add(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00ab, code lost:
        if (r3.size() != r14.$size) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00ad, code lost:
        r14.L$0 = r6;
        r14.I$0 = r0;
        r14.I$1 = r4;
        r14.L$1 = r3;
        r14.I$2 = r5;
        r14.L$2 = r8;
        r14.L$3 = r1;
        r14.label = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c1, code lost:
        if (r6.yield(r3, r14) != r7) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c3, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c6, code lost:
        if (r14.$reuseBuffer == false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c8, code lost:
        r3.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00cc, code lost:
        r3 = new java.util.ArrayList(r14.$size);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00d3, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00dd, code lost:
        if ((!r3.isEmpty()) == false) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00e1, code lost:
        if (r14.$partialWindows != false) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e9, code lost:
        if (r3.size() != r14.$size) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00eb, code lost:
        r14.L$0 = r6;
        r14.I$0 = r0;
        r14.I$1 = r4;
        r14.L$1 = r3;
        r14.I$2 = r5;
        r14.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00fc, code lost:
        if (r6.yield(r3, r14) != r7) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00fe, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0112, code lost:
        if (r1.hasNext() == false) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0114, code lost:
        r7 = r1.next();
        r3.add(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x011f, code lost:
        if (r3.isFull() == false) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0127, code lost:
        if (r3.size() >= r14.$size) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0129, code lost:
        r3 = r3.expanded(r14.$size);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0132, code lost:
        if (r14.$reuseBuffer == false) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0134, code lost:
        r8 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0138, code lost:
        r8 = new java.util.ArrayList(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0142, code lost:
        r14.L$0 = r6;
        r14.I$0 = r5;
        r14.I$1 = r4;
        r14.L$1 = r3;
        r14.L$2 = r7;
        r14.L$3 = r1;
        r14.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0155, code lost:
        if (r6.yield(r8, r14) != r0) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0157, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0158, code lost:
        r3.removeFirst(r14.$step);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0160, code lost:
        if (r14.$partialWindows == false) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0162, code lost:
        r1 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x016c, code lost:
        if (r1.size() <= r14.$step) goto L_0x0198;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0170, code lost:
        if (r14.$reuseBuffer == false) goto L_0x0176;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0172, code lost:
        r6 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0176, code lost:
        r6 = new java.util.ArrayList(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0180, code lost:
        r14.L$0 = r5;
        r14.I$0 = r4;
        r14.I$1 = r3;
        r14.L$1 = r1;
        r14.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x018f, code lost:
        if (r5.yield(r6, r14) != r0) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0191, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0192, code lost:
        r1.removeFirst(r14.$step);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01a0, code lost:
        if ((true ^ r1.isEmpty()) == false) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01a2, code lost:
        r14.L$0 = r5;
        r14.I$0 = r4;
        r14.I$1 = r3;
        r14.L$1 = r1;
        r14.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01b1, code lost:
        if (r5.yield(r1, r14) != r0) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01b3, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01b6, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0047, code lost:
        r0 = r13.I$1;
        r0 = r13.I$0;
        r0 = (kotlin.sequences.SequenceScope) r13.L$0;
        kotlin.ResultKt.throwOnFailure(r14);
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 1
            switch(r1) {
                case 0: goto L_0x006f;
                case 1: goto L_0x0054;
                case 2: goto L_0x0041;
                case 3: goto L_0x0029;
                case 4: goto L_0x0017;
                case 5: goto L_0x0012;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0012:
            java.lang.Object r0 = r13.L$1
            kotlin.collections.RingBuffer r0 = (kotlin.collections.RingBuffer) r0
            goto L_0x0047
        L_0x0017:
            java.lang.Object r1 = r13.L$1
            kotlin.collections.RingBuffer r1 = (kotlin.collections.RingBuffer) r1
            int r3 = r13.I$1
            int r4 = r13.I$0
            java.lang.Object r5 = r13.L$0
            kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
            kotlin.ResultKt.throwOnFailure(r14)
            r14 = r13
            goto L_0x0192
        L_0x0029:
            java.lang.Object r1 = r13.L$3
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r3 = r13.L$2
            java.lang.Object r3 = r13.L$1
            kotlin.collections.RingBuffer r3 = (kotlin.collections.RingBuffer) r3
            int r4 = r13.I$1
            int r5 = r13.I$0
            java.lang.Object r6 = r13.L$0
            kotlin.sequences.SequenceScope r6 = (kotlin.sequences.SequenceScope) r6
            kotlin.ResultKt.throwOnFailure(r14)
            r14 = r13
            goto L_0x0158
        L_0x0041:
            int r0 = r13.I$2
            java.lang.Object r0 = r13.L$1
            java.util.ArrayList r0 = (java.util.ArrayList) r0
        L_0x0047:
            int r0 = r13.I$1
            int r0 = r13.I$0
            java.lang.Object r0 = r13.L$0
            kotlin.sequences.SequenceScope r0 = (kotlin.sequences.SequenceScope) r0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x01b4
        L_0x0054:
            java.lang.Object r1 = r13.L$3
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r3 = r13.L$2
            int r3 = r13.I$2
            java.lang.Object r3 = r13.L$1
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r4 = r13.I$1
            int r5 = r13.I$0
            java.lang.Object r6 = r13.L$0
            kotlin.sequences.SequenceScope r6 = (kotlin.sequences.SequenceScope) r6
            kotlin.ResultKt.throwOnFailure(r14)
            r14 = r13
            r7 = r0
            r0 = r5
            goto L_0x00c4
        L_0x006f:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.sequences.SequenceScope r14 = r13.f2966p$
            int r1 = r13.$size
            r3 = 1024(0x400, float:1.435E-42)
            int r1 = kotlin.ranges.RangesKt.coerceAtMost((int) r1, (int) r3)
            int r3 = r13.$step
            int r4 = r13.$size
            int r3 = r3 - r4
            if (r3 < 0) goto L_0x00ff
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r1)
            r5 = 0
            java.util.Iterator r6 = r13.$iterator
            r7 = r0
            r0 = r1
            r1 = r6
            r6 = r14
            r14 = r13
            r11 = r4
            r4 = r3
            r3 = r11
        L_0x0093:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x00d5
            java.lang.Object r8 = r1.next()
            if (r5 <= 0) goto L_0x00a2
            int r5 = r5 + -1
            goto L_0x0093
        L_0x00a2:
            r3.add(r8)
            int r9 = r3.size()
            int r10 = r14.$size
            if (r9 != r10) goto L_0x0093
            r14.L$0 = r6
            r14.I$0 = r0
            r14.I$1 = r4
            r14.L$1 = r3
            r14.I$2 = r5
            r14.L$2 = r8
            r14.L$3 = r1
            r14.label = r2
            java.lang.Object r5 = r6.yield(r3, r14)
            if (r5 != r7) goto L_0x00c4
            return r7
        L_0x00c4:
            boolean r5 = r14.$reuseBuffer
            if (r5 == 0) goto L_0x00cc
            r3.clear()
            goto L_0x00d3
        L_0x00cc:
            java.util.ArrayList r3 = new java.util.ArrayList
            int r5 = r14.$size
            r3.<init>(r5)
        L_0x00d3:
            r5 = r4
            goto L_0x0093
        L_0x00d5:
            r1 = r3
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x01b4
            boolean r1 = r14.$partialWindows
            if (r1 != 0) goto L_0x00eb
            int r1 = r3.size()
            int r2 = r14.$size
            if (r1 != r2) goto L_0x01b4
        L_0x00eb:
            r14.L$0 = r6
            r14.I$0 = r0
            r14.I$1 = r4
            r14.L$1 = r3
            r14.I$2 = r5
            r0 = 2
            r14.label = r0
            java.lang.Object r14 = r6.yield(r3, r14)
            if (r14 != r7) goto L_0x01b4
            return r7
        L_0x00ff:
            kotlin.collections.RingBuffer r4 = new kotlin.collections.RingBuffer
            r4.<init>(r1)
            java.util.Iterator r5 = r13.$iterator
            r6 = r14
            r14 = r13
            r11 = r5
            r5 = r1
            r1 = r11
            r12 = r4
            r4 = r3
            r3 = r12
        L_0x010e:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x015e
            java.lang.Object r7 = r1.next()
            r3.add(r7)
            boolean r8 = r3.isFull()
            if (r8 == 0) goto L_0x010e
            int r8 = r3.size()
            int r9 = r14.$size
            if (r8 >= r9) goto L_0x0130
            int r7 = r14.$size
            kotlin.collections.RingBuffer r3 = r3.expanded(r7)
            goto L_0x010e
        L_0x0130:
            boolean r8 = r14.$reuseBuffer
            if (r8 == 0) goto L_0x0138
            r8 = r3
            java.util.List r8 = (java.util.List) r8
            goto L_0x0142
        L_0x0138:
            java.util.ArrayList r8 = new java.util.ArrayList
            r9 = r3
            java.util.Collection r9 = (java.util.Collection) r9
            r8.<init>(r9)
            java.util.List r8 = (java.util.List) r8
        L_0x0142:
            r14.L$0 = r6
            r14.I$0 = r5
            r14.I$1 = r4
            r14.L$1 = r3
            r14.L$2 = r7
            r14.L$3 = r1
            r7 = 3
            r14.label = r7
            java.lang.Object r7 = r6.yield(r8, r14)
            if (r7 != r0) goto L_0x0158
            return r0
        L_0x0158:
            int r7 = r14.$step
            r3.removeFirst(r7)
            goto L_0x010e
        L_0x015e:
            boolean r1 = r14.$partialWindows
            if (r1 == 0) goto L_0x01b4
            r1 = r3
            r3 = r4
            r4 = r5
            r5 = r6
        L_0x0166:
            int r6 = r1.size()
            int r7 = r14.$step
            if (r6 <= r7) goto L_0x0198
            boolean r6 = r14.$reuseBuffer
            if (r6 == 0) goto L_0x0176
            r6 = r1
            java.util.List r6 = (java.util.List) r6
            goto L_0x0180
        L_0x0176:
            java.util.ArrayList r6 = new java.util.ArrayList
            r7 = r1
            java.util.Collection r7 = (java.util.Collection) r7
            r6.<init>(r7)
            java.util.List r6 = (java.util.List) r6
        L_0x0180:
            r14.L$0 = r5
            r14.I$0 = r4
            r14.I$1 = r3
            r14.L$1 = r1
            r7 = 4
            r14.label = r7
            java.lang.Object r6 = r5.yield(r6, r14)
            if (r6 != r0) goto L_0x0192
            return r0
        L_0x0192:
            int r6 = r14.$step
            r1.removeFirst(r6)
            goto L_0x0166
        L_0x0198:
            r6 = r1
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r2 = r2 ^ r6
            if (r2 == 0) goto L_0x01b4
            r14.L$0 = r5
            r14.I$0 = r4
            r14.I$1 = r3
            r14.L$1 = r1
            r2 = 5
            r14.label = r2
            java.lang.Object r14 = r5.yield(r1, r14)
            if (r14 != r0) goto L_0x01b4
            return r0
        L_0x01b4:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.SlidingWindowKt$windowedIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
