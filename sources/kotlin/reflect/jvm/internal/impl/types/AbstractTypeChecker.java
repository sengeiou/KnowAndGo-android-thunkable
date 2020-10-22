package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractTypeChecker.kt */
public final class AbstractTypeChecker {
    public static final AbstractTypeChecker INSTANCE = new AbstractTypeChecker();
    @JvmField
    public static boolean RUN_SLOW_ASSERTIONS;

    private AbstractTypeChecker() {
    }

    public final boolean isSubtypeOf(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2) {
        Intrinsics.checkParameterIsNotNull(abstractTypeCheckerContext, "context");
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, "subType");
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker2, "superType");
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        return completeIsSubTypeOf(abstractTypeCheckerContext, abstractTypeCheckerContext.prepareType(kotlinTypeMarker), abstractTypeCheckerContext.prepareType(kotlinTypeMarker2));
    }

    public final boolean equalTypes(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2) {
        Intrinsics.checkParameterIsNotNull(abstractTypeCheckerContext, "context");
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker, NotificationBundleProcessor.PUSH_ADDITIONAL_DATA_KEY);
        Intrinsics.checkParameterIsNotNull(kotlinTypeMarker2, "b");
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        if (INSTANCE.isCommonDenotableType(abstractTypeCheckerContext, kotlinTypeMarker) && INSTANCE.isCommonDenotableType(abstractTypeCheckerContext, kotlinTypeMarker2)) {
            SimpleTypeMarker lowerBoundIfFlexible = abstractTypeCheckerContext.lowerBoundIfFlexible(kotlinTypeMarker);
            if (!abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(kotlinTypeMarker), abstractTypeCheckerContext.typeConstructor(kotlinTypeMarker2))) {
                return false;
            }
            if (abstractTypeCheckerContext.argumentsCount(lowerBoundIfFlexible) == 0) {
                if (abstractTypeCheckerContext.hasFlexibleNullability(kotlinTypeMarker) || abstractTypeCheckerContext.hasFlexibleNullability(kotlinTypeMarker2) || abstractTypeCheckerContext.isMarkedNullable(lowerBoundIfFlexible) == abstractTypeCheckerContext.isMarkedNullable(abstractTypeCheckerContext.lowerBoundIfFlexible(kotlinTypeMarker2))) {
                    return true;
                }
                return false;
            }
        }
        if (!INSTANCE.isSubtypeOf(abstractTypeCheckerContext, kotlinTypeMarker, kotlinTypeMarker2) || !INSTANCE.isSubtypeOf(abstractTypeCheckerContext, kotlinTypeMarker2, kotlinTypeMarker)) {
            return false;
        }
        return true;
    }

    private final boolean completeIsSubTypeOf(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        Boolean checkSubtypeForSpecialCases = checkSubtypeForSpecialCases(abstractTypeCheckerContext, abstractTypeCheckerContext.lowerBoundIfFlexible(kotlinTypeMarker), abstractTypeCheckerContext.upperBoundIfFlexible(kotlinTypeMarker2));
        if (checkSubtypeForSpecialCases != null) {
            boolean booleanValue = checkSubtypeForSpecialCases.booleanValue();
            abstractTypeCheckerContext.addSubtypeConstraint(kotlinTypeMarker, kotlinTypeMarker2);
            return booleanValue;
        }
        Boolean addSubtypeConstraint = abstractTypeCheckerContext.addSubtypeConstraint(kotlinTypeMarker, kotlinTypeMarker2);
        if (addSubtypeConstraint != null) {
            return addSubtypeConstraint.booleanValue();
        }
        return isSubtypeOfForSingleClassifierType(abstractTypeCheckerContext, abstractTypeCheckerContext.lowerBoundIfFlexible(kotlinTypeMarker), abstractTypeCheckerContext.upperBoundIfFlexible(kotlinTypeMarker2));
    }

    private final Boolean checkSubtypeForIntegerLiteralType(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        if (!abstractTypeCheckerContext.isIntegerLiteralType(simpleTypeMarker) && !abstractTypeCheckerContext.isIntegerLiteralType(simpleTypeMarker2)) {
            return null;
        }
        AbstractTypeChecker$checkSubtypeForIntegerLiteralType$1 abstractTypeChecker$checkSubtypeForIntegerLiteralType$1 = new AbstractTypeChecker$checkSubtypeForIntegerLiteralType$1(abstractTypeCheckerContext);
        if (abstractTypeCheckerContext.isIntegerLiteralType(simpleTypeMarker) && abstractTypeCheckerContext.isIntegerLiteralType(simpleTypeMarker2)) {
            return true;
        }
        if (abstractTypeCheckerContext.isIntegerLiteralType(simpleTypeMarker)) {
            if (abstractTypeChecker$checkSubtypeForIntegerLiteralType$1.invoke(simpleTypeMarker, simpleTypeMarker2)) {
                return true;
            }
        } else if (abstractTypeCheckerContext.isIntegerLiteralType(simpleTypeMarker2) && abstractTypeChecker$checkSubtypeForIntegerLiteralType$1.invoke(simpleTypeMarker2, simpleTypeMarker)) {
            return true;
        }
        return null;
    }

    private final boolean hasNothingSupertype(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker) {
        AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy;
        TypeConstructorMarker typeConstructor = abstractTypeCheckerContext.typeConstructor(simpleTypeMarker);
        if (abstractTypeCheckerContext.isClassTypeConstructor(typeConstructor)) {
            return abstractTypeCheckerContext.isNothingConstructor(typeConstructor);
        }
        if (abstractTypeCheckerContext.isNothingConstructor(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker))) {
            return true;
        }
        abstractTypeCheckerContext.initialize();
        ArrayDeque<SimpleTypeMarker> supertypesDeque = abstractTypeCheckerContext.getSupertypesDeque();
        if (supertypesDeque == null) {
            Intrinsics.throwNpe();
        }
        Set<SimpleTypeMarker> supertypesSet = abstractTypeCheckerContext.getSupertypesSet();
        if (supertypesSet == null) {
            Intrinsics.throwNpe();
        }
        supertypesDeque.push(simpleTypeMarker);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() <= 1000) {
                SimpleTypeMarker pop = supertypesDeque.pop();
                Intrinsics.checkExpressionValueIsNotNull(pop, "current");
                if (supertypesSet.add(pop)) {
                    if (abstractTypeCheckerContext.isClassType(pop)) {
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
                    } else {
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    }
                    if (!(!Intrinsics.areEqual((Object) supertypesPolicy, (Object) AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy != null) {
                        for (KotlinTypeMarker transformType : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(pop))) {
                            SimpleTypeMarker transformType2 = supertypesPolicy.transformType(abstractTypeCheckerContext, transformType);
                            if (abstractTypeCheckerContext.isNothingConstructor(abstractTypeCheckerContext.typeConstructor(transformType2))) {
                                abstractTypeCheckerContext.clear();
                                return true;
                            }
                            supertypesDeque.add(transformType2);
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            } else {
                throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker + ". Supertypes = " + CollectionsKt.joinToString$default(supertypesSet, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)).toString());
            }
        }
        abstractTypeCheckerContext.clear();
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x011b A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isSubtypeOfForSingleClassifierType(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext r13, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r14, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r15) {
        /*
            r12 = this;
            boolean r0 = RUN_SLOW_ASSERTIONS
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0076
            boolean r0 = r13.isSingleClassifierType(r14)
            if (r0 != 0) goto L_0x0022
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r0 = r13.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r14)
            boolean r0 = r13.isIntersection(r0)
            if (r0 != 0) goto L_0x0022
            r0 = r14
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r0 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r0
            boolean r0 = r13.isAllowedTypeVariable(r0)
            if (r0 == 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r0 = 0
            goto L_0x0023
        L_0x0022:
            r0 = 1
        L_0x0023:
            boolean r3 = kotlin._Assertions.ENABLED
            if (r3 == 0) goto L_0x0043
            if (r0 == 0) goto L_0x002a
            goto L_0x0043
        L_0x002a:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r15 = "Not singleClassifierType and not intersection subType: "
            r13.append(r15)
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.AssertionError r14 = new java.lang.AssertionError
            r14.<init>(r13)
            java.lang.Throwable r14 = (java.lang.Throwable) r14
            throw r14
        L_0x0043:
            boolean r0 = r13.isSingleClassifierType(r15)
            if (r0 != 0) goto L_0x0055
            r0 = r15
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r0 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r0
            boolean r0 = r13.isAllowedTypeVariable(r0)
            if (r0 == 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r0 = 0
            goto L_0x0056
        L_0x0055:
            r0 = 1
        L_0x0056:
            boolean r3 = kotlin._Assertions.ENABLED
            if (r3 == 0) goto L_0x0076
            if (r0 == 0) goto L_0x005d
            goto L_0x0076
        L_0x005d:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Not singleClassifierType superType: "
            r13.append(r14)
            r13.append(r15)
            java.lang.String r13 = r13.toString()
            java.lang.AssertionError r14 = new java.lang.AssertionError
            r14.<init>(r13)
            java.lang.Throwable r14 = (java.lang.Throwable) r14
            throw r14
        L_0x0076:
            kotlin.reflect.jvm.internal.impl.types.AbstractNullabilityChecker r0 = kotlin.reflect.jvm.internal.impl.types.AbstractNullabilityChecker.INSTANCE
            boolean r0 = r0.isPossibleSubtype(r13, r14, r15)
            if (r0 != 0) goto L_0x007f
            return r2
        L_0x007f:
            r0 = r14
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r0 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r0
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r3 = r13.lowerBoundIfFlexible(r0)
            r4 = r15
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r4 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r4
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r5 = r13.upperBoundIfFlexible(r4)
            java.lang.Boolean r3 = r12.checkSubtypeForIntegerLiteralType(r13, r3, r5)
            if (r3 == 0) goto L_0x009b
            boolean r14 = r3.booleanValue()
            r13.addSubtypeConstraint(r0, r4)
            return r14
        L_0x009b:
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r0 = r13.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r15)
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r3 = r13.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r14)
            boolean r3 = r13.isEqualTypeConstructors(r3, r0)
            if (r3 == 0) goto L_0x00b0
            int r3 = r13.parametersCount(r0)
            if (r3 != 0) goto L_0x00b0
            return r1
        L_0x00b0:
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r3 = r13.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r15)
            boolean r3 = r13.isAnyConstructor(r3)
            if (r3 == 0) goto L_0x00bb
            return r1
        L_0x00bb:
            java.util.List r3 = r12.findCorrespondingSupertypes(r13, r14, r0)
            int r4 = r3.size()
            switch(r4) {
                case 0: goto L_0x00e5;
                case 1: goto L_0x00d6;
                default: goto L_0x00c6;
            }
        L_0x00c6:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext$SeveralSupertypesWithSameConstructorPolicy r4 = r13.getSameConstructorPolicy()
            int[] r5 = kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.WhenMappings.$EnumSwitchMapping$0
            int r4 = r4.ordinal()
            r4 = r5[r4]
            switch(r4) {
                case 1: goto L_0x012b;
                case 2: goto L_0x011c;
                case 3: goto L_0x00ea;
                case 4: goto L_0x00ea;
                default: goto L_0x00d5;
            }
        L_0x00d5:
            goto L_0x012c
        L_0x00d6:
            java.lang.Object r14 = kotlin.collections.CollectionsKt.first(r3)
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r14 = (kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r14
            kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker r14 = r13.asArgumentList(r14)
            boolean r13 = r12.isSubtypeForSameConstructor(r13, r14, r15)
            return r13
        L_0x00e5:
            boolean r13 = r12.hasNothingSupertype(r13, r14)
            return r13
        L_0x00ea:
            r4 = r3
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            boolean r5 = r4 instanceof java.util.Collection
            if (r5 == 0) goto L_0x00fc
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x00fc
        L_0x00fa:
            r4 = 0
            goto L_0x0119
        L_0x00fc:
            java.util.Iterator r4 = r4.iterator()
        L_0x0100:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00fa
            java.lang.Object r5 = r4.next()
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r5 = (kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r5
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker r6 = INSTANCE
            kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker r5 = r13.asArgumentList(r5)
            boolean r5 = r6.isSubtypeForSameConstructor(r13, r5, r15)
            if (r5 == 0) goto L_0x0100
            r4 = 1
        L_0x0119:
            if (r4 == 0) goto L_0x012c
            return r1
        L_0x011c:
            java.lang.Object r14 = kotlin.collections.CollectionsKt.first(r3)
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r14 = (kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r14
            kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker r14 = r13.asArgumentList(r14)
            boolean r13 = r12.isSubtypeForSameConstructor(r13, r14, r15)
            return r13
        L_0x012b:
            return r2
        L_0x012c:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext$SeveralSupertypesWithSameConstructorPolicy r4 = r13.getSameConstructorPolicy()
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext$SeveralSupertypesWithSameConstructorPolicy r5 = kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SeveralSupertypesWithSameConstructorPolicy.INTERSECT_ARGUMENTS_AND_CHECK_AGAIN
            if (r4 == r5) goto L_0x0135
            return r2
        L_0x0135:
            kotlin.reflect.jvm.internal.impl.types.model.ArgumentList r4 = new kotlin.reflect.jvm.internal.impl.types.model.ArgumentList
            int r5 = r13.parametersCount(r0)
            r4.<init>(r5)
            int r0 = r13.parametersCount(r0)
            r5 = 0
        L_0x0143:
            if (r5 >= r0) goto L_0x01c3
            r6 = r3
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r8 = 10
            int r8 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r8)
            r7.<init>(r8)
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r6 = r6.iterator()
        L_0x0159:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x01b3
            java.lang.Object r8 = r6.next()
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r8 = (kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r8
            kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker r9 = r13.getArgumentOrNull(r8, r5)
            if (r9 == 0) goto L_0x0186
            kotlin.reflect.jvm.internal.impl.types.model.TypeVariance r10 = r13.getVariance((kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker) r9)
            kotlin.reflect.jvm.internal.impl.types.model.TypeVariance r11 = kotlin.reflect.jvm.internal.impl.types.model.TypeVariance.INV
            if (r10 != r11) goto L_0x0175
            r10 = 1
            goto L_0x0176
        L_0x0175:
            r10 = 0
        L_0x0176:
            if (r10 == 0) goto L_0x0179
            goto L_0x017a
        L_0x0179:
            r9 = 0
        L_0x017a:
            if (r9 == 0) goto L_0x0186
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r9 = r13.getType(r9)
            if (r9 == 0) goto L_0x0186
            r7.add(r9)
            goto L_0x0159
        L_0x0186:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "Incorrect type: "
            r13.append(r0)
            r13.append(r8)
            java.lang.String r0 = ", subType: "
            r13.append(r0)
            r13.append(r14)
            java.lang.String r14 = ", superType: "
            r13.append(r14)
            r13.append(r15)
            java.lang.String r13 = r13.toString()
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r13 = r13.toString()
            r14.<init>(r13)
            java.lang.Throwable r14 = (java.lang.Throwable) r14
            throw r14
        L_0x01b3:
            java.util.List r7 = (java.util.List) r7
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r6 = r13.intersectTypes(r7)
            kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker r6 = r13.asTypeArgument(r6)
            r4.add(r6)
            int r5 = r5 + 1
            goto L_0x0143
        L_0x01c3:
            kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker r4 = (kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker) r4
            boolean r13 = r12.isSubtypeForSameConstructor(r13, r4, r15)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.isSubtypeOfForSingleClassifierType(kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker):boolean");
    }

    public final boolean isSubtypeForSameConstructor(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull TypeArgumentListMarker typeArgumentListMarker, @NotNull SimpleTypeMarker simpleTypeMarker) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(abstractTypeCheckerContext, "$this$isSubtypeForSameConstructor");
        Intrinsics.checkParameterIsNotNull(typeArgumentListMarker, "capturedSubArguments");
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "superType");
        TypeConstructorMarker typeConstructor = abstractTypeCheckerContext.typeConstructor(simpleTypeMarker);
        int parametersCount = abstractTypeCheckerContext.parametersCount(typeConstructor);
        for (int i = 0; i < parametersCount; i++) {
            TypeArgumentMarker argument = abstractTypeCheckerContext.getArgument(simpleTypeMarker, i);
            if (!abstractTypeCheckerContext.isStarProjection(argument)) {
                KotlinTypeMarker type = abstractTypeCheckerContext.getType(argument);
                TypeArgumentMarker typeArgumentMarker = abstractTypeCheckerContext.get(typeArgumentListMarker, i);
                boolean z2 = abstractTypeCheckerContext.getVariance(typeArgumentMarker) == TypeVariance.INV;
                if (!_Assertions.ENABLED || z2) {
                    KotlinTypeMarker type2 = abstractTypeCheckerContext.getType(typeArgumentMarker);
                    TypeVariance effectiveVariance = effectiveVariance(abstractTypeCheckerContext.getVariance(abstractTypeCheckerContext.getParameter(typeConstructor, i)), abstractTypeCheckerContext.getVariance(argument));
                    if (effectiveVariance == null) {
                        return abstractTypeCheckerContext.isErrorTypeEqualsToAnything();
                    }
                    if (abstractTypeCheckerContext.argumentsDepth <= 100) {
                        abstractTypeCheckerContext.argumentsDepth = abstractTypeCheckerContext.argumentsDepth + 1;
                        switch (effectiveVariance) {
                            case INV:
                                z = INSTANCE.equalTypes(abstractTypeCheckerContext, type2, type);
                                break;
                            case OUT:
                                z = INSTANCE.isSubtypeOf(abstractTypeCheckerContext, type2, type);
                                break;
                            case IN:
                                z = INSTANCE.isSubtypeOf(abstractTypeCheckerContext, type, type2);
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                        abstractTypeCheckerContext.argumentsDepth = abstractTypeCheckerContext.argumentsDepth - 1;
                        if (!z) {
                            return false;
                        }
                    } else {
                        throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + type2).toString());
                    }
                } else {
                    throw new AssertionError("Incorrect sub argument: " + typeArgumentMarker);
                }
            }
        }
        return true;
    }

    private final boolean isCommonDenotableType(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, KotlinTypeMarker kotlinTypeMarker) {
        return abstractTypeCheckerContext.isDenotable(abstractTypeCheckerContext.typeConstructor(kotlinTypeMarker)) && !abstractTypeCheckerContext.isDynamic(kotlinTypeMarker) && !abstractTypeCheckerContext.isDefinitelyNotNullType(kotlinTypeMarker) && Intrinsics.areEqual((Object) abstractTypeCheckerContext.typeConstructor(abstractTypeCheckerContext.lowerBoundIfFlexible(kotlinTypeMarker)), (Object) abstractTypeCheckerContext.typeConstructor(abstractTypeCheckerContext.upperBoundIfFlexible(kotlinTypeMarker)));
    }

    @Nullable
    public final TypeVariance effectiveVariance(@NotNull TypeVariance typeVariance, @NotNull TypeVariance typeVariance2) {
        Intrinsics.checkParameterIsNotNull(typeVariance, "declared");
        Intrinsics.checkParameterIsNotNull(typeVariance2, "useSite");
        if (typeVariance == TypeVariance.INV) {
            return typeVariance2;
        }
        if (typeVariance2 == TypeVariance.INV || typeVariance == typeVariance2) {
            return typeVariance;
        }
        return null;
    }

    private final Boolean checkSubtypeForSpecialCases(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        KotlinTypeMarker kotlinTypeMarker = simpleTypeMarker;
        boolean z = true;
        if (abstractTypeCheckerContext.isError(kotlinTypeMarker) || abstractTypeCheckerContext.isError(simpleTypeMarker2)) {
            if (abstractTypeCheckerContext.isErrorTypeEqualsToAnything()) {
                return true;
            }
            if (!abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker) || abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker2)) {
                return Boolean.valueOf(AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(abstractTypeCheckerContext, abstractTypeCheckerContext.withNullability(simpleTypeMarker, false), abstractTypeCheckerContext.withNullability(simpleTypeMarker2, false)));
            }
            return false;
        } else if (abstractTypeCheckerContext.isStubType(simpleTypeMarker) || abstractTypeCheckerContext.isStubType(simpleTypeMarker2)) {
            return true;
        } else {
            CapturedTypeMarker asCapturedType = abstractTypeCheckerContext.asCapturedType(simpleTypeMarker2);
            KotlinTypeMarker lowerType = asCapturedType != null ? abstractTypeCheckerContext.lowerType(asCapturedType) : null;
            if (!(asCapturedType == null || lowerType == null)) {
                switch (abstractTypeCheckerContext.getLowerCapturedTypePolicy(simpleTypeMarker, asCapturedType)) {
                    case CHECK_ONLY_LOWER:
                        return Boolean.valueOf(isSubtypeOf(abstractTypeCheckerContext, kotlinTypeMarker, lowerType));
                    case CHECK_SUBTYPE_AND_LOWER:
                        if (isSubtypeOf(abstractTypeCheckerContext, kotlinTypeMarker, lowerType)) {
                            return true;
                        }
                        break;
                }
            }
            TypeConstructorMarker typeConstructor = abstractTypeCheckerContext.typeConstructor(simpleTypeMarker2);
            if (!abstractTypeCheckerContext.isIntersection(typeConstructor)) {
                return null;
            }
            boolean z2 = !abstractTypeCheckerContext.isMarkedNullable(simpleTypeMarker2);
            if (!_Assertions.ENABLED || z2) {
                Iterable supertypes = abstractTypeCheckerContext.supertypes(typeConstructor);
                if (!(supertypes instanceof Collection) || !((Collection) supertypes).isEmpty()) {
                    Iterator it = supertypes.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!INSTANCE.isSubtypeOf(abstractTypeCheckerContext, kotlinTypeMarker, (KotlinTypeMarker) it.next())) {
                                z = false;
                            }
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
            throw new AssertionError("Intersection type should not be marked nullable!: " + simpleTypeMarker2);
        }
    }

    private final List<SimpleTypeMarker> collectAllSupertypesWithGivenTypeConstructor(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy;
        List<SimpleTypeMarker> fastCorrespondingSupertypes = abstractTypeCheckerContext.fastCorrespondingSupertypes(simpleTypeMarker, typeConstructorMarker);
        if (fastCorrespondingSupertypes != null) {
            return fastCorrespondingSupertypes;
        }
        if (!abstractTypeCheckerContext.isClassTypeConstructor(typeConstructorMarker) && abstractTypeCheckerContext.isClassType(simpleTypeMarker)) {
            return CollectionsKt.emptyList();
        }
        if (!abstractTypeCheckerContext.isCommonFinalClassConstructor(typeConstructorMarker)) {
            List<SimpleTypeMarker> smartList = new SmartList<>();
            abstractTypeCheckerContext.initialize();
            ArrayDeque<SimpleTypeMarker> supertypesDeque = abstractTypeCheckerContext.getSupertypesDeque();
            if (supertypesDeque == null) {
                Intrinsics.throwNpe();
            }
            Set<SimpleTypeMarker> supertypesSet = abstractTypeCheckerContext.getSupertypesSet();
            if (supertypesSet == null) {
                Intrinsics.throwNpe();
            }
            supertypesDeque.push(simpleTypeMarker);
            while (!supertypesDeque.isEmpty()) {
                if (supertypesSet.size() <= 1000) {
                    SimpleTypeMarker pop = supertypesDeque.pop();
                    Intrinsics.checkExpressionValueIsNotNull(pop, "current");
                    if (supertypesSet.add(pop)) {
                        SimpleTypeMarker captureFromArguments = abstractTypeCheckerContext.captureFromArguments(pop, CaptureStatus.FOR_SUBTYPING);
                        if (captureFromArguments == null) {
                            captureFromArguments = pop;
                        }
                        if (abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(captureFromArguments), typeConstructorMarker)) {
                            smartList.add(captureFromArguments);
                            supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
                        } else if (abstractTypeCheckerContext.argumentsCount(captureFromArguments) == 0) {
                            supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                        } else {
                            supertypesPolicy = abstractTypeCheckerContext.substitutionSupertypePolicy(captureFromArguments);
                        }
                        if (!(!Intrinsics.areEqual((Object) supertypesPolicy, (Object) AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                            supertypesPolicy = null;
                        }
                        if (supertypesPolicy != null) {
                            for (KotlinTypeMarker transformType : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(pop))) {
                                supertypesDeque.add(supertypesPolicy.transformType(abstractTypeCheckerContext, transformType));
                            }
                        }
                    }
                } else {
                    throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker + ". Supertypes = " + CollectionsKt.joinToString$default(supertypesSet, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)).toString());
                }
            }
            abstractTypeCheckerContext.clear();
            return smartList;
        } else if (!abstractTypeCheckerContext.areEqualTypeConstructors(abstractTypeCheckerContext.typeConstructor(simpleTypeMarker), typeConstructorMarker)) {
            return CollectionsKt.emptyList();
        } else {
            SimpleTypeMarker captureFromArguments2 = abstractTypeCheckerContext.captureFromArguments(simpleTypeMarker, CaptureStatus.FOR_SUBTYPING);
            if (captureFromArguments2 == null) {
                captureFromArguments2 = simpleTypeMarker;
            }
            return CollectionsKt.listOf(captureFromArguments2);
        }
    }

    private final List<SimpleTypeMarker> collectAndFilter(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        return selectOnlyPureKotlinSupertypes(abstractTypeCheckerContext, collectAllSupertypesWithGivenTypeConstructor(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker));
    }

    private final List<SimpleTypeMarker> selectOnlyPureKotlinSupertypes(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, List<? extends SimpleTypeMarker> list) {
        if (list.size() < 2) {
            return list;
        }
        Collection arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            TypeArgumentListMarker asArgumentList = abstractTypeCheckerContext.asArgumentList((SimpleTypeMarker) next);
            TypeSystemContext typeSystemContext = abstractTypeCheckerContext;
            int size = typeSystemContext.size(asArgumentList);
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (!(abstractTypeCheckerContext.asFlexibleType(abstractTypeCheckerContext.getType(typeSystemContext.get(asArgumentList, i))) == null)) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        List<SimpleTypeMarker> list2 = (List) arrayList;
        return list2.isEmpty() ^ true ? list2 : list;
    }

    @NotNull
    public final List<SimpleTypeMarker> findCorrespondingSupertypes(@NotNull AbstractTypeCheckerContext abstractTypeCheckerContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker) {
        AbstractTypeCheckerContext.SupertypesPolicy supertypesPolicy;
        Intrinsics.checkParameterIsNotNull(abstractTypeCheckerContext, "$this$findCorrespondingSupertypes");
        Intrinsics.checkParameterIsNotNull(simpleTypeMarker, "subType");
        Intrinsics.checkParameterIsNotNull(typeConstructorMarker, "superConstructor");
        if (abstractTypeCheckerContext.isClassType(simpleTypeMarker)) {
            return collectAndFilter(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker);
        }
        if (!abstractTypeCheckerContext.isClassTypeConstructor(typeConstructorMarker) && !abstractTypeCheckerContext.isIntegerLiteralTypeConstructor(typeConstructorMarker)) {
            return collectAllSupertypesWithGivenTypeConstructor(abstractTypeCheckerContext, simpleTypeMarker, typeConstructorMarker);
        }
        SmartList<SimpleTypeMarker> smartList = new SmartList<>();
        abstractTypeCheckerContext.initialize();
        ArrayDeque<SimpleTypeMarker> supertypesDeque = abstractTypeCheckerContext.getSupertypesDeque();
        if (supertypesDeque == null) {
            Intrinsics.throwNpe();
        }
        Set<SimpleTypeMarker> supertypesSet = abstractTypeCheckerContext.getSupertypesSet();
        if (supertypesSet == null) {
            Intrinsics.throwNpe();
        }
        supertypesDeque.push(simpleTypeMarker);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() <= 1000) {
                SimpleTypeMarker pop = supertypesDeque.pop();
                Intrinsics.checkExpressionValueIsNotNull(pop, "current");
                if (supertypesSet.add(pop)) {
                    if (abstractTypeCheckerContext.isClassType(pop)) {
                        smartList.add(pop);
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE;
                    } else {
                        supertypesPolicy = AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    }
                    if (!(!Intrinsics.areEqual((Object) supertypesPolicy, (Object) AbstractTypeCheckerContext.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy != null) {
                        for (KotlinTypeMarker transformType : abstractTypeCheckerContext.supertypes(abstractTypeCheckerContext.typeConstructor(pop))) {
                            supertypesDeque.add(supertypesPolicy.transformType(abstractTypeCheckerContext, transformType));
                        }
                    }
                }
            } else {
                throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker + ". Supertypes = " + CollectionsKt.joinToString$default(supertypesSet, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)).toString());
            }
        }
        abstractTypeCheckerContext.clear();
        Collection arrayList = new ArrayList();
        for (SimpleTypeMarker simpleTypeMarker2 : smartList) {
            AbstractTypeChecker abstractTypeChecker = INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(simpleTypeMarker2, "it");
            CollectionsKt.addAll(arrayList, abstractTypeChecker.collectAndFilter(abstractTypeCheckerContext, simpleTypeMarker2, typeConstructorMarker));
        }
        return (List) arrayList;
    }
}
