package lv.javaguru.DAO;

import lv.javaguru.Domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO extends JpaRepository<Role, Integer> {

//    String getRole();
}
