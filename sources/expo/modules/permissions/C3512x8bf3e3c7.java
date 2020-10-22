package expo.modules.permissions;

import com.facebook.react.modules.core.PermissionListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.unimodules.interfaces.permissions.PermissionsResponseListener;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032,\u0010\u0004\u001a(\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0014\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, mo39786d2 = {"<anonymous>", "", "requestCode", "", "receivePermissions", "", "", "kotlin.jvm.PlatformType", "grantResults", "", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)Z", "expo/modules/permissions/PermissionsService$delegateRequestToActivity$1$1"}, mo39787k = 3, mo39788mv = {1, 1, 15})
/* renamed from: expo.modules.permissions.PermissionsService$delegateRequestToActivity$$inlined$run$lambda$1 */
/* compiled from: PermissionsService.kt */
final class C3512x8bf3e3c7 implements PermissionListener {
    final /* synthetic */ PermissionsResponseListener $listener$inlined;
    final /* synthetic */ String[] $permissions$inlined;
    final /* synthetic */ PermissionsService this$0;

    C3512x8bf3e3c7(PermissionsService permissionsService, String[] strArr, PermissionsResponseListener permissionsResponseListener) {
        this.this$0 = permissionsService;
        this.$permissions$inlined = strArr;
        this.$listener$inlined = permissionsResponseListener;
    }

    public final boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 13) {
            PermissionsResponseListener permissionsResponseListener = this.$listener$inlined;
            PermissionsService permissionsService = this.this$0;
            Intrinsics.checkExpressionValueIsNotNull(strArr, "receivePermissions");
            Intrinsics.checkExpressionValueIsNotNull(iArr, "grantResults");
            permissionsResponseListener.onResult(permissionsService.parseNativeResult(strArr, iArr));
            return true;
        }
        PermissionsResponseListener permissionsResponseListener2 = this.$listener$inlined;
        PermissionsService permissionsService2 = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(strArr, "receivePermissions");
        int length = strArr.length;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr2[i2] = -1;
        }
        permissionsResponseListener2.onResult(permissionsService2.parseNativeResult(strArr, iArr2));
        return false;
    }
}
