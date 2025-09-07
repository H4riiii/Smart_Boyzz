import java.sql.*;
import java.time.*;
import java.util.*;

public class ptaMembers {
    int ID;
    String name;
    String parentOf;
    LocalDate expiry;

    static List<ptaMembers> memberList = new ArrayList<>();

    public ptaMembers(int ID, String name, String parentOf, LocalDate expiry){
        this.ID = ID;
        this.name = name;
        this.parentOf = parentOf;
        this.expiry = expiry;
    }

    public void addParent(){
        memberList.add(this);
        System.out.println(name + "added successfully!!!");
    }

    public static void showMembers(){
        System.out.println("PTA members : ");
        for(ptaMembers m : memberList) {
            System.out.println("ID : " + m.ID + "\nName : " + m.name +"\nParent Of : " + m.parentOf + "\nExpires on : " +m.expiry + "\n\n\n\n");
        }
    }
}
