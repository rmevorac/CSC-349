// Roey Mevorach and Tyler Hart
// rmevorac and tyhart
// 5/5/2021
// Project3

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class GameProblem {

   public static void game(int n, int m, int[][] A) {
      int row = n - 1, col = m - 1;
      int[][] S = new int[n][m];
      String[][] R = new String[n][m];

      S[row][col] = A[row][col];
      R[row][col] = "e";

      for (int i = col - 1; i >= 0; i--) {
         if (S[row][i + 1] > 0) {
            S[row][i] = A[row][i] + S[row][i + 1];
            R[row][i] = "r";
         }

         else {
            S[row][i] = A[row][i];
            R[row][i] = "e";
         }
      }

      for (int j = row - 1; j >= 0; j--) {
         if (S[j + 1][col] > 0) {
            S[j][col] = A[j][col] + S[j + 1][col];
            R[j][col] = "d";
         }

         else {
            S[j][col] = A[j][col];
            R[j][col] = "e";
         }
      }

      for (int a = row - 1; a >= 0; a--) {
         for (int b = col - 1; b >= 0; b--) {
            if (S[a][b + 1] > S[a + 1][b]) {
               S[a][b] = A[a][b] + S[a][b + 1];
               R[a][b] = "r";
            }
   
            else {
               S[a][b] = A[a][b] + S[a + 1][b];
               R[a][b] = "d";
            }
         }
      }

      int max = S[0][0];
      int max_row = 0, max_col = 0;

      for (int c = 0; c < n; c++) {
         for (int d = 0; d < m; d++) {
            if (S[c][d] > max) {
               max = S[c][d];
               max_row = c;
               max_col = d;
            }
         }
      }

      System.out.println("Best score: " + max);
      printBestPath(R, max_row, max_col);

      // printTables(S, R, n, m);
   }

   private static void printBestPath(String[][] R, int row, int col) {
      System.out.print("Best path: ");

      while (R[row][col] != "e") {
         System.out.print("[" + (row + 1) + "," + (col + 1) + "] to ");

         if (R[row][col] == "r")
            col++;

         else
            row++;
      }

      System.out.println("[" + (row + 1) + "," + (col + 1) + "] to exit");
   }

   private static void printTables(int[][] A, String[][] B, int row, int col) {
      for (int i = 0; i < row; i++) {
         for (int j = 0; j < col; j++) {
            System.out.print(A[i][j] + " ");
         }

         System.out.print("\n");
      }

      for (int i = 0; i < row; i++) {
         for (int j = 0; j < col; j++) {
            System.out.print(B[i][j] + " ");
         }
         
         System.out.print("\n");
      }
   }

   public static void main(String[] args) throws FileNotFoundException {
      System.out.println("Please enter the filename:");
      int i = 0, q = 0;
      Scanner sc = new Scanner(System.in);
      String fname = sc.next();
      File file = new File(fname);

      try {
         Scanner fsc = new Scanner(file);
         int row = fsc.nextInt();
         int column = fsc.nextInt();
         int A[][] = new int[row][column];

         for(i = 0; i < row; i++) {
            for(q = 0; q < column; q++) {
                  A[i][q] = fsc.nextInt();
            }
         }

         game(row, column, A);
      }

      catch (FileNotFoundException ex) {
         System.out.println("File does not exist");
      }
   }
}