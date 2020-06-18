package com.aiotdelivery.z_carqueue;

import java.util.LinkedList;
import java.util.List;

public class CarQueue {
    private List<Car> carQueue = new LinkedList<>();

    public void add(int carNum) {
        Car car = new Car(carNum);
        carQueue.add(car);
    }

    public void show() {
        System.out.print("[");
        for (Car car : carQueue) {
            System.out.print(car.getCarName() + ",");
        }
        System.out.println("]");
    }
}
