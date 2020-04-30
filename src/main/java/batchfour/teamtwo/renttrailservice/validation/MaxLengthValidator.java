package batchfour.teamtwo.renttrailservice.validation;

import batchfour.teamtwo.renttrailservice.validation.annotations.MaxLength;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MaxLengthValidator implements ConstraintValidator<MaxLength, String> {

    private MaxLength contraint;

    @Override
    public void initialize(MaxLength constraintAnnotation) {
        contraint = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        int length = value != null ? value.length() : 0;
        return length <= contraint.value();
    }
}
