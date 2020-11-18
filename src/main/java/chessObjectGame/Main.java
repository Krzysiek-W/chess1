package chessObjectGame;

import chessObjectGame.board.Board;
import chessObjectGame.board.InitializingGame;
import chessObjectGame.chessPieces.ChessPieces;
import chessObjectGame.chessPieces.King;
import chessObjectGame.board.Coordinates;

import java.util.Scanner;

import static chessObjectGame.board.Coordinates.createCoordinates;

public class Main {
    public static void main(String[] args) {
        boolean gameOver = false;
        InitializingGame chessGame = new InitializingGame();

        String currentPlayer = "white";
        Scanner scanner = new Scanner(System.in);
        String input;
        Coordinates newCoodrs;
        ChessPieces currentPiece;
        King king;

        while (!gameOver) {
            chessGame.getBoard().showBoard();
            System.out.println(currentPlayer + " move");
            System.out.println("" +
                    "Press q to exit \n" +
                    "press m to move piece");

            input = scanner.nextLine();
            if (input.equalsIgnoreCase("Q") || input.equalsIgnoreCase("EXIT") || input.equalsIgnoreCase("QUIT")) {
                gameOver = true;
                System.out.println("GAME OVER");
            } else if (input.equalsIgnoreCase("M") || input.equalsIgnoreCase("MOVE")) {
                currentPiece = getCurrentPiece(chessGame, currentPlayer);
                newCoodrs = getNewLocation();

                if (currentPiece.moveTo(newCoodrs)) {
                    currentPlayer = (currentPlayer.equalsIgnoreCase("white")) ? "black" : "white";
                } else {
                    System.out.println("Move was invalid");
                }
            } else {
                System.out.println("WRONG COMMAND! \n" +
                        "press button");
                input = scanner.nextLine();
            }
        }
    }

    private static Coordinates getNewLocation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Move to coords xy");
        String input = scanner.nextLine();
        return createCoordinates(input);
    }

    private static ChessPieces getCurrentPiece(InitializingGame game, String color) {
        Scanner scanner = new Scanner(System.in);
        String input;
        Coordinates currentLocation;
        ChessPieces currentPiece;

        while (true) {
            System.out.println("Move from: ");
            input = scanner.nextLine();
            currentLocation = createCoordinates(input);
            if (Board.outOfRange(currentLocation)) {
                System.out.println("Coords out of range");
                continue;
            }
            currentPiece = game.getBoard().getPieceFromBoard(currentLocation);
            if (currentPiece == null) {
                System.out.println("empty field");
            } else if (currentPiece.getColor().equalsIgnoreCase(color)) {
                return currentPiece;
            } else {
                System.out.println("This is not your piece! Can't touch this :)");
            }
        }
    }
}
