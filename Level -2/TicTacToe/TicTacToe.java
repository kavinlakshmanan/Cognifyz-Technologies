import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
            boolean isPlayer1Turn = true;
            boolean gameWon = false;
            boolean isDraw = false;

            while (!gameWon && !isDraw) {
                printBoard(board);

                char currentPlayerSymbol = isPlayer1Turn ? 'X' : 'O';
                System.out.println((isPlayer1Turn ? "Player 1" : "Player 2") + ", enter your move (row[1-3] column[1-3]):");
                int row = scanner.nextInt() - 1;
                int col = scanner.nextInt() - 1;

                if (isValidMove(board, row, col)) {
                    board[row][col] = currentPlayerSymbol;
                    gameWon = checkWin(board, currentPlayerSymbol);
                    isDraw = checkDraw(board);
                    isPlayer1Turn = !isPlayer1Turn;
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            }

            printBoard(board);
            if (gameWon) {
                System.out.println((isPlayer1Turn ? "Player 2" : "Player 1") + " wins!");
            } else {
                System.out.println("It's a draw!");
            }

            System.out.println("Do you want to play again? (yes/no):");
            String choice = scanner.next();
            playAgain = choice.equalsIgnoreCase("yes");
        }

        scanner.close();
    }

    public static void printBoard(char[][] board) {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    public static boolean checkWin(char[][] board, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) return true;
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) return true;
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) return true;
        return false;
    }

    public static boolean checkDraw(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
