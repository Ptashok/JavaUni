package lab1.utilities;

import java.io.*;

public class DataFileOperator {
    public void writeVectorToFile(double[] vector, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (double value : vector) {
                writer.write(value + "\n");
            }
        }
    }

    public void writeMatrixToFile(double[][] matrix, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (double[] row : matrix) {
                for (double value : row) {
                    writer.write(value + "\t");
                }
                writer.write("\n");
            }
        }
    }

    public double[] readVectorFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines().mapToDouble(Double::parseDouble).toArray();
        }
    }

    public double[][] readMatrixFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines().map(line -> {
                String[] parts = line.split("\t");
                return java.util.Arrays.stream(parts).mapToDouble(Double::parseDouble).toArray();
            }).toArray(double[][]::new);
        }
    }
}
