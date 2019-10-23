package com.example.dblArray;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        int verticalSize, horizontalSize;
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите размеры массива:" +
                    "количество строк и столбцов >2");
            verticalSize = in.nextInt();
            horizontalSize = in.nextInt();
            MyDblArray a = new MyDblArray(verticalSize, horizontalSize);
            a.randomMyDblArray();
            System.out.println(String.format("Исходный массив:%n%s", a));
            a.sortingMyDblArray();
            // a.sortingMyDblArrayWithArrays();
            System.out.println(String.format("Отсортированный массив:%n%s", a));
        } catch (InputMismatchException e) {
            System.out.println("введено не целое число!");
        } catch (InvalidArraySizeException e) {
            System.out.println(e.getMessage());
        }


    }

}

