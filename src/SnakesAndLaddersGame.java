
public class SnakesAndLaddersGame {
    private Die die;
    private final int MAX_NUM_OF_PLAYERS = 5;
    private Player[] players = new Player[MAX_NUM_OF_PLAYERS];

    public SnakesAndLaddersGame(int min, int max) {
        this.die = new Die(min, max);
    }

    public SnakesAndLaddersGame() {
        this(1, 6);
    }

    public void initializeGame() {
        String input;
        int playerCnt = 0
        do{
            input = Main.scanner.nextLine();
            if(input.startsWith("add player")) {
                if(playerCnt > MAX_NUM_OF_PLAYERS){
                    System.out.println("The maximal number of players is five !");
                }
                else{
                    String inputName = input.split(" ")[2];
                    String inputColor = input.split(" ")[3];
                    boolean  nameUsed = isNameUsed(inputName);
                    boolean  colorUsed = isColorUsed(inputColor);
                    if(nameUsed && colorUsed){
                        System.out.println("The name and the color are already taken!");
                    }
                    else if(nameUsed){
                        System.out.println("The name is already taken!");
                    }
                    else if(colorUsed){
                        System.out.println("The color is already taken!");
                    }
                    else{
                        players[playerCnt++] = new Player(inputName, new GamePiece(Color.valueOf(inputColor)));
                    }
                }
            }
            else if(input.startsWith("add ladder")){

            }
        } while(!input.equals("end"));
    }

    boolean isNameUsed(String name){
        for(Player player: players){
            if(player != null && player.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    boolean isColorUsed(String color){
        for(Player player: players){
            if(player != null && player.getColor().equals(color)){
                return true;
            }
        }
        return false;
    }

}
