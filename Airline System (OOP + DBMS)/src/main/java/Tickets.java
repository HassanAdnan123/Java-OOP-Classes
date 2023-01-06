import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Tickets extends Database{

    Tickets(){
        tableName = "tickets";
        columns = new String[] {"name","arrival_time","depart_time","passenger_id","flight_id"};
    }


    void add() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Arrival Time: ");
        String arrival_time = sc.nextLine();
        System.out.println("Departure Time: ");
        String Depart_time = sc.nextLine();

        super.openConnection();
        Statement sql = con.createStatement();
        sql.execute(String.format("insert into "+tableName+" (name, arrival_time, Depart_time) values ('%s','%s','%s')",name,arrival_time,Depart_time));
        System.out.println("Insertion success.");
        super.closeConnection();
    }

    void view() throws SQLException {
        super.view();
    }
    void update() throws SQLException {
        super.view();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the data to be updated: ");
        String id = sc.nextLine();

        System.out.println("Updating data for ID: " + id.toString());
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Arrival Time: ");
        String arrival_time = sc.nextLine();
        System.out.println("Departure Time: ");
        String Depart_time = sc.nextLine();

        super.openConnection();
        Statement sql = con.createStatement();
        sql.execute(String.format("update " + tableName +
                " set name = '%s', " +
                " arrival_time = '%s', " +
                " Depart_time = '%s' " +
                " where id = %s", name, arrival_time, Depart_time, id));
        System.out.println("Update success.");
        super.closeConnection();

        super.view();
    }

    void delete() throws SQLException {
        super.delete();
    }

}