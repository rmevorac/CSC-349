// Roey Mevorach and Tyler Hart
// rmevorac and tyhart
// 5/24/2021
// Project 5

import java.util.*;
import java.io.File;
import java.util.Arrays;
import java.io.FileNotFoundException;
private class VertexInfo {
   int distance;
   int parent;
   VertexInfo()
   {
      this.distance = 0;
      this.parent = 0;
   }
}
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

   private int[] indegrees() {
      int[] indegs = new int[graph.size()];
      for(int i = 0; i < graph.size(); i++) {
         for(int q = 0; q < graph.get(i).size();q++) {
            indegs[graph.get(i).get(q)-1] = indegs[graph.get(i).get(q)-1] + 1;
         }
      }
      return indegs;
   }

   public int[] topSort() {
      LinkedList<Integer> queue = new LinkedList<Integer>();
      int[] result = new int[graph.size()];
      int[] indegs = indegrees();
      for(int i = 0; i < graph.size(); i++) {
         if(indegs[i] == 0) {
            queue.addLast(i+1);
         }
      }
      int i = 0;
      while(!queue.isEmpty()) {
         int u = queue.removeFirst();
         result[i] = u;
         i++;
         for(int v = 0; v < graph.get(u-1).size();v++) {
            indegs[graph.get(u-1).get(v)-1] = indegs[graph.get(u-1).get(v)-1]-1;
            if(indegs[graph.get(u-1).get(v)-1] == 0) {
               queue.addLast(graph.get(u-1).get(v));
            }
         }
      }

      if(i < graph.size()) {
         System.out.println("Cycle Detected!");
         throw new IllegalArgumentException();
      }
      return result;
   }
   private int[] BFS(int s)
   {
      VertexInfo[] tree = new VertexInfo[graph.size()];
      LinkedList<Integer> queue = new LinkedList<Integer>();
      tree[0].parent = 0;

      while(!queue.isEmpty()) {
         
      }

   }

}