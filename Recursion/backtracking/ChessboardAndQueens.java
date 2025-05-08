// Your task is to place eight queens on a chessboard so that no two queens are attacking each other. As an additional challenge, each square is either free or reserved, and you can only place queens on the free squares. However, the reserved squares do not prevent queens from attacking each other.

// How many possible ways are there to place the queens?

// Input
// The input has eight lines, and each of them has eight characters. Each square is either free (.) or reserved (*).

// Output
// Print one integer: the number of ways you can place the queens.

// Example
// Input:

// ........
// ........
// ..*.....
// ........
// ........
// .....**.
// ...*....
// ........
// Output:

// 65
 import java.util.Scanner;

public class EightQueens {
    static char[][] board = new char[8][8];
    static boolean[] cols = new boolean[8];
    static boolean[] diag1 = new boolean[15]; // row - col ranges from -7 to +7 → shift by +7
    static boolean[] diag2 = new boolean[15]; // row + col ranges from 0 to 14
    static int ways = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the board
        for (int i = 0; i < 8; i++) {
            board[i] = scanner.next().toCharArray();
        }
        scanner.close();

        // Start backtracking from row 0
        solve(0);
        System.out.println(ways);
    }

    static void solve(int row) {
        if (row == 8) {
            // Successfully placed 8 queens
            ways++;
            return;
        }

        for (int col = 0; col < 8; col++) {
            // Skip reserved squares
            if (board[row][col] == '*') continue;

            // Check if position is safe
            if (cols[col] || diag1[row - col + 7] || diag2[row + col]) continue;

            // Place queen
            cols[col] = true;
            diag1[row - col + 7] = true;
            diag2[row + col] = true;

            solve(row + 1);

            // Backtrack
            cols[col] = false;
            diag1[row - col + 7] = false;
            diag2[row + col] = false;
        }
    }
}


