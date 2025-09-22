import java.util.*;
import java.time.*;

public class ptaFund{
    static private int fund = 0;
    static String transferStatement = "";
    static List<String> transferRecord = new ArrayList<>();

    static void depositFund(int amount){
        fund += amount;
        Instant timestamp = Instant.now();
        transferStatement = "+" + amount + " to funds at " + timestamp;
        transferRecord.add(transferStatement);
        transferStatement = "";
    }

    static void transferFund(int amount, String dept){
        if(amount <= fund){
            System.out.printf("$" + amount + "has been transferred to " + dept + " department.");
            fund -= amount;
            Instant timestamp = Instant.now();
            transferStatement = "- " + amount + " to " +  dept + " at " + timestamp;
            transferRecord.add(transferStatement);
            transferStatement = "";
        }
        else{
            System.out.println("Insufficient Funds!!!");
        }
    }

    static void showBalance(){
        System.out.println("The amount left is " + fund);
    }

    static void transferHistory (){
        System.out.println("The transfer history of funds is ");
        for(String str : transferRecord){
            System.out.println(str);
        }
        System.out.print("The current balance is ");
        showBalance();
    }
}
