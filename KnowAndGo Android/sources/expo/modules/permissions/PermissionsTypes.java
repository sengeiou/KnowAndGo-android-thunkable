package expo.modules.permissions;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import p024io.nlopez.smartlocation.geofencing.providers.GeofencingGooglePlayServicesProvider;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, mo39786d2 = {"Lexpo/modules/permissions/PermissionsTypes;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "toString", "LOCATION", "CAMERA", "CONTACTS", "AUDIO_RECORDING", "CAMERA_ROLL", "CALENDAR", "SMS", "REMINDERS", "NOTIFICATIONS", "USER_FACING_NOTIFICATIONS", "SYSTEM_BRIGHTNESS", "expo-permissions_release"}, mo39787k = 1, mo39788mv = {1, 1, 15})
/* compiled from: PermissionsTypes.kt */
public enum PermissionsTypes {
    LOCATION(GeofencingGooglePlayServicesProvider.LOCATION_EXTRA_ID),
    CAMERA("camera"),
    CONTACTS("contacts"),
    AUDIO_RECORDING("audioRecording"),
    CAMERA_ROLL("cameraRoll"),
    CALENDAR("calendar"),
    SMS("sms"),
    REMINDERS("reminders"),
    NOTIFICATIONS("notifications"),
    USER_FACING_NOTIFICATIONS("userFacingNotifications"),
    SYSTEM_BRIGHTNESS("systemBrightness");
    
    @NotNull
    private final String type;

    private PermissionsTypes(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public String toString() {
        return this.type;
    }
}
