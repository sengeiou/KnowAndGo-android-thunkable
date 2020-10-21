package com.polidea.rxandroidble;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import bleshadow.javax.inject.Inject;
import p033rx.Emitter;
import p033rx.Observable;
import p033rx.functions.Action1;
import p033rx.functions.Cancellable;
import p033rx.internal.operators.OnSubscribeCreate;

public class RxBleAdapterStateObservable extends Observable<BleAdapterState> {

    public static class BleAdapterState {
        public static final BleAdapterState STATE_OFF = new BleAdapterState(false);
        public static final BleAdapterState STATE_ON = new BleAdapterState(true);
        public static final BleAdapterState STATE_TURNING_OFF = new BleAdapterState(false);
        public static final BleAdapterState STATE_TURNING_ON = new BleAdapterState(false);
        private final boolean isUsable;

        private BleAdapterState(boolean z) {
            this.isUsable = z;
        }

        public boolean isUsable() {
            return this.isUsable;
        }
    }

    @Inject
    public RxBleAdapterStateObservable(@NonNull final Context context) {
        super(new OnSubscribeCreate(new Action1<Emitter<BleAdapterState>>() {
            public void call(final Emitter<BleAdapterState> emitter) {
                final C26151 r0 = new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                            emitter.onNext(RxBleAdapterStateObservable.mapToBleAdapterState(intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1)));
                        }
                    }
                };
                context.registerReceiver(r0, RxBleAdapterStateObservable.createFilter());
                emitter.setCancellation(new Cancellable() {
                    public void cancel() throws Exception {
                        context.unregisterReceiver(r0);
                    }
                });
            }
        }, Emitter.BackpressureMode.LATEST));
    }

    /* access modifiers changed from: private */
    public static BleAdapterState mapToBleAdapterState(int i) {
        switch (i) {
            case 11:
                return BleAdapterState.STATE_TURNING_ON;
            case 12:
                return BleAdapterState.STATE_ON;
            case 13:
                return BleAdapterState.STATE_TURNING_OFF;
            default:
                return BleAdapterState.STATE_OFF;
        }
    }

    /* access modifiers changed from: private */
    public static IntentFilter createFilter() {
        return new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
    }
}
