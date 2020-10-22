package expo.modules.lineargradient;

import android.content.Context;
import java.util.ArrayList;
import org.unimodules.core.ViewManager;
import org.unimodules.core.interfaces.ExpoProp;

public class LinearGradientManager extends ViewManager<LinearGradientView> {
    public static final String PROP_BORDER_RADII = "borderRadii";
    public static final String PROP_COLORS = "colors";
    public static final String PROP_END_POS = "endPoint";
    public static final String PROP_LOCATIONS = "locations";
    public static final String PROP_START_POS = "startPoint";
    public static final String VIEW_CLASS_NAME = "ExpoLinearGradient";

    public String getName() {
        return VIEW_CLASS_NAME;
    }

    public LinearGradientView createViewInstance(Context context) {
        return new LinearGradientView(context);
    }

    public ViewManager.ViewManagerType getViewManagerType() {
        return ViewManager.ViewManagerType.SIMPLE;
    }

    @ExpoProp(name = "colors")
    public void setColors(LinearGradientView linearGradientView, ArrayList<Double> arrayList) {
        linearGradientView.setColors(arrayList);
    }

    @ExpoProp(name = "locations")
    public void setLocations(LinearGradientView linearGradientView, ArrayList<Double> arrayList) {
        if (arrayList != null) {
            linearGradientView.setLocations(arrayList);
        }
    }

    @ExpoProp(name = "startPoint")
    public void setStartPosition(LinearGradientView linearGradientView, ArrayList<Double> arrayList) {
        linearGradientView.setStartPosition(arrayList);
    }

    @ExpoProp(name = "endPoint")
    public void setEndPosition(LinearGradientView linearGradientView, ArrayList<Double> arrayList) {
        linearGradientView.setEndPosition(arrayList);
    }

    @ExpoProp(name = "borderRadii")
    public void setBorderRadii(LinearGradientView linearGradientView, ArrayList<Double> arrayList) {
        linearGradientView.setBorderRadii(arrayList);
    }
}
