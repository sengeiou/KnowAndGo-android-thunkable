package p033rx.internal.operators;

import p033rx.Observable;
import p033rx.Subscriber;
import p033rx.exceptions.Exceptions;
import p033rx.functions.Action0;
import p033rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.OperatorDoAfterTerminate */
public final class OperatorDoAfterTerminate<T> implements Observable.Operator<T, T> {
    final Action0 action;

    public OperatorDoAfterTerminate(Action0 action0) {
        if (action0 != null) {
            this.action = action0;
            return;
        }
        throw new NullPointerException("Action can not be null");
    }

    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) {
            public void onNext(T t) {
                subscriber.onNext(t);
            }

            public void onError(Throwable th) {
                try {
                    subscriber.onError(th);
                } finally {
                    callAction();
                }
            }

            public void onCompleted() {
                try {
                    subscriber.onCompleted();
                } finally {
                    callAction();
                }
            }

            /* access modifiers changed from: package-private */
            public void callAction() {
                try {
                    OperatorDoAfterTerminate.this.action.call();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaHooks.onError(th);
                }
            }
        };
    }
}
