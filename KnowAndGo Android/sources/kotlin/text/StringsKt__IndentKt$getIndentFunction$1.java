package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo39786d2 = {"<anonymous>", "", "line", "invoke"}, mo39787k = 3, mo39788mv = {1, 1, 15})
/* compiled from: Indent.kt */
final class StringsKt__IndentKt$getIndentFunction$1 extends Lambda implements Function1<String, String> {
    public static final StringsKt__IndentKt$getIndentFunction$1 INSTANCE = new StringsKt__IndentKt$getIndentFunction$1();

    StringsKt__IndentKt$getIndentFunction$1() {
        super(1);
    }

    @NotNull
    public final String invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "line");
        return str;
    }
}
