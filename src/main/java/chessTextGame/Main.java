package chessTextGame;

public class Main {
    public static void main(String[] args) {
        String[][] newBoard = Board.creatorNewBoard();
        Board.printBoard(newBoard);

        for(;;){
            Board.printBoard(Board.movePawn(newBoard));
        }
    }
}
