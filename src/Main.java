import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] board = new String[3][3];
        String p1 = "X";
        String p2 = "O";
        boolean win = false;
        int firstPlayerMove, secondPlayerMove = 0;

        System.out.println("Enter number between (0-8): ");
        printBoard(board);
        while (win == false) {

            System.out.println(p1 + " player move: ");
            firstPlayerMove = sc.nextInt();
            if (board[firstPlayerMove / 3][firstPlayerMove % 3] == null) {
                board[firstPlayerMove / 3][firstPlayerMove % 3] = p1;
            } else {
                System.out.println("The cell is already occupied!");
            }
            checkWinner(board, p1);
            printBoard(board);
            System.out.println(p2 + " player move: ");
            secondPlayerMove = sc.nextInt();
            if (board[secondPlayerMove / 3][secondPlayerMove % 3] == null) {
                board[secondPlayerMove / 3][secondPlayerMove % 3] = p1;
            } else {
                System.out.println("The cell is already occupied!");
                continue;
            }
            board[secondPlayerMove / 3][secondPlayerMove % 3] = p2;
            checkWinner(board, p2);
            printBoard(board);
        }
    }

    public static void printBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkWinner(String[][] board, String player) {
        boolean winner = false;
        return winner;
    }
}