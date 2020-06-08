import java.util.ArrayList;

public class Player {
    private String name;
    private double money;
    private int position;
    private ArrayList<Property> properties;
    public Player(String pName) {
        name = pName;
        money = 1500;
        properties = new ArrayList<Property>();
        position = 0;
    }

    public String getName() {
        return name;
    }

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
        position += 2 + (int) (Math.random() * 10);
    }
    public void buyProp(Property bought) {
        this.properties.add(bought);
    }
    public void payFine(double fine) {
        money -= fine;
    }
}
