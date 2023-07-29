package com.example.tpd_client.interfaces;

import javax.ejb.Local;

@Local
public interface UserFlowerInterface {
    int getUserId();
    void setUserId(int userId);
    int getFlowerId();
    void setFlowerId(int flowerId);
}
