public class SpecialField extends Field {
    private String name;
    private double maxFine;
    public SpecialField(String name, double cost) {
        this.name = name;
        this.maxFine = cost * 0.1;
    }
}
