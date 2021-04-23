//Roey Mevorach and Tyler Hart
//rmevorac and tyhart
//4/14/2021
//Project2 part 1

import java.util.*;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

class MatrixWork {
    public MatrixWork() {
    }

    public static int[][] matrixProduct(int[][] A, int[][] B) {
        int x = A[0].length;
        int y = B.length;
        int[][] C = new int[A.length][B[0].length];
        if(x != y)
            throw new IllegalArgumentException("Matrix A Columns != Matrix B Rows");
        for(int row = 0; row < A.length; row++)
        {
            for(int column = 0; column < B[0].length; column++)
            {
                int total = 0;
                for(int i = 0; i < A[row].length; i++)
                {
                    total += (A[row][i] * B[i][column]);
                }
                C[row][column] = total;
            }
        }
        return C;
    }
    public static int[][] matrixProduct_DAC(int[][] A, int[][] B)
    {
        if(A.length != B.length || A[0].length != B[0].length || (A[0].length != B.length))
        {
            throw new IllegalArgumentException("Matrix not square");
        }
        double x = Math.log(A.length);
        if((A.length % 2) != 0 || (B[0].length % 2) != 0 || floor(x) != x)
            throw new IllegalArgumentException("Matrix not compatible");
        int n = A.length;
        int [][] C = matrixProduct_DAC(A, 0, 0, B, 0, 0, n);
        return C;
    }
    public static int[][] matrixProduct_DAC(int[][] A, int startrowA, int startcolA, int[][] B, int startrowB, int startcolB, int n)
    {
        int i = 0;
        int y = 0;
        int[][] C = new int[n][n];
        if(n == 1)
            C[0][0] = A[startrowA][startcolA] * B[startrowB][startcolB];
        else
        {
            int half = n/2;
            int [][] c11 = matrixAddition(matrixProduct_DAC(A,startrowA,startcolA,B,startrowB,startcolB,half), matrixProduct_DAC(A, startrowA, startcolA + half, B, startrowB + half, startcolB, half), half);
            int [][] c12 = matrixAddition(matrixProduct_DAC(A,startrowA,startcolA,B,startrowB,startcolB+half,half), matrixProduct_DAC(A, startrowA, startcolA + half, B, startrowB + half, startcolB + half, half), half);
            int [][] c21 = matrixAddition(matrixProduct_DAC(A,startrowA+half,startcolA,B,startrowB,startcolB,half), matrixProduct_DAC(A, startrowA + half, startcolA + half, B, startrowB + half, startcolB, half), half);
            int [][] c22 = matrixAddition(matrixProduct_DAC(A,startrowA+half,startcolA,B,startrowB,startcolB+half,half), matrixProduct_DAC(A, startrowA + half, startcolA + half, B, startrowB + half, startcolB + half, half), half);
            for(i = 0; i < half; i++)
            {
                for(y = 0; y < half; y++)
                {
                    C[i][y] = c11[i][y];
                }
            }
            for(i = 0; i < half; i++)
            {
                for(y = 0; y < half; y++)
                {
                    C[i][y+half] = c12[i][y];
                }
            }
            for(i = 0; i < half; i++)
            {
                for(y = 0; y < half; y++)
                {
                    C[i+half][y] = c21[i][y];
                }
            }
            for(i = 0; i < half; i++)
            {
                for(y = 0; y < half; y++)
                {
                    C[i+half][y+half] = c22[i][y];
                }
            }
        }
        return C;
    }

    public static int[][] matrixAddition(int[][] A, int[][] B, int n) {
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        return C;
    }
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
        for(i = 0; i < row; i++)
        {
            for(q = 0; q < column; q++)
            {
                A[i][q] = fsc.nextInt();
            }
        }
        row = fsc.nextInt();
        column = fsc.nextInt();
        int[][] B = new int[row][column];
        for(i = 0; i < row; i++)
        {
            for(q = 0; q < column; q++)
            {
                B[i][q] = fsc.nextInt();
            }
        }
        try{
            int[][] C = matrixProduct(A,B);
            System.out.println("Product matrix:");
        for(i = 0; i < C.length; i++)
        {
            for(q = 0; q < C[0].length; q++)
            {
                System.out.print(C[i][q] + " ");
            }
            System.out.println();
        }
        C = matrixProduct_DAC(A, B);
        System.out.println("DAC Product matrix:");
        for(i = 0; i < C.length; i++)
        {
            for(q = 0; q < C[0].length; q++)
            {
                System.out.print(C[i][q] + " ");
            }
            System.out.println();
        }
    }
    catch(IllegalArgumentException e)
    {
        System.out.println("Matrix A Columns != Matrix B Rows");
    }
        fsc.close();
        sc.close();
    }
}