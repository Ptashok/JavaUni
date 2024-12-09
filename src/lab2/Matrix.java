package lab2;

import java.util.Random;

public class Matrix {
    private final double[][] data;
    private final int size;

    public Matrix(int size) {
        this.size = size;
        this.data = new double[size][size];
    }

    public int getSize() {
        return size;
    }

    public double get(int row, int col) {
        return data[row][col];
    }

    public void set(int row, int col, double value) {
        data[row][col] = value;
    }

    public void fillRandom(double minValue, double maxValue) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                data[i][j] = minValue + (maxValue - minValue) * random.nextDouble();
            }
        }
    }

    public static Matrix multiply(Matrix m1, Matrix m2) {
        int size = m1.getSize();
        Matrix result = new Matrix(size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double sum = 0;
                for (int k = 0; k < size; k++) {
                    sum += m1.get(i, k) * m2.get(k, j);
                }
                result.set(i, j, sum);
            }
        }
        return result;
    }

    public static Matrix subtract(Matrix m1, Matrix m2) {
        int size = m1.getSize();
        Matrix result = new Matrix(size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.set(i, j, m1.get(i, j) - m2.get(i, j));
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] row : data) {
            for (double value : row) {
                sb.append(String.format("%.2f\t", value));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
