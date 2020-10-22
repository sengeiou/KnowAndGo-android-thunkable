package com.polidea.rxandroidble.helpers;

import android.content.Context;
import androidx.annotation.NonNull;
import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble.ClientComponent;
import com.polidea.rxandroidble.DaggerClientComponent;
import p033rx.Emitter;
import p033rx.Observable;
import p033rx.functions.Action1;
import p033rx.internal.operators.OnSubscribeCreate;

public class LocationServicesOkObservable extends Observable<Boolean> {
    public static LocationServicesOkObservable createInstance(@NonNull Context context) {
        return DaggerClientComponent.builder().clientModule(new ClientComponent.ClientModule(context)).build().locationServicesOkObservable();
    }

    @Inject
    LocationServicesOkObservable(@Named("location-ok-boolean-observable") final Observable<Boolean> observable) {
        super(new OnSubscribeCreate(new Action1<Emitter<Boolean>>() {
            public void call(Emitter<Boolean> emitter) {
                emitter.setSubscription(Observable.this.subscribe(emitter));
            }
        }, Emitter.BackpressureMode.LATEST));
    }
}
