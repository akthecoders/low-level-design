package Chess;

import java.util.ArrayList;
import java.util.List;

class Board {
    int rows;
    int cols;
    List<Piece> pieces = new ArrayList<>();
}

class Player {
    String name;

    public void move(Board board, Piece piece, Location dest) {}
}

interface Piece {
    Location location = new Location();
    Color color = Color.WHITE;
}

class Pawn implements Piece {

}

enum Color {
    WHITE, BLACK
}

class Location {
    int row = 0;
    int col = 0;
}


public class Chess {
    Board board;
    Player player1;
    Player player2;
    Player currentPlayer;

    Chess() {
        board = new Board();
        player1 = new Player();
        player2 = new Player();
    }

    public void play() {
        Piece piece = new Pawn();
        Location dest = new Location();
        currentPlayer.move(board, piece, dest);
        if(isWinner(currentPlayer)) {
            System.out.println("Player has won " + currentPlayer.name);
            return;
        }
        nextPlayer();
    }

    public void nextPlayer() {
        if(currentPlayer.equals(player1)) {
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1;
        }
    }

    public boolean isWinner(Player currentPlayer) {return true;}
}
