package com.example.parkingcarproject.model;

public class CarDetails {

    private int carId;
    private int carImage;
    private String carType;
    private String carColor;
    private boolean isAvailable;

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public CarDetails(int carId, int carImage, String carType, String carColor) {
        this.carId = carId;
        this.carImage = carImage;
        this.carType = carType;
        this.carColor = carColor;
    }

    public int getCarImage() {
        return carImage;
    }

    public void setCarImage(int carImage) {
        this.carImage = carImage;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    @Override
    public String toString() {
        return "CarDetails{" +
                "carId=" + carId +
                ", carType='" + carType + '\'' +
                ", carColor='" + carColor + '\'' +
                '}';
    }
}
