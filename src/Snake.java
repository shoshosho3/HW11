/**
 * this function represents a snake in the game
 */
public class Snake {
    //------------------------------------attribute--------------------------------
    private final int length;//length of snake

    //------------------------------------constructor--------------------------------

    /**
     * constructor
     *
     * @param length length of snake
     */
    public Snake(int length) {
        this.length = length;
    }

    //------------------------------------getter--------------------------------

    /**
     * @return length of snake
     */
    public int getLength() {
        return length;
    }
}