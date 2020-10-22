package expo.modules.permissions.requesters;

import android.os.Bundle;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.unimodules.interfaces.permissions.PermissionsResponse;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u001c\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bH&¨\u0006\n"}, mo39786d2 = {"Lexpo/modules/permissions/requesters/PermissionRequester;", "", "getAndroidPermissions", "", "", "parseAndroidPermissions", "Landroid/os/Bundle;", "permissionsResponse", "", "Lorg/unimodules/interfaces/permissions/PermissionsResponse;", "expo-permissions_release"}, mo39787k = 1, mo39788mv = {1, 1, 15})
/* compiled from: PermissionRequester.kt */
public interface PermissionRequester {
    @NotNull
    List<String> getAndroidPermissions();

    @NotNull
    Bundle parseAndroidPermissions(@NotNull Map<String, PermissionsResponse> map);
}
