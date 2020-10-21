package kotlin.random;

import java.util.Random;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\t\u0010\u0000\u001a\u00020\u0001H\b\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0007\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0007¨\u0006\n"}, mo39786d2 = {"defaultPlatformRandom", "Lkotlin/random/Random;", "doubleFromParts", "", "hi26", "", "low27", "asJavaRandom", "Ljava/util/Random;", "asKotlinRandom", "kotlin-stdlib"}, mo39787k = 2, mo39788mv = {1, 1, 15})
/* compiled from: PlatformRandom.kt */
public final class PlatformRandomKt {
    public static final double doubleFromParts(int i, int i2) {
        return ((double) ((((long) i) << 27) + ((long) i2))) / ((double) 9007199254740992L);
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static final Random asJavaRandom(@NotNull Random random) {
        Random impl;
        Intrinsics.checkParameterIsNotNull(random, "$this$asJavaRandom");
        AbstractPlatformRandom abstractPlatformRandom = (AbstractPlatformRandom) (!(random instanceof AbstractPlatformRandom) ? null : random);
        return (abstractPlatformRandom == null || (impl = abstractPlatformRandom.getImpl()) == null) ? new KotlinRandom(random) : impl;
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static final Random asKotlinRandom(@NotNull Random random) {
        Random impl;
        Intrinsics.checkParameterIsNotNull(random, "$this$asKotlinRandom");
        KotlinRandom kotlinRandom = (KotlinRandom) (!(random instanceof KotlinRandom) ? null : random);
        return (kotlinRandom == null || (impl = kotlinRandom.getImpl()) == null) ? new PlatformRandom(random) : impl;
    }

    @InlineOnly
    private static final Random defaultPlatformRandom() {
        return PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }
}
