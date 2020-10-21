package com.bugsnag.android;

import com.bugsnag.RuntimeVersions;

public class InternalHooks {
    public static void configureClient(Client client) {
        client.getConfig().addBeforeSendSession(new BeforeSendSession() {
            public void beforeSendSession(SessionTrackingPayload sessionTrackingPayload) {
                RuntimeVersions.addRuntimeVersions(sessionTrackingPayload.getDevice());
            }
        });
        client.getConfig().beforeSend(new BeforeSend() {
            public boolean run(Report report) {
                RuntimeVersions.addRuntimeVersions(report.getError().getDeviceData());
                return true;
            }
        });
    }
}
