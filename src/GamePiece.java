/**
 * This class represents a game piece of a player
 */
public class GamePiece {

    //------------------------------------attributes--------------------------------
    private final Color color;//color of game piece
    private Square currentSquare = new Square(GameBoard.MIN_SQUARE);//current square of game piece

    //------------------------------------constructor--------------------------------

    /**
     * Constructor
     *
     * @param color color of game piece
     */
    public GamePiece(Color color) {
        this.color = color;
    }

    //------------------------------------getters and setters--------------------------------

    /**
     *
     * @return color of game piece
     */
    public Color getColor() {
        return color;
    }

    /**
     *
     * @return current place of game piece
     */
    public int getCurrentPlace() {
        return currentSquare.getPlace();
    }


    /**
     * This function sets current square to given square
     *
     * @param currentSquare square being set to game piece
     */
    public void setCurrentSquare(Square currentSquare) {
        this.currentSquare = currentSquare;
    }

    public boolean onSnake() {
        return currentSquare.hasSnake();
    }

    public boolean onLadder() {
        return currentSquare.hasLadder();
    }

}
