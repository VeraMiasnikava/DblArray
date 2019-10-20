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
            System.out.println(String.format("Исходный массив:%n") + a.toString());
            a.sortingMyDblArray();
            // a.sortingMyDblArrayWithArrays();
            System.out.println("Отсортированный массив:");
            System.out.println(a.toString());
        } catch (InputMismatchException e) {
            System.out.println("введено не целое число!");
        } catch (NullPointerException e) {
            System.out.println("массив не создан!");
        }


    }

}

