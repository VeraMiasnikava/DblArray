package com.example.dblArray;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MyDblArray {
    private int[][] a;
    private int horizontalSize;
    private int verticalSize;
    private Random random = new Random();

    MyDblArray(int verticalSize, int horizontalSize) {
        //конструктор
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;
        a = new int[verticalSize][horizontalSize];
    }

    void randomMyDblArray() {
        //заполнение массива
        for (int i = 0; i < verticalSize; i++)
            for (int j = 0; j < horizontalSize; j++) {
                a[i][j] = random.nextInt(100);
            }
    }

    void sortingMyDblArray() {
        /*сортировка двумерного массива без использования
        дополнительных массивов и методов класса Arrays*/
        int k, t = 0, c = 0, p = 0, temp;
        while (c < verticalSize * horizontalSize - 1) {
            k = c / horizontalSize;
            if (t == horizontalSize) {
                t = 0;
            }
            for (int i = k; i < verticalSize; i++) {
                if (i == k) {
                    p = c % horizontalSize + 1;
                } else {
                    p = 0;
                }
                for (int j = p; j < horizontalSize; j++, p++) {
                    if (a[k][t] < a[i][j]) {
                        temp = a[i][j];
                        a[i][j] = a[k][t];
                        a[k][t] = temp;
                    }
                }
            }
            c++;
            t++;
        }
    }

    void sortingMyDblArrayWithArrays() {
        //сортировка массива с использованием метода
        //класса Arrays
        int[] array = new int[verticalSize * horizontalSize];
        int t = 0;
        for (int[] temp : a)
            for (int element : temp) {
                array[t++] = element;
            }
        Arrays.sort(array);
        t = 0;
        for (int i = 0; i < verticalSize; i++)
            for (int j = 0; j < horizontalSize; j++) {
                a[i][j] = array[t++];
            }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("");
        for (int array[] : a) {
            for (int element : array) {
                s.append(String.format("%4d", element));
            }
            s.append(String.format("%n"));
        }
        return s.toString();
    }

}
