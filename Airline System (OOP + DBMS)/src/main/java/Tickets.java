import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Tickets extends Database{

    Tickets(){
        tableName = "tickets";
        columns = new String[] {"name","arrival_time","depart_time","passenger_id","flight_id"};
    }


    void add() throws SQLException {

        Passengers passengerReference = new Passengers();
        Flights flightsReference = new Flights();

        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Arrival Time: ");
        String arrival_time = sc.nextLine();
        System.out.println("Departure Time: ");
        String Depart_time = sc.nextLine();
        passengerReference.view();
        System.out.println("Passenger ID: ");
        String passenger_id = sc.nextLine();
        flightsReference.view();
        System.out.println("Flight ID: ");
        String flight_id = sc.nextLine();

        super.openConnection();
        Statement sql = con.createStatement();
        sql.execute(String.format("insert into "+tableName+" (name, arrival_time, depart_time, passenger_id, flight_id) values ('%s','%s','%s',%s,%s)",name,arrival_time,Depart_time, passenger_id, flight_id));
        System.out.println("Insertion success.");
        super.closeConnection();
    }

    void view() throws SQLException {
        openConnection();
        Statement sql = con.createStatement();
        ResultSet views = sql.executeQuery("select t.id, p.name, f.name, t.name, t.depart_time, t.arrival_time  from tickets t\n" +
                "\t inner join passengers p ON p.id = t.passenger_id \n" +
                "\t inner join flights f on f.id = t.flight_id \n" +
                ";");
        System.out.println("----------------------------------------------");
        System.out.println("------------- "+tableName+".sql -------------");
        System.out.println("T_ID\t PSNGR_NM\t FL_NM \t TKT_NM \t ARVL \t DEPART");
        System.out.println("\t");
        while (views.next()) {
            System.out.println(views.getInt(1) + "\t" + views.getString(2) + "\t" + views.getString(3) + "\t" + views.getString(4)+ "\t" + views.getString(5)+ "\t" + views.getString(6));
        }
        System.out.println("----------------------------------------------");
        closeConnection();
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