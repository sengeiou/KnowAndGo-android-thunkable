package expo.modules.barcodescanner.utils;

import android.os.Bundle;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class BarCodeScannerEventHelper {
    public static Pair<List<Bundle>, Bundle> getCornerPointsAndBoundingBox(List<Integer> list, float f) {
        ArrayList arrayList = new ArrayList();
        Bundle bundle = new Bundle();
        float f2 = Float.MAX_VALUE;
        float f3 = Float.MAX_VALUE;
        float f4 = Float.MIN_VALUE;
        float f5 = Float.MIN_VALUE;
        for (int i = 0; i < list.size(); i += 2) {
            float intValue = ((float) list.get(i).intValue()) / f;
            float intValue2 = ((float) list.get(i + 1).intValue()) / f;
            f2 = Math.min(f2, intValue);
            f3 = Math.min(f3, intValue2);
            f4 = Math.max(f4, intValue);
            f5 = Math.max(f5, intValue2);
            arrayList.add(getPoint(intValue, intValue2));
        }
        bundle.putParcelable("origin", getPoint(f2, f3));
        bundle.putParcelable("size", getSize(f4 - f2, f5 - f3));
        return new Pair<>(arrayList, bundle);
    }

    private static Bundle getSize(float f, float f2) {
        Bundle bundle = new Bundle();
        bundle.putFloat("width", f);
        bundle.putFloat("height", f2);
        return bundle;
    }

    private static Bundle getPoint(float f, float f2) {
        Bundle bundle = new Bundle();
        bundle.putFloat("x", f);
        bundle.putFloat("y", f2);
        return bundle;
    }
}
