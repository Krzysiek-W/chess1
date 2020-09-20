package chessObjectGame.chessPieces;

import chessObjectGame.board.InicialingGame;
import chessObjectGame.board.Coordinates;

public class Qeen extends ChessPieces {


    public Qeen(String color, Coordinates initCoords, InicialingGame game) {
        super(color, initCoords, game);
        mark = color.equals("white") ? "wQ" : "bQ";
    }
}
