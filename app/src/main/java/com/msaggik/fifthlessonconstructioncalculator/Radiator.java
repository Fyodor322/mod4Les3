package com.msaggik.fifthlessonconstructioncalculator;

import java.io.Serializable;

public class Radiator implements Serializable {

    private int square; //площадь квартиры
    private int height; //высота потолков
    private int radiatorPower; //мощность радиатора
    private int cost;

    public Radiator(int square, int height, int radiatorPower, int cost) {
        this.square = square;
        this.height = height;
        this.radiatorPower = radiatorPower;
        this.cost = cost;
    }

    public int getSquare() {
        return square;
    }
    public int getHeight() {
        return height;
    }
    public int getRadiatorPower() {
        return radiatorPower;
    }
    public int getCost() {
        return cost;
    }

    public void setSquare(int square) {
        this.square = square;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setRadiatorPower(int radiatorPower) {
        this.radiatorPower = radiatorPower;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}



