package p033rx.internal.observers;

import java.util.List;
import java.util.concurrent.TimeUnit;
import p033rx.Producer;
import p033rx.Subscriber;
import p033rx.functions.Action0;
import p033rx.observers.AssertableSubscriber;
import p033rx.observers.TestSubscriber;

/* renamed from: rx.internal.observers.AssertableSubscriberObservable */
public class AssertableSubscriberObservable<T> extends Subscriber<T> implements AssertableSubscriber<T> {

    /* renamed from: ts */
    private final TestSubscriber<T> f3050ts;

    public AssertableSubscriberObservable(TestSubscriber<T> testSubscriber) {
        this.f3050ts = testSubscriber;
    }

    public static <T> AssertableSubscriberObservable<T> create(long j) {
        TestSubscriber testSubscriber = new TestSubscriber(j);
        AssertableSubscriberObservable<T> assertableSubscriberObservable = new AssertableSubscriberObservable<>(testSubscriber);
        assertableSubscriberObservable.add(testSubscriber);
        return assertableSubscriberObservable;
    }

    public void onStart() {
        this.f3050ts.onStart();
    }

    public void onCompleted() {
        this.f3050ts.onCompleted();
    }

    public void setProducer(Producer producer) {
        this.f3050ts.setProducer(producer);
    }

    public final int getCompletions() {
        return this.f3050ts.getCompletions();
    }

    public void onError(Throwable th) {
        this.f3050ts.onError(th);
    }

    public List<Throwable> getOnErrorEvents() {
        return this.f3050ts.getOnErrorEvents();
    }

    public void onNext(T t) {
        this.f3050ts.onNext(t);
    }

    public final int getValueCount() {
        return this.f3050ts.getValueCount();
    }

    public AssertableSubscriber<T> requestMore(long j) {
        this.f3050ts.requestMore(j);
        return this;
    }

    public List<T> getOnNextEvents() {
        return this.f3050ts.getOnNextEvents();
    }

    public AssertableSubscriber<T> assertReceivedOnNext(List<T> list) {
        this.f3050ts.assertReceivedOnNext(list);
        return this;
    }

    public final AssertableSubscriber<T> awaitValueCount(int i, long j, TimeUnit timeUnit) {
        if (this.f3050ts.awaitValueCount(i, j, timeUnit)) {
            return this;
        }
        throw new AssertionError("Did not receive enough values in time. Expected: " + i + ", Actual: " + this.f3050ts.getValueCount());
    }

    public AssertableSubscriber<T> assertTerminalEvent() {
        this.f3050ts.assertTerminalEvent();
        return this;
    }

    public AssertableSubscriber<T> assertUnsubscribed() {
        this.f3050ts.assertUnsubscribed();
        return this;
    }

    public AssertableSubscriber<T> assertNoErrors() {
        this.f3050ts.assertNoErrors();
        return this;
    }

    public AssertableSubscriber<T> awaitTerminalEvent() {
        this.f3050ts.awaitTerminalEvent();
        return this;
    }

    public AssertableSubscriber<T> awaitTerminalEvent(long j, TimeUnit timeUnit) {
        this.f3050ts.awaitTerminalEvent(j, timeUnit);
        return this;
    }

    public AssertableSubscriber<T> awaitTerminalEventAndUnsubscribeOnTimeout(long j, TimeUnit timeUnit) {
        this.f3050ts.awaitTerminalEventAndUnsubscribeOnTimeout(j, timeUnit);
        return this;
    }

    public Thread getLastSeenThread() {
        return this.f3050ts.getLastSeenThread();
    }

    public AssertableSubscriber<T> assertCompleted() {
        this.f3050ts.assertCompleted();
        return this;
    }

    public AssertableSubscriber<T> assertNotCompleted() {
        this.f3050ts.assertNotCompleted();
        return this;
    }

    public AssertableSubscriber<T> assertError(Class<? extends Throwable> cls) {
        this.f3050ts.assertError(cls);
        return this;
    }

    public AssertableSubscriber<T> assertError(Throwable th) {
        this.f3050ts.assertError(th);
        return this;
    }

    public AssertableSubscriber<T> assertNoTerminalEvent() {
        this.f3050ts.assertNoTerminalEvent();
        return this;
    }

    public AssertableSubscriber<T> assertNoValues() {
        this.f3050ts.assertNoValues();
        return this;
    }

    public AssertableSubscriber<T> assertValueCount(int i) {
        this.f3050ts.assertValueCount(i);
        return this;
    }

    public AssertableSubscriber<T> assertValues(T... tArr) {
        this.f3050ts.assertValues(tArr);
        return this;
    }

    public AssertableSubscriber<T> assertValue(T t) {
        this.f3050ts.assertValue(t);
        return this;
    }

    public final AssertableSubscriber<T> assertValuesAndClear(T t, T... tArr) {
        this.f3050ts.assertValuesAndClear(t, tArr);
        return this;
    }

    public final AssertableSubscriber<T> perform(Action0 action0) {
        action0.call();
        return this;
    }

    public String toString() {
        return this.f3050ts.toString();
    }

    public final AssertableSubscriber<T> assertResult(T... tArr) {
        this.f3050ts.assertValues(tArr);
        this.f3050ts.assertNoErrors();
        this.f3050ts.assertCompleted();
        return this;
    }

    public final AssertableSubscriber<T> assertFailure(Class<? extends Throwable> cls, T... tArr) {
        this.f3050ts.assertValues(tArr);
        this.f3050ts.assertError(cls);
        this.f3050ts.assertNotCompleted();
        return this;
    }

    public final AssertableSubscriber<T> assertFailureAndMessage(Class<? extends Throwable> cls, String str, T... tArr) {
        this.f3050ts.assertValues(tArr);
        this.f3050ts.assertError(cls);
        this.f3050ts.assertNotCompleted();
        String message = this.f3050ts.getOnErrorEvents().get(0).getMessage();
        if (message == str || (str != null && str.equals(message))) {
            return this;
        }
        throw new AssertionError("Error message differs. Expected: '" + str + "', Received: '" + message + "'");
    }
}
