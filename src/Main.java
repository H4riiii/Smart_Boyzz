import java.util.*;
import java.time.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int mainChoice = 0;
    static int memberChoice = 0;
    static int fundChoice = 0;

    static void mainMenu(){
        System.out.println("======PTA MANAGEMENT SYSTEM======");
        System.out.println("1. Member management");
        System.out.println("2. Fund management");
        System.out.println("3. Store management");
        System.out.println("4. Exit program");
        System.out.println("Enter your memberChoice : ");
        mainChoice =  sc.nextInt();
    }

    static void memberMenu(){
        System.out.println("========Member Menu========");
        System.out.println("1. Add members");
        System.out.println("2. Show members");
        System.out.println("3. Go Back");
        System.out.print("\nEnter memberChoice : ");
        memberChoice =  sc.nextInt();
    }
    static void fundMenu(){
        System.out.println("========Fund Menu========");
        System.out.println("1. Deposit Fund");
        System.out.println("2. Transfer Fund");
        System.out.println("3. Fund Balance");
        System.out.println("4. Transfer Records");
        System.out.println("5. Go Back");
        System.out.println("\nEnter your memberChoice : ");
        fundChoice = sc.nextInt();
    }

    public static void main(String[] args){
        System.out.println("             WELCOME!!!             \n"
                         + "           =============              ");

        while(mainChoice != 4){
            mainMenu();
            switch (mainChoice){
                case 1 :
                    while(memberChoice != 3){
                        memberMenu();
                        switch(memberChoice){
                            case 1 :
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
                                ptaMembers member = new ptaMembers(id,name, parentOf, expiry);
                                member.addParent();
                                break;
                            case 2 :
                                ptaMembers.showMembers();
                                break;
                            case 3 :
                                System.out.println("Exiting...");
                                break;
                            default :
                                System.out.println("Invalid Input!!!");
                                break;

                        }
                    }
                case 2 :

            }
        }
        sc.close();
    }
}
