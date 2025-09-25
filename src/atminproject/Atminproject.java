
package atminproject;
import java.util.Scanner;

public class Atminproject {
 private static final int PREDEFINED_PIN = 1234;
    private static int balance = 0;

    public static void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount! Try again.");
        }
    }

    public static void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount! Try again.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        }
    }

    public static void checkBalance() {
        System.out.println("Your balance is: " + balance);
    }
    
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
        int attempts = 3;

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            if (pin == PREDEFINED_PIN) {
                System.out.println("Login successful");

                while (true) {
                    System.out.println("===== ATM Menu =====");
                    System.out.println("1) Deposit");
                    System.out.println("2) Withdraw");
                    System.out.println("3) Check Balance");
                    System.out.println("4) Exit");
                    System.out.print("Choice: ");

                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.print("Enter amount to deposit: ");
                            int dep = sc.nextInt();
                            deposit(dep);
                            break;
                        case 2:
                            System.out.print("Enter amount to withdraw: ");
                            int wit = sc.nextInt();
                            withdraw(wit);
                            break;
                        case 3:
                            checkBalance();
                            break;
                        case 4:
                            System.out.println("Thank you for using the ATM. Goodbye!");
                            sc.close();
                            return;
                        default:
                            System.out.println("Invalid option! Try again.");
                            continue;
                    }
                }
            } else {
                attempts--;
                if (attempts == 0) {
                    System.out.println("Wrong PIN entered 3 times. Account locked!");
                } else {
                    System.out.println("Wrong PIN! Attempts left: " + attempts);
                }
            }
        }   
    }         
}        
    
    

