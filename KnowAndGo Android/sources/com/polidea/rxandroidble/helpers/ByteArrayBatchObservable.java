package com.polidea.rxandroidble.helpers;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import p033rx.Observable;
import p033rx.Observer;
import p033rx.functions.Action2;
import p033rx.functions.Func0;
import p033rx.observables.SyncOnSubscribe;

public class ByteArrayBatchObservable extends Observable<byte[]> {
    public ByteArrayBatchObservable(@NonNull byte[] bArr, int i) {
        super(createSyncOnSubscribe(copy(bArr), i));
        if (i <= 0) {
            throw new IllegalArgumentException("maxBatchSize must be >0 but found: " + i);
        }
    }

    @NonNull
    private static SyncOnSubscribe<ByteBuffer, byte[]> createSyncOnSubscribe(final byte[] bArr, final int i) {
        return SyncOnSubscribe.createSingleState(new Func0<ByteBuffer>() {
            public ByteBuffer call() {
                return ByteBuffer.wrap(bArr);
            }
        }, new Action2<ByteBuffer, Observer<? super byte[]>>() {
            public void call(ByteBuffer byteBuffer, Observer<? super byte[]> observer) {
                int min = Math.min(byteBuffer.remaining(), i);
                if (min == 0) {
                    observer.onCompleted();
                    return;
                }
                byte[] bArr = new byte[min];
                byteBuffer.get(bArr);
                observer.onNext(bArr);
            }
        });
    }

    @NonNull
    private static byte[] copy(@NonNull byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
