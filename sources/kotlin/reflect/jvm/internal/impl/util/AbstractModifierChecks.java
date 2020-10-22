package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.util.CheckResult;
import org.jetbrains.annotations.NotNull;

/* compiled from: modifierChecks.kt */
public abstract class AbstractModifierChecks {
    @NotNull
    public abstract List<Checks> getChecks$descriptors();

    @NotNull
    public final CheckResult check(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
        for (Checks next : getChecks$descriptors()) {
            if (next.isApplicable(functionDescriptor)) {
                return next.checkAll(functionDescriptor);
            }
        }
        return CheckResult.IllegalFunctionName.INSTANCE;
    }
}
