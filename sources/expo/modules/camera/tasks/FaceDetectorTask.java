package expo.modules.camera.tasks;

import java.util.ArrayList;
import org.unimodules.interfaces.facedetector.FaceDetectionError;
import org.unimodules.interfaces.facedetector.FaceDetectionSkipped;
import org.unimodules.interfaces.facedetector.FaceDetector;
import org.unimodules.interfaces.facedetector.FacesDetectionCompleted;

public class FaceDetectorTask {
    private FaceDetectorAsyncTaskDelegate mDelegate;
    private FaceDetector mFaceDetector;
    private int mHeight;
    private byte[] mImageData;
    private boolean mMirrored;
    private int mRotation;
    private double mScaleX;
    private double mScaleY;
    private int mWidth;

    public FaceDetectorTask(FaceDetectorAsyncTaskDelegate faceDetectorAsyncTaskDelegate, FaceDetector faceDetector, byte[] bArr, int i, int i2, int i3, boolean z, double d, double d2) {
        this.mImageData = bArr;
        this.mWidth = i;
        this.mHeight = i2;
        this.mMirrored = z;
        this.mScaleX = d;
        this.mScaleY = d2;
        this.mRotation = i3;
        this.mDelegate = faceDetectorAsyncTaskDelegate;
        this.mFaceDetector = faceDetector;
    }

    public void execute() {
        this.mFaceDetector.detectFaces(this.mImageData, this.mWidth, this.mHeight, this.mRotation, this.mMirrored, this.mScaleX, this.mScaleY, new FacesDetectionCompleted() {
            public final void detectionCompleted(ArrayList arrayList) {
                FaceDetectorTask.lambda$execute$0(FaceDetectorTask.this, arrayList);
            }
        }, new FaceDetectionError() {
            public final void onError(Throwable th) {
                FaceDetectorTask.lambda$execute$1(FaceDetectorTask.this, th);
            }
        }, new FaceDetectionSkipped() {
            public final void onSkipped(String str) {
                FaceDetectorTask.this.mDelegate.onFaceDetectingTaskCompleted();
            }
        });
    }

    public static /* synthetic */ void lambda$execute$0(FaceDetectorTask faceDetectorTask, ArrayList arrayList) {
        if (arrayList != null) {
            faceDetectorTask.mDelegate.onFacesDetected(arrayList);
        } else {
            faceDetectorTask.mDelegate.onFaceDetectionError(faceDetectorTask.mFaceDetector);
        }
        faceDetectorTask.mDelegate.onFaceDetectingTaskCompleted();
    }

    public static /* synthetic */ void lambda$execute$1(FaceDetectorTask faceDetectorTask, Throwable th) {
        faceDetectorTask.mDelegate.onFaceDetectionError(faceDetectorTask.mFaceDetector);
        faceDetectorTask.mDelegate.onFaceDetectingTaskCompleted();
    }
}
