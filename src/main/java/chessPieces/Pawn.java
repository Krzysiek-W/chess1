package chessPieces;

import board.InicialingGame;
import board.Coordinates;

public class Pawn extends ChessPieces {
    public Pawn(String color, Coordinates initCoords, InicialingGame game) {
        super(color, initCoords, game);
        mark = color.equals("white") ? "wP" : "bP";
    }
}
