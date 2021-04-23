//Roey Mevorach and Tyler Hart
//rmevorac and tyhart
//4/23/2021
//Project2 part 2

import java.lang.Math;

class MatrixProduct {
    public MatrixProduct() {
    }
    public static int[][] matrixProduct_DAC(int[][] A, int[][] B) {
        if(A.length != B.length || A[0].length != B[0].length || (A[0].length != B.length))
            throw new IllegalArgumentException("Matrix not square");

        double x = Math.log(A.length)/Math.log(2);

        if((A.length % 2) != 0 || (B[0].length % 2) != 0 || Math.floor(x) != x)
            throw new IllegalArgumentException("Matrix not compatible");

        int n = A.length;
        int [][] C = matrixProduct_DAC(A, 0, 0, B, 0, 0, n);
        return C;
    }

    private static int[][] matrixProduct_DAC(int[][] A, int startrowA, int startcolA, int[][] B, int startrowB, int startcolB, int n) {
        int i = 0;
        int y = 0;
        int[][] C = new int[n][n];
        if(n == 1)
            C[0][0] = A[startrowA][startcolA] * B[startrowB][startcolB];
        else {
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

    public static int[][] matrixArithmetic(int[][] A, int startrowA, int startcolA, int[][] B, int startrowB, int startcolB, int n, int flag) {
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (flag == 1)
                    C[i][j] = A[i + startrowA][j + startcolA] - B[i + startrowB][j + startcolB];
                else
                    C[i][j] = A[i + startrowA][j + startcolA] + B[i + startrowB][j + startcolB];
            }
        }

        return C;
    }

    public static int[][] matrixProduct_Strassen(int[][] A,  int[][] B) {
        if(A.length != B.length || A[0].length != B[0].length || (A[0].length != B.length))
            throw new IllegalArgumentException("Matrix not square");

        double x = Math.log(A.length)/Math.log(2);

        if((A.length % 2) != 0 || (B[0].length % 2) != 0 || Math.floor(x) != x)
            throw new IllegalArgumentException("Matrix not compatible");

        int n = A.length;
        int [][] C = matrixProduct_Strassen(A, 0, 0, B, 0, 0, n);
        return C;
    }

    private static int[][] matrixProduct_Strassen(int[][] A, int startrowA, int startcolA, int[][] B, int startrowB, int startcolB, int n) {
        int i = 0;
        int y = 0;
        int[][] C = new int[n][n];
        if(n == 1)
            C[0][0] = A[startrowA][startcolA] * B[startrowB][startcolB];
        else {
            int half = n/2;
            int [][] s1 = matrixArithmetic(B, startrowB, startcolB + half, B, startrowB + half, startcolB + half, half, 1);
            int [][] s2 = matrixArithmetic(A, startrowA, startcolA, A, startrowA, startcolA + half, half, 0);
            int [][] s3 = matrixArithmetic(A, startrowA + half, startcolA, A, startrowA + half, startcolA + half, half, 0);
            int [][] s4 = matrixArithmetic(B, startrowB + half, startcolB, B, startrowB, startcolB, half, 1);
            int [][] s5 = matrixArithmetic(A, startrowA, startcolA, A, startrowA + half, startcolA + half, half, 0);
            int [][] s6 = matrixArithmetic(B, startrowB, startcolB, B, startrowB + half, startcolB + half, half, 0);
            int [][] s7 = matrixArithmetic(A, startrowA, startcolA + half, A, startrowA + half, startcolA + half, half, 1);
            int [][] s8 = matrixArithmetic(B, startrowB + half, startcolB, B, startrowB + half, startcolB + half, half, 0);
            int [][] s9 = matrixArithmetic(A, startrowA, startcolA, A, startrowA + half, startcolA, half, 1);
            int [][] s10 = matrixArithmetic(B, startrowB, startcolB, B, startrowB, startcolB + half, half, 0);
            int [][] p1 = matrixProduct_Strassen(A, startrowA, startcolA, s1, 0, 0, half);
            int [][] p2 = matrixProduct_Strassen(s2, 0, 0, B, startrowB + half, startcolB + half, half);
            int [][] p3 = matrixProduct_Strassen(s3, 0, 0, B, startrowB, startcolB, half);
            int [][] p4 = matrixProduct_Strassen(A, startrowA + half, startcolA + half, s4, 0, 0, half);
            int [][] p5 = matrixProduct_Strassen(s5, 0, 0, s6, 0, 0, half);
            int [][] p6 = matrixProduct_Strassen(s7, 0, 0, s8, 0, 0, half);
            int [][] p7 = matrixProduct_Strassen(s9, 0, 0, s10, 0, 0, half);
            int [][] c11 = matrixArithmetic(matrixArithmetic(p5, 0, 0, p4, 0, 0, half, 0), 0, 0, matrixArithmetic(p2, 0, 0, p6, 0, 0, half, 0), 0, 0, half, 1);
            int [][] c12 = matrixArithmetic(p1, 0, 0, p2, 0, 0, half, 0);
            int [][] c21 = matrixArithmetic(p3, 0, 0, p4, 0, 0, half, 0);
            int [][] c22 = matrixArithmetic(matrixArithmetic(p5, 0, 0, p1, 0, 0, half, 0), 0, 0, matrixArithmetic(p3, 0, 0, p7, 0, 0, half, 1), 0, 0, half, 1);

            for(i = 0; i < half; i++) {
                for(y = 0; y < half; y++) {
                    C[i][y] = c11[i][y];
                }
            }
            for(i = 0; i < half; i++) {
                for(y = 0; y < half; y++) {
                    C[i][y+half] = c12[i][y];
                }
            }
            for(i = 0; i < half; i++) {
                for(y = 0; y < half; y++) {
                    C[i+half][y] = c21[i][y];
                }
            }
            for(i = 0; i < half; i++) {
                for(y = 0; y < half; y++) {
                    C[i+half][y+half] = c22[i][y];
                }
            }
        }
        return C;
    }
}