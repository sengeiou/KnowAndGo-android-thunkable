package com.polidea.rxandroidble.internal.connection;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.annotation.NonNull;
import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble.NotificationSetupMode;
import com.polidea.rxandroidble.exceptions.BleCannotSetCharacteristicNotificationException;
import com.polidea.rxandroidble.exceptions.BleConflictingNotificationAlreadySetException;
import com.polidea.rxandroidble.internal.util.ActiveCharacteristicNotification;
import com.polidea.rxandroidble.internal.util.CharacteristicChangedEvent;
import com.polidea.rxandroidble.internal.util.CharacteristicNotificationId;
import com.polidea.rxandroidble.internal.util.ObservableUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import p033rx.Completable;
import p033rx.Observable;
import p033rx.functions.Action0;
import p033rx.functions.Actions;
import p033rx.functions.Func0;
import p033rx.functions.Func1;
import p033rx.subjects.PublishSubject;

@ConnectionScope
class NotificationAndIndicationManager {
    static final UUID CLIENT_CHARACTERISTIC_CONFIG_UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    /* access modifiers changed from: private */
    public final Map<CharacteristicNotificationId, ActiveCharacteristicNotification> activeNotificationObservableMap = new HashMap();
    /* access modifiers changed from: private */
    public final BluetoothGatt bluetoothGatt;
    /* access modifiers changed from: private */
    public final byte[] configDisable;
    /* access modifiers changed from: private */
    public final byte[] configEnableIndication;
    /* access modifiers changed from: private */
    public final byte[] configEnableNotification;
    /* access modifiers changed from: private */
    public final DescriptorWriter descriptorWriter;
    /* access modifiers changed from: private */
    public final RxBleGattCallback gattCallback;

    @Inject
    NotificationAndIndicationManager(@Named("enable-notification-value") byte[] bArr, @Named("enable-indication-value") byte[] bArr2, @Named("disable-notification-value") byte[] bArr3, BluetoothGatt bluetoothGatt2, RxBleGattCallback rxBleGattCallback, DescriptorWriter descriptorWriter2) {
        this.configEnableNotification = bArr;
        this.configEnableIndication = bArr2;
        this.configDisable = bArr3;
        this.bluetoothGatt = bluetoothGatt2;
        this.gattCallback = rxBleGattCallback;
        this.descriptorWriter = descriptorWriter2;
    }

    /* access modifiers changed from: package-private */
    public Observable<Observable<byte[]>> setupServerInitiatedCharacteristicRead(@NonNull final BluetoothGattCharacteristic bluetoothGattCharacteristic, final NotificationSetupMode notificationSetupMode, final boolean z) {
        return Observable.defer(new Func0<Observable<Observable<byte[]>>>() {
            public Observable<Observable<byte[]>> call() {
                synchronized (NotificationAndIndicationManager.this.activeNotificationObservableMap) {
                    final CharacteristicNotificationId characteristicNotificationId = new CharacteristicNotificationId(bluetoothGattCharacteristic.getUuid(), Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()));
                    ActiveCharacteristicNotification activeCharacteristicNotification = (ActiveCharacteristicNotification) NotificationAndIndicationManager.this.activeNotificationObservableMap.get(characteristicNotificationId);
                    if (activeCharacteristicNotification == null) {
                        byte[] access$100 = z ? NotificationAndIndicationManager.this.configEnableIndication : NotificationAndIndicationManager.this.configEnableNotification;
                        final PublishSubject create = PublishSubject.create();
                        Observable<Observable<byte[]>> refCount = NotificationAndIndicationManager.setCharacteristicNotification(NotificationAndIndicationManager.this.bluetoothGatt, bluetoothGattCharacteristic, true).andThen(ObservableUtil.justOnNext(NotificationAndIndicationManager.observeOnCharacteristicChangeCallbacks(NotificationAndIndicationManager.this.gattCallback, characteristicNotificationId))).compose(NotificationAndIndicationManager.setupModeTransformer(NotificationAndIndicationManager.this.descriptorWriter, bluetoothGattCharacteristic, access$100, notificationSetupMode)).map(new Func1<Observable<byte[]>, Observable<byte[]>>() {
                            public Observable<byte[]> call(Observable<byte[]> observable) {
                                return Observable.amb(create.cast(byte[].class), observable.takeUntil((Observable<? extends E>) create));
                            }
                        }).doOnUnsubscribe(new Action0() {
                            public void call() {
                                create.onCompleted();
                                synchronized (NotificationAndIndicationManager.this.activeNotificationObservableMap) {
                                    NotificationAndIndicationManager.this.activeNotificationObservableMap.remove(characteristicNotificationId);
                                }
                                NotificationAndIndicationManager.setCharacteristicNotification(NotificationAndIndicationManager.this.bluetoothGatt, bluetoothGattCharacteristic, false).compose(NotificationAndIndicationManager.teardownModeTransformer(NotificationAndIndicationManager.this.descriptorWriter, bluetoothGattCharacteristic, NotificationAndIndicationManager.this.configDisable, notificationSetupMode)).subscribe(Actions.empty(), Actions.toAction1(Actions.empty()));
                            }
                        }).mergeWith(NotificationAndIndicationManager.this.gattCallback.observeDisconnect()).replay(1).refCount();
                        NotificationAndIndicationManager.this.activeNotificationObservableMap.put(characteristicNotificationId, new ActiveCharacteristicNotification(refCount, z));
                        return refCount;
                    } else if (activeCharacteristicNotification.isIndication == z) {
                        Observable<Observable<byte[]>> observable = activeCharacteristicNotification.notificationObservable;
                        return observable;
                    } else {
                        Observable<Observable<byte[]>> error = Observable.error(new BleConflictingNotificationAlreadySetException(bluetoothGattCharacteristic.getUuid(), true ^ z));
                        return error;
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    @NonNull
    public static Completable setCharacteristicNotification(final BluetoothGatt bluetoothGatt2, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final boolean z) {
        return Completable.fromAction(new Action0() {
            public void call() {
                if (!bluetoothGatt2.setCharacteristicNotification(bluetoothGattCharacteristic, z)) {
                    throw new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 1, (Throwable) null);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    @NonNull
    public static Observable.Transformer<Observable<byte[]>, Observable<byte[]>> setupModeTransformer(final DescriptorWriter descriptorWriter2, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final byte[] bArr, final NotificationSetupMode notificationSetupMode) {
        return new Observable.Transformer<Observable<byte[]>, Observable<byte[]>>() {
            public Observable<Observable<byte[]>> call(Observable<Observable<byte[]>> observable) {
                switch (C26678.$SwitchMap$com$polidea$rxandroidble$NotificationSetupMode[notificationSetupMode.ordinal()]) {
                    case 1:
                        return observable;
                    case 2:
                        final Completable completable = NotificationAndIndicationManager.writeClientCharacteristicConfig(bluetoothGattCharacteristic, descriptorWriter2, bArr).toObservable().publish().autoConnect(2).toCompletable();
                        return observable.mergeWith(completable.toObservable()).map(new Func1<Observable<byte[]>, Observable<byte[]>>() {
                            public Observable<byte[]> call(Observable<byte[]> observable) {
                                return observable.mergeWith(completable.onErrorComplete().toObservable());
                            }
                        });
                    default:
                        return NotificationAndIndicationManager.writeClientCharacteristicConfig(bluetoothGattCharacteristic, descriptorWriter2, bArr).andThen(observable);
                }
            }
        };
    }

    /* renamed from: com.polidea.rxandroidble.internal.connection.NotificationAndIndicationManager$8 */
    static /* synthetic */ class C26678 {
        static final /* synthetic */ int[] $SwitchMap$com$polidea$rxandroidble$NotificationSetupMode = new int[NotificationSetupMode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.polidea.rxandroidble.NotificationSetupMode[] r0 = com.polidea.rxandroidble.NotificationSetupMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$polidea$rxandroidble$NotificationSetupMode = r0
                int[] r0 = $SwitchMap$com$polidea$rxandroidble$NotificationSetupMode     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.polidea.rxandroidble.NotificationSetupMode r1 = com.polidea.rxandroidble.NotificationSetupMode.COMPAT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$polidea$rxandroidble$NotificationSetupMode     // Catch:{ NoSuchFieldError -> 0x001f }
                com.polidea.rxandroidble.NotificationSetupMode r1 = com.polidea.rxandroidble.NotificationSetupMode.QUICK_SETUP     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$polidea$rxandroidble$NotificationSetupMode     // Catch:{ NoSuchFieldError -> 0x002a }
                com.polidea.rxandroidble.NotificationSetupMode r1 = com.polidea.rxandroidble.NotificationSetupMode.DEFAULT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.polidea.rxandroidble.internal.connection.NotificationAndIndicationManager.C26678.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    @NonNull
    public static Completable.Transformer teardownModeTransformer(final DescriptorWriter descriptorWriter2, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final byte[] bArr, final NotificationSetupMode notificationSetupMode) {
        return new Completable.Transformer() {
            public Completable call(Completable completable) {
                if (notificationSetupMode == NotificationSetupMode.COMPAT) {
                    return completable;
                }
                return completable.andThen(NotificationAndIndicationManager.writeClientCharacteristicConfig(bluetoothGattCharacteristic, descriptorWriter2, bArr));
            }
        };
    }

    /* access modifiers changed from: private */
    @NonNull
    public static Observable<byte[]> observeOnCharacteristicChangeCallbacks(RxBleGattCallback rxBleGattCallback, final CharacteristicNotificationId characteristicNotificationId) {
        return rxBleGattCallback.getOnCharacteristicChanged().filter(new Func1<CharacteristicChangedEvent, Boolean>() {
            public Boolean call(CharacteristicChangedEvent characteristicChangedEvent) {
                return Boolean.valueOf(characteristicChangedEvent.equals(characteristicNotificationId));
            }
        }).map(new Func1<CharacteristicChangedEvent, byte[]>() {
            public byte[] call(CharacteristicChangedEvent characteristicChangedEvent) {
                return characteristicChangedEvent.data;
            }
        });
    }

    /* access modifiers changed from: private */
    @NonNull
    public static Completable writeClientCharacteristicConfig(final BluetoothGattCharacteristic bluetoothGattCharacteristic, DescriptorWriter descriptorWriter2, byte[] bArr) {
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG_UUID);
        if (descriptor == null) {
            return Completable.error((Throwable) new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 2, (Throwable) null));
        }
        return descriptorWriter2.writeDescriptor(descriptor, bArr).toCompletable().onErrorResumeNext(new Func1<Throwable, Completable>() {
            public Completable call(Throwable th) {
                return Completable.error((Throwable) new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 3, th));
            }
        });
    }
}
