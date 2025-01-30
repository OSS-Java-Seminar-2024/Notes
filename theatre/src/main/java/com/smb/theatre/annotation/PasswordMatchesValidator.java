package com.smb.theatre.annotation;

import com.smb.theatre.model.dto.EmployeeDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object>
{
    @Override
    public void initialize (PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid (Object obj, ConstraintValidatorContext context) {
        EmployeeDto employee = (EmployeeDto) obj;
        return employee.getPassword().equals(employee.getMatchingPassword());
    }
}
