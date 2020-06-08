public class Property extends Field {
    private String name;
    private double cost;
    private double fine;
    private String type;
    public Property() {}
    public Property(String name, double cost, String type) {
        this.name = name;
        this.cost = cost;
        this.fine = cost * 0.1;
        this.type = type;
    }
}
