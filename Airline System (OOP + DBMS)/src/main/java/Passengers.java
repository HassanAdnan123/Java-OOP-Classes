import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Passengers extends Database{

    Passengers(){
        tableName = "passengers";
        columns = new String[] {"name","cnic"};
        columnData = new String[2];
    }


    void add() throws SQLException {
        super.add();
    }


    void view() throws SQLException {
        super.view();
    }

    void update() throws SQLException {
//        super.view();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the ID of the data to be updated: ");
//        String id = sc.nextLine();
//
//        System.out.println("Updating data for ID: " + id.toString());
//        System.out.println("Passenger Name: ");
//        String name = sc.nextLine();
//        System.out.println("CNIC: ");
//        String cnic = sc.nextLine();
//
//        super.openConnection();
//        Statement sql = con.createStatement();
//        sql.execute(String.format("update " + tableName +
//                " set name = '%s', " +
//                " cnic = '%s', " +
//                " where id = %s", name, cnic, id));
//        System.out.println("Update success.");
//        super.closeConnection();
//
//        super.view();
        super.update();
    }

    void delete() throws SQLException {
        super.delete();
    }

}