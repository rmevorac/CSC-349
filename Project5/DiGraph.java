// Roey Mevorach and Tyler Hart
// rmevorac and tyhart
// 5/24/2021
// Project 5

import java.util.*;
import java.io.File;
import java.util.Arrays;
import java.io.FileNotFoundException;

class DiGraph {
   private class VertexInfo {
      int distance;
      int parent;
      VertexInfo()
      {
         this.distance = -1;
         this.parent = -1;
      }
   }
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
   public VertexInfo[] BFS(int s)
   {
      int N = graph.size();
      VertexInfo[] tree = new VertexInfo[N+1];
      LinkedList<Integer> queue = new LinkedList<Integer>();
      for(int i = 1; i < N+1; i++)
      {
         tree[i] = new VertexInfo();
      }
      tree[s].distance = 0;
      queue.addLast(s);
      while(!queue.isEmpty()) {
         int u = queue.getFirst();
         queue.removeFirst();
         for(int v : graph.get(u-1))
         {
            if(tree[v].distance == -1)
            {
               tree[v].distance = tree[u].distance+1;
               tree[v].parent = u;
               queue.addLast(v);
            }
         }
         
      }
      for(int i = 1; i < tree.length; i++)
      {
         System.out.println(i + ": distance = " + tree[i].distance + " parent = " + tree[i].parent);
      }
      return tree;
   }

}