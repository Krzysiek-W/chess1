package chessObjectGame.board;

import chessObjectGame.chessPieces.ChessPieces;


import java.util.logging.Logger;

public class Board {
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
        return coords.getVerticalPositionOnBoard() < 0
                || coords.getVerticalPositionOnBoard() > 8
                || coords.getHorizontalPositionOnBoard() < 0
                || coords.getHorizontalPositionOnBoard() > 8;
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

    public void showBoard() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder printBoard = new StringBuilder(" \n   A  B  C  D  E  F  G  H \n");
        for (int vertical = 0; vertical < 8; vertical++) {
            printBoard.append(vertical + 1);
            for (int horizontal = 0; horizontal < 8; horizontal++) {
                if (board[horizontal][vertical] != null) {
                    printBoard.append(" ").append(board[horizontal][vertical].getMark());
                } else {
                    printBoard.append(" - ");
                }
            }
            printBoard.append("\n");
        }
        return printBoard.toString();
    }
}

