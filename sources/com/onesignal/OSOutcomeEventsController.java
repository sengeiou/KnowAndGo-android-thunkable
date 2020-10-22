package com.onesignal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.onesignal.OneSignal;
import com.onesignal.influence.model.OSInfluence;
import com.onesignal.influence.model.OSInfluenceType;
import com.onesignal.outcomes.OSOutcomeEventsFactory;
import com.onesignal.outcomes.model.OSOutcomeEventParams;
import com.onesignal.outcomes.model.OSOutcomeSource;
import com.onesignal.outcomes.model.OSOutcomeSourceBody;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class OSOutcomeEventsController {
    private static final String OS_SAVE_OUTCOMES = "OS_SAVE_OUTCOMES";
    private static final String OS_SAVE_UNIQUE_OUTCOME_NOTIFICATIONS = "OS_SAVE_UNIQUE_OUTCOME_NOTIFICATIONS";
    private static final String OS_SEND_SAVED_OUTCOMES = "OS_SEND_SAVED_OUTCOMES";
    @NonNull
    private final OSSessionManager osSessionManager;
    /* access modifiers changed from: private */
    @NonNull
    public final OSOutcomeEventsFactory outcomeEventsFactory;
    private Set<String> unattributedUniqueOutcomeEventsSentOnSession;

    public OSOutcomeEventsController(@NonNull OSSessionManager oSSessionManager, @NonNull OSOutcomeEventsFactory oSOutcomeEventsFactory) {
        this.osSessionManager = oSSessionManager;
        this.outcomeEventsFactory = oSOutcomeEventsFactory;
        initUniqueOutcomeEventsSentSets();
    }

    private void initUniqueOutcomeEventsSentSets() {
        this.unattributedUniqueOutcomeEventsSentOnSession = OSUtils.newConcurrentSet();
        Set<String> unattributedUniqueOutcomeEventsSent = this.outcomeEventsFactory.getRepository().getUnattributedUniqueOutcomeEventsSent();
        if (unattributedUniqueOutcomeEventsSent != null) {
            this.unattributedUniqueOutcomeEventsSentOnSession = unattributedUniqueOutcomeEventsSent;
        }
    }

    /* access modifiers changed from: package-private */
    public void cleanOutcomes() {
        OneSignal.Log(OneSignal.LOG_LEVEL.DEBUG, "OneSignal cleanOutcomes for session");
        this.unattributedUniqueOutcomeEventsSentOnSession = OSUtils.newConcurrentSet();
        saveUnattributedUniqueOutcomeEvents();
    }

    /* access modifiers changed from: package-private */
    public void sendSavedOutcomes() {
        new Thread(new Runnable() {
            public void run() {
                Thread.currentThread().setPriority(10);
                for (OSOutcomeEventParams access$100 : OSOutcomeEventsController.this.outcomeEventsFactory.getRepository().getSavedOutcomeEvents()) {
                    OSOutcomeEventsController.this.sendSavedOutcomeEvent(access$100);
                }
            }
        }, OS_SEND_SAVED_OUTCOMES).start();
    }

    /* access modifiers changed from: private */
    public void sendSavedOutcomeEvent(@NonNull final OSOutcomeEventParams oSOutcomeEventParams) {
        int deviceType = new OSUtils().getDeviceType();
        this.outcomeEventsFactory.getRepository().requestMeasureOutcomeEvent(OneSignal.appId, deviceType, oSOutcomeEventParams, new OneSignalApiResponseHandler() {
            public void onFailure(int i, String str, Throwable th) {
            }

            public void onSuccess(String str) {
                OSOutcomeEventsController.this.outcomeEventsFactory.getRepository().removeEvent(oSOutcomeEventParams);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void sendClickActionOutcomes(List<OSInAppMessageOutcome> list) {
        for (OSInAppMessageOutcome next : list) {
            String name = next.getName();
            if (next.isUnique()) {
                sendUniqueOutcomeEvent(name, (OneSignal.OutcomeCallback) null);
            } else if (next.getWeight() > 0.0f) {
                sendOutcomeEventWithValue(name, next.getWeight(), (OneSignal.OutcomeCallback) null);
            } else {
                sendOutcomeEvent(name, (OneSignal.OutcomeCallback) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void sendUniqueOutcomeEvent(@NonNull String str, @Nullable OneSignal.OutcomeCallback outcomeCallback) {
        sendUniqueOutcomeEvent(str, this.osSessionManager.getInfluences(), outcomeCallback);
    }

    /* access modifiers changed from: package-private */
    public void sendOutcomeEvent(@NonNull String str, @Nullable OneSignal.OutcomeCallback outcomeCallback) {
        sendAndCreateOutcomeEvent(str, 0.0f, this.osSessionManager.getInfluences(), outcomeCallback);
    }

    /* access modifiers changed from: package-private */
    public void sendOutcomeEventWithValue(@NonNull String str, float f, @Nullable OneSignal.OutcomeCallback outcomeCallback) {
        sendAndCreateOutcomeEvent(str, f, this.osSessionManager.getInfluences(), outcomeCallback);
    }

    private void sendUniqueOutcomeEvent(@NonNull String str, @NonNull List<OSInfluence> list, @Nullable OneSignal.OutcomeCallback outcomeCallback) {
        List<OSInfluence> removeDisabledInfluences = removeDisabledInfluences(list);
        if (removeDisabledInfluences.isEmpty()) {
            OneSignal.Log(OneSignal.LOG_LEVEL.DEBUG, "Unique Outcome disabled for current session");
            return;
        }
        boolean z = false;
        Iterator<OSInfluence> it = removeDisabledInfluences.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().getInfluenceType().isAttributed()) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z) {
            List<OSInfluence> uniqueIds = getUniqueIds(str, removeDisabledInfluences);
            if (uniqueIds == null) {
                OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
                OneSignal.Log(log_level, "Measure endpoint will not send because unique outcome already sent for: \nSessionInfluences: " + removeDisabledInfluences.toString() + "\nOutcome name: " + str);
                if (outcomeCallback != null) {
                    outcomeCallback.onSuccess((OutcomeEvent) null);
                    return;
                }
                return;
            }
            sendAndCreateOutcomeEvent(str, 0.0f, uniqueIds, outcomeCallback);
        } else if (this.unattributedUniqueOutcomeEventsSentOnSession.contains(str)) {
            OneSignal.LOG_LEVEL log_level2 = OneSignal.LOG_LEVEL.DEBUG;
            OneSignal.Log(log_level2, "Measure endpoint will not send because unique outcome already sent for: \nSession: " + OSInfluenceType.UNATTRIBUTED + "\nOutcome name: " + str);
            if (outcomeCallback != null) {
                outcomeCallback.onSuccess((OutcomeEvent) null);
            }
        } else {
            this.unattributedUniqueOutcomeEventsSentOnSession.add(str);
            sendAndCreateOutcomeEvent(str, 0.0f, removeDisabledInfluences, outcomeCallback);
        }
    }

    private void sendAndCreateOutcomeEvent(@NonNull String str, @NonNull float f, @NonNull List<OSInfluence> list, @Nullable OneSignal.OutcomeCallback outcomeCallback) {
        final long currentTimeMillis = System.currentTimeMillis() / 1000;
        int deviceType = new OSUtils().getDeviceType();
        String str2 = OneSignal.appId;
        OSOutcomeSourceBody oSOutcomeSourceBody = null;
        OSOutcomeSourceBody oSOutcomeSourceBody2 = null;
        boolean z = false;
        for (OSInfluence next : list) {
            switch (next.getInfluenceType()) {
                case DIRECT:
                    if (oSOutcomeSourceBody == null) {
                        oSOutcomeSourceBody = new OSOutcomeSourceBody();
                    }
                    oSOutcomeSourceBody = setSourceChannelIds(next, oSOutcomeSourceBody);
                    break;
                case INDIRECT:
                    if (oSOutcomeSourceBody2 == null) {
                        oSOutcomeSourceBody2 = new OSOutcomeSourceBody();
                    }
                    oSOutcomeSourceBody2 = setSourceChannelIds(next, oSOutcomeSourceBody2);
                    break;
                case UNATTRIBUTED:
                    z = true;
                    break;
                case DISABLED:
                    OneSignal.Log(OneSignal.LOG_LEVEL.VERBOSE, "Outcomes disabled for channel: " + next.getInfluenceChannel());
                    return;
            }
        }
        if (oSOutcomeSourceBody == null && oSOutcomeSourceBody2 == null && !z) {
            OneSignal.Log(OneSignal.LOG_LEVEL.VERBOSE, "Outcomes disabled for all channels");
            return;
        }
        OSOutcomeEventParams oSOutcomeEventParams = new OSOutcomeEventParams(str, new OSOutcomeSource(oSOutcomeSourceBody, oSOutcomeSourceBody2), f);
        final OSOutcomeEventParams oSOutcomeEventParams2 = oSOutcomeEventParams;
        final OneSignal.OutcomeCallback outcomeCallback2 = outcomeCallback;
        final String str3 = str;
        this.outcomeEventsFactory.getRepository().requestMeasureOutcomeEvent(str2, deviceType, oSOutcomeEventParams, new OneSignalApiResponseHandler() {
            public void onSuccess(String str) {
                OSOutcomeEventsController.this.saveUniqueOutcome(oSOutcomeEventParams2);
                if (outcomeCallback2 != null) {
                    outcomeCallback2.onSuccess(OutcomeEvent.fromOutcomeEventParamsV2toOutcomeEventV1(oSOutcomeEventParams2));
                }
            }

            public void onFailure(int i, String str, Throwable th) {
                new Thread(new Runnable() {
                    public void run() {
                        Thread.currentThread().setPriority(10);
                        oSOutcomeEventParams2.setTimestamp(currentTimeMillis);
                        OSOutcomeEventsController.this.outcomeEventsFactory.getRepository().saveOutcomeEvent(oSOutcomeEventParams2);
                    }
                }, OSOutcomeEventsController.OS_SAVE_OUTCOMES).start();
                OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.WARN;
                OneSignal.onesignalLog(log_level, "Sending outcome with name: " + str3 + " failed with status code: " + i + " and response: " + str + "\nOutcome event was cached and will be reattempted on app cold start");
                if (outcomeCallback2 != null) {
                    outcomeCallback2.onSuccess((OutcomeEvent) null);
                }
            }
        });
    }

    private OSOutcomeSourceBody setSourceChannelIds(OSInfluence oSInfluence, OSOutcomeSourceBody oSOutcomeSourceBody) {
        switch (oSInfluence.getInfluenceChannel()) {
            case IAM:
                oSOutcomeSourceBody.setInAppMessagesIds(oSInfluence.getIds());
                break;
            case NOTIFICATION:
                oSOutcomeSourceBody.setNotificationIds(oSInfluence.getIds());
                break;
        }
        return oSOutcomeSourceBody;
    }

    private List<OSInfluence> removeDisabledInfluences(List<OSInfluence> list) {
        ArrayList arrayList = new ArrayList(list);
        for (OSInfluence next : list) {
            if (next.getInfluenceType().isDisabled()) {
                OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.DEBUG;
                OneSignal.onesignalLog(log_level, "Outcomes disabled for channel: " + next.getInfluenceChannel().toString());
                arrayList.remove(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void saveUniqueOutcome(OSOutcomeEventParams oSOutcomeEventParams) {
        if (oSOutcomeEventParams.isUnattributed()) {
            saveUnattributedUniqueOutcomeEvents();
        } else {
            saveAttributedUniqueOutcomeNotifications(oSOutcomeEventParams);
        }
    }

    private void saveAttributedUniqueOutcomeNotifications(final OSOutcomeEventParams oSOutcomeEventParams) {
        new Thread(new Runnable() {
            public void run() {
                Thread.currentThread().setPriority(10);
                OSOutcomeEventsController.this.outcomeEventsFactory.getRepository().saveUniqueOutcomeNotifications(oSOutcomeEventParams);
            }
        }, OS_SAVE_UNIQUE_OUTCOME_NOTIFICATIONS).start();
    }

    private void saveUnattributedUniqueOutcomeEvents() {
        this.outcomeEventsFactory.getRepository().saveUnattributedUniqueOutcomeEventsSent(this.unattributedUniqueOutcomeEventsSentOnSession);
    }

    private List<OSInfluence> getUniqueIds(String str, List<OSInfluence> list) {
        List<OSInfluence> notCachedUniqueOutcome = this.outcomeEventsFactory.getRepository().getNotCachedUniqueOutcome(str, list);
        if (notCachedUniqueOutcome.size() > 0) {
            return notCachedUniqueOutcome;
        }
        return null;
    }
}
