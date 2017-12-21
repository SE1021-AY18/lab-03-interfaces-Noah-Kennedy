/*
 * SE1021 – 061
 * Winter 2017
 * Lab 3 - Interfaces
 * Name: Noah Kennedy
 * Created: 12/14/2017
 */


import java.text.DecimalFormat;

/**
 * The class representation of a bolt which is a part.
 *
 * @author Noah Kennedy
 * @version 1.0
 */
public class Bolt implements Part {

    /**
     * The constant value which represents the density of the materials.
     */
    public static final double LBS_MULTIPLIER = .05;

    /**
     * The constant value which helps to calculate the cost.
     */
    public static final double USD_MULTIPLIER = 1.0;
    private double diameterInches;
    private double lengthInches;
    private final DecimalFormat costFormat;
    private final DecimalFormat weightFormat;

    /**
     * The constructor for the Bolt class.
     * @param diameterInches The diameter, in inches, of the bolt.
     * @param lengthInches The length, in inches, of the bolt.
     */
    public Bolt(double diameterInches, double lengthInches) {
        this.diameterInches = diameterInches;
        this.lengthInches = lengthInches;

        costFormat = new DecimalFormat("$0.00");
        weightFormat = new DecimalFormat("#.### lbs");
    }

    /**
     * Returns the name of the bolt.
     * @return The dimensions of the bolt followed by the word 'bolt'.
     */
    @Override
    public String getName() {
        return diameterInches + "x" + lengthInches + " bolt";
    }

    /**
     * Calculates the cost of the bolt.
     * @return The cost of the bolt.
     */
    @Override
    public double getCost() {
        return USD_MULTIPLIER * diameterInches * lengthInches;
    }

    /**
     * Calculates the weight of the bolt.
     * @return The weight of the bolt.
     */
    @Override
    public double getWeight() {
        return LBS_MULTIPLIER * Math.pow(diameterInches, 2) * lengthInches;
    }

    /**
     * Prints out the bill of materials for the bolt.
     */
    @Override
    public void printBillOfMaterials() {
        System.out.println("==========================");
        System.out.println(getName());
        System.out.println("==========================");
        System.out.println("Diameter: " + diameterInches + " inches");
        System.out.println("Length: " + lengthInches + " inches");
        System.out.println("Cost: " + costFormat.format(getCost()));
        System.out.println("Weight: " + weightFormat.format(getWeight()));
    }


}