package chessPieces;

import board.InicialingGame;
import board.Coordinates;

public class King extends ChessPieces {

    public King(String color, Coordinates initCoords, InicialingGame game) {
        super(color, initCoords, game);
        mark = color.equals("white") ? "wK" : "bK";
    }
}
