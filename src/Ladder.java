/**
 * This class represents a ladder in the game
 */
public class Ladder {

    //------------------------------------attribute--------------------------------
    private final int length;//length of ladder

    //------------------------------------constructor--------------------------------

    /**
     * constructor
     *
     * @param length length of ladder
     */
    public Ladder(int length) {
        this.length = length;
    }

    //------------------------------------getter--------------------------------

    /**
     * @return value of length
     */
    public int getLength() {
        return length;
    }
}
