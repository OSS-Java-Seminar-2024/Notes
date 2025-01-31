package com.smb.theatre.annotation;

import com.smb.theatre.model.dto.UserDto;
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
        UserDto employee = (UserDto) obj;
        //return employee.getPassword().equals(employee.getMatchingPassword());
        return true;
    }

}