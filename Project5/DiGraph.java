// Roey Mevorach and Tyler Hart
// rmevorac and tyhart
// 5/24/2021
// Project 5

import java.util.*;
import java.io.File;
import java.util.Arrays;
import java.io.FileNotFoundException;

class DiGraph {
   private ArrayList<LinkedList<Integer>> graph;

   DiGraph(int N){
      System.out.println("DiGraph constructor initialized");
      graph = new ArrayList<LinkedList<Integer>>(N);

      for (int i = 0; i < N; i++) {
         graph.add(new LinkedList<Integer>());
      }
   }

   public void deleteEdge(int from, int to) {
      if (graph.get(from - 1).contains(to)) {
         graph.get(from - 1).remove(Integer.valueOf(to));
         System.out.println("(" + from + ", " + to + ") " + "edge is now removed from the graph");
      }

      System.out.println("Edge does not exist");
   }
   public void addEdge(int from, int to) {
      if (!graph.get(from - 1).contains(to)) {
         graph.get(from - 1).add(to);
         System.out.println("(" + from + ", " + to + ") " + "edge is now added to the graph");
      }

      else {
         System.out.println("Edge already exists");
      }
   }
   public int edgeCount() {
      int count = 0;
      for (int i = 0; i < graph.size(); i++) {
         count += graph.get(i).size();
      }
      return count;
   }

   public int vertexCount() {
      return graph.size();
   }

   public void print() {
      System.out.println("The graph is the following: ");
      for (int i = 0; i < vertexCount(); i++) {
         System.out.print((i + 1) + " is connected to: ");
         for (int j = 0; j < graph.get(i).size(); j++) {
            System.out.print(graph.get(i).get(j));

            if (j + 1 < graph.get(i).size()) {
               System.out.print(", ");
            }
         }

         System.out.print("\n");
      }
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.println("Enter number of vertices");

      int from, to;
      int N = sc.nextInt();
      DiGraph digraph = new DiGraph(N);

      System.out.println("Choose one of the following operations:");
      System.out.println("-add edge (enter a)\n-delete edge (enter d)\n-edge count (enter e)");
      System.out.println("-vertex count (enter v)\n-print graph (enter p)\n-Quit (enter q)");

      while (true) {
         char in = sc.next().charAt(0);
         
         if (in == 'q') {
            System.out.println("Thanks for playing. Good Bye.");
            return;
         }

         try {
            switch (in) {
               case 'a':
                  System.out.println("Enter vertices (from then to):");
                  from = sc.nextInt();
                  to = sc.nextInt();
                  digraph.addEdge(from, to);
                  break;

               case 'd':
                  System.out.println("Enter vertices (from then to):");
                  from = sc.nextInt();
                  to = sc.nextInt();
                  digraph.deleteEdge(from, to);
                  break;

               case 'e':
                  int numEdges = digraph.edgeCount();
                  System.out.println("Number of edges is " + numEdges);
                  break;

               case 'v':
                  int numVert = digraph.vertexCount();
                  System.out.println("Number of vertices is " + numVert);
                  break;

               case 'p':
                  digraph.print();
                  break;

               default:
                  throw new IllegalArgumentException();
            }
         }

         catch(IllegalArgumentException e) {
            System.out.println("Input Error: this is an invalid menu choice");
         }
      }
   }

}