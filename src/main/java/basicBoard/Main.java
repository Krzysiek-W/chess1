package basicBoard;

public class Main {
    public static void main(String[] args) {
      String[][] newBoard = Board.creatorNewBoard();
       Board.printBoard(newBoard);
       Board.printBoard(Board.movePawn(newBoard));

    }
}
