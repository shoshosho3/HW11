public class GameBoard {
    static final int BOARD_SIZE = 100;
    static final int MIN_SQUARE = 1;
    static Square[] squares;

    /**
     * constructor, initializes squares
     */
    public GameBoard() {
        squares = new Square[BOARD_SIZE];
    }

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
        } else if (squareNumber == BOARD_SIZE) {
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
        return squareNumber > BOARD_SIZE || squareNumber < MIN_SQUARE;
    }

}
