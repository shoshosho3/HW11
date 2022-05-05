/**
 * This function represents a die in the game
 */
public class Die {

    //------------------------------------attributes--------------------------------

    private final int min; // min value of die
    private final int max; // max value of die

    //------------------------------------constructors--------------------------------

    /**
     * Constructor
     *
     * @param min min value of die
     * @param max max value of die
     */
    public Die(int min, int max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Empty constructor with default values of die
     */
    public Die() {
        this(1, 6);
    }

    //------------------------------------public methods--------------------------------

    /**
     * This function implements a roll of the die
     *
     * @return result of roll of the die
     */
    public int roll() {
        return Main.rnd.nextInt(max - min + 1) + min;
    }
}
