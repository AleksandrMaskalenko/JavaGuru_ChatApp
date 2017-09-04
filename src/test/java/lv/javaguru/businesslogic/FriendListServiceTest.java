package lv.javaguru.businesslogic;

import lv.javaguru.Businesslogic.FriendListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class FriendListServiceTest {

    @Mock private FriendListService friendListService;

    @InjectMocks
    private FriendListService service = new FriendListService();


    @Test
    public void shouldReturnErrorWhen() {
      //  doReturn() .when(friendListService).getAllFriends();

    }
}
