
public class SnakesAndLaddersGame {
    private final Die die;
    private final int MAX_NUM_OF_PLAYERS = 5;
    private final Player[] players = new Player[MAX_NUM_OF_PLAYERS];
    private int playerNum = 0;
    private GameBoard gameBoard;
    private boolean onLadder;

    /**
     * Constructor with parameters of dice range
     * The constructor creates game dice and empty game board
     *
     * @param min integer representing min result of dice
     * @param max integer representing max result of dice
     */
    public SnakesAndLaddersGame(int min, int max) {
        this.die = new Die(min, max);
        gameBoard = new GameBoard();
    }

    /**
     * Empty constructor with default values
     */
    public SnakesAndLaddersGame() {
        this(1, 6);
    }

    /**
     * This function sorts players by name
     */
    private void sortPlayers() {
        for (int i = 0; i < playerNum; i++) {
            for (int j = i; j < playerNum; j++) {
                if (players[i].getName().compareTo(players[j].getName()) > 0) {
                    Player temp = players[i];
                    players[i] = players[j];
                    players[j] = temp;
                }

            }

        }
    }

    /**
     * This function checks if a square has a snake or a ladder
     *
     * @param squareNumber integer representing square being tested
     * @return true if square has a ladder or a snake, false otherwise
     */
    private boolean OnLadderOrSnake(int squareNumber) {
        onLadder = gameBoard.squares[squareNumber].haveLadder();
        boolean onSnake = gameBoard.squares[squareNumber].haveSnake();
        return onSnake || onLadder;
    }

    /**
     * This function implements a game
     *
     * @return String of winner
     */
    public String start() {
        int roundNumber = 1;
        String winner = "";
        while (winner.equals("")) {
            System.out.println("------------------------- Round number " + roundNumber + " -------------------------");
            winner = playRound();
            roundNumber++;
        }
        return winner;
    }


    /**
     * This function implements a round of the game
     *
     * @return name of winner or "" if there's no winner
     */
    private String playRound() {
        String winner = "";
        for (int i = 0; i < playerNum && winner.equals(""); i++) {
            int roll = die.roll();
            Player current = players[i];
            System.out.print(current.getName() + " rolled " + roll + ". The path to the next square: " +
                    current.getPlace());

            current.move(roll);
            int newPlace = current.getPlace();
            System.out.print(" -> " + newPlace);

            if (current.getPlace() == GameBoard.MAX_SQUARE) {
                System.out.println("\n");
                printPositions();
                return current.getName();
            }

            while (OnLadderOrSnake(newPlace - 1)) {
                current.move((onLadder ? 1:-1)*gameBoard.squares[newPlace - 1].ladder.getLength());
                newPlace = current.getPlace();
                System.out.print(" -> " + newPlace);

                if (current.getPlace() == GameBoard.MAX_SQUARE) {
                    winner = current.getName();
                    break;
                }

            }
            System.out.println();
        }

        System.out.println();
        printPositions();
        return winner;
    }

    /**
     * This function prints the positions of players
     */
    private void printPositions() {
        System.out.println("Players positions on the board:");

        for (int i = 0; i < playerNum; i++) {
            Player p = players[i];
            System.out.println(p.getName() + " is in square number " + p.getPlace());
        }
    }

    /**
     * This function initializes the game according to input from user
     */
    public void initializeGame() {
        this.gameBoard = new GameBoard();
        System.out.println("Initializing the game...");
        String input;

        final int MIN_NUM_OF_PLAYERS = 2;
        do {
            input = Main.scanner.nextLine();
            if (input.startsWith("add")) {
                addObject(input.substring(4));
            } else if (input.equals("end") && playerNum < MIN_NUM_OF_PLAYERS) {
                System.out.println("Cannot start the game, there are less than two players!");
            }
        } while (!input.equals("end") || playerNum < MIN_NUM_OF_PLAYERS);


        sortPlayers();
    }

    /**
     * This function checks input starting with the word "add" and adds to board accordingly
     *
     * @param input String representing input after word add
     */
    private void addObject(String input) {
        if (input.startsWith("player")) {
            addPlayer(input);
        } else if (input.startsWith("ladder") || input.startsWith("snake")) {
            int length = Integer.parseInt(input.split(" ")[1]);
            int squareNumber = Integer.parseInt(input.split(" ")[2]);
            if (input.startsWith("ladder")) {
                gameBoard.addLadder(length, squareNumber);
            } else {
                gameBoard.addSnake(length, squareNumber);
            }
        }
    }

    /**
     * This function adds player if it is possible
     * It prints a fitting message if not possible
     *
     * @param input input of player
     */
    void addPlayer(String input) {
        if (playerNum >= MAX_NUM_OF_PLAYERS) {
            System.out.println("The maximal number of players is five !");
        } else {
            String inputName = input.split(" ")[1];
            String inputColor = input.split(" ")[2];
            boolean nameUsed = isNameUsed(inputName);
            boolean colorUsed = isColorUsed(inputColor);
            if (nameUsed && colorUsed) {
                System.out.println("The name and the color are already taken!");
            } else if (nameUsed) {
                System.out.println("The name is already taken!");
            } else if (colorUsed) {
                System.out.println("The color is already taken!");
            } else {
                players[playerNum++] = new Player(inputName, new GamePiece(Color.valueOf(inputColor.toUpperCase())));
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
            if (player != null && player.getColor().equals(color.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

}
