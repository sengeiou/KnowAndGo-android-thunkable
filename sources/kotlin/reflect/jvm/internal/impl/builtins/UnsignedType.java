package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

/* compiled from: UnsignedType.kt */
public enum UnsignedType {
    UBYTE(r3),
    USHORT(r3),
    UINT(r3),
    ULONG(r3);
    
    @NotNull
    private final ClassId arrayClassId;
    @NotNull
    private final ClassId classId;
    @NotNull
    private final Name typeName;

    private UnsignedType(ClassId classId2) {
        this.classId = classId2;
        Name shortClassName = this.classId.getShortClassName();
        Intrinsics.checkExpressionValueIsNotNull(shortClassName, "classId.shortClassName");
        this.typeName = shortClassName;
        FqName packageFqName = this.classId.getPackageFqName();
        this.arrayClassId = new ClassId(packageFqName, Name.identifier(this.typeName.asString() + "Array"));
    }

    @NotNull
    public final ClassId getClassId() {
        return this.classId;
    }

    @NotNull
    public final Name getTypeName() {
        return this.typeName;
    }

    @NotNull
    public final ClassId getArrayClassId() {
        return this.arrayClassId;
    }
}
