package com.onesignal.outcomes;

import com.onesignal.OSLogger;
import com.onesignal.OneSignalApiResponseHandler;
import com.onesignal.OutcomeEvent;
import com.onesignal.outcomes.domain.OutcomeEventsService;
import com.onesignal.outcomes.model.OSOutcomeEventParams;
import org.json.JSONException;
import org.json.JSONObject;

class OSOutcomeEventsV1Repository extends OSOutcomeEventsRepository {
    private static final String DIRECT = "direct";

    OSOutcomeEventsV1Repository(OSLogger oSLogger, OSOutcomeEventsCache oSOutcomeEventsCache, OutcomeEventsService outcomeEventsService) {
        super(oSLogger, oSOutcomeEventsCache, outcomeEventsService);
    }

    public void requestMeasureOutcomeEvent(String str, int i, OSOutcomeEventParams oSOutcomeEventParams, OneSignalApiResponseHandler oneSignalApiResponseHandler) {
        OutcomeEvent fromOutcomeEventParamsV2toOutcomeEventV1 = OutcomeEvent.fromOutcomeEventParamsV2toOutcomeEventV1(oSOutcomeEventParams);
        switch (fromOutcomeEventParamsV2toOutcomeEventV1.getSession()) {
            case DIRECT:
                requestMeasureDirectOutcomeEvent(str, i, fromOutcomeEventParamsV2toOutcomeEventV1, oneSignalApiResponseHandler);
                return;
            case INDIRECT:
                requestMeasureIndirectOutcomeEvent(str, i, fromOutcomeEventParamsV2toOutcomeEventV1, oneSignalApiResponseHandler);
                return;
            case UNATTRIBUTED:
                requestMeasureUnattributedOutcomeEvent(str, i, fromOutcomeEventParamsV2toOutcomeEventV1, oneSignalApiResponseHandler);
                return;
            default:
                return;
        }
    }

    private void requestMeasureDirectOutcomeEvent(String str, int i, OutcomeEvent outcomeEvent, OneSignalApiResponseHandler oneSignalApiResponseHandler) {
        try {
            JSONObject jSONObjectForMeasure = outcomeEvent.toJSONObjectForMeasure();
            jSONObjectForMeasure.put("app_id", str);
            jSONObjectForMeasure.put("device_type", i);
            jSONObjectForMeasure.put(DIRECT, true);
            this.outcomeEventsService.sendOutcomeEvent(jSONObjectForMeasure, oneSignalApiResponseHandler);
        } catch (JSONException e) {
            this.logger.error("Generating direct outcome:JSON Failed.", e);
        }
    }

    private void requestMeasureIndirectOutcomeEvent(String str, int i, OutcomeEvent outcomeEvent, OneSignalApiResponseHandler oneSignalApiResponseHandler) {
        try {
            JSONObject jSONObjectForMeasure = outcomeEvent.toJSONObjectForMeasure();
            jSONObjectForMeasure.put("app_id", str);
            jSONObjectForMeasure.put("device_type", i);
            jSONObjectForMeasure.put(DIRECT, false);
            this.outcomeEventsService.sendOutcomeEvent(jSONObjectForMeasure, oneSignalApiResponseHandler);
        } catch (JSONException e) {
            this.logger.error("Generating indirect outcome:JSON Failed.", e);
        }
    }

    private void requestMeasureUnattributedOutcomeEvent(String str, int i, OutcomeEvent outcomeEvent, OneSignalApiResponseHandler oneSignalApiResponseHandler) {
        try {
            JSONObject jSONObjectForMeasure = outcomeEvent.toJSONObjectForMeasure();
            jSONObjectForMeasure.put("app_id", str);
            jSONObjectForMeasure.put("device_type", i);
            this.outcomeEventsService.sendOutcomeEvent(jSONObjectForMeasure, oneSignalApiResponseHandler);
        } catch (JSONException e) {
            this.logger.error("Generating unattributed outcome:JSON Failed.", e);
        }
    }
}
