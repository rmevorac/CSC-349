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
      else
         System.out.println("Edge does not exist");
   }
   public void addEdge(int from, int to) {
      if (!graph.get(from - 1).contains(to)) {
         graph.get(from - 1).add(to);
         System.out.println("(" + from + "," + to + ") edge is now added to the graph");
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
   private int[] indegrees()
   {
      int[] indegs = new int[graph.size()];
      for(int i = 0; i < graph.size(); i++)
      {
         //System.out.println("i = " + i);
         for(int q = 0; q < graph.get(i).size();q++)
         {
            //System.out.println("q = " + q);
            indegs[graph.get(i).get(q)-1] = indegs[graph.get(i).get(q)-1] + 1;
         }
      }
      return indegs;
   }
   public int[] topSort()
   {
      LinkedList<Integer> queue = new LinkedList<Integer>();
      int[] result = new int[graph.size()];
      int[] indegs = indegrees();
      for(int i = 0; i < graph.size(); i++)
      {
         if(indegs[i] == 0)
         {
            queue.addLast(i+1);
         }
      }
      int i = 0;
      while(!queue.isEmpty())
      {
         int u = queue.removeFirst();
         result[i] = u;
         i++;
         for(int v = 0; v < graph.get(u-1).size();v++)
         {
            indegs[graph.get(u-1).get(v)-1] = indegs[graph.get(u-1).get(v)-1]-1;
            if(indegs[graph.get(u-1).get(v)-1] == 0)
            {
               queue.addLast(graph.get(u-1).get(v));
            }
         }
      }
      if(i < graph.size())
      {
         System.out.println("Cycle Detected!");
         throw new IllegalArgumentException();
      }
      return result;
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
         String fake = sc.nextLine();
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

               case 't':
                  int[] result = digraph.topSort();
                  System.out.println("Topsorted List:");
                  for(int i = 0; i < digraph.vertexCount()-1; i++)
                  {
                     System.out.print(result[i] + ", ");
                  }
                  System.out.println(result[digraph.vertexCount()-1]);
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