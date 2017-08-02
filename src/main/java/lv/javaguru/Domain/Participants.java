package lv.javaguru.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Participants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int particip_id;

    private int conv_id;
    private int user_id;
    private boolean status;

    public Participants() {
    }

    public int getParticip_id() {
        return particip_id;
    }

    public void setParticip_id(int particip_id) {
        this.particip_id = particip_id;
    }

    public int getConv_id() {
        return conv_id;
    }

    public void setConv_id(int conv_id) {
        this.conv_id = conv_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
