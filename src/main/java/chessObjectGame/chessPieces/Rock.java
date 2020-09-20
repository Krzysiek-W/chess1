package chessObjectGame.chessPieces;

import chessObjectGame.board.InicialingGame;
import chessObjectGame.board.Coordinates;

public class Rock extends ChessPieces{

    public Rock(String color, Coordinates initCoords, InicialingGame game) {
        super(color, initCoords, game);
        mark = color.equals("white") ? "wR" : "bR";
    }
}
