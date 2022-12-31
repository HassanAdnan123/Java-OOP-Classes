import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Flights F = new Flights();
        F.delete();
    }
}

class Database {
    Connection con;
    String databaseName = "airline_system";
    public String tableName = "";

    void openConnection() throws SQLException {
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + databaseName + "?autoReconnect=true&useSSL=false", "root", "abc123++");
        } catch (Exception e) {
            System.out.println("Exception occured: " + e.getMessage());
        }
    }

    void closeConnection() throws SQLException {
        con.close();
    }

    void add() throws SQLException {
        System.out.println("Please inherit me from other child classes");
    }

    void view() throws SQLException {
        openConnection();
        Statement sql = con.createStatement();
        ResultSet views = sql.executeQuery("select * from " + tableName + " ");
        System.out.println("----------------------------------------------");
        System.out.println("------------- "+tableName+".sql -------------");
        while (views.next()) {
            System.out.println(views.getInt(1) + "\t" + views.getString(2) + "\t" + views.getString(3) + "\t" + views.getString(4));
        }
        System.out.println("----------------------------------------------");
        closeConnection();
    }

    void update() throws SQLException {
        System.out.println("Please inherit me from other child classes");
    }

    void delete() throws SQLException {
        view();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the data to be deleted: ");
        String id = sc.nextLine();

        openConnection();
        Statement sql = con.createStatement();
        sql.execute(String.format("delete from "+tableName+" where id = %s", id));
        System.out.println("Delete success.");
        closeConnection();
        view();
    }

}