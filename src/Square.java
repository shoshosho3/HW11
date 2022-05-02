public class Square {
    Ladder ladder;
    Snake snake;

    public Square() {
    }

    public void addLadder(int length) {
        if (squareEmpty(true)) ladder = new Ladder(length);
    }

    public void addSnake(int length) {
        if (squareEmpty(false)) snake = new Snake(length);
    }

    boolean squareEmpty(boolean isLadder) {
        if (ladder != null) {
            System.out.println("This square " + (isLadder ? "already " : "") + "contains a bottom of a ladder!");
            return false;
        }
        if (snake != null) {
            System.out.println("This square " + (!isLadder ? "already " : "") + "contains a head of a snake!");
            return false;
        }
        return true;
    }
}
