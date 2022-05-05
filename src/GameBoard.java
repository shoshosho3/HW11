/**
 * This class represents board of a game
 */
public class GameBoard {

    //------------------------------------static attributes--------------------------------
    static final int MAX_SQUARE = 100;//max square index on board
    static final int MIN_SQUARE = 1;//min square index on board

    //------------------------------------attribute--------------------------------
    private final Square[] squares;//array of squares on board

    //------------------------------------constructors--------------------------------

    /**
     * Constructor, initializes squares on board
     */
    public GameBoard() {
        squares = new Square[MAX_SQUARE - MIN_SQUARE + 1];
        for (int i = MIN_SQUARE; i <=MAX_SQUARE; i++) {
            squares[i-MIN_SQUARE] = new Square(i);
        }
    }

    //------------------------------------getter--------------------------------

    /**
     *
     * @param place index of wanted square
     * @return square in index place on board
     */
    public Square getSquare(int place) {
        return squares[place];
    }

    //------------------------------------public methods--------------------------------

    /**
     * This function adds a ladder to square in square number if possible
     * A fitting message is printed if not possible
     *
     * @param length       length of wanted ladder
     * @param squareNumber number of square in board
     */
    public void addLadder(int length, int squareNumber) {
        if (OutOfBounds(squareNumber)) {
            System.out.println("The square is not within the board's boundaries!");
        } else if (OutOfBounds(squareNumber + length)) {
            System.out.println("The ladder is too long!");
        } else {
            squares[squareNumber - 1].addLadder(length);
        }
    }

    /**
     * This function adds a snake to square in square number if possible
     * A fitting message is printed if not possible
     *
     * @param length       length of wanted snake
     * @param squareNumber number of snake in board
     */
    public void addSnake(int length, int squareNumber) {
        if (OutOfBounds(squareNumber)) {
            System.out.println("The square is not within the board's boundaries!");
        } else if (squareNumber == MAX_SQUARE) {
            System.out.println("You cannot add a snake in the last square!");
        } else if (OutOfBounds(squareNumber - length)) {
            System.out.println("The snake is too long!");
        } else {
            squares[squareNumber - 1].addSnake(length);
        }
    }

    /**
     * This function checks if given square number is in board bounds
     *
     * @param squareNumber square number being tested
     * @return true if square number in board bounds, false otherwise
     */
    public boolean OutOfBounds(int squareNumber) {
        return squareNumber > MAX_SQUARE || squareNumber < MIN_SQUARE;
    }

}
