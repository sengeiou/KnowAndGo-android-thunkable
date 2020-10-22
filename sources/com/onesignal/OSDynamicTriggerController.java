package com.onesignal;

import com.onesignal.OSTrigger;
import com.onesignal.OneSignal;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

class OSDynamicTriggerController {
    private static final long DEFAULT_LAST_IN_APP_TIME_AGO = 999999;
    private static final double REQUIRED_ACCURACY = 0.3d;
    static Date sessionLaunchTime = new Date();
    /* access modifiers changed from: private */
    public final OSDynamicTriggerControllerObserver observer;
    /* access modifiers changed from: private */
    public final ArrayList<String> scheduledMessages = new ArrayList<>();

    interface OSDynamicTriggerControllerObserver {
        void messageTriggerConditionChanged();
    }

    OSDynamicTriggerController(OSDynamicTriggerControllerObserver oSDynamicTriggerControllerObserver) {
        this.observer = oSDynamicTriggerControllerObserver;
    }

    /* access modifiers changed from: package-private */
    public boolean dynamicTriggerShouldFire(final OSTrigger oSTrigger) {
        long j;
        if (oSTrigger.value == null) {
            return false;
        }
        synchronized (this.scheduledMessages) {
            if (!(oSTrigger.value instanceof Number)) {
                return false;
            }
            switch (oSTrigger.kind) {
                case SESSION_TIME:
                    j = new Date().getTime() - sessionLaunchTime.getTime();
                    break;
                case TIME_SINCE_LAST_IN_APP:
                    if (!OSInAppMessageController.getController().isInAppMessageShowing()) {
                        Date date = OSInAppMessageController.getController().lastTimeInAppDismissed;
                        if (date != null) {
                            j = new Date().getTime() - date.getTime();
                            break;
                        } else {
                            j = DEFAULT_LAST_IN_APP_TIME_AGO;
                            break;
                        }
                    } else {
                        return false;
                    }
                default:
                    j = 0;
                    break;
            }
            long doubleValue = (long) (((Number) oSTrigger.value).doubleValue() * 1000.0d);
            if (evaluateTimeIntervalWithOperator((double) doubleValue, (double) j, oSTrigger.operatorType)) {
                return true;
            }
            long j2 = doubleValue - j;
            if (j2 <= 0) {
                return false;
            }
            if (this.scheduledMessages.contains(oSTrigger.triggerId)) {
                return false;
            }
            OSDynamicTriggerTimer.scheduleTrigger(new TimerTask() {
                public void run() {
                    OSDynamicTriggerController.this.scheduledMessages.remove(oSTrigger.triggerId);
                    OSDynamicTriggerController.this.observer.messageTriggerConditionChanged();
                }
            }, oSTrigger.triggerId, j2);
            this.scheduledMessages.add(oSTrigger.triggerId);
            return false;
        }
    }

    private static boolean evaluateTimeIntervalWithOperator(double d, double d2, OSTrigger.OSTriggerOperator oSTriggerOperator) {
        switch (oSTriggerOperator) {
            case LESS_THAN:
                if (d2 < d) {
                    return true;
                }
                return false;
            case LESS_THAN_OR_EQUAL_TO:
                if (d2 <= d || roughlyEqual(d, d2)) {
                    return true;
                }
                return false;
            case GREATER_THAN:
                if (d2 > d) {
                    return true;
                }
                return false;
            case GREATER_THAN_OR_EQUAL_TO:
                if (d2 >= d || roughlyEqual(d, d2)) {
                    return true;
                }
                return false;
            case EQUAL_TO:
                return roughlyEqual(d, d2);
            case NOT_EQUAL_TO:
                return !roughlyEqual(d, d2);
            default:
                OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.ERROR;
                OneSignal.onesignalLog(log_level, "Attempted to apply an invalid operator on a time-based in-app-message trigger: " + oSTriggerOperator.toString());
                return false;
        }
    }

    private static boolean roughlyEqual(double d, double d2) {
        return Math.abs(d - d2) < REQUIRED_ACCURACY;
    }
}
