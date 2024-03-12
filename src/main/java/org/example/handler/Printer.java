package org.example.handler;

import lombok.Getter;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.example.model.PrinterType;
import org.example.model.State;

@Getter
public class Printer implements Runnable {

    private final int stepValue;
    private final int maxValue;
    private final PrinterType currentPrinterType;
    private final PrinterType nextPrinterType;
    private final State state;
    private int currentValue;

    public Printer(int currentValue, final int stepValue, final int maxValue, @NonNull final PrinterType currentPrinterType, @NonNull final PrinterType nextPrinterType, @NonNull final State state) {
        this.currentValue = currentValue;
        this.stepValue = stepValue;
        this.maxValue = maxValue;
        this.currentPrinterType = currentPrinterType;
        this.nextPrinterType = nextPrinterType;
        this.state = state;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (currentValue <= maxValue) {
            synchronized (state) {
                while (this.currentPrinterType != state.getNextToPrint()) {
                    state.wait();
                }
                System.out.println(this.currentPrinterType + " : " + currentValue);
                currentValue += stepValue;
                state.setNextToPrint(this.nextPrinterType);
                state.notifyAll();
            }
        }
    }
}
