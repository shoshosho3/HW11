public class GamePiece {
    private Color color;
    int place;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public GamePiece(Color color, int initplace) {
        this.color = color;
        this.place = initplace;
    }

    public int move(int steps)
    {
        int nextPlace = place+steps;
        if (nextPlace < GameBoard.MIN_SQUARE)
        {
            nextPlace = GameBoard.MIN_SQUARE;
        }
        else if(nextPlace > GameBoard.MAX_SQUARE)
        {
            // MAX_SQUARE - (nextPlace - MAX_SQUARE) = 2*MAX_SQUARE - nextPlace
            nextPlace = 2*GameBoard.MAX_SQUARE - nextPlace;
        }
        place = nextPlace;
        return place;
    }

}
