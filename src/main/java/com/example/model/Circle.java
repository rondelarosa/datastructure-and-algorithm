package com.example.model;

public class Circle {
    private double radius;

    public double getRadius() {
        return radius;
    }

    public double area() {
        return Math.PI * this.radius * this.radius;
    }

    public double perimiter() {
        return 2 * Math.PI * this.radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return String.valueOf(this.radius);
    }
}
