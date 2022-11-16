package org.itstep.Task01;

public class Car {
    private String name;
    private int makeYear;
    private int price;
    private String color;
    private double engineVolume;

    public Car(String name, int makeYear, int price, String color, double engineVolume) {
        this.name = name;
        this.makeYear = makeYear;
        this.price = price;
        this.color = color;
        this.engineVolume = engineVolume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMakeYear() {
        return makeYear;
    }

    public void setMakeYear(int makeYear) {
        this.makeYear = makeYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", makeYear=" + makeYear +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", engineVolume=" + engineVolume +
                '}';
    }

    public void printCollection (){

    }
}
