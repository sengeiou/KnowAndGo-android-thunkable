package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.Nullable;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo39786d2 = {"<anonymous>", "", "T", "", "invoke"}, mo39787k = 3, mo39788mv = {1, 1, 15})
/* compiled from: KClassImpl.kt */
final class KClassImpl$Data$simpleName$2 extends Lambda implements Function0<String> {
    final /* synthetic */ KClassImpl.Data this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KClassImpl$Data$simpleName$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Nullable
    public final String invoke() {
        if (KClassImpl.this.getJClass().isAnonymousClass()) {
            return null;
        }
        ClassId access$getClassId$p = KClassImpl.this.getClassId();
        if (access$getClassId$p.isLocal()) {
            return this.this$0.calculateLocalClassName(KClassImpl.this.getJClass());
        }
        String asString = access$getClassId$p.getShortClassName().asString();
        Intrinsics.checkExpressionValueIsNotNull(asString, "classId.shortClassName.asString()");
        return asString;
    }
}
