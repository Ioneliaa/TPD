package com.example.tpd_client.models;

import com.example.tpd_client.interfaces.FlowerInterface;

import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
public class Flower implements FlowerInterface, Serializable {
    private int id;
    private String color;

    public Flower(int id, String color, String name) {
        this.id = id;
        this.color = color;
        this.name = name;
    }

    public Flower(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
