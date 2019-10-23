package com.example.dblArray;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;

class MyDblArray {
    private int[][] a;
    private int horizontalSize;
    private int verticalSize;
    private Random random = new Random();

    MyDblArray(int verticalSize, int horizontalSize) throws InvalidArraySizeException {
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;
        if (horizontalSize < 3 || verticalSize < 3) {
            throw new InvalidArraySizeException("неверно указаны размеры массива!");
        }
        a = new int[verticalSize][horizontalSize];
    }

    void randomMyDblArray() {
        for (int i = 0; i < verticalSize; i++)
            for (int j = 0; j < horizontalSize; j++) {
                a[i][j] = random.nextInt(100);
            }
    }

    /**
     * сортировка двумерного массива без использования
     * дополнительных массивов и методов класса Arrays
     *
     * @return void
     * @autor Vera Miasnikova
     */
    void sortingMyDblArray() {
        int lineNumber, columnNumber = 0, elementNumber = 0, columnStart, temp;
        while (elementNumber < verticalSize * horizontalSize - 1) {
            lineNumber = elementNumber / horizontalSize;
            if (columnNumber == horizontalSize) {
                columnNumber = 0;
            }
            for (int i = lineNumber; i < verticalSize; i++) {
                if (i == lineNumber) {
                    columnStart = elementNumber % horizontalSize + 1;
                } else {
                    columnStart = 0;
                }
                for (int j = columnStart; j < horizontalSize; j++, columnStart++) {
                    if (a[lineNumber][columnNumber] < a[i][j]) {
                        temp = a[i][j];
                        a[i][j] = a[lineNumber][columnNumber];
                        a[lineNumber][columnNumber] = temp;
                    }
                }
            }
            elementNumber++;
            columnNumber++;
        }
    }

    void sortingMyDblArrayWithArrays() {
        int[] array = new int[verticalSize * horizontalSize];
        int index = 0;
        for (int[] temp : a)
            for (int element : temp) {
                array[index++] = element;
            }
        Arrays.sort(array);
        index = 0;
        for (int i = 0; i < verticalSize; i++)
            for (int j = 0; j < horizontalSize; j++) {
                a[i][j] = array[index++];
            }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int array[] : a) {
            for (int element : array) {
                s.append(String.format("%4d", element));
            }
            s.append(String.format("%n"));
        }
        return s.toString();
    }


}
