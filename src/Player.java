import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private String name;
    private double money;
    private int position;
    private ArrayList<Property> properties;
    private HashMap<String, Integer> monopoly;
    public Player(String pName) {
        name = pName;
        money = 1500;
        properties = new ArrayList<Property>();
        monopoly = new HashMap<String, Integer>();
        monopolyFill();
        position = 0;
    }
    private void monopolyFill() {
        monopoly.put("red", 0);
        monopoly.put("green", 0);
        monopoly.put("purple", 0);
        monopoly.put("blue", 0);
    }
    public String getName() {
        return name;
    }
    public boolean isMonopolist() { return monopoly.containsValue(3); }
    public ArrayList<Property> getProperties() {
        return properties;
    }

    public double getMoney() {
        return money;
    }

    public int getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    public void makeMove() {
        int move = 2 + (int) (Math.random() * 4);
        position += move;
        System.out.println("You are moving forward to " + move + " cells");
    }
    public void buyProp(Property bought) {
        this.properties.add(bought);
        int count = monopoly.get(bought.getColor());
        count++;
        monopoly.put(bought.getColor(), count);
        money -= bought.getCost();
    }
    public boolean isAbleToBuy(Property A) { return money >= A.getCost(); }
    public void payFine(double fine) {
        money -= fine;
    }
    public void makeFullCycle() {
        money += 250;
    }
    public void specEvent() {
        int specCoef = (int) (Math.random() * 5);
        if (specCoef == 0) {
            money += 10;
            System.out.println("You got a lucky day! You found a 10$ on the road");
        } else if(specCoef == 1) {
            money += 100;
            System.out.println("You have a birthday today! You get 100$ as a present");
        } else if(specCoef == 2) {
            money += 1000;
            System.out.println("You found a suitcase. When you opened it, you got a jackpot as a 1000$");
        } else if(specCoef == 3) {
            money -= 1000;
            System.out.println("You accidentally bumped into a someone's car, you're fined with 1000$ bill");
        } else if(specCoef == 4) {
            money -= 100;
            System.out.println("You lost your wallet, -100$");
        } else {
            money -= 10;
            System.out.println("You gave a homeless person 10$");
        }
    }
    public String toString() {
        return name;
    }
    public void printProperties() {
        if (properties.size() == 0){
            System.out.println("Sorry you didn't buy anything");
        }
        else {
            for (Property prop : properties) {
                System.out.printf("%-15s%s%15s", prop.getName(), prop.getFine(), prop.getColor());
                System.out.println();
            }
        }
    }
    public void profit(double fine) {
        money += fine;
    }
}
