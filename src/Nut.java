/*
 * SE1021 – 061
 * Winter 2017
 * Lab 3 - Interfaces
 * Name: Noah Kennedy
 * Created: 12/14/2017
 */

import java.text.DecimalFormat;

/**
 * The class representation of a nut.
 * Nut is a part.
 *
 * @author Noah Kennedy
 * @version 1.0
 */
public class Nut implements Part{
    private double diameterInches;

    /**
     * The constant representation of material density.
     */
    public static final double LBS_MULTIPLIER = 0.01;

    /**
     * The constant representation of the price of a given quantity of materials.
     */
    public static final double USD_MULTIPLIER = 0.5;
    private final DecimalFormat costFormat;
    private final DecimalFormat weightFormat;

    /**
     * The constructor for the Nut class.
     * @param diameterInches The interior diameter, in inches, of the nut.
     */
    public Nut(double diameterInches) {
        this.diameterInches = diameterInches;
        costFormat = new DecimalFormat("$0.00");
        weightFormat = new DecimalFormat("#.### lbs");
    }

    /**
     * Returns the name of the Nut object according to it's dimensions.
     * @return The name of the Nut.
     */
    @Override
    public String getName() {
        return diameterInches + " inch nut";
    }

    /**
     * Calculates the cost of the part.
     * @return The cost of the part.
     */
    @Override
    public double getCost() {
        return USD_MULTIPLIER * diameterInches;
    }

    /**
     * Calculates the weight of the part.
     * @return The weight of the part.
     */
    @Override
    public double getWeight() {
        return LBS_MULTIPLIER * Math.pow(diameterInches, 2);
    }

    /**
     * Prints the bill of materials for the part.
     */
    @Override
    public void printBillOfMaterials() {
        System.out.println("==========================");
        System.out.println(getName());
        System.out.println("==========================");

        System.out.println("Diameter: " + diameterInches + " inches");
        System.out.println("Cost: " + costFormat.format(getCost()));
        System.out.println("Weight: " + weightFormat.format(getWeight()));
    }
}
