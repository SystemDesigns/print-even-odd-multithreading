package org.example;

import org.example.handler.Printer;
import org.example.model.PrinterType;
import org.example.model.State;

public class Main {
    public static void main(String[] args) {

        final State state = new State(PrinterType.ODD);

        final Printer oddPrinter = new Printer(1, 2, 10, PrinterType.ODD, PrinterType.EVEN, state);
        final Printer evenPrinter = new Printer(2, 2, 10, PrinterType.EVEN, PrinterType.ODD, state);

        final Thread oddThread = new Thread(oddPrinter);
        final Thread evenThread = new Thread(evenPrinter);

        oddThread.start();
        evenThread.start();
    }
}