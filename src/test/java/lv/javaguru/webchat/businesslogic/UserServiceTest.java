package lv.javaguru.webchat.businesslogic;

import lv.javaguru.Businesslogic.AddUserValidator;
import lv.javaguru.Businesslogic.UserService;
import lv.javaguru.DAO.UserDAO;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock private UserDAO dao;
    @Mock private AddUserValidator addUserValidator;

    //@InjectMocks
   // private UserService service = new
}
