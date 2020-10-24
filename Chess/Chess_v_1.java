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
 *  
 * 
 * 
 */

public class Chess_v_1 {
    
}
