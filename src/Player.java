public class Player {
    private String name;
    private GamePiece gamePiece;

    public Player(String name, GamePiece gamePiece) {
        this.name = name;
        this.gamePiece = gamePiece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GamePiece getGamePiece() {
        return gamePiece;
    }

    public void setGamePiece(GamePiece gamePiece) {
        this.gamePiece = gamePiece;
    }

    public String getColor() {
        return gamePiece.getColor().toString();
    }

    public int getPlace() {
        return gamePiece.place;
    }

    public int move(int steps) {
        return gamePiece.move(steps);
    }
}
