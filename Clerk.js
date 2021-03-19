/**
 * Question:
 * The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in a huge line. Each of them has a single 100, 50 or 25 dollar bill. An "Avengers" ticket costs 25 dollars.
 * Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.
 * Can Vasya sell a ticket to every person and give change if he initially has no money and sells the tickets strictly in the order people queue?
 * Return YES, if Vasya can sell a ticket to every person and give change with the bills he has at hand at that moment. Otherwise return NO.
 *
 * Test cases
 * tickets([25, 25, 50]) // => YES
 * tickets([25, 100]) // => NO. Vasya will not have enough money to give change to 100 dollars
 * tickets([25, 25, 50, 50, 100]) // => NO. Vasya will not have the right bills to give 75 dollars of change (you can't make two bills of 25 from one of 50)
 */

function tickets(customersInQueue) {

    // Imitate Cash register

    let twentyFiveDollarBill = 0;
    let fiftyDollarBill = 0;
    let hundredDollarBill = 0;

    for (let customerBill of customersInQueue) {
        let isSuccessful = false;

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


let customersLine1 = [25, 25, 50];
let customersLine2 = [25, 100];
let customersLine3 = [25, 25, 50, 50, 100];

console.log(`Result of customers standing in LINE1 ${customersLine1} -> ${tickets(customersLine1)}`);
console.log(`Result of customers standing in LINE2 ${customersLine2} -> ${tickets(customersLine2)}`);
console.log(`Result of customers standing in LINE3 ${customersLine3} -> ${tickets(customersLine3)}`);