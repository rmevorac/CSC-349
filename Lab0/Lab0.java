//Author: Roey Mevorach & Tyler Hart

import java.util.*;
import java.lang.*;

class Algorithms {
	public static void printLinearTime()
	{
		long startTime;
		long endTime;
		for(long i = 1000; i < 100000001; i*=2)
		{
			startTime = System.currentTimeMillis();
			linearAlgorithm(i);
		        endTime = System.currentTimeMillis();
		        endTime = endTime - startTime;
			System.out.println("T(" + i + ") = " + endTime);
		}
	}
	public static void printQuadraticTime()
	{
		long startTime;
		long endTime;
		for(long i = 1000; i < 512001; i*=2)
		{
			startTime = System.currentTimeMillis();
			quadraticAlgorithm(i);
			endTime = System.currentTimeMillis();
			endTime = endTime - startTime;
			System.out.println("T(" + i + ") = " + endTime);
		}
	}
	public static void printCubicTime()
	{
		long startTime;
		long endTime;
		for(long i = 1000; i < 8000; i *=2)
		{
			startTime = System.currentTimeMillis();
			cubicAlgorithm(i);
			endTime = System.currentTimeMillis();
			endTime = endTime - startTime;
			System.out.println("T(" + i + ") = " + endTime);
		}
	}
	public static void printLogTime()
	{
		long startTime;
		long endTime;
		for(long i = 1000; i < 100000001; i*=2)
		{
			startTime = System.currentTimeMillis();
			logarithmicAlgorithm(i);
			endTime = System.currentTimeMillis();
			endTime = endTime - startTime;
			System.out.println("T(" + i + ") = " + endTime);
		}
	}
	public static void printLogNTime()
	{
		long startTime;
		long endTime;
		for(long i = 1000; i < 100000001; i*=2)
		{
			startTime = System.currentTimeMillis();
			NlogNAlgorithm(i);
			endTime = System.currentTimeMillis();
			endTime = endTime - startTime;
			System.out.println("T(" + i + ") = " + endTime);
		}
	}
   public static  void linearAlgorithm(long N) {
      int x;
      for (long i = 1; i < N; i++) {
         x = 1;
      }
   }
   
   public static void quadraticAlgorithm (long N) {
      int x;
      for (long i = 1; i < N; i++) {
         for (long j = 1; j < N; j++) {
            x = 1;
         }
      }
   }
   
   public static void cubicAlgorithm (long N) {
      int x;
      for (long i = 1; i < N; i++) {
         for (long j = 1; j < N; j++) {
            for (long k = 1; k < N; k++) {
               x = 1;
            }
         }
      }
   }
   
   public static void logarithmicAlgorithm(long N) {
      int x;
      for (long i = N; i > 1; i*=.5) {
         x = 1;
      }
   }
   
   public static void NlogNAlgorithm(long N) {
      int x;
      for (long i = 1; i < N; i++) {
         for (long j = N; j > 1; j*=.5) {
            x = 1;
         }
      }
   }
	public static void main(String[] args)
	{
		System.out.println("Logarithmic algorithm's running times:");
		printLogTime();
		System.out.println("\nLinear algorithm's running times:");
		printLinearTime();
		System.out.println("\nNlogN algorithm's running times:");
		printLogNTime();
		System.out.println("\nQuadratic algorithm's running times:");
		printQuadraticTime();
		System.out.println("\nCubic algorithm's running times:");
		printCubicTime();
	}
}
