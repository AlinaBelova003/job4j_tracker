package ru.job4j;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int a) {
        return a - x;
    }

    public int multiple(int a) {
        return x * a;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sumAllOperation(int a) {
        return multiple(a) + divide(a) + sum(a) + minus(a);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int resultMultiple = calculator.multiple(5);
        System.out.println(resultMultiple);
        int resultDivide = calculator.divide(3);
        System.out.println(resultDivide);
        int resultSum = sum(10);
        System.out.println(resultSum);
        int resultMinus = minus(2);
        System.out.println(resultMinus);
        int resultAll = calculator.sumAllOperation(2);
        System.out.println(resultAll);

    }
}
