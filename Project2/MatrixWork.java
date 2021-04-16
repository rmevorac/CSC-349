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
    }
    catch(IllegalArgumentException e)
    {
        System.out.println("Matrix A Columns != Matrix B Rows");
    }
        fsc.close();
        sc.close();
    }
}