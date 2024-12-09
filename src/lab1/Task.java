package lab1;

import java.util.Arrays;

public class Task {
    private final double[][] MD; // Матрица MD
    private final double[][] MC; // Матрица MC
    private final double[][] MX; // Матрица MX
    private final double[] B;    // Вектор B
    private final double[] D;    // Вектор D
    private final double b;      // Скаляр b

    public Task(double[][] MD, double[][] MC, double[][] MX, double[] B, double[] D, double b) {
        this.MD = MD;
        this.MC = MC;
        this.MX = MX;
        this.B = B;
        this.D = D;
        this.b = b;
    }

    /**
     * Метод для вычисления MA = b * MD * (MC - MX) + MX * MC
     */
    public double[][] computeMA() {
        int size = MD.length;
        double[][] resultMA = new double[size][size];

        // Шаг 1: temp1 = MC - MX
        double[][] temp1 = subtractMatrices(MC, MX);

        // Шаг 2: temp2 = MD * temp1 * b
        double[][] temp2 = multiplyMatrices(MD, temp1);
        temp2 = multiplyMatrixWithScalar(temp2, b);

        // Шаг 3: temp3 = MX * MC
        double[][] temp3 = multiplyMatrices(MX, MC);

        // Шаг 4: resultMA = temp2 + temp3
        resultMA = addMatrices(temp2, temp3);

        return resultMA;
    }

    /**
     * Метод для вычисления E = MC * B + D * min(MC)
     */
    public double[] computeE() {
        int size = MC.length;
        double[] resultE = new double[size];

        // Шаг 1: MC * B
        double[] temp1 = multiplyMatrixWithVector(MC, B);

        // Шаг 2: min(MC)
        double minMC = findMin(MC);

        // Шаг 3: D * min(MC)
        double[] temp2 = multiplyVectorWithScalar(D, minMC);

        // Шаг 4: E = temp1 + temp2
        resultE = addVectors(temp1, temp2);

        return resultE;
    }

    // --- Вспомогательные методы ---

    // Умножение двух матриц
    private double[][] multiplyMatrices(double[][] mat1, double[][] mat2) {
        int size = mat1.length;
        double[][] result = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }

        return result;
    }

    // Умножение матрицы на вектор
    private double[] multiplyMatrixWithVector(double[][] matrix, double[] vector) {
        int size = matrix.length;
        double[] result = new double[size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }

        return result;
    }

    // Умножение вектора на скаляр
    private double[] multiplyVectorWithScalar(double[] vector, double scalar) {
        int size = vector.length;
        double[] result = new double[size];

        for (int i = 0; i < size; i++) {
            result[i] = vector[i] * scalar;
        }

        return result;
    }

    // Умножение матрицы на скаляр
    private double[][] multiplyMatrixWithScalar(double[][] matrix, double scalar) {
        int size = matrix.length;
        double[][] result = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }

        return result;
    }

    // Сложение двух матриц
    private double[][] addMatrices(double[][] mat1, double[][] mat2) {
        int size = mat1.length;
        double[][] result = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = mat1[i][j] + mat2[i][j];
            }
        }

        return result;
    }

    // Вычитание одной матрицы из другой
    private double[][] subtractMatrices(double[][] mat1, double[][] mat2) {
        int size = mat1.length;
        double[][] result = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = mat1[i][j] - mat2[i][j];
            }
        }

        return result;
    }

    // Сложение двух векторов
    private double[] addVectors(double[] vec1, double[] vec2) {
        int size = vec1.length;
        double[] result = new double[size];

        for (int i = 0; i < size; i++) {
            result[i] = vec1[i] + vec2[i];
        }

        return result;
    }

    // Поиск минимального элемента в матрице
    private double findMin(double[][] matrix) {
        double min = Double.MAX_VALUE;

        for (double[] row : matrix) {
            for (double element : row) {
                if (element < min) {
                    min = element;
                }
            }
        }

        return min;
    }
}
