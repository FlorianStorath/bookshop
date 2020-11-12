package ownValidators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint( validatedBy = AValidator.class )
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME )
@Documented
public @interface AConstraint
{
  String message() default "beginnt nicht mit A";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
