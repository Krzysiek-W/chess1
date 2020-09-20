package chessObjectGame.board;

import chessObjectGame.chessPieces.ChessPieces;


import java.util.logging.Logger;

public class Board {
    Logger logger = Logger.getLogger("Board.class");
    ChessPieces[][] board;

    public Board() {
        this.board = new ChessPieces[8][8];
    }


    public Boolean itIsNotEmptyCell(Coordinates coords) {
        return board[coords.getVerticalPositionOnBoard()][coords.getHorizontalPositionOnBoard()] != null;
    }

    private void removePieceAtCell(Coordinates coords) {
        board[coords.getVerticalPositionOnBoard()][coords.getHorizontalPositionOnBoard()] = null;
    }

    public ChessPieces getPieceFromBoard(Coordinates coords) {
        return board[coords.getVerticalPositionOnBoard()][coords.getHorizontalPositionOnBoard()];
    }

    public static boolean outOfRange(Coordinates coords) {
        return coords.getVerticalPositionOnBoard() <= 0 &&
                coords.getVerticalPositionOnBoard() > 8 &&
                coords.getHorizontalPositionOnBoard() <= 0 &&
                coords.getHorizontalPositionOnBoard() > 8;
    }

    public void putPieceAtCell(ChessPieces piece, Coordinates coords) {
        if (itIsNotEmptyCell(coords)) {
            removePieceAtCell(coords);
        }
        if (piece.getCoordinates() != null) {
            removePieceAtCell(piece.getCoordinates());
        }
        board[coords.getVerticalPositionOnBoard()][coords.getHorizontalPositionOnBoard()] = piece;
        piece.setCoordinates(coords);
    }

    @Override
    public String toString() {
        String printBoard = " \n 0  1  2  3  4  5  6  7 \n";
        for (int vertical = 0; vertical < 8; vertical++) {
            printBoard += vertical;
            for (int horizontal = 0; horizontal < 8; horizontal++) {
                if (board[horizontal][vertical] != null) {
                    printBoard += " " + board[horizontal][vertical].getMark();
                } else {
                    printBoard += " - ";
                }
            }
            printBoard += "\n";
        }
        return printBoard;
    }

    public void show() {
//        String printBoard = "\n  0  1  2  3  4  5  6  7 \n";
//        for (int vertical = 0; vertical < 8; vertical++) {
//            printBoard += vertical;
//            for (int horizontal = 0; horizontal < 8; horizontal++) {
//                if (chessObjectGame.board[horizontal][vertical] != null) {
//                    printBoard += " " + chessObjectGame.board[horizontal][vertical].getMark();
//                } else {
//                    printBoard += " - ";
//                }
//            }
//            printBoard += "\n";
//        }
        logger.info(this::toString);
    }
}

