package expo.modules.p020av.progress;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo39784bv = {1, 0, 3}, mo39787k = 3, mo39788mv = {1, 1, 15})
/* renamed from: expo.modules.av.progress.AndroidLooperTimeMachine$sam$java_lang_Runnable$0 */
/* compiled from: AndroidLooperTimeMachine.kt */
final class AndroidLooperTimeMachine$sam$java_lang_Runnable$0 implements Runnable {
    private final /* synthetic */ Function0 function;

    AndroidLooperTimeMachine$sam$java_lang_Runnable$0(Function0 function0) {
        this.function = function0;
    }

    public final /* synthetic */ void run() {
        Intrinsics.checkExpressionValueIsNotNull(this.function.invoke(), "invoke(...)");
    }
}
