package lab1;

import lab1.utilities.ResultWriter;

public class RunnableMA extends RunnableTask {
    public RunnableMA(ResultWriter resultWriter, Task task) {
        super(resultWriter, task);
    }

    @Override
    protected void computeAndPrintResult() {
        double[][] resultMA = task.computeMA();
        resultWriter.writeToResultFile(resultMA);
        resultWriter.printResultToConsole(resultMA);
    }
}
