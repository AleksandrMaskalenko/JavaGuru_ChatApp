package lv.javaguru.domain;

import lv.javaguru.Domain.Conversation;
import lv.javaguru.Domain.Participants;
import lv.javaguru.Domain.Role;
import lv.javaguru.Domain.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParticipantsTest {


    private Role role = new Role(5,"USER");
    private User user = new User(1,"password", "name", "email", "username", role );
    private Conversation conversation = new Conversation(3,"title", "01/01/2017", "pair", user);
    private Participants participant = new Participants(5,conversation, user);


    @Test
    public void getRoleName() {
        assertThat(role.getRoleName(), is("USER"));
    }
    @Test
    public void getUsername() {
        assertThat(user.getUsername(), is("username"));
    }
    @Test
    public void getName() {
        assertThat(user.getName(), is("name"));
    }
    @Test
    public void getConversationTitle() {
        assertThat(conversation.getTitle(), is("title"));
    }
    @Test
    public void getConversationDate() {
        assertThat(conversation.getCreationDate(), is("01/01/2017"));
    }
    @Test
    public void getParticipantUserUsername() {
        assertThat(participant.getUser().getUsername(), is("username"));
    }
    @Test
    public void getParticipantUserName() {
        assertThat(participant.getUser().getName(), is("name"));
    }
    @Test
    public void getParticipantId() {
        assertThat(participant.getPart_id(), is(5));
    }
    @Test
    public void getParticipantConversationTitle() {
        assertThat(participant.getConversation().getTitle(), is("title"));
    }
    @Test
    public void getParticipantConversationDate() {
        assertThat(participant.getConversation().getCreationDate(), is("01/01/2017"));
    }

}