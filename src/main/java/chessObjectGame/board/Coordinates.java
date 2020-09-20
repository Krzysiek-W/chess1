package chessObjectGame.board;

public class Coordinates {
    int horizontalPositionOnBoard;
    int verticalPositionOnBoard;

    public Coordinates(int verticalPositionOnBoard, int horizontalPositionOnBoard) {
        this.horizontalPositionOnBoard = verticalPositionOnBoard;
        this.verticalPositionOnBoard = horizontalPositionOnBoard;
    }

    public int getHorizontalPositionOnBoard() {
        return horizontalPositionOnBoard;
    }

    public void setHorizontalPositionOnBoard(int horizontalPositionOnBoard) {
        this.horizontalPositionOnBoard = horizontalPositionOnBoard;
    }

    public int getVerticalPositionOnBoard() {
        return verticalPositionOnBoard;
    }

    public void setVerticalPositionOnBoard(int verticalPositionOnBoard) {
        this.verticalPositionOnBoard = verticalPositionOnBoard;
    }
}
