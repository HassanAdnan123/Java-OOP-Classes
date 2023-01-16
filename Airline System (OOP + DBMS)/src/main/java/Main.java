import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
//        Flights F = new Flights();
//        Passengers P = new Passengers();
//        Tickets T = new Tickets();
//        T.generateTicket();
        JFrame frame = new JFrame("App");
        MainInterface myUi = new MainInterface();
        frame.setContentPane(myUi.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}






