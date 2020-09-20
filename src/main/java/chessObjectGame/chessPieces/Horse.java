package chessObjectGame.chessPieces;

import chessObjectGame.board.InicialingGame;
import chessObjectGame.board.Coordinates;

public class Horse extends ChessPieces {


    public Horse(String color, Coordinates initCoords, InicialingGame game) {
        super(color, initCoords, game);
        mark = color.equals("white") ? "wH" : "bH";
    }
}
