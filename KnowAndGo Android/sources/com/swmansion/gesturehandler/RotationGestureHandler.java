package com.swmansion.gesturehandler;

import android.view.MotionEvent;
import com.swmansion.gesturehandler.RotationGestureDetector;

public class RotationGestureHandler extends GestureHandler<RotationGestureHandler> {
    private static final double ROTATION_RECOGNITION_THRESHOLD = 0.08726646259971647d;
    private RotationGestureDetector.OnRotationGestureListener mGestureListener = new RotationGestureDetector.OnRotationGestureListener() {
        public boolean onRotationBegin(RotationGestureDetector rotationGestureDetector) {
            return true;
        }

        public boolean onRotation(RotationGestureDetector rotationGestureDetector) {
            double access$000 = RotationGestureHandler.this.mLastRotation;
            double unused = RotationGestureHandler.this.mLastRotation = RotationGestureHandler.this.mLastRotation + rotationGestureDetector.getRotation();
            long timeDelta = rotationGestureDetector.getTimeDelta();
            if (timeDelta > 0) {
                double unused2 = RotationGestureHandler.this.mLastVelocity = (RotationGestureHandler.this.mLastRotation - access$000) / ((double) timeDelta);
            }
            if (Math.abs(RotationGestureHandler.this.mLastRotation) < RotationGestureHandler.ROTATION_RECOGNITION_THRESHOLD || RotationGestureHandler.this.getState() != 2) {
                return true;
            }
            RotationGestureHandler.this.activate();
            return true;
        }

        public void onRotationEnd(RotationGestureDetector rotationGestureDetector) {
            RotationGestureHandler.this.end();
        }
    };
    /* access modifiers changed from: private */
    public double mLastRotation;
    /* access modifiers changed from: private */
    public double mLastVelocity;
    private RotationGestureDetector mRotationGestureDetector;

    public RotationGestureHandler() {
        setShouldCancelWhenOutside(false);
    }

    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent) {
        int state = getState();
        if (state == 0) {
            this.mLastVelocity = 0.0d;
            this.mLastRotation = 0.0d;
            this.mRotationGestureDetector = new RotationGestureDetector(this.mGestureListener);
            begin();
        }
        if (this.mRotationGestureDetector != null) {
            this.mRotationGestureDetector.onTouchEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() != 1) {
            return;
        }
        if (state == 4) {
            end();
        } else {
            fail();
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        this.mRotationGestureDetector = null;
        this.mLastVelocity = 0.0d;
        this.mLastRotation = 0.0d;
    }

    public double getRotation() {
        return this.mLastRotation;
    }

    public double getVelocity() {
        return this.mLastVelocity;
    }

    public float getAnchorX() {
        if (this.mRotationGestureDetector == null) {
            return Float.NaN;
        }
        return this.mRotationGestureDetector.getAnchorX();
    }

    public float getAnchorY() {
        if (this.mRotationGestureDetector == null) {
            return Float.NaN;
        }
        return this.mRotationGestureDetector.getAnchorY();
    }
}
