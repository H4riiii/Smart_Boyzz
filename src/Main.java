import java.util.*;
import java.time.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int mainChoice = 0;
    static int memberChoice = 0;
    static int fundChoice = 0;
    static int storeChoice = 0;

    static String USERNAME;
    static String PASS;

    static boolean login(){
        System.out.println("===========LOGIN===========");
        System.out.print("Enter your User Name : ");
        USERNAME = sc.nextLine();
        System.out.print("Enter your Password : ");
        PASS = sc.nextLine();
        DBConnection db = new DBConnection(USERNAME, PASS);
        if(db.getConnection() == null){
            System.out.println("LOGIN FAILED!!!\n");
            return false;
        }
        return true;
    }

    static void mainMenu(){
        System.out.println("======PTA MANAGEMENT SYSTEM======");
        System.out.println("1. Member management");
        System.out.println("2. Fund management");
        System.out.println("3. Store management");
        System.out.println("4. Exit program");
        System.out.println("Enter your choice : ");
        mainChoice =  sc.nextInt();
    }

    static void memberMenu(){
        System.out.println("========Member Menu========");
        System.out.println("1. Add members");
        System.out.println("2. Show members");
        System.out.println("3. Go Back");
        System.out.print("\nEnter choice : ");
        memberChoice =  sc.nextInt();
    }
    static void fundMenu(){
        System.out.println("========Fund Menu========");
        System.out.println("1. Deposit Fund");
        System.out.println("2. Transfer Fund");
        System.out.println("3. Fund Balance");
        System.out.println("4. Transfer Records");
        System.out.println("5. Go Back");
        System.out.println("\nEnter your choice : ");
        fundChoice = sc.nextInt();
    }

    static void storeMenu(){
        System.out.println("========Store Menu========");
        System.out.println("1. Add Stock");
        System.out.println("2. Remove Stock");
        System.out.println("3. Show Stock");
        System.out.println("4. Go Back");
        System.out.println("\nEnter your choice : ");
        storeChoice = sc.nextInt();
    }

    public static void main(String[] args){
        System.out.println("             WELCOME!!!             \n"
                         + "           =============              ");
        int loginCount = 4;
        while(loginCount != -1){
            if(!login()){
                loginCount--;
            }
            else{
                break;
            }
            if(loginCount == 0){
                System.out.println("LOGIN ATTEMPT FAILED!!!\nPROGRAM TERMINATING!!!");
                return;
            }
        }
        while(mainChoice != 4){
            mainMenu();
            switch (mainChoice) {
                case 1:
                    while (memberChoice != 3) {
                        memberMenu();
                        switch (memberChoice) {
                            case 1:
                                System.out.print("Enter ID : ");
                                int id = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Enter Name : ");
                                String name = sc.nextLine();

                                System.out.print("Enter parent of : ");
                                String parentOf = sc.nextLine();

                                System.out.print("Enter expiration day : ");
                                int day = sc.nextInt();

                                System.out.print("Enter expiration month : ");
                                int month = sc.nextInt();

                                System.out.print("Enter expiration year : ");
                                int year = sc.nextInt();

                                LocalDate expiry = LocalDate.of(year, month, day);
                                ptaMembers member = new ptaMembers(id, name, parentOf, expiry);
                                member.addParent();
                                break;
                            case 2:
                                ptaMembers.showMembers();
                                break;
                            case 3:
                                System.out.println("Exiting...");
                                break;
                            default:
                                System.out.println("Invalid Input!!!");
                                break;
                        }
                    }
                    break;
                case 2:
                    while (fundChoice != 5) {
                        fundMenu();
                        int amount;
                        switch (fundChoice) {
                            case 1:
                                System.out.print("Enter the amount to deposit : ");
                                amount = sc.nextInt();
                                ptaFund.depositFund(amount);
                                break;
                            case 2:
                                System.out.print("Enter the amount to transfer : ");
                                amount = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Enter the department to transfer amount : ");
                                String dept = sc.nextLine();
                                ptaFund.transferFund(amount, dept);
                                break;
                            case 3:
                                ptaFund.showBalance();
                                break;
                            case 4:
                                ptaFund.transferHistory();
                                break;
                            case 5:
                                System.out.println("Going Back...");
                                break;
                            default:
                                System.out.println("Invalid!!!");
                                break;
                        }
                    }
                case 3:/*
                    storeMenu();
                    while (storeChoice != 4) {
                        storeMenu();
                        switch (storeChoice){
                            case 1:

                                break;
                        }
                    }
                    break;*/
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("INVALID CHOICE!");
                    break;
            }
        }
        sc.close();
    }
}
