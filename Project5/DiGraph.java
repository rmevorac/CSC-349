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
      VertexInfo() {
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

   private VertexInfo[] BFS(int s) {
      s = s-1;
      int N = graph.size();
      VertexInfo[] tree = new VertexInfo[N];
      LinkedList<Integer> queue = new LinkedList<Integer>();
      for(int i = 0; i < N; i++) {
         tree[i] = new VertexInfo();
      }
      tree[s].distance = 0;
      queue.addLast(s);

      while(!queue.isEmpty()) {
         int u = queue.getFirst();
         queue.removeFirst();
         for(int v : graph.get(u)) {
            if(tree[v-1].distance == -1) {
               tree[v-1].distance = tree[u].distance+1;
               tree[v-1].parent = u+1;
               queue.addLast(v-1);
            }
         }
         
      }

      for(int i = 0; i < tree.length; i++) {
         System.out.println(i+1 + ": distance = " + tree[i].distance + " parent = " + tree[i].parent);
      }

      return tree;
   }

   public boolean isTherePath(int from, int to) {
      boolean result = false;
      VertexInfo[] tree = BFS(from);
      VertexInfo current = tree[to-1];

      while (current.distance > 0 && result == false) {
         if (current.parent == from) {
            result = true;
         }

         else {
            System.out.println("current.parent = " + current.parent);
            current = tree[current.parent-1];
         }
      }

      return result;
   }

   public int lengthOfPath(int from, int to) {
      VertexInfo[] tree = BFS(from);
      return tree[to - 1].distance;
   }

   public void printPath(int from, int to) {
      VertexInfo[] tree = BFS(from);
      int current = to;

      if (tree[to - 1].distance == -1) {
         System.out.println("There is no Path");
      }

      else {
         String output = "";
         while (current != from) {
            output = "-->" + current + output;
            current = tree[current - 1].parent;
         }

         output = from + output;
         System.out.println(output);
      }
   }

}