package lv.javaguru.Businesslogic;


import com.google.common.collect.Lists;
import lv.javaguru.api.Error;

import java.util.List;
import java.util.Optional;

public class AddUserValidatorImpl implements AddUserValidator {

    @Override
    public List<Error> validate(String userName, String email) {
        List<Error> errors = Lists.newArrayList();
        validateUserName(userName).ifPresent(e -> errors.add(e));
        validateEmail(email).ifPresent(e -> errors.add(e));
        return errors;
    }

    @Override
    public Optional<Error> validateUserName(String userName) {
        if (userName == null || "".equals(userName)) {
            return Optional.of(new Error("userName", "Must be not empty"));
        } else if (alreadyExist(userName)) {
            return Optional.of(new Error("userName", "Username already Exists"));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean alreadyExist(String userName) {
        // TO DO, when DB will work

        return false;
    }

    @Override
    public Optional<Error> validateEmail(String email) {
        if (email == null || "".equals(email)) {
            return Optional.of(new Error("email", "Must be not empty"));
        } else {
            return Optional.empty();
        }
    }
}