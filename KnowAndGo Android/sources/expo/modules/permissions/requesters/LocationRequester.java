package expo.modules.permissions.requesters;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u001c\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, mo39786d2 = {"Lexpo/modules/permissions/requesters/LocationRequester;", "Lexpo/modules/permissions/requesters/PermissionRequester;", "()V", "getAndroidPermissions", "", "", "parseAndroidPermissions", "Landroid/os/Bundle;", "permissionsResponse", "", "Lorg/unimodules/interfaces/permissions/PermissionsResponse;", "expo-permissions_release"}, mo39787k = 1, mo39788mv = {1, 1, 15})
/* compiled from: LocationRequester.kt */
public final class LocationRequester implements PermissionRequester {
    @NotNull
    public List<String> getAndroidPermissions() {
        return CollectionsKt.listOf("android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION");
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [java.util.Map, java.lang.Object, java.util.Map<java.lang.String, org.unimodules.interfaces.permissions.PermissionsResponse>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.Bundle parseAndroidPermissions(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, org.unimodules.interfaces.permissions.PermissionsResponse> r9) {
        /*
            r8 = this;
            java.lang.String r0 = "permissionsResponse"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r9, r0)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "none"
            java.lang.String r2 = "android.permission.ACCESS_FINE_LOCATION"
            java.lang.Object r2 = kotlin.collections.MapsKt.getValue(r9, r2)
            org.unimodules.interfaces.permissions.PermissionsResponse r2 = (org.unimodules.interfaces.permissions.PermissionsResponse) r2
            java.lang.String r3 = "android.permission.ACCESS_COARSE_LOCATION"
            java.lang.Object r9 = kotlin.collections.MapsKt.getValue(r9, r3)
            org.unimodules.interfaces.permissions.PermissionsResponse r9 = (org.unimodules.interfaces.permissions.PermissionsResponse) r9
            boolean r3 = r9.getCanAskAgain()
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x002c
            boolean r3 = r9.getCanAskAgain()
            if (r3 == 0) goto L_0x002c
            r3 = 1
            goto L_0x002d
        L_0x002c:
            r3 = 0
        L_0x002d:
            org.unimodules.interfaces.permissions.PermissionsStatus r6 = r9.getStatus()
            org.unimodules.interfaces.permissions.PermissionsStatus r7 = org.unimodules.interfaces.permissions.PermissionsStatus.GRANTED
            if (r6 == r7) goto L_0x003f
            org.unimodules.interfaces.permissions.PermissionsStatus r6 = r2.getStatus()
            org.unimodules.interfaces.permissions.PermissionsStatus r7 = org.unimodules.interfaces.permissions.PermissionsStatus.GRANTED
            if (r6 != r7) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r4 = 0
        L_0x003f:
            java.lang.String r5 = "status"
            org.unimodules.interfaces.permissions.PermissionsStatus r6 = r2.getStatus()
            org.unimodules.interfaces.permissions.PermissionsStatus r7 = org.unimodules.interfaces.permissions.PermissionsStatus.GRANTED
            if (r6 != r7) goto L_0x0052
            java.lang.String r1 = "fine"
            org.unimodules.interfaces.permissions.PermissionsStatus r9 = org.unimodules.interfaces.permissions.PermissionsStatus.GRANTED
            java.lang.String r9 = r9.getStatus()
            goto L_0x0080
        L_0x0052:
            org.unimodules.interfaces.permissions.PermissionsStatus r6 = r9.getStatus()
            org.unimodules.interfaces.permissions.PermissionsStatus r7 = org.unimodules.interfaces.permissions.PermissionsStatus.GRANTED
            if (r6 != r7) goto L_0x0063
            java.lang.String r1 = "coarse"
            org.unimodules.interfaces.permissions.PermissionsStatus r9 = org.unimodules.interfaces.permissions.PermissionsStatus.GRANTED
            java.lang.String r9 = r9.getStatus()
            goto L_0x0080
        L_0x0063:
            org.unimodules.interfaces.permissions.PermissionsStatus r2 = r2.getStatus()
            org.unimodules.interfaces.permissions.PermissionsStatus r6 = org.unimodules.interfaces.permissions.PermissionsStatus.DENIED
            if (r2 != r6) goto L_0x007a
            org.unimodules.interfaces.permissions.PermissionsStatus r9 = r9.getStatus()
            org.unimodules.interfaces.permissions.PermissionsStatus r2 = org.unimodules.interfaces.permissions.PermissionsStatus.DENIED
            if (r9 != r2) goto L_0x007a
            org.unimodules.interfaces.permissions.PermissionsStatus r9 = org.unimodules.interfaces.permissions.PermissionsStatus.DENIED
            java.lang.String r9 = r9.getStatus()
            goto L_0x0080
        L_0x007a:
            org.unimodules.interfaces.permissions.PermissionsStatus r9 = org.unimodules.interfaces.permissions.PermissionsStatus.UNDETERMINED
            java.lang.String r9 = r9.getStatus()
        L_0x0080:
            r0.putString(r5, r9)
            java.lang.String r9 = "expires"
            java.lang.String r2 = "never"
            r0.putString(r9, r2)
            java.lang.String r9 = "canAskAgain"
            r0.putBoolean(r9, r3)
            java.lang.String r9 = "granted"
            r0.putBoolean(r9, r4)
            java.lang.String r9 = "android"
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            java.lang.String r3 = "scope"
            r2.putString(r3, r1)
            r0.putBundle(r9, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.permissions.requesters.LocationRequester.parseAndroidPermissions(java.util.Map):android.os.Bundle");
    }
}
