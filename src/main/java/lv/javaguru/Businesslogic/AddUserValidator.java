package lv.javaguru.Businesslogic;


import lv.javaguru.api.Error;


import java.util.List;
import java.util.Optional;

public interface AddUserValidator {
    List<Error> validate(String userName, String email);


    Optional<Error> validateUserName(String userName);

    boolean alreadyExist(String userName);

    Optional<Error> validateEmail (String email);

}

