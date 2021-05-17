// Roey Mevorach and Tyler Hart
// rmevorac and tyhart
// 5/17/2021
// Project 4

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class ChangeMaker {

   public static int[] change_DP(int n, int[] d) {
      int k = d.length;
      int[] C = new int[n+1];
      int[] A = new int[n+1];
      int[] B = new int[k];
      int x;
      C[0] = 0;
      for(x = 1; x <= n; x++) {
         int min = 100000;
         for(int m = 0; m < k; m++) {
            if(x - d[m] >= 0) {
               if(C[x-d[m]] < min) {
                  A[x] = m;
                  min = C[x-d[m]];
               }
            }
         }

         C[x] = 1 + min;
      }

      int i = n;
      while(i > 0) {
         B[A[i]]++;
         i = i - d[A[i]];
      }
      return B;
   }

   public static int[] change_greedy(int n, int[] d) {
      int k = d.length, i = 0;
      int[] B = new int[k];

      while (i < k) {
         if (d[i] <= n) {
            B[i]++;
            n -= d[i];
         }

         else {
            i++;
         }
      }

      return B;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int i;
      System.out.println("Enter the number of coin-denominations and the set of coin values in decreasing order:");
      int x = sc.nextInt();
      int[] d = new int[x];

      for(i = 0; i < x; i++)
         d[i] = sc.nextInt();

      while (true) {
         System.out.println("Enter a positive amount to be changed (enter 0 to quit):");
         int n = sc.nextInt();
         
         if(n == 0) {
            System.out.println("Thanks for playing. Good Bye.");
            return;
         }

         int[] B = new int[x];
         
         try {
            B = change_DP(n,d);
         }
         catch(IllegalArgumentException e) {
            System.out.println("Input Error");
         }

         int cc = 0;
         System.out.print("DP algorithm results\nAmount: " + n + "\nOptimal distribution:");
         for(i = 0; i < x; i++) {
            if(B[i] > 0) {
               if(cc !=0)
                  System.out.print(" +");
               System.out.print(" " + B[i] + "*" + d[i] + "c");
               cc += B[i];
            }
         }

         System.out.println("\nOptimal coin count: " + cc);

         try {
            B = change_greedy(n, d);
         }
         catch(IllegalArgumentException e) {
            System.out.println("Input Error");
         }

         cc = 0;
         System.out.print("\nGreedy algorithm results\nAmount: " + n + "\nOptimal distribution:");
         for(i = 0; i < x; i++) {
            if(B[i] > 0) {
               if(cc !=0)
                  System.out.print(" +");
               System.out.print(" " + B[i] + "*" + d[i] + "c");
               cc += B[i];
            }
         }

         System.out.println("\nOptimal coin count: " + cc + "\n");
      }
   }
}