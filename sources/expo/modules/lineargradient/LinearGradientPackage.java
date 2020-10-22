package expo.modules.lineargradient;

import android.content.Context;
import java.util.Collections;
import java.util.List;
import org.unimodules.core.BasePackage;
import org.unimodules.core.ViewManager;

public class LinearGradientPackage extends BasePackage {
    public List<ViewManager> createViewManagers(Context context) {
        return Collections.singletonList(new LinearGradientManager());
    }
}
