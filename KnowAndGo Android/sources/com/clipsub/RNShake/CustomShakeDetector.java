package com.clipsub.RNShake;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.facebook.infer.annotation.Assertions;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class CustomShakeDetector implements SensorEventListener {
    private static final int MAGNITUDE_THRESHOLD = 25;
    private static final int MAX_SAMPLES = 40;
    private static final long MIN_TIME_BETWEEN_SAMPLES_NS = TimeUnit.NANOSECONDS.convert(20, TimeUnit.MILLISECONDS);
    private static final int PERCENT_OVER_THRESHOLD_FOR_SHAKE = 60;
    private static final float SHAKING_WINDOW_NS = ((float) TimeUnit.NANOSECONDS.convert(3, TimeUnit.SECONDS));
    private static final long VISIBLE_TIME_RANGE_NS = TimeUnit.NANOSECONDS.convert(250, TimeUnit.MILLISECONDS);
    private int mCurrentIndex;
    private long mLastShakeTimestamp;
    private long mLastTimestamp;
    @Nullable
    private double[] mMagnitudes;
    private int mMinNumShakes;
    private int mNumShakes;
    @Nullable
    private SensorManager mSensorManager;
    private final ShakeListener mShakeListener;
    @Nullable
    private long[] mTimestamps;

    public interface ShakeListener {
        void onShake();
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public CustomShakeDetector(ShakeListener shakeListener) {
        this(shakeListener, 1);
    }

    public CustomShakeDetector(ShakeListener shakeListener, int i) {
        this.mShakeListener = shakeListener;
        this.mMinNumShakes = i;
    }

    public void start(SensorManager sensorManager) {
        Assertions.assertNotNull(sensorManager);
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        if (defaultSensor != null) {
            this.mSensorManager = sensorManager;
            this.mLastTimestamp = -1;
            this.mCurrentIndex = 0;
            this.mMagnitudes = new double[40];
            this.mTimestamps = new long[40];
            this.mSensorManager.registerListener(this, defaultSensor, 2);
            this.mNumShakes = 0;
            this.mLastShakeTimestamp = 0;
        }
    }

    public void stop() {
        if (this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this);
            this.mSensorManager = null;
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.timestamp - this.mLastTimestamp >= MIN_TIME_BETWEEN_SAMPLES_NS) {
            Assertions.assertNotNull(this.mTimestamps);
            Assertions.assertNotNull(this.mMagnitudes);
            float f = sensorEvent.values[0];
            float f2 = sensorEvent.values[1];
            float f3 = sensorEvent.values[2];
            this.mLastTimestamp = sensorEvent.timestamp;
            this.mTimestamps[this.mCurrentIndex] = sensorEvent.timestamp;
            this.mMagnitudes[this.mCurrentIndex] = Math.sqrt((double) ((f * f) + (f2 * f2) + (f3 * f3)));
            maybeDispatchShake(sensorEvent.timestamp);
            this.mCurrentIndex = (this.mCurrentIndex + 1) % 40;
        }
    }

    private void maybeDispatchShake(long j) {
        Assertions.assertNotNull(this.mTimestamps);
        Assertions.assertNotNull(this.mMagnitudes);
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 40; i3++) {
            int i4 = ((this.mCurrentIndex - i3) + 40) % 40;
            if (j - this.mTimestamps[i4] < VISIBLE_TIME_RANGE_NS) {
                i2++;
                if (this.mMagnitudes[i4] >= 25.0d) {
                    i++;
                }
            }
        }
        if (((double) i) / ((double) i2) > 0.6d) {
            if (j - this.mLastShakeTimestamp >= VISIBLE_TIME_RANGE_NS) {
                this.mNumShakes++;
            }
            this.mLastShakeTimestamp = j;
            if (this.mNumShakes >= this.mMinNumShakes) {
                this.mNumShakes = 0;
                this.mLastShakeTimestamp = 0;
                this.mShakeListener.onShake();
            }
        }
        if (((float) (j - this.mLastShakeTimestamp)) > SHAKING_WINDOW_NS) {
            this.mNumShakes = 0;
            this.mLastShakeTimestamp = 0;
        }
    }
}
