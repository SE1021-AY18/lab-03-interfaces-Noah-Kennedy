/*
 * SE1021 – 061
 * Winter 2017
 * Lab 3 - Interfaces
 * Name: Noah Kennedy
 * Created: 12/14/2017
 */


import java.text.DecimalFormat;

/**
 * The class representation of a Duplicate part.
 * Duplicate has a part and is a part.
 * Duplicate can contain as many copies of a single part as necessary.
 *
 * @author Noah Kennedy
 * @version 1.0
 */
public class Duplicate implements Part {

    private final DecimalFormat weightFormat;
    private final DecimalFormat costFormat;

    private Part identicalPart;
    private int numDuplicates;

    /**
     * The constant representation of the reduction factor
     * of a sale meeting or exceeding the first threshold.
     */
    public static final double REDUCTION_FACTOR1 = 0.95;

    /**
     * The constant representation of the reduction factor
     * of a sale meeting or exceeding the second threshold.
     */
    public static final double REDUCTION_FACTOR2 = 0.9;

    /**
     * The constant representation of the amount of units
     * required for a sale to be reduced with the first factor.
     */
    public static final int USD_THRESHOLD1 = 5;

    /**
     * The constant representation of the amount of units
     * required for a sale to be reduced with the second factor.
     */
    public static final int USD_THRESHOLD2 = 10;

    /**
     * The constructor for a Duplicate part.
     * @param identicalPart The part which is to be duplicated.
     * @param numDuplicates The number of duplicates of the part.
     */
    public Duplicate(Part identicalPart, int numDuplicates) {
        this.identicalPart = identicalPart;
        this.numDuplicates = numDuplicates;

        weightFormat = new DecimalFormat("#.### lbs");
        costFormat = new DecimalFormat("$0.00");
    }

    /**
     * Calculates the cost of a duplicate part.
     * @return The cost of the duplicate part.
     */
    @Override
    public double getCost() {
        double cost;

        cost = identicalPart.getCost() * numDuplicates;

        if(numDuplicates >= USD_THRESHOLD2) {
            cost *= REDUCTION_FACTOR2;
        } else if(numDuplicates >= USD_THRESHOLD1) {
            cost *= REDUCTION_FACTOR1;
        }

        return cost;
    }

    /**
     * Returns the name of the duplicate part according to the amount of duplicates
     * and the part which is duplicated.
     * @return The name of the part.
     */
    @Override
    public String getName() {
        return numDuplicates + " " + identicalPart.getName() + "s";
    }

    /**
     * Calculates the weight of the duplicate part.
     * @return The weight of the duplicates.
     */
    @Override
    public double getWeight() {
        return identicalPart.getWeight() * numDuplicates;
    }

    /**
     * Prints the bill of materials for the duplicate parts.
     */
    @Override
    public void printBillOfMaterials() {
        System.out.println("==========================");
        System.out.println(getName());
        System.out.println("==========================");
        System.out.println("Duplicate part: " + identicalPart.getName());
        System.out.println("Copies: " + numDuplicates);
        System.out.println("Individual cost: " + costFormat.format(identicalPart.getCost()));
        System.out.println("Individual weight: " + weightFormat.format(identicalPart.getWeight()));
        System.out.println("Total cost: " + costFormat.format(getCost()));
        System.out.println("Total weight: " + weightFormat.format(getWeight()));
        identicalPart.printBillOfMaterials();
    }


}
