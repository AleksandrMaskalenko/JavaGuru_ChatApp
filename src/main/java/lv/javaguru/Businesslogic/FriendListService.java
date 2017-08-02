package lv.javaguru.Businesslogic;

import lv.javaguru.DAO.FriendListDAO;
import lv.javaguru.Domain.FriendList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendListService {

    @Autowired
    private FriendListDAO friendListDAO;

}
