package kotlin.reflect.jvm.internal.structure;

import java.lang.reflect.Member;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, mo39786d2 = {"<anonymous>", "", "p1", "Ljava/lang/reflect/Member;", "invoke"}, mo39787k = 3, mo39788mv = {1, 1, 15})
/* compiled from: ReflectJavaClass.kt */
final /* synthetic */ class ReflectJavaClass$fields$1 extends FunctionReference implements Function1<Member, Boolean> {
    public static final ReflectJavaClass$fields$1 INSTANCE = new ReflectJavaClass$fields$1();

    ReflectJavaClass$fields$1() {
        super(1);
    }

    public final String getName() {
        return "isSynthetic";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(Member.class);
    }

    public final String getSignature() {
        return "isSynthetic()Z";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((Member) obj));
    }

    public final boolean invoke(@NotNull Member member) {
        Intrinsics.checkParameterIsNotNull(member, "p1");
        return member.isSynthetic();
    }
}
