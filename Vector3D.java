package org.example;

public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return ("(" + String.format("%.2f", x) + ", " + String.format("%.2f", y) + ", " + String.format("%.2f", z) + ")");
    }

    public double getMagnitude() {
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }

    public Vector3D normalize() {
        double m = getMagnitude();
        if (m != 0) {
            return new Vector3D(x / m, y / m, z / m);
        } else {
            throw new IllegalArgumentException("This is not possible as the magnitude is zero!");
        }
    }

    public Vector3D add(Vector3D v) {
        return new Vector3D(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    public Vector3D multiply(int c) {
        return new Vector3D(this.x * c, this.y * c, this.z * c);
    }

    public double dotProduct(Vector3D v) {
        return (this.x * v.x + this.y * v.y + this.z * v.z);
    }

    public double angleBetween(Vector3D v) {
        double dot = this.dotProduct(v);
        double m = this.getMagnitude();
        double mv = v.getMagnitude();

        if (m == 0 || mv == 0) {
            throw new IllegalArgumentException("This is not possible with a 0 vector!");
        }

        double cosTheta = dot / (m * mv);
        return Math.acos(cosTheta);
    }
}