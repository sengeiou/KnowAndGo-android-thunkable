package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalUnsignedTypes
@SinceKotlin(version = "1.3")
@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b@\u0018\u0000 f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001fB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0010J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013J\u001b\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u0013\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\rHÖ\u0001J\u0013\u0010%\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b&\u0010\u0005J\u0013\u0010'\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0005J\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b*\u0010\u0010J\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b+\u0010\u0013J\u001b\u0010)\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b,\u0010\u001fJ\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b-\u0010\u0018J\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b/\u0010\u000bJ\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u0010J\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u0013J\u001b\u00100\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u001fJ\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0018J\u001b\u00105\u001a\u0002062\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b:\u0010\u0010J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b;\u0010\u0013J\u001b\u00109\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b<\u0010\u001fJ\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b=\u0010\u0018J\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u0010J\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u0013J\u001b\u0010>\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u001fJ\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u0018J\u0010\u0010C\u001a\u00020DH\b¢\u0006\u0004\bE\u0010FJ\u0010\u0010G\u001a\u00020HH\b¢\u0006\u0004\bI\u0010JJ\u0010\u0010K\u001a\u00020LH\b¢\u0006\u0004\bM\u0010NJ\u0010\u0010O\u001a\u00020\rH\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020SH\b¢\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020\u0003H\b¢\u0006\u0004\bW\u0010\u0005J\u000f\u0010X\u001a\u00020YH\u0016¢\u0006\u0004\bZ\u0010[J\u0013\u0010\\\u001a\u00020\u000eH\bø\u0001\u0000¢\u0006\u0004\b]\u0010FJ\u0013\u0010^\u001a\u00020\u0011H\bø\u0001\u0000¢\u0006\u0004\b_\u0010QJ\u0013\u0010`\u001a\u00020\u0014H\bø\u0001\u0000¢\u0006\u0004\ba\u0010UJ\u0013\u0010b\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\bc\u0010\u0005J\u001b\u0010d\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\be\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006g"}, mo39786d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "data$annotations", "()V", "and", "other", "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-impl", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "(S)I", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, mo39787k = 1, mo39788mv = {1, 1, 15})
/* compiled from: UShort.kt */
public final class UShort implements Comparable<UShort> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    @NotNull
    /* renamed from: box-impl */
    public static final /* synthetic */ UShort m2762boximpl(short s) {
        return new UShort(s);
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw */
    private int m2766compareToxj2QHRw(short s) {
        return m2767compareToxj2QHRw(this.data, s);
    }

    @PublishedApi
    /* renamed from: constructor-impl */
    public static short m2768constructorimpl(short s) {
        return s;
    }

    @PublishedApi
    public static /* synthetic */ void data$annotations() {
    }

    /* renamed from: equals-impl */
    public static boolean m2774equalsimpl(short s, @Nullable Object obj) {
        if (obj instanceof UShort) {
            if (s == ((UShort) obj).m2809unboximpl()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: equals-impl0 */
    public static final boolean m2775equalsimpl0(short s, short s2) {
        throw null;
    }

    /* renamed from: hashCode-impl */
    public static int m2776hashCodeimpl(short s) {
        return s;
    }

    @InlineOnly
    /* renamed from: toByte-impl */
    private static final byte m2797toByteimpl(short s) {
        return (byte) s;
    }

    @InlineOnly
    /* renamed from: toDouble-impl */
    private static final double m2798toDoubleimpl(short s) {
        return (double) (s & MAX_VALUE);
    }

    @InlineOnly
    /* renamed from: toFloat-impl */
    private static final float m2799toFloatimpl(short s) {
        return (float) (s & MAX_VALUE);
    }

    @InlineOnly
    /* renamed from: toInt-impl */
    private static final int m2800toIntimpl(short s) {
        return s & MAX_VALUE;
    }

    @InlineOnly
    /* renamed from: toLong-impl */
    private static final long m2801toLongimpl(short s) {
        return ((long) s) & 65535;
    }

    @InlineOnly
    /* renamed from: toShort-impl */
    private static final short m2802toShortimpl(short s) {
        return s;
    }

    @InlineOnly
    /* renamed from: toUShort-impl */
    private static final short m2807toUShortimpl(short s) {
        return s;
    }

    public boolean equals(Object obj) {
        return m2774equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m2776hashCodeimpl(this.data);
    }

    @NotNull
    public String toString() {
        return m2803toStringimpl(this.data);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ short m2809unboximpl() {
        return this.data;
    }

    @PublishedApi
    private /* synthetic */ UShort(short s) {
        this.data = s;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return m2766compareToxj2QHRw(((UShort) obj).m2809unboximpl());
    }

    @Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, mo39786d2 = {"Lkotlin/UShort$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UShort;", "S", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, mo39787k = 1, mo39788mv = {1, 1, 15})
    /* compiled from: UShort.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU */
    private static final int m2763compareTo7apg3OU(short s, byte b) {
        return Intrinsics.compare((int) s & MAX_VALUE, (int) b & UByte.MAX_VALUE);
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw */
    private static int m2767compareToxj2QHRw(short s, short s2) {
        return Intrinsics.compare((int) s & MAX_VALUE, (int) s2 & MAX_VALUE);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns */
    private static final int m2765compareToWZ4Q5Ns(short s, int i) {
        return UnsignedKt.uintCompare(UInt.m2602constructorimpl(s & MAX_VALUE), i);
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ */
    private static final int m2764compareToVKZWuLQ(short s, long j) {
        return UnsignedKt.ulongCompare(ULong.m2671constructorimpl(((long) s) & 65535), j);
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU */
    private static final int m2784plus7apg3OU(short s, byte b) {
        return UInt.m2602constructorimpl(UInt.m2602constructorimpl(s & MAX_VALUE) + UInt.m2602constructorimpl(b & UByte.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw */
    private static final int m2787plusxj2QHRw(short s, short s2) {
        return UInt.m2602constructorimpl(UInt.m2602constructorimpl(s & MAX_VALUE) + UInt.m2602constructorimpl(s2 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns */
    private static final int m2786plusWZ4Q5Ns(short s, int i) {
        return UInt.m2602constructorimpl(UInt.m2602constructorimpl(s & MAX_VALUE) + i);
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ */
    private static final long m2785plusVKZWuLQ(short s, long j) {
        return ULong.m2671constructorimpl(ULong.m2671constructorimpl(((long) s) & 65535) + j);
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU */
    private static final int m2779minus7apg3OU(short s, byte b) {
        return UInt.m2602constructorimpl(UInt.m2602constructorimpl(s & MAX_VALUE) - UInt.m2602constructorimpl(b & UByte.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw */
    private static final int m2782minusxj2QHRw(short s, short s2) {
        return UInt.m2602constructorimpl(UInt.m2602constructorimpl(s & MAX_VALUE) - UInt.m2602constructorimpl(s2 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns */
    private static final int m2781minusWZ4Q5Ns(short s, int i) {
        return UInt.m2602constructorimpl(UInt.m2602constructorimpl(s & MAX_VALUE) - i);
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ */
    private static final long m2780minusVKZWuLQ(short s, long j) {
        return ULong.m2671constructorimpl(ULong.m2671constructorimpl(((long) s) & 65535) - j);
    }

    @InlineOnly
    /* renamed from: times-7apg3OU */
    private static final int m2793times7apg3OU(short s, byte b) {
        return UInt.m2602constructorimpl(UInt.m2602constructorimpl(s & MAX_VALUE) * UInt.m2602constructorimpl(b & UByte.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw */
    private static final int m2796timesxj2QHRw(short s, short s2) {
        return UInt.m2602constructorimpl(UInt.m2602constructorimpl(s & MAX_VALUE) * UInt.m2602constructorimpl(s2 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns */
    private static final int m2795timesWZ4Q5Ns(short s, int i) {
        return UInt.m2602constructorimpl(UInt.m2602constructorimpl(s & MAX_VALUE) * i);
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ */
    private static final long m2794timesVKZWuLQ(short s, long j) {
        return ULong.m2671constructorimpl(ULong.m2671constructorimpl(((long) s) & 65535) * j);
    }

    @InlineOnly
    /* renamed from: div-7apg3OU */
    private static final int m2770div7apg3OU(short s, byte b) {
        return UnsignedKt.m2828uintDivideJ1ME1BU(UInt.m2602constructorimpl(s & MAX_VALUE), UInt.m2602constructorimpl(b & UByte.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw */
    private static final int m2773divxj2QHRw(short s, short s2) {
        return UnsignedKt.m2828uintDivideJ1ME1BU(UInt.m2602constructorimpl(s & MAX_VALUE), UInt.m2602constructorimpl(s2 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns */
    private static final int m2772divWZ4Q5Ns(short s, int i) {
        return UnsignedKt.m2828uintDivideJ1ME1BU(UInt.m2602constructorimpl(s & MAX_VALUE), i);
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ */
    private static final long m2771divVKZWuLQ(short s, long j) {
        return UnsignedKt.m2830ulongDivideeb3DHEI(ULong.m2671constructorimpl(((long) s) & 65535), j);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU */
    private static final int m2789rem7apg3OU(short s, byte b) {
        return UnsignedKt.m2829uintRemainderJ1ME1BU(UInt.m2602constructorimpl(s & MAX_VALUE), UInt.m2602constructorimpl(b & UByte.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw */
    private static final int m2792remxj2QHRw(short s, short s2) {
        return UnsignedKt.m2829uintRemainderJ1ME1BU(UInt.m2602constructorimpl(s & MAX_VALUE), UInt.m2602constructorimpl(s2 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns */
    private static final int m2791remWZ4Q5Ns(short s, int i) {
        return UnsignedKt.m2829uintRemainderJ1ME1BU(UInt.m2602constructorimpl(s & MAX_VALUE), i);
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ */
    private static final long m2790remVKZWuLQ(short s, long j) {
        return UnsignedKt.m2831ulongRemaindereb3DHEI(ULong.m2671constructorimpl(((long) s) & 65535), j);
    }

    @InlineOnly
    /* renamed from: inc-impl */
    private static final short m2777incimpl(short s) {
        return m2768constructorimpl((short) (s + 1));
    }

    @InlineOnly
    /* renamed from: dec-impl */
    private static final short m2769decimpl(short s) {
        return m2768constructorimpl((short) (s - 1));
    }

    @InlineOnly
    /* renamed from: rangeTo-xj2QHRw */
    private static final UIntRange m2788rangeToxj2QHRw(short s, short s2) {
        return new UIntRange(UInt.m2602constructorimpl(s & MAX_VALUE), UInt.m2602constructorimpl(s2 & MAX_VALUE), (DefaultConstructorMarker) null);
    }

    @InlineOnly
    /* renamed from: and-xj2QHRw */
    private static final short m2761andxj2QHRw(short s, short s2) {
        return m2768constructorimpl((short) (s & s2));
    }

    @InlineOnly
    /* renamed from: or-xj2QHRw */
    private static final short m2783orxj2QHRw(short s, short s2) {
        return m2768constructorimpl((short) (s | s2));
    }

    @InlineOnly
    /* renamed from: xor-xj2QHRw */
    private static final short m2808xorxj2QHRw(short s, short s2) {
        return m2768constructorimpl((short) (s ^ s2));
    }

    @InlineOnly
    /* renamed from: inv-impl */
    private static final short m2778invimpl(short s) {
        return m2768constructorimpl((short) (~s));
    }

    @InlineOnly
    /* renamed from: toUByte-impl */
    private static final byte m2804toUByteimpl(short s) {
        return UByte.m2535constructorimpl((byte) s);
    }

    @InlineOnly
    /* renamed from: toUInt-impl */
    private static final int m2805toUIntimpl(short s) {
        return UInt.m2602constructorimpl(s & MAX_VALUE);
    }

    @InlineOnly
    /* renamed from: toULong-impl */
    private static final long m2806toULongimpl(short s) {
        return ULong.m2671constructorimpl(((long) s) & 65535);
    }

    @NotNull
    /* renamed from: toString-impl */
    public static String m2803toStringimpl(short s) {
        return String.valueOf(s & MAX_VALUE);
    }
}
