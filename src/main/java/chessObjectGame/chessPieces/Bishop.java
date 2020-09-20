package chessObjectGame.chessPieces;

import chessObjectGame.board.InicialingGame;
import chessObjectGame.board.Coordinates;

public class Bishop extends ChessPieces {


    public Bishop(String color, Coordinates initCoords, InicialingGame game) {
        super(color, initCoords, game);
        mark = color.equals("white") ? "wB" : "bB";
    }

}
