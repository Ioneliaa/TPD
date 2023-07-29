package com.example.tpd_client.interfaces;

import javax.ejb.Local;

@Local
public interface UserInterface {
    int getId();
    void setId(int id);
    String getUsername();
    void setUsername(String username);
    String getPassword();
    void setPassword(String password);
}
