package ownValidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AValidator implements ConstraintValidator<AConstraint, String> {
	 @Override
	  public void initialize( AConstraint constraintAnnotation ) { }

	  @Override
	  public boolean isValid( String value, ConstraintValidatorContext context )
	  {
	    return value != null && value.startsWith("A");
	  }

}
