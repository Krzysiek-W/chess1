package chessObjectGame.chessPieces;

import chessObjectGame.board.Board;
import chessObjectGame.board.InitializingGame;
import chessObjectGame.board.Coordinates;

import java.util.ArrayList;

public class Pawn extends ChessPieces {

    public Pawn(String color, Coordinates initCoords, InitializingGame game) {
        super(color, initCoords, game);
        mark = color.equalsIgnoreCase("white") ? "wP" : "bP";
    }

    boolean canAttack;

    boolean firstMove = true;

    ArrayList<Coordinates> movePawn = new ArrayList<>();

    @Override
    public boolean moveValidation(Coordinates coordinates, Coordinates newCoordinate) {
        int limitHorizontal = Coordinates.coordinatesDifference(coordinates, newCoordinate).getLeft();
        int limitVertical = Coordinates.coordinatesDifference(coordinates, newCoordinate).getRight();
        canAttack = false;

        Board board = gameInit.getBoard();
        int i = color.equalsIgnoreCase("white") ? 1 : -1;

        if (board.getPieceFromBoard(newCoordinate) != null) {
            canAttack = !color.equals(board.getPieceFromBoard(newCoordinate).getColor());
            if(limitVertical == 0){
                return false;
            }
        }
        if (limitHorizontal > 2 || limitHorizontal < -2 || limitVertical < -1 || limitVertical > 1) {
            return false;
        }

        if (limitVertical != 0) {
            if (canAttack) {
                if (coordinates.getHorizontalPositionOnBoard() + i == newCoordinate.getHorizontalPositionOnBoard() &&
                        coordinates.getVerticalPositionOnBoard() + limitVertical == newCoordinate.getVerticalPositionOnBoard()) {
                    firstMove = false;
                    return true;
                }
                ;
            } else {
                return false;
            }
        }

        if (limitHorizontal == 2 || limitHorizontal == -2) {
            if (firstMove) {
                i*=2;
                if (color.equalsIgnoreCase("white")) {
                    for (int j = 1; j < limitHorizontal; j++) {
                        if (board.getPieceFromBoard(coordinates.addToHorizontal(j)) != null) {
                            return false;
                        }
                    }
                } else {
                    for (int j = -1; j > limitHorizontal; j--) {
                        if (board.getPieceFromBoard(coordinates.addToHorizontal(j)) != null) {
                            return false;
                        }
                    }
                }
            } else {
                return false;
            }
        }

        if(coordinates.getHorizontalPositionOnBoard() + i != newCoordinate.getHorizontalPositionOnBoard()){
            return false;
        }
        firstMove = false;
        return true;
    }
}