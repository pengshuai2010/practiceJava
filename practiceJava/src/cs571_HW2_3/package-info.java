/**
 * Because new seniors' discount is only on Tuesday, to reflect this change, I added a Enum type Day, 
 * including MONDAY, TUESDAY, WENSDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY. 
 * 
 * Because DISCOUNT_RATE_NORMAL may also apply to senior customers, it is not longer proper to call it "NORMAL",
 * so I renamed "DISCOUNT_RATE_NORMAL" to "DISCOUNT_RATE_DEFAULT". Accordingly, the "NORMAL" in Enum type Customer
 * is also renamed to "DEFAULT".
 * 
 * And I added another argument of Enum type Day to getDiscountRate() method, so that when day == Day.TUESDAY and
 * customer == Customer.SENIOR, DISCOUNT_RATE_DEFAULT is returned.
 * 
 * Now that the getDiscountRate() method is no longer a simple getter method, it has to be tested too. I added a 
 * testGetDiscountRate() method in Unit test class for class Sale. All test methods in UT_Sale class are 
 * refactored to thoroughly test all combinations of Day and Custom type.
 */
/**
 * @author shuaipeng
 *
 */
package cs571_HW2_3;