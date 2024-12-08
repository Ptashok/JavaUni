package Lab8;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;
import java.util.Random;

public class ForkJoinSumExample {

    // Рекурсивне завдання для обчислення суми масиву
    static class SumTask extends RecursiveTask<Long> {
        private static final int THRESHOLD = 20; // Поріг розділення підзадач
        private final int[] array;
        private final int start;
        private final int end;

        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            // Якщо розмір підмасиву менший за поріг, обчислюємо суму безпосередньо
            if (end - start <= THRESHOLD) {
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                // Розділяємо задачу на дві частини
                int middle = (start + end) / 2;
                SumTask leftTask = new SumTask(array, start, middle);
                SumTask rightTask = new SumTask(array, middle, end);

                // Запускаємо підзадачі паралельно
                leftTask.fork();
                long rightResult = rightTask.compute();
                long leftResult = leftTask.join();

                // Повертаємо суму результатів підзадач
                return leftResult + rightResult;
            }
        }
    }

    public static void main(String[] args) {
        // Ініціалізуємо масив з 1_000_000 випадкових елементів у діапазоні 0-100
        int[] array = new int[1_000_000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101);
        }

        // Створюємо пул ForkJoin і запускаємо завдання обчислення суми
        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(array, 0, array.length);
        long sum = pool.invoke(task);

        // Виводимо результат
        System.out.println("Total sum of array elements: " + sum);
    }
}
