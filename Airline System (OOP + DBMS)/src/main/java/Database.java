import java.sql.*;
import java.util.Scanner;

abstract class Database {
    Connection con;
    String databaseName = "airline_system";
    private String tableName ;
    private String[] columns;
    private String[] columnData;
    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public String[] getColumnData() {
        return columnData;
    }

    public void setColumnData(String[] columnData) {
        this.columnData = columnData;
    }

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
        view();
        System.out.println("------ Adding **"+tableName+"** ------");
        Scanner sc = new Scanner(System.in);
        for(int i=0; i < columnData.length; i++){
            System.out.println("Please enter "+columns[i]);
            columnData[i] = sc.nextLine();
        }
        openConnection();
        Statement sql = con.createStatement();
        sql.execute("insert into "+tableName+getQueryableColumnsForAdd());
        System.out.println("Insertion success.");
        closeConnection();
        view();    }

    void view() throws SQLException {
        openConnection();
        Statement sql = con.createStatement();
        ResultSet views = sql.executeQuery("select * from " + tableName + " ");
        System.out.println("----------------------------------------------");
        System.out.println("------------- "+tableName+".sql -------------");
        while (views.next()) {
            String printRow = String.valueOf(views.getInt(1));
            for(int i=0; i<columns.length; i++){
                printRow += "\t " + views.getString(i+2);
            }
            System.out.println(printRow);
        }
        System.out.println("----------------------------------------------");
        closeConnection();
    }

    String getQueryableColumnsForAdd(){
        String startStr = "(";          // (name,ticket,cnic) values ('%s','%s')
        String colNames = "";           //
        String middleStr = ") values (";//
        String valueStr = "";           //
        String endStr = ")";            //


        for(int i=0 ; i < columns.length ; i++){
            colNames += columns[i];
            valueStr += "'" + columnData[i] +"'";

            if((i != columns.length-1)) {
                colNames += ",";
                valueStr += ",";
            }
        }
        return startStr + colNames + middleStr + valueStr + endStr;
    }

    String getQueryableColumnsForUpdate(String id){
        String startStr = "update " + tableName + " set ";
        String colNames = "";
        String endStr = "where id = "+ id;


        for(int i=0 ; i < columns.length ; i++){
            colNames += columns[i] + " = '" + columnData[i] + "' ";

            if((i != columns.length-1)) {
                colNames += ", ";
            }
        }
        return startStr + colNames + endStr;
    }

    void update() throws SQLException {
        view();
        String id;
        System.out.println("------ Updating ** "+tableName+" ** ------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter ID of item: ");
        id = sc.nextLine();

        for(int i=0; i < columnData.length; i++){
            System.out.println("Please enter "+columns[i]);
            columnData[i] = sc.nextLine();
        }

        openConnection();
        Statement sql = con.createStatement();
//        sql.execute(String.format("update " + tableName +
//                " set name = '%s', " +
//                " cnic = '%s', " +
//                " where id = %s", name, cnic, id));
        sql.execute(getQueryableColumnsForUpdate(id));
        System.out.println("Update success.");
        closeConnection();
        view();    }

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
