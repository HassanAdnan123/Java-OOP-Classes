import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        RealNum R = new RealNum();

        // Upcasting
        RealNum R1 = new Integer();
        RealNum R2 = new Float();

        R1 = R2;

        //Explicit Downcasting

        // Float -> RealNum (Child to Parent)
        // RealNum with Float reference (Parent with that specific child)
        Float F1 = (Float) R2;
    }
}

class RealNum {

}

class Float extends RealNum{

}

class Integer extends RealNum{

}