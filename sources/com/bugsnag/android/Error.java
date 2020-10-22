package com.bugsnag.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bugsnag.android.JsonStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Error implements JsonStream.Streamable {
    @NonNull
    private Map<String, Object> appData = new HashMap();
    private Breadcrumbs breadcrumbs;
    @NonNull
    final Configuration config;
    @Nullable
    private String context;
    @NonNull
    private Map<String, Object> deviceData = new HashMap();
    private final BugsnagException exception;
    private final Exceptions exceptions;
    @Nullable
    private String groupingHash;
    private final HandledState handledState;
    private boolean incomplete = false;
    @NonNull
    private MetaData metaData = new MetaData();
    private String[] projectPackages;
    private final Session session;
    @Nullable
    private Severity severity;
    private final ThreadState threadState;
    @NonNull
    private User user = new User();

    Error(@NonNull Configuration configuration, @NonNull Throwable th, HandledState handledState2, @NonNull Severity severity2, Session session2, ThreadState threadState2) {
        this.threadState = threadState2;
        this.config = configuration;
        if (th instanceof BugsnagException) {
            this.exception = (BugsnagException) th;
        } else {
            this.exception = new BugsnagException(th);
        }
        this.handledState = handledState2;
        this.severity = severity2;
        this.session = session2;
        this.projectPackages = configuration.getProjectPackages();
        this.exceptions = new Exceptions(configuration, this.exception);
    }

    public void toStream(@NonNull JsonStream jsonStream) throws IOException {
        MetaData merge = MetaData.merge(this.config.getMetaData(), this.metaData);
        jsonStream.beginObject();
        jsonStream.name("context").value(this.context);
        jsonStream.name("metaData").value((JsonStream.Streamable) merge);
        jsonStream.name("severity").value((JsonStream.Streamable) this.severity);
        jsonStream.name("severityReason").value((JsonStream.Streamable) this.handledState);
        jsonStream.name("unhandled").value(this.handledState.isUnhandled());
        jsonStream.name("incomplete").value(this.incomplete);
        if (this.projectPackages != null) {
            jsonStream.name("projectPackages").beginArray();
            for (String value : this.projectPackages) {
                jsonStream.value(value);
            }
            jsonStream.endArray();
        }
        jsonStream.name("exceptions").value((JsonStream.Streamable) this.exceptions);
        jsonStream.name("user").value((JsonStream.Streamable) this.user);
        jsonStream.name("app").value((Object) this.appData);
        jsonStream.name("device").value((Object) this.deviceData);
        jsonStream.name("breadcrumbs").value((JsonStream.Streamable) this.breadcrumbs);
        jsonStream.name("groupingHash").value(this.groupingHash);
        if (this.config.getSendThreads()) {
            jsonStream.name("threads").value((JsonStream.Streamable) this.threadState);
        }
        if (this.session != null) {
            jsonStream.name("session").beginObject();
            jsonStream.name("id").value(this.session.getId());
            jsonStream.name("startedAt").value(DateUtils.toIso8601(this.session.getStartedAt()));
            jsonStream.name("events").beginObject();
            jsonStream.name("handled").value((long) this.session.getHandledCount());
            jsonStream.name("unhandled").value((long) this.session.getUnhandledCount());
            jsonStream.endObject();
            jsonStream.endObject();
        }
        jsonStream.endObject();
    }

    /* access modifiers changed from: package-private */
    public boolean isIncomplete() {
        return this.incomplete;
    }

    /* access modifiers changed from: package-private */
    public void setIncomplete(boolean z) {
        this.incomplete = z;
    }

    public void setContext(@Nullable String str) {
        this.context = str;
    }

    @Nullable
    public String getContext() {
        return this.context;
    }

    public void setGroupingHash(@Nullable String str) {
        this.groupingHash = str;
    }

    @Nullable
    public String getGroupingHash() {
        return this.groupingHash;
    }

    public void setSeverity(@Nullable Severity severity2) {
        if (severity2 != null) {
            this.severity = severity2;
            this.handledState.setCurrentSeverity(severity2);
        }
    }

    @Nullable
    public Severity getSeverity() {
        return this.severity;
    }

    public void setUser(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.user = new User(str, str2, str3);
    }

    /* access modifiers changed from: package-private */
    public void setUser(@NonNull User user2) {
        this.user = user2;
    }

    @NonNull
    public User getUser() {
        return this.user;
    }

    public void setUserId(@Nullable String str) {
        this.user = new User(this.user);
        this.user.setId(str);
    }

    public void setUserEmail(@Nullable String str) {
        this.user = new User(this.user);
        this.user.setEmail(str);
    }

    public void setUserName(@Nullable String str) {
        this.user = new User(this.user);
        this.user.setName(str);
    }

    public void addToTab(@NonNull String str, @NonNull String str2, @Nullable Object obj) {
        this.metaData.addToTab(str, str2, obj);
    }

    public void clearTab(@NonNull String str) {
        this.metaData.clearTab(str);
    }

    @NonNull
    public MetaData getMetaData() {
        return this.metaData;
    }

    public void setMetaData(@NonNull MetaData metaData2) {
        if (metaData2 == null) {
            this.metaData = new MetaData();
        } else {
            this.metaData = metaData2;
        }
    }

    @NonNull
    public String getExceptionName() {
        return this.exception.getName();
    }

    public void setExceptionName(@NonNull String str) {
        this.exception.setName(str);
    }

    @NonNull
    public String getExceptionMessage() {
        String message = this.exception.getMessage();
        return message != null ? message : "";
    }

    public void setExceptionMessage(@NonNull String str) {
        this.exception.setMessage(str);
    }

    @NonNull
    public Throwable getException() {
        return this.exception;
    }

    public void setDeviceId(@Nullable String str) {
        this.deviceData.put("id", str);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Map<String, Object> getAppData() {
        return this.appData;
    }

    @NonNull
    public Map<String, Object> getDeviceData() {
        return this.deviceData;
    }

    /* access modifiers changed from: package-private */
    public void setAppData(@NonNull Map<String, Object> map) {
        this.appData = map;
    }

    /* access modifiers changed from: package-private */
    public void setDeviceData(@NonNull Map<String, Object> map) {
        this.deviceData = map;
    }

    /* access modifiers changed from: package-private */
    public void setBreadcrumbs(Breadcrumbs breadcrumbs2) {
        this.breadcrumbs = breadcrumbs2;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldIgnoreClass() {
        return this.config.shouldIgnoreClass(getExceptionName());
    }

    @NonNull
    public HandledState getHandledState() {
        return this.handledState;
    }

    /* access modifiers changed from: package-private */
    public Exceptions getExceptions() {
        return this.exceptions;
    }

    /* access modifiers changed from: package-private */
    public Session getSession() {
        return this.session;
    }

    /* access modifiers changed from: package-private */
    public String[] getProjectPackages() {
        return this.projectPackages;
    }

    /* access modifiers changed from: package-private */
    public void setProjectPackages(String[] strArr) {
        this.projectPackages = strArr;
        if (this.exceptions != null) {
            this.exceptions.setProjectPackages(strArr);
        }
    }

    static class Builder {
        private String attributeValue;
        private final Configuration config;
        private final Throwable exception;
        private MetaData metaData;
        private final SessionTracker sessionTracker;
        private Severity severity;
        private String severityReasonType;
        private final ThreadState threadState;

        Builder(@NonNull Configuration configuration, @NonNull Throwable th, SessionTracker sessionTracker2, @NonNull Thread thread, boolean z) {
            this.severity = Severity.WARNING;
            this.threadState = new ThreadState(configuration, thread, Thread.getAllStackTraces(), z ? th : null);
            this.config = configuration;
            this.exception = th;
            this.severityReasonType = "userSpecifiedSeverity";
            this.sessionTracker = sessionTracker2;
        }

        Builder(@NonNull Configuration configuration, @NonNull String str, @NonNull String str2, @NonNull StackTraceElement[] stackTraceElementArr, SessionTracker sessionTracker2, Thread thread) {
            this(configuration, new BugsnagException(str, str2, stackTraceElementArr), sessionTracker2, thread, false);
        }

        /* access modifiers changed from: package-private */
        public Builder severityReasonType(String str) {
            this.severityReasonType = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder attributeValue(String str) {
            this.attributeValue = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder severity(Severity severity2) {
            this.severity = severity2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder metaData(MetaData metaData2) {
            this.metaData = metaData2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Error build() {
            HandledState newInstance = HandledState.newInstance(this.severityReasonType, this.severity, this.attributeValue);
            Error error = new Error(this.config, this.exception, newInstance, this.severity, getSession(newInstance), this.threadState);
            if (this.metaData != null) {
                error.setMetaData(this.metaData);
            }
            return error;
        }

        private Session getSession(HandledState handledState) {
            Session currentSession;
            if (this.sessionTracker == null || (currentSession = this.sessionTracker.getCurrentSession()) == null) {
                return null;
            }
            if (!this.config.getAutoCaptureSessions() && currentSession.isAutoCaptured()) {
                return null;
            }
            if (handledState.isUnhandled()) {
                return this.sessionTracker.incrementUnhandledAndCopy();
            }
            return this.sessionTracker.incrementHandledAndCopy();
        }
    }
}
