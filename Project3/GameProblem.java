// Roey Mevorach and Tyler Hart
// rmevorac and tyhart
// 5/5/2021
// Project3

class GameProblem {

   public static void game(int n, int m, int[][] A) {
      int[][] S = new int[n + 1][m + 1];
      string[][] R = new string[n][m];

   }

   public static void main() {
      System.out.println("Please enter the filename:");
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

      game(row, column, A);
   }
}