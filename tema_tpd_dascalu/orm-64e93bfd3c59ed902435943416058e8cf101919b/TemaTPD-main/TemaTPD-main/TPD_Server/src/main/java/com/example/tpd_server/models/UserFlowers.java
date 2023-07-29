package com.example.tpd_server.models;

import com.example.tpd_server.interfaces.UserFlowersInterface;

import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
public class UserFlowers implements UserFlowersInterface, Serializable {
    private int userId;
    private int flowerId;

    public UserFlowers(){

    }
    public UserFlowers(int userId, int flowerId) {
        this.userId = userId;
        this.flowerId = flowerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlowersId() {
        return flowerId;
    }

    public void setFlowersId(int flowerId) {
        this.flowerId = flowerId;
    }
}
