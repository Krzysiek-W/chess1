package chessPieces;

import board.InicialingGame;
import board.Coordinates;

public class Bishop extends ChessPieces {


    public Bishop(String color, Coordinates initCoords, InicialingGame game) {
        super(color, initCoords, game);
        mark = color.equals("white") ? "wB" : "bB";
    }

}
