
public class SnakesAndLaddersGame {
    private Die die;
    private final int MAX_NUM_OF_PLAYERS = 5;
    private final int MIN_NUM_OF_PLAYERS = 2;
    private final Player[] players = new Player[MAX_NUM_OF_PLAYERS];
    private int playerNum = 0;

    public SnakesAndLaddersGame(int min, int max) {
        this.die = new Die(min, max);
    }

    public SnakesAndLaddersGame() {
        this(1, 6);
    }

    public void initializeGame() {
        System.out.println("Initializing the game...");
        String input;
        do {
            input = Main.scanner.nextLine();
            if (input.startsWith("add player")) {
                addPlayer(input);
            } else if (input.startsWith("add ladder") || input.startsWith("add snake")) {
                int length = Integer.parseInt(input.split(" ")[2]);
                int squareNumber = Integer.parseInt(input.split(" ")[3]);
                if(input.startsWith("add ladder")) {
                    GameBoard.addLadder(length, squareNumber);
                } else {
                    GameBoard.addSnake(length, squareNumber);
                }
            } else if(input.equals("end") && playerNum < MIN_NUM_OF_PLAYERS) {
                System.out.println("Cannot start the game, there are less than two players!");
            }
        } while (!input.equals("end") || playerNum < MIN_NUM_OF_PLAYERS);

    }

    void addPlayer(String input) {
        if (playerNum > MAX_NUM_OF_PLAYERS) {
            System.out.println("The maximal number of players is five !");
        } else {
            String inputName = input.split(" ")[2];
            String inputColor = input.split(" ")[3];
            boolean nameUsed = isNameUsed(inputName);
            boolean colorUsed = isColorUsed(inputColor);
            if (nameUsed && colorUsed) {
                System.out.println("The name and the color are already taken!");
            } else if (nameUsed) {
                System.out.println("The name is already taken!");
            } else if (colorUsed) {
                System.out.println("The color is already taken!");
            } else {
                players[playerNum++] = new Player(inputName, new GamePiece(Color.valueOf(inputColor)));
            }
        }
    }

    /**
     * This function checks if there is an existing player with name
     *
     * @param name String of a name of a player
     * @return true if there is already a player with given name, otherwise false
     */
    boolean isNameUsed(String name) {
        for (Player player : players) {
            if (player != null && player.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This function checks if there is an existing player with color
     *
     * @param color String of a color of a player
     * @return true if there is already a player with given color, otherwise false
     */
    boolean isColorUsed(String color) {
        for (Player player : players) {
            if (player != null && player.getColor().equals(color)) {
                return true;
            }
        }
        return false;
    }

}
