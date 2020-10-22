package expo.modules.barcodescanner;

import android.hardware.Camera;
import android.util.Log;
import com.facebook.imagepipeline.common.RotationOptions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpoBarCodeScanner {
    static final int CAMERA_TYPE_BACK = 2;
    static final int CAMERA_TYPE_FRONT = 1;
    private static ExpoBarCodeScanner ourInstance;
    private int mActualDeviceOrientation;
    private Camera mCamera = null;
    private final HashMap<Integer, CameraInfoWrapper> mCameraInfos;
    private int mCameraType;
    private final HashMap<Integer, Integer> mCameraTypeToIndex;
    private final Set<Number> mCameras;
    private int mRotation;

    public static ExpoBarCodeScanner getInstance() {
        return ourInstance;
    }

    public static void createInstance(int i) {
        ourInstance = new ExpoBarCodeScanner(i);
    }

    public Camera acquireCameraInstance(int i) {
        if (this.mCamera == null && this.mCameras.contains(Integer.valueOf(i)) && this.mCameraTypeToIndex.get(Integer.valueOf(i)) != null) {
            try {
                this.mCamera = Camera.open(this.mCameraTypeToIndex.get(Integer.valueOf(i)).intValue());
                this.mCameraType = i;
                adjustPreviewLayout(i);
            } catch (Exception e) {
                Log.e("ExpoBarCodeScanner", "acquireCameraInstance failed", e);
            }
        }
        return this.mCamera;
    }

    public void releaseCameraInstance() {
        if (this.mCamera != null) {
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public int getPreviewWidth(int i) {
        CameraInfoWrapper cameraInfoWrapper = this.mCameraInfos.get(Integer.valueOf(i));
        if (cameraInfoWrapper == null) {
            return 0;
        }
        return cameraInfoWrapper.previewWidth;
    }

    public int getPreviewHeight(int i) {
        CameraInfoWrapper cameraInfoWrapper = this.mCameraInfos.get(Integer.valueOf(i));
        if (cameraInfoWrapper == null) {
            return 0;
        }
        return cameraInfoWrapper.previewHeight;
    }

    public Camera.Size getBestSize(List<Camera.Size> list, int i, int i2) {
        Camera.Size size = null;
        for (Camera.Size next : list) {
            if (next.width <= i && next.height <= i2) {
                if (size == null || next.width * next.height > size.width * size.height) {
                    size = next;
                }
            }
        }
        return size;
    }

    public int getActualDeviceOrientation() {
        return this.mActualDeviceOrientation;
    }

    public void setActualDeviceOrientation(int i) {
        this.mActualDeviceOrientation = i;
        adjustPreviewLayout(this.mCameraType);
    }

    public void adjustPreviewLayout(int i) {
        CameraInfoWrapper cameraInfoWrapper;
        if (this.mCamera != null && (cameraInfoWrapper = this.mCameraInfos.get(Integer.valueOf(i))) != null) {
            int i2 = 0;
            switch (this.mActualDeviceOrientation) {
                case 1:
                    i2 = 90;
                    break;
                case 2:
                    i2 = RotationOptions.ROTATE_180;
                    break;
                case 3:
                    i2 = 270;
                    break;
            }
            if (cameraInfoWrapper.info.facing == 1) {
                this.mRotation = (cameraInfoWrapper.info.orientation + i2) % 360;
                this.mRotation = (360 - this.mRotation) % 360;
            } else {
                this.mRotation = ((cameraInfoWrapper.info.orientation - i2) + 360) % 360;
            }
            this.mCamera.setDisplayOrientation(this.mRotation);
            Camera.Parameters parameters = this.mCamera.getParameters();
            parameters.setRotation(this.mRotation);
            Camera.Size bestSize = getBestSize(parameters.getSupportedPreviewSizes(), 1920, 1920);
            int i3 = bestSize.width;
            int i4 = bestSize.height;
            parameters.setPreviewSize(i3, i4);
            try {
                this.mCamera.setParameters(parameters);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cameraInfoWrapper.previewHeight = i4;
            cameraInfoWrapper.previewWidth = i3;
            if (this.mRotation == 90 || this.mRotation == 270) {
                cameraInfoWrapper.previewHeight = i3;
                cameraInfoWrapper.previewWidth = i4;
            }
        }
    }

    private ExpoBarCodeScanner(int i) {
        this.mCameraType = 0;
        this.mActualDeviceOrientation = 0;
        this.mRotation = 0;
        this.mCameras = new HashSet();
        this.mCameraInfos = new HashMap<>();
        this.mCameraTypeToIndex = new HashMap<>();
        this.mActualDeviceOrientation = i;
        for (int i2 = 0; i2 < Camera.getNumberOfCameras(); i2++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == 1 && this.mCameraInfos.get(1) == null) {
                this.mCameraInfos.put(1, new CameraInfoWrapper(cameraInfo));
                this.mCameraTypeToIndex.put(1, Integer.valueOf(i2));
                this.mCameras.add(1);
            } else if (cameraInfo.facing == 0 && this.mCameraInfos.get(2) == null) {
                this.mCameraInfos.put(2, new CameraInfoWrapper(cameraInfo));
                this.mCameraTypeToIndex.put(2, Integer.valueOf(i2));
                this.mCameras.add(2);
            }
        }
    }

    public int getRotation() {
        return this.mRotation;
    }

    private class CameraInfoWrapper {
        public final Camera.CameraInfo info;
        public int previewHeight = -1;
        public int previewWidth = -1;
        public int rotation = 0;

        public CameraInfoWrapper(Camera.CameraInfo cameraInfo) {
            this.info = cameraInfo;
        }
    }
}
