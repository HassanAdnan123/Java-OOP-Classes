import java.sql.ResultSet;
import java.sql.SQLException;

class Passengers extends Database{

    Passengers(){
        setTableName("passengers");
        setColumns(new String[] {"name","cnic"});
        setColumnData(new String[2]);
    }




    void add() throws SQLException {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Passenger Name: ");
//        String name = sc.nextLine();
//        System.out.println("CNIC: ");
//        String cnic = sc.nextLine();
//
//        super.openConnection();
//        Statement sql = con.createStatement();
//        sql.execute(String.format("insert into "+tableName+" (name,cnic) values ('%s','%s')",name,cnic));
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
