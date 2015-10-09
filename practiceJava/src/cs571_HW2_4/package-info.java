/**
 * Since discount rate depends on Customer and Day, I change Customer from enum type to class,
 * and derive PrefferedCustomer class and SeniorCustomer class from the Customer class. 
 * 
 * the getDISCOUNT_RATE() method is overridden in PrefferedCustomer class and SeniorCustomer 
 * class to allow different discount rates for preffered customers and senior customers and 
 * different days.
 * 
 * Accordingly, the static data member DISCOUNT_RATE_DEFAULT, DISCOUNT_RATE_SINIOR and 
 * DISCOUNT_RATE_PREFERED as well as their getters and setters are removed.
 * 
 * Because who bought the items and when the items are sold is naturally attributes of a sale, 
 * I added Customer and Day as data member of Sale class, thus much simplified the design of 
 * the Sale class.
 * 
 * And the test code are revised accordingly.
 *
/**
 * @author speng
 * created on Oct 8, 2015
 */
package cs571_HW2_4;