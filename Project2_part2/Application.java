import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class Application {
   
   public static void main(String[] args) throws FileNotFoundException{
      System.out.println("Please enter filename containing Matrix information:");
      int i = 0, q = 0;
      Scanner sc = new Scanner(System.in);
      String fname = sc.next();
      File file = new File(fname);
      Scanner fsc = new Scanner(file);
      int row = fsc.nextInt();
      int column = fsc.nextInt();
      int A[][] = new int[row][column];

      for(i = 0; i < row; i++) {
         for(q = 0; q < column; q++) {
               A[i][q] = fsc.nextInt();
         }
      }

      row = fsc.nextInt();
      column = fsc.nextInt();
      int[][] B = new int[row][column];

      for(i = 0; i < row; i++) {
         for(q = 0; q < column; q++) {
               B[i][q] = fsc.nextInt();
         }
      }

      try {
         int[][] C = MatrixProduct.matrixProduct(A,B);
         System.out.println("Product matrix:");
         for(i = 0; i < C.length; i++) {
               for(q = 0; q < C[0].length; q++) {
                  System.out.print(C[i][q] + " ");
               }
               System.out.println();
         }

         C = MatrixProduct.matrixProduct_Strassen(A, B);
         System.out.println("Strassen Product matrix:");
         for(i = 0; i < C.length; i++) {
               for(q = 0; q < C[0].length; q++) {
                  System.out.print(C[i][q] + " ");
               }
               System.out.println();
         }

         C = MatrixProduct.matrixProduct_DAC(A, B);
         System.out.println("DAC Product matrix:");
         for(i = 0; i < C.length; i++) {
               for(q = 0; q < C[0].length; q++) {
                  System.out.print(C[i][q] + " ");
               }
               System.out.println();
         }
      }

      catch(IllegalArgumentException e) {
         System.out.println("Matrix A Columns != Matrix B Rows");
      }

      fsc.close();
      sc.close();
   }
}