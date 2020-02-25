package by.javatr.task1.util;

import java.io.FileReader;
import java.io.IOException;

public class ArrayService {

    private static final int limit = 30;

    public static int[] getAllFibonacci() {
        int[] f = new int[limit];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < limit; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static int[] fillArrayRandom() {
        int[] array = new int[limit];
        for (int i = 0; i < limit - 1; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

    public static int[] fillArrayFromFile() {
        int[] array = new int[limit];
        try {
            FileReader fileReader = new FileReader( "array.txt" );
            int num, i = 0;
            while ((num = fileReader.read()) != -1) {
                array[i] = num;
                i++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }
}
