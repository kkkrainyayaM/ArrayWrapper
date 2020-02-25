package by.javatr.task1.runner;

import by.javatr.task1.entities.Array;
import by.javatr.task1.entities.ArrayService;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner( System.in );

        Array array1 = new Array( ArrayService.fillArrayFromFile() );
        Array array2 = new Array( ArrayService.fillArrayRandom() );

        System.out.println( "ENTER ARRAY LENGTH: " );
        int size = input.nextInt();
        if(size<0) throw new IndexOutOfBoundsException( "Length couldn't be less 0" );
        System.out.println( "INSERT ARRAY ELEMENTS: " );
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }
        Array array3 = new Array( array );

        System.out.println( array1.toString() );
        System.out.println( array2.toString() );
        System.out.println( array3.toString() );
    }
}
