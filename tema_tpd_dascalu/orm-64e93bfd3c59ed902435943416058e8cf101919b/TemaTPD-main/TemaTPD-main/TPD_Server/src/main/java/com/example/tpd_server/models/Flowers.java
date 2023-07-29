package com.example.tpd_server.models;

import com.example.tpd_server.interfaces.FlowersInterface;

import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
public class Flowers implements FlowersInterface, Serializable {
    private int id;
    private String name;
    private String color;

    public Flowers(){

    }
    public Flowers(int id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void SetColor(int SetColor) {

    }

}
