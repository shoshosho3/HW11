public class Square {
    Ladder ladder = null;
    Snake snake = null;
    int number;
    /**
     * empty constructor
     */
    public Square(int number) {
        this.number = number;
    }

    /**
     * This function adds a ladder to square if possible
     *
     * @param length length of ladder
     */
    public void addLadder(int length) {
        if (squareEmpty(true)) ladder = new Ladder(length);
    }

    /**
     * This function adds a snake to square if possible
     *
     * @param length length of snake
     */
    public void addSnake(int length) {
        if (squareEmpty(false)) snake = new Snake(length);
    }

    /**
     * This function checks if square is empty of snake and ladder
     * If not ot empty a fitting message is printed
     *
     * @param isLadder true if checking for ladder
     * @return true if square empty, otherwise false
     */
    boolean squareEmpty(boolean isLadder) {
        //checking if square has a bottom of a ladder
        if (haveLadder()) {
            System.out.println("This square " + (isLadder ? "already " : "") + "contains a bottom of a ladder!");
            return false;
        }
        //checking if square has a head of a snake
        if (haveSnake()) {
            System.out.println("This square " + (!isLadder ? "already " : "") + "contains a head of a snake!");
            return false;
        }
        return true;
    }

    public boolean haveLadder()
    {
        return ladder != null;
    }
    public boolean haveSnake()
    {
        return snake != null;
    }
}
