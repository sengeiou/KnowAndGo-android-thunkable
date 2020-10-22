package expo.modules.permissions;

import android.content.Context;
import android.os.Bundle;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.permissions.requesters.LocationRequester;
import expo.modules.permissions.requesters.NotificationRequester;
import expo.modules.permissions.requesters.PermissionRequester;
import expo.modules.permissions.requesters.RemindersRequester;
import expo.modules.permissions.requesters.SimpleRequester;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.unimodules.core.ExportedModule;
import org.unimodules.core.ModuleRegistry;
import org.unimodules.core.Promise;
import org.unimodules.core.interfaces.ExpoMethod;
import org.unimodules.interfaces.permissions.Permissions;
import org.unimodules.interfaces.permissions.PermissionsResponse;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u000b\u001a\u00020\f2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000ej\b\u0012\u0004\u0012\u00020\t`\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0014H\u0002¢\u0006\u0002\u0010\u0015J(\u0010\u0016\u001a\u00020\f2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000ej\b\u0012\u0004\u0012\u00020\t`\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0017\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J*\u0010\u001d\u001a\u00020\u001e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u00142\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020 0\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX.¢\u0006\u0002\n\u0000¨\u0006!"}, mo39786d2 = {"Lexpo/modules/permissions/PermissionsModule;", "Lorg/unimodules/core/ExportedModule;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mPermissions", "Lorg/unimodules/interfaces/permissions/Permissions;", "mRequesters", "", "", "Lexpo/modules/permissions/requesters/PermissionRequester;", "askAsync", "", "requestedPermissionsTypes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "promise", "Lorg/unimodules/core/Promise;", "getAndroidPermissionsFromList", "", "", "(Ljava/util/List;)[Ljava/lang/String;", "getAsync", "getName", "getRequester", "permissionType", "onCreate", "moduleRegistry", "Lorg/unimodules/core/ModuleRegistry;", "parsePermissionsResponse", "Landroid/os/Bundle;", "permissionMap", "Lorg/unimodules/interfaces/permissions/PermissionsResponse;", "expo-permissions_release"}, mo39787k = 1, mo39788mv = {1, 1, 15})
/* compiled from: PermissionsModule.kt */
public final class PermissionsModule extends ExportedModule {
    private Permissions mPermissions;
    private Map<String, ? extends PermissionRequester> mRequesters;

    @NotNull
    public String getName() {
        return "ExpoPermissions";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PermissionsModule(@NotNull Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    public void onCreate(@NotNull ModuleRegistry moduleRegistry) throws IllegalStateException {
        SimpleRequester simpleRequester;
        Intrinsics.checkParameterIsNotNull(moduleRegistry, "moduleRegistry");
        Permissions permissions = (Permissions) moduleRegistry.getModule(Permissions.class);
        if (permissions != null) {
            this.mPermissions = permissions;
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            NotificationRequester notificationRequester = new NotificationRequester(context);
            Permissions permissions2 = this.mPermissions;
            if (permissions2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPermissions");
            }
            if (permissions2.isPermissionPresentInManifest("android.permission.WRITE_CONTACTS")) {
                simpleRequester = new SimpleRequester("android.permission.WRITE_CONTACTS", "android.permission.READ_CONTACTS");
            } else {
                simpleRequester = new SimpleRequester("android.permission.READ_CONTACTS");
            }
            this.mRequesters = MapsKt.mapOf(TuplesKt.m2473to(PermissionsTypes.LOCATION.getType(), new LocationRequester()), TuplesKt.m2473to(PermissionsTypes.CAMERA.getType(), new SimpleRequester("android.permission.CAMERA")), TuplesKt.m2473to(PermissionsTypes.CONTACTS.getType(), simpleRequester), TuplesKt.m2473to(PermissionsTypes.AUDIO_RECORDING.getType(), new SimpleRequester("android.permission.RECORD_AUDIO")), TuplesKt.m2473to(PermissionsTypes.CAMERA_ROLL.getType(), new SimpleRequester("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE")), TuplesKt.m2473to(PermissionsTypes.CALENDAR.getType(), new SimpleRequester("android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR")), TuplesKt.m2473to(PermissionsTypes.SMS.getType(), new SimpleRequester("android.permission.READ_SMS")), TuplesKt.m2473to(PermissionsTypes.NOTIFICATIONS.getType(), notificationRequester), TuplesKt.m2473to(PermissionsTypes.USER_FACING_NOTIFICATIONS.getType(), notificationRequester), TuplesKt.m2473to(PermissionsTypes.SYSTEM_BRIGHTNESS.getType(), new SimpleRequester("android.permission.WRITE_SETTINGS")), TuplesKt.m2473to(PermissionsTypes.REMINDERS.getType(), new RemindersRequester()));
            return;
        }
        throw new IllegalStateException("Couldn't find implementation for Permissions interface.");
    }

    private final PermissionRequester getRequester(String str) throws IllegalStateException {
        Map<String, ? extends PermissionRequester> map = this.mRequesters;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRequesters");
        }
        PermissionRequester permissionRequester = (PermissionRequester) map.get(str);
        if (permissionRequester != null) {
            return permissionRequester;
        }
        throw new IllegalStateException("Unrecognized permission type: " + str);
    }

    @ExpoMethod
    public final void getAsync(@NotNull ArrayList<String> arrayList, @NotNull Promise promise) {
        Intrinsics.checkParameterIsNotNull(arrayList, "requestedPermissionsTypes");
        Intrinsics.checkParameterIsNotNull(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            Permissions permissions = this.mPermissions;
            if (permissions == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPermissions");
            }
            String[] androidPermissionsFromList = getAndroidPermissionsFromList(arrayList);
            permissions.getPermissions(new PermissionsModule$getAsync$1(this, promise, arrayList), (String[]) Arrays.copyOf(androidPermissionsFromList, androidPermissionsFromList.length));
        } catch (IllegalStateException e) {
            promise.reject("E_PERMISSIONS_UNKNOWN", "Failed to get permissions", e);
        }
    }

    @ExpoMethod
    public final void askAsync(@NotNull ArrayList<String> arrayList, @NotNull Promise promise) {
        Intrinsics.checkParameterIsNotNull(arrayList, "requestedPermissionsTypes");
        Intrinsics.checkParameterIsNotNull(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            Permissions permissions = this.mPermissions;
            if (permissions == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPermissions");
            }
            String[] androidPermissionsFromList = getAndroidPermissionsFromList(arrayList);
            permissions.askForPermissions(new PermissionsModule$askAsync$1(this, promise, arrayList), (String[]) Arrays.copyOf(androidPermissionsFromList, androidPermissionsFromList.length));
        } catch (IllegalStateException e) {
            promise.reject("E_PERMISSIONS_UNKNOWN", "Failed to get permissions", e);
        }
    }

    /* access modifiers changed from: private */
    public final Bundle parsePermissionsResponse(List<String> list, Map<String, PermissionsResponse> map) throws IllegalStateException {
        Bundle bundle = new Bundle();
        for (String str : list) {
            bundle.putBundle(str, getRequester(str).parseAndroidPermissions(map));
        }
        return bundle;
    }

    private final String[] getAndroidPermissionsFromList(List<String> list) throws IllegalStateException {
        Iterable<String> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String requester : iterable) {
            arrayList.add(getRequester(requester).getAndroidPermissions());
        }
        Iterator it = ((List) arrayList).iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                next = CollectionsKt.plus((List) next, (List) it.next());
            }
            Object[] array = ((Collection) next).toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }
}
