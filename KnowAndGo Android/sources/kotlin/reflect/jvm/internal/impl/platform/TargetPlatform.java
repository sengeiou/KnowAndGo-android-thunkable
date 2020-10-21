package kotlin.reflect.jvm.internal.impl.platform;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TargetPlatform.kt */
public class TargetPlatform implements Collection<SimplePlatform>, KMappedMarker {
    @NotNull
    private final Set<SimplePlatform> componentPlatforms;

    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends SimplePlatform> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(@NotNull SimplePlatform simplePlatform) {
        Intrinsics.checkParameterIsNotNull(simplePlatform, "element");
        return this.componentPlatforms.contains(simplePlatform);
    }

    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "elements");
        return this.componentPlatforms.containsAll(collection);
    }

    public int getSize() {
        return this.componentPlatforms.size();
    }

    public boolean isEmpty() {
        return this.componentPlatforms.isEmpty();
    }

    @NotNull
    public Iterator<SimplePlatform> iterator() {
        return this.componentPlatforms.iterator();
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return CollectionToArray.toArray(this, tArr);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof SimplePlatform) {
            return contains((SimplePlatform) obj);
        }
        return false;
    }

    @NotNull
    public final Set<SimplePlatform> getComponentPlatforms() {
        return this.componentPlatforms;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    @NotNull
    public String toString() {
        return PlatformUtilKt.getPresentableDescription(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof TargetPlatform) && !(!Intrinsics.areEqual((Object) this.componentPlatforms, (Object) ((TargetPlatform) obj).componentPlatforms))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.componentPlatforms.hashCode();
    }
}
