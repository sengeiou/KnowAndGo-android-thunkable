package com.polidea.rxandroidble;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.polidea.rxandroidble.exceptions.BleGattException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import p033rx.Completable;
import p033rx.Observable;

public interface RxBleConnection {
    public static final int GATT_MTU_MAXIMUM = 517;
    public static final int GATT_MTU_MINIMUM = 23;
    public static final int GATT_READ_MTU_OVERHEAD = 1;
    public static final int GATT_WRITE_MTU_OVERHEAD = 3;

    @RequiresApi(api = 21)
    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectionPriority {
    }

    @Deprecated
    public interface Connector {
        Observable<RxBleConnection> prepareConnection(boolean z);
    }

    public interface LongWriteOperationBuilder {
        Observable<byte[]> build();

        LongWriteOperationBuilder setBytes(@NonNull byte[] bArr);

        LongWriteOperationBuilder setCharacteristic(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic);

        LongWriteOperationBuilder setCharacteristicUuid(@NonNull UUID uuid);

        LongWriteOperationBuilder setMaxBatchSize(@IntRange(from = 1, mo1065to = 514) int i);

        LongWriteOperationBuilder setWriteOperationAckStrategy(@NonNull WriteOperationAckStrategy writeOperationAckStrategy);

        LongWriteOperationBuilder setWriteOperationRetryStrategy(@NonNull WriteOperationRetryStrategy writeOperationRetryStrategy);
    }

    public interface WriteOperationAckStrategy extends Observable.Transformer<Boolean, Boolean> {
    }

    LongWriteOperationBuilder createNewLongWriteBuilder();

    Observable<RxBleDeviceServices> discoverServices();

    Observable<RxBleDeviceServices> discoverServices(@IntRange(from = 1) long j, @NonNull TimeUnit timeUnit);

    Observable<BluetoothGattCharacteristic> getCharacteristic(@NonNull UUID uuid);

    int getMtu();

    <T> Observable<T> queue(@NonNull RxBleCustomOperation<T> rxBleCustomOperation);

    Observable<byte[]> readCharacteristic(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic);

    Observable<byte[]> readCharacteristic(@NonNull UUID uuid);

    Observable<byte[]> readDescriptor(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor);

    Observable<byte[]> readDescriptor(@NonNull UUID uuid, @NonNull UUID uuid2, @NonNull UUID uuid3);

    Observable<Integer> readRssi();

    @RequiresApi(api = 21)
    Completable requestConnectionPriority(int i, @IntRange(from = 1) long j, @NonNull TimeUnit timeUnit);

    @RequiresApi(api = 21)
    Observable<Integer> requestMtu(@IntRange(from = 23, mo1065to = 517) int i);

    Observable<Observable<byte[]>> setupIndication(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic);

    Observable<Observable<byte[]>> setupIndication(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull NotificationSetupMode notificationSetupMode);

    Observable<Observable<byte[]>> setupIndication(@NonNull UUID uuid);

    Observable<Observable<byte[]>> setupIndication(@NonNull UUID uuid, @NonNull NotificationSetupMode notificationSetupMode);

    Observable<Observable<byte[]>> setupNotification(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic);

    Observable<Observable<byte[]>> setupNotification(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull NotificationSetupMode notificationSetupMode);

    Observable<Observable<byte[]>> setupNotification(@NonNull UUID uuid);

    Observable<Observable<byte[]>> setupNotification(@NonNull UUID uuid, @NonNull NotificationSetupMode notificationSetupMode);

    @Deprecated
    Observable<BluetoothGattCharacteristic> writeCharacteristic(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic);

    Observable<byte[]> writeCharacteristic(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, @NonNull byte[] bArr);

    Observable<byte[]> writeCharacteristic(@NonNull UUID uuid, @NonNull byte[] bArr);

    Observable<byte[]> writeDescriptor(@NonNull BluetoothGattDescriptor bluetoothGattDescriptor, @NonNull byte[] bArr);

    Observable<byte[]> writeDescriptor(@NonNull UUID uuid, @NonNull UUID uuid2, @NonNull UUID uuid3, @NonNull byte[] bArr);

    public enum RxBleConnectionState {
        CONNECTING("CONNECTING"),
        CONNECTED("CONNECTED"),
        DISCONNECTED("DISCONNECTED"),
        DISCONNECTING("DISCONNECTING");
        
        private final String description;

        private RxBleConnectionState(String str) {
            this.description = str;
        }

        public String toString() {
            return "RxBleConnectionState{" + this.description + '}';
        }
    }

    public interface WriteOperationRetryStrategy extends Observable.Transformer<LongWriteFailure, LongWriteFailure> {

        public static class LongWriteFailure {
            final int batchIndex;
            final BleGattException cause;

            public LongWriteFailure(int i, BleGattException bleGattException) {
                this.batchIndex = i;
                this.cause = bleGattException;
            }

            public int getBatchIndex() {
                return this.batchIndex;
            }

            public BleGattException getCause() {
                return this.cause;
            }
        }
    }
}
