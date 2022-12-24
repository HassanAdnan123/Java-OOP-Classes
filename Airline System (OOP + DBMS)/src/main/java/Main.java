import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Flights F = new Flights();
        F.add();
        F.add();
        F.view();
    }
}

class Database {
    Connection con;
    String databaseName = "airline_system";

    void openConnection() throws SQLException {
       try{
           con = DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/"+databaseName+"?autoReconnect=true&useSSL=false","root","abc123++");
       }
       catch (Exception e){
           System.out.println("Exception occured: "+e.getMessage());
       }
    }

    void closeConnection() throws SQLException {
        con.close();
    }

    void add() throws SQLException {
        System.out.println("Please inherit me from other child classes");
    }

    void view() throws SQLException {
        System.out.println("Please inherit me from other child classes");
    }

}

class Flights extends Database{
    String name;
    String serial_no;
    String engine_no;

    String tableName = "flights";

    void add() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Flight Name: ");
        String name = sc.nextLine();
        System.out.println("Serial Number: ");
        String serial_no = sc.nextLine();
        System.out.println("Engine Number: ");
        String engine_no = sc.nextLine();

       super.openConnection();
       Statement sql = con.createStatement();
       sql.execute(String.format("insert into "+tableName+" (name, serial_no, engine_no) values ('%s','%s','%s')",name,serial_no,engine_no));
       System.out.println("Insertion success.");
       super.closeConnection();
    }

    void view() throws SQLException {
        super.openConnection();
        Statement sql = con.createStatement();
        ResultSet views = sql.executeQuery("select * from "+tableName+" ");

        while(views.next()) {
            System.out.println(views.getInt(1)+"\t"+views.getString(2)+"\t"+views.getString(3)+"\t"+views.getString(4));
        }

        super.closeConnection();
    }

}