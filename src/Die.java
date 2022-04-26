public class Die {
    private int min;
    private int max;

    public Die(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public Die() {
        this(1, 6);
    }

    public int roll() {
        return Main.rnd.nextInt(max - min + 1) + min;
    }
}
