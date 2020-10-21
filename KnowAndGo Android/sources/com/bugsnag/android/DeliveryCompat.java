package com.bugsnag.android;

import androidx.annotation.NonNull;

class DeliveryCompat implements Delivery {
    volatile ErrorReportApiClient errorReportApiClient;
    volatile SessionTrackingApiClient sessionTrackingApiClient;

    DeliveryCompat() {
    }

    public void deliver(@NonNull SessionTrackingPayload sessionTrackingPayload, @NonNull Configuration configuration) throws DeliveryFailureException {
        if (this.sessionTrackingApiClient != null) {
            try {
                this.sessionTrackingApiClient.postSessionTrackingPayload(configuration.getSessionEndpoint(), sessionTrackingPayload, configuration.getSessionApiHeaders());
            } catch (Throwable th) {
                handleException(th);
            }
        }
    }

    public void deliver(@NonNull Report report, @NonNull Configuration configuration) throws DeliveryFailureException {
        if (this.errorReportApiClient != null) {
            try {
                this.errorReportApiClient.postReport(configuration.getEndpoint(), report, configuration.getErrorApiHeaders());
            } catch (Throwable th) {
                handleException(th);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void handleException(Throwable th) throws DeliveryFailureException {
        if (!(th instanceof NetworkException)) {
            Logger.warn("Ignoring Exception, this API is deprecated", th);
            return;
        }
        throw new DeliveryFailureException(th.getMessage(), th);
    }
}
