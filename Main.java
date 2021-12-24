package tictactoe;

public class Main {
    public static void main(String[] args) {
        char[][] grid = enterCells();
        print(grid);
        System.out.println(stateOfGame(grid));
    }

    public static String stateOfGame(char[][] grid) {
        String stateOfGame = "State of Game";
        int noOX = noOX(grid);
        int noO = noOX % 10;
        int noX = noOX / 10;
        String whoWins = whoWins(grid);
        if (Math.abs(noX - noO) > 1 || whoWins.equals("true true")) {
            stateOfGame = "Impossible";
        } else if (noO + noX == 9 && whoWins.equals("false false")) {
            stateOfGame = "Draw";
        } else if (noO + noX < 9 && whoWins.equals("false false")) {
            stateOfGame = "Game not finished";
        } else if (whoWins.equals("true false")) {
            stateOfGame = "O wins";
        } else if (whoWins.equals("false true")) {
            stateOfGame = "X wins";
        }
        return stateOfGame;
    }

    public static char[][] enterCells() {
        System.out.print("Enter cells: ");
        String str = new java.util.Scanner(System.in).nextLine();
        final int n = 3;
        char[][] grid = new char[n][n];
        for (int i = 0, k = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = str.charAt(k);
                k++;
            }
        }
        return grid;
    }

    public static void print(char[][] grid) {
        int n = 3;
        System.out.println("---------");
        for (int i = 0; i < n; i++) {
            System.out.print("| ");
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static int noOX(char[][] grid) {
        int x = 0;
        int o = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                x += grid[i][j] == 'X' ? 1 : 0;
                o += grid[i][j] == 'O' ? 1 : 0;
            }
        }
        return o + 10 * x;
    }

    public static String whoWins(char[][] grid) {
        boolean xWins = false;
        boolean oWins = false;
        int xh = 0, oh = 0, xv = 0, ov = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                xh += grid[i][j] == 'X' ? 1 : 0;
                oh += grid[i][j] == 'O' ? 1 : 0;
                xv += grid[j][i] == 'X' ? 1 : 0;
                ov += grid[j][i] == 'O' ? 1 : 0;
            }
            xWins = xh == 3 || xWins;
            oWins = oh == 3 || oWins;
            xWins = xv == 3 || xWins;
            oWins = ov == 3 || oWins;
            xh = 0; oh = 0; xv = 0; ov = 0;
        }
        for (int i = 0, j = 0, k = grid.length - 1; i < grid.length ; i++, j++, k--) {
            xh += grid[i][j] == 'X' ? 1 : 0;
            oh += grid[i][j] == 'O' ? 1 : 0;
            xv += grid[i][k] == 'X' ? 1 : 0;
            ov += grid[i][k] == 'O' ? 1 : 0;
        }
        xWins = xh == 3 || xWins;
        oWins = oh == 3 || oWins;
        xWins = xv == 3 || xWins;
        oWins = ov == 3 || oWins;
        return oWins + " " + xWins;
    }
}