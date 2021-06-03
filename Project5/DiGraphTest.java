// Roey Mevorach and Tyler Hart
// rmevorac and tyhart
// 5/24/2021
// Project 5

import java.util.*;
import java.io.File;
import java.util.Arrays;
import java.io.FileNotFoundException;

class DiGraphTest {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.println("Enter number of vertices");

      int from, to, src;
      int N = sc.nextInt();
      DiGraph digraph = new DiGraph(N);

      System.out.println("Choose one of the following operations:");
      System.out.println("-add edge (enter a)\n-delete edge (enter d)\n-edge count (enter e)");
      System.out.println("-vertex count (enter v)\n-print graph (enter p)\n-Quit (enter q)");

      while (true) {
         String s = sc.next();
         String fake = sc.nextLine();
         char in = s.charAt(0);
         
         if (in == 'q') {
            System.out.println("Good bye.");
            return;
         }

         try {
            if(s.length() > 1 || fake.length() > 0)
            {
               throw new IllegalArgumentException();
            }
            switch (in) {
               case 'a':
                  System.out.println("Enter vertices (from then to):");
                  from = sc.nextInt();
                  to = sc.nextInt();
                  digraph.addEdge(from, to);
                  break;

               case 'b':
                  System.out.println("Enter source vertex:");
                  src = sc.nextInt();
                  digraph.printTree(src);
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
               
               case 'i':
                  System.out.println("Enter vertices (from then to):");
                  from = sc.nextInt();
                  to = sc.nextInt();
                  System.out.println(digraph.isTherePath(from, to));
                  break;

               case 'l':
                  System.out.println("Enter vertices (from then to):");
                  from = sc.nextInt();
                  to = sc.nextInt();
                  System.out.println("length = " + digraph.lengthOfPath(from, to));
                  break;

               case 'p':
                  digraph.print();
                  break;
               
               case 's':
                  System.out.println("Enter vertices (from then to):");
                  from = sc.nextInt();
                  to = sc.nextInt();
                  digraph.printPath(from, to);
                  break;

               case 't':
                  int[] result = digraph.topSort();
                  System.out.println("Topsorted List:");
                  for(int i = 0; i < digraph.vertexCount()-1; i++)
                  {
                     System.out.print(result[i] + ", ");
                  }
                  System.out.println(result[digraph.vertexCount()-1]);
                  break;

               case 'v':
                  int numVert = digraph.vertexCount();
                  System.out.println("Number of vertices is " + numVert);
                  break;

               default:
                  throw new IllegalArgumentException();
            }
         }

         catch(IllegalArgumentException e) {
            System.out.println("Illegal Argument Exception");
         }
      }
   }
}