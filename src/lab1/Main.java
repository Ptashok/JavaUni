package lab1;

import lab1.initialization.DataGenerator;
import lab1.initialization.FileName;
import lab1.utilities.DataFileOperator;
import lab1.utilities.ResultWriter;

public class Main {
    public static void main(String[] args) {
        try {
            DataGenerator generator = new DataGenerator(100);
            DataFileOperator fileOperator = new DataFileOperator();

            double[][] MD = generator.generateMatrix();
            double[][] MC = generator.generateMatrix();
            double[][] MX = generator.generateMatrix();
            double[] B = generator.generateVector();
            double[] D = generator.generateVector();
            double b = 2.5;

            fileOperator.writeMatrixToFile(MD, FileName.MD.getFileName());
            fileOperator.writeMatrixToFile(MC, FileName.MC.getFileName());
            fileOperator.writeMatrixToFile(MX, FileName.MX.getFileName());
            fileOperator.writeVectorToFile(B, FileName.B.getFileName());
            fileOperator.writeVectorToFile(D, FileName.D.getFileName());

            ResultWriter resultWriter = new ResultWriter();
            Task task = new Task(MD, MC, MX, B, D, b);

            Thread threadE = new Thread(new RunnableE(resultWriter, task));
            Thread threadMA = new Thread(new RunnableMA(resultWriter, task));

            long startTime = System.nanoTime();
            threadE.start();
            threadMA.start();

            threadE.join();
            threadMA.join();
            long endTime = System.nanoTime();

            System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
