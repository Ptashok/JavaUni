package lab1;

import lab1.utilities.ResultWriter;

public abstract class RunnableTask implements Runnable {
    protected final ResultWriter resultWriter;
    protected final Task task;

    public RunnableTask(ResultWriter resultWriter, Task task) {
        this.resultWriter = resultWriter;
        this.task = task;
    }

    @Override
    public void run() {
        computeAndPrintResult();
    }

    protected abstract void computeAndPrintResult();
}
