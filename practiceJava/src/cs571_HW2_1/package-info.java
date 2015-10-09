/**
 * Item class includes three data members: tile, origUnitPrice, quantity
 * Item class also includes getters and setters as wells as a getItemTotal method to calculate 
 * total price of this item.
 * 
 * The setOrigUnitPrice() method of Item class shall throw an runtime exception IllegalArgumentException 
 * if argument origUnitPrice is non-positive.
 * 
 * There two JUnit test class to test the Item class and Sale class. Very simple methods such as 
 * getter and setters are not tested since testing them virtually means to test the JVM itself, and 
 * we can assume that JVM has already been well tested.
 * 
 * In the UT_Item class, the case that input argument of setOrigUnitPrice() method is non-positive is 
 * tested.
 */
/**
 * @author speng
 * created on Oct 7, 2015
 */
package cs571_HW2_1;