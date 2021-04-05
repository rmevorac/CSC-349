//Roey Mevorach and Tyler Hart

import java.util.*;
import java.util.Arrays;
import java.util.Random;

class Application {
   public Application() {
   }

   private static int randomFill() {
      return new Random().nextInt(50);
  }

   public int[] createArray() {
      int[] arr = new int[10];

      for (int i = 0; i < arr.length; i++) {
         arr[i] = randomFill();
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

   public void testBubbleSort() {
      int[] arr = createArray();
      printArray(arr);

      Sorts.bubbleSort(arr, arr.length);
      printArray(arr);
   }

   public void testSelectionSort() {
      int[] arr = createArray();
      printArray(arr);

      Sorts.selectionSort(arr, arr.length);
      printArray(arr);
   }

   public void testMergeSort() {
      int[] arr = createArray();
      printArray(arr);

      Sorts.mergeSort(arr, arr.length);
      printArray(arr);
   }

   public void testQuickSort() {
      int[] arr = createArray();
      printArray(arr);

      Sorts.quickSort(arr, arr.length);
      printArray(arr);
   }


   public static void main(String[] args) {
      Application app = new Application();
      app.testBubbleSort();
   }
}