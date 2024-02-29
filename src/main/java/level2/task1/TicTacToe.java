package level2.task1;

import java.util.Scanner;

public class TicTacToe {

        private static final char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        private static char currentPlayer = 'X';

        public static void main(String[] args) {
            System.out.println("---------------Welcome to Tic-Tac-Toe Game---------------");
            Scanner userInput = new Scanner(System.in);
            boolean gameInProgress = true;

            while (gameInProgress) {
                System.out.println("Lets Play!");
                System.out.println("""
                        Rules:\s
                        1. 2 Player -->\s
                        \t\tP1 is "X"
                        \t\tP2 is "O"
                        2. You have to insert row number and column number in range [1-3] [1-3]
                        3. Example: Player X/O: 3 1""");
                displayBoard();

                int row, col;

                do {
                    System.out.println("Player " + currentPlayer + ": ");
                    row = userInput.nextInt() - 1;
                    col = userInput.nextInt() - 1;
                } while (!isValidMove(row, col));

                board[row][col] = currentPlayer;

                if (checkForWin() || checkForDraw()) {
                    displayBoard();
                    System.out.println("Game Over! \nResult: " + (checkForWin() ? "Player " + currentPlayer + " wins!" : "It's a draw!"));
                    System.out.println("Do you want to play again? (yes/no): ");
                    String playAgain = userInput.next().toLowerCase();
                    if (!playAgain.equals("yes")) {
                        gameInProgress = false;
                    } else {
                        resetBoard();
                    }
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }

            System.out.println("Thanks for playing, Good Bye!");
            userInput.close();
        }

        private static void displayBoard() {
            System.out.println("╔═════╦═════╦═════╗");
            for (int i = 0; i < 3; i++) {
                System.out.println("║  " + board[i][0] + "  ║  " + board[i][1] + "  ║  " + board[i][2] + "  ║");
                if (i < 2) {
                    System.out.println("╠═════╬═════╬═════╣");
                }
            }
            System.out.println("╚═════╩═════╩═════╝");
        }

        private static boolean isValidMove(int row, int col) {
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                return true;
            } else {
                System.out.println("Invalid move! Try again.");
                return false;
            }
        }

        private static boolean checkForWin() {
            return (checkRows() || checkColumns() || checkDiagonals());
        }

        private static boolean checkRows() {
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                    return true;
                }
            }
            return false;
        }

        private static boolean checkColumns() {
            for (int i = 0; i < 3; i++) {
                if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                    return true;
                }
            }
            return false;
        }

        private static boolean checkDiagonals() {
            return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                    (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
        }

        private static boolean checkForDraw() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        return false;
                    }
                }
            }
            return true;
        }

        private static void resetBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = ' ';
                }
            }
            currentPlayer = 'X';
        }

    }
//    char[][] board;
//    public TicTacToe(){
//        board=new char[3][3];
//        initBoard();
//    }
//    void initBoard(){
//        for (int i=0;i< board.length;i++){
//            for (int j=0;j< board[i].length;j++){
//                board[i][j]=' ';
//            }
//        }
//    }
//    void dispBoard(){
//        System.out.println("--------------");
//        for (int i=0;i< board.length;i++){
//            System.out.print(" | ");
//            for (int j=0;j< board[i].length;j++){
//                System.out.print(board[i][j] +" | ");
//            }
//            System.out.println();
//            System.out.println("--------------");
//        }
//    }
//
//    void placeMark(int row,int column,char mark){
//        if(row >=0 && row <=2 && column >=0 && column <=2){
//            board[row][column]=mark;
//        }
//        else {
//            System.out.println("Invalid Position");
//        }
//    }
//    Boolean checkColWin(){
//        for (int j=0;j<=2;j++){
//            if (board[0][j]!=' ' && board[0][j]== board[1][j] && board[1][j]== board[2][j]){
//                return true;
//            }
//        }
//        return false;
//    }
//    Boolean checkRowsWin(){
//        for (int i=0;i<=2;i++){
//            if (board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2]){
//                return true;
//            }
//        }
//        return false;
//    }
//    Boolean checkDiagWin(){
//        if (board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2] || board[0][2]!=' '&& board[0][2]==board[1][1] && board[1][1]==board[2][1]){
//            return true;
//        }
//        return false;
//    }

