package com.example.tpd_client.models;

import com.example.tpd_client.interfaces.UserFlowerInterface;

import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
public class UserFlower implements UserFlowerInterface, Serializable {
    private int userId;
    private int flowerId;

    public UserFlower(){

    }
    public UserFlower(int userId, int flowerId) {
        this.userId = userId;
        this.flowerId = flowerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(int flowerId) {
        this.flowerId = flowerId;
    }
}
