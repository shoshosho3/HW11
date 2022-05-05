public class Player {
    private final String name;
    private final GamePiece gamePiece;

    public Player(String name, GamePiece gamePiece) {
        this.name = name;
        this.gamePiece = gamePiece;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return gamePiece.getColor().toString();
    }

    public int getPlace() {
        return gamePiece.getCurrentPlace();
    }

    public void move(int steps) {
        gamePiece.move(steps);
    }
}
