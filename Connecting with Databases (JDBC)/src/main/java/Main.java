import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/computer-shop","root","abc123++");

            Statement sql = con.createStatement();
            sql.execute("insert into desktops (name, price, company) values ('A',1,'B')");
            ResultSet views = sql.executeQuery("select * from desktops");
            while(views.next())
                System.out.println(views.getInt(1)+"\t"+views.getString(2)+"\t"+views.getString(3)+"\t"+views.getString(4));
            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}