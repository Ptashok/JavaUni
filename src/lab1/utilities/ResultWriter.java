package lab1.utilities;

import java.io.FileWriter;
import java.io.IOException;

public class ResultWriter {
    public synchronized void writeToResultFile(double[] result) {
        // Указываем путь относительно папки resources
        try (FileWriter writer = new FileWriter("resources/data/result_E.txt")) {
            for (double value : result) {
                writer.write(value + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void writeToResultFile(double[][] result) {
        // Указываем путь относительно папки resources
        try (FileWriter writer = new FileWriter("resources/data/result_MA.txt")) {
            for (double[] row : result) {
                for (double value : row) {
                    writer.write(value + "\t");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printResultToConsole(double[] result) {
        System.out.println("Result E:");
        for (double value : result) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public synchronized void printResultToConsole(double[][] result) {
        System.out.println("Result MA:");
        for (double[] row : result) {
            for (double value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
