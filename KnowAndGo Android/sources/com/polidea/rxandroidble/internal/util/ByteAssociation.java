package com.polidea.rxandroidble.internal.util;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.UUID;

public class ByteAssociation<T> {
    public final T first;
    public final byte[] second;

    public ByteAssociation(@NonNull T t, byte[] bArr) {
        this.first = t;
        this.second = bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ByteAssociation)) {
            return false;
        }
        ByteAssociation byteAssociation = (ByteAssociation) obj;
        if (!Arrays.equals(byteAssociation.second, this.second) || !byteAssociation.first.equals(this.first)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.first.hashCode() ^ Arrays.hashCode(this.second);
    }

    public String toString() {
        String str;
        if (this.first instanceof BluetoothGattCharacteristic) {
            str = BluetoothGattCharacteristic.class.getSimpleName() + "(" + ((BluetoothGattCharacteristic) this.first).getUuid().toString() + ")";
        } else if (this.first instanceof BluetoothGattDescriptor) {
            str = BluetoothGattDescriptor.class.getSimpleName() + "(" + ((BluetoothGattDescriptor) this.first).getUuid().toString() + ")";
        } else if (this.first instanceof UUID) {
            str = UUID.class.getSimpleName() + "(" + this.first.toString() + ")";
        } else {
            str = this.first.getClass().getSimpleName();
        }
        return getClass().getSimpleName() + "[first=" + str + ", second=" + Arrays.toString(this.second) + "]";
    }

    public static <T> ByteAssociation<T> create(T t, byte[] bArr) {
        return new ByteAssociation<>(t, bArr);
    }
}
