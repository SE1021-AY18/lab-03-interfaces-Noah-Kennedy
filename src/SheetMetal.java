public class SheetMetal implements Part {

    public static final double LBS_MULTIPLIER = 0.1;
    private double lengthInches;
    private double thicknessInches;
    public static final double USD_MULTIPLIER = .50;
    private double widthInches;

    public SheetMetal(double lengthInches, double widthInches, double thicknessInches) {
        this.lengthInches = lengthInches;
        this.widthInches = widthInches;
        this.thicknessInches = thicknessInches;
    }

    @Override
    public double getCost() {
        return USD_MULTIPLIER * thicknessInches * widthInches * lengthInches;
    }

    @Override
    public double getWeight() {
        return LBS_MULTIPLIER * thicknessInches * widthInches * lengthInches;
    }

    public String getName() {
        return "sheet";
    }

    public void printBillOfMaterials() {

    }
}
