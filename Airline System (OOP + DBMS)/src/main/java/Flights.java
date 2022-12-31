import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Flights extends Database{

    Flights(){
        tableName = "flights";
    }


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
        super.view();
    }

    void update() throws SQLException {
        super.view();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the data to be updated: ");
        String id = sc.nextLine();

        System.out.println("Updating data for ID: " + id.toString());
        System.out.println("Flight Name: ");
        String name = sc.nextLine();
        System.out.println("Serial Number: ");
        String serial_no = sc.nextLine();
        System.out.println("Engine Number: ");
        String engine_no = sc.nextLine();

        super.openConnection();
        Statement sql = con.createStatement();
        sql.execute(String.format("update "+ tableName +
                " set name = '%s', " +
                " serial_no = '%s', " +
                " engine_no = '%s' " +
                " where id = %s",name,serial_no,engine_no, id));
        System.out.println("Update success.");
        super.closeConnection();

        super.view();

    }

    void delete() throws SQLException {
        super.delete();
    }
}