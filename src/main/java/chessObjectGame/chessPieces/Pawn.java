package chessObjectGame.chessPieces;

import chessObjectGame.board.InitializingGame;
import chessObjectGame.board.Coordinates;

public class Pawn extends ChessPieces {

    public Pawn(String color, Coordinates initCoords, InitializingGame game) {
        super(color, initCoords, game);
        mark = color.equals("white") ? "wP" : "bP";
    }

    @Override
    public boolean moveValidation(Coordinates coordinates, Coordinates newCoords) {
        int i = color.equalsIgnoreCase("white") ? 1 : -1;
        return coordinates.getHorizontalPositionOnBoard() + i == newCoords.getHorizontalPositionOnBoard();
    }
}