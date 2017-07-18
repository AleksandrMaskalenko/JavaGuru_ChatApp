package lv.javaguru.webchat;

import lv.javaguru.Businesslogic.UserService;
import lv.javaguru.Domain.User;
import lv.javaguru.database.Database;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.booleanThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BusinessLogicUserTest {

    private Database dao;
    private UserService service;

    @Before
    public void init(){
        dao = mock(Database.class);
        service = new UserService(dao);
    }

    @Test
    public void shouldAddNewUserIfNotExistsInTheList(){
        doReturn(Optional.empty()).when(dao).getUserByUserName("Pupkin");
        boolean result = service.addUser("Pupkin", 25999647, "pupkin@pupkin.lv");
        assertThat(result, is(true));
        verify(dao).getUserByUserName("Pupkin");
    }
    @Test
    public void shouldNotAddNewUserIfAlreadyExistsInTheList(){
        User user = mock(User.class);
        doReturn(Optional.of(user)).when(dao).getUserByUserName("Berzins");
        boolean result = service.addUser("Berzins", 26598758, "berzins@berzins.lv");
        assertThat(result, is(false));
    }
}
