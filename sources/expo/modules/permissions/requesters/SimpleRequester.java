package expo.modules.permissions.requesters;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u001b\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, mo39786d2 = {"Lexpo/modules/permissions/requesters/SimpleRequester;", "Lexpo/modules/permissions/requesters/PermissionRequester;", "permission", "", "", "([Ljava/lang/String;)V", "getPermission", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getAndroidPermissions", "", "parseAndroidPermissions", "Landroid/os/Bundle;", "permissionsResponse", "", "Lorg/unimodules/interfaces/permissions/PermissionsResponse;", "expo-permissions_release"}, mo39787k = 1, mo39788mv = {1, 1, 15})
/* compiled from: SimpleRequester.kt */
public final class SimpleRequester implements PermissionRequester {
    @NotNull
    private final String[] permission;

    public SimpleRequester(@NotNull String... strArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permission");
        this.permission = strArr;
    }

    @NotNull
    public final String[] getPermission() {
        return this.permission;
    }

    @NotNull
    public List<String> getAndroidPermissions() {
        return ArraysKt.toList((T[]) this.permission);
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [java.util.Map, java.lang.Object, java.util.Map<java.lang.String, org.unimodules.interfaces.permissions.PermissionsResponse>] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d7  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.Bundle parseAndroidPermissions(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, org.unimodules.interfaces.permissions.PermissionsResponse> r8) {
        /*
            r7 = this;
            java.lang.String r0 = "permissionsResponse"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.util.List r1 = r7.getAndroidPermissions()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r2 = r1 instanceof java.util.Collection
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0021
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0021
        L_0x001f:
            r1 = 1
            goto L_0x0045
        L_0x0021:
            java.util.Iterator r1 = r1.iterator()
        L_0x0025:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x001f
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r2 = kotlin.collections.MapsKt.getValue(r8, r2)
            org.unimodules.interfaces.permissions.PermissionsResponse r2 = (org.unimodules.interfaces.permissions.PermissionsResponse) r2
            org.unimodules.interfaces.permissions.PermissionsStatus r2 = r2.getStatus()
            org.unimodules.interfaces.permissions.PermissionsStatus r5 = org.unimodules.interfaces.permissions.PermissionsStatus.GRANTED
            if (r2 != r5) goto L_0x0041
            r2 = 1
            goto L_0x0042
        L_0x0041:
            r2 = 0
        L_0x0042:
            if (r2 != 0) goto L_0x0025
            r1 = 0
        L_0x0045:
            if (r1 == 0) goto L_0x004a
            org.unimodules.interfaces.permissions.PermissionsStatus r1 = org.unimodules.interfaces.permissions.PermissionsStatus.GRANTED
            goto L_0x008a
        L_0x004a:
            java.util.List r1 = r7.getAndroidPermissions()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r2 = r1 instanceof java.util.Collection
            if (r2 == 0) goto L_0x005f
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x005f
        L_0x005d:
            r1 = 1
            goto L_0x0083
        L_0x005f:
            java.util.Iterator r1 = r1.iterator()
        L_0x0063:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x005d
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r2 = kotlin.collections.MapsKt.getValue(r8, r2)
            org.unimodules.interfaces.permissions.PermissionsResponse r2 = (org.unimodules.interfaces.permissions.PermissionsResponse) r2
            org.unimodules.interfaces.permissions.PermissionsStatus r2 = r2.getStatus()
            org.unimodules.interfaces.permissions.PermissionsStatus r5 = org.unimodules.interfaces.permissions.PermissionsStatus.DENIED
            if (r2 != r5) goto L_0x007f
            r2 = 1
            goto L_0x0080
        L_0x007f:
            r2 = 0
        L_0x0080:
            if (r2 != 0) goto L_0x0063
            r1 = 0
        L_0x0083:
            if (r1 == 0) goto L_0x0088
            org.unimodules.interfaces.permissions.PermissionsStatus r1 = org.unimodules.interfaces.permissions.PermissionsStatus.DENIED
            goto L_0x008a
        L_0x0088:
            org.unimodules.interfaces.permissions.PermissionsStatus r1 = org.unimodules.interfaces.permissions.PermissionsStatus.UNDETERMINED
        L_0x008a:
            java.lang.String r2 = "status"
            java.lang.String r5 = r1.getStatus()
            r0.putString(r2, r5)
            java.lang.String r2 = "expires"
            java.lang.String r5 = "never"
            r0.putString(r2, r5)
            java.lang.String r2 = "canAskAgain"
            java.util.List r5 = r7.getAndroidPermissions()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            boolean r6 = r5 instanceof java.util.Collection
            if (r6 == 0) goto L_0x00b1
            r6 = r5
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x00b1
        L_0x00af:
            r8 = 1
            goto L_0x00ce
        L_0x00b1:
            java.util.Iterator r5 = r5.iterator()
        L_0x00b5:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00af
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = kotlin.collections.MapsKt.getValue(r8, r6)
            org.unimodules.interfaces.permissions.PermissionsResponse r6 = (org.unimodules.interfaces.permissions.PermissionsResponse) r6
            boolean r6 = r6.getCanAskAgain()
            if (r6 != 0) goto L_0x00b5
            r8 = 0
        L_0x00ce:
            r0.putBoolean(r2, r8)
            java.lang.String r8 = "granted"
            org.unimodules.interfaces.permissions.PermissionsStatus r2 = org.unimodules.interfaces.permissions.PermissionsStatus.GRANTED
            if (r1 != r2) goto L_0x00d8
            r3 = 1
        L_0x00d8:
            r0.putBoolean(r8, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.permissions.requesters.SimpleRequester.parseAndroidPermissions(java.util.Map):android.os.Bundle");
    }
}
