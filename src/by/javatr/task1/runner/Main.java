package by.javatr.task1.runner;

import by.javatr.task1.util.Array;
import by.javatr.task1.util.ArrayService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Array array1 = new Array( ArrayService.fillArrayFromFile() );
        Array array2 = new Array( ArrayService.fillArrayRandom() );
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter array length: " );
        int size = input.nextInt();
        int[] array = new int[size];
        System.out.println( "Insert array elements:" );
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }
        Array array3 = new Array( size, array );
        System.out.println( array1.toString() );
        System.out.println( array2.toString() );
        System.out.println( array3.toString() );
    }
}
