package com.polidea.rxandroidble.internal.scan;

import android.os.ParcelUuid;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.polidea.rxandroidble.scan.ScanRecord;
import java.util.List;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ScanRecordImplCompat implements ScanRecord {
    private final int advertiseFlags;
    private final byte[] bytes;
    private final String deviceName;
    private final SparseArray<byte[]> manufacturerSpecificData;
    private final Map<ParcelUuid, byte[]> serviceData;
    @Nullable
    private final List<ParcelUuid> serviceUuids;
    private final int txPowerLevel;

    public ScanRecordImplCompat(@Nullable List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i, int i2, String str, byte[] bArr) {
        this.serviceUuids = list;
        this.manufacturerSpecificData = sparseArray;
        this.serviceData = map;
        this.deviceName = str;
        this.advertiseFlags = i;
        this.txPowerLevel = i2;
        this.bytes = bArr;
    }

    public int getAdvertiseFlags() {
        return this.advertiseFlags;
    }

    @Nullable
    public List<ParcelUuid> getServiceUuids() {
        return this.serviceUuids;
    }

    public SparseArray<byte[]> getManufacturerSpecificData() {
        return this.manufacturerSpecificData;
    }

    @Nullable
    public byte[] getManufacturerSpecificData(int i) {
        return this.manufacturerSpecificData.get(i);
    }

    public Map<ParcelUuid, byte[]> getServiceData() {
        return this.serviceData;
    }

    @Nullable
    public byte[] getServiceData(ParcelUuid parcelUuid) {
        if (parcelUuid == null) {
            return null;
        }
        return this.serviceData.get(parcelUuid);
    }

    public int getTxPowerLevel() {
        return this.txPowerLevel;
    }

    @Nullable
    public String getDeviceName() {
        return this.deviceName;
    }

    public byte[] getBytes() {
        return this.bytes;
    }
}
