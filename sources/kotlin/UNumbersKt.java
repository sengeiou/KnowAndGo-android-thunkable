package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\bH\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u000bH\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0004\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0007\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\bH\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\n\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\u000bH\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\r\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0004\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0007\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\bH\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\n\u001a\u0017\u0010\u0013\u001a\u00020\u0001*\u00020\u000bH\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\r\u001a\u001f\u0010\u0018\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u0018\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001f\u0010\u0018\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001f\u0010\u0018\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001f\u0010\"\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b#\u0010\u001b\u001a\u001f\u0010\"\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b$\u0010\u001d\u001a\u001f\u0010\"\u001a\u00020\b*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b%\u0010\u001f\u001a\u001f\u0010\"\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b&\u0010!\u001a\u0017\u0010'\u001a\u00020\u0002*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u0017\u0010'\u001a\u00020\u0005*\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0007\u001a\u0017\u0010'\u001a\u00020\b*\u00020\bH\bø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u0017\u0010'\u001a\u00020\u000b*\u00020\u000bH\bø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u0017\u0010/\u001a\u00020\u0002*\u00020\u0002H\bø\u0001\u0000¢\u0006\u0004\b0\u0010)\u001a\u0017\u0010/\u001a\u00020\u0005*\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b1\u0010\u0007\u001a\u0017\u0010/\u001a\u00020\b*\u00020\bH\bø\u0001\u0000¢\u0006\u0004\b2\u0010,\u001a\u0017\u0010/\u001a\u00020\u000b*\u00020\u000bH\bø\u0001\u0000¢\u0006\u0004\b3\u0010.\u0002\u0004\n\u0002\b\u0019¨\u00064"}, mo39786d2 = {"countLeadingZeroBits", "", "Lkotlin/UByte;", "countLeadingZeroBits-7apg3OU", "(B)I", "Lkotlin/UInt;", "countLeadingZeroBits-WZ4Q5Ns", "(I)I", "Lkotlin/ULong;", "countLeadingZeroBits-VKZWuLQ", "(J)I", "Lkotlin/UShort;", "countLeadingZeroBits-xj2QHRw", "(S)I", "countOneBits", "countOneBits-7apg3OU", "countOneBits-WZ4Q5Ns", "countOneBits-VKZWuLQ", "countOneBits-xj2QHRw", "countTrailingZeroBits", "countTrailingZeroBits-7apg3OU", "countTrailingZeroBits-WZ4Q5Ns", "countTrailingZeroBits-VKZWuLQ", "countTrailingZeroBits-xj2QHRw", "rotateLeft", "bitCount", "rotateLeft-LxnNnR4", "(BI)B", "rotateLeft-V7xB4Y4", "(II)I", "rotateLeft-JSWoG40", "(JI)J", "rotateLeft-olVBNx4", "(SI)S", "rotateRight", "rotateRight-LxnNnR4", "rotateRight-V7xB4Y4", "rotateRight-JSWoG40", "rotateRight-olVBNx4", "takeHighestOneBit", "takeHighestOneBit-7apg3OU", "(B)B", "takeHighestOneBit-WZ4Q5Ns", "takeHighestOneBit-VKZWuLQ", "(J)J", "takeHighestOneBit-xj2QHRw", "(S)S", "takeLowestOneBit", "takeLowestOneBit-7apg3OU", "takeLowestOneBit-WZ4Q5Ns", "takeLowestOneBit-VKZWuLQ", "takeLowestOneBit-xj2QHRw", "kotlin-stdlib"}, mo39787k = 2, mo39788mv = {1, 1, 15})
@JvmName(name = "UNumbersKt")
/* compiled from: UNumbers.kt */
public final class UNumbersKt {
    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countOneBits-WZ4Q5Ns */
    private static final int m2739countOneBitsWZ4Q5Ns(int i) {
        return Integer.bitCount(i);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countLeadingZeroBits-WZ4Q5Ns */
    private static final int m2735countLeadingZeroBitsWZ4Q5Ns(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countTrailingZeroBits-WZ4Q5Ns */
    private static final int m2743countTrailingZeroBitsWZ4Q5Ns(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: takeHighestOneBit-WZ4Q5Ns */
    private static final int m2755takeHighestOneBitWZ4Q5Ns(int i) {
        return UInt.m2602constructorimpl(Integer.highestOneBit(i));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: takeLowestOneBit-WZ4Q5Ns */
    private static final int m2759takeLowestOneBitWZ4Q5Ns(int i) {
        return UInt.m2602constructorimpl(Integer.lowestOneBit(i));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rotateLeft-V7xB4Y4 */
    private static final int m2747rotateLeftV7xB4Y4(int i, int i2) {
        return UInt.m2602constructorimpl(Integer.rotateLeft(i, i2));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rotateRight-V7xB4Y4 */
    private static final int m2751rotateRightV7xB4Y4(int i, int i2) {
        return UInt.m2602constructorimpl(Integer.rotateRight(i, i2));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countOneBits-VKZWuLQ */
    private static final int m2738countOneBitsVKZWuLQ(long j) {
        return Long.bitCount(j);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countLeadingZeroBits-VKZWuLQ */
    private static final int m2734countLeadingZeroBitsVKZWuLQ(long j) {
        return Long.numberOfLeadingZeros(j);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countTrailingZeroBits-VKZWuLQ */
    private static final int m2742countTrailingZeroBitsVKZWuLQ(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: takeHighestOneBit-VKZWuLQ */
    private static final long m2754takeHighestOneBitVKZWuLQ(long j) {
        return ULong.m2671constructorimpl(Long.highestOneBit(j));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: takeLowestOneBit-VKZWuLQ */
    private static final long m2758takeLowestOneBitVKZWuLQ(long j) {
        return ULong.m2671constructorimpl(Long.lowestOneBit(j));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rotateLeft-JSWoG40 */
    private static final long m2745rotateLeftJSWoG40(long j, int i) {
        return ULong.m2671constructorimpl(Long.rotateLeft(j, i));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rotateRight-JSWoG40 */
    private static final long m2749rotateRightJSWoG40(long j, int i) {
        return ULong.m2671constructorimpl(Long.rotateRight(j, i));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countOneBits-7apg3OU */
    private static final int m2737countOneBits7apg3OU(byte b) {
        return Integer.bitCount(UInt.m2602constructorimpl(b & UByte.MAX_VALUE));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countLeadingZeroBits-7apg3OU */
    private static final int m2733countLeadingZeroBits7apg3OU(byte b) {
        return Integer.numberOfLeadingZeros(b & UByte.MAX_VALUE) - 24;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countTrailingZeroBits-7apg3OU */
    private static final int m2741countTrailingZeroBits7apg3OU(byte b) {
        return Integer.numberOfTrailingZeros(b | UByte.MIN_VALUE);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: takeHighestOneBit-7apg3OU */
    private static final byte m2753takeHighestOneBit7apg3OU(byte b) {
        return UByte.m2535constructorimpl((byte) Integer.highestOneBit(b & UByte.MAX_VALUE));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: takeLowestOneBit-7apg3OU */
    private static final byte m2757takeLowestOneBit7apg3OU(byte b) {
        return UByte.m2535constructorimpl((byte) Integer.lowestOneBit(b & UByte.MAX_VALUE));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rotateLeft-LxnNnR4 */
    private static final byte m2746rotateLeftLxnNnR4(byte b, int i) {
        return UByte.m2535constructorimpl(NumbersKt.rotateLeft(b, i));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rotateRight-LxnNnR4 */
    private static final byte m2750rotateRightLxnNnR4(byte b, int i) {
        return UByte.m2535constructorimpl(NumbersKt.rotateRight(b, i));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countOneBits-xj2QHRw */
    private static final int m2740countOneBitsxj2QHRw(short s) {
        return Integer.bitCount(UInt.m2602constructorimpl(s & UShort.MAX_VALUE));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countLeadingZeroBits-xj2QHRw */
    private static final int m2736countLeadingZeroBitsxj2QHRw(short s) {
        return Integer.numberOfLeadingZeros(s & UShort.MAX_VALUE) - 16;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: countTrailingZeroBits-xj2QHRw */
    private static final int m2744countTrailingZeroBitsxj2QHRw(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: takeHighestOneBit-xj2QHRw */
    private static final short m2756takeHighestOneBitxj2QHRw(short s) {
        return UShort.m2768constructorimpl((short) Integer.highestOneBit(s & UShort.MAX_VALUE));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: takeLowestOneBit-xj2QHRw */
    private static final short m2760takeLowestOneBitxj2QHRw(short s) {
        return UShort.m2768constructorimpl((short) Integer.lowestOneBit(s & UShort.MAX_VALUE));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rotateLeft-olVBNx4 */
    private static final short m2748rotateLeftolVBNx4(short s, int i) {
        return UShort.m2768constructorimpl(NumbersKt.rotateLeft(s, i));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    /* renamed from: rotateRight-olVBNx4 */
    private static final short m2752rotateRightolVBNx4(short s, int i) {
        return UShort.m2768constructorimpl(NumbersKt.rotateRight(s, i));
    }
}
