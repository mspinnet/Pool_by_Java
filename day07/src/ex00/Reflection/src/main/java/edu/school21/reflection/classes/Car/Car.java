package edu.school21.reflection.classes.Car;

import java.util.StringJoiner;

public class Car {
    private String model;
    private String color;
    private int mileage;

    public Car() {
        this.model = "Default model";
        this.color = "Default color";
        this.mileage = 0;
    }

    public Car(String model, String color, int mileage) {
        this.model = model;
        this.color = color;
        this.mileage = mileage;
    }

    public int growMileage(int value) {
        this.mileage += value;
        return mileage;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
                .add("model='" + model + "'")
                .add("color='" + color + "'")
                .add("mileage=" + mileage)
                .toString();
    }
}
