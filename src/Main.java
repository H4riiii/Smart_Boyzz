import java.util.*;
import java.time.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice = 1;

        while(choice != 3){
            System.out.println("========Menu========");
            System.out.println("1. Add members");
            System.out.println("2. Show members");
            System.out.println("3. Exit");
            System.out.print("\nEnter choice : ");
            choice = sc.nextInt();
            switch(choice){
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
    }
}
