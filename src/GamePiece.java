/**
 * This class represents a game piece
 */
public class GamePiece {

    //------------------------------------attributes--------------------------------
    private final Color color;
    private int currentPlace = GameBoard.MIN_SQUARE;

    //------------------------------------constructor--------------------------------

    /**
     * Constructor
     *
     * @param color color of game piece
     */
    public GamePiece(Color color) {
        this.color = color;
    }

    //------------------------------------getters--------------------------------

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
        return currentPlace;
    }

    //------------------------------------public methods--------------------------------

    /**
     * This function moves game piece from current place to another
     *
     * @param steps number of steps forward
     */
    public void move(int steps) {
        int nextPlace = currentPlace + steps;
        if (nextPlace < GameBoard.MIN_SQUARE) {
            nextPlace = GameBoard.MIN_SQUARE;
        } else if (nextPlace > GameBoard.MAX_SQUARE) {
            // MAX_SQUARE - (nextPlace - MAX_SQUARE) = 2*MAX_SQUARE - nextPlace
            nextPlace = 2 * GameBoard.MAX_SQUARE - nextPlace;
        }
        currentPlace = nextPlace;
    }

}
