/**
 * Since the "buy one, get the second (and the rest of the same item) 50% off" policy is related 
 * to specific kind of items, I choose to refactor the Item class. 
 * 
 * I added a HashSet specialDiscounts to the Item class as a static data member, which contain 
 * the list of items that is applicable to this discount policy. It is static because it is not
 * not related to specific instance of Item class. And I chose hash set as its data structure 
 * because that hash set is fast in determining whether certain element is contained or not  
 * and that it does not allow duplicates.
 * 
 * I rewrited the getItemTotal() method to implement this discount policy.
 * 
 * To allow operations on the specialDiscounts, I added method addToSpecialDiscouts(), 
 * removeFromSpecialDiscouts() and isApplicableToSpecialDiscouts(). 
 * 
 * I updated the UT_Item class to test the newly added methods as well as the updated methods.
 */
/**
 * @author speng
 * created on Oct 8, 2015
 */
package cs571_HW2_5;