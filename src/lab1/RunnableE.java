package lab1;

import lab1.utilities.ResultWriter;

public class RunnableE extends RunnableTask {
    public RunnableE(ResultWriter resultWriter, Task task) {
        super(resultWriter, task);
    }

    @Override
    protected void computeAndPrintResult() {
        double[] resultE = task.computeE();
        resultWriter.writeToResultFile(resultE);
        resultWriter.printResultToConsole(resultE);
    }
}
