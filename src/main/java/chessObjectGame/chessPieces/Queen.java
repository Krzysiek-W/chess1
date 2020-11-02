package chessObjectGame.chessPieces;

import chessObjectGame.board.InitializingGame;
import chessObjectGame.board.Coordinates;

public class Queen extends ChessPieces {

    public Queen(String color, Coordinates initCoords, InitializingGame game) {
        super(color, initCoords, game);
        mark = color.equals("white") ? "wQ" : "bQ";
    }
}
