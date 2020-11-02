package chessObjectGame.chessPieces;

import chessObjectGame.board.InitializingGame;
import chessObjectGame.board.Coordinates;

public class Horse extends ChessPieces {

    public Horse(String color, Coordinates initCoords, InitializingGame game) {
        super(color, initCoords, game);
        mark = color.equals("white") ? "wH" : "bH";
    }
}
