package p033rx.internal.subscriptions;

import p033rx.Subscription;

/* renamed from: rx.internal.subscriptions.Unsubscribed */
public enum Unsubscribed implements Subscription {
    INSTANCE;

    public boolean isUnsubscribed() {
        return true;
    }

    public void unsubscribe() {
    }
}
