package org.unimodules.interfaces.permissions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo39786d2 = {"Lorg/unimodules/interfaces/permissions/PermissionsResponse;", "", "status", "Lorg/unimodules/interfaces/permissions/PermissionsStatus;", "canAskAgain", "", "(Lorg/unimodules/interfaces/permissions/PermissionsStatus;Z)V", "getCanAskAgain", "()Z", "getStatus", "()Lorg/unimodules/interfaces/permissions/PermissionsStatus;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "unimodules-permissions-interface_release"}, mo39787k = 1, mo39788mv = {1, 1, 15})
/* compiled from: PermissionsResponse.kt */
public final class PermissionsResponse {
    @NotNull
    public static final String CAN_ASK_AGAIN_KEY = "canAskAgain";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXPIRES_KEY = "expires";
    @NotNull
    public static final String GRANTED_KEY = "granted";
    @NotNull
    public static final String PERMISSION_EXPIRES_NEVER = "never";
    @NotNull
    public static final String STATUS_KEY = "status";
    private final boolean canAskAgain;
    @NotNull
    private final PermissionsStatus status;

    public static /* synthetic */ PermissionsResponse copy$default(PermissionsResponse permissionsResponse, PermissionsStatus permissionsStatus, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            permissionsStatus = permissionsResponse.status;
        }
        if ((i & 2) != 0) {
            z = permissionsResponse.canAskAgain;
        }
        return permissionsResponse.copy(permissionsStatus, z);
    }

    @NotNull
    public final PermissionsStatus component1() {
        return this.status;
    }

    public final boolean component2() {
        return this.canAskAgain;
    }

    @NotNull
    public final PermissionsResponse copy(@NotNull PermissionsStatus permissionsStatus, boolean z) {
        Intrinsics.checkParameterIsNotNull(permissionsStatus, "status");
        return new PermissionsResponse(permissionsStatus, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PermissionsResponse) {
                PermissionsResponse permissionsResponse = (PermissionsResponse) obj;
                if (Intrinsics.areEqual((Object) this.status, (Object) permissionsResponse.status)) {
                    if (this.canAskAgain == permissionsResponse.canAskAgain) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        PermissionsStatus permissionsStatus = this.status;
        int hashCode = (permissionsStatus != null ? permissionsStatus.hashCode() : 0) * 31;
        boolean z = this.canAskAgain;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "PermissionsResponse(status=" + this.status + ", canAskAgain=" + this.canAskAgain + ")";
    }

    public PermissionsResponse(@NotNull PermissionsStatus permissionsStatus, boolean z) {
        Intrinsics.checkParameterIsNotNull(permissionsStatus, "status");
        this.status = permissionsStatus;
        this.canAskAgain = z;
    }

    @NotNull
    public final PermissionsStatus getStatus() {
        return this.status;
    }

    @Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo39786d2 = {"Lorg/unimodules/interfaces/permissions/PermissionsResponse$Companion;", "", "()V", "CAN_ASK_AGAIN_KEY", "", "EXPIRES_KEY", "GRANTED_KEY", "PERMISSION_EXPIRES_NEVER", "STATUS_KEY", "unimodules-permissions-interface_release"}, mo39787k = 1, mo39788mv = {1, 1, 15})
    /* compiled from: PermissionsResponse.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PermissionsResponse(PermissionsStatus permissionsStatus, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(permissionsStatus, (i & 2) != 0 ? true : z);
    }

    public final boolean getCanAskAgain() {
        return this.canAskAgain;
    }
}
