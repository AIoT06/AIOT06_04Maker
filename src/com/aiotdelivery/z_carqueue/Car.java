package com.aiotdelivery.z_carqueue;

public class Car {
    private int carId;
    private String carName;
    private int status; /* 0:待機中/1:出勤中/2:回程中/-1:故障排除中 */

    public Car(int carId) {
        this.carId = carId;
        this.carName = "Car" + carId;
        this.status = 0;
    }

    public int getCarId() {
        return carId;
    }
    public String getCarName() {
        return carName;
    }
    public int getStatus() {
        return status;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }
    public void setCarName(String carName) {
        this.carName = carName;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public boolean goOut(Car car) {
        if (car.getStatus() != 0) return false;
        car.status = 1;
        return true;
    }

    public boolean goBack(Car car) {
        if (car.getStatus() != 1) return false;
        car.status = 2;
        return true;
    }

    public boolean available(Car car) {
        switch (car.getStatus()) {
            case 2:
                car.setStatus(0);
            case 0:
                return true;
            default:
                return false;
        }
    }
}
