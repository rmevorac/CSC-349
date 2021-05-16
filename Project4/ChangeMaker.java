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

   public static void main(String[] args) throws FileNotFoundException {
      System.out.println("Please enter the filename:");
      Scanner sc = new Scanner(System.in);
      String fname = sc.next();
      File file = new File(fname);
      try {
         Scanner fsc = new Scanner(file);
      }

      catch (FileNotFoundException ex) {
         System.out.println("File does not exist");
      }
   }
}