/**
 * This class represents a game of snakes and ladders
 */
public class SnakesAndLaddersGame {

    //------------------------------------constants--------------------------------
    private static final String NO_WINNER_YET = "";
    private static final int MAX_NUM_OF_PLAYERS = 5;
    private static final int MIN_NUM_OF_PLAYERS = 2;

    //------------------------------------attributes--------------------------------
    private final Die die;//die of the game
    private final Player[] players = new Player[MAX_NUM_OF_PLAYERS];//array of players playing game
    private int playerNum = 0;//number of players in game
    private GameBoard gameBoard;//game board of the game

    //------------------------------------constructors--------------------------------

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

    //------------------------------------public methods--------------------------------

    /**
     * This function initializes the game according to input from user
     */
    public void initializeGame() {
        String input;

        this.gameBoard = new GameBoard();
        System.out.println("Initializing the game...");
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
     * This function implements a game
     *
     * @return String of winner
     */
    public String start() {
        int roundNumber = 1;
        String winner = NO_WINNER_YET;
        while (winner.equals(NO_WINNER_YET)) {
            System.out.println("------------------------- Round number " + roundNumber + " -------------------------");
            winner = playRound();
            roundNumber++;
        }
        return winner;
    }

    //------------------------------------private methods--------------------------------

    //------------initialization methods------------

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
    private void addPlayer(String input) {
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
    private boolean isNameUsed(String name) {
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
    private boolean isColorUsed(String color) {
        for (Player player : players) {
            if (player != null && player.getColor().equals(color.toUpperCase())) {
                return true;
            }
        }
        return false;
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

    //------------game methods------------

    /**
     * This function implements a round of the game
     *
     * @return name of winner or "" if there's no winner
     */
    private String playRound() {
        for (int i = 0; i < playerNum; i++) {
            Player currentPlayer = players[i];

            //moves and checking for winner
            firstMove(currentPlayer);
            if (currentPlayer.getCurrentPlace() == GameBoard.MAX_SQUARE || snakesAndLadders(currentPlayer)) {
                System.out.println("\n");
                printPositions();
                return currentPlayer.getName();
            }

            System.out.println();
        }
        System.out.println();
        printPositions();
        return NO_WINNER_YET;
    }

    /**
     * This function moves the player according to die roll
     *
     * @param player current player playing his turn
     */
    private void firstMove(Player player) {
        int roll = die.roll();
        System.out.print(player.getName() + " rolled " + roll + ". The path to the next square: " +
                player.getCurrentPlace());
        player.setCurrentSquare(gameBoard.getSquare(getNext(player.getCurrentPlace(), roll) - 1));
        System.out.print(" -> " + player.getCurrentPlace());
    }

    /**
     * This function returns the next index according to given steps and current place
     *
     * @param currentPlace current place of a player's game piece
     * @param steps        amount of steps to next square
     * @return next index of square
     */
    private int getNext(int currentPlace, int steps) {
        int provisionalPlace = currentPlace + steps;
        if (provisionalPlace < GameBoard.MIN_SQUARE) {
            return GameBoard.MIN_SQUARE;
        }
        if (provisionalPlace > GameBoard.MAX_SQUARE) {
            // MAX_SQUARE - (nextPlace - MAX_SQUARE) = 2*MAX_SQUARE - nextPlace
            return 2 * GameBoard.MAX_SQUARE - provisionalPlace;
        }
        return provisionalPlace;
    }

    /**
     * This function implements movement of game piece on snakes and ladders in a turn of a player
     *
     * @param player current player playing his turn
     * @return true if the player won, false otherwise
     */
    private boolean snakesAndLadders(Player player) {
        while (player.onSnake() || player.onLadder()) {
            int place = player.getCurrentPlace();
            Square square = gameBoard.getSquare(place - 1);
            int steps = player.onLadder() ? square.getLadder().getLength() : -1 * square.getSnake().getLength();
            player.setCurrentSquare(gameBoard.getSquare(getNext(place, steps) - 1));
            System.out.print(" -> " + player.getCurrentPlace());

            if (player.getCurrentPlace() == GameBoard.MAX_SQUARE) {
                return true;
            }
        }
        return false;
    }

    /**
     * This function prints the positions of players
     */
    private void printPositions() {
        System.out.println("Players positions on the board:");

        for (int i = 0; i < playerNum; i++) {
            Player p = players[i];
            System.out.println(p.getName() + " is in square number " + p.getCurrentPlace());
        }
    }

}
