package expo.modules.permissions;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.unimodules.core.Promise;
import org.unimodules.interfaces.permissions.PermissionsResponse;
import org.unimodules.interfaces.permissions.PermissionsResponseListener;
import org.unimodules.interfaces.permissions.PermissionsStatus;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, mo39786d2 = {"<anonymous>", "", "permissionsMap", "", "", "Lorg/unimodules/interfaces/permissions/PermissionsResponse;", "onResult"}, mo39787k = 3, mo39788mv = {1, 1, 15})
/* compiled from: PermissionsService.kt */
final class PermissionsService$getPermissionsWithPromise$1 implements PermissionsResponseListener {
    final /* synthetic */ Promise $promise;

    PermissionsService$getPermissionsWithPromise$1(Promise promise) {
        this.$promise = promise;
    }

    public final void onResult(@NotNull Map<String, PermissionsResponse> map) {
        boolean z;
        boolean z2;
        String str;
        boolean z3;
        boolean z4;
        Intrinsics.checkParameterIsNotNull(map, "permissionsMap");
        boolean z5 = true;
        if (!map.isEmpty()) {
            Iterator<Map.Entry<String, PermissionsResponse>> it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((PermissionsResponse) it.next().getValue()).getStatus() == PermissionsStatus.GRANTED) {
                    z4 = true;
                    continue;
                } else {
                    z4 = false;
                    continue;
                }
                if (!z4) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (!map.isEmpty()) {
            Iterator<Map.Entry<String, PermissionsResponse>> it2 = map.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (((PermissionsResponse) it2.next().getValue()).getStatus() == PermissionsStatus.DENIED) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
                if (!z3) {
                    z2 = false;
                    break;
                }
            }
        }
        z2 = true;
        if (!map.isEmpty()) {
            Iterator<Map.Entry<String, PermissionsResponse>> it3 = map.entrySet().iterator();
            while (true) {
                if (it3.hasNext()) {
                    if (!((PermissionsResponse) it3.next().getValue()).getCanAskAgain()) {
                        z5 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        Promise promise = this.$promise;
        Bundle bundle = new Bundle();
        bundle.putString(PermissionsResponse.EXPIRES_KEY, "never");
        if (z) {
            str = PermissionsStatus.GRANTED.getStatus();
        } else if (z2) {
            str = PermissionsStatus.DENIED.getStatus();
        } else {
            str = PermissionsStatus.UNDETERMINED.getStatus();
        }
        bundle.putString("status", str);
        bundle.putBoolean(PermissionsResponse.CAN_ASK_AGAIN_KEY, z5);
        bundle.putBoolean(PermissionsResponse.GRANTED_KEY, z);
        promise.resolve(bundle);
    }
}
