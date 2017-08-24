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

    public void saveMassage(ConvMessage convMessage) {
        convMessageDAO.save(convMessage);

    }

    public List<ConvMessage> getMessages(int id) {
        return convMessageDAO.getMessages(id);
    }
}
