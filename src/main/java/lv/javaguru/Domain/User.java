package lv.javaguru.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    private String password;
    private int phone;
    private String email;
    private String userName;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


    public User() {
    }

    public User(String password, int phone, String email, String userName, Role role) {
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.userName = userName;
        this.role = role;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
