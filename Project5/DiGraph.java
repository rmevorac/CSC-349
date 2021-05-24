// Roey Mevorach and Tyler Hart
// rmevorac and tyhart
// 5/24/2021
// Project 5

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class DiGraph {
   private Array<LinkedList> graph;

   DiGraph(int N){
      System.out.println("DiGraph constructor init");
      graph = new Array<LinkedList>(N);
   }

   public void deleteEdge(int from, int to) {
      if (graph[from].contains(to)) {
         graph[from].remove(to);
      }
   }
   public void addEdge(int from, int to) {
      if(!graph[from].contains(to)) {
         graph[from].add(to);
      }
   }
   public int edgeCount()
   {
      int count = 0;
      for(int i = 0; i <= graph.length; i++)
      {
         for(int q = 0; q <= graph[i].length; q++)
         {
            count++;
         }
      }
      return count;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int x = sc.nextInt();

      while (true) {
         System.out.println("Choose one of the following operations:");
         System.out.println("-add edge (enter a)\n-delete edge (enter d)\n-edge count (enter e)");
         System.out.println("-vertex count (enter v)\n-print graph (enter p)\n-Quit (enter q)");
         char in = sc.nextByte();
         
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