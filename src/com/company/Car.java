package com.company;

public class Car {
    private String name;
    private int price;
    private Type type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    public static Car makeCar(String name, int price, Type type){
        Car car = new Car();
        car.name = name;
        car.price = price;
        car.type = type;

        return car;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +"$"+
                ", type=" + type +"'"+
                '}';
    }
}
