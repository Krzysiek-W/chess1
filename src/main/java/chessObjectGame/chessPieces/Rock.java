package chessObjectGame.chessPieces;

import chessObjectGame.board.InitializingGame;
import chessObjectGame.board.Coordinates;

public class Rock extends ChessPieces{

    public Rock(String color, Coordinates initCoords, InitializingGame game) {
        super(color, initCoords, game);
        mark = color.equals("white") ? "wR" : "bR";
    }
}
