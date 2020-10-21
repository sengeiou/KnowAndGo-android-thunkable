package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeSubstitution.kt */
public abstract class TypeConstructorSubstitution extends TypeSubstitution {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    @NotNull
    public static final TypeSubstitution create(@NotNull TypeConstructor typeConstructor, @NotNull List<? extends TypeProjection> list) {
        return Companion.create(typeConstructor, list);
    }

    @JvmStatic
    @NotNull
    @JvmOverloads
    public static final TypeConstructorSubstitution createByConstructorsMap(@NotNull Map<TypeConstructor, ? extends TypeProjection> map) {
        return Companion.createByConstructorsMap$default(Companion, map, false, 2, (Object) null);
    }

    @Nullable
    public abstract TypeProjection get(@NotNull TypeConstructor typeConstructor);

    @Nullable
    public TypeProjection get(@NotNull KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "key");
        return get(kotlinType.getConstructor());
    }

    /* compiled from: TypeSubstitution.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ TypeConstructorSubstitution createByConstructorsMap$default(Companion companion, Map map, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.createByConstructorsMap(map, z);
        }

        @JvmStatic
        @NotNull
        @JvmOverloads
        public final TypeConstructorSubstitution createByConstructorsMap(@NotNull Map<TypeConstructor, ? extends TypeProjection> map, boolean z) {
            Intrinsics.checkParameterIsNotNull(map, "map");
            return new TypeConstructorSubstitution$Companion$createByConstructorsMap$1(map, z);
        }

        @JvmStatic
        @NotNull
        public final TypeSubstitution create(@NotNull KotlinType kotlinType) {
            Intrinsics.checkParameterIsNotNull(kotlinType, "kotlinType");
            return create(kotlinType.getConstructor(), kotlinType.getArguments());
        }

        @JvmStatic
        @NotNull
        public final TypeSubstitution create(@NotNull TypeConstructor typeConstructor, @NotNull List<? extends TypeProjection> list) {
            Intrinsics.checkParameterIsNotNull(typeConstructor, "typeConstructor");
            Intrinsics.checkParameterIsNotNull(list, "arguments");
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters, "typeConstructor.parameters");
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) CollectionsKt.lastOrNull(parameters);
            if (!(typeParameterDescriptor != null ? typeParameterDescriptor.isCapturedFromOuterDeclaration() : false)) {
                return new IndexedParametersSubstitution(parameters, list);
            }
            Companion companion = this;
            List<TypeParameterDescriptor> parameters2 = typeConstructor.getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters2, "typeConstructor.parameters");
            Iterable<TypeParameterDescriptor> iterable = parameters2;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (TypeParameterDescriptor typeParameterDescriptor2 : iterable) {
                Intrinsics.checkExpressionValueIsNotNull(typeParameterDescriptor2, "it");
                arrayList.add(typeParameterDescriptor2.getTypeConstructor());
            }
            return createByConstructorsMap$default(companion, MapsKt.toMap(CollectionsKt.zip((List) arrayList, list)), false, 2, (Object) null);
        }
    }
}
