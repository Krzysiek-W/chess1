package chessObjectGame.chessPieces;

import chessObjectGame.board.InitializingGame;
import chessObjectGame.board.Coordinates;

public class King extends ChessPieces {

    public King(String color, Coordinates initCoords, InitializingGame game) {
        super(color, initCoords, game);
        mark = color.equals("white") ? "wK" : "bK";
    }
}
