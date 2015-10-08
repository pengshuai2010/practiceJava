/**
 * To support discounts for 3 different kind of customers, there should be 3 
 * different data members representing for them in Sale class. So I renamed 
 * DISCOUNT_RATE to DISCOUNT_RATE_NORMAL, and added DISCOUNT_RATE_SINIOR and 
 * DISCOUNT_RATE_PREFERED.
 * 
 * And I used Enum type to represent 3 kind of customers, namely SENIOR, PREFFERED
 * and NORMAL. 
 * 
 * I refactored getDiscountRate() method to take an argument of Enum type Customer.
 *  getDiscountRate() uses switch case statement to decide which discount rate is 
 * applicable.
 */
/**
 * @author speng
 * created on Oct 7, 2015
 */
package cs571_HW2_2;