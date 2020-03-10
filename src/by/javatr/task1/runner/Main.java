package by.javatr.task1.runner;

import by.javatr.exceptions.NullArgumentException;
import by.javatr.task1.entities.Array;
import by.javatr.task1.entities.ArrayService;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner( System.in );

            Array array1 = new Array( ArrayService.fillArrayFromFile() );
            Array array2 = new Array( ArrayService.fillArrayRandom() );

            System.out.println( "ENTER ARRAY LENGTH: " );
            int size = input.nextInt();
            int[] array = new int[size];

            System.out.println( "INSERT ARRAY ELEMENTS: " );
            Arrays.stream( array ).forEach( x -> x = input.nextInt() );
            Array array3 = new Array( array );

            System.out.println( array1.toString() );
            System.out.println( array2.toString() );
            System.out.println( array3.toString() );
        }
        catch (NullArgumentException e) {
            e.printStackTrace();
        }
    }
}
