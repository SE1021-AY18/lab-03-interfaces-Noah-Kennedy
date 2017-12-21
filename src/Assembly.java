/*
 * SE1021 – 061
 * Winter 2017
 * Lab 3 - Interfaces
 * Name: Noah Kennedy
 * Created: 12/14/2017
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * The class representation of an assembly.
 * An assembly is composed of parts and is a part.
 *
 * @author Noah Kennedy
 * @version 1.0
 */
public class Assembly implements Part {
    private final DecimalFormat costFormat;
    private final DecimalFormat weightFormat;
    private String name;
    private List<Part> subParts;

    /**
     * The constant amount added to an assembly's price for every additional sub-part.
     */
    public static final double USD_PER_SUB_PART = 0.25;

    /**
     * The constructor for an Assembly object.
     * @param name The name of the Assembly.
     */
    public Assembly(String name) {
        this.name = name;
        subParts = new ArrayList<>();
        weightFormat = new DecimalFormat("#.### lbs");
        costFormat = new DecimalFormat("$0.00");
    }

    /**
     * The method to add a new sub-part.
     * @param part The sub-part to be added.
     */
    public void addPart(Part part) {
        subParts.add(part);
    }

    /**
     * Prints the bill of materials for the part.
     */
    @Override
    public void printBillOfMaterials() {
        System.out.println("==========================");
        System.out.println(name);
        System.out.println("==========================");

        for (Part part : subParts) {
            System.out.println("Part: " + part.getName());
            System.out.println("Cost: " + costFormat.format(part.getCost()));
            System.out.println("Weight: " + weightFormat.format(part.getWeight()));
        }

        System.out.println("Total cost: " + costFormat.format(getCost()));
        System.out.println("Total weight: " + weightFormat.format(getWeight()));

        for (Part part : subParts) {
            part.printBillOfMaterials();
        }


    }

    /**
     * Calculates the cost of the Assembly.
     * @return The cost of the Assembly.
     */
    @Override
    public double getCost() {
        double cost;
        cost = USD_PER_SUB_PART * subParts.size();

        for (Part part : subParts) {
            cost += part.getCost();
        }

        return cost;
    }

    /**
     * Calculates the weight of the Assembly.
     * @return The weight of the Assembly.
     */
    @Override
    public double getWeight() {
        double weight;
        weight = 0;

        for (Part part : subParts) {
            weight += part.getWeight();
        }

        return weight;
    }

    @Override
    public String getName() {
        return name;
    }
}
