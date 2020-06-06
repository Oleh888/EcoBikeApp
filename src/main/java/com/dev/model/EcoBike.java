package com.dev.model;

import java.util.Objects;

public abstract class EcoBike {
    private String brand;
    private double weight;
    private boolean withLight;
    private String color;
    private double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isWithLight() {
        return withLight;
    }

    public void setWithLight(boolean withLight) {
        this.withLight = withLight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EcoBike ecoBike = (EcoBike) obj;
        return Objects.equals(brand, ecoBike.brand)
                && Objects.equals(color, ecoBike.color)
                && Objects.equals(price, ecoBike.price)
                && weight == ecoBike.weight
                && (withLight && ecoBike.withLight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, color, price, weight, withLight);
    }
}
