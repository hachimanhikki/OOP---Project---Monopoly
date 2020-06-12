public class SpecialField extends Field {
    private String name;
    private String type;
    private double maxFine;
    public SpecialField(String name, String type, double cost) {
        this.name = name;
        this.type = type;
        this.maxFine = cost * 0.1;
    }
    public String toString() {
        return this.type;
    }
}
