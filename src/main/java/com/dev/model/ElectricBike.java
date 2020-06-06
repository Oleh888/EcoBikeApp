package com.dev.model;

public class ElectricBike extends EcoBike {
    private double maxSpeed;
    private double batteryCapacity;

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String light = isWithLight() ? "head/tail light." : "no head/tail light.";
        builder.append("E-BIKE ")
                .append(getBrand())
                .append(" with ")
                .append(batteryCapacity)
                .append(" mAh battery and  ")
                .append(light)
                .append("\nPrice: ")
                .append(getPrice())
                .append(" euros.");
        return builder.toString();
    }
}
