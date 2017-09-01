package lv.javaguru.Businesslogic;

import lv.javaguru.DAO.ConvMessageDAO;
import lv.javaguru.Domain.ConvMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvMessageService {

    @Autowired
    private ConvMessageDAO convMessageDAO;

    @Autowired
    private UserService userService;

    public void saveMassage(ConvMessage convMessage) {
        convMessage.setUser(userService.authentication());
        convMessageDAO.save(convMessage);
    }

    public List<ConvMessage> getMessages(int conv_id) {
        return convMessageDAO.getMessages(conv_id);
    }
}
