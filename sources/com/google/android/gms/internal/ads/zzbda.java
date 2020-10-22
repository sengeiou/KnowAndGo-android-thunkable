package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.extractor.p012ts.TsExtractor;
import javax.annotation.concurrent.GuardedBy;

@zzard
final class zzbda implements SensorEventListener {
    private final SensorManager zzecv;
    private final Object zzecw = new Object();
    private final Display zzecx;
    private final float[] zzecy = new float[9];
    private final float[] zzecz = new float[9];
    @GuardedBy("sensorThreadLock")
    private float[] zzeda;
    private Handler zzedb;
    private zzbdc zzedc;

    zzbda(Context context) {
        this.zzecv = (SensorManager) context.getSystemService("sensor");
        this.zzecx = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* access modifiers changed from: package-private */
    public final void start() {
        if (this.zzedb == null) {
            Sensor defaultSensor = this.zzecv.getDefaultSensor(11);
            if (defaultSensor == null) {
                zzawz.zzen("No Sensor of TYPE_ROTATION_VECTOR");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
            handlerThread.start();
            this.zzedb = new zzdbh(handlerThread.getLooper());
            if (!this.zzecv.registerListener(this, defaultSensor, 0, this.zzedb)) {
                zzawz.zzen("SensorManager.registerListener failed.");
                stop();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void stop() {
        if (this.zzedb != null) {
            this.zzecv.unregisterListener(this);
            this.zzedb.post(new zzbdb(this));
            this.zzedb = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbdc zzbdc) {
        this.zzedc = zzbdc;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 0.0f) {
            synchronized (this.zzecw) {
                if (this.zzeda == null) {
                    this.zzeda = new float[9];
                }
            }
            SensorManager.getRotationMatrixFromVector(this.zzecy, fArr);
            switch (this.zzecx.getRotation()) {
                case 1:
                    SensorManager.remapCoordinateSystem(this.zzecy, 2, TsExtractor.TS_STREAM_TYPE_AC3, this.zzecz);
                    break;
                case 2:
                    SensorManager.remapCoordinateSystem(this.zzecy, TsExtractor.TS_STREAM_TYPE_AC3, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, this.zzecz);
                    break;
                case 3:
                    SensorManager.remapCoordinateSystem(this.zzecy, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 1, this.zzecz);
                    break;
                default:
                    System.arraycopy(this.zzecy, 0, this.zzecz, 0, 9);
                    break;
            }
            zzl(1, 3);
            zzl(2, 6);
            zzl(5, 7);
            synchronized (this.zzecw) {
                System.arraycopy(this.zzecz, 0, this.zzeda, 0, 9);
            }
            if (this.zzedc != null) {
                this.zzedc.zztk();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(float[] fArr) {
        synchronized (this.zzecw) {
            if (this.zzeda == null) {
                return false;
            }
            System.arraycopy(this.zzeda, 0, fArr, 0, this.zzeda.length);
            return true;
        }
    }

    private final void zzl(int i, int i2) {
        float f = this.zzecz[i];
        this.zzecz[i] = this.zzecz[i2];
        this.zzecz[i2] = f;
    }
}
