package Chess;

/**
 * 
 * API Design
 * 
 * Base URL: my.chess.com
 * 
 * 
 * 
 * 
 * 
 * GET: {baseURL}/chess/initiate
 * Responses:
 * 200:
 *  Return a json object for the status if chess is initiated with a game id.
 *  body: Contains json 
 * 404:
 *  Return if chess not initialized
 * 
 * 
 * 
 * 
 * 
 * GET: {baseURL}/chess/{gameId}/player/{playerId}/move?from={location}?to={location}
 * Path Params:
 *  playerId: playerId of the player who is doing the move.
 *      values: A valid playerId
 *      type: String
 *  gameId: gameId is the id of the game which is beign played.
 *      values: A valid gameId
 *      type: String
 * Query Params:
 *  from: location from where the player wants to move
 *      values: A string of the numeric and the alphabets as per the chess board.
 *      type: String
 *  to: locatino to where the player wants to move
 *      values: A string of the numeric and the alphabets as per the chess board.
 *      type: String
 * Response:
 *  200:
 *      Return a json object if the move was valid, along with an object containig values if it attacked the another player pieces.
 *      body: Contains json of valid move along with , piece if any attacked by this move.
 *  401:
 *      Return a json object if the move was not valid,
 *      body: Contains json of invalid move.
 *
 * 
 * 
 * 
 * 
 * GET: {baseURL}/chess/{gameId}/player/{playerId}/winner
 * Path Params:
 *  gameId: gameId is the id of the game which is beign played.
 *      values: A valid gameId
 *      type: String
 *  playerId: playerId of the player who is doing the move.
 *      values: A valid playerId
 *      type: String
 * Response:
 *  200:
 *      Return a json object with status of game and if the player has won or defeated or no status
 *      body: Contains json
 *  500:
 *      Return a json object if request fails due to server error.
 * 
 * 
 * 
 * 
 * 
 * Database Design for Chess
 * Tables:
 *  Game
 *  User
 *  GameUserWonMapping
 *  Moves
 * 
 * Game Table
 *      ColName             Data Type               Constraints
 *      id                  var_char(10)            PK
 *      status              ENUM(5)                 Not Null
 *      player1             var_char(10)            Foreign Key to User
 *      player2             var_char(10)            Foreign Key to User
 *      
 * 
 * User Table
 *      ColName             Data Type               Constratints
 *      id                  var_char(10)            PK
 *      first_name          var_char(20)            Not Null
 *      last_name           var_char(20)            Not NUll
 *      email               var_char(30)            Not Null CK
 * 
 * GameUserWonMapping
 *      ColName             Data Type               Constraints
 *      id                  var_char(10)            PK
 *      gameID              var_char(10)            ForeignKey to Game Table
 *      userId              var_char(10)            ForeignKey to User
 * 
 * Moves
 *      ColName             Data Type               Constraints
 *      id                  var_char(10)            PK
 *      Piece               var_char(10)            Not Null
 *      LocationFrom        var_char(10)            Not NUll
 *      LocationTo          var_char(10)            Not Null
 *      LastMove            boolean                 Not Null
 *      PrevMove            var_char(10)            Key to Moves.ID
 *      NextMove            var_char(10)            Key to Moves.ID
 * 
 *      
 * 
 */


public class Chess_v_1 {
    
    Player player1;
    Player player2;
    Player currentPlayer;

    public Setup initiate() {
        Setup setup = new Setup();
        this.player1 = setup.player1;
        this.player2 = setup.player2;
        this.currentPlayer = setup.currentPlayer;
        return setup;
    }

    public IResponse move(Location from , Location to) {
        IResponse response = currentPlayer.move(from, to);
        if(currentPlayer.won()) {
            return new Success(Status.SUCCESS, "Player Won" + this);                
        }
        updatePlayer();
        return response;
    }

    public Player winner() {
        if(player1.won()) {
            return player1;
        }
        else if(player2.won()) {
            return player2;
        }
        else {
            return null;
        }
    }

    private void updatePlayer() {
        if(currentPlayer == player1) {
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1;
        }
    }

}

class Player {
    String first_name;
    String last_name;
    Color color;

    public IResponse move(Location from , Location to) {
        if(from.isValidMove(to)) {
            from.move(to);
            return new Success(Status.SUCCESS, "Moved");
        }
        else {
            return new Fail(Status.FAIL, "Invalid Move");
        }
    }

    public boolean won() {
        // Logic to find if player has won.
        return true;
    }
    
}

abstract class Color {
    String color = "";
}

enum Status {
    SUCCESS,
    FAIL
}

class Location {
    int num;
    String alpha;
    Piece piece;

    public boolean isValidMove(Location to) {
        return false;
    }

    public void move(Location to) {

    }
}

abstract class Piece {
    MovingStrategy movingStrategy;
}

class Pawn extends Piece {
    public Pawn(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }
}

interface MovingStrategy {
    void move(Piece piece);
}

class PawnMovingStrategy implements MovingStrategy{
    @Override
    public void move(Piece piece) {
        // TODO Auto-generated method stub

    }
}

interface IResponse {
}

class Fail implements IResponse {
    Status status;
    String message;
    public Fail(Status status, String message) {
        this.status = status;
        this.message = message;
    }
}

class Success implements IResponse {
    Status status;
    String message;
    public Success(Status status, String message) {
        this.status = status;
        this.message = message;
    }
}

class BLACK extends Color {
    public BLACK() {
        this.color = "BLACK";
    }
}

class WHITE extends Color {
    public WHITE() {
        this.color = "WHITE";
    }
}

class Setup {
    String gameId;
    Player player1;
    Player player2;
    Player currentPlayer = player1;
    public void findGame() {}
    public void findPlayer() {}
}
