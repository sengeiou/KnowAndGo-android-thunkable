package kotlin.reflect.jvm.internal.impl.platform;

import org.jetbrains.annotations.NotNull;

/* compiled from: TargetPlatform.kt */
public abstract class SimplePlatform {
    @NotNull
    private final String platformName;

    @NotNull
    public String toString() {
        return this.platformName;
    }
}
