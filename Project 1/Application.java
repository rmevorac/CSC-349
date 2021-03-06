//Roey Mevorach and Tyler Hart
import java.util.*;
import java.util.Arrays;
import java.util.Random;

class Application {
   public Application() {
   }

   private static int randomFill(int N) {
      return new Random().nextInt(N-1);
  }

   public int[] createArray(int N) {
      int[] arr = new int[N];

      for (int i = 0; i < arr.length; i++) {
         arr[i] = randomFill(N);
      }

      return arr;
   }

   public void printArray(int[] arr) {
      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i]);
         if (i < arr.length - 1) {
            System.out.print(", ");
         }
      }
      System.out.print("\n");
   }

   public void testBubbleSort(int N, int[] arr) {
      //printArray(arr);
      long x;
      long t = System.currentTimeMillis();
      Sorts.bubbleSort(arr, arr.length);
      x = System.currentTimeMillis();
      System.out.print("T_bs=" + (x-t) + ", ");
   }

   public void testSelectionSort(int N, int[] arr) {
      //printArray(arr);
      long x;
      long t = System.currentTimeMillis();
      Sorts.selectionSort(arr, arr.length);
      x = System.currentTimeMillis();
      System.out.print("T_ss=" + (x-t) + ", ");
      //printArray(arr);
   }

   public void testMergeSort(int N, int[] arr) {
      long x;
      long t = System.currentTimeMillis();
      printArray(arr);
      Sorts.mergeSort(arr, arr.length);
      x = System.currentTimeMillis();
      printArray(arr);
      System.out.print("T_ms="+(x-t) + ", ");
   }

   public void testQuickSort(int N, int[] arr) {
      long x;
      long t = System.currentTimeMillis();
      Sorts.quickSort(arr, arr.length);
      x = System.currentTimeMillis();
      System.out.println("T_qs=" + (x-t));
   }


   public static void main(String[] args) {
      Application app = new Application();
      int[] arr;
      int[] temp;
      for(int i = 5; i <= 50; i*=2)
      {
         for(int q = 1; q <= 5; q++)
         {
            arr = app.createArray(i);
            temp = arr.clone();
            System.out.print("N=" + i + ": ");
            app.testSelectionSort(i,arr);
            arr = temp.clone();
            app.testBubbleSort(i,arr);
            arr = temp.clone();
            app.testMergeSort(i,arr);
            arr = temp.clone();
            app.testQuickSort(i,arr);
         }
         if(i != 160000)
            System.out.println();
      }
   }
}