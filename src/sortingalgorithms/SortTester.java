/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import static sortingalgorithms.Sorts.mergeSort;
import static sortingalgorithms.Sorts.quickSort;

public class SortTester {

    public static void PrintTableHeader() {
        System.out.format("+----------+----------+----------------+----------------+%n");
        System.out.format("|     n    | n trials | MergeSort Wins |  QuckSort Wins |%n");
        System.out.format("+----------+----------+----------------+----------------+%n");
    }

    public static void PrintRow(int[] nums) {
        String leftAlignFormat = "| %-8s | %-8d | %-14d | %-14d |%n";
        System.out.format(leftAlignFormat, "n=" + nums[0], nums[1], nums[2], nums[3]);
        System.out.format("+----------+----------+----------------+----------------+%n");

    }

    public static void experimentOne() {
//, 100, 1000, 10000, 100000, 1000000, 2000000
        int[] nSize = {10};
        int[] test = populateArray(20);
        int trialCount = 1;

//        int r[] = {1,2000000,51245,214425};
//        PrintTableHeader();
//        PrintRow(r);
        // System.out.println(Arrays.toString(test));
        //
        for (int x = 0; x < 1; x++) {
            for (int y = 0; y < trialCount; trialCount++) {
                 int[] trial = new int[10];
                 trial = (populateArray(nSize[0])).clone();

//                start();
 //               mergeSort(trial);
//                stop();
//                getElapsedTime();
//                reset();

//                start();
//                 quickSort(trial);
//                stop();
//                getElapsedTime();
//                reset();
                
                // System.out.println(Arrays.toString(trial));
            }
        }
    }

    public static int[] populateArray(int n) {
        int[] anArray = new int[n];
        Random randomno = new Random();
        for (int i = 0; i < anArray.length; i++) {
            anArray[i] = randomno.nextInt(1000000) + 1;
        }
        return anArray;
    }

    public static void experimentTwo() {

    }

    private static long startTime = -1;
    private static long stopTime = -1;
    private static boolean running = false;

    public static void start() {
        startTime = System.currentTimeMillis();
        running = true;
    }

    public static void stop() {
        stopTime = System.currentTimeMillis();
        running = false;
    }

    public static long getElapsedTime() {
        if (startTime == -1) {
            return 0;
        }
        if (running) {
            return System.currentTimeMillis() - startTime;
        } else {
            return stopTime - startTime;
        }
    }

    public static void reset() {
        startTime = -1;
        stopTime = -1;
        running = false;
    }

    public static void printTable(String[][] table) {
        // Find out what the maximum number of columns is in any row
        int maxColumns = 0;
        for (int i = 0; i < table.length; i++) {
            maxColumns = Math.max(table[i].length, maxColumns);
        }

        // Find the maximum length of a string in each column
        int[] lengths = new int[maxColumns];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                lengths[j] = Math.max(table[i][j].length(), lengths[j]);
            }
        }

        // Generate a format string for each column
        String[] formats = new String[lengths.length];
        for (int i = 0; i < lengths.length; i++) {
            formats[i] = "%1$" + lengths[i] + "s"
                    + (i + 1 == lengths.length ? "\n" : " ");
        }

        // Print 'em out
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf(formats[j], table[i][j]);
            }
        }
    }

}

//        String company = "Experiment #1\n";
//        List<String> t2Headers = Arrays.asList("n", "nTrials", "# mergeSort Wins", "# quicksortWins");
//        List<List<String>> t2Rows = Arrays.asList(
//                Arrays.asList("10", "20", var1, var2),
//       start();
//            // your code runs here
//            stop();
//System.out.println("hello");
//            System.err.println("elapsed time: " + getElapsedTime());    
