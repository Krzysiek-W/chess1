package chessPieces;

import board.InicialingGame;
import board.Coordinates;

public class Horse extends ChessPieces {


    public Horse(String color, Coordinates initCoords, InicialingGame game) {
        super(color, initCoords, game);
        mark = color.equals("white") ? "wH" : "bH";
    }
}
