import java.sql.*;
import java.util.Scanner;

public class AirlineSimulator {
    public static void main(String[] args) throws SQLException {
        Flights F = new Flights();
        Passengers P = new Passengers();
        Tickets T = new Tickets();
        System.out.println(F.getQueryableColumns());
        System.out.println(P.getQueryableColumns());
        System.out.println(T.getQueryableColumns());
        P.add();
    }
}

class Database {
    Connection con;
    String databaseName = "airline_system";
    public String tableName = "";
    public String[] columns;

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

    String getQueryableColumns(){
        String startStr = "(";          // (name,ticket,cnic) values ('%s','%s')
        String colNames = "";           //
        String middleStr = ") values (";//
        String valueStr = "";           //
        String endStr = ")";            //


        for(int i=0 ; i < columns.length ; i++){
            colNames += columns[i];
            valueStr += "'%s'";

            if((i != columns.length-1)) {
                colNames += ",";
                valueStr += ",";
            }
        }
        return startStr + colNames + middleStr + valueStr + endStr;
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