//Roey Mevorach and Tyler Hart

import java.util.*;

class Sorts {
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
   }
}

