package chessObjectGame.chessPieces;


import chessObjectGame.board.Board;
import chessObjectGame.board.InicialingGame;
import chessObjectGame.board.Coordinates;

public abstract class ChessPieces {
    protected String mark;
    protected String color;
    protected Coordinates coordinates;
    protected InicialingGame gameInit;

    public ChessPieces(String color, Coordinates initCoords, InicialingGame game) {
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
                oldPiece.getMark() != mark) {

            board.putPieceAtCell(this, newCoords);
            return true;
        }
        return false;
    }


    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public InicialingGame getGameInit() {
        return gameInit;
    }

    public void setGameInit(InicialingGame gameInit) {
        this.gameInit = gameInit;
    }
}



