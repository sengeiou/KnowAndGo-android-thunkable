package org.apache.logging.log4j.message;

import java.lang.Thread;
import kotlin.text.Typography;

class BasicThreadInformation implements ThreadInformation {
    private static final int HASH_MULTIPLIER = 31;
    private static final int HASH_SHIFT = 32;

    /* renamed from: id */
    private final long f3044id;
    private final boolean isAlive;
    private final boolean isDaemon;
    private final String longName;
    private final String name;
    private final int priority;
    private final Thread.State state;
    private final String threadGroupName;

    public BasicThreadInformation(Thread thread) {
        String str;
        this.f3044id = thread.getId();
        this.name = thread.getName();
        this.longName = thread.toString();
        this.state = thread.getState();
        this.priority = thread.getPriority();
        this.isAlive = thread.isAlive();
        this.isDaemon = thread.isDaemon();
        ThreadGroup threadGroup = thread.getThreadGroup();
        if (threadGroup == null) {
            str = null;
        } else {
            str = threadGroup.getName();
        }
        this.threadGroupName = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BasicThreadInformation basicThreadInformation = (BasicThreadInformation) obj;
        if (this.f3044id != basicThreadInformation.f3044id) {
            return false;
        }
        return this.name == null ? basicThreadInformation.name == null : this.name.equals(basicThreadInformation.name);
    }

    public int hashCode() {
        return (((int) (this.f3044id ^ (this.f3044id >>> 32))) * 31) + (this.name != null ? this.name.hashCode() : 0);
    }

    public void printThreadInfo(StringBuilder sb) {
        sb.append(Typography.quote);
        sb.append(this.name);
        sb.append("\" ");
        if (this.isDaemon) {
            sb.append("daemon ");
        }
        sb.append("prio=");
        sb.append(this.priority);
        sb.append(" tid=");
        sb.append(this.f3044id);
        sb.append(' ');
        if (this.threadGroupName != null) {
            sb.append("group=\"");
            sb.append(this.threadGroupName);
            sb.append(Typography.quote);
        }
        sb.append(10);
        sb.append("\tThread state: ");
        sb.append(this.state.name());
        sb.append(10);
    }

    public void printStack(StringBuilder sb, StackTraceElement[] stackTraceElementArr) {
        for (StackTraceElement append : stackTraceElementArr) {
            sb.append("\tat ");
            sb.append(append);
            sb.append(10);
        }
    }
}
