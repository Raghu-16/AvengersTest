import java.util.Arrays;

/**
 * The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in a huge line. Each of them has a single 100, 50 or 25 dollar bill. An "Avengers" ticket costs 25 dollars.
 * Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.
 * Can Vasya sell a ticket to every person and give change if he initially has no money and sells the tickets strictly in the order people queue?
 * Return YES, if Vasya can sell a ticket to every person and give change with the bills he has at hand at that moment. Otherwise return NO.
 * tickets([25, 25, 50]) // => YES
 * tickets([25, 100]) // => NO. Vasya will not have enough money to give change to 100 dollars
 * tickets([25, 25, 50, 50, 100]) // => NO. Vasya will not have the right bills to give 75 dollars of change (you can't make two bills of 25 from one of 50)
 */

public class Clerk {
    public static String tickets(int[] customersInQueue) {

        // Imitate Cash register

        int twentyFiveDollarBill = 0;
        int fiftyDollarBill = 0;
        int hundredDollarBill = 0;

        for (int customerBill : customersInQueue) {
            boolean isSuccessful = false;

            switch (customerBill) {
                case 25:
                    twentyFiveDollarBill++;
                    isSuccessful = true;
                    break;
                case 50:
                    if (twentyFiveDollarBill > 0) {
                        twentyFiveDollarBill--;
                        fiftyDollarBill++;
                        isSuccessful = true;
                    }
                    break;
                case 100:
                    if ((fiftyDollarBill >= 1 && twentyFiveDollarBill >= 1) || (twentyFiveDollarBill >= 3)) {
                        if (fiftyDollarBill >= 1) {
                            fiftyDollarBill--;
                            twentyFiveDollarBill--;
                        } else {
                            twentyFiveDollarBill -= 3;
                        }
                        isSuccessful = true;
                        hundredDollarBill++;
                    }
                    break;
                default:
                    break;
            }

            if (!isSuccessful) {
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {

        int[] customersLine1 = {25, 25, 50};
        int[] customersLine2 = {25, 100};
        int[] customersLine3 = {25, 25, 50, 50, 100};

        String resultLine1 = Clerk.tickets(customersLine1);
        String resultLine2 = Clerk.tickets(customersLine2);
        String resultLine3 = Clerk.tickets(customersLine3);

        System.out.println("Result of customers standing in LINE1  " + Arrays.toString(customersLine1) + " -> " + resultLine1);
        System.out.println("Result of customers standing in LINE2  " + Arrays.toString(customersLine2) + " -> " + resultLine2);
        System.out.println("Result of customers standing in LINE3  " + Arrays.toString(customersLine3) + " -> " + resultLine3);
    }
}
