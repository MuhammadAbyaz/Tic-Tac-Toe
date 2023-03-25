import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] board = new String[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = " ";
            }
        }
        String p1 = "X";
        String p2 = "O";
        int firstPlayerMove, secondPlayerMove;

        System.out.println("Enter number between (0-8): ");
        printBoard(board);
        while (true) {
            System.out.println(p1 + " player move: ");
            firstPlayerMove = sc.nextInt();
            checkMove(board, firstPlayerMove, p1);
            printBoard(board);
            if (checkWinner(board, p1)) {
                break;
            }
            System.out.println(p2 + " player move: ");
            secondPlayerMove = sc.nextInt();
            checkMove(board, secondPlayerMove, p2);
            board[secondPlayerMove / 3][secondPlayerMove % 3] = p2;
            printBoard(board);
            if (checkWinner(board, p2)) {
                break;
            }
        }
    }

    public static void printBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("-+-+-");
            }
        }
    }

    public static boolean checkWinner(String[][] board, String player) {
        boolean win = false;
        int tie = 0;
        if (board[0][0].equals(player) && board[0][1].equals(player) && board[0][2].equals(player)) {
            System.out.println(player + " Wins!");
            win = true;
        } else if (board[1][0].equals(player) && board[1][1].equals(player) && board[1][2].equals(player)) {
            System.out.println(player + " Wins!");
            win = true;

        } else if (board[2][0].equals(player) && board[2][1].equals(player) && board[2][2].equals(player)) {
            System.out.println(player + " Wins!");
            win = true;

        } else if (board[0][0].equals(player) && board[1][0].equals(player) && board[2][0].equals(player)) {
            System.out.println(player + " Wins!");
            win = true;

        } else if (board[0][1].equals(player) && board[1][1].equals(player) && board[2][1].equals(player)) {
            System.out.println(player + " Wins!");
            win = true;

        } else if (board[0][2].equals(player) && board[1][2].equals(player) && board[2][2].equals(player)) {
            System.out.println(player + " Wins!");
            win = true;

        } else if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            System.out.println(player + " Wins");
            win = true;
        } else if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            System.out.println(player + " Wins");
            win = true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != " ") {
                    tie++;
                }
            }
            if (tie == 9) {
                System.out.println("Tie! nobody has won the game");
                win = true;
            }
        }
        return win;
    }

    public static void checkMove(String[][] board, int option, String symbol) {
        if (board[option / 3][option % 3].equals(" ")) {
            board[option / 3][option % 3] = symbol;
        } else if (option < 0 || option > 8) {
            System.out.println("Invalid move! Please select the number between (0-8): ");
        } else {
            System.out.println("Invalid move! the cell is already occupied");
        }
    }
}