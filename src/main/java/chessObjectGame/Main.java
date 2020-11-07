package chessObjectGame;

import chessObjectGame.board.Board;
import chessObjectGame.board.InitializingGame;
import chessObjectGame.chessPieces.ChessPieces;
import chessObjectGame.chessPieces.King;
import chessObjectGame.board.Coordinates;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InitializingGame chessGame = new InitializingGame();
        boolean gameOver = false;
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

    private static Coordinates createCoordinates(String input) {
        try {
            int vertical = Integer.parseInt(convertHorizontalPosition(input.split("")[0].trim()));
            int horizontal = Integer.parseInt(input.split("")[1].trim()) - 1;
            return new Coordinates(horizontal, vertical);
        } catch (NumberFormatException e) {
            System.out.println("Bad command, use format eg. 'A1' ");
            Scanner scanner = new Scanner(System.in);
            return createCoordinates(scanner.nextLine());
        }
    }

    private static Coordinates getNewLocation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Move to coords xy");
        String input = scanner.nextLine();
        Coordinates newCoords = createCoordinates(input);
        return newCoords;
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
                System.out.println("Not your piece.");
            }
        }
    }

    //TODO Maybe enum?
    private static String convertHorizontalPosition(String letterPosition) {
        Map<String, String> letterArray = new HashMap<String, String>();
        letterArray.put("A", "0");
        letterArray.put("B", "1");
        letterArray.put("C", "2");
        letterArray.put("D", "3");
        letterArray.put("E", "4");
        letterArray.put("F", "5");
        letterArray.put("G", "6");
        letterArray.put("H", "7");

        return letterArray.getOrDefault(letterPosition, "9");
    }
}
