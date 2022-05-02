public class GameBoard {
    static final int BOARD_SIZE = 100;
    static Square[] squares = new Square[BOARD_SIZE];
    static final int MIN_SQUARE = 1;

    public static void addLadder(int length, int squareNumber) {
        if(OutOfBounds(squareNumber)) {
            System.out.println("The square is not within the board's boundaries!");
        } else if(OutOfBounds(squareNumber + length)) {
            System.out.println("The ladder is too long!");
        } else {
            squares[squareNumber - 1].addLadder(length);
        }
    }

    public static void addSnake(int length, int squareNumber) {
        if(OutOfBounds(squareNumber)) {
            System.out.println("The square is not within the board's boundaries!");
        } else if (squareNumber == BOARD_SIZE) {
            System.out.println("You cannot add a snake in the last square!");
        } else if(OutOfBounds(squareNumber - length)) {
            System.out.println("The snake is too long!");
        } else {
            squares[squareNumber - 1].addSnake(length);
        }
    }

    public static boolean OutOfBounds(int squareNumber) {
        return squareNumber > BOARD_SIZE || squareNumber < MIN_SQUARE;
    }

}
