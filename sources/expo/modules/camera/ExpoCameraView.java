package expo.modules.camera;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.google.android.cameraview.CameraView;
import com.google.android.cameraview.Size;
import expo.modules.camera.tasks.BarCodeScannerAsyncTask;
import expo.modules.camera.tasks.BarCodeScannerAsyncTaskDelegate;
import expo.modules.camera.tasks.FaceDetectorAsyncTaskDelegate;
import expo.modules.camera.tasks.FaceDetectorTask;
import expo.modules.camera.tasks.PictureSavedDelegate;
import expo.modules.camera.tasks.ResolveTakenPictureAsyncTask;
import expo.modules.camera.utils.ImageDimensions;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.unimodules.core.ModuleRegistry;
import org.unimodules.core.Promise;
import org.unimodules.core.interfaces.LifecycleEventListener;
import org.unimodules.core.interfaces.services.EventEmitter;
import org.unimodules.core.interfaces.services.UIManager;
import org.unimodules.interfaces.barcodescanner.BarCodeScanner;
import org.unimodules.interfaces.barcodescanner.BarCodeScannerProvider;
import org.unimodules.interfaces.barcodescanner.BarCodeScannerResult;
import org.unimodules.interfaces.barcodescanner.BarCodeScannerSettings;
import org.unimodules.interfaces.camera.CameraViewInterface;
import org.unimodules.interfaces.facedetector.FaceDetector;
import org.unimodules.interfaces.facedetector.FaceDetectorProvider;
import org.unimodules.interfaces.permissions.Permissions;

public class ExpoCameraView extends CameraView implements LifecycleEventListener, BarCodeScannerAsyncTaskDelegate, FaceDetectorAsyncTaskDelegate, PictureSavedDelegate, CameraViewInterface {
    private static final String FAST_MODE_KEY = "fastMode";
    private static final String MAX_DURATION_KEY = "maxDuration";
    private static final String MAX_FILE_SIZE_KEY = "maxFileSize";
    private static final String MUTE_KEY = "mute";
    private static final String QUALITY_KEY = "quality";
    public volatile boolean barCodeScannerTaskLock = false;
    public volatile boolean faceDetectorTaskLock = false;
    /* access modifiers changed from: private */
    public BarCodeScanner mBarCodeScanner;
    /* access modifiers changed from: private */
    public FaceDetector mFaceDetector;
    private boolean mIsNew = true;
    private boolean mIsPaused = false;
    /* access modifiers changed from: private */
    public ModuleRegistry mModuleRegistry;
    private Map<String, Object> mPendingFaceDetectorSettings;
    /* access modifiers changed from: private */
    public Map<Promise, File> mPictureTakenDirectories = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public Map<Promise, Map<String, Object>> mPictureTakenOptions = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public Queue<Promise> mPictureTakenPromises = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */
    public boolean mShouldDetectFaces = false;
    /* access modifiers changed from: private */
    public boolean mShouldScanBarCodes = false;
    /* access modifiers changed from: private */
    public Promise mVideoRecordedPromise;

    public void requestLayout() {
    }

    public ExpoCameraView(Context context, ModuleRegistry moduleRegistry) {
        super(context, true);
        this.mModuleRegistry = moduleRegistry;
        initBarCodeScanner();
        setChildrenDrawingOrderEnabled(true);
        ((UIManager) this.mModuleRegistry.getModule(UIManager.class)).registerLifecycleEventListener(this);
        addCallback(new CameraView.Callback() {
            public void onCameraOpened(CameraView cameraView) {
                CameraViewHelper.emitCameraReadyEvent((EventEmitter) ExpoCameraView.this.mModuleRegistry.getModule(EventEmitter.class), cameraView);
            }

            public void onMountError(CameraView cameraView) {
                CameraViewHelper.emitMountErrorEvent((EventEmitter) ExpoCameraView.this.mModuleRegistry.getModule(EventEmitter.class), cameraView, "Camera component could not be rendered - is there any other instance running?");
            }

            public void onPictureTaken(CameraView cameraView, byte[] bArr) {
                Promise promise = (Promise) ExpoCameraView.this.mPictureTakenPromises.poll();
                File file = (File) ExpoCameraView.this.mPictureTakenDirectories.remove(promise);
                Map map = (Map) ExpoCameraView.this.mPictureTakenOptions.remove(promise);
                if (map.containsKey(ExpoCameraView.FAST_MODE_KEY) && ((Boolean) map.get(ExpoCameraView.FAST_MODE_KEY)).booleanValue()) {
                    promise.resolve((Object) null);
                }
                new ResolveTakenPictureAsyncTask(bArr, promise, (Map<String, Object>) map, file, (PictureSavedDelegate) ExpoCameraView.this).execute(new Void[0]);
            }

            public void onVideoRecorded(CameraView cameraView, String str) {
                if (ExpoCameraView.this.mVideoRecordedPromise != null) {
                    if (str != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("uri", Uri.fromFile(new File(str)).toString());
                        ExpoCameraView.this.mVideoRecordedPromise.resolve(bundle);
                    } else {
                        ExpoCameraView.this.mVideoRecordedPromise.reject("E_RECORDING", "Couldn't stop recording - there is none in progress");
                    }
                    Promise unused = ExpoCameraView.this.mVideoRecordedPromise = null;
                }
            }

            public void onFramePreview(CameraView cameraView, byte[] bArr, int i, int i2, int i3) {
                CameraView cameraView2 = cameraView;
                int correctCameraRotation = CameraViewHelper.getCorrectCameraRotation(i3, ExpoCameraView.this.getFacing());
                boolean z = false;
                if (ExpoCameraView.this.mShouldScanBarCodes && !ExpoCameraView.this.barCodeScannerTaskLock && (cameraView2 instanceof BarCodeScannerAsyncTaskDelegate)) {
                    ExpoCameraView.this.barCodeScannerTaskLock = true;
                    new BarCodeScannerAsyncTask((BarCodeScannerAsyncTaskDelegate) cameraView2, ExpoCameraView.this.mBarCodeScanner, bArr, i, i2, i3).execute(new Void[0]);
                }
                if (ExpoCameraView.this.mShouldDetectFaces && !ExpoCameraView.this.faceDetectorTaskLock && (cameraView2 instanceof FaceDetectorAsyncTaskDelegate)) {
                    ExpoCameraView.this.faceDetectorTaskLock = true;
                    float f = cameraView.getResources().getDisplayMetrics().density;
                    ImageDimensions imageDimensions = new ImageDimensions(i, i2, correctCameraRotation, ExpoCameraView.this.getFacing());
                    double width = ((double) cameraView.getWidth()) / ((double) (((float) imageDimensions.getWidth()) * f));
                    double height = ((double) cameraView.getHeight()) / ((double) (((float) imageDimensions.getHeight()) * f));
                    FaceDetectorAsyncTaskDelegate faceDetectorAsyncTaskDelegate = (FaceDetectorAsyncTaskDelegate) cameraView2;
                    FaceDetector access$800 = ExpoCameraView.this.mFaceDetector;
                    if (ExpoCameraView.this.getFacing() == 1) {
                        z = true;
                    }
                    new FaceDetectorTask(faceDetectorAsyncTaskDelegate, access$800, bArr, i, i2, correctCameraRotation, z, width, height).execute();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view = getView();
        if (view != null) {
            setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            view.layout(0, 0, i3 - i, i4 - i2);
        }
    }

    public void onViewAdded(View view) {
        if (getView() != view && getView() != null) {
            ArrayList<View> arrayList = new ArrayList<>();
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (i != 0 || childAt != getView()) {
                    if (childAt != getView()) {
                        arrayList.add(childAt);
                    }
                    i++;
                } else {
                    return;
                }
            }
            for (View bringChildToFront : arrayList) {
                bringChildToFront(bringChildToFront);
            }
            requestLayout();
            invalidate();
        }
    }

    public void takePicture(Map<String, Object> map, Promise promise, File file) {
        this.mPictureTakenPromises.add(promise);
        this.mPictureTakenOptions.put(promise, map);
        this.mPictureTakenDirectories.put(promise, file);
        try {
            super.takePicture();
        } catch (Exception e) {
            this.mPictureTakenPromises.remove(promise);
            this.mPictureTakenOptions.remove(promise);
            this.mPictureTakenDirectories.remove(promise);
            throw e;
        }
    }

    public void onPictureSaved(Bundle bundle) {
        CameraViewHelper.emitPictureSavedEvent((EventEmitter) this.mModuleRegistry.getModule(EventEmitter.class), this, bundle);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x007a A[Catch:{ IOException -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007d A[Catch:{ IOException -> 0x0085 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void record(java.util.Map<java.lang.String, java.lang.Object> r9, org.unimodules.core.Promise r10, java.io.File r11) {
        /*
            r8 = this;
            java.lang.String r0 = "Camera"
            java.lang.String r1 = ".mp4"
            java.lang.String r3 = expo.modules.camera.utils.FileSystemUtils.generateOutputPath(r11, r0, r1)     // Catch:{ IOException -> 0x0085 }
            java.lang.String r11 = "maxDuration"
            java.lang.Object r11 = r9.get(r11)     // Catch:{ IOException -> 0x0085 }
            r0 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            if (r11 == 0) goto L_0x001f
            java.lang.String r11 = "maxDuration"
            java.lang.Object r11 = r9.get(r11)     // Catch:{ IOException -> 0x0085 }
            java.lang.Double r11 = (java.lang.Double) r11     // Catch:{ IOException -> 0x0085 }
            double r4 = r11.doubleValue()     // Catch:{ IOException -> 0x0085 }
            goto L_0x0020
        L_0x001f:
            r4 = r0
        L_0x0020:
            java.lang.String r11 = "maxFileSize"
            java.lang.Object r11 = r9.get(r11)     // Catch:{ IOException -> 0x0085 }
            if (r11 == 0) goto L_0x0034
            java.lang.String r11 = "maxFileSize"
            java.lang.Object r11 = r9.get(r11)     // Catch:{ IOException -> 0x0085 }
            java.lang.Double r11 = (java.lang.Double) r11     // Catch:{ IOException -> 0x0085 }
            double r0 = r11.doubleValue()     // Catch:{ IOException -> 0x0085 }
        L_0x0034:
            int r11 = r8.getCameraId()     // Catch:{ IOException -> 0x0085 }
            r2 = 1
            android.media.CamcorderProfile r11 = android.media.CamcorderProfile.get(r11, r2)     // Catch:{ IOException -> 0x0085 }
            java.lang.String r6 = "quality"
            java.lang.Object r6 = r9.get(r6)     // Catch:{ IOException -> 0x0085 }
            if (r6 == 0) goto L_0x0059
            int r11 = r8.getCameraId()     // Catch:{ IOException -> 0x0085 }
            java.lang.String r6 = "quality"
            java.lang.Object r6 = r9.get(r6)     // Catch:{ IOException -> 0x0085 }
            java.lang.Double r6 = (java.lang.Double) r6     // Catch:{ IOException -> 0x0085 }
            int r6 = r6.intValue()     // Catch:{ IOException -> 0x0085 }
            android.media.CamcorderProfile r11 = expo.modules.camera.CameraViewHelper.getCamcorderProfile(r11, r6)     // Catch:{ IOException -> 0x0085 }
        L_0x0059:
            r7 = r11
            java.lang.String r11 = "mute"
            java.lang.Object r9 = r9.get(r11)     // Catch:{ IOException -> 0x0085 }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ IOException -> 0x0085 }
            if (r9 == 0) goto L_0x006e
            boolean r9 = r9.booleanValue()     // Catch:{ IOException -> 0x0085 }
            if (r9 != 0) goto L_0x006b
            goto L_0x006e
        L_0x006b:
            r9 = 0
            r6 = 0
            goto L_0x006f
        L_0x006e:
            r6 = 1
        L_0x006f:
            int r9 = (int) r4     // Catch:{ IOException -> 0x0085 }
            int r4 = r9 * 1000
            int r5 = (int) r0     // Catch:{ IOException -> 0x0085 }
            r2 = r8
            boolean r9 = super.record(r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x0085 }
            if (r9 == 0) goto L_0x007d
            r8.mVideoRecordedPromise = r10     // Catch:{ IOException -> 0x0085 }
            goto L_0x008c
        L_0x007d:
            java.lang.String r9 = "E_RECORDING_FAILED"
            java.lang.String r11 = "Starting video recording failed. Another recording might be in progress."
            r10.reject((java.lang.String) r9, (java.lang.String) r11)     // Catch:{ IOException -> 0x0085 }
            goto L_0x008c
        L_0x0085:
            java.lang.String r9 = "E_RECORDING_FAILED"
            java.lang.String r11 = "Starting video recording failed - could not create video file."
            r10.reject((java.lang.String) r9, (java.lang.String) r11)
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.camera.ExpoCameraView.record(java.util.Map, org.unimodules.core.Promise, java.io.File):void");
    }

    private void initBarCodeScanner() {
        BarCodeScannerProvider barCodeScannerProvider = (BarCodeScannerProvider) this.mModuleRegistry.getModule(BarCodeScannerProvider.class);
        if (barCodeScannerProvider != null) {
            this.mBarCodeScanner = barCodeScannerProvider.createBarCodeDetectorWithContext(getContext());
        }
    }

    public void setShouldScanBarCodes(boolean z) {
        this.mShouldScanBarCodes = z;
        setScanning(this.mShouldScanBarCodes || this.mShouldDetectFaces);
    }

    public void setBarCodeScannerSettings(BarCodeScannerSettings barCodeScannerSettings) {
        if (this.mBarCodeScanner != null) {
            this.mBarCodeScanner.setSettings(barCodeScannerSettings);
        }
    }

    public void onBarCodeScanned(BarCodeScannerResult barCodeScannerResult) {
        if (this.mShouldScanBarCodes) {
            CameraViewHelper.emitBarCodeReadEvent((EventEmitter) this.mModuleRegistry.getModule(EventEmitter.class), this, barCodeScannerResult);
        }
    }

    public void onBarCodeScanningTaskCompleted() {
        this.barCodeScannerTaskLock = false;
    }

    public int[] getPreviewSizeAsArray() {
        Size previewSize = getPreviewSize();
        return new int[]{previewSize.getWidth(), previewSize.getHeight()};
    }

    public void onHostResume() {
        if (!hasCameraPermissions()) {
            CameraViewHelper.emitMountErrorEvent((EventEmitter) this.mModuleRegistry.getModule(EventEmitter.class), this, "Camera permissions not granted - component could not be rendered.");
        } else if ((this.mIsPaused && !isCameraOpened()) || this.mIsNew) {
            this.mIsPaused = false;
            this.mIsNew = false;
            if (!Build.FINGERPRINT.contains("generic")) {
                start();
                FaceDetectorProvider faceDetectorProvider = (FaceDetectorProvider) this.mModuleRegistry.getModule(FaceDetectorProvider.class);
                if (faceDetectorProvider != null) {
                    this.mFaceDetector = faceDetectorProvider.createFaceDetectorWithContext(getContext());
                    if (this.mPendingFaceDetectorSettings != null) {
                        this.mFaceDetector.setSettings(this.mPendingFaceDetectorSettings);
                        this.mPendingFaceDetectorSettings = null;
                    }
                }
            }
        }
    }

    public void onHostPause() {
        if (!this.mIsPaused && isCameraOpened()) {
            if (this.mFaceDetector != null) {
                this.mFaceDetector.release();
            }
            this.mIsPaused = true;
            stop();
        }
    }

    public void onHostDestroy() {
        if (this.mFaceDetector != null) {
            this.mFaceDetector.release();
        }
        stop();
    }

    private boolean hasCameraPermissions() {
        return ((Permissions) this.mModuleRegistry.getModule(Permissions.class)).hasGrantedPermissions("android.permission.CAMERA");
    }

    public void setShouldDetectFaces(boolean z) {
        this.mShouldDetectFaces = z;
        setScanning(this.mShouldScanBarCodes || this.mShouldDetectFaces);
    }

    public void setFaceDetectorSettings(Map<String, Object> map) {
        if (this.mFaceDetector == null) {
            this.mPendingFaceDetectorSettings = map;
        } else {
            this.mFaceDetector.setSettings(map);
        }
    }

    public void onFacesDetected(List<Bundle> list) {
        if (this.mShouldDetectFaces) {
            if (list == null) {
                list = new ArrayList<>();
            }
            CameraViewHelper.emitFacesDetectedEvent((EventEmitter) this.mModuleRegistry.getModule(EventEmitter.class), this, list);
        }
    }

    public void onFaceDetectionError(FaceDetector faceDetector) {
        this.faceDetectorTaskLock = false;
        if (this.mShouldDetectFaces) {
            CameraViewHelper.emitFaceDetectionErrorEvent((EventEmitter) this.mModuleRegistry.getModule(EventEmitter.class), this, faceDetector);
        }
    }

    public void onFaceDetectingTaskCompleted() {
        this.faceDetectorTaskLock = false;
    }
}
