package lab2;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        final int N = 400; // Size of matrix/vector
        final int THREADS = 2;
        final int PART = N / THREADS;

        Matrix MD = new Matrix(N);
        Matrix MT = new Matrix(N);
        Matrix MZ = new Matrix(N);
        Matrix ME = new Matrix(N);
        Matrix MM = new Matrix(N);
        Vector D = new Vector(N);
        Vector B = new Vector(N);
        Matrix MA = new Matrix(N);
        Vector A = new Vector(N);

        // Fill data with random values
        MD.fillRandom(1, 10);
        MT.fillRandom(1, 10);
        MZ.fillRandom(1, 10);
        ME.fillRandom(1, 10);
        MM.fillRandom(1, 10);
        D.fillRandom(1, 10);
        B.fillRandom(1, 10);

        System.out.println("Data generated!");

        CyclicBarrier barrier = new CyclicBarrier(THREADS);

        ExecutorService executor = Executors.newFixedThreadPool(THREADS);

        for (int t = 0; t < THREADS; t++) {
            final int threadId = t;
            executor.submit(() -> {
                try {
                    System.out.println("Thread " + threadId + " started.");

                    // Compute part of MA
                    int startRow = threadId * PART;
                    int endRow = (threadId + 1) * PART;

                    for (int i = startRow; i < endRow; i++) {
                        for (int j = 0; j < N; j++) {
                            double sum = MZ.get(i, j);
                            for (int k = 0; k < N; k++) {
                                sum += MD.get(i, k) * MT.get(k, j) - ME.get(i, k) * MM.get(k, j);
                            }
                            MA.set(i, j, sum);
                        }
                    }

                    barrier.await();

                    // Find max(D)
                    double maxD = D.max();

                    // Compute part of A
                    for (int i = startRow; i < endRow; i++) {
                        double sum = 0;
                        for (int j = 0; j < N; j++) {
                            sum += D.get(j) * MT.get(i, j) - maxD * B.get(i);
                        }
                        A.set(i, sum);
                    }

                    System.out.println("Thread " + threadId + " finished.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait for all threads to finish
        }

        System.out.println("Result MA:\n" + MA);
        System.out.println("Result A:\n" + A);
    }
}
