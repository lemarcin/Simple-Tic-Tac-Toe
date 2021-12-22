package tictactoe;

public class Main {
    public static void main(String[] args) {
        String str = "XOXOXOXXO";
        final int n = 3;
        char[][] grid = new char[n][n];
        for (int i = 0, k = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = str.charAt(k);
                k++;
            }
        }
        print(grid);
    }
    public static void print(char grid[][]) {
        int n = 3;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("");
        }
    }
}