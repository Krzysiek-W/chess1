package chessObjectGame.chessPieces;


import chessObjectGame.board.Board;
import chessObjectGame.board.InitializingGame;
import chessObjectGame.board.Coordinates;
import lombok.Data;

@Data
public abstract class ChessPieces {
    protected String mark;
    protected String color;
    protected Coordinates coordinates;
    protected InitializingGame gameInit;

    public ChessPieces(String color, Coordinates initCoords, InitializingGame game) {
        this.color = color;
        this.coordinates = null;
        this.gameInit = game;
        gameInit
                .getBoard()
                .putPieceAtCell(this, initCoords);
    }

    public boolean moveTo(Coordinates newCoords) {
        Board board = gameInit.getBoard();
        ChessPieces oldPiece = board.getPieceFromBoard(newCoords);

        if (oldPiece == null ||
                !oldPiece.getMark().equals(mark)) {

            board.putPieceAtCell(this, newCoords);
            return true;
        }
        return false;
    }
}



