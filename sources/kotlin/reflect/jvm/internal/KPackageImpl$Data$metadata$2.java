package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import org.jetbrains.annotations.Nullable;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, mo39786d2 = {"<anonymous>", "Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "invoke"}, mo39787k = 3, mo39788mv = {1, 1, 15})
/* compiled from: KPackageImpl.kt */
final class KPackageImpl$Data$metadata$2 extends Lambda implements Function0<Triple<? extends JvmNameResolver, ? extends ProtoBuf.Package, ? extends JvmMetadataVersion>> {
    final /* synthetic */ KPackageImpl.Data this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KPackageImpl$Data$metadata$2(KPackageImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Nullable
    public final Triple<JvmNameResolver, ProtoBuf.Package, JvmMetadataVersion> invoke() {
        KotlinClassHeader classHeader;
        ReflectKotlinClass access$getKotlinClass$p = this.this$0.getKotlinClass();
        if (access$getKotlinClass$p == null || (classHeader = access$getKotlinClass$p.getClassHeader()) == null) {
            return null;
        }
        String[] data = classHeader.getData();
        String[] strings = classHeader.getStrings();
        if (data == null || strings == null) {
            return null;
        }
        Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom = JvmProtoBufUtil.readPackageDataFrom(data, strings);
        return new Triple<>(readPackageDataFrom.component1(), readPackageDataFrom.component2(), classHeader.getMetadataVersion());
    }
}
