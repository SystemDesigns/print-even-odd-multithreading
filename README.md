## Problem Statement

Given an integer N, the task is to write a Java program to print the first N natural numbers in incremental order.

We'll be using the concept of thread synchronization and inter-thread communication to solve the problem.

## Solution
Following classes can be created:
1. PrinterType - Enum with values as Even and Odd.
2. State - Shared state class which will be used to store which printer type needs to run next.
3. Printer - Handler class with a State object.

`State` object is shared between the even printer and the odd printer, and `wait()` and `notify()` methods are used to execute the subsequent operations.

![Screenshot 2024-03-13 at 11 11 22 AM](https://github.com/SystemDesigns/print-even-odd-multithreading/assets/18263409/7420090b-f72f-4c53-ac5d-9df217a89b44)
