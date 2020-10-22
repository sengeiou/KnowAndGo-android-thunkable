package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.Closeable;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p026io.CloseableKt;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: BuiltInsPackageFragmentImpl.kt */
public final class BuiltInsPackageFragmentImpl extends DeserializedPackageFragmentImpl implements BuiltInsPackageFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean isFallback;

    public /* synthetic */ BuiltInsPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf.PackageFragment packageFragment, BuiltInsBinaryVersion builtInsBinaryVersion, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(fqName, storageManager, moduleDescriptor, packageFragment, builtInsBinaryVersion, z);
    }

    private BuiltInsPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf.PackageFragment packageFragment, BuiltInsBinaryVersion builtInsBinaryVersion, boolean z) {
        super(fqName, storageManager, moduleDescriptor, packageFragment, builtInsBinaryVersion, (DeserializedContainerSource) null);
        this.isFallback = z;
    }

    /* compiled from: BuiltInsPackageFragmentImpl.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BuiltInsPackageFragmentImpl create(@NotNull FqName fqName, @NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor, @NotNull InputStream inputStream, boolean z) {
            Throwable th;
            Intrinsics.checkParameterIsNotNull(fqName, "fqName");
            Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
            Intrinsics.checkParameterIsNotNull(moduleDescriptor, "module");
            Intrinsics.checkParameterIsNotNull(inputStream, "inputStream");
            Closeable closeable = inputStream;
            Throwable th2 = null;
            try {
                InputStream inputStream2 = (InputStream) closeable;
                BuiltInsBinaryVersion readFrom = BuiltInsBinaryVersion.Companion.readFrom(inputStream2);
                if (readFrom == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("version");
                }
                if (readFrom.isCompatible()) {
                    ProtoBuf.PackageFragment parseFrom = ProtoBuf.PackageFragment.parseFrom(inputStream2, BuiltInSerializerProtocol.INSTANCE.getExtensionRegistry());
                    CloseableKt.closeFinally(closeable, th2);
                    Intrinsics.checkExpressionValueIsNotNull(parseFrom, "proto");
                    return new BuiltInsPackageFragmentImpl(fqName, storageManager, moduleDescriptor, parseFrom, readFrom, z, (DefaultConstructorMarker) null);
                }
                throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: " + "expected " + BuiltInsBinaryVersion.INSTANCE + ", actual " + readFrom + ". " + "Please update Kotlin");
            } catch (Throwable th3) {
                CloseableKt.closeFinally(closeable, th);
                throw th3;
            }
        }
    }
}
