package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, mo39786d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"}, mo39787k = 1, mo39788mv = {1, 1, 15})
/* compiled from: InlineClassAwareCaller.kt */
public final class InlineClassAwareCaller<M extends Member> implements Caller<M> {
    private final Caller<M> caller;
    private final BoxUnboxData data;
    private final boolean isDefault;

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
        if ((r10.caller instanceof kotlin.reflect.jvm.internal.calls.BoundCaller) != false) goto L_0x007b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InlineClassAwareCaller(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r9, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.calls.Caller<? extends M> r10, boolean r11) {
        /*
            r8 = this;
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            java.lang.String r0 = "caller"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            r8.<init>()
            r8.caller = r10
            r8.isDefault = r11
            r10 = r8
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller r10 = (kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller) r10
            kotlin.reflect.jvm.internal.impl.types.KotlinType r11 = r9.getReturnType()
            if (r11 != 0) goto L_0x001d
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x001d:
            java.lang.String r0 = "descriptor.returnType!!"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r11, r0)
            java.lang.Class r11 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.toInlineClass((kotlin.reflect.jvm.internal.impl.types.KotlinType) r11)
            r0 = 0
            if (r11 == 0) goto L_0x002e
            java.lang.reflect.Method r11 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.getBoxMethod(r11, r9)
            goto L_0x002f
        L_0x002e:
            r11 = r0
        L_0x002f:
            r1 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) r1
            boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(r1)
            r2 = 0
            if (r1 == 0) goto L_0x0048
            kotlin.ranges.IntRange$Companion r9 = kotlin.ranges.IntRange.Companion
            kotlin.ranges.IntRange r9 = r9.getEMPTY()
            java.lang.reflect.Method[] r10 = new java.lang.reflect.Method[r2]
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r0 = new kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData
            r0.<init>(r9, r10, r11)
            goto L_0x0152
        L_0x0048:
            kotlin.reflect.jvm.internal.calls.Caller<M> r1 = r10.caller
            boolean r1 = r1 instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic
            r3 = -1
            if (r1 == 0) goto L_0x0050
            goto L_0x007b
        L_0x0050:
            boolean r1 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
            if (r1 == 0) goto L_0x005d
            kotlin.reflect.jvm.internal.calls.Caller<M> r1 = r10.caller
            boolean r1 = r1 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r1 == 0) goto L_0x005b
            goto L_0x007b
        L_0x005b:
            r3 = 0
            goto L_0x007b
        L_0x005d:
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r1 = r9.getDispatchReceiverParameter()
            if (r1 == 0) goto L_0x005b
            kotlin.reflect.jvm.internal.calls.Caller<M> r1 = r10.caller
            boolean r1 = r1 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r1 != 0) goto L_0x005b
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = r9.getContainingDeclaration()
            java.lang.String r3 = "descriptor.containingDeclaration"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
            boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r1)
            if (r1 == 0) goto L_0x0079
            goto L_0x005b
        L_0x0079:
            r1 = 1
            r3 = 1
        L_0x007b:
            boolean r1 = r10.isDefault
            if (r1 == 0) goto L_0x0081
            r1 = 2
            goto L_0x0082
        L_0x0081:
            r1 = 0
        L_0x0082:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r5 = r9.getExtensionReceiverParameter()
            if (r5 == 0) goto L_0x0092
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = r5.getType()
            goto L_0x0093
        L_0x0092:
            r5 = r0
        L_0x0093:
            if (r5 == 0) goto L_0x0099
            r4.add(r5)
            goto L_0x00e3
        L_0x0099:
            boolean r5 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
            if (r5 == 0) goto L_0x00c7
            r5 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) r5
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r5 = r5.getConstructedClass()
            java.lang.String r6 = "descriptor.constructedClass"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r6)
            boolean r6 = r5.isInner()
            if (r6 == 0) goto L_0x00e3
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r5 = r5.getContainingDeclaration()
            if (r5 == 0) goto L_0x00bf
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r5
            kotlin.reflect.jvm.internal.impl.types.SimpleType r5 = r5.getDefaultType()
            r4.add(r5)
            goto L_0x00e3
        L_0x00bf:
            kotlin.TypeCastException r9 = new kotlin.TypeCastException
            java.lang.String r10 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            r9.<init>(r10)
            throw r9
        L_0x00c7:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r5 = r9.getContainingDeclaration()
            java.lang.String r6 = "descriptor.containingDeclaration"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r6)
            boolean r6 = r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r6 == 0) goto L_0x00e3
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r5
            boolean r6 = r5.isInline()
            if (r6 == 0) goto L_0x00e3
            kotlin.reflect.jvm.internal.impl.types.SimpleType r5 = r5.getDefaultType()
            r4.add(r5)
        L_0x00e3:
            java.util.List r5 = r9.getValueParameters()
            java.lang.String r6 = "descriptor.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r6)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x00f2:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0109
            java.lang.Object r6 = r5.next()
            r7 = r4
            java.util.Collection r7 = (java.util.Collection) r7
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r6
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = r6.getType()
            r7.add(r6)
            goto L_0x00f2
        L_0x0109:
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.List r4 = (java.util.List) r4
            int r5 = r4.size()
            int r5 = r5 + r3
            int r5 = r5 + r1
            r1 = r10
            kotlin.reflect.jvm.internal.calls.Caller r1 = (kotlin.reflect.jvm.internal.calls.Caller) r1
            int r6 = kotlin.reflect.jvm.internal.calls.CallerKt.getArity(r1)
            if (r6 != r5) goto L_0x0155
            int r10 = java.lang.Math.max(r3, r2)
            int r1 = r4.size()
            int r1 = r1 + r3
            kotlin.ranges.IntRange r10 = kotlin.ranges.RangesKt.until((int) r10, (int) r1)
            java.lang.reflect.Method[] r1 = new java.lang.reflect.Method[r5]
        L_0x012c:
            if (r2 >= r5) goto L_0x014d
            boolean r6 = r10.contains((int) r2)
            if (r6 == 0) goto L_0x0147
            int r6 = r2 - r3
            java.lang.Object r6 = r4.get(r6)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r6
            java.lang.Class r6 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.toInlineClass((kotlin.reflect.jvm.internal.impl.types.KotlinType) r6)
            if (r6 == 0) goto L_0x0147
            java.lang.reflect.Method r6 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.getUnboxMethod(r6, r9)
            goto L_0x0148
        L_0x0147:
            r6 = r0
        L_0x0148:
            r1[r2] = r6
            int r2 = r2 + 1
            goto L_0x012c
        L_0x014d:
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r0 = new kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData
            r0.<init>(r10, r1, r11)
        L_0x0152:
            r8.data = r0
            return
        L_0x0155:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r11 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Inconsistent number of parameters in the descriptor and Java reflection object: "
            r0.append(r2)
            int r1 = kotlin.reflect.jvm.internal.calls.CallerKt.getArity(r1)
            r0.append(r1)
            java.lang.String r1 = " != "
            r0.append(r1)
            r0.append(r5)
            r1 = 10
            r0.append(r1)
            java.lang.String r2 = "Calling: "
            r0.append(r2)
            r0.append(r9)
            r0.append(r1)
            java.lang.String r9 = "Parameter types: "
            r0.append(r9)
            java.util.List r9 = r10.getParameterTypes()
            r0.append(r9)
            java.lang.String r9 = ")\n"
            r0.append(r9)
            java.lang.String r9 = "Default: "
            r0.append(r9)
            boolean r9 = r10.isDefault
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r11.<init>(r9)
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller.<init>(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.calls.Caller, boolean):void");
    }

    public M getMember() {
        return this.caller.getMember();
    }

    @NotNull
    public Type getReturnType() {
        return this.caller.getReturnType();
    }

    @NotNull
    public List<Type> getParameterTypes() {
        return this.caller.getParameterTypes();
    }

    @Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003H\u0002J\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, mo39786d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"}, mo39787k = 1, mo39788mv = {1, 1, 15})
    /* compiled from: InlineClassAwareCaller.kt */
    private static final class BoxUnboxData {
        @NotNull
        private final IntRange argumentRange;
        @Nullable
        private final Method box;
        @NotNull
        private final Method[] unbox;

        public BoxUnboxData(@NotNull IntRange intRange, @NotNull Method[] methodArr, @Nullable Method method) {
            Intrinsics.checkParameterIsNotNull(intRange, "argumentRange");
            Intrinsics.checkParameterIsNotNull(methodArr, "unbox");
            this.argumentRange = intRange;
            this.unbox = methodArr;
            this.box = method;
        }

        @NotNull
        public final IntRange component1() {
            return this.argumentRange;
        }

        @NotNull
        public final Method[] component2() {
            return this.unbox;
        }

        @Nullable
        public final Method component3() {
            return this.box;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        r0 = r0.invoke((java.lang.Object) null, new java.lang.Object[]{r10});
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object call(@org.jetbrains.annotations.NotNull java.lang.Object[] r10) {
        /*
            r9 = this;
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r0 = r9.data
            kotlin.ranges.IntRange r1 = r0.component1()
            java.lang.reflect.Method[] r2 = r0.component2()
            java.lang.reflect.Method r0 = r0.component3()
            int r3 = r10.length
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r10, r3)
            java.lang.String r4 = "java.util.Arrays.copyOf(this, size)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            if (r3 == 0) goto L_0x0055
            int r4 = r1.getFirst()
            int r1 = r1.getLast()
            r5 = 0
            if (r4 > r1) goto L_0x003f
        L_0x002a:
            r6 = r2[r4]
            r7 = r10[r4]
            if (r6 == 0) goto L_0x0038
            if (r7 == 0) goto L_0x0038
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.Object r7 = r6.invoke(r7, r8)
        L_0x0038:
            r3[r4] = r7
            if (r4 == r1) goto L_0x003f
            int r4 = r4 + 1
            goto L_0x002a
        L_0x003f:
            kotlin.reflect.jvm.internal.calls.Caller<M> r10 = r9.caller
            java.lang.Object r10 = r10.call(r3)
            if (r0 == 0) goto L_0x0054
            r1 = 0
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r5] = r10
            java.lang.Object r0 = r0.invoke(r1, r2)
            if (r0 == 0) goto L_0x0054
            r10 = r0
        L_0x0054:
            return r10
        L_0x0055:
            kotlin.TypeCastException r10 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller.call(java.lang.Object[]):java.lang.Object");
    }
}
