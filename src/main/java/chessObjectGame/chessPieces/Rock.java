package chessPieces;

import board.InicialingGame;
import board.Coordinates;

public class Rock extends ChessPieces{

    public Rock(String color, Coordinates initCoords, InicialingGame game) {
        super(color, initCoords, game);
        mark = color.equals("white") ? "wR" : "bR";
    }
}
