package board;

import chessPieces.*;

public class InicialingGame {

    private Board board;


    public InicialingGame() {
        board = new Board();
        setUpPiecesOfBoard("white");
        setUpPiecesOfBoard("black");
    }

    private void setUpPiecesOfBoard(String color) {

        int one = (color.equals("black")) ? -1 : 1;
        int side = (color.equals("white")) ? 0 : 7;
        int coordsIncrement = 0;

        ChessPieces r1 = new Rock(color, new Coordinates(side, coordsIncrement),this);
        ChessPieces r2 = new Rock(color, new Coordinates(side, 7 - coordsIncrement),this);
        coordsIncrement++;

        ChessPieces h1 = new Horse(color, new Coordinates(side, coordsIncrement),this);
        ChessPieces h2 = new Horse(color, new Coordinates(side, 7 - coordsIncrement),this);
        coordsIncrement++;

        ChessPieces b1 = new Bishop(color, new Coordinates(side, coordsIncrement),this);
        ChessPieces b2 = new Bishop(color, new Coordinates(side, 7 - coordsIncrement),this);
        coordsIncrement++;

        if (color.equals("white")) {
            ChessPieces q = new Qeen(color, new Coordinates(side, coordsIncrement),this);
            coordsIncrement++;
            ChessPieces k = new King(color, new Coordinates(side, coordsIncrement),this);
        } else {
            ChessPieces k = new King(color, new Coordinates(side, coordsIncrement),this);
            coordsIncrement++;
            ChessPieces q = new Qeen(color, new Coordinates(side, coordsIncrement),this);

        }

        for (int i = 0; i < 8 ; i++) {
            Pawn p = new Pawn(color,new Coordinates(side+one,i),this);

        }
    }

    public Board getBoard() {
        return board;
    }
}
