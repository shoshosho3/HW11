/**
 * This class represents a square on the game board
 */
public class Square {

    //------------------------------------attributes--------------------------------
    private Ladder ladder = null;//ladder of which its bottom is on square
    private Snake snake = null;//snake of which its head is on square
    private final int place;//place of square on board

    //------------------------------------constructor--------------------------------

    /**
     * empty constructor
     */
    public Square(int place) {
        this.place = place;
    }

    //------------------------------------getters--------------------------------

    /**
     * @return ladder of which its bottom is on square
     */
    public Ladder getLadder() {
        return ladder;
    }

    /**
     * @return snake of which its head is on square
     */
    public Snake getSnake() {
        return snake;
    }

    /**
     * @return place of square on board
     */
    public int getPlace() {
        return place;
    }

    //------------------------------------public methods--------------------------------

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
     * This function checks if square has a ladder
     *
     * @return true if square has a ladder
     */
    public boolean hasLadder() {
        return ladder != null;
    }

    /**
     * This function checks if square has a snake
     *
     * @return true if square has a snake
     */
    public boolean hasSnake() {
        return snake != null;
    }

    //------------------------------------private method--------------------------------

    /**
     * This function checks if square is empty of snake and ladder
     * If not ot empty a fitting message is printed
     *
     * @param isLadder true if checking for ladder
     * @return true if square empty, otherwise false
     */
    private boolean squareEmpty(boolean isLadder) {

        //checking if square has a bottom of a ladder
        if (hasLadder()) {
            System.out.println("This square " + (isLadder ? "already " : "") + "contains a bottom of a ladder!");
            return false;
        }

        //checking if square has a head of a snake
        if (hasSnake()) {
            System.out.println("This square " + (!isLadder ? "already " : "") + "contains a head of a snake!");
            return false;
        }

        //square is empty
        return true;
    }
}
