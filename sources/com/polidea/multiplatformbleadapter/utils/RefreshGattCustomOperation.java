package com.polidea.multiplatformbleadapter.utils;

import android.bluetooth.BluetoothGatt;
import androidx.annotation.NonNull;
import com.polidea.rxandroidble.RxBleCustomOperation;
import com.polidea.rxandroidble.internal.connection.RxBleGattCallback;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import p033rx.Observable;
import p033rx.Scheduler;

public class RefreshGattCustomOperation implements RxBleCustomOperation<Boolean> {
    @NonNull
    public Observable<Boolean> asObservable(final BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, Scheduler scheduler) throws Throwable {
        return Observable.amb(Observable.fromCallable(new Callable<Boolean>() {
            /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x004b  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Boolean call() throws java.lang.Exception {
                /*
                    r6 = this;
                    r0 = 0
                    android.bluetooth.BluetoothGatt r1 = r4     // Catch:{ Exception -> 0x0037 }
                    java.lang.Class r1 = r1.getClass()     // Catch:{ Exception -> 0x0037 }
                    java.lang.String r2 = "refresh"
                    java.lang.Class[] r3 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0037 }
                    java.lang.reflect.Method r1 = r1.getMethod(r2, r3)     // Catch:{ Exception -> 0x0037 }
                    if (r1 != 0) goto L_0x001a
                    java.lang.String r1 = "Could not find function BluetoothGatt.refresh()"
                    java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0037 }
                    com.polidea.rxandroidble.internal.RxBleLog.m1084d(r1, r2)     // Catch:{ Exception -> 0x0037 }
                    r1 = 0
                    goto L_0x0041
                L_0x001a:
                    android.bluetooth.BluetoothGatt r2 = r4     // Catch:{ Exception -> 0x0037 }
                    java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0037 }
                    java.lang.Object r1 = r1.invoke(r2, r3)     // Catch:{ Exception -> 0x0037 }
                    java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x0037 }
                    boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x0037 }
                    if (r1 != 0) goto L_0x0041
                    java.lang.String r2 = "BluetoothGatt.refresh() returned false"
                    java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0032 }
                    com.polidea.rxandroidble.internal.RxBleLog.m1084d(r2, r3)     // Catch:{ Exception -> 0x0032 }
                    goto L_0x0041
                L_0x0032:
                    r2 = move-exception
                    r5 = r2
                    r2 = r1
                    r1 = r5
                    goto L_0x0039
                L_0x0037:
                    r1 = move-exception
                    r2 = 0
                L_0x0039:
                    java.lang.String r3 = "Could not call function BluetoothGatt.refresh()"
                    java.lang.Object[] r4 = new java.lang.Object[r0]
                    com.polidea.rxandroidble.internal.RxBleLog.m1085d(r1, r3, r4)
                    r1 = r2
                L_0x0041:
                    java.lang.String r2 = "Calling BluetoothGatt.refresh() status: %s"
                    r3 = 1
                    java.lang.Object[] r3 = new java.lang.Object[r3]
                    if (r1 == 0) goto L_0x004b
                    java.lang.String r4 = "Success"
                    goto L_0x004d
                L_0x004b:
                    java.lang.String r4 = "Failure"
                L_0x004d:
                    r3[r0] = r4
                    com.polidea.rxandroidble.internal.RxBleLog.m1088i(r2, r3)
                    java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.polidea.multiplatformbleadapter.utils.RefreshGattCustomOperation.C25331.call():java.lang.Boolean");
            }
        }).subscribeOn(scheduler).delay(1, TimeUnit.SECONDS, scheduler), rxBleGattCallback.observeDisconnect());
    }
}
