package com.example.tpd_server.interfaces;

import javax.ejb.Remote;

@Remote
public interface UserFlowersInterface {
    int getUserId();
    void setUserId(int userId);
    int getFlowersId();
    void setFlowersId(int flowersId);
}
