package lv.javaguru.webchat.businesslogic;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import lv.javaguru.Businesslogic.FriendListService;
import lv.javaguru.Domain.FriendList;
import org.hibernate.service.spi.InjectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;


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
