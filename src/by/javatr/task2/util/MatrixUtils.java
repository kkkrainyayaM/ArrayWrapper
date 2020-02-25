package by.javatr.task2.util;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;

public final class MatrixUtils {

    private MatrixUtils() {
    }

    private static final Random RANDOM = new Random();
    private static final int MAX_VALUE = 100;
    private static final int MAX_ROWS_COUNT = 5;
    private static final int MAX_COLUMNS_COUNT = 5;

    public static int[][] generateMatrix() {
        //to avoid zero - +1
        int rowsCount = RANDOM.nextInt( MAX_ROWS_COUNT ) + 1;
        int[][] result = new int[rowsCount][];
        for (int i = 0; i < rowsCount; i++) {
            result[i] = new int[RANDOM.nextInt( MAX_COLUMNS_COUNT ) + 1];
            fillArray( result[i] );
        }
        return result;
    }

    public static void sortRowsBy(int[][] matrix, Comparator<int[]> comparator) {
        for (int i = matrix.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if( comparator.compare( matrix[j], matrix[j + 1] ) > 0 ) {
                    int[] temp = matrix[j];
                    matrix[j] = matrix[j + 1];
                    matrix[j + 1] = temp;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] matrix1 : matrix) {
            for (int i : matrix1) {
                System.out.print( i + "\t" );
            }
            System.out.println();
        }
    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = RANDOM.nextInt( MAX_VALUE );
        }
    }

    public static int compareBySum(int[] array1, int[] array2) {
        int sum1 = IntStream.of( array1 ).sum();
        int sum2 = IntStream.of( array2 ).sum();
        return sum1 - sum2;
    }

    public static int compareByMaxValue(int[] array1, int[] array2) {
        int max1 = IntStream.of( array1 ).max().orElse( 0 );
        int max2 = IntStream.of( array2 ).max().orElse( 0 );
        return max1 - max2;
    }

    public static int compareByMinValue(int[] array1, int[] array2) {
        int min1 = IntStream.of( array1 ).min().orElse( 0 );
        int min2 = IntStream.of( array2 ).min().orElse( 0 );
        return min1 - min2;
    }
}