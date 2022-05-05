/**
 * This function represents a player in the game
 */
public class Player {

    //------------------------------------attributes--------------------------------
    private final String name;//name of player
    private final GamePiece gamePiece;//game piece held by player

    //------------------------------------constructor--------------------------------

    /**
     * Constructor
     *
     * @param name      name of player
     * @param gamePiece game piece held by player
     */
    public Player(String name, GamePiece gamePiece) {
        this.name = name;
        this.gamePiece = gamePiece;
    }

    //------------------------------------getters--------------------------------

    /**
     * @return name of player
     */
    public String getName() {
        return name;
    }

    /**
     * @return color of player's game piece
     */
    public String getColor() {
        return gamePiece.getColor().toString();
    }

    /**
     * @return current place of player's game piece
     */
    public int getCurrentPlace() {
        return gamePiece.getCurrentPlace();
    }

    //------------------------------------public method--------------------------------

    /**
     * This function sets current square of player's game piece to given square
     *
     * @param currentSquare square being set to game piece
     */
    public void setCurrentSquare(Square currentSquare) {
        gamePiece.setCurrentSquare(currentSquare);
    }

    public boolean onSnake() {
        return gamePiece.onSnake();
    }

    public boolean onLadder() {
        return gamePiece.onLadder();
    }
}
