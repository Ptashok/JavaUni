package lab2;

import java.util.Random;

public class Vector {
    private final double[] data;

    public Vector(int size) {
        this.data = new double[size];
    }

    public int getSize() {
        return data.length;
    }

    public double get(int index) {
        return data[index];
    }

    public void set(int index, double value) {
        data[index] = value;
    }

    public void fillRandom(double minValue, double maxValue) {
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = minValue + (maxValue - minValue) * random.nextDouble();
        }
    }

    public double max() {
        double maxValue = data[0];
        for (double value : data) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double value : data) {
            sb.append(String.format("%.2f\t", value));
        }
        return sb.toString();
    }
}
