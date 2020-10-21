package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty1;
import org.jetbrains.annotations.Nullable;

@Metadata(mo39784bv = {1, 0, 3}, mo39787k = 3, mo39788mv = {1, 1, 15})
/* compiled from: KClasses.kt */
final /* synthetic */ class KClasses$isSubclassOf$1 extends PropertyReference1 {
    public static final KProperty1 INSTANCE = new KClasses$isSubclassOf$1();

    KClasses$isSubclassOf$1() {
    }

    public String getName() {
        return "superclasses";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(KClasses.class, "kotlin-reflection");
    }

    public String getSignature() {
        return "getSuperclasses(Lkotlin/reflect/KClass;)Ljava/util/List;";
    }

    @Nullable
    public Object get(@Nullable Object obj) {
        return KClasses.getSuperclasses((KClass) obj);
    }
}
