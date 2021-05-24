// Roey Mevorach and Tyler Hart
// rmevorac and tyhart
// 5/24/2021
// Project 5

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class DiGraph {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int x = sc.nextInt();

      while (true) {
         System.out.println("Choose one of the following operations:");
         System.out.println("-add edge (enter a)\n-delete edge (enter d)\n-edge count (enter e)");
         System.out.println("-vertex count (enter v)\n-print graph (enter p)\n-Quit (enter q)");
         char in = sc.nextInt();
         
         if(in == 'q') {
            System.out.println("Thanks for playing. Good Bye.");
            return;
         }

         try {
            //enter method calls here
         }
         catch(IllegalArgumentException e) {
            System.out.println("Input Error");
         }
      }
   }
}