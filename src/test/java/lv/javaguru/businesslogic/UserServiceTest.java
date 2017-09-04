package lv.javaguru.businesslogic;

import lv.javaguru.Businesslogic.UserService;
import lv.javaguru.Domain.Role;
import lv.javaguru.Domain.User;
import lv.javaguru.validator.AddUserValidator;
import lv.javaguru.DAO.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserDAO userDAO;

//    @Test
    public void createUser() {

        entityManager.persist(create(12,"password", "name", "email", "username"));
        entityManager.flush();

        User user = userDAO.findOneByUsername("username");

        assertThat(user.getUsername(), is("username"));
        assertThat(user.getId(), is(notNullValue()));

    }

    private User create(int id, String password, String name, String email, String username) {
        Role role = new Role(3, "USER");
        return new User(id, password, name, email, username, role);
    }
}
