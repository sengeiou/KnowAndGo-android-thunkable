package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KotlinClassFinder.kt */
public interface KotlinClassFinder extends KotlinMetadataFinder {
    @Nullable
    Result findKotlinClassOrContent(@NotNull JavaClass javaClass);

    @Nullable
    Result findKotlinClassOrContent(@NotNull ClassId classId);

    /* compiled from: KotlinClassFinder.kt */
    public static abstract class Result {
        private Result() {
        }

        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final KotlinJvmBinaryClass toKotlinJvmBinaryClass() {
            KotlinClass kotlinClass = (KotlinClass) (!(this instanceof KotlinClass) ? null : this);
            if (kotlinClass != null) {
                return kotlinClass.getKotlinJvmBinaryClass();
            }
            return null;
        }

        /* compiled from: KotlinClassFinder.kt */
        public static final class KotlinClass extends Result {
            @NotNull
            private final KotlinJvmBinaryClass kotlinJvmBinaryClass;

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof KotlinClass) && Intrinsics.areEqual((Object) this.kotlinJvmBinaryClass, (Object) ((KotlinClass) obj).kotlinJvmBinaryClass);
                }
                return true;
            }

            public int hashCode() {
                KotlinJvmBinaryClass kotlinJvmBinaryClass2 = this.kotlinJvmBinaryClass;
                if (kotlinJvmBinaryClass2 != null) {
                    return kotlinJvmBinaryClass2.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return "KotlinClass(kotlinJvmBinaryClass=" + this.kotlinJvmBinaryClass + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public KotlinClass(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkParameterIsNotNull(kotlinJvmBinaryClass2, "kotlinJvmBinaryClass");
                this.kotlinJvmBinaryClass = kotlinJvmBinaryClass2;
            }

            @NotNull
            public final KotlinJvmBinaryClass getKotlinJvmBinaryClass() {
                return this.kotlinJvmBinaryClass;
            }
        }

        /* compiled from: KotlinClassFinder.kt */
        public static final class ClassFileContent extends Result {
            @NotNull
            private final byte[] content;

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof ClassFileContent) && Intrinsics.areEqual((Object) this.content, (Object) ((ClassFileContent) obj).content);
                }
                return true;
            }

            public int hashCode() {
                byte[] bArr = this.content;
                if (bArr != null) {
                    return Arrays.hashCode(bArr);
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return "ClassFileContent(content=" + Arrays.toString(this.content) + ")";
            }

            @NotNull
            public final byte[] getContent() {
                return this.content;
            }
        }
    }
}
