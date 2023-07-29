package com.example.tpd_server.interfaces;

import javax.ejb.Remote;

@Remote
public interface FlowersInterface {
    int getId();
    void setId(int id);
    String getName();
    void setName(String name);
    String getColor();
    void SetColor(int SetColor);
}
