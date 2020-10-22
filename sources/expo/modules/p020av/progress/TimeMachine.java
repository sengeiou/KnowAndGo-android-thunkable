package expo.modules.p020av.progress;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00070\nj\u0002`\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, mo39786d2 = {"Lexpo/modules/av/progress/TimeMachine;", "", "time", "", "getTime", "()J", "scheduleAt", "", "intervalMillis", "callback", "Lkotlin/Function0;", "Lexpo/modules/av/progress/TimeMachineTick;", "expo-av_release"}, mo39787k = 1, mo39788mv = {1, 1, 15})
/* renamed from: expo.modules.av.progress.TimeMachine */
/* compiled from: ProgressLooper.kt */
public interface TimeMachine {
    long getTime();

    void scheduleAt(long j, @NotNull Function0<Unit> function0);
}
