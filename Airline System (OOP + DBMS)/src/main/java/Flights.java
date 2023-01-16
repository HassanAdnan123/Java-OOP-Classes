import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

class Flights extends Database{

    Flights(){
        setTableName("flights");
        setColumns(new String[] {"name","serial_no","engine_no"});
        setColumnData(new String[3]);
    }


    void add() throws SQLException {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Flight Name: ");
//        String name = sc.nextLine();
//        System.out.println("Serial Number: ");
//        String serial_no = sc.nextLine();
//        System.out.println("Engine Number: ");
//        String engine_no = sc.nextLine();
//
//        super.openConnection();
//        Statement sql = con.createStatement();
//        sql.execute(String.format("insert into "+tableName+" (name, serial_no, engine_no) values ('%s','%s','%s')",name,serial_no,engine_no));
//        System.out.println("Insertion success.");
//        super.closeConnection();
        super.add();
    }

    ResultSet view() throws SQLException {
        return super.view();
    }
    void update() throws SQLException {
//        super.view();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the ID of the data to be updated: ");
//        String id = sc.nextLine();
//
//        System.out.println("Updating data for ID: " + id.toString());
//        System.out.println("Flight Name: ");
//        String name = sc.nextLine();
//        System.out.println("Serial Number: ");
//        String serial_no = sc.nextLine();
//        System.out.println("Engine Number: ");
//        String engine_no = sc.nextLine();
//
//        super.openConnection();
//        Statement sql = con.createStatement();
//        sql.execute(String.format("update " + tableName +
//                " set name = '%s', " +
//                " serial_no = '%s', " +
//                " engine_no = '%s' " +
//                " where id = %s", name, serial_no, engine_no, id));
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
