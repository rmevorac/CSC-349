//Roey Mevorach and Tyler Hart

import java.util.*;

class Sorts {

   public static void printArray(int[] arr) {
      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i]);
         if (i < arr.length - 1) {
            System.out.print(", ");
         }
      }
      System.out.print("\n");
   }

   public static int[] swapElements(int[] arr, int idx1, int idx2) {
      int temp = arr[idx1];
      arr[idx1] = arr[idx2];
      arr[idx2] = temp;
      return arr;
   }

   public static void selectionSort (int[] arr, int N) {
      //Sorts the list of N elements contained in arr[0..N-1] using the selection sort algorithm.
      int min;
      int temp;
      for(int q = 0; q < N; q++)
      {
         min = arr[q];
         temp = q;
         for(int i = q; i < N; i++)
         {
            if(arr[i] < min)
            {
               min = arr[i];
               temp = i;
            }
         }
         arr[temp] = arr[q];
         arr[q] = min;
      }
   }

   public static void bubbleSort (int[] arr, int N) {
      //Sorts the list of N elements contained in arr[0..N-1] using the improved bubble sort algorithm
      //(see the handout).
      boolean flag = true;
      int last = N - 1;
      while (flag) {
         flag = false;
         for (int i = 0; i < last; i++) {
            if (arr[i] > arr[i + 1]) {
               arr = swapElements(arr, i, i + 1);
               flag = true;
            }
         }
         last -= 1;
      }
   }

   public static void mergeSort (int[] arr, int N) {
      //Sorts the list of N elements contained in arr[0..N-1] using the merge sort algorithm.
      mergeSort(arr,0,N-1);
   }
   private static void mergeSort(int[] arr, int first, int last)
   {
      if(first < last)
      {
         int middle = (first + last)/2;
         mergeSort(arr,first,middle);
         mergeSort(arr,middle+1,last);
         mergeSortedHalves(arr,first,middle,last);
      }
   }
   private static void mergeSortedHalves(int[] arr, int left,int middle,int right)
   {
      int[] temp = new int[right-left+1];
      int x = left;
      int y = middle+1;
      int  z = 0;
      while(x <= middle && y <= right)
      {
         if(arr[y] < arr[x])
         {
            temp[z] = arr[y];
            y++;
         }
         else
         {
            temp[z] = arr[x];
            x++;
         }
         z++;
      }
      if(x > middle)
      {
         while( y <= right)
         {
            temp[z++] = arr[y++];
         }
      }
      else
      {
         while( x <= middle)
         {
            temp[z++] = arr[x++];
         }
      }
      for(int i = 0; i < right-left+1; i++)
      {
         arr[i+left] = temp[i];
         temp[i] = -1;
      }
   }

   public static void quickSort (int[] arr, int N) {
      //Sorts the list of N elements contained in arr[0..N-1] using the quick sort algorithm with
      //median-of-three pivot and rearrangement of the three elements (see the handout).
      quickSort(arr, 0, N - 1);
   }

   private static void quickSort (int[] list, int first, int last) { //sorts list[first..last] segment
      if (first < last) { //checking if there is more than one element in list[first..last] segment
         setPivotToEnd(list, first, last); //supporting method
         int pivotIndex = splitList (list, first, last); //supporting method quickSort(list, first, pivotIndex-1);
         quickSort(list, first, pivotIndex - 1);
         quickSort(list, pivotIndex + 1, last);
      }
   }

   private static void setPivotToEnd (int[] arr, int left, int right) {
      if (arr[left] > arr[(left + right) / 2]) {
         arr = swapElements(arr, left, (left + right) / 2);
      }

      if (arr[left] > arr[right]) {
         arr = swapElements(arr, left, right);
      }

      if (arr[right] > arr[(left + right) / 2]) {
         arr = swapElements(arr, (left + right) / 2, right);
      }

      // System.out.print("After setPivotToEnd: ");
      // printArray(arr);
   }

   private static int splitList (int[] arr, int left, int right) {
      //Rearranges the list by placing the pivot so that it is preceded by smaller
      //values and followed by greater values. Returns pivot’s index.
      //Precondition: arr[right] contains the pivot
      //Postcondition: the pivot is properly placed and its index is returned.
      // Elements in the list are arranged so that arr[i]<pivot for all arr[i]
      // located to the left of pivot, and arr[i]>pivot for all arr[i] located to
      // the right of the pivot.
      int indexL = left;
      int indexR = right - 1;
      int pivot = right;

      while (indexL < indexR) {
         // System.out.println("before left, right, pivot: " + indexL + ", " + indexR + ", " + pivot);
         // System.out.println("arr left, arr right, arr pivot: " + arr[indexL] + ", " + arr[indexR] + ", " + arr[pivot]);
         while (arr[indexL] < arr[pivot]) {
            indexL++;
         }

         while (arr[indexR] > arr[pivot] && indexL < indexR) {
            indexR--;
         }

         if (indexL < indexR) {
            arr = swapElements(arr, indexL, indexR);
            indexL++;
            indexR--;
         }
         // System.out.println("after left, right, pivot: " + indexL + ", " + indexR + ", " + pivot);
         // printArray(arr);
      }

      if (indexL == indexR && arr[indexL] <= arr[pivot]) {
         indexL++;
      }

      arr = swapElements(arr, indexL, pivot);
      // System.out.print("After splitList: ");
      // printArray(arr);
      return indexL;
   }
}
