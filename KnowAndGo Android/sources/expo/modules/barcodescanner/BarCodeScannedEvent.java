package expo.modules.barcodescanner;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Pair;
import androidx.core.util.Pools;
import com.facebook.react.uimanager.events.TouchesHelper;
import expo.modules.barcodescanner.BarCodeScannerViewManager;
import expo.modules.barcodescanner.utils.BarCodeScannerEventHelper;
import java.util.List;
import org.unimodules.core.interfaces.services.EventEmitter;
import org.unimodules.interfaces.barcodescanner.BarCodeScannerResult;

public class BarCodeScannedEvent extends EventEmitter.BaseEvent {
    private static final Pools.SynchronizedPool<BarCodeScannedEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(3);
    private BarCodeScannerResult mBarCode;
    private Bundle mBoundingBox;
    private List<Bundle> mCornerPoints;
    private int mViewTag;

    private BarCodeScannedEvent() {
    }

    public static BarCodeScannedEvent obtain(int i, BarCodeScannerResult barCodeScannerResult, float f) {
        BarCodeScannedEvent acquire = EVENTS_POOL.acquire();
        if (acquire == null) {
            acquire = new BarCodeScannedEvent();
        }
        acquire.init(i, barCodeScannerResult, f);
        return acquire;
    }

    private void init(int i, BarCodeScannerResult barCodeScannerResult, float f) {
        this.mViewTag = i;
        this.mBarCode = barCodeScannerResult;
        Pair<List<Bundle>, Bundle> cornerPointsAndBoundingBox = BarCodeScannerEventHelper.getCornerPointsAndBoundingBox(barCodeScannerResult.getCornerPoints(), f);
        this.mCornerPoints = (List) cornerPointsAndBoundingBox.first;
        this.mBoundingBox = (Bundle) cornerPointsAndBoundingBox.second;
    }

    public short getCoalescingKey() {
        return (short) (this.mBarCode.getValue().hashCode() % 32767);
    }

    public String getEventName() {
        return BarCodeScannerViewManager.Events.EVENT_ON_BAR_CODE_SCANNED.toString();
    }

    public Bundle getEventBody() {
        Bundle bundle = new Bundle();
        bundle.putInt(TouchesHelper.TARGET_KEY, this.mViewTag);
        bundle.putString("data", this.mBarCode.getValue());
        bundle.putInt("type", this.mBarCode.getType());
        if (!this.mCornerPoints.isEmpty()) {
            bundle.putParcelableArray("cornerPoints", (Parcelable[]) this.mCornerPoints.toArray(new Bundle[this.mCornerPoints.size()]));
            bundle.putBundle("bounds", this.mBoundingBox);
        }
        return bundle;
    }
}
