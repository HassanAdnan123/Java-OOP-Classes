import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Tickets extends Database{

    Tickets(){
        setTableName("tickets");
        setColumns(new String[] {"name","passenger_id","flight_id","to_location_id","slot_id","from_location_id"});
    }




    void add() throws SQLException {
        super.view();
        Passengers passengerReference=new Passengers();
        Flights flightReference=new Flights();
        Location locationReference=new Location();
        Slots slotReference=new Slots();

        Scanner sc = new Scanner(System.in);
        System.out.println("Id: ");
        String id = sc.nextLine();
        System.out.println("Name: ");
        String name = sc.nextLine();

        passengerReference.view();
        System.out.println("Passenger ID: ");
        String passenger_id = sc.nextLine();
        flightReference.view();
        System.out.println("Flight id: ");
        String flight_id = sc.nextLine();

        locationReference.view();
        System.out.println("to_location Id : ");
        String to_location_id = sc.nextLine();
        slotReference.view();
        System.out.println("Slot id: ");
        String slot_id = sc.nextLine();
        locationReference.view();
        System.out.println("from_location ID: ");
        String from_location_id = sc.nextLine();

        super.openConnection();
        Statement sql = con.createStatement();
        sql.execute(String.format("insert into "+getTableName()+"(id, name, passenger_id, flight_id, to_location_id,from_location_id,slot_id) " +
                "values ('%s','%s','%s','%s','%s','%s')"
                ,id, name, passenger_id, flight_id,to_location_id,from_location_id,slot_id));
        System.out.println("Insertion success.");
        super.closeConnection();
    }

    void view() throws SQLException {
        openConnection();
        Statement sql=con.createStatement();
        ResultSet views= sql.executeQuery("select t.id, p.name, f.name, t.name, s.depart_time, s.arrival_time, l.city_name, l.city_name from tickets t\n" +
                "\t inner join passengers p on p.id=t.passenger_id \n"+
                "\t inner join flights f on f.id=t.flight_id \n"+
                "\t inner join slots s on s.id=t.slot_id \n"+
                "\t inner join location l on l.id=t.to_location_id \n"+
                "\t inner join location l on l.id=t.from_location_id \n"+
                ";");
        System.out.println("----------------------------------------------");
        System.out.println("------------- "+getTableName()+".sql -------------");
        //System.out.println("T_ID\t PSNGR_NM\t FL_NM \t TKT_NM \t ARVL \t DEPART");
        System.out.println("\t");
        while (views.next()) {
            System.out.println(views.getInt(1) + "\t" + views.getString(2) + "\t" + views.getString(3) + "\t" + views.getString(4)+ "\t"
            + views.getString(5)+ "\t" + views.getString(6)+ "\t" + views.getString(7)+ "\t" + views.getString(8));
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
        sql.execute(String.format("update " + getTableName() +
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

    void generateTicket() throws SQLException {
        Passengers passengerReference = new Passengers();
        passengerReference.view();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter passenger name: ");
        String passengerName = sc.nextLine();

        openConnection();
        Statement sql=con.createStatement();
        ResultSet views= sql.executeQuery(String.format("call generate_ticket ('%s')",passengerName));

        System.out.println("----------------------------------------------");
        System.out.println(String.format("Showing all tickets booked for %s",passengerName));

        while (views.next()) {
            System.out.println("\n");
            System.out.println("---------------Ticket #: "+views.getString(1)+"---------------");
            System.out.println("Passenger: "+views.getString(2) );
            System.out.println("Flight: "+views.getString(3) );
            System.out.println("Flight Departure: "+views.getString(5) );
            System.out.println("Flight Arrival: "+views.getString(4) );
            System.out.println("From: "+views.getString(7) );
            System.out.println("To: "+views.getString(6) );
            System.out.println("Stay at "+views.getString(6)+": "+views.getString(8)+" mins." );
            System.out.println("----------------------------------------------");
        }
        System.out.println("----------------------------------------------");
        closeConnection();
    }
}
