import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{

        Scanner sc = new Scanner(System.in);

        System.out.println("Computer Model: ");
        String model = sc.nextLine();
        System.out.println("Price: ");
        String price = sc.nextLine();
        System.out.println("Manufacturer Company: ");
        String company = sc.nextLine();


            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/computershop?autoReconnect=true&useSSL=false","root","abc123++");
             //                                          ^^database name

            Statement sql = con.createStatement();

            // Insert Query Syntax
            sql.execute(String.format("insert into desktops (name, price, company) values ('%s',%s,'%s')",model,price,company));
            // INSERT INTO DESKTOPS (name, price, company) VALUES ('compaq',980, 'acer')


            // Select Query Syntax
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