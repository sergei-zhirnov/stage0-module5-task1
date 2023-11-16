package com.epam.mjc.stage0;

/**
 * Here are the tasks for working with the arrays.
 * <p>
 * The usage of any additional packages (such as java.util.*) is forbidden.
 */
public class ArrayTasks {

    /**
     * Return a String[] array that will list all the seasons of the year, starting with winter.
     */
    public String[] seasonsArray() {
        String[] seasons = {"winter", "spring", "summer", "autumn"};
        return seasons;

    }

    /**
     * Generate an int[] array of consecutive positive integers
     * starting at 1 of the given length (length parameter > 0).
     * <p>
     * Example:
     * <p>
     * length = 1  -> [1]
     * length = 3  -> [1, 2, 3]
     * length = 5  -> [1, 2, 3, 4, 5]
     */
    public int[] generateNumbers(int length) {
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = i + 1;
        }
        return numbers;


    }

    /**
     * Find the sum of all elements of the int[] array.
     * <p>
     * Example:
     * <p>
     * arr = [1, 3, 5]   -> sum = 9
     * arr = [5, -3, -4] -> sum = -2
     */
    public int totalSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * Return the index of the first occurrence of number in the arr array.
     * If there is no such element in the array, return -1.
     * <p>
     * Example:
     * <p>
     * arr = [99, -7, 102], number = -7    ->   2
     * arr = [5, -3, -4],   number = 10    ->  -1
     */
    public int findIndexOfNumber(int[] arr, int number) {
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                result = i;
                break;
            }
        }
        return result;

    }

    /**
     * Return the new String[] array obtained from the arr array
     * by reversing the order of the elements.
     * <p>
     * Example:
     * <p>
     * arr = ["Bob", "Nick"]               -> ["Nick", "Bob"]
     * arr = ["pineapple", "apple", "pen"] -> ["pen", "apple", "pineapple"]
     */
    public String[] reverseArray(String[] arr) {
       String[] reversedArr = new String[arr.length];
       for (int i = 0; i < arr.length; i++) {
           reversedArr[i] = arr[arr.length-i-1];
       }
       return reversedArr;
    }

    /**
     * Return new int[] array obtained from arr int[] array
     * by choosing positive numbers only.
     * P.S. 0 is not a positive number =)
     * <p>
     * Example:
     * <p>
     * arr = [1,-2, 3]      -> [1, 3]
     * arr = [-1, -2, -3]   -> []
     * arr = [1, 2]         -> [1, 2]
     */
    public int[] getOnlyPositiveNumbers(int[] arr) {
        int arrLen = arr.length;
        int positiveArrLen = 0;
        for (int i = 0; i < arrLen; i++) {
            if (arr[i] > 0) {
                positiveArrLen +=1;
            }
        }

        int[] positiveArr = new int[positiveArrLen];
        int j = 0;
        for (int i = 0; i < arrLen; i++) {
            if (arr[i] > 0) {
                positiveArr[j] = arr[i];
                ++j;
            }
        }

        return positiveArr;

    }


    /**
     * Return a sorted, ragged, two-dimensional int[][] array following these rules:
     * Incoming one-dimensional arrays must be arranged in ascending order of their length;
     * numbers in all one-dimensional arrays must be in ascending order.
     * <p>
     * Example:
     * <p>
     * arr = [[3, 1, 2,], [3,2]] -> [[2, 3], [1, 2, 3]]
     * arr = [[5, 4], [7]]       -> [[7], [4, 5]]
     */
    public static int[][] sortRaggedArray(int[][] arr) {
        int len = arr.length;

        // Sorting internal arrays
        for (int i = 0; i < len; i++) {
            int wid = arr[i].length;
            for (int j = 0; j < wid; j++) {
                for (int k = j + 1; k < wid; k++) {
                    int tmp = 0;
                    if (arr[i][j] > arr[i][k]) {
                        tmp = arr[i][j];
                        arr[i][j] = arr[i][k];
                        arr[i][k] = tmp;
                    }
                }
            }
        }

        // Sorting array of arrays
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int wid = arr[i].length;
                int[] tmp = new int[wid];
                if (arr[i].length > arr[j].length) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }




        // Printing items for debug
        for (int i = 0; i < len; i++) {
            int localWid = arr[i].length;
            System.out.println("Array #" + i);
            for (int j = 0; j < localWid; j++) {
                System.out.println("Element #" + j + " = " + arr[i][j]);
            }
        }

      //  int[][] sortedArr = new int[len][];
        return arr;

    }

    public static void main(String[] args) {
        int[][] array = new int[4][];
        array[0] = new int[]{3, 1, 2};
        array[1] = new int[]{5, 4};
        array[2] = new int[]{7, 9, 6, 8};
        array[3] = new int[]{4, 6, 2};

        sortRaggedArray(array);
    }


}
