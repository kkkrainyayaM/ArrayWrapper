package by.javatr.task1.util;

import java.util.Arrays;

public class Array {
    private static final int initialSize = 30;
    private int[] array;

    public Array(int[] array) {
        setArray( array );
    }

    public Array(int size, int[] array) {
        if( size == 0 ) throw new IllegalArgumentException( "size couldn't be null" );
        this.array = new int[size];
        for (int i = 0; i < size - 1; i++) {
            this.array[i] = array[i];
        }
    }

    public Array() {
        array = new int[initialSize];
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] arr) {
        if( arr == null ) throw new IllegalArgumentException( "array couldn't be null" );
        this.array = arr;
    }


    public int getIndexOf(int key) {
        return binarySearch( shellSort(), key );
    }

    public int getMin() {
        int min = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if( array[i - 1] < array[i] ) min = array[i - 1];
        }
        return min;
    }

    public int getMax() {
        int max = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if( array[i - 1] > array[i] ) max = array[i - 1];
        }
        return max;
    }

    public int[] getFibonacci() {
        int[] newArray = new int[initialSize];
        int count = 0;
        int[] fibonachi = ArrayService.getAllFibonacci();
        for (int i = 0; i < initialSize - 1; i++) {
            for (int j = 0; j < initialSize - 1; j++) {
                if( array[i] == array[j] ) {
                    newArray[count++] = array[i];
                    break;
                }
            }
        }
        return newArray;
    }

    public int[] getThreeeDgNumWithNoSameDg() {
        int[] newArray = new int[initialSize];
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if( array[i] > 99 && array[i] < 1000 ) {
                if( (array[i] / 100) != (array[i] / 10) && ((array[i] / 10) != (array[i] % 10))
                        && ((array[i] / 100) != (array[i] % 10)) ) {
                    newArray[count++] = array[i];
                    break;
                }
            }
        }
        return newArray;
    }

    public int[] getAllSimpleNums() {
        int[] simple = new int[initialSize];
        int count = 0;
        boolean key = true;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 2; j < array[i]; j++) {
                if( array[i] % j == 0 ) {
                    key = false;
                    break;
                }
            }
            if( key = true ) {
            }
            simple[count] = array[i];
            count++;
        }
        return simple;
    }

    public int binarySearch(int[] sortedArray, int key) {
        int index = -1, low = 0, high = sortedArray.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if( sortedArray[mid] < key ) {
                low = mid + 1;
            }
            else if( sortedArray[mid] > key ) {
                high = mid - 1;
            }
            else if( sortedArray[mid] == key ) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public int[] bubbleSort() {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if( array[j] > array[j + 1] ) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    public int[] inseertionSort() {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return array;
    }

    public int[] shellSort() {
        int n = array.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {

                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap)
                    array[j] = array[j - gap];

               
                array[j] = temp;
            }
        }
        return array;
    }

    @Override
    public boolean equals(Object o) {
        if( this == o ) return true;
        if( !(o.getClass() == Array.class) ) return false;
        Array array1 = (Array) o;
        return Arrays.equals( getArray(), array1.getArray() );
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode( getArray() );
    }

    @Override
    public String toString() {
        return "Array{" +
                "util=" + Arrays.toString( array ) +
                '}';
    }
}