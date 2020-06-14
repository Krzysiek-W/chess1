import board.Board;
import board.InicialingGame;
import chessPieces.ChessPieces;
import chessPieces.King;
import board.Coordinates;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InicialingGame chessGame = new InicialingGame();
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;
        String currentPlayer = "white";
        String input;

        Coordinates newCoodrs;
        ChessPieces currentPiece;
        King king;

        while (!gameOver) {
            //System.out.println(chessGame.getBoard().toString());
            chessGame.getBoard().show();
            System.out.println(currentPlayer + " move");
            System.out.println("" +
                    "Press q to exit \n" +
                    "press m to move piece");

            input = scanner.nextLine();
            if (input.equalsIgnoreCase("Q") || input.equalsIgnoreCase("EXIT")) {
                gameOver = true;
                System.out.println("Game OVER");
                continue;
            } else if (input.equalsIgnoreCase("M") || input.equalsIgnoreCase("MOVE")) {

                currentPiece = getCurrentPiece(chessGame, currentPlayer);
                newCoodrs = getNewLocation();

                if (currentPiece.moveTo(newCoodrs)) {
                    currentPlayer = (currentPlayer.equalsIgnoreCase("white")) ? "black" : "white";
                } else {
                    System.out.println("Move was invalid");
                }
            }

        }
    }


    private static Coordinates createCoordinates(String input) {
        int vertical = Integer.parseInt(input.split(",")[0].trim());
        int horizontal = Integer.parseInt(input.split(",")[1].trim());
        return new Coordinates(vertical, horizontal);
    }

    private static Coordinates getNewLocation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Move to coords x,y");
        String input = scanner.nextLine();
        Coordinates newCoords = createCoordinates(input);
        return newCoords;
    }

    private static ChessPieces getCurrentPiece(InicialingGame game, String color) {
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

}
