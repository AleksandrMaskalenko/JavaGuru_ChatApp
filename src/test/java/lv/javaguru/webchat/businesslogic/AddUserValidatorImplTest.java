package lv.javaguru.webchat.businesslogic;

import lv.javaguru.Businesslogic.AddUserValidator;
import lv.javaguru.Businesslogic.AddUserValidatorImpl;
import lv.javaguru.api.Error;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

public class AddUserValidatorImplTest {

    @InjectMocks
    private AddUserValidator validator = new AddUserValidatorImpl();

    @Test
    public void shouldReturnErrorWhenUsernameIsNull() {
        List<Error> errors = validator.validate(null, "email");
        assertThat(errors.size(), is(1));
        assertThat(errors.get(0).getField(), is("userName"));
        assertThat(errors.get(0).getErrorMessage(), is("Must be not empty"));
    }

    @Test
    public void shouldReturnErrorWhenUserNameIsEmpty() {
        List<Error> errors = validator.validate("", "email");
        assertThat(errors.size(), is(1));
        assertThat(errors.get(0).getField(), is("userName"));
        assertThat(errors.get(0).getErrorMessage(), is("Must be not empty"));
    }

    @Test
    public void shouldReturnErrorWhenEmailIsNull() {
        List<Error> errors = validator.validate("userName", null);
        assertThat(errors.size(), is(1));
        assertThat(errors.get(0).getField(), is("email"));
        assertThat(errors.get(0).getErrorMessage(), is("Must be not empty"));
    }

    @Test
    public void shouldReturnErrorWhenEmailIsEmpty() {
        List<Error> errors = validator.validate("userName", "");
        assertThat(errors.size(), is(1));
        assertThat(errors.get(0).getField(), is("email"));
        assertThat(errors.get(0).getErrorMessage(), is("Must be not empty"));
    }
}
