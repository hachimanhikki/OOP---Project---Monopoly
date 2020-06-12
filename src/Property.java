public class Property extends Field {
    private String name;
    private double cost;
    private double fine;
    private String color;
    private String type;
    private boolean owned;
    private  String owner;
    public Property() {}
    public Property(String name, double cost, String type, String color) {
        this.name = name;
        this.cost = cost;
        this.fine = cost * 0.1;
        this.type = type;
        this.color = color;
        this.owner = "none";
        this.owned = false;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public double getFine() {
        return fine;
    }

    public String getColor() {
        return color;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String toString() {
        return type;
    }
    public void printInfo() {
        System.out.println(name + " Cost is " + cost + " Income " + getFine());
    }
}
