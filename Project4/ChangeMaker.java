// Roey Mevorach and Tyler Hart
// rmevorac and tyhart
// 5/17/2021
// Project4

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class ChangeMaker {

   public static int[] change_DP(int n, int[] d) {
      
      return d;
   }

   public static void main(String[] args) {
      int i;
      System.out.println("Enter the number of coin-denominations and the set of coin values:");
      Scanner sc = new Scanner(System.in);
      int x = sc.nextInt();
      int[] d = new int[x];
      for(i = 0; i < x; i++)
         d[i] = sc.nextInt();
      System.out.println("Enter a positive amount to be changed (enter 0 to quit):");
      int n = sc.nextInt();
      if(n == 0)
         return;
      System.out.print("Coin array of size " + x + ": ");
      for(i = 0; i < x; i++)
         System.out.print("["+ d[i] + "] ");
      System.out.println("\nAmount to be changed: " + n);
      try{
         int[] s = change_DP(n,d);
      }
      catch(IllegalArgumentException e) {
         System.out.println("Input Error");
      }
      String od = "ASSIGN OPTIMAL DISTRIBUTION HERE";
      int cc = 0;
      System.out.println("DP algorithm results\nAmount: " + n + "\nOptimal distribution: " + od);
      System.out.println("Optimal coin count: " + cc);
   }
}