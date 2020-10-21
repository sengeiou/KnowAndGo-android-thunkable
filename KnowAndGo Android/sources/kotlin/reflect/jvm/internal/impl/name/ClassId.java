package kotlin.reflect.jvm.internal.impl.name;

import kotlin.text.StringsKt;
import org.apache.commons.p032io.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ClassId {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean local;
    private final FqName packageFqName;
    private final FqName relativeClassName;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Throwable th;
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 3:
                objArr[0] = "packageFqName";
                break;
            case 2:
                objArr[0] = "relativeClassName";
                break;
            case 4:
                objArr[0] = "topLevelName";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 10:
                objArr[0] = "segment";
                break;
            case 11:
            case 12:
                objArr[0] = "string";
                break;
            default:
                objArr[0] = "topLevelFqName";
                break;
        }
        switch (i) {
            case 5:
                objArr[1] = "getPackageFqName";
                break;
            case 6:
                objArr[1] = "getRelativeClassName";
                break;
            case 7:
                objArr[1] = "getShortClassName";
                break;
            case 9:
                objArr[1] = "asSingleFqName";
                break;
            case 13:
            case 14:
                objArr[1] = "asString";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                break;
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                objArr[2] = "<init>";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                break;
            case 8:
                objArr[2] = "createNestedClassId";
                break;
            case 10:
                objArr[2] = "startsWith";
                break;
            case 11:
            case 12:
                objArr[2] = "fromString";
                break;
            default:
                objArr[2] = "topLevel";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                th = new IllegalStateException(format);
                break;
            default:
                th = new IllegalArgumentException(format);
                break;
        }
        throw th;
    }

    @NotNull
    public static ClassId topLevel(@NotNull FqName fqName) {
        if (fqName == null) {
            $$$reportNull$$$0(0);
        }
        return new ClassId(fqName.parent(), fqName.shortName());
    }

    public ClassId(@NotNull FqName fqName, @NotNull FqName fqName2, boolean z) {
        if (fqName == null) {
            $$$reportNull$$$0(1);
        }
        if (fqName2 == null) {
            $$$reportNull$$$0(2);
        }
        this.packageFqName = fqName;
        this.relativeClassName = fqName2;
        this.local = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ClassId(@NotNull FqName fqName, @NotNull Name name) {
        this(fqName, FqName.topLevel(name), false);
        if (fqName == null) {
            $$$reportNull$$$0(3);
        }
        if (name == null) {
            $$$reportNull$$$0(4);
        }
    }

    @NotNull
    public FqName getPackageFqName() {
        FqName fqName = this.packageFqName;
        if (fqName == null) {
            $$$reportNull$$$0(5);
        }
        return fqName;
    }

    @NotNull
    public FqName getRelativeClassName() {
        FqName fqName = this.relativeClassName;
        if (fqName == null) {
            $$$reportNull$$$0(6);
        }
        return fqName;
    }

    @NotNull
    public Name getShortClassName() {
        Name shortName = this.relativeClassName.shortName();
        if (shortName == null) {
            $$$reportNull$$$0(7);
        }
        return shortName;
    }

    public boolean isLocal() {
        return this.local;
    }

    @NotNull
    public ClassId createNestedClassId(@NotNull Name name) {
        if (name == null) {
            $$$reportNull$$$0(8);
        }
        return new ClassId(getPackageFqName(), this.relativeClassName.child(name), this.local);
    }

    @Nullable
    public ClassId getOuterClassId() {
        FqName parent = this.relativeClassName.parent();
        if (parent.isRoot()) {
            return null;
        }
        return new ClassId(getPackageFqName(), parent, this.local);
    }

    public boolean isNestedClass() {
        return !this.relativeClassName.parent().isRoot();
    }

    @NotNull
    public FqName asSingleFqName() {
        if (this.packageFqName.isRoot()) {
            FqName fqName = this.relativeClassName;
            if (fqName == null) {
                $$$reportNull$$$0(9);
            }
            return fqName;
        }
        return new FqName(this.packageFqName.asString() + "." + this.relativeClassName.asString());
    }

    @NotNull
    public static ClassId fromString(@NotNull String str) {
        if (str == null) {
            $$$reportNull$$$0(11);
        }
        return fromString(str, false);
    }

    @NotNull
    public static ClassId fromString(@NotNull String str, boolean z) {
        if (str == null) {
            $$$reportNull$$$0(12);
        }
        return new ClassId(new FqName(StringsKt.substringBeforeLast(str, (char) IOUtils.DIR_SEPARATOR_UNIX, "").replace(IOUtils.DIR_SEPARATOR_UNIX, '.')), new FqName(StringsKt.substringAfterLast(str, (char) IOUtils.DIR_SEPARATOR_UNIX, str)), z);
    }

    @NotNull
    public String asString() {
        if (this.packageFqName.isRoot()) {
            String asString = this.relativeClassName.asString();
            if (asString == null) {
                $$$reportNull$$$0(13);
            }
            return asString;
        }
        String str = this.packageFqName.asString().replace('.', IOUtils.DIR_SEPARATOR_UNIX) + "/" + this.relativeClassName.asString();
        if (str == null) {
            $$$reportNull$$$0(14);
        }
        return str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClassId classId = (ClassId) obj;
        if (!this.packageFqName.equals(classId.packageFqName) || !this.relativeClassName.equals(classId.relativeClassName) || this.local != classId.local) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((this.packageFqName.hashCode() * 31) + this.relativeClassName.hashCode()) * 31) + Boolean.valueOf(this.local).hashCode();
    }

    public String toString() {
        if (!this.packageFqName.isRoot()) {
            return asString();
        }
        return "/" + asString();
    }
}
