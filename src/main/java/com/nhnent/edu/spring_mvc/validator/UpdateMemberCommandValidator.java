package com.nhnent.edu.spring_mvc.validator;

import com.nhnent.edu.spring_mvc.dto.UpdateMemberCommand;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UpdateMemberCommandValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UpdateMemberCommand.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UpdateMemberCommand command = (UpdateMemberCommand) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "name is empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "password is empty");
        if (command.getPassword().length() < 8) {
            errors.rejectValue("password", "", "password length is less than 8");
        }
    }

}
