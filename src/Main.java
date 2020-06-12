import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Database sql = new Database();
        Board game_board = new Board();
        game_board = sql.createBoard();
        int choice = 0;
        Player almas = new Player("almas");
        Player rakha = new Player("raha");
        while (true) {
            System.out.println("1. Make a move");
            System.out.println("2. Check cash");
            choice = scan.nextInt();
            if (choice == 1) {
                almas.makeMove();
                if (game_board.getCell(almas).toString().equals("special")) {
                    if (almas.getPosition() != 0) {
                        almas.specEvent();
                    }
                }
                else {
                    Property property = (Property)game_board.getCell(almas);
                    if (almas.isAbleToBuy(property) && !property.isOwned()) {
                        System.out.println("Do you want to buy this, enter 1 if you want or enter anything if not");
                        property.printInfo();
                        choice = scan.nextInt();
                        if (choice == 1) {
                            almas.buyProp(property);
                            ((Property) game_board.getCell(almas)).setOwner(almas.toString());
                        }
                    }
                }
            }
            else {
                System.out.print(almas.getMoney());
            }
            if (almas.getMoney() < 0) {
                System.out.println(almas.toString() + " lost the game");
                break;
            }
        }
    }
}
