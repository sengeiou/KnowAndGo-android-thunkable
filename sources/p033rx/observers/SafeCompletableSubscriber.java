package p033rx.observers;

import p033rx.CompletableSubscriber;
import p033rx.Subscription;
import p033rx.exceptions.CompositeException;
import p033rx.exceptions.Exceptions;
import p033rx.exceptions.OnCompletedFailedException;
import p033rx.exceptions.OnErrorFailedException;
import p033rx.plugins.RxJavaHooks;

/* renamed from: rx.observers.SafeCompletableSubscriber */
public final class SafeCompletableSubscriber implements CompletableSubscriber, Subscription {
    final CompletableSubscriber actual;
    boolean done;

    /* renamed from: s */
    Subscription f3088s;

    public SafeCompletableSubscriber(CompletableSubscriber completableSubscriber) {
        this.actual = completableSubscriber;
    }

    public void onCompleted() {
        if (!this.done) {
            this.done = true;
            try {
                this.actual.onCompleted();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                throw new OnCompletedFailedException(th);
            }
        }
    }

    public void onError(Throwable th) {
        if (this.done) {
            RxJavaHooks.onError(th);
            return;
        }
        this.done = true;
        try {
            this.actual.onError(th);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            throw new OnErrorFailedException(new CompositeException(th, th2));
        }
    }

    public void onSubscribe(Subscription subscription) {
        this.f3088s = subscription;
        try {
            this.actual.onSubscribe(this);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            subscription.unsubscribe();
            onError(th);
        }
    }

    public void unsubscribe() {
        this.f3088s.unsubscribe();
    }

    public boolean isUnsubscribed() {
        return this.done || this.f3088s.isUnsubscribed();
    }
}
