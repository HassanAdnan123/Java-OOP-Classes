import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Flights F = new Flights();
        Passengers P = new Passengers();
        Tickets T = new Tickets();
        T.generateTicket();
    }
}






