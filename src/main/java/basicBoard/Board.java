package basicBoard;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Board {

    public static String[][] creatorNewBoard() {

        String[][] newBoard = new String[9][9];
        String[] letterArray = {" _|", " A|", " B|", " C|", " D|", " E|", " F|", " G|", " H|"};
        String[] numberArry = {" _|", " 1|", " 2|", " 3|", " 4|", " 5|", " 6|", " 7|", " 8|"};
        String[] figuresChessWhite = {" A|", "|R|", "|h|", "|B|", "|Q|", "|K|", "|B|", "|h|", "|R|"};
        String[] figuresChessBlack = {" H|", "|R|", "|h|", "|B|", "|K|", "|Q|", "|B|", "|h|", "|R|"};

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                newBoard[i][j] = "|#|";

            }
        }
        for (int i = 0; i < 9; i++) {
            newBoard[0][i] = letterArray[i];
            newBoard[i][0] = numberArry[i];
            newBoard[2][i] = "|P|";
            newBoard[7][i] = "|P|";
            newBoard[1][i] = figuresChessBlack[i];
            newBoard[8][i] = figuresChessWhite[i];
        }


        return newBoard;
    }

    public static void printBoard(String[][] board) {


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static String[][] movePawn(String[][] board) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Twój ruch: \n");
        String move = scanner.nextLine();
        String [] moves = move.split(" ",2);
        Pattern compiledMatcher = Pattern.compile("[A-H][1-8]");
        Matcher matcher = compiledMatcher.matcher(moves[0]);
        Matcher matcher1 = compiledMatcher.matcher(moves[1]);

        if (matcher.find() == true && matcher1.find() == true) {
            int x = 0, x2 = 0, y = 0, y2 = 0;
            String[] moveArray = move.split("");
            String[] letterArray = {"A", "B", "C", "D", "E", "F", "G", "H"};

            for (int i = 0; i < 8; i++) {
                if (moveArray[0].equals(letterArray[i])) {
                    x = i + 1;
                    y = Integer.parseInt(moveArray[1]);
                }
                if (moveArray[3].equals(letterArray[i])) {
                    x2 = i + 1;
                    y2 = Integer.parseInt(moveArray[4]);
                }
            }
            board[y2][x2] = board[y][x];

            board[y][x] = "|#|";

            return board;
        }
        System.out.print("nieprawidłowy ruch\n");
        return board;


    }
}
