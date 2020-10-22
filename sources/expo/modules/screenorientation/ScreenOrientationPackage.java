package expo.modules.screenorientation;

import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.unimodules.core.BasePackage;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo39786d2 = {"Lexpo/modules/screenorientation/ScreenOrientationPackage;", "Lorg/unimodules/core/BasePackage;", "()V", "createExportedModules", "", "Lexpo/modules/screenorientation/ScreenOrientationModule;", "context", "Landroid/content/Context;", "expo-screen-orientation_release"}, mo39787k = 1, mo39788mv = {1, 1, 15})
/* compiled from: ScreenOrientationPackage.kt */
public final class ScreenOrientationPackage extends BasePackage {
    @NotNull
    public List<ScreenOrientationModule> createExportedModules(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return CollectionsKt.listOf(new ScreenOrientationModule(context));
    }
}
