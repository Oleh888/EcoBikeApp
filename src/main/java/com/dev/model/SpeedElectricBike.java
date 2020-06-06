package com.dev.model;

public class SpeedElectricBike extends ElectricBike {
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String light = isWithLight() ? "head/tail light." : "no head/tail light.";
        builder.append("SPEEDELECE ")
                .append(getBrand())
                .append(" with ")
                .append(getBatteryCapacity())
                .append(" mAh battery and  ")
                .append(light)
                .append("\nPrice: ")
                .append(getPrice())
                .append(" euros.");
        return builder.toString();
    }
}
