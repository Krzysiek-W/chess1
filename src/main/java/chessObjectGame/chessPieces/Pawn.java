package chessObjectGame.chessPieces;

import chessObjectGame.board.InicialingGame;
import chessObjectGame.board.Coordinates;

public class Pawn extends ChessPieces {
    public Pawn(String color, Coordinates initCoords, InicialingGame game) {
        super(color, initCoords, game);
        mark = color.equals("white") ? "wP" : "bP";
    }
}
