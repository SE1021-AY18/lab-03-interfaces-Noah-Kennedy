/*
 * SE1021 – 061
 * Winter 2017
 * Lab 3 - Interfaces
 * Name: Noah Kennedy
 * Created: 12/14/2017
 */

/**
 * The behavioral template for a representation of a part.
 *
 * @author Noah Kennedy
 * @version 1.0
 */
public interface Part {
    double getCost();
    String getName();
    double getWeight();
    void printBillOfMaterials();
}
