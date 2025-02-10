import java.util.Scanner;

//Exceptions
class InvalidMenuOptionException extends Exception {
    public InvalidMenuOptionException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class MinimumBalanceRequiredException extends Exception {
    public MinimumBalanceRequiredException(String message) {
        super(message);
    }
}

public class CodingalBanking {
    private static double balance;

   //Menu display method
    public static void displayMenu() {
        System.out.println("\n--- State Bank of India ---");
        System.out.println("1. View Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    //Money deposit method
    public static void depositMoney(double amount) {
        balance += amount;
        System.out.println("Deposited: ₹" + amount);
    }

    // Money withdrawal method
    public static void withdrawMoney(double amount)
            throws InsufficientBalanceException, MinimumBalanceRequiredException {
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
            return;
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }
        if (balance - amount < 1000) { // Minimum balance check
            throw new MinimumBalanceRequiredException("Cannot withdraw, minimum balance required is ₹1000.");
        }
        balance -= amount;
        System.out.println("Withdrawn: ₹" + amount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.print("Enter your initial balance: ₹");
        balance = sc.nextDouble();

        //Minimum balance check for opening the account
        if (balance < 1000) {
            System.out.println("Opening balance must be at least ₹1000. Exiting...");

        }

        //Loop for menu options
        while (running) {
            try {
                displayMenu();
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Current Balance: ₹" + balance);
                        break;

                    case 2:
                        System.out.print("Enter the deposit amount: ₹");
                        double depositAmount = sc.nextDouble();
                        depositMoney(depositAmount);
                        break;

                    case 3:
                        System.out.print("Enter the withdrawal amount: ₹");
                        double withdrawAmount = sc.nextDouble();
                        withdrawMoney(withdrawAmount);
                        break;

                    case 4:
                        System.out.println("Exiting. Thank you for using SBI.");
                        running = false;
                        break;

                    default:
                        throw new InvalidMenuOptionException("Invalid option. Please select a valid option.");
                }
            } catch (InvalidMenuOptionException | InsufficientBalanceException | MinimumBalanceRequiredException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}
