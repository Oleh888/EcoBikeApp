package com.dev.model;

import java.util.Objects;

public class FoldingBike extends EcoBike {
    private double sizeOfWheels;
    private int numberOfGears;

    public double getSizeOfWheels() {
        return sizeOfWheels;
    }

    public void setSizeOfWheels(double sizeOfWheels) {
        this.sizeOfWheels = sizeOfWheels;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        FoldingBike foldingBike = (FoldingBike) obj;
        return sizeOfWheels == foldingBike.sizeOfWheels
                && numberOfGears == foldingBike.numberOfGears;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + Objects.hash(sizeOfWheels, numberOfGears);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        String light = isWithLight() ? "head/tail light." : "no head/tail light.";
        builder.append("FOLDING BIKE ")
                .append(getBrand())
                .append(" with ")
                .append(numberOfGears)
                .append(" gear(s) and ")
                .append(light)
                .append("\nPrice: ")
                .append(getPrice())
                .append(" euros.");
        return builder.toString();
    }
}
