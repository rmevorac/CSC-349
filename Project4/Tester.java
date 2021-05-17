// Roey Mevorach and Tyler Hart
// rmevorac and tyhart
// 5/17/2021
// Project 4

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

class Tester {

   public static void main(String[] args) {
      int count = 0;
      int[] A = new int[9];
      int[] B = new int[9];
      int[] arr1 = {100, 50, 25, 10, 5, 1};
      int[] arr2 = {100, 50, 20, 15, 10, 5, 3, 2, 1};
      int[] arr3 = {64, 32, 16, 8, 4, 2, 1};
      int[] arr4 = {100, 50, 25, 10, 1};
      int[] arr5 = {66, 35, 27, 18, 10, 1};

      System.out.print("Testing change_DP and change_greedy algorithms\nTesting set1: x");

      for (int i = 1; i <= 200; i++) {
         A = ChangeMaker.change_DP(i, arr1);
         B = ChangeMaker.change_greedy(i, arr1);
         if (Arrays.stream(A).sum() == Arrays.stream(B).sum()) {
            count++;
         }
      }

      System.out.print(count + " matches in 200 tests\nTesting set2: x");
      count = 0;

      for (int i = 1; i <= 200; i++) {
         A = ChangeMaker.change_DP(i, arr2);
         B = ChangeMaker.change_greedy(i, arr2);
         if (Arrays.stream(A).sum() == Arrays.stream(B).sum()) {
            count++;
         }
      }

      System.out.print(count + " matches in 200 tests\nTesting set3: x");
      count = 0;

      for (int i = 1; i <= 200; i++) {
         A = ChangeMaker.change_DP(i, arr3);
         B = ChangeMaker.change_greedy(i, arr3);
         if (Arrays.stream(A).sum() == Arrays.stream(B).sum()) {
            count++;
         }
      }

      System.out.print(count + " matches in 200 tests\nTesting set4: x");
      count = 0;

      for (int i = 1; i <= 200; i++) {
         A = ChangeMaker.change_DP(i, arr4);
         B = ChangeMaker.change_greedy(i, arr4);
         if (Arrays.stream(A).sum() == Arrays.stream(B).sum()) {
            count++;
         }
      }

      System.out.print(count + " matches in 200 tests\nTesting set5: x");
      count = 0;

      for (int i = 1; i <= 200; i++) {
         A = ChangeMaker.change_DP(i, arr5);
         B = ChangeMaker.change_greedy(i, arr5);
         if (Arrays.stream(A).sum() == Arrays.stream(B).sum()) {
            count++;
         }
      }

      System.out.println(count + " matches in 200 tests");
   }
}