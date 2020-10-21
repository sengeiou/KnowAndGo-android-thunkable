package org.apache.logging.log4j.message;

import java.lang.Thread;
import java.lang.management.LockInfo;
import java.lang.management.MonitorInfo;
import java.lang.management.ThreadInfo;
import kotlin.text.Typography;

class ExtendedThreadInformation implements ThreadInformation {
    private final ThreadInfo threadInfo;

    public ExtendedThreadInformation(ThreadInfo threadInfo2) {
        this.threadInfo = threadInfo2;
    }

    public void printThreadInfo(StringBuilder sb) {
        sb.append(Typography.quote);
        sb.append(this.threadInfo.getThreadName());
        sb.append(Typography.quote);
        sb.append(" Id=");
        sb.append(this.threadInfo.getThreadId());
        sb.append(' ');
        formatState(sb, this.threadInfo);
        if (this.threadInfo.isSuspended()) {
            sb.append(" (suspended)");
        }
        if (this.threadInfo.isInNative()) {
            sb.append(" (in native)");
        }
        sb.append(10);
    }

    public void printStack(StringBuilder sb, StackTraceElement[] stackTraceElementArr) {
        int i = 0;
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append("\tat ");
            sb.append(stackTraceElement.toString());
            sb.append(10);
            if (i == 0 && this.threadInfo.getLockInfo() != null) {
                switch (C39811.$SwitchMap$java$lang$Thread$State[this.threadInfo.getThreadState().ordinal()]) {
                    case 1:
                        sb.append("\t-  blocked on ");
                        formatLock(sb, this.threadInfo.getLockInfo());
                        sb.append(10);
                        break;
                    case 2:
                        sb.append("\t-  waiting on ");
                        formatLock(sb, this.threadInfo.getLockInfo());
                        sb.append(10);
                        break;
                    case 3:
                        sb.append("\t-  waiting on ");
                        formatLock(sb, this.threadInfo.getLockInfo());
                        sb.append(10);
                        break;
                }
            }
            for (MonitorInfo monitorInfo : this.threadInfo.getLockedMonitors()) {
                if (monitorInfo.getLockedStackDepth() == i) {
                    sb.append("\t-  locked ");
                    formatLock(sb, monitorInfo);
                    sb.append(10);
                }
            }
            i++;
        }
        LockInfo[] lockedSynchronizers = this.threadInfo.getLockedSynchronizers();
        if (lockedSynchronizers.length > 0) {
            sb.append("\n\tNumber of locked synchronizers = ");
            sb.append(lockedSynchronizers.length);
            sb.append(10);
            for (LockInfo formatLock : lockedSynchronizers) {
                sb.append("\t- ");
                formatLock(sb, formatLock);
                sb.append(10);
            }
        }
    }

    /* renamed from: org.apache.logging.log4j.message.ExtendedThreadInformation$1 */
    static /* synthetic */ class C39811 {
        static final /* synthetic */ int[] $SwitchMap$java$lang$Thread$State = new int[Thread.State.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                java.lang.Thread$State[] r0 = java.lang.Thread.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$lang$Thread$State = r0
                int[] r0 = $SwitchMap$java$lang$Thread$State     // Catch:{ NoSuchFieldError -> 0x0014 }
                java.lang.Thread$State r1 = java.lang.Thread.State.BLOCKED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$java$lang$Thread$State     // Catch:{ NoSuchFieldError -> 0x001f }
                java.lang.Thread$State r1 = java.lang.Thread.State.WAITING     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$java$lang$Thread$State     // Catch:{ NoSuchFieldError -> 0x002a }
                java.lang.Thread$State r1 = java.lang.Thread.State.TIMED_WAITING     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.logging.log4j.message.ExtendedThreadInformation.C39811.<clinit>():void");
        }
    }

    private void formatLock(StringBuilder sb, LockInfo lockInfo) {
        sb.append(Typography.less);
        sb.append(lockInfo.getIdentityHashCode());
        sb.append("> (a ");
        sb.append(lockInfo.getClassName());
        sb.append(')');
    }

    private void formatState(StringBuilder sb, ThreadInfo threadInfo2) {
        Thread.State threadState = threadInfo2.getThreadState();
        sb.append(threadState);
        switch (C39811.$SwitchMap$java$lang$Thread$State[threadState.ordinal()]) {
            case 1:
                sb.append(" (on object monitor owned by \"");
                sb.append(threadInfo2.getLockOwnerName());
                sb.append("\" Id=");
                sb.append(threadInfo2.getLockOwnerId());
                sb.append(')');
                return;
            case 2:
                StackTraceElement stackTraceElement = threadInfo2.getStackTrace()[0];
                String className = stackTraceElement.getClassName();
                String methodName = stackTraceElement.getMethodName();
                if (className.equals("java.lang.Object") && methodName.equals("wait")) {
                    sb.append(" (on object monitor");
                    if (threadInfo2.getLockOwnerName() != null) {
                        sb.append(" owned by \"");
                        sb.append(threadInfo2.getLockOwnerName());
                        sb.append("\" Id=");
                        sb.append(threadInfo2.getLockOwnerId());
                    }
                    sb.append(')');
                    return;
                } else if (!className.equals("java.lang.Thread") || !methodName.equals("join")) {
                    sb.append(" (parking for lock");
                    if (threadInfo2.getLockOwnerName() != null) {
                        sb.append(" owned by \"");
                        sb.append(threadInfo2.getLockOwnerName());
                        sb.append("\" Id=");
                        sb.append(threadInfo2.getLockOwnerId());
                    }
                    sb.append(')');
                    return;
                } else {
                    sb.append(" (on completion of thread ");
                    sb.append(threadInfo2.getLockOwnerId());
                    sb.append(')');
                    return;
                }
            case 3:
                StackTraceElement stackTraceElement2 = threadInfo2.getStackTrace()[0];
                String className2 = stackTraceElement2.getClassName();
                String methodName2 = stackTraceElement2.getMethodName();
                if (className2.equals("java.lang.Object") && methodName2.equals("wait")) {
                    sb.append(" (on object monitor");
                    if (threadInfo2.getLockOwnerName() != null) {
                        sb.append(" owned by \"");
                        sb.append(threadInfo2.getLockOwnerName());
                        sb.append("\" Id=");
                        sb.append(threadInfo2.getLockOwnerId());
                    }
                    sb.append(')');
                    return;
                } else if (className2.equals("java.lang.Thread") && methodName2.equals("sleep")) {
                    sb.append(" (sleeping)");
                    return;
                } else if (!className2.equals("java.lang.Thread") || !methodName2.equals("join")) {
                    sb.append(" (parking for lock");
                    if (threadInfo2.getLockOwnerName() != null) {
                        sb.append(" owned by \"");
                        sb.append(threadInfo2.getLockOwnerName());
                        sb.append("\" Id=");
                        sb.append(threadInfo2.getLockOwnerId());
                    }
                    sb.append(')');
                    return;
                } else {
                    sb.append(" (on completion of thread ");
                    sb.append(threadInfo2.getLockOwnerId());
                    sb.append(')');
                    return;
                }
            default:
                return;
        }
    }
}
