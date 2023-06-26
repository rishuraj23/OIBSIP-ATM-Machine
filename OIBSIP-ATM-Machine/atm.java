import java.util.Scanner;

class Atminterface {

    static boolean status = false;

    static class Customer {
        String name;
        String acType;
        int deposit;
        int ac;
        int initial;
        int wDraw;
        int totalDepo;
        int totalWid;
        int adminPin;
        int custPin;
        int account_no;
        int amount;
        int initial_transfer;
        String name_receiver;
        String bank_name;
    }


    public static void create(Customer cust) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n\t Set Customer Name: ");
        cust.name = scanner.nextLine();
        System.out.print("\n\t Set Account Number: ");
        cust.ac = scanner.nextInt();
        scanner.nextLine();
        System.out.print("\n\t Enter Account type: ");
        cust.acType = scanner.nextLine();
        System.out.println("\n\t Account has been created successfully !!!");
    }

    public static void depo(Customer cust) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t \nEnter the amount you want to deposit : Rs ");
        cust.deposit = scanner.nextInt();
        System.out.println("\t \nAmount deposited successfully !");
        cust.initial += cust.deposit;
        cust.totalDepo += cust.deposit;
    }

    public static void check(Customer cust) {
        System.out.println("\t  --------------------------------\n");
        System.out.println("\t   Total available fund: Rs " + cust.initial + "\n");
        System.out.println("\t  --------------------------------\n");
    }

    public static void withdraw(Customer cust) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t Enter the withdraw amount: Rs ");
        int temp = scanner.nextInt();
        if (temp > cust.initial) {
            System.out.println("\t ---------------------------------\n");
            System.out.println("\t| X--Insuffient Fund Available--X |\n");
            System.out.println("\t ---------------------------------\n");
        } else {
            cust.wDraw = temp;
            cust.initial -= cust.wDraw;
            cust.totalWid += cust.wDraw;
        }
    }

    public static void display(Customer cust) {
        System.out.println("\n\n\n-------------------------------------------------------------\n");
        System.out.println(" \n\n\t\tTRANSACTION DETAILS \n\n");
        System.out.println(" \t\t NAME: " + cust.name + "\n");
        System.out.println(" \t\t Account Number: " + cust.ac + "\n");
        System.out.println(" \t\t Account Type: " + cust.acType + "\n");
        System.out.println(" \t\t Recent Deposit: Rs " + cust.deposit + "\n");
        System.out.println(" \t\t Recent Withdrawal: RS " + cust.wDraw + "\n");
        System.out.println(" \t\t Available Balance: Rs " + cust.initial + "\n");
        System.out.println(" \t\t Total Deposite: Rs " + cust.totalDepo + "\n");
        System.out.println(" \t\t Total Withdrawal: Rs " + cust.totalWid + "\n");
        System.out.println("\t\t Total amount transferred: Rs "+ cust.initial_transfer +"\n");
        System.out.println("\n\n\n-------------------------------------------------------------\n");
    }

    public static void transfer(Customer cust){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the name of the receiver : ");
        cust.name_receiver = scanner.nextLine();
        System.out.print("\nEnter the bank name of the receiver : ");
        cust.bank_name = scanner.nextLine();
        System.out.print("\nEnter the account number of the receiver : ");
        cust.account_no = scanner.nextInt();
        System.out.print("\nEnter the amount to be transfer : Rs ");
        cust.amount = scanner.nextInt();
        System.out.println("\nAmount transferred\n");
        cust.initial_transfer += cust.amount;
        cust.initial -= cust.initial_transfer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer cust = new Customer();

        cust.adminPin = 1234;
        cust.custPin = 123456;

        System.out.println("\n\n--------- Welcome to OASIS Infobyte Private Limited Bank ---------\n\n");

        int choice;

        do {
            System.out.println("\nPress Any Key to Continue...");
            scanner.nextLine();
            System.out.println("\n\n\n===========================================================\n");
            System.out.println("\t\t Atm Interface \n\n");
            System.out.println("\t \t 1.Create an account with us \n");
            System.out.println("\t \t 2.Deposit Balance\n");
            System.out.println("\t \t 3.Check Balance\n");
            System.out.println("\t \t 4.Withdraw Balance\n");
            System.out.println("\t \t 5.Account Holder's Details\n");
            System.out.println("\t \t 6. Transfer\n");
            System.out.println("\t \t 7.Exit");
            System.out.println("\n===========================================================\n");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            System.out.println("\n");

            switch (choice) {
                case 1:
                    System.out.print("Enter Administrator Pin to Create Account: ");
                    int tempPin = scanner.nextInt();
                    if (tempPin == cust.adminPin) {
                        create(cust);
                        status = true;
                    } else {
                        System.out.println("------- Pin Error -------");
                    }
                    break;

                case 2:
                    if (status) {
                        int tempPin2;
                        System.out.print("\nEnter 6 Digit Pin: ");
                        tempPin2 = scanner.nextInt();
                        if (tempPin2 == cust.custPin) {
                            depo(cust);
                        } else {
                            System.out.println("------- Pin Error -------");
                        }
                    } else {
                        System.out.println("------- No Account Found -------");
                    }
                    break;

                case 3:
                    if (status) {
                        int tempPin2;
                        System.out.print("\nEnter 6 Digit Pin: ");
                        tempPin2 = scanner.nextInt();
                        if (tempPin2 == cust.custPin) {
                            check(cust);
                        } else {
                            System.out.println("------- Pin Error -------");
                        }
                    } else {
                        System.out.println("------- No Account Found -------");
                    }
                    break;

                case 4:
                    if (status) {
                        int tempPin2;
                        System.out.print("\nEnter 6 Digit Pin: ");
                        tempPin2 = scanner.nextInt();
                        if (tempPin2 == cust.custPin) {
                            withdraw(cust);
                        } else {
                            System.out.println("------- Pin Error -------");
                        }
                    } else {
                        System.out.println("------- No Account Found -------");
                    }
                    break;

                case 5:
                    if (status) {
                        int tempPin2;
                        System.out.print("\nEnter 6 Digit Pin: ");
                        tempPin2 = scanner.nextInt();
                        if (tempPin2 == cust.custPin) {
                            display(cust);
                        } else {
                            System.out.println("------- Pin Error -------");
                        }
                    } else {
                        System.out.println("------- No Account Found -------");
                    }
                    break;
                case 6:
                    if(status) {
                        int tempPin2;
                        System.out.print("\nEnter 6 Digit Pin: ");
                        tempPin2 = scanner.nextInt();
                        if (tempPin2 == cust.custPin) {
                            transfer(cust);
                        } else {
                            System.out.println("------- Pin Error -------");
                        }
                    } else {
                        System.out.println("------- No Account Found -------");
                    }
                     break;
                case 7:
                     break;
        } }while (choice != 7);

        System.out.println("\n\t ---------------------------------\n");
        System.out.println("\t|   Thanks For Visiting Here !!!  |\n");
        System.out.println("\t ---------------------------------\n\n\n\n");
        System.out.println("\nPress Any Key To Close Application");

        scanner.nextLine();
    }
}