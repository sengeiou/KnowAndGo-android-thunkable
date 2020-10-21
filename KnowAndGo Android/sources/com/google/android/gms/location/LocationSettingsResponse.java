package com.google.android.gms.location;

import com.google.android.gms.common.api.C1618Response;

public class LocationSettingsResponse extends C1618Response<LocationSettingsResult> {
    public LocationSettingsStates getLocationSettingsStates() {
        return ((LocationSettingsResult) getResult()).getLocationSettingsStates();
    }
}
