package lv.javaguru.Domain;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int role_id;

    @Column(name = "role_name")
    private String roleName;

    public Role() {
    }

    public Role(int role_id, String roleName) {
        this.role_id = role_id;
        this.roleName = roleName;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
