package com.bugsnag.android;

import androidx.annotation.NonNull;
import com.bugsnag.android.JsonStream;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class Session implements JsonStream.Streamable {
    private final AtomicBoolean autoCaptured;
    private AtomicInteger handledCount = new AtomicInteger();

    /* renamed from: id */
    private final String f65id;
    final AtomicBoolean isStopped = new AtomicBoolean(false);
    private final Date startedAt;
    private AtomicBoolean tracked = new AtomicBoolean(false);
    private AtomicInteger unhandledCount = new AtomicInteger();
    private final User user;

    static Session copySession(Session session) {
        Session session2 = new Session(session.f65id, session.startedAt, session.user, session.unhandledCount.get(), session.handledCount.get());
        session2.tracked.set(session.tracked.get());
        session2.autoCaptured.set(session.isAutoCaptured());
        return session2;
    }

    public Session(String str, Date date, User user2, boolean z) {
        this.f65id = str;
        this.startedAt = new Date(date.getTime());
        this.user = user2;
        this.autoCaptured = new AtomicBoolean(z);
    }

    Session(String str, Date date, User user2, int i, int i2) {
        this.f65id = str;
        this.startedAt = new Date(date.getTime());
        this.user = user2;
        this.autoCaptured = new AtomicBoolean(false);
        this.unhandledCount = new AtomicInteger(i);
        this.handledCount = new AtomicInteger(i2);
        this.tracked = new AtomicBoolean(true);
    }

    /* access modifiers changed from: package-private */
    public String getId() {
        return this.f65id;
    }

    /* access modifiers changed from: package-private */
    public Date getStartedAt() {
        return new Date(this.startedAt.getTime());
    }

    /* access modifiers changed from: package-private */
    public User getUser() {
        return this.user;
    }

    /* access modifiers changed from: package-private */
    public int getUnhandledCount() {
        return this.unhandledCount.intValue();
    }

    /* access modifiers changed from: package-private */
    public int getHandledCount() {
        return this.handledCount.intValue();
    }

    /* access modifiers changed from: package-private */
    public Session incrementHandledAndCopy() {
        this.handledCount.incrementAndGet();
        return copySession(this);
    }

    /* access modifiers changed from: package-private */
    public Session incrementUnhandledAndCopy() {
        this.unhandledCount.incrementAndGet();
        return copySession(this);
    }

    /* access modifiers changed from: package-private */
    public AtomicBoolean isTracked() {
        return this.tracked;
    }

    /* access modifiers changed from: package-private */
    public boolean isAutoCaptured() {
        return this.autoCaptured.get();
    }

    /* access modifiers changed from: package-private */
    public void setAutoCaptured(boolean z) {
        this.autoCaptured.set(z);
    }

    public void toStream(@NonNull JsonStream jsonStream) throws IOException {
        jsonStream.beginObject().name("id").value(this.f65id).name("startedAt").value(DateUtils.toIso8601(this.startedAt));
        if (this.user != null) {
            jsonStream.name("user").value((JsonStream.Streamable) this.user);
        }
        jsonStream.endObject();
    }
}
