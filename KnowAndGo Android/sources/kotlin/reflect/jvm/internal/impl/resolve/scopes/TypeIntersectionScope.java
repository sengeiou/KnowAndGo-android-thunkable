package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.onesignal.OneSignalDbContract;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import p024io.nlopez.smartlocation.geofencing.providers.GeofencingGooglePlayServicesProvider;

/* compiled from: TypeIntersectionScope.kt */
public final class TypeIntersectionScope extends AbstractScopeAdapter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final ChainedMemberScope workerScope;

    @JvmStatic
    @NotNull
    public static final MemberScope create(@NotNull String str, @NotNull Collection<? extends KotlinType> collection) {
        return Companion.create(str, collection);
    }

    private TypeIntersectionScope(ChainedMemberScope chainedMemberScope) {
        this.workerScope = chainedMemberScope;
    }

    public /* synthetic */ TypeIntersectionScope(ChainedMemberScope chainedMemberScope, DefaultConstructorMarker defaultConstructorMarker) {
        this(chainedMemberScope);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public ChainedMemberScope getWorkerScope() {
        return this.workerScope;
    }

    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(lookupLocation, GeofencingGooglePlayServicesProvider.LOCATION_EXTRA_ID);
        return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedFunctions(name, lookupLocation), TypeIntersectionScope$getContributedFunctions$1.INSTANCE);
    }

    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(lookupLocation, GeofencingGooglePlayServicesProvider.LOCATION_EXTRA_ID);
        return OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedVariables(name, lookupLocation), TypeIntersectionScope$getContributedVariables$1.INSTANCE);
    }

    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(descriptorKindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(function1, "nameFilter");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object next : super.getContributedDescriptors(descriptorKindFilter, function1)) {
            if (((DeclarationDescriptor) next) instanceof CallableDescriptor) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list = (List) pair.component1();
        List list2 = (List) pair.component2();
        if (list != null) {
            return CollectionsKt.plus(OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(list, TypeIntersectionScope$getContributedDescriptors$2.INSTANCE), list2);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
    }

    /* compiled from: TypeIntersectionScope.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final MemberScope create(@NotNull String str, @NotNull Collection<? extends KotlinType> collection) {
            Intrinsics.checkParameterIsNotNull(str, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
            Intrinsics.checkParameterIsNotNull(collection, "types");
            Iterable<KotlinType> iterable = collection;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (KotlinType memberScope : iterable) {
                arrayList.add(memberScope.getMemberScope());
            }
            ChainedMemberScope chainedMemberScope = new ChainedMemberScope(str, (List) arrayList);
            if (collection.size() <= 1) {
                return chainedMemberScope;
            }
            return new TypeIntersectionScope(chainedMemberScope, (DefaultConstructorMarker) null);
        }
    }
}
