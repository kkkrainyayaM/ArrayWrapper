package by.javatr.task2.runner;

import by.javatr.task2.util.MatrixUtils;

public class Main {

    public static void main(String[] args) {

        int[][] matrix = MatrixUtils.generateMatrix();
        System.out.println( "NOT SORTED MATRIX:" );
        MatrixUtils.printMatrix( matrix );

        MatrixUtils.sortRowsBy( matrix, MatrixUtils::compareBySum );
        System.out.println( "\nSORTED MATRIX BY SUM:" );
        MatrixUtils.printMatrix( matrix );

        MatrixUtils.sortRowsBy( matrix, MatrixUtils::compareByMaxValue );
        System.out.println( "\nSORTED MATRIX BY MAX VALUE:" );
        MatrixUtils.printMatrix( matrix );

        MatrixUtils.sortRowsBy( matrix, MatrixUtils::compareByMinValue );
        System.out.println( "\nSORTED MATRIX BY MIN VALUE:" );
        MatrixUtils.printMatrix( matrix );
    }
}