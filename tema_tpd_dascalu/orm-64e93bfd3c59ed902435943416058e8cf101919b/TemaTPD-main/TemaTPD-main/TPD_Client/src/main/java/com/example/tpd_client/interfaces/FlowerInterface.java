package com.example.tpd_client.interfaces;

import javax.ejb.Local;

@Local
public interface FlowerInterface {
    int getId();
    void setId(int id);
    String getColor();
    void setColor(String color);
    String getName();
    void setName(String name);
}
