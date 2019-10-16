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
            if (verticalSize < 3 || horizontalSize < 3)
                throw new MyDblArrayException("неверно указаны размеры массива!");
            MyDblArray a = new MyDblArray(verticalSize, horizontalSize);
            a.randomMyDblArray();
            System.out.println("Исходный массив:");
            System.out.println(a.toString());
            a.sortingMyDblArray();
           // a.sortingMyDblArrayWithArrays();
            System.out.println("Отсортированный массив:");
            System.out.println(a.toString());
        } catch (MyDblArrayException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("введено не целое число!");
        }


    }

}

