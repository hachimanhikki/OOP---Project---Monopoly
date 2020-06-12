import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();
        Database sql = new Database();
        Board game_board = new Board();
        game_board = sql.createBoard();
        int choice = 0;
        int turn = 0;
        System.out.println("How many players are gonna play?");
        try{
            choice = scan.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Enter number!!!");
            return;
        }
        if (choice == 1){
            System.out.println("YOU CANNOT PLAY THIS GAME ALONE IS TOOOOO DANGEROUS");
            return;
        }
        System.out.println("Enter players name:");
        while (choice != 0) {
            String name = scan.next();
            players.add(new Player(name));
            choice--;
        }
        while (true) {
            System.out.println("It is your turn " + players.get(turn).getName());
            while(true) {
                System.out.println("1. Make a move");
                System.out.println("2. Check cash");
                System.out.println("3. Check you properties");
                choice = scan.nextInt();
                if (choice == 1)
                    break;
                else if (choice == 2){
                    System.out.println(players.get(turn).getMoney());
                } else if (choice == 3){
                    players.get(turn).printProperties();
                }
            }
            players.get(turn).makeMove();
            if (game_board.getCell(players.get(turn)).toString().equals("special")) {
                if (players.get(turn).getPosition() != 0) {
                    players.get(turn).specEvent();
                }
            }
            else {
                Property property = (Property)game_board.getCell(players.get(turn));
                if (players.get(turn).isAbleToBuy(property) && !property.isOwned()) {
                    System.out.println("Do you want to buy this, enter 1 if you want or enter anything if not");
                    property.printInfo();
                    choice = scan.nextInt();
                    if (choice == 1) {
                        players.get(turn).buyProp(property);
                        ((Property) game_board.getCell(players.get(turn))).setOwner(players.get(turn));
                        ((Property) game_board.getCell(players.get(turn))).isBought();
                    }
                }
                else if(property.isOwned()) {
                    System.out.println("You are on someone's property, you will be charged to " + property.getFine() + "$");
                    players.get(turn).payFine(property.getFine());
                    int index = players.indexOf(property.getOwner());
                    players.get(index).profit(property.getFine());
                }
                else{
                    System.out.println("You don't have enough money");
                }
            }
            if (players.get(turn).getMoney() < 0) {
                System.out.println(players.get(turn).toString() + " lost the game");
                players.remove(turn);
            }
            if (players.get(turn).isMonopolist()){
                System.out.println("Winner is " + players.get(turn).toString());
                break;
            }
            if (players.size() == 1) {
                System.out.println("Winner is " + players.get(0).toString());
                break;
            }
            turn++;
            if (turn == players.size()) turn = 0;
        }
    }
}
