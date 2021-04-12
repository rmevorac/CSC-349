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

   public void testBubbleSort(int N) {
      int[] arr = createArray(N);
      //printArray(arr);
      long x;
      long t = System.currentTimeMillis();
      Sorts.bubbleSort(arr, arr.length);
      x = System.currentTimeMillis();
      printArray(arr);
   }

   public void testSelectionSort(int N) {
      int[] arr = createArray(N);
      //printArray(arr);
      long x;
      long t = System.currentTimeMillis();
      Sorts.selectionSort(arr, arr.length);
      x = System.currentTimeMillis();
      System.out.print("T_ss=" + (x-t) + ", ");
      //printArray(arr);
   }

   public void testMergeSort(int N) {
      int[] arr = createArray(N);
      printArray(arr);

      Sorts.mergeSort(arr, arr.length);
      printArray(arr);
   }

   public void testQuickSort(int N) {
      int[] arr = createArray(N);
      printArray(arr);

      Sorts.quickSort(arr, arr.length);
      printArray(arr);
   }


   public static void main(String[] args) {
      Application app = new Application();
      System.out.print("N=5000: ");
      app.testSelectionSort(5000);
      app.testBubbleSort(5000);
   }
}
