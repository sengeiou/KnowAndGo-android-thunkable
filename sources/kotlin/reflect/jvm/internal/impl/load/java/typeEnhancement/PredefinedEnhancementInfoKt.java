package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancementBuilder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import org.jetbrains.annotations.NotNull;

/* compiled from: predefinedEnhancementInfo.kt */
public final class PredefinedEnhancementInfoKt {
    /* access modifiers changed from: private */
    public static final JavaTypeQualifiers NOT_NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, (MutabilityQualifier) null, true, false, 8, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final JavaTypeQualifiers NOT_PLATFORM = new JavaTypeQualifiers(NullabilityQualifier.NOT_NULL, (MutabilityQualifier) null, false, false, 8, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final JavaTypeQualifiers NULLABLE = new JavaTypeQualifiers(NullabilityQualifier.NULLABLE, (MutabilityQualifier) null, false, false, 8, (DefaultConstructorMarker) null);
    @NotNull
    private static final Map<String, PredefinedFunctionEnhancementInfo> PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;

    static {
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        String javaLang = signatureBuildingComponents.javaLang("Object");
        String javaFunction = signatureBuildingComponents.javaFunction("Predicate");
        String javaFunction2 = signatureBuildingComponents.javaFunction("Function");
        String javaFunction3 = signatureBuildingComponents.javaFunction("Consumer");
        String javaFunction4 = signatureBuildingComponents.javaFunction("BiFunction");
        String javaFunction5 = signatureBuildingComponents.javaFunction("BiConsumer");
        String javaFunction6 = signatureBuildingComponents.javaFunction("UnaryOperator");
        String javaUtil = signatureBuildingComponents.javaUtil("stream/Stream");
        String javaUtil2 = signatureBuildingComponents.javaUtil("Optional");
        SignatureEnhancementBuilder signatureEnhancementBuilder = new SignatureEnhancementBuilder();
        SignatureBuildingComponents signatureBuildingComponents2 = signatureBuildingComponents;
        String str = javaFunction;
        String str2 = javaUtil;
        String str3 = javaFunction3;
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder, signatureBuildingComponents.javaUtil("Iterator"));
        String str4 = javaFunction6;
        String str5 = javaFunction6;
        SignatureEnhancementBuilder signatureEnhancementBuilder2 = signatureEnhancementBuilder;
        String str6 = javaFunction5;
        String str7 = javaUtil2;
        String str8 = javaLang;
        String str9 = javaFunction4;
        String str10 = javaFunction2;
        String str11 = str7;
        classEnhancementBuilder.function("forEachRemaining", new C3688xd5dbd441(signatureBuildingComponents2, javaFunction3, javaFunction, str2, str4, str6, str8, str9, str10, str11));
        String str12 = str3;
        String str13 = str;
        String str14 = str5;
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder2, signatureBuildingComponents.javaLang("Iterable")).function("spliterator", new C3699xd5dbd442(signatureBuildingComponents2, str12, str13, str2, str14, str6, str8, str9, str10, str11));
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder2 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder2, signatureBuildingComponents.javaUtil("Collection"));
        classEnhancementBuilder2.function("removeIf", new C3709xd5dbd443(signatureBuildingComponents2, str12, str13, str2, str14, str6, str8, str9, str10, str11));
        classEnhancementBuilder2.function("stream", new C3710xd5dbd444(signatureBuildingComponents2, str12, str13, str2, str14, str6, str8, str9, str10, str11));
        classEnhancementBuilder2.function("parallelStream", new C3711xd5dbd445(signatureBuildingComponents2, str12, str13, str2, str14, str6, str8, str9, str10, str11));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder2, signatureBuildingComponents.javaUtil("List")).function("replaceAll", new C3712xd5dbd446(signatureBuildingComponents2, str12, str13, str2, str14, str6, str8, str9, str10, str11));
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder3 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder2, signatureBuildingComponents.javaUtil("Map"));
        classEnhancementBuilder3.function("forEach", new C3713xd5dbd447(signatureBuildingComponents2, str12, str13, str2, str14, str6, str8, str9, str10, str11));
        classEnhancementBuilder3.function("putIfAbsent", new C3714xd5dbd448(signatureBuildingComponents2, str12, str13, str2, str14, str6, str8, str9, str10, str11));
        classEnhancementBuilder3.function("replace", new C3715xd5dbd449(signatureBuildingComponents2, str12, str13, str2, str14, str6, str8, str9, str10, str11));
        classEnhancementBuilder3.function("replace", new C3689xe59eb40f(signatureBuildingComponents2, str12, str13, str2, str14, str6, str8, str9, str10, str11));
        classEnhancementBuilder3.function("replaceAll", new C3690xe59eb410(signatureBuildingComponents2, str12, str13, str2, str14, str6, str8, str9, str10, str11));
        classEnhancementBuilder3.function("compute", new C3691xe59eb411(signatureBuildingComponents2, str12, str13, str2, str14, str6, str8, str9, str10, str11));
        classEnhancementBuilder3.function("computeIfAbsent", new C3692xe59eb412(signatureBuildingComponents2, str12, str13, str2, str14, str6, str8, str9, str10, str11));
        classEnhancementBuilder3.function("computeIfPresent", new C3693xe59eb413(signatureBuildingComponents2, str12, str13, str2, str14, str6, str8, str9, str10, str11));
        classEnhancementBuilder3.function("merge", new C3694xe59eb414(signatureBuildingComponents2, str12, str13, str2, str14, str6, str8, str9, str10, str11));
        String str15 = str7;
        SignatureEnhancementBuilder.ClassEnhancementBuilder classEnhancementBuilder4 = new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder2, str15);
        String str16 = javaLang;
        String str17 = str15;
        classEnhancementBuilder4.function("empty", new C3695xe59eb415(signatureBuildingComponents2, str12, str13, str2, str14, str6, str16, str9, str10, str17));
        classEnhancementBuilder4.function("of", new C3696xe59eb416(signatureBuildingComponents2, str12, str13, str2, str14, str6, str16, str9, str10, str17));
        classEnhancementBuilder4.function("ofNullable", new C3697xe59eb417(signatureBuildingComponents2, str12, str13, str2, str14, str6, str16, str9, str10, str17));
        classEnhancementBuilder4.function("get", new C3698xe59eb418(signatureBuildingComponents2, str12, str13, str2, str14, str6, str16, str9, str10, str17));
        classEnhancementBuilder4.function("ifPresent", new C3700xe59eb42e(signatureBuildingComponents2, str12, str13, str2, str14, str6, str16, str9, str10, str17));
        SignatureEnhancementBuilder signatureEnhancementBuilder3 = signatureEnhancementBuilder2;
        String str18 = javaFunction5;
        SignatureEnhancementBuilder signatureEnhancementBuilder4 = signatureEnhancementBuilder3;
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder3, signatureBuildingComponents.javaLang("ref/Reference")).function("get", new C3701xe59eb42f(signatureBuildingComponents2, str12, str13, str2, str14, str6, javaLang, str9, str10, str17));
        String str19 = str;
        String str20 = str18;
        String str21 = javaLang;
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder4, str19).function("test", new C3702xe59eb430(signatureBuildingComponents2, str12, str19, str2, str14, str20, str21, str9, str10, str17));
        String str22 = str19;
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder4, signatureBuildingComponents.javaFunction("BiPredicate")).function("test", new C3703xe59eb431(signatureBuildingComponents2, str12, str22, str2, str14, str20, str21, str9, str10, str17));
        String str23 = str3;
        String str24 = str23;
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder4, str23).function("accept", new C3704xe59eb432(signatureBuildingComponents2, str23, str22, str2, str14, str20, javaLang, str9, str10, str17));
        String str25 = str18;
        String str26 = str24;
        String str27 = javaLang;
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder4, str25).function("accept", new C3705xe59eb433(signatureBuildingComponents2, str26, str22, str2, str14, str25, str27, str9, str10, str17));
        String str28 = str25;
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder4, javaFunction2).function("apply", new C3706xe59eb434(signatureBuildingComponents2, str26, str22, str2, str14, str28, str27, str9, str10, str17));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder4, javaFunction4).function("apply", new C3707xe59eb435(signatureBuildingComponents2, str26, str22, str2, str14, str28, str27, str9, str10, str17));
        new SignatureEnhancementBuilder.ClassEnhancementBuilder(signatureEnhancementBuilder4, signatureBuildingComponents.javaFunction("Supplier")).function("get", new C3708xe59eb436(signatureBuildingComponents2, str26, str22, str2, str14, str28, str27, str9, str10, str17));
        PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE = signatureEnhancementBuilder4.build();
    }

    @NotNull
    public static final Map<String, PredefinedFunctionEnhancementInfo> getPREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE() {
        return PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE;
    }
}
