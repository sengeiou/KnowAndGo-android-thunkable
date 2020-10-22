package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaVisibilities {
    @NotNull
    public static final Visibility PACKAGE_VISIBILITY = new Visibility("package", false) {
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = (i == 3 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 3 || i == 5) ? 2 : 3)];
            switch (i) {
                case 1:
                    objArr[0] = "from";
                    break;
                case 2:
                    objArr[0] = "visibility";
                    break;
                case 3:
                case 5:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$1";
                    break;
                case 4:
                    objArr[0] = "classDescriptor";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            if (i == 3) {
                objArr[1] = "normalize";
            } else if (i != 5) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$1";
            } else {
                objArr[1] = "effectiveVisibility";
            }
            switch (i) {
                case 2:
                    objArr[2] = "compareTo";
                    break;
                case 3:
                case 5:
                    break;
                case 4:
                    objArr[2] = "effectiveVisibility";
                    break;
                default:
                    objArr[2] = "isVisible";
                    break;
            }
            String format = String.format(str, objArr);
            throw ((i == 3 || i == 5) ? new IllegalStateException(format) : new IllegalArgumentException(format));
        }

        @NotNull
        public String getDisplayName() {
            return "public/*package*/";
        }

        public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            return JavaVisibilities.areInSamePackage(declarationDescriptorWithVisibility, declarationDescriptor);
        }

        /* access modifiers changed from: protected */
        public Integer compareTo(@NotNull Visibility visibility) {
            if (visibility == null) {
                $$$reportNull$$$0(2);
            }
            if (this == visibility) {
                return 0;
            }
            if (Visibilities.isPrivate(visibility)) {
                return 1;
            }
            return -1;
        }

        @NotNull
        public Visibility normalize() {
            Visibility visibility = Visibilities.PROTECTED;
            if (visibility == null) {
                $$$reportNull$$$0(3);
            }
            return visibility;
        }
    };
    @NotNull
    public static final Visibility PROTECTED_AND_PACKAGE = new Visibility("protected_and_package", true) {
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 3 ? 3 : 2)];
            switch (i) {
                case 1:
                    objArr[0] = "from";
                    break;
                case 2:
                    objArr[0] = "visibility";
                    break;
                case 3:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$3";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$3";
            } else {
                objArr[1] = "normalize";
            }
            switch (i) {
                case 2:
                    objArr[2] = "compareTo";
                    break;
                case 3:
                    break;
                default:
                    objArr[2] = "isVisible";
                    break;
            }
            String format = String.format(str, objArr);
            throw (i != 3 ? new IllegalArgumentException(format) : new IllegalStateException(format));
        }

        @NotNull
        public String getDisplayName() {
            return "protected/*protected and package*/";
        }

        public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            return JavaVisibilities.isVisibleForProtectedAndPackage(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
        }

        /* access modifiers changed from: protected */
        public Integer compareTo(@NotNull Visibility visibility) {
            if (visibility == null) {
                $$$reportNull$$$0(2);
            }
            if (this == visibility) {
                return 0;
            }
            if (visibility == Visibilities.INTERNAL) {
                return null;
            }
            if (Visibilities.isPrivate(visibility)) {
                return 1;
            }
            return -1;
        }

        @NotNull
        public Visibility normalize() {
            Visibility visibility = Visibilities.PROTECTED;
            if (visibility == null) {
                $$$reportNull$$$0(3);
            }
            return visibility;
        }
    };
    @NotNull
    public static final Visibility PROTECTED_STATIC_VISIBILITY = new Visibility("protected_static", true) {
        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 2 ? 3 : 2)];
            switch (i) {
                case 1:
                    objArr[0] = "from";
                    break;
                case 2:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$2";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            if (i != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$2";
            } else {
                objArr[1] = "normalize";
            }
            if (i != 2) {
                objArr[2] = "isVisible";
            }
            String format = String.format(str, objArr);
            throw (i != 2 ? new IllegalArgumentException(format) : new IllegalStateException(format));
        }

        @NotNull
        public String getDisplayName() {
            return "protected/*protected static*/";
        }

        public boolean isVisible(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            return JavaVisibilities.isVisibleForProtectedAndPackage(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
        }

        @NotNull
        public Visibility normalize() {
            Visibility visibility = Visibilities.PROTECTED;
            if (visibility == null) {
                $$$reportNull$$$0(2);
            }
            return visibility;
        }
    };

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities";
        switch (i) {
            case 2:
            case 3:
                objArr[2] = "areInSamePackage";
                break;
            default:
                objArr[2] = "isVisibleForProtectedAndPackage";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    /* access modifiers changed from: private */
    public static boolean isVisibleForProtectedAndPackage(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            $$$reportNull$$$0(0);
        }
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(1);
        }
        if (areInSamePackage(DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(declarationDescriptorWithVisibility), declarationDescriptor)) {
            return true;
        }
        return Visibilities.PROTECTED.isVisible(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
    }

    /* access modifiers changed from: private */
    public static boolean areInSamePackage(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(2);
        }
        if (declarationDescriptor2 == null) {
            $$$reportNull$$$0(3);
        }
        PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(declarationDescriptor, PackageFragmentDescriptor.class, false);
        PackageFragmentDescriptor packageFragmentDescriptor2 = (PackageFragmentDescriptor) DescriptorUtils.getParentOfType(declarationDescriptor2, PackageFragmentDescriptor.class, false);
        if (packageFragmentDescriptor2 == null || packageFragmentDescriptor == null || !packageFragmentDescriptor.getFqName().equals(packageFragmentDescriptor2.getFqName())) {
            return false;
        }
        return true;
    }
}
