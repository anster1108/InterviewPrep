/*
	Lemonade Change
		Each lemonade at a booth sells for $5. Consumers are lining up to place individual orders, following the billing order. Every consumer will purchase a single lemonade and may pay with a $5, $10, or $20 bill. Each customer must receive the appropriate change so that the net transaction is $5. Initially, there is no change available.

		Determine if it is possible to provide the correct change to every customer. Return true if the correct change can be given to every customer, and false otherwise.

		Given an integer array bills, where bills[i] is the bill the ith customer pays, return true if the correct change can be given to every customer, and false otherwise.

	Example 1
		Input : bills = [5, 5, 10, 5, 20]

		Output : true

		Explanation : Initially we have $0 available for change.

		From first two customers, we will collect two $5 bills in order. After the first two customers we have two $5 bills available with us for change.

		From the third customer , we collect bill of $10 and give back $5. After third customer we have one $5 and one $10 bill available with us for change.

		From fourth customer , we collect $5 bill. After fourth customer we have two $5 and one $10 bills available with us for change if required.

		From fifth customer , we collect bill of $20 and give back $15 (one $10 + one $5 bill).

		Since all the customers did receive the change correctly , so we return true.
	Example 2
		Input : bills = [5, 5, 10, 10, 20]

		Output : false

		Explanation : From first two customers, we will collect two $5 bills in order. After the first two customers we have two $5 bills available with us for change.

		From third customer , we collect $10 and give back $5. After the third customer we have one $5 and one $10 bill available with us for change.

		From fourth customer , we collect $10 and give back $5. After the fourth customer we have two $10 bill available with us for change.

		From fifth customer , we collect $20 , we cannot give the $15 change as we have two $10 bills.

		Since all the customers did not receive the change correctly , the we return false.

	Example 3
		Input : bills = [5, 5, 10, 20]

		Output: true
*/

import java.util.*;

class Cashier {
    /* Function to find whether each customer can 
       be provided with correct change */
    public boolean lemonadeChange(int[] bills) {
        
        // Counter for $5
        int five = 0; 
        
        // Counter for $10
        int ten = 0;   
        
        // Iterate through each customer's bill
        for (int bill : bills) {
            
            /* If the customer's
               bill is $5 */
            if (bill == 5) {
                
                // Increment $5
                five++;  
            }
            
            /* If the customer's
               bill is $10 */
            else if (bill == 10) {
                
                /* Check if there are $5
                   bills available to give change */
                if (five > 0) {
                    // Use one $5
                    five--; 
                    // Receive one $10
                    ten++;   
                } else {
                    // If no $5 bill available, return false
                    return false;  
                }
            }
            
            /* If the customer's
               bill is $20 */
            else {
                /* Check if there are both
                   $5 and $10 bills
                   available to give change */
                if (five > 0 && ten > 0) {
                    // Use one $5
                    five--; 
                    // Use one $10
                    ten--;   
                } 
                /* If there are not enough $10 bills,
                   check if there are at least
                   three $5 bills available */
                else if (five >= 3) {
                    // Use three $5 bills
                    five -= 3;  
                } 
                /* If unable to give
                   change, return false */
                else {
                    return false;  
                }
            }
        }
        
        // Return true
        return true;  
    }

    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        System.out.print("Queues of customers: ");
        for (int bill : bills) {
            System.out.print(bill + " ");
        }
        System.out.println();
        Cashier Cashier = new Cashier();
        boolean ans = Cashier.lemonadeChange(bills);
        if (ans)
            System.out.println("It is possible to provide change for all customers.");
        else
            System.out.println("It is not possible to provide change for all customers.");
    }
}
/*
	Time Complexity: O(N) where N is the number of people in the queue or the number of bills to be processed. Each customer's bill is processed exactly once. The loop iterates N times, and the operations performed during each iteration are done in constant time.
	Space Complexity: O(1) because no extra space is used.
*/
