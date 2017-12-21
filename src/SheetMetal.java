/*
 * SE1021 – 061
 * Winter 2017
 * Lab 3 - Interfaces
 * Name: Noah Kennedy
 * Created: 12/14/2017
 */

import java.text.DecimalFormat;

/**
 * The class representation of SheetMetal.
 * SheetMetal is a part.
 *
 * @author Noah Kennedy
 * @version 1.0
 */
public class SheetMetal implements Part {

    /**
     * The constant representation of the density of the materials.
     * Used in calculating weight.
     */
    public static final double LBS_MULTIPLIER = 0.1;

    /**
     * The constant representation of the price of a quantity of materials.
     */
    public static final double USD_MULTIPLIER = .50;

    private double lengthInches;
    private double thicknessInches;
    private double widthInches;

    private final DecimalFormat costFormat;
    private final DecimalFormat weightFormat;

    /**
     * The constructor for the SheetMetal class.
     * @param lengthInches The length, in inches, of the sheet.
     * @param widthInches The width, in inches, of the sheet.
     * @param thicknessInches The thickness, in inches, of the sheet.
     */
    public SheetMetal(double lengthInches, double widthInches, double thicknessInches) {
        this.lengthInches = lengthInches;
        this.widthInches = widthInches;
        this.thicknessInches = thicknessInches;
        costFormat = new DecimalFormat("$0.00");
        weightFormat = new DecimalFormat("#.### lbs");
    }

    /**
     * Calculates the cost of the part.
     * @return The cost of the part.
     */
    @Override
    public double getCost() {
        return USD_MULTIPLIER * thicknessInches * widthInches * lengthInches;
    }

    /**
     * Calculates the weight of the part.
     * @return The weight of the part.
     */
    @Override
    public double getWeight() {
        return LBS_MULTIPLIER * thicknessInches * widthInches * lengthInches;
    }

    /**
     * Returns the name of the SheetMetal object according to it's dimensions.
     * @return The name of the SheetMetal object.
     */
    @Override
    public String getName() {
        return lengthInches + "x" + widthInches + "x" + thicknessInches + " sheet";
    }

    /**
     * Prints the bill of materials for the part.
     */
    @Override
    public void printBillOfMaterials() {
        System.out.println("==========================");
        System.out.println(getName());
        System.out.println("==========================");
        System.out.println("Length: " + lengthInches + " inches");
        System.out.println("Width: " +  widthInches + " inches");
        System.out.println("Thickness: " + thicknessInches + " inches");
        System.out.println("Cost: " +  costFormat.format(getCost()));
        System.out.println("Weight: " + weightFormat.format(getWeight()));
    }
}
