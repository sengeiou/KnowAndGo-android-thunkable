package kotlin.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;

@SinceKotlin(version = "1.2")
@Target({ElementType.PARAMETER})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, mo39786d2 = {"Lkotlin/internal/AccessibleLateinitPropertyLiteral;", "", "kotlin-stdlib"}, mo39787k = 1, mo39788mv = {1, 1, 15})
@Retention(AnnotationRetention.BINARY)
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
/* compiled from: Annotations.kt */
public @interface AccessibleLateinitPropertyLiteral {
}
